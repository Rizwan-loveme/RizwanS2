package com.srizwan.YouTube.player

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.media.AudioManager
import android.provider.Settings
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.media3.common.C
import androidx.media3.common.Player
import com.srizwan.YouTube.R
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.VectorLabelDrawable
import kotlin.math.abs

/**
 * Touch gestures of the player screen (part 8). Attach it to the player view with [attach].
 *
 *  - double tap on the left / right side: back / forward 10 s; more taps in a row go on (-20 s, -30 s ...)
 *  - double tap in the middle: play / pause
 *  - swipe up / down on the right half: volume, on the left half: screen brightness
 *  - single tap: show / hide the controls (what the player view did by itself before)
 *
 * Touches on the controls (buttons, seek bar, chips) never reach it, they handle themselves.
 * Swipes that start at the very edge of the screen are left to the system back gesture.
 */
class PlayerGestures(
    private val activity: Activity,
    private val touchView: View,
    private val hint: ImageView,
    private val seekBackHint: ImageView,
    private val seekForwardHint: ImageView,
    private val player: () -> Player?,
    private val toggleControls: () -> Unit
) {
    private val audio = activity.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private val edgePx = 24f * activity.resources.displayMetrics.density

    private enum class Mode { NONE, VOLUME, BRIGHTNESS, IGNORED }

    private var mode = Mode.NONE
    private var downX = 0f
    private var downY = 0f
    private var startFraction = 0f

    // seek chain: taps that follow a double tap within CHAIN_MS go on seeking the same way
    private var lastSeekAt = 0L
    private var lastDirection = 0
    private var seekTotalMs = 0L

    private val detector = GestureDetector(activity, object : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            mode = Mode.NONE
            downX = e.x
            downY = e.y
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            val dir = sideOf(e.x)
            if (dir != 0 && inChain(dir)) seek(dir) else toggleControls()
            return true
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            val dir = sideOf(e.x)
            if (dir != 0) seek(dir) else togglePlay()
            return true
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
            if (mode == Mode.IGNORED) return true
            if (mode == Mode.NONE) {
                val dx = e2.x - downX
                val dy = e2.y - downY
                // mostly sideways, or started at the screen edge (system back gesture): not ours
                val atEdge = downX < edgePx || downX > touchView.width - edgePx
                if (atEdge || abs(dx) > abs(dy)) {
                    mode = Mode.IGNORED
                    return true
                }
                if (downX > touchView.width / 2f) {
                    mode = Mode.VOLUME
                    startFraction = volumeFraction()
                } else {
                    mode = Mode.BRIGHTNESS
                    startFraction = brightnessFraction()
                }
            }
            // a swipe over 70% of the view height = the whole range
            val fraction = (startFraction + (downY - e2.y) / (touchView.height * 0.7f)).coerceIn(0f, 1f)
            if (mode == Mode.VOLUME) setVolume(fraction) else setBrightness(fraction)
            return true
        }
    }).apply { setIsLongpressEnabled(false) }

    @SuppressLint("ClickableViewAccessibility")
    fun attach() {
        touchView.setOnTouchListener { _, event ->
            detector.onTouchEvent(event)
            true
        }
    }

    // ---- double tap ----

    /** -1 = left 40%, +1 = right 40%, 0 = the middle */
    private fun sideOf(x: Float): Int {
        val w = touchView.width.toFloat()
        return when {
            x < w * 0.4f -> -1
            x > w * 0.6f -> 1
            else -> 0
        }
    }

    private fun inChain(dir: Int): Boolean =
        dir == lastDirection && android.os.SystemClock.uptimeMillis() - lastSeekAt <= CHAIN_MS

    private fun seek(dir: Int) {
        val p = player() ?: return
        if (!p.isCommandAvailable(Player.COMMAND_SEEK_IN_CURRENT_MEDIA_ITEM)) return
        val now = android.os.SystemClock.uptimeMillis()
        if (dir != lastDirection || now - lastSeekAt > CHAIN_MS) seekTotalMs = 0L
        lastDirection = dir
        lastSeekAt = now
        seekTotalMs += SEEK_MS
        var target = p.currentPosition + dir * SEEK_MS
        val d = p.duration
        if (d != C.TIME_UNSET) target = target.coerceAtMost(d)
        p.seekTo(target.coerceAtLeast(0L))
        val view = if (dir < 0) seekBackHint else seekForwardHint
        // vector icon + the seconds as glyph outlines
        view.setImageDrawable(
            VectorLabelDrawable(
                activity, "${seekTotalMs / 1000}s",
                if (dir < 0) R.drawable.ic_seek_back else R.drawable.ic_seek_forward,
                textSizeDp = 16f, iconSizeDp = 24f
            )
        )
        flash(view)
    }

    private fun togglePlay() {
        val p = player() ?: return
        if (p.playWhenReady && p.playbackState != Player.STATE_ENDED) {
            p.pause()
        } else {
            if (p.playbackState == Player.STATE_ENDED) p.seekTo(0)
            p.play()
        }
    }

    // ---- volume / brightness ----

    private fun volumeFraction(): Float {
        val max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC).coerceAtLeast(1)
        return audio.getStreamVolume(AudioManager.STREAM_MUSIC) / max.toFloat()
    }

    private fun setVolume(fraction: Float) {
        val max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC).coerceAtLeast(1)
        val index = Math.round(fraction * max)
        runCatching { audio.setStreamVolume(AudioManager.STREAM_MUSIC, index, 0) }
        hint.setImageDrawable(
            VectorLabelDrawable(activity, "${Math.round(index * 100f / max)}%", R.drawable.ic_volume, textSizeDp = 16f, iconSizeDp = 24f)
        )
        flash(hint)
    }

    private fun brightnessFraction(): Float {
        val current = activity.window.attributes.screenBrightness
        if (current >= 0f) return current
        // still "follow the system": start from the system value
        val system = runCatching {
            Settings.System.getInt(activity.contentResolver, Settings.System.SCREEN_BRIGHTNESS)
        }.getOrDefault(128)
        return (system / 255f).coerceIn(0f, 1f)
    }

    private fun setBrightness(fraction: Float) {
        // 0 would switch the screen off on some phones: keep a faint minimum
        val value = fraction.coerceIn(0.02f, 1f)
        val lp = activity.window.attributes
        lp.screenBrightness = value
        activity.window.attributes = lp
        hint.setImageDrawable(
            VectorLabelDrawable(activity, "${Math.round(value * 100f)}%", R.drawable.ic_brightness, textSizeDp = 16f, iconSizeDp = 24f)
        )
        flash(hint)
    }

    // ---- feedback ----

    /** Shows [v] and fades it out shortly after the last update. */
    private fun flash(v: ImageView) {
        if (v.background == null) v.background = GlassDrawable(activity, 18f)
        v.animate().cancel()
        v.alpha = 1f
        v.visibility = View.VISIBLE
        v.animate().alpha(0f).setStartDelay(HINT_MS).setDuration(200L)
            .withEndAction { v.visibility = View.GONE }
    }

    private companion object {
        const val SEEK_MS = 10_000L
        const val CHAIN_MS = 700L
        const val HINT_MS = 600L
    }
}
