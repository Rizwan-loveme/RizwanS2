package com.srizwan.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.GestureDetector
import android.view.HapticFeedbackConstants
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.video.FileOutputOptions
import androidx.camera.video.VideoRecordEvent
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.srizwan.camera.ui.FocusRingView
import com.srizwan.camera.ui.GlassDrawable
import com.srizwan.camera.ui.ModePill
import com.srizwan.camera.ui.ShutterButton
import com.srizwan.camera.ui.ThumbLoader
import com.srizwan.camera.ui.TimerPill
import com.srizwan.camera.ui.cmDp
import com.srizwan.camera.ui.glassIconButton
import java.util.concurrent.Executors

/**
 * The built-in Camera screen (package com.srizwan.camera).
 *
 * Step 2: full-screen live preview driven by [CameraEngine]. Step 3: pinch to zoom, tap to focus (engine does flash and rotation).
 * Step 4 (this file): the glass UI, no text of its own: back, flash, a timer while recording, a photo / video switch, the shutter,
 * the front / back switch, a thumbnail of the last shot and the focus ring.
 *
 * Step 5: photos and videos are saved to DCIM/Camera ([CameraStorage]: MediaStore on Android 10+, a plain file before), and a
 * denied camera permission shows a glass lock (tap: ask again, or open the app settings when Android will not ask any more).
 * The microphone is asked when the first video starts; without it the video is recorded without sound. Tapping the thumbnail
 * opens the photo in the Gallery viewer / the video in the Video player (step 6: a plain VIEW intent to this app, so :camera does not
 * depend on :gallery or :video).
 *
 * Use [start] (explicit intent, the activity is not exported). [MODE_PHOTO] / [MODE_VIDEO] choose the mode it opens in.
 *
 * Step 7, capture mode ([captureIntent], started for a result): the Browser uses it for `<input type=file capture>` and for the
 * Camera button of the file picker. It takes ONE photo / video, returns its `content://` uri as the result data (with a read grant)
 * and closes. The thumbnail is hidden; the photo / video switch is hidden too when the page only accepts one kind ([EXTRA_LOCK_MODE]).
 * The shot is saved to DCIM/Camera like any other.
 */
class CameraActivity : AppCompatActivity() {

    private lateinit var previewView: PreviewView

    /** The camera engine (photo / video / lens switch / flash / zoom / focus), created in onCreate. */
    lateinit var engine: CameraEngine
        private set

    private lateinit var focusRing: FocusRingView
    private lateinit var shutterFlash: View
    private lateinit var backBtn: ImageView
    private lateinit var flashBtn: ImageView
    private lateinit var switchBtn: ImageView
    private lateinit var thumb: ImageView
    private lateinit var shutter: ShutterButton
    private lateinit var modePill: ModePill
    private lateinit var timer: TimerPill
    private lateinit var errorView: ImageView
    private lateinit var lockView: ImageView

    private var startMode = CameraEngine.Mode.PHOTO
    private val io = Executors.newSingleThreadExecutor()

    private var audioAsked = false
    private var captureMode = false

    /** Last saved photo / video as a `content://` uri (null until known), for the thumbnail tap. */
    private var lastUri: Uri? = null
    private var lastVideo = false

    /** CAMERA (always) + WRITE_EXTERNAL_STORAGE on Android 9 and older. Only CAMERA decides whether the screen works. */
    private val askCamera = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        if (hasCamera()) openCamera() else showPermission()
    }

    private val askAudio = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        startVideoNow() // with sound when granted, without sound when not
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startMode = if (intent?.getStringExtra(EXTRA_MODE) == MODE_VIDEO) CameraEngine.Mode.VIDEO else CameraEngine.Mode.PHOTO

        captureMode = intent?.getBooleanExtra(EXTRA_CAPTURE, false) == true
        buildUi()
        if (captureMode) {
            thumb.visibility = View.GONE
            if (intent?.getBooleanExtra(EXTRA_LOCK_MODE, false) == true) modePill.visibility = View.GONE
        }

        engine = CameraEngine(this, this, previewView)
        engine.onBound = { refreshUi() }
        engine.onError = { showError() }
        installGestures()

        val missing = ArrayList<String>()
        if (!hasCamera()) missing += Manifest.permission.CAMERA
        if (CameraStorage.needsLegacyWrite() && !CameraStorage.hasLegacyWrite(this)) missing += Manifest.permission.WRITE_EXTERNAL_STORAGE
        if (missing.isEmpty()) openCamera() else askCamera.launch(missing.toTypedArray())
    }

    private fun hasCamera(): Boolean =
        ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    private fun hasAudio(): Boolean =
        ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED

    // ------------------------------------------------------------------ UI

    private fun buildUi() {
        previewView = PreviewView(this).apply {
            scaleType = PreviewView.ScaleType.FILL_CENTER
            implementationMode = PreviewView.ImplementationMode.PERFORMANCE
        }
        focusRing = FocusRingView(this)
        shutterFlash = View(this).apply {
            setBackgroundColor(Color.WHITE)
            alpha = 0f
        }

        // Top: back (left), timer (centre), flash (right)
        backBtn = glassIconButton(this, R.drawable.cm_ic_back, R.string.cm_cd_back).apply { setOnClickListener { finish() } }
        flashBtn = glassIconButton(this, R.drawable.cm_ic_flash_off, R.string.cm_cd_flash_off).apply {
            setOnClickListener {
                engine.cycleFlash()
                refreshUi()
            }
        }
        timer = TimerPill(this)
        val top = FrameLayout(this).apply {
            val p = cmDp(12f)
            setPadding(p, p, p, p)
            addView(backBtn, FrameLayout.LayoutParams(cmDp(48f), cmDp(48f), Gravity.START or Gravity.CENTER_VERTICAL))
            addView(timer, FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER))
            addView(flashBtn, FrameLayout.LayoutParams(cmDp(48f), cmDp(48f), Gravity.END or Gravity.CENTER_VERTICAL))
        }

        // Bottom: mode pill above a row with thumbnail (left), shutter (centre), switch camera (right)
        modePill = ModePill(this).apply {
            onSelect = { video ->
                engine.setMode(if (video) CameraEngine.Mode.VIDEO else CameraEngine.Mode.PHOTO)
                refreshUi()
            }
        }
        thumb = ImageView(this).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            background = GlassDrawable(context, 14f)
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: android.graphics.Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, cmDp(14f).toFloat())
                }
            }
            contentDescription = getString(R.string.cm_cd_last)
            isClickable = true
            setOnClickListener { openLast() }
        }
        shutter = ShutterButton(this).apply {
            contentDescription = getString(R.string.cm_cd_shutter)
            setOnClickListener { onShutter() }
        }
        switchBtn = glassIconButton(this, R.drawable.cm_ic_switch, R.string.cm_cd_switch).apply {
            setOnClickListener {
                engine.switchLens()
                refreshUi()
            }
        }
        val row = FrameLayout(this).apply {
            addView(thumb, FrameLayout.LayoutParams(cmDp(52f), cmDp(52f), Gravity.START or Gravity.CENTER_VERTICAL).apply { marginStart = cmDp(32f) })
            addView(shutter, FrameLayout.LayoutParams(cmDp(76f), cmDp(76f), Gravity.CENTER))
            addView(switchBtn, FrameLayout.LayoutParams(cmDp(52f), cmDp(52f), Gravity.END or Gravity.CENTER_VERTICAL).apply { marginEnd = cmDp(32f) })
        }
        val bottom = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(0, cmDp(24f), 0, cmDp(16f))
            // soft dark fade so the buttons stay readable over a bright scene
            background = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(0x00000000, 0x99000000.toInt()))
            addView(modePill, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { bottomMargin = cmDp(14f) })
            addView(row, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, cmDp(84f)))
        }

        // Shown instead of the controls when the camera cannot be opened.
        errorView = glassIconButton(this, R.drawable.cm_ic_error, R.string.cm_cd_error, sizeDp = 72f).apply {
            visibility = View.GONE
            isClickable = false
        }

        // Shown when the camera permission is missing: tap to ask again, or to open the app's settings.
        lockView = glassIconButton(this, R.drawable.cm_ic_lock, R.string.cm_cd_lock, sizeDp = 72f).apply {
            visibility = View.GONE
            setOnClickListener { onLockTapped() }
        }

        val match = ViewGroup.LayoutParams.MATCH_PARENT
        val root = FrameLayout(this).apply {
            setBackgroundColor(ContextCompat.getColor(context, R.color.cm_bg))
            addView(previewView, FrameLayout.LayoutParams(match, match))
            addView(focusRing, FrameLayout.LayoutParams(match, match))
            addView(shutterFlash, FrameLayout.LayoutParams(match, match))
            addView(top, FrameLayout.LayoutParams(match, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP))
            addView(bottom, FrameLayout.LayoutParams(match, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM))
            addView(errorView, FrameLayout.LayoutParams(cmDp(72f), cmDp(72f), Gravity.CENTER))
            addView(lockView, FrameLayout.LayoutParams(cmDp(72f), cmDp(72f), Gravity.CENTER))
        }
        setContentView(root)
    }

    /** Brings every button in line with the engine (mode, lens, flash, recording). */
    private fun refreshUi() {
        if (!::engine.isInitialized) return
        val rec = engine.isRecording
        val video = engine.mode == CameraEngine.Mode.VIDEO

        flashBtn.setImageResource(
            when (engine.flash) {
                CameraEngine.Flash.OFF -> R.drawable.cm_ic_flash_off
                CameraEngine.Flash.AUTO -> R.drawable.cm_ic_flash_auto
                CameraEngine.Flash.ON -> R.drawable.cm_ic_flash_on
            },
        )
        flashBtn.contentDescription = getString(
            when (engine.flash) {
                CameraEngine.Flash.OFF -> R.string.cm_cd_flash_off
                CameraEngine.Flash.AUTO -> R.string.cm_cd_flash_auto
                CameraEngine.Flash.ON -> R.string.cm_cd_flash_on
            },
        )
        flashBtn.setColorFilter(if (engine.flash == CameraEngine.Flash.OFF) Color.WHITE else 0xFFFFD34E.toInt())
        flashBtn.alpha = if (engine.hasFlash) 1f else 0.35f

        val idle = if (rec) 0.35f else 1f
        switchBtn.alpha = if (!rec && engine.canSwitchLens()) 1f else 0.35f
        modePill.alpha = idle
        thumb.alpha = idle
        modePill.select(video)

        shutter.style = when {
            !video -> ShutterButton.Style.PHOTO
            rec -> ShutterButton.Style.RECORDING
            else -> ShutterButton.Style.VIDEO
        }
        shutter.contentDescription = getString(
            when {
                !video -> R.string.cm_cd_shutter
                rec -> R.string.cm_cd_stop
                else -> R.string.cm_cd_record
            },
        )
        timer.visibility = if (rec) View.VISIBLE else View.GONE
        errorView.visibility = View.GONE
        lockView.visibility = View.GONE
        shutter.isEnabled = true
    }

    private fun showError() {
        errorView.visibility = View.VISIBLE
        shutter.isEnabled = false
        timer.visibility = View.GONE
    }

    private fun showPermission() {
        lockView.visibility = View.VISIBLE
        errorView.visibility = View.GONE
        shutter.isEnabled = false
    }

    private fun onLockTapped() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            askCamera.launch(arrayOf(Manifest.permission.CAMERA))
        } else {
            // Android does not ask any more ("don't ask again"): the app's settings page is the only way left.
            try {
                startActivity(
                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", packageName, null)),
                )
            } catch (e: Exception) {
                Log.w(TAG, "cannot open the app settings", e)
            }
        }
    }

    /** Pinch = zoom, single tap = focus + exposure at that point (with the focus ring). */
    @SuppressLint("ClickableViewAccessibility")
    private fun installGestures() {
        val scale = ScaleGestureDetector(
            this,
            object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(detector: ScaleGestureDetector): Boolean {
                    engine.zoomBy(detector.scaleFactor)
                    return true
                }
            },
        )
        val tap = GestureDetector(
            this,
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onDown(e: MotionEvent): Boolean = true

                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    engine.focusAt(e.x, e.y)
                    focusRing.show(e.x, e.y)
                    return true
                }
            },
        )
        previewView.setOnTouchListener { _, event ->
            scale.onTouchEvent(event)
            if (!scale.isInProgress) tap.onTouchEvent(event)
            true
        }
    }

    // ------------------------------------------------------------------ capture

    private fun onShutter() {
        shutter.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
        when {
            engine.mode == CameraEngine.Mode.PHOTO -> takePhoto()
            engine.isRecording -> engine.stopRecording()
            else -> startVideo()
        }
    }

    private fun takePhoto() {
        val target = CameraStorage.photo(this)
        flashScreen()
        engine.takePhoto(
            target.options,
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    saved(output.savedUri, target.file, video = false)
                }

                override fun onError(exception: ImageCaptureException) {
                    Log.e(TAG, "photo failed", exception)
                }
            },
        )
    }

    /** Video: the microphone is asked once, at the first recording; the answer does not stop the recording. */
    private fun startVideo() {
        if (!hasAudio() && !audioAsked) {
            audioAsked = true
            askAudio.launch(Manifest.permission.RECORD_AUDIO)
        } else {
            startVideoNow()
        }
    }

    private fun startVideoNow() {
        if (engine.isRecording || engine.mode != CameraEngine.Mode.VIDEO) return
        val target = CameraStorage.video(this)
        val onEvent: (VideoRecordEvent) -> Unit = { event ->
            when (event) {
                is VideoRecordEvent.Start -> refreshUi()
                is VideoRecordEvent.Status -> timer.setMillis(event.recordingStats.recordedDurationNanos / 1_000_000L)
                is VideoRecordEvent.Finalize -> {
                    timer.setMillis(0)
                    refreshUi()
                    val uri = event.outputResults.outputUri
                    if (event.hasError()) CameraStorage.discard(this, uri) else saved(uri, target.file, video = true)
                }
                else -> Unit
            }
        }
        val store = target.store
        val disk = target.disk
        if (store != null) engine.startRecording(store, audio = true, onEvent = onEvent)
        else if (disk != null) engine.startRecording(disk, audio = true, onEvent = onEvent)
        refreshUi()
    }

    /**
     * A photo / video was saved: MediaStore gives its `content://` [uri] at once; the Android 8 / 9 file case gets it from the
     * media scanner a moment later (a `file://` uri must not leave the process, so the thumbnail opens only after that).
     */
    private fun saved(uri: Uri?, file: java.io.File?, video: Boolean) {
        if (captureMode) {
            // Browser capture: hand the shot back and close. On Android 8 / 9 the uri comes from the media scanner.
            if (file == null) {
                if (uri != null) finishWithResult(uri)
            } else {
                CameraStorage.scan(this, file, video) { scanned ->
                    runOnUiThread { if (!isDestroyed) finishWithResult(scanned ?: Uri.fromFile(file)) }
                }
            }
            return
        }
        lastVideo = video
        if (file == null) {
            if (uri == null) return
            lastUri = uri
            showThumb(uri, video)
            return
        }
        lastUri = null
        showThumb(Uri.fromFile(file), video)
        CameraStorage.scan(this, file, video) { scanned -> runOnUiThread { if (!isDestroyed) lastUri = scanned } }
    }

    private fun finishWithResult(uri: Uri) {
        setResult(RESULT_OK, Intent().setData(uri).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION))
        finish()
    }

    /** Thumbnail tap: the photo opens in the Gallery viewer, the video in the Video player (both are part of this app). */
    private fun openLast() {
        val uri = lastUri ?: return
        if (engine.isRecording) return
        val intent = Intent(Intent.ACTION_VIEW)
            .setDataAndType(uri, if (lastVideo) "video/*" else "image/*")
            .setPackage(packageName)
            .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Log.w(TAG, "no viewer for the last shot", e)
        }
    }

    /** Short white flash over the preview, like a shutter. */
    private fun flashScreen() {
        shutterFlash.animate().cancel()
        shutterFlash.alpha = 0.55f
        shutterFlash.animate().alpha(0f).setDuration(160).start()
    }

    private fun showThumb(uri: Uri, video: Boolean) {
        val size = cmDp(52f) * 2
        io.execute {
            val bmp = ThumbLoader.load(this, uri, video, size)
            runOnUiThread {
                if (!isDestroyed && bmp != null) thumb.setImageBitmap(bmp)
            }
        }
    }

    // ------------------------------------------------------------------ lifecycle

    private fun openCamera() {
        engine.start(startMode, front = false)
        refreshUi()
    }

    override fun onResume() {
        super.onResume()
        // Back from the app settings with the permission now granted.
        if (lockView.visibility == View.VISIBLE && hasCamera()) openCamera()
    }

    override fun onDestroy() {
        if (::engine.isInitialized) engine.release()
        io.shutdown()
        super.onDestroy()
    }

    companion object {
        private const val TAG = "CameraActivity"

        /** String extra: [MODE_PHOTO] or [MODE_VIDEO]. */
        const val EXTRA_MODE = "com.srizwan.camera.MODE"
        const val MODE_PHOTO = "photo"
        const val MODE_VIDEO = "video"

        /** Boolean extra: capture mode (one shot, returned as a result), see [captureIntent]. */
        const val EXTRA_CAPTURE = "com.srizwan.camera.CAPTURE"

        /** Boolean extra (capture mode): hide the photo / video switch, the caller only wants [EXTRA_MODE]'s kind. */
        const val EXTRA_LOCK_MODE = "com.srizwan.camera.LOCK_MODE"

        /**
         * The intent for capture mode: start it with `StartActivityForResult`. RESULT_OK carries the saved photo / video as
         * `data` (a `content://` uri, read grant included) - read it with [resultUri]; RESULT_CANCELED when the user left.
         * [mode] is [MODE_PHOTO] or [MODE_VIDEO]; [lockMode] hides the switch (the page only accepts that kind).
         */
        @JvmStatic
        @JvmOverloads
        fun captureIntent(context: Context, mode: String = MODE_PHOTO, lockMode: Boolean = false): Intent =
            Intent(context, CameraActivity::class.java)
                .putExtra(EXTRA_MODE, mode)
                .putExtra(EXTRA_CAPTURE, true)
                .putExtra(EXTRA_LOCK_MODE, lockMode)

        /** The photo / video uri of a capture result (null when cancelled). */
        @JvmStatic
        fun resultUri(data: Intent?): Uri? = data?.data

        /** Opens the Camera. [mode] is [MODE_PHOTO] or [MODE_VIDEO]. */
        @JvmStatic
        @JvmOverloads
        fun start(context: Context, mode: String = MODE_PHOTO) {
            val intent = Intent(context, CameraActivity::class.java).putExtra(EXTRA_MODE, mode)
            if (context !is android.app.Activity) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
