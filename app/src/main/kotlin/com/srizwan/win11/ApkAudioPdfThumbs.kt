package com.srizwan.win11

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.pdf.PdfRenderer
import android.media.MediaMetadataRetriever
import android.os.ParcelFileDescriptor
import java.io.File
import kotlin.math.roundToInt

// =====================================================================
// APK / AUDIO / PDF THUMBNAILS  (step 4.11 - list engine)
//
// Three [ThumbDecoder]s that plug into the 4.8 engine, registered once in
// ExplorerUi (register() ignores a decoder that is already added):
//
//  ApkThumbDecoder    the REAL icon of the APK (PackageManager reads it from the
//                     file, the app does not have to be installed). Drawn into a
//                     square bitmap with a small margin so CENTER_CROP never cuts
//                     the icon. An APK without an icon keeps the file icon.
//  AudioThumbDecoder  the album art embedded in the file (ID3 / MP4 cover) through
//                     MediaMetadataRetriever.embeddedPicture. Decoded with
//                     inSampleSize like images (4.9). A song without cover art
//                     keeps the file icon.
//  PdfThumbDecoder    the FIRST page, rendered by PdfRenderer on a white
//                     background at the wanted size. Encrypted / broken PDFs keep
//                     the file icon.
//
// "Fallback icon" = the decoder returns null: the engine remembers it in
// ThumbMemory.misses (no retry on every scroll) and the row keeps its normal
// file icon. The size rule is the shared [thumbTargetSize] (short side about
// edgePx, long side at most 2 x edgePx, never enlarged except the APK icon,
// which is a vector / density-independent drawable). Every decoder checks
// req.cancelled between its heavy steps.
// =====================================================================

/** The application context for decoders that need a system service (the APK decoder). Set by ExplorerUi. */
internal object ThumbEnv {
    @Volatile var app: Context? = null
}

// ---------------------------------------------------------------------
// APK
// ---------------------------------------------------------------------
internal object ApkThumbDecoder : ThumbDecoder {

    private const val MAX_EDGE = 256          // an icon is never needed bigger than this
    private const val MARGIN = 0.10f          // empty border around the icon (each side)

    override fun supports(item: FileItem): Boolean = !item.isDir && item.ext == "apk"

    override fun decode(item: FileItem, edgePx: Int, req: ThumbRequest): Bitmap? {
        if (edgePx <= 0 || item.size <= 0L) return null
        val ctx = ThumbEnv.app ?: return null
        val pm = ctx.packageManager
        val path = item.path

        @Suppress("DEPRECATION")
        val info = pm.getPackageArchiveInfo(path, 0) ?: return null
        val ai = info.applicationInfo ?: return null
        if (req.cancelled) return null
        if (ai.icon == 0) return null          // no icon in the manifest -> file icon

        // needed so the resources are read from the file and not from an installed copy
        ai.sourceDir = path
        ai.publicSourceDir = path

        val drawable = try { ai.loadIcon(pm) } catch (e: Exception) { null } ?: return null
        if (req.cancelled) return null

        val size = edgePx.coerceIn(16, MAX_EDGE)
        val bmp = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)
        val pad = (size * MARGIN).roundToInt()
        drawable.setBounds(pad, pad, size - pad, size - pad)
        drawable.draw(Canvas(bmp))
        return bmp
    }
}

// ---------------------------------------------------------------------
// AUDIO (album art)
// ---------------------------------------------------------------------
internal object AudioThumbDecoder : ThumbDecoder {

    private val EXTS = hashSetOf(
        "mp3", "m4a", "aac", "flac", "ogg", "oga", "opus", "wav", "wma", "amr", "mka"
    )

    override fun supports(item: FileItem): Boolean = !item.isDir && item.ext in EXTS

    override fun decode(item: FileItem, edgePx: Int, req: ThumbRequest): Bitmap? {
        if (edgePx <= 0 || item.size <= 0L) return null
        val r = MediaMetadataRetriever()
        try {
            r.setDataSource(item.path)
            if (req.cancelled) return null
            val art = r.embeddedPicture ?: return null          // no cover -> file icon
            if (req.cancelled) return null

            // 1. size only
            val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            BitmapFactory.decodeByteArray(art, 0, art.size, bounds)
            val w = bounds.outWidth
            val h = bounds.outHeight
            if (w <= 0 || h <= 0) return null

            // 2. wanted size, 3. biggest power-of-two sample that is still >= the wanted size
            val t = thumbTargetSize(w, h, edgePx)
            val tw = t[0]
            val th = t[1]
            var sample = 1
            while (w / (sample * 2) >= tw && h / (sample * 2) >= th) sample *= 2
            val opts = BitmapFactory.Options().apply {
                inSampleSize = sample
                inPreferredConfig = Bitmap.Config.ARGB_8888
            }
            var bmp = BitmapFactory.decodeByteArray(art, 0, art.size, opts) ?: return null
            if (req.cancelled) { bmp.recycle(); return null }

            // 4. exact size
            if (bmp.width > tw || bmp.height > th) {
                val scaled = try { Bitmap.createScaledBitmap(bmp, tw, th, true) } catch (e: Exception) { bmp }
                if (scaled !== bmp) { bmp.recycle(); bmp = scaled }
            }
            return bmp
        } catch (e: RuntimeException) {
            return null                                           // unreadable / unsupported file
        } finally {
            try { r.release() } catch (e: Exception) { }
        }
    }
}

// ---------------------------------------------------------------------
// PDF (first page)
// ---------------------------------------------------------------------
internal object PdfThumbDecoder : ThumbDecoder {

    /** A huge PDF is skipped: opening it can stall a worker thread for seconds. */
    private const val MAX_BYTES = 300L * 1024 * 1024

    override fun supports(item: FileItem): Boolean = !item.isDir && item.ext == "pdf"

    override fun decode(item: FileItem, edgePx: Int, req: ThumbRequest): Bitmap? {
        if (edgePx <= 0 || item.size <= 0L || item.size > MAX_BYTES) return null
        var pfd: ParcelFileDescriptor? = null
        var renderer: PdfRenderer? = null
        var page: PdfRenderer.Page? = null
        try {
            pfd = ParcelFileDescriptor.open(File(item.path), ParcelFileDescriptor.MODE_READ_ONLY)
            renderer = PdfRenderer(pfd)                           // throws for encrypted / broken files
            if (renderer.pageCount <= 0 || req.cancelled) return null
            page = renderer.openPage(0)
            val pw = page.width
            val ph = page.height
            if (pw <= 0 || ph <= 0 || req.cancelled) return null

            val t = thumbTargetSize(pw, ph, edgePx)
            val bw = t[0]
            val bh = t[1]

            val bmp = Bitmap.createBitmap(bw, bh, Bitmap.Config.ARGB_8888)
            bmp.eraseColor(Color.WHITE)                           // PdfRenderer draws on transparent
            page.render(bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            if (req.cancelled) { bmp.recycle(); return null }
            return bmp
        } catch (e: Exception) {
            return null                                           // password / corrupt -> file icon
        } finally {
            try { page?.close() } catch (e: Exception) { }
            try { renderer?.close() } catch (e: Exception) { }
            try { pfd?.close() } catch (e: Exception) { }
        }
    }
}
