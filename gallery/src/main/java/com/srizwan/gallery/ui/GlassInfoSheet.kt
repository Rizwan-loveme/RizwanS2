package com.srizwan.gallery.ui

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.srizwan.gallery.R
import com.srizwan.gallery.data.ImageInfo

/**
 * The details of one picture (step 8) as a glass sheet: a small dim label above each value, all drawn as glyph outlines
 * ([VectorText]), so values can be long (a path wraps, a name is cut with an ellipsis after four lines). The location row,
 * when there is one, is tappable ([onLocation]) and drawn in the accent colour. Built on [GlassSheet.showContent].
 */
object GlassInfoSheet {

    fun show(activity: Activity, title: String, info: ImageInfo, onLocation: () -> Unit) {
        GlassSheet.showContent(activity) { _ ->
            fun dp(v: Float) = GlassUi.dp(activity, v)
            val accent = activity.getColor(R.color.gl_accent)

            val column = LinearLayout(activity).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(20f), dp(16f), dp(20f), dp(12f))
            }
            val heading = ImageView(activity).apply {
                setImageDrawable(VectorLabelDrawable(activity, title, R.drawable.gl_ic_info, textSizeDp = 16f, iconSizeDp = 22f))
            }
            column.addView(heading, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(30f)))

            info.rows.forEachIndexed { index, (label, value) ->
                val isLocation = index == info.locationRow
                val labelView = VectorText(activity).apply { set(label, 12f, 0x99FFFFFF.toInt()) }
                val valueView = VectorText(activity).apply {
                    set(value, 15f, if (isLocation) accent else 0xFFFFFFFF.toInt(), maxLines = 4)
                }
                val item = LinearLayout(activity).apply {
                    orientation = LinearLayout.VERTICAL
                    setPadding(0, dp(8f), 0, dp(8f))
                    addView(labelView, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                    addView(valueView, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                        topMargin = dp(2f)
                    })
                    if (isLocation) {
                        isClickable = true
                        isFocusable = true
                        GlassUi.borderless(activity)?.let { foreground = it }
                        contentDescription = activity.getString(R.string.gl_cd_open_map)
                        setOnClickListener { onLocation() }
                    }
                }
                column.addView(item, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = if (index == 0) dp(8f) else 0
                })
            }
            column
        }
    }
}
