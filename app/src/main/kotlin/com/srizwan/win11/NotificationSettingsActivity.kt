package com.srizwan.win11

import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.LruCache
import android.text.Editable
import android.text.TextWatcher
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors
import androidx.core.view.WindowInsetsCompat

/**
 * Notification settings (Win11 style, programmatic UI, vector icons only):
 * pop-ups from EVERY installed app with a per-app on/off switch (+ search, all on / all off),
 * a master switch, a sound switch (follows the Ring / Vibrate / Mute button) and the
 * "Display over other apps" permission that lets pop-ups appear over other apps.
 * Alerts are shown by WhatsAppNotificationListener even when the launcher is in the background.
 * Apps in NotifPrefs.customAlertApps (WhatsApp) also get their own sound, vibration and pop-up look
 * (style, accent colour, time, position, on/off); every other app shares one "All other apps" look.
 */
class NotificationSettingsActivity : AppCompatActivity() {

    private lateinit var statusText: TextView
    private lateinit var statusBtn: TextView
    /** One installed app in the per-app list. The icon is NOT loaded here (lazy, see [AppsAdapter]). */
    private class AppEntry(val pkg: String, val label: String, val ri: android.content.pm.ResolveInfo)
    private val appEntries = mutableListOf<AppEntry>()
    private var shownApps: List<AppEntry> = emptyList()
    private var query = ""
    private var masterOn = true
    private lateinit var appsStatus: TextView
    private var appsAdapter: AppsAdapter? = null

    /** Icons are decoded on a background thread and kept in a size-limited cache. */
    private val iconCache = object : LruCache<String, Bitmap>(
        maxOf(2048, (Runtime.getRuntime().maxMemory() / 1024 / 16).toInt())
    ) {
        override fun sizeOf(key: String, value: Bitmap): Int = value.byteCount / 1024
    }
    private val iconExec = Executors.newFixedThreadPool(2)

    private lateinit var overlayText: TextView
    private lateinit var overlayBtn: TextView

    private lateinit var adminStatusText: TextView
    private lateinit var adminBtn: TextView
    private val REQ_DEVICE_ADMIN = 9001
    private val REQ_SOUND_BASE = 9100 // + index in NotifPrefs.customAlertApps
    private val soundValueViews = HashMap<String, TextView>()
    private val vibValueViews = HashMap<String, TextView>()
    // pop-up look per profile id (a custom app's id, or NotifPrefs.POPUP_DEFAULT_ID for all other apps)
    private val popStyleViews = HashMap<String, TextView>()
    private val popDurViews = HashMap<String, TextView>()
    private val popPosViews = HashMap<String, TextView>()
    private val popSwatchRows = HashMap<String, LinearLayout>()
    private val popSwitches = HashMap<String, SwitchCompat>()

    private fun dp(v: Int): Int = (v * resources.displayMetrics.density).toInt()

    private fun round(color: Int, radiusDp: Int): GradientDrawable =
        GradientDrawable().apply {
            setColor(color)
            cornerRadius = dp(radiusDp).toFloat()
            setStroke(dp(1), Color.argb(28, 255, 255, 255))
        }

    private var glassBlur = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try { supportActionBar?.hide() } catch (e: Exception) { }
        try {
            @Suppress("DEPRECATION")
            window.statusBarColor = Color.TRANSPARENT
            @Suppress("DEPRECATION")
            window.navigationBarColor = Color.TRANSPARENT
            if (android.os.Build.VERSION.SDK_INT >= 31) {
                val wm = getSystemService(Context.WINDOW_SERVICE) as android.view.WindowManager
                if (wm.isCrossWindowBlurEnabled) {
                    window.setBackgroundBlurRadius((40 * resources.displayMetrics.density).toInt())
                    glassBlur = true
                }
            }
        } catch (e: Exception) { }
        setContentView(buildScreen())
        try {
            androidx.core.view.WindowCompat.getInsetsController(window, window.decorView).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
        } catch (e: Exception) { }
    }

    override fun onDestroy() {
        super.onDestroy()
        try { iconExec.shutdownNow() } catch (_: Throwable) { }
    }

    override fun onResume() {
        super.onResume()
        refreshStatus()
        refreshAdminStatus()
        refreshOverlayStatus()
        refreshPopupSwitches()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_DEVICE_ADMIN) refreshAdminStatus()
        val idx = requestCode - REQ_SOUND_BASE
        if (idx in NotifPrefs.customAlertApps.indices && resultCode == RESULT_OK) onSoundPicked(NotifPrefs.customAlertApps[idx], data)
    }

    // =====================================================================
    // UI
    // =====================================================================

    private fun buildScreen(): View {
        val mp = ViewGroup.LayoutParams.MATCH_PARENT
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT

        val root = LinearLayout(this)
        root.orientation = LinearLayout.VERTICAL
        root.setBackgroundColor(if (glassBlur) Color.argb(125, 24, 27, 34) else Color.argb(205, 24, 27, 34))
        root.layoutParams = ViewGroup.LayoutParams(mp, mp)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(b.left, b.top, b.right, b.bottom)
            insets
        }

        // ── Title bar: back + bell + title ──
        val titleBar = LinearLayout(this)
        titleBar.orientation = LinearLayout.HORIZONTAL
        titleBar.gravity = Gravity.CENTER_VERTICAL
        titleBar.setPadding(dp(6), 0, dp(14), 0)
        titleBar.layoutParams = LinearLayout.LayoutParams(mp, dp(52))
        titleBar.addView(iconButton(VectorIconView.BACK, 40, Color.WHITE) { finish() })
        val bell = VectorIconView(this, VectorIconView.BELL)
        bell.layoutParams = LinearLayout.LayoutParams(dp(18), dp(18)).apply { leftMargin = dp(6) }
        titleBar.addView(bell)
        val title = TextView(this)
        title.text = "Notifications"
        title.setTextColor(W11.TEXT)
        title.textSize = 17f
        title.typeface = Typeface.DEFAULT_BOLD
        title.setPadding(dp(10), 0, 0, 0)
        titleBar.addView(title)
        root.addView(titleBar)

        // The whole page is ONE RecyclerView: header (cards, search, bulk buttons) + app rows
        // (recycled) + footer (sound, test, note). Only the rows on screen exist as views.
        masterOn = NotifPrefs.isMasterOn(this)
        val col = LinearLayout(this) // header
        col.orientation = LinearLayout.VERTICAL
        col.setPadding(dp(16), dp(4), dp(16), 0)
        col.layoutParams = RecyclerView.LayoutParams(mp, wc)
        val footer = LinearLayout(this)
        footer.orientation = LinearLayout.VERTICAL
        footer.setPadding(dp(16), 0, dp(16), dp(24))
        footer.layoutParams = RecyclerView.LayoutParams(mp, wc)

        // ── Access status card ──
        val card = LinearLayout(this)
        card.orientation = LinearLayout.VERTICAL
        card.background = round(Color.argb(64, 255, 255, 255), 8)
        card.setPadding(dp(16), dp(14), dp(16), dp(14))
        card.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { bottomMargin = dp(16) }
        val cardTitle = TextView(this)
        cardTitle.text = "Notification access"
        cardTitle.setTextColor(W11.TEXT)
        cardTitle.textSize = 14f
        cardTitle.typeface = Typeface.DEFAULT_BOLD
        card.addView(cardTitle)
        statusText = TextView(this)
        statusText.setTextColor(W11.TEXT_DIM)
        statusText.textSize = 12f
        statusText.setPadding(0, dp(4), 0, 0)
        card.addView(statusText)
        statusBtn = TextView(this)
        statusBtn.text = "Open settings"
        statusBtn.setTextColor(Color.BLACK)
        statusBtn.textSize = 13f
        statusBtn.typeface = Typeface.DEFAULT_BOLD
        statusBtn.gravity = Gravity.CENTER
        statusBtn.background = round(W11.ACCENT, 6)
        statusBtn.setPadding(dp(16), dp(8), dp(16), dp(8))
        statusBtn.layoutParams = LinearLayout.LayoutParams(wc, wc).apply { topMargin = dp(10) }
        statusBtn.setOnClickListener {
            try {
                startActivity(Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS))
            } catch (e: Exception) {
                Toast.makeText(this, "Can't open settings", Toast.LENGTH_SHORT).show()
            }
        }
        card.addView(statusBtn)
        col.addView(card)

        // ── Uninstall protection (Device Admin) card ──
        col.addView(sectionLabel("Security"))
        val adminCard = LinearLayout(this)
        adminCard.orientation = LinearLayout.VERTICAL
        adminCard.background = round(Color.argb(64, 255, 255, 255), 8)
        adminCard.setPadding(dp(16), dp(14), dp(16), dp(14))
        adminCard.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { bottomMargin = dp(16) }
        val adminTitle = TextView(this)
        adminTitle.text = "Uninstall protection"
        adminTitle.setTextColor(W11.TEXT)
        adminTitle.textSize = 14f
        adminTitle.typeface = Typeface.DEFAULT_BOLD
        adminCard.addView(adminTitle)
        adminStatusText = TextView(this)
        adminStatusText.setTextColor(W11.TEXT_DIM)
        adminStatusText.textSize = 12f
        adminStatusText.setPadding(0, dp(4), 0, 0)
        adminCard.addView(adminStatusText)
        adminBtn = TextView(this)
        adminBtn.setTextColor(Color.BLACK)
        adminBtn.textSize = 13f
        adminBtn.typeface = Typeface.DEFAULT_BOLD
        adminBtn.gravity = Gravity.CENTER
        adminBtn.background = round(W11.ACCENT, 6)
        adminBtn.setPadding(dp(16), dp(8), dp(16), dp(8))
        adminBtn.layoutParams = LinearLayout.LayoutParams(wc, wc).apply { topMargin = dp(10) }
        adminBtn.setOnClickListener {
            if (AppDeviceAdmin.isActive(this)) {
                AppDeviceAdmin.deactivate(this)
                refreshAdminStatus()
            } else {
                AppDeviceAdmin.requestActivation(this, REQ_DEVICE_ADMIN)
            }
        }
        adminCard.addView(adminBtn)
        col.addView(adminCard)

        // ── Master switch ──
        col.addView(sectionLabel("General"))
        col.addView(
            toggleRow(
                VectorIconView.BELL, W11.ACCENT, "Show notification pop-ups",
                "Pop-ups from every app, on or off at once",
                NotifPrefs.isMasterOn(this)
            ) { on ->
                NotifPrefs.setMaster(this, on)
                applyMasterState(on)
            }.first
        )

        // ── Pop-ups over other apps (overlay permission) ──
        col.addView(sectionLabel("Pop-up over other apps"))
        val ovCard = LinearLayout(this)
        ovCard.orientation = LinearLayout.VERTICAL
        ovCard.background = round(Color.argb(64, 255, 255, 255), 8)
        ovCard.setPadding(dp(16), dp(14), dp(16), dp(14))
        ovCard.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { bottomMargin = dp(16) }
        overlayText = TextView(this)
        overlayText.setTextColor(W11.TEXT_DIM)
        overlayText.textSize = 12f
        ovCard.addView(overlayText)
        overlayBtn = TextView(this)
        overlayBtn.text = "Allow display over other apps"
        overlayBtn.setTextColor(Color.BLACK)
        overlayBtn.textSize = 13f
        overlayBtn.typeface = Typeface.DEFAULT_BOLD
        overlayBtn.gravity = Gravity.CENTER
        overlayBtn.background = round(W11.ACCENT, 6)
        overlayBtn.setPadding(dp(16), dp(8), dp(16), dp(8))
        overlayBtn.layoutParams = LinearLayout.LayoutParams(wc, wc).apply { topMargin = dp(10) }
        overlayBtn.setOnClickListener {
            try {
                startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName")))
            } catch (e: Exception) {
                Toast.makeText(this, "Can't open settings", Toast.LENGTH_SHORT).show()
            }
        }
        ovCard.addView(overlayBtn)
        col.addView(ovCard)

        // ── Per-app switches: every installed app ──
        col.addView(sectionLabel("Apps"))
        col.addView(buildAppSearch())
        col.addView(buildBulkRow())
        appsStatus = TextView(this)
        appsStatus.text = "Loading apps..."
        appsStatus.setTextColor(W11.TEXT_DIM)
        appsStatus.textSize = 12f
        appsStatus.setPadding(dp(4), dp(6), 0, dp(6))
        col.addView(appsStatus)

        // ── Sound ──
        footer.addView(sectionLabel("Sound"))
        footer.addView(
            toggleRow(
                VectorIconView.BELL, Color.parseColor("#FFB900"), "Play notification sound",
                "Ring = sound, Vibrate = vibration, Mute = silent (set with the Ring button in Quick Settings)",
                NotifPrefs.isSoundOn(this)
            ) { on -> NotifPrefs.setSound(this, on) }.first
        )

        // ── Own sound + vibration per app (WhatsApp, and any app added to NotifPrefs.customAlertApps) ──
        footer.addView(sectionLabel("Sound & vibration per app"))
        for ((i, app) in NotifPrefs.customAlertApps.withIndex()) footer.addView(buildAlertCard(app, i))

        // ── Own pop-up look per app (same apps as above) + one card for every other app ──
        footer.addView(sectionLabel("Pop-up per app"))
        for (app in NotifPrefs.customAlertApps) {
            footer.addView(buildPopupCard(app.id, app.label, app.color, app, app.packages.first()))
        }
        footer.addView(buildPopupCard(NotifPrefs.POPUP_DEFAULT_ID, "All other apps", W11.ACCENT, null, packageName))

        // ── Test ──
        val test = TextView(this)
        test.text = "Send test notification"
        test.setTextColor(Color.BLACK)
        test.textSize = 14f
        test.typeface = Typeface.DEFAULT_BOLD
        test.gravity = Gravity.CENTER
        test.background = round(W11.ACCENT, 8)
        test.setPadding(dp(16), dp(12), dp(16), dp(12))
        test.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { topMargin = dp(20) }
        test.setOnClickListener {
            NotifPrefs.alert(this, "Test", "This is a test notification", "Notifications", packageName)
        }
        footer.addView(test)

        val note = TextView(this)
        note.text = "Pop-ups from all apps also appear while the launcher is paused, stopped or in the background. Allow display over other apps so they show as a glass card over any app."
        note.setTextColor(W11.TEXT_DIM)
        note.textSize = 11f
        note.setPadding(dp(4), dp(10), dp(4), 0)
        footer.addView(note)

        val rv = RecyclerView(this)
        rv.layoutManager = LinearLayoutManager(this)
        rv.layoutParams = LinearLayout.LayoutParams(mp, 0, 1f)
        rv.isVerticalScrollBarEnabled = false
        rv.itemAnimator = null
        rv.overScrollMode = View.OVER_SCROLL_NEVER
        rv.setItemViewCacheSize(8)
        val ad = AppsAdapter(col, footer)
        appsAdapter = ad
        rv.adapter = ad
        root.addView(rv)
        loadApps()
        return root
    }

    private fun sectionLabel(text: String): TextView {
        val tv = TextView(this)
        tv.text = text
        tv.setTextColor(W11.TEXT_DIM)
        tv.textSize = 12f
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.setPadding(dp(4), dp(10), 0, dp(8))
        return tv
    }

    private fun iconButton(type: String, sizeDp: Int, color: Int, onClick: () -> Unit): FrameLayout {
        val box = FrameLayout(this)
        box.layoutParams = LinearLayout.LayoutParams(dp(sizeDp), dp(sizeDp))
        val ic = VectorIconView(this, type)
        ic.setIconColor(color)
        val isz = (sizeDp * 0.5f).toInt()
        ic.layoutParams = FrameLayout.LayoutParams(dp(isz), dp(isz), Gravity.CENTER)
        box.addView(ic)
        box.isClickable = true
        box.setOnClickListener { onClick() }
        return box
    }

    /** One card row: vector icon, title, subtitle, Win11-style switch. */
    private fun toggleRow(
        iconType: String, iconColor: Int, title: String, subtitle: String,
        checked: Boolean, onChange: (Boolean) -> Unit
    ): Pair<View, SwitchCompat> {
        val mp = ViewGroup.LayoutParams.MATCH_PARENT
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT
        val row = LinearLayout(this)
        row.orientation = LinearLayout.HORIZONTAL
        row.gravity = Gravity.CENTER_VERTICAL
        row.background = round(Color.argb(64, 255, 255, 255), 8)
        row.setPadding(dp(14), dp(12), dp(10), dp(12))
        row.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { bottomMargin = dp(6) }

        val ic = VectorIconView(this, iconType)
        ic.setIconColor(iconColor)
        ic.layoutParams = LinearLayout.LayoutParams(dp(24), dp(24)).apply { rightMargin = dp(14) }
        row.addView(ic)

        val texts = LinearLayout(this)
        texts.orientation = LinearLayout.VERTICAL
        texts.layoutParams = LinearLayout.LayoutParams(0, wc, 1f)
        val t = TextView(this)
        t.text = title
        t.setTextColor(W11.TEXT)
        t.textSize = 14f
        texts.addView(t)
        val st = TextView(this)
        st.text = subtitle
        st.setTextColor(W11.TEXT_DIM)
        st.textSize = 11f
        texts.addView(st)
        row.addView(texts)

        val sw = SwitchCompat(this)
        val states = arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf())
        sw.thumbTintList = ColorStateList(states, intArrayOf(Color.BLACK, Color.parseColor("#CCCCCC")))
        sw.trackTintList = ColorStateList(states, intArrayOf(W11.ACCENT, Color.parseColor("#555555")))
        sw.isChecked = checked
        sw.setOnCheckedChangeListener { _, on -> onChange(on) }
        row.addView(sw)
        return Pair(row, sw)
    }

    /** Dims and disables the per-app rows while the master switch is off. */
    private fun applyMasterState(on: Boolean) {
        masterOn = on
        appsAdapter?.let { if (shownApps.isNotEmpty()) it.notifyItemRangeChanged(1, shownApps.size) }
    }

    // =====================================================================
    // Per-app list (every installed app) - RecyclerView, lazy icons
    // =====================================================================

    private fun buildAppSearch(): View {
        val mp = ViewGroup.LayoutParams.MATCH_PARENT
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT
        val et = EditText(this)
        et.hint = "Search apps"
        et.setHintTextColor(W11.TEXT_DIM)
        et.setTextColor(W11.TEXT)
        et.textSize = 14f
        et.isSingleLine = true
        et.background = round(Color.argb(64, 255, 255, 255), 20)
        et.setPadding(dp(16), dp(10), dp(16), dp(10))
        et.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { bottomMargin = dp(8) }
        et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) { query = s?.toString().orEmpty().trim().lowercase(); applyFilter() }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        return et
    }

    private fun buildBulkRow(): View {
        val row = LinearLayout(this)
        row.orientation = LinearLayout.HORIZONTAL
        fun pill(text: String, on: Boolean): TextView {
            val t = TextView(this)
            t.text = text
            t.setTextColor(W11.TEXT)
            t.textSize = 12f
            t.background = round(Color.argb(64, 255, 255, 255), 16)
            t.setPadding(dp(14), dp(7), dp(14), dp(7))
            t.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT).apply { rightMargin = dp(8) }
            t.setOnClickListener {
                NotifPrefs.setPkgsOn(this, appEntries.map { it.pkg }, on)
                // visible rows rebind and read the saved state; off-screen rows read it when shown
                if (shownApps.isNotEmpty()) appsAdapter?.notifyItemRangeChanged(1, shownApps.size)
                refreshPopupSwitches()
            }
            return t
        }
        row.addView(pill("Turn all on", true))
        row.addView(pill("Turn all off", false))
        return row
    }

    /** Lists every launchable app (name only, no icons) off the UI thread. */
    private fun loadApps() {
        Thread {
            val list = ArrayList<AppEntry>()
            try {
                val pm = packageManager
                val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
                val seen = HashSet<String>()
                for (ri in pm.queryIntentActivities(intent, 0)) {
                    val pkg = ri.activityInfo?.packageName ?: continue
                    if (pkg == packageName || !seen.add(pkg)) continue
                    val label = try { ri.loadLabel(pm).toString() } catch (_: Exception) { pkg }
                    list.add(AppEntry(pkg, label, ri))
                }
                list.sortBy { it.label.lowercase() }
            } catch (e: Throwable) {
                AppLog.e("NotifSettings", "app list failed", e)
            }
            Handler(Looper.getMainLooper()).post {
                if (isFinishing || isDestroyed) return@post
                appEntries.clear()
                appEntries.addAll(list)
                applyFilter()
            }
        }.start()
    }

    /** Search: rebuilds the shown list and animates only the difference (header keeps its focus). */
    private fun applyFilter() {
        val q = query
        val old = shownApps
        val new: List<AppEntry> =
            if (q.isEmpty()) ArrayList(appEntries)
            else appEntries.filter { it.label.lowercase().contains(q) || it.pkg.lowercase().contains(q) }
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize() = old.size + 2
            override fun getNewListSize() = new.size + 2
            override fun areItemsTheSame(o: Int, n: Int): Boolean = when {
                o == 0 || n == 0 -> o == n
                o == old.size + 1 || n == new.size + 1 -> o == old.size + 1 && n == new.size + 1
                else -> old[o - 1].pkg == new[n - 1].pkg
            }
            override fun areContentsTheSame(o: Int, n: Int) = true
        })
        shownApps = new
        appsAdapter?.let { diff.dispatchUpdatesTo(it) }
        appsStatus.text = when {
            appEntries.isEmpty() -> "No apps found"
            q.isEmpty() -> "${appEntries.size} apps"
            else -> "${new.size} of ${appEntries.size} apps"
        }
    }

    private class StaticHolder(v: View) : RecyclerView.ViewHolder(v)

    /** One app row: icon (lazy), name, package, pop-up on/off switch. */
    private inner class AppHolder(
        val row: LinearLayout, val icon: ImageView, val name: TextView, val pkgText: TextView, val sw: SwitchCompat
    ) : RecyclerView.ViewHolder(row) {
        fun bind(e: AppEntry) {
            name.text = e.label
            pkgText.text = e.pkg
            row.alpha = if (masterOn) 1f else 0.45f
            sw.isEnabled = masterOn
            sw.setOnCheckedChangeListener(null)
            sw.isChecked = NotifPrefs.isPkgOn(this@NotificationSettingsActivity, e.pkg)
            sw.setOnCheckedChangeListener { _, on ->
                NotifPrefs.setPkgOn(this@NotificationSettingsActivity, e.pkg, on)
                refreshPopupSwitches() // keep the per-app pop-up card in step with this row
            }
            icon.tag = e.pkg
            val cached = iconCache.get(e.pkg)
            if (cached != null) {
                icon.setImageBitmap(cached)
            } else {
                icon.setImageDrawable(null)
                val size = dp(30)
                iconExec.execute {
                    if (icon.tag != e.pkg) return@execute // row was recycled meanwhile
                    val bmp = try { e.ri.loadIcon(packageManager).toBitmap(size, size) } catch (_: Throwable) { null }
                    if (bmp != null) {
                        iconCache.put(e.pkg, bmp)
                        runOnUiThread { if (!isDestroyed && icon.tag == e.pkg) icon.setImageBitmap(bmp) }
                    }
                }
            }
        }
    }

    private fun newAppHolder(): AppHolder {
        val mp = ViewGroup.LayoutParams.MATCH_PARENT
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT
        val row = LinearLayout(this)
        row.orientation = LinearLayout.HORIZONTAL
        row.gravity = Gravity.CENTER_VERTICAL
        row.background = round(Color.argb(64, 255, 255, 255), 8)
        row.setPadding(dp(14), dp(10), dp(10), dp(10))
        row.layoutParams = RecyclerView.LayoutParams(mp, wc).apply {
            leftMargin = dp(16); rightMargin = dp(16); bottomMargin = dp(6)
        }

        val ic = ImageView(this)
        ic.layoutParams = LinearLayout.LayoutParams(dp(30), dp(30)).apply { rightMargin = dp(14) }
        row.addView(ic)

        val texts = LinearLayout(this)
        texts.orientation = LinearLayout.VERTICAL
        texts.layoutParams = LinearLayout.LayoutParams(0, wc, 1f)
        val t = TextView(this)
        t.setTextColor(W11.TEXT)
        t.textSize = 14f
        t.maxLines = 1
        t.ellipsize = android.text.TextUtils.TruncateAt.END
        texts.addView(t)
        val st = TextView(this)
        st.setTextColor(W11.TEXT_DIM)
        st.textSize = 11f
        st.maxLines = 1
        st.ellipsize = android.text.TextUtils.TruncateAt.END
        texts.addView(st)
        row.addView(texts)

        val sw = SwitchCompat(this)
        val states = arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf())
        sw.thumbTintList = ColorStateList(states, intArrayOf(Color.BLACK, Color.parseColor("#CCCCCC")))
        sw.trackTintList = ColorStateList(states, intArrayOf(W11.ACCENT, Color.parseColor("#555555")))
        row.addView(sw)
        return AppHolder(row, ic, t, st, sw)
    }

    /** position 0 = header, last = footer, everything between = app rows. */
    private inner class AppsAdapter(private val header: View, private val footer: View) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun getItemCount() = shownApps.size + 2
        override fun getItemViewType(position: Int) = when (position) {
            0 -> 0
            itemCount - 1 -> 2
            else -> 1
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
            0 -> StaticHolder(header)
            2 -> StaticHolder(footer)
            else -> newAppHolder()
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if (holder is AppHolder) holder.bind(shownApps[position - 1])
        }
    }

    // =====================================================================
    // Own sound + vibration per app
    // =====================================================================

    private fun buildAlertCard(app: NotifApp, index: Int): View {
        val mp = ViewGroup.LayoutParams.MATCH_PARENT
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT
        val card = LinearLayout(this)
        card.orientation = LinearLayout.VERTICAL
        card.background = round(Color.argb(64, 255, 255, 255), 8)
        card.setPadding(dp(14), dp(12), dp(14), dp(12))
        card.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { bottomMargin = dp(6) }

        val title = TextView(this)
        title.text = app.label
        title.setTextColor(app.color)
        title.textSize = 14f
        title.typeface = Typeface.DEFAULT_BOLD
        card.addView(title)

        fun valueRow(label: String, value: TextView, onClick: () -> Unit): View {
            val row = LinearLayout(this)
            row.orientation = LinearLayout.HORIZONTAL
            row.gravity = Gravity.CENTER_VERTICAL
            row.setPadding(0, dp(10), 0, dp(10))
            val l = TextView(this)
            l.text = label
            l.setTextColor(W11.TEXT)
            l.textSize = 13f
            l.layoutParams = LinearLayout.LayoutParams(0, wc, 1f)
            row.addView(l)
            value.setTextColor(W11.ACCENT)
            value.textSize = 13f
            value.maxLines = 1
            value.ellipsize = android.text.TextUtils.TruncateAt.END
            value.maxWidth = dp(170)
            row.addView(value)
            row.setOnClickListener { onClick() }
            return row
        }

        val sv = TextView(this)
        sv.text = NotifPrefs.soundLabel(this, NotifPrefs.getSoundSetting(this, app.id))
        soundValueViews[app.id] = sv
        card.addView(valueRow("Sound", sv) { pickSound(app, index) })

        val vv = TextView(this)
        vv.text = NotifPrefs.vibLabel(NotifPrefs.getVibId(this, app.id))
        vibValueViews[app.id] = vv
        card.addView(valueRow("Vibration", vv) { pickVibration(app) })

        val actions = LinearLayout(this)
        actions.orientation = LinearLayout.HORIZONTAL
        fun pill(text: String, onClick: () -> Unit): TextView {
            val t = TextView(this)
            t.text = text
            t.setTextColor(W11.TEXT)
            t.textSize = 12f
            t.background = round(Color.argb(64, 255, 255, 255), 16)
            t.setPadding(dp(14), dp(7), dp(14), dp(7))
            t.layoutParams = LinearLayout.LayoutParams(wc, wc).apply { rightMargin = dp(8) }
            t.setOnClickListener { onClick() }
            return t
        }
        actions.addView(pill("Preview") { NotifPrefs.previewAlert(this, app.id) })
        actions.addView(pill("Reset to default") {
            NotifPrefs.resetAlert(this, app.id)
            refreshAlertValues(app)
        })
        card.addView(actions)

        val note = TextView(this)
        note.text = "Sound plays in Ring mode. A vibration pattern also vibrates in Ring mode; Default vibrates only in Vibrate mode; Off never vibrates."
        note.setTextColor(W11.TEXT_DIM)
        note.textSize = 11f
        note.setPadding(0, dp(8), 0, 0)
        card.addView(note)
        return card
    }

    private fun refreshAlertValues(app: NotifApp) {
        soundValueViews[app.id]?.text = NotifPrefs.soundLabel(this, NotifPrefs.getSoundSetting(this, app.id))
        vibValueViews[app.id]?.text = NotifPrefs.vibLabel(NotifPrefs.getVibId(this, app.id))
    }

    private fun pickSound(app: NotifApp, index: Int) {
        try {
            val saved = NotifPrefs.getSoundSetting(this, app.id)
            val i = Intent(RingtoneManager.ACTION_RINGTONE_PICKER)
            i.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION)
            i.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "${app.label} sound")
            i.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true)
            i.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, true)
            i.putExtra(
                RingtoneManager.EXTRA_RINGTONE_DEFAULT_URI,
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            )
            val existing: Uri? = when (saved) {
                null -> RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                NotifPrefs.SOUND_SILENT -> null
                else -> Uri.parse(saved)
            }
            i.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, existing)
            @Suppress("DEPRECATION")
            startActivityForResult(i, REQ_SOUND_BASE + index)
        } catch (e: Exception) {
            Toast.makeText(this, "Can't open the sound picker", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onSoundPicked(app: NotifApp, data: Intent?) {
        @Suppress("DEPRECATION")
        val uri: Uri? = data?.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
        val def = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        NotifPrefs.setSoundSetting(
            this, app.id,
            when (uri) {
                null -> NotifPrefs.SOUND_SILENT
                def -> null // "Default" entry of the picker
                else -> uri.toString()
            }
        )
        refreshAlertValues(app)
        if (uri != null) NotifPrefs.playSound(this, if (uri == def) null else uri.toString())
    }

    private fun pickVibration(app: NotifApp) {
        val pats = NotifPrefs.vibPatterns
        val cur = pats.indexOfFirst { it.id == NotifPrefs.getVibId(this, app.id) }.coerceAtLeast(0)
        W11Dialog.Builder(this)
            .setTitle("${app.label} vibration")
            .setSingleChoiceItems(pats.map { it.label }.toTypedArray(), cur) { _, which ->
                val id = pats[which].id
                NotifPrefs.setVibId(this, app.id, id)
                refreshAlertValues(app)
                if (id != "off") NotifPrefs.vibratePattern(this, id) // preview
            }
            .setNegativeButton("Close", null)
            .show()
    }

    // =====================================================================
    // Own pop-up look per app: style, accent colour, time, position, on/off
    // =====================================================================

    /** A card for one pop-up profile. [app] = null is the "all other apps" card (no own on/off switch). */
    private fun buildPopupCard(id: String, label: String, appColor: Int, app: NotifApp?, previewPkg: String): View {
        val mp = ViewGroup.LayoutParams.MATCH_PARENT
        val wc = ViewGroup.LayoutParams.WRAP_CONTENT
        val card = LinearLayout(this)
        card.orientation = LinearLayout.VERTICAL
        card.background = round(Color.argb(64, 255, 255, 255), 8)
        card.setPadding(dp(14), dp(12), dp(14), dp(12))
        card.layoutParams = LinearLayout.LayoutParams(mp, wc).apply { bottomMargin = dp(6) }

        val title = TextView(this)
        title.text = label
        title.setTextColor(appColor)
        title.textSize = 14f
        title.typeface = Typeface.DEFAULT_BOLD
        card.addView(title)

        // On / off for this app (same switch as in the app list; covers all of the app's packages)
        if (app != null) {
            val sw = SwitchCompat(this)
            val states = arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf())
            sw.thumbTintList = ColorStateList(states, intArrayOf(Color.BLACK, Color.parseColor("#CCCCCC")))
            sw.trackTintList = ColorStateList(states, intArrayOf(W11.ACCENT, Color.parseColor("#555555")))
            sw.text = "Show pop-ups from this app"
            sw.setTextColor(W11.TEXT)
            sw.textSize = 13f
            sw.setPadding(0, dp(8), 0, dp(4))
            sw.isChecked = app.packages.all { NotifPrefs.isPkgOn(this, it) }
            sw.setOnCheckedChangeListener { _, on ->
                NotifPrefs.setPkgsOn(this, app.packages, on)
                if (shownApps.isNotEmpty()) appsAdapter?.notifyItemRangeChanged(1, shownApps.size)
            }
            popSwitches[id] = sw
            card.addView(sw, LinearLayout.LayoutParams(mp, wc))
        }

        fun valueRow(labelText: String, value: TextView, onClick: () -> Unit): View {
            val row = LinearLayout(this)
            row.orientation = LinearLayout.HORIZONTAL
            row.gravity = Gravity.CENTER_VERTICAL
            row.setPadding(0, dp(10), 0, dp(10))
            val l = TextView(this)
            l.text = labelText
            l.setTextColor(W11.TEXT)
            l.textSize = 13f
            l.layoutParams = LinearLayout.LayoutParams(0, wc, 1f)
            row.addView(l)
            value.setTextColor(W11.ACCENT)
            value.textSize = 13f
            value.maxLines = 1
            value.ellipsize = android.text.TextUtils.TruncateAt.END
            value.maxWidth = dp(170)
            row.addView(value)
            row.setOnClickListener { onClick() }
            return row
        }

        val sv = TextView(this)
        sv.text = NotifPrefs.popupStyleLabel(NotifPrefs.getPopupStyleId(this, id))
        popStyleViews[id] = sv
        card.addView(valueRow("Style", sv) { pickPopupStyle(id, label, previewPkg) })

        // accent colour swatches
        val colorLabel = TextView(this)
        colorLabel.text = "Accent colour"
        colorLabel.setTextColor(W11.TEXT)
        colorLabel.textSize = 13f
        colorLabel.setPadding(0, dp(10), 0, dp(6))
        card.addView(colorLabel)
        val swatches = LinearLayout(this)
        swatches.orientation = LinearLayout.HORIZONTAL
        swatches.gravity = Gravity.CENTER_VERTICAL
        popSwatchRows[id] = swatches
        renderSwatches(id, appColor.takeIf { app != null }, swatches, previewPkg, label)
        card.addView(swatches)

        val dv = TextView(this)
        dv.text = NotifPrefs.popupDurationLabel(NotifPrefs.getPopupDurationMs(this, id))
        popDurViews[id] = dv
        card.addView(valueRow("Stays for", dv) { pickPopupDuration(id, label) })

        val pv = TextView(this)
        pv.text = NotifPrefs.popupPositionLabel(NotifPrefs.getPopupPosition(this, id))
        popPosViews[id] = pv
        card.addView(valueRow("Position", pv) { pickPopupPosition(id, label, previewPkg) })

        val actions = LinearLayout(this)
        actions.orientation = LinearLayout.HORIZONTAL
        fun pill(text: String, onClick: () -> Unit): TextView {
            val t = TextView(this)
            t.text = text
            t.setTextColor(W11.TEXT)
            t.textSize = 12f
            t.background = round(Color.argb(64, 255, 255, 255), 16)
            t.setPadding(dp(14), dp(7), dp(14), dp(7))
            t.layoutParams = LinearLayout.LayoutParams(wc, wc).apply { rightMargin = dp(8) }
            t.setOnClickListener { onClick() }
            return t
        }
        actions.addView(pill("Preview") { previewPopup(label, previewPkg) })
        actions.addView(pill("Reset to default") {
            NotifPrefs.resetPopup(this, id)
            refreshPopupValues(id, appColor.takeIf { app != null }, previewPkg, label)
        })
        card.addView(actions)

        val note = TextView(this)
        note.text = if (app != null)
            "Used for pop-ups from ${app.label}, inside the launcher and over other apps. Default = glass card, top right, 5 seconds."
        else
            "Used for every app that has no pop-up look of its own above. Default = glass card, top right, 5 seconds."
        note.setTextColor(W11.TEXT_DIM)
        note.textSize = 11f
        note.setPadding(0, dp(8), 0, 0)
        card.addView(note)
        return card
    }

    /** (Re)draws the colour dots of one profile; the saved one gets a white ring. [ownColor] = the app's own colour, offered as an extra dot. */
    private fun renderSwatches(id: String, ownColor: Int?, row: LinearLayout, previewPkg: String, label: String) {
        row.removeAllViews()
        val saved = NotifPrefs.getPopupAccent(this, id)
        val choices = ArrayList<Int>()
        NotifPrefs.popupColors.forEach { choices.add(it.color) }
        if (ownColor != null && ownColor !in choices) choices.add(1, ownColor) // right after "Default"
        for (c in choices) {
            val dot = View(this)
            val selected = c == saved
            dot.background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(if (c == 0) Color.TRANSPARENT else c)
                setStroke(
                    dp(if (selected) 3 else 2),
                    if (selected) Color.WHITE else if (c == 0) Color.argb(140, 255, 255, 255) else Color.argb(40, 255, 255, 255)
                )
            }
            dot.contentDescription = NotifPrefs.popupColors.firstOrNull { it.color == c }?.label ?: "App colour"
            dot.layoutParams = LinearLayout.LayoutParams(dp(28), dp(28)).apply { rightMargin = dp(10) }
            dot.setOnClickListener {
                NotifPrefs.setPopupAccent(this, id, c)
                renderSwatches(id, ownColor, row, previewPkg, label)
                previewPopup(label, previewPkg)
            }
            row.addView(dot)
        }
    }

    private fun refreshPopupValues(id: String, ownColor: Int?, previewPkg: String, label: String) {
        popStyleViews[id]?.text = NotifPrefs.popupStyleLabel(NotifPrefs.getPopupStyleId(this, id))
        popDurViews[id]?.text = NotifPrefs.popupDurationLabel(NotifPrefs.getPopupDurationMs(this, id))
        popPosViews[id]?.text = NotifPrefs.popupPositionLabel(NotifPrefs.getPopupPosition(this, id))
        popSwatchRows[id]?.let { renderSwatches(id, ownColor, it, previewPkg, label) }
    }

    /** Shows the pop-up with the saved look of that app right here, so every change can be seen at once. */
    private fun previewPopup(label: String, previewPkg: String) {
        GlassToast.show(this, previewPkg, label, "Preview", "This is how the pop-up looks.")
    }

    private fun pickPopupStyle(id: String, label: String, previewPkg: String) {
        val opts = NotifPrefs.popupStyles
        val cur = opts.indexOfFirst { it.id == NotifPrefs.getPopupStyleId(this, id) }.coerceAtLeast(0)
        W11Dialog.Builder(this)
            .setTitle("$label pop-up style")
            .setSingleChoiceItems(opts.map { it.label }.toTypedArray(), cur) { _, which ->
                NotifPrefs.setPopupStyleId(this, id, opts[which].id)
                popStyleViews[id]?.text = opts[which].label
                previewPopup(label, previewPkg)
            }
            .setNegativeButton("Close", null)
            .show()
    }

    private fun pickPopupDuration(id: String, label: String) {
        val opts = NotifPrefs.popupDurations
        val cur = opts.indexOfFirst { it.ms == NotifPrefs.getPopupDurationMs(this, id) }.coerceAtLeast(0)
        W11Dialog.Builder(this)
            .setTitle("$label pop-up time")
            .setSingleChoiceItems(opts.map { it.label }.toTypedArray(), cur) { _, which ->
                NotifPrefs.setPopupDurationMs(this, id, opts[which].ms)
                popDurViews[id]?.text = opts[which].label
            }
            .setNegativeButton("Close", null)
            .show()
    }

    private fun pickPopupPosition(id: String, label: String, previewPkg: String) {
        val opts = NotifPrefs.popupPositions
        val cur = opts.indexOfFirst { it.id == NotifPrefs.getPopupPosition(this, id) }.coerceAtLeast(0)
        W11Dialog.Builder(this)
            .setTitle("$label pop-up position")
            .setSingleChoiceItems(opts.map { it.label }.toTypedArray(), cur) { _, which ->
                NotifPrefs.setPopupPosition(this, id, opts[which].id)
                popPosViews[id]?.text = opts[which].label
                previewPopup(label, previewPkg)
            }
            .setNegativeButton("Close", null)
            .show()
    }

    /** Keeps the "Show pop-ups from this app" switches of the pop-up cards equal to the saved per-app choice. */
    private fun refreshPopupSwitches() {
        for (app in NotifPrefs.customAlertApps) {
            val sw = popSwitches[app.id] ?: continue
            val on = app.packages.all { NotifPrefs.isPkgOn(this, it) }
            if (sw.isChecked != on) {
                // set without writing back
                sw.setOnCheckedChangeListener(null)
                sw.isChecked = on
                sw.setOnCheckedChangeListener { _, v ->
                    NotifPrefs.setPkgsOn(this, app.packages, v)
                    if (shownApps.isNotEmpty()) appsAdapter?.notifyItemRangeChanged(1, shownApps.size)
                }
            }
        }
    }

    private fun refreshOverlayStatus() {
        if (!::overlayText.isInitialized) return
        val ok = NotifPrefs.canOverlay(this)
        overlayText.text =
            if (ok) "On. Pop-ups from other apps appear as a glass card over whatever you are using."
            else "Off. Without this, pop-ups outside the launcher fall back to a plain system toast."
        overlayBtn.visibility = if (ok) View.GONE else View.VISIBLE
    }

    private fun refreshStatus() {
        val on = WhatsAppNotificationListener.isEnabled(this)
        statusText.text =
            if (on) "Access is on. Pop-ups from your apps work even when the launcher is in the background."
            else "Access is off. Turn it on to receive pop-ups from your apps."
        statusBtn.visibility = if (on) View.GONE else View.VISIBLE
    }

    private fun refreshAdminStatus() {
        val on = AppDeviceAdmin.isActive(this)
        adminStatusText.text =
            if (on) "On. Uninstalling now requires turning this off first."
            else "Off. Turn this on to stop the app being uninstalled by accident."
        adminBtn.text = if (on) "Turn off" else "Turn on"
    }
}
