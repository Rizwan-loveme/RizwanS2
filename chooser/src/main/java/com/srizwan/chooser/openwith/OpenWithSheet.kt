package com.srizwan.chooser.openwith

import android.app.Activity
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R
import com.srizwan.chooser.data.AppFinder
import com.srizwan.chooser.data.MimeTypes
import com.srizwan.chooser.data.PackageWatcher
import com.srizwan.chooser.data.Target
import com.srizwan.chooser.settings.ChooserSettings
import com.srizwan.chooser.ui.AppGrid
import com.srizwan.chooser.ui.AppListHost
import com.srizwan.chooser.ui.GlassButtons
import com.srizwan.chooser.ui.GlassSheet
import com.srizwan.chooser.ui.GlassShimmerView
import com.srizwan.chooser.ui.GlassToast
import com.srizwan.chooser.ui.GlassUi
import com.srizwan.chooser.ui.VectorLabelDrawable
import com.srizwan.chooser.ui.VectorText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.util.Locale

/**
 * The own "Open with" sheet (step 3): a glass card at the bottom of the screen with the apps that can open a file, as a grid of
 * icons and names, instead of the system chooser (on Tecno / Infinix / itel phones the "TranResolver").
 *
 * How it works:
 *  1. The sheet opens at once with a loading skeleton and asks [AppFinder] for the apps (on `Dispatchers.IO`).
 *  2. Tap an app to select it, then press **Just once** or **Always**. Tapping the selected app again opens it just once.
 *     Press and hold an app to see its details (the system "App info" screen).
 *  3. When nothing can open the file, the sheet says so and offers **Find in store** (Play Store search for a fitting app).
 *
 * The sheet only chooses: it calls `onChoose(target, always)` and closes. Starting the app (explicit intent, FileProvider grant,
 * failure handling) and saving the "Always" choice ([com.srizwan.chooser.data.ChooserPrefs.setAlways]) belong to the launcher of
 * step 4, which saves it only after the app really started, so an app that fails is never remembered.
 *
 * The grid itself is [AppGrid] (shared with the Share sheet of step 6). Text is drawn as vector outlines, like everywhere in the Chooser
 * (no TextView, no EditText).
 *
 * Step 11: the look follows the settings (grid or list, apps per row); a very long list scrolls inside the sheet while Just once /
 * Always stay in reach; the sheet re-layouts on rotation and keeps the selected app; it asks for the apps again when an app is installed
 * or removed while it is open, and when it gets the focus back (after the settings or an App info screen); the gear opens the settings.
 */
object OpenWithSheet {

    private const val TAG = "OpenWithSheet"

    /** Height kept for what is not the app list: padding, header, hint and buttons (dp). The list scrolls inside the rest. */
    private const val RESERVE_DP = 200f

    /**
     * Shows the sheet; returns the dialog, or null when [activity] is finishing.
     *
     * @param fileName the name shown under the title (and the source of the type when [mime] is null).
     * @param mime the file's MIME type; null = taken from [fileName]'s extension (the "any type" wildcard when that is unknown too).
     * @param includeSelf false hides this app's own activities (for example when the caller already is the Gallery viewer).
     * @param onCancel called when the sheet is closed without a choice (tap outside, Back, or the finishing of the activity).
     * @param onFailure step 12: called, after the sheet was closed (and without [onCancel]), when the package manager could not give the
     *   first app list. The launcher then opens the system chooser. When null the sheet shows the "no app" state instead.
     * @param onChoose the chosen app and whether "Always" was pressed.
     */
    fun show(
        activity: Activity,
        fileName: String?,
        mime: String? = null,
        includeSelf: Boolean = true,
        onCancel: (() -> Unit)? = null,
        onFailure: (() -> Unit)? = null,
        onChoose: (target: Target, always: Boolean) -> Unit
    ): Dialog? {
        if (activity.isFinishing || activity.isDestroyed) return null
        val type = mime?.trim()?.takeIf { it.isNotEmpty() }
            ?: fileName?.takeIf { it.isNotBlank() }?.let { MimeTypes.forName(it) }
            ?: MimeTypes.ANY

        fun dp(v: Float) = GlassUi.dp(activity, v)
        var chosen = false
        var dismissSheet: () -> Unit = {}
        val host = AppListHost(activity)
        var targets: List<Target>? = null // null = the first answer is still on its way
        var selectedKey: String? = null // kept over a rebuild (rotation, refresh)
        var loadJob: Job? = null
        var load: () -> Unit = {}

        val dialog = GlassSheet.showContent(activity, maxFraction = AppGrid.SHEET_MAX_FRACTION) { dismiss ->
            dismissSheet = dismiss
            val skeleton = GlassShimmerView(activity).apply { configure(GlassShimmerView.Style.APPS, AppGrid.skeletonColumns(activity)) }
            host.addView(skeleton, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(190f)))
            LinearLayout(activity).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(16f), dp(14f), dp(16f), dp(16f))
                addView(header(activity, fileName))
                addView(host, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(10f)
                })
            }
        } ?: return null

        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
        val watcher = PackageWatcher(activity) { if (dialog.isShowing) load() }
        var cleaned = false
        fun cleanup() {
            if (cleaned) return
            cleaned = true
            watcher.stop()
            scope.cancel()
        }
        dialog.setOnDismissListener {
            cleanup()
            if (!chosen) onCancel?.invoke()
        }
        host.onGone = { cleanup() }

        val pick = { target: Target, always: Boolean ->
            chosen = true
            dismissSheet()
            onChoose(target, always)
        }

        // draws the list (or the empty state) from what [targets] holds now
        fun render() {
            val list = targets ?: return
            host.removeAllViews()
            if (list.isEmpty()) {
                host.addView(
                    AppGrid.empty(
                        activity, R.drawable.ch_ic_apps,
                        activity.getString(R.string.ch_open_empty_title),
                        activity.getString(R.string.ch_open_empty_text, kindLabel(fileName, type)),
                        activity.getString(R.string.ch_find_in_store), R.drawable.ch_ic_store
                    ) {
                        dismissSheet()
                        openStore(activity, storeQuery(fileName, type))
                    }
                )
            } else {
                host.addView(appsView(activity, list, AppGrid.columnsFor(activity), selectedKey, { selectedKey = it }, pick))
            }
        }

        // asks the package manager again (first start, an app was installed or removed, back from the settings)
        load = {
            loadJob?.cancel()
            loadJob = scope.launch {
                val found = try {
                    AppFinder.findViewStrict(activity, null, type, includeSelf)
                } catch (e: AppFinder.QueryFailedException) {
                    null
                }
                if (!dialog.isShowing) return@launch
                if (found == null) {
                    when {
                        targets != null -> return@launch // a failed refresh keeps the list that is on screen
                        onFailure != null -> {
                            chosen = true // not a cancel: no onCancel call for this close
                            dismissSheet()
                            onFailure()
                            return@launch
                        }
                    }
                }
                targets = found ?: emptyList()
                render()
            }
        }
        host.onReflow = { if (dialog.isShowing) render() }
        host.onResume = { if (dialog.isShowing) load() }
        watcher.start()
        load()
        return dialog
    }

    // ── pieces ──────────────────────────────────────────────────────────────

    /** "Open with" with its icon, the file name (dim, one line) under it, and the settings button on the right. */
    private fun header(activity: Activity, fileName: String?): View {
        fun dp(v: Float) = GlassUi.dp(activity, v)
        val title = ImageView(activity).apply {
            setImageDrawable(
                VectorLabelDrawable(activity, activity.getString(R.string.ch_open_with), R.drawable.ch_ic_open_with, textSizeDp = 17f, iconSizeDp = 22f)
            )
        }
        val texts = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            addView(title, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(30f)))
            if (!fileName.isNullOrBlank()) {
                val name = VectorText(activity).apply { set(fileName, 13f, ContextCompat.getColor(activity, R.color.ch_text_dim)) }
                addView(name, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(2f)
                })
            }
        }
        val gear = GlassUi.iconButton(activity, R.drawable.ch_ic_settings, R.string.ch_cd_settings, sizeDp = 40f) {
            ChooserSettings.open(activity)
        }
        return LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.TOP
            addView(texts, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            addView(gear, LinearLayout.LayoutParams(dp(40f), dp(40f)).apply { marginStart = dp(8f) })
        }
    }

    /** The grid (inside its own scroll area when the list is long), the hint and the two buttons. The selected app is kept in [selectedKey]. */
    private fun appsView(
        activity: Activity,
        targets: List<Target>,
        columns: Int,
        selectedKey: String?,
        setSelected: (String?) -> Unit,
        pick: (Target, Boolean) -> Unit
    ): View {
        fun dp(v: Float) = GlassUi.dp(activity, v)
        var selected = targets.indexOfFirst { it.key == selectedKey }
        if (selected < 0 && selectedKey != null) setSelected(null) // that app is gone
        var tiles: List<View> = emptyList()

        val once = GlassButtons.pill(activity, activity.getString(R.string.ch_just_once), primary = false) {
            targets.getOrNull(selected)?.let { pick(it, false) }
        }
        val always = GlassButtons.pill(activity, activity.getString(R.string.ch_always), primary = true) {
            targets.getOrNull(selected)?.let { pick(it, true) }
        }

        fun paint() {
            tiles.forEachIndexed { i, tile ->
                tile.isSelected = i == selected
                tile.background = if (i == selected) AppGrid.selectedBackground(activity) else AppGrid.ripple(activity)
            }
            GlassButtons.setEnabled(once, selected >= 0)
            GlassButtons.setEnabled(always, selected >= 0)
        }

        val built = AppGrid.build(activity, targets, columns) { index ->
            if (selected == index) pick(targets[index], false) else {
                selected = index
                setSelected(targets[index].key)
                paint()
            }
        }
        tiles = built.tiles

        val hint = VectorText(activity).apply {
            set(activity.getString(R.string.ch_open_hint), 12f, ContextCompat.getColor(activity, R.color.ch_text_dim), maxLines = 2, center = true)
        }
        val buttons = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            addView(once, LinearLayout.LayoutParams(0, dp(48f), 1f))
            addView(always, LinearLayout.LayoutParams(0, dp(48f), 1f).apply { marginStart = dp(8f) })
        }
        paint()
        return LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            addView(AppGrid.scroller(activity, built.view, RESERVE_DP), LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
            addView(hint, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                topMargin = dp(8f)
            })
            addView(buttons, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                topMargin = dp(12f)
            })
        }
    }

    // ── helpers ─────────────────────────────────────────────────────────────

    /** `PDF` for `report.pdf`, else the MIME type (`video/x-matroska`), for the "none of your apps can open ... files" line. */
    private fun kindLabel(fileName: String?, mime: String): String {
        val ext = fileName?.substringAfterLast('.', "")?.takeIf { it.isNotEmpty() && it.length <= 10 && !it.contains('/') }
        return ext?.uppercase(Locale.ROOT) ?: mime
    }

    /** What to look for in the store: the extension plus "viewer", else a word for the kind of file. */
    private fun storeQuery(fileName: String?, mime: String): String {
        val ext = fileName?.substringAfterLast('.', "")?.lowercase(Locale.ROOT)
            ?.takeIf { it.isNotEmpty() && it.length <= 10 && !it.contains('/') }
        if (ext != null) return "$ext viewer"
        return when (MimeTypes.family(mime)) {
            "image" -> "image viewer"
            "video" -> "video player"
            "audio" -> "music player"
            "text" -> "text editor"
            else -> "file viewer"
        }
    }

    /**
     * Opens the store search: the Play Store directly (explicit package, so no chooser can appear), else the web page of the same
     * search; when neither can start, a glass toast says so.
     */
    private fun openStore(activity: Activity, query: String) {
        val q = Uri.encode(query)
        try {
            activity.startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=$q&c=apps")).setPackage("com.android.vending")
            )
            return
        } catch (e: ActivityNotFoundException) {
            Log.i(TAG, "Play Store not installed")
        } catch (e: Exception) {
            Log.w(TAG, "Play Store search failed", e)
        }
        try {
            activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=$q&c=apps")))
        } catch (e: Exception) {
            Log.w(TAG, "Web store search failed", e)
            GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_no_store))
        }
    }
}
