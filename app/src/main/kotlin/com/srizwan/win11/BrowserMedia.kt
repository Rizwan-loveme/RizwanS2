package com.srizwan.win11

import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.FrameLayout
import java.util.Collections
import java.util.WeakHashMap

// =====================================================================
// BACKGROUND AUDIO / VIDEO (Step 3)
//
// A tab (or pop-up) that is playing audio must not be stopped when the user works in another tab:
//  * every page reports "playing / not playing" through the AndroidMedia bridge (MEDIA_HOOK_JS);
//  * a WebView that is playing is NOT paused (WebView.onPause) when its tab is hidden, when the
//    app goes to the background or when a dialog pop-up of another tab is shown;
//  * the page gets KEEP_ALIVE_JS so it thinks it is still visible and does not pause itself;
//  * PopupPlaybackService (foreground service) runs while something is playing, so Android keeps
//    the process and the audio alive when the app is in the background;
//  * the tab strip shows a small speaker icon on a tab that is playing.
//  * Step 3b: when the app goes to the background, a playing tab's WebView is moved into a tiny (1x1 px)
//    invisible system overlay window. A WebView that is attached to a visible window is never treated as
//    "hidden" by Android, so audio keeps playing — the same reason a floating pop-up keeps playing. It is
//    moved back into the browser when the app returns. Needs "Display over other apps" (asked once).
// All state is touched on the main thread only.
// =====================================================================

/** WebViews whose page is playing audio / video right now. Main thread only. */
internal val mediaPlayingViews: MutableSet<WebView> =
    Collections.newSetFromMap(WeakHashMap<WebView, Boolean>())

internal fun isMediaPlaying(wv: WebView): Boolean = mediaPlayingViews.contains(wv)

/** Injected into every page: reports to AndroidMedia.state(true / false) whenever a media element starts or stops. */
internal const val MEDIA_HOOK_JS = """
(function(){
  if (window.__mediaHook) return; window.__mediaHook = true;
  var list = [];
  function playing(m){ return !m.paused && !m.ended && m.readyState > 2 && !m.muted && m.volume > 0; }
  var ctxs = [];
  try {
    var AC = window.AudioContext || window.webkitAudioContext;
    if (AC && !AC.__mediaHooked) {
      var Wrapped = class extends AC {
        constructor(){ super(...arguments); ctxs.push(this); this.addEventListener('statechange', function(){ setTimeout(report, 60); }); setTimeout(report, 60); }
      };
      Wrapped.__mediaHooked = true;
      window.AudioContext = Wrapped; if (window.webkitAudioContext) window.webkitAudioContext = Wrapped;
    }
  } catch (e) {}
  function report(){
    var p = false;
    for (var j = 0; j < ctxs.length; j++) { try { if (ctxs[j].state === 'running') p = true; } catch (e) {} }
    for (var i = list.length - 1; i >= 0; i--) {
      var m = list[i];
      if (m.paused && m.isConnected === false) { list.splice(i, 1); continue; }
      if (playing(m)) p = true;
    }
    try { AndroidMedia.state(p); } catch (e) {}
  }
  function track(m){ if (m && list.indexOf(m) < 0) list.push(m); }
  ['playing','play','pause','ended','emptied','volumechange'].forEach(function(ev){
    document.addEventListener(ev, function(e){
      if (e.target && e.target.tagName) { track(e.target); setTimeout(report, 60); }
    }, true);
  });
  try {
    var origPlay = HTMLMediaElement.prototype.play;
    HTMLMediaElement.prototype.play = function(){
      var self = this; track(self);
      if (!self.__mediaHooked) {
        self.__mediaHooked = true;
        ['playing','pause','ended','emptied','volumechange'].forEach(function(ev){
          self.addEventListener(ev, function(){ setTimeout(report, 60); });
        });
      }
      return origPlay.apply(this, arguments);
    };
  } catch (e) {}
})();
"""

/** JavaScript bridge (one per WebView). Runs on a WebView thread, so everything is posted to the main thread. */
internal class MediaBridge(private val act: MainActivity, private val wv: WebView) {
    @JavascriptInterface
    fun state(playing: Boolean) {
        act.runOnUiThread {
            val changed = if (playing) mediaPlayingViews.add(wv) else mediaPlayingViews.remove(wv)
            if (changed) act.onMediaStateChanged()
        }
    }
}

/** Something started / stopped playing: update the speaker icons, pause hidden tabs that stopped, start / stop the service. */
internal fun MainActivity.onMediaStateChanged() {
    webTabs.forEachIndexed { i, tab ->
        if (i != currentTabIndex && !mediaPlayingViews.contains(tab.webView)) {
            try { tab.webView.onPause() } catch (e: Exception) { }   // a hidden tab that stopped playing can sleep again
        }
    }
    updateTabTitles()
    updatePopupService()
    // sound started while the app is open: make sure it may keep going in the background
    if (mediaPlayingViews.isNotEmpty() && !canDrawOverApps()) askOverlayPermissionOnce()
    syncBackgroundHosts()
}

// ── background hosts ────────────────────────────────────────────────

private var appInBackground = false
private val bgHosts = LinkedHashMap<WebView, FrameLayout>()

/** The app is no longer visible (Activity.onStop): park every playing page in an invisible overlay window. */
internal fun MainActivity.parkPlayingInBackground() {
    appInBackground = true
    syncBackgroundHosts()
}

/** The app is visible again (Activity.onStart) or is being destroyed: bring the pages back into the browser. */
internal fun MainActivity.unparkFromBackground() {
    appInBackground = false
    for ((wv, host) in bgHosts.toMap()) restoreFromHost(wv, host)
    bgHosts.clear()
}

private fun MainActivity.syncBackgroundHosts() {
    if (!appInBackground) return
    // a page that stopped playing goes back to sleep inside the browser
    for ((wv, host) in bgHosts.toMap()) {
        if (!mediaPlayingViews.contains(wv)) {
            restoreFromHost(wv, host); bgHosts.remove(wv)
            try { wv.onPause() } catch (e: Exception) { }
        }
    }
    if (!canDrawOverApps()) return
    // a pop-up shown as a dialog would be hidden with the app: let it float (overlay) so it keeps playing
    popupWindows.filter { it.mode != PopupMode.FLOAT && isMediaPlaying(it.webView) }
        .forEach { try { it.setMode(PopupMode.FLOAT) } catch (e: Exception) { } }
    for (tab in webTabs) {
        val wv = tab.webView
        if (mediaPlayingViews.contains(wv) && !bgHosts.containsKey(wv)) parkInHost(wv)
    }
}

private fun MainActivity.parkInHost(wv: WebView) {
    val host = FrameLayout(this)
    try {
        (wv.parent as? ViewGroup)?.removeView(wv)
        host.addView(wv, FrameLayout.LayoutParams(1, 1))
        val type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        else @Suppress("DEPRECATION") WindowManager.LayoutParams.TYPE_PHONE
        val lp = WindowManager.LayoutParams(
            1, 1, type,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            PixelFormat.TRANSLUCENT
        ).apply { gravity = Gravity.TOP or Gravity.START; x = 0; y = 0 }
        applicationContext.getSystemService(android.content.Context.WINDOW_SERVICE).let { it as WindowManager }
            .addView(host, lp)
        wv.visibility = View.VISIBLE
        try { wv.onResume() } catch (e: Exception) { }
        wv.evaluateJavascript(KEEP_ALIVE_JS, null)
        bgHosts[wv] = host
    } catch (e: Exception) {
        AppLog.e("BrowserMedia", "cannot keep the page in the background window", e)
        restoreFromHost(wv, host)
    }
}

private fun MainActivity.restoreFromHost(wv: WebView, host: FrameLayout) {
    try {
        (applicationContext.getSystemService(android.content.Context.WINDOW_SERVICE) as WindowManager)
            .removeViewImmediate(host)
    } catch (e: Exception) { }
    try {
        host.removeView(wv)
        (wv.parent as? ViewGroup)?.removeView(wv)
        if (webTabs.any { it.webView == wv }) {
            webContainer.addView(wv, FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            wv.visibility = if (webTabs.getOrNull(currentTabIndex)?.webView == wv) View.VISIBLE else View.GONE
        }
    } catch (e: Exception) { AppLog.e("BrowserMedia", "cannot restore the page", e) }
}
