package com.srizwan.chooser.ui

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R

/**
 * An on / off switch for the settings screen (step 11): a glass track with a round knob that slides. Off is a dim track, on is the
 * accent colour. No text: the row it sits in carries the label. A tap toggles it and calls [onChange] with the new state;
 * [setOn] changes it from code (without the call, unless [notify] is true).
 */
class GlassSwitch(context: Context) : View(context) {

    var onChange: ((Boolean) -> Unit)? = null
    var isOn: Boolean = false
        private set

    private val d = resources.displayMetrics.density
    private val accent = ContextCompat.getColor(context, R.color.ch_accent)
    private val offColor = 0x33FFFFFF
    private val onColor = (accent and 0x00FFFFFF) or 0x99000000.toInt()
    private val trackPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private val rimPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 1.2f * d
    }
    private val knobPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.WHITE }
    private val rect = RectF()
    private val evaluator = ArgbEvaluator()
    private var pos = 0f // 0 = off, 1 = on (animated in between)
    private var animator: ValueAnimator? = null

    init {
        isClickable = true
        isFocusable = true
        setOnClickListener { toggle() }
    }

    fun toggle() = setOn(!isOn, notify = true)

    fun setOn(on: Boolean, notify: Boolean = false, animate: Boolean = isAttachedToWindow) {
        if (on == isOn) return
        isOn = on
        animator?.cancel()
        if (animate) {
            animator = ValueAnimator.ofFloat(pos, if (on) 1f else 0f).apply {
                duration = 160L
                addUpdateListener {
                    pos = it.animatedValue as Float
                    invalidate()
                }
                start()
            }
        } else {
            pos = if (on) 1f else 0f
            invalidate()
        }
        if (notify) onChange?.invoke(on)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension((52 * d).toInt(), (30 * d).toInt())
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator?.cancel()
        pos = if (isOn) 1f else 0f
    }

    override fun onDraw(canvas: Canvas) {
        val w = width.toFloat()
        val h = height.toFloat()
        val inset = rimPaint.strokeWidth / 2f
        rect.set(inset, inset, w - inset, h - inset)
        trackPaint.color = evaluator.evaluate(pos, offColor, onColor) as Int
        rimPaint.color = evaluator.evaluate(pos, 0x40FFFFFF, accent) as Int
        canvas.drawRoundRect(rect, h / 2f, h / 2f, trackPaint)
        canvas.drawRoundRect(rect, h / 2f, h / 2f, rimPaint)
        val r = h / 2f - 5f * d
        val travel = w - h
        val cx = h / 2f + travel * pos
        canvas.drawCircle(cx, h / 2f, r, knobPaint)
    }
}
