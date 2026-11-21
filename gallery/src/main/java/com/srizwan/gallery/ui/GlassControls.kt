package com.srizwan.gallery.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.srizwan.gallery.R

/**
 * The glass controls of the Gallery: the small pieces every screen is built from.
 *
 *  - [GlassUi]      : dp helper, round / plain icon buttons.
 *  - [GlassBar]     : the floating glass top bar (back, title, action icons).
 *  - [GlassToolbar] : the floating glass bottom bar of icon buttons (viewer actions, selection actions).
 *  - [GlassTabs]    : the Photos / Albums pill switch.
 *  - [GlassConfirm] : "are you sure" sheet (delete).
 *
 * Nothing here uses a TextView: titles and labels are glyph outlines ([VectorText], [VectorLabelDrawable]),
 * icons are vector drawables, so every piece looks the same on every device.
 */
object GlassUi {

    fun dp(context: Context, v: Float): Int = (v * context.resources.displayMetrics.density + 0.5f).toInt()

    /** The ripple that fits a round icon, or null when the theme has none. */
    fun borderless(context: Context): Drawable? = TypedValue().let { tv ->
        if (context.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, tv, true) && tv.resourceId != 0) {
            ContextCompat.getDrawable(context, tv.resourceId)
        } else null
    }

    /**
     * An icon button. [glass] = true gives it its own round glass body (floating over a picture);
     * false is a bare icon for use inside a glass bar.
     */
    fun iconButton(
        context: Context,
        @DrawableRes icon: Int,
        @StringRes description: Int,
        sizeDp: Float = 44f,
        glass: Boolean = false,
        onClick: (() -> Unit)? = null
    ): ImageView = ImageView(context).apply {
        scaleType = ImageView.ScaleType.FIT_CENTER
        setImageDrawable(ContextCompat.getDrawable(context, icon))
        if (description != 0) contentDescription = context.getString(description)
        val pad = dp(context, sizeDp * 0.24f)
        setPadding(pad, pad, pad, pad)
        isClickable = true
        isFocusable = true
        if (glass) background = GlassDrawable(context, sizeDp / 2f)
        borderless(context)?.let { foreground = it }
        layoutParams = LinearLayout.LayoutParams(dp(context, sizeDp), dp(context, sizeDp))
        onClick?.let { cb -> setOnClickListener { cb() } }
    }

    /** Swaps the picture of a button and (optionally) its description, e.g. favorite outline -> filled. */
    fun setIcon(button: ImageView, @DrawableRes icon: Int, @StringRes description: Int = 0) {
        button.setImageDrawable(ContextCompat.getDrawable(button.context, icon))
        if (description != 0) button.contentDescription = button.context.getString(description)
    }

    /** Keeps a bar clear of the status / navigation bar and the camera cut-out (needed once a screen is edge to edge). */
    fun padForInsets(view: View, basePaddingDp: Float, top: Boolean, bottom: Boolean) {
        val base = dp(view.context, basePaddingDp)
        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            v.setPadding(
                base + bars.left,
                base + if (top) bars.top else 0,
                base + bars.right,
                base + if (bottom) bars.bottom else 0
            )
            insets
        }
    }
}

/**
 * The floating glass top bar: a rounded glass pill with a back button, a one-line title and action icons on the
 * right. Put it at the top of a FrameLayout (`Gravity.TOP`); it pads itself below the status bar.
 */
class GlassBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val pill = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        background = GlassDrawable(context, 28f)
        setPadding(GlassUi.dp(context, 4f), GlassUi.dp(context, 4f), GlassUi.dp(context, 8f), GlassUi.dp(context, 4f))
    }
    private val back = GlassUi.iconButton(context, R.drawable.gl_ic_back, R.string.gl_cd_back, sizeDp = 44f)
    private val title = VectorText(context)
    private val actions = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
    }

    init {
        clipToPadding = false
        pill.addView(back)
        pill.addView(
            title,
            LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                marginStart = GlassUi.dp(context, 6f)
                marginEnd = GlassUi.dp(context, 6f)
            }
        )
        pill.addView(actions, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        addView(pill, LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        GlassUi.padForInsets(this, 12f, top = true, bottom = false)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ViewCompat.requestApplyInsets(this)
    }

    /** The title is drawn as glyph outlines, one line, ended with an ellipsis when it is too long. */
    fun setTitle(text: String?) {
        title.set(text.orEmpty(), 18f, 0xFFFFFFFF.toInt(), bold = true)
    }

    /** Shows or hides the back button (the Gallery home screen has none while it is the root). */
    fun setBackVisible(visible: Boolean, onClick: (() -> Unit)? = null) {
        back.visibility = if (visible) View.VISIBLE else View.GONE
        onClick?.let { cb -> back.setOnClickListener { cb() } }
    }

    /** Another picture / description for the leading button (the selection bar shows a close cross instead of the arrow). */
    fun setBackIcon(@DrawableRes icon: Int, @StringRes description: Int) = GlassUi.setIcon(back, icon, description)

    /** Adds an icon on the right; returns it so a screen can change its picture later (see [GlassUi.setIcon]). */
    fun addAction(@DrawableRes icon: Int, @StringRes description: Int, onClick: () -> Unit): ImageView {
        val b = GlassUi.iconButton(context, icon, description, sizeDp = 42f, onClick = onClick)
        actions.addView(b)
        return b
    }

    fun clearActions() = actions.removeAllViews()
}

/**
 * The floating glass bottom bar: icon buttons spread evenly over a rounded glass pill. Put it at the bottom of a
 * FrameLayout (`Gravity.BOTTOM`); it pads itself above the navigation bar.
 */
class GlassToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val pill = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER
        background = GlassDrawable(context, 28f)
        setPadding(GlassUi.dp(context, 8f), GlassUi.dp(context, 4f), GlassUi.dp(context, 8f), GlassUi.dp(context, 4f))
    }

    init {
        clipToPadding = false
        addView(pill, LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        GlassUi.padForInsets(this, 12f, top = false, bottom = true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ViewCompat.requestApplyInsets(this)
    }

    /**
     * Adds a button; the buttons share the width equally. Returns it so its picture can be changed later.
     * [compact] = true gives the icon more room inside a narrow button (eight buttons on a 360 dp phone).
     */
    fun addButton(
        @DrawableRes icon: Int,
        @StringRes description: Int,
        compact: Boolean = false,
        onClick: () -> Unit
    ): ImageView {
        val b = GlassUi.iconButton(context, icon, description, sizeDp = 46f, onClick = onClick)
        b.layoutParams = LinearLayout.LayoutParams(0, GlassUi.dp(context, 46f), 1f)
        if (compact) {
            val pad = GlassUi.dp(context, 8f)
            b.setPadding(pad, pad, pad, pad)
        }
        pill.addView(b)
        return b
    }

    /**
     * For a toolbar that sits inside a parent which already keeps clear of the system bars (the viewer's bottom area):
     * drops the toolbar's own insets padding so the gap is not added twice.
     */
    fun withoutOwnInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(this, null)
        setPadding(0, 0, 0, 0)
    }

    fun buttonAt(index: Int): ImageView? = pill.getChildAt(index) as? ImageView

    fun clearButtons() = pill.removeAllViews()
}

/**
 * The Photos / Albums switch: a glass pill with one label per tab; the chosen tab is a lighter pill.
 * Labels are glyph outlines. [setTabs] draws the tabs, [select] changes the chosen one.
 */
class GlassTabs @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var labels: List<String> = emptyList()
    private var selected = 0
    private var onSelect: ((Int) -> Unit)? = null

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        background = GlassDrawable(context, 22f)
        val p = GlassUi.dp(context, 4f)
        setPadding(p, p, p, p)
    }

    fun setTabs(labels: List<String>, selected: Int, onSelect: (Int) -> Unit) {
        this.labels = labels
        this.onSelect = onSelect
        this.selected = selected.coerceIn(0, (labels.size - 1).coerceAtLeast(0))
        rebuild()
    }

    fun select(index: Int) {
        if (index == selected || index !in labels.indices) return
        selected = index
        rebuild()
    }

    val selectedIndex: Int get() = selected

    private fun rebuild() {
        removeAllViews()
        labels.forEachIndexed { index, text ->
            val on = index == selected
            val tab = ImageView(context).apply {
                setImageDrawable(VectorLabelDrawable(context, text, 0, textSizeDp = 14f))
                contentDescription = text
                isClickable = true
                isFocusable = true
                setPadding(GlassUi.dp(context, 18f), GlassUi.dp(context, 8f), GlassUi.dp(context, 18f), GlassUi.dp(context, 8f))
                alpha = if (on) 1f else 0.7f
                background = if (on) {
                    GradientDrawable().apply {
                        cornerRadius = GlassUi.dp(context, 18f).toFloat()
                        setColor(0x33FFFFFF)
                    }
                } else null
                setOnClickListener {
                    if (index != selected) {
                        select(index)
                        onSelect?.invoke(index)
                    }
                }
            }
            addView(tab, LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
    }
}

/**
 * "Are you sure?" as a glass sheet (built on [GlassSheet]): a confirm row with the action's icon and a cancel row.
 * Used before a photo or a selection is deleted.
 */
object GlassConfirm {
    fun show(
        activity: android.app.Activity,
        @DrawableRes confirmIcon: Int,
        confirmLabel: String,
        cancelLabel: String,
        onConfirm: () -> Unit
    ) {
        GlassSheet.show(
            activity,
            listOf(
                GlassSheet.Row(confirmIcon, confirmLabel, false),
                GlassSheet.Row(R.drawable.gl_ic_close, cancelLabel, false)
            )
        ) { index -> if (index == 0) onConfirm() }
    }
}
