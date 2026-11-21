package com.srizwan.gallery.data

/** What the pictures are ordered by. */
enum class SortBy { DATE, NAME, SIZE }

/** What the albums are ordered by. */
enum class AlbumSortBy { DATE, NAME, COUNT }

/**
 * The sort order of a list of pictures. Default: newest first.
 * [ascending] = true: oldest first, A to Z, smallest first. [ascending] = false: newest first, Z to A, biggest first.
 */
data class GallerySort(
    val by: SortBy = SortBy.DATE,
    val ascending: Boolean = false
) {
    val comparator: Comparator<GalleryImage>
        get() {
            val byName = Comparator<GalleryImage> { a, b -> naturalCompare(a.name, b.name) }
            val base: Comparator<GalleryImage> = when (by) {
                SortBy.DATE -> compareBy<GalleryImage> { it.dateMillis }.then(byName)
                SortBy.NAME -> byName
                SortBy.SIZE -> compareBy<GalleryImage> { it.size }.then(byName)
            }
            return if (ascending) base else base.reversed()
        }
}

/**
 * Compares names the way a person reads them: "IMG_2" before "IMG_10", upper / lower case ignored,
 * leading zeros ignored. Returns <0, 0 or >0.
 */
internal fun naturalCompare(a: String, b: String): Int {
    var i = 0
    var j = 0
    while (i < a.length && j < b.length) {
        val ca = a[i]
        val cb = b[j]
        if (ca.isDigit() && cb.isDigit()) {
            var ei = i
            while (ei < a.length && a[ei].isDigit()) ei++
            var ej = j
            while (ej < b.length && b[ej].isDigit()) ej++
            val na = a.substring(i, ei).trimStart('0')
            val nb = b.substring(j, ej).trimStart('0')
            if (na.length != nb.length) return na.length - nb.length
            val c = na.compareTo(nb)
            if (c != 0) return c
            i = ei
            j = ej
        } else {
            val c = ca.lowercaseChar().compareTo(cb.lowercaseChar())
            if (c != 0) return c
            i++
            j++
        }
    }
    return (a.length - i) - (b.length - j)
}
