package com.srizwan.win11

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.graphics.PathParser

// =====================================================================
// STEP 4.14 – GLASS EMPTY / PERMISSION / ERROR STATE
// One glass card replaces the plain "This folder is empty" text and the
// plain error box of the explorer. It has three faces:
//   * EMPTY  – empty folder          (folder icon,  [New folder])
//   * DENIED – no permission         (lock icon,    [Allow access] [Retry])
//   * FAILED – the load failed       (warning icon, [Retry])
// Pure Kotlin views, the icons are drawn from path data (no drawable
// resource), same glass look as the rows / cells (WX.GLASS + WX.GLASS_EDGE).
// It is the last row of the list (as the old boxes were), so in Grid and
// Large mode it takes the whole row and in all modes it scrolls with the
// list under the drive card.
// =====================================================================

internal enum class StateKind { EMPTY, DENIED, FAILED }

/** Big vector icon of a state (folder / lock / warning), drawn on a Canvas from path data. */
internal class StateIconView(context: Context) : View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private var path: Path? = null

    var tint: Int = WX.DIM
        set(v) { field = v; invalidate() }

    fun setKind(kind: StateKind) {
        path = PathParser.createPathFromPathData(
            when (kind) {
                // folder (outline)
                StateKind.EMPTY ->
                    "M20 6h-8l-2-2H4c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V8c0-1.1-.9-2-2-2zm0 12H4V8h16v10z"
                // padlock
                StateKind.DENIED ->
                    "M18 8h-1V6c0-2.76-2.24-5-5-5S7 3.24 7 6v2H6c-1.1 0-2 .9-2 2v10c0 1.1.9 2 2 2h12c1.1 0 2-.9 2-2V10c0-1.1-.9-2-2-2zm-6 9c-1.1 0-2-.9-2-2s.9-2 2-2 2 .9 2 2-.9 2-2 2zm3.1-9H8.9V6c0-1.71 1.39-3.1 3.1-3.1 1.71 0 3.1 1.39 3.1 3.1v2z"
                // warning triangle (same path as ic_w_warning)
                StateKind.FAILED ->
                    "M1 21h22L12 2 1 21zm12-3h-2v-2h2v2zm0-4h-2v-4h2v4z"
            }
        )
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        val p = path ?: return
        val s = minOf(width, height) / 24f
        canvas.save()
        canvas.translate((width - 24f * s) / 2f, (height - 24f * s) / 2f)
        canvas.scale(s, s)
        paint.color = tint
        canvas.drawPath(p, paint)
        canvas.restore()
    }
}

/** Vertical box that never gets wider than [maxWidthPx] (a wide tablet / landscape grid keeps a neat card). */
private class MaxWidthLinear(context: Context, private val maxWidthPx: Int) : LinearLayout(context) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val w = MeasureSpec.getSize(widthMeasureSpec)
        val spec = if (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED && w > maxWidthPx)
            MeasureSpec.makeMeasureSpec(maxWidthPx, MeasureSpec.EXACTLY) else widthMeasureSpec
        super.onMeasure(spec, heightMeasureSpec)
    }
}

/**
 * The glass state card. [show] puts one of the three faces on screen, [hide] removes it.
 * Buttons: [onNewFolder] (empty folder), [onAllowAccess] and [onRetry] (no permission),
 * [onRetry] (failed). Showing the same face again (for example the same empty folder after a
 * rename elsewhere) does not rebuild or re-animate the card.
 */
internal class StateCardView(
    context: Context,
    private val onRetry: () -> Unit,
    private val onNewFolder: () -> Unit,
    private val onAllowAccess: () -> Unit
) : FrameLayout(context) {

    private val density = context.resources.displayMetrics.density
    private fun dp(v: Int): Int = (v * density).toInt()

    private val icon = StateIconView(context)
    private val iconTile = FrameLayout(context)
    private val titleView = TextView(context)
    private val msgView = TextView(context)
    private val buttons = LinearLayout(context)
    private var shownKind: StateKind? = null

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        visibility = View.GONE
        setPadding(dp(12), dp(28), dp(12), dp(28))
        accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_POLITE

        val card = MaxWidthLinear(context, dp(420)).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(dp(24), dp(28), dp(24), dp(24))
            background = GradientDrawable().apply {
                cornerRadius = dp(20).toFloat()
                setColor(WX.GLASS)
                setStroke(dp(1), WX.GLASS_EDGE)
            }
        }

        iconTile.addView(icon, FrameLayout.LayoutParams(dp(36), dp(36), Gravity.CENTER))
        card.addView(iconTile, LinearLayout.LayoutParams(dp(76), dp(76)))

        titleView.apply {
            setTextColor(WX.TEXT)
            textSize = 16f
            typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
            gravity = Gravity.CENTER
        }
        card.addView(titleView, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = dp(16) })

        msgView.apply {
            setTextColor(WX.DIM)
            textSize = 12.5f
            gravity = Gravity.CENTER
            setLineSpacing(0f, 1.15f)
        }
        card.addView(msgView, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = dp(6) })

        buttons.apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
        }
        card.addView(buttons, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = dp(20) })

        addView(card, FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL
        ))
    }

    /** Colour of the icon (and its tile) for each face. */
    private fun tintOf(kind: StateKind): Int = when (kind) {
        StateKind.EMPTY -> Color.parseColor("#FFB900")     // same amber as the folder tile
        StateKind.DENIED -> Color.parseColor("#FF9F43")
        StateKind.FAILED -> WX.WARN
    }

    fun showEmpty() = show(
        StateKind.EMPTY,
        "This folder is empty",
        "Nothing here yet. Create a folder or copy files into it."
    )

    fun showDenied(message: String) = show(StateKind.DENIED, "Permission denied", message)

    fun showFailed(title: String, message: String) = show(StateKind.FAILED, title, message)

    fun show(kind: StateKind, title: String, message: String) {
        val same = visibility == View.VISIBLE && shownKind == kind &&
                titleView.text.toString() == title && msgView.text.toString() == message
        if (same) return
        val wasVisible = visibility == View.VISIBLE

        shownKind = kind
        val tint = tintOf(kind)
        icon.setKind(kind)
        icon.tint = tint
        iconTile.background = GradientDrawable().apply {
            cornerRadius = dp(22).toFloat()
            setColor(Color.argb(0x24, Color.red(tint), Color.green(tint), Color.blue(tint)))
            setStroke(dp(1), Color.argb(0x45, Color.red(tint), Color.green(tint), Color.blue(tint)))
        }
        titleView.text = title
        msgView.text = message

        buttons.removeAllViews()
        when (kind) {
            StateKind.EMPTY -> addButton("New folder", primary = true) { onNewFolder() }
            StateKind.DENIED -> {
                addButton("Allow access", primary = true) { onAllowAccess() }
                addButton("Retry", primary = false) { onRetry() }
            }
            StateKind.FAILED -> addButton("Retry", primary = true) { onRetry() }
        }

        animate().cancel()
        if (!wasVisible) {
            alpha = 0f
            translationY = dp(10).toFloat()
            visibility = View.VISIBLE
            animate().alpha(1f).translationY(0f).setDuration(180L).start()
        } else {
            alpha = 1f
            translationY = 0f
        }
    }

    fun hide() {
        animate().cancel()
        alpha = 1f
        translationY = 0f
        visibility = View.GONE
        shownKind = null
    }

    private fun addButton(label: String, primary: Boolean, onClick: () -> Unit) {
        val accentFill = Color.argb(0x26, Color.red(WX.ACCENT), Color.green(WX.ACCENT), Color.blue(WX.ACCENT))
        val face = GradientDrawable().apply {
            cornerRadius = dp(20).toFloat()
            if (primary) {
                setColor(accentFill)
                setStroke(dp(1), WX.ACCENT)
            } else {
                setColor(WX.GLASS)
                setStroke(dp(1), WX.GLASS_EDGE)
            }
        }
        val mask = GradientDrawable().apply {
            cornerRadius = dp(20).toFloat()
            setColor(Color.WHITE)
        }
        val b = TextView(context).apply {
            text = label
            setTextColor(if (primary) WX.ACCENT else WX.TEXT)
            textSize = 14f
            typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
            gravity = Gravity.CENTER
            setPadding(dp(22), 0, dp(22), 0)
            background = RippleDrawable(ColorStateList.valueOf(WX.RIPPLE), face, mask)
            isClickable = true
            contentDescription = label
            setOnClickListener { onClick() }
        }
        buttons.addView(b, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, dp(40)
        ).apply {
            if (buttons.childCount > 0) marginStart = dp(10)
        })
    }
}

/**
 * "Allow access" button of the permission state: Android 11+ opens the all-files-access page of
 * this app, older versions (and devices without that page) open the app details page, where the
 * Storage permission can be switched on. Then press Retry.
 */
internal fun openStorageAccessSettings(ctx: Context) {
    fun start(i: Intent): Boolean = try {
        if (ctx !is android.app.Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        ctx.startActivity(i)
        true
    } catch (_: Exception) {
        false
    }

    val pkg = Uri.parse("package:${ctx.packageName}")
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
        if (start(Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, pkg))) return
    }
    start(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, pkg))
}
