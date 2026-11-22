package com.srizwan.win11

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import androidx.core.graphics.PathParser
import android.os.Build
import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

// =====================================================================
// START MENU DATA (Step 4.2/4.3): launchable apps + pinned list + hidden apps
// =====================================================================

class AppEntry(
    val label: String,
    val pkg: String,
    val cls: String,
    val icon: Drawable,
    /** Non-null = built-in app that opens inside Win11 itself (e.g. "browser"). */
    val section: String? = null
) {
    val key: String get() = "$pkg/$cls"
    val isBuiltIn: Boolean get() = section != null

    fun launchIntent(): Intent = Intent(Intent.ACTION_MAIN).apply {
        addCategory(Intent.CATEGORY_LAUNCHER)
        setClassName(pkg, cls)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
    }
}

/** Vector-only icon for built-in apps (same path data as the taskbar icons, no emoji/bitmaps). */
class BuiltInIconDrawable(pathData: String, private val tint: Int, evenOdd: Boolean = false) : Drawable() {
    private val path = PathParser.createPathFromPathData(pathData)?.also {
        if (evenOdd) it.fillType = android.graphics.Path.FillType.EVEN_ODD
    }
    private val fill = Paint(Paint.ANTI_ALIAS_FLAG).apply { style = Paint.Style.FILL; color = tint }

    override fun draw(canvas: Canvas) {
        val b = bounds
        val s = minOf(b.width(), b.height()) / 24f
        canvas.save()
        canvas.translate(b.left + (b.width() - 24f * s) / 2f, b.top + (b.height() - 24f * s) / 2f)
        canvas.scale(s, s)
        path?.let { canvas.drawPath(it, fill) }
        canvas.restore()
    }

    override fun setAlpha(alpha: Int) { fill.alpha = alpha; invalidateSelf() }
    override fun setColorFilter(cf: ColorFilter?) { fill.colorFilter = cf; invalidateSelf() }
    @Deprecated("Deprecated in Java")
    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT
}

/**
 * Loads launchable apps from PackageManager (background thread) and keeps the
 * ordered pinned list in SharedPreferences ("start_menu" / "pinned").
 * Step 4.3 (All apps) reuses [apps], [isPinned] and [pin]/[unpin].
 */
class AppRepository(private val ctx: Context) {

    private val pm: PackageManager = ctx.packageManager
    private val prefs = ctx.getSharedPreferences("start_menu", Context.MODE_PRIVATE)
    private val io = Executors.newSingleThreadExecutor()
    private val main = Handler(Looper.getMainLooper())

    var apps: List<AppEntry> = emptyList()
        private set

    /** Key of the system Phone (dialer) app entry, shown with the built-in phone icon; null if the device has none. */
    @Volatile
    var systemPhoneKey: String? = null
        private set

    private val pinnedKeys: MutableList<String> = (prefs.getString(KEY_PINNED, null)
        ?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()).toMutableList()

    private val recentKeys: MutableList<String> = (prefs.getString(KEY_RECENT, null)
        ?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()).toMutableList()

    private val hiddenKeys: MutableSet<String> = (prefs.getString(KEY_HIDDEN, null)
        ?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()).toMutableSet()

    companion object {
        private const val KEY_PINNED = "pinned"
        private const val KEY_HIDDEN = "hidden"
        private const val DEFAULT_COUNT = 12
        private const val KEY_RECENT = "recent"
        private const val KEY_RECENT_MODEL = "recent_model_v1"
        private const val MAX_RECENT = 12
        private const val BUILTIN_CLS_BROWSER = "builtin.browser"
        private const val BUILTIN_CLS_NOTIF = "builtin.notifications"
        private const val BUILTIN_CLS_CALC = "builtin.calculator"
        private const val BUILTIN_CLS_PARALLEL = "builtin.parallel"
        private const val BUILTIN_CLS_WINLATOR = "builtin.winlator"
        private const val BUILTIN_CLS_YOUTUBE = "builtin.youtube"
        private const val BUILTIN_CLS_VIDEO = "builtin.video"
        private const val BUILTIN_CLS_GALLERY = "builtin.gallery"
        private const val BUILTIN_CLS_CAMERA = "builtin.camera"
        private const val BUILTIN_CLS_J2ME = "builtin.j2me"
        private const val BUILTIN_CLS_PPSSPP = "builtin.ppsspp"
        /** Handheld console with a screen and two buttons (even-odd fill makes the hollow screen): the built-in PPSSPP app (:ppsspp module, package org.ppsspp.ppsspp). */
        private const val PPSSPP_PATH =
            "M5,6H19C20.66,6 22,7.34 22,9V15C22,16.66 20.66,18 19,18H5C3.34,18 2,16.66 2,15V9C2,7.34 3.34,6 5,6ZM8,8H16C16.55,8 17,8.45 17,9V15C17,15.55 16.55,16 16,16H8C7.45,16 7,15.55 7,15V9C7,8.45 7.45,8 8,8ZM3.5,12a1,1 0 1,0 2,0a1,1 0 1,0 -2,0ZM18.5,12a1,1 0 1,0 2,0a1,1 0 1,0 -2,0Z"
        /** Camera body with a lens (Material "photo_camera"): the built-in Camera app (:camera module, package com.srizwan.camera). */
        private const val CAMERA_PATH =
            "M9,2L7.17,4H4c-1.1,0 -2,0.9 -2,2v12c0,1.1 0.9,2 2,2h16c1.1,0 2,-0.9 2,-2V6c0,-1.1 -0.9,-2 -2,-2h-3.17L15,2H9zM12,17c-2.76,0 -5,-2.24 -5,-5s2.24,-5 5,-5 5,2.24 5,5 -2.24,5 -5,5z"
        /** Game pad (Material "videogame_asset"): the built-in J2ME app (:j2me module = J2ME Loader, package ru.playsoftware.j2meloader). */
        private const val J2ME_PATH =
            "M21,6H3c-1.1,0 -2,0.9 -2,2v8c0,1.1 0.9,2 2,2h18c1.1,0 1.99,-0.9 1.99,-2L23,8c0,-1.1 -0.9,-2 -2,-2zM11,13H8v3H6v-3H3v-2h3V8h2v3h3v2zM15.5,15c-0.83,0 -1.5,-0.67 -1.5,-1.5s0.67,-1.5 1.5,-1.5 1.5,0.67 1.5,1.5 -0.67,1.5 -1.5,1.5zM19.5,12c-0.83,0 -1.5,-0.67 -1.5,-1.5S18.67,9 19.5,9s1.5,0.67 1.5,1.5 -0.67,1.5 -1.5,1.5z"
        /** Framed picture with a mountain (Material "image"): the built-in Gallery app (:gallery module, package com.srizwan.gallery). */
        private const val GALLERY_PATH =
            "M21,19V5c0,-1.1 -0.9,-2 -2,-2H5c-1.1,0 -2,0.9 -2,2v14c0,1.1 0.9,2 2,2h14c1.1,0 2,-0.9 2,-2zM8.5,13.5l2.5,3.01L14.5,12l4.5,6H5l3.5,-4.5z"
        /** Film frame (Material "movie"): the built-in Video app (:video module, package com.srizwan.video). */
        private const val VIDEO_PATH =
            "M18,4l2,4h-3l-2,-4h-2l2,4h-3l-2,-4H8l2,4H5L3,4H2.99C1.9,4 2,5 2,6v12c0,1.1 0.9,2 2,2h16c1.1,0 2,-0.9 2,-2V4h-4z"
        /** Rounded screen with a hollow play triangle (even-odd fill): the built-in YouTube app. */
        private const val YOUTUBE_PATH =
            "M21.6,7.2c-0.2,-0.9 -0.9,-1.5 -1.8,-1.7C18.2,5 12,5 12,5s-6.2,0 -7.8,0.5c-0.9,0.2 -1.6,0.8 -1.8,1.7C2,8.8 2,12 2,12s0,3.2 0.4,4.8c0.2,0.9 0.9,1.5 1.8,1.7C5.8,19 12,19 12,19s6.2,0 7.8,-0.5c0.9,-0.2 1.6,-0.8 1.8,-1.7C22,15.2 22,12 22,12s0,-3.2 -0.4,-4.8z M10,15V9l5.2,3z"
        /** Wine glass (Wine = Windows programs): Winlator. Even-odd fill makes the hollow bowl. */
        private const val WINLATOR_PATH =
            "M6,2 H18 L17.3,8.6 C16.9,11.9 14.8,14.2 12.9,14.8 V19.2 H16.2 V21.2 H7.8 V19.2 H11.1 V14.8 C9.2,14.2 7.1,11.9 6.7,8.6 Z M8.2,4 L8.6,8.3 C8.9,10.2 10.2,11.9 12,12.4 C13.8,11.9 15.1,10.2 15.4,8.3 L15.8,4 Z"
        /** Two overlapping sheets (copy icon): the Parallel manager. */
        private const val PARALLEL_PATH =
            "M16 1H4c-1.1 0-2 .9-2 2v14h2V3h12V1zm3 4H8c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h11c1.1 0 2-.9 2-2V7c0-1.1-.9-2-2-2zm0 16H8V7h11v14z"

        // Calculator glyph (same path as ic_w_calculator.xml, even-odd fill)
        private const val CALC_PATH =
            "M5,2h14a2,2 0 0 1 2,2v16a2,2 0 0 1 -2,2H5a2,2 0 0 1 -2,-2V4a2,2 0 0 1 2,-2z M6.5,4.5h11v4h-11z M6.5,11h3v2.5h-3z M10.5,11h3v2.5h-3z M14.5,11h3v2.5h-3z M6.5,14.8h3v2.5h-3z M10.5,14.8h3v2.5h-3z M14.5,14.8h3v2.5h-3z M6.5,18.6h3v2h-3z M10.5,18.6h3v2h-3z M14.5,18.6h3v2h-3z"

        // Same bell path as VectorIconView.BELL
        private const val NOTIF_PATH =
            "M12,22c1.1,0 2,-0.9 2,-2h-4c0,1.1 0.89,2 2,2zM18,16v-5c0,-3.07 -1.64,-5.64 -4.5,-6.32V4c0,-0.83 -0.67,-1.5 -1.5,-1.5s-1.5,0.67 -1.5,1.5v0.68C7.63,5.36 6,7.92 6,11v5l-2,2v1h16v-1l-2,-2z"
        private const val BUILTIN_CLS_SMS = "builtin.sms"

        // Same bubble path as VectorIconView.MESSAGES
        private const val SMS_PATH =
            "M20,2H4C2.9,2 2,2.9 2,4v18l4,-4h14c1.1,0 2,-0.9 2,-2V4C22,2.9 21.1,2 20,2z"
        private const val BUILTIN_CLS_FILES = "builtin.files"

        // Same folder path as VectorIconView.FILES
        private const val FILES_PATH =
            "M10,4H4c-1.1,0 -1.99,0.9 -1.99,2L2,18c0,1.1 0.9,2 2,2h16c1.1,0 2,-0.9 2,-2V8c0,-1.1 -0.9,-2 -2,-2h-8l-2,-2z"
        private const val BUILTIN_CLS_PHONE = "builtin.phone"

        // Same handset path as VectorIconView.PHONE
        private const val PHONE_PATH =
            "M6.62,10.79c1.44,2.83 3.76,5.14 6.59,6.59l2.2,-2.2c0.27,-0.27 0.67,-0.36 1.02,-0.24 1.12,0.37 2.33,0.57 3.57,0.57 0.55,0 1,0.45 1,1V20c0,0.55 -0.45,1 -1,1 -9.39,0 -17,-7.61 -17,-17 0,-0.55 0.45,-1 1,-1h3.5c0.55,0 1,0.45 1,1 0,1.25 0.2,2.45 0.57,3.57 0.11,0.35 0.03,0.74 -0.25,1.02l-2.2,2.2z"

        // Same globe path as VectorIconView.BROWSER
        private const val BROWSER_PATH =
            "M12,2C6.48,2 2,6.48 2,12s4.48,10 10,10 10,-4.48 10,-10S17.52,2 12,2zM11,19.93c-3.95,-0.49 -7,-3.85 -7,-7.93 0,-0.62 0.08,-1.21 0.21,-1.79L9,15v1c0,1.1 0.9,2 2,2v1.93zM17.9,17.39c-0.26,-0.81 -1,-1.39 -1.9,-1.39h-1v-3c0,-0.55 -0.45,-1 -1,-1H8v-2h2c0.55,0 1,-0.45 1,-1V7h2c1.1,0 2,-0.9 2,-2v-0.41c2.93,1.19 5,4.06 5,7.41 0,2.08 -0.8,3.97 -2.1,5.39z"

        private val PREFERRED = listOf(
            "com.android.chrome",
            "com.google.android.apps.messaging",
            "com.google.android.dialer",
            "com.android.dialer",
            "com.android.contacts",
            "com.google.android.contacts",
            "com.android.camera",
            "com.android.camera2",
            "com.google.android.GoogleCamera",
            "com.google.android.apps.photos",
            "com.google.android.gm",
            "com.google.android.apps.maps",
            "com.google.android.youtube",
            "com.android.vending",
            "com.android.settings"
        )
    }

    /** Reloads the app list in the background; [onDone] runs on the main thread. */
    fun load(onDone: (changed: Boolean) -> Unit) {
        io.execute {
            val list = try { query() } catch (e: Exception) { null }
            main.post {
                if (list == null) return@post
                // "Hide app" can also be switched in Notifications > Apps (AppControl): re-read it here.
                val prefsChanged = reloadPrefs()
                val changed = list.map { it.key } != apps.map { it.key } || prefsChanged
                apps = list
                migrateBuiltInPhone()
                if (!prefs.getBoolean(KEY_RECENT_MODEL, false)) {
                    // One-time switch to "Recent by default": Start no longer auto-pins apps.
                    // Pins that are only the old auto-seeded defaults are cleared; anything the user
                    // pinned on purpose (an app outside the old default set) is kept.
                    val defaults = defaultPins(list).toSet()
                    if (pinnedKeys.all { it in defaults }) { pinnedKeys.clear(); save() }
                    prefs.edit().putBoolean(KEY_RECENT_MODEL, true).apply()
                    onDone(true)
                } else {
                    onDone(changed)
                }
            }
        }
    }

    /**
     * Re-reads the pinned and hidden lists from the preferences (they can be changed outside this
     * object, see [AppControl]). Returns true when something differs from what was in memory.
     */
    private fun reloadPrefs(): Boolean {
        val newHidden = (prefs.getString(KEY_HIDDEN, null)
            ?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()).toSet()
        val newPinned = prefs.getString(KEY_PINNED, null)
            ?.split("\n")?.filter { it.isNotBlank() } ?: emptyList()
        var changed = false
        if (newHidden != hiddenKeys) { hiddenKeys.clear(); hiddenKeys.addAll(newHidden); changed = true }
        if (newPinned != pinnedKeys) { pinnedKeys.clear(); pinnedKeys.addAll(newPinned); changed = true }
        return changed
    }

    private fun builtInApps(): List<AppEntry> = listOf(
        AppEntry(
            "Files", ctx.packageName, BUILTIN_CLS_FILES,
            BuiltInIconDrawable(FILES_PATH, Color.parseColor("#FFC83D")),
            section = "files"
        ),
        AppEntry(
            "Browser", ctx.packageName, BUILTIN_CLS_BROWSER,
            BuiltInIconDrawable(BROWSER_PATH, Color.parseColor("#4CC2FF")),
            section = "browser"
        ),
        AppEntry(
            "Notifications", ctx.packageName, BUILTIN_CLS_NOTIF,
            BuiltInIconDrawable(NOTIF_PATH, Color.parseColor("#FFB900")),
            section = "notifications"
        ),
        AppEntry(
            "Messages", ctx.packageName, BUILTIN_CLS_SMS,
            BuiltInIconDrawable(SMS_PATH, Color.parseColor("#7AB8FF")),
            section = "sms"
        ),
        // The built-in Phone screen is hidden: the system Phone app (see query()) is used instead.
        AppEntry(
            "Calculator", ctx.packageName, BUILTIN_CLS_CALC,
            BuiltInIconDrawable(CALC_PATH, Color.parseColor("#9AA7FF"), evenOdd = true),
            section = "calculator"
        ),
        // Parallel apps manager (BlackBox virtual space): see parallel/ParallelActivity.kt
        AppEntry(
            "Parallel", ctx.packageName, BUILTIN_CLS_PARALLEL,
            BuiltInIconDrawable(PARALLEL_PATH, Color.parseColor("#8C7BFF")),
            section = "parallel"
        ),
        // Built-in YouTube app (:youtube module, com.srizwan.YouTube.YouTubeActivity), vector icon only
        AppEntry(
            "YouTube", ctx.packageName, BUILTIN_CLS_YOUTUBE,
            BuiltInIconDrawable(YOUTUBE_PATH, Color.parseColor("#FF3B30"), evenOdd = true),
            section = "youtube"
        ),
        // Built-in Video app (:video module, com.srizwan.video.home.VideoHomeActivity), vector icon only
        AppEntry(
            "Video", ctx.packageName, BUILTIN_CLS_VIDEO,
            BuiltInIconDrawable(VIDEO_PATH, Color.parseColor("#FF6B8B")),
            section = "video"
        ),
        // Built-in Gallery app (:gallery module, com.srizwan.gallery.home.GalleryHomeActivity), vector icon only
        AppEntry(
            "Gallery", ctx.packageName, BUILTIN_CLS_GALLERY,
            BuiltInIconDrawable(GALLERY_PATH, Color.parseColor("#4FD1A5")),
            section = "gallery"
        ),
        // Built-in Camera app (:camera module, com.srizwan.camera.CameraActivity), vector icon only
        AppEntry(
            "Camera", ctx.packageName, BUILTIN_CLS_CAMERA,
            BuiltInIconDrawable(CAMERA_PATH, Color.parseColor("#FFD34E")),
            section = "camera"
        ),
        // Built-in J2ME app (:j2me module = J2ME Loader, ru.playsoftware.j2meloader.MainActivity), vector icon only
        AppEntry(
            "J2ME", ctx.packageName, BUILTIN_CLS_J2ME,
            BuiltInIconDrawable(J2ME_PATH, Color.parseColor("#FF9F43")),
            section = "j2me"
        ),
        // Built-in PPSSPP app (:ppsspp module, org.ppsspp.ppsspp.PpssppActivity), vector icon only
        AppEntry(
            "PPSSPP", ctx.packageName, BUILTIN_CLS_PPSSPP,
            BuiltInIconDrawable(PPSSPP_PATH, Color.parseColor("#4C8DFF"), evenOdd = true),
            section = "ppsspp"
        )
    ) + (
        // Winlator (PC software: .exe via Wine + Box64) exists only for 64-bit ARM phones.
        if (WinlatorLauncher.isSupported()) listOf(
            AppEntry(
                "Winlator", ctx.packageName, BUILTIN_CLS_WINLATOR,
                BuiltInIconDrawable(WINLATOR_PATH, Color.parseColor("#C77DFF"), evenOdd = true),
                section = WinlatorLauncher.SECTION
            )
        ) else emptyList()
    )

    /** Package of the device's default Phone / dialer app (null if none can be found). */
    private fun systemDialerPackage(): String? {
        try {
            val tm = ctx.getSystemService(Context.TELECOM_SERVICE) as? android.telecom.TelecomManager
            tm?.defaultDialerPackage?.let { if (it.isNotBlank()) return it }
        } catch (e: Throwable) { }
        return try {
            pm.resolveActivity(Intent(Intent.ACTION_DIAL), PackageManager.MATCH_DEFAULT_ONLY)
                ?.activityInfo?.packageName
        } catch (e: Throwable) { null }
    }

    @Suppress("DEPRECATION")
    private fun query(): List<AppEntry> {
        val i = Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER)
        val res = if (Build.VERSION.SDK_INT >= 33)
            pm.queryIntentActivities(i, PackageManager.ResolveInfoFlags.of(0L))
        else pm.queryIntentActivities(i, 0)
        val dialerPkg = systemDialerPackage()
        var phoneKey: String? = null
        val list = res.asSequence()
            .filter { it.activityInfo != null && it.activityInfo.packageName != ctx.packageName }
            .map {
                val pkg = it.activityInfo.packageName
                if (pkg == dialerPkg && phoneKey == null) {
                    // The system Phone app replaces the built-in Phone: real app, built-in vector icon.
                    phoneKey = "$pkg/${it.activityInfo.name}"
                    AppEntry(
                        "Phone", pkg, it.activityInfo.name,
                        BuiltInIconDrawable(PHONE_PATH, Color.parseColor("#6CCB5F"))
                    )
                } else AppEntry(it.loadLabel(pm).toString(), pkg, it.activityInfo.name, it.loadIcon(pm))
            }
            .plus(builtInApps())
            .distinctBy { it.key }
            .sortedWith(compareBy(String.CASE_INSENSITIVE_ORDER) { it.label })
            .toList()
        systemPhoneKey = phoneKey
        return list
    }

    /** Old installs pinned / hid the built-in Phone: move that pin (same position) to the system Phone app. */
    private fun migrateBuiltInPhone() {
        val old = "${ctx.packageName}/$BUILTIN_CLS_PHONE"
        val sys = systemPhoneKey
        val at = pinnedKeys.indexOf(old)
        if (at >= 0) {
            pinnedKeys.removeAt(at)
            if (sys != null && !pinnedKeys.contains(sys)) pinnedKeys.add(at.coerceAtMost(pinnedKeys.size), sys)
            save()
        }
        if (hiddenKeys.remove(old)) {
            if (sys != null) hiddenKeys.add(sys)
            saveHidden()
        }
    }

    private fun defaultPins(list: List<AppEntry>): List<String> {
        val out = LinkedHashSet<String>()
        list.firstOrNull { it.isBuiltIn && it.section == "files" }?.let { out.add(it.key) }
        list.firstOrNull { it.isBuiltIn && it.section == "browser" }?.let { out.add(it.key) }
        systemPhoneKey?.let { k -> list.firstOrNull { it.key == k }?.let { out.add(it.key) } }
        list.firstOrNull { it.isBuiltIn && it.section == "sms" }?.let { out.add(it.key) }
        list.firstOrNull { it.isBuiltIn && it.section == "notifications" }?.let { out.add(it.key) }
        list.firstOrNull { it.isBuiltIn && it.section == "calculator" }?.let { out.add(it.key) }
        for (p in PREFERRED) {
            list.firstOrNull { it.pkg == p }?.let { out.add(it.key) }
            if (out.size >= DEFAULT_COUNT) break
        }
        for (a in list) {
            if (out.size >= DEFAULT_COUNT) break
            out.add(a.key)
        }
        return out.toList()
    }

    private fun save() {
        prefs.edit().putString(KEY_PINNED, pinnedKeys.joinToString("\n")).apply()
    }

    private fun saveHidden() {
        prefs.edit().putString(KEY_HIDDEN, hiddenKeys.joinToString("\n")).apply()
    }

    /** Pinned apps, in order, excluding hidden ones. */
    fun pinned(): List<AppEntry> {
        val map = apps.associateBy { it.key }
        return pinnedKeys.mapNotNull { map[it] }.filter { it.key !in hiddenKeys }
    }

    // ── Recent apps: most recently opened from Start first; pinned / hidden apps are left out ──
    fun recent(): List<AppEntry> {
        val map = apps.associateBy { it.key }
        return recentKeys.mapNotNull { map[it] }
            .filter { it.key !in hiddenKeys && it.key !in pinnedKeys }
    }

    fun addRecent(e: AppEntry) {
        recentKeys.remove(e.key)
        recentKeys.add(0, e.key)
        while (recentKeys.size > MAX_RECENT) recentKeys.removeAt(recentKeys.size - 1)
        saveRecent()
    }

    fun removeRecent(e: AppEntry) {
        if (recentKeys.remove(e.key)) saveRecent()
    }

    private fun saveRecent() {
        prefs.edit().putString(KEY_RECENT, recentKeys.joinToString("\n")).apply()
    }

    // ── Hidden apps (Step 4.3) ───────────────────────────────────
    fun isHidden(e: AppEntry): Boolean = hiddenKeys.contains(e.key)

    /** Hiding also removes the app from Pinned. */
    fun hide(e: AppEntry) {
        unpin(e)
        if (hiddenKeys.add(e.key)) saveHidden()
    }

    fun unhide(e: AppEntry) {
        if (hiddenKeys.remove(e.key)) saveHidden()
    }

    fun visibleApps(): List<AppEntry> = apps.filter { it.key !in hiddenKeys }

    fun hiddenApps(): List<AppEntry> = apps.filter { it.key in hiddenKeys }

    fun isPinned(e: AppEntry): Boolean = pinnedKeys.contains(e.key)

    fun pin(e: AppEntry) {
        if (!pinnedKeys.contains(e.key)) { pinnedKeys.add(e.key); save() }
    }

    fun unpin(e: AppEntry) {
        if (pinnedKeys.remove(e.key)) save()
    }

    fun togglePin(e: AppEntry): Boolean {
        if (isPinned(e)) unpin(e) else pin(e)
        return isPinned(e)
    }

    fun moveToFront(e: AppEntry) {
        if (pinnedKeys.remove(e.key)) { pinnedKeys.add(0, e.key); save() }
    }
}
