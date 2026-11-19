package com.srizwan.win11

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.Settings
import android.widget.Toast

// =====================================================================
// NOTIFICATION SETTINGS: master on/off, per-app on/off (every installed
// app), Do Not Disturb, and sound / vibrate that follow the ring mode.
// =====================================================================

class NotifApp(
    val id: String,
    val label: String,
    val packages: Set<String>,
    val color: Int
)

/** A vibration pattern: timings in ms, off/on alternating, first value = delay. null = no fixed pattern. */
class VibPattern(val id: String, val label: String, val timings: LongArray?)

/** A choice for the pop-up look: style, position (id + label shown in the settings). */
class PopupOption(val id: String, val label: String)

/** How long a pop-up stays: [ms] = 0 means "until dismissed" (tap the card or the X). */
class PopupDuration(val ms: Long, val label: String)

/** An accent colour choice: [color] = 0 means "no accent" (the plain default look). */
class PopupColor(val color: Int, val label: String)

/**
 * The saved look of a pop-up for one app profile (see [NotifPrefs.popupStyleFor]).
 * [style] glass / solid / light / compact, [accent] ARGB or 0, [durationMs] 0 = until dismissed,
 * [position] one of [NotifPrefs.popupPositions]. The defaults equal the original pop-up exactly.
 */
class PopupStyle(
    val style: String = "glass",
    val accent: Int = 0,
    val durationMs: Long = 5000L,
    val position: String = "top_right"
)

object NotifPrefs {

    /**
     * Apps that have their OWN sound + vibration (Settings > Notifications > Sound & vibration per app).
     * To give another app the same settings, add its [NotifApp] here (for example `apps[2]` for Messenger):
     * the settings screen, the saved keys (`snd_<id>`, `vib_<id>`) and the playback all follow this list.
     */
    val customAlertApps: List<NotifApp> by lazy { listOf(apps.first { it.id == "whatsapp" }) }

    /** Selectable vibration patterns. "default" keeps the old behaviour (short buzz in Vibrate mode only). */
    val vibPatterns: List<VibPattern> = listOf(
        VibPattern("default", "Default", null),
        VibPattern("off", "Off", null),
        VibPattern("short", "Short", longArrayOf(0, 250)),
        VibPattern("long", "Long", longArrayOf(0, 700)),
        VibPattern("double", "Double", longArrayOf(0, 150, 120, 150)),
        VibPattern("triple", "Triple", longArrayOf(0, 120, 100, 120, 100, 120)),
        VibPattern("heartbeat", "Heartbeat", longArrayOf(0, 70, 90, 150, 450, 70, 90, 150))
    )

    const val SOUND_SILENT = "silent"

    @Volatile private var lastRingtone: android.media.Ringtone? = null

    private const val FILE = "notif_settings"
    private const val KEY_MASTER = "master"
    private const val KEY_SOUND = "sound"
    private const val KEY_DND = "dnd"

    /** Chat apps from older versions. Their old "app_<id>" switch is still honoured (see [isPkgOn]). */
    val apps: List<NotifApp> = listOf(
        NotifApp("whatsapp", "WhatsApp",
            setOf("com.whatsapp", "com.gbwhatsapp"), 0xFF25D366.toInt()),
        NotifApp("whatsapp_business", "WhatsApp Business",
            setOf("com.whatsapp.w4b", "com.whatsapp.business"), 0xFF128C7E.toInt()),
        NotifApp("messenger", "Messenger",
            setOf("com.facebook.orca"), 0xFF0084FF.toInt()),
        NotifApp("messenger_lite", "Messenger Lite",
            setOf("com.facebook.mlite", "com.facebook.messenger.lite"), 0xFF4CC2FF.toInt()),
        NotifApp("telegram", "Telegram",
            setOf("org.telegram.messenger", "org.telegram.messenger.web"), 0xFF2AABEE.toInt())
    )

    private fun p(ctx: Context) = ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE)

    fun appFor(pkg: String): NotifApp? = apps.firstOrNull { pkg in it.packages }

    fun isMasterOn(ctx: Context): Boolean = p(ctx).getBoolean(KEY_MASTER, true)
    fun setMaster(ctx: Context, on: Boolean) { p(ctx).edit().putBoolean(KEY_MASTER, on).apply() }

    // Legacy per-chat-app switch (kept so old settings still work)
    fun isAppOn(ctx: Context, id: String): Boolean = p(ctx).getBoolean("app_$id", true)
    fun setAppOn(ctx: Context, id: String, on: Boolean) {
        p(ctx).edit().putBoolean("app_$id", on).apply()
    }

    /** Per-package pop-up switch for ANY app. Default on; a saved choice wins; old chat-app choice is the fallback. */
    fun isPkgOn(ctx: Context, pkg: String): Boolean {
        val sp = p(ctx)
        if (sp.contains("pkg_$pkg")) return sp.getBoolean("pkg_$pkg", true)
        val legacy = appFor(pkg) ?: return true
        return sp.getBoolean("app_${legacy.id}", true)
    }

    fun setPkgOn(ctx: Context, pkg: String, on: Boolean) {
        p(ctx).edit().putBoolean("pkg_$pkg", on).apply()
    }

    fun setPkgsOn(ctx: Context, pkgs: Collection<String>, on: Boolean) {
        val e = p(ctx).edit()
        pkgs.forEach { e.putBoolean("pkg_$it", on) }
        e.apply()
    }

    // ── Own sound + vibration per app (see [customAlertApps]) ──

    /** The custom-alert profile (app) a package belongs to, or null = it uses the general settings. */
    fun alertProfileFor(pkg: String?): NotifApp? =
        if (pkg == null) null else customAlertApps.firstOrNull { pkg in it.packages }

    /** null = default notification sound, [SOUND_SILENT] = no sound, otherwise a sound URI string. */
    fun getSoundSetting(ctx: Context, id: String): String? = p(ctx).getString("snd_$id", null)
    fun setSoundSetting(ctx: Context, id: String, value: String?) {
        val e = p(ctx).edit()
        if (value == null) e.remove("snd_$id") else e.putString("snd_$id", value)
        e.apply()
    }

    fun getVibId(ctx: Context, id: String): String = p(ctx).getString("vib_$id", "default") ?: "default"
    fun setVibId(ctx: Context, id: String, patternId: String) {
        p(ctx).edit().putString("vib_$id", patternId).apply()
    }

    fun resetAlert(ctx: Context, id: String) {
        p(ctx).edit().remove("snd_$id").remove("vib_$id").apply()
    }

    fun vibLabel(patternId: String): String = vibPatterns.firstOrNull { it.id == patternId }?.label ?: "Default"

    /** Readable name of a saved sound setting. */
    fun soundLabel(ctx: Context, value: String?): String {
        if (value == null) return "Default"
        if (value == SOUND_SILENT) return "Silent"
        return try {
            RingtoneManager.getRingtone(ctx.applicationContext, Uri.parse(value))?.getTitle(ctx) ?: "Custom"
        } catch (_: Throwable) { "Custom" }
    }

    // ── Own pop-up look per app (see [customAlertApps]; every other app uses the "default" profile) ──

    /** Profile id of the "all other apps" pop-up look. */
    const val POPUP_DEFAULT_ID = "default"

    val popupStyles: List<PopupOption> = listOf(
        PopupOption("glass", "Glass"),
        PopupOption("solid", "Solid"),
        PopupOption("light", "Light"),
        PopupOption("compact", "Compact")
    )

    val popupPositions: List<PopupOption> = listOf(
        PopupOption("top_right", "Top right"),
        PopupOption("top_center", "Top center"),
        PopupOption("top_left", "Top left"),
        PopupOption("bottom_right", "Bottom right"),
        PopupOption("bottom_center", "Bottom center"),
        PopupOption("bottom_left", "Bottom left")
    )

    val popupDurations: List<PopupDuration> = listOf(
        PopupDuration(2000L, "2 seconds"),
        PopupDuration(3000L, "3 seconds"),
        PopupDuration(5000L, "5 seconds"),
        PopupDuration(8000L, "8 seconds"),
        PopupDuration(12000L, "12 seconds"),
        PopupDuration(0L, "Until dismissed")
    )

    /** Accent swatches. The first (0) is the plain default look; an app's own colour is added in the settings. */
    val popupColors: List<PopupColor> = listOf(
        PopupColor(0, "Default"),
        PopupColor(0xFF4CC2FF.toInt(), "Blue"),
        PopupColor(0xFF25D366.toInt(), "Green"),
        PopupColor(0xFFFFB900.toInt(), "Amber"),
        PopupColor(0xFFFF6B6B.toInt(), "Red"),
        PopupColor(0xFFB388FF.toInt(), "Purple"),
        PopupColor(0xFFFF6AC1.toInt(), "Pink")
    )

    /** Which pop-up profile a package uses: its own app profile, otherwise the "default" one. */
    fun popupProfileId(pkg: String?): String = alertProfileFor(pkg)?.id ?: POPUP_DEFAULT_ID

    fun getPopupStyleId(ctx: Context, id: String): String {
        val v = p(ctx).getString("pop_style_$id", "glass") ?: "glass"
        return if (popupStyles.any { it.id == v }) v else "glass"
    }
    fun getPopupAccent(ctx: Context, id: String): Int = p(ctx).getInt("pop_color_$id", 0)
    fun getPopupDurationMs(ctx: Context, id: String): Long {
        val v = p(ctx).getLong("pop_dur_$id", 5000L)
        return if (popupDurations.any { it.ms == v }) v else 5000L
    }
    fun getPopupPosition(ctx: Context, id: String): String {
        val v = p(ctx).getString("pop_pos_$id", "top_right") ?: "top_right"
        return if (popupPositions.any { it.id == v }) v else "top_right"
    }

    fun setPopupStyleId(ctx: Context, id: String, value: String) { p(ctx).edit().putString("pop_style_$id", value).apply() }
    fun setPopupAccent(ctx: Context, id: String, color: Int) { p(ctx).edit().putInt("pop_color_$id", color).apply() }
    fun setPopupDurationMs(ctx: Context, id: String, ms: Long) { p(ctx).edit().putLong("pop_dur_$id", ms).apply() }
    fun setPopupPosition(ctx: Context, id: String, value: String) { p(ctx).edit().putString("pop_pos_$id", value).apply() }

    fun resetPopup(ctx: Context, id: String) {
        p(ctx).edit().remove("pop_style_$id").remove("pop_color_$id")
            .remove("pop_dur_$id").remove("pop_pos_$id").apply()
    }

    fun popupStyleLabel(styleId: String): String = popupStyles.firstOrNull { it.id == styleId }?.label ?: "Glass"
    fun popupPositionLabel(posId: String): String = popupPositions.firstOrNull { it.id == posId }?.label ?: "Top right"
    fun popupDurationLabel(ms: Long): String = popupDurations.firstOrNull { it.ms == ms }?.label ?: "5 seconds"

    /** The pop-up look saved for this profile id. */
    fun getPopupStyle(ctx: Context, id: String): PopupStyle = PopupStyle(
        getPopupStyleId(ctx, id), getPopupAccent(ctx, id), getPopupDurationMs(ctx, id), getPopupPosition(ctx, id)
    )

    /** The pop-up look for a package (its app profile, else the "default" one). */
    fun popupStyleFor(ctx: Context, pkg: String?): PopupStyle = getPopupStyle(ctx, popupProfileId(pkg))

    fun isSoundOn(ctx: Context): Boolean = p(ctx).getBoolean(KEY_SOUND, true)
    fun setSound(ctx: Context, on: Boolean) { p(ctx).edit().putBoolean(KEY_SOUND, on).apply() }

    /** Do Not Disturb (Win11 style): no pop-ups and no sound; the notification center still collects everything. */
    fun isDndOn(ctx: Context): Boolean = p(ctx).getBoolean(KEY_DND, false)
    fun setDnd(ctx: Context, on: Boolean) { p(ctx).edit().putBoolean(KEY_DND, on).apply() }

    /** Master switch AND the app's own switch must be on, and Do Not Disturb must be off. */
    fun isAllowed(ctx: Context, pkg: String): Boolean {
        if (!isMasterOn(ctx)) return false
        if (isDndOn(ctx)) return false
        return isPkgOn(ctx, pkg)
    }

    /** true when pop-ups may be drawn over other apps (needs the "Display over other apps" permission). */
    fun canOverlay(ctx: Context): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.M || Settings.canDrawOverlays(ctx)

    /**
     * Shows the glass pop-up and gives sound / vibration feedback. Safe to call from any thread and
     * from a Service, so it works while the launcher is paused, stopped or in the background.
     * With "Display over other apps" allowed the pop-up is the same glass card as inside the
     * launcher; otherwise a normal system Toast is used.
     */
    fun alert(ctx: Context, sender: String, message: String, app: String, pkg: String? = null) {
        val appCtx = ctx.applicationContext
        Handler(Looper.getMainLooper()).post {
            var shown = false
            try {
                if (canOverlay(appCtx)) shown = GlassToast.showOverlay(appCtx, pkg, app, sender, message)
            } catch (_: Throwable) { }
            if (!shown) {
                try {
                    val text = if (message.length > 80) message.substring(0, 80) + "\u2026" else message
                    Toast.makeText(appCtx, "$app: $sender\n$text", Toast.LENGTH_LONG).show()
                } catch (_: Exception) { }
            }
            feedback(appCtx, pkg)
        }
    }

    /**
     * Sound or vibration that follows the phone's ring mode (the Ring / Vibrate / Mute button):
     * Ring = notification sound (if the sound switch is on), Vibrate = a short vibration, Mute = nothing.
     *
     * Apps in [customAlertApps] can have their own sound and vibration pattern:
     *  - sound: default / silent / a picked sound (Ring mode only, still needs the sound switch on),
     *  - vibration "Default" = old behaviour (buzz only in Vibrate mode); "Off" = never vibrate;
     *    a pattern (Short, Long, Double, ...) vibrates in Ring mode (with the sound) and in Vibrate mode.
     */
    fun feedback(ctx: Context, pkg: String? = null) {
        val c = ctx.applicationContext
        val prof = alertProfileFor(pkg)
        val soundSet = if (prof != null) getSoundSetting(c, prof.id) else null
        val vibId = if (prof != null) getVibId(c, prof.id) else "default"
        val mode = try {
            (c.getSystemService(Context.AUDIO_SERVICE) as AudioManager).ringerMode
        } catch (_: Throwable) { AudioManager.RINGER_MODE_NORMAL }
        when (mode) {
            AudioManager.RINGER_MODE_NORMAL -> {
                if (isSoundOn(c) && soundSet != SOUND_SILENT) playSound(c, soundSet)
                if (vibId != "default" && vibId != "off") vibratePattern(c, vibId)
            }
            AudioManager.RINGER_MODE_VIBRATE -> {
                if (vibId == "default") vibrate(c) else if (vibId != "off") vibratePattern(c, vibId)
            }
            else -> { /* silent: nothing */ }
        }
    }

    /** [soundSetting]: null = default notification sound, otherwise a sound URI string. */
    fun playSound(ctx: Context, soundSetting: String? = null) {
        try {
            val c = ctx.applicationContext
            val def = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            var ringtone: android.media.Ringtone? = null
            if (soundSetting != null && soundSetting != SOUND_SILENT) {
                ringtone = try { RingtoneManager.getRingtone(c, Uri.parse(soundSetting)) } catch (_: Throwable) { null }
            }
            if (ringtone == null) ringtone = RingtoneManager.getRingtone(c, def)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                ringtone.audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()
            }
            try { lastRingtone?.stop() } catch (_: Throwable) { }
            lastRingtone = ringtone // keep a reference so it is not collected while playing
            ringtone.play()
        } catch (e: Exception) { }
    }

    @Suppress("DEPRECATION")
    fun vibrate(ctx: Context) {
        try {
            val v = ctx.applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator ?: return
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                v.vibrate(250)
            }
        } catch (e: Throwable) { }
    }

    /** Plays the vibration pattern with this id (ignores the ring mode; used by feedback and the preview). */
    @Suppress("DEPRECATION")
    fun vibratePattern(ctx: Context, patternId: String) {
        try {
            val t = vibPatterns.firstOrNull { it.id == patternId }?.timings
            if (t == null) { if (patternId == "default") vibrate(ctx); return }
            val v = ctx.applicationContext.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator ?: return
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createWaveform(t, -1))
            } else {
                v.vibrate(t, -1)
            }
        } catch (e: Throwable) { }
    }

    /** Settings preview: this app's sound and vibration, whatever the ring mode is. */
    fun previewAlert(ctx: Context, id: String) {
        val snd = getSoundSetting(ctx, id)
        if (snd != SOUND_SILENT) playSound(ctx, snd)
        val vib = getVibId(ctx, id)
        if (vib != "off") vibratePattern(ctx, vib)
    }
}
