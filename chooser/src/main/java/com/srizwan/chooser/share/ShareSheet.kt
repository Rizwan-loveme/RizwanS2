package com.srizwan.chooser.share

import android.app.Activity
import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Outline
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R
import com.srizwan.chooser.data.AppFinder
import com.srizwan.chooser.data.ChooserKind
import com.srizwan.chooser.data.ChooserPrefs
import com.srizwan.chooser.data.PackageWatcher
import com.srizwan.chooser.data.Target
import com.srizwan.chooser.settings.ChooserSettings
import com.srizwan.chooser.ui.AppGrid
import com.srizwan.chooser.ui.AppListHost
import com.srizwan.chooser.ui.GlassButtons
import com.srizwan.chooser.ui.GlassDrawable
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
import kotlinx.coroutines.withContext
import java.io.File

/**
 * The own Share sheet (step 6): a glass card with the apps that can receive what is shared, instead of `Intent.createChooser`.
 *
 *  - **Preview header**: a small thumbnail (the first picture) or a file / text icon, the title "Share", and one line under it (the
 *    file name, "3 files", or the first line of the text).
 *  - **Recent first**: apps used for the last shares of this kind come first under a "Recent" heading, the rest under "All apps"
 *    (no headings when nothing was shared before).
 *  - **One tap sends**: sharing has no "always", so a tap on an app chooses it. Press and hold shows the app's App info.
 *  - **Copy** (text only): a button that puts the text on the clipboard.
 *  - Nothing can receive it: a short message (and Copy for text).
 *
 * Like [com.srizwan.chooser.openwith.OpenWithSheet] it only chooses: the launcher [Share] builds the intent and starts the app.
 *
 * Step 11: the same polish as the Open with sheet. The look follows the settings (grid or list, apps per row, recent apps on or off),
 * a very long list scrolls inside the sheet so Copy stays in reach, the sheet re-layouts on rotation, asks for the apps again when
 * an app is installed or removed (or when it gets the focus back), and the gear in the header opens the settings.
 */
object ShareSheet {

    /** Height kept for what is not the app list (padding, header; plus the Copy button for text), in dp. The list scrolls inside the rest. */
    private const val RESERVE_DP = 120f
    private const val RESERVE_DP_COPY = 184f

    /** How many recent apps the list style shows under "Recent". */
    private const val RECENT_ROWS = 3

    /** What the header shows: [subtitle] (dim, one line), a picture file for the thumbnail ([thumb], decoded off the main thread) or an [icon]. */
    class Header(val subtitle: String?, val thumb: File?, @DrawableRes val icon: Int)

    /**
     * Shows the sheet; returns the dialog, or null when [activity] is finishing.
     *
     * @param mime the type of what is shared (`text/plain` for text); [count] the number of files (1 for text).
     * @param copyText when not null a Copy button is shown that copies this text.
     * @param onFailure step 12: called, after the sheet was closed (and without [onCancel]), when the package manager could not give the
     *   first app list. The launcher then opens the system chooser. When null the sheet shows the "no app" state instead.
     */
    fun show(
        activity: Activity,
        header: Header,
        mime: String,
        count: Int,
        includeSelf: Boolean = false,
        copyText: String? = null,
        onCancel: (() -> Unit)? = null,
        onFailure: (() -> Unit)? = null,
        onChoose: (Target) -> Unit
    ): Dialog? {
        if (activity.isFinishing || activity.isDestroyed) return null
        fun dp(v: Float) = GlassUi.dp(activity, v)
        var chosen = false
        var dismissSheet: () -> Unit = {}
        val host = AppListHost(activity)
        val thumbView = ImageView(activity)
        var targets: List<Target>? = null // null = the first answer is still on its way
        var loadJob: Job? = null
        var load: () -> Unit = {}

        val dialog = GlassSheet.showContent(activity, maxFraction = AppGrid.SHEET_MAX_FRACTION) { dismiss ->
            dismissSheet = dismiss
            val skeleton = GlassShimmerView(activity).apply { configure(GlassShimmerView.Style.APPS, AppGrid.skeletonColumns(activity)) }
            host.addView(skeleton, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(190f)))
            LinearLayout(activity).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp(16f), dp(14f), dp(16f), dp(16f))
                addView(headerView(activity, header, thumbView))
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

        val pick = { target: Target ->
            chosen = true
            dismissSheet()
            onChoose(target)
        }
        val copy = copyText?.let { text ->
            { copyToClipboard(activity, text); dismissSheet() }
        }

        // thumbnail (only for a picture file; failures keep the icon)
        header.thumb?.let { file ->
            scope.launch {
                val bmp = withContext(Dispatchers.IO) { decodeThumb(file, dp(56f)) }
                if (bmp != null && dialog.isShowing) {
                    thumbView.setPadding(0, 0, 0, 0)
                    thumbView.scaleType = ImageView.ScaleType.CENTER_CROP
                    thumbView.setImageBitmap(bmp)
                }
            }
        }

        // draws the list (or the empty state) from what [targets] holds now
        fun render() {
            val list = targets ?: return
            host.removeAllViews()
            if (list.isEmpty()) {
                host.addView(
                    AppGrid.empty(
                        activity, R.drawable.ch_ic_apps,
                        activity.getString(R.string.ch_share_empty_title),
                        activity.getString(R.string.ch_share_empty_text),
                        if (copy != null) activity.getString(R.string.ch_copy) else null,
                        R.drawable.ch_ic_copy
                    ) { copy?.invoke() }
                )
            } else {
                host.addView(appsView(activity, list, AppGrid.columnsFor(activity), mime, pick, copy))
            }
        }

        // asks the package manager again (first start, an app was installed or removed, back from the settings)
        load = {
            loadJob?.cancel()
            loadJob = scope.launch {
                val found = try {
                    AppFinder.findSendStrict(activity, mime, count, includeSelf)
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

    /** The thumbnail / icon square, the title "Share" and the dim line under it. */
    private fun headerView(activity: Activity, header: Header, thumbView: ImageView): View {
        fun dp(v: Float) = GlassUi.dp(activity, v)
        thumbView.apply {
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            background = GlassDrawable(activity, 14f)
            val p = dp(14f)
            setPadding(p, p, p, p)
            setImageDrawable(VectorLabelDrawable(activity, null, header.icon, iconSizeDp = 28f))
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, dp(14f).toFloat())
                }
            }
            clipToOutline = true
        }
        val title = ImageView(activity).apply {
            setImageDrawable(
                VectorLabelDrawable(activity, activity.getString(R.string.ch_share), R.drawable.ch_ic_share, textSizeDp = 17f, iconSizeDp = 22f)
            )
        }
        val texts = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
            addView(title, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(30f)))
            if (!header.subtitle.isNullOrBlank()) {
                val line = VectorText(activity).apply { set(header.subtitle, 13f, ContextCompat.getColor(activity, R.color.ch_text_dim)) }
                addView(line, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                    topMargin = dp(2f)
                })
            }
        }
        val gear = GlassUi.iconButton(activity, R.drawable.ch_ic_settings, R.string.ch_cd_settings, sizeDp = 40f) {
            ChooserSettings.open(activity)
        }
        return LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            addView(thumbView, LinearLayout.LayoutParams(dp(56f), dp(56f)))
            addView(texts, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply { marginStart = dp(12f) })
            addView(gear, LinearLayout.LayoutParams(dp(40f), dp(40f)).apply { marginStart = dp(8f) })
        }
    }

    /**
     * Recent apps first (one row at most, three in the list style, under "Recent"), the others under "All apps"; both sit in one scroll
     * area so a very long list does not push the Copy button (text only) out of reach. With "Remember recent apps" switched off there
     * is no recent part.
     */
    private fun appsView(
        activity: Activity,
        targets: List<Target>,
        columns: Int,
        mime: String,
        pick: (Target) -> Unit,
        copy: (() -> Unit)?
    ): View {
        fun dp(v: Float) = GlassUi.dp(activity, v)
        val recentKeys = ChooserPrefs.recent(activity, ChooserKind.SEND, mime).toSet()
        val recent = targets.filter { it.key in recentKeys }.take(if (AppGrid.isList(activity)) RECENT_ROWS else columns)
        val others = targets.filter { it !in recent }

        val col = LinearLayout(activity).apply { orientation = LinearLayout.VERTICAL }
        fun section(label: String?, list: List<Target>) {
            if (list.isEmpty()) return
            if (label != null) col.addView(AppGrid.sectionLabel(activity, label))
            col.addView(
                AppGrid.build(activity, list, columns) { index -> pick(list[index]) }.view,
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            )
        }
        if (recent.isEmpty()) {
            section(null, others)
        } else {
            section(activity.getString(R.string.ch_share_recent), recent)
            section(if (others.isEmpty()) null else activity.getString(R.string.ch_share_all), others)
        }

        val reserve = if (copy != null) RESERVE_DP_COPY else RESERVE_DP
        val out = LinearLayout(activity).apply { orientation = LinearLayout.VERTICAL }
        out.addView(AppGrid.scroller(activity, col, reserve), LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
        if (copy != null) {
            val b = GlassButtons.pill(activity, activity.getString(R.string.ch_copy), primary = false, icon = R.drawable.ch_ic_copy) { copy() }
            out.addView(b, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(48f)).apply { topMargin = dp(12f) })
        }
        return out
    }

    private fun copyToClipboard(activity: Activity, text: String) {
        try {
            val cm = activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cm.setPrimaryClip(ClipData.newPlainText("text", text))
            GlassToast.showOn(activity, R.drawable.ch_ic_check, activity.getString(R.string.ch_toast_copied))
        } catch (e: Exception) {
            android.util.Log.w("ShareSheet", "copy failed", e)
            GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_share_failed))
        }
    }

    /** A small bitmap of [file] (about [targetPx] on the short side), or null when it cannot be decoded. Blocking: call off the main thread. */
    private fun decodeThumb(file: File, targetPx: Int): Bitmap? = try {
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(file.path, bounds)
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) {
            null
        } else {
            var sample = 1
            while (bounds.outWidth / (sample * 2) >= targetPx && bounds.outHeight / (sample * 2) >= targetPx) sample *= 2
            BitmapFactory.decodeFile(file.path, BitmapFactory.Options().apply { inSampleSize = sample })
        }
    } catch (e: Exception) {
        null
    } catch (e: OutOfMemoryError) {
        null
    }
}
