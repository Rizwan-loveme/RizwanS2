package com.srizwan.win11

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Drop-in replacement for [android.widget.Toast] with the same call shape
 * (`Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()`), but drawn as a glass pill that matches
 * [GlassToast] (dark translucent card, thin light border, rounded corners).
 *
 *  - inside an activity it floats at the bottom centre of that screen (above the taskbar in the launcher);
 *  - from a service / application context it floats over any app when "Display over other apps" is allowed;
 *  - otherwise it falls back to the system toast so a message is never lost.
 *
 * Only one glass message is visible at a time; a new one replaces the old one. Safe to call from any thread.
 * Because it lives in the same package as the rest of the app, files that used `android.widget.Toast` now
 * get this class (the explicit import was pointed here).
 */
class Toast private constructor(
    private val ctx: Context,
    private val text: CharSequence,
    private val duration: Int
) {

    fun show() {
        main.post { display() }
    }

    fun cancel() {
        main.post { removeCurrent() }
    }

    private fun display() {
        val message = text.toString()
        if (message.isEmpty()) return
        val ms = if (duration == LENGTH_LONG) 3500L else 2000L
        val shown = try {
            val activity = unwrap(ctx)
            if (activity != null && !activity.isFinishing && !activity.isDestroyed) showInActivity(activity, message, ms)
            else showOverlay(ctx.applicationContext, message, ms)
        } catch (e: Throwable) {
            AppLog.w("GlassToast", "glass message failed", e)
            false
        }
        if (!shown) {
            try {
                android.widget.Toast.makeText(ctx.applicationContext, message, android.widget.Toast.LENGTH_SHORT).show()
            } catch (_: Throwable) {}
        }
    }

    companion object {
        const val LENGTH_SHORT = 0
        const val LENGTH_LONG = 1

        private const val TAG = "win11_glass_message"
        private val main = Handler(Looper.getMainLooper())

        private var current: View? = null
        private var currentWm: WindowManager? = null
        private var dismiss: Runnable? = null

        @JvmStatic
        fun makeText(context: Context, text: CharSequence?, duration: Int): Toast =
            Toast(context, text ?: "", duration)

        @JvmStatic
        fun makeText(context: Context, @StringRes resId: Int, duration: Int): Toast =
            Toast(context, context.getString(resId), duration)

        private fun unwrap(c: Context): Activity? {
            var x: Context? = c
            while (x is ContextWrapper) {
                if (x is Activity) return x
                x = x.baseContext
            }
            return null
        }

        private fun buildCard(ctx: Context, message: String): LinearLayout {
            val dm = ctx.resources.displayMetrics
            fun dp(v: Int) = (v * dm.density).toInt()
            val card = LinearLayout(ctx).apply {
                tag = TAG
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(18), dp(11), dp(18), dp(11))
                background = GradientDrawable().apply {
                    setColor(Color.argb(225, 32, 36, 44))
                    setStroke(dp(1), Color.argb(46, 255, 255, 255))
                    cornerRadius = dp(22).toFloat()
                }
                elevation = dp(10).toFloat()
                isClickable = false
                isFocusable = false
            }
            card.addView(TextView(ctx).apply {
                text = message
                setTextColor(Color.WHITE)
                textSize = 14f
                maxLines = 3
                ellipsize = TextUtils.TruncateAt.END
            }, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            return card
        }

        private fun animateIn(card: View, dp40: Float) {
            card.alpha = 0f
            card.translationY = dp40
            card.animate().alpha(1f).translationY(0f).setDuration(200).start()
        }

        private fun scheduleDismiss(card: View, ms: Long) {
            dismiss?.let { main.removeCallbacks(it) }
            val r = Runnable { if (current === card) removeCurrent() }
            dismiss = r
            main.postDelayed(r, ms)
        }

        private fun removeCurrent() {
            dismiss?.let { main.removeCallbacks(it) }
            dismiss = null
            val v = current ?: return
            current = null
            val wm = currentWm
            currentWm = null
            try { v.animate().cancel() } catch (_: Throwable) {}
            try {
                if (wm != null) wm.removeViewImmediate(v)
                else (v.parent as? ViewGroup)?.removeView(v)
            } catch (_: Throwable) {}
        }

        private fun showInActivity(activity: Activity, message: String, ms: Long): Boolean {
            val host = activity.findViewById<ViewGroup>(android.R.id.content) ?: return false
            val dm = activity.resources.displayMetrics
            fun dp(v: Int) = (v * dm.density).toInt()

            removeCurrent()
            host.findViewWithTag<View>(TAG)?.let { host.removeView(it) }

            val card = buildCard(activity, message)

            // stay clear of the navigation bar even when the window draws edge-to-edge
            val insets = ViewCompat.getRootWindowInsets(host)?.getInsets(WindowInsetsCompat.Type.systemBars())
            val loc = IntArray(2)
            host.getLocationOnScreen(loc)
            val hostBottom = loc[1] + host.height
            val taskbar = if (activity is MainActivity) dp(52) else 0
            val bottomMargin = maxOf(0, (insets?.bottom ?: 0) - (dm.heightPixels - hostBottom)) + dp(28) + taskbar

            val maxW = minOf(dm.widthPixels - dp(48), dp(420))
            card.measure(
                View.MeasureSpec.makeMeasureSpec(maxW, View.MeasureSpec.AT_MOST),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            )
            val w = minOf(card.measuredWidth, maxW)
            host.addView(card, FrameLayout.LayoutParams(w, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL).apply {
                setMargins(dp(24), 0, dp(24), bottomMargin)
            })
            current = card
            currentWm = null
            animateIn(card, dp(24).toFloat())
            scheduleDismiss(card, ms)
            return true
        }

        private fun showOverlay(appCtx: Context, message: String, ms: Long): Boolean {
            if (!Settings.canDrawOverlays(appCtx)) return false
            val wm = appCtx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = appCtx.resources.displayMetrics
            fun dp(v: Int) = (v * dm.density).toInt()

            removeCurrent()
            val card = buildCard(appCtx, message)

            val nbId = appCtx.resources.getIdentifier("navigation_bar_height", "dimen", "android")
            val navBar = if (nbId > 0) appCtx.resources.getDimensionPixelSize(nbId) else dp(24)

            @Suppress("DEPRECATION")
            val type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            else WindowManager.LayoutParams.TYPE_PHONE

            val lp = WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                type,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT
            ).apply {
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                y = navBar + dp(48)
            }
            wm.addView(card, lp)
            current = card
            currentWm = wm
            animateIn(card, dp(24).toFloat())
            scheduleDismiss(card, ms)
            return true
        }
    }
}
