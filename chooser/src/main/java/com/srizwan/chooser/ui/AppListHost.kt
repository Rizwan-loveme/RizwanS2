package com.srizwan.chooser.ui

import android.content.Context
import android.content.res.Configuration
import android.widget.FrameLayout

/**
 * The frame that holds the app list of an Open with / Share sheet (step 11). It tells the sheet when to build the list again:
 *
 *  - [onReflow]: the screen was rotated or resized while the sheet is open (the number of columns and the height limit change; the apps stay).
 *  - [onResume]: the sheet's window got the focus back after losing it, for example after the settings screen or an App info screen
 *    was open on top (the saved style may have changed, an app may have been uninstalled): ask for the apps again.
 *  - [onGone]: the window was removed from the screen, however it happened (dismissed, or taken away with its activity): the sheet
 *    stops its work (coroutines, the package watcher). It may be called more than once.
 */
class AppListHost(context: Context) : FrameLayout(context) {

    var onReflow: (() -> Unit)? = null
    var onResume: (() -> Unit)? = null
    var onGone: (() -> Unit)? = null

    private var hadFocus = false
    private var lostFocus = false

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        post { onReflow?.invoke() }
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        if (hasWindowFocus) {
            if (hadFocus && lostFocus) post { onResume?.invoke() }
            hadFocus = true
            lostFocus = false
        } else if (hadFocus) {
            lostFocus = true
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        onGone?.invoke()
    }
}
