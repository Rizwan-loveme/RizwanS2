package com.srizwan.win11

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
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
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Windows 11 style flyout, docked to the right of the screen just above the taskbar:
 *   - top    : notification center (+ calendar), scrollable
 *   - bottom : Quick Settings tiles, then brightness and volume sliders
 * No close button: tap anywhere outside the panel (or press Back) to dismiss it.
 */
class QuickControlsActivity : AppCompatActivity() {
    private val tile = Color.argb(64, 255, 255, 255)
    private val accent = Color.rgb(76, 194, 255)
    private val darkIcon = Color.rgb(16, 20, 28)
    private val recRed = Color.rgb(255, 82, 82)
    private var torchOn = false
    private var notifSection: LinearLayout? = null
    private var calSection: LinearLayout? = null
    private val calMonth: Calendar = Calendar.getInstance()
    private val collapsedGroups = HashSet<String>()
    private val showAllGroups = HashSet<String>()
    private val cardBorder = Color.argb(28, 255, 255, 255)
    private val storeListener: () -> Unit = {
        try { renderNotifications() } catch (e: Throwable) { AppLog.e("Quick", "renderNotifications failed", e) }
    }

    private class QTile(val frame: FrameLayout, val icon: ImageView)
    private class SRow(val row: LinearLayout, val icon: ImageView, val slider: GlassSlider)
    private val tiles = HashMap<String, QTile>()
    private var panel: LinearLayout? = null
    private var briRow: SRow? = null
    private var volRow: SRow? = null
    private var lastVolume = 0
    private var closing = false
    /** Runs once after the user comes back from a permission screen with the permission granted. */
    private var pendingAfterGrant: (() -> Unit)? = null
    private var pendingNeedsWrite = false
    private var pendingNeedsPolicy = false

    private var torchId: String? = null
    private var torchUnavailable = false
    private val audio by lazy { getSystemService(Context.AUDIO_SERVICE) as AudioManager }

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

    // Wi-Fi / Bluetooth / ringer / location / airplane / hardware-volume changes keep the tiles truthful.
    private val stateReceiver = object : BroadcastReceiver() {
        override fun onReceive(c: Context?, i: Intent?) {
            try { refreshState() } catch (e: Throwable) { AppLog.w("Quick", "refresh failed", e) }
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
    // Android 12+: turning Bluetooth on/off needs the "Nearby devices" (BLUETOOTH_CONNECT) permission.
    private val btPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        if (granted) onBluetoothTap()
        else {
            Toast.makeText(this, "Allow Nearby devices to switch Bluetooth from here", Toast.LENGTH_LONG).show()
            try { startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS)) } catch (_: Exception) {}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLog.i("Quick", "onCreate")
        quietTransition(open = true)
        try {
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
            window.setDimAmount(0.28f)
            if (Build.VERSION.SDK_INT >= 31) {
                val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
                if (wm.isCrossWindowBlurEnabled) {
                    window.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                    window.attributes = window.attributes.apply { blurBehindRadius = dp(18) }
                }
            }
            @Suppress("DEPRECATION")
            window.statusBarColor = Color.TRANSPARENT
            @Suppress("DEPRECATION")
            window.navigationBarColor = Color.TRANSPARENT
        } catch (e: Throwable) { AppLog.w("Quick", "glass window setup failed", e) }

        // Full-screen transparent layer: a tap anywhere outside the panel closes it.
        val root = FrameLayout(this).apply {
            isClickable = true
            contentDescription = "Close quick settings"
            setOnClickListener { finish() }
        }

        val pw = minOf(resources.displayMetrics.widthPixels - dp(16), dp(380))
        val p = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = GradientDrawable().apply {
                cornerRadius = dp(12).toFloat()
                setColor(Color.argb(232, 30, 34, 48))
                setStroke(dp(1), Color.argb(64, 255, 255, 255))
            }
            elevation = dp(14).toFloat()
            isClickable = true   // taps on the panel itself must not reach the dismiss layer
            setPadding(dp(12), dp(10), dp(12), dp(12))
        }
        panel = p

        // ── TOP: notifications + calendar ─────────────────────────────
        val scroll = ScrollView(this).apply {
            isVerticalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
        }
        val body = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        scroll.addView(body)
        val section = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        body.addView(section)
        notifSection = section
        try { renderNotifications() } catch (e: Throwable) { AppLog.e("Quick", "renderNotifications failed", e) }
        val cal = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        body.addView(cal)
        calSection = cal
        try { renderCalendar() } catch (e: Throwable) { AppLog.e("Quick", "renderCalendar failed", e) }
        p.addView(scroll, LinearLayout.LayoutParams(-1, 0, 1f))

        p.addView(View(this).apply { setBackgroundColor(Color.argb(38, 255, 255, 255)) },
            LinearLayout.LayoutParams(-1, 1).apply { topMargin = dp(6); bottomMargin = dp(8) })

        // ── BOTTOM: quick settings tiles, then brightness + volume ────
        val quick = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        val grid = GridLayout(this).apply { columnCount = 5; useDefaultMargins = false }
        quick.addView(grid)
        buildTiles(grid)
        val bri = sliderRow(R.drawable.ic_qs_brightness, "Brightness", null)
        bri.slider.max = 254
        bri.slider.onGate = {
            if (SystemToggles.canWriteSettings(this)) true
            else { askWriteSettings("Brightness", null); false }
        }
        bri.slider.onChange = { v, user -> if (user) SystemToggles.setBrightness(this, v + 1) }
        briRow = bri
        val vol = sliderRow(R.drawable.ic_qs_volume_up, "Volume (tap to mute)") { toggleMute() }
        vol.slider.onChange = { v, user ->
            if (user) {
                try { audio.setStreamVolume(AudioManager.STREAM_MUSIC, v, 0) } catch (_: SecurityException) {}
                if (v > 0) lastVolume = v
                updateVolumeIcon(v)
            }
        }
        volRow = vol
        quick.addView(bri.row, LinearLayout.LayoutParams(-1, dp(40)).apply { topMargin = dp(6) })
        quick.addView(vol.row, LinearLayout.LayoutParams(-1, dp(40)))
        p.addView(quick, LinearLayout.LayoutParams(-1, -2))

        root.addView(p, FrameLayout.LayoutParams(pw, ViewGroup.LayoutParams.MATCH_PARENT, Gravity.END or Gravity.BOTTOM).apply {
            setMargins(dp(8), dp(8), dp(8), dp(TASKBAR_DP + 8))
        })
        setContentView(root)

        // Keep the panel clear of the status bar / cutout / navigation bar, and sitting right above the taskbar.
        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            val lp = p.layoutParams as FrameLayout.LayoutParams
            lp.setMargins(bars.left + dp(8), bars.top + dp(8), bars.right + dp(8), bars.bottom + dp(TASKBAR_DP + 8))
            p.layoutParams = lp
            WindowInsetsCompat.CONSUMED
        }
        ViewCompat.requestApplyInsets(root)

        // Slide in from the right.
        p.alpha = 0f
        p.translationX = dp(36).toFloat()
        p.animate().alpha(1f).translationX(0f).setDuration(200).setInterpolator(DecelerateInterpolator()).start()
        refreshState()
    }

    private fun buildTiles(grid: GridLayout) {
        fun t(key: String, icon: Int, desc: String, action: () -> Unit) = addTile(grid, key, icon, desc, action)
        t("wifi", R.drawable.ic_qs_wifi, "Wi-Fi") { onWifiTap() }
        t("bt", R.drawable.ic_qs_bluetooth, "Bluetooth") { onBluetoothTap() }
        t("air", R.drawable.ic_qs_airplane, "Airplane mode") { startActivity(Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS)) }
        t("loc", R.drawable.ic_qs_location, "Location / GPS") { onLocationTap() }
        t("rot", R.drawable.ic_qs_rotate, "Auto-rotate") { onRotateTap() }
        t("torch", R.drawable.ic_qs_flashlight, "Flashlight") { toggleTorch() }
        // One button for Ring -> Vibrate -> Mute (tap to cycle; the icon shows the current mode)
        t("ringer", R.drawable.ic_qs_ring, "Ring") { cycleRinger() }
        t("rec", R.drawable.ic_qs_recorder, "Screen recorder") { onRecorderTap() }
        t("shot", R.drawable.ic_qs_screenshot, "Capture screenshot") { onScreenshotTap() }
        t("power", R.drawable.ic_qs_power, "Power menu") { onPowerTap() }
        t("log", R.drawable.ic_qs_log, "Debug log") { startActivity(Intent(this, DebugLogActivity::class.java)) }
    }

    private fun addTile(parent: GridLayout, key: String, iconRes: Int, description: String, action: () -> Unit): QTile {
        val icon = ImageView(this).apply {
            try { setImageResource(iconRes) } catch (e: Throwable) { AppLog.e("Quick", "icon for '$description' failed", e) }
            contentDescription = description
            setColorFilter(Color.WHITE)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }
        val button = FrameLayout(this).apply {
            background = roundBg(tile, 8, stroke = true)
            isClickable = true
            isFocusable = true
            contentDescription = description
            setOnClickListener {
                AppLog.d("Quick", "tap: $description")
                try { action() } catch (e: Throwable) {
                    AppLog.e("Quick", "tile '$description' failed", e)
                    Toast.makeText(this@QuickControlsActivity, "$description: not available on this device", Toast.LENGTH_SHORT).show()
                }
                try { refreshState() } catch (_: Throwable) {}
            }
            addView(icon, FrameLayout.LayoutParams(dp(24), dp(24), Gravity.CENTER))
        }
        val lp = GridLayout.LayoutParams().apply {
            width = 0
            height = dp(46)
            columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            setMargins(dp(3), dp(3), dp(3), dp(3))
        }
        parent.addView(button, lp)
        val q = QTile(button, icon)
        tiles[key] = q
        return q
    }

    private fun sliderRow(iconRes: Int, desc: String, onIcon: (() -> Unit)?): SRow {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        val icon = ImageView(this).apply {
            setImageResource(iconRes)
            setColorFilter(Color.WHITE)
            contentDescription = desc
            scaleType = ImageView.ScaleType.FIT_CENTER
            setPadding(dp(10), dp(10), dp(10), dp(10))
            if (onIcon != null) {
                isClickable = true
                isFocusable = true
                setOnClickListener { try { onIcon() } catch (e: Throwable) { AppLog.w("Quick", "$desc icon failed", e) } }
            }
        }
        row.addView(icon, LinearLayout.LayoutParams(dp(40), dp(40)))
        val s = GlassSlider(this)
        row.addView(s, LinearLayout.LayoutParams(0, dp(40), 1f))
        return SRow(row, icon, s)
    }

    /** Active tile = accent fill + dark icon (Windows 11); inactive = frosted tile + white icon. */
    private fun setTile(key: String, active: Boolean, on: Int = accent, iconOn: Int = darkIcon) {
        val t = tiles[key] ?: return
        t.frame.background = roundBg(if (active) on else tile, 8, stroke = !active)
        t.icon.setColorFilter(if (active) iconOn else Color.WHITE)
    }

    /** Re-read the real state of every tile and slider. */
    private fun refreshState() {
        setTile("wifi", SystemToggles.wifiOn(this))
        setTile("bt", SystemToggles.bluetoothOn(this))
        setTile("air", SystemToggles.airplaneOn(this))
        setTile("loc", SystemToggles.locationOn(this))
        setTile("rot", SystemToggles.autoRotate(this))
        val rm = try { audio.ringerMode } catch (_: Throwable) { AudioManager.RINGER_MODE_NORMAL }
        updateRingerTile(rm)
        updateFlashTile()
        updateRecorderTile()
        syncSliders()
    }

    private fun syncSliders() {
        briRow?.slider?.let { s ->
            if (!s.dragging) s.value = SystemToggles.brightness(this) - 1
        }
        volRow?.slider?.let { s ->
            if (!s.dragging) {
                val max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
                val cur = audio.getStreamVolume(AudioManager.STREAM_MUSIC)
                s.max = max
                s.value = cur
                if (cur > 0) lastVolume = cur
                updateVolumeIcon(cur)
            }
        }
    }

    private fun updateVolumeIcon(v: Int) {
        volRow?.icon?.setImageResource(if (v <= 0) R.drawable.ic_qs_silent else R.drawable.ic_qs_volume_up)
    }

    private fun toggleMute() {
        try {
            val cur = audio.getStreamVolume(AudioManager.STREAM_MUSIC)
            val max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            if (cur > 0) {
                lastVolume = cur
                audio.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0)
            } else {
                audio.setStreamVolume(AudioManager.STREAM_MUSIC, if (lastVolume > 0) lastVolume else max / 2, 0)
            }
        } catch (_: SecurityException) {}
        syncSliders()
    }

    // ── Tile actions ──────────────────────────────────────────────────
    private fun openPanel(panel: String, fallback: String) {
        try { if (Build.VERSION.SDK_INT >= 29) startActivity(Intent(panel)) else startActivity(Intent(fallback)) }
        catch (_: Exception) { startActivity(Intent(fallback)) }
    }

    private fun onWifiTap() {
        if (SystemToggles.toggleWifiDirect(this)) return
        openPanel("android.settings.panel.action.INTERNET_CONNECTIVITY", Settings.ACTION_WIFI_SETTINGS)
    }

    private fun onBluetoothTap() {
        if (Build.VERSION.SDK_INT >= 31 &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            btPermissionLauncher.launch(Manifest.permission.BLUETOOTH_CONNECT)
            return
        }
        if (!SystemToggles.toggleBluetooth(this)) startActivity(Intent(Settings.ACTION_BLUETOOTH_SETTINGS))
    }

    private fun onLocationTap() {
        if (SystemToggles.setLocationDirect(this, !SystemToggles.locationOn(this))) return
        startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
    }

    private fun onRotateTap() {
        val act = { SystemToggles.setAutoRotate(this, !SystemToggles.autoRotate(this)); Unit }
        if (!SystemToggles.canWriteSettings(this)) { askWriteSettings("Auto-rotate", act); return }
        act()
    }

    private fun ringerName(mode: Int) = when (mode) {
        AudioManager.RINGER_MODE_NORMAL -> "Ring"
        AudioManager.RINGER_MODE_VIBRATE -> "Vibrate"
        else -> "Mute"
    }

    /** Single Ring / Vibrate / Mute button: Ring -> Vibrate -> Mute -> Ring. */
    private fun cycleRinger() {
        val cur = try { audio.ringerMode } catch (_: Throwable) { AudioManager.RINGER_MODE_NORMAL }
        setRinger(when (cur) {
            AudioManager.RINGER_MODE_NORMAL -> AudioManager.RINGER_MODE_VIBRATE
            AudioManager.RINGER_MODE_VIBRATE -> AudioManager.RINGER_MODE_SILENT
            else -> AudioManager.RINGER_MODE_NORMAL
        })
    }

    /** The one tile shows the current mode's icon; highlighted while Vibrate or Mute is active. */
    private fun updateRingerTile(rm: Int) {
        val t = tiles["ringer"] ?: return
        t.icon.setImageResource(when (rm) {
            AudioManager.RINGER_MODE_NORMAL -> R.drawable.ic_qs_ring
            AudioManager.RINGER_MODE_VIBRATE -> R.drawable.ic_qs_vibrate
            else -> R.drawable.ic_qs_silent
        })
        t.frame.contentDescription = "Sound mode: ${ringerName(rm)}. Tap to change"
        setTile("ringer", rm != AudioManager.RINGER_MODE_NORMAL)
    }

    private fun setRinger(mode: Int) {
        try {
            if (mode == AudioManager.RINGER_MODE_SILENT && !SystemToggles.hasPolicyAccess(this)) {
                askPolicyAccess { setRinger(mode) }
                return
            }
            audio.ringerMode = mode
            Toast.makeText(this, ringerName(mode), Toast.LENGTH_SHORT).show()
        } catch (_: SecurityException) {
            askPolicyAccess { setRinger(mode) }
        } catch (_: Exception) { Toast.makeText(this, "This mode is restricted by Android", Toast.LENGTH_SHORT).show() }
    }

    /** One-time "Modify system settings" permission; [then] runs automatically when the user comes back with it granted. */
    private fun askWriteSettings(what: String, then: (() -> Unit)?) {
        W11Dialog.Builder(this)
            .setTitle("Allow modify system settings")
            .setMessage("$what needs the \"Modify system settings\" permission. Turn it on for RizwanS2 on the next screen, then come back. You only need to do this once.")
            .setPositiveButton("Allow") { _, _ ->
                pendingAfterGrant = then; pendingNeedsWrite = true; pendingNeedsPolicy = false
                try { startActivity(SystemToggles.writeSettingsIntent(this)) }
                catch (_: Exception) { try { startActivity(Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)) } catch (_: Exception) {} }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun askPolicyAccess(then: (() -> Unit)?) {
        W11Dialog.Builder(this)
            .setTitle("Allow Do Not Disturb access")
            .setMessage("Silent mode needs Do Not Disturb access. Turn it on for RizwanS2 on the next screen, then come back. You only need to do this once.")
            .setPositiveButton("Allow") { _, _ ->
                pendingAfterGrant = then; pendingNeedsPolicy = true; pendingNeedsWrite = false
                try { startActivity(Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)) } catch (_: Exception) {}
            }
            .setNegativeButton("Cancel", null)
            .show()
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
        try { renderCalendar() } catch (e: Throwable) { AppLog.e("Quick", "renderCalendar failed", e) }
        try { renderNotifications() } catch (e: Throwable) { AppLog.e("Quick", "renderNotifications failed", e) }
        try {
            val f = IntentFilter().apply {
                addAction(android.net.wifi.WifiManager.WIFI_STATE_CHANGED_ACTION)
                addAction(android.bluetooth.BluetoothAdapter.ACTION_STATE_CHANGED)
                addAction(AudioManager.RINGER_MODE_CHANGED_ACTION)
                addAction("android.media.VOLUME_CHANGED_ACTION")
                addAction("android.location.MODE_CHANGED")
                addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            }
            ContextCompat.registerReceiver(this, stateReceiver, f, ContextCompat.RECEIVER_EXPORTED)
        } catch (e: Throwable) { AppLog.w("Quick", "register state receiver failed", e) }
        try {
            val cm = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            if (torchId == null) torchId = findTorchId(cm)
            if (torchId != null) cm.registerTorchCallback(torchCallback, Handler(Looper.getMainLooper()))
        } catch (_: Exception) {}
    }

    override fun onStop() {
        NotificationStore.removeListener(storeListener)
        try { unregisterReceiver(stateReceiver) } catch (_: Exception) {}
        try { (getSystemService(Context.CAMERA_SERVICE) as CameraManager).unregisterTorchCallback(torchCallback) } catch (_: Exception) {}
        super.onStop()
    }

    private fun updateFlashTile() {
        setTile("torch", torchOn)
        tiles["torch"]?.frame?.contentDescription = if (torchOn) "Flashlight off" else "Flashlight (brightest)"
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
        refreshState()
        // Back from a permission screen: finish the action the user started, automatically.
        val job = pendingAfterGrant
        if (job != null) {
            val granted = (pendingNeedsWrite && SystemToggles.canWriteSettings(this)) ||
                (pendingNeedsPolicy && SystemToggles.hasPolicyAccess(this))
            if (granted) {
                pendingAfterGrant = null; pendingNeedsWrite = false; pendingNeedsPolicy = false
                try { job(); refreshState() } catch (e: Throwable) { AppLog.w("Quick", "pending action failed", e) }
            }
        }
    }

    /** Red tile while a recording is running. */
    private fun updateRecorderTile() {
        val recording = ScreenRecordService.isRecording
        setTile("rec", recording, recRed, Color.WHITE)
        tiles["rec"]?.frame?.contentDescription = if (recording) "Stop screen recording" else "Screen recorder"
    }

    private fun onRecorderTap() {
        if (ScreenRecordService.isRecording) {
            ScreenRecordService.stop(this)
            Toast.makeText(this, "Stopping recording... it will be saved to Movies/RizwanS2", Toast.LENGTH_LONG).show()
            setTile("rec", false)
            tiles["rec"]?.frame?.contentDescription = "Screen recorder"
            return
        }
        W11Dialog.Builder(this)
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
    // ── Notification center (Windows 11 style) ───────────────────────
    private fun roundBg(color: Int, radiusDp: Int, stroke: Boolean = false) = GradientDrawable().apply {
        setColor(color); cornerRadius = dp(radiusDp).toFloat()
        if (stroke) setStroke(dp(1), cardBorder)
    }

    /** Small vector-icon button (no emoji / text glyphs). */
    private fun iconButton(res: Int, desc: String, tint: Int, sizeDp: Int = 28, padDp: Int = 7, onClick: () -> Unit): ImageView =
        ImageView(this).apply {
            setImageResource(res)
            setColorFilter(tint)
            contentDescription = desc
            setPadding(dp(padDp), dp(padDp), dp(padDp), dp(padDp))
            scaleType = ImageView.ScaleType.FIT_CENTER
            isClickable = true
            isFocusable = true
            layoutParams = LinearLayout.LayoutParams(dp(sizeDp), dp(sizeDp))
            setOnClickListener { onClick() }
        }

    private fun renderNotifications() {
        val sec = notifSection ?: return
        sec.removeAllViews()
        val items = NotificationStore.snapshot()

        // Header: bell + title + "Clear all" pill
        val header = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(4), dp(18), dp(4), dp(8))
        }
        val dnd = NotifPrefs.isDndOn(this)
        header.addView(iconButton(
            if (dnd) R.drawable.ic_qs_bell_off else R.drawable.ic_qs_notifications,
            if (dnd) "Do not disturb is on. Tap to turn off" else "Turn on do not disturb",
            if (dnd) accent else Color.WHITE, sizeDp = 32, padDp = 5
        ) {
            NotifPrefs.setDnd(this, !NotifPrefs.isDndOn(this))
            renderNotifications()
        })
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
                setTextColor(Color.WHITE); textSize = 12f
                background = roundBg(Color.argb(40, 255, 255, 255), 14)
                setPadding(dp(14), dp(6), dp(14), dp(6))
                isClickable = true
                setOnClickListener { NotificationStore.clearAll() }
            })
        }
        sec.addView(header)
        if (dnd) {
            sec.addView(TextView(this).apply {
                text = "Do not disturb is on. Pop-ups and sounds are silenced."
                setTextColor(accent); textSize = 12f
                setPadding(dp(6), 0, dp(6), dp(8))
            })
        }

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
            val empty = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER_HORIZONTAL
                setPadding(0, dp(26), 0, dp(26))
            }
            empty.addView(ImageView(this).apply {
                setImageResource(R.drawable.ic_qs_notifications)
                setColorFilter(Color.GRAY)
            }, LinearLayout.LayoutParams(dp(30), dp(30)))
            empty.addView(TextView(this).apply {
                text = "No new notifications"
                setTextColor(Color.LTGRAY); alpha = 0.8f; textSize = 14f
                gravity = Gravity.CENTER
                setPadding(0, dp(8), 0, 0)
            })
            sec.addView(empty, LinearLayout.LayoutParams(-1, -2))
            return
        }

        // One group per app, newest group first.
        items.groupBy { it.pkg }.entries.sortedByDescending { it.value.first().time }.forEach { (pkg, list) ->
            val collapsed = pkg in collapsedGroups
            val showAll = pkg in showAllGroups
            val gh = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(4), dp(10), dp(0), dp(2))
            }
            gh.addView(ImageView(this).apply {
                val ic = appIcon(pkg)
                if (ic != null) setImageDrawable(ic) else { setImageResource(R.drawable.ic_qs_notifications); setColorFilter(accent) }
            }, LinearLayout.LayoutParams(dp(16), dp(16)))
            gh.addView(TextView(this).apply {
                text = if (collapsed && list.size > 1) "${list.first().app}  \u00B7  ${list.size}" else list.first().app
                setTextColor(Color.LTGRAY); textSize = 12f
                setPadding(dp(8), 0, 0, 0)
            })
            gh.addView(View(this), LinearLayout.LayoutParams(0, 1, 1f))
            if (list.size > 1) {
                gh.addView(iconButton(
                    if (collapsed) R.drawable.ic_qs_chevron_down else R.drawable.ic_qs_chevron_up,
                    if (collapsed) "Expand notifications" else "Collapse notifications",
                    Color.LTGRAY
                ) {
                    if (!collapsedGroups.add(pkg)) collapsedGroups.remove(pkg)
                    renderNotifications()
                })
            }
            val popOn = NotifPrefs.isPkgOn(this, pkg)
            gh.addView(iconButton(
                if (popOn) R.drawable.ic_qs_notifications else R.drawable.ic_qs_bell_off,
                if (popOn) "Pop-ups from ${list.first().app} are on. Tap to turn off"
                else "Pop-ups from ${list.first().app} are off. Tap to turn on",
                if (popOn) Color.LTGRAY else accent, padDp = 7
            ) {
                NotifPrefs.setPkgOn(this, pkg, !popOn)
                renderNotifications()
            })
            gh.addView(iconButton(R.drawable.ic_qs_close, "Clear notifications from ${list.first().app}", Color.LTGRAY, padDp = 9) {
                NotificationStore.clearApp(pkg)
            })
            sec.addView(gh)
            if (collapsed) return@forEach

            val visible = if (showAll || list.size <= 3) list else list.take(3)
            visible.forEach { sec.addView(notifCard(it), LinearLayout.LayoutParams(-1, -2).apply { bottomMargin = dp(6) }) }
            if (list.size > 3) {
                sec.addView(TextView(this).apply {
                    text = if (showAll) "Show less" else "Show more (${list.size - 3})"
                    setTextColor(accent); textSize = 12f
                    gravity = Gravity.CENTER
                    setPadding(dp(8), dp(6), dp(8), dp(6))
                    isClickable = true
                    setOnClickListener {
                        if (!showAllGroups.add(pkg)) showAllGroups.remove(pkg)
                        renderNotifications()
                    }
                }, LinearLayout.LayoutParams(-1, -2))
            }
        }
    }

    private fun notifCard(item: NotifItem): View {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(14), dp(8), dp(4), dp(12))
            background = roundBg(tile, 8, stroke = true)
            isClickable = true
            isFocusable = true
            setOnClickListener { openNotification(item) }
        }
        // Row 1: title, time, dismiss (vector X)
        val top = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        top.addView(TextView(this).apply {
            text = if (item.title.isNotEmpty()) item.title else item.app
            setTextColor(Color.WHITE); textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1; ellipsize = TextUtils.TruncateAt.END
        }, LinearLayout.LayoutParams(0, -2, 1f))
        top.addView(TextView(this).apply {
            text = ago(item.time)
            setTextColor(Color.GRAY); textSize = 11f
            setPadding(dp(8), 0, dp(2), 0)
        })
        top.addView(iconButton(R.drawable.ic_qs_close, "Dismiss notification", Color.LTGRAY, sizeDp = 30, padDp = 9) {
            NotificationStore.dismiss(item.key)
        })
        card.addView(top, LinearLayout.LayoutParams(-1, -2))
        // Row 2: message text
        if (item.text.isNotEmpty()) card.addView(TextView(this).apply {
            text = item.text
            setTextColor(Color.LTGRAY); textSize = 13f
            maxLines = 3; ellipsize = TextUtils.TruncateAt.END
            setPadding(0, 0, dp(10), 0)
        })
        return card
    }

    // ── Calendar (Windows 11 notification center bottom half) ────────
    private fun renderCalendar() {
        val sec = calSection ?: return
        sec.removeAllViews()
        val today = Calendar.getInstance()

        // Full date line: "Thursday, November 19"
        sec.addView(TextView(this).apply {
            text = SimpleDateFormat("EEEE, MMMM d", Locale.getDefault()).format(today.time)
            setTextColor(Color.WHITE); textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            setPadding(dp(4), dp(20), dp(4), dp(8))
        })

        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(8), dp(6), dp(8), dp(10))
            background = roundBg(tile, 8, stroke = true)
        }
        // Month title with up / down arrows (tap the title to jump back to this month)
        val nav = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL; gravity = Gravity.CENTER_VERTICAL }
        nav.addView(TextView(this).apply {
            text = SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(calMonth.time)
            setTextColor(Color.WHITE); textSize = 14f
            setPadding(dp(6), dp(8), dp(6), dp(8))
            isClickable = true
            setOnClickListener {
                calMonth.timeInMillis = System.currentTimeMillis()
                renderCalendar()
            }
        }, LinearLayout.LayoutParams(0, -2, 1f))
        nav.addView(iconButton(R.drawable.ic_qs_chevron_up, "Previous month", Color.WHITE, sizeDp = 36, padDp = 9) {
            calMonth.add(Calendar.MONTH, -1); renderCalendar()
        })
        nav.addView(iconButton(R.drawable.ic_qs_chevron_down, "Next month", Color.WHITE, sizeDp = 36, padDp = 9) {
            calMonth.add(Calendar.MONTH, 1); renderCalendar()
        })
        card.addView(nav, LinearLayout.LayoutParams(-1, -2))

        val first = calMonth.firstDayOfWeek
        val names = DateFormatSymbols.getInstance().shortWeekdays
        val grid = GridLayout(this).apply { columnCount = 7; useDefaultMargins = false }
        fun cell(text: String, color: Int, circle: Boolean, bold: Boolean, hDp: Int): FrameLayout {
            val f = FrameLayout(this)
            f.addView(TextView(this).apply {
                this.text = text
                setTextColor(color); textSize = 12f
                gravity = Gravity.CENTER
                if (bold) typeface = Typeface.DEFAULT_BOLD
                if (circle) background = GradientDrawable().apply { shape = GradientDrawable.OVAL; setColor(accent) }
            }, FrameLayout.LayoutParams(dp(30), dp(30), Gravity.CENTER))
            val lp = GridLayout.LayoutParams().apply {
                width = 0; height = dp(hDp)
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            }
            grid.addView(f, lp)
            return f
        }
        for (i in 0 until 7) {
            val d = (first - 1 + i) % 7 + 1
            cell(names[d].take(2), Color.LTGRAY, false, false, 28)
        }
        val start = calMonth.clone() as Calendar
        start.set(Calendar.DAY_OF_MONTH, 1)
        val offset = (start.get(Calendar.DAY_OF_WEEK) - first + 7) % 7
        start.add(Calendar.DAY_OF_MONTH, -offset)
        val month = calMonth.get(Calendar.MONTH)
        for (i in 0 until 42) {
            val isToday = start.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                start.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)
            val inMonth = start.get(Calendar.MONTH) == month
            cell(
                start.get(Calendar.DAY_OF_MONTH).toString(),
                if (isToday) Color.rgb(20, 24, 30) else if (inMonth) Color.WHITE else Color.GRAY,
                isToday, isToday, 34
            )
            start.add(Calendar.DAY_OF_MONTH, 1)
        }
        card.addView(grid, LinearLayout.LayoutParams(-1, -2))
        sec.addView(card, LinearLayout.LayoutParams(-1, -2))
        sec.addView(View(this), LinearLayout.LayoutParams(-1, dp(12)))
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
            W11Dialog.Builder(this)
                .setTitle("Enable power controls")
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
            W11Dialog.Builder(this)
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

    // ── Dismiss: slide out to the right, no close button ──────────────
    override fun finish() {
        val p = panel
        if (closing || p == null) { reallyFinish(); return }
        closing = true
        p.animate().cancel()
        p.animate().alpha(0f).translationX(dp(36).toFloat()).setDuration(140)
            .withEndAction { reallyFinish() }.start()
    }

    private fun reallyFinish() {
        super.finish()
        quietTransition(open = false)
    }

    @Suppress("DEPRECATION")
    private fun quietTransition(open: Boolean) {
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                overrideActivityTransition(
                    if (open) OVERRIDE_TRANSITION_OPEN else OVERRIDE_TRANSITION_CLOSE, 0, 0)
            } else overridePendingTransition(0, 0)
        } catch (_: Throwable) {}
    }

    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()

    companion object {
        /** Taskbar height (52dp) + its 1dp top border: the panel sits right above it. */
        private const val TASKBAR_DP = 53
    }
}
