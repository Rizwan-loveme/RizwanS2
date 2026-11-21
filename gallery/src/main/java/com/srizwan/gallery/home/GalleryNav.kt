package com.srizwan.gallery.home

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.srizwan.gallery.data.GalleryImage
import com.srizwan.gallery.data.GalleryRepository
import com.srizwan.gallery.viewer.GalleryViewerActivity
import kotlin.math.max
import kotlin.math.min

/** Small helpers shared by the home screen (step 5) and the album screen (step 6). */
internal object GalleryNav {

    /** At most this many neighbouring paths go to the viewer, so the intent stays small for huge libraries. */
    private const val NEIGHBOURS = GalleryViewerActivity.MAX_PATHS

    /**
     * Opens the viewer on [images][index] with the neighbouring paths, in the order shown here. When the list was cut to
     * [NEIGHBOURS] and is a straight run of [GalleryRepository.cached] (the home grid), the viewer swipes through the
     * whole shared list (step 7).
     */
    fun openPhoto(activity: Activity, images: List<GalleryImage>, index: Int) {
        if (index !in images.indices) return
        val from = max(0, index - NEIGHBOURS / 2)
        val to = min(images.size, from + NEIGHBOURS)
        GalleryViewerActivity.start(activity, images[index].path, images.subList(from, to).map { it.path })
    }

    /** Date headers (one per calendar day) when [grouped], else a flat list. Keeps the order of [images]. */
    fun buildItems(images: List<GalleryImage>, grouped: Boolean): List<PhotoItem> {
        val out = ArrayList<PhotoItem>(images.size + 64)
        var index = 0
        if (grouped) {
            for (group in GalleryRepository.groupByDay(images)) {
                out.add(PhotoItem.Header(group.epochDay))
                for (img in group.images) out.add(PhotoItem.Photo(img, index++))
            }
        } else {
            for (img in images) out.add(PhotoItem.Photo(img, index++))
        }
        return out
    }

    /** Edge to edge: transparent system bars with light icons; [root] receives the insets. */
    fun edgeToEdge(activity: Activity, root: View) {
        val window = activity.window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= 29) window.isNavigationBarContrastEnforced = false
        WindowInsetsControllerCompat(window, root).apply {
            isAppearanceLightStatusBars = false
            isAppearanceLightNavigationBars = false
        }
    }
}
