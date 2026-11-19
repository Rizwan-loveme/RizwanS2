package com.srizwan.win11

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Windows 11 style toast: a small glass (translucent, rounded, bordered) card that slides in at
 * the top-right, stays for a few seconds and fades away. Tap opens the notification center;
 * the vector X dismisses it. Only one toast is shown at a time (a new one replaces the old one).
 */
object GlassToast {

    private const val TAG = "win11_glass_toast"
    private const val SHOW_MS = 5000L

    fun show(activity: Activity, pkg: String?, app: String, title: String, text: String) {
        try {
            val host = activity.findViewById<ViewGroup>(android.R.id.content) ?: return
            val dm = activity.resources.displayMetrics
            fun dp(v: Int) = (v * dm.density).toInt()

            host.findViewWithTag<View>(TAG)?.let { host.removeView(it) }

            val card = LinearLayout(activity).apply {
                tag = TAG
                orientation = LinearLayout.VERTICAL
                setPadding(dp(14), dp(10), dp(6), dp(12))
                background = GradientDrawable().apply {
                    setColor(Color.argb(225, 32, 36, 44))
                    cornerRadius = dp(12).toFloat()
                    setStroke(dp(1), Color.argb(46, 255, 255, 255))
                }
                elevation = dp(10).toFloat()
                isClickable = true
                isFocusable = true
            }

            fun hide() {
                if (card.parent == null) return
                card.animate().cancel()
                card.animate().alpha(0f).translationY(-dp(40).toFloat()).setDuration(180)
                    .withEndAction { (card.parent as? ViewGroup)?.removeView(card) }.start()
            }

            // Row 1: app icon + app name + vector X
            val top = LinearLayout(activity).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
            }
            top.addView(ImageView(activity).apply {
                val ic = try { pkg?.let { activity.packageManager.getApplicationIcon(it) } } catch (_: Exception) { null }
                if (ic != null) setImageDrawable(ic)
                else { setImageResource(R.drawable.ic_qs_notifications); setColorFilter(Color.rgb(76, 194, 255)) }
            }, LinearLayout.LayoutParams(dp(16), dp(16)))
            top.addView(TextView(activity).apply {
                this.text = app
                setTextColor(Color.LTGRAY); textSize = 12f
                setPadding(dp(8), 0, 0, 0)
            }, LinearLayout.LayoutParams(0, -2, 1f))
            top.addView(ImageView(activity).apply {
                setImageResource(R.drawable.ic_qs_close)
                setColorFilter(Color.LTGRAY)
                contentDescription = "Dismiss"
                setPadding(dp(9), dp(9), dp(9), dp(9))
                isClickable = true
                setOnClickListener { hide() }
            }, LinearLayout.LayoutParams(dp(30), dp(30)))
            card.addView(top, LinearLayout.LayoutParams(-1, -2))

            // Row 2/3: sender + message
            if (title.isNotEmpty()) card.addView(TextView(activity).apply {
                this.text = title
                setTextColor(Color.WHITE); textSize = 14f
                typeface = Typeface.DEFAULT_BOLD
                maxLines = 1; ellipsize = TextUtils.TruncateAt.END
                setPadding(0, 0, dp(8), 0)
            })
            if (text.isNotEmpty()) card.addView(TextView(activity).apply {
                this.text = text
                setTextColor(Color.LTGRAY); textSize = 13f
                maxLines = 2; ellipsize = TextUtils.TruncateAt.END
                setPadding(0, dp(2), dp(8), 0)
            })

            card.setOnClickListener {
                hide()
                try { activity.startActivity(Intent(activity, QuickControlsActivity::class.java)) } catch (_: Exception) {}
            }

            // Sit below the status bar even when the window draws edge-to-edge.
            val insetTop = ViewCompat.getRootWindowInsets(host)
                ?.getInsets(WindowInsetsCompat.Type.systemBars())?.top ?: 0
            val loc = IntArray(2)
            host.getLocationOnScreen(loc)
            val topMargin = maxOf(0, insetTop - loc[1]) + dp(8)

            val width = minOf(dm.widthPixels - dp(24), dp(380))
            host.addView(card, FrameLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.TOP or Gravity.END).apply {
                setMargins(dp(12), topMargin, dp(12), 0)
            })

            card.alpha = 0f
            card.translationY = -dp(40).toFloat()
            card.animate().alpha(1f).translationY(0f).setDuration(220).start()
            card.postDelayed({ hide() }, SHOW_MS)
        } catch (e: Throwable) {
            AppLog.e("GlassToast", "show failed", e)
        }
    }
}
