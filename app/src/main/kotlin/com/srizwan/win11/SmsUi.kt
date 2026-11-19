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

// SMS: conversation list, thread view, live refresh, compose / send / delete (split out of MainActivity).
// All functions are extensions of MainActivity; state lives in MainActivity.

internal fun MainActivity.smsRound(color: Int, radiusDp: Int): android.graphics.drawable.GradientDrawable =
    android.graphics.drawable.GradientDrawable().apply {
        setColor(color)
        cornerRadius = dp(radiusDp).toFloat()
    }


internal fun MainActivity.smsIconButton(
    type: String, sizeDp: Int, iconColor: Int, bg: Int?, onClick: () -> Unit
): FrameLayout {
    val box = FrameLayout(this)
    box.layoutParams = LinearLayout.LayoutParams(dp(sizeDp), dp(sizeDp))
    if (bg != null) box.background = smsRound(bg, sizeDp / 2)
    val ic = VectorIconView(this, type)
    ic.setIconColor(iconColor)
    val isz = (sizeDp * 0.5f).toInt()
    ic.layoutParams = FrameLayout.LayoutParams(dp(isz), dp(isz), Gravity.CENTER)
    box.addView(ic)
    box.isClickable = true
    box.setOnClickListener { onClick() }
    return box
}


internal fun MainActivity.smsAvatar(name: String, sizeDp: Int): FrameLayout {
    val palette = intArrayOf(
        0xFF0078D4.toInt(), 0xFF107C10.toInt(), 0xFF8764B8.toInt(),
        0xFFCA5010.toInt(), 0xFF00B7C3.toInt(), 0xFFC239B3.toInt()
    )
    val color = palette[(name.hashCode() and 0x7fffffff) % palette.size]
    val box = FrameLayout(this)
    box.layoutParams = LinearLayout.LayoutParams(dp(sizeDp), dp(sizeDp))
    box.background = smsRound(color, sizeDp / 2)
    val ch = name.trim().firstOrNull()
    if (ch != null && ch.isLetter()) {
        val tv = TextView(this)
        tv.text = ch.toString().uppercase()
        tv.setTextColor(Color.WHITE)
        tv.textSize = (sizeDp * 0.4f)
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.gravity = Gravity.CENTER
        tv.layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        box.addView(tv)
    } else {
        val ic = VectorIconView(this, VectorIconView.PHONE)
        ic.setIconColor(Color.WHITE)
        val isz = (sizeDp * 0.5f).toInt()
        ic.layoutParams = FrameLayout.LayoutParams(dp(isz), dp(isz), Gravity.CENTER)
        box.addView(ic)
    }
    return box
}


internal fun MainActivity.createSmsView(): LinearLayout {
    val a = this
    val mp = ViewGroup.LayoutParams.MATCH_PARENT
    val wc = ViewGroup.LayoutParams.WRAP_CONTENT

    val root = LinearLayout(a)
    root.orientation = LinearLayout.VERTICAL
    root.setBackgroundColor(Color.TRANSPARENT)
    root.layoutParams = ViewGroup.LayoutParams(mp, mp)

    // ── Window title bar ──
    val titleBar = LinearLayout(a)
    titleBar.orientation = LinearLayout.HORIZONTAL
    titleBar.gravity = Gravity.CENTER_VERTICAL
    titleBar.setPadding(dp(14), 0, dp(14), 0)
    titleBar.layoutParams = LinearLayout.LayoutParams(mp, dp(40))
    val titleIcon = VectorIconView(a, VectorIconView.MESSAGES)
    titleIcon.layoutParams = LinearLayout.LayoutParams(dp(16), dp(16))
    titleBar.addView(titleIcon)
    val titleText = TextView(a)
    titleText.text = "Messages"
    titleText.setTextColor(W11.TEXT)
    titleText.textSize = 12f
    titleText.setPadding(dp(10), 0, 0, 0)
    titleBar.addView(titleText)
    root.addView(titleBar)

    val body = LinearLayout(a)
    body.orientation = LinearLayout.HORIZONTAL
    body.layoutParams = LinearLayout.LayoutParams(mp, 0, 1f)

    // ── LEFT PANE: search + new message + conversation list ──
    val listPane = LinearLayout(a)
    listPane.orientation = LinearLayout.VERTICAL
    listPane.setBackgroundColor(Color.argb(96, 18, 22, 32))
    listPane.layoutParams =
        if (smsWide) LinearLayout.LayoutParams(dp(320), mp)
        else LinearLayout.LayoutParams(0, mp, 1f)

    val toolbar = LinearLayout(a)
    toolbar.orientation = LinearLayout.HORIZONTAL
    toolbar.gravity = Gravity.CENTER_VERTICAL
    toolbar.setPadding(dp(10), dp(8), dp(10), dp(8))
    toolbar.layoutParams = LinearLayout.LayoutParams(mp, wc)

    val searchBox = LinearLayout(a)
    searchBox.orientation = LinearLayout.HORIZONTAL
    searchBox.gravity = Gravity.CENTER_VERTICAL
    searchBox.background = android.graphics.drawable.GradientDrawable().apply {
        cornerRadius = dp(18).toFloat()
        setColor(W11.START_SEARCH_BG)
        setStroke(1, W11.START_BORDER)
    }
    searchBox.setPadding(dp(10), 0, dp(10), 0)
    searchBox.layoutParams = LinearLayout.LayoutParams(0, dp(36), 1f)
    val searchIcon = VectorIconView(a, VectorIconView.SEARCH)
    searchIcon.setIconColor(W11.TEXT_DIM)
    searchIcon.layoutParams = LinearLayout.LayoutParams(dp(14), dp(14))
    searchBox.addView(searchIcon)
    smsSearchEdit = EditText(a).apply {
        hint = "Search messages"
        textSize = 13f
        maxLines = 1
        setSingleLine(true)
        setTextColor(Color.WHITE)
        setHintTextColor(Color.parseColor("#80FFFFFF"))
        setBackgroundColor(Color.TRANSPARENT)
        setPadding(dp(8), 0, 0, 0)
        layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f)
        addTextChangedListener(object : android.text.TextWatcher {
            override fun afterTextChanged(s: android.text.Editable?) {
                // debounce: don't re-query the SMS database on every keystroke
                smsSearchRunnable?.let { smsMain.removeCallbacks(it) }
                val r = Runnable { refreshSmsView() }
                smsSearchRunnable = r
                smsMain.postDelayed(r, 250)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
    searchBox.addView(smsSearchEdit)
    toolbar.addView(searchBox)

    val composeBtn = smsIconButton(
        VectorIconView.EDIT, 36, Color.BLACK, W11.ACCENT
    ) { showComposeSmsDialog(null, "") }
    (composeBtn.layoutParams as LinearLayout.LayoutParams).leftMargin = dp(8)
    toolbar.addView(composeBtn)
    listPane.addView(toolbar)
    val roleBanner = smsMakeRoleBanner()
    smsRoleBanner = roleBanner
    listPane.addView(roleBanner)

    val listFrame = FrameLayout(a)
    listFrame.layoutParams = LinearLayout.LayoutParams(mp, 0, 1f)
    val listRv = RecyclerView(a)
    listRv.layoutManager = LinearLayoutManager(a)
    listRv.layoutParams = FrameLayout.LayoutParams(mp, mp)
    listRv.itemAnimator = null
    listRv.setHasFixedSize(true)
    listRv.setItemViewCacheSize(10)
    listRv.isVerticalScrollBarEnabled = false
    listRv.overScrollMode = View.OVER_SCROLL_NEVER
    val listAdapter = SmsListAdapter(act)
    listRv.adapter = listAdapter
    // Pagination: 20 conversations at a time, next page when the end is near
    listRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(r: RecyclerView, dx: Int, dy: Int) {
            if (dy <= 0) return
            val lm = r.layoutManager as LinearLayoutManager
            if (lm.findLastVisibleItemPosition() >= listAdapter.itemCount - 4) smsLoadMoreConversations()
        }
    })
    smsListRv = listRv
    smsListAdapter = listAdapter
    listFrame.addView(listRv)
    val listEmpty = TextView(a)
    listEmpty.textSize = 14f
    listEmpty.gravity = Gravity.CENTER
    listEmpty.setTextColor(W11.TEXT_DIM)
    listEmpty.setPadding(dp(20), dp(40), dp(20), dp(40))
    listEmpty.visibility = View.GONE
    listEmpty.layoutParams = FrameLayout.LayoutParams(mp, wc)
    smsListEmpty = listEmpty
    listFrame.addView(listEmpty)
    // Loading animation: visible from the first frame until the first page is ready
    val listSpinner = smsSpinner()
    listSpinner.layoutParams = FrameLayout.LayoutParams(dp(32), dp(32), Gravity.CENTER)
    smsListSpinner = listSpinner
    listFrame.addView(listSpinner)
    listPane.addView(listFrame)
    body.addView(listPane)
    smsListPane = listPane

    if (smsWide) {
        val divider = View(a)
        divider.setBackgroundColor(W11.DIVIDER)
        divider.layoutParams = LinearLayout.LayoutParams(dp(1), mp)
        body.addView(divider)
    }

    // ── RIGHT PANE: placeholder (wide only) or the open conversation ──
    val threadPane = LinearLayout(a)
    threadPane.orientation = LinearLayout.VERTICAL
    threadPane.setBackgroundColor(Color.argb(72, 10, 12, 20))
    threadPane.layoutParams = LinearLayout.LayoutParams(0, mp, 1f)

    val placeholder = LinearLayout(a)
    placeholder.orientation = LinearLayout.VERTICAL
    placeholder.gravity = Gravity.CENTER
    placeholder.layoutParams = LinearLayout.LayoutParams(mp, 0, 1f)
    val phIcon = VectorIconView(a, VectorIconView.MESSAGES)
    phIcon.setIconColor(Color.parseColor("#554CC2FF"))
    phIcon.layoutParams = LinearLayout.LayoutParams(dp(56), dp(56))
    placeholder.addView(phIcon)
    val phText = TextView(a)
    phText.text = "Select a conversation"
    phText.setTextColor(W11.TEXT_DIM)
    phText.textSize = 14f
    phText.gravity = Gravity.CENTER
    phText.setPadding(0, dp(12), 0, 0)
    placeholder.addView(phText)
    placeholder.visibility = if (smsWide) View.VISIBLE else View.GONE
    threadPane.addView(placeholder)

    val content = LinearLayout(a)
    content.orientation = LinearLayout.VERTICAL
    content.layoutParams = LinearLayout.LayoutParams(mp, 0, 1f)
    content.visibility = View.GONE
    threadPane.addView(content)

    threadPane.visibility = if (smsWide) View.VISIBLE else View.GONE
    body.addView(threadPane)
    smsThreadPane = threadPane
    smsThreadPlaceholder = placeholder
    smsThreadContent = content

    root.addView(body)
    return root
}


internal fun MainActivity.smsShowThreadPane() {
    smsThreadPlaceholder?.visibility = View.GONE
    smsThreadContent?.visibility = View.VISIBLE
    smsThreadPane?.visibility = View.VISIBLE
    if (!smsWide) smsListPane?.visibility = View.GONE
}

/** Closes the open conversation (narrow: back to the list; wide: show the placeholder). */

internal fun MainActivity.smsCloseThread() {
    smsCurrentAddress = null
    smsListAdapter?.selected = null
    smsThreadContent?.visibility = View.GONE
    if (smsWide) {
        smsThreadPlaceholder?.visibility = View.VISIBLE
    } else {
        smsThreadPane?.visibility = View.GONE
        smsListPane?.visibility = View.VISIBLE
    }
    refreshSmsView()
}

// ── SMS engine state (all heavy work runs off the UI thread) ─────────

internal fun MainActivity.smsSpinner(): ProgressBar = ProgressBar(this).apply {
    isIndeterminate = true
    indeterminateTintList = android.content.res.ColorStateList.valueOf(W11.ACCENT)
}


data class SmsConversation(
    var address: String,
    var snippet: String,
    var date: Long,
    var type: Int,
    var unreadCount: Int,
    var name: String = address,
    /** Provider thread id (0 when the row came from the slow fallback scan). */
    val threadId: Long = 0L,
    /** First recipient id of the thread, used only when the thread has no SMS row (MMS only). */
    val recipientId: String = "",
    /** false = light stub from the threads table; address/type/body are filled when its page is shown. */
    var resolved: Boolean = true
)

/** Item of the conversation list: either a day separator or a message. */

sealed class SmsItem {
    data class Day(val label: String) : SmsItem()
    data class Msg(val msg: SmsMessage) : SmsItem()
    /** Spinner row shown at the top while an older page is being loaded. */
    object Loading : SmsItem()
}

/** Bubble that never grows wider than [ratio] of the space its parent offers. */

class SmsBubbleLayout(ctx: Context, private val ratio: Float) : LinearLayout(ctx) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val parentW = MeasureSpec.getSize(widthMeasureSpec)
        val spec = if (parentW > 0)
            MeasureSpec.makeMeasureSpec((parentW * ratio).toInt(), MeasureSpec.AT_MOST)
        else widthMeasureSpec
        super.onMeasure(spec, heightMeasureSpec)
    }
}


internal fun MainActivity.smsDisplayName(address: String): String {
    contactNameCache[address]?.let { return it }
    val name = getContactName(address)
    contactNameCache[address] = name
    return name
}


internal fun MainActivity.refreshSmsView() {
    val rv = smsListRv ?: return
    val empty = smsListEmpty ?: return

    if (ContextCompat.checkSelfPermission(
            this, PERM_SMS_R
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            this, arrayOf(PERM_SMS_R, PERM_SMS_S, PERM_SMS_R2), REQ_SMS
        )
        smsListAdapter?.submit(emptyList())
        smsListSpinner?.visibility = View.GONE
        empty.text = "SMS permission required.\nTap to grant."
        empty.setTextColor(Color.WHITE)
        empty.visibility = View.VISIBLE
        empty.setOnClickListener {
            ActivityCompat.requestPermissions(
                this, arrayOf(PERM_SMS_R, PERM_SMS_S, PERM_SMS_R2), REQ_SMS
            )
        }
        return
    }
    empty.setOnClickListener(null)
    empty.isClickable = false

    smsUpdateRoleBanner()
    val query = smsSearchEdit?.text?.toString()?.lowercase() ?: ""
    val gen = ++smsListGen
    val prevShown = smsConvShown
    val lastQuery = smsLastQuery
    if ((smsListAdapter?.itemCount ?: 0) == 0) {
        // nothing on screen yet: show the loading animation instead of a blank pane
        empty.visibility = View.GONE
        smsListSpinner?.visibility = View.VISIBLE
    }
    smsExec.execute {
        var error: String? = null
        var all: List<SmsConversation> = emptyList()
        try {
            // Fast path: one row per thread from the threads table (no message bodies of the whole
            // inbox). Search or an unsupported device uses the filtered scan instead.
            all = (if (query.isEmpty()) smsLoadThreadStubs() else null)
                ?: smsLoadByScan(query) { gen != smsListGen }
        } catch (e: Exception) {
            error = "SMS load error: ${e.message}"
        }
        if (gen != smsListGen) return@execute // a newer load superseded this one
        // Pagination: only the first page (20) is resolved + gets contact names now; the rest
        // load on scroll. A refresh keeps the pages already shown (unless the search text changed).
        val showN = if (query != lastQuery) SMS_PAGE else maxOf(SMS_PAGE, prevShown)
        val list = all.take(showN)
        smsResolveStubs(list)
        list.forEach { c -> c.name = smsDisplayName(c.address) }
        smsMain.post {
            if (gen != smsListGen) return@post
            smsListSpinner?.visibility = View.GONE
            smsConvAll = all
            smsConvShown = list.size
            smsConvLoadingMore = false
            smsLastQuery = query
            if (error != null) {
                smsListAdapter?.submit(emptyList())
                empty.text = error
                empty.setTextColor(Color.parseColor("#FF4444"))
                empty.visibility = View.VISIBLE
            } else if (list.isEmpty()) {
                smsListAdapter?.submit(emptyList())
                empty.text =
                    if (query.isEmpty()) "No messages found" else "No results for \"$query\""
                empty.setTextColor(W11.TEXT_DIM)
                empty.visibility = View.VISIBLE
            } else {
                empty.visibility = View.GONE
                smsListAdapter?.submit(list)
            }
        }
    }
}

/**
 * Fast conversation list: `content://mms-sms/conversations?simple=true` returns ONE row per thread
 * (id, date, snippet, recipient_ids), so the whole inbox is never read. Unread badges come from a
 * small query on unread rows only. Returns null when the device does not support it (fallback scan).
 */
internal fun MainActivity.smsLoadThreadStubs(): List<SmsConversation>? {
    val out = ArrayList<SmsConversation>()
    try {
        val c = contentResolver.query(
            Uri.parse("content://mms-sms/conversations?simple=true"),
            arrayOf("_id", "date", "snippet", "recipient_ids"),
            null, null, "date DESC"
        ) ?: return null
        c.use {
            val idI = it.getColumnIndex("_id")
            val dateI = it.getColumnIndex("date")
            val snI = it.getColumnIndex("snippet")
            val rcI = it.getColumnIndex("recipient_ids")
            if (idI < 0 || dateI < 0) return null
            while (it.moveToNext()) {
                val rc = if (rcI >= 0) (it.getString(rcI) ?: "").trim().split(" ").firstOrNull() ?: "" else ""
                out.add(
                    SmsConversation(
                        address = "", snippet = if (snI >= 0) it.getString(snI) ?: "" else "",
                        date = it.getLong(dateI), type = 1, unreadCount = 0,
                        threadId = it.getLong(idI), recipientId = rc, resolved = false
                    )
                )
            }
        }
    } catch (_: Throwable) { return null }
    if (out.isEmpty()) return null // let the scan double-check an empty / blocked result
    // unread counts: only unread rows are read (usually few)
    try {
        val counts = HashMap<Long, Int>()
        contentResolver.query(
            Uri.parse("content://sms/"), arrayOf("thread_id", "address", "date"),
            "read = 0", null, null
        )?.use {
            val tI = it.getColumnIndex("thread_id")
            val aI = it.getColumnIndex("address")
            val dI = it.getColumnIndex("date")
            while (it.moveToNext()) {
                val addr = if (aI >= 0) it.getString(aI) ?: "Unknown" else "Unknown"
                val date = if (dI >= 0) it.getLong(dI) else 0L
                if (date > smsReadAt(addr)) {
                    val t = if (tI >= 0) it.getLong(tI) else 0L
                    counts[t] = (counts[t] ?: 0) + 1
                }
            }
        }
        out.forEach { c -> c.unreadCount = counts[c.threadId] ?: 0 }
    } catch (_: Throwable) { }
    return out
}

/** Fills address / newest body / type of stub rows: one tiny indexed query per thread (LIMIT 1). */
internal fun MainActivity.smsResolveStubs(list: List<SmsConversation>) {
    for (c in list) {
        if (c.resolved) continue
        try {
            contentResolver.query(
                Uri.parse("content://sms/"), arrayOf("address", "body", "date", "type"),
                "thread_id = ?", arrayOf(c.threadId.toString()), "date DESC LIMIT 1"
            )?.use {
                if (it.moveToFirst()) {
                    c.address = it.getString(0) ?: "Unknown"
                    c.snippet = it.getString(1) ?: c.snippet
                    c.date = it.getLong(2)
                    c.type = it.getInt(3)
                }
            }
            if (c.address.isEmpty() && c.recipientId.isNotEmpty()) { // MMS-only thread
                contentResolver.query(
                    Uri.parse("content://mms-sms/canonical-addresses"), arrayOf("address"),
                    "_id = ?", arrayOf(c.recipientId), null
                )?.use { if (it.moveToFirst()) c.address = it.getString(0) ?: "" }
            }
        } catch (_: Throwable) { }
        if (c.address.isEmpty()) c.address = "Unknown"
        c.name = c.address
        c.resolved = true
    }
}

/** Slow path (search, or a device without the threads table): filtered scan grouped in memory. */
internal fun MainActivity.smsLoadByScan(query: String, cancelled: () -> Boolean): List<SmsConversation> {
    val conversations = LinkedHashMap<String, SmsConversation>()
    val like = "%" + query.replace("%", "").replace("_", "") + "%"
    val cursor = contentResolver.query(
        Uri.parse("content://sms/"),
        arrayOf("address", "body", "date", "type", "read", "thread_id"),
        if (query.isEmpty()) null else "address LIKE ? OR body LIKE ?",
        if (query.isEmpty()) null else arrayOf(like, like), "date DESC"
    )
    cursor?.use {
        val addrIdx = it.getColumnIndex("address")
        val bodyIdx = it.getColumnIndex("body")
        val dateIdx = it.getColumnIndex("date")
        val typeIdx = it.getColumnIndex("type")
        val readIdx = it.getColumnIndex("read")
        val thIdx = it.getColumnIndex("thread_id")
        while (it.moveToNext()) {
            if (cancelled()) return emptyList() // a newer load superseded this one
            val addr = if (addrIdx >= 0) it.getString(addrIdx) ?: "Unknown" else "Unknown"
            val body = if (bodyIdx >= 0) it.getString(bodyIdx) ?: "" else ""
            val isRead = if (readIdx >= 0) it.getInt(readIdx) == 1 else true
            val date = if (dateIdx >= 0) it.getLong(dateIdx) else 0L
            // unread = provider says unread AND it arrived after we last opened the thread
            val unread = !isRead && date > smsReadAt(addr)
            val existing = conversations[addr]
            if (existing == null) {
                conversations[addr] = SmsConversation(
                    addr, body, date,
                    if (typeIdx >= 0) it.getInt(typeIdx) else 1,
                    if (unread) 1 else 0,
                    threadId = if (thIdx >= 0) it.getLong(thIdx) else 0L
                )
            } else if (unread) existing.unreadCount++
        }
    }
    return conversations.values.toList()
}

// ── Conversation list (RecyclerView – rows are recycled, never rebuilt) ──

internal class SmsRowHolder(private val act: MainActivity, val row: LinearLayout) : RecyclerView.ViewHolder(row) {
    val indicator = View(row.context)
    val avatarHost = FrameLayout(row.context)
    val nameView = TextView(row.context)
    val snippetView = TextView(row.context)
    val timeView = TextView(row.context)
    val badge = TextView(row.context)
    var avatarName: String? = null

    init {
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT
        row.orientation = LinearLayout.HORIZONTAL
        row.gravity = Gravity.CENTER_VERTICAL
        row.setPadding(act.dp(6), act.dp(10), act.dp(10), act.dp(10))
        row.layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, wc
        ).apply { setMargins(act.dp(6), act.dp(1), act.dp(6), act.dp(1)) }

        indicator.layoutParams = LinearLayout.LayoutParams(act.dp(3), act.dp(18)).apply {
            setMargins(0, 0, act.dp(7), 0)
        }
        row.addView(indicator)

        avatarHost.layoutParams = LinearLayout.LayoutParams(act.dp(40), act.dp(40)).apply {
            rightMargin = act.dp(12)
        }
        row.addView(avatarHost)

        val textBlock = LinearLayout(row.context)
        textBlock.orientation = LinearLayout.VERTICAL
        textBlock.layoutParams = LinearLayout.LayoutParams(0, wc, 1f)
        nameView.setTextColor(W11.TEXT)
        nameView.textSize = 14f
        nameView.maxLines = 1
        nameView.ellipsize = android.text.TextUtils.TruncateAt.END
        textBlock.addView(nameView)
        snippetView.textSize = 12f
        snippetView.maxLines = 1
        snippetView.ellipsize = android.text.TextUtils.TruncateAt.END
        textBlock.addView(snippetView)
        row.addView(textBlock)

        val right = LinearLayout(row.context)
        right.orientation = LinearLayout.VERTICAL
        right.gravity = Gravity.END
        right.setPadding(act.dp(8), 0, 0, 0)
        right.layoutParams = LinearLayout.LayoutParams(wc, wc)
        timeView.setTextColor(W11.TEXT_DIM)
        timeView.textSize = 11f
        right.addView(timeView)
        badge.textSize = 10f
        badge.typeface = Typeface.DEFAULT_BOLD
        badge.gravity = Gravity.CENTER
        badge.setTextColor(Color.BLACK)
        badge.background = act.smsRound(W11.ACCENT, 9)
        badge.minWidth = act.dp(18)
        badge.setPadding(act.dp(5), act.dp(1), act.dp(5), act.dp(1))
        badge.layoutParams = LinearLayout.LayoutParams(wc, wc).apply { topMargin = act.dp(4) }
        right.addView(badge)
        row.addView(right)
    }
}


internal class SmsListAdapter(private val act: MainActivity) : RecyclerView.Adapter<SmsRowHolder>() {
    private var items: MutableList<SmsConversation> = mutableListOf()
    var selected: String? = null
        set(v) { if (field != v) { field = v; notifyDataSetChanged() } }

    fun submit(list: List<SmsConversation>) {
        items = list.toMutableList()
        notifyDataSetChanged()
    }

    /** Next page of conversations (pagination). */
    fun append(more: List<SmsConversation>) {
        val start = items.size
        items.addAll(more)
        notifyItemRangeInserted(start, more.size)
    }

    /** The conversation was opened: drop its unread badge / bold text right away. */
    fun clearUnread(address: String) {
        for (i in items.indices) {
            val c = items[i]
            if (c.address == address && c.unreadCount > 0) { c.unreadCount = 0; notifyItemChanged(i) }
        }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SmsRowHolder(act, LinearLayout(parent.context))

    override fun onBindViewHolder(h: SmsRowHolder, position: Int) {
        val conv = items[position]
        val isSentLast = smsIsOutgoing(conv.type)
        val sel = act.smsWide && conv.address == selected
        val unread = conv.unreadCount > 0

        h.row.background = act.smsRound(if (sel) W11.ITEM_ACTIVE_BG else Color.TRANSPARENT, 6)
        h.indicator.background = act.smsRound(if (sel) W11.ACCENT else Color.TRANSPARENT, 2)

        if (h.avatarName != conv.name) {
            h.avatarName = conv.name
            h.avatarHost.removeAllViews()
            val av = act.smsAvatar(conv.name, 40)
            av.layoutParams = FrameLayout.LayoutParams(act.dp(40), act.dp(40))
            h.avatarHost.addView(av)
        }

        h.nameView.text = conv.name
        h.nameView.typeface = if (unread) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
        h.snippetView.text =
            (if (isSentLast) "You: " else "") + conv.snippet.replace("\n", " ")
        h.snippetView.setTextColor(if (unread) W11.TEXT else W11.TEXT_DIM)
        h.timeView.text = if (conv.date > 0)
            DateUtils.getRelativeTimeSpanString(
                conv.date, System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS
            ).toString() else ""
        h.badge.visibility = if (unread) View.VISIBLE else View.GONE
        if (unread) h.badge.text = conv.unreadCount.toString()

        h.row.setOnClickListener {
            val p = h.bindingAdapterPosition
            if (p != RecyclerView.NO_POSITION) act.openSmsThread(items[p].address, items[p].name)
        }
        h.row.setOnLongClickListener {
            val p = h.bindingAdapterPosition
            if (p == RecyclerView.NO_POSITION) return@setOnLongClickListener true
            val c = items[p]
            val menu = GlassMenu(act, h.row)
            menu.menu.add(0, 1, 0, "Call")
            menu.menu.add(0, 2, 1, "Reply")
            menu.menu.add(0, 3, 2, "Delete conversation")
            menu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    1 -> {
                        act.openSystemDialer(c.address)
                    }
                    2 -> act.showComposeSmsDialog(c.address, "")
                    3 -> act.deleteSmsThread(c.address)
                }
                true
            }
            menu.show()
            true
        }
    }
}


internal fun MainActivity.getContactName(address: String): String {
    if (ContextCompat.checkSelfPermission(
            this, PERM_CONTACTS
        ) != PackageManager.PERMISSION_GRANTED
    ) return address
    return try {
        val uri = Uri.withAppendedPath(
            ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(address)
        )
        val cursor = contentResolver.query(
            uri, arrayOf(ContactsContract.PhoneLookup.DISPLAY_NAME), null, null, null
        )
        cursor?.use { if (it.moveToFirst()) it.getString(0) else address } ?: address
    } catch (e: Exception) { address }
}

// ── Message bubbles ──────────────────────────────────────────────────

private const val SMS_VT_DAY = 0

private const val SMS_VT_RECV = 1

private const val SMS_VT_SENT = 2

private const val SMS_VT_LOADING = 3


internal class SmsBubbleHolder(
    view: View, val body: TextView?, val time: TextView?
) : RecyclerView.ViewHolder(view)


internal class SmsThreadAdapter(private val act: MainActivity) : RecyclerView.Adapter<SmsBubbleHolder>() {
    var items: MutableList<SmsItem> = mutableListOf()
    private val timeFmt = SimpleDateFormat("HH:mm", Locale.getDefault())

    fun submit(list: MutableList<SmsItem>) {
        items = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = when (val it = items[position]) {
        is SmsItem.Day -> SMS_VT_DAY
        is SmsItem.Loading -> SMS_VT_LOADING
        is SmsItem.Msg ->
            if (smsIsOutgoing(it.msg.type)) SMS_VT_SENT
            else SMS_VT_RECV
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmsBubbleHolder {
        val ctx = parent.context
        val mp = ViewGroup.LayoutParams.MATCH_PARENT
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT
        if (viewType == SMS_VT_LOADING) {
            val box = FrameLayout(ctx)
            box.layoutParams = RecyclerView.LayoutParams(mp, act.dp(44))
            val pb = act.smsSpinner()
            pb.layoutParams = FrameLayout.LayoutParams(act.dp(24), act.dp(24), Gravity.CENTER)
            box.addView(pb)
            return SmsBubbleHolder(box, null, null)
        }
        if (viewType == SMS_VT_DAY) {
            val chip = TextView(ctx)
            chip.setTextColor(W11.TEXT_DIM)
            chip.textSize = 11f
            chip.gravity = Gravity.CENTER
            chip.setPadding(0, act.dp(8), 0, act.dp(6))
            chip.layoutParams = RecyclerView.LayoutParams(mp, wc)
            return SmsBubbleHolder(chip, chip, null)
        }
        val sent = viewType == SMS_VT_SENT
        val row = FrameLayout(ctx)
        row.layoutParams = RecyclerView.LayoutParams(mp, wc)
        row.setPadding(act.dp(12), act.dp(3), act.dp(12), act.dp(3))

        val bubble = SmsBubbleLayout(ctx, if (act.smsWide) 0.7f else 0.8f)
        bubble.orientation = LinearLayout.VERTICAL
        bubble.background =
            act.smsRound(if (sent) Color.argb(228, 10, 92, 173) else Color.argb(92, 255, 255, 255), 8)
        bubble.setPadding(act.dp(12), act.dp(8), act.dp(12), act.dp(6))
        bubble.layoutParams = FrameLayout.LayoutParams(
            wc, wc, if (sent) Gravity.END else Gravity.START
        )

        val bodyView = TextView(ctx)
        bodyView.setTextColor(Color.WHITE)
        bodyView.textSize = 14f
        // Simple line breaking + no hyphenation: fast, and safe for Bengali text.
        bodyView.breakStrategy = android.text.Layout.BREAK_STRATEGY_SIMPLE
        bodyView.hyphenationFrequency = android.text.Layout.HYPHENATION_FREQUENCY_NONE
        bodyView.layoutParams = LinearLayout.LayoutParams(wc, wc)
        bubble.addView(bodyView)

        val timeView = TextView(ctx)
        timeView.setTextColor(Color.parseColor("#B3FFFFFF"))
        timeView.textSize = 10f
        timeView.layoutParams = LinearLayout.LayoutParams(wc, wc).apply {
            gravity = Gravity.END
            topMargin = act.dp(2)
        }
        bubble.addView(timeView)
        row.addView(bubble)
        return SmsBubbleHolder(row, bodyView, timeView)
    }

    override fun onBindViewHolder(h: SmsBubbleHolder, position: Int) {
        when (val it = items[position]) {
            is SmsItem.Day -> h.body?.text = it.label
            is SmsItem.Loading -> {}
            is SmsItem.Msg -> {
                h.body?.text = it.msg.body
                h.time?.text =
                    if (it.msg.date > 0) timeFmt.format(Date(it.msg.date)) else ""
            }
        }
    }
}


internal fun MainActivity.smsBuildItems(messages: List<SmsMessage>): MutableList<SmsItem> {
    val out = ArrayList<SmsItem>(messages.size + 16)
    val dayFmt = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
    var lastDay = ""
    for (m in messages) {
        if (m.date > 0) {
            val day = dayFmt.format(Date(m.date))
            if (day != lastDay) {
                lastDay = day
                out.add(SmsItem.Day(day))
            }
        }
        out.add(SmsItem.Msg(m))
    }
    return out
}


internal fun MainActivity.smsUpdateHeaderSub(count: Int, truncated: Boolean) {
    val addr = smsCurrentAddress ?: return
    smsHeaderSub?.text =
        (if (smsCurrentName != addr) "$addr  -  " else "") +
            (if (truncated) "$count+ messages" else "$count messages")
}

/** Builds header + message list + composer once; later opens only re-bind data. */

internal fun MainActivity.ensureSmsThreadUi() {
    if (smsThreadRv != null) return
    val content = smsThreadContent ?: return
    val a = this
    val mp = ViewGroup.LayoutParams.MATCH_PARENT
    val wc = ViewGroup.LayoutParams.WRAP_CONTENT

    // ── Header: [back] avatar  name / number   call  delete ──
    val header = LinearLayout(a)
    header.orientation = LinearLayout.HORIZONTAL
    header.gravity = Gravity.CENTER_VERTICAL
    header.setBackgroundColor(GLASS_BAR)
    header.setPadding(dp(8), dp(8), dp(12), dp(8))
    header.layoutParams = LinearLayout.LayoutParams(mp, wc)
    if (!smsWide) {
        val back = smsIconButton(VectorIconView.BACK, 40, Color.WHITE, null) {
            smsCloseThread()
        }
        smsBackBtn = back
        header.addView(back)
    } else {
        header.setPadding(dp(16), dp(8), dp(12), dp(8))
    }
    val avatarHost = LinearLayout(a)
    avatarHost.layoutParams = LinearLayout.LayoutParams(wc, wc).apply {
        setMargins(dp(4), 0, dp(10), 0)
    }
    smsHeaderAvatarHost = avatarHost
    header.addView(avatarHost)

    val nameBlock = LinearLayout(a)
    nameBlock.orientation = LinearLayout.VERTICAL
    nameBlock.layoutParams = LinearLayout.LayoutParams(0, wc, 1f)
    val headerName = TextView(a)
    headerName.textSize = 15f
    headerName.typeface = Typeface.DEFAULT_BOLD
    headerName.setTextColor(Color.WHITE)
    headerName.maxLines = 1
    headerName.ellipsize = android.text.TextUtils.TruncateAt.END
    nameBlock.addView(headerName)
    smsHeaderName = headerName
    val headerSub = TextView(a)
    headerSub.textSize = 11f
    headerSub.setTextColor(W11.TEXT_DIM)
    nameBlock.addView(headerSub)
    smsHeaderSub = headerSub
    header.addView(nameBlock)

    header.addView(smsIconButton(VectorIconView.PHONE, 40, Color.parseColor("#6CCB5F"), null) {
        smsCurrentAddress?.let { openSystemDialer(it) }
    })
    header.addView(smsIconButton(VectorIconView.DELETE, 40, Color.parseColor("#FF99A4"), null) {
        smsCurrentAddress?.let { deleteSmsThread(it) }
    })
    content.addView(header)

    val divider = View(a)
    divider.setBackgroundColor(W11.DIVIDER)
    divider.layoutParams = LinearLayout.LayoutParams(mp, dp(1))
    content.addView(divider)

    // ── Messages ──
    val rv = RecyclerView(a)
    rv.layoutManager = LinearLayoutManager(a)
    rv.itemAnimator = null
    rv.setItemViewCacheSize(12)
    rv.overScrollMode = View.OVER_SCROLL_NEVER
    rv.setPadding(0, dp(8), 0, dp(8))
    rv.clipToPadding = false
    val adapter = SmsThreadAdapter(act)
    rv.adapter = adapter
    // Pagination: scrolling up near the oldest loaded message fetches 20 older ones
    rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(r: RecyclerView, dx: Int, dy: Int) {
            if (dy >= 0) return
            val lm = r.layoutManager as LinearLayoutManager
            if (lm.findFirstVisibleItemPosition() <= 3) smsLoadOlder()
        }
    })
    smsThreadRv = rv
    smsThreadAdapter = adapter
    val msgFrame = FrameLayout(a)
    msgFrame.layoutParams = LinearLayout.LayoutParams(mp, 0, 1f)
    rv.layoutParams = FrameLayout.LayoutParams(mp, mp)
    msgFrame.addView(rv)
    val spinner = smsSpinner()
    spinner.layoutParams = FrameLayout.LayoutParams(dp(32), dp(32), Gravity.CENTER)
    spinner.visibility = View.GONE
    smsThreadSpinner = spinner
    msgFrame.addView(spinner)
    content.addView(msgFrame)

    // ── Composer ──
    val replyBar = LinearLayout(a)
    replyBar.orientation = LinearLayout.HORIZONTAL
    replyBar.gravity = Gravity.CENTER_VERTICAL
    replyBar.setBackgroundColor(GLASS_BAR)
    replyBar.setPadding(dp(10), dp(8), dp(10), dp(8))
    replyBar.layoutParams = LinearLayout.LayoutParams(mp, wc)
    val inputBox = LinearLayout(a)
    inputBox.orientation = LinearLayout.HORIZONTAL
    inputBox.gravity = Gravity.CENTER_VERTICAL
    inputBox.background = smsRound(GLASS_FILL_STRONG, 8)
    inputBox.setPadding(dp(12), dp(2), dp(12), dp(2))
    inputBox.layoutParams = LinearLayout.LayoutParams(0, wc, 1f)
    val replyEdit = EditText(a)
    replyEdit.hint = "Type a message"
    replyEdit.textSize = 14f
    replyEdit.setTextColor(Color.WHITE)
    replyEdit.setHintTextColor(Color.parseColor("#80FFFFFF"))
    replyEdit.setBackgroundColor(Color.TRANSPARENT)
    replyEdit.maxLines = 4
    replyEdit.setPadding(0, dp(8), 0, dp(8))
    replyEdit.layoutParams = LinearLayout.LayoutParams(mp, wc)
    smsReplyEdit = replyEdit
    inputBox.addView(replyEdit)
    replyBar.addView(inputBox)
    val sendBtn = smsIconButton(VectorIconView.SEND, 42, Color.BLACK, W11.ACCENT) {
        val address = smsCurrentAddress
        val text = replyEdit.text.toString().trim()
        if (address != null && text.isNotEmpty() && sendSms(address, text)) {
            replyEdit.setText("")
            // Show the sent message instantly (no re-query, no lag).
            val ad = smsThreadAdapter
            if (ad != null) {
                val now = System.currentTimeMillis()
                val dayFmt = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
                val lastMsg = ad.items.lastOrNull { it is SmsItem.Msg } as? SmsItem.Msg
                if (lastMsg == null || dayFmt.format(Date(lastMsg.msg.date)) != dayFmt.format(Date(now)))
                    ad.items.add(SmsItem.Day(dayFmt.format(Date(now))))
                ad.items.add(
                    SmsItem.Msg(
                        SmsMessage(
                            text, now, Telephony.TextBasedSmsColumns.MESSAGE_TYPE_SENT, local = true
                        )
                    )
                )
                ad.notifyItemRangeInserted(ad.items.size - 1, 1)
                smsThreadRv?.scrollToPosition(ad.items.size - 1)
            }
        }
    }
    (sendBtn.layoutParams as LinearLayout.LayoutParams).leftMargin = dp(8)
    replyBar.addView(sendBtn)
    content.addView(replyBar)
}

// ── Read state: opening a conversation marks it read ──────────────────

internal fun MainActivity.smsReadAt(address: String): Long = smsUiPrefs.getLong("readat:$address", 0L)


internal fun MainActivity.smsMarkRead(address: String) {
    // Local marker always works; the SMS provider itself only accepts the write when
    // this app is the default SMS app, so that part is best effort.
    smsUiPrefs.edit().putLong("readat:$address", System.currentTimeMillis()).apply()
    smsListAdapter?.clearUnread(address)
    smsExec.execute {
        try {
            val cv = ContentValues().apply { put("read", 1) }
            contentResolver.update(Uri.parse("content://sms/"), cv, "address = ? AND read = 0", arrayOf(address))
        } catch (e: Exception) { }
    }
}

// ── Realtime messages: list + open chat update the moment an SMS arrives or is sent ──

internal fun MainActivity.smsLiveSoon(delayMs: Long) {
    smsMain.removeCallbacks(smsLiveRunnable)
    smsMain.postDelayed(smsLiveRunnable, delayMs)
}

/**
 * Two triggers, both debounced: a ContentObserver on content://sms (fires when the SMS provider
 * changes) and the SMS_RECEIVED broadcast (fires first, so the update is as fast as the phone allows).
 */

internal fun MainActivity.registerSmsLive() {
    if (smsObserver == null) {
        try {
            val o = object : android.database.ContentObserver(smsMain) {
                override fun onChange(selfChange: Boolean) { smsLiveSoon(250) }
            }
            contentResolver.registerContentObserver(Uri.parse("content://sms"), true, o)
            smsObserver = o
        } catch (e: Throwable) { AppLog.w(LOGT, "sms observer failed", e) }
    }
    if (smsArrivedReceiver == null) {
        try {
            val r = object : BroadcastReceiver() {
                override fun onReceive(c: Context?, i: Intent?) { smsLiveSoon(800) }
            }
            ContextCompat.registerReceiver(
                this, r, IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION),
                ContextCompat.RECEIVER_EXPORTED
            )
            smsArrivedReceiver = r
        } catch (e: Throwable) { AppLog.w(LOGT, "sms receiver failed", e) }
    }
}


internal fun MainActivity.unregisterSmsLive() {
    try { smsMain.removeCallbacks(smsLiveRunnable) } catch (_: Throwable) { }
    try { smsObserver?.let { contentResolver.unregisterContentObserver(it) } } catch (_: Throwable) { }
    smsObserver = null
    try { smsArrivedReceiver?.let { unregisterReceiver(it) } } catch (_: Throwable) { }
    smsArrivedReceiver = null
}


internal fun MainActivity.smsLiveRefresh() {
    if (!isUIInitialized || activeSection != "sms") return
    if (ContextCompat.checkSelfPermission(this, PERM_SMS_R) != PackageManager.PERMISSION_GRANTED) return
    refreshSmsView() // conversation list: new preview text, unread badge, newest on top
    val address = smsCurrentAddress ?: return
    val ad = smsThreadAdapter ?: return
    if (smsThreadContent?.visibility != View.VISIBLE) return
    val gen = smsThreadGen
    try {
        smsExec.execute {
            val (latest, _, error) = smsQueryPage(address, Long.MAX_VALUE)
            if (error != null || latest.isEmpty()) return@execute
            smsMain.post {
                if (gen != smsThreadGen || smsCurrentAddress != address) return@post
                smsMergeLatest(address, ad, latest)
            }
        }
    } catch (_: Throwable) { }
}

/**
 * Merges the newest page into the open chat without reloading it: older pages stay, the newest
 * messages are replaced by the provider's copy, and a just-sent bubble is kept until the provider
 * has the same message (non-default SMS apps never get their sent messages written to the provider).
 */

internal fun MainActivity.smsMergeLatest(address: String, ad: SmsThreadAdapter, latest: List<SmsMessage>) {
    val current = ad.items.mapNotNull { (it as? SmsItem.Msg)?.msg }
    val cut = latest.first().date
    val sentInProvider = latest.filter { smsIsOutgoing(it.type) }
    val keep = current.filter { m ->
        if (m.local) sentInProvider.none { it.body == m.body && Math.abs(it.date - m.date) < 5 * 60_000L }
        else m.date < cut
    }
    val merged = (keep + latest).sortedBy { it.date }
    val last = merged.last()
    val cur = current.lastOrNull()
    if (cur != null && merged.size == current.size &&
        last.date == cur.date && last.body == cur.body && last.local == cur.local
    ) return // nothing new

    val lastCurrentDate = cur?.date ?: 0L
    val gotIncoming = merged.any {
        !smsIsOutgoing(it.type) && it.date > lastCurrentDate
    }
    val rv = smsThreadRv
    val lm = rv?.layoutManager as? LinearLayoutManager
    val atBottom = lm == null || ad.items.isEmpty() ||
        lm.findLastVisibleItemPosition() >= ad.items.size - 2

    val items = smsBuildItems(merged)
    ad.submit(items)
    smsUpdateHeaderSub(merged.size, smsThreadHasMore)
    if (atBottom && items.isNotEmpty()) rv?.scrollToPosition(items.size - 1) // like a chat app
    if (gotIncoming) smsMarkRead(address) // the chat is open, so it is read
}

// ── Conversation list pagination (20 per page) ────────────────────────

internal fun MainActivity.smsLoadMoreConversations() {
    if (smsConvLoadingMore) return
    val all = smsConvAll
    val from = smsConvShown
    if (from >= all.size) return
    smsConvLoadingMore = true
    val gen = smsListGen
    smsExec.execute {
        val next = all.subList(from, minOf(all.size, from + SMS_PAGE)).toList()
        smsResolveStubs(next)
        next.forEach { c -> c.name = smsDisplayName(c.address) }
        smsMain.post {
            smsConvLoadingMore = false
            if (gen != smsListGen || all !== smsConvAll) return@post
            smsConvShown = from + next.size
            smsListAdapter?.append(next)
        }
    }
}

// ── Thread pagination (20 per page, newest first, oldest page on scroll up) ──
/** One page of a thread: up to [SMS_PAGE] messages older than [before], returned oldest -> newest. */

internal fun MainActivity.smsQueryPage(address: String, before: Long): Triple<List<SmsMessage>, Boolean, String?> {
    val out = ArrayList<SmsMessage>()
    var error: String? = null
    try {
        val first = before == Long.MAX_VALUE
        val cursor = contentResolver.query(
            Uri.parse("content://sms/"),
            arrayOf("body", "date", "type"),
            if (first) "address = ?" else "address = ? AND date < ?",
            if (first) arrayOf(address) else arrayOf(address, before.toString()),
            "date DESC LIMIT ${SMS_PAGE + 1}" // one extra row tells us whether more exist
        )
        cursor?.use {
            val bodyIdx = it.getColumnIndex("body")
            val dateIdx = it.getColumnIndex("date")
            val typeIdx = it.getColumnIndex("type")
            while (it.moveToNext()) {
                out.add(
                    SmsMessage(
                        if (bodyIdx >= 0) it.getString(bodyIdx) ?: "" else "",
                        if (dateIdx >= 0) it.getLong(dateIdx) else 0L,
                        if (typeIdx >= 0) it.getInt(typeIdx) else 1
                    )
                )
            }
        }
    } catch (e: Exception) {
        error = e.message
    }
    val more = out.size > SMS_PAGE
    if (more) out.removeAt(out.size - 1)
    out.reverse() // oldest -> newest
    return Triple(out, more, error)
}

/** If the loaded messages do not fill the screen yet, keep fetching older pages. */

internal fun MainActivity.smsMaybeLoadOlder() {
    val rv = smsThreadRv ?: return
    val lm = rv.layoutManager as? LinearLayoutManager ?: return
    if (smsThreadHasMore && lm.findFirstVisibleItemPosition() <= 0) smsLoadOlder()
}


internal fun MainActivity.smsLoadOlder() {
    val address = smsCurrentAddress ?: return
    val adapter = smsThreadAdapter ?: return
    if (!smsThreadHasMore || smsThreadLoadingMore) return
    smsThreadLoadingMore = true
    val gen = smsThreadGen
    val before = smsThreadOldest
    adapter.items.add(0, SmsItem.Loading)
    adapter.notifyItemInserted(0)
    smsExec.execute {
        val (older, more, error) = smsQueryPage(address, before)
        smsMain.post {
            smsThreadLoadingMore = false
            if (gen != smsThreadGen || smsCurrentAddress != address) return@post
            val rv = smsThreadRv ?: return@post
            val lm = rv.layoutManager as LinearLayoutManager
            val items = adapter.items

            // Anchor on the first visible message so the screen does not jump when older ones are added above.
            var pos = lm.findFirstVisibleItemPosition().coerceAtLeast(0)
            while (pos < items.size && items[pos] !is SmsItem.Msg) pos++
            val anchor = items.getOrNull(pos) as? SmsItem.Msg
            val anchorTop = lm.findViewByPosition(pos)?.top ?: 0

            items.removeAll { it is SmsItem.Loading }
            if (error != null) {
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "SMS thread error: $error", Toast.LENGTH_SHORT).show()
                return@post
            }
            if (older.isNotEmpty()) {
                val dayFmt = SimpleDateFormat("d MMMM yyyy", Locale.getDefault())
                // merge the day separator when the older page ends on the same day the list starts with
                val top = items.firstOrNull() as? SmsItem.Day
                if (top != null && top.label == dayFmt.format(Date(older.last().date))) items.removeAt(0)
                items.addAll(0, smsBuildItems(older))
                smsThreadOldest = older.first().date
            }
            smsThreadHasMore = more && older.isNotEmpty()
            adapter.notifyDataSetChanged()
            if (anchor != null) {
                val idx = items.indexOfFirst { it === anchor }
                if (idx >= 0) lm.scrollToPositionWithOffset(idx, anchorTop)
            }
            smsUpdateHeaderSub(items.count { it is SmsItem.Msg }, smsThreadHasMore)
            rv.post { smsMaybeLoadOlder() }
        }
    }
}


internal fun MainActivity.openSmsThread(address: String, displayName: String) {
    ensureSmsThreadUi()
    val adapter = smsThreadAdapter ?: return
    val changed = smsCurrentAddress != address
    smsCurrentAddress = address
    smsCurrentName = displayName
    if (changed) {
        smsReplyEdit?.setText("")
        adapter.submit(mutableListOf())
    }
    smsThreadHasMore = false
    smsThreadLoadingMore = false
    smsThreadOldest = 0L
    smsHeaderName?.text = displayName
    smsHeaderAvatarHost?.removeAllViews()
    smsHeaderAvatarHost?.addView(smsAvatar(displayName, 36))
    smsUpdateHeaderSub(0, false)
    smsShowThreadPane()
    smsListAdapter?.selected = address // moves the highlight, no list reload
    smsMarkRead(address)

    val gen = ++smsThreadGen
    if (adapter.items.isEmpty()) smsThreadSpinner?.visibility = View.VISIBLE
    smsExec.execute {
        val (messages, more, error) = smsQueryPage(address, Long.MAX_VALUE)
        val items = smsBuildItems(messages)
        smsMain.post {
            if (gen != smsThreadGen || smsCurrentAddress != address) return@post
            smsThreadSpinner?.visibility = View.GONE
            if (error != null) {
                Toast.makeText(this, "SMS thread error: $error", Toast.LENGTH_SHORT).show()
                return@post
            }
            if (messages.isEmpty()) items.add(SmsItem.Day("No messages"))
            smsThreadHasMore = more
            smsThreadOldest = messages.firstOrNull()?.date ?: 0L
            adapter.submit(items)
            smsUpdateHeaderSub(messages.size, more)
            // open at the newest message, like a chat app
            if (items.isNotEmpty()) smsThreadRv?.scrollToPosition(items.size - 1)
            smsThreadRv?.post { smsMaybeLoadOlder() }
        }
    }
}

/** [local] = bubble shown instantly after Send, before (or without) the SMS provider having it. */

data class SmsMessage(val body: String, val date: Long, val type: Int, val local: Boolean = false)


internal fun MainActivity.showComposeSmsDialog(preFilledAddress: String?, preFilledBody: String) {
    val dialogView = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setBackgroundColor(Color.parseColor("#1E1E1E"))
        setPadding(dp(16), dp(16), dp(16), dp(16))
    }
    dialogView.addView(TextView(this).apply {
        text = "To:"
        setTextColor(Color.parseColor("#AAAAAA"))
        textSize = 13f
    })
    val toEdit = EditText(this).apply {
        hint = "Phone number"
        textSize = 14f
        setText(preFilledAddress ?: "")
        setTextColor(Color.WHITE)
        inputType = android.text.InputType.TYPE_CLASS_PHONE
    }.glassStyle()
    dialogView.addView(toEdit)
    dialogView.addView(View(this).apply {
        layoutParams =
            LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(8))
    })
    dialogView.addView(TextView(this).apply {
        text = "Message:"
        setTextColor(Color.parseColor("#AAAAAA"))
        textSize = 13f
    })
    val msgEdit = EditText(this).apply {
        hint = "Type message here…"
        textSize = 14f
        setText(preFilledBody)
        setTextColor(Color.WHITE)
        minLines = 3
        maxLines = 6
        gravity = Gravity.TOP
    }.glassStyle()
    dialogView.addView(msgEdit)

    W11Dialog.Builder(this)
        .setTitle("New message")
        .setView(dialogView)
        .setPositiveButton("Send") { _, _ ->
            val to = toEdit.text.toString().trim()
            val msg = msgEdit.text.toString().trim()
            if (to.isEmpty() || msg.isEmpty()) {
                Toast.makeText(this, "Number and message required", Toast.LENGTH_SHORT).show()
            } else sendSms(to, msg)
        }
        .setNegativeButton("Cancel", null)
        .show()
}


internal fun MainActivity.sendSms(address: String, body: String): Boolean {
    if (ContextCompat.checkSelfPermission(
            this, PERM_SMS_S
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            this, arrayOf(PERM_SMS_S, PERM_SMS_R), REQ_SMS
        )
        Toast.makeText(this, "SMS permission required", Toast.LENGTH_SHORT).show()
        return false
    }
    try {
        // default SMS app: the message is also written to the provider (Outbox -> Sent / Failed)
        smsSendAndRecord(this, address, body)
        Toast.makeText(this, "SMS sent to $address", Toast.LENGTH_SHORT).show()
        if (activeSection == "sms") refreshSmsView()
        return true
    } catch (e: Exception) {
        Toast.makeText(this, "SMS failed: ${e.message}", Toast.LENGTH_LONG).show()
        return false
    }
}


internal fun MainActivity.deleteSmsThread(address: String) {
    W11Dialog.Builder(this)
        .setTitle("Delete conversation")
        .setMessage("Delete all messages with $address?")
        .setPositiveButton("Delete") { _, _ ->
            smsExec.execute {
                try {
                    val deleted = contentResolver.delete(
                        Uri.parse("content://sms/"), "address = ?", arrayOf(address)
                    )
                    smsMain.post {
                        Toast.makeText(
                            this, "Deleted $deleted message(s)", Toast.LENGTH_SHORT
                        ).show()
                        if (smsCurrentAddress == address) smsCloseThread() else refreshSmsView()
                    }
                } catch (e: Exception) {
                    smsMain.post {
                        Toast.makeText(
                            this, "Delete failed: ${e.message}", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        .setNegativeButton("Cancel", null).show()
}

// =====================================================================
// FILE MANAGER
// =====================================================================

