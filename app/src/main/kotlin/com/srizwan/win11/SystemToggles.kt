package com.srizwan.win11

import android.Manifest
import android.app.Activity
import android.app.NotificationManager
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import androidx.core.location.LocationManagerCompat

/**
 * Reads the real state of the quick-setting tiles and flips each one directly whenever Android
 * allows it for a normal app. Whatever Android does not allow falls back to the system screen
 * (the caller opens it), so every tile always does something useful.
 *
 *  - Brightness, auto-rotate     : "Modify system settings" (WRITE_SETTINGS) - asked once, then automatic.
 *  - Silent mode                 : "Do Not Disturb access" - asked once, then automatic.
 *  - Wi-Fi                       : direct on Android 9 and older; Android 10+ shows the system Internet panel.
 *  - Bluetooth                   : direct up to Android 12L; Android 13+ shows the system "turn on" prompt.
 *  - Location                    : direct when the one-time ADB grant of WRITE_SECURE_SETTINGS was done
 *                                  (see README); otherwise opens Location settings.
 *  - Airplane mode               : opens the system panel (Android lets only system apps switch radios).
 */
object SystemToggles {

    // ── permissions ──────────────────────────────────────────────────
    fun canWriteSettings(ctx: Context): Boolean = try { Settings.System.canWrite(ctx) } catch (_: Throwable) { false }

    fun writeSettingsIntent(ctx: Context): Intent =
        Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:${ctx.packageName}"))

    fun hasSecureSettings(ctx: Context): Boolean =
        ctx.checkSelfPermission(Manifest.permission.WRITE_SECURE_SETTINGS) == PackageManager.PERMISSION_GRANTED

    fun hasPolicyAccess(ctx: Context): Boolean = try {
        (ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).isNotificationPolicyAccessGranted
    } catch (_: Throwable) { false }

    // ── state readers ────────────────────────────────────────────────
    @Suppress("DEPRECATION")
    fun wifiOn(ctx: Context): Boolean = try {
        (ctx.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager).isWifiEnabled
    } catch (_: Throwable) { false }

    fun bluetoothOn(ctx: Context): Boolean = try {
        (ctx.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter?.isEnabled == true
    } catch (_: Throwable) { false }

    fun locationOn(ctx: Context): Boolean = try {
        LocationManagerCompat.isLocationEnabled(ctx.getSystemService(Context.LOCATION_SERVICE) as android.location.LocationManager)
    } catch (_: Throwable) { false }

    fun airplaneOn(ctx: Context): Boolean = try {
        Settings.Global.getInt(ctx.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) == 1
    } catch (_: Throwable) { false }

    fun autoRotate(ctx: Context): Boolean = try {
        Settings.System.getInt(ctx.contentResolver, Settings.System.ACCELEROMETER_ROTATION, 0) == 1
    } catch (_: Throwable) { false }

    /** 1..255 */
    fun brightness(ctx: Context): Int = try {
        Settings.System.getInt(ctx.contentResolver, Settings.System.SCREEN_BRIGHTNESS, 128).coerceIn(1, 255)
    } catch (_: Throwable) { 128 }

    // ── direct writers ───────────────────────────────────────────────
    fun setAutoRotate(ctx: Context, on: Boolean): Boolean = try {
        Settings.System.putInt(ctx.contentResolver, Settings.System.ACCELEROMETER_ROTATION, if (on) 1 else 0)
    } catch (e: Throwable) { AppLog.w("Toggles", "auto-rotate write failed", e); false }

    /** [value] 1..255. Switches to manual brightness first so auto-brightness does not undo it. */
    fun setBrightness(ctx: Context, value: Int): Boolean = try {
        val cr = ctx.contentResolver
        if (Settings.System.getInt(cr, Settings.System.SCREEN_BRIGHTNESS_MODE, 0) !=
            Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL) {
            Settings.System.putInt(cr, Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL)
        }
        Settings.System.putInt(cr, Settings.System.SCREEN_BRIGHTNESS, value.coerceIn(1, 255))
    } catch (e: Throwable) { AppLog.w("Toggles", "brightness write failed", e); false }

    /** Android 9 and older can switch Wi-Fi directly. Returns false when the system panel is needed. */
    @Suppress("DEPRECATION")
    fun toggleWifiDirect(ctx: Context): Boolean {
        if (Build.VERSION.SDK_INT >= 29) return false
        return try {
            val wm = ctx.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            wm.setWifiEnabled(!wm.isWifiEnabled)
        } catch (e: Throwable) { AppLog.w("Toggles", "wifi toggle failed", e); false }
    }

    /**
     * true = handled here (switched, or the system "turn on Bluetooth" prompt was shown).
     * false = caller should open Bluetooth settings.
     * On Android 12+ the caller must already hold BLUETOOTH_CONNECT.
     */
    @Suppress("DEPRECATION", "MissingPermission")
    fun toggleBluetooth(activity: Activity): Boolean {
        return try {
            val ad: BluetoothAdapter = (activity.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter
                ?: return false
            if (Build.VERSION.SDK_INT < 33) {
                if (ad.isEnabled) ad.disable() else ad.enable()
            } else if (!ad.isEnabled) {
                activity.startActivity(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)); true
            } else false
        } catch (e: Throwable) { AppLog.w("Toggles", "bluetooth toggle failed", e); false }
    }

    /** Needs the one-time ADB grant of WRITE_SECURE_SETTINGS. true only if the state really changed. */
    @Suppress("DEPRECATION")
    fun setLocationDirect(ctx: Context, on: Boolean): Boolean {
        if (!hasSecureSettings(ctx)) return false
        return try {
            Settings.Secure.putInt(ctx.contentResolver, Settings.Secure.LOCATION_MODE,
                if (on) Settings.Secure.LOCATION_MODE_HIGH_ACCURACY else Settings.Secure.LOCATION_MODE_OFF)
            locationOn(ctx) == on
        } catch (e: Throwable) { AppLog.w("Toggles", "location write failed", e); false }
    }
}
