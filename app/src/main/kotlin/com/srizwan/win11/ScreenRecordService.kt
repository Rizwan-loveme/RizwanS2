package com.srizwan.win11

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ServiceInfo
import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.MediaRecorder
import android.media.MediaScannerConnection
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.math.max

/**
 * Screen recorder: MediaProjection + MediaRecorder inside a foreground service.
 *
 * Android always shows its own screen-capture consent dialog before recording
 * (an app cannot skip it). After the user accepts, this service records the whole
 * screen (optionally with microphone audio) and saves an MP4 to Movies/RizwanS2.
 *
 * Stop: tap the recorder tile again, use the "Stop" action in the notification,
 * or use the system "stop sharing" chip.
 */
class ScreenRecordService : Service() {

    companion object {
        private const val CHANNEL_ID = "screen_record"
        private const val NOTIF_ID = 7301
        private const val NOTIF_DONE_ID = 7302
        private const val EXTRA_CODE = "result_code"
        private const val EXTRA_DATA = "result_data"
        private const val EXTRA_MIC = "with_mic"
        private const val START_DELAY_MS = 1500L
        private const val MAX_SIDE = 1920
        private const val FOLDER = "RizwanS2"

        /** true from the moment recording is requested until it is stopped. */
        @Volatile var isRecording = false
            private set

        private fun actionStart(ctx: Context) = ctx.packageName + ".SCREEN_RECORD_START"
        private fun actionStop(ctx: Context) = ctx.packageName + ".SCREEN_RECORD_STOP"

        fun start(ctx: Context, resultCode: Int, data: Intent, withMic: Boolean) {
            val i = Intent(ctx, ScreenRecordService::class.java).apply {
                action = actionStart(ctx)
                putExtra(EXTRA_CODE, resultCode)
                putExtra(EXTRA_DATA, data)
                putExtra(EXTRA_MIC, withMic)
            }
            ContextCompat.startForegroundService(ctx, i)
        }

        fun stop(ctx: Context) {
            if (!isRecording) return
            ctx.startService(Intent(ctx, ScreenRecordService::class.java).setAction(actionStop(ctx)))
        }
    }

    private val handler = Handler(Looper.getMainLooper())
    private var projection: MediaProjection? = null
    private var projectionCallback: MediaProjection.Callback? = null
    private var recorder: MediaRecorder? = null
    private var virtualDisplay: VirtualDisplay? = null
    private var outFile: File? = null
    private var startedAt = 0L

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        AppLog.i("Recorder", "onStartCommand action=${intent?.action} recording=$isRecording")
        if (intent?.action == actionStop(this)) {
            finishRecording()
            return START_NOT_STICKY
        }
        if (isRecording) return START_NOT_STICKY

        val code = intent?.getIntExtra(EXTRA_CODE, 0) ?: 0
        val data = readData(intent)
        if (data == null) {
            stopSelf()
            return START_NOT_STICKY
        }
        val mic = intent?.getBooleanExtra(EXTRA_MIC, false) == true &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) ==
            PackageManager.PERMISSION_GRANTED

        createChannel()
        try {
            val notif = buildNotification("Starting…", false)
            if (Build.VERSION.SDK_INT >= 29) {
                var type = ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PROJECTION
                if (mic && Build.VERSION.SDK_INT >= 30) type = type or ServiceInfo.FOREGROUND_SERVICE_TYPE_MICROPHONE
                // Android 14+: foreground service (type mediaProjection) must be running
                // BEFORE getMediaProjection() is called.
                startForeground(NOTIF_ID, notif, type)
            } else {
                startForeground(NOTIF_ID, notif)
            }
        } catch (e: Exception) {
            AppLog.e("Recorder", "startForeground failed", e)
            toast("Could not start recorder: ${e.message}")
            stopSelf()
            return START_NOT_STICKY
        }

        isRecording = true
        // Short delay so the consent dialog / quick panel are gone before capture begins.
        handler.postDelayed({ beginCapture(code, data, mic) }, START_DELAY_MS)
        return START_NOT_STICKY
    }

    @Suppress("DEPRECATION")
    private fun readData(intent: Intent?): Intent? =
        if (Build.VERSION.SDK_INT >= 33) intent?.getParcelableExtra(EXTRA_DATA, Intent::class.java)
        else intent?.getParcelableExtra(EXTRA_DATA)

    private fun beginCapture(code: Int, data: Intent, mic: Boolean) {
        if (!isRecording) return // stopped during the start delay
        try {
            val mpm = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
            val proj = mpm.getMediaProjection(code, data)
                ?: throw IllegalStateException("Screen capture permission was not granted")
            projection = proj
            // Android 14+: a callback MUST be registered before createVirtualDisplay().
            val cb = object : MediaProjection.Callback() {
                override fun onStop() { handler.post { finishRecording() } }
            }
            projectionCallback = cb
            proj.registerCallback(cb, handler)

            val (w, h, dpi) = screenSize()
            val dir = getExternalFilesDir(Environment.DIRECTORY_MOVIES) ?: cacheDir
            dir.mkdirs()
            val stamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
            val file = File(dir, "REC_$stamp.mp4")
            outFile = file

            @Suppress("DEPRECATION")
            val rec = if (Build.VERSION.SDK_INT >= 31) MediaRecorder(this) else MediaRecorder()
            if (mic) rec.setAudioSource(MediaRecorder.AudioSource.MIC)
            rec.setVideoSource(MediaRecorder.VideoSource.SURFACE)
            rec.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            rec.setVideoEncoder(MediaRecorder.VideoEncoder.H264)
            if (mic) {
                rec.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                rec.setAudioEncodingBitRate(128_000)
                rec.setAudioSamplingRate(44_100)
            }
            rec.setVideoSize(w, h)
            rec.setVideoFrameRate(30)
            rec.setVideoEncodingBitRate((w.toLong() * h * 3).coerceIn(2_000_000L, 16_000_000L).toInt())
            rec.setOutputFile(file.absolutePath)
            rec.prepare()
            recorder = rec

            virtualDisplay = proj.createVirtualDisplay(
                "RizwanS2Recorder", w, h, dpi,
                DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                rec.surface, null, null
            )
            rec.start()
            startedAt = System.currentTimeMillis()
            postNotification(NOTIF_ID, buildNotification(if (mic) "Recording screen + microphone" else "Recording screen", true))
        } catch (e: Exception) {
            AppLog.e("Recorder", "beginCapture failed", e)
            toast("Could not start recording: ${e.message ?: e.javaClass.simpleName}")
            abortCapture()
        }
    }

    /** Stop recording and save the file. Safe to call more than once. */
    private fun finishRecording() {
        if (!isRecording) return
        isRecording = false
        handler.removeCallbacksAndMessages(null)

        val rec = recorder
        var recorded = false
        if (rec != null) {
            try { rec.stop(); recorded = true } catch (_: RuntimeException) { /* too short / no frames */ }
        }
        releaseCapture()

        val file = outFile
        outFile = null
        if (!recorded || file == null || !file.exists() || file.length() == 0L) {
            file?.delete()
            if (rec != null) toast("Recording was too short to save")
            endService()
            return
        }

        postNotification(NOTIF_ID, buildNotification("Saving recording…", false))
        Thread {
            val saved = saveToGallery(file)
            handler.post {
                if (saved != null) {
                    toast("Recording saved: ${saved.where}")
                    postNotification(NOTIF_DONE_ID, buildDoneNotification(saved))
                } else {
                    toast("Could not copy to gallery. File kept at: ${file.absolutePath}")
                }
                endService()
            }
        }.start()
    }

    private fun abortCapture() {
        isRecording = false
        handler.removeCallbacksAndMessages(null)
        releaseCapture()
        outFile?.delete()
        outFile = null
        endService()
    }

    private fun releaseCapture() {
        try { recorder?.reset() } catch (_: Exception) {}
        try { recorder?.release() } catch (_: Exception) {}
        recorder = null
        try { virtualDisplay?.release() } catch (_: Exception) {}
        virtualDisplay = null
        val p = projection
        if (p != null) {
            projectionCallback?.let { try { p.unregisterCallback(it) } catch (_: Exception) {} }
            try { p.stop() } catch (_: Exception) {}
        }
        projectionCallback = null
        projection = null
    }

    @Suppress("DEPRECATION")
    private fun endService() {
        if (Build.VERSION.SDK_INT >= 24) stopForeground(STOP_FOREGROUND_REMOVE)
        else stopForeground(true)
        stopSelf()
    }

    override fun onDestroy() {
        if (isRecording) {
            isRecording = false
            handler.removeCallbacksAndMessages(null)
            releaseCapture()
        }
        super.onDestroy()
    }

    // ── helpers ───────────────────────────────────────────────────────

    @Suppress("DEPRECATION")
    private fun screenSize(): Triple<Int, Int, Int> {
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var w: Int
        var h: Int
        if (Build.VERSION.SDK_INT >= 30) {
            val b = wm.maximumWindowMetrics.bounds
            w = b.width(); h = b.height()
        } else {
            val m = DisplayMetrics()
            wm.defaultDisplay.getRealMetrics(m)
            w = m.widthPixels; h = m.heightPixels
        }
        val side = max(w, h)
        if (side > MAX_SIDE) {
            val s = MAX_SIDE.toFloat() / side
            w = (w * s).toInt(); h = (h * s).toInt()
        }
        w = (w / 2 * 2).coerceAtLeast(2)
        h = (h / 2 * 2).coerceAtLeast(2)
        return Triple(w, h, resources.displayMetrics.densityDpi)
    }

    private class Saved(val uri: Uri?, val where: String)

    private fun saveToGallery(src: File): Saved? {
        return try {
            if (Build.VERSION.SDK_INT >= 29) {
                val values = ContentValues().apply {
                    put(MediaStore.Video.Media.DISPLAY_NAME, src.name)
                    put(MediaStore.Video.Media.MIME_TYPE, "video/mp4")
                    put(MediaStore.Video.Media.RELATIVE_PATH, Environment.DIRECTORY_MOVIES + "/" + FOLDER)
                    put(MediaStore.Video.Media.IS_PENDING, 1)
                }
                val uri = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values)
                    ?: return null
                try {
                    contentResolver.openOutputStream(uri)?.use { out ->
                        src.inputStream().use { it.copyTo(out) }
                    } ?: throw IllegalStateException("Cannot open output")
                    val done = ContentValues().apply { put(MediaStore.Video.Media.IS_PENDING, 0) }
                    contentResolver.update(uri, done, null, null)
                } catch (e: Exception) {
                    try { contentResolver.delete(uri, null, null) } catch (_: Exception) {}
                    return null
                }
                src.delete()
                Saved(uri, "Movies/$FOLDER")
            } else {
                // Android 5–9: copy to public Movies (needs storage permission, which this app requests).
                val dir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), FOLDER)
                dir.mkdirs()
                val dest = File(dir, src.name)
                src.copyTo(dest, overwrite = true)
                src.delete()
                var found: Uri? = null
                val latch = CountDownLatch(1)
                MediaScannerConnection.scanFile(this, arrayOf(dest.absolutePath), arrayOf("video/mp4")) { _, u ->
                    found = u
                    latch.countDown()
                }
                latch.await(3, TimeUnit.SECONDS)
                Saved(found, "Movies/$FOLDER")
            }
        } catch (e: Exception) {
            null
        }
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(
                NotificationChannel(CHANNEL_ID, "Screen recorder", NotificationManager.IMPORTANCE_LOW)
            )
        }
    }

    private fun buildNotification(text: String, recording: Boolean): Notification {
        val stopPi = PendingIntent.getService(
            this, 0,
            Intent(this, ScreenRecordService::class.java).setAction(actionStop(this)),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val b = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_qs_recorder)
            .setContentTitle("RizwanS2 Screen Recorder")
            .setContentText(text)
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_LOW)
        if (recording) {
            b.setUsesChronometer(true).setWhen(startedAt).setShowWhen(true)
            b.addAction(R.drawable.ic_qs_recorder, "Stop", stopPi)
            b.setContentIntent(stopPi)
        }
        return b.build()
    }

    private fun buildDoneNotification(saved: Saved): Notification {
        val b = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_qs_recorder)
            .setContentTitle("Screen recording saved")
            .setContentText(saved.where)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
        if (saved.uri != null) {
            val view = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(saved.uri, "video/mp4")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            b.setContentIntent(
                PendingIntent.getActivity(
                    this, 1, view,
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                )
            )
        }
        return b.build()
    }

    private fun postNotification(id: Int, n: Notification) {
        try {
            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(id, n)
        } catch (_: Exception) {}
    }

    private fun toast(msg: String) {
        handler.post { Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show() }
    }
}
