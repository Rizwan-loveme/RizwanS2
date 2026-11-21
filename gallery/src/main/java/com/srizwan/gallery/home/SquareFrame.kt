package com.srizwan.gallery.home

import android.content.Context
import android.widget.FrameLayout

/** A FrameLayout that is always as tall as it is wide: the cell of the photo grid and the cover of an album card. */
internal class SquareFrame(context: Context) : FrameLayout(context) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}
