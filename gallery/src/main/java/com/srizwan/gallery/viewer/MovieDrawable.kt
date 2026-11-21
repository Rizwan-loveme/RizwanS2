package com.srizwan.gallery.viewer

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Movie
import android.graphics.PixelFormat
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.SystemClock

/**
 * Animated GIF for Android 8 / 8.1 (API 26 / 27), where `AnimatedImageDrawable` does not exist yet: plays a
 * [Movie] frame by frame. Android 9+ uses `AnimatedImageDrawable` instead (see [ViewerLoader]). A Movie can only be
 * drawn on a software canvas, so [ZoomImageView] switches itself to a software layer while it shows one.
 */
@Suppress("DEPRECATION")
internal class MovieDrawable(private val movie: Movie) : Drawable(), Animatable {

    private var running = false
    private var startTime = 0L

    override fun getIntrinsicWidth(): Int = movie.width()

    override fun getIntrinsicHeight(): Int = movie.height()

    override fun draw(canvas: Canvas) {
        val w = movie.width()
        val h = movie.height()
        if (w <= 0 || h <= 0) return
        val duration = movie.duration().coerceAtLeast(1)
        val time = if (running) ((SystemClock.uptimeMillis() - startTime) % duration).toInt() else 0
        movie.setTime(time)
        val b = bounds
        val save = canvas.save()
        canvas.translate(b.left.toFloat(), b.top.toFloat())
        canvas.scale(b.width().toFloat() / w, b.height().toFloat() / h)
        movie.draw(canvas, 0f, 0f)
        canvas.restoreToCount(save)
        if (running) invalidateSelf() // next frame
    }

    override fun start() {
        if (running) return
        running = true
        startTime = SystemClock.uptimeMillis()
        invalidateSelf()
    }

    override fun stop() {
        running = false
    }

    override fun isRunning(): Boolean = running

    override fun setAlpha(alpha: Int) {
        // a Movie has no alpha control; the viewer does not fade a GIF
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        // not supported by Movie
    }

    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
}
