package com.srizwan.gallery.home

import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.gallery.ui.GlassUi
import kotlin.math.abs

/**
 * Drag to select (step 9). After a long press started a selection ([SelectionController.onLongPress]) the finger may stay
 * down and slide over more pictures: this listener takes the gesture over from the cell and reports the picture under the
 * finger ([SelectionController.dragTo]). Near the top or bottom edge of the list the grid scrolls by itself, faster the
 * closer the finger is to the edge. A new touch (ACTION_DOWN), a lift or a cancel ends the drag.
 */
internal class DragSelectListener(
    private val controller: SelectionController
) : RecyclerView.OnItemTouchListener {

    private var list: RecyclerView? = null
    private var lastX = 0f
    private var lastY = 0f
    private var scrolling = false

    private val autoScroll = object : Runnable {
        override fun run() {
            val rv = list ?: return
            if (!controller.dragging) {
                scrolling = false
                return
            }
            val zone = GlassUi.dp(rv.context, 72f).toFloat()
            val topLimit = rv.paddingTop + zone
            val bottomLimit = rv.height - zone
            val maxStep = GlassUi.dp(rv.context, 18f).toFloat()
            val dy = when {
                lastY < topLimit -> -maxStep * ((topLimit - lastY) / zone).coerceIn(0.1f, 1f)
                lastY > bottomLimit -> maxStep * ((lastY - bottomLimit) / zone).coerceIn(0.1f, 1f)
                else -> 0f
            }
            if (abs(dy) < 1f) {
                scrolling = false
                return
            }
            rv.scrollBy(0, dy.toInt())
            controller.dragTo(indexAt(rv, lastX, lastY)) // the picture under the finger changed by scrolling
            rv.postOnAnimation(this)
        }
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        list = rv
        return when (e.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                controller.endDrag() // a new touch: a drag that never got its lift is over
                false
            }
            MotionEvent.ACTION_MOVE -> {
                if (controller.dragging && e.pointerCount == 1) {
                    follow(rv, e)
                    true // the cell gets a cancel, this listener gets the rest of the gesture
                } else false
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                controller.endDrag()
                false
            }
            else -> false
        }
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        when (e.actionMasked) {
            MotionEvent.ACTION_MOVE -> follow(rv, e)
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                controller.endDrag()
                rv.removeCallbacks(autoScroll)
                scrolling = false
            }
        }
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}

    private fun follow(rv: RecyclerView, e: MotionEvent) {
        lastX = e.x
        lastY = e.y
        controller.dragTo(indexAt(rv, e.x, e.y))
        if (!scrolling) {
            scrolling = true
            rv.postOnAnimation(autoScroll)
        }
    }

    private fun indexAt(rv: RecyclerView, x: Float, y: Float): Int {
        val child = rv.findChildViewUnder(x, y) ?: return -1
        val position = rv.getChildAdapterPosition(child)
        return if (position == RecyclerView.NO_POSITION) -1 else controller.photoIndexAt(position)
    }
}
