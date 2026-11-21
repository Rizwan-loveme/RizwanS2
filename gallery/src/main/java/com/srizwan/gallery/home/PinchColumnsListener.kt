package com.srizwan.gallery.home

import android.content.Context
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import androidx.recyclerview.widget.RecyclerView

/**
 * Pinch on the Photos grid changes the number of columns: spread the fingers = bigger pictures = fewer columns,
 * pinch together = more columns. Each step needs a clear scale change (about 30 %), so a slight twitch does nothing.
 * Normal one-finger scrolling is not touched: the gesture is only taken over once two fingers are scaling.
 */
internal class PinchColumnsListener(
    context: Context,
    private val currentColumns: () -> Int,
    private val onColumns: (Int) -> Unit,
    private val min: Int,
    private val max: Int
) : RecyclerView.OnItemTouchListener {

    private var accumulated = 1f

    private val detector = ScaleGestureDetector(context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            accumulated = 1f
            return true
        }

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            accumulated *= detector.scaleFactor
            val now = currentColumns()
            if (accumulated > STEP_OUT) {
                accumulated = 1f
                if (now > min) onColumns(now - 1)
            } else if (accumulated < STEP_IN) {
                accumulated = 1f
                if (now < max) onColumns(now + 1)
            }
            return true
        }
    }).apply { isQuickScaleEnabled = false }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        detector.onTouchEvent(e)
        return detector.isInProgress
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        detector.onTouchEvent(e)
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}

    private companion object {
        const val STEP_OUT = 1.3f
        const val STEP_IN = 0.77f
    }
}
