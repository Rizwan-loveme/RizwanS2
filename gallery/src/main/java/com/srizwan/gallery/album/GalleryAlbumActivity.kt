package com.srizwan.gallery.album

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.HapticFeedbackConstants
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.data.GalleryPermission
import com.srizwan.gallery.data.GalleryPrefs
import com.srizwan.gallery.data.GalleryRepository
import com.srizwan.gallery.data.SortBy
import com.srizwan.gallery.home.GalleryNav
import com.srizwan.gallery.home.PhotoItem
import com.srizwan.gallery.home.PhotosAdapter
import com.srizwan.gallery.home.PinchColumnsListener
import com.srizwan.gallery.home.SelectionController
import com.srizwan.gallery.ui.GlassBar
import com.srizwan.gallery.ui.GlassEmptyState
import com.srizwan.gallery.ui.GlassSheet
import com.srizwan.gallery.ui.GlassShimmerView
import com.srizwan.gallery.ui.GlassToast
import com.srizwan.gallery.ui.GlassUi
import com.srizwan.gallery.ui.VectorText
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * The album screen (step 6): the pictures of ONE folder in the same grid as the home screen, under a glass header.
 *
 *  - Header: back, folder name, a sort button and the view-mode button; the picture count sits under it.
 *  - **Sort** (glass sheet): newest first, oldest first, name (A to Z), size (biggest first). The choice is saved
 *    ([GalleryPrefs.albumSortIndex]). Date headers are shown for the two date orders (when "group by date" is on),
 *    name / size give one flat grid.
 *  - **View mode**: group by date, 2 to 5 columns (shared with the home screen); pinch changes the columns too.
 *  - Shimmer skeleton while loading, glass empty card when the folder has no pictures any more.
 *  - Tapping a picture opens the viewer with the folder's pictures in the order shown here.
 *
 * Started with [start]; the pictures come from [GalleryRepository] (shared in-memory list), so coming back from the
 * viewer (after a delete / rename) shows the fresh list.
 */
class GalleryAlbumActivity : AppCompatActivity() {

    private enum class State { LOADING, EMPTY, CONTENT }

    private class BuildResult(val images: List<GalleryImage>, val items: List<PhotoItem>)

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var loadJob: Job? = null
    private var buildJob: Job? = null

    private lateinit var root: FrameLayout
    private lateinit var topArea: LinearLayout
    private lateinit var scrim: View
    private lateinit var bar: GlassBar
    private lateinit var countText: VectorText
    private lateinit var list: RecyclerView
    private lateinit var shimmer: GlassShimmerView
    private lateinit var empty: GlassEmptyState
    private lateinit var layout: GridLayoutManager
    private lateinit var adapter: PhotosAdapter
    private lateinit var selection: SelectionController
    private lateinit var selectionBack: OnBackPressedCallback

    private var folderPath = ""
    private var albumName = ""
    private var all: List<GalleryImage> = emptyList()
    private var sortIndex = 0
    private var columns = GalleryPrefs.DEFAULT_COLUMNS
    private var groupByDate = true
    private var loading = true

    private var insetLeft = 0
    private var insetRight = 0
    private var insetBottom = 0
    private var topHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        folderPath = intent.getStringExtra(EXTRA_FOLDER).orEmpty()
        albumName = intent.getStringExtra(EXTRA_NAME).orEmpty().ifEmpty { java.io.File(folderPath).name }
        if (folderPath.isEmpty()) {
            finish()
            return
        }
        sortIndex = GalleryPrefs.albumSortIndex(this)
        columns = GalleryPrefs.columns(this)
        groupByDate = GalleryPrefs.groupByDate(this)
        buildUi()
        setContentView(root)
        GalleryNav.edgeToEdge(this, root)
        render()
    }

    override fun onStart() {
        super.onStart()
        if (folderPath.isEmpty()) return
        if (!GalleryPermission.has(this)) { // the permission was taken away: the home screen asks for it again
            finish()
            return
        }
        GlassToast.host = this
        load()
    }

    override fun onStop() {
        if (GlassToast.host === this) GlassToast.host = null
        super.onStop()
    }

    /** Rotation / split screen (the screen is not recreated): new insets, the skeleton and the thumbnails follow the new width. */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        ViewCompat.requestApplyInsets(root)
        render()
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    // ── views ────────────────────────────────────────────────────────────────

    private fun dp(v: Float): Int = GlassUi.dp(this, v)

    private fun buildUi() {
        root = FrameLayout(this).apply { setBackgroundColor(getColor(R.color.gl_bg)) }

        adapter = PhotosAdapter(
            onClick = { index ->
                if (selection.active) selection.toggle(index) else GalleryNav.openPhoto(this, adapter.images, index)
            },
            onLongPress = { index -> selection.onLongPress(index) }
        )
        selection = SelectionController(
            this, scope, adapter,
            onModeChanged = { active -> onSelectionMode(active) },
            onDeleted = { onPhotosDeleted() }
        )
        adapter.setColumns(columns)
        layout = GridLayoutManager(this, columns)
        val lm = layout
        layout.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = if (adapter.isHeader(position)) lm.spanCount else 1
        }
        list = RecyclerView(this).apply {
            layoutManager = layout
            this.adapter = this@GalleryAlbumActivity.adapter
            clipToPadding = false
            setHasFixedSize(true)
            itemAnimator = null
            setItemViewCacheSize(16)
            visibility = View.GONE
            addOnLayoutChangeListener { v, _, _, _, _, _, _, _, _ ->
                this@GalleryAlbumActivity.adapter.updateWidth(v.width - v.paddingLeft - v.paddingRight, this)
            }
            addOnItemTouchListener(
                PinchColumnsListener(
                    this@GalleryAlbumActivity, { columns }, { setColumns(it) },
                    GalleryPrefs.MIN_COLUMNS, GalleryPrefs.MAX_COLUMNS
                )
            )
            addOnItemTouchListener(selection.dragListener)
        }
        shimmer = GlassShimmerView(this).apply { visibility = View.GONE }
        empty = GlassEmptyState(this).apply { visibility = View.GONE }

        root.addView(list, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        root.addView(shimmer, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        root.addView(empty, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        scrim = View(this).apply {
            background = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(0xE60B0D10.toInt(), 0x000B0D10)
            )
        }
        root.addView(scrim, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(110f), Gravity.TOP))

        bar = GlassBar(this).apply {
            setTitle(albumName)
            setBackVisible(true) { finish() }
            addAction(R.drawable.gl_ic_sort, R.string.gl_cd_sort) { showSortMenu() }
            addAction(R.drawable.gl_ic_grid, R.string.gl_cd_grid) { showViewMenu() }
        }
        countText = VectorText(this).apply { setPadding(dp(24f), dp(4f), dp(24f), dp(8f)) }
        topArea = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(bar, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(countText, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addOnLayoutChangeListener { _, _, top, _, bottom, _, _, _, _ ->
                val h = bottom - top
                if (h != topHeight) {
                    topHeight = h
                    root.post { applyPadding() }
                }
            }
        }
        root.addView(topArea, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP))
        // the glass selection bar (step 9) floats over the header while pictures are picked
        root.addView(selection.bar, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP))

        selectionBack = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                selection.clear()
            }
        }
        onBackPressedDispatcher.addCallback(this, selectionBack)

        ViewCompat.setOnApplyWindowInsetsListener(root) { _, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout())
            insetLeft = b.left
            insetRight = b.right
            insetBottom = b.bottom
            applyPadding()
            insets
        }
    }

    private fun applyPadding() {
        val top = topHeight
        list.setPadding(insetLeft, top, insetRight, insetBottom + dp(12f))
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
    }

    // ── data ─────────────────────────────────────────────────────────────────

    private fun load(force: Boolean = false) {
        loadJob?.cancel()
        if (all.isEmpty()) {
            loading = true
            render()
        }
        loadJob = scope.launch {
            val source = try {
                GalleryRepository.load(applicationContext, forceRefresh = force)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.w(TAG, "load failed", e)
                emptyList()
            }
            if (source === all && !loading) return@launch // nothing changed since the last time
            all = source
            rebuild()
        }
    }

    /** Picks the folder's pictures, sorts and groups them on a background thread, then shows them. */
    private fun rebuild(resetScroll: Boolean = false) {
        buildJob?.cancel()
        val source = all
        val sort = GalleryPrefs.albumSort(sortIndex)
        val grouped = groupByDate && sort.by == SortBy.DATE
        val folder = folderPath
        buildJob = scope.launch {
            val result = withContext(Dispatchers.Default) {
                val images = GalleryRepository.sorted(GalleryRepository.imagesInFolder(source, folder), sort)
                BuildResult(images, GalleryNav.buildItems(images, grouped))
            }
            adapter.submit(result.items, result.images)
            selection.onListChanged()
            if (resetScroll) list.scrollToPosition(0)
            countText.set(
                resources.getQuantityString(R.plurals.gl_n_photos, result.images.size, result.images.size),
                13f, 0xB3FFFFFF.toInt()
            )
            loading = false
            render()
        }
    }

    private fun render() {
        val state = when {
            loading -> State.LOADING
            adapter.images.isEmpty() -> State.EMPTY
            else -> State.CONTENT
        }
        if (state == State.LOADING) shimmer.configure(GlassShimmerView.Style.PHOTOS, columns)
        shimmer.visibility = if (state == State.LOADING) View.VISIBLE else View.GONE
        if (state == State.EMPTY) {
            empty.show(R.drawable.gl_ic_photo_library, getString(R.string.gl_empty_title), getString(R.string.gl_empty_text))
        }
        empty.visibility = if (state == State.EMPTY) View.VISIBLE else View.GONE
        list.visibility = if (state == State.CONTENT) View.VISIBLE else View.GONE
    }

    // ── multi-select (step 9) ────────────────────────────────────────────────

    /** The glass selection bar takes the place of the header while pictures are picked. */
    private fun onSelectionMode(active: Boolean) {
        selectionBack.isEnabled = active
        topArea.visibility = if (active) View.INVISIBLE else View.VISIBLE
    }

    /** Pictures were deleted in the selection mode: show the shared list without them. */
    private fun onPhotosDeleted() {
        all = GalleryRepository.cached() ?: all
        rebuild()
    }

    // ── actions ──────────────────────────────────────────────────────────────

    private fun showSortMenu() {
        val labels = intArrayOf(R.string.gl_sort_newest, R.string.gl_sort_oldest, R.string.gl_sort_name, R.string.gl_sort_size)
        val rows = labels.mapIndexed { i, res -> GlassSheet.Row(R.drawable.gl_ic_sort, getString(res), i == sortIndex) }
        GlassSheet.show(this, rows) { index ->
            if (index != sortIndex) {
                sortIndex = index
                GalleryPrefs.setAlbumSortIndex(this, index)
                rebuild(resetScroll = true)
            }
        }
    }

    private fun showViewMenu() {
        val rows = ArrayList<GlassSheet.Row>()
        rows.add(GlassSheet.Row(R.drawable.gl_ic_photo_library, getString(R.string.gl_menu_group_by_date), groupByDate))
        for (c in GalleryPrefs.MIN_COLUMNS..GalleryPrefs.MAX_COLUMNS) {
            rows.add(GlassSheet.Row(R.drawable.gl_ic_grid, getString(R.string.gl_menu_columns, c), c == columns))
        }
        GlassSheet.show(this, rows) { index ->
            if (index == 0) {
                groupByDate = !groupByDate
                GalleryPrefs.setGroupByDate(this, groupByDate)
                rebuild()
            } else {
                setColumns(GalleryPrefs.MIN_COLUMNS + index - 1)
            }
        }
    }

    private fun setColumns(value: Int) {
        val c = value.coerceIn(GalleryPrefs.MIN_COLUMNS, GalleryPrefs.MAX_COLUMNS)
        if (c == columns) return
        columns = c
        GalleryPrefs.setColumns(this, c)
        val first = layout.findFirstVisibleItemPosition()
        layout.spanCount = c
        adapter.setColumns(c)
        if (first >= 0) layout.scrollToPositionWithOffset(first, 0)
        list.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK)
        list.alpha = 0.5f
        list.animate().alpha(1f).setDuration(180L).start()
    }

    companion object {
        private const val TAG = "GalleryAlbum"
        const val EXTRA_FOLDER = "gl_album_folder"
        const val EXTRA_NAME = "gl_album_name"

        /** Opens the album screen for the folder [folderPath]; [name] is the title (default: the folder name). */
        @JvmStatic
        fun start(context: Context, folderPath: String, name: String? = null) {
            val intent = Intent(context, GalleryAlbumActivity::class.java)
                .putExtra(EXTRA_FOLDER, folderPath)
                .putExtra(EXTRA_NAME, name.orEmpty())
            if (context !is android.app.Activity) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
