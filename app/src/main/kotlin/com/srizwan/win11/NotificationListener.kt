package com.srizwan.win11

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.app.role.RoleManager
import android.app.DownloadManager
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Rect
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.net.Uri
import android.os.*
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings
import android.provider.Telephony
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.telephony.SmsManager
import android.text.format.DateUtils
import android.util.Base64
import android.util.Log
import android.view.*
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.graphics.Typeface
import android.graphics.pdf.PdfRenderer
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.webkit.*
import android.widget.*
import android.widget.VideoView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.ZipInputStream

// ==================== NOTIFICATION LISTENER (every app) ====================

class WhatsAppNotificationListener : NotificationListenerService() {

    companion object {
        const val ACTION_CHAT_MESSAGE = "com.srizwan.win11.CHAT_MESSAGE"
        const val EXTRA_SENDER = "sender"
        const val EXTRA_MESSAGE = "message"
        const val EXTRA_APP = "app"
        const val EXTRA_PKG = "pkg"

        /**
         * true while MainActivity is started (receiver registered) and shows the in-app overlay.
         * false = paused/stopped/background: the service shows the alert itself.
         */
        @Volatile var appVisible = false

        /** Connected listener, used by the notification center to dismiss notifications. */
        @Volatile var instance: WhatsAppNotificationListener? = null

        fun isEnabled(context: Context): Boolean {
            val flat = Settings.Secure.getString(
                context.contentResolver,
                "enabled_notification_listeners"
            ) ?: return false
            val cn = ComponentName(context, WhatsAppNotificationListener::class.java)
            return flat.contains(cn.flattenToString())
        }

        fun getAppLabel(context: Context, packageName: String): String = try {
            val pm = context.packageManager
            pm.getApplicationLabel(pm.getApplicationInfo(packageName, 0)).toString()
        } catch (_: Exception) {
            packageName
        }
    }

    /** key -> "title|text" of the last pop-up, so re-posts of the same notification (progress, count updates) do not pop up again. */
    private val lastShown = HashMap<String, String>()

    /** Only real, user-facing notifications pop up: no ongoing / media / progress / service / silent ones. */
    private fun shouldPopup(sbn: StatusBarNotification, n: Notification): Boolean {
        if (!sbn.isClearable) return false
        if (n.flags and Notification.FLAG_GROUP_SUMMARY != 0) return false
        if (n.flags and Notification.FLAG_ONGOING_EVENT != 0) return false
        if (n.flags and Notification.FLAG_FOREGROUND_SERVICE != 0) return false
        when (n.category) {
            Notification.CATEGORY_TRANSPORT, Notification.CATEGORY_PROGRESS,
            Notification.CATEGORY_SERVICE, Notification.CATEGORY_SYSTEM,
            Notification.CATEGORY_STATUS -> return false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                val r = NotificationListenerService.Ranking()
                // importance below "default" = the phone itself shows it silently, so do not pop up
                if (currentRanking.getRanking(sbn.key, r) &&
                    r.importance < android.app.NotificationManager.IMPORTANCE_DEFAULT
                ) return false
            } catch (_: Throwable) { }
        }
        return true
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        // A crash in this service would kill the whole app process (and Android re-binds the
        // listener on every start), so everything here is guarded and logged.
        try {
            sbn ?: return
            val n = sbn.notification ?: return
            val extras = n.extras ?: return
            val sender = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString() ?: ""
            val message = (extras.getCharSequence(Notification.EXTRA_TEXT)
                ?: extras.getCharSequence(Notification.EXTRA_BIG_TEXT)
                ?: extras.getCharSequence(Notification.EXTRA_SUB_TEXT))?.toString() ?: ""
            // Every dismissible notification goes to the Windows-style notification center.
            NotificationStore.onPosted(this, sbn)
            if (sbn.packageName == packageName) return
            if (sender.isEmpty() && message.isEmpty()) return
            if (!shouldPopup(sbn, n)) return

            val sig = sender + "\u0000" + message
            val prev = synchronized(lastShown) {
                if (lastShown.size > 300) lastShown.clear()
                lastShown.put(sbn.key, sig)
            }
            if (prev == sig) return

            AppLog.d(Listener_TAG, "notification from ${sbn.packageName}")
            // Notification settings: master switch + do-not-disturb + per-app on/off
            if (!NotifPrefs.isAllowed(this, sbn.packageName)) return
            val label = getAppLabel(this, sbn.packageName)
            if (!appVisible) {
                // Launcher is paused/stopped/in background: pop up straight from the service
                NotifPrefs.alert(this, sender, message, label, sbn.packageName)
                return
            }
            val intent = Intent(ACTION_CHAT_MESSAGE).apply {
                putExtra(EXTRA_SENDER, sender)
                putExtra(EXTRA_MESSAGE, message)
                putExtra(EXTRA_APP, label)
                putExtra(EXTRA_PKG, sbn.packageName)
                setPackage(packageName)
            }
            sendBroadcast(intent)
        } catch (e: Throwable) {
            AppLog.e(Listener_TAG, "onNotificationPosted failed", e)
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        try {
            sbn?.key?.let { k -> synchronized(lastShown) { lastShown.remove(k) } }
            NotificationStore.remove(sbn?.key)
        } catch (e: Throwable) { AppLog.e(Listener_TAG, "onNotificationRemoved failed", e) }
    }

    override fun onListenerConnected() {
        super.onListenerConnected()
        AppLog.i(Listener_TAG, "connected")
        instance = this
        try {
            // Rebuild the center from what is currently showing on the phone.
            NotificationStore.clearLocal()
            synchronized(lastShown) { lastShown.clear() }
            activeNotifications?.forEach { sbn ->
                NotificationStore.onPosted(this, sbn)
                // remember what is already on screen so it does not pop up again
                val ex = sbn.notification?.extras
                if (ex != null) {
                    val t = ex.getCharSequence(Notification.EXTRA_TITLE)?.toString() ?: ""
                    val m = (ex.getCharSequence(Notification.EXTRA_TEXT)
                        ?: ex.getCharSequence(Notification.EXTRA_BIG_TEXT)
                        ?: ex.getCharSequence(Notification.EXTRA_SUB_TEXT))?.toString() ?: ""
                    synchronized(lastShown) { lastShown[sbn.key] = t + "\u0000" + m }
                }
            }
        } catch (e: Throwable) {
            AppLog.e(Listener_TAG, "initial notification scan failed", e)
        }
    }

    override fun onListenerDisconnected() {
        AppLog.i(Listener_TAG, "disconnected")
        if (instance === this) instance = null
        super.onListenerDisconnected()
    }
}

private const val Listener_TAG = "Listener"

// ==================== MAIN ACTIVITY ====================
