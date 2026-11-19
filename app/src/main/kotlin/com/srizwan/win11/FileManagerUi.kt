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

internal fun MainActivity.enterFilePip(videoView: VideoView) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
        Toast.makeText(this, "PiP requires Android 8.0+", Toast.LENGTH_SHORT).show()
        return
    }
    try {
        val builder =
            android.app.PictureInPictureParams.Builder()
                .setAspectRatio(android.util.Rational(16, 9))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            builder.setSeamlessResizeEnabled(true)
        }
        val rect = Rect()
        videoView.getGlobalVisibleRect(rect)
        if (!rect.isEmpty) builder.setSourceRectHint(rect)
        pipVideoView = videoView
        enterPictureInPictureMode(builder.build())
    } catch (e: Exception) {
        Toast.makeText(this, "PiP error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}

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
        file.name.endsWith(".mp4", true) || file.name.endsWith(".mkv", true) ||
                file.name.endsWith(".avi", true) -> playVideo(file)
        file.name.endsWith(".txt", true) -> openTextFile(file)
        file.name.endsWith(".pdf", true) -> openPdfFile(file)
        file.name.endsWith(".zip", true) -> showZipOptions(file)
        isImageFile(file.name) -> openImageFile(file)
        else -> Toast.makeText(this, "Unsupported file", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.isImageFile(name: String): Boolean {
    val lower = name.lowercase()
    return lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") ||
            lower.endsWith(".gif") || lower.endsWith(".bmp") || lower.endsWith(".webp")
}


internal fun MainActivity.loadFiles(dir: File) {
    try {
        if (!dir.exists() || !dir.canRead()) {
            Toast.makeText(this, "Cannot read directory", Toast.LENGTH_SHORT).show()
            return
        }
        currentPath = dir
        val storageRoot = try { Environment.getExternalStorageDirectory() } catch (e: Exception) { File("/storage/emulated/0") }
        val files = try {
            dir.listFiles()
                ?.sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase() }))
                ?: emptyList()
        } catch (e: Exception) { emptyList() }
        val free = try { dir.freeSpace } catch (e: Exception) { 0L }
        val total = try { dir.totalSpace } catch (e: Exception) { 0L }
        explorerUi.show(dir, storageRoot, files, free, total)
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
    if (file.name.endsWith(".pdf", true)) options.add(1, "PDF to JPG")
    if (file.name.endsWith(".zip", true)) options.add(1, "Extract ZIP to DCIM")
    W11Dialog.Builder(this).setTitle(file.name)
        .setItems(options.toTypedArray()) { _, which ->
            when (options[which]) {
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


internal fun MainActivity.playVideo(file: File) {
    try {
        val dialog = Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            dialog.window?.attributes?.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
        dialog.window?.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        @Suppress("DEPRECATION")
        dialog.window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        val rootFrame = FrameLayout(this).apply {
            setBackgroundColor(Color.BLACK)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
        // FIX: Use 'this' (Activity context) for VideoView, not applicationContext
        val videoView = VideoView(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.CENTER
            )
            setVideoPath(file.absolutePath)
            setOnPreparedListener { mp ->
                mp.isLooping = false
                mp.setVideoScalingMode(android.media.MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT)
                start()
            }
            setOnErrorListener { _, _, _ ->
                Toast.makeText(
                    act, "Cannot play this video", Toast.LENGTH_SHORT
                ).show()
                true
            }
        }
        rootFrame.addView(videoView)

        val controlOverlay = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#CC000000"))
            setPadding(dp(8), dp(8), dp(8), dp(16))
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM
            )
            visibility = View.GONE
        }
        pipControlOverlay = controlOverlay

        val topControls = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        val playPauseBtn = Button(this).apply {
            iconOnly(R.drawable.ic_w_pause, 26, Color.WHITE)
            setBackgroundColor(Color.TRANSPARENT)
            setTextColor(Color.WHITE)
            setOnClickListener {
                if (videoView.isPlaying) {
                    videoView.pause(); iconOnly(R.drawable.ic_w_play, 26, Color.WHITE)
                } else {
                    videoView.start(); iconOnly(R.drawable.ic_w_pause, 26, Color.WHITE)
                }
            }
        }
        val seekBar = SeekBar(this).apply {
            layoutParams =
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
        }
        val timeText = TextView(this).apply {
            text = "00:00 / 00:00"
            setTextColor(Color.WHITE)
            textSize = 12f
            setPadding(dp(8), 0, dp(8), 0)
        }
        topControls.addView(playPauseBtn)
        topControls.addView(seekBar)
        topControls.addView(timeText)

        val orientationControls = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setPadding(0, dp(4), 0, dp(4))
        }

        fun makeCtrlBtn(
            label: String,
            color: String = "#333333",
            w: Int = 70,
            icon: Int? = null,
            action: () -> Unit
        ) = Button(this).apply {
            text = label
            if (icon != null) {
                if (label.isEmpty()) iconOnly(icon, 20, Color.WHITE) else iconStart(icon, 16, Color.WHITE, 6)
            }
            textSize = 12f
            setBackgroundColor(Color.parseColor(color))
            setTextColor(Color.WHITE)
            layoutParams =
                LinearLayout.LayoutParams(dp(w), ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    setMargins(dp(4), 0, dp(4), 0)
                }
            setOnClickListener { action() }
        }

        orientationControls.addView(makeCtrlBtn("", icon = R.drawable.ic_w_portrait) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        })
        orientationControls.addView(makeCtrlBtn("", icon = R.drawable.ic_w_landscape) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        })
        orientationControls.addView(makeCtrlBtn("", icon = R.drawable.ic_qs_rotate) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
        })
        val pipBtn = makeCtrlBtn("PiP", "#1565C0", 80, R.drawable.ic_w_pip) {
            enterFilePip(videoView)
        }.apply {
            isEnabled = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
            alpha = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) 1f else 0.4f
        }
        orientationControls.addView(pipBtn)
        orientationControls.addView(makeCtrlBtn("", "#D32F2F", 60, R.drawable.ic_qs_close) {
            try { videoView.stopPlayback() } catch (e: Exception) { }
            pipVideoView = null
            pipControlOverlay = null
            pipHideHandler = null
            pipHideRunnable = null
            dialog.dismiss()
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        })

        controlOverlay.addView(topControls)
        controlOverlay.addView(orientationControls)
        rootFrame.addView(controlOverlay)

        val hideHandler = Handler(Looper.getMainLooper())
        pipHideHandler = hideHandler
        val hideRunnable = Runnable { controlOverlay.visibility = View.GONE }
        pipHideRunnable = hideRunnable

        fun showControlsTemporarily() {
            hideHandler.removeCallbacks(hideRunnable)
            if (!isInPipMode) controlOverlay.visibility = View.VISIBLE
            hideHandler.postDelayed(hideRunnable, 3000L)
        }

        rootFrame.setOnClickListener {
            if (isInPipMode) return@setOnClickListener
            if (controlOverlay.visibility == View.VISIBLE) {
                hideHandler.removeCallbacks(hideRunnable)
                controlOverlay.visibility = View.GONE
            } else {
                showControlsTemporarily()
            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) videoView.seekTo(progress)
            }
            override fun onStartTrackingTouch(sb: SeekBar?) {
                hideHandler.removeCallbacks(hideRunnable)
            }
            override fun onStopTrackingTouch(sb: SeekBar?) { showControlsTemporarily() }
        })

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    try {
                        if (videoView.isPlaying) {
                            val cur = videoView.currentPosition
                            val dur = videoView.duration
                            if (dur > 0) {
                                seekBar.max = dur
                                seekBar.progress = cur
                                timeText.text = "${formatTime(cur)} / ${formatTime(dur)}"
                            }
                        }
                    } catch (e: Exception) { }
                }
            }
        }, 0, 1000)

        dialog.setOnDismissListener {
            timer.cancel()
            hideHandler.removeCallbacks(hideRunnable)
            pipVideoView = null
            pipControlOverlay = null
            pipHideHandler = null
            pipHideRunnable = null
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
        dialog.setContentView(rootFrame)
        dialog.show()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
    } catch (e: Exception) {
        Toast.makeText(this, "Error playing video: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.formatTime(millis: Int): String {
    if (millis < 0) return "00:00"
    val s = millis / 1000; val m = s / 60; val h = m / 60
    return if (h > 0) String.format("%02d:%02d:%02d", h, m % 60, s % 60)
    else String.format("%02d:%02d", m, s % 60)
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


internal fun MainActivity.openImageFile(file: File) {
    try {
        val dialog = Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            dialog.window?.attributes?.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
        val rootFrame = FrameLayout(this).apply { setBackgroundColor(Color.BLACK) }
        val bitmap = loadBitmapSafe(file)
        if (bitmap == null) {
            Toast.makeText(this, "Cannot open image", Toast.LENGTH_SHORT).show()
            return
        }
        val zoomMatrix = Matrix()
        var zoomScale = 1f
        val imageView = ImageView(this).apply {
            scaleType = ImageView.ScaleType.FIT_CENTER
            setImageBitmap(bitmap)
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.CENTER
            )
        }
        val scaleDetector =
            ScaleGestureDetector(this, object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                override fun onScale(d: ScaleGestureDetector): Boolean {
                    zoomScale = (zoomScale * d.scaleFactor).coerceIn(0.5f, 8f)
                    zoomMatrix.setScale(zoomScale, zoomScale, d.focusX, d.focusY)
                    imageView.imageMatrix = zoomMatrix
                    return true
                }
            })
        imageView.setOnTouchListener { v, event ->
            scaleDetector.onTouchEvent(event)
            if (event.action == MotionEvent.ACTION_UP && !scaleDetector.isInProgress) v.performClick()
            true
        }
        rootFrame.addView(imageView)
        val topOverlay = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setBackgroundColor(Color.parseColor("#CC000000"))
            setPadding(dp(12), dp(8), dp(8), dp(8))
            gravity = Gravity.CENTER_VERTICAL
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.TOP
            )
        }
        val infoText = TextView(this).apply {
            text =
                "${file.name}  |  ${bitmap.width}×${bitmap.height}  |  ${getSize(file.length())}"
            setTextColor(Color.WHITE)
            textSize = 12f
            layoutParams =
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f)
            setSingleLine(true)
            ellipsize = android.text.TextUtils.TruncateAt.MIDDLE
        }
        val closeBtn = Button(this).apply {
            iconOnly(R.drawable.ic_qs_close, 18, Color.WHITE)
            setBackgroundColor(Color.parseColor("#D32F2F"))
            layoutParams = LinearLayout.LayoutParams(dp(44), dp(44))
            setPadding(0, 0, 0, 0)
            setOnClickListener { dialog.dismiss() }
        }
        topOverlay.addView(infoText)
        topOverlay.addView(closeBtn)
        rootFrame.addView(topOverlay)
        rootFrame.addView(TextView(this).apply {
            text = "Pinch to zoom"
            setTextColor(Color.parseColor("#AAFFFFFF"))
            textSize = 11f
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#88000000"))
            setPadding(dp(16), dp(6), dp(16), dp(6))
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
            ).apply { setMargins(0, 0, 0, dp(24)) }
        })
        dialog.setContentView(rootFrame)
        dialog.show()
    } catch (e: Exception) {
        Toast.makeText(this, "Image error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}


internal fun MainActivity.loadBitmapSafe(file: File): Bitmap? {
    return try {
        val opts = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(file.absolutePath, opts)
        val max = 2048; var sample = 1
        while ((opts.outWidth / sample) > max || (opts.outHeight / sample) > max) sample *= 2
        BitmapFactory.decodeFile(
            file.absolutePath, BitmapFactory.Options().apply { inSampleSize = sample }
        )
    } catch (e: Exception) { null }
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

