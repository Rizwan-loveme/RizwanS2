package com.srizwan.gallery.viewer

import android.app.WallpaperManager
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.data.GalleryPrefs
import com.srizwan.gallery.data.GalleryRepository
import com.srizwan.gallery.data.ImageInfo
import com.srizwan.gallery.home.GalleryNav
import com.srizwan.gallery.ui.GlassBar
import com.srizwan.gallery.ui.GlassConfirm
import com.srizwan.gallery.ui.GlassInfoSheet
import com.srizwan.gallery.ui.GlassPrompt
import com.srizwan.gallery.ui.GlassSheet
import com.srizwan.gallery.ui.GlassToast
import com.srizwan.gallery.ui.GlassToolbar
import com.srizwan.gallery.ui.GlassUi
import com.srizwan.gallery.ui.VectorText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.util.Locale
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * The full-screen photo viewer (step 7).
 *
 *  - **Swipe** left / right between the pictures (ViewPager2, a small gap between pages). Each page is a [ZoomImageView]:
 *    pinch, double-tap, pan, fling, and **swipe down to close** (the backdrop and the bars fade while you drag).
 *    Big pictures are decoded in tiles, so a 4K / 12 MP photo stays sharp when zoomed and never fills the memory;
 *    EXIF orientation is applied (also to the tiles); GIFs play.
 *  - **Tap** hides / shows the glass top bar (name, "3 / 120") and the bottom area (the glass filmstrip; the actions toolbar
 *    of step 8 goes into the same bottom area) and, together with them, the system bars.
 *  - **Filmstrip**: glass thumbnails with the current one centred; tap to jump there.
 *  - **Back** first stops a running slideshow, then returns a zoomed picture to "fit", then closes.
 *  - **Actions** (step 8, the glass toolbar above the screen's bottom edge, under the filmstrip): Share (FileProvider),
 *    Favorite (heart, stored on the device), Slideshow (auto-advance, interval chosen in a glass sheet), Rotate (turns the
 *    picture 90 degrees clockwise in the viewer; while turned, the top bar shows a check = save it into the file and a
 *    cross = undo), Rename, Set as wallpaper (home / lock / both), Info (details sheet with EXIF) and Delete (glass
 *    confirm). The file work is in [ImageActions]; it runs on a background thread and the screen follows the result
 *    (a deleted picture leaves the pager and the filmstrip, a renamed one gets its new name).
 *
 * Opened with [start]: the picture and the other pictures of the folder IN THE ORDER the caller shows them. Without
 * that list (a single file from another app) the viewer uses the folder's pictures from [GalleryRepository.cached].
 * The window is translucent, so while you drag a picture down the screen behind it shows through.
 */
class GalleryViewerActivity : AppCompatActivity() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var loadJob: Job? = null

    private lateinit var root: FrameLayout
    private lateinit var backdrop: View
    private lateinit var pager: ViewPager2
    private lateinit var chrome: FrameLayout
    private lateinit var topArea: LinearLayout
    private lateinit var bar: GlassBar
    private lateinit var counter: VectorText
    private lateinit var bottomArea: LinearLayout
    private lateinit var filmstrip: GlassFilmstrip
    private lateinit var toolbar: GlassToolbar
    private lateinit var btnFavorite: ImageView
    private lateinit var btnSlideshow: ImageView
    private lateinit var btnRotate: ImageView
    private lateinit var barSave: ImageView
    private lateinit var barUndo: ImageView
    private lateinit var adapter: ViewerPagerAdapter
    private lateinit var systemBars: WindowInsetsControllerCompat

    private var startPath = ""

    /** The caller's picture order ([EXTRA_PATHS]); only read from an intent that carries this process's [TOKEN]. */
    private var givenPaths: List<String> = emptyList()

    /** The uri of an `ACTION_VIEW` from another app (step 10), turned into a path off the main thread in [loadImages]. */
    private var pendingUri: Uri? = null
    private var current = 0
    private var barsVisible = true

    // step 8: slideshow and background actions
    private val handler = Handler(Looper.getMainLooper())
    private val accent by lazy { getColor(R.color.gl_accent) }
    private var slideshow = false
    private var busy = false
    private val advance = Runnable { advanceSlideshow() }

    /** What the pages tell this screen (kept out of the class header: the listener type is internal). */
    private val pageListener = object : ZoomImageView.Listener {
        override fun onTap() {
            setBars(!barsVisible)
        }

        override fun onDragProgress(progress: Float) {
            backdrop.alpha = 1f - progress
            chrome.alpha = (1f - progress * 2.5f).coerceAtLeast(0f)
        }

        override fun onDismiss() {
            close()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readIntent(intent, savedInstanceState?.getString(KEY_PATH))
        if (startPath.isEmpty() && pendingUri == null) {
            finish()
            return
        }
        buildUi()
        setContentView(root)
        GalleryNav.edgeToEdge(this, root)
        systemBars = WindowInsetsControllerCompat(window, root).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
        if (Build.VERSION.SDK_INT >= 28) { // use the area beside a camera cut-out when the bars are hidden
            val lp = window.attributes
            lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            window.attributes = lp
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (slideshow) {
                    stopSlideshow()
                    return
                }
                val page = adapter.viewAt(pager.currentItem)
                if (page != null && page.isZoomed) {
                    page.resetZoom(animated = true)
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
        root.post { ViewCompat.requestApplyInsets(root) }
        loadImages()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        readIntent(intent, null)
        if (startPath.isEmpty() && pendingUri == null) return
        loadImages()
    }

    /**
     * Reads what the intent asks for. Since step 10 this screen is exported (other apps open pictures in it with
     * `ACTION_VIEW`), so a path or a picture list is only taken from an intent made by [start] (it carries [TOKEN], which
     * only this process knows); an intent from outside can only bring a `data` uri.
     */
    private fun readIntent(i: Intent, savedPath: String?) {
        val trusted = i.getStringExtra(EXTRA_TOKEN) == TOKEN
        givenPaths = if (trusted) i.getStringArrayListExtra(EXTRA_PATHS) ?: emptyList() else emptyList()
        startPath = savedPath ?: if (trusted) i.getStringExtra(EXTRA_PATH).orEmpty() else ""
        pendingUri = if (startPath.isEmpty() && i.action == Intent.ACTION_VIEW) i.data else null
    }

    override fun onStart() {
        super.onStart()
        GlassToast.host = this
    }

    override fun onStop() {
        stopSlideshow()
        if (GlassToast.host === this) GlassToast.host = null
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (::adapter.isInitialized) adapter.images.getOrNull(current)?.let { outState.putString(KEY_PATH, it.path) }
    }

    override fun onDestroy() {
        handler.removeCallbacks(advance)
        scope.cancel()
        super.onDestroy()
    }

    // ── views ────────────────────────────────────────────────────────────────

    private fun dp(v: Float): Int = GlassUi.dp(this, v)

    private fun buildUi() {
        root = FrameLayout(this)

        backdrop = View(this).apply { setBackgroundColor(Color.BLACK) }
        root.addView(backdrop, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        adapter = ViewerPagerAdapter(pageListener)
        pager = ViewPager2(this).apply {
            this.adapter = this@GalleryViewerActivity.adapter
            offscreenPageLimit = 1
            setPageTransformer(MarginPageTransformer(dp(14f)))
            (getChildAt(0) as? RecyclerView)?.overScrollMode = View.OVER_SCROLL_NEVER
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    onPage(position)
                }

                override fun onPageScrollStateChanged(state: Int) {
                    if (!slideshow) return
                    // a finger on the pager holds the slideshow; when it settles the interval starts again
                    if (state == ViewPager2.SCROLL_STATE_DRAGGING) handler.removeCallbacks(advance)
                    else if (state == ViewPager2.SCROLL_STATE_IDLE) scheduleSlideshow()
                }
            })
        }
        root.addView(pager, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        chrome = FrameLayout(this)
        root.addView(chrome, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        bar = GlassBar(this).apply { setBackVisible(true) { finish() } }
        // shown only while the picture is turned in the viewer: save the turn into the file / take it back
        barSave = bar.addAction(R.drawable.gl_ic_check, R.string.gl_cd_save_rotation) { onSaveRotation() }
        barUndo = bar.addAction(R.drawable.gl_ic_close, R.string.gl_cd_undo_rotation) { onUndoRotation() }
        barSave.visibility = View.GONE
        barUndo.visibility = View.GONE
        counter = VectorText(this).apply { setPadding(dp(24f), dp(2f), dp(24f), dp(12f)) }
        topArea = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(0xAA000000.toInt(), 0x00000000))
            addView(bar, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(counter, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        }
        chrome.addView(
            topArea,
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.TOP)
        )

        filmstrip = GlassFilmstrip(this).apply { onPick = { index -> goTo(index) } }
        // The bottom area is a vertical stack: the glass filmstrip, then the glass actions toolbar (step 8). The area
        // keeps clear of the system bars itself, so the toolbar drops its own insets padding.
        toolbar = GlassToolbar(this).apply { withoutOwnInsets() }
        toolbar.addButton(R.drawable.gl_ic_share, R.string.gl_cd_share, compact = true) { onShare() }
        btnFavorite = toolbar.addButton(R.drawable.gl_ic_favorite_outline, R.string.gl_cd_favorite, compact = true) { onFavorite() }
        btnSlideshow = toolbar.addButton(R.drawable.gl_ic_slideshow, R.string.gl_cd_slideshow, compact = true) { onSlideshow() }
        btnRotate = toolbar.addButton(R.drawable.gl_ic_rotate, R.string.gl_cd_rotate, compact = true) { onRotate() }
        toolbar.addButton(R.drawable.gl_ic_edit, R.string.gl_cd_rename, compact = true) { onRename() }
        toolbar.addButton(R.drawable.gl_ic_wallpaper, R.string.gl_cd_wallpaper, compact = true) { onWallpaper() }
        toolbar.addButton(R.drawable.gl_ic_info, R.string.gl_cd_info, compact = true) { onInfo() }
        toolbar.addButton(R.drawable.gl_ic_delete, R.string.gl_cd_delete, compact = true) { onDelete() }

        bottomArea = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            background = GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, intArrayOf(0xAA000000.toInt(), 0x00000000))
            setPadding(0, dp(28f), 0, 0)
            addView(filmstrip, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(
                toolbar,
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    .apply { topMargin = dp(8f) }
            )
        }
        GlassUi.padForInsets(bottomArea, 12f, top = false, bottom = true)
        chrome.addView(
            bottomArea,
            FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM)
        )
    }

    // ── pictures ─────────────────────────────────────────────────────────────

    private fun loadImages() {
        loadJob?.cancel()
        val uri = pendingUri
        val given = givenPaths
        loadJob = scope.launch {
            var path = startPath
            if (uri != null) { // a picture another app wants shown (step 10)
                path = withContext(Dispatchers.IO) { ViewUri.resolve(applicationContext, uri) }.orEmpty()
                startPath = path
                pendingUri = null
            }
            if (path.isEmpty()) {
                GlassToast.show(applicationContext, R.drawable.gl_ic_error, getString(R.string.gl_cd_error))
                finish()
                return@launch
            }
            val (list, index) = withContext(Dispatchers.IO) { resolve(path, given) }
            if (list.isEmpty()) {
                finish()
                return@launch
            }
            adapter.submit(list)
            filmstrip.setImages(list)
            pager.setCurrentItem(index, false)
            onPage(index)
        }
    }

    /**
     * The pictures to swipe through and the position of [path] in them. [given] (the caller's order) wins; with none,
     * the folder's pictures from the shared list; with that missing too, just the one file.
     */
    private fun resolve(path: String, given: List<String>): Pair<List<GalleryImage>, Int> {
        val cache = GalleryRepository.cached()
        val byPath = HashMap<String, GalleryImage>()
        if (cache != null) for (img in cache) byPath[img.path] = img

        fun lookup(p: String): GalleryImage? {
            byPath[p]?.let { return it }
            val f = File(p)
            // the requested file is always accepted; its neighbours must look like pictures
            return if (f.isFile && (p == path || GalleryRepository.isImageName(f.name))) GalleryRepository.fromFile(f) else null
        }

        val list = ArrayList<GalleryImage>()
        if (given.isEmpty()) {
            val folder = File(path).parent
            if (cache != null && folder != null) list.addAll(GalleryRepository.imagesInFolder(cache, folder))
            if (folder != null && list.none { it.path == path } && !ViewUri.isTemp(applicationContext, path)) {
                // not in the shared list (the Gallery was not opened yet, or MediaStore does not know the file): the
                // pictures of its folder in name order, at most MAX_PATHS around it
                list.clear()
                val files = File(folder).listFiles { f -> f.isFile && GalleryRepository.isImageName(f.name) }
                    ?.sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.name }).orEmpty()
                val at = files.indexOfFirst { it.absolutePath == path }.coerceAtLeast(0)
                val from = max(0, at - MAX_PATHS / 2)
                for (f in files.subList(from, min(files.size, from + MAX_PATHS))) lookup(f.absolutePath)?.let { list.add(it) }
            }
        } else if (cache != null && given.size >= MAX_PATHS && isRunOf(cache, given)) {
            // The caller cut a long list down to MAX_PATHS around the tapped picture, and it is a straight run of the
            // shared list: swipe through the whole list instead.
            list.addAll(cache)
        } else {
            for (p in given) lookup(p)?.let { list.add(it) }
        }
        var index = list.indexOfFirst { it.path == path }
        if (index < 0) {
            val own = lookup(path) ?: return Pair(emptyList(), 0)
            list.add(0, own)
            index = 0
        }
        return Pair(list, index)
    }

    /** True when [paths] appear in [cache] one after the other, in the same order. */
    private fun isRunOf(cache: List<GalleryImage>, paths: List<String>): Boolean {
        val start = cache.indexOfFirst { it.path == paths[0] }
        if (start < 0 || start + paths.size > cache.size) return false
        for (i in paths.indices) if (cache[start + i].path != paths[i]) return false
        return true
    }

    private fun onPage(position: Int) {
        val images = adapter.images
        if (position !in images.indices) return
        current = position
        bar.setTitle(images[position].name)
        counter.set(getString(R.string.gl_viewer_counter, position + 1, images.size), 13f, 0xB3FFFFFF.toInt())
        filmstrip.setCurrent(position, smooth = true)
        adapter.resetZoomExcept(position)
        updateActions()
        if (slideshow) scheduleSlideshow()
    }

    /** A thumbnail was tapped: close pictures slide, far ones jump. */
    private fun goTo(index: Int) {
        if (index == pager.currentItem) return
        pager.setCurrentItem(index, abs(index - pager.currentItem) <= 3)
    }

    // ── actions (step 8) ─────────────────────────────────────────────────────

    private fun currentImage(): GalleryImage? = adapter.images.getOrNull(current)

    private fun toast(icon: Int, text: Int, vararg args: Any) {
        GlassToast.show(this, icon, getString(text, *args))
    }

    private fun toastFail(text: Int) = toast(R.drawable.gl_ic_error, text)

    /** Runs [block] on the main thread while ignoring further action taps (an action is already working). */
    private fun runBusy(block: suspend () -> Unit) {
        if (busy) return
        busy = true
        scope.launch {
            try {
                block()
            } finally {
                busy = false
            }
        }
    }

    /** The icons that show the state of the current picture: heart, turn, slideshow. */
    private fun updateActions() {
        val image = currentImage() ?: return
        val fav = GalleryPrefs.isFavorite(this, image.path)
        GlassUi.setIcon(btnFavorite, if (fav) R.drawable.gl_ic_favorite else R.drawable.gl_ic_favorite_outline)
        if (fav) btnFavorite.setColorFilter(FAVORITE_COLOR) else btnFavorite.clearColorFilter()

        val turned = adapter.turnsOf(image.path) != 0
        if (turned) btnRotate.setColorFilter(accent) else btnRotate.clearColorFilter()
        val v = if (turned) View.VISIBLE else View.GONE
        barSave.visibility = v
        barUndo.visibility = v

        if (slideshow) {
            GlassUi.setIcon(btnSlideshow, R.drawable.gl_ic_pause, R.string.gl_cd_pause)
            btnSlideshow.setColorFilter(accent)
        } else {
            GlassUi.setIcon(btnSlideshow, R.drawable.gl_ic_slideshow, R.string.gl_cd_slideshow)
            btnSlideshow.clearColorFilter()
        }
    }

    private fun onShare() {
        val image = currentImage() ?: return
        stopSlideshow()
        if (!ImageActions.share(this, image)) toastFail(R.string.gl_toast_share_failed)
    }

    private fun onFavorite() {
        val image = currentImage() ?: return
        val now = !GalleryPrefs.isFavorite(this, image.path)
        GalleryPrefs.setFavorite(this, image.path, now)
        updateActions()
        if (now) toast(R.drawable.gl_ic_favorite, R.string.gl_toast_fav_added)
        else toast(R.drawable.gl_ic_favorite_outline, R.string.gl_toast_fav_removed)
    }

    // delete ------------------------------------------------------------------

    private fun onDelete() {
        val image = currentImage() ?: return
        stopSlideshow()
        GlassConfirm.show(
            this, R.drawable.gl_ic_delete,
            getString(R.string.gl_delete_confirm), getString(R.string.gl_action_cancel)
        ) { doDelete(image) }
    }

    private fun doDelete(image: GalleryImage) = runBusy {
        val ok = withContext(Dispatchers.IO) { ImageActions.delete(applicationContext, image) }
        if (!ok) {
            toastFail(R.string.gl_toast_delete_failed)
            return@runBusy
        }
        val position = adapter.images.indexOfFirst { it.path == image.path }
        if (position < 0) return@runBusy
        adapter.removeAt(position)
        val list = adapter.images
        toast(R.drawable.gl_ic_delete, R.string.gl_toast_deleted)
        if (list.isEmpty()) { // that was the last picture
            finish()
            return@runBusy
        }
        filmstrip.setImages(list)
        val next = min(position, list.size - 1)
        pager.setCurrentItem(next, false)
        onPage(next)
    }

    // rename ------------------------------------------------------------------

    private fun onRename() {
        val image = currentImage() ?: return
        stopSlideshow()
        val file = File(image.path)
        val base = file.name.substringBeforeLast('.', file.name)
        GlassPrompt.show(
            this, R.drawable.gl_ic_edit, getString(R.string.gl_rename_title), file.name, base.length
        ) { typed -> doRename(image, typed) }
    }

    private fun doRename(image: GalleryImage, typed: String) = runBusy {
        val result = withContext(Dispatchers.IO) { ImageActions.rename(applicationContext, image, typed) }
        when (result.outcome) {
            ImageActions.Outcome.OK -> {
                val renamed = result.image ?: return@runBusy
                if (renamed.path == image.path) return@runBusy // the same name: nothing changed
                val position = adapter.images.indexOfFirst { it.path == image.path }
                if (position < 0) return@runBusy
                adapter.replaceAt(position, renamed)
                filmstrip.setImages(adapter.images)
                onPage(position)
                toast(R.drawable.gl_ic_check_circle, R.string.gl_toast_renamed)
            }
            ImageActions.Outcome.BAD_NAME -> toastFail(R.string.gl_toast_rename_bad)
            ImageActions.Outcome.EXISTS -> toastFail(R.string.gl_toast_rename_exists)
            else -> toastFail(R.string.gl_toast_rename_failed)
        }
    }

    // wallpaper ---------------------------------------------------------------

    private fun onWallpaper() {
        val image = currentImage() ?: return
        stopSlideshow()
        GlassSheet.show(
            this,
            listOf(
                GlassSheet.Row(R.drawable.gl_ic_wallpaper, getString(R.string.gl_wallpaper_home), false),
                GlassSheet.Row(R.drawable.gl_ic_lock, getString(R.string.gl_wallpaper_lock), false),
                GlassSheet.Row(R.drawable.gl_ic_wallpaper, getString(R.string.gl_wallpaper_both), false)
            )
        ) { index ->
            val which = when (index) {
                0 -> WallpaperManager.FLAG_SYSTEM
                1 -> WallpaperManager.FLAG_LOCK
                else -> WallpaperManager.FLAG_SYSTEM or WallpaperManager.FLAG_LOCK
            }
            doWallpaper(image, which)
        }
    }

    private fun doWallpaper(image: GalleryImage, which: Int) = runBusy {
        val turns = adapter.turnsOf(image.path) // a picture turned in the viewer becomes the wallpaper as seen
        val ok = withContext(Dispatchers.IO) { ImageActions.setWallpaper(applicationContext, image, turns, which) }
        if (ok) toast(R.drawable.gl_ic_check_circle, R.string.gl_toast_wallpaper_set)
        else toastFail(R.string.gl_toast_wallpaper_failed)
    }

    // rotate ------------------------------------------------------------------

    /** One tap = 90 degrees clockwise, in the viewer only; the check in the top bar writes it into the file. */
    private fun onRotate() {
        val image = currentImage() ?: return
        stopSlideshow()
        adapter.setTurns(current, adapter.turnsOf(image.path) + 1)
        updateActions()
    }

    private fun onUndoRotation() {
        adapter.setTurns(current, 0)
        updateActions()
    }

    private fun onSaveRotation() {
        val image = currentImage() ?: return
        val turns = adapter.turnsOf(image.path)
        if (turns == 0) return
        runBusy {
            val result = withContext(Dispatchers.IO) { ImageActions.saveRotation(applicationContext, image, turns) }
            when (result.outcome) {
                ImageActions.Outcome.OK -> {
                    val updated = result.image ?: return@runBusy
                    val position = adapter.images.indexOfFirst { it.path == image.path }
                    if (position >= 0) {
                        adapter.reload(position, updated) // the file carries the turn now: the view-only turn is dropped
                        filmstrip.refresh(position)
                        updateActions()
                    }
                    toast(R.drawable.gl_ic_check_circle, R.string.gl_toast_rotation_saved)
                }
                ImageActions.Outcome.UNSUPPORTED -> toastFail(R.string.gl_toast_rotation_unsupported)
                ImageActions.Outcome.TOO_BIG -> toastFail(R.string.gl_toast_rotation_too_big)
                else -> toastFail(R.string.gl_toast_rotation_failed)
            }
        }
    }

    // info --------------------------------------------------------------------

    private fun onInfo() {
        val image = currentImage() ?: return
        stopSlideshow()
        runBusy {
            val info = withContext(Dispatchers.IO) { ImageInfo.read(applicationContext, image) }
            GlassInfoSheet.show(this@GalleryViewerActivity, getString(R.string.gl_info_title), info) { openMap(info, image) }
        }
    }

    private fun openMap(info: ImageInfo, image: GalleryImage) {
        val lat = info.latitude ?: return
        val lon = info.longitude ?: return
        val pos = String.format(Locale.US, "%.6f,%.6f", lat, lon)
        val uri = Uri.parse("geo:$pos?q=$pos(${Uri.encode(image.name)})")
        try {
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        } catch (e: ActivityNotFoundException) {
            toastFail(R.string.gl_toast_no_map)
        }
    }

    // slideshow ---------------------------------------------------------------

    private fun onSlideshow() {
        if (slideshow) {
            stopSlideshow()
            return
        }
        if (adapter.itemCount < 2) {
            toast(R.drawable.gl_ic_error, R.string.gl_toast_slideshow_single)
            return
        }
        val choices = GalleryPrefs.SLIDESHOW_CHOICES
        val chosen = GalleryPrefs.slideshowSeconds(this)
        GlassSheet.show(
            this,
            choices.map { GlassSheet.Row(R.drawable.gl_ic_play, getString(R.string.gl_slideshow_seconds, it), it == chosen) }
        ) { index ->
            GalleryPrefs.setSlideshowSeconds(this, choices[index])
            startSlideshow()
        }
    }

    private fun startSlideshow() {
        if (slideshow || adapter.itemCount < 2) return
        slideshow = true
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        toast(R.drawable.gl_ic_play, R.string.gl_toast_slideshow_start, GalleryPrefs.slideshowSeconds(this))
        setBars(false) // a clean show; a tap brings the bars (and the pause button) back
        updateActions()
        scheduleSlideshow()
    }

    private fun stopSlideshow() {
        if (!slideshow) return
        slideshow = false
        handler.removeCallbacks(advance)
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        if (::btnSlideshow.isInitialized) updateActions()
    }

    private fun scheduleSlideshow() {
        handler.removeCallbacks(advance)
        handler.postDelayed(advance, GalleryPrefs.slideshowSeconds(this) * 1000L)
    }

    /** Next picture; after the last one the show starts again from the first. A picture the user zoomed into waits. */
    private fun advanceSlideshow() {
        if (!slideshow) return
        val count = adapter.itemCount
        if (count < 2) {
            stopSlideshow()
            return
        }
        val page = adapter.viewAt(pager.currentItem)
        if (page != null && page.isZoomed) {
            scheduleSlideshow()
            return
        }
        val next = pager.currentItem + 1
        if (next >= count) pager.setCurrentItem(0, false) else pager.setCurrentItem(next, true)
        scheduleSlideshow() // the page change schedules again as well; the later call replaces this one
    }

    // ── bars ─────────────────────────────────────────────────────────────────

    private fun setBars(visible: Boolean) {
        if (visible == barsVisible) return
        barsVisible = visible
        val offset = dp(28f).toFloat()
        animateBar(topArea, visible, -offset)
        animateBar(bottomArea, visible, offset)
        if (visible) {
            systemBars.show(WindowInsetsCompat.Type.systemBars())
        } else {
            systemBars.hide(WindowInsetsCompat.Type.systemBars())
        }
    }

    private fun animateBar(view: View, show: Boolean, hiddenOffset: Float) {
        view.animate().cancel()
        if (show) {
            view.visibility = View.VISIBLE
            view.animate().alpha(1f).translationY(0f).setDuration(180L).start()
        } else {
            view.animate().alpha(0f).translationY(hiddenOffset).setDuration(160L)
                .withEndAction { if (!barsVisible) view.visibility = View.GONE }
                .start()
        }
    }

    /** The swipe-down finished: leave without a second animation (the picture already slid away). */
    @Suppress("DEPRECATION")
    private fun close() {
        finish()
        overridePendingTransition(0, 0)
    }

    companion object {
        const val EXTRA_PATH = "gl_path"

        /** The other pictures, in the order the caller shows them (`ArrayList<String>` of paths). */
        const val EXTRA_PATHS = "gl_paths"

        /** At most this many paths travel in the intent (keeps it small); see [start] and [resolve]. */
        const val MAX_PATHS = 1000

        /** Proves that an intent was made by [start] in this process (see [readIntent]). */
        const val EXTRA_TOKEN = "gl_token"
        private val TOKEN: String = java.util.UUID.randomUUID().toString()

        private const val KEY_PATH = "gl_state_path"

        /** The heart of a favorite picture. */
        private const val FAVORITE_COLOR = 0xFFFF5C7A.toInt()

        /**
         * Opens the viewer on [path]. [folderImages] are the pictures to swipe through, in the order the caller shows
         * them (the File Manager passes its folder, the Gallery its grid). A list longer than [MAX_PATHS] is cut to
         * [MAX_PATHS] around [path]; an empty list means "the folder of [path]".
         */
        @JvmStatic
        fun start(context: Context, path: String, folderImages: List<String> = emptyList()) {
            val intent = Intent(context, GalleryViewerActivity::class.java).putExtra(EXTRA_PATH, path).putExtra(EXTRA_TOKEN, TOKEN)
            if (folderImages.isNotEmpty()) {
                val list = if (folderImages.size > MAX_PATHS) {
                    val at = folderImages.indexOf(path).coerceAtLeast(0)
                    val from = max(0, at - MAX_PATHS / 2)
                    folderImages.subList(from, min(folderImages.size, from + MAX_PATHS))
                } else {
                    folderImages
                }
                intent.putStringArrayListExtra(EXTRA_PATHS, ArrayList(list))
            }
            if (context !is android.app.Activity) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
}
