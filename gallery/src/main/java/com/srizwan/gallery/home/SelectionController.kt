package com.srizwan.gallery.home

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.srizwan.gallery.R
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.ui.GlassBar
import com.srizwan.gallery.ui.GlassConfirm
import com.srizwan.gallery.ui.GlassToast
import com.srizwan.gallery.viewer.ImageActions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.max
import kotlin.math.min

/**
 * Multi-select mode of the photo grids (step 9), shared by the home screen and the album screen.
 *
 *  - **Start**: long-press a picture. It becomes picked and the glass selection bar replaces the top bar.
 *  - **Pick more**: tap pictures (a tap on a picked one drops it; dropping the last one ends the mode), or keep the finger
 *    down after the long press and **drag**: every picture between the long-pressed one and the finger is picked
 *    ([DragSelectListener]; the grid scrolls by itself near its top / bottom edge). Long-pressing a picture while selecting
 *    starts a new drag from it: from an unpicked one it picks the range, from a picked one it drops the range. Moving the
 *    finger back shrinks the range again (the picks made before the drag stay as they were).
 *  - **Glass selection bar**: close (cross), "N selected", select all (a second tap drops all), share ([ImageActions.shareMany],
 *    at most [ImageActions.MAX_SHARE] pictures) and delete (glass confirm sheet, then [ImageActions.deleteMany] on `Dispatchers.IO`).
 *
 * The screen owns the views: it adds [bar] on top of its top area, hides its own top bar while [active] ([onModeChanged]),
 * calls [onClick] / [onLongPress] from the adapter, adds [dragListener] to the list, calls [onListChanged] after it rebuilt
 * the grid, and reads the fresh list in [onDeleted]. The picks are kept as paths, so a rebuild (search, sort, reload) drops
 * only the pictures that are gone.
 */
internal class SelectionController(
    private val activity: AppCompatActivity,
    private val scope: CoroutineScope,
    val adapter: PhotosAdapter,
    private val onModeChanged: (active: Boolean) -> Unit,
    private val onDeleted: () -> Unit
) {

    /** The glass selection bar; the screen adds it to its root (Gravity.TOP). Hidden until a selection starts. */
    val bar: GlassBar = GlassBar(activity).apply {
        setBackVisible(true) { clear() }
        setBackIcon(R.drawable.gl_ic_close, R.string.gl_cd_exit_selection)
        addAction(R.drawable.gl_ic_select_all, R.string.gl_cd_select_all) { selectAll() }
        addAction(R.drawable.gl_ic_share, R.string.gl_cd_share) { share() }
        addAction(R.drawable.gl_ic_delete, R.string.gl_cd_delete) { delete() }
        visibility = View.GONE
    }

    val dragListener = DragSelectListener(this)

    var active = false
        private set

    /** True from the long press until the finger is lifted (the drag that picks a range). */
    var dragging = false
        private set

    private var selected: Set<String> = emptySet()
    private var busy = false

    private var anchor = -1
    private var lastTo = -1
    private var base: Set<String> = emptySet()
    private var dragAdds = true

    // ── taps ─────────────────────────────────────────────────────────────────

    /** A tap on picture [index] while selecting: pick or drop it. Ends the mode when the last pick is dropped. */
    fun toggle(index: Int) {
        if (busy) return
        val image = adapter.images.getOrNull(index) ?: return
        selected = if (image.path in selected) selected - image.path else selected + image.path
        if (selected.isEmpty()) clear() else push()
    }

    /** A long press on picture [index]: starts selecting, or (already selecting) starts a range drag from it. */
    fun onLongPress(index: Int) {
        if (busy) return
        val image = adapter.images.getOrNull(index) ?: return
        base = selected
        dragAdds = image.path !in base
        selected = if (dragAdds) base + image.path else base - image.path
        anchor = index
        lastTo = index
        dragging = true
        if (!active) {
            active = true
            bar.visibility = View.VISIBLE
            ViewCompat.requestApplyInsets(bar)
            onModeChanged(true)
        }
        push()
    }

    // ── drag ─────────────────────────────────────────────────────────────────

    /** The finger moved over picture [index] (-1 = a header or the gap between pictures: ignored). */
    fun dragTo(index: Int) {
        if (!dragging || index < 0 || index == lastTo) return
        val images = adapter.images
        if (anchor !in images.indices || index !in images.indices) return
        lastTo = index
        val range = HashSet<String>()
        for (i in min(anchor, index)..max(anchor, index)) range.add(images[i].path)
        selected = if (dragAdds) base + range else base - range
        push()
    }

    fun endDrag() {
        if (!dragging) return
        dragging = false
        if (active && selected.isEmpty()) clear()
    }

    // ── bar actions ──────────────────────────────────────────────────────────

    fun selectAll() {
        if (busy || !active) return
        val images = adapter.images
        if (images.isEmpty()) return
        if (selected.size >= images.size) { // everything was picked: a second tap drops all
            clear()
            return
        }
        selected = images.mapTo(LinkedHashSet(images.size)) { it.path }
        push()
    }

    /** Leaves the mode and drops all picks. */
    fun clear() {
        if (busy) return
        val was = active
        active = false
        dragging = false
        selected = emptySet()
        adapter.setSelection(false, emptySet())
        bar.visibility = View.GONE
        if (was) onModeChanged(false)
    }

    private fun share() {
        if (busy) return
        val images = pickedImages()
        if (images.isEmpty()) return
        if (images.size > ImageActions.MAX_SHARE) {
            toast(R.drawable.gl_ic_error, activity.getString(R.string.gl_toast_share_too_many, ImageActions.MAX_SHARE))
            return
        }
        if (!ImageActions.shareMany(activity, images)) {
            toast(R.drawable.gl_ic_error, activity.getString(R.string.gl_toast_share_failed))
        }
    }

    private fun delete() {
        if (busy) return
        val images = pickedImages()
        if (images.isEmpty()) return
        val n = images.size
        GlassConfirm.show(
            activity, R.drawable.gl_ic_delete,
            activity.resources.getQuantityString(R.plurals.gl_delete_many_confirm, n, n),
            activity.getString(R.string.gl_action_cancel)
        ) { runDelete(images) }
    }

    private fun runDelete(images: List<GalleryImage>) {
        if (busy) return
        busy = true
        bar.alpha = 0.5f
        val app = activity.applicationContext
        scope.launch {
            try {
                val result = withContext(Dispatchers.IO) { ImageActions.deleteMany(app, images) }
                busy = false
                bar.alpha = 1f
                if (active) { // the pictures that could not be deleted stay picked
                    selected = selected - result.deleted.toHashSet()
                    if (selected.isEmpty()) clear() else push()
                }
                onDeleted()
                val gone = result.deleted.size
                if (gone > 0) {
                    toast(R.drawable.gl_ic_delete, activity.resources.getQuantityString(R.plurals.gl_toast_deleted_many, gone, gone))
                }
                if (result.failed > 0) {
                    toast(R.drawable.gl_ic_error, activity.getString(R.string.gl_toast_delete_some_failed, result.failed))
                }
            } finally {
                busy = false
                bar.alpha = 1f
            }
        }
    }

    // ── list changes ─────────────────────────────────────────────────────────

    /** The screen rebuilt its grid (search, sort, reload, delete): picks of pictures that are gone are dropped. */
    fun onListChanged() {
        if (!active) return
        val present = HashSet<String>(adapter.images.size * 2)
        for (img in adapter.images) present.add(img.path)
        val keep = selected.filterTo(LinkedHashSet()) { it in present }
        if (keep.size != selected.size) selected = keep
        if (selected.isEmpty()) clear() else push()
    }

    // ── helpers ──────────────────────────────────────────────────────────────

    /** The picked pictures in the order of the grid. */
    private fun pickedImages(): List<GalleryImage> = adapter.images.filter { it.path in selected }

    private fun push() {
        adapter.setSelection(active, selected)
        val n = selected.size
        bar.setTitle(activity.resources.getQuantityString(R.plurals.gl_n_selected, n, n))
    }

    private fun toast(icon: Int, text: String) = GlassToast.show(activity, icon, text)

    /** Picture index under adapter [position] (headers give -1); used by [DragSelectListener]. */
    fun photoIndexAt(position: Int): Int = adapter.photoIndexAt(position)
}
