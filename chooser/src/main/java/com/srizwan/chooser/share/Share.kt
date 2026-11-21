package com.srizwan.chooser.share

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import com.srizwan.chooser.R
import com.srizwan.chooser.data.ChooserFileProvider
import com.srizwan.chooser.data.ChooserKind
import com.srizwan.chooser.data.ChooserPrefs
import com.srizwan.chooser.data.MimeTypes
import com.srizwan.chooser.openwith.OpenWith
import com.srizwan.chooser.ui.GlassToast
import java.io.File

/**
 * The share launcher (step 6): shares a file, several files or text WITHOUT the system chooser. The call the rest of the app will use
 * (step 7 replaces the old `Intent.createChooser` share calls with it).
 *
 * ```
 * Share.file(activity, File("/sdcard/DCIM/a.jpg"))
 * Share.files(activity, listOfFiles, authority = GalleryFileProvider.authority(activity))
 * Share.uris(activity, uris, names, mime = "video/mp4")
 * Share.text(activity, "https://example.com", subject = "A link")
 * ```
 *
 *  - One file: `ACTION_SEND`; several: `ACTION_SEND_MULTIPLE` with the common type ([MimeTypes.forNames], or [mime] when given); text: `ACTION_SEND`
 *    with `text/plain`. Files are handed over as `content://` uris with `FLAG_GRANT_READ_URI_PERMISSION` and a `ClipData` (so the grant covers every uri),
 *    through [ChooserFileProvider] or the caller's own provider (`authority`).
 *  - The apps come from [com.srizwan.chooser.data.AppFinder.findSend]; this app's own activities are hidden unless `includeSelf = true`.
 *  - The chosen app is started with an **explicit intent** (`setComponent`). After a successful start it goes to the front of the recent list.
 *    When it cannot be started a glass toast says so and the app leaves the recent list; a missing file is reported too. Nothing throws to the caller.
 *  - There is no "Always" for sharing.
 *
 * Call it from the main thread. The result is the same as the open-with launcher's: [OpenWith.Result] with `STARTED`, `CANCELLED` or `FAILED`.
 *
 * Step 12: when our own sheet cannot be built (it throws, or the package manager gives no app list) the same send intent goes to
 * `Intent.createChooser` inside a try / catch ([systemChooser]); then `STARTED` comes without a component and nothing is remembered.
 */
object Share {

    private const val TAG = "Share"
    private const val SNIPPET_CHARS = 120

    private enum class Start { OK, FILE_ERROR, APP_ERROR }

    /** One file. [mime] null = by its extension. */
    fun file(
        activity: Activity,
        file: File,
        mime: String? = null,
        includeSelf: Boolean = false,
        authority: String? = null,
        onResult: ((OpenWith.Result) -> Unit)? = null
    ) = files(activity, listOf(file), mime, includeSelf, authority, onResult)

    /** One or more files (those that do not exist are left out; when none is left a toast says so). */
    fun files(
        activity: Activity,
        files: List<File>,
        mime: String? = null,
        includeSelf: Boolean = false,
        authority: String? = null,
        onResult: ((OpenWith.Result) -> Unit)? = null
    ) {
        val usable = files.filter { it.isFile }
        if (usable.isEmpty()) {
            fileMissing(activity, onResult)
            return
        }
        val names = usable.map { it.name }
        val type = mime?.trim()?.takeIf { it.isNotEmpty() } ?: MimeTypes.forNames(names)
        val subtitle = if (usable.size == 1) usable[0].name else activity.getString(R.string.ch_share_count, usable.size)
        val thumb = usable.firstOrNull { MimeTypes.family(MimeTypes.forName(it.name)) == "image" }
        val header = ShareSheet.Header(subtitle, thumb, R.drawable.ch_ic_file)
        run(activity, header, type, usable.size, includeSelf, null, onResult) { component ->
            val uris = usable.mapNotNull { f ->
                try {
                    if (authority == null) ChooserFileProvider.uriFor(activity, f) else FileProvider.getUriForFile(activity, authority, f)
                } catch (e: Exception) {
                    Log.w(TAG, "no uri for ${f.path}", e)
                    null
                }
            }
            streamIntent(names.first(), type, uris, component)
        }
    }

    /**
     * One or more `content://` uris (`file://` uris are turned into files first). [names] are the display names (same order; the first is
     * shown when one file is shared). [mime] null = the common type of [names].
     */
    fun uris(
        activity: Activity,
        uris: List<Uri>,
        names: List<String> = emptyList(),
        mime: String? = null,
        includeSelf: Boolean = false,
        authority: String? = null,
        onResult: ((OpenWith.Result) -> Unit)? = null
    ) {
        if (uris.isEmpty()) {
            fileMissing(activity, onResult)
            return
        }
        val label = names.firstOrNull() ?: uris[0].lastPathSegment ?: "file"
        val type = mime?.trim()?.takeIf { it.isNotEmpty() } ?: if (names.isEmpty()) MimeTypes.ANY else MimeTypes.forNames(names)
        val subtitle = if (uris.size == 1) label else activity.getString(R.string.ch_share_count, uris.size)
        val header = ShareSheet.Header(subtitle, null, R.drawable.ch_ic_file)
        run(activity, header, type, uris.size, includeSelf, null, onResult) { component ->
            val ready = uris.mapNotNull { u ->
                if (u.scheme == "file") {
                    val f = u.path?.let { File(it) }
                    if (f == null || !f.isFile) null
                    else if (authority == null) ChooserFileProvider.uriFor(activity, f) else FileProvider.getUriForFile(activity, authority, f)
                } else u
            }
            streamIntent(label, type, ready, component)
        }
    }

    /** Text or a link, with an optional [subject] (an email subject, for apps that use one). The sheet also has a Copy button. */
    fun text(
        activity: Activity,
        text: String,
        subject: String? = null,
        includeSelf: Boolean = false,
        onResult: ((OpenWith.Result) -> Unit)? = null
    ) {
        if (text.isEmpty()) {
            fileMissing(activity, onResult)
            return
        }
        val first = text.lineSequence().firstOrNull { it.isNotBlank() }?.trim().orEmpty().take(SNIPPET_CHARS)
        val header = ShareSheet.Header(first, null, R.drawable.ch_ic_text)
        run(activity, header, "text/plain", 1, includeSelf, text, onResult) { component ->
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
                if (!subject.isNullOrEmpty()) putExtra(Intent.EXTRA_SUBJECT, subject)
                setComponent(component)
            }
        }
    }

    // ── the flow ────────────────────────────────────────────────────────────

    private fun run(
        activity: Activity,
        header: ShareSheet.Header,
        type: String,
        count: Int,
        includeSelf: Boolean,
        copyText: String?,
        onResult: ((OpenWith.Result) -> Unit)?,
        makeIntent: (ComponentName?) -> Intent
    ) {
        val dialog = try {
            ShareSheet.show(
                activity, header, type, count, includeSelf, copyText,
                onCancel = { onResult?.invoke(OpenWith.Result(OpenWith.Outcome.CANCELLED)) },
                // step 12: no app list from the package manager: the system chooser is the last resort
                onFailure = { systemChooser(activity, makeIntent, onResult) }
            ) { target ->
                when (start(activity, target.component, makeIntent)) {
                    Start.OK -> {
                        ChooserPrefs.recordChoice(activity, ChooserKind.SEND, type, target)
                        onResult?.invoke(OpenWith.Result(OpenWith.Outcome.STARTED, target.component))
                    }
                    Start.FILE_ERROR -> fileMissing(activity, onResult)
                    Start.APP_ERROR -> {
                        ChooserPrefs.forget(activity, ChooserKind.SEND, type, target.key)
                        GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_share_failed))
                        onResult?.invoke(OpenWith.Result(OpenWith.Outcome.FAILED, target.component))
                    }
                }
            }
        } catch (e: Exception) {
            Log.w(TAG, "the Share sheet could not be built", e)
            systemChooser(activity, makeIntent, onResult)
            return
        }
        if (dialog == null) onResult?.invoke(OpenWith.Result(OpenWith.Outcome.FAILED))
    }

    /**
     * Step 12, the last resort: `Intent.createChooser` for the same send intent (no component), used only when our own sheet could not be
     * built. Wrapped in a try / catch: when even that fails a glass toast says so. The result is `STARTED` without a component, nothing
     * is remembered. The read grant and the clip data of the intent are carried over to the chooser by the system.
     */
    private fun systemChooser(activity: Activity, makeIntent: (ComponentName?) -> Intent, onResult: ((OpenWith.Result) -> Unit)?) {
        if (activity.isFinishing || activity.isDestroyed) {
            onResult?.invoke(OpenWith.Result(OpenWith.Outcome.FAILED))
            return
        }
        val intent = try {
            makeIntent(null)
        } catch (e: Exception) {
            Log.w(TAG, "nothing to share", e)
            fileMissing(activity, onResult)
            return
        }
        try {
            Log.i(TAG, "using the system chooser")
            activity.startActivity(Intent.createChooser(intent, null))
            onResult?.invoke(OpenWith.Result(OpenWith.Outcome.STARTED))
        } catch (e: Exception) {
            Log.w(TAG, "the system chooser could not be started", e)
            GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_share_failed))
            onResult?.invoke(OpenWith.Result(OpenWith.Outcome.FAILED))
        }
    }

    /** `ACTION_SEND` for one uri, `ACTION_SEND_MULTIPLE` for several, with the read grant on every uri. Throws when no uri is left (a file problem). */
    private fun streamIntent(name: String, type: String, uris: List<Uri>, component: ComponentName?): Intent {
        if (uris.isEmpty()) throw java.io.FileNotFoundException("no file to share")
        val intent = if (uris.size == 1) {
            Intent(Intent.ACTION_SEND).putExtra(Intent.EXTRA_STREAM, uris[0])
        } else {
            Intent(Intent.ACTION_SEND_MULTIPLE).putParcelableArrayListExtra(Intent.EXTRA_STREAM, ArrayList(uris))
        }
        val clip = ClipData.newRawUri(name, uris[0])
        for (i in 1 until uris.size) clip.addItem(ClipData.Item(uris[i]))
        return intent.apply {
            this.type = type
            clipData = clip
            setComponent(component)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
    }

    /** Never throws: a failure to build the intent is a file problem, a failure to start is an app problem. */
    private fun start(activity: Activity, component: ComponentName, makeIntent: (ComponentName) -> Intent): Start {
        val intent = try {
            makeIntent(component)
        } catch (e: Exception) {
            Log.w(TAG, "nothing to share", e)
            return Start.FILE_ERROR
        }
        return try {
            activity.startActivity(intent)
            Start.OK
        } catch (e: ActivityNotFoundException) {
            Log.w(TAG, "app not found: $component", e)
            Start.APP_ERROR
        } catch (e: Exception) { // SecurityException, TransactionTooLargeException for huge text, a crash while starting ...
            Log.w(TAG, "could not start $component", e)
            Start.APP_ERROR
        }
    }

    private fun fileMissing(activity: Activity, onResult: ((OpenWith.Result) -> Unit)?) {
        GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_file_missing))
        onResult?.invoke(OpenWith.Result(OpenWith.Outcome.FAILED))
    }
}
