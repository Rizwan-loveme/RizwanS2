package com.srizwan.win11

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.service.notification.StatusBarNotification
import java.util.concurrent.CopyOnWriteArraySet

/** One notification shown in the Windows-style notification center. */
class NotifItem(
    val key: String,
    val pkg: String,
    val app: String,
    val title: String,
    val text: String,
    val time: Long,
    val intent: PendingIntent?,
    val autoCancel: Boolean
)

/**
 * In-memory mirror of the phone's active (dismissible) notifications.
 * Filled by [WhatsAppNotificationListener] (the app's notification-access service):
 * posted / removed callbacks keep it live, and on connect it is rebuilt from the
 * notifications that are currently active.
 */
object NotificationStore {

    private const val MAX_ITEMS = 100

    private val items = LinkedHashMap<String, NotifItem>()
    private val listeners = CopyOnWriteArraySet<() -> Unit>()
    private val main = Handler(Looper.getMainLooper())

    fun snapshot(): List<NotifItem> = synchronized(items) { items.values.sortedByDescending { it.time } }

    fun addListener(l: () -> Unit) { listeners.add(l) }
    fun removeListener(l: () -> Unit) { listeners.remove(l) }

    private fun changed() { main.post { listeners.forEach { it() } } }

    /** Add or update a notification. Ongoing (media, foreground-service) and group-summary entries are skipped. */
    fun onPosted(ctx: Context, sbn: StatusBarNotification) {
        try {
            val n = sbn.notification ?: return
            if (!sbn.isClearable) return
            if (n.flags and Notification.FLAG_GROUP_SUMMARY != 0) return
            val ex = n.extras ?: return
            val title = ex.getCharSequence(Notification.EXTRA_TITLE)?.toString().orEmpty()
            val text = (ex.getCharSequence(Notification.EXTRA_TEXT)
                ?: ex.getCharSequence(Notification.EXTRA_BIG_TEXT)
                ?: ex.getCharSequence(Notification.EXTRA_SUB_TEXT))?.toString().orEmpty()
            if (title.isEmpty() && text.isEmpty()) return

            val item = NotifItem(
                key = sbn.key,
                pkg = sbn.packageName,
                app = appLabel(ctx, sbn.packageName),
                title = title,
                text = text,
                time = if (sbn.postTime > 0) sbn.postTime else System.currentTimeMillis(),
                intent = n.contentIntent,
                autoCancel = n.flags and Notification.FLAG_AUTO_CANCEL != 0
            )
            synchronized(items) {
                items.remove(item.key)
                items[item.key] = item
                while (items.size > MAX_ITEMS) {
                    val oldest = items.values.minByOrNull { it.time } ?: break
                    items.remove(oldest.key)
                }
            }
            changed()
        } catch (e: Exception) {
            AppLog.e("NotifStore", "onPosted failed for ${sbn.packageName}", e)
        }
    }

    /** Called when the system says a notification is gone (dismissed anywhere). */
    fun remove(key: String?) {
        if (key == null) return
        val removed = synchronized(items) { items.remove(key) != null }
        if (removed) changed()
    }

    fun clearLocal() {
        synchronized(items) { items.clear() }
        changed()
    }

    // ── actions that also dismiss on the phone ────────────────────────

    fun dismiss(key: String) {
        try { WhatsAppNotificationListener.instance?.cancelNotification(key) } catch (_: Exception) {}
        remove(key)
    }

    fun clearApp(pkg: String) {
        val keys = synchronized(items) { items.values.filter { it.pkg == pkg }.map { it.key } }
        keys.forEach { dismiss(it) }
    }

    fun clearAll() {
        try { WhatsAppNotificationListener.instance?.cancelAllNotifications() } catch (_: Exception) {}
        clearLocal()
    }

    private fun appLabel(ctx: Context, pkg: String): String = try {
        val pm = ctx.packageManager
        pm.getApplicationLabel(pm.getApplicationInfo(pkg, 0)).toString()
    } catch (_: Exception) {
        pkg
    }
}
