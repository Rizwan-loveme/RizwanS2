package com.srizwan.video.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

/**
 * Multi-line text that is pure vector, in the spirit of [VectorLabelDrawable]: every line is drawn as glyph
 * OUTLINES (`Paint.getTextPath`), so there is no TextView in the Video app. It wraps at spaces for the width
 * it is given, stops after [set]'s `maxLines` and ends the last line with an ellipsis.
 *
 * Used for video titles and the meta line of the feed cards. Give it a fixed or match-parent width.
 */
class VectorText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val d = resources.displayMetrics.density
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL }
    private var text = ""
    private var maxLines = 1
    private var lineHeight = 0f
    private var ascent = 0f
    private val lines = ArrayList<Path>()
    private var laidOutWidth = -1

    fun set(text: String, sizeDp: Float, color: Int, bold: Boolean = false, maxLines: Int = 1) {
        this.text = text.replace('\n', ' ').trim()
        this.maxLines = maxLines.coerceAtLeast(1)
        paint.textSize = sizeDp * d
        paint.color = color
        paint.typeface = if (bold) Typeface.create(Typeface.DEFAULT, Typeface.BOLD) else Typeface.DEFAULT
        val fm = paint.fontMetrics
        ascent = -fm.ascent
        lineHeight = (fm.descent - fm.ascent) * 1.12f
        laidOutWidth = -1
        contentDescription = this.text
        requestLayout()
        invalidate()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val w = MeasureSpec.getSize(widthMeasureSpec)
        layoutLines((w - paddingLeft - paddingRight).coerceAtLeast(0))
        val h = (lines.size * lineHeight).toInt() + paddingTop + paddingBottom
        setMeasuredDimension(w, resolveSize(h, heightMeasureSpec))
    }

    private fun addLine(s: String) {
        val p = Path()
        paint.getTextPath(s, 0, s.length, 0f, 0f, p)
        lines.add(p)
    }

    private fun layoutLines(avail: Int) {
        if (avail == laidOutWidth) return
        laidOutWidth = avail
        lines.clear()
        if (avail <= 0 || text.isEmpty()) return
        val n = text.length
        var start = 0
        while (start < n && lines.size < maxLines) {
            while (start < n && text[start] == ' ') start++
            if (start >= n) break
            val lastLine = lines.size == maxLines - 1
            val fit = paint.breakText(text, start, n, true, avail.toFloat(), null).coerceAtLeast(1)
            var end = start + fit
            if (end >= n) { // the rest fits on this line
                addLine(text.substring(start, n))
                break
            }
            if (lastLine) { // more text than lines: cut and add an ellipsis
                val ell = "\u2026"
                val room = (avail - paint.measureText(ell)).coerceAtLeast(0f)
                var e = start + paint.breakText(text, start, n, true, room, null).coerceAtLeast(1)
                while (e > start && text[e - 1] == ' ') e--
                addLine(text.substring(start, e) + ell)
                break
            }
            if (text[end] != ' ') { // break at the last space of the line when there is one
                val sp = text.lastIndexOf(' ', end - 1)
                if (sp > start) end = sp
            }
            addLine(text.substring(start, end).trimEnd())
            start = end
        }
    }

    override fun onDraw(canvas: Canvas) {
        for ((i, p) in lines.withIndex()) {
            val save = canvas.save()
            canvas.translate(paddingLeft.toFloat(), paddingTop + ascent + i * lineHeight)
            canvas.drawPath(p, paint)
            canvas.restoreToCount(save)
        }
    }
}
