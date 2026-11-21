package com.srizwan.video.ui

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.srizwan.video.R

/**
 * The list picker of the Video app (speed, quality): a glass card at the bottom of the screen over a
 * blurred, dimmed backdrop (system window blur on Android 12+, plain dim before that). Rows are a vector icon
 * plus a vector-outline label; the chosen row has a vector check. No dialog title, no text view.
 */
object GlassSheet {

    class Row(@DrawableRes val icon: Int, val label: String?, val selected: Boolean)

    fun show(activity: Activity, rows: List<Row>, onPick: (Int) -> Unit) {
        if (activity.isFinishing || activity.isDestroyed || rows.isEmpty()) return
        val density = activity.resources.displayMetrics.density
        fun dp(v: Float) = (v * density).toInt()

        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)

        val list = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(8f), dp(8f), dp(8f), dp(8f))
        }
        rows.forEachIndexed { index, row ->
            list.addView(rowView(activity, row, density) {
                dialog.dismiss()
                onPick(index)
            })
        }
        val maxHeight = (activity.resources.displayMetrics.heightPixels * 0.6f).toInt()
        val scroll = object : ScrollView(activity) {
            override fun onMeasure(widthSpec: Int, heightSpec: Int) {
                val size = MeasureSpec.getSize(heightSpec)
                val cap = if (size > 0) minOf(size, maxHeight) else maxHeight
                super.onMeasure(widthSpec, MeasureSpec.makeMeasureSpec(cap, MeasureSpec.AT_MOST))
            }
        }.apply {
            isVerticalScrollBarEnabled = false
            addView(list)
        }
        val card = FrameLayout(activity).apply {
            background = GlassDrawable(activity, 26f, strong = true)
            isClickable = true // taps on the card do not reach the backdrop
            addView(scroll)
            alpha = 0f
            translationY = dp(60f).toFloat()
        }
        val root = FrameLayout(activity).apply {
            setPadding(dp(12f), dp(12f), dp(12f), dp(12f))
            setOnClickListener { dialog.dismiss() }
            addView(
                card,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM
                )
            )
        }
        dialog.setContentView(root)
        dialog.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            setDimAmount(0.38f)
            if (Build.VERSION.SDK_INT >= 31) {
                addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                attributes = attributes.also { it.blurBehindRadius = 34 }
            }
        }
        dialog.show()
        card.animate().alpha(1f).translationY(0f).setDuration(220L).start()
    }

    private fun rowView(context: Context, row: Row, density: Float, onClick: () -> Unit): View {
        fun dp(v: Float) = (v * density).toInt()
        val label = ImageView(context).apply {
            setImageDrawable(VectorLabelDrawable(context, row.label, row.icon, textSizeDp = 16f, iconSizeDp = 22f))
        }
        val check = ImageView(context).apply {
            setImageDrawable(
                VectorLabelDrawable(context, null, R.drawable.vp_ic_check, iconSizeDp = 22f, tint = ContextCompat.getColor(context, R.color.vp_accent))
            )
            visibility = if (row.selected) View.VISIBLE else View.INVISIBLE
        }
        val spacer = View(context)
        return LinearLayout(context).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            minimumHeight = dp(50f)
            setPadding(dp(16f), 0, dp(16f), 0)
            addView(label)
            addView(spacer, LinearLayout.LayoutParams(0, 1, 1f))
            addView(check)
            background = if (row.selected) {
                GradientDrawable().apply {
                    cornerRadius = dp(16f).toFloat()
                    setColor(0x26FFFFFF)
                }
            } else {
                selectable(context)
            }
            isClickable = true
            setOnClickListener { onClick() }
        }
    }

    private fun selectable(context: Context) = TypedValue().let { tv ->
        if (context.theme.resolveAttribute(android.R.attr.selectableItemBackground, tv, true) && tv.resourceId != 0) {
            ContextCompat.getDrawable(context, tv.resourceId)
        } else null
    }
}
