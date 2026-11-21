package com.srizwan.win11.parallel

import android.app.Activity
import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.net.Uri
import android.provider.OpenableColumns
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.Switch
import android.widget.TextView
import com.srizwan.chooser.picker.FilePicker
import com.srizwan.win11.Toast
import top.niunaijun.blackbox.utils.bundle.BundleInstaller
import java.io.File
import java.text.DateFormat
import java.util.Date

class ParallelActivity : Activity() {

    private val ui = Handler(Looper.getMainLooper())
    private lateinit var list: LinearLayout
    private lateinit var subtitle: TextView
    private lateinit var status: TextView
    private lateinit var progressBar: ProgressBar
    /** True while a file install runs, so a second one cannot be started. */
    private var installing = false

    /** Part 26: per-clone views whose "running" look is refreshed by [pollRunning]. */
    private class RunViews(val item: CloneItem, val dot: TextView, val stop: TextView)
    private val runViews = ArrayList<RunViews>()
    private var polling = false
    private val pollTask = object : Runnable {
        override fun run() {
            if (!polling) return
            pollRunning()
            ui.postDelayed(this, 2000L)
        }
    }

    /** Checks every listed clone off the main thread and updates the dots and stop buttons. */
    private fun pollRunning() {
        val views = ArrayList(runViews)
        if (views.isEmpty()) return
        Engine.io.execute {
            val states = views.map { Engine.isRunning(it.item.packageName, it.item.userId) }
            ui.post { views.forEachIndexed { i, v -> applyRunning(v, states[i]) } }
        }
    }

    private fun applyRunning(v: RunViews, running: Boolean) {
        v.dot.visibility = if (running) View.VISIBLE else View.GONE
        v.stop.alpha = if (running) 1f else 0.35f
        v.stop.isEnabled = running
    }

    private fun startPolling() {
        if (polling) return
        polling = true
        ui.post(pollTask)
    }

    private fun stopPolling() {
        polling = false
        ui.removeCallbacks(pollTask)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Palette.PRIMARY_DARK
        setContentView(buildUi())
        Engine.onReady { ui.post { refresh() } }
        refresh()
        Engine.io.execute { Engine.cleanTemp() }
        permStep = 0
        nextPermissionStep()
    }

    // ------------------------------------------------------------------ permissions

    private var permStep = 0

    private fun runtimePermissions(): List<String> {
        val l = ArrayList<String>()
        l += listOf(
            Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO,
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.GET_ACCOUNTS,
            Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR,
            Manifest.permission.READ_PHONE_STATE, Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG,
            Manifest.permission.READ_SMS, Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS, Manifest.permission.RECEIVE_MMS
        )
        if (Build.VERSION.SDK_INT < 33) {
            l += listOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (Build.VERSION.SDK_INT >= 26) l += Manifest.permission.READ_PHONE_NUMBERS
        if (Build.VERSION.SDK_INT >= 26) l += Manifest.permission.ANSWER_PHONE_CALLS
        if (Build.VERSION.SDK_INT >= 29) l += Manifest.permission.ACTIVITY_RECOGNITION
        if (Build.VERSION.SDK_INT >= 31) l += listOf(
            Manifest.permission.BLUETOOTH_CONNECT, Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_ADVERTISE
        )
        if (Build.VERSION.SDK_INT >= 33) l += listOf(
            Manifest.permission.POST_NOTIFICATIONS, Manifest.permission.NEARBY_WIFI_DEVICES,
            Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO,
            Manifest.permission.READ_MEDIA_AUDIO
        )
        if (Build.VERSION.SDK_INT >= 34) l += Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
        return l
    }

    /** False when the user denied POST_NOTIFICATIONS or switched the app's notifications off. */
    private fun notificationsAllowed(): Boolean {
        if (Build.VERSION.SDK_INT < 26) return true
        return try {
            if (Build.VERSION.SDK_INT >= 33 &&
                checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
            ) return false
            (getSystemService(NOTIFICATION_SERVICE) as android.app.NotificationManager).areNotificationsEnabled()
        } catch (e: Throwable) {
            true
        }
    }

    private fun missing(list: List<String>): Array<String> =
        list.filter { checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED }.toTypedArray()

    /** Step 0: normal runtime permissions -> 1: background location -> 2: all-files access -> 3: overlay -> 4: notifications on. */
    private fun nextPermissionStep() {
        while (permStep < 5) {
            val step = permStep++
            when (step) {
                0 -> {
                    val m = missing(runtimePermissions())
                    if (m.isNotEmpty()) { requestPermissions(m, 100); return }
                }
                1 -> if (Build.VERSION.SDK_INT >= 29) {
                    val m = missing(listOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION))
                    if (m.isNotEmpty()) { requestPermissions(m, 101); return }
                }
                2 -> if (Build.VERSION.SDK_INT >= 30 && !Environment.isExternalStorageManager()) {
                    try {
                        startActivity(Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:$packageName")))
                    } catch (e: Throwable) {
                        try { startActivity(Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)) } catch (e2: Throwable) { }
                    }
                    return // continue from onResume() when the user comes back
                }
                3 -> if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
                    try {
                        startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName")))
                    } catch (e: Throwable) { }
                    return
                }
                // needed so the "app is not running" notification (tap = destroy app) can be shown
                4 -> if (!notificationsAllowed()) {
                    try {
                        startActivity(
                            Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                                .putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
                        )
                    } catch (e: Throwable) { }
                    return
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        nextPermissionStep()
    }

    private var pausedForSettings = false

    override fun onPause() {
        super.onPause()
        stopPolling()
        if (permStep in 3..5) pausedForSettings = true
    }

    override fun onResume() {
        super.onResume()
        startPolling()
        if (pausedForSettings) {
            pausedForSettings = false
            nextPermissionStep()
        }
    }

    // ------------------------------------------------------------------ layout

    private fun buildUi(): View {
        val root = FrameLayout(this).apply { setBackgroundColor(Palette.BG) }

        val column = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }

        val header = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(22), dp(26), dp(22), dp(22))
            val r = dp(26).toFloat()
            background = GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                intArrayOf(Palette.PRIMARY_DARK, Palette.PRIMARY)
            ).apply { setCornerRadii(floatArrayOf(0f, 0f, 0f, 0f, r, r, r, r)) }
        }
        header.addView(tv("🌀 Parallel", 28f, Color.WHITE, bold = true))
        header.addView(tv("একই অ্যাপ, আলাদা অ্যাকাউন্ট", 14f, Color.parseColor("#E0DDFF")))
        subtitle = tv("", 13f, Color.WHITE).apply { setPadding(0, dp(10), 0, 0) }
        header.addView(subtitle)
        column.addView(header, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT))

        status = tv("", 14f, Palette.TEXT, bold = true).apply {
            background = roundBg(Palette.AMBER, 14)
            setPadding(dp(14), dp(10), dp(14), dp(10))
            visibility = View.GONE
        }
        column.addView(status, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            setMargins(dp(16), dp(12), dp(16), 0)
        })

        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal).apply {
            max = 1000
            isIndeterminate = true
            progressTintList = ColorStateList.valueOf(Palette.PRIMARY)
            indeterminateTintList = ColorStateList.valueOf(Palette.PRIMARY)
            visibility = View.GONE
        }
        column.addView(progressBar, LinearLayout.LayoutParams(MATCH_PARENT, dp(6)).apply {
            setMargins(dp(16), dp(6), dp(16), 0)
        })

        // The option cards scroll together with the clone list, so a growing number of them
        // never pushes the list off a small screen.
        val content = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        content.addView(independentCopyRow(), LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            setMargins(dp(16), dp(12), dp(16), 0)
        })
        content.addView(backgroundServiceRow(), LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            setMargins(dp(16), dp(8), dp(16), 0)
        })
        content.addView(installInBoxRow(), LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            setMargins(dp(16), dp(8), dp(16), 0)
        })
        content.addView(spaceLimitRow(), LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply {
            setMargins(dp(16), dp(8), dp(16), 0)
        })

        list = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(12), dp(16), dp(110))
        }
        content.addView(list, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT))
        column.addView(ScrollView(this).apply { addView(content) }, LinearLayout.LayoutParams(MATCH_PARENT, 0, 1f))

        root.addView(column, FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))

        val add = tv("➕  ক্লোন করুন", 16f, Color.WHITE, bold = true).apply {
            gravity = Gravity.CENTER
            background = roundBg(Palette.PRIMARY, 30)
            setPadding(dp(22), dp(16), dp(22), dp(16))
            elevation = dp(6).toFloat()
            setOnClickListener { if (!installing) showPicker() else toast("⏳ ইনস্টল চলছে, একটু অপেক্ষা করুন") }
        }
        val fromFile = tv("📂  ফাইল থেকে", 16f, Color.WHITE, bold = true).apply {
            gravity = Gravity.CENTER
            background = roundBg(Palette.PRIMARY_DARK, 30)
            setPadding(dp(22), dp(16), dp(22), dp(16))
            elevation = dp(6).toFloat()
            setOnClickListener { pickInstallFile() }
        }
        val bar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            addView(add, LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT))
            addView(fromFile, LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply { leftMargin = dp(10) })
        }
        root.addView(bar, FrameLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT, Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL).apply {
            bottomMargin = dp(26)
        })
        root.setOnApplyWindowInsetsListener { _, ins ->
            @Suppress("DEPRECATION")
            val top = ins.systemWindowInsetTop
            @Suppress("DEPRECATION")
            val bottom = ins.systemWindowInsetBottom
            header.setPadding(dp(22), dp(26) + top, dp(22), dp(22))
            (bar.layoutParams as FrameLayout.LayoutParams).bottomMargin = dp(26) + bottom
            bar.requestLayout()
            ins
        }
        return root
    }

    // ------------------------------------------------------------------ clone list

    private fun refresh() {
        Engine.io.execute {
            val items = Engine.listClones()
            ui.post { render(items) }
        }
    }

    private fun render(items: List<CloneItem>) {
        subtitle.text = if (items.isEmpty()) "কোনো ক্লোন নেই" else "📦 মোট ক্লোন: ${items.size}"
        list.removeAllViews()
        runViews.clear()
        if (items.isEmpty()) {
            list.addView(tv("📭", 56f).apply { gravity = Gravity.CENTER; setPadding(0, dp(60), 0, dp(8)) })
            list.addView(tv("এখনো কোনো অ্যাপ ক্লোন করা হয়নি", 16f, Palette.TEXT, bold = true).apply { gravity = Gravity.CENTER })
            list.addView(tv("নিচের ➕ বাটনে চাপ দিয়ে শুরু করুন", 13f, Palette.MUTED).apply {
                gravity = Gravity.CENTER
                setPadding(0, dp(6), 0, 0)
            })
            return
        }
        for (item in items) list.addView(cloneRow(item))
        pollRunning() // show the running state right away, then the poll keeps it fresh
    }

    private fun appIcon(icon: Drawable?, sizeDp: Int): View =
        if (icon != null) {
            ImageView(this).apply {
                setImageDrawable(icon)
                layoutParams = LinearLayout.LayoutParams(dp(sizeDp), dp(sizeDp))
            }
        } else {
            tv("📦", 26f).apply {
                gravity = Gravity.CENTER
                layoutParams = LinearLayout.LayoutParams(dp(sizeDp), dp(sizeDp))
            }
        }

    /** A card with a title, a short explanation and a switch. */
    private fun switchRow(title: String, note: String, checked: Boolean, onChange: (Boolean) -> Unit): View {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = roundBg(Palette.CARD, 18)
            setPadding(dp(14), dp(10), dp(14), dp(10))
            elevation = dp(2).toFloat()
        }
        val texts = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)
        }
        texts.addView(tv(title, 15f, Palette.TEXT, bold = true))
        texts.addView(tv(note, 11f, Palette.MUTED))
        row.addView(texts)
        row.addView(Switch(this).apply {
            isChecked = checked
            setOnCheckedChangeListener { _, on -> onChange(on) }
        })
        return row
    }

    /** A card with "−  N  +" to set how many spaces one app can be cloned into. */
    private fun spaceLimitRow(): View {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = roundBg(Palette.CARD, 18)
            setPadding(dp(14), dp(10), dp(10), dp(10))
            elevation = dp(2).toFloat()
        }
        val texts = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)
        }
        texts.addView(tv("🔢 সর্বোচ্চ স্পেস", 15f, Palette.TEXT, bold = true))
        texts.addView(tv("একটি অ্যাপ সর্বোচ্চ কয়টি স্পেসে ক্লোন করা যাবে। কমালে আগের ক্লোন মুছে যায় না।", 11f, Palette.MUTED))
        row.addView(texts)
        val count = tv("${Engine.maxSpaces}", 18f, Palette.TEXT, bold = true).apply {
            gravity = Gravity.CENTER
            minWidth = dp(34)
        }
        fun change(delta: Int) {
            Engine.maxSpaces = Engine.maxSpaces + delta
            count.text = "${Engine.maxSpaces}"
        }
        row.addView(emojiButton("➖", Palette.AMBER) { change(-1) })
        row.addView(count)
        row.addView(emojiButton("➕", Palette.GREEN) { change(1) })
        return row
    }

    /** Switch for the independent copy mode of new clones made from phone apps. */
    private fun independentCopyRow(): View = switchRow(
        "💾 স্বাধীন কপি",
        "ফোনের মূল অ্যাপ আপডেট বা মুছে ফেললেও ক্লোন চলবে। বেশি স্টোরেজ লাগে।",
        Engine.independentCopy
    ) { on ->
        Engine.independentCopy = on
        toast(if (on) "💾 নতুন ক্লোনের APK ফাইল নিজস্ব জায়গায় কপি হবে" else "🔗 নতুন ক্লোন ফোনের মূল ফাইল ব্যবহার করবে")
    }

    /** Part 31: switch for installing APKs that a cloned app asks for into the box instead of the phone. */
    private fun installInBoxRow(): View = switchRow(
        "📥 বক্সের ভেতরে ইনস্টল",
        "ক্লোন অ্যাপ (ব্রাউজার, ফাইল ম্যানেজার) কোনো APK ইনস্টল চাইলে সেটা ফোনে নয়, ওই ক্লোনের স্পেসেই ইনস্টল হবে।",
        InstallInBoxSetting.isEnabled(applicationContext)
    ) { on ->
        InstallInBoxSetting.setEnabled(applicationContext, on)
        toast(if (on) "📥 ক্লোনের ইনস্টল এখন বক্সের ভেতরে হবে" else "📱 ক্লোনের ইনস্টল ফোনের সিস্টেম ইনস্টলারে যাবে")
    }

    /** Switch for the engine's background service (isEnableDaemonService). */
    private fun backgroundServiceRow(): View = switchRow(
        "🔋 ব্যাকগ্রাউন্ড সার্ভিস",
        "চালু থাকলে ক্লোন অ্যাপগুলো সহজে বন্ধ হয় না। একটি স্থায়ী নোটিফিকেশন দেখাবে, ব্যাটারি বেশি লাগতে পারে।",
        DaemonSetting.isEnabled(applicationContext)
    ) { on ->
        DaemonSetting.setEnabled(applicationContext, on)
        toast(if (on) "🔋 ব্যাকগ্রাউন্ড সার্ভিস চালু হয়েছে" else "🔋 ব্যাকগ্রাউন্ড সার্ভিস বন্ধ হয়েছে")
    }

    private fun cloneRow(item: CloneItem): View {
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = roundBg(Palette.CARD, 18)
            setPadding(dp(14), dp(12), dp(10), dp(12))
            elevation = dp(2).toFloat()
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT).apply { bottomMargin = dp(10) }
        }
        // Part 26: six buttons no longer fit beside the name, so they sit in their own strip below it
        val top = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        val actions = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL or Gravity.END
            setPadding(0, dp(8), 0, 0)
        }
        top.addView(appIcon(item.icon, 46))

        val info = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(12), 0, dp(8), 0)
            layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)
        }
        val titleLine = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        titleLine.addView(tv(item.title, 16f, Palette.TEXT, bold = true).apply {
            oneLine()
            layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)
        })
        // Part 26: running indicator (a green pill), hidden until the poll says the clone runs
        val dot = tv("● চলছে", 10f, Color.parseColor("#1E8E3E"), bold = true).apply {
            background = roundBg(Palette.GREEN, 8)
            setPadding(dp(7), dp(2), dp(7), dp(2))
            visibility = View.GONE
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply { leftMargin = dp(6) }
        }
        titleLine.addView(dot)
        info.addView(titleLine)
        info.addView(tv("স্পেস ${item.userId + 1} · ${if (item.independent) "💾 স্বাধীন" else "🔗 মূল অ্যাপের সাথে"} · ${item.packageName}", 11f, Palette.MUTED).apply { oneLine() })
        top.addView(info)
        row.addView(top)
        // seven buttons can be wider than a small screen, so the strip scrolls sideways
        row.addView(HorizontalScrollView(this).apply {
            isHorizontalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            isFillViewport = true
            addView(actions, FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT))
        })

        actions.addView(emojiButton("▶️", Palette.GREEN) { openClone(item) })
        // Part 26: force-stop; only active while the clone runs (see applyRunning)
        val stop = emojiButton("⏹️", Palette.RED) { forceStop(item) }.apply {
            alpha = 0.35f
            isEnabled = false
        }
        actions.addView(stop)
        runViews.add(RunViews(item, dot, stop))
        actions.addView(emojiButton("📍", Palette.AMBER) { openFakeLocation(item) })
        actions.addView(emojiButton("⚙️", Palette.LILAC) { openPermissions(item) })
        actions.addView(emojiButton("💾", Palette.GREEN) { showBackupMenu(item) })
        actions.addView(emojiButton("🧹", Palette.AMBER) { confirm("🧹 ডেটা মুছবেন?", "${item.label} (স্পেস ${item.userId + 1}) এর সব ডেটা মুছে যাবে।") { clearClone(item) } })
        actions.addView(emojiButton("🗑️", Palette.RED) { confirm("🗑️ ক্লোন মুছবেন?", "${item.label} (স্পেস ${item.userId + 1}) ক্লোনটি ডেটাসহ মুছে যাবে।") { removeClone(item) } })
        return row
    }

    // ------------------------------------------------------------------ actions

    private fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    private fun setStatus(msg: String?) {
        if (msg == null) {
            status.visibility = View.GONE
            progressBar.visibility = View.GONE
        } else {
            status.text = msg
            status.visibility = View.VISIBLE
        }
    }

    private fun openClone(item: CloneItem) {
        Engine.io.execute {
            val ok = Engine.launch(item.packageName, item.userId)
            if (!ok) ui.post { toast("❌ অ্যাপটি খোলা যায়নি") }
        }
    }

    /** Part 26: kills every process of the clone after a confirmation; data stays. */
    private fun forceStop(item: CloneItem) {
        confirm("⏹️ জোর করে বন্ধ করবেন?", "${item.label} (স্পেস ${item.userId + 1}) এখনই বন্ধ হবে। সেভ না করা কাজ হারাতে পারে, ডেটা মুছবে না।") {
            Engine.io.execute {
                Engine.forceStop(item.packageName, item.userId)
                val running = Engine.isRunning(item.packageName, item.userId)
                ui.post {
                    runViews.filter { it.item.packageName == item.packageName && it.item.userId == item.userId }
                        .forEach { applyRunning(it, running) }
                    toast(if (running) "⚠️ পুরোপুরি বন্ধ হয়নি, আবার চেষ্টা করুন" else "⏹️ ${item.label} বন্ধ হয়েছে")
                }
            }
        }
    }

    // ------------------------------------------------------------------ Part 30: backup and restore

    /** Menu of the 💾 button: new backup, restore, delete. */
    private fun showBackupMenu(item: CloneItem) {
        if (installing || backupBusy) { toast("⏳ আরেকটি কাজ চলছে, একটু অপেক্ষা করুন"); return }
        val names = arrayOf("💾 নতুন ব্যাকআপ নিন", "♻️ ব্যাকআপ থেকে রিস্টোর", "🗑️ ব্যাকআপ মুছুন")
        AlertDialog.Builder(this)
            .setTitle("💾 ${item.label} (স্পেস ${item.userId + 1})")
            .setItems(names) { _, which ->
                when (which) {
                    0 -> confirm("💾 ব্যাকআপ নেবেন?", "ব্যাকআপের আগে অ্যাপটি বন্ধ হবে, যাতে ডেটা ঠিকঠাক সেভ হয়। অ্যাপ নিজে (APK) সেভ হয় না, শুধু ডেটা।") { startBackup(item) }
                    1 -> pickBackup(item, restore = true)
                    2 -> pickBackup(item, restore = false)
                }
            }
            .setNegativeButton("বন্ধ", null)
            .show()
    }

    private var backupBusy = false

    private fun beginBackupWork(text: String) {
        backupBusy = true
        setStatus(text)
        progressBar.isIndeterminate = true
        progressBar.visibility = View.VISIBLE
    }

    private fun backupProgress(text: String, done: Int, total: Int) {
        ui.post {
            if (isFinishing || !backupBusy) return@post
            status.text = "$text  ($done/$total)"
            progressBar.isIndeterminate = total <= 0
            if (total > 0) progressBar.progress = ((done * 1000L) / total).toInt().coerceIn(0, 1000)
        }
    }

    private fun endBackupWork() {
        backupBusy = false
        if (!isFinishing) setStatus(null)
    }

    private fun startBackup(item: CloneItem) {
        beginBackupWork("⏳ ব্যাকআপ হচ্ছে…")
        Engine.io.execute {
            Engine.forceStop(item.packageName, item.userId)
            var file: File? = null
            var error: String? = null
            try {
                file = CloneBackup.backup(applicationContext, item.packageName, item.userId, item.label) { d, t ->
                    backupProgress("⏳ ব্যাকআপ হচ্ছে…", d, t)
                }
            } catch (t: Throwable) {
                error = t.message ?: t.javaClass.simpleName
            }
            val saved = file
            ui.post {
                endBackupWork()
                if (isFinishing) return@post
                if (saved != null) toast("✅ ব্যাকআপ হয়েছে (${sizeText(saved.length())})\n${saved.absolutePath}")
                else toast("❌ ব্যাকআপ হয়নি: $error")
                pollRunning()
            }
        }
    }

    private fun sizeText(bytes: Long): String =
        if (bytes >= 1048576L) "${bytes / 1048576L} MB" else "${(bytes + 1023L) / 1024L} KB"

    /** Lists the saved backups of the clone's app; picking one restores it or deletes it. */
    private fun pickBackup(item: CloneItem, restore: Boolean) {
        Engine.io.execute {
            val all = CloneBackup.list(applicationContext, item.packageName)
            ui.post {
                if (isFinishing) return@post
                if (all.isEmpty()) { toast("📭 এই অ্যাপের কোনো ব্যাকআপ নেই"); return@post }
                val df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT)
                val rows = all.map { "${df.format(Date(it.createdAt))}\nস্পেস ${it.userId + 1} · v${it.versionName} · ${sizeText(it.size)}" }.toTypedArray()
                AlertDialog.Builder(this)
                    .setTitle(if (restore) "♻️ কোনটি রিস্টোর করবেন?" else "🗑️ কোনটি মুছবেন?")
                    .setItems(rows) { _, i ->
                        val b = all[i]
                        if (restore) confirm(
                            "♻️ রিস্টোর করবেন?",
                            "${item.label} (স্পেস ${item.userId + 1}) এর এখনকার ডেটা এই ব্যাকআপ দিয়ে বদলে যাবে। অ্যাপটি বন্ধ হবে।\nব্যাকআপ: ${df.format(Date(b.createdAt))} (v${b.versionName})"
                        ) { startRestore(item, b) }
                        else confirm("🗑️ ব্যাকআপ মুছবেন?", "${df.format(Date(b.createdAt))} এর ব্যাকআপ ফাইলটি মুছে যাবে।") {
                            Engine.io.execute {
                                val ok = CloneBackup.delete(b)
                                ui.post { toast(if (ok) "🗑️ ব্যাকআপ মোছা হয়েছে" else "❌ ফাইল মোছা যায়নি") }
                            }
                        }
                    }
                    .setNegativeButton("বন্ধ", null)
                    .show()
            }
        }
    }

    private fun startRestore(item: CloneItem, b: CloneBackup.Info) {
        beginBackupWork("⏳ রিস্টোর হচ্ছে…")
        Engine.io.execute {
            Engine.forceStop(item.packageName, item.userId)
            val err = CloneBackup.restore(b, item.packageName, item.userId) { d, t ->
                backupProgress("⏳ রিস্টোর হচ্ছে…", d, t)
            }
            ui.post {
                endBackupWork()
                if (isFinishing) return@post
                toast(if (err == null) "✅ রিস্টোর হয়েছে, এখন অ্যাপটি খুলুন" else "❌ $err")
                pollRunning()
            }
        }
    }

    private fun openFakeLocation(item: CloneItem) {
        startActivity(Intent(this, FakeLocationActivity::class.java)
            .putExtra(FakeLocationActivity.EXTRA_PACKAGE, item.packageName)
            .putExtra(FakeLocationActivity.EXTRA_USER, item.userId)
            .putExtra(FakeLocationActivity.EXTRA_LABEL, item.label))
    }

    private fun openPermissions(item: CloneItem) {
        startActivity(Intent(this, PermissionsActivity::class.java)
            .putExtra(PermissionsActivity.EXTRA_PACKAGE, item.packageName)
            .putExtra(PermissionsActivity.EXTRA_USER, item.userId)
            .putExtra(PermissionsActivity.EXTRA_LABEL, item.label))
    }

    private fun clearClone(item: CloneItem) {
        setStatus("⏳ ডেটা মোছা হচ্ছে…")
        Engine.io.execute {
            Engine.clearData(item.packageName, item.userId)
            ui.post { setStatus(null); toast("✅ ডেটা মোছা হয়েছে") }
        }
    }

    private fun removeClone(item: CloneItem) {
        setStatus("⏳ মোছা হচ্ছে…")
        Engine.io.execute {
            Engine.remove(item.packageName, item.userId)
            ui.post { setStatus(null); refresh() }
        }
    }

    private fun startClone(app: DeviceApp) {
        setStatus("⏳ ${app.label} ক্লোন হচ্ছে…")
        Engine.io.execute {
            val error = Engine.clone(app.packageName)
            ui.post {
                setStatus(null)
                toast(if (error == null) "✅ ${app.label} ক্লোন হয়েছে" else "❌ $error")
                refresh()
            }
        }
    }

    private fun confirm(title: String, message: String, onYes: () -> Unit) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("হ্যাঁ") { _, _ -> onYes() }
            .setNegativeButton("না", null)
            .show()
    }

    // ------------------------------------------------------------------ install from file

    private val requestPickFile = 200

    private fun pickInstallFile() {
        if (installing) {
            toast("⏳ ইনস্টল চলছে, একটু অপেক্ষা করুন")
            return
        }
        try {
            startActivityForResult(
                FilePicker.intent(this, multiple = false, mimeTypes = InstallText.PICKER_TYPES, title = "📂 APK / XAPK / APKS / APKM"),
                requestPickFile
            )
        } catch (e: Throwable) {
            toast("❌ ফাইল বাছাই খোলা যায়নি")
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode != requestPickFile || resultCode != RESULT_OK) return
        // This app's own picker also returns the plain path: no copy is needed then.
        val path = FilePicker.paths(data).firstOrNull()
        if (path != null) {
            val f = File(path)
            installChosen(f.name, f.length(), file = f, uri = null)
            return
        }
        val uri = FilePicker.uris(data).firstOrNull() ?: return
        var name = uri.lastPathSegment ?: "file"
        var size = 0L
        try {
            contentResolver.query(uri, null, null, null, null)?.use { c ->
                if (c.moveToFirst()) {
                    val n = c.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    val z = c.getColumnIndex(OpenableColumns.SIZE)
                    if (n >= 0) name = c.getString(n) ?: name
                    if (z >= 0 && !c.isNull(z)) size = c.getLong(z)
                }
            }
        } catch (e: Throwable) {
            // name and size are only for the progress text
        }
        installChosen(name, size, file = null, uri = uri)
    }

    private fun installChosen(name: String, size: Long, file: File?, uri: Uri?) {
        if (installing) return
        installing = true
        setStatus("⏳ $name")
        progressBar.isIndeterminate = true
        progressBar.visibility = View.VISIBLE
        val listener = BundleInstaller.Listener { stage, done, total ->
            ui.post {
                if (isFinishing) return@post
                status.text = InstallText.stage(stage) + InstallText.amount(done, total) + "\n" + name
                val determinate = total > 0L && (stage == BundleInstaller.Stage.COPYING || stage == BundleInstaller.Stage.UNPACKING || stage == BundleInstaller.Stage.COPYING_OBB)
                progressBar.isIndeterminate = !determinate
                if (determinate) progressBar.progress = ((done * 1000L) / total).toInt().coerceIn(0, 1000)
            }
        }
        Engine.io.execute {
            val r = if (file != null) Engine.installFile(file, listener) else Engine.installUri(applicationContext, uri!!, size, listener)
            val label = if (r.success) Engine.labelOfInstalled(r.packageName ?: "", r.userId) else ""
            ui.post {
                installing = false
                if (isFinishing) return@post
                setStatus(null)
                if (r.success) {
                    var msg = "✅ $label ইনস্টল হয়েছে (স্পেস ${r.userId + 1})"
                    if (r.obbCount > 0) msg += "\n🎮 OBB ফাইল কপি হয়েছে (${r.obbCount} টি)"
                    toast(msg)
                } else {
                    showInstallError(name, r)
                }
                refresh()
            }
        }
    }

    private fun showInstallError(name: String, r: BundleInstaller.Result) {
        val (title, text) = InstallText.error(r.kind)
        val detail = tv(r.message ?: "", 11f, Palette.MUTED).apply {
            setTextIsSelectable(true)
            setPadding(0, dp(12), 0, 0)
        }
        val box = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(22), dp(8), dp(22), 0)
            addView(tv(name, 12f, Palette.MUTED).apply { oneLine() })
            addView(tv(text, 14f, Palette.TEXT).apply { setPadding(0, dp(8), 0, 0) })
            if (!r.message.isNullOrBlank()) addView(detail)
        }
        AlertDialog.Builder(this)
            .setTitle("❌ $title")
            .setView(ScrollView(this).apply { addView(box) })
            .setPositiveButton("ঠিক আছে", null)
            .show()
    }

    // ------------------------------------------------------------------ picker

    private fun showPicker() {
        val search = EditText(this).apply {
            hint = "🔍 অ্যাপ খুঁজুন"
            setSingleLine()
        }
        val box = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        val wrap = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(8), dp(16), 0)
            addView(search, LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT))
            addView(ScrollView(context).apply { addView(box) }, LinearLayout.LayoutParams(MATCH_PARENT, dp(380)))
        }
        val dialog = AlertDialog.Builder(this)
            .setTitle("➕ কোন অ্যাপ ক্লোন করবেন?")
            .setView(wrap)
            .setNegativeButton("বাতিল", null)
            .create()

        var apps: List<DeviceApp> = emptyList()
        fun fill() {
            val q = search.text.toString().trim()
            box.removeAllViews()
            val shown = apps.filter { q.isEmpty() || it.label.contains(q, ignoreCase = true) || it.packageName.contains(q, ignoreCase = true) }
            if (shown.isEmpty()) {
                box.addView(tv("কিছু পাওয়া যায়নি", 14f, Palette.MUTED).apply { setPadding(0, dp(20), 0, 0) })
                return
            }
            for (app in shown) {
                box.addView(LinearLayout(this).apply {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    setPadding(0, dp(8), 0, dp(8))
                    addView(appIcon(app.icon, 40))
                    addView(LinearLayout(context).apply {
                        orientation = LinearLayout.VERTICAL
                        setPadding(dp(12), 0, 0, 0)
                        addView(tv(app.label, 15f, Palette.TEXT, bold = true).apply { oneLine() })
                        addView(tv(app.packageName, 11f, Palette.MUTED).apply { oneLine() })
                    })
                    setOnClickListener { dialog.dismiss(); startClone(app) }
                })
            }
        }

        box.addView(tv("⏳ লোড হচ্ছে…", 14f, Palette.MUTED).apply { setPadding(0, dp(20), 0, 0) })
        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: Editable?) = fill()
        })
        dialog.show()

        Engine.io.execute {
            val loaded = Engine.deviceApps()
            ui.post {
                apps = loaded
                if (!isFinishing) fill()
            }
        }
    }
}
