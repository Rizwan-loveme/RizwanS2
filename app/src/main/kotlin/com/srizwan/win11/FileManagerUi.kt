package com.srizwan.win11

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.app.role.RoleManager
import android.app.DownloadManager
import android.app.Notification
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Rect
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.net.Uri
import android.os.*
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings
import android.provider.Telephony
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.telephony.SmsManager
import android.text.format.DateUtils
import android.util.Base64
import android.util.Log
import android.view.*
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.graphics.Typeface
import android.graphics.pdf.PdfRenderer
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.webkit.*
import android.widget.*
import android.widget.VideoView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.zip.ZipInputStream

// File manager and file viewers: text, image, PDF, video, zip (split out of MainActivity).
// All functions are extensions of MainActivity; state lives in MainActivity.

// =====================================================================
// CUSTOM URL SCHEME
// =====================================================================


internal fun MainActivity.createFileManagerView(): LinearLayout {
    explorerUi = ExplorerUi(
        ctx = this,
        onUp = { goUp() },
        onNewFolder = { createNewFolder() },
        onOpenFolder = { loadFiles(it) },
        onItemClick = { openFile(it) },
        onItemMenu = { showFileOptions(it) }
    )
    return explorerUi.root
}


internal fun MainActivity.openFile(file: File) {
    when {
        file.isDirectory -> loadFiles(file)
        isVideoFile(file.name) -> playVideo(file)
        file.name.endsWith(".txt", true) -> openTextFile(file)
        file.name.endsWith(".pdf", true) -> openPdfFile(file)
        file.name.endsWith(".zip", true) -> showZipOptions(file)
        isImageFile(file.name) -> openImageFile(file)
        // .exe .msi .bat .lnk: PC software runs in the built-in Winlator (Wine + Box64)
        WinlatorLauncher.isWindowsProgram(file.name) -> WinlatorLauncher.runFile(this, file)
        else -> Toast.makeText(this, "Unsupported file", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.isImageFile(name: String): Boolean {
    val lower = name.lowercase()
    return lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") ||
            lower.endsWith(".gif") || lower.endsWith(".bmp") || lower.endsWith(".webp") ||
            lower.endsWith(".heic") || lower.endsWith(".heif")
}


internal fun MainActivity.loadFiles(dir: File) {
    try {
        if (!dir.exists() || !dir.canRead()) {
            Toast.makeText(this, "Cannot read directory", Toast.LENGTH_SHORT).show()
            return
        }
        currentPath = dir
        val storageRoot = try { Environment.getExternalStorageDirectory() } catch (e: Exception) { File("/storage/emulated/0") }
        // Step 4.1: listing, sorting and space lookup now run on a background
        // thread inside ExplorerUi.load(); a newer call cancels the older one.
        explorerUi.load(dir, storageRoot)
    } catch (e: Exception) {
        Toast.makeText(this, "Error loading files: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.goUp() {
    try {
        val parent = currentPath.parentFile
        if (parent != null && parent.exists() && parent.canRead()) loadFiles(parent)
    } catch (e: Exception) { }
}


internal fun MainActivity.createNewFolder() {
    val input = EditText(this).glassStyle()
    W11Dialog.Builder(this).setTitle("New Folder").setView(input)
        .setPositiveButton("Create") { _, _ ->
            val name = input.text.toString().trim()
            if (name.isNotEmpty()) {
                if (File(currentPath, name).mkdirs()) {
                    Toast.makeText(this, "Created", Toast.LENGTH_SHORT).show()
                    loadFiles(currentPath)
                } else Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }.setNegativeButton("Cancel", null).show()
}


internal fun MainActivity.showFileOptions(file: File) {
    val options = mutableListOf("Delete", "Rename", "Details")
    if (file.isFile && WinlatorLauncher.isSupported()) {
        if (WinlatorLauncher.isWindowsProgram(file.name)) {
            options.add(0, "Run in container...")
            options.add(0, "Run with Winlator")
        } else options.add(0, "Open with Winlator")
    }
    if (file.name.endsWith(".pdf", true)) options.add(1, "PDF to JPG")
    if (file.name.endsWith(".zip", true)) options.add(1, "Extract ZIP to DCIM")
    W11Dialog.Builder(this).setTitle(file.name)
        .setItems(options.toTypedArray()) { _, which ->
            when (options[which]) {
                "Run with Winlator", "Open with Winlator" -> WinlatorLauncher.runFile(this, file)
                "Run in container..." -> WinlatorLauncher.runFile(this, file, pickContainer = true)
                "Delete" -> deleteFile(file)
                "Rename" -> renameFile(file)
                "PDF to JPG" -> pdfToJpg(file)
                "Extract ZIP to DCIM" -> extractZipToDcim(file)
                "Details" -> showDetails(file)
            }
        }.show()
}


internal fun MainActivity.deleteFile(file: File) {
    W11Dialog.Builder(this).setTitle("Delete?").setMessage("Delete ${file.name}?")
        .setPositiveButton("Yes") { _, _ ->
            if (file.deleteRecursively()) {
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                loadFiles(currentPath)
            } else Toast.makeText(this, "Delete failed", Toast.LENGTH_SHORT).show()
        }.setNegativeButton("No", null).show()
}


internal fun MainActivity.renameFile(file: File) {
    val input = EditText(this).apply { setText(file.name) }.glassStyle()
    W11Dialog.Builder(this).setTitle("Rename").setView(input)
        .setPositiveButton("OK") { _, _ ->
            val newName = input.text.toString().trim()
            if (newName.isNotEmpty() && file.renameTo(File(file.parent, newName))) {
                Toast.makeText(this, "Renamed", Toast.LENGTH_SHORT).show()
                loadFiles(currentPath)
            } else Toast.makeText(this, "Rename failed", Toast.LENGTH_SHORT).show()
        }.setNegativeButton("Cancel", null).show()
}


internal fun MainActivity.showDetails(file: File) {
    W11Dialog.Builder(this).setTitle("Details").setMessage(
        """
            Name: ${file.name}
            Path: ${file.absolutePath}
            Size: ${getSize(file.length())}
            Modified: ${Date(file.lastModified())}
            Readable: ${file.canRead()}
            Writable: ${file.canWrite()}
            """.trimIndent()
    ).setPositiveButton("OK", null).show()
}

// ── ZIP ──────────────────────────────────────────────────────


internal fun MainActivity.showZipOptions(file: File) {
    W11Dialog.Builder(this).setTitle(file.name).setIcon(R.drawable.ic_w_archive)
        .setItems(arrayOf("Extract to DCIM", "Details")) { _, which ->
            when (which) { 0 -> extractZipToDcim(file); 1 -> showDetails(file) }
        }.setNegativeButton("Cancel", null).show()
}


internal fun MainActivity.extractZipToDcim(zipFile: File) {
    val dcimDir = try {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
    } catch (e: Exception) {
        File(Environment.getExternalStorageDirectory(), "DCIM")
    }
    val destRoot = File(dcimDir, zipFile.nameWithoutExtension)
    val progressDialog = W11Dialog.Builder(this).setTitle("Extracting…").setIcon(R.drawable.ic_w_box)
        .setMessage("0 files extracted").setCancelable(false).create()
    progressDialog.show()
    Thread {
        var extracted = 0; var failed = 0
        try {
            destRoot.mkdirs()
            val zis = ZipInputStream(zipFile.inputStream().buffered())
            var entry = zis.nextEntry
            while (entry != null) {
                try {
                    val outFile = File(destRoot, entry.name.replace("..", "_"))
                    if (entry.isDirectory) outFile.mkdirs()
                    else {
                        outFile.parentFile?.mkdirs()
                        FileOutputStream(outFile).use { zis.copyTo(it, 8192) }
                        extracted++
                        val c = extracted
                        runOnUiThread { progressDialog.setMessage("$c files extracted…") }
                    }
                    zis.closeEntry()
                } catch (ex: Exception) {
                    failed++
                    try { zis.closeEntry() } catch (_: Exception) { }
                }
                entry = try { zis.nextEntry } catch (_: Exception) { null }
            }
            zis.close()
            runOnUiThread {
                progressDialog.dismiss()
                val msg =
                    if (failed == 0) "$extracted files extracted to\nDCIM/${zipFile.nameWithoutExtension}"
                    else "$extracted extracted, $failed failed"
                W11Dialog.Builder(this).setTitle("Extraction Complete").setMessage(msg)
                    .setPositiveButton("OK", null).show()
                loadFiles(currentPath)
            }
        } catch (e: Exception) {
            runOnUiThread {
                progressDialog.dismiss()
                Toast.makeText(this, "ZIP error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }.start()
}

// ── Video Player ─────────────────────────────────────────────
// Videos open in the glass video player of the :video module (package com.srizwan.video): the same player as the
// built-in YouTube app (glass controls, gestures, speed, 4K resolution chip, floating popup window, background
// playback, resume). The old VideoView dialog and its picture-in-picture code are gone.

internal fun MainActivity.playVideo(file: File) {
    try {
        // the videos of the same folder (name order) = next / previous and auto-play of the next one
        val around = file.parentFile?.listFiles()
            ?.filter { it.isFile && isVideoFile(it.name) }
            ?.sortedBy { it.name.lowercase() }
            ?.map { it.absolutePath }
            ?: emptyList()
        com.srizwan.video.player.VideoPlayerActivity.start(this, file.absolutePath, file.name, around)
    } catch (e: Throwable) {
        Toast.makeText(this, "Error playing video: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

/** Video files the File Manager opens in the video player (`ts` is left out: it is almost always TypeScript). */
internal fun MainActivity.isVideoFile(name: String): Boolean {
    val ext = name.substringAfterLast('.', "").lowercase()
    return ext in setOf(
        "mp4", "m4v", "mkv", "webm", "3gp", "3gpp", "3g2", "mov", "avi", "flv", "wmv", "mpg", "mpeg", "ogv"
    )
}

// ── Text Viewer ──────────────────────────────────────────────


internal fun MainActivity.openTextFile(file: File) {
    try {
        val fileContent = file.readText()
        val dialog = Dialog(
            this, android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen
        )
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#181B22"))
        }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setBackgroundColor(Color.parseColor("#33FFFFFF"))
            setPadding(dp(8), dp(8), dp(8), dp(8))
            gravity = Gravity.CENTER_VERTICAL
        }
        val titleView = TextView(this).apply {
            this.text = file.name
            setTextColor(Color.WHITE)
            textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            layoutParams =
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            setSingleLine(true)
            ellipsize = android.text.TextUtils.TruncateAt.MIDDLE
        }
        val closeBtn = ImageView(this).apply {
            setImageResource(R.drawable.ic_qs_close)
            setColorFilter(Color.WHITE)
            contentDescription = "Close"
            setPadding(dp(10), dp(10), dp(10), dp(10))
            layoutParams = LinearLayout.LayoutParams(dp(40), dp(40))
            setOnClickListener { dialog.dismiss() }
        }
        val searchBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setBackgroundColor(Color.TRANSPARENT)
            setPadding(dp(10), dp(8), dp(10), dp(8))
            gravity = Gravity.CENTER_VERTICAL
        }
        val glassSearch = GlassSearch(this, "Search in file…", 38)
        val searchInput = glassSearch.edit
        glassSearch.root.layoutParams = LinearLayout.LayoutParams(0, dp(38), 1f)
        val resultCount = TextView(this).apply {
            text = ""
            setTextColor(Color.parseColor("#B3FFFFFF"))
            textSize = 12f
            setPadding(dp(8), 0, dp(8), 0)
        }
        topBar.addView(titleView)
        topBar.addView(closeBtn)
        searchBar.addView(glassSearch.root)
        searchBar.addView(resultCount)
        val infoBar = TextView(this).apply {
            val lines = fileContent.lines().size
            val words = fileContent.trim().split(Regex("\\s+")).size
            this.text =
                "  ${getSize(file.length())}  |  $lines lines  |  $words words"
            setTextColor(Color.parseColor("#B3FFFFFF"))
            iconStart(R.drawable.ic_w_doc, 12, Color.parseColor("#B3FFFFFF"), 4)
            textSize = 11f
            setBackgroundColor(Color.parseColor("#26FFFFFF"))
            setPadding(dp(8), dp(4), dp(8), dp(4))
        }
        val scrollView = ScrollView(this).apply {
            layoutParams =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
        }
        val textView = TextView(this).apply {
            this.text = fileContent
            setPadding(dp(16), dp(16), dp(16), dp(16))
            setTextIsSelectable(true)
            textSize = 14f
            setTextColor(Color.parseColor("#EDEDED"))
            typeface = Typeface.MONOSPACE
        }
        scrollView.addView(textView)
        searchInput.addTextChangedListener(object : android.text.TextWatcher {
            override fun afterTextChanged(s: android.text.Editable?) {
                val q = s.toString().trim()
                if (q.isEmpty()) {
                    textView.text = fileContent; resultCount.text = ""; return
                }
                val span = android.text.SpannableString(fileContent)
                var cnt = 0
                var idx = fileContent.indexOf(q, ignoreCase = true)
                while (idx != -1) {
                    span.setSpan(
                        android.text.style.BackgroundColorSpan(Color.parseColor("#FFEB3B")),
                        idx, idx + q.length,
                        android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    span.setSpan(
                        android.text.style.ForegroundColorSpan(Color.BLACK),
                        idx, idx + q.length,
                        android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    cnt++
                    idx = fileContent.indexOf(q, idx + 1, ignoreCase = true)
                }
                textView.text = span
                resultCount.text = if (cnt > 0) "$cnt found" else "Not found"
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        layout.addView(topBar)
        layout.addView(searchBar)
        layout.addView(infoBar)
        layout.addView(scrollView)
        dialog.setContentView(layout)
        dialog.show()
    } catch (e: Exception) {
        Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

// ── Image Viewer ──────────────────────────────────────────────
// Pictures open in the glass viewer of the :gallery module (package com.srizwan.gallery): swipe left / right through the
// folder, pinch / double-tap zoom, swipe down to close, share / delete / rename / rotate / info / slideshow. The old
// full-screen dialog (one picture, pinch only) and its bitmap loader are gone.

internal fun MainActivity.openImageFile(file: File) {
    try {
        // The pictures of this folder in the File Manager's own order (what the list on screen shows), so swiping moves
        // through them the same way playVideo() hands over the videos around the one that was tapped.
        val shown = shownExplorerFiles()
        val path = file.absolutePath
        val around: List<String> =
            if (shown.any { it.path == path }) {
                shown.filter { !it.isDir && isImageFile(it.name) }.map { it.path }
            } else {
                // not the folder on screen (or nothing shown yet): the folder's pictures in name order
                file.parentFile?.listFiles()
                    ?.filter { it.isFile && isImageFile(it.name) }
                    ?.sortedBy { it.name.lowercase() }
                    ?.map { it.absolutePath }
                    ?: emptyList()
            }
        com.srizwan.gallery.viewer.GalleryViewerActivity.start(this, path, around)
    } catch (e: Throwable) {
        Toast.makeText(this, "Image error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.openPdfFile(file: File) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        Toast.makeText(this, "PDF requires Android 5.0+", Toast.LENGTH_SHORT).show()
        return
    }
    try {
        val pfd = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
        val renderer = PdfRenderer(pfd)
        val pageCount = renderer.pageCount
        if (pageCount == 0) {
            renderer.close()
            Toast.makeText(this, "Empty PDF", Toast.LENGTH_SHORT).show()
            return
        }
        val dialog = Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        val layout = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setBackgroundColor(Color.BLACK)
            setPadding(dp(8), dp(8), dp(8), dp(8))
        }
        val titleText = TextView(this).apply {
            text = "${file.name} - 1/$pageCount"
            setTextColor(Color.WHITE)
            layoutParams =
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        }
        val closeBtn = Button(this).apply {
            iconOnly(R.drawable.ic_qs_close, 20)
            setOnClickListener {
                try { renderer.close() } catch (e: Exception) { }
                dialog.dismiss()
            }
        }
        topBar.addView(titleText)
        topBar.addView(closeBtn)
        val imageView = ImageView(this).apply {
            layoutParams =
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }
        var currentPage = 0
        fun renderPage(n: Int) {
            try {
                val page = renderer.openPage(n)
                val bmp =
                    Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
                page.render(
                    bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY
                )
                imageView.setImageBitmap(bmp)
                titleText.text = "${file.name} - ${n + 1}/$pageCount"
                page.close()
            } catch (e: Exception) {
                Toast.makeText(this, "PDF render error", Toast.LENGTH_SHORT).show()
            }
        }
        renderPage(0)
        imageView.setOnClickListener {
            currentPage = (currentPage + 1) % pageCount
            renderPage(currentPage)
        }
        layout.addView(topBar)
        layout.addView(imageView)
        dialog.setContentView(layout)
        dialog.show()
    } catch (e: Exception) {
        Toast.makeText(this, "PDF Error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.pdfToJpg(file: File) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        Toast.makeText(this, "PDF to JPG requires Android 5.0+", Toast.LENGTH_SHORT).show()
        return
    }
    Thread {
        try {
            val pfd = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
            val renderer = PdfRenderer(pfd)
            val outputDir = File(currentPath, "${file.nameWithoutExtension}_jpg")
            outputDir.mkdirs()
            for (i in 0 until renderer.pageCount) {
                val page = renderer.openPage(i)
                val bmp =
                    Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
                page.render(bmp, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
                FileOutputStream(File(outputDir, "page_${i + 1}.jpg")).use {
                    bmp.compress(Bitmap.CompressFormat.JPEG, 90, it)
                }
                page.close()
            }
            renderer.close()
            runOnUiThread {
                Toast.makeText(
                    act,
                    "Saved to ${outputDir.name}",
                    Toast.LENGTH_SHORT
                ).show()
                loadFiles(currentPath)
            }
        } catch (e: Exception) {
            runOnUiThread {
                Toast.makeText(
                    act, "Error: ${e.message}", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }.start()
}

// =====================================================================
// BROWSER
// =====================================================================

