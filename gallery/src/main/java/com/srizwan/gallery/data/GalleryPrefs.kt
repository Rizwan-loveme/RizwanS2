package com.srizwan.gallery.data

import android.content.Context
import android.content.SharedPreferences

/**
 * The few settings the Gallery remembers (all in one private preferences file, `gallery_prefs`):
 *  - grid columns (2 to 5), "group by date", the last tab (Photos / Albums), the album sort order;
 *  - the favorite pictures, and (step 12) the "favorites only" filter of the home screen;
 *  - the slideshow interval the viewer uses.
 * Every getter clamps what it reads, so a value from an older version or a damaged file can never break a screen. The
 * settings are changed from the home screen's view menu (step 12), the album sort sheet and the viewer.
 */
object GalleryPrefs {

    const val MIN_COLUMNS = 2
    const val MAX_COLUMNS = 5
    const val DEFAULT_COLUMNS = 3

    const val TAB_PHOTOS = 0
    const val TAB_ALBUMS = 1

    private const val FILE = "gallery_prefs"
    private const val KEY_COLUMNS = "columns"
    private const val KEY_GROUP_BY_DATE = "group_by_date"
    private const val KEY_LAST_TAB = "last_tab"
    private const val KEY_ALBUM_SORT = "album_sort"
    private const val KEY_FAVORITES = "favorites"
    private const val KEY_SLIDESHOW_SECONDS = "slideshow_seconds"
    private const val KEY_FAVORITES_ONLY = "favorites_only"

    /** Slideshow intervals the viewer offers, in seconds. */
    val SLIDESHOW_CHOICES: IntArray = intArrayOf(2, 3, 5, 10, 15)
    const val DEFAULT_SLIDESHOW_SECONDS = 3

    private fun prefs(context: Context): SharedPreferences =
        context.applicationContext.getSharedPreferences(FILE, Context.MODE_PRIVATE)

    fun columns(context: Context): Int =
        prefs(context).getInt(KEY_COLUMNS, DEFAULT_COLUMNS).coerceIn(MIN_COLUMNS, MAX_COLUMNS)

    fun setColumns(context: Context, value: Int) {
        prefs(context).edit().putInt(KEY_COLUMNS, value.coerceIn(MIN_COLUMNS, MAX_COLUMNS)).apply()
    }

    fun groupByDate(context: Context): Boolean = prefs(context).getBoolean(KEY_GROUP_BY_DATE, true)

    fun setGroupByDate(context: Context, value: Boolean) {
        prefs(context).edit().putBoolean(KEY_GROUP_BY_DATE, value).apply()
    }

    /** Step 12: the home screen shows only the pictures marked with the heart. */
    fun favoritesOnly(context: Context): Boolean = prefs(context).getBoolean(KEY_FAVORITES_ONLY, false)

    fun setFavoritesOnly(context: Context, value: Boolean) {
        prefs(context).edit().putBoolean(KEY_FAVORITES_ONLY, value).apply()
    }

    fun lastTab(context: Context): Int =
        prefs(context).getInt(KEY_LAST_TAB, TAB_PHOTOS).coerceIn(TAB_PHOTOS, TAB_ALBUMS)

    fun setLastTab(context: Context, value: Int) {
        prefs(context).edit().putInt(KEY_LAST_TAB, value.coerceIn(TAB_PHOTOS, TAB_ALBUMS)).apply()
    }

    /**
     * Sort order of the album screen: 0 newest, 1 oldest, 2 name (A to Z), 3 size (biggest first).
     * Use [albumSort] / [albumSortIndex] to convert.
     */
    fun albumSortIndex(context: Context): Int = prefs(context).getInt(KEY_ALBUM_SORT, 0).coerceIn(0, 3)

    fun setAlbumSortIndex(context: Context, value: Int) {
        prefs(context).edit().putInt(KEY_ALBUM_SORT, value.coerceIn(0, 3)).apply()
    }

    fun albumSort(index: Int): GallerySort = when (index) {
        1 -> GallerySort(SortBy.DATE, ascending = true)
        2 -> GallerySort(SortBy.NAME, ascending = true)
        3 -> GallerySort(SortBy.SIZE, ascending = false)
        else -> GallerySort(SortBy.DATE, ascending = false)
    }

    // ── favorites (step 8): the paths of the pictures marked with the heart, stored on this device only ────────────

    @Synchronized
    fun isFavorite(context: Context, path: String): Boolean =
        prefs(context).getStringSet(KEY_FAVORITES, null)?.contains(path) == true

    /** A copy of the favorite paths (the stored set itself must never be changed in place). */
    @Synchronized
    fun favorites(context: Context): Set<String> =
        HashSet(prefs(context).getStringSet(KEY_FAVORITES, null) ?: emptySet<String>())

    @Synchronized
    fun setFavorite(context: Context, path: String, favorite: Boolean) {
        val set = HashSet(prefs(context).getStringSet(KEY_FAVORITES, null) ?: emptySet<String>())
        val changed = if (favorite) set.add(path) else set.remove(path)
        if (changed) prefs(context).edit().putStringSet(KEY_FAVORITES, set).apply()
    }

    /** A picture was renamed: its heart moves to the new path. */
    @Synchronized
    fun moveFavorite(context: Context, from: String, to: String) {
        val set = HashSet(prefs(context).getStringSet(KEY_FAVORITES, null) ?: emptySet<String>())
        if (set.remove(from)) {
            set.add(to)
            prefs(context).edit().putStringSet(KEY_FAVORITES, set).apply()
        }
    }

    /**
     * Step 12: forgets the hearts of pictures that were deleted by another app. A path is dropped only when its folder
     * is still there but the file is not, so an SD card that is just not mounted keeps its favorites. Blocking (touches
     * the disk): call it off the main thread. Returns how many were dropped.
     */
    @Synchronized
    fun pruneFavorites(context: Context): Int {
        val set = HashSet(prefs(context).getStringSet(KEY_FAVORITES, null) ?: return 0)
        val gone = set.filter { path ->
            val file = java.io.File(path)
            !file.exists() && file.parentFile?.isDirectory == true
        }
        if (gone.isEmpty()) return 0
        set.removeAll(gone.toSet())
        prefs(context).edit().putStringSet(KEY_FAVORITES, set).apply()
        return gone.size
    }

    // ── slideshow (step 8) ───────────────────────────────────────────────────

    fun slideshowSeconds(context: Context): Int {
        val v = prefs(context).getInt(KEY_SLIDESHOW_SECONDS, DEFAULT_SLIDESHOW_SECONDS)
        return if (v in SLIDESHOW_CHOICES) v else DEFAULT_SLIDESHOW_SECONDS
    }

    fun setSlideshowSeconds(context: Context, seconds: Int) {
        prefs(context).edit().putInt(KEY_SLIDESHOW_SECONDS, seconds).apply()
    }
}
