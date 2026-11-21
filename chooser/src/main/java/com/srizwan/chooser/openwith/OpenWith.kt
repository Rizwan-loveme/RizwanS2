package com.srizwan.chooser.openwith

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.FileProvider
import com.srizwan.chooser.R
import com.srizwan.chooser.data.AppFinder
import com.srizwan.chooser.data.ChooserFileProvider
import com.srizwan.chooser.data.ChooserKind
import com.srizwan.chooser.data.ChooserPrefs
import com.srizwan.chooser.data.MimeTypes
import com.srizwan.chooser.data.Target
import com.srizwan.chooser.ui.GlassToast
import java.io.File

/**
 * The open-with launcher (step 4): opens a file in another app WITHOUT the system chooser. This is the call the rest of the app uses.
 *
 * ```
 * OpenWith.show(activity, File("/sdcard/Download/report.pdf"))
 * OpenWith.show(activity, uri, fileName = "report.pdf", mime = "application/pdf")
 * ```
 *
 * What it does:
 *  1. A saved **Always** app for this MIME type is checked ([AppFinder.canStartView]) and started at once, no sheet. When it is gone
 *     (uninstalled / disabled) the saved choice is deleted and the sheet opens instead. [forceSheet] skips this step (the "Open with" menu item).
 *  2. Otherwise the glass [OpenWithSheet] opens. The chosen app is started with an **explicit** intent (`setComponent`), so no resolver
 *     or chooser of the system is involved.
 *  3. The file reaches the app as a `content://` uri with `FLAG_GRANT_READ_URI_PERMISSION` (a `File` goes through [ChooserFileProvider],
 *     or the provider named by `authority`; a `content://` uri is passed on as it is; a `file://` uri is turned into a `File` first).
 *  4. After the app really started, the choice is remembered (recent list, and the saved default when **Always** was pressed).
 *     When it cannot be started (`ActivityNotFoundException`, `SecurityException`, a crash while starting ...) a glass toast says so, the app is
 *     dropped from the recent list and, if it was the saved default, the saved default is deleted. A missing file is reported too and never
 *     touches the saved choices (the app is not to blame).
 *
 * Call it from the main thread. The result goes to `onResult` (optional): [Outcome.STARTED] (with the component), [Outcome.CANCELLED]
 * (the sheet was closed without a choice) or [Outcome.FAILED] (a toast was already shown).
 *
 * Step 12: when our own sheet cannot be built (it throws, or the package manager gives no app list) the same `ACTION_VIEW` goes to
 * `Intent.createChooser` inside a try / catch ([systemChooser]); then `STARTED` comes without a component and nothing is remembered.
 */
object OpenWith {

    private const val TAG = "OpenWith"

    enum class Outcome { STARTED, CANCELLED, FAILED }

    class Result(val outcome: Outcome, val component: ComponentName? = null)

    private enum class Start { OK, FILE_ERROR, APP_ERROR }

    /** Opens [file]. [mime] null = by its extension. [authority] = a FileProvider of the caller (null = [ChooserFileProvider]). */
    fun show(
        activity: Activity,
        file: File,
        mime: String? = null,
        includeSelf: Boolean = true,
        forceSheet: Boolean = false,
        authority: String? = null,
        onResult: ((Result) -> Unit)? = null
    ) {
        val type = typeOf(mime, file.name)
        if (!file.isFile) {
            fileMissing(activity, file.path, onResult)
            return
        }
        run(activity, file.name, type, includeSelf, forceSheet, onResult) {
            if (authority == null) ChooserFileProvider.uriFor(activity, file) else FileProvider.getUriForFile(activity, authority, file)
        }
    }

    /** Opens the file behind [uri] (`content://`, or `file://` for a local file). [fileName] is shown in the sheet and gives the type when [mime] is null. */
    fun show(
        activity: Activity,
        uri: Uri,
        fileName: String? = null,
        mime: String? = null,
        includeSelf: Boolean = true,
        forceSheet: Boolean = false,
        authority: String? = null,
        onResult: ((Result) -> Unit)? = null
    ) {
        val name = fileName ?: uri.lastPathSegment
        val type = typeOf(mime, name)
        run(activity, name, type, includeSelf, forceSheet, onResult) {
            if (uri.scheme == "file") {
                val path = uri.path ?: throw IllegalArgumentException("file uri without a path")
                val f = File(path)
                if (!f.isFile) throw java.io.FileNotFoundException(path)
                if (authority == null) ChooserFileProvider.uriFor(activity, f) else FileProvider.getUriForFile(activity, authority, f)
            } else uri
        }
    }

    // ── the flow ────────────────────────────────────────────────────────────

    private fun run(
        activity: Activity,
        name: String?,
        type: String,
        includeSelf: Boolean,
        forceSheet: Boolean,
        onResult: ((Result) -> Unit)?,
        makeUri: () -> Uri
    ) {
        if (activity.isFinishing || activity.isDestroyed) {
            onResult?.invoke(Result(Outcome.FAILED))
            return
        }

        // 1. a saved "Always" app
        if (!forceSheet) {
            val saved = savedApp(activity, type)
            if (saved != null) {
                when (start(activity, saved, name, type, makeUri)) {
                    Start.OK -> {
                        ChooserPrefs.recordChoice(activity, ChooserKind.VIEW, type, saved.flattenToString())
                        onResult?.invoke(Result(Outcome.STARTED, saved))
                        return
                    }
                    Start.FILE_ERROR -> {
                        fileMissing(activity, name, onResult)
                        return
                    }
                    Start.APP_ERROR -> {
                        // the saved app cannot be started any more: forget it and let the user choose again
                        forgetApp(activity, type, saved.flattenToString())
                        GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_open_failed))
                    }
                }
            }
        }

        // 2. the sheet; step 12: when it cannot be built (an exception, or no app list from the package manager) the system chooser is the last resort
        val dialog = try {
            OpenWithSheet.show(
                activity, name, type, includeSelf,
                onCancel = { onResult?.invoke(Result(Outcome.CANCELLED)) },
                onFailure = { systemChooser(activity, name, type, onResult, makeUri) }
            ) { target, always -> chosen(activity, target, always, name, type, onResult, makeUri) }
        } catch (e: Exception) {
            Log.w(TAG, "the Open with sheet could not be built", e)
            systemChooser(activity, name, type, onResult, makeUri)
            return
        }
        if (dialog == null) onResult?.invoke(Result(Outcome.FAILED))
    }

    /**
     * Step 12, the last resort: `Intent.createChooser` for the same `ACTION_VIEW`, used only when our own sheet could not be built. It is
     * wrapped in a try / catch: when even that fails a glass toast says so. The result is [Outcome.STARTED] without a component (the
     * system chooser picks the app, so nothing is remembered).
     */
    private fun systemChooser(activity: Activity, name: String?, type: String, onResult: ((Result) -> Unit)?, makeUri: () -> Uri) {
        if (activity.isFinishing || activity.isDestroyed) {
            onResult?.invoke(Result(Outcome.FAILED))
            return
        }
        val uri = try {
            makeUri()
        } catch (e: Exception) {
            fileMissing(activity, name, onResult)
            return
        }
        val view = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, type)
            clipData = ClipData.newRawUri(name ?: "file", uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        try {
            Log.i(TAG, "using the system chooser for $name")
            activity.startActivity(Intent.createChooser(view, null))
            onResult?.invoke(Result(Outcome.STARTED))
        } catch (e: Exception) {
            Log.w(TAG, "the system chooser could not be started", e)
            GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_open_failed))
            onResult?.invoke(Result(Outcome.FAILED))
        }
    }

    private fun chosen(
        activity: Activity,
        target: Target,
        always: Boolean,
        name: String?,
        type: String,
        onResult: ((Result) -> Unit)?,
        makeUri: () -> Uri
    ) {
        when (start(activity, target.component, name, type, makeUri)) {
            Start.OK -> {
                ChooserPrefs.recordChoice(activity, ChooserKind.VIEW, type, target)
                if (always) ChooserPrefs.setAlways(activity, ChooserKind.VIEW, type, target)
                onResult?.invoke(Result(Outcome.STARTED, target.component))
            }
            Start.FILE_ERROR -> fileMissing(activity, name, onResult)
            Start.APP_ERROR -> {
                forgetApp(activity, type, target.key)
                GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_open_failed))
                onResult?.invoke(Result(Outcome.FAILED, target.component))
            }
        }
    }

    /** The saved "Always" component for [type], or null (and the saved choice deleted) when it is not an app that can be started any more. */
    private fun savedApp(activity: Activity, type: String): ComponentName? {
        val key = ChooserPrefs.always(activity, ChooserKind.VIEW, type) ?: return null
        val component = ComponentName.unflattenFromString(key)
        if (component == null || !AppFinder.canStartView(activity, component, type)) {
            forgetApp(activity, type, key)
            return null
        }
        return component
    }

    /** Drops [key] from the recent list and, when it is the saved default of [type], deletes the saved default. */
    private fun forgetApp(activity: Activity, type: String, key: String) {
        ChooserPrefs.forget(activity, ChooserKind.VIEW, type, key)
        if (ChooserPrefs.always(activity, ChooserKind.VIEW, type) == key) ChooserPrefs.clearAlways(activity, ChooserKind.VIEW, type)
    }

    /** The explicit `ACTION_VIEW` start. Never throws: a failed uri is a file problem, a failed start is an app problem. */
    private fun start(activity: Activity, component: ComponentName, name: String?, type: String, makeUri: () -> Uri): Start {
        val uri = try {
            makeUri()
        } catch (e: Exception) {
            Log.w(TAG, "no uri for $name", e)
            return Start.FILE_ERROR
        }
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, type)
            setComponent(component)
            clipData = ClipData.newRawUri(name ?: "file", uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        return try {
            activity.startActivity(intent)
            Start.OK
        } catch (e: ActivityNotFoundException) {
            Log.w(TAG, "app not found: $component", e)
            Start.APP_ERROR
        } catch (e: Exception) { // SecurityException (not exported / permission), a crash while starting ...
            Log.w(TAG, "could not start $component", e)
            Start.APP_ERROR
        }
    }

    private fun fileMissing(activity: Activity, name: String?, onResult: ((Result) -> Unit)?) {
        Log.w(TAG, "file not available: $name")
        GlassToast.showOn(activity, R.drawable.ch_ic_error, activity.getString(R.string.ch_toast_file_missing))
        onResult?.invoke(Result(Outcome.FAILED))
    }

    private fun typeOf(mime: String?, name: String?): String =
        mime?.trim()?.takeIf { it.isNotEmpty() } ?: name?.takeIf { it.isNotBlank() }?.let { MimeTypes.forName(it) } ?: MimeTypes.ANY
}
