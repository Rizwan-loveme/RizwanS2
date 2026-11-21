package com.srizwan.YouTube.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.media3.common.C
import androidx.media3.common.Player
import com.srizwan.YouTube.R
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * The player controls of the YouTube app, used by the player screen and by the floating window.
 * Everything is a vector: play / pause, -10 s / +10 s, a seek bar, the position and duration (glyph outlines,
 * see [VectorLabelDrawable]) and the fullscreen button. There is no text view and no Media3 controller.
 *
 * [compact] (floating window): only the three centre buttons and a thin seek bar.
 * Touches on empty areas are NOT consumed, so the view below keeps its own gestures.
 */
class GlassControls @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val d = resources.displayMetrics.density
    private fun dp(v: Float) = (v * d).toInt()

    /** Small layout for the floating window. */
    var compact: Boolean = false
        set(value) {
            field = value
            applyCompact()
        }

    /** Called when the controls appear / disappear (the chips of the player screen follow it). */
    var onVisibilityChanged: ((Boolean) -> Unit)? = null

    /** The fullscreen button was tapped. */
    var onFullscreenClick: (() -> Unit)? = null

    private var player: Player? = null
    private var shownNow = true
    private var scrubbing = false
    private var lastPosSec = -1L
    private var lastDurSec = -2L

    private val rewind = iconButton(R.drawable.ic_seek_back)
    private val forward = iconButton(R.drawable.ic_seek_forward)
    private val playPause = iconButton(R.drawable.ic_play).apply {
        background = GlassDrawable(context, 40f, strong = true)
    }
    private val position = ImageView(context)
    private val duration = ImageView(context)
    private val fullscreen = iconButton(R.drawable.ic_fullscreen)
    private val seek = SeekLine(context)

    private val centre = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER
        addView(rewind)
        addView(playPause)
        addView(forward)
    }
    private val bottom = LinearLayout(context).apply {
        orientation = LinearLayout.HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        addView(position)
        addView(seek, LinearLayout.LayoutParams(0, dp(28f), 1f).apply {
            marginStart = dp(8f)
            marginEnd = dp(8f)
        })
        addView(duration)
        addView(fullscreen)
    }

    private val hideRunnable = Runnable { hide() }
    private val tick = object : Runnable {
        override fun run() {
            refreshProgress()
            if (shownNow && player != null) postDelayed(this, 250L)
        }
    }

    private val listener = object : Player.Listener {
        override fun onEvents(player: Player, events: Player.Events) {
            refreshState()
        }
    }

    init {
        // soft dark edges so the white icons read on any picture
        background = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(0x66000000, 0x00000000, 0x00000000, 0xB3000000.toInt())
        )
        addView(centre, LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER))
        addView(bottom, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, Gravity.BOTTOM))

        fullscreen.setPadding(dp(8f), dp(8f), dp(8f), dp(8f))
        rewind.contentDescription = context.getString(R.string.yt_cd_rewind)
        forward.contentDescription = context.getString(R.string.yt_cd_forward)
        fullscreen.contentDescription = context.getString(R.string.yt_cd_fullscreen)
        rewind.setOnClickListener { seekBy(-SEEK_MS) }
        forward.setOnClickListener { seekBy(SEEK_MS) }
        playPause.setOnClickListener { togglePlay() }
        fullscreen.setOnClickListener { onFullscreenClick?.invoke() }
        seek.onScrub = { fraction, finished -> onScrub(fraction, finished) }
        applyCompact()
        refreshState()
    }

    // ---- public ----

    /** Connects the controls to [p] (or disconnects with null). */
    fun bind(p: Player?) {
        if (player === p) {
            if (p != null) show()
            return
        }
        player?.removeListener(listener)
        removeCallbacks(tick)
        player = p
        p?.addListener(listener)
        lastPosSec = -1L
        lastDurSec = -2L
        refreshState()
        refreshProgress()
        if (p != null) show() else removeCallbacks(hideRunnable)
    }

    val isOpen: Boolean get() = shownNow

    fun toggle() = if (shownNow) hide() else show()

    fun show() {
        shownNow = true
        animate().cancel()
        if (visibility != VISIBLE) {
            alpha = 0f
            visibility = VISIBLE
        }
        animate().alpha(1f).setDuration(140L).start()
        removeCallbacks(tick)
        post(tick)
        scheduleHide()
        onVisibilityChanged?.invoke(true)
    }

    fun hide() {
        if (scrubbing) return
        shownNow = false
        removeCallbacks(hideRunnable)
        removeCallbacks(tick)
        animate().cancel()
        animate().alpha(0f).setDuration(140L).withEndAction { if (!shownNow) visibility = GONE }.start()
        onVisibilityChanged?.invoke(false)
    }

    fun setFullscreen(on: Boolean) {
        fullscreen.setImageDrawable(
            VectorLabelDrawable(context, null, if (on) R.drawable.ic_fullscreen_exit else R.drawable.ic_fullscreen, iconSizeDp = 26f)
        )
    }

    // ---- internals ----

    private fun applyCompact() {
        val big = if (compact) 36f else 48f
        val bigPlay = if (compact) 48f else 64f
        setSize(rewind, big)
        setSize(forward, big)
        setSize(playPause, bigPlay)
        val vis = if (compact) GONE else VISIBLE
        position.visibility = vis
        duration.visibility = vis
        fullscreen.visibility = vis
        val pad = if (compact) dp(6f) else dp(12f)
        bottom.setPadding(pad, 0, pad, if (compact) dp(4f) else dp(10f))
        seek.compact = compact
        refreshState()
    }

    private fun setSize(v: View, sizeDp: Float) {
        val lp = (v.layoutParams as? LinearLayout.LayoutParams) ?: LinearLayout.LayoutParams(0, 0)
        lp.width = dp(sizeDp)
        lp.height = dp(sizeDp)
        lp.marginStart = dp(if (compact) 6f else 14f)
        lp.marginEnd = dp(if (compact) 6f else 14f)
        v.layoutParams = lp
        v.setPadding(dp(sizeDp * 0.22f), dp(sizeDp * 0.22f), dp(sizeDp * 0.22f), dp(sizeDp * 0.22f))
    }

    private fun iconButton(res: Int): ImageView = ImageView(context).apply {
        scaleType = ImageView.ScaleType.FIT_CENTER
        setImageDrawable(ContextCompat.getDrawable(context, res))
        isClickable = true
        isFocusable = true
        borderless(context)?.let { foreground = it }
    }

    private fun borderless(c: Context): Drawable? = TypedValue().let { tv ->
        if (c.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, tv, true) && tv.resourceId != 0) {
            ContextCompat.getDrawable(c, tv.resourceId)
        } else null
    }

    private fun refreshState() {
        val p = player
        val ended = p != null && p.playbackState == Player.STATE_ENDED
        val playing = p != null && p.playWhenReady && !ended
        val res = when {
            ended -> R.drawable.ic_retry
            playing -> R.drawable.ic_pause
            else -> R.drawable.ic_play
        }
        playPause.setImageDrawable(ContextCompat.getDrawable(context, res))
        playPause.contentDescription = context.getString(if (playing) R.string.yt_cd_pause else R.string.yt_cd_play)
        if (playing) scheduleHide() else removeCallbacks(hideRunnable)
    }

    private fun scheduleHide() {
        removeCallbacks(hideRunnable)
        val p = player
        if (shownNow && !scrubbing && p != null && p.playWhenReady && p.playbackState != Player.STATE_ENDED) {
            postDelayed(hideRunnable, AUTO_HIDE_MS)
        }
    }

    private fun togglePlay() {
        val p = player ?: return
        if (p.playbackState == Player.STATE_ENDED) {
            p.seekTo(0L)
            p.play()
        } else if (p.playWhenReady) {
            p.pause()
        } else {
            p.play()
        }
        scheduleHide()
    }

    private fun seekBy(deltaMs: Long) {
        val p = player ?: return
        if (!p.isCommandAvailable(Player.COMMAND_SEEK_IN_CURRENT_MEDIA_ITEM)) return
        var target = p.currentPosition + deltaMs
        val dur = p.duration
        if (dur != C.TIME_UNSET) target = min(target, dur)
        p.seekTo(max(0L, target))
        scheduleHide()
    }

    private fun onScrub(fraction: Float, finished: Boolean) {
        val p = player ?: return
        val dur = p.duration
        if (dur == C.TIME_UNSET || dur <= 0L) return
        scrubbing = !finished
        val target = (dur * fraction).toLong()
        setTimeLabel(position, target, true)
        if (finished) {
            p.seekTo(target)
            scheduleHide()
        } else {
            removeCallbacks(hideRunnable)
        }
    }

    private fun refreshProgress() {
        val p = player
        if (p == null) {
            seek.set(0f, 0f)
            return
        }
        val dur = p.duration
        if (dur == C.TIME_UNSET || dur <= 0L) {
            seek.set(0f, 0f)
            if (lastDurSec != -1L) {
                duration.setImageDrawable(null)
                lastDurSec = -1L
            }
            return
        }
        if (!scrubbing) {
            seek.set(p.currentPosition.toFloat() / dur, p.bufferedPosition.toFloat() / dur)
            if (!compact) setTimeLabel(position, p.currentPosition, false)
        }
        if (!compact && lastDurSec != dur / 1000) {
            lastDurSec = dur / 1000
            duration.setImageDrawable(VectorLabelDrawable(context, formatTime(dur), 0, textSizeDp = 12f))
        }
    }

    private fun setTimeLabel(view: ImageView, ms: Long, force: Boolean) {
        val sec = ms / 1000
        if (!force && sec == lastPosSec) return
        lastPosSec = sec
        view.setImageDrawable(VectorLabelDrawable(context, formatTime(ms), 0, textSizeDp = 12f))
    }

    override fun onDetachedFromWindow() {
        removeCallbacks(tick)
        removeCallbacks(hideRunnable)
        super.onDetachedFromWindow()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (shownNow && player != null) {
            removeCallbacks(tick)
            post(tick)
            scheduleHide()
        }
    }

    /** The seek bar: track, buffered part, played part and a round thumb. Drawn, not widget text. */
    private class SeekLine(context: Context) : View(context) {
        var onScrub: ((Float, Boolean) -> Unit)? = null
        var compact = false
        private var played = 0f
        private var buffered = 0f
        private var dragging = false
        private val density = resources.displayMetrics.density
        private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private val red = ContextCompat.getColor(context, R.color.yt_red)

        fun set(playedFraction: Float, bufferedFraction: Float) {
            if (dragging) return
            played = playedFraction.coerceIn(0f, 1f)
            buffered = bufferedFraction.coerceIn(0f, 1f)
            invalidate()
        }

        override fun onDraw(canvas: Canvas) {
            val h = if (dragging) 5 * density else 3 * density
            val cy = height / 2f
            val left = paddingLeft + 6 * density
            val right = width - paddingRight - 6 * density
            val w = right - left
            paint.style = Paint.Style.FILL
            paint.strokeCap = Paint.Cap.ROUND
            fun bar(to: Float, color: Int) {
                paint.color = color
                canvas.drawRoundRect(left, cy - h / 2, left + max(to, 0f), cy + h / 2, h / 2, h / 2, paint)
            }
            bar(w, Color.argb(70, 255, 255, 255))
            bar(w * buffered, Color.argb(120, 255, 255, 255))
            bar(w * played, red)
            if (!compact || dragging) {
                paint.color = red
                canvas.drawCircle(left + w * played, cy, (if (dragging) 8 else 6) * density, paint)
            }
        }

        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            setMeasuredDimension(
                resolveSize((100 * density).toInt(), widthMeasureSpec),
                resolveSize((28 * density).toInt(), heightMeasureSpec)
            )
        }

        @SuppressLint("ClickableViewAccessibility")
        override fun onTouchEvent(e: MotionEvent): Boolean {
            val left = paddingLeft + 6 * density
            val w = (width - paddingRight - 6 * density - left).coerceAtLeast(1f)
            val fraction = ((e.x - left) / w).coerceIn(0f, 1f)
            when (e.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    parent?.requestDisallowInterceptTouchEvent(true)
                    dragging = true
                    played = fraction
                    invalidate()
                    onScrub?.invoke(fraction, false)
                }
                MotionEvent.ACTION_MOVE -> {
                    played = fraction
                    invalidate()
                    onScrub?.invoke(fraction, false)
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    played = fraction
                    dragging = false
                    invalidate()
                    onScrub?.invoke(fraction, true)
                }
            }
            return true
        }
    }

    private companion object {
        const val SEEK_MS = 10_000L
        const val AUTO_HIDE_MS = 3_000L

        /** 754000 -> "12:34", 3723000 -> "1:02:03" */
        fun formatTime(ms: Long): String {
            val total = max(0L, ms) / 1000
            val h = total / 3600
            val m = (total % 3600) / 60
            val s = total % 60
            return if (h > 0) String.format(java.util.Locale.US, "%d:%02d:%02d", h, m, s)
            else String.format(java.util.Locale.US, "%d:%02d", m, s)
        }
    }
}
