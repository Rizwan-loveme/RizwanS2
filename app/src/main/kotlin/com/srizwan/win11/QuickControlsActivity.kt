package com.srizwan.win11

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.media.projection.MediaProjectionManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** Icon-only Windows-inspired Quick Settings and notification panel. */
class QuickControlsActivity : AppCompatActivity() {
    private val bg = Color.rgb(28, 31, 38)
    private val tile = Color.rgb(53, 58, 68)
    private val accent = Color.rgb(76, 194, 255)
    private var torchOn = false
    private var notifSection: LinearLayout? = null
    private val storeListener: () -> Unit = {
        try { renderNotifications() } catch (e: Throwable) { AppLog.e("Quick", "renderNotifications failed", e) }
    }
    private var recorderTile: FrameLayout? = null
    private var flashTile: FrameLayout? = null
    private var torchId: String? = null
    private var torchUnavailable = false

    // Real torch state (also changes when another app / the system toggles the torch).
    private val torchCallback = object : CameraManager.TorchCallback() {
        override fun onTorchModeChanged(cameraId: String, enabled: Boolean) {
            if (cameraId == torchId) {
                torchOn = enabled
                torchUnavailable = false
                updateFlashTile()
            }
        }
        override fun onTorchModeUnavailable(cameraId: String) {
            if (cameraId == torchId) torchUnavailable = true
        }
    }

    // Screenshot (MediaProjection path): consent dialog -> ScreenshotService.
    private val shotLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { res ->
        val data = res.data
        if (res.resultCode == RESULT_OK && data != null) {
            ScreenshotService.start(this, res.resultCode, data)
            finish()
        } else {
            Toast.makeText(this, "Screenshot cancelled", Toast.LENGTH_SHORT).show()
        }
    }
    private var recordWithMic = false

    // Screen recorder: Android's own screen-capture consent dialog -> start the service.
    private val projectionLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { res ->
        val data = res.data
        if (res.resultCode == RESULT_OK && data != null) {
            ScreenRecordService.start(this, res.resultCode, data, recordWithMic)
            Toast.makeText(this, "Recording starts in a moment. Stop it from the notification or this tile.", Toast.LENGTH_LONG).show()
            finish()
        } else {
            Toast.makeText(this, "Screen recording cancelled", Toast.LENGTH_SHORT).show()
        }
    }
    private val micPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        recordWithMic = granted
        if (!granted) Toast.makeText(this, "Microphone not allowed - recording without audio", Toast.LENGTH_SHORT).show()
        requestScreenCapture()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLog.i("Quick", "onCreate")
        try {
            @Suppress("DEPRECATION")
            window.statusBarColor = bg
            @Suppress("DEPRECATION")
            window.navigationBarColor = bg
        } catch (e: Throwable) { AppLog.w("Quick", "system bar colors failed", e) }

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(12), dp(12), dp(12), dp(12))
            setBackgroundColor(bg)
        }
        // No visible headings or tile labels: controls are vector-icon-only.
        val scroll = ScrollView(this)
        val body = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        scroll.addView(body)
        val grid = GridLayout(this).apply { columnCount = 3; useDefaultMargins = false }
        body.addView(grid)

        recorderTile = addTile(grid, R.drawable.ic_qs_recorder, "Screen recorder") { onRecorderTap() }
        addTile(grid, R.drawable.ic_qs_screenshot, "Capture screenshot") { onScreenshotTap() }
        addTile(grid, R.drawable.ic_qs_power, "Power menu") { onPowerTap() }
        addTile(grid, R.drawable.ic_qs_wifi, "Wi-Fi") { openPanel("android.settings.panel.action.INTERNET_CONNECTIVITY", Settings.ACTION_WIFI_SETTINGS) }
        addTile(grid, R.drawable.ic_qs_bluetooth, "Bluetooth") { startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS)) }
        addTile(grid, R.drawable.ic_qs_location, "Location / GPS") { startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)) }
        addTile(grid, R.drawable.ic_qs_ring, "Normal ring mode") { setRinger(AudioManager.RINGER_MODE_NORMAL) }
        addTile(grid, R.drawable.ic_qs_vibrate, "Vibrate mode") { setRinger(AudioManager.RINGER_MODE_VIBRATE) }
        addTile(grid, R.drawable.ic_qs_silent, "Silent mode") { setRinger(AudioManager.RINGER_MODE_SILENT) }
        addTile(grid, R.drawable.ic_qs_rotate, "Screen rotation settings") { startActivity(Intent(Settings.ACTION_DISPLAY_SETTINGS)) }
        addTile(grid, R.drawable.ic_qs_volume_up, "Volume up") { volume(AudioManager.ADJUST_RAISE) }
        addTile(grid, R.drawable.ic_qs_volume_down, "Volume down") { volume(AudioManager.ADJUST_LOWER) }
        addTile(grid, R.drawable.ic_qs_airplane, "Airplane mode settings") { startActivity(Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)) }
        flashTile = addTile(grid, R.drawable.ic_qs_flashlight, "Flashlight") { toggleTorch() }
        addTile(grid, R.drawable.ic_qs_notifications, "Debug log") { startActivity(Intent(this, DebugLogActivity::class.java)) }

        // Windows-style notification center (filled by renderNotifications()).
        val section = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        body.addView(section)
        notifSection = section
        try { renderNotifications() } catch (e: Throwable) { AppLog.e("Quick", "renderNotifications failed", e) }
        root.addView(scroll, LinearLayout.LayoutParams(-1, 0, 1f))
        root.addView(ImageButton(this).apply {
            setImageResource(R.drawable.ic_qs_close)
            contentDescription = "Close quick settings"
            setColorFilter(Color.WHITE)
            background = null
            setPadding(dp(10), dp(10), dp(10), dp(10))
            setOnClickListener { finish() }
        }, LinearLayout.LayoutParams(dp(48), dp(48)).apply { gravity = Gravity.END })
        setContentView(root)

        // Android 15+ draws edge-to-edge: keep the panel clear of the status / navigation bars.
        val pad = dp(12)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            v.setPadding(bars.left + pad, bars.top + pad, bars.right + pad, bars.bottom + pad)
            WindowInsetsCompat.CONSUMED
        }
        ViewCompat.requestApplyInsets(root)
    }

    private fun addTile(parent: GridLayout, iconRes: Int, description: String, action: () -> Unit): FrameLayout {
        val button = FrameLayout(this).apply {
            setBackgroundColor(tile)
            isClickable = true
            isFocusable = true
            contentDescription = description
            setOnClickListener {
                AppLog.d("Quick", "tap: $description")
                try { action() } catch (e: Throwable) {
                    AppLog.e("Quick", "tile '$description' failed", e)
                    Toast.makeText(this@QuickControlsActivity, "$description: not available on this device", Toast.LENGTH_SHORT).show()
                }
            }
            val icon = ImageView(this@QuickControlsActivity).apply {
                try { setImageResource(iconRes) } catch (e: Throwable) { AppLog.e("Quick", "icon for '$description' failed", e) }
                contentDescription = description
                setColorFilter(Color.WHITE)
                scaleType = ImageView.ScaleType.FIT_CENTER
            }
            addView(icon, FrameLayout.LayoutParams(dp(32), dp(32), Gravity.CENTER))
        }
        val p = GridLayout.LayoutParams().apply {
            width = 0
            height = dp(76)
            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            setMargins(dp(4), dp(4), dp(4), dp(4))
        }
        parent.addView(button, p)
        return button
    }

    private fun openPanel(panel: String, fallback: String) {
        try { if (Build.VERSION.SDK_INT >= 29) startActivity(Intent(panel)) else startActivity(Intent(fallback)) }
        catch (_: Exception) { startActivity(Intent(fallback)) }
    }
    private fun setRinger(mode: Int) {
        try {
            val audio = getSystemService(Context.AUDIO_SERVICE) as AudioManager
            audio.ringerMode = mode
            Toast.makeText(this, "Ring mode updated", Toast.LENGTH_SHORT).show()
        } catch (_: SecurityException) {
            Toast.makeText(this, "Allow Do Not Disturb access for Silent mode", Toast.LENGTH_LONG).show()
            startActivity(Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS))
        } catch (_: Exception) { Toast.makeText(this, "This mode is restricted by Android", Toast.LENGTH_SHORT).show() }
    }
    private fun volume(direction: Int) {
        (getSystemService(Context.AUDIO_SERVICE) as AudioManager).adjustVolume(direction, AudioManager.FLAG_SHOW_UI)
    }
    // ── Flashlight ────────────────────────────────────────────────────
    private fun findTorchId(cm: CameraManager): String? = try {
        val withFlash = cm.cameraIdList.filter {
            cm.getCameraCharacteristics(it).get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        }
        withFlash.firstOrNull {
            cm.getCameraCharacteristics(it).get(CameraCharacteristics.LENS_FACING) == CameraCharacteristics.LENS_FACING_BACK
        } ?: withFlash.firstOrNull()
    } catch (_: Exception) { null }

    override fun onStart() {
        super.onStart()
        NotificationStore.addListener(storeListener)
        try { renderNotifications() } catch (e: Throwable) { AppLog.e("Quick", "renderNotifications failed", e) }
        try {
            val cm = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            if (torchId == null) torchId = findTorchId(cm)
            if (torchId != null) cm.registerTorchCallback(torchCallback, Handler(Looper.getMainLooper()))
        } catch (_: Exception) {}
    }

    override fun onStop() {
        NotificationStore.removeListener(storeListener)
        try { (getSystemService(Context.CAMERA_SERVICE) as CameraManager).unregisterTorchCallback(torchCallback) } catch (_: Exception) {}
        super.onStop()
    }

    private fun updateFlashTile() {
        val t = flashTile ?: return
        (t.getChildAt(0) as? ImageView)?.setColorFilter(if (torchOn) Color.rgb(255, 214, 0) else Color.WHITE)
        t.contentDescription = if (torchOn) "Flashlight off" else "Flashlight (brightest)"
    }

    /** Toggle the torch at the brightest level the device supports (Android 13+), plain on/off otherwise. */
    private fun toggleTorch() {
        try {
            val cm = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            val id = torchId ?: findTorchId(cm)
            if (id == null) {
                Toast.makeText(this, "This device has no flashlight", Toast.LENGTH_SHORT).show()
                return
            }
            torchId = id
            if (torchOn) {
                cm.setTorchMode(id, false)
            } else if (Build.VERSION.SDK_INT >= 33) {
                // FIX: the old code hard-coded level 5; most phones only support level 1, so the
                // call threw and the torch never turned on. Use the device's real maximum.
                val max = cm.getCameraCharacteristics(id)
                    .get(CameraCharacteristics.FLASH_INFO_STRENGTH_MAXIMUM_LEVEL) ?: 1
                if (max > 1) cm.turnOnTorchWithStrengthLevel(id, max) else cm.setTorchMode(id, true)
            } else {
                cm.setTorchMode(id, true)
            }
        } catch (e: CameraAccessException) {
            Toast.makeText(this, "Camera is in use by another app", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Flashlight unavailable on this device", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        updateRecorderTile()
    }

    /** Red icon + "stop" description while a recording is running. */
    private fun updateRecorderTile() {
        val tileView = recorderTile ?: return
        val recording = ScreenRecordService.isRecording
        (tileView.getChildAt(0) as? ImageView)?.setColorFilter(if (recording) Color.rgb(255, 82, 82) else Color.WHITE)
        tileView.contentDescription = if (recording) "Stop screen recording" else "Screen recorder"
    }

    private fun onRecorderTap() {
        if (ScreenRecordService.isRecording) {
            ScreenRecordService.stop(this)
            Toast.makeText(this, "Stopping recording... it will be saved to Movies/RizwanS2", Toast.LENGTH_LONG).show()
            recorderTile?.let { t ->
                (t.getChildAt(0) as? ImageView)?.setColorFilter(Color.WHITE)
                t.contentDescription = "Screen recorder"
            }
            return
        }
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Screen Recorder")
            .setItems(arrayOf("Screen only", "Screen + microphone")) { _, which ->
                if (which == 1) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
                        recordWithMic = true
                        requestScreenCapture()
                    } else {
                        micPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    }
                } else {
                    recordWithMic = false
                    requestScreenCapture()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun requestScreenCapture() {
        try {
            val mpm = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
            projectionLauncher.launch(mpm.createScreenCaptureIntent())
        } catch (e: Exception) {
            Toast.makeText(this, "Screen recording is not available on this device", Toast.LENGTH_LONG).show()
        }
    }
    // ── Notification center (Windows style) ──────────────────────────
    private fun renderNotifications() {
        val sec = notifSection ?: return
        sec.removeAllViews()
        val items = NotificationStore.snapshot()

        // Header: bell + title + "Clear all"
        val header = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(4), dp(18), dp(4), dp(8))
        }
        header.addView(ImageView(this).apply {
            setImageResource(R.drawable.ic_qs_notifications)
            setColorFilter(Color.WHITE)
        }, LinearLayout.LayoutParams(dp(22), dp(22)))
        header.addView(TextView(this).apply {
            text = "Notifications"
            setTextColor(Color.WHITE); textSize = 16f
            typeface = Typeface.DEFAULT_BOLD
            setPadding(dp(10), 0, 0, 0)
        })
        header.addView(View(this), LinearLayout.LayoutParams(0, 1, 1f))
        if (items.isNotEmpty()) {
            header.addView(TextView(this).apply {
                text = "Clear all"
                setTextColor(accent); textSize = 13f
                setPadding(dp(10), dp(8), dp(10), dp(8))
                isClickable = true
                setOnClickListener { NotificationStore.clearAll() }
            })
        }
        sec.addView(header)

        // Notification access is required to read other apps' notifications.
        if (!WhatsAppNotificationListener.isEnabled(this)) {
            sec.addView(infoCard(
                "Turn on notification access to see your phone's notifications here.",
                "Turn on"
            ) {
                try { startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)) } catch (_: Exception) {}
            })
            return
        }
        if (items.isEmpty()) {
            sec.addView(TextView(this).apply {
                text = "No new notifications"
                setTextColor(Color.LTGRAY); alpha = 0.7f; textSize = 14f
                gravity = Gravity.CENTER
                setPadding(0, dp(28), 0, dp(28))
            }, LinearLayout.LayoutParams(-1, -2))
            return
        }

        // One group per app, newest group first.
        items.groupBy { it.pkg }.entries.sortedByDescending { it.value.first().time }.forEach { (pkg, list) ->
            val gh = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(4), dp(10), dp(4), dp(4))
            }
            gh.addView(ImageView(this).apply {
                val ic = appIcon(pkg)
                if (ic != null) setImageDrawable(ic) else { setImageResource(R.drawable.ic_qs_notifications); setColorFilter(accent) }
            }, LinearLayout.LayoutParams(dp(18), dp(18)))
            gh.addView(TextView(this).apply {
                text = if (list.size > 1) "${list.first().app}  ·  ${list.size}" else list.first().app
                setTextColor(Color.LTGRAY); textSize = 12f
                setPadding(dp(8), 0, 0, 0)
            })
            gh.addView(View(this), LinearLayout.LayoutParams(0, 1, 1f))
            gh.addView(TextView(this).apply {
                text = "Clear"
                setTextColor(accent); textSize = 12f
                setPadding(dp(10), dp(6), dp(10), dp(6))
                isClickable = true
                setOnClickListener { NotificationStore.clearApp(pkg) }
            })
            sec.addView(gh)
            list.forEach { sec.addView(notifCard(it), LinearLayout.LayoutParams(-1, -2).apply { bottomMargin = dp(6) }) }
        }
    }

    private fun notifCard(item: NotifItem): View {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.TOP
            setPadding(dp(12), dp(10), dp(4), dp(10))
            background = GradientDrawable().apply { setColor(tile); cornerRadius = dp(8).toFloat() }
            isClickable = true
            isFocusable = true
            setOnClickListener { openNotification(item) }
        }
        val col = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        if (item.title.isNotEmpty()) col.addView(TextView(this).apply {
            text = item.title
            setTextColor(Color.WHITE); textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1; ellipsize = TextUtils.TruncateAt.END
        })
        if (item.text.isNotEmpty()) col.addView(TextView(this).apply {
            text = item.text
            setTextColor(Color.LTGRAY); textSize = 12f
            maxLines = 3; ellipsize = TextUtils.TruncateAt.END
            setPadding(0, dp(2), 0, 0)
        })
        card.addView(col, LinearLayout.LayoutParams(0, -2, 1f))

        val right = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.END
        }
        right.addView(TextView(this).apply {
            text = ago(item.time)
            setTextColor(Color.GRAY); textSize = 11f
            setPadding(dp(8), 0, dp(8), 0)
        })
        right.addView(TextView(this).apply {
            text = "\u2715"
            setTextColor(Color.LTGRAY); textSize = 15f
            gravity = Gravity.CENTER
            setPadding(dp(8), dp(4), dp(8), dp(4))
            contentDescription = "Dismiss notification"
            isClickable = true
            setOnClickListener { NotificationStore.dismiss(item.key) }
        })
        card.addView(right, LinearLayout.LayoutParams(-2, -2))
        return card
    }

    private fun infoCard(message: String, button: String, onClick: () -> Unit): View {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(14), dp(12), dp(14), dp(12))
            background = GradientDrawable().apply { setColor(tile); cornerRadius = dp(8).toFloat() }
        }
        card.addView(TextView(this).apply { text = message; setTextColor(Color.LTGRAY); textSize = 13f })
        card.addView(TextView(this).apply {
            text = button
            setTextColor(accent); textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            setPadding(0, dp(10), 0, 0)
            isClickable = true
            setOnClickListener { onClick() }
        })
        return card
    }

    private fun appIcon(pkg: String): Drawable? = try { packageManager.getApplicationIcon(pkg) } catch (_: Exception) { null }

    private fun ago(t: Long): String {
        val minutes = (System.currentTimeMillis() - t) / 60000
        return when {
            minutes < 1 -> "now"
            minutes < 60 -> "${minutes}m"
            minutes < 1440 -> "${minutes / 60}h"
            else -> SimpleDateFormat("d MMM", Locale.getDefault()).format(Date(t))
        }
    }

    /** Tap on a card: run the notification's own action (opens the app/chat), else just launch the app. */
    private fun openNotification(item: NotifItem) {
        var opened = false
        try {
            item.intent?.let { it.send(); opened = true }
        } catch (_: Exception) {}
        if (!opened) {
            try {
                packageManager.getLaunchIntentForPackage(item.pkg)?.let { startActivity(it); opened = true }
            } catch (_: Exception) {}
        }
        if (!opened) {
            Toast.makeText(this, "Could not open this notification", Toast.LENGTH_SHORT).show()
            return
        }
        if (item.autoCancel) NotificationStore.dismiss(item.key)
        finish()
    }

    // ── Power popup (Android 5.0+) ────────────────────────────────────
    private fun onPowerTap() {
        if (!PowerService.isEnabled) {
            androidx.appcompat.app.AlertDialog.Builder(this)
                .setMessage("Turn on \"Win11 Power and Lock\" in Accessibility settings to use the power popup. It does not read your screen.")
                .setPositiveButton("Open settings") { _, _ -> startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }
                .setNegativeButton("Cancel", null).show()
            return
        }
        if (!PowerService.powerDialog()) {
            Toast.makeText(this, "Could not open the power menu. Hold the physical power button instead.", Toast.LENGTH_LONG).show()
        }
    }

    // ── Screenshot ────────────────────────────────────────────────────
    private fun onScreenshotTap() {
        if (Build.VERSION.SDK_INT >= 28 && PowerService.isEnabled) {
            // One tap: system screenshot via the accessibility service. Close the panel first
            // so it is not part of the picture.
            val appCtx = applicationContext
            finish()
            Handler(Looper.getMainLooper()).postDelayed({
                if (!PowerService.screenshot()) {
                    Toast.makeText(appCtx, "Screenshot failed. Re-enable the accessibility service.", Toast.LENGTH_LONG).show()
                }
            }, 700)
            return
        }
        if (Build.VERSION.SDK_INT >= 28) {
            androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Capture Screenshot")
                .setItems(arrayOf(
                    "Use screen-capture permission (asks each time)",
                    "Enable one-tap screenshot: turn on \"Win11 Power and Lock\" in Accessibility (also enables power popup)"
                )) { _, which ->
                    if (which == 0) requestShotCapture()
                    else startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
                }
                .setNegativeButton("Cancel", null)
                .show()
        } else {
            requestShotCapture()
        }
    }

    private fun requestShotCapture() {
        try {
            val mpm = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
            shotLauncher.launch(mpm.createScreenCaptureIntent())
        } catch (e: Exception) {
            Toast.makeText(this, "Screenshot is not available on this device", Toast.LENGTH_LONG).show()
        }
    }
    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()
}
