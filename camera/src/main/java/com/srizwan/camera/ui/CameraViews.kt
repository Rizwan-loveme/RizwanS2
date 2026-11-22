package com.srizwan.camera.ui

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlin.math.min

/** dp -> px. */
internal fun Context.cmDp(v: Float): Int = (v * resources.displayMetrics.density + 0.5f).toInt()

private const val WHITE_DIM = 0xB3FFFFFF.toInt()
private const val RED = 0xFFE5484D.toInt()
private const val ACCENT = 0xFFFFD34E.toInt()

/** A round glass button with one vector icon (back, flash, switch camera). */
internal fun glassIconButton(context: Context, @DrawableRes icon: Int, @StringRes description: Int, sizeDp: Float = 48f): ImageView =
    ImageView(context).apply {
        val pad = context.cmDp(sizeDp * 0.25f)
        setPadding(pad, pad, pad, pad)
        setImageResource(icon)
        scaleType = ImageView.ScaleType.FIT_CENTER
        background = GlassDrawable(context, sizeDp / 2f)
        contentDescription = context.getString(description)
        isClickable = true
        isFocusable = true
        layoutParams = ViewGroup.LayoutParams(context.cmDp(sizeDp), context.cmDp(sizeDp))
    }

/**
 * The big round shutter: a white ring with a white disc (photo), a red disc (video, ready) or a red rounded square
 * (video, recording). It shrinks a little while pressed.
 */
internal class ShutterButton(context: Context) : View(context) {

    enum class Style { PHOTO, VIDEO, RECORDING }

    var style: Style = Style.PHOTO
        set(value) {
            field = value
            invalidate()
        }

    private val ring = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        this.style = Paint.Style.STROKE
        strokeWidth = context.cmDp(4f).toFloat()
        color = Color.WHITE
    }
    private val fill = Paint(Paint.ANTI_ALIAS_FLAG).apply { this.style = Paint.Style.FILL }
    private val box = RectF()

    init {
        isClickable = true
        isFocusable = true
    }

    override fun dispatchSetPressed(pressed: Boolean) {
        super.dispatchSetPressed(pressed)
        animate().scaleX(if (pressed) 0.9f else 1f).scaleY(if (pressed) 0.9f else 1f).setDuration(90).start()
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        alpha = if (enabled) 1f else 0.35f
    }

    override fun onDraw(canvas: Canvas) {
        val cx = width / 2f
        val cy = height / 2f
        val r = min(width, height) / 2f
        canvas.drawCircle(cx, cy, r - ring.strokeWidth / 2f, ring)
        when (style) {
            Style.PHOTO -> {
                fill.color = Color.WHITE
                canvas.drawCircle(cx, cy, r * 0.78f, fill)
            }
            Style.VIDEO -> {
                fill.color = RED
                canvas.drawCircle(cx, cy, r * 0.78f, fill)
            }
            Style.RECORDING -> {
                fill.color = RED
                val h = r * 0.38f
                box.set(cx - h, cy - h, cx + h, cy + h)
                canvas.drawRoundRect(box, context.cmDp(6f).toFloat(), context.cmDp(6f).toFloat(), fill)
            }
        }
    }
}

/** The thin ring that appears where the preview was tapped to focus, then fades out. It never takes touches. */
internal class FocusRingView(context: Context) : View(context) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = context.cmDp(2f).toFloat()
        color = ACCENT
    }
    private var cx = 0f
    private var cy = 0f
    private var progress = 1f // 1 = finished (nothing drawn)
    private val animator = ValueAnimator.ofFloat(0f, 1f).apply {
        duration = 1000
        addUpdateListener {
            progress = it.animatedValue as Float
            invalidate()
        }
    }

    fun show(x: Float, y: Float) {
        cx = x
        cy = y
        animator.cancel()
        animator.start()
    }

    override fun onDraw(canvas: Canvas) {
        if (progress >= 1f) return
        val base = context.cmDp(34f)
        val radius = base * (1.35f - 0.35f * min(1f, progress * 4f))
        val alpha = if (progress < 0.7f) 1f else 1f - (progress - 0.7f) / 0.3f
        paint.alpha = (alpha * 255).toInt()
        canvas.drawCircle(cx, cy, radius, paint)
    }

    override fun onDetachedFromWindow() {
        animator.cancel()
        super.onDetachedFromWindow()
    }
}

/** Photo | video switch: a glass pill with two icons, the chosen one is lit. */
internal class ModePill(context: Context) : LinearLayout(context) {

    var onSelect: ((video: Boolean) -> Unit)? = null

    private val photo = item(com.srizwan.camera.R.drawable.cm_ic_photo, com.srizwan.camera.R.string.cm_cd_photo_mode)
    private val video = item(com.srizwan.camera.R.drawable.cm_ic_videocam, com.srizwan.camera.R.string.cm_cd_video_mode)

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        val pad = context.cmDp(4f)
        setPadding(pad, pad, pad, pad)
        background = GlassDrawable(context, 24f)
        addView(photo)
        addView(video)
        photo.setOnClickListener { onSelect?.invoke(false) }
        video.setOnClickListener { onSelect?.invoke(true) }
        select(false)
    }

    fun select(isVideo: Boolean) {
        style(photo, !isVideo)
        style(video, isVideo)
    }

    private fun style(view: ImageView, on: Boolean) {
        view.setColorFilter(if (on) ACCENT else WHITE_DIM)
        view.background = if (on) GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(0x40FFFFFF)
        } else null
        view.isSelected = on
    }

    private fun item(@DrawableRes icon: Int, @StringRes description: Int) = ImageView(context).apply {
        val pad = context.cmDp(10f)
        setPadding(pad, pad, pad, pad)
        setImageResource(icon)
        contentDescription = context.getString(description)
        isClickable = true
        isFocusable = true
        layoutParams = LayoutParams(context.cmDp(44f), context.cmDp(44f))
    }
}

/** Red dot + mm:ss, shown at the top while a video is recorded. Digits only (no text of its own). */
internal class TimerPill(context: Context) : LinearLayout(context) {

    private val label = TextView(context).apply {
        setTextColor(Color.WHITE)
        textSize = 15f
        typeface = android.graphics.Typeface.MONOSPACE
        text = format(0)
    }

    init {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        val h = context.cmDp(14f)
        val v = context.cmDp(8f)
        setPadding(h, v, h, v)
        background = GlassDrawable(context, 20f)
        contentDescription = context.getString(com.srizwan.camera.R.string.cm_cd_timer)
        val dot = View(context).apply {
            background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(RED)
            }
            layoutParams = LayoutParams(context.cmDp(9f), context.cmDp(9f)).apply { rightMargin = context.cmDp(8f) }
        }
        addView(dot)
        addView(label)
        visibility = GONE
    }

    fun setMillis(ms: Long) {
        label.text = format(ms)
    }

    private fun format(ms: Long): String {
        val total = ms / 1000
        val h = total / 3600
        val m = (total % 3600) / 60
        val s = total % 60
        return if (h > 0) "%d:%02d:%02d".format(h, m, s) else "%02d:%02d".format(m, s)
    }
}
