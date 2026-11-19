package com.srizwan.win11

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.media.AudioManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

/** Icon-only Windows-inspired Quick Settings and notification panel. */
class QuickControlsActivity : AppCompatActivity() {
    private val bg = Color.rgb(28, 31, 38)
    private val tile = Color.rgb(53, 58, 68)
    private val accent = Color.rgb(76, 194, 255)
    private var torchOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = bg
        window.navigationBarColor = bg

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

        addTile(grid, R.drawable.ic_qs_recorder, "Screen recorder") { showRecorderHelp() }
        addTile(grid, R.drawable.ic_qs_screenshot, "Capture screenshot") { showScreenshotHelp() }
        addTile(grid, R.drawable.ic_qs_power, "Power menu") {
            if (!PowerService.powerDialog()) androidx.appcompat.app.AlertDialog.Builder(this)
                .setMessage("Enable RizwanS2 Power and Lock in Accessibility settings to use the power popup.")
                .setPositiveButton("Open settings") { _, _ -> startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }
                .setNegativeButton("Cancel", null).show()
        }
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
        addTile(grid, R.drawable.ic_qs_flashlight, "Flashlight") { toggleTorch() }

        val notifBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(dp(4), dp(18), dp(4), dp(8))
        }
        notifBar.addView(ImageView(this).apply {
            setImageResource(R.drawable.ic_qs_notifications)
            contentDescription = "Notifications"
            setColorFilter(Color.WHITE)
        }, LinearLayout.LayoutParams(dp(28), dp(28)))
        val spacer = View(this)
        notifBar.addView(spacer, LinearLayout.LayoutParams(0, 1, 1f))
        notifBar.addView(ImageButton(this).apply {
            setImageResource(R.drawable.ic_qs_clear)
            contentDescription = "Clear notifications"
            setColorFilter(accent)
            background = null
            setPadding(dp(8), dp(8), dp(8), dp(8))
            setOnClickListener { body.findViewWithTag<View>("notification-list")?.let { (it as? LinearLayout)?.removeAllViews() } }
        }, LinearLayout.LayoutParams(dp(44), dp(44)))
        body.addView(notifBar)

        val list = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL; tag = "notification-list" }
        body.addView(list)
        val active = try { NotificationStore.items.toList().asReversed() } catch (_: Exception) { emptyList() }
        if (active.isEmpty()) {
            list.addView(ImageView(this).apply {
                setImageResource(R.drawable.ic_qs_empty)
                contentDescription = "No notifications"
                setColorFilter(Color.LTGRAY)
                alpha = 0.7f
                scaleType = ImageView.ScaleType.CENTER
                setPadding(0, dp(20), 0, dp(20))
            }, LinearLayout.LayoutParams(-1, dp(76)))
        } else active.forEach { item ->
            // Notification content remains readable; only panel chrome and control labels are icon-only.
            val card = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                setPadding(dp(12), dp(10), dp(12), dp(10))
                setBackgroundColor(tile)
            }
            card.addView(ImageView(this).apply {
                setImageResource(R.drawable.ic_qs_notifications)
                contentDescription = "Notification"
                setColorFilter(accent)
            }, LinearLayout.LayoutParams(dp(24), dp(24)))
            val textCol = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(12), 0, 0, 0)
            }
            textCol.addView(TextView(this).apply {
                text = item.first; setTextColor(Color.WHITE); textSize = 14f
                typeface = Typeface.DEFAULT_BOLD
            })
            textCol.addView(TextView(this).apply {
                text = item.second; setTextColor(Color.LTGRAY); textSize = 12f
                setPadding(0, dp(3), 0, 0)
            })
            card.addView(textCol, LinearLayout.LayoutParams(0, -2, 1f))
            val lp = LinearLayout.LayoutParams(-1, -2).apply { bottomMargin = dp(8) }
            list.addView(card, lp)
        }
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
    }

    private fun addTile(parent: GridLayout, iconRes: Int, description: String, action: () -> Unit) {
        val button = FrameLayout(this).apply {
            setBackgroundColor(tile)
            isClickable = true
            isFocusable = true
            contentDescription = description
            setOnClickListener { action() }
            val icon = ImageView(this@QuickControlsActivity).apply {
                setImageResource(iconRes)
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
    private fun toggleTorch() {
        try {
            val cm = getSystemService(Context.CAMERA_SERVICE) as CameraManager
            val id = cm.cameraIdList.firstOrNull { cm.getCameraCharacteristics(it).get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true }
                ?: throw IllegalStateException("No flash")
            torchOn = !torchOn
            if (Build.VERSION.SDK_INT >= 33 && torchOn) cm.turnOnTorchWithStrengthLevel(id, 5)
            else cm.setTorchMode(id, torchOn)
            Toast.makeText(this, if (torchOn) "Flashlight on" else "Flashlight off", Toast.LENGTH_SHORT).show()
        } catch (_: Exception) { Toast.makeText(this, "Flashlight unavailable or camera in use", Toast.LENGTH_SHORT).show() }
    }
    private fun showRecorderHelp() {
        androidx.appcompat.app.AlertDialog.Builder(this).setTitle("Screen Recorder")
            .setMessage("Android requires system screen-capture consent before recording. Use the device Quick Settings shade and choose Screen Record; RizwanS2 cannot silently record the screen.")
            .setPositiveButton("OK", null).show()
    }
    private fun showScreenshotHelp() {
        androidx.appcompat.app.AlertDialog.Builder(this).setTitle("Capture Screenshot")
            .setMessage("Use the device Power + Volume Down shortcut or the Android system screenshot option. Third-party capture requires system permission.")
            .setPositiveButton("OK", null).show()
    }
    private fun dp(v: Int) = (v * resources.displayMetrics.density).toInt()
}

object NotificationStore {
    val items: MutableList<Pair<String, String>> = java.util.Collections.synchronizedList(mutableListOf())
}
