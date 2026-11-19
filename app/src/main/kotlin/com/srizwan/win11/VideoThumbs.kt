package com.srizwan.win11

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.os.Build
import kotlin.math.abs

// =====================================================================
// VIDEO THUMBNAILS  (step 4.10 - list engine)
//
// A [ThumbDecoder] for video files, registered once in ExplorerUi:
// ThumbLoader.register(VideoThumbDecoder).
//
//  - The picture is one frame taken with MediaMetadataRetriever, about
//    1 second into the video (the very first frame is often black); a
//    video shorter than 2 s uses its middle. OPTION_CLOSEST_SYNC is used
//    because it is much faster than an exact frame.
//  - Android 8.1+ (API 27): getScaledFrameAtTime decodes the frame
//    already at the wanted size, so a 4K video never makes a 4K bitmap.
//    The size of the result is checked; if it does not look right (the
//    rotation / size handling differs between devices) the plain
//    full-size frame is taken and scaled down instead.
//    Android 7.x (API 24 - 26): full frame, then scaled down.
//  - The duration is read in the same pass and stored in
//    ThumbMemory.durations under the same key as the picture; the row /
//    cell / card shows it as a badge in the corner (ThumbSlot).
//  - Same size rule as the images (4.9): short side about edgePx, long
//    side at most 2 x edgePx, never enlarged.
// =====================================================================

internal object VideoThumbDecoder : ThumbDecoder {

    /** `ts` is left out on purpose: in a file manager it is almost always TypeScript. */
    private val EXTS = hashSetOf(
        "mp4", "m4v", "mkv", "webm", "3gp", "3gpp", "3g2", "mov", "avi", "flv", "wmv",
        "mpg", "mpeg", "ogv"
    )

    override fun supports(item: FileItem): Boolean = !item.isDir && item.ext in EXTS

    override fun decode(item: FileItem, edgePx: Int, req: ThumbRequest): Bitmap? {
        if (edgePx <= 0 || item.size <= 0L) return null
        val r = MediaMetadataRetriever()
        try {
            r.setDataSource(item.path)
            if (req.cancelled) return null

            val durationMs = r.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
                ?.toLongOrNull() ?: 0L
            var vw = r.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH)?.toIntOrNull() ?: 0
            var vh = r.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT)?.toIntOrNull() ?: 0
            val rotation = r.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION)
                ?.toIntOrNull() ?: 0
            if (rotation == 90 || rotation == 270) { val t = vw; vw = vh; vh = t }   // size as it is seen

            val timeUs = if (durationMs > 2000L) 1_000_000L else durationMs * 500L   // 1 s, or the middle
            val option = MediaMetadataRetriever.OPTION_CLOSEST_SYNC

            var bmp: Bitmap? = null
            var tw = 0
            var th = 0
            if (vw > 0 && vh > 0) {
                val t = thumbTargetSize(vw, vh, edgePx)
                tw = t[0]; th = t[1]
            }

            // fast path: the frame is decoded at the wanted size
            if (Build.VERSION.SDK_INT >= 27 && tw > 0 && th > 0) {
                val s = try { r.getScaledFrameAtTime(timeUs, option, tw, th) } catch (e: Exception) { null }
                if (s != null) {
                    // sane = same shape as the video, as it is seen (5% tolerance)
                    val want = vw.toFloat() / vh
                    val got = s.width.toFloat() / s.height
                    if (abs(got - want) / want < 0.05f) bmp = s else s.recycle()
                }
            }
            if (req.cancelled) { bmp?.recycle(); return null }

            // plain path: full frame, then scaled down
            if (bmp == null) {
                val full = r.getFrameAtTime(timeUs, option) ?: r.getFrameAtTime() ?: return null
                if (req.cancelled) { full.recycle(); return null }
                val t = thumbTargetSize(full.width, full.height, edgePx)
                bmp = if (full.width > t[0] || full.height > t[1]) {
                    val scaled = try { Bitmap.createScaledBitmap(full, t[0], t[1], true) } catch (e: Exception) { full }
                    if (scaled !== full) full.recycle()
                    scaled
                } else full
            }

            if (durationMs > 0L) ThumbMemory.durations.put(req.key, durationMs)
            return bmp
        } finally {
            try { r.release() } catch (e: Exception) { }
        }
    }
}
