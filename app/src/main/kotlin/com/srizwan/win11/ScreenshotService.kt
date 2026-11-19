package com.srizwan.win11

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.graphics.Bitmap
import android.graphics.PixelFormat
import android.hardware.display.DisplayManager
import android.hardware.display.VirtualDisplay
import android.media.Image
import android.media.ImageReader
import android.media.MediaScannerConnection
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Looper
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Screenshot via MediaProjection (used when the one-tap Accessibility screenshot is not
 * enabled). Android shows its screen-capture consent dialog first; after that this service
 * grabs a single frame of the whole screen and saves a PNG to Pictures/RizwanS2.
 */
class ScreenshotService : Service() {

    companion object {
        private const val CHANNEL_ID = "screen_capture"
        private const val NOTIF_ID = 7311
        private const val NOTIF_DONE_ID = 7312
        private const val EXTRA_CODE = "result_code"
        private const val EXTRA_DATA = "result_data"
        private const val START_DELAY_MS = 700L
        private const val TIMEOUT_MS = 4000L
        private const val FOLDER = "RizwanS2"

        fun start(ctx: Context, resultCode: Int, data: Intent) {
            val i = Intent(ctx, ScreenshotService::class.java).apply {
                putExtra(EXTRA_CODE, resultCode)
                putExtra(EXTRA_DATA, data)
            }
            ContextCompat.startForegroundService(ctx, i)
        }
    }

    private class Saved(val uri: Uri?, val where: String)

    private val handler = Handler(Looper.getMainLooper())
    private val running = AtomicBoolean(false)
    private val taken = AtomicBoolean(false)
    private val finished = AtomicBoolean(false)
    private var projection: MediaProjection? = null
    private var projectionCallback: MediaProjection.Callback? = null
    private var reader: ImageReader? = null
    private var virtualDisplay: VirtualDisplay? = null
    private var worker: HandlerThread? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        AppLog.i("Screenshot", "onStartCommand")
        if (!running.compareAndSet(false, true)) return START_NOT_STICKY
        val code = intent?.getIntExtra(EXTRA_CODE, 0) ?: 0
        val data = readData(intent)
        if (data == null) {
            running.set(false)
            stopSelf()
            return START_NOT_STICKY
        }
        createChannel()
        try {
            val notif = ongoingNotification()
            if (Build.VERSION.SDK_INT >= 29) {
                // Android 14+: the mediaProjection foreground service must be running
                // before getMediaProjection() is called.
                startForeground(NOTIF_ID, notif, ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PROJECTION)
            } else {
                startForeground(NOTIF_ID, notif)
            }
        } catch (e: Exception) {
            AppLog.e("Screenshot", "startForeground failed", e)
            toast("Could not start screenshot: ${e.message}")
            running.set(false)
            stopSelf()
            return START_NOT_STICKY
        }
        // Short delay so the consent dialog is gone from the screen before we capture.
        handler.postDelayed({ capture(code, data) }, START_DELAY_MS)
        return START_NOT_STICKY
    }

    @Suppress("DEPRECATION")
    private fun readData(intent: Intent?): Intent? =
        if (Build.VERSION.SDK_INT >= 33) intent?.getParcelableExtra(EXTRA_DATA, Intent::class.java)
        else intent?.getParcelableExtra(EXTRA_DATA)

    private fun capture(code: Int, data: Intent) {
        if (finished.get()) return
        try {
            val mpm = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
            val proj = mpm.getMediaProjection(code, data)
                ?: throw IllegalStateException("Screen capture permission was not granted")
            projection = proj
            // Android 14+: a callback MUST be registered before createVirtualDisplay().
            val cb = object : MediaProjection.Callback() {
                override fun onStop() { /* released by us in cleanup() */ }
            }
            projectionCallback = cb
            proj.registerCallback(cb, handler)

            val (w, h, dpi) = screenSize()
            val thread = HandlerThread("RizwanS2Shot").also { it.start() }
            worker = thread
            val ir = ImageReader.newInstance(w, h, PixelFormat.RGBA_8888, 2)
            reader = ir
            ir.setOnImageAvailableListener(object : ImageReader.OnImageAvailableListener {
                override fun onImageAvailable(r: ImageReader) {
                    if (taken.get()) return
                    val img = (try { r.acquireLatestImage() } catch (_: Exception) { null }) ?: return
                    if (!taken.compareAndSet(false, true)) { img.close(); return }
                    var saved: Saved? = null
                    try {
                        val bmp = toBitmap(img, w, h)
                        saved = saveBitmap(bmp)
                        bmp.recycle()
                    } catch (e: Exception) {
                        AppLog.e("Screenshot", "saving image failed", e)
                    } finally {
                        img.close()
                    }
                    val result = saved
                    handler.post { complete(result) }
                }
            }, Handler(thread.looper))

            virtualDisplay = proj.createVirtualDisplay(
                "RizwanS2Shot", w, h, dpi,
                DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR,
                ir.surface, null, null
            )
            handler.postDelayed({
                if (!taken.get()) {
                    toast("Screenshot timed out. Try again.")
                    complete(null, silent = true)
                }
            }, TIMEOUT_MS)
        } catch (e: Exception) {
            AppLog.e("Screenshot", "capture failed", e)
            toast("Could not take screenshot: ${e.message ?: e.javaClass.simpleName}")
            complete(null, silent = true)
        }
    }

    private fun complete(saved: Saved?, silent: Boolean = false) {
        if (!finished.compareAndSet(false, true)) return
        handler.removeCallbacksAndMessages(null)
        cleanup()
        if (saved != null) {
            toast("Screenshot saved: ${saved.where}")
            postNotification(NOTIF_DONE_ID, doneNotification(saved))
        } else if (!silent) {
            toast("Could not save the screenshot")
        }
        endService()
    }

    private fun cleanup() {
        try { virtualDisplay?.release() } catch (_: Exception) {}
        virtualDisplay = null
        try { reader?.close() } catch (_: Exception) {}
        reader = null
        val p = projection
        if (p != null) {
            projectionCallback?.let { try { p.unregisterCallback(it) } catch (_: Exception) {} }
            try { p.stop() } catch (_: Exception) {}
        }
        projectionCallback = null
        projection = null
        worker?.quitSafely()
        worker = null
    }

    @Suppress("DEPRECATION")
    private fun endService() {
        if (Build.VERSION.SDK_INT >= 24) stopForeground(STOP_FOREGROUND_REMOVE)
        else stopForeground(true)
        running.set(false)
        stopSelf()
    }

    override fun onDestroy() {
        if (finished.compareAndSet(false, true)) {
            handler.removeCallbacksAndMessages(null)
            cleanup()
        }
        super.onDestroy()
    }

    // ── helpers ───────────────────────────────────────────────────────

    @Suppress("DEPRECATION")
    private fun screenSize(): Triple<Int, Int, Int> {
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val w: Int
        val h: Int
        if (Build.VERSION.SDK_INT >= 30) {
            val b = wm.maximumWindowMetrics.bounds
            w = b.width(); h = b.height()
        } else {
            val m = DisplayMetrics()
            wm.defaultDisplay.getRealMetrics(m)
            w = m.widthPixels; h = m.heightPixels
        }
        return Triple(w, h, resources.displayMetrics.densityDpi)
    }

    private fun toBitmap(img: Image, w: Int, h: Int): Bitmap {
        val plane = img.planes[0]
        val pixelStride = plane.pixelStride
        val rowPadding = plane.rowStride - pixelStride * w
        val padded = Bitmap.createBitmap(w + rowPadding / pixelStride, h, Bitmap.Config.ARGB_8888)
        padded.copyPixelsFromBuffer(plane.buffer)
        if (padded.width == w) return padded
        val cropped = Bitmap.createBitmap(padded, 0, 0, w, h)
        padded.recycle()
        return cropped
    }

    private fun saveBitmap(bmp: Bitmap): Saved? {
        val name = "Screenshot_" + SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date()) + ".png"
        return try {
            if (Build.VERSION.SDK_INT >= 29) {
                val values = ContentValues().apply {
                    put(MediaStore.Images.Media.DISPLAY_NAME, name)
                    put(MediaStore.Images.Media.MIME_TYPE, "image/png")
                    put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/" + FOLDER)
                    put(MediaStore.Images.Media.IS_PENDING, 1)
                }
                val uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
                    ?: return null
                try {
                    contentResolver.openOutputStream(uri)?.use { out ->
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, out)
                    } ?: throw IllegalStateException("Cannot open output")
                    val done = ContentValues().apply { put(MediaStore.Images.Media.IS_PENDING, 0) }
                    contentResolver.update(uri, done, null, null)
                } catch (e: Exception) {
                    try { contentResolver.delete(uri, null, null) } catch (_: Exception) {}
                    return null
                }
                Saved(uri, "Pictures/$FOLDER")
            } else {
                // Android 7–9: public Pictures folder (needs storage permission); else app folder.
                var dir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), FOLDER)
                var where = "Pictures/$FOLDER"
                var file = File(dir, name)
                try {
                    dir.mkdirs()
                    FileOutputStream(file).use { bmp.compress(Bitmap.CompressFormat.PNG, 100, it) }
                } catch (_: Exception) {
                    dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES) ?: cacheDir
                    dir.mkdirs()
                    file = File(dir, name)
                    where = file.absolutePath
                    FileOutputStream(file).use { bmp.compress(Bitmap.CompressFormat.PNG, 100, it) }
                }
                var found: Uri? = null
                val latch = CountDownLatch(1)
                MediaScannerConnection.scanFile(this, arrayOf(file.absolutePath), arrayOf("image/png")) { _, u ->
                    found = u
                    latch.countDown()
                }
                latch.await(3, TimeUnit.SECONDS)
                Saved(found, where)
            }
        } catch (e: Exception) {
            null
        }
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(
                NotificationChannel(CHANNEL_ID, "Screenshots", NotificationManager.IMPORTANCE_LOW)
            )
        }
    }

    private fun ongoingNotification(): Notification =
        NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_qs_screenshot)
            .setContentTitle("RizwanS2 Screenshot")
            .setContentText("Capturing screen…")
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setCategory(NotificationCompat.CATEGORY_SERVICE)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()

    private fun doneNotification(saved: Saved): Notification {
        val b = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_qs_screenshot)
            .setContentTitle("Screenshot saved")
            .setContentText(saved.where)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_LOW)
        if (saved.uri != null) {
            val view = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(saved.uri, "image/png")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            b.setContentIntent(
                PendingIntent.getActivity(
                    this, 2, view,
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
