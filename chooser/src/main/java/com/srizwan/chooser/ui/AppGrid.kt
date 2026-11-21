package com.srizwan.chooser.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.provider.Settings
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R
import com.srizwan.chooser.data.ChooserPrefs
import com.srizwan.chooser.data.Target

/**
 * The grid of apps shared by the "Open with" sheet (step 3) and the Share sheet (step 6): app icon over app name, rows that fit the
 * card, press-and-hold for the system "App info", plus the small pieces around it (section label, empty state).
 * The sheets decide what a tap means (select, or send at once); the grid only reports the tapped index.
 *
 * Step 11: the settings choose the look ([isList]: one app per row instead of tiles; [columnsFor]: the number of tiles per row, never more
 * than fit), [scroller] keeps a very long list inside its own scroll area so the buttons under it stay in reach, and the sheets
 * re-layout on rotation ([AppListHost]).
 */
object AppGrid {

    private const val TAG = "AppGrid"
    private const val TILE_DP = 76f
    private const val MIN_COLUMNS = 3
    private const val MAX_COLUMNS = 6
    private const val MIN_TILE_DP = 56f
    private const val ROW_DP = 52f

    /** The share of the screen height a sheet with apps may use: more in landscape, where the screen is short. */
    const val SHEET_MAX_FRACTION = 0.92f

    fun sheetFraction(context: Context): Float {
        val dm = context.resources.displayMetrics
        return if (dm.heightPixels < dm.widthPixels) SHEET_MAX_FRACTION else 0.72f
    }

    /** The grid view and its tiles (in the order of the targets), so a sheet can mark the selected one. */
    class Built(val view: View, val tiles: List<View>)

    /** Does the saved style list the apps one per row (see [ChooserPrefs.sheetList])? */
    fun isList(context: Context): Boolean = ChooserPrefs.sheetList(context)

    /**
     * Tiles per row. The card is the screen width minus 24 dp of margin, minus 32 dp of padding. Automatic = as many as fit; a number
     * chosen in the settings is used when it fits (tiles at least 56 dp wide), else the most that fit. 1 in the list style.
     */
    fun columnsFor(activity: Activity): Int {
        if (isList(activity)) return 1
        val dm = activity.resources.displayMetrics
        val cardDp = dm.widthPixels / dm.density - 24f - 32f
        val fit = (cardDp / TILE_DP).toInt().coerceIn(MIN_COLUMNS, MAX_COLUMNS)
        val wanted = ChooserPrefs.sheetColumns(activity)
        if (wanted == 0) return fit
        val most = (cardDp / MIN_TILE_DP).toInt().coerceIn(MIN_COLUMNS, MAX_COLUMNS)
        return wanted.coerceAtMost(most)
    }

    /** Columns for the loading skeleton: it only draws tiles, so the list style gets a few as well. */
    fun skeletonColumns(activity: Activity): Int = columnsFor(activity).coerceAtLeast(MIN_COLUMNS)

    /**
     * Puts [content] (a grid) in its own scroll area, so a very long list scrolls inside the sheet and the buttons under it stay visible.
     * The area is as tall as the list up to the screen height times [sheetFraction], minus [reserveDp] for the rest of the sheet
     * (never less than one row). A short list does not scroll at all.
     */
    fun scroller(context: Context, content: View, reserveDp: Float): ScrollView {
        val minPx = GlassUi.dp(context, 80f)
        val reservePx = GlassUi.dp(context, reserveDp)
        return object : ScrollView(context) {
            override fun onMeasure(widthSpec: Int, heightSpec: Int) {
                val cap = (resources.displayMetrics.heightPixels * sheetFraction(context)).toInt() - reservePx
                super.onMeasure(widthSpec, MeasureSpec.makeMeasureSpec(cap.coerceAtLeast(minPx), MeasureSpec.AT_MOST))
            }
        }.apply {
            isVerticalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            isVerticalFadingEdgeEnabled = true
            setFadingEdgeLength(GlassUi.dp(context, 18f))
            addView(content)
        }
    }

    /** [onTap] gets the index into [targets]. Press and hold opens the app's App info screen. */
    fun build(activity: Activity, targets: List<Target>, columns: Int, onTap: (Int) -> Unit): Built {
        val tiles = ArrayList<View>(targets.size)
        val grid = LinearLayout(activity).apply { orientation = LinearLayout.VERTICAL }
        if (isList(activity)) {
            targets.forEachIndexed { index, target ->
                val row = listRow(activity, target)
                row.background = ripple(activity)
                row.setOnClickListener { onTap(index) }
                row.setOnLongClickListener {
                    it.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
                    openAppInfo(activity, target.packageName)
                    true
                }
                tiles.add(row)
                grid.addView(row, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, GlassUi.dp(activity, ROW_DP)))
            }
            return Built(grid, tiles)
        }
        targets.chunked(columns).forEachIndexed { rowIndex, chunk ->
            val row = LinearLayout(activity).apply {
                orientation = LinearLayout.HORIZONTAL
                isBaselineAligned = false
            }
            chunk.forEachIndexed { col, target ->
                val index = rowIndex * columns + col
                val tile = tile(activity, target)
                tile.background = ripple(activity)
                tile.setOnClickListener { onTap(index) }
                tile.setOnLongClickListener {
                    it.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
                    openAppInfo(activity, target.packageName)
                    true
                }
                tiles.add(tile)
                row.addView(tile, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f))
            }
            // the last row keeps its tiles the same width as the rows above
            repeat(columns - chunk.size) {
                row.addView(View(activity), LinearLayout.LayoutParams(0, 1, 1f))
            }
            grid.addView(row, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
        return Built(grid, tiles)
    }

    /** One app: its icon over its name (two lines at most). The name is also the spoken description of the tile. */
    private fun tile(activity: Activity, target: Target): LinearLayout {
        fun dp(v: Float) = GlassUi.dp(activity, v)
        val icon = ImageView(activity).apply {
            scaleType = ImageView.ScaleType.FIT_CENTER
            setImageDrawable(target.icon)
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        val label = VectorText(activity).apply {
            set(target.label, 12f, Color.WHITE, maxLines = 2, center = true)
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        return LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(dp(4f), dp(10f), dp(4f), dp(8f))
            isClickable = true
            isFocusable = true
            contentDescription = target.label
            addView(icon, LinearLayout.LayoutParams(dp(48f), dp(48f)))
            addView(label, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                topMargin = dp(6f)
            })
        }
    }

    /** One app of the list style: a small icon, then its name on one line. */
    private fun listRow(activity: Activity, target: Target): LinearLayout {
        fun dp(v: Float) = GlassUi.dp(activity, v)
        val icon = ImageView(activity).apply {
            scaleType = ImageView.ScaleType.FIT_CENTER
            setImageDrawable(target.icon)
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        val label = VectorText(activity).apply {
            set(target.label, 16f, Color.WHITE, maxLines = 1)
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        return LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(12f), dp(6f), dp(12f), dp(6f))
            isClickable = true
            isFocusable = true
            contentDescription = target.label
            addView(icon, LinearLayout.LayoutParams(dp(40f), dp(40f)))
            addView(label, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply { marginStart = dp(14f) })
        }
    }

    /** A small dim heading over a part of the grid ("Recent", "All apps"). */
    fun sectionLabel(activity: Activity, text: String): View = VectorText(activity).apply {
        set(text, 12f, ContextCompat.getColor(activity, R.color.ch_text_dim), bold = true)
        setPadding(GlassUi.dp(activity, 4f), GlassUi.dp(activity, 10f), 0, GlassUi.dp(activity, 2f))
    }

    /** The look of the selected tile (accent outline). */
    fun selectedBackground(activity: Activity) = GradientDrawable().apply {
        cornerRadius = GlassUi.dp(activity, 16f).toFloat()
        setColor(0x26FFFFFF)
        setStroke(GlassUi.dp(activity, 1.5f), ContextCompat.getColor(activity, R.color.ch_accent))
    }

    fun ripple(activity: Activity) = TypedValue().let { tv ->
        if (activity.theme.resolveAttribute(android.R.attr.selectableItemBackground, tv, true) && tv.resourceId != 0) {
            ContextCompat.getDrawable(activity, tv.resourceId)
        } else null
    }

    /** "Nothing here": a round glass icon, a title, a short text and (when [buttonLabel] is given) one accent button. */
    fun empty(
        activity: Activity,
        @DrawableRes iconRes: Int,
        titleText: String,
        bodyText: String,
        buttonLabel: String? = null,
        @DrawableRes buttonIcon: Int = 0,
        onButton: () -> Unit = {}
    ): View {
        fun dp(v: Float) = GlassUi.dp(activity, v)
        val icon = ImageView(activity).apply {
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            background = GlassDrawable(activity, 40f)
            val p = dp(16f)
            setPadding(p, p, p, p)
            setImageDrawable(VectorLabelDrawable(activity, null, iconRes, iconSizeDp = 32f))
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        val title = VectorText(activity).apply { set(titleText, 17f, Color.WHITE, bold = true, maxLines = 2, center = true) }
        val text = VectorText(activity).apply {
            set(bodyText, 14f, ContextCompat.getColor(activity, R.color.ch_text_dim), maxLines = 3, center = true)
        }
        return LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(0, dp(12f), 0, dp(4f))
            addView(icon, LinearLayout.LayoutParams(dp(72f), dp(72f)))
            addView(title, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                topMargin = dp(14f)
            })
            addView(text, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                topMargin = dp(6f)
            })
            if (buttonLabel != null) {
                val b = GlassButtons.pill(activity, buttonLabel, primary = true, icon = buttonIcon, onClick = onButton)
                addView(b, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(18f)
                })
            }
        }
    }

    /** The system "App info" screen of [packageName]. A failure is only logged: the sheet stays as it is. */
    fun openAppInfo(activity: Activity, packageName: String) {
        try {
            activity.startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", packageName, null)))
        } catch (e: Exception) {
            Log.w(TAG, "App info not available for $packageName", e)
        }
    }
}
