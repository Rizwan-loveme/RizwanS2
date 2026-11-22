package com.srizwan.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.view.OrientationEventListener
import android.view.Surface
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.FocusMeteringAction
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.FallbackStrategy
import androidx.camera.video.FileOutputOptions
import androidx.camera.video.MediaStoreOutputOptions
import androidx.camera.video.PendingRecording
import androidx.camera.video.Quality
import androidx.camera.video.QualitySelector
import androidx.camera.video.Recorder
import androidx.camera.video.Recording
import androidx.camera.video.VideoCapture
import androidx.camera.video.VideoRecordEvent
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.util.concurrent.TimeUnit

/**
 * The CameraX engine of the built-in Camera: live preview, photo, video and front / back switching (step 2), plus the
 * controls of step 3: flash, zoom, tap to focus and the rotation of the saved photo / video.
 *
 * It only talks to CameraX; it draws nothing (the glass UI is step 4) and decides nothing about where files go: the caller
 * passes the output options (step 5 passes MediaStore ones). Everything must be called on the main thread, all callbacks
 * arrive on the main thread too.
 *
 * Use cases are bound per mode (PHOTO = Preview + ImageCapture, VIDEO = Preview + VideoCapture). Binding all three at once
 * is not supported on every device (legacy hardware level), one pair always is.
 */
class CameraEngine(
    private val context: Context,
    private val owner: LifecycleOwner,
    private val previewView: PreviewView,
) {

    enum class Mode { PHOTO, VIDEO }

    /** Flash setting. Photo: off / auto / on. Video: only off / on (on = torch, auto does not exist for video). */
    enum class Flash { OFF, AUTO, ON }

    /** Current mode ([Mode.PHOTO] until [start] says otherwise). */
    var mode: Mode = Mode.PHOTO
        private set

    /** True while the front camera is selected. */
    var isFront: Boolean = false
        private set

    /** The bound camera (flash, zoom and focus controls use it in step 3); null before [start] finished or after an error. */
    var camera: Camera? = null
        private set

    /** Called when the camera cannot be opened / bound or a capture fails. */
    var onError: ((Throwable) -> Unit)? = null

    /** Called after every successful (re)bind: new mode or lens, so the UI can refresh its buttons. */
    var onBound: (() -> Unit)? = null

    /** Current flash setting; kept when the mode or the lens changes (a lens without a flash unit just ignores it). */
    var flash: Flash = Flash.OFF
        private set

    /** True when the selected lens has a flash unit (the front camera usually has none): dim the flash button when false. */
    val hasFlash: Boolean get() = camera?.cameraInfo?.hasFlashUnit() == true

    /** Current zoom ratio (1.0 = no zoom); resets to 1.0 whenever the mode or the lens changes. */
    val zoomRatio: Float get() = camera?.cameraInfo?.zoomState?.value?.zoomRatio ?: 1f

    val isRecording: Boolean get() = recording != null

    private val mainExecutor = ContextCompat.getMainExecutor(context)
    private var provider: ProcessCameraProvider? = null
    private var imageCapture: ImageCapture? = null
    private var videoCapture: VideoCapture<Recorder>? = null
    private var recording: Recording? = null
    private var started = false

    /** Surface.ROTATION_* of the device as the sensor sees it: the saved photo / video is turned upright by it. */
    private var rotation = Surface.ROTATION_0

    private val orientationListener = object : OrientationEventListener(context) {
        override fun onOrientationChanged(orientation: Int) {
            if (orientation == ORIENTATION_UNKNOWN) return
            val r = when (orientation) {
                in 45..134 -> Surface.ROTATION_270
                in 135..224 -> Surface.ROTATION_180
                in 225..314 -> Surface.ROTATION_90
                else -> Surface.ROTATION_0
            }
            if (r != rotation) {
                rotation = r
                applyRotation()
            }
        }
    }

    init {
        // The sensor is only listened to while the screen is visible.
        owner.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onStart(owner: LifecycleOwner) {
                if (orientationListener.canDetectOrientation()) orientationListener.enable()
            }

            override fun onStop(owner: LifecycleOwner) {
                orientationListener.disable()
            }
        })
    }

    /** Opens the camera in [mode] on the back ([front] = false) or front lens. Needs the CAMERA permission already. */
    fun start(mode: Mode = Mode.PHOTO, front: Boolean = false) {
        this.mode = mode
        this.isFront = front
        started = true
        rotation = previewView.display?.rotation ?: Surface.ROTATION_0
        val existing = provider
        if (existing != null) {
            bind()
            return
        }
        val future = ProcessCameraProvider.getInstance(context)
        future.addListener({
            try {
                provider = future.get()
                if (started) bind()
            } catch (e: Exception) {
                fail(e)
            }
        }, mainExecutor)
    }

    /** True when the device has the other lens (front <-> back), for dimming the switch button. */
    fun canSwitchLens(): Boolean {
        val p = provider ?: return false
        return try {
            p.hasCamera(CameraSelector.DEFAULT_BACK_CAMERA) && p.hasCamera(CameraSelector.DEFAULT_FRONT_CAMERA)
        } catch (e: Exception) {
            false
        }
    }

    /** Front <-> back. Ignored while recording (CameraX would end the clip). */
    fun switchLens() {
        if (!started || isRecording || !canSwitchLens()) return
        isFront = !isFront
        bind()
    }

    /** Photo <-> video. Ignored while recording. */
    fun setMode(newMode: Mode) {
        if (!started || isRecording || newMode == mode) return
        mode = newMode
        if (mode == Mode.VIDEO && flash == Flash.AUTO) flash = Flash.OFF
        bind()
    }

    /** Off -> auto -> on -> off (video: off <-> on). Ignored when the lens has no flash unit. */
    fun cycleFlash() {
        if (!hasFlash) return
        flash = when (flash) {
            Flash.OFF -> if (mode == Mode.PHOTO) Flash.AUTO else Flash.ON
            Flash.AUTO -> Flash.ON
            Flash.ON -> Flash.OFF
        }
        applyFlash()
    }

    /** Multiplies the zoom by [factor] (a pinch gesture's scale factor), kept inside what the lens supports. */
    fun zoomBy(factor: Float) {
        val state = camera?.cameraInfo?.zoomState?.value ?: return
        setZoom(state.zoomRatio * factor)
    }

    /** Sets the zoom ratio, clamped to the lens' minimum / maximum. */
    fun setZoom(ratio: Float) {
        val cam = camera ?: return
        val state = cam.cameraInfo.zoomState.value ?: return
        cam.cameraControl.setZoomRatio(ratio.coerceIn(state.minZoomRatio, state.maxZoomRatio))
    }

    /** Focus and exposure on a point of the preview ([x], [y] in view pixels, e.g. a tap); it goes back to auto after 3 s. */
    fun focusAt(x: Float, y: Float) {
        val cam = camera ?: return
        try {
            val point = previewView.meteringPointFactory.createPoint(x, y)
            val action = FocusMeteringAction.Builder(point).setAutoCancelDuration(3, TimeUnit.SECONDS).build()
            cam.cameraControl.startFocusAndMetering(action)
        } catch (e: Exception) {
            Log.w(TAG, "focus failed", e)
        }
    }

    /** Takes a photo; the result goes to [callback]. [options] decide the destination (file / MediaStore / stream). */
    fun takePhoto(options: ImageCapture.OutputFileOptions, callback: ImageCapture.OnImageSavedCallback) {
        val capture = imageCapture
        if (capture == null || mode != Mode.PHOTO) {
            callback.onError(
                androidx.camera.core.ImageCaptureException(
                    ImageCapture.ERROR_INVALID_CAMERA, "Camera is not in photo mode", null,
                ),
            )
            return
        }
        capture.takePicture(options, mainExecutor, callback)
    }

    /** Starts a video into a file. Audio is recorded only when [audio] is true and RECORD_AUDIO is granted. */
    fun startRecording(options: FileOutputOptions, audio: Boolean, onEvent: (VideoRecordEvent) -> Unit) {
        val recorder = videoCapture?.output ?: return
        begin(recorder.prepareRecording(context, options), audio, onEvent)
    }

    /** Starts a video into MediaStore (step 5 uses this one). */
    fun startRecording(options: MediaStoreOutputOptions, audio: Boolean, onEvent: (VideoRecordEvent) -> Unit) {
        val recorder = videoCapture?.output ?: return
        begin(recorder.prepareRecording(context, options), audio, onEvent)
    }

    /** Stops the running video; the Finalize event reaches the callback given to startRecording. */
    fun stopRecording() {
        recording?.stop()
    }

    /** Stops everything and gives the camera back. Call from onDestroy (CameraX also unbinds with the lifecycle). */
    fun release() {
        started = false
        recording?.stop()
        recording = null
        try {
            provider?.unbindAll()
        } catch (e: Exception) {
            Log.w(TAG, "unbindAll failed", e)
        }
        camera = null
        imageCapture = null
        videoCapture = null
    }

    @SuppressLint("MissingPermission") // checked just above (granted(RECORD_AUDIO))
    private fun begin(pending: PendingRecording, audio: Boolean, onEvent: (VideoRecordEvent) -> Unit) {
        if (recording != null) return
        val withAudio = if (audio && granted(Manifest.permission.RECORD_AUDIO)) pending.withAudioEnabled() else pending
        recording = withAudio.start(mainExecutor) { event ->
            if (event is VideoRecordEvent.Finalize) {
                recording = null
                if (event.hasError()) Log.w(TAG, "video finished with error ${event.error}", event.cause)
            }
            onEvent(event)
        }
    }

    private fun bind() {
        val p = provider ?: return
        val selector = if (isFront) CameraSelector.DEFAULT_FRONT_CAMERA else CameraSelector.DEFAULT_BACK_CAMERA
        try {
            if (!p.hasCamera(selector)) {
                fail(IllegalStateException(if (isFront) "No front camera" else "No back camera"))
                return
            }
            p.unbindAll()
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(previewView.surfaceProvider)
            when (mode) {
                Mode.PHOTO -> {
                    val capture = ImageCapture.Builder()
                        .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                        .build()
                    imageCapture = capture
                    videoCapture = null
                    camera = p.bindToLifecycle(owner, selector, preview, capture)
                }
                Mode.VIDEO -> {
                    val recorder = Recorder.Builder()
                        .setQualitySelector(
                            QualitySelector.from(Quality.HD, FallbackStrategy.lowerQualityOrHigherThan(Quality.SD)),
                        )
                        .build()
                    val capture = VideoCapture.withOutput(recorder)
                    videoCapture = capture
                    imageCapture = null
                    camera = p.bindToLifecycle(owner, selector, preview, capture)
                }
            }
            applyRotation()
            applyFlash()
            onBound?.invoke()
        } catch (e: Exception) {
            fail(e)
        }
    }

    private fun applyRotation() {
        imageCapture?.setTargetRotation(rotation)
        videoCapture?.setTargetRotation(rotation)
    }

    private fun applyFlash() {
        val cam = camera ?: return
        val has = cam.cameraInfo.hasFlashUnit()
        try {
            if (mode == Mode.PHOTO) {
                cam.cameraControl.enableTorch(false)
                imageCapture?.setFlashMode(
                    if (!has) {
                        ImageCapture.FLASH_MODE_OFF
                    } else {
                        when (flash) {
                            Flash.OFF -> ImageCapture.FLASH_MODE_OFF
                            Flash.AUTO -> ImageCapture.FLASH_MODE_AUTO
                            Flash.ON -> ImageCapture.FLASH_MODE_ON
                        }
                    },
                )
            } else {
                cam.cameraControl.enableTorch(has && flash == Flash.ON)
            }
        } catch (e: Exception) {
            Log.w(TAG, "flash failed", e)
        }
    }

    private fun fail(e: Throwable) {
        Log.e(TAG, "camera error", e)
        camera = null
        onError?.invoke(e)
    }

    private fun granted(permission: String): Boolean =
        ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED

    private companion object {
        const val TAG = "CameraEngine"
    }
}
