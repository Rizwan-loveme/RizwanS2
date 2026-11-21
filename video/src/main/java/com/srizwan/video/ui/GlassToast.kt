package com.srizwan.video.ui

import android.app.Activity
import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.DrawableRes
import java.lang.ref.WeakReference

/**
 * The toast of the Video app: a glass pill with a vector icon (and, if given, a vector-outline label).
 * No system Toast, no text view.
 *
 *  - while the player screen is visible it floats at the top of that screen;
 *  - otherwise, when "display over other apps" is allowed (the floating player needs it anyway), it floats
 *    over whatever app is on screen;
 *  - otherwise it is skipped (a toast must never crash anything).
 */
object GlassToast {

    private var hostRef: WeakReference<Activity>? = null
    private val main = Handler(Looper.getMainLooper())

    private var current: View? = null
    private var currentParent: ViewGroup? = null
    private var currentWm: WindowManager? = null
    private var dismiss: Runnable? = null

    /** The visible screen that shows toasts inside itself; set in onStart, cleared in onStop. */
    var host: Activity?
        get() = hostRef?.get()
        set(value) { hostRef = value?.let { WeakReference(it) } }

    fun show(context: Context, @DrawableRes icon: Int, label: String? = null, durationMs: Long = 2200L) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            main.post { show(context, icon, label, durationMs) }
            return
        }
        try {
            showNow(context.applicationContext, icon, label, durationMs)
        } catch (e: Throwable) {
            android.util.Log.w("GlassToast", "not shown", e)
        }
    }

    private fun showNow(app: Context, icon: Int, label: String?, durationMs: Long) {
        clear()
        val density = app.resources.displayMetrics.density
        val view = ImageView(app).apply {
            setImageDrawable(VectorLabelDrawable(app, label, icon, textSizeDp = 14f, iconSizeDp = 24f))
            background = GlassDrawable(app, 24f)
            setPadding((18 * density).toInt(), (12 * density).toInt(), (18 * density).toInt(), (12 * density).toInt())
            alpha = 0f
            translationY = -24 * density
            scaleX = 0.92f
            scaleY = 0.92f
        }
        val act = host
        if (act != null && !act.isFinishing && !act.isDestroyed) {
            val content = act.findViewById<ViewGroup>(android.R.id.content)
            val lp = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.TOP or Gravity.CENTER_HORIZONTAL
            ).apply { topMargin = (16 * density).toInt() }
            content.addView(view, lp)
            currentParent = content
        } else if (Settings.canDrawOverlays(app)) {
            val wm = app.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val lp = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT
            ).apply {
                gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
                y = statusBarHeight(app) + (12 * density).toInt()
            }
            wm.addView(view, lp)
            currentWm = wm
        } else {
            return
        }
        current = view
        view.animate().alpha(1f).translationY(0f).scaleX(1f).scaleY(1f)
            .setDuration(220L).setInterpolator(DecelerateInterpolator()).start()
        val r = Runnable { fadeOut() }
        dismiss = r
        main.postDelayed(r, durationMs)
    }

    private fun fadeOut() {
        val v = current ?: return
        v.animate().alpha(0f).translationY(-12f).setDuration(180L).withEndAction { clear() }.start()
    }

    private fun clear() {
        dismiss?.let { main.removeCallbacks(it) }
        dismiss = null
        val v = current ?: return
        v.animate().cancel()
        runCatching { currentParent?.removeView(v) }
        runCatching { currentWm?.removeViewImmediate(v) }
        current = null
        currentParent = null
        currentWm = null
    }

    private fun statusBarHeight(context: Context): Int {
        val id = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (id > 0) context.resources.getDimensionPixelSize(id) else 0
    }
}
