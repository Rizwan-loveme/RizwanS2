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


class MainActivity : AppCompatActivity() {

    // Used by the split-out files (BrowserUi.kt, SmsUi.kt, ...): extension functions cannot use ::x.isInitialized
    internal val act: MainActivity get() = this
    internal val backNavIconInit: Boolean get() = ::backNavIcon.isInitialized
    internal val desktopIconInit: Boolean get() = ::desktopIcon.isInitialized
    internal val dlBadgeInit: Boolean get() = ::dlBadge.isInitialized
    internal val downloadsViewInit: Boolean get() = ::downloadsView.isInitialized
    internal val reloadBtnInit: Boolean get() = ::reloadBtn.isInitialized
    internal val rootLayoutInit: Boolean get() = ::rootLayout.isInitialized
    internal val shellInit: Boolean get() = ::shell.isInitialized

    // ── Core layout ──────────────────────────────────────────────
    internal lateinit var rootLayout: LinearLayout
    internal lateinit var tabLayout: LinearLayout
    internal lateinit var contentFrame: FrameLayout
    internal lateinit var shell: Win11Shell
    internal lateinit var desktopView: FrameLayout

    // ── File manager ─────────────────────────────────────────────
    internal lateinit var fileManagerView: LinearLayout
    internal lateinit var explorerUi: ExplorerUi

    /**
     * What the File Manager list shows right now (empty while the File Manager is not built yet). `::explorerUi.isInitialized`
     * only compiles inside this class, so [openImageFile] (an extension function in FileManagerUi.kt) calls this instead.
     */
    internal fun shownExplorerFiles(): List<FileItem> =
        if (::explorerUi.isInitialized) explorerUi.shownFiles() else emptyList()
    internal var currentPath: File = Environment.getExternalStorageDirectory()

    // ── Browser ──────────────────────────────────────────────────
    internal lateinit var browserView: LinearLayout
    internal lateinit var tabContainer: LinearLayout
    internal lateinit var tabScroll: HorizontalScrollView
    internal val webTabs = mutableListOf<WebTab>()
    internal var currentTabIndex = 0
    internal lateinit var urlBar: EditText
    internal lateinit var progressBar: ProgressBar
    internal lateinit var webContainer: FrameLayout
    internal lateinit var downloadsUi: DownloadsUi
    internal lateinit var downloadsView: LinearLayout
    internal lateinit var reloadBtn: TextView
    internal lateinit var backNavIcon: VectorIconView
    internal lateinit var fwdNavIcon: VectorIconView
    internal lateinit var desktopIcon: VectorIconView
    internal lateinit var dlBadge: TextView
    internal var isPageLoading = false
    internal val dlListener: () -> Unit = { updateDownloadBadge() }

    // ── Phone / SMS / Contacts / Flashlight ──────────────────────
    internal lateinit var dialerView: LinearLayout
    internal lateinit var smsView: LinearLayout
    internal var isTorchOn = false
    internal var cameraManager: CameraManager? = null
    internal var cameraId: String? = null

    // ── State flags ───────────────────────────────────────────────
    internal var activeSection = "desktop"
    internal var globalDesktopMode = false

    // ── Fullscreen video ─────────────────────────────────────────
    internal var customView: View? = null
    internal var customViewCallback: WebChromeClient.CustomViewCallback? = null
    internal var originalOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    // ── Prefs ────────────────────────────────────────────────────
    internal lateinit var prefs: SharedPreferences
    internal val KEY_CURRENT_PATH = "current_path"
    internal val KEY_TAB_URLS = "tab_urls"
    internal val KEY_CURRENT_TAB = "current_tab"
    internal val KEY_IS_FILE_MANAGER = "is_file_manager"
    internal val KEY_DESKTOP_MODE = "desktop_mode"

    internal var isUIInitialized = false
    internal var pendingDeepLink: Uri? = null

    // ── Downloads ────────────────────────────────────────────────
    internal val activeDownloads = mutableMapOf<Long, String>()
    internal var downloadReceiver: BroadcastReceiver? = null

    // ── Notification / Chat receiver ─────────────────────────────
    internal var chatReceiver: BroadcastReceiver? = null

    // ── Permissions ──────────────────────────────────────────────
    internal val PERM_CALL = Manifest.permission.CALL_PHONE
    internal val PERM_SMS_R = Manifest.permission.READ_SMS
    internal val PERM_SMS_S = Manifest.permission.SEND_SMS
    internal val PERM_SMS_R2 = Manifest.permission.RECEIVE_SMS
    internal val PERM_CONTACTS = Manifest.permission.READ_CONTACTS

    internal val REQ_CALL = 201
    internal val REQ_SMS = 202
    internal val REQ_CONTACTS = 203

    internal var fileUploadCallback: ValueCallback<Array<Uri>>? = null
    internal val fileChooserLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val cb = fileUploadCallback ?: return@registerForActivityResult
            fileUploadCallback = null
            val results =
                if (result.resultCode == Activity.RESULT_OK && result.data?.data != null)
                    arrayOf(result.data!!.data!!)
                else null
            cb.onReceiveValue(results)
        }

    internal val storagePermissionLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (!Environment.isExternalStorageManager())
                    Toast.makeText(this, "Storage permission required", Toast.LENGTH_SHORT).show()
            }
            initUI()
        }

    internal val defaultLauncherLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (isDefaultLauncher()) {
                Toast.makeText(this, "Win11 is now your default launcher", Toast.LENGTH_SHORT).show()
            }
        }

    internal val notificationAccessLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (WhatsAppNotificationListener.isEnabled(this)) {
                Toast.makeText(
                    this, "নোটিফিকেশন অ্যাক্সেস চালু হয়েছে", Toast.LENGTH_SHORT
                ).show()
                registerChatReceiver()
            }
        }

    // =====================================================================
    // LIFECYCLE
    // =====================================================================

    // ── Debug helpers (log + never let one failing step kill the whole app) ──
    internal val LOGT = "Main"

    internal fun <T> guard(step: String, block: () -> T): T? = try {
        AppLog.d(LOGT, "> $step")
        block()
    } catch (e: Throwable) {
        AppLog.e(LOGT, "X $step FAILED", e)
        null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppLog.i(LOGT, "onCreate (savedState=${savedInstanceState != null}, API ${Build.VERSION.SDK_INT})")
        try { supportActionBar?.hide() } catch (e: Exception) { }
        prefs = getSharedPreferences("app_state", MODE_PRIVATE)
        guard("DlEngine.init") { DlEngine.init(applicationContext) }
        globalDesktopMode = guard("read prefs") { prefs.getBoolean(KEY_DESKTOP_MODE, false) } ?: false
        guard("initCamera") { initCamera() }
        val permOk = guard("checkPermissionAndShowDialog") { checkPermissionAndShowDialog() }
        if (permOk == null && !isUIInitialized) {
            // The permission step itself threw: still try to bring the UI up.
            guard("initUI (fallback after permission step)") { initUI() }
        }
        guard("default launcher request") {
            if (!isDefaultLauncher() && !prefs.getBoolean("asked_default_launcher", false)) {
                prefs.edit().putBoolean("asked_default_launcher", true).apply()
                requestDefaultLauncher()
            }
            Unit
        }
        guard("show previous crash") { showLastCrashIfAny() }
        guard("deep link (cold start)") {
            val d = intent?.data
            if (intent?.action == Intent.ACTION_VIEW && d?.scheme == "rizwans2") handleDeepLink(d)
            handleSendTo(intent)
            Unit
        }
    }

    /** If the previous run crashed, show it in a dialog (full text, Copy / Open log). */
    internal fun showLastCrashIfAny() {
        val crash = AppLog.takeLastCrash() ?: return
        AppLog.w(LOGT, "previous run crashed:\n$crash")
        showErrorDialog("App crashed last time", crash, null)
    }

    /** Error dialog: scrollable stack text + Copy / Open log / (Retry) / Close buttons. */
    internal fun showErrorDialog(title: String, text: String, onRetry: (() -> Unit)?) {
        try {
            val box = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
            val sv = ScrollView(this)
            sv.addView(TextView(this).apply {
                this.text = text
                setTextColor(Color.rgb(200, 255, 200))
                typeface = Typeface.MONOSPACE
                textSize = 10f
                setTextIsSelectable(true)
                setPadding(8, 8, 8, 8)
            })
            box.addView(sv, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f))
            val row = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
            var dlg: Dialog? = null
            fun addBtn(label: String, action: () -> Unit) {
                row.addView(Button(this).apply {
                    this.text = label
                    textSize = 11f
                    setOnClickListener {
                        try { action() } catch (t: Throwable) { AppLog.e(LOGT, "dialog button $label failed", t) }
                    }
                }, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            }
            addBtn("Copy") {
                val cm = getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
                cm.setPrimaryClip(android.content.ClipData.newPlainText("Win11 error", text))
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
            }
            addBtn("Open log") { startActivity(Intent(this, DebugLogActivity::class.java)) }
            if (onRetry != null) addBtn("Retry") { dlg?.dismiss(); onRetry() }
            addBtn("Close") { dlg?.dismiss() }
            box.addView(row)
            val h = (resources.displayMetrics.heightPixels * 0.6f).toInt()
            box.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, h)
            dlg = W11Dialog.Builder(this).setTitle(title).setView(box).setCancelable(true).show()
        } catch (t: Throwable) {
            AppLog.e(LOGT, "showErrorDialog failed", t)
            try {
                W11Dialog.Builder(this)
                    .setTitle(title).setMessage(text.take(1500)).setPositiveButton("OK", null).show()
            } catch (_: Throwable) { }
        }
    }

    override fun onStart() {
        super.onStart()
        AppLog.d(LOGT, "onStart")
        guard("notification access check") {
            if (!WhatsAppNotificationListener.isEnabled(this)) requestNotificationAccess()
            else registerChatReceiver()
        }
        guard("realtime SMS") {
            registerSmsLive()
            if (isUIInitialized) smsUpdateRoleBanner()
            // came back from the background: catch up on anything that arrived meanwhile
            if (isUIInitialized && activeSection == "sms") smsLiveSoon(100)
        }
    }

    override fun onStop() {
        super.onStop()
        AppLog.d(LOGT, "onStop")
        unregisterChatReceiver()
        unregisterSmsLive()
    }

    override fun onPause() {
        super.onPause()
        AppLog.d(LOGT, "onPause")
        saveState()
        webTabs.forEach { try { it.webView.onPause() } catch (e: Exception) { } }
    }

    override fun onResume() {
        super.onResume()
        AppLog.d(LOGT, "onResume (uiReady=$isUIInitialized)")
        if (isUIInitialized) ViewCompat.requestApplyInsets(rootLayout)
        webTabs.getOrNull(currentTabIndex)?.let {
            try { it.webView.onResume() } catch (e: Exception) { }
        }
        if (isUIInitialized) tabLayout.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        AppLog.i(LOGT, "onDestroy (finishing=$isFinishing)")
        try { if (::shell.isInitialized) shell.stopClock() } catch (e: Exception) { }
        try { if (::explorerUi.isInitialized) explorerUi.destroy() } catch (e: Exception) { }
        try {
            saveState()
            webTabs.forEach {
                try { it.webView.stopLoading(); it.webView.destroy() } catch (e: Exception) { }
            }
            webTabs.clear()
        } catch (e: Exception) { }
        try {
            downloadReceiver?.let { unregisterReceiver(it) }
            downloadReceiver = null
        } catch (e: Exception) { }
        unregisterChatReceiver()
        unregisterSmsLive()
        try { DlEngine.removeListener(dlListener); if (::downloadsUi.isInitialized) downloadsUi.onHide() } catch (e: Exception) { }
        try {
            smsSearchRunnable?.let { smsMain.removeCallbacks(it) }
            smsExec.shutdownNow()
        } catch (e: Exception) { }
        releaseTorch()
        super.onDestroy()
    }

    // 4.15.4: the manifest lists orientation | screenSize | smallestScreenSize | screenLayout | uiMode, so
    // rotation, split-screen, fold and dark / light do NOT recreate this Activity (the open folder, scroll
    // position, view mode and a running load stay). Views follow by themselves: ExplorerUi listens to the
    // layout change of its list (columns, skeleton, thumb bar), all colours are fixed (WX), nothing to do here.
    override fun onConfigurationChanged(newConfig: android.content.res.Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    // =====================================================================
    // DEFAULT LAUNCHER SETUP
    // =====================================================================

    internal fun isDefaultLauncher(): Boolean {
        val intent = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME)
        val info = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return info?.activityInfo?.packageName == packageName
    }

    internal fun requestDefaultLauncher() {
        if (isDefaultLauncher()) return
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val rm = getSystemService(Context.ROLE_SERVICE) as RoleManager
                if (rm.isRoleAvailable(RoleManager.ROLE_HOME) && !rm.isRoleHeld(RoleManager.ROLE_HOME)) {
                    defaultLauncherLauncher.launch(rm.createRequestRoleIntent(RoleManager.ROLE_HOME))
                    return
                }
            }
            defaultLauncherLauncher.launch(Intent(Settings.ACTION_HOME_SETTINGS))
        } catch (e: Exception) {
            try {
                defaultLauncherLauncher.launch(Intent(Settings.ACTION_SETTINGS))
            } catch (e2: Exception) { }
        }
    }

    // =====================================================================
    // CAMERA / FLASHLIGHT
    // =====================================================================

    internal fun initCamera() {
        try {
            cameraManager = getSystemService(Context.CAMERA_SERVICE) as? CameraManager
            cameraId = cameraManager?.cameraIdList?.firstOrNull { id ->
                cameraManager!!.getCameraCharacteristics(id)
                    .get(android.hardware.camera2.CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
            }
        } catch (e: Exception) {
            Log.e("Torch", "initCamera error: ${e.message}")
        }
    }

    internal fun toggleTorch(btn: Button?) {
        if (cameraManager == null || cameraId == null) {
            Toast.makeText(this, "Flashlight not available", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            isTorchOn = !isTorchOn
            cameraManager!!.setTorchMode(cameraId!!, isTorchOn)
            btn?.text = if (isTorchOn) "OFF" else "ON"
            btn?.iconStart(R.drawable.ic_qs_flashlight, 18, Color.WHITE, 6)
            btn?.setBackgroundColor(
                if (isTorchOn) Color.parseColor("#FFC107") else Color.parseColor("#444444")
            )
        } catch (e: CameraAccessException) {
            Toast.makeText(this, "Torch error: ${e.message}", Toast.LENGTH_SHORT).show()
            isTorchOn = false
        } catch (e: Exception) {
            Toast.makeText(this, "Torch error: ${e.message}", Toast.LENGTH_SHORT).show()
            isTorchOn = false
        }
    }

    internal fun releaseTorch() {
        try {
            if (isTorchOn && cameraId != null) {
                cameraManager?.setTorchMode(cameraId!!, false)
                isTorchOn = false
            }
        } catch (e: Exception) { }
    }

    // =====================================================================
    // NOTIFICATION SYSTEM
    // =====================================================================

    internal fun requestNotificationAccess() {
        W11Dialog.Builder(this)
            .setTitle("Notification Access")
            .setMessage("সব অ্যাপের নোটিফিকেশন পপআপ (WhatsApp, Messenger, Gmail ইত্যাদি) দেখাতে হলে Notification Access অনুমতি দিতে হবে।\n\nSettings → Notification Access → এই অ্যাপ চালু করুন।")
            .setPositiveButton("Settings খুলুন") { _, _ ->
                try {
                    notificationAccessLauncher.launch(
                        Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
                    )
                } catch (e: Exception) {
                    Toast.makeText(this, "Settings খুলতে পারেনি", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("এখন না", null).show()
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    internal fun registerChatReceiver() {
        if (chatReceiver != null) return
        WhatsAppNotificationListener.appVisible = true
        chatReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val sender =
                    intent?.getStringExtra(WhatsAppNotificationListener.EXTRA_SENDER) ?: return
                val message =
                    intent.getStringExtra(WhatsAppNotificationListener.EXTRA_MESSAGE) ?: ""
                val app =
                    intent.getStringExtra(WhatsAppNotificationListener.EXTRA_APP) ?: "Message"
                val pkg = intent.getStringExtra(WhatsAppNotificationListener.EXTRA_PKG)
                showChatToast(sender, message, app, pkg)
                // sound / vibration follow the Ring - Vibrate - Mute button
                NotifPrefs.feedback(this@MainActivity, pkg)
            }
        }
        val filter = IntentFilter(WhatsAppNotificationListener.ACTION_CHAT_MESSAGE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(chatReceiver, filter, RECEIVER_NOT_EXPORTED)
        } else {
            @Suppress("UnspecifiedRegisterReceiverFlag")
            registerReceiver(chatReceiver, filter)
        }
    }

    internal fun unregisterChatReceiver() {
        try { chatReceiver?.let { unregisterReceiver(it) } } catch (e: Exception) { }
        chatReceiver = null
        WhatsAppNotificationListener.appVisible = false
    }

    // Win11 style glass toast card (vector icons only, no emoji); see GlassToast.kt.
    internal fun showChatToast(sender: String, message: String, app: String, pkg: String? = null) {
        runOnUiThread {
            try {
                val displayMsg = if (message.length > 120) message.substring(0, 120) + "\u2026" else message
                GlassToast.show(this, pkg, app, sender, displayMsg)
            } catch (e: Exception) {
                Toast.makeText(this, "$app: $sender - $message", Toast.LENGTH_LONG).show()
            }
        }
    }

    internal fun playSystemNotificationSound() {
        try {
            val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext, uri)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ringtone.audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()
            }
            ringtone.play()
        } catch (e: Exception) { }
    }

    // =====================================================================
    // PERMISSION & INIT
    // =====================================================================

    internal fun checkPermissionAndShowDialog() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                try {
                    storagePermissionLauncher.launch(
                        Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION).apply {
                            data = Uri.parse("package:$packageName")
                        }
                    )
                } catch (e: Exception) {
                    initUI()
                }
            } else {
                initUI()
            }
        } else {
            val r = ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE
            )
            val w = ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            if (r != PackageManager.PERMISSION_GRANTED || w != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ),
                    100
                )
            } else {
                initUI()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            100 -> initUI()
            REQ_CALL -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Call permission granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Call permission denied", Toast.LENGTH_SHORT).show()
                }
            }
            REQ_SMS -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    refreshSmsView()
                } else {
                    Toast.makeText(this, "SMS permission denied", Toast.LENGTH_SHORT).show()
                }
            }
            REQ_CONTACTS -> { /* refreshed on next open */ }
        }
    }

    /** Builds the UI. If anything fails: log it and show an on-screen error page (with log + retry). */
    internal fun initUI() {
        if (isUIInitialized) return
        AppLog.i(LOGT, "initUI: begin")
        try {
            buildUi()
            AppLog.i(LOGT, "initUI: done")
        } catch (e: Throwable) {
            AppLog.e(LOGT, "initUI: FAILED", e)
            isUIInitialized = false
            showStartupError(e)
        }
    }

    internal fun showStartupError(e: Throwable) {
        try {
            setContentView(FrameLayout(this).apply { setBackgroundColor(Color.parseColor("#202020")) })
        } catch (t: Throwable) {
            AppLog.e(LOGT, "showStartupError: blank view failed", t)
        }
        showErrorDialog("Startup error", AppLog.deviceInfo() + "\n\n" + AppLog.stack(e)) {
            AppLog.i(LOGT, "retry initUI")
            initUI()
        }
    }

    /** One screen of the app: if its builder throws, show a small error panel instead of crashing. */
    internal fun safeSection(name: String, block: () -> LinearLayout): LinearLayout = try {
        AppLog.d(LOGT, "build section: $name")
        block()
    } catch (e: Throwable) {
        AppLog.e(LOGT, "build section '$name' FAILED", e)
        LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#202020"))
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
            )
            visibility = View.GONE
            addView(TextView(this@MainActivity).apply {
                text = "$name could not load\n${e.javaClass.simpleName}: ${e.message}\n\n(see Quick Settings → Debug log)"
                setCompoundDrawables(null, Ico.drawable(this@MainActivity, R.drawable.ic_w_warning, 32, Color.rgb(255, 193, 7)), null, null)
                compoundDrawablePadding = 16
                setTextColor(Color.WHITE)
                gravity = Gravity.CENTER
                setPadding(32, 32, 32, 32)
            })
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    internal fun buildUi() {
        if (isUIInitialized) return
        isUIInitialized = true

        currentPath = try {
            Environment.getExternalStorageDirectory().takeIf { it.exists() && it.canRead() }
                ?: filesDir
        } catch (e: Exception) { filesDir }

        rootLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            setBackgroundColor(Color.TRANSPARENT) // glass: the wallpaper shows behind the taskbar
        }

        // ── Win11 taskbar (bottom) ── ──────────────────────────────────────
        shell = Win11Shell(this) { section ->
            if (section == "start") {
                shell.toggleStart()
            } else {
                shell.closeStart(animated = false)
                if (section == "notifications") {
                    startActivity(Intent(this, NotificationSettingsActivity::class.java))
                } else if (section == "dialer") {
                    openSystemDialer()
                } else if (section == "calculator") {
                    try { startActivity(Intent(this, CalculatorActivity::class.java)) }
                    catch (e: Throwable) { AppLog.e(LOGT, "cannot open CalculatorActivity", e) }
                } else if (section == WinlatorLauncher.SECTION) {
                    WinlatorLauncher.open(this)
                } else if (section == "youtube") {
                    try { startActivity(Intent(this, com.srizwan.YouTube.YouTubeActivity::class.java)) }
                    catch (e: Throwable) { AppLog.e(LOGT, "cannot open YouTubeActivity", e) }
                } else if (section == "video") {
                    try { startActivity(Intent(this, com.srizwan.video.home.VideoHomeActivity::class.java)) }
                    catch (e: Throwable) { AppLog.e(LOGT, "cannot open VideoHomeActivity", e) }
                } else if (section == "gallery") {
                    try { startActivity(Intent(this, com.srizwan.gallery.home.GalleryHomeActivity::class.java)) }
                    catch (e: Throwable) { AppLog.e(LOGT, "cannot open GalleryHomeActivity", e) }
                } else if (section == "parallel") {
                    try { startActivity(Intent(this, com.srizwan.win11.parallel.ParallelActivity::class.java)) }
                    catch (e: Throwable) { AppLog.e(LOGT, "cannot open ParallelActivity", e) }
                } else {
                    switchToSection(section)
                }
            }
        }
        // Win11 behaviour: tapping the already-active taskbar app minimizes it (back to the desktop).
        shell.onMinimize = {
            AppLog.i(LOGT, "taskbar toggle: minimize $activeSection")
            shell.closeStart(animated = false)
            switchToSection("desktop")
        }
        shell.onQuick = {
            AppLog.i(LOGT, "open QuickControlsActivity")
            try { startActivity(Intent(this@MainActivity, QuickControlsActivity::class.java)) }
            catch (e: Throwable) { AppLog.e(LOGT, "cannot open QuickControlsActivity", e) }
        }
        tabLayout = shell.buildTaskbar()
        desktopView = shell.buildDesktop()

        contentFrame = FrameLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f
            )
            setBackgroundColor(Color.parseColor("#202020"))
        }

        fileManagerView = safeSection("Files") { createFileManagerView() }
        browserView = safeSection("Browser") { createBrowserView() }
        dialerView = safeSection("Phone") { createDialerView() }
        smsView = safeSection("Messages") { createSmsView() }

        contentFrame.addView(desktopView)
        contentFrame.addView(fileManagerView)
        contentFrame.addView(browserView)
        contentFrame.addView(dialerView)
        contentFrame.addView(smsView)
        downloadsUi = DownloadsUi(
            ctx = this,
            onBack = { hideDownloads() },
            onOpen = { openDownloaded(it) },
            onShowFolder = { showDownloadsFolder() },
            onCopyLink = { copyText(it) }
        )
        downloadsView = downloadsUi.root
        contentFrame.addView(downloadsView)
        DlEngine.addListener(dlListener)
        contentFrame.addView(shell.buildStartPanel()) // Start menu overlay (must stay last)

        rootLayout.addView(contentFrame)
        rootLayout.addView(tabLayout)
        // Glass: wallpaper bloom behind everything, so the translucent taskbar / Start menu look frosted.
        val glassRoot = FrameLayout(this)
        glassRoot.addView(BloomView(this), FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
        glassRoot.addView(rootLayout)
        setContentView(glassRoot)

        // ── System bar insets (status bar / cutout / nav bar / keyboard) ──
        // Works for edge-to-edge (Android 15+) and older versions alike, so
        // no screen can ever draw underneath the status bar.
        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { v, insets ->
            val bars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            val ime = insets.getInsets(WindowInsetsCompat.Type.ime())
            @Suppress("DEPRECATION")
            val legacyBottom = insets.toWindowInsets()?.systemWindowInsetBottom ?: 0
            v.setPadding(
                bars.left, bars.top, bars.right,
                maxOf(bars.bottom, ime.bottom, legacyBottom)
            )
            WindowInsetsCompat.CONSUMED
        }
        try {
            @Suppress("DEPRECATION")
            window.statusBarColor = Color.parseColor("#202020")
            @Suppress("DEPRECATION")
            window.navigationBarColor = Color.parseColor("#202020")
            // dark bars → light (white) icons
            WindowCompat.getInsetsController(window, rootLayout).apply {
                isAppearanceLightStatusBars = false
                isAppearanceLightNavigationBars = false
            }
        } catch (e: Exception) { }
        ViewCompat.requestApplyInsets(rootLayout)
        shell.startClock()
        restoreState()
    }

    internal fun restoreState() {
        try {
            val savedPath = prefs.getString(KEY_CURRENT_PATH, null)
            if (savedPath != null) {
                val dir = File(savedPath)
                if (dir.exists() && dir.isDirectory && dir.canRead()) currentPath = dir
            }
        } catch (e: Exception) { }
        loadFiles(currentPath)

        try {
            val tabUrls = prefs.getStringSet(KEY_TAB_URLS, null)
            if (!tabUrls.isNullOrEmpty()) {
                tabUrls.forEach { url -> if (url.isNotEmpty()) addNewTab(url, switch = false) }
            }
        } catch (e: Exception) { }

        if (webTabs.isEmpty()) addNewTab("https://www.google.com", switch = true)
        else {
            val savedIdx = prefs.getInt(KEY_CURRENT_TAB, 0)
            currentTabIndex = savedIdx.coerceIn(0, webTabs.size - 1)
            switchTab(currentTabIndex)
        }

        val savedIsFileManager = prefs.getBoolean(KEY_IS_FILE_MANAGER, true)
        switchToSection("desktop")

        // A rizwans2:// link that arrived before the UI was ready.
        pendingDeepLink?.let { pendingDeepLink = null; handleDeepLink(it) }
        pendingSendTo?.let { pendingSendTo = null; handleSendTo(it) }
    }

    /**
     * The number in a link like rizwans2://3, rizwans2://#3 or rizwans2://app/3 (1 = the first app of the Start menu's "All apps"
     * list), or null when the link carries no number.
     */
    private fun deepLinkNumber(uri: Uri): Int? {
        val host = (uri.host ?: "").lowercase()
        val text = when {
            host.isNotEmpty() && host.all { it.isDigit() } -> host
            host == "app" -> uri.pathSegments.firstOrNull()?.trim()
            host.isEmpty() -> uri.fragment?.trim()
            else -> null
        }
        return text?.takeIf { it.isNotEmpty() && it.length <= 6 && it.all { c -> c.isDigit() } }?.toIntOrNull()
    }

    /** Opens app number [n] (1-based) of the Start menu's "All apps" list. Out of range: nothing opens, nothing crashes. */
    private fun launchAppNumber(n: Int, retry: Boolean = true) {
        val list = shell.allAppsInOrder()
        if (list.isEmpty() && retry) {
            // the app list is still loading (cold start): load it, then try once more
            shell.appRepo.load { launchAppNumber(n, retry = false) }
            return
        }
        val entry = list.getOrNull(n - 1)
        if (entry == null) {
            AppLog.w(LOGT, "deep link: no app number $n (the list has ${list.size})")
            return
        }
        shell.launchApp(entry)
    }

    /**
     * rizwans2://open | files | browser | dialer | sms | winlator | youtube | video | gallery | start | quick  (anything else just opens the launcher).
     * Numbers: rizwans2://1, rizwans2://#1 and rizwans2://app/1 open app number 1 of the Start menu's "All apps" list (as shown on screen).
     */
    internal fun handleDeepLink(uri: Uri) {
        AppLog.i(LOGT, "deep link: $uri")
        if (!isUIInitialized || !::shell.isInitialized) { pendingDeepLink = uri; return }
        try {
            val number = deepLinkNumber(uri)
            if (number != null) { launchAppNumber(number); return }
            when ((uri.host ?: "").lowercase()) {
                "files", "browser", "dialer", "sms" -> {
                    shell.closeStart(animated = false)
                    switchToSection(uri.host!!.lowercase())
                }
                "start" -> { switchToSection("desktop"); shell.openStart() }
                "quick" -> shell.onQuick?.invoke()
                "calculator", "calc" -> startActivity(Intent(this, CalculatorActivity::class.java))
                "winlator" -> WinlatorLauncher.open(this)
                "parallel" -> startActivity(Intent(this, com.srizwan.win11.parallel.ParallelActivity::class.java))
                "youtube" -> startActivity(Intent(this, com.srizwan.YouTube.YouTubeActivity::class.java))
                "video" -> startActivity(Intent(this, com.srizwan.video.home.VideoHomeActivity::class.java))
                "gallery" -> startActivity(Intent(this, com.srizwan.gallery.home.GalleryHomeActivity::class.java))
                else -> { // "open" and anything unknown
                    if (shell.isStartOpen()) shell.closeStart()
                    switchToSection("desktop")
                }
            }
        } catch (e: Throwable) { AppLog.e(LOGT, "deep link failed", e) }
    }

    /** Phone uses the system dialer app (the built-in Phone screen is hidden). Optional number is pre-filled. */
    internal fun openSystemDialer(number: String? = null) {
        try {
            val i = Intent(Intent.ACTION_DIAL).apply {
                if (!number.isNullOrBlank()) data = Uri.fromParts("tel", number.trim(), null)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(i)
        } catch (e: Throwable) {
            AppLog.e(LOGT, "cannot open the system dialer", e)
            Toast.makeText(this, "No phone app found", Toast.LENGTH_SHORT).show()
        }
    }

    internal fun switchToSection(section: String) {
        if (section == "dialer") { openSystemDialer(); return } // built-in Phone is hidden
        val target = if (section == "start") "desktop" else section
        activeSection = target
        // Phone / Messages are glass screens: let the wallpaper bloom show through them.
        contentFrame.setBackgroundColor(
            if (target == "dialer" || target == "sms") Color.TRANSPARENT else Color.parseColor("#202020")
        )
        desktopView.visibility = View.GONE
        fileManagerView.visibility = View.GONE
        browserView.visibility = View.GONE
        dialerView.visibility = View.GONE
        smsView.visibility = View.GONE
        hideDownloads()

        when (target) {
            "desktop" -> {
                desktopView.visibility = View.VISIBLE
                shell.setActive("desktop")
            }
            "files" -> {
                fileManagerView.visibility = View.VISIBLE
                highlightTab(0)
            }
            "browser" -> {
                browserView.visibility = View.VISIBLE
                highlightTab(1)
                if (currentTabIndex in webTabs.indices) {
                    try { webTabs[currentTabIndex].webView.onResume() } catch (e: Exception) { }
                }
            }
            "dialer" -> {
                dialerView.visibility = View.VISIBLE
                highlightTab(2)
            }
            "sms" -> {
                smsView.visibility = View.VISIBLE
                highlightTab(3)
                refreshSmsView()
            }
        }
    }

    internal fun highlightTab(activeIndex: Int) {
        val names = arrayOf("files", "browser", "dialer", "sms")
        shell.setActive(names.getOrElse(activeIndex) { "desktop" })
    }

    internal var dialInput: EditText? = null
    internal var torchBtn: Button? = null

    // ── Glass helpers (Dialer / Messages) ──────────────────────────────
    internal val GLASS_BAR = Color.argb(110, 20, 24, 34)
    internal val GLASS_FILL = Color.argb(64, 255, 255, 255)
    internal val GLASS_FILL_STRONG = Color.argb(84, 255, 255, 255)

    /** Rounded translucent card with the thin light glass border. */
    internal fun glassCard(fill: Int, radiusDp: Int): android.graphics.drawable.GradientDrawable =
        android.graphics.drawable.GradientDrawable().apply {
            setColor(fill)
            cornerRadius = dp(radiusDp).toFloat()
            setStroke(dp(1), Color.argb(28, 255, 255, 255))
        }

    /** Glass button: translucent rounded fill + ripple, no Material elevation / shadow. */
    internal fun Button.glass(fill: Int, radiusDp: Int = 8) {
        val mask = android.graphics.drawable.GradientDrawable().apply {
            setColor(Color.WHITE); cornerRadius = dp(radiusDp).toFloat()
        }
        background = android.graphics.drawable.RippleDrawable(
            android.content.res.ColorStateList.valueOf(Color.argb(70, 255, 255, 255)),
            glassCard(fill, radiusDp), mask
        )
        stateListAnimator = null
    }

    internal var smsSearchEdit: EditText? = null
    internal var smsRoleBanner: TextView? = null
    internal var pendingSendTo: Intent? = null
    internal val smsRoleLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { smsRoleChanged() }

    // PC-style two-pane state (list on the left, thread on the right)
    internal var smsListPane: LinearLayout? = null
    internal var smsThreadPane: LinearLayout? = null
    internal var smsThreadPlaceholder: LinearLayout? = null
    internal var smsThreadContent: LinearLayout? = null
    internal var smsCurrentAddress: String? = null
    internal var smsCurrentName: String = ""

    /** Wide screens show list + thread side by side (PC layout); narrow ones switch between them. */
    internal val smsWide: Boolean
        get() = resources.configuration.screenWidthDp >= 560

    // ── Small UI helpers (vector icons only, Win11 look) ─────────────────
    internal val smsExec = java.util.concurrent.Executors.newSingleThreadExecutor()
    internal val smsMain = Handler(Looper.getMainLooper())
    internal val contactNameCache = java.util.concurrent.ConcurrentHashMap<String, String>()
    internal var smsListRv: RecyclerView? = null
    internal var smsListEmpty: TextView? = null
    internal var smsListAdapter: SmsListAdapter? = null
    internal var smsListGen = 0
    internal var smsThreadGen = 0
    internal var smsSearchRunnable: Runnable? = null

    // Conversation (right pane) views – built once, re-bound on every open
    internal var smsThreadRv: RecyclerView? = null
    internal var smsThreadAdapter: SmsThreadAdapter? = null
    internal var smsHeaderAvatarHost: LinearLayout? = null
    internal var smsHeaderName: TextView? = null
    internal var smsHeaderSub: TextView? = null
    internal var smsBackBtn: View? = null
    internal var smsReplyEdit: EditText? = null

    internal val SMS_PAGE = 20
    internal var smsListSpinner: View? = null
    internal var smsThreadSpinner: View? = null
    internal var smsThreadOldest = 0L
    internal var smsThreadHasMore = false
    internal var smsThreadLoadingMore = false
    internal var smsConvAll: List<SmsConversation> = emptyList()
    internal var smsConvShown = 0
    internal var smsConvLoadingMore = false
    internal var smsLastQuery = ""
    internal val smsUiPrefs by lazy { getSharedPreferences("sms_ui", MODE_PRIVATE) }

    /** Round, accent-coloured loading animation (indeterminate spinner). */
    internal var smsObserver: android.database.ContentObserver? = null
    internal var smsArrivedReceiver: BroadcastReceiver? = null
    internal val smsLiveRunnable = Runnable { smsLiveRefresh() }

    internal fun rippleBg(radiusDp: Int): android.graphics.drawable.RippleDrawable {
        val mask = android.graphics.drawable.GradientDrawable().apply {
            cornerRadius = dp(radiusDp).toFloat()
            setColor(Color.WHITE)
        }
        return android.graphics.drawable.RippleDrawable(
            android.content.res.ColorStateList.valueOf(Color.parseColor("#33FFFFFF")), null, mask
        )
    }

    internal fun makeToolBtn(icon: View, desc: String, onClick: () -> Unit): FrameLayout =
        FrameLayout(this).apply {
            layoutParams = LinearLayout.LayoutParams(dp(38), dp(40))
            background = rippleBg(19)
            isClickable = true
            contentDescription = desc
            setOnClickListener { onClick() }
            addView(icon, FrameLayout.LayoutParams(dp(20), dp(20), Gravity.CENTER))
        }

    /** Win11 / Edge style tab chip. */
    internal fun getSize(size: Long): String {
        if (size <= 0) return "0 B"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val dg = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
            .coerceIn(0, units.size - 1)
        return DecimalFormat("#,##0.#").format(
            size / Math.pow(1024.0, dg.toDouble())
        ) + " " + units[dg]
    }

    internal fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

    // =====================================================================
    // DOWNLOAD SYSTEM
    // =====================================================================

    internal fun backToDesktop() {
        if (activeSection != "desktop") switchToSection("desktop")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent?.action == Intent.ACTION_VIEW && intent.data?.scheme == "rizwans2") {
            handleDeepLink(intent.data!!)
        }
        handleSendTo(intent)
        if (intent?.hasCategory(Intent.CATEGORY_HOME) == true && isUIInitialized) {
            if (shell.isStartOpen()) shell.closeStart()
            switchToSection("desktop")
        }
        if (intent?.getBooleanExtra("open_downloads", false) == true && isUIInitialized) {
            switchToSection("browser")
            showDownloads()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (!isUIInitialized) {
            @Suppress("DEPRECATION")
            super.onBackPressed()
            return
        }
        when {
            ::shell.isInitialized && shell.isStartOpen() -> { if (!shell.handleBack()) shell.closeStart() }
            ::downloadsView.isInitialized && downloadsView.visibility == View.VISIBLE -> hideDownloads()
            customView != null -> {
                val chromeClient = try {
                    webTabs[currentTabIndex].webView.webChromeClient
                } catch (e: Exception) { null }
                if (chromeClient != null) chromeClient.onHideCustomView()
                else {
                    customViewCallback?.onCustomViewHidden()
                    customViewCallback = null
                    (window.decorView as FrameLayout).removeView(customView)
                    customView = null
                    tabLayout.visibility = View.VISIBLE
                    requestedOrientation = originalOrientation
                }
            }
            activeSection == "browser" -> {
                val canGoBack = try {
                    webTabs.isNotEmpty() && webTabs[currentTabIndex].webView.canGoBack()
                } catch (e: Exception) { false }
                if (canGoBack) webTabs[currentTabIndex].webView.goBack()
                else backToDesktop()
            }
            activeSection == "files" -> {
                try {
                    val storagePath = Environment.getExternalStorageDirectory().absolutePath
                    if (currentPath.absolutePath != storagePath) goUp()
                    else backToDesktop()
                } catch (e: Exception) {
                    backToDesktop()
                }
            }
            activeSection == "sms" && !smsWide && smsCurrentAddress != null -> smsCloseThread()
            else -> backToDesktop()
        }
    }

    // =====================================================================
    // STATE SAVE
    // =====================================================================

    internal fun saveState() {
        if (!isUIInitialized) return
        try {
            val urls = webTabs.mapNotNull {
                try {
                    it.webView.url?.takeIf { u -> u.isNotEmpty() } ?: "about:blank"
                } catch (e: Exception) { null }
            }.toSet()
            prefs.edit().apply {
                putString(KEY_CURRENT_PATH, currentPath.absolutePath)
                putStringSet(KEY_TAB_URLS, urls)
                putInt(KEY_CURRENT_TAB, currentTabIndex)
                putBoolean(KEY_IS_FILE_MANAGER, activeSection == "files")
                putBoolean(KEY_DESKTOP_MODE, globalDesktopMode)
                apply()
            }
        } catch (e: Exception) { }
    }

    // =====================================================================
    // UI HELPERS
    // =====================================================================

}
