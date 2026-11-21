package com.srizwan.chooser.receive

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Outline
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.srizwan.chooser.R
import com.srizwan.chooser.data.ChooserKind
import com.srizwan.chooser.data.ChooserPrefs
import com.srizwan.chooser.openwith.OpenWith
import com.srizwan.chooser.share.Share
import com.srizwan.chooser.ui.AppGrid
import com.srizwan.chooser.ui.GlassButtons
import com.srizwan.chooser.ui.GlassDrawable
import com.srizwan.chooser.ui.GlassSheet
import com.srizwan.chooser.ui.GlassShimmerView
import com.srizwan.chooser.ui.GlassToast
import com.srizwan.chooser.ui.GlassUi
import com.srizwan.chooser.ui.VectorLabelDrawable
import com.srizwan.chooser.ui.VectorText
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

/**
 * Step 10: this app as an "Open with" and Share target for other apps, as a glass sheet over a see-through screen.
 *
 * Other apps reach it through three filters (see the manifest): `VIEW` (alias "Open with"), `SEND` and `SEND_MULTIPLE` (alias "Save to Files").
 * What it offers:
 *  - one file: **Open with** (our own glass app sheet, [OpenWith]), **Save to Files**, **Share**;
 *  - many files: **Save to Files**, **Share**;
 *  - text or a link: **Copy**, **Save as text file**, **Share**.
 *  - a `VIEW` for which an "Always" app is saved is opened in that app at once (the sheet only shows if that app fails).
 *
 * Trust: the intent is from a stranger, so [ReceiveParser] accepts only `content://` uris of other apps; names are cleaned and files are never
 * overwritten ([ReceiveSaver]). Tapping outside the sheet (or Back) cancels a running copy and removes its partial file.
 * Not exported itself: only the aliases are.
 */
class ReceiveActivity : AppCompatActivity() {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
    private var job: Job? = null
    private var dialog: Dialog? = null
    private var dismissSheet: () -> Unit = {}
    private lateinit var holder: FrameLayout
    private val thumbView by lazy { ImageView(this) }

    /** True while a follow-up flow (the Open with or Share sheet) owns the screen, so closing our own sheet must not finish the activity. */
    private var keepAlive = false
    private var content: ReceivedContent? = null

    private fun dp(v: Float) = GlassUi.dp(this, v)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val parsed = ReceiveParser.parse(this, intent)
        scope.launch(Dispatchers.IO) { ReceiveSaver.trimCache(applicationContext) }
        if (parsed == null || (parsed.items.isEmpty() && parsed.text == null)) {
            showEmpty()
            return
        }
        content = parsed
        scope.launch {
            withContext(Dispatchers.IO) { parsed.items.forEach { ReceiveSaver.describe(applicationContext, it, parsed.typeHint) } }
            start(parsed)
        }
    }

    override fun onStart() {
        super.onStart()
        GlassToast.host = this
    }

    override fun onStop() {
        super.onStop()
        if (GlassToast.host === this) GlassToast.host = null
    }

    override fun onDestroy() {
        super.onDestroy()
        dialog?.setOnDismissListener(null)
        try { dialog?.dismiss() } catch (e: Exception) { /* already gone */ }
        scope.cancel()
    }

    // ── the sheet ───────────────────────────────────────────────────────────

    private fun start(c: ReceivedContent) {
        if (isFinishing || isDestroyed) return
        val single = c.items.singleOrNull()
        // a saved "Always" app opens a VIEW at once; the sheet only shows (busy) while the private copy is made
        val direct = c.view && single != null && ChooserPrefs.always(this, ChooserKind.VIEW, single.mime) != null
        showSheet(headerOf(c)) { if (direct) busyView() else actionsView(c) }
        if (direct && single != null) openStaged(single, force = false)
        else single?.let { loadThumb(it) }
    }

    private fun showEmpty() {
        showSheet(null) {
            AppGrid.empty(
                this, R.drawable.ch_ic_file,
                getString(R.string.ch_recv_empty_title), getString(R.string.ch_recv_empty_text),
                getString(R.string.ch_recv_done), R.drawable.ch_ic_check
            ) { dismissSheet() }
        }
    }

    /** Opens the glass card; [header] (title + one line) is shown above [body], which can be swapped later through [holder]. */
    private fun showSheet(header: Header?, body: () -> View) {
        val d = try {
            GlassSheet.showContent(this) { dismiss ->
                dismissSheet = dismiss
                holder = FrameLayout(this).apply { addView(body()) }
                LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    setPadding(dp(16f), dp(14f), dp(16f), dp(16f))
                    if (header != null) addView(headerView(header))
                    addView(holder, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                        topMargin = if (header != null) dp(12f) else 0
                    })
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "the sheet could not be shown", e)
            null
        }
        if (d == null) {
            finish()
            return
        }
        dialog = d
        d.setOnDismissListener {
            job?.cancel() // a running copy stops and deletes its partial file
            if (!keepAlive) finish()
        }
    }

    private fun swap(view: View) {
        if (!::holder.isInitialized) return
        holder.removeAllViews()
        holder.addView(view)
    }

    // ── header ──────────────────────────────────────────────────────────────

    private class Header(val title: String, val subtitle: String, @DrawableRes val icon: Int)

    private fun headerOf(c: ReceivedContent): Header {
        val title = getString(if (c.view) R.string.ch_recv_open_title else R.string.ch_recv_title)
        val single = c.items.singleOrNull()
        val (sub, icon) = when {
            single != null -> {
                val size = if (single.size >= 0) " · " + ReceiveSaver.sizeText(this, single.size) else ""
                (single.name + size) to iconFor(single.mime)
            }
            c.items.size > 1 -> getString(R.string.ch_share_count, c.items.size) to R.drawable.ch_ic_file
            else -> (c.text.orEmpty().lineSequence().firstOrNull { it.isNotBlank() }?.trim().orEmpty().take(120)) to R.drawable.ch_ic_text
        }
        return Header(title, sub, icon)
    }

    private fun iconFor(mime: String): Int = when (mime.substringBefore('/')) {
        "image" -> R.drawable.ch_ic_image
        "video" -> R.drawable.ch_ic_video
        "audio" -> R.drawable.ch_ic_audio
        "text" -> R.drawable.ch_ic_text
        else -> R.drawable.ch_ic_file
    }

    private fun headerView(h: Header): View {
        thumbView.apply {
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            background = GlassDrawable(this@ReceiveActivity, 14f)
            val p = dp(14f)
            setPadding(p, p, p, p)
            setImageDrawable(VectorLabelDrawable(this@ReceiveActivity, null, h.icon, iconSizeDp = 28f))
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, dp(14f).toFloat())
                }
            }
            clipToOutline = true
        }
        val title = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@ReceiveActivity, h.title, R.drawable.ch_ic_open_with, textSizeDp = 17f, iconSizeDp = 22f))
        }
        val texts = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_VERTICAL
            addView(title, LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dp(30f)))
            if (h.subtitle.isNotBlank()) {
                val line = VectorText(this@ReceiveActivity).apply { set(h.subtitle, 13f, ContextCompat.getColor(this@ReceiveActivity, R.color.ch_text_dim)) }
                addView(line, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { topMargin = dp(2f) })
            }
        }
        return LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            addView(thumbView, LinearLayout.LayoutParams(dp(56f), dp(56f)))
            addView(texts, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply { marginStart = dp(12f) })
        }
    }

    private fun loadThumb(item: ReceivedItem) {
        if (!item.mime.startsWith("image/")) return
        scope.launch {
            val bmp = withContext(Dispatchers.IO) { ReceiveSaver.thumbnail(applicationContext, item, dp(56f)) }
            if (bmp != null && dialog?.isShowing == true) {
                thumbView.setPadding(0, 0, 0, 0)
                thumbView.scaleType = ImageView.ScaleType.CENTER_CROP
                thumbView.setImageBitmap(bmp)
            }
        }
    }

    // ── actions ─────────────────────────────────────────────────────────────

    private fun button(label: Int, icon: Int, primary: Boolean, onClick: () -> Unit): View =
        GlassButtons.pill(this, getString(label), primary, icon, onClick)

    private fun column(vararg views: View): View = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        views.forEachIndexed { i, v ->
            addView(v, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(48f)).apply { if (i > 0) topMargin = dp(8f) })
        }
    }

    private fun actionsView(c: ReceivedContent): View {
        val single = c.items.singleOrNull()
        val buttons = ArrayList<View>()
        when {
            c.items.isEmpty() -> { // text
                buttons += button(R.string.ch_copy, R.drawable.ch_ic_copy, true) { copyText(c.text.orEmpty()) }
                buttons += button(R.string.ch_recv_save_text, R.drawable.ch_ic_save, false) { save(c) }
                buttons += button(R.string.ch_share, R.drawable.ch_ic_share, false) { shareText(c.text.orEmpty()) }
            }
            single != null -> {
                val open = button(R.string.ch_recv_open_with, R.drawable.ch_ic_open_with, c.view) { openStaged(single, force = true) }
                val save = button(R.string.ch_recv_save, R.drawable.ch_ic_save, !c.view) { save(c) }
                if (c.view) { buttons += open; buttons += save } else { buttons += save; buttons += open }
                buttons += button(R.string.ch_share, R.drawable.ch_ic_share, false) { shareFiles(c) }
            }
            else -> {
                buttons += button(R.string.ch_recv_save, R.drawable.ch_ic_save, true) { save(c) }
                buttons += button(R.string.ch_share, R.drawable.ch_ic_share, false) { shareFiles(c) }
            }
        }
        val col = column(*buttons.toTypedArray()) as LinearLayout
        if (c.skipped > 0) {
            val note = VectorText(this).apply {
                set(getString(R.string.ch_recv_skipped, c.skipped), 12f, ContextCompat.getColor(this@ReceiveActivity, R.color.ch_text_dim), maxLines = 2, center = true)
            }
            col.addView(note, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { topMargin = dp(10f) })
        }
        return col
    }

    private fun busyView(): View = GlassShimmerView(this).apply {
        configure(GlassShimmerView.Style.APPS, 3)
        layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(110f))
    }

    private fun failed() {
        swap(resultView(false, getString(R.string.ch_recv_failed_title), getString(R.string.ch_recv_failed_text), null))
    }

    private fun resultView(ok: Boolean, title: String, detail: String?, showIn: File?): View {
        val icon = ImageView(this).apply {
            scaleType = ImageView.ScaleType.CENTER_INSIDE
            background = GlassDrawable(this@ReceiveActivity, 32f)
            val p = dp(12f)
            setPadding(p, p, p, p)
            setImageDrawable(VectorLabelDrawable(this@ReceiveActivity, null, if (ok) R.drawable.ch_ic_check else R.drawable.ch_ic_error, iconSizeDp = 28f))
            importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        val t = VectorText(this).apply { set(title, 16f, 0xFFFFFFFF.toInt(), bold = true, maxLines = 2, center = true) }
        val col = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            addView(icon, LinearLayout.LayoutParams(dp(64f), dp(64f)))
            addView(t, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { topMargin = dp(10f) })
            if (!detail.isNullOrBlank()) {
                val d = VectorText(this@ReceiveActivity).apply {
                    set(detail, 13f, ContextCompat.getColor(this@ReceiveActivity, R.color.ch_text_dim), maxLines = 3, center = true)
                }
                addView(d, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { topMargin = dp(4f) })
            }
        }
        val buttons = ArrayList<View>()
        if (showIn != null) buttons += button(R.string.ch_recv_show, R.drawable.ch_ic_folder, true) { showInFiles(showIn) }
        buttons += button(R.string.ch_recv_done, R.drawable.ch_ic_check, showIn == null) { dismissSheet() }
        col.addView(column(*buttons.toTypedArray()), LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
            topMargin = dp(14f)
        })
        return col
    }

    // ── what the buttons do ─────────────────────────────────────────────────

    private fun save(c: ReceivedContent) {
        swap(busyView())
        job = scope.launch {
            try {
                val dest = withContext(Dispatchers.IO) { ReceiveSaver.destination(applicationContext) }
                val saved = ArrayList<File>()
                var total = c.items.size
                withContext(Dispatchers.IO) {
                    for (item in c.items) {
                        try {
                            saved += ReceiveSaver.copy(applicationContext, item, dest.dir)
                        } catch (e: CancellationException) {
                            throw e
                        } catch (e: Exception) {
                            Log.w(TAG, "could not save ${item.name}", e)
                        }
                    }
                    if (c.items.isEmpty() && c.text != null) {
                        total = 1
                        try { saved += ReceiveSaver.saveText(dest.dir, c.text) } catch (e: Exception) { Log.w(TAG, "could not save the text", e) }
                    }
                    if (dest.shared) ReceiveSaver.scan(applicationContext, saved)
                }
                if (saved.isEmpty()) {
                    failed()
                } else {
                    val title = if (saved.size == total) getString(R.string.ch_recv_saved) else getString(R.string.ch_recv_saved_some, saved.size, total)
                    swap(resultView(true, title, getString(R.string.ch_recv_saved_to, dest.label), saved.first().parentFile))
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.w(TAG, "save failed", e)
                failed()
            }
        }
    }

    /** Makes a private copy, then hands it to the glass "Open with" sheet. [force] = show the sheet even when an "Always" app is saved. */
    private fun openStaged(item: ReceivedItem, force: Boolean) {
        swap(busyView())
        job = scope.launch {
            val file = try {
                withContext(Dispatchers.IO) { ReceiveSaver.stage(applicationContext, item) }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.w(TAG, "could not prepare ${item.name}", e)
                failed()
                return@launch
            }
            keepAlive = true
            dialog?.dismiss()
            OpenWith.show(this@ReceiveActivity, file, item.mime, true, force, null) { finish() }
        }
    }

    private fun shareFiles(c: ReceivedContent) {
        swap(busyView())
        job = scope.launch {
            val files = try {
                withContext(Dispatchers.IO) { c.items.map { ReceiveSaver.stage(applicationContext, it) } }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.w(TAG, "could not prepare the files", e)
                failed()
                return@launch
            }
            keepAlive = true
            dialog?.dismiss()
            Share.files(this@ReceiveActivity, files) { finish() }
        }
    }

    private fun shareText(text: String) {
        keepAlive = true
        dialog?.dismiss()
        Share.text(this, text) { finish() }
    }

    private fun copyText(text: String) {
        try {
            val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            cm.setPrimaryClip(ClipData.newPlainText("text", text))
            swap(resultView(true, getString(R.string.ch_toast_copied), null, null))
        } catch (e: Exception) {
            Log.w(TAG, "copy failed", e)
            failed()
        }
    }

    /** Opens the launcher's File Manager in the folder the files were saved to. */
    private fun showInFiles(dir: File?) {
        try {
            val uri = Uri.parse("rizwans2://files" + if (dir != null) "?path=" + Uri.encode(dir.absolutePath) else "")
            startActivity(Intent(Intent.ACTION_VIEW, uri).setPackage(packageName))
        } catch (e: Exception) {
            Log.w(TAG, "File Manager could not be opened", e)
            GlassToast.showOn(this, R.drawable.ch_ic_error, getString(R.string.ch_toast_open_failed))
            return
        }
        dismissSheet()
    }

    private companion object {
        const val TAG = "ReceiveActivity"
    }
}
