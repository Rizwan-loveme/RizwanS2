@file:androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)

package com.srizwan.YouTube.player

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Outline
import android.graphics.PixelFormat
import android.provider.Settings
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewOutlineProvider
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.VideoSize
import com.srizwan.YouTube.R
import com.srizwan.YouTube.databinding.FloatPlayerBinding
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.GlassToast
import com.srizwan.YouTube.ui.VectorLabelDrawable
import kotlin.math.abs

/**
 * The floating popup player. It replaces picture-in-picture: the video of the shared [YtPlayer] appears in a
 * small glass window over ANY app (it slides in from the top like a heads-up notification), and shows only the
 * picture, the compact controls and a cross that closes it (and ends the video).
 *
 *  - drag the window anywhere; pinch to resize it (the shape follows the video: wide, square or tall)
 *  - tap the picture to show / hide the controls
 *  - the cross stops the video and removes the window; it appears with the controls and fades out with them
 *
 * It needs "Display over other apps" ([canDraw]). The player screen calls [show]; opening the player screen
 * again calls [hide], which gives the picture back without stopping anything.
 */
object FloatingPlayer {

    private var binding: FloatPlayerBinding? = null
    private var windowManager: WindowManager? = null
    private var params: WindowManager.LayoutParams? = null
    private var themed: Context? = null
    private var attachedPlayer: Player? = null

    private var contentWidth = 0
    private var ratio = 16f / 9f
    private var slide: ValueAnimator? = null
    private var moved = false

    val isShowing: Boolean get() = binding != null

    fun canDraw(context: Context): Boolean = Settings.canDrawOverlays(context)

    private val playerListener = object : Player.Listener {
        override fun onVideoSizeChanged(videoSize: VideoSize) {
            val r = ratioOf(videoSize) ?: return
            if (abs(r - ratio) > 0.01f) {
                ratio = r
                applySize()
            }
        }

        override fun onPlayerError(error: PlaybackException) {
            themed?.let { GlassToast.show(it, R.drawable.ic_error) }
        }
    }

    /** Shows the window. Returns false when it could not (no player, no permission). */
    fun show(context: Context): Boolean {
        if (binding != null) return true
        val app = context.applicationContext
        val player = YtPlayer.peek() ?: return false
        if (!canDraw(app)) return false
        return try {
            showNow(app, player)
            true
        } catch (e: Throwable) {
            android.util.Log.w("FloatingPlayer", "cannot show", e)
            hide()
            false
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun showNow(app: Context, player: Player) {
        val ctx = ContextThemeWrapper(app, R.style.Theme_YouTube)
        themed = ctx
        val b = FloatPlayerBinding.inflate(LayoutInflater.from(ctx))
        val density = app.resources.displayMetrics.density
        val dm = app.resources.displayMetrics

        b.floatRoot.background = GlassDrawable(ctx, 22f)
        b.floatClip.clipToOutline = true
        b.floatClip.outlineProvider = object : ViewOutlineProvider() {
            override fun getOutline(view: View, outline: Outline) {
                outline.setRoundRect(0, 0, view.width, view.height, 20f * density)
            }
        }
        b.floatClose.background = GlassDrawable(ctx, 20f, strong = true)
        b.floatClose.setImageDrawable(VectorLabelDrawable(ctx, null, R.drawable.ic_close, iconSizeDp = 18f))
        b.floatClose.setOnClickListener { close() }
        // the cross follows the controls: it fades in with a touch and fades out with them after a few seconds
        b.floatControls.onVisibilityChanged = { visible -> setCloseVisible(b, visible) }

        YtPlayer.setVideoEnabled(true)
        b.floatPlayer.player = player
        b.floatControls.compact = true
        b.floatControls.bind(player)
        setCloseVisible(b, b.floatControls.isOpen, animate = false)
        player.addListener(playerListener)
        attachedPlayer = player

        ratio = ratioOf(player.videoSize) ?: (16f / 9f)
        contentWidth = minOf((dm.widthPixels * 0.72f).toInt(), (360 * density).toInt())
        val (w, h) = windowSize()
        val lp = WindowManager.LayoutParams(
            w, h,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS or
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = (dm.widthPixels - w) / 2
            y = -h // starts above the screen and slides down
        }
        val wm = app.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.addView(b.root, lp)
        windowManager = wm
        params = lp
        binding = b
        YtPlayer.floating = true

        attachTouch(b, ctx)

        // slide in from the top, like a heads-up notification
        val targetY = statusBarHeight(app) + (12 * density).toInt()
        slide = ValueAnimator.ofInt(-h, targetY).apply {
            duration = 280L
            interpolator = DecelerateInterpolator()
            addUpdateListener {
                val l = params ?: return@addUpdateListener
                l.y = it.animatedValue as Int
                updateLayout()
            }
            start()
        }
    }

    /** The window goes away; the video keeps playing (the player screen takes it over). */
    fun hide() {
        slide?.cancel()
        slide = null
        val b = binding
        binding = null
        YtPlayer.floating = false
        attachedPlayer?.removeListener(playerListener)
        attachedPlayer = null
        if (b != null) {
            b.floatControls.onVisibilityChanged = null
            b.floatClose.animate().cancel()
            b.floatControls.bind(null)
            b.floatPlayer.player = null
            runCatching { windowManager?.removeViewImmediate(b.root) }
        }
        windowManager = null
        params = null
        themed = null
    }

    /** The cross: the window goes away and the video stops. */
    fun close() {
        hide()
        YtPlayer.release()
    }

    /**
     * Shows / hides the cross together with the controls. While it is hidden it is INVISIBLE (not just
     * transparent), so a touch on that spot reaches the window and brings the controls (and the cross) back.
     */
    private fun setCloseVisible(b: FloatPlayerBinding, visible: Boolean, animate: Boolean = true) {
        val v = b.floatClose
        v.animate().cancel()
        if (!animate) {
            v.alpha = if (visible) 1f else 0f
            v.visibility = if (visible) View.VISIBLE else View.INVISIBLE
            return
        }
        if (visible) {
            v.visibility = View.VISIBLE
            v.animate().alpha(1f).setDuration(140L).start()
        } else {
            v.animate().alpha(0f).setDuration(140L).withEndAction {
                if (b.floatControls.isOpen.not()) v.visibility = View.INVISIBLE
            }.start()
        }
    }

    // ---- touch: drag, pinch, tap ----

    @SuppressLint("ClickableViewAccessibility")
    private fun attachTouch(b: FloatPlayerBinding, ctx: Context) {
        val slop = ViewConfiguration.get(ctx).scaledTouchSlop
        var downRawX = 0f
        var downRawY = 0f
        var startX = 0
        var startY = 0
        var pinched = false
        val scale = ScaleGestureDetector(ctx, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector): Boolean {
                pinched = true
                contentWidth = (contentWidth * detector.scaleFactor).toInt()
                applySize()
                return true
            }
        })
        b.floatRoot.setOnTouchListener { _, e ->
            scale.onTouchEvent(e)
            if (scale.isInProgress) return@setOnTouchListener true
            val lp = params ?: return@setOnTouchListener false
            when (e.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    slide?.cancel()
                    downRawX = e.rawX
                    downRawY = e.rawY
                    startX = lp.x
                    startY = lp.y
                    moved = false
                    pinched = false
                }
                MotionEvent.ACTION_MOVE -> if (e.pointerCount == 1 && !pinched) {
                    val dx = e.rawX - downRawX
                    val dy = e.rawY - downRawY
                    if (abs(dx) > slop || abs(dy) > slop) moved = true
                    if (moved) {
                        lp.x = startX + dx.toInt()
                        lp.y = startY + dy.toInt()
                        clampToScreen()
                        updateLayout()
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (!moved && !pinched) b.floatControls.toggle()
                }
            }
            true
        }
    }

    // ---- size ----

    private fun ratioOf(size: VideoSize): Float? {
        if (size.width <= 0 || size.height <= 0) return null
        return (size.width * size.pixelWidthHeightRatio / size.height).coerceIn(0.42f, 2.4f)
    }

    /** Window size (picture + the 2 dp glass frame) for the current width and the video's shape. */
    private fun windowSize(): Pair<Int, Int> {
        val ctx = themed ?: return 0 to 0
        val dm = ctx.resources.displayMetrics
        val density = dm.density
        val minW = (120 * density).toInt()
        val maxW = (dm.widthPixels * 0.95f).toInt()
        var w = contentWidth.coerceIn(minW, maxW)
        var h = (w / ratio).toInt()
        val maxH = (dm.heightPixels * 0.6f).toInt()
        if (h > maxH) { // a tall video: limit the height, keep its shape
            h = maxH
            w = (h * ratio).toInt().coerceAtLeast(minW)
        }
        contentWidth = w
        val frame = (4 * density).toInt() // 2 dp each side
        return (w + frame) to (h + frame)
    }

    private fun applySize() {
        val lp = params ?: return
        val (w, h) = windowSize()
        lp.width = w
        lp.height = h
        clampToScreen()
        updateLayout()
    }

    private fun clampToScreen() {
        val lp = params ?: return
        val dm = themed?.resources?.displayMetrics ?: return
        lp.x = lp.x.coerceIn(0, (dm.widthPixels - lp.width).coerceAtLeast(0))
        lp.y = lp.y.coerceIn(0, (dm.heightPixels - lp.height).coerceAtLeast(0))
    }

    private fun updateLayout() {
        val b = binding ?: return
        val lp = params ?: return
        runCatching { windowManager?.updateViewLayout(b.root, lp) }
    }

    private fun statusBarHeight(context: Context): Int {
        val id = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        return if (id > 0) context.resources.getDimensionPixelSize(id) else 0
    }
}
