package com.srizwan.win11

import android.Manifest
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.app.role.RoleManager
import android.content.BroadcastReceiver
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.IBinder
import android.provider.ContactsContract
import android.provider.Telephony
import android.telephony.SmsManager
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat

/**
 * Part 7: default SMS app support.
 *
 * Android only delivers new SMS (SMS_DELIVER) to, and only lets the provider be written by, the
 * default SMS app. Once this app holds the SMS role:
 *  - [SmsDeliverReceiver] writes every incoming SMS to the provider and shows its own notification
 *    + glass pop-up (nothing depends on another app's notification any more),
 *  - [smsSendAndRecord] writes sent messages to the provider (Outbox -> Sent / Failed),
 *  - [RespondViaMessageService] answers "reject call with message",
 *  - [MmsDeliverReceiver] is the required WAP-push hook (MMS download is NOT implemented).
 * When another app is the default, everything keeps working as before (read + send only).
 */
object SmsRole {
    const val ACTION_SENT = "com.srizwan.win11.SMS_SENT"
    const val EXTRA_URI = "uri"

    fun isDefault(ctx: Context): Boolean = try {
        Telephony.Sms.getDefaultSmsPackage(ctx) == ctx.packageName
    } catch (_: Throwable) { false }

    /** Intent that asks the user to make this app the default SMS app, or null if not possible/needed. */
    fun requestIntent(ctx: Context): Intent? = try {
        if (isDefault(ctx)) null
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val rm = ctx.getSystemService(RoleManager::class.java)
            if (rm != null && rm.isRoleAvailable(RoleManager.ROLE_SMS) && !rm.isRoleHeld(RoleManager.ROLE_SMS))
                rm.createRequestRoleIntent(RoleManager.ROLE_SMS) else null
        } else if (ctx.packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)) {
            Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT)
                .putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, ctx.packageName)
        } else null
    } catch (_: Throwable) { null }
}

private fun smsManager(ctx: Context): SmsManager =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) ctx.getSystemService(SmsManager::class.java)
    else @Suppress("DEPRECATION") SmsManager.getDefault()

/**
 * Sends [body] to [address]. As default SMS app the message is first written to the provider
 * (Outbox), then [SmsSentReceiver] turns it into Sent or Failed from the radio result.
 * Throws when sending cannot start.
 */
fun smsSendAndRecord(ctx: Context, address: String, body: String) {
    val app = ctx.applicationContext
    val sm = smsManager(app)
    val parts = sm.divideMessage(body)
    var rowUri: Uri? = null
    if (SmsRole.isDefault(app)) {
        try {
            val cv = ContentValues().apply {
                put(Telephony.TextBasedSmsColumns.ADDRESS, address)
                put(Telephony.TextBasedSmsColumns.BODY, body)
                put(Telephony.TextBasedSmsColumns.DATE, System.currentTimeMillis())
                put(Telephony.TextBasedSmsColumns.READ, 1)
                put(Telephony.TextBasedSmsColumns.SEEN, 1)
            }
            rowUri = app.contentResolver.insert(Telephony.Sms.Outbox.CONTENT_URI, cv)
        } catch (_: Throwable) { rowUri = null }
    }
    fun pi(i: Int): PendingIntent? {
        val u = rowUri ?: return null
        val it = Intent(SmsRole.ACTION_SENT).setClass(app, SmsSentReceiver::class.java)
            .putExtra(SmsRole.EXTRA_URI, u.toString())
        return PendingIntent.getBroadcast(
            app, (u.hashCode() * 31 + i), it,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
    if (parts.size <= 1) {
        sm.sendTextMessage(address, null, body, pi(0), null)
    } else {
        val sent = ArrayList<PendingIntent?>()
        for (i in parts.indices) sent.add(pi(i))
        sm.sendMultipartTextMessage(address, null, parts, if (rowUri != null) sent else null, null)
    }
}

/** Radio result of a message sent by [smsSendAndRecord]: Outbox -> Sent, or Failed. */
class SmsSentReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        try {
            val uri = Uri.parse(intent.getStringExtra(SmsRole.EXTRA_URI) ?: return)
            val cv = ContentValues()
            if (resultCode == Activity.RESULT_OK) {
                cv.put(Telephony.TextBasedSmsColumns.TYPE, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_SENT)
                // never turn a failed part back into Sent
                context.contentResolver.update(uri, cv, "type = ?", arrayOf(Telephony.TextBasedSmsColumns.MESSAGE_TYPE_OUTBOX.toString()))
            } else {
                cv.put(Telephony.TextBasedSmsColumns.TYPE, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_FAILED)
                cv.put(Telephony.TextBasedSmsColumns.ERROR_CODE, resultCode)
                context.contentResolver.update(uri, cv, null, null)
            }
        } catch (e: Throwable) { AppLog.w("SmsSent", "status update failed", e) }
    }
}

/** Incoming SMS (only delivered while this app is the default SMS app). */
class SmsDeliverReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_DELIVER_ACTION) return
        val msgs = try { Telephony.Sms.Intents.getMessagesFromIntent(intent) } catch (_: Throwable) { null }
        if (msgs == null || msgs.isEmpty()) return
        val app = context.applicationContext
        val pending = goAsync()
        Thread {
            try {
                val addr = msgs[0].displayOriginatingAddress ?: msgs[0].originatingAddress ?: "Unknown"
                val body = msgs.joinToString("") { it.displayMessageBody ?: "" }
                val cv = ContentValues().apply {
                    put(Telephony.TextBasedSmsColumns.ADDRESS, addr)
                    put(Telephony.TextBasedSmsColumns.BODY, body)
                    put(Telephony.TextBasedSmsColumns.DATE, System.currentTimeMillis())
                    put(Telephony.TextBasedSmsColumns.DATE_SENT, msgs[0].timestampMillis)
                    put(Telephony.TextBasedSmsColumns.READ, 0)
                    put(Telephony.TextBasedSmsColumns.SEEN, 0)
                    put(Telephony.TextBasedSmsColumns.PROTOCOL, msgs[0].protocolIdentifier)
                    val sub = intent.getIntExtra("subscription", -1)
                    if (sub >= 0) put(Telephony.TextBasedSmsColumns.SUBSCRIPTION_ID, sub)
                }
                try { app.contentResolver.insert(Telephony.Sms.Inbox.CONTENT_URI, cv) }
                catch (e: Throwable) { AppLog.e("SmsDeliver", "cannot write inbox", e) }
                SmsNotifier.show(app, addr, body)
            } catch (e: Throwable) {
                AppLog.e("SmsDeliver", "incoming SMS failed", e)
            } finally {
                pending.finish()
            }
        }.start()
    }
}

/** Required for the SMS role. MMS download / parsing is not implemented. */
class MmsDeliverReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        AppLog.w("MmsDeliver", "MMS push received but MMS is not supported by this app")
    }
}

/** "Reject call with message" quick replies (required for the SMS role). */
class RespondViaMessageService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        try {
            if (intent?.action == "android.intent.action.RESPOND_VIA_MESSAGE") {
                val text = intent.getStringExtra(Intent.EXTRA_TEXT)?.trim().orEmpty()
                val to = intent.data?.schemeSpecificPart?.substringBefore('?')?.trim().orEmpty()
                if (text.isNotEmpty() && to.isNotEmpty() &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED
                ) smsSendAndRecord(this, to, text)
            }
        } catch (e: Throwable) {
            AppLog.e("RespondVia", "quick reply failed", e)
        } finally {
            stopSelf(startId)
        }
        return START_NOT_STICKY
    }
}

/** Notification + glass pop-up for an incoming SMS received while this app is the default. */
object SmsNotifier {
    private const val CHANNEL = "sms_incoming"

    fun show(ctx: Context, address: String, body: String) {
        val name = contactName(ctx, address)
        // Glass pop-up (our own notifications are skipped by the listener, so it is shown here)
        try {
            if (NotifPrefs.isAllowed(ctx, ctx.packageName)) {
                if (WhatsAppNotificationListener.appVisible) {
                    ctx.sendBroadcast(Intent(WhatsAppNotificationListener.ACTION_CHAT_MESSAGE).apply {
                        putExtra(WhatsAppNotificationListener.EXTRA_SENDER, name)
                        putExtra(WhatsAppNotificationListener.EXTRA_MESSAGE, body)
                        putExtra(WhatsAppNotificationListener.EXTRA_APP, "Messages")
                        putExtra(WhatsAppNotificationListener.EXTRA_PKG, ctx.packageName)
                        setPackage(ctx.packageName)
                    })
                } else NotifPrefs.alert(ctx, name, body, "Messages", ctx.packageName)
            }
        } catch (_: Throwable) { }
        // System notification (needed while the launcher is not in front)
        try {
            if (WhatsAppNotificationListener.appVisible) return
            if (Build.VERSION.SDK_INT >= 33 &&
                ContextCompat.checkSelfPermission(ctx, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
            ) return
            val nm = ctx.getSystemService(NotificationManager::class.java) ?: return
            if (Build.VERSION.SDK_INT >= 26 && nm.getNotificationChannel(CHANNEL) == null) {
                nm.createNotificationChannel(
                    NotificationChannel(CHANNEL, "Messages", NotificationManager.IMPORTANCE_HIGH)
                )
            }
            val open = Intent(ctx, MainActivity::class.java).apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("rizwans2://sms")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }
            val pi = PendingIntent.getActivity(
                ctx, address.hashCode(), open,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            val n = NotificationCompat.Builder(ctx, CHANNEL)
                .setSmallIcon(R.drawable.ic_stat_sms)
                .setContentTitle(name)
                .setContentText(body)
                .setStyle(NotificationCompat.BigTextStyle().bigText(body))
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)
                .setContentIntent(pi)
                .build()
            nm.notify(address, 7001, n)
        } catch (e: Throwable) { AppLog.w("SmsNotifier", "notify failed", e) }
    }

    private fun contactName(ctx: Context, address: String): String {
        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) return address
        return try {
            val uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(address))
            ctx.contentResolver.query(uri, arrayOf(ContactsContract.PhoneLookup.DISPLAY_NAME), null, null, null)
                ?.use { if (it.moveToFirst()) it.getString(0) else address } ?: address
        } catch (_: Throwable) { address }
    }
}

// ── MainActivity side: banner, role request, sms:/smsto: intents ─────────────

/** Outgoing = Sent, Outbox, Failed or Queued (drawn on the right side of the chat). */
internal fun smsIsOutgoing(type: Int): Boolean =
    type == Telephony.TextBasedSmsColumns.MESSAGE_TYPE_SENT ||
        type == Telephony.TextBasedSmsColumns.MESSAGE_TYPE_OUTBOX ||
        type == Telephony.TextBasedSmsColumns.MESSAGE_TYPE_FAILED ||
        type == Telephony.TextBasedSmsColumns.MESSAGE_TYPE_QUEUED

internal fun MainActivity.smsMakeRoleBanner(): TextView = TextView(this).apply {
    text = "Make this your default SMS app to send and receive messages reliably. Tap to set."
    textSize = 12f
    setTextColor(Color.WHITE)
    gravity = Gravity.CENTER_VERTICAL
    setPadding(dp(12), dp(8), dp(12), dp(8))
    setBackgroundColor(Color.argb(120, 0, 120, 212))
    visibility = View.GONE
    setOnClickListener { smsRequestDefaultRole() }
}

internal fun MainActivity.smsUpdateRoleBanner() {
    smsRoleBanner?.visibility = if (SmsRole.requestIntent(this) != null) View.VISIBLE else View.GONE
}

internal fun MainActivity.smsRequestDefaultRole() {
    val i = SmsRole.requestIntent(this)
    if (i == null) { smsUpdateRoleBanner(); return }
    try { smsRoleLauncher.launch(i) }
    catch (e: Throwable) {
        AppLog.w(LOGT, "default SMS request failed", e)
        Toast.makeText(this, "Cannot open the default SMS app setting", Toast.LENGTH_SHORT).show()
    }
}

internal fun MainActivity.smsRoleChanged() {
    smsUpdateRoleBanner()
    Toast.makeText(
        this,
        if (SmsRole.isDefault(this)) "This is now the default SMS app" else "Default SMS app not changed",
        Toast.LENGTH_SHORT
    ).show()
    if (isUIInitialized && activeSection == "sms") refreshSmsView()
}

/** sms: / smsto: / mms: / mmsto: links (Intent.ACTION_SENDTO) open the Messages compose dialog. */
internal fun MainActivity.handleSendTo(intent: Intent?) {
    intent ?: return
    val d = intent.data ?: return
    val scheme = (d.scheme ?: "").lowercase()
    if (scheme !in listOf("sms", "smsto", "mms", "mmsto")) return
    if (intent.action != Intent.ACTION_SENDTO && intent.action != Intent.ACTION_VIEW) return
    try {
        val number = Uri.decode(d.schemeSpecificPart.substringBefore('?')).trim()
        val body = intent.getStringExtra("sms_body") ?: intent.getStringExtra(Intent.EXTRA_TEXT) ?: ""
        if (!isUIInitialized || !shellInit) { pendingSendTo = intent; return }
        shell.closeStart(animated = false)
        switchToSection("sms")
        showComposeSmsDialog(number, body)
    } catch (e: Throwable) { AppLog.e(LOGT, "sendto failed", e) }
}
