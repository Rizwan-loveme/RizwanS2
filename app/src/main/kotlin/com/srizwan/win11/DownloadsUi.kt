package com.srizwan.win11

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.os.Environment
import android.os.StatFs
import android.os.SystemClock
import android.text.TextUtils
import android.view.Gravity
import android.view.MotionEvent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import java.text.DateFormat
import java.util.Date
import java.util.Locale

// =====================================================================
// Downloads screen (1DM style list) – Win11 dark look
// =====================================================================

class DownloadsUi(
    private val ctx: Context,
    private val onBack: () -> Unit,
    private val onOpen: (DlTask) -> Unit,
    private val onShowFolder: () -> Unit,
    private val onCopyLink: (String) -> Unit,
    private val onShare: (DlTask) -> Unit = { }
) {
    private val density = ctx.resources.displayMetrics.density
    private fun dp(v: Int): Int = (v * density).toInt()

    val root: LinearLayout
    private val list: ListView
    private val emptyView: TextView
    private val speedLabel: TextView
    private val storageLabel: TextView
    private val refreshBtn: TextView
    private val titleBar: LinearLayout
    private val selBar: LinearLayout
    private val selCount: TextView
    private val selAllBtn: TextView
    private val searchBar: LinearLayout
    private val searchInput: EditText
    private val sortChip: TextView
    private var query = ""
    private var freeText = ""
    private var freeAt = 0L
    private val chips = ArrayList<TextView>()
    private var filter = 0 // 0 all, 1 downloading, 2 completed
    private val adapter = DlAdapter()
    private val listener: () -> Unit = { refresh() }

    // Step 4: multi-select. Long-press a row to start; tap rows to toggle; Back / X leaves the mode.
    private var selecting = false
    private val selected = LinkedHashSet<Long>()

    init {
        root = LinearLayout(ctx).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
            setBackgroundColor(WX.BG)
            visibility = View.GONE
            isClickable = true // swallow touches so the page underneath is not scrolled
        }

        // ── Title bar ───────────────────────────────────────────
        val bar = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(WX.BAR)
            setPadding(dp(8), dp(8), dp(8), dp(8))
        }
        titleBar = bar
        bar.addView(FrameLayout(ctx).apply {
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Back"
            setOnClickListener { onBack() }
            addView(
                VectorIconView(ctx, VectorIconView.BACK),
                FrameLayout.LayoutParams(dp(22), dp(22), Gravity.CENTER)
            )
        })
        bar.addView(TextView(ctx).apply {
            text = "Downloads"
            setTextColor(WX.TEXT)
            textSize = 18f
            typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
            setPadding(dp(8), 0, 0, 0)
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        })
        speedLabel = TextView(ctx).apply {
            setTextColor(WX.ACCENT)
            textSize = 12f
            setPadding(0, 0, dp(4), 0)
        }
        bar.addView(speedLabel)
        bar.addView(TextView(ctx).apply {
            iconOnly(R.drawable.ic_w_search, 20, WX.TEXT)
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Search downloads"
            setOnClickListener { openSearch() }
        })
        refreshBtn = TextView(ctx).apply {
            iconOnly(R.drawable.ic_w_refresh, 20, WX.TEXT)
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Refresh list from storage"
            setOnClickListener { syncStorage(true) }
        }
        bar.addView(refreshBtn)
        bar.addView(TextView(ctx).apply {
            text = "⋮"
            setTextColor(WX.TEXT)
            textSize = 22f
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Download settings"
            setOnClickListener { showSettings() }
        })
        root.addView(bar)

        // ── Selection bar (replaces the title bar while selecting) ──
        selBar = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(WX.BAR)
            setPadding(dp(8), dp(8), dp(8), dp(8))
            visibility = View.GONE
        }
        selBar.addView(TextView(ctx).apply {
            iconOnly(R.drawable.ic_qs_close, 20, WX.TEXT)
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Exit selection"
            setOnClickListener { exitSelection() }
        })
        selCount = TextView(ctx).apply {
            setTextColor(WX.TEXT)
            textSize = 18f
            typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
            setPadding(dp(8), 0, 0, 0)
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        }
        selBar.addView(selCount)
        selAllBtn = TextView(ctx).apply {
            iconOnly(R.drawable.ic_w_select_all, 22, WX.TEXT)
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Select all"
            setOnClickListener { toggleSelectAll() }
        }
        selBar.addView(selAllBtn)
        selBar.addView(TextView(ctx).apply {
            iconOnly(R.drawable.ic_w_delete, 22, WX.WARN)
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "Delete selected"
            setOnClickListener { confirmDeleteSelected(true) }
        })
        selBar.addView(TextView(ctx).apply {
            text = "⋮"
            setTextColor(WX.TEXT)
            textSize = 22f
            gravity = Gravity.CENTER
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            background = ripple(22)
            isClickable = true
            contentDescription = "More actions"
            setOnClickListener { showSelectionMenu() }
        })
        root.addView(selBar)

        // ── Search bar (Step 5) ─────────────────────────────────
        searchBar = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setBackgroundColor(WX.BAR)
            setPadding(dp(12), dp(6), dp(8), dp(8))
            visibility = View.GONE
        }
        searchInput = EditText(ctx).apply {
            hint = "Search downloads"
            setHintTextColor(WX.DIM)
            setTextColor(WX.TEXT)
            textSize = 15f
            setSingleLine(true)
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            setPadding(dp(12), dp(8), dp(12), dp(8))
            background = GradientDrawable().apply {
                cornerRadius = dp(8).toFloat()
                setColor(WX.CARD)
                setStroke(1, WX.CARD_BORDER)
            }
            layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) { }
                override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) { }
                override fun afterTextChanged(s: Editable?) { query = s?.toString()?.trim().orEmpty(); refresh() }
            })
            setOnEditorActionListener { v, action, _ ->
                if (action == EditorInfo.IME_ACTION_SEARCH) { hideKeyboard(v); true } else false
            }
        }
        searchBar.addView(searchInput)
        searchBar.addView(TextView(ctx).apply {
            iconOnly(R.drawable.ic_qs_close, 18, WX.TEXT)
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(40))
            background = ripple(20)
            isClickable = true
            contentDescription = "Close search"
            setOnClickListener { closeSearch() }
        })
        root.addView(searchBar)

        // ── Filter chips ────────────────────────────────────────
        val chipRow = LinearLayout(ctx).apply {
            orientation = LinearLayout.HORIZONTAL
            setBackgroundColor(WX.BAR)
            setPadding(dp(12), dp(0), dp(12), dp(10))
        }
        listOf("All", "Downloading", "Completed").forEachIndexed { i, label ->
            val chip = TextView(ctx).apply {
                text = label
                textSize = 13f
                gravity = Gravity.CENTER
                setPadding(dp(14), 0, dp(14), 0)
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, dp(32)
                ).apply { rightMargin = dp(8) }
                isClickable = true
                setOnClickListener { if (selecting) exitSelection(); filter = i; refresh() }
            }
            chips.add(chip)
            chipRow.addView(chip)
        }
        chipRow.addView(View(ctx).apply { layoutParams = LinearLayout.LayoutParams(0, 1, 1f) })
        sortChip = TextView(ctx).apply {
            textSize = 13f
            gravity = Gravity.CENTER
            setPadding(dp(14), 0, dp(14), 0)
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(32))
            isClickable = true
            setTextColor(WX.TEXT)
            background = GradientDrawable().apply {
                cornerRadius = dp(16).toFloat()
                setColor(WX.CARD); setStroke(1, WX.CARD_BORDER)
            }
            contentDescription = "Sort downloads"
            setOnClickListener { showSortDialog() }
        }
        chipRow.addView(sortChip)
        root.addView(chipRow)
        storageLabel = TextView(ctx).apply {
            setTextColor(WX.DIM)
            textSize = 11.5f
            setSingleLine(true)
            ellipsize = TextUtils.TruncateAt.END
            setBackgroundColor(WX.BAR)
            setPadding(dp(14), 0, dp(14), dp(8))
        }
        root.addView(storageLabel)
        root.addView(View(ctx).apply {
            setBackgroundColor(WX.CARD_BORDER)
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1)
        })

        // ── List ────────────────────────────────────────────────
        emptyView = TextView(ctx).apply {
            text = "No downloads yet"
            setTextColor(WX.DIM)
            textSize = 14f
            gravity = Gravity.CENTER
            setPadding(0, dp(64), 0, dp(64))
            layoutParams = AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        list = ListView(ctx).apply {
            layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
            divider = null
            dividerHeight = 0
            selector = android.graphics.drawable.ColorDrawable(Color.TRANSPARENT)
            setBackgroundColor(WX.BG)
            clipToPadding = false
            setPadding(0, dp(4), 0, dp(8))
            addFooterView(this@DownloadsUi.emptyView, null, false)
            this.adapter = this@DownloadsUi.adapter
            setOnItemClickListener { parent, _, position, _ ->
                (parent.getItemAtPosition(position) as? DlTask)?.let { t ->
                    if (selecting) { toggleSelected(t.id); return@let }
                    when (t.status) {
                        DlEngine.DONE -> onOpen(t)
                        DlEngine.PAUSED, DlEngine.FAILED -> DlEngine.resume(t.id)
                        DlEngine.RUNNING, DlEngine.QUEUED -> { if (!t.isBlob) DlEngine.pause(t.id) }
                        else -> { }
                    }
                }
            }
            setOnItemLongClickListener { parent, _, position, _ ->
                (parent.getItemAtPosition(position) as? DlTask)?.let { t ->
                    if (!selecting) { selecting = true; selected.add(t.id); updateSelectionUi() }
                    else toggleSelected(t.id)
                }
                true
            }
            // pull down from the top of the list to re-read the storage
            var downY = -1f
            setOnTouchListener { v, ev ->
                val lv = v as ListView
                when (ev.actionMasked) {
                    MotionEvent.ACTION_DOWN -> {
                        val atTop = lv.firstVisiblePosition == 0 &&
                            (lv.childCount == 0 || lv.getChildAt(0).top >= lv.paddingTop)
                        downY = if (atTop) ev.rawY else -1f
                    }
                    MotionEvent.ACTION_UP -> {
                        if (!selecting && downY >= 0f && ev.rawY - downY > dp(96)) syncStorage(true)
                        downY = -1f
                    }
                    MotionEvent.ACTION_CANCEL -> downY = -1f
                }
                false
            }
        }
        root.addView(list)
        updateChips()
    }

    private fun ripple(radiusDp: Int): RippleDrawable {
        val mask = GradientDrawable().apply {
            cornerRadius = dp(radiusDp).toFloat()
            setColor(Color.WHITE)
        }
        return RippleDrawable(ColorStateList.valueOf(WX.RIPPLE), null, mask)
    }

    /** Row background: normal ripple, or ripple over a soft accent tint when the row is selected. */
    private fun rowBackground(selectedRow: Boolean): RippleDrawable {
        val mask = GradientDrawable().apply { cornerRadius = dp(8).toFloat(); setColor(Color.WHITE) }
        val fill = if (selectedRow) GradientDrawable().apply {
            cornerRadius = dp(8).toFloat()
            setColor(Color.argb(0x33, Color.red(WX.ACCENT), Color.green(WX.ACCENT), Color.blue(WX.ACCENT)))
        } else null
        return RippleDrawable(ColorStateList.valueOf(WX.RIPPLE), fill, mask)
    }

    // ── Public ──────────────────────────────────────────────────

    fun onShow() {
        DlEngine.addListener(listener)
        refresh()
        syncStorage(false) // files may have been deleted / renamed since the list was last shown
    }

    fun onHide() {
        DlEngine.removeListener(listener)
        selecting = false
        selected.clear()
        updateSelectionBars()
        if (searchBar.visibility == View.VISIBLE) closeSearch()
    }

    /** Back button: leaves selection mode first. Returns true when it consumed the press. */
    fun handleBack(): Boolean {
        if (selecting) { exitSelection(); return true }
        if (searchBar.visibility == View.VISIBLE) { closeSearch(); return true }
        return false
    }

    private fun updateChips() {
        chips.forEachIndexed { i, c ->
            val on = i == filter
            c.setTextColor(if (on) Color.BLACK else WX.TEXT)
            c.background = GradientDrawable().apply {
                cornerRadius = dp(16).toFloat()
                if (on) setColor(WX.ACCENT) else { setColor(WX.CARD); setStroke(1, WX.CARD_BORDER) }
            }
        }
    }

    private fun refresh() {
        updateChips()
        val all = DlEngine.tasks.toList().sortedByDescending { it.createdAt }
        val byFilter = when (filter) {
            1 -> all.filter { it.status != DlEngine.DONE }
            2 -> all.filter { it.status == DlEngine.DONE }
            else -> all
        }
        val byQuery = if (query.isEmpty()) byFilter else byFilter.filter {
            it.fileName.contains(query, true) || it.url.contains(query, true)
        }
        adapter.data = sorted(byQuery)
        sortChip.text = sortLabel(DlEngine.sortMode)
        emptyView.text = if (query.isNotEmpty() && all.isNotEmpty()) "No downloads match \"$query\"" else "No downloads yet"
        if (selecting) {
            // rows can vanish (storage sync, finished-and-removed ...): drop them from the selection
            val alive = HashSet<Long>()
            for (t in adapter.data) alive.add(t.id)
            selected.retainAll(alive)
            if (selected.isEmpty()) selecting = false
            updateSelectionBars()
        }
        adapter.notifyDataSetChanged()
        emptyView.visibility = if (adapter.data.isEmpty()) View.VISIBLE else View.GONE
        var speed = 0L
        for (t in all) if (t.status == DlEngine.RUNNING) speed += t.speed
        speedLabel.text = if (speed > 0) "${dlFmtSize(speed)}/s" else ""
        updateStorageLabel(all)
    }

    // ── Storage ─────────────────────────────────────────────────

    /** "12 files · 1.4 GB · 23.1 GB free" */
    private fun updateStorageLabel(all: List<DlTask>) {
        val done = all.filter { it.status == DlEngine.DONE }
        val bytes = done.sumOf { if (it.total > 0) it.total else it.downloaded.get() }
        val now = SystemClock.elapsedRealtime()
        if (freeText.isEmpty() || now - freeAt > 5000) { // StatFs is cheap, but this runs on every list update
            freeAt = now
            freeText = try {
                dlFmtSize(StatFs(Environment.getExternalStorageDirectory().path).availableBytes) + " free"
            } catch (e: Exception) { "" }
        }
        val files = if (done.size == 1) "1 file" else "${done.size} files"
        storageLabel.text = listOf(files, dlFmtSize(bytes), freeText).filter { it.isNotEmpty() }.joinToString("  ·  ")
    }

    /** Re-reads the storage: finished downloads whose file is gone leave the list, renamed ones get the new name. */
    private fun syncStorage(manual: Boolean) {
        if (manual) refreshBtn.animate().rotationBy(360f).setDuration(600).start()
        DlEngine.refreshFromStorage { removed, updated ->
            freeAt = 0L // free space may have changed too
            refresh()
            when {
                removed > 0 -> Toast.makeText(
                    ctx, if (removed == 1) "1 file is no longer in storage: removed from the list"
                    else "$removed files are no longer in storage: removed from the list", Toast.LENGTH_SHORT
                ).show()
                manual && updated > 0 -> Toast.makeText(ctx, "List updated", Toast.LENGTH_SHORT).show()
                manual -> Toast.makeText(ctx, "List is up to date", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // ── Selection (Step 4) ──────────────────────────────────────

    private fun updateSelectionBars() {
        titleBar.visibility = if (selecting) View.GONE else View.VISIBLE
        selBar.visibility = if (selecting) View.VISIBLE else View.GONE
        if (selecting) {
            selCount.text = if (selected.size == 1) "1 selected" else "${selected.size} selected"
            val all = adapter.data.isNotEmpty() && adapter.data.all { it.id in selected }
            selAllBtn.iconOnly(R.drawable.ic_w_select_all, 22, if (all) WX.ACCENT else WX.TEXT)
            selAllBtn.contentDescription = if (all) "Deselect all" else "Select all"
        }
    }

    private fun updateSelectionUi() {
        updateSelectionBars()
        adapter.notifyDataSetChanged()
    }

    private fun exitSelection() {
        selecting = false
        selected.clear()
        updateSelectionUi()
    }

    private fun toggleSelected(id: Long) {
        if (!selected.remove(id)) selected.add(id)
        if (selected.isEmpty()) exitSelection() else updateSelectionUi()
    }

    /** Select all rows of the current filter; when all are already selected this clears the selection. */
    private fun toggleSelectAll() {
        val visible = adapter.data
        if (visible.isEmpty()) return
        if (visible.all { it.id in selected }) { exitSelection(); return }
        for (t in visible) selected.add(t.id)
        updateSelectionUi()
    }

    private fun invertSelection() {
        val next = LinkedHashSet<Long>()
        for (t in adapter.data) if (t.id !in selected) next.add(t.id)
        selected.clear(); selected.addAll(next)
        if (selected.isEmpty()) exitSelection() else updateSelectionUi()
    }

    private fun showSelectionMenu() {
        val opts = ArrayList<Pair<String, () -> Unit>>()
        opts.add("Select all" to { if (!adapter.data.all { it.id in selected }) toggleSelectAll() })
        opts.add("Invert selection" to { invertSelection() })
        opts.add("Remove from list" to { confirmDeleteSelected(false) })
        if (selected.size == 1) DlEngine.find(selected.first())?.let { t ->
            opts.add("This item…" to { showMenu(t) })
        }
        W11Dialog.Builder(ctx).setTitle(if (selected.size == 1) "1 selected" else "${selected.size} selected")
            .setItems(opts.map { it.first }.toTypedArray()) { _, which -> opts[which].second() }
            .setNegativeButton("Close", null).show()
    }

    /** Batch delete / remove: always asks first, then saves the list once ([DlEngine.deleteMany]). */
    private fun confirmDeleteSelected(deleteFiles: Boolean) {
        val ids = selected.toList()
        if (ids.isEmpty()) return
        val tasks = ids.mapNotNull { DlEngine.find(it) }
        val finished = tasks.count { it.status == DlEngine.DONE }
        val active = tasks.size - finished
        val n = tasks.size
        val items = if (n == 1) "1 item" else "$n items"
        val msg = StringBuilder()
        if (deleteFiles) {
            msg.append("Delete $items from the list")
            if (finished > 0) msg.append(" and delete ${if (finished == 1) "its file" else "$finished files"} from the phone")
            msg.append("?")
            if (active > 0) msg.append("\n\n$active unfinished download${if (active == 1) "" else "s"} will be stopped and its partial data removed.")
        } else {
            msg.append("Remove $items from the list?")
            if (finished > 0) msg.append("\n\nFinished files stay on the phone.")
            if (active > 0) msg.append("\n\n$active unfinished download${if (active == 1) "" else "s"} will be stopped.")
        }
        W11Dialog.confirm(ctx, if (deleteFiles) "Delete" else "Remove from list", msg.toString(), "Yes") {
            DlEngine.deleteMany(ids, deleteFiles) { removed ->
                freeAt = 0L
                Toast.makeText(
                    ctx, if (deleteFiles) (if (removed == 1) "1 item deleted" else "$removed items deleted")
                    else (if (removed == 1) "1 item removed" else "$removed items removed"), Toast.LENGTH_SHORT
                ).show()
                refresh()
            }
            exitSelection()
        }
    }

    // ── Search & sort (Step 5) ──────────────────────────────────

    private fun sizeOf(t: DlTask): Long = if (t.total > 0) t.total else t.downloaded.get()

    private fun sorted(list: List<DlTask>): List<DlTask> = when (DlEngine.sortMode) {
        DlEngine.SORT_OLDEST -> list.sortedBy { it.createdAt }
        DlEngine.SORT_NAME_AZ -> list.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.fileName })
        DlEngine.SORT_NAME_ZA -> list.sortedWith(compareBy<DlTask, String>(String.CASE_INSENSITIVE_ORDER) { it.fileName }.reversed())
        DlEngine.SORT_SIZE_DESC -> list.sortedByDescending { sizeOf(it) }
        DlEngine.SORT_SIZE_ASC -> list.sortedBy { sizeOf(it) }
        else -> list.sortedByDescending { it.createdAt }
    }

    private fun sortLabel(mode: Int): String = when (mode) {
        DlEngine.SORT_OLDEST -> "Oldest"
        DlEngine.SORT_NAME_AZ -> "Name A–Z"
        DlEngine.SORT_NAME_ZA -> "Name Z–A"
        DlEngine.SORT_SIZE_DESC -> "Largest"
        DlEngine.SORT_SIZE_ASC -> "Smallest"
        else -> "Newest"
    }

    private fun showSortDialog() {
        val modes = intArrayOf(
            DlEngine.SORT_NEWEST, DlEngine.SORT_OLDEST, DlEngine.SORT_NAME_AZ,
            DlEngine.SORT_NAME_ZA, DlEngine.SORT_SIZE_DESC, DlEngine.SORT_SIZE_ASC
        )
        val labels = arrayOf("Date: newest first", "Date: oldest first", "Name: A to Z", "Name: Z to A", "Size: largest first", "Size: smallest first")
        W11Dialog.Builder(ctx).setTitle("Sort by")
            .setSingleChoiceItems(labels, modes.indexOf(DlEngine.sortMode).coerceAtLeast(0)) { d, i ->
                DlEngine.sortMode = modes[i]
                d.dismiss()
                refresh()
            }.setNegativeButton("Cancel", null).show()
    }

    private fun openSearch() {
        searchBar.visibility = View.VISIBLE
        searchInput.requestFocus()
        try {
            (ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(searchInput, InputMethodManager.SHOW_IMPLICIT)
        } catch (e: Exception) { }
    }

    private fun hideKeyboard(v: View) {
        try { (ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(v.windowToken, 0) }
        catch (e: Exception) { }
    }

    private fun closeSearch() {
        hideKeyboard(searchInput)
        searchBar.visibility = View.GONE
        if (searchInput.text.isNotEmpty()) searchInput.setText("") // the text watcher clears [query] and refreshes
        else if (query.isNotEmpty()) { query = ""; refresh() }
    }

    // ── Rename / info (Step 5) ──────────────────────────────────

    private fun showRename(t: DlTask) {
        val input = EditText(ctx).apply {
            setText(t.fileName)
            setSingleLine(true)
            textSize = 15f
            post {
                val dot = t.fileName.lastIndexOf('.')
                setSelection(0, if (dot > 0) dot else t.fileName.length) // select the name, keep the extension
            }
        }.glassStyle()
        W11Dialog.Builder(ctx).setTitle("Rename").setView(input)
            .setPositiveButton("OK") { _, _ ->
                DlEngine.rename(t.id, input.text.toString()) { ok, info ->
                    Toast.makeText(ctx, if (ok) "Renamed to $info" else info, Toast.LENGTH_SHORT).show()
                    refresh()
                }
            }.setNegativeButton("Cancel", null).show()
    }

    private fun showInfo(t: DlTask) {
        val df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT)
        val size = if (t.total > 0) dlFmtSize(t.total) else dlFmtSize(t.downloaded.get())
        val sb = StringBuilder()
        sb.append("Name: ").append(t.fileName).append('\n')
        sb.append("Size: ").append(size)
        if (t.total > 0 && t.status != DlEngine.DONE) sb.append("  (").append(dlFmtSize(t.downloaded.get())).append(" done)")
        sb.append('\n')
        sb.append("Type: ").append(t.mime.ifBlank { DlEngine.guessMime(t.fileName) }).append('\n')
        sb.append("Added: ").append(df.format(Date(t.createdAt))).append('\n')
        sb.append("Status: ").append(statusText(t))
        if (t.savedPath.isNotEmpty()) sb.append('\n').append("Location: ").append(t.savedPath)
        if (t.url.isNotEmpty()) sb.append('\n').append("Link: ").append(t.url)
        val b = W11Dialog.Builder(ctx).setTitle("File info").setMessage(sb.toString())
        if (t.url.isNotEmpty()) b.setPositiveButton("Copy link") { _, _ -> onCopyLink(t.url) }
        b.setNegativeButton("Close", null).show()
    }

    // ── Menus ───────────────────────────────────────────────────

    private fun showMenu(t: DlTask) {
        val opts = ArrayList<Pair<String, () -> Unit>>()
        when (t.status) {
            DlEngine.DONE -> {
                opts.add("Open" to { onOpen(t) })
                opts.add("Rename" to { showRename(t) })
                opts.add("Share" to { onShare(t) })
                opts.add("File info" to { showInfo(t) })
                opts.add("Show in Downloads folder" to { onShowFolder() })
                if (!t.isBlob && t.url.isNotEmpty()) opts.add("Re-download" to {
                    if (DlEngine.redownload(t.id) != null) Toast.makeText(ctx, "Download started again", Toast.LENGTH_SHORT).show()
                })
                opts.add("Delete file" to { DlEngine.deleteFinishedFile(t.id) })
                opts.add("Remove from list" to { confirmStop(t, "Remove from list") })
            }
            DlEngine.RUNNING, DlEngine.QUEUED -> {
                if (!t.isBlob) opts.add("Pause" to { DlEngine.pause(t.id) })
                opts.add("File info" to { showInfo(t) })
                opts.add("Cancel and delete" to { confirmStop(t, "Cancel and delete") })
            }
            DlEngine.PAUSED -> {
                opts.add("Resume" to { DlEngine.resume(t.id) })
                opts.add("File info" to { showInfo(t) })
                opts.add("Cancel and delete" to { confirmStop(t, "Cancel and delete") })
            }
            DlEngine.FAILED -> {
                if (!t.isBlob) opts.add("Retry" to { DlEngine.resume(t.id) })
                opts.add("File info" to { showInfo(t) })
                opts.add("Remove from list" to { confirmStop(t, "Remove from list") })
            }
            else -> opts.add("Remove from list" to { confirmStop(t, "Remove from list") })
        }
        if (t.url.isNotEmpty()) opts.add("Copy link" to { onCopyLink(t.url) })
        W11Dialog.Builder(ctx).setTitle(t.fileName)
            .setItems(opts.map { it.first }.toTypedArray()) { _, which -> opts[which].second() }
            .setNegativeButton("Close", null).show()
    }

    /** A download is only stopped / removed after the user confirms. */
    private fun confirmStop(t: DlTask, action: String) {
        val msg = if (action.startsWith("Remove")) "Remove ${t.fileName} from the list?"
                  else "${t.fileName}\n\nThis stops the download. Continue?"
        W11Dialog.confirm(ctx, action, msg, "Yes") {
            DlEngine.cancel(t.id)
        }
    }

    private fun showSettings() {
        val items = arrayOf(
            "Connections per download: ${DlEngine.connections}",
            "Simultaneous downloads: ${DlEngine.maxParallel}",
            "Clear finished and failed"
        )
        W11Dialog.Builder(ctx).setTitle("Download settings")
            .setItems(items) { _, which ->
                when (which) {
                    0 -> {
                        val v = intArrayOf(1, 2, 4, 6, 8)
                        W11Dialog.Builder(ctx).setTitle("Connections per download")
                            .setSingleChoiceItems(
                                v.map { it.toString() }.toTypedArray(),
                                v.indexOf(DlEngine.connections).coerceAtLeast(0)
                            ) { d, i -> DlEngine.connections = v[i]; d.dismiss() }
                            .setNegativeButton("Cancel", null).show()
                    }
                    1 -> {
                        val v = intArrayOf(1, 2, 3, 4, 5)
                        W11Dialog.Builder(ctx).setTitle("Simultaneous downloads")
                            .setSingleChoiceItems(
                                v.map { it.toString() }.toTypedArray(),
                                v.indexOf(DlEngine.maxParallel).coerceAtLeast(0)
                            ) { d, i -> DlEngine.maxParallel = v[i]; d.dismiss() }
                            .setNegativeButton("Cancel", null).show()
                    }
                    2 -> DlEngine.clearFinished()
                }
            }.setNegativeButton("Close", null).show()
    }

    // ── Row ─────────────────────────────────────────────────────

    private fun statusText(t: DlTask): String {
        val done = t.downloaded.get()
        val sizeText = if (t.total > 0) "${dlFmtSize(done)} of ${dlFmtSize(t.total)}" else dlFmtSize(done)
        return when (t.status) {
            DlEngine.RUNNING -> {
                val sb = StringBuilder(sizeText)
                if (t.speed > 0) sb.append("  •  ${dlFmtSize(t.speed)}/s")
                val eta = t.etaSeconds()
                if (eta >= 0) sb.append("  •  ${dlFmtEta(eta)} left")
                if (t.connectionCount > 1) sb.append("  •  ${t.connectionCount} conn")
                sb.toString()
            }
            DlEngine.QUEUED -> "Queued"
            DlEngine.PAUSED -> "Paused  •  $sizeText"
            DlEngine.SAVING -> "Saving to Downloads…"
            DlEngine.DONE -> (if (t.total > 0) dlFmtSize(t.total) else dlFmtSize(done)) + "  •  Completed"
            DlEngine.FAILED -> "Failed: ${t.error.ifBlank { "unknown error" }}"
            else -> ""
        }
    }

    private inner class Row : LinearLayout(ctx) {
        val check = ImageView(ctx)
        val icon = FileIconView(ctx)
        val name = TextView(ctx)
        val bar = UsageBar(ctx)
        val status = TextView(ctx)
        val action = TextView(ctx)
        val cancel = TextView(ctx)

        init {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            minimumHeight = dp(72)
            setPadding(dp(16), dp(8), dp(4), dp(8))
            layoutParams = AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            background = ripple(8)

            check.visibility = View.GONE
            addView(check, LinearLayout.LayoutParams(dp(22), dp(22)).apply { rightMargin = dp(12) })
            addView(icon, LinearLayout.LayoutParams(dp(38), dp(38)))

            val col = LinearLayout(ctx).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
                    .apply { leftMargin = dp(14); rightMargin = dp(4) }
            }
            name.apply {
                setTextColor(WX.TEXT)
                textSize = 15f
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.MIDDLE
            }
            bar.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(4)
            ).apply { topMargin = dp(6) }
            status.apply {
                setTextColor(WX.DIM)
                textSize = 12f
                setSingleLine(true)
                ellipsize = TextUtils.TruncateAt.END
                setPadding(0, dp(5), 0, 0)
            }
            col.addView(name)
            col.addView(bar)
            col.addView(status)
            addView(col)

            action.apply {
                textSize = 18f
                gravity = Gravity.CENTER
                setTextColor(WX.TEXT)
                layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
                background = ripple(22)
                isClickable = true
                isFocusable = false
            }
            cancel.apply {
                iconOnly(R.drawable.ic_qs_close, 16, WX.DIM)
                textSize = 16f
                gravity = Gravity.CENTER
                setTextColor(WX.DIM)
                layoutParams = LinearLayout.LayoutParams(dp(40), dp(44))
                background = ripple(20)
                isClickable = true
                isFocusable = false
            }
            addView(action)
            addView(cancel)
        }

        fun bind(t: DlTask) {
            val ext = t.fileName.substringAfterLast('.', "").lowercase(Locale.ROOT)
            icon.setFile(fileTypeColor(ext), ext.uppercase(Locale.ROOT).take(4), false)
            val isSel = selecting && t.id in selected
            background = rowBackground(isSel)
            if (selecting) {
                check.visibility = View.VISIBLE
                check.background = GradientDrawable().apply {
                    cornerRadius = dp(5).toFloat()
                    if (isSel) setColor(WX.ACCENT) else { setColor(Color.TRANSPARENT); setStroke(dp(2), WX.DIM) }
                }
                check.setPadding(dp(3), dp(3), dp(3), dp(3))
                check.setImageDrawable(if (isSel) Ico.drawable(ctx, R.drawable.ic_w_check, 16, Color.BLACK) else null)
            } else {
                check.visibility = View.GONE
            }
            name.text = t.fileName
            status.text = statusText(t)
            status.setTextColor(if (t.status == DlEngine.FAILED) WX.WARN else WX.DIM)

            val showBar = t.status != DlEngine.DONE
            bar.visibility = if (showBar) View.VISIBLE else View.GONE
            if (showBar) {
                bar.fraction = if (t.total > 0) t.downloaded.get().toFloat() / t.total.toFloat() else 0f
                bar.fillColor = when (t.status) {
                    DlEngine.FAILED -> WX.WARN
                    DlEngine.PAUSED, DlEngine.QUEUED -> Color.parseColor("#8A8A8A")
                    else -> WX.ACCENT
                }
            }

            when (t.status) {
                DlEngine.RUNNING, DlEngine.QUEUED -> {
                    action.visibility = if (t.isBlob) View.GONE else View.VISIBLE
                    action.iconOnly(R.drawable.ic_w_pause, 18)
                    action.setOnClickListener { DlEngine.pause(t.id) }
                }
                DlEngine.PAUSED -> {
                    action.visibility = View.VISIBLE
                    action.iconOnly(R.drawable.ic_w_play, 18)
                    action.setOnClickListener { DlEngine.resume(t.id) }
                }
                DlEngine.FAILED -> {
                    action.visibility = if (t.isBlob) View.GONE else View.VISIBLE
                    action.iconOnly(R.drawable.ic_w_refresh, 18)
                    action.setOnClickListener { DlEngine.resume(t.id) }
                }
                else -> action.visibility = View.GONE
            }
            cancel.visibility = if (t.status == DlEngine.DONE || t.status == DlEngine.SAVING) View.GONE else View.VISIBLE
            cancel.setOnClickListener { confirmStop(t, "Cancel download") }
            if (selecting) { action.visibility = View.GONE; cancel.visibility = View.GONE } // taps select rows, nothing else
        }
    }

    private inner class DlAdapter : BaseAdapter() {
        var data: List<DlTask> = emptyList()
        override fun getCount(): Int = data.size
        override fun getItem(position: Int): DlTask = data[position]
        override fun getItemId(position: Int): Long = data[position].id
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val row = (convertView as? Row) ?: Row()
            row.bind(data[position])
            return row
        }
    }
}
