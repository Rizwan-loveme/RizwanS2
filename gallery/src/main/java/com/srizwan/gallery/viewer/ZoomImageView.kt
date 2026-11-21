package com.srizwan.gallery.viewer

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.VelocityTracker
import android.view.View
import android.view.ViewConfiguration
import android.view.animation.DecelerateInterpolator
import android.widget.OverScroller
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.loader.IconPlaceholder
import java.util.concurrent.Future
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * One page of the viewer: a picture you can pinch, double-tap, pan and fling, that also closes with a swipe down.
 * A plain View that draws with a canvas matrix (no ImageView), so the same code serves still pictures, tiles and
 * animated GIFs.
 *
 *  - **Pinch** zooms around your fingers (a little rubber-band past the limits, then it settles back);
 *    **double tap** toggles between "fit" and a close-up at the tapped point; **pan** and **fling** move the zoomed
 *    picture inside its edges. At the edge of a zoomed picture the next horizontal drag is handed to the ViewPager2,
 *    so you swipe on to the neighbouring photo.
 *  - **Swipe down** (while not zoomed) drags the picture away; past ~16 % of the height, or with a quick flick,
 *    it closes ([Listener.onDismiss]); otherwise it springs back. [Listener.onDragProgress] reports 0..1 so the
 *    screen can fade its backdrop and bars.
 *  - **Sharpness**: [show] draws a cached thumbnail at once, then the base bitmap. If the picture is bigger than the base
 *    bitmap, sharp tiles of the visible part are decoded in the background while you zoom ([TileSource]); only about 36
 *    tiles are kept. Nothing is recycled by hand, so a frame that is still being drawn can never hit a recycled bitmap.
 *  - **Tap** (single) goes to [Listener.onTap] after the double-tap time-out.
 */
internal class ZoomImageView(context: Context) : View(context) {

    interface Listener {
        /** A single tap (the viewer toggles its bars). */
        fun onTap()

        /** 0 = at rest, 1 = dragged far enough that it will close. Also called with 0 when it springs back. */
        fun onDragProgress(progress: Float)

        /** The swipe-down was committed: close the screen. */
        fun onDismiss()
    }

    var listener: Listener? = null

    private val density = resources.displayMetrics.density
    private val main = Handler(Looper.getMainLooper())
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
    private val touchSlop = ViewConfiguration.get(context).scaledTouchSlop

    // ── content ──────────────────────────────────────────────────────────────
    private var base: Bitmap? = null
    private var animated: Drawable? = null
    private var tileSource: TileSource? = null

    /** Size of the whole picture as loaded (EXIF applied), in picture pixels (0 = nothing to show yet). */
    private var srcW = 0
    private var srcH = 0

    /** Size of the picture as SEEN: [srcW] x [srcH], swapped while it is turned a quarter / three quarters (step 8). */
    private var imgW = 0
    private var imgH = 0

    /** View-only rotation in quarter turns clockwise (0..3), set by the rotate button of the viewer. */
    private var quarterTurns = 0

    private var generation = 0
    private var loadTask: Future<*>? = null
    private var loading = false
    private var failed = false

    // ── transform: view = picture * scale + (tx, ty) ─────────────────────────
    private var scale = 1f
    private var tx = 0f
    private var ty = 0f
    private var fitScale = 1f
    private var maxScale = 1f

    // ── tiles ────────────────────────────────────────────────────────────────
    private class TileEntry(val sample: Int, val bitmap: Bitmap, val rect: RectF)

    private val tileMap = object : LinkedHashMap<Long, TileEntry>(64, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Long, TileEntry>?): Boolean = size > MAX_TILES
    }
    private val pending = HashSet<Long>()
    @Volatile private var tileGen = 0
    @Volatile private var wanted: Set<Long> = emptySet()
    private var currentSample = 0

    // ── gestures ─────────────────────────────────────────────────────────────
    private val scroller = OverScroller(context)
    private var zoomAnim: ValueAnimator? = null
    private var dismissAnim: ValueAnimator? = null
    private var velocity: VelocityTracker? = null
    private var scaling = false
    private var lastFx = 0f
    private var lastFy = 0f
    private var downX = 0f
    private var downY = 0f
    private var dismissing = false
    private var closing = false
    private var dismissOffset = 0f

    private val scaleDetector = ScaleGestureDetector(context, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            if (imgW == 0 || dismissing || closing) return false
            scaling = true
            zoomAnim?.cancel()
            scroller.forceFinished(true)
            lastFx = detector.focusX
            lastFy = detector.focusY
            parent?.requestDisallowInterceptTouchEvent(true)
            return true
        }

        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val fx = detector.focusX
            val fy = detector.focusY
            tx += fx - lastFx // two fingers moving together pan the picture
            ty += fy - lastFy
            lastFx = fx
            lastFy = fy
            val target = (scale * detector.scaleFactor).coerceIn(fitScale * 0.75f, maxScale * 1.3f)
            val px = (fx - tx) / scale // the picture point under the fingers stays under them
            val py = (fy - ty) / scale
            scale = target
            tx = fx - px * target
            ty = fy - py * target
            clampTranslation()
            invalidate()
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector) {
            scaling = false
            settleScale()
        }
    })

    private val gestures = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean = true

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            listener?.onTap()
            return true
        }

        override fun onDoubleTap(e: MotionEvent): Boolean {
            toggleZoom(e.x, e.y)
            return true
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean =
            handleScroll(e2, distanceX, distanceY)

        override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean =
            handleFling(velocityX, velocityY)
    }).apply { setIsLongpressEnabled(false) }

    private val errorIcon by lazy { IconPlaceholder(context, R.drawable.gl_ic_error, sizeDp = 48f, softness = 0.6f) }
    private val spinnerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 3f * density
        strokeCap = Paint.Cap.ROUND
        color = 0xCCFFFFFF.toInt()
    }
    private val spinnerRect = RectF()

    /** The view-only rotation now, in quarter turns clockwise. */
    val turns: Int get() = quarterTurns

    /** True while the picture is bigger than "fit". */
    val isZoomed: Boolean get() = imgW > 0 && scale > fitScale * 1.02f

    // ── public API ───────────────────────────────────────────────────────────

    /**
     * Shows [image]. [preview] (a thumbnail that is already in memory, may be null) is drawn at once, while the real
     * picture is decoded on a background thread. [turns] is the view-only rotation to start with (quarter turns clockwise).
     */
    fun show(image: GalleryImage, preview: Bitmap?, turns: Int = 0) {
        clear()
        quarterTurns = normTurns(turns)
        val token = ++generation
        if (preview != null) setContent(preview, null, preview.width, preview.height, null)
        loading = preview == null
        val path = image.path
        val gif = image.isGif
        loadTask = ViewerLoader.pageExecutor.submit(Runnable {
            val result = try {
                ViewerLoader.load(path, gif)
            } catch (e: Throwable) {
                Log.w(TAG, "load failed: $path", e)
                null
            }
            main.post { onLoaded(token, result) }
        })
        invalidate()
    }

    /** Stops everything and forgets the picture (the page is recycled). */
    fun clear() {
        generation++
        loadTask?.cancel(false)
        loadTask = null
        zoomAnim?.cancel()
        dismissAnim?.cancel()
        scroller.forceFinished(true)
        releaseContent()
        base = null
        srcW = 0
        srcH = 0
        imgW = 0
        imgH = 0
        quarterTurns = 0
        failed = false
        loading = false
        scale = 1f
        tx = 0f
        ty = 0f
        fitScale = 1f
        dismissing = false
        closing = false
        dismissOffset = 0f
        translationY = 0f
        scaleX = 1f
        scaleY = 1f
    }

    /**
     * Turns the picture to [turns] quarter turns clockwise (view only, the file is not touched) and shows it at "fit".
     * Tiles stay valid: they are kept in picture coordinates and only the drawing is rotated.
     */
    fun setTurns(turns: Int) {
        val t = normTurns(turns)
        if (t == quarterTurns) return
        quarterTurns = t
        if (srcW == 0) return
        zoomAnim?.cancel()
        scroller.forceFinished(true)
        applyTurnsToSize()
        computeFit()
        scale = fitScale
        centerTranslation()
        invalidate()
    }

    private fun normTurns(t: Int): Int = ((t % 4) + 4) % 4

    private fun applyTurnsToSize() {
        if (quarterTurns % 2 == 0) {
            imgW = srcW
            imgH = srcH
        } else {
            imgW = srcH
            imgH = srcW
        }
    }

    /** Back to "fit". */
    fun resetZoom(animated: Boolean = true) {
        if (!isZoomed) return
        if (animated) {
            animateTo(fitScale, width / 2f, height / 2f)
        } else {
            zoomAnim?.cancel()
            scroller.forceFinished(true)
            scale = fitScale
            centerTranslation()
            invalidate()
        }
    }

    // ── content ──────────────────────────────────────────────────────────────

    private fun onLoaded(token: Int, r: ViewerLoader.Result?) {
        if (token != generation) { // the page moved on: free what was decoded for it
            r?.tiles?.close()
            (r?.animated as? Animatable)?.stop()
            return
        }
        loading = false
        if (r == null) {
            if (imgW == 0) {
                failed = true
                contentDescription = context.getString(R.string.gl_cd_error)
            }
            invalidate() // a thumbnail that is already showing stays
            return
        }
        setContent(r.bitmap, r.animated, r.width, r.height, r.tiles)
    }

    private fun setContent(bmp: Bitmap?, anim: Drawable?, w: Int, h: Int, src: TileSource?) {
        releaseContent()
        base = bmp
        animated = anim
        srcW = w
        srcH = h
        applyTurnsToSize()
        tileSource = src
        failed = false
        if (anim != null) {
            anim.callback = this
            if (anim is MovieDrawable) setLayerType(LAYER_TYPE_SOFTWARE, null) // Movie cannot draw on the GPU
            if (isAttachedToWindow && windowVisibility == VISIBLE) (anim as? Animatable)?.start()
        }
        computeFit()
        scale = fitScale
        centerTranslation()
        invalidate()
    }

    /** Drops tiles, the tile decoder and the animation (not the base bitmap: see the class comment). */
    private fun releaseContent() {
        tileGen++
        pending.clear()
        tileMap.clear()
        wanted = emptySet()
        currentSample = 0
        tileSource?.close()
        tileSource = null
        animated?.let {
            (it as? Animatable)?.stop()
            it.callback = null
        }
        animated = null
        if (layerType != LAYER_TYPE_NONE) setLayerType(LAYER_TYPE_NONE, null)
    }

    private fun computeFit() {
        if (imgW == 0 || imgH == 0 || width == 0 || height == 0) return
        fitScale = min(width.toFloat() / imgW, height.toFloat() / imgH)
        maxScale = max(fitScale * 4f, density * 2f)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        computeFit()
        scale = fitScale
        centerTranslation()
    }

    // ── transform helpers ────────────────────────────────────────────────────

    private fun centerTranslation() {
        tx = (width - imgW * scale) / 2f
        ty = (height - imgH * scale) / 2f
    }

    /** Keeps the picture inside the view; a picture smaller than the view is centred. */
    private fun clampAxis(t: Float, content: Float, view: Int): Float =
        if (content <= view) (view - content) / 2f else t.coerceIn(view - content, 0f)

    private fun clampTranslation() {
        tx = clampAxis(tx, imgW * scale, width)
        ty = clampAxis(ty, imgH * scale, height)
    }

    private fun settleScale() {
        val target = scale.coerceIn(fitScale, maxScale)
        if (abs(target - scale) > 0.001f) {
            animateTo(target, lastFx, lastFy)
        } else {
            clampTranslation()
            invalidate()
        }
    }

    private fun toggleZoom(fx: Float, fy: Float) {
        if (imgW == 0 || dismissing || closing) return
        val fill = max(width.toFloat() / imgW, height.toFloat() / imgH)
        val zoomIn = min(maxScale, max(fill, fitScale * 2f))
        animateTo(if (isZoomed) fitScale else zoomIn, fx, fy)
    }

    /** Animates to [target] scale, keeping the picture point under ([fx], [fy]) where it is. */
    private fun animateTo(target: Float, fx: Float, fy: Float) {
        zoomAnim?.cancel()
        scroller.forceFinished(true)
        val s0 = scale
        val x0 = tx
        val y0 = ty
        val px = (fx - tx) / scale
        val py = (fy - ty) / scale
        val x1 = clampAxis(fx - px * target, imgW * target, width)
        val y1 = clampAxis(fy - py * target, imgH * target, height)
        zoomAnim = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 240L
            interpolator = DecelerateInterpolator()
            addUpdateListener { a ->
                val t = a.animatedValue as Float
                scale = s0 + (target - s0) * t
                tx = x0 + (x1 - x0) * t
                ty = y0 + (y1 - y0) * t
                invalidate()
            }
            start()
        }
    }

    // ── touch ────────────────────────────────────────────────────────────────

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(e: MotionEvent): Boolean {
        if (closing) return true
        when (e.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                downX = e.x
                downY = e.y
                scroller.forceFinished(true)
                zoomAnim?.cancel()
                if (dismissAnim?.isRunning == true) { // grabbed while it springs back
                    dismissAnim?.cancel()
                    dismissing = false
                    applyDismiss(0f)
                }
                velocity?.recycle()
                velocity = VelocityTracker.obtain()
                // A zoomed picture keeps the touch (pan); a fitted one lets the ViewPager2 take a horizontal swipe.
                parent?.requestDisallowInterceptTouchEvent(isZoomed)
            }
            MotionEvent.ACTION_POINTER_DOWN -> parent?.requestDisallowInterceptTouchEvent(true)
        }
        velocity?.addMovement(e)
        scaleDetector.onTouchEvent(e)
        gestures.onTouchEvent(e)
        when (e.actionMasked) {
            MotionEvent.ACTION_UP -> {
                endDismiss(true)
                releaseVelocity()
            }
            MotionEvent.ACTION_CANCEL -> { // e.g. the ViewPager2 took over the swipe
                endDismiss(false)
                releaseVelocity()
            }
        }
        return true
    }

    private fun releaseVelocity() {
        velocity?.recycle()
        velocity = null
    }

    private fun handleScroll(e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        if (scaling || e2.pointerCount > 1 || closing) return false
        if (dismissing) {
            applyDismiss(max(0f, dismissOffset - distanceY))
            return true
        }
        if (!isZoomed) {
            val dx = e2.x - downX
            val dy = e2.y - downY
            if (dy > touchSlop && dy > abs(dx) * 1.2f) { // a swipe down: drag the picture away
                dismissing = true
                parent?.requestDisallowInterceptTouchEvent(true)
                applyDismiss(dy)
            }
            return true
        }
        val oldTx = tx
        tx -= distanceX
        ty -= distanceY
        clampTranslation()
        // At the left / right edge a further horizontal drag belongs to the pager (next / previous photo).
        val stuckX = abs(tx - oldTx) < 0.01f && abs(distanceX) > abs(distanceY)
        parent?.requestDisallowInterceptTouchEvent(!stuckX)
        invalidate()
        return true
    }

    private fun handleFling(vx: Float, vy: Float): Boolean {
        if (scaling || dismissing || closing || !isZoomed) return false
        val cw = imgW * scale
        val ch = imgH * scale
        val minX = if (cw > width) width - cw else tx
        val maxX = if (cw > width) 0f else tx
        val minY = if (ch > height) height - ch else ty
        val maxY = if (ch > height) 0f else ty
        scroller.fling(
            tx.roundToInt(), ty.roundToInt(), vx.roundToInt(), vy.roundToInt(),
            minX.roundToInt(), maxX.roundToInt(), minY.roundToInt(), maxY.roundToInt()
        )
        postInvalidateOnAnimation()
        return true
    }

    override fun computeScroll() {
        if (scroller.computeScrollOffset()) {
            tx = scroller.currX.toFloat()
            ty = scroller.currY.toFloat()
            invalidate()
        }
    }

    // ── swipe down to close ──────────────────────────────────────────────────

    private fun applyDismiss(offset: Float) {
        dismissOffset = offset
        val progress = (offset / (height * 0.45f).coerceAtLeast(1f)).coerceIn(0f, 1f)
        translationY = offset
        val s = 1f - 0.12f * progress
        scaleX = s
        scaleY = s
        listener?.onDragProgress(progress)
    }

    private fun endDismiss(up: Boolean) {
        if (!dismissing || dismissAnim?.isRunning == true) return
        velocity?.computeCurrentVelocity(1000)
        val vy = velocity?.yVelocity ?: 0f
        val commit = up && (dismissOffset > height * 0.16f || vy > 1400f)
        animateDismiss(if (commit) height * 1.1f else 0f, commit)
    }

    private fun animateDismiss(target: Float, commit: Boolean) {
        closing = commit
        dismissAnim = ValueAnimator.ofFloat(dismissOffset, target).apply {
            duration = if (commit) 180L else 200L
            interpolator = DecelerateInterpolator()
            addUpdateListener { a -> applyDismiss(a.animatedValue as Float) }
            addListener(object : AnimatorListenerAdapter() {
                private var cancelled = false

                override fun onAnimationCancel(animation: Animator) {
                    cancelled = true
                }

                override fun onAnimationEnd(animation: Animator) {
                    if (cancelled) return
                    if (commit) {
                        listener?.onDismiss()
                    } else {
                        dismissing = false
                        applyDismiss(0f)
                    }
                }
            })
            start()
        }
    }

    // ── tiles ────────────────────────────────────────────────────────────────

    /** The `inSampleSize` of the tiles that are sharper than the base bitmap at the current zoom, 0 = base is enough. */
    private fun tileSampleFor(): Int {
        val b = base ?: return 0
        val baseRatio = srcW.toFloat() / b.width // picture pixels per base pixel
        var s = 1
        while (s * 2 <= 1f / scale) s *= 2
        return if (s >= baseRatio * 0.99f) 0 else s
    }

    private fun tileKey(sample: Int, x: Int, y: Int): Long = (sample.toLong() shl 48) or (x.toLong() shl 24) or y.toLong()

    /** Asks for the tiles of the visible part that are not decoded yet. Cheap; runs after every draw. */
    private fun ensureTiles() {
        val src = tileSource ?: return
        val sample = tileSampleFor()
        if (sample != currentSample) { // the zoom crossed a level: forget the queue of the old one
            currentSample = sample
            tileGen++
            pending.clear()
        }
        if (sample == 0) {
            wanted = emptySet()
            return
        }
        val tileSize = TILE * sample // picture pixels covered by one tile
        // the visible part, first as SEEN (turned), then mapped back to the picture's own coordinates
        val left = max(0f, -tx / scale)
        val top = max(0f, -ty / scale)
        val right = min(imgW.toFloat(), (width - tx) / scale)
        val bottom = min(imgH.toFloat(), (height - ty) / scale)
        if (right <= left || bottom <= top) return
        val sl: Float
        val st: Float
        val sr: Float
        val sb: Float
        when (quarterTurns) {
            1 -> { sl = top; sr = bottom; st = srcH - right; sb = srcH - left }
            2 -> { sl = srcW - right; sr = srcW - left; st = srcH - bottom; sb = srcH - top }
            3 -> { sl = srcW - bottom; sr = srcW - top; st = left; sb = right }
            else -> { sl = left; sr = right; st = top; sb = bottom }
        }
        val x0 = (max(0f, sl) / tileSize).toInt()
        val x1 = ((min(srcW.toFloat(), sr) - 0.5f) / tileSize).toInt()
        val y0 = (max(0f, st) / tileSize).toInt()
        val y1 = ((min(srcH.toFloat(), sb) - 0.5f) / tileSize).toInt()
        val want = HashSet<Long>()
        val gen = tileGen
        for (iy in y0..y1) {
            for (ix in x0..x1) {
                val key = tileKey(sample, ix, iy)
                want.add(key)
                if (tileMap[key] != null || pending.contains(key)) continue
                pending.add(key)
                val l = ix * tileSize
                val t = iy * tileSize
                val r = min(srcW, l + tileSize)
                val b = min(srcH, t + tileSize)
                ViewerLoader.tileExecutor.execute(Runnable {
                    if (gen != tileGen || key !in wanted) { // scrolled away / zoom level changed while queued
                        main.post { pending.remove(key) }
                        return@Runnable
                    }
                    val tile = try {
                        src.decode(l, t, r, b, sample)
                    } catch (e: Throwable) {
                        null
                    }
                    main.post {
                        pending.remove(key)
                        if (gen == tileGen && tile != null && src === tileSource) {
                            tileMap[key] = TileEntry(sample, tile.bitmap, tile.rect)
                            invalidate()
                        }
                    }
                })
            }
        }
        wanted = want
    }

    // ── drawing ──────────────────────────────────────────────────────────────

    override fun onDraw(canvas: Canvas) {
        if (imgW == 0 || imgH == 0) {
            drawStatus(canvas)
            return
        }
        val save = canvas.save()
        canvas.translate(tx, ty)
        canvas.scale(scale, scale)
        when (quarterTurns) { // from here on everything is drawn in the picture's own coordinates
            1 -> { canvas.translate(srcH.toFloat(), 0f); canvas.rotate(90f) }
            2 -> { canvas.translate(srcW.toFloat(), srcH.toFloat()); canvas.rotate(180f) }
            3 -> { canvas.translate(0f, srcW.toFloat()); canvas.rotate(270f) }
        }
        val a = animated
        if (a != null) {
            a.setBounds(0, 0, srcW, srcH)
            a.draw(canvas)
        } else {
            base?.let { b ->
                val inner = canvas.save()
                canvas.scale(srcW.toFloat() / b.width, srcH.toFloat() / b.height)
                canvas.drawBitmap(b, 0f, 0f, paint)
                canvas.restoreToCount(inner)
            }
            if (tileSource != null) {
                for (t in tileMap.values) {
                    if (t.sample == currentSample) canvas.drawBitmap(t.bitmap, null, t.rect, paint)
                }
            }
        }
        canvas.restoreToCount(save)
        if (tileSource != null) ensureTiles()
    }

    private fun drawStatus(canvas: Canvas) {
        if (loading) {
            val r = 16f * density
            val cx = width / 2f
            val cy = height / 2f
            spinnerRect.set(cx - r, cy - r, cx + r, cy + r)
            val angle = (SystemClock.uptimeMillis() % 900L) / 900f * 360f
            canvas.drawArc(spinnerRect, angle, 270f, false, spinnerPaint)
            postInvalidateOnAnimation()
        } else if (failed) {
            errorIcon.setBounds(0, 0, width, height)
            errorIcon.draw(canvas)
        }
    }

    // ── animated pictures follow the window ──────────────────────────────────

    override fun verifyDrawable(who: Drawable): Boolean = who === animated || super.verifyDrawable(who)

    /** The animation's dirty rectangle is in picture coordinates, not view coordinates: redraw the whole view. */
    override fun invalidateDrawable(drawable: Drawable) {
        if (drawable === animated) invalidate() else super.invalidateDrawable(drawable)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (windowVisibility == VISIBLE) (animated as? Animatable)?.start()
    }

    override fun onDetachedFromWindow() {
        (animated as? Animatable)?.stop()
        super.onDetachedFromWindow()
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        (animated as? Animatable)?.let { if (visibility == VISIBLE) it.start() else it.stop() }
    }

    private companion object {
        const val TAG = "ZoomImageView"

        /** Tiles are decoded about this many pixels wide / high. */
        const val TILE = 512

        /** Most tiles kept at once (about 18 MB for JPEG, 36 MB otherwise). */
        const val MAX_TILES = 36
    }
}
