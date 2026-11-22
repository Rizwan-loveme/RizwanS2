package com.srizwan.chooser.picker

import android.Manifest
import android.content.ClipData
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.chooser.R
import com.srizwan.chooser.data.ChooserFileProvider
import com.srizwan.chooser.data.ChooserPrefs
import com.srizwan.chooser.ui.GlassBar
import com.srizwan.chooser.ui.GlassButtons
import com.srizwan.chooser.ui.GlassDrawable
import com.srizwan.chooser.ui.GlassEmptyState
import com.srizwan.chooser.ui.GlassSheet
import com.srizwan.chooser.ui.GlassToast
import com.srizwan.chooser.ui.GlassUi
import com.srizwan.chooser.ui.VectorLabelDrawable
import com.srizwan.chooser.ui.VectorText
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * The own file picker (step 8): a glass screen with the storage roots, folders, a breadcrumb, a list or grid of the files (pictures and
 * videos show a thumbnail), recursive search, sort / hidden-files / "only the kind that was asked for" options, one-file or many-file
 * choosing, and a folder mode. Start it with [FilePicker.intent]; the result is described there.
 *
 *  - Back goes up one folder (then to the storage screen, then closes); while files are ticked it first clears the ticks; while searching it closes the search.
 *  - Single choice: tapping a file returns it. Many files: tapping ticks, the bottom bar's "Select" returns them.
 *  - Reads files with `java.io.File`, so it needs the storage access `:app` already holds. Without it the screen asks for it (an "Allow" button).
 *  - Only this app's own callers may set the start folder or use the folder mode, and only they get plain paths back ([PickerOptions.fromIntent]).
 *    Since step 9 the activity is exported with filters for `GET_CONTENT` / `OPEN_DOCUMENT` / `PICK`, so other apps list it as their file picker.
 *    A foreign caller may tick at most [MAX_FOREIGN] files at once.
 */
class FilePickerActivity : AppCompatActivity() {

    private lateinit var options: PickerOptions
    private var trusted = false

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private var loadJob: Job? = null
    private var searchJob: Job? = null
    private var generation = 0

    /** The folder on screen; null = the storage screen (roots and usual folders). */
    private var currentDir: File? = null
    private var roots: List<PickerEntry> = emptyList()
    private var sort = PickerSort.NAME
    private var showHidden = false
    private var filterOn = false
    private var grid = false
    private var searching = false
    private var showingSearchResults = false
    private var needsPermission = false
    private var navBottom = 0
    private val selected = LinkedHashSet<String>()

    private lateinit var root: FrameLayout
    private lateinit var topArea: LinearLayout
    private lateinit var bar: GlassBar
    private lateinit var crumbScroll: HorizontalScrollView
    private lateinit var crumbRow: LinearLayout
    private lateinit var searchRow: LinearLayout
    private lateinit var searchField: EditText
    private lateinit var recycler: RecyclerView
    private lateinit var layoutManager: GridLayoutManager
    private lateinit var adapter: PickerAdapter
    private lateinit var empty: GlassEmptyState
    private lateinit var bottom: FrameLayout
    private lateinit var bottomText: VectorText
    private lateinit var selectButton: ImageView
    private lateinit var thumbs: PickerThumbs
    private lateinit var viewToggle: ImageView

    private fun dp(v: Float) = GlassUi.dp(this, v)

    // ── lifecycle ────────────────────────────────────────────────────────

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        trusted = callingActivity?.packageName == packageName
        options = PickerOptions.fromIntent(intent, trusted)
        if (options.foldersOnly && !trusted) {
            setResult(RESULT_CANCELED)
            finish()
            return
        }

        sort = try { PickerSort.valueOf(ChooserPrefs.pickerSort(this).orEmpty()) } catch (e: IllegalArgumentException) { PickerSort.NAME }
        showHidden = ChooserPrefs.pickerShowHidden(this)
        grid = ChooserPrefs.pickerGrid(this)
        filterOn = options.mimeTypes.isNotEmpty()
        thumbs = PickerThumbs()

        if (savedInstanceState != null) {
            currentDir = if (savedInstanceState.getBoolean(STATE_HOME)) null else savedInstanceState.getString(STATE_DIR)?.let { File(it) }
            savedInstanceState.getStringArrayList(STATE_SELECTED)?.let { selected.addAll(it) }
            filterOn = savedInstanceState.getBoolean(STATE_FILTER, filterOn)
        } else {
            currentDir = options.startDir?.takeIf { it.isDirectory }
                ?: ChooserPrefs.pickerDir(this)?.let { File(it) }?.takeIf { it.isDirectory }
                ?: PickerRoots.internal()
        }

        edgeToEdge()
        buildUi()
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = goBack()
        })
        updateChrome()
        reload()
    }

    override fun onStart() {
        super.onStart()
        GlassToast.host = this
    }

    override fun onStop() {
        super.onStop()
        if (GlassToast.host === this) GlassToast.host = null
    }

    override fun onResume() {
        super.onResume()
        // back from the "all files access" screen
        if (::adapter.isInitialized && needsPermission && hasAccess()) reload()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
        if (::thumbs.isInitialized) thumbs.shutdown()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_HOME, currentDir == null)
        outState.putString(STATE_DIR, currentDir?.absolutePath)
        outState.putStringArrayList(STATE_SELECTED, ArrayList(selected))
        outState.putBoolean(STATE_FILTER, filterOn)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (::adapter.isInitialized) {
            layoutManager.spanCount = spanCount()
            adapter.notifyDataSetChanged()
            updatePadding()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQ_STORAGE && hasAccess()) reload()
    }

    // ── window and views ─────────────────────────────────────────────────

    private fun edgeToEdge() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= 29) window.isNavigationBarContrastEnforced = false
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
    }

    private fun buildUi() {
        thumbs = if (::thumbs.isInitialized) thumbs else PickerThumbs()

        adapter = PickerAdapter(this, thumbs, onTap = { onEntryTap(it) }, onHold = { onEntryHold(it) })
        adapter.selected = selected
        adapter.setGrid(grid)
        layoutManager = GridLayoutManager(this, spanCount())
        recycler = RecyclerView(this).apply {
            clipToPadding = false
            layoutManager = this@FilePickerActivity.layoutManager
            adapter = this@FilePickerActivity.adapter
            itemAnimator = null
            overScrollMode = View.OVER_SCROLL_NEVER
        }

        // top: bar + breadcrumb (or the search field)
        bar = GlassBar(this).apply {
            setBackVisible(true) { goBack() }
            // Camera button (the Browser's uploads): the caller opens its own camera when it gets RESULT_CAMERA
            if (options.cameraButton && trusted) addAction(R.drawable.ch_ic_camera, R.string.ch_cd_camera) {
                setResult(FilePicker.RESULT_CAMERA)
                finish()
            }
            addAction(R.drawable.ch_ic_search, R.string.ch_cd_search) { openSearch() }
        }
        viewToggle = bar.addAction(
            if (grid) R.drawable.ch_ic_list else R.drawable.ch_ic_grid,
            if (grid) R.string.ch_cd_view_list else R.string.ch_cd_view_grid
        ) { toggleGrid() }
        bar.addAction(R.drawable.ch_ic_sort, R.string.ch_cd_options) { showOptions() }

        crumbRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        crumbScroll = HorizontalScrollView(this).apply {
            isHorizontalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            clipToPadding = false
            setPadding(dp(12f), 0, dp(12f), dp(6f))
            addView(crumbRow, ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }

        searchField = EditText(this).apply {
            background = null
            setTextColor(Color.WHITE)
            setHintTextColor(0x80FFFFFF.toInt())
            hint = getString(R.string.ch_picker_search_hint)
            contentDescription = getString(R.string.ch_cd_search)
            textSize = 16f
            setSingleLine()
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            setPadding(dp(16f), 0, dp(8f), 0)
            setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeyboard()
                    true
                } else false
            }
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (searching) onQueryChanged(s?.toString().orEmpty())
                }
            })
        }
        val fieldPill = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@FilePickerActivity, 24f)
            addView(searchField, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f))
        }
        val closeButton = GlassUi.iconButton(this, R.drawable.ch_ic_close, R.string.ch_cd_close, sizeDp = 44f, glass = true) {
            closeSearch(refresh = true)
        }
        searchRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            visibility = View.GONE
            setPadding(dp(12f), 0, dp(12f), dp(6f))
            addView(fieldPill, LinearLayout.LayoutParams(0, dp(44f), 1f))
            addView(closeButton, LinearLayout.LayoutParams(dp(44f), dp(44f)).apply { marginStart = dp(8f) })
        }

        topArea = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(bar, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(crumbScroll, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(searchRow, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ -> updatePadding() }
        }

        empty = GlassEmptyState(this).apply { visibility = View.GONE }

        // bottom: "n selected" + Select, or the folder name + Use this folder
        bottomText = VectorText(this)
        selectButton = GlassButtons.pill(
            this,
            getString(if (options.foldersOnly) R.string.ch_picker_use_folder else R.string.ch_picker_select),
            primary = true,
            icon = R.drawable.ch_ic_check
        ) { finishPicked() }
        val pill = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@FilePickerActivity, 30f, strong = true)
            setPadding(dp(18f), dp(8f), dp(8f), dp(8f))
            addView(bottomText, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply { marginEnd = dp(8f) })
            addView(selectButton, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
        bottom = FrameLayout(this).apply {
            visibility = View.GONE
            clipToPadding = false
            addView(pill, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            GlassUi.padForInsets(this, 12f, top = false, bottom = true)
            addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ -> updatePadding() }
        }

        root = FrameLayout(this).apply {
            addView(recycler, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
            addView(empty, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER))
            addView(topArea, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP))
            addView(this@FilePickerActivity.bottom, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM))
        }
        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
            navBottom = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()).bottom
            updatePadding()
            insets
        }
        setContentView(root)
    }

    /** The list scrolls under the floating bars: padding = the height of the bars, so the first and last rows can be reached. */
    private fun updatePadding() {
        if (!::recycler.isInitialized) return
        val top = (if (topArea.bottom > 0) topArea.bottom else dp(130f)) + dp(4f)
        val bottomSpace = if (bottom.visibility == View.VISIBLE && bottom.height > 0) bottom.height else navBottom + dp(8f)
        val b = bottomSpace + dp(8f)
        if (recycler.paddingTop != top || recycler.paddingBottom != b) {
            recycler.setPadding(dp(6f), top, dp(6f), b)
        }
    }

    private fun spanCount(): Int {
        val dm = resources.displayMetrics
        val widthDp = dm.widthPixels / dm.density
        return if (grid) (widthDp / 110f).toInt().coerceIn(3, 7) else if (widthDp >= 640f) 2 else 1
    }

    // ── loading ──────────────────────────────────────────────────────────

    private class Loaded(val roots: List<PickerEntry>, val entries: List<PickerEntry>?)

    private fun reload() {
        loadJob?.cancel()
        searchJob?.cancel()
        showingSearchResults = false
        val gen = ++generation
        if (!hasAccess()) {
            showPermission()
            return
        }
        needsPermission = false
        val self = this
        val dir = currentDir
        val filters = options.mimeTypes
        val applyFilters = filterOn
        val foldersOnly = options.foldersOnly
        val hidden = showHidden
        val order = sort
        loadJob = scope.launch {
            val loaded = try {
                withContext(Dispatchers.IO) {
                    val rts = PickerRoots.storages(self)
                    val entries = if (dir == null) {
                        rts + PickerRoots.shortcuts(self)
                    } else {
                        PickerLister.list(dir, filters, applyFilters, foldersOnly, hidden, order)
                    }
                    Loaded(rts, entries)
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Loaded(emptyList(), null)
            }
            if (gen != generation) return@launch
            roots = loaded.roots
            val list = loaded.entries
            if (list == null) {
                showMessage(R.drawable.ch_ic_lock, getString(R.string.ch_picker_unreadable_title), getString(R.string.ch_picker_unreadable_text), null)
            } else {
                showList(list, if (filterOn && options.mimeTypes.isNotEmpty()) Reason.FILTERED else Reason.EMPTY)
            }
            rebuildCrumbs()
            updateChrome()
        }
    }

    private enum class Reason { EMPTY, FILTERED, NO_MATCH }

    private fun showList(list: List<PickerEntry>, reasonIfEmpty: Reason) {
        adapter.selected = selected
        adapter.submit(list)
        recycler.scrollToPosition(0)
        if (list.isNotEmpty()) {
            empty.visibility = View.GONE
            return
        }
        when (reasonIfEmpty) {
            Reason.EMPTY -> showMessage(R.drawable.ch_ic_folder, getString(R.string.ch_picker_empty_title), getString(R.string.ch_picker_empty_text), null)
            Reason.FILTERED -> showMessage(R.drawable.ch_ic_filter, getString(R.string.ch_picker_filtered_title), getString(R.string.ch_picker_filtered_text), null)
            Reason.NO_MATCH -> showMessage(R.drawable.ch_ic_search, getString(R.string.ch_picker_nomatch_title), getString(R.string.ch_picker_nomatch_text), null)
        }
    }

    private fun showMessage(@DrawableRes icon: Int, title: String, text: String, button: Pair<String, () -> Unit>?) {
        adapter.submit(emptyList())
        empty.show(icon, title, text, button?.first, button?.second)
        empty.visibility = View.VISIBLE
    }

    // ── storage access ───────────────────────────────────────────────────

    private fun hasAccess(): Boolean {
        val read = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        return if (Build.VERSION.SDK_INT >= 30) read || Environment.isExternalStorageManager() else read
    }

    private fun showPermission() {
        needsPermission = true
        showMessage(
            R.drawable.ch_ic_lock,
            getString(R.string.ch_picker_perm_title),
            getString(R.string.ch_picker_perm_text),
            getString(R.string.ch_picker_allow) to { requestAccess() }
        )
        rebuildCrumbs()
        updateChrome()
    }

    private fun requestAccess() {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                startActivity(Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:$packageName")))
            } catch (e: Exception) {
                try {
                    startActivity(Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION))
                } catch (e2: Exception) {
                    GlassToast.showOn(this, R.drawable.ch_ic_error)
                }
            }
        } else {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQ_STORAGE)
        }
    }

    // ── navigation ───────────────────────────────────────────────────────

    private fun navigate(dir: File?) {
        if (searching) closeSearch(refresh = false)
        currentDir = dir
        if (dir != null) ChooserPrefs.setPickerDir(this, dir.absolutePath)
        reload()
        rebuildCrumbs()
        updateChrome()
    }

    private fun goBack() {
        val dir = currentDir
        when {
            searching -> closeSearch(refresh = true)
            options.multiple && selected.isNotEmpty() -> clearSelection()
            dir != null -> navigate(parentOrHome(dir))
            else -> {
                setResult(RESULT_CANCELED)
                finish()
            }
        }
    }

    /** The folder above [dir]; null (= the storage screen) at a storage root or when the parent cannot be read. */
    private fun parentOrHome(dir: File): File? {
        val path = dir.absolutePath
        if (roots.any { it.path == path } || path == PickerRoots.internal().absolutePath) return null
        val parent = dir.parentFile ?: return null
        return if (parent.canRead()) parent else null
    }

    private fun rebuildCrumbs() {
        crumbRow.removeAllViews()
        val dir = currentDir
        addCrumb(getString(R.string.ch_picker_home), R.drawable.ch_ic_home, last = dir == null) { navigate(null) }
        if (dir != null) {
            val rootEntry = PickerRoots.rootOf(dir, roots)
            val base = rootEntry?.file ?: File("/")
            val basePath = base.absolutePath.trimEnd('/')
            val parts = dir.absolutePath.removePrefix(basePath).split('/').filter { it.isNotEmpty() }
            if (rootEntry != null || parts.isNotEmpty()) {
                addChevron()
                addCrumb(rootEntry?.name ?: "/", 0, last = parts.isEmpty()) { navigate(base) }
            }
            var acc = base
            parts.forEachIndexed { i, part ->
                acc = File(acc, part)
                val target = acc
                addChevron()
                addCrumb(part, 0, last = i == parts.lastIndex) { navigate(target) }
            }
        }
        crumbScroll.post { crumbScroll.fullScroll(View.FOCUS_RIGHT) }
    }

    private fun addCrumb(label: String, @DrawableRes icon: Int, last: Boolean, onClick: () -> Unit) {
        val v = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@FilePickerActivity, label, icon, textSizeDp = 13f, iconSizeDp = 18f))
            contentDescription = label
            isClickable = true
            isFocusable = true
            setPadding(dp(12f), dp(8f), dp(12f), dp(8f))
            alpha = if (last) 1f else 0.72f
            background = if (last) {
                GradientDrawable().apply {
                    cornerRadius = dp(16f).toFloat()
                    setColor(0x33FFFFFF)
                }
            } else null
            setOnClickListener { if (!last) onClick() }
        }
        crumbRow.addView(v, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    }

    private fun addChevron() {
        val v = ImageView(this).apply {
            setImageResource(R.drawable.ch_ic_chevron)
            alpha = 0.5f
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        crumbRow.addView(v, LinearLayout.LayoutParams(dp(18f), dp(18f)))
    }

    // ── taps and selection ───────────────────────────────────────────────

    private fun onEntryTap(e: PickerEntry) {
        when {
            e.isDir -> navigate(e.file)
            options.foldersOnly -> Unit
            options.multiple -> toggle(e)
            else -> deliver(listOf(e.file))
        }
    }

    private fun onEntryHold(e: PickerEntry) {
        if (e.kind == PickerEntry.Kind.FILE && options.multiple && !options.foldersOnly) toggle(e)
    }

    private fun toggle(e: PickerEntry) {
        if (!selected.remove(e.path)) {
            if (!trusted && selected.size >= MAX_FOREIGN) {
                GlassToast.showOn(this, R.drawable.ch_ic_error)
                return
            }
            selected.add(e.path)
        }
        adapter.changed(e.path)
        updateChrome()
    }

    private fun clearSelection() {
        val old = selected.toList()
        selected.clear()
        old.forEach { adapter.changed(it) }
        updateChrome()
    }

    /** Title, back icon, bottom bar and the Select button follow the state. */
    private fun updateChrome() {
        if (!::bar.isInitialized) return
        val title = when {
            options.multiple && selected.isNotEmpty() -> getString(R.string.ch_picker_selected, selected.size)
            options.title != null -> options.title
            options.foldersOnly -> getString(R.string.ch_picker_title_folder)
            options.multiple -> getString(R.string.ch_picker_title_files)
            else -> getString(R.string.ch_picker_title_file)
        }
        bar.setTitle(title)
        val atHome = currentDir == null && !searching && selected.isEmpty()
        bar.setBackIcon(
            if (atHome) R.drawable.ch_ic_close else R.drawable.ch_ic_back,
            if (atHome) R.string.ch_cd_close else R.string.ch_cd_back
        )

        val showBottom = options.foldersOnly || (options.multiple && selected.isNotEmpty())
        bottom.visibility = if (showBottom) View.VISIBLE else View.GONE
        if (showBottom) {
            val text = if (options.foldersOnly) currentDir?.name?.ifEmpty { "/" }.orEmpty() else getString(R.string.ch_picker_selected, selected.size)
            bottomText.set(text, 15f, Color.WHITE, bold = true)
            GlassButtons.setEnabled(selectButton, !options.foldersOnly || currentDir != null)
            ViewCompat.requestApplyInsets(bottom)
        }
        updatePadding()
    }

    // ── result ───────────────────────────────────────────────────────────

    private fun finishPicked() {
        if (options.foldersOnly) {
            val dir = currentDir ?: return
            val out = Intent().putStringArrayListExtra(FilePicker.EXTRA_RESULT_PATHS, arrayListOf(dir.absolutePath))
            setResult(RESULT_OK, out)
            finish()
            return
        }
        deliver(selected.map { File(it) })
    }

    /** Hands the files back as `content://` uris (own FileProvider) with a read grant; files that vanished are left out. */
    private fun deliver(files: List<File>) {
        val uris = ArrayList<Uri>()
        val paths = ArrayList<String>()
        for (f in files) {
            if (!f.isFile) continue
            try {
                uris.add(ChooserFileProvider.uriFor(this, f))
                paths.add(f.absolutePath)
            } catch (e: Exception) {
                // a path the provider cannot serve: skip it
            }
        }
        if (uris.isEmpty()) {
            GlassToast.showOn(this, R.drawable.ch_ic_error, getString(R.string.ch_picker_toast_gone))
            selected.clear()
            reload()
            updateChrome()
            return
        }
        val clip = ClipData("files", arrayOf("*/*"), ClipData.Item(uris[0]))
        for (i in 1 until uris.size) clip.addItem(ClipData.Item(uris[i]))
        val result = Intent()
        result.data = uris[0]
        result.clipData = clip
        result.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        if (trusted) result.putStringArrayListExtra(FilePicker.EXTRA_RESULT_PATHS, paths)
        setResult(RESULT_OK, result)
        finish()
    }

    // ── view, sort and filter options ────────────────────────────────────

    private fun toggleGrid() {
        grid = !grid
        ChooserPrefs.setPickerGrid(this, grid)
        adapter.setGrid(grid)
        layoutManager.spanCount = spanCount()
        GlassUi.setIcon(
            viewToggle,
            if (grid) R.drawable.ch_ic_list else R.drawable.ch_ic_grid,
            if (grid) R.string.ch_cd_view_list else R.string.ch_cd_view_grid
        )
    }

    private fun showOptions() {
        val rows = ArrayList<GlassSheet.Row>()
        rows.add(GlassSheet.Row(R.drawable.ch_ic_sort, getString(R.string.ch_picker_sort_name), sort == PickerSort.NAME))
        rows.add(GlassSheet.Row(R.drawable.ch_ic_sort, getString(R.string.ch_picker_sort_date), sort == PickerSort.DATE))
        rows.add(GlassSheet.Row(R.drawable.ch_ic_sort, getString(R.string.ch_picker_sort_size), sort == PickerSort.SIZE))
        rows.add(GlassSheet.Row(R.drawable.ch_ic_sort, getString(R.string.ch_picker_sort_type), sort == PickerSort.TYPE))
        rows.add(GlassSheet.Row(R.drawable.ch_ic_file, getString(R.string.ch_picker_show_hidden), showHidden))
        val hasFilter = options.mimeTypes.isNotEmpty() && !options.foldersOnly
        if (hasFilter) rows.add(GlassSheet.Row(R.drawable.ch_ic_filter, getString(R.string.ch_picker_only_matching), filterOn))
        GlassSheet.show(this, rows) { index ->
            when (index) {
                0, 1, 2, 3 -> {
                    sort = PickerSort.values()[index]
                    ChooserPrefs.setPickerSort(this, sort.name)
                }
                4 -> {
                    showHidden = !showHidden
                    ChooserPrefs.setPickerShowHidden(this, showHidden)
                }
                5 -> filterOn = !filterOn
            }
            refreshListing()
        }
    }

    /** Lists again after an option changed: the search is run again when one is open. */
    private fun refreshListing() {
        if (searching && query.isNotBlank()) runSearch(query) else reload()
    }

    // ── search ───────────────────────────────────────────────────────────

    private var query = ""

    private fun openSearch() {
        if (searching) return
        searching = true
        query = ""
        crumbScroll.visibility = View.GONE
        searchRow.visibility = View.VISIBLE
        searchField.setText("")
        searchField.post {
            searchField.requestFocus()
            (getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(searchField, InputMethodManager.SHOW_IMPLICIT)
        }
        updateChrome()
    }

    private fun closeSearch(refresh: Boolean) {
        if (!searching) return
        searching = false
        query = ""
        searchJob?.cancel()
        hideKeyboard()
        searchRow.visibility = View.GONE
        crumbScroll.visibility = View.VISIBLE
        searchField.setText("")
        updateChrome()
        if (refresh) reload()
    }

    private fun hideKeyboard() {
        (getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(searchField.windowToken, 0)
    }

    private fun onQueryChanged(text: String) {
        query = text
        if (text.isBlank()) {
            searchJob?.cancel()
            if (showingSearchResults) reload()
            return
        }
        runSearch(text)
    }

    private fun runSearch(text: String) {
        searchJob?.cancel()
        loadJob?.cancel()
        if (!hasAccess()) return
        val gen = ++generation
        val base = currentDir ?: PickerRoots.internal()
        val filters = options.mimeTypes
        val applyFilters = filterOn
        val foldersOnly = options.foldersOnly
        val hidden = showHidden
        val order = sort
        searchJob = scope.launch {
            delay(250L)
            val hits = try {
                withContext(Dispatchers.IO) {
                    PickerLister.search(base, text, filters, applyFilters, foldersOnly, hidden, order) { !isActive }
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                emptyList()
            }
            if (gen != generation) return@launch
            showingSearchResults = true
            showList(hits, Reason.NO_MATCH)
        }
    }

    companion object {
        private const val STATE_HOME = "picker_home"
        private const val STATE_DIR = "picker_dir"
        private const val STATE_SELECTED = "picker_selected"
        private const val STATE_FILTER = "picker_filter"
        private const val REQ_STORAGE = 7801
        private const val MAX_FOREIGN = 200
    }
}
