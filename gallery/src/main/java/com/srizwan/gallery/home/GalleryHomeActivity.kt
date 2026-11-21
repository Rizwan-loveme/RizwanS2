package com.srizwan.gallery.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.provider.Settings
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryAlbum
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.data.GalleryPermission
import com.srizwan.gallery.data.GalleryPrefs
import com.srizwan.gallery.data.GalleryRepository
import com.srizwan.gallery.ui.GlassBar
import com.srizwan.gallery.ui.GlassDrawable
import com.srizwan.gallery.ui.GlassEmptyState
import com.srizwan.gallery.ui.GlassShimmerView
import com.srizwan.gallery.ui.GlassSheet
import com.srizwan.gallery.ui.GlassTabs
import com.srizwan.gallery.ui.GlassToast
import com.srizwan.gallery.ui.GlassUi
import com.srizwan.gallery.album.GalleryAlbumActivity
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * The built-in Gallery app: the glass home screen (step 5).
 *
 *  - Glass top bar: title, a search button and the view-mode menu (group by date, 2 to 5 columns, refresh).
 *  - Tabs **Photos** (square thumbnails grouped under date headers; pinch to change the columns, 2 to 5) and
 *    **Albums** (one card per folder: cover thumbnail, name, picture count).
 *  - While the pictures load a shimmer skeleton is shown; a glass card says "no photos", "no matches" or
 *    "permission needed" (with a button that asks for it / opens the app settings).
 *  - Search (name and folder) filters both tabs; the lists run under the floating glass bars (edge to edge).
 *  - The view menu is the settings sheet (step 12): group by date, favorites only, 2 to 5 columns, slideshow interval, "All files
 *    access" (Android 11+, only while not allowed) and refresh; every choice is saved in [GalleryPrefs].
 *  - Long-press a picture to select (step 9): see [SelectionController] (drag range, select all, share, delete).
 *
 * Loading and filtering run on background threads ([GalleryRepository.load], `Dispatchers.Default`); thumbnails come
 * from [com.srizwan.gallery.loader.ImageLoader]. Tapping a picture opens the viewer (step 7); tapping an
 * album opens the album screen ([GalleryAlbumActivity], step 6).
 */
class GalleryHomeActivity : AppCompatActivity() {

    private enum class State { LOADING, PERMISSION, EMPTY, CONTENT }

    private class BuildResult(
        val images: List<GalleryImage>,
        val items: List<PhotoItem>,
        val albums: List<GalleryAlbum>
    )

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var loadJob: Job? = null
    private var buildJob: Job? = null
    private var searchJob: Job? = null

    private lateinit var root: FrameLayout
    private lateinit var topArea: LinearLayout
    private lateinit var scrim: View
    private lateinit var bar: GlassBar
    private lateinit var searchWrap: FrameLayout
    private lateinit var searchField: EditText
    private lateinit var searchClear: ImageView
    private lateinit var tabs: GlassTabs
    private lateinit var photosList: RecyclerView
    private lateinit var albumsList: RecyclerView
    private lateinit var shimmer: GlassShimmerView
    private lateinit var empty: GlassEmptyState
    private lateinit var photosLayout: GridLayoutManager
    private lateinit var albumsLayout: GridLayoutManager
    private lateinit var photosAdapter: PhotosAdapter
    private lateinit var albumsAdapter: AlbumsAdapter
    private lateinit var searchBack: OnBackPressedCallback
    private lateinit var selectionBack: OnBackPressedCallback
    private lateinit var selection: SelectionController

    private var all: List<GalleryImage> = emptyList()
    private var query = ""
    private var columns = GalleryPrefs.DEFAULT_COLUMNS
    private var groupByDate = true
    private var favoritesOnly = false
    private var tab = GalleryPrefs.TAB_PHOTOS
    private var loading = true
    private var searchOpen = false
    private var lastLoadAt = 0L
    private var permissionAsked = false

    /** "All files access" as it was at the last load: a change (the user allowed it in the settings) reloads with the folder scan. */
    private var lastAllFiles = false

    private var insetLeft = 0
    private var insetRight = 0
    private var insetBottom = 0
    private var topHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        columns = GalleryPrefs.columns(this)
        groupByDate = GalleryPrefs.groupByDate(this)
        favoritesOnly = GalleryPrefs.favoritesOnly(this)
        tab = GalleryPrefs.lastTab(this)
        lastAllFiles = GalleryPermission.hasAllFilesAccess()
        buildUi()
        setContentView(root)
        setUpWindow()
        render()
        // the process was killed while a search was open: bring the search back (the other settings are in the prefs)
        savedInstanceState?.getString(KEY_QUERY)?.takeIf { it.isNotEmpty() }?.let { saved ->
            openSearch(showKeyboard = false)
            searchField.setText(saved)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (searchOpen) outState.putString(KEY_QUERY, searchField.text?.toString().orEmpty())
    }

    override fun onStart() {
        super.onStart()
        GlassToast.host = this
        refreshIfNeeded()
    }

    override fun onStop() {
        if (GlassToast.host === this) GlassToast.host = null
        super.onStop()
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        albumsLayout.spanCount = albumColumns()
        albumsAdapter.columns = albumColumns()
        albumsAdapter.notifyDataSetChanged()
        ViewCompat.requestApplyInsets(root)
        render()
    }

    // ── window and views ─────────────────────────────────────────────────────

    private fun setUpWindow() = GalleryNav.edgeToEdge(this, root)

    private fun dp(v: Float): Int = GlassUi.dp(this, v)

    private fun buildUi() {
        root = FrameLayout(this).apply { setBackgroundColor(getColor(R.color.gl_bg)) }

        // Photos
        photosAdapter = PhotosAdapter(
            onClick = { index ->
                if (selection.active) selection.toggle(index) else openPhoto(photosAdapter.images, index)
            },
            onLongPress = { index -> onPhotoLongPress(index) }
        )
        selection = SelectionController(
            this, scope, photosAdapter,
            onModeChanged = { active -> onSelectionMode(active) },
            onDeleted = { onPhotosDeleted() }
        )
        photosAdapter.setColumns(columns)
        photosLayout = GridLayoutManager(this, columns)
        val photosLm = photosLayout
        photosLayout.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                if (photosAdapter.isHeader(position)) photosLm.spanCount else 1
        }
        photosList = makeList(photosLayout, photosAdapter) { w -> photosAdapter.updateWidth(w, photosList) }
        photosList.addOnItemTouchListener(
            PinchColumnsListener(
                this, { columns }, { setColumns(it) },
                GalleryPrefs.MIN_COLUMNS, GalleryPrefs.MAX_COLUMNS
            )
        )
        photosList.addOnItemTouchListener(selection.dragListener)

        // Albums
        albumsAdapter = AlbumsAdapter { album -> openAlbum(album) }
        albumsAdapter.columns = albumColumns()
        albumsLayout = GridLayoutManager(this, albumColumns())
        albumsList = makeList(albumsLayout, albumsAdapter) { w -> albumsAdapter.viewWidthPx = w }

        shimmer = GlassShimmerView(this).apply { visibility = View.GONE }
        empty = GlassEmptyState(this).apply { visibility = View.GONE }

        root.addView(photosList, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        root.addView(albumsList, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        root.addView(shimmer, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        root.addView(empty, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        // a soft dark fade behind the floating bars so the thumbnails never fight with the icons
        scrim = View(this).apply {
            background = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xE60B0D10.toInt(), 0x000B0D10)
            )
            isClickable = false
        }
        root.addView(scrim, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(120f), Gravity.TOP))

        // Top area: bar, search row, tabs
        bar = GlassBar(this).apply {
            setTitle(getString(R.string.gl_title))
            setBackVisible(false)
            addAction(R.drawable.gl_ic_search, R.string.gl_cd_search) { toggleSearch() }
            addAction(R.drawable.gl_ic_grid, R.string.gl_cd_grid) { showViewMenu() }
        }
        searchWrap = buildSearchRow().apply { visibility = View.GONE }
        tabs = GlassTabs(this).apply {
            setTabs(
                listOf(getString(R.string.gl_cd_photos), getString(R.string.gl_cd_albums)),
                tab
            ) { index -> setTab(index) }
        }
        val tabsRow = FrameLayout(this).apply {
            setPadding(0, dp(2f), 0, dp(8f))
            addView(
                tabs,
                FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL
                )
            )
        }
        topArea = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(bar, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(searchWrap, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(tabsRow, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addOnLayoutChangeListener { _, _, top, _, bottom, _, _, _, _ ->
                val h = bottom - top
                if (h != topHeight) {
                    topHeight = h
                    root.post { applyPadding() }
                }
            }
        }
        root.addView(topArea, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP))
        // the glass selection bar (step 9) floats over the top bar while pictures are picked
        root.addView(selection.bar, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP))

        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            insetLeft = b.left
            insetRight = b.right
            insetBottom = b.bottom
            applyPadding()
            insets
        }

        searchBack = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                closeSearch()
            }
        }
        onBackPressedDispatcher.addCallback(this, searchBack)

        // added last: Back first leaves the selection, then closes the search, then the screen
        selectionBack = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                selection.clear()
            }
        }
        onBackPressedDispatcher.addCallback(this, selectionBack)
    }

    private fun makeList(lm: GridLayoutManager, adapter: RecyclerView.Adapter<*>, onWidth: (Int) -> Unit): RecyclerView =
        RecyclerView(this).apply {
            layoutManager = lm
            this.adapter = adapter
            clipToPadding = false
            setHasFixedSize(true)
            itemAnimator = null
            setItemViewCacheSize(16)
            visibility = View.GONE
            addOnLayoutChangeListener { v, _, _, _, _, _, _, _, _ ->
                onWidth(v.width - v.paddingLeft - v.paddingRight)
            }
        }

    private fun buildSearchRow(): FrameLayout {
        val pill = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@GalleryHomeActivity, 24f)
        }
        val icon = ImageView(this).apply {
            setImageResource(R.drawable.gl_ic_search)
            alpha = 0.8f
            setPadding(dp(8f), dp(8f), dp(8f), dp(8f))
        }
        searchField = EditText(this).apply {
            background = null
            setTextColor(Color.WHITE)
            setHintTextColor(0x80FFFFFF.toInt())
            hint = getString(R.string.gl_search_hint)
            contentDescription = getString(R.string.gl_cd_search)
            textSize = 16f
            setSingleLine()
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            setPadding(0, 0, 0, 0)
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
                    onSearchTextChanged(s?.toString().orEmpty())
                }
            })
        }
        searchClear = GlassUi.iconButton(this, R.drawable.gl_ic_close, R.string.gl_cd_close, sizeDp = 40f) {
            searchField.setText("")
        }.apply { visibility = View.INVISIBLE }
        pill.addView(icon, LinearLayout.LayoutParams(dp(40f), dp(40f)))
        pill.addView(searchField, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f))
        pill.addView(searchClear)
        return FrameLayout(this).apply {
            setPadding(dp(12f), dp(2f), dp(12f), dp(2f))
            addView(pill, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(48f)))
        }
    }

    /** The lists run under the floating bars: top padding = height of the bars, bottom = navigation bar. */
    private fun applyPadding() {
        val top = topHeight
        val bottom = insetBottom + dp(12f)
        photosList.setPadding(insetLeft, top, insetRight, bottom)
        albumsList.setPadding(insetLeft, top, insetRight, bottom)
        empty.setPadding(insetLeft, top, insetRight, insetBottom)
        (shimmer.layoutParams as FrameLayout.LayoutParams).let { lp ->
            if (lp.topMargin != top) {
                lp.topMargin = top
                shimmer.layoutParams = lp
            }
        }
        (scrim.layoutParams as FrameLayout.LayoutParams).let { lp ->
            val h = top + dp(16f)
            if (lp.height != h) {
                lp.height = h
                scrim.layoutParams = lp
            }
        }
        searchWrap.setPadding(dp(12f) + insetLeft, dp(2f), dp(12f) + insetRight, dp(2f))
    }

    /** 2 columns on a phone, more on wide screens. */
    private fun albumColumns(): Int = (resources.configuration.screenWidthDp / 170).coerceIn(2, 5)

    // ── loading and filtering ────────────────────────────────────────────────

    /** Loads (or reloads) the pictures when the screen comes to the front. */
    private fun refreshIfNeeded() {
        if (!GalleryPermission.has(this)) {
            if (all.isNotEmpty()) {
                all = emptyList()
                rebuild()
            } else {
                loading = false
                render()
            }
            if (!permissionAsked) requestPermission()
            return
        }
        if (loadJob?.isActive == true) return
        when {
            lastLoadAt == 0L || GalleryRepository.cached() == null -> reload(force = false)
            GalleryPermission.hasAllFilesAccess() != lastAllFiles -> reload(force = true) // allowed / taken away in the settings
            GalleryRepository.cached() !== all -> reload(force = false) // the viewer deleted / renamed a picture (step 8)
            SystemClock.elapsedRealtime() - lastLoadAt > STALE_MS -> reload(force = true) // new photos taken meanwhile
        }
        // hearts may have been changed in the viewer meanwhile
        if (favoritesOnly && loadJob?.isActive != true && all.isNotEmpty()) rebuild()
    }

    private fun reload(force: Boolean) {
        loadJob?.cancel()
        lastAllFiles = GalleryPermission.hasAllFilesAccess()
        if (all.isEmpty()) {
            loading = true
            render()
        }
        loadJob = scope.launch {
            val list = try {
                GalleryRepository.load(applicationContext, forceRefresh = force)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.w(TAG, "load failed", e)
                emptyList()
            }
            lastLoadAt = SystemClock.elapsedRealtime()
            if (list.isNotEmpty()) { // forget the hearts of pictures another app deleted
                val app = applicationContext
                withContext(Dispatchers.IO) { GalleryPrefs.pruneFavorites(app) }
            }
            if (list === all) { // nothing new (the shared in-memory list)
                loading = false
                render()
                return@launch
            }
            all = list
            rebuild()
        }
    }

    /** Filters, groups and builds the album list on a background thread, then shows the result. */
    private fun rebuild(resetScroll: Boolean = false) {
        buildJob?.cancel()
        val source = all
        val q = query
        val grouped = groupByDate
        val favOnly = favoritesOnly
        val app = applicationContext
        buildJob = scope.launch {
            val result = withContext(Dispatchers.Default) {
                val found = GalleryRepository.search(source, q)
                val filtered = if (favOnly) {
                    val hearts = GalleryPrefs.favorites(app)
                    found.filter { it.path in hearts }
                } else found
                BuildResult(filtered, GalleryNav.buildItems(filtered, grouped), GalleryRepository.albums(filtered))
            }
            photosAdapter.submit(result.items, result.images)
            albumsAdapter.submit(result.albums)
            selection.onListChanged()
            if (resetScroll) {
                photosList.scrollToPosition(0)
                albumsList.scrollToPosition(0)
            }
            loading = false
            render()
        }
    }

    // ── what is on screen ────────────────────────────────────────────────────

    private fun render() {
        val state = when {
            !GalleryPermission.has(this) -> State.PERMISSION
            loading -> State.LOADING
            photosAdapter.images.isEmpty() -> State.EMPTY
            else -> State.CONTENT
        }
        if (state == State.LOADING) {
            shimmer.configure(
                if (tab == GalleryPrefs.TAB_ALBUMS) GlassShimmerView.Style.ALBUMS else GlassShimmerView.Style.PHOTOS,
                if (tab == GalleryPrefs.TAB_ALBUMS) albumColumns() else columns
            )
        }
        shimmer.visibility = if (state == State.LOADING) View.VISIBLE else View.GONE
        when (state) {
            State.PERMISSION -> {
                val settings = needsSettings()
                empty.show(
                    R.drawable.gl_ic_lock,
                    getString(R.string.gl_perm_title),
                    getString(R.string.gl_perm_text),
                    getString(if (settings) R.string.gl_open_settings else R.string.gl_allow)
                ) { if (needsSettings()) openAppSettings() else requestPermission() }
            }
            State.EMPTY -> {
                if (query.isNotBlank()) {
                    empty.show(R.drawable.gl_ic_search, getString(R.string.gl_no_match_title), getString(R.string.gl_no_match_text))
                } else if (favoritesOnly) {
                    empty.show(
                        R.drawable.gl_ic_favorite_outline,
                        getString(R.string.gl_no_fav_title),
                        getString(R.string.gl_no_fav_text),
                        getString(R.string.gl_show_all)
                    ) { setFavoritesOnly(false) }
                } else {
                    empty.show(
                        R.drawable.gl_ic_photo_library,
                        getString(R.string.gl_empty_title),
                        getString(R.string.gl_empty_text),
                        getString(R.string.gl_menu_refresh)
                    ) { reload(force = true) }
                }
            }
            else -> {}
        }
        empty.visibility = if (state == State.PERMISSION || state == State.EMPTY) View.VISIBLE else View.GONE
        val content = state == State.CONTENT
        photosList.visibility = if (content && tab == GalleryPrefs.TAB_PHOTOS) View.VISIBLE else View.GONE
        albumsList.visibility = if (content && tab == GalleryPrefs.TAB_ALBUMS) View.VISIBLE else View.GONE
    }

    private fun setTab(index: Int) {
        if (index == tab) return
        tab = index
        GalleryPrefs.setLastTab(this, index)
        render()
        val shown = if (index == GalleryPrefs.TAB_PHOTOS) photosList else albumsList
        if (shown.visibility == View.VISIBLE) {
            shown.alpha = 0f
            shown.animate().alpha(1f).setDuration(160L).start()
        }
    }

    private fun setColumns(value: Int) {
        val c = value.coerceIn(GalleryPrefs.MIN_COLUMNS, GalleryPrefs.MAX_COLUMNS)
        if (c == columns) return
        columns = c
        GalleryPrefs.setColumns(this, c)
        val first = photosLayout.findFirstVisibleItemPosition()
        photosLayout.spanCount = c
        photosAdapter.setColumns(c)
        if (first >= 0) photosLayout.scrollToPositionWithOffset(first, 0)
        photosList.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK)
        photosList.alpha = 0.5f
        photosList.animate().alpha(1f).setDuration(180L).start()
    }

    // ── actions ──────────────────────────────────────────────────────────────

    /**
     * Opens the viewer on [images][index]. The viewer gets the neighbouring paths (at most 1000, so the intent stays
     * small even for a library of tens of thousands of pictures); step 7 reads the rest from [GalleryRepository.cached].
     */
    private fun openPhoto(images: List<GalleryImage>, index: Int) = GalleryNav.openPhoto(this, images, index)

    // ── multi-select (step 9) ────────────────────────────────────────────────

    /** Long press on a picture: starts selecting (the keyboard of an open search goes away first). */
    private fun onPhotoLongPress(index: Int) {
        if (searchOpen) hideKeyboard()
        selection.onLongPress(index)
    }

    /** The glass selection bar takes the place of the top bar (and of the Photos / Albums tabs) while pictures are picked. */
    private fun onSelectionMode(active: Boolean) {
        selectionBack.isEnabled = active
        topArea.visibility = if (active) View.INVISIBLE else View.VISIBLE
    }

    /** Pictures were deleted in the selection mode: show the shared list without them. */
    private fun onPhotosDeleted() {
        all = GalleryRepository.cached() ?: all
        rebuild()
    }

    /** Opens the album screen (step 6) for [album]'s folder. */
    private fun openAlbum(album: GalleryAlbum) = GalleryAlbumActivity.start(this, album.folderPath, album.name)

    /**
     * The settings menu (every choice is saved in [GalleryPrefs]): group by date, favorites only, 2 to 5 columns, the
     * slideshow interval, "All files access" (only on Android 11+ while it is not allowed) and refresh.
     */
    private fun showViewMenu() {
        val rows = ArrayList<GlassSheet.Row>()
        val actions = ArrayList<() -> Unit>()
        fun add(icon: Int, label: String, selected: Boolean, action: () -> Unit) {
            rows.add(GlassSheet.Row(icon, label, selected))
            actions.add(action)
        }
        add(R.drawable.gl_ic_photo_library, getString(R.string.gl_menu_group_by_date), groupByDate) {
            groupByDate = !groupByDate
            GalleryPrefs.setGroupByDate(this, groupByDate)
            rebuild()
        }
        add(R.drawable.gl_ic_favorite, getString(R.string.gl_menu_favorites), favoritesOnly) {
            setFavoritesOnly(!favoritesOnly)
        }
        for (c in GalleryPrefs.MIN_COLUMNS..GalleryPrefs.MAX_COLUMNS) {
            add(R.drawable.gl_ic_grid, getString(R.string.gl_menu_columns, c), c == columns) { setColumns(c) }
        }
        add(R.drawable.gl_ic_slideshow, getString(R.string.gl_menu_slideshow), false) { showSlideshowMenu() }
        if (Build.VERSION.SDK_INT >= 30 && !GalleryPermission.hasAllFilesAccess()) {
            add(R.drawable.gl_ic_lock, getString(R.string.gl_menu_all_files), false) { openAllFilesSettings() }
        }
        add(R.drawable.gl_ic_retry, getString(R.string.gl_menu_refresh), false) { reload(force = true) }
        GlassSheet.show(this, rows) { index -> actions.getOrNull(index)?.invoke() }
    }

    /** The slideshow interval the viewer uses (2, 3, 5, 10 or 15 seconds). */
    private fun showSlideshowMenu() {
        val chosen = GalleryPrefs.slideshowSeconds(this)
        val rows = GalleryPrefs.SLIDESHOW_CHOICES.map { sec ->
            GlassSheet.Row(R.drawable.gl_ic_slideshow, getString(R.string.gl_slideshow_seconds, sec), sec == chosen)
        }
        GlassSheet.show(this, rows) { index ->
            GalleryPrefs.SLIDESHOW_CHOICES.getOrNull(index)?.let { GalleryPrefs.setSlideshowSeconds(this, it) }
        }
    }

    /** Shows only the hearted pictures (or all of them again) and remembers the choice. */
    private fun setFavoritesOnly(value: Boolean) {
        if (value == favoritesOnly) return
        favoritesOnly = value
        GalleryPrefs.setFavoritesOnly(this, value)
        rebuild(resetScroll = true)
    }

    /** Android 11+: the settings page where the user allows "All files access" (folder scan, deleting other apps' pictures). */
    private fun openAllFilesSettings() {
        if (Build.VERSION.SDK_INT < 30) return
        try {
            startActivity(
                Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.fromParts("package", packageName, null))
            )
        } catch (e: Exception) {
            try {
                startActivity(Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION))
            } catch (e2: Exception) {
                Log.w(TAG, "no all-files-access screen", e2)
            }
        }
    }

    // ── search ───────────────────────────────────────────────────────────────

    private fun toggleSearch() {
        if (searchOpen) closeSearch() else openSearch()
    }

    private fun openSearch(showKeyboard: Boolean = true) {
        searchOpen = true
        searchBack.isEnabled = true
        searchWrap.visibility = View.VISIBLE
        if (showKeyboard) {
            searchField.requestFocus()
            getSystemService(InputMethodManager::class.java)?.showSoftInput(searchField, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun closeSearch() {
        searchOpen = false
        searchBack.isEnabled = false
        hideKeyboard()
        searchField.setText("") // also clears the filter (through the text watcher)
        searchWrap.visibility = View.GONE
        if (query.isNotEmpty()) { // the watcher is debounced: apply at once
            searchJob?.cancel()
            query = ""
            rebuild(resetScroll = true)
        }
    }

    private fun hideKeyboard() {
        getSystemService(InputMethodManager::class.java)?.hideSoftInputFromWindow(searchField.windowToken, 0)
    }

    private fun onSearchTextChanged(text: String) {
        searchClear.visibility = if (text.isEmpty()) View.INVISIBLE else View.VISIBLE
        searchJob?.cancel()
        if (text == query) return
        searchJob = scope.launch {
            delay(SEARCH_DEBOUNCE_MS)
            query = text
            rebuild(resetScroll = true)
        }
    }

    // ── permission ───────────────────────────────────────────────────────────

    private fun requestPermission() {
        permissionAsked = true
        ActivityCompat.requestPermissions(this, arrayOf(GalleryPermission.toRequest(this)), REQ_PERMISSION)
    }

    /** After a "don't ask again" the system shows no dialog any more: the button then opens the app settings. */
    private fun needsSettings(): Boolean =
        permissionAsked && !ActivityCompat.shouldShowRequestPermissionRationale(this, GalleryPermission.toRequest(this))

    private fun openAppSettings() {
        try {
            startActivity(
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", packageName, null))
            )
        } catch (e: ActivityNotFoundException) {
            Log.w(TAG, "no settings screen", e)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != REQ_PERMISSION) return
        if (GalleryPermission.has(this)) reload(force = true) else render()
    }

    private companion object {
        const val TAG = "GalleryHome"
        const val KEY_QUERY = "gl_state_query"
        const val REQ_PERMISSION = 5201
        const val SEARCH_DEBOUNCE_MS = 200L
        const val STALE_MS = 60_000L
    }
}
