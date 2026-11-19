package com.srizwan.win11

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Windows 11 style toast: a small card that slides in, stays for a few seconds and fades away.
 * Tap opens the notification center; the vector X dismisses it. Only one toast is shown at a time
 * (a new one replaces the old one).
 *
 * The look is per app (see [NotifPrefs.popupStyleFor] and [PopupStyle]): style (glass, solid, light,
 * compact), accent colour, how long it stays (or until dismissed) and where it appears (six
 * positions). Apps without their own profile use the "default" profile; its defaults are the
 * original glass card at the top right for 5 seconds.
 *
 * [show] draws inside the launcher; [showOverlay] draws the same card over any app (needs the
 * "Display over other apps" permission) so pop-ups from other apps also appear while the launcher
 * is in the background.
 */
object GlassToast {

    private const val TAG = "win11_glass_toast"

    private var overlayView: View? = null

    /** Colours of one style. */
    private class Pal(
        val bg: Int, val stroke: Int, val name: Int, val title: Int, val body: Int, val close: Int
    )

    private fun palette(style: String): Pal = when (style) {
        "solid" -> Pal(
            Color.rgb(28, 30, 36), Color.argb(70, 255, 255, 255),
            Color.LTGRAY, Color.WHITE, Color.LTGRAY, Color.LTGRAY
        )
        "light" -> Pal(
            Color.argb(244, 248, 249, 252), Color.argb(50, 0, 0, 0),
            Color.rgb(90, 94, 104), Color.rgb(20, 22, 28), Color.rgb(70, 74, 84), Color.rgb(90, 94, 104)
        )
        else -> Pal( // glass = the original look
            Color.argb(225, 32, 36, 44), Color.argb(46, 255, 255, 255),
            Color.LTGRAY, Color.WHITE, Color.LTGRAY, Color.LTGRAY
        )
    }

    private fun isBottom(position: String) = position.startsWith("bottom")

    /** Horizontal gravity flag of a position id (top_right, bottom_center, ...). */
    private fun horizontalGravity(position: String): Int = when {
        position.endsWith("left") -> Gravity.START
        position.endsWith("center") -> Gravity.CENTER_HORIZONTAL
        else -> Gravity.END
    }

    /** Builds the card. [onClose] = X button, [onTap] = tap on the card. */
    private fun buildCard(
        ctx: Context, pkg: String?, app: String, title: String, text: String, st: PopupStyle,
        onClose: () -> Unit, onTap: () -> Unit
    ): LinearLayout {
        val dm = ctx.resources.displayMetrics
        fun dp(v: Int) = (v * dm.density).toInt()

        val pal = palette(st.style)
        val compact = st.style == "compact"
        val hasAccent = st.accent != 0
        val nameColor = if (hasAccent) st.accent else pal.name

        val card = LinearLayout(ctx).apply {
            tag = TAG
            orientation = if (compact) LinearLayout.HORIZONTAL else LinearLayout.VERTICAL
            if (compact) {
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(12), dp(8), dp(4), dp(8))
            } else {
                setPadding(dp(14), dp(10), dp(6), dp(12))
            }
            background = GradientDrawable().apply {
                setColor(pal.bg)
                cornerRadius = dp(12).toFloat()
                if (hasAccent) setStroke(dp(2), Color.argb(230, Color.red(st.accent), Color.green(st.accent), Color.blue(st.accent)))
                else setStroke(dp(1), pal.stroke)
            }
            elevation = dp(10).toFloat()
            isClickable = true
            isFocusable = true
        }

        fun appIcon(sizeDp: Int): ImageView = ImageView(ctx).apply {
            val ic = try { pkg?.let { ctx.packageManager.getApplicationIcon(it) } } catch (_: Exception) { null }
            if (ic != null) setImageDrawable(ic)
            else {
                setImageResource(R.drawable.ic_qs_notifications)
                setColorFilter(if (hasAccent) st.accent else Color.rgb(76, 194, 255))
            }
        }

        fun closeButton(sizeDp: Int): ImageView = ImageView(ctx).apply {
            setImageResource(R.drawable.ic_qs_close)
            setColorFilter(pal.close)
            contentDescription = "Dismiss"
            setPadding(dp(9), dp(9), dp(9), dp(9))
            isClickable = true
            setOnClickListener { onClose() }
        }

        if (compact) {
            // One slim row: icon, sender + one line of text, X. The sender falls back to the app name.
            card.addView(appIcon(20), LinearLayout.LayoutParams(dp(20), dp(20)).apply { rightMargin = dp(10) })
            val col = LinearLayout(ctx).apply { orientation = LinearLayout.VERTICAL }
            col.addView(TextView(ctx).apply {
                this.text = if (title.isNotEmpty()) title else app
                setTextColor(if (hasAccent) st.accent else pal.title); textSize = 13f
                typeface = Typeface.DEFAULT_BOLD
                maxLines = 1; ellipsize = TextUtils.TruncateAt.END
            })
            if (text.isNotEmpty()) col.addView(TextView(ctx).apply {
                this.text = text
                setTextColor(pal.body); textSize = 12f
                maxLines = 1; ellipsize = TextUtils.TruncateAt.END
            })
            card.addView(col, LinearLayout.LayoutParams(0, -2, 1f))
            card.addView(closeButton(28), LinearLayout.LayoutParams(dp(30), dp(30)))
        } else {
            // Row 1: app icon + app name + vector X
            val top = LinearLayout(ctx).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
            }
            top.addView(appIcon(16), LinearLayout.LayoutParams(dp(16), dp(16)))
            top.addView(TextView(ctx).apply {
                this.text = app
                setTextColor(nameColor); textSize = 12f
                setPadding(dp(8), 0, 0, 0)
            }, LinearLayout.LayoutParams(0, -2, 1f))
            top.addView(closeButton(30), LinearLayout.LayoutParams(dp(30), dp(30)))
            card.addView(top, LinearLayout.LayoutParams(-1, -2))

            // Row 2/3: sender + message
            if (title.isNotEmpty()) card.addView(TextView(ctx).apply {
                this.text = title
                setTextColor(pal.title); textSize = 14f
                typeface = Typeface.DEFAULT_BOLD
                maxLines = 1; ellipsize = TextUtils.TruncateAt.END
                setPadding(0, 0, dp(8), 0)
            })
            if (text.isNotEmpty()) card.addView(TextView(ctx).apply {
                this.text = text
                setTextColor(pal.body); textSize = 13f
                maxLines = 2; ellipsize = TextUtils.TruncateAt.END
                setPadding(0, dp(2), dp(8), 0)
            })
        }

        card.setOnClickListener { onTap() }
        return card
    }

    // ── Inside the launcher ───────────────────────────────────────────
    fun show(activity: Activity, pkg: String?, app: String, title: String, text: String) {
        try {
            val host = activity.findViewById<ViewGroup>(android.R.id.content) ?: return
            val dm = activity.resources.displayMetrics
            fun dp(v: Int) = (v * dm.density).toInt()

            host.findViewWithTag<View>(TAG)?.let { host.removeView(it) }

            val st = NotifPrefs.popupStyleFor(activity, pkg)
            val bottom = isBottom(st.position)
            // slide in from the edge the card sits on
            val slide = (if (bottom) dp(40) else -dp(40)).toFloat()

            lateinit var card: LinearLayout
            fun hide() {
                if (card.parent == null) return
                card.animate().cancel()
                card.animate().alpha(0f).translationY(slide).setDuration(180)
                    .withEndAction { (card.parent as? ViewGroup)?.removeView(card) }.start()
            }
            card = buildCard(activity, pkg, app, title, text, st, { hide() }) {
                hide()
                try { activity.startActivity(Intent(activity, QuickControlsActivity::class.java)) } catch (_: Exception) {}
            }

            // Stay clear of the status bar / navigation bar even when the window draws edge-to-edge.
            val insets = ViewCompat.getRootWindowInsets(host)?.getInsets(WindowInsetsCompat.Type.systemBars())
            val loc = IntArray(2)
            host.getLocationOnScreen(loc)
            val topMargin = maxOf(0, (insets?.top ?: 0) - loc[1]) + dp(8)
            val hostBottom = loc[1] + host.height
            // inside the launcher the 52dp taskbar sits at the bottom of the content area
            val taskbar = if (activity is MainActivity) dp(52) else 0
            val bottomMargin = maxOf(0, (insets?.bottom ?: 0) - (dm.heightPixels - hostBottom)) + dp(8) + taskbar

            val width = minOf(dm.widthPixels - dp(24), dp(380))
            val gravity = (if (bottom) Gravity.BOTTOM else Gravity.TOP) or horizontalGravity(st.position)
            host.addView(card, FrameLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT, gravity).apply {
                setMargins(dp(12), if (bottom) 0 else topMargin, dp(12), if (bottom) bottomMargin else 0)
            })

            card.alpha = 0f
            card.translationY = slide
            card.animate().alpha(1f).translationY(0f).setDuration(220).start()
            if (st.durationMs > 0L) card.postDelayed({ hide() }, st.durationMs) // 0 = until dismissed
        } catch (e: Throwable) {
            AppLog.e("GlassToast", "show failed", e)
        }
    }

    // ── Over any app (needs "Display over other apps") ────────────────
    /** @return true when the overlay was added; false means the caller should fall back to a Toast. */
    fun showOverlay(ctx: Context, pkg: String?, app: String, title: String, text: String): Boolean {
        return try {
            val appCtx = ctx.applicationContext
            val wm = appCtx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = appCtx.resources.displayMetrics
            fun dp(v: Int) = (v * dm.density).toInt()

            removeOverlay(wm)

            val st = NotifPrefs.popupStyleFor(appCtx, pkg)
            val bottom = isBottom(st.position)
            val slide = (if (bottom) dp(40) else -dp(40)).toFloat()

            val shortText = if (text.length > 120) text.substring(0, 120) + "…" else text
            val close = { removeOverlay(wm) }
            val card = buildCard(appCtx, pkg, app, title, shortText, st, { close() }) {
                close()
                try {
                    appCtx.startActivity(Intent(appCtx, QuickControlsActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                } catch (_: Exception) {}
            }

            val sbId = appCtx.resources.getIdentifier("status_bar_height", "dimen", "android")
            val statusBar = if (sbId > 0) appCtx.resources.getDimensionPixelSize(sbId) else dp(24)
            val nbId = appCtx.resources.getIdentifier("navigation_bar_height", "dimen", "android")
            val navBar = if (nbId > 0) appCtx.resources.getDimensionPixelSize(nbId) else dp(24)

            @Suppress("DEPRECATION")
            val type = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            else WindowManager.LayoutParams.TYPE_PHONE

            val h = horizontalGravity(st.position)
            val lp = WindowManager.LayoutParams(
                minOf(dm.widthPixels - dp(24), dp(380)),
                WindowManager.LayoutParams.WRAP_CONTENT,
                type,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT
            ).apply {
                gravity = (if (bottom) Gravity.BOTTOM else Gravity.TOP) or h
                // x is the distance from the left / right edge; for "center" it is an offset from the middle
                x = if (h == Gravity.CENTER_HORIZONTAL) 0 else dp(12)
                y = if (bottom) navBar + dp(8) else statusBar + dp(8)
            }

            wm.addView(card, lp)
            overlayView = card
            card.alpha = 0f
            card.translationY = slide
            card.animate().alpha(1f).translationY(0f).setDuration(220).start()
            if (st.durationMs > 0L) {
                card.postDelayed({ if (overlayView === card) removeOverlay(wm) }, st.durationMs)
            }
            true
        } catch (e: Throwable) {
            AppLog.w("GlassToast", "overlay failed, falling back to Toast", e)
            false
        }
    }

    private fun removeOverlay(wm: WindowManager) {
        val v = overlayView ?: return
        overlayView = null
        try { v.animate().cancel() } catch (_: Throwable) {}
        try { wm.removeViewImmediate(v) } catch (_: Throwable) {}
    }
}
