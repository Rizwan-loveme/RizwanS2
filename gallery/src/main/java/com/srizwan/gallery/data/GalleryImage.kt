package com.srizwan.gallery.data

import android.content.ContentUris
import android.net.Uri
import android.provider.MediaStore
import java.io.File

/**
 * One picture of the device.
 *
 * [id] is the MediaStore `_ID`; it is 0 for a file that only the folder scan found (MediaStore does not know it yet),
 * and then [uri] is a `file://` uri. [dateMillis] is the date the picture was taken, else the date the file changed.
 * [width] / [height] are 0 when unknown (folder-scan files, until the viewer decodes them).
 */
data class GalleryImage(
    val id: Long,
    val path: String,
    val name: String,
    val folderPath: String,
    val folderName: String,
    val size: Long,
    val dateMillis: Long,
    val width: Int,
    val height: Int,
    val mime: String
) {
    /** `content://` uri for a MediaStore picture, `file://` for a folder-scan one. */
    val uri: Uri
        get() = if (id > 0L) {
            ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id)
        } else {
            Uri.fromFile(File(path))
        }

    val isGif: Boolean get() = mime == "image/gif"
}

/** A folder that holds pictures: [cover] is its newest picture. */
data class GalleryAlbum(
    val folderPath: String,
    val name: String,
    val count: Int,
    val cover: GalleryImage,
    val newestMillis: Long,
    val totalSize: Long
)

/** The pictures of one calendar day ([epochDay] = days since 1970-01-01 in the device time zone). */
data class DayGroup(
    val epochDay: Long,
    val images: List<GalleryImage>
)
