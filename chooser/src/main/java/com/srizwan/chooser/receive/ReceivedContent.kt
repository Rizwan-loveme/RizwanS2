package com.srizwan.chooser.receive

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Parcelable
import android.util.Log
import java.util.Locale

/** One file another app handed over: its `content://` uri and what we learned about it ([ReceiveSaver.describe] fills name, size and type). */
internal class ReceivedItem(val uri: Uri) {
    var name: String = "file"
    var size: Long = -1L
    var mime: String = "*/*"
}

/**
 * What an incoming `VIEW` / `SEND` / `SEND_MULTIPLE` intent carries, after the safety checks of [ReceiveParser].
 *
 * @property view true for `ACTION_VIEW` (another app wants a file opened), false for a share.
 * @property items the accepted files (never more than [ReceiveParser.MAX_FILES]).
 * @property text shared text or a link, when no file came with it.
 * @property skipped how many uris were left out (not `content://`, one of our own providers, over the limit).
 * @property typeHint the MIME type the sender put on the intent, already checked ([ReceiveParser.cleanMime]); null when it had none or it was not valid.
 */
internal class ReceivedContent(
    val view: Boolean,
    val items: List<ReceivedItem>,
    val text: String?,
    val skipped: Int,
    val typeHint: String?
)

/**
 * Reads an incoming intent for the receive screen (step 10) and decides what is trusted. The intent comes from an app we know nothing about, so:
 *
 *  - Only `content://` uris are accepted. A `file://` uri is dropped: it would let a stranger point us at any path our process can read.
 *  - A uri of one of OUR OWN providers is dropped, too. `ChooserFileProvider` serves any path (root-path), so a stranger could otherwise send
 *    `content://<our authority>/...` and have us copy our private files to a public folder. Our own code never reaches this screen (our lists
 *    hide it), so nothing legitimate is lost.
 *  - At most [MAX_FILES] files and [MAX_TEXT] characters of text are read.
 *  - A MIME type is only used when it looks like one ([cleanMime]); names are cleaned later by [ReceiveSaver.cleanName].
 *
 * Nothing here touches the file contents: no stream is opened, so parsing is cheap and cannot block.
 */
internal object ReceiveParser {

    private const val TAG = "ReceiveParser"
    const val MAX_FILES = 200
    const val MAX_TEXT = 200_000

    private val MIME = Regex("^[a-z0-9][a-z0-9!#$&^_.+-]{0,60}/[a-z0-9*][a-z0-9!#$&^_.+*-]{0,60}$")

    fun parse(context: Context, intent: Intent?): ReceivedContent? {
        intent ?: return null
        val hint = cleanMime(intent.type)
        val raw = ArrayList<Uri>()
        var text: String? = null
        var view = false
        try {
            when (intent.action) {
                Intent.ACTION_VIEW -> {
                    view = true
                    intent.data?.let { raw.add(it) }
                }
                Intent.ACTION_SEND -> {
                    view = false
                    stream(intent)?.let { raw.add(it) }
                    if (raw.isEmpty()) raw.addAll(clipUris(intent.clipData))
                    if (raw.isEmpty()) text = textOf(intent)
                }
                Intent.ACTION_SEND_MULTIPLE -> {
                    view = false
                    raw.addAll(streams(intent))
                    if (raw.isEmpty()) raw.addAll(clipUris(intent.clipData))
                }
                else -> return null
            }
        } catch (e: Exception) { // a malformed extra must never crash the screen
            Log.w(TAG, "could not read the intent", e)
            return null
        }

        val items = ArrayList<ReceivedItem>()
        var skipped = 0
        val seen = HashSet<String>()
        for (u in raw) {
            if (items.size >= MAX_FILES) { skipped++; continue }
            if (!accept(context, u)) { skipped++; continue }
            if (seen.add(u.toString())) items.add(ReceivedItem(u))
        }
        return ReceivedContent(view, items, text, skipped, hint)
    }

    /** A usable `content://` uri of another app. */
    private fun accept(context: Context, uri: Uri): Boolean {
        if (!"content".equals(uri.scheme, ignoreCase = true)) return false
        return !isOwnProvider(context, uri)
    }

    /** True when the uri belongs to a provider of this app (or when that cannot be told: then it is refused). */
    @Suppress("DEPRECATION")
    private fun isOwnProvider(context: Context, uri: Uri): Boolean {
        val host = uri.host ?: return true
        val me = context.packageName
        if (host.equals(me, ignoreCase = true) || host.startsWith("$me.", ignoreCase = true)) return true
        return try {
            context.packageManager.resolveContentProvider(host, 0)?.packageName == me
        } catch (e: Exception) {
            true
        }
    }

    /** A MIME type in lower case when it has the shape `type/subtype` (and a sane length), else null. */
    fun cleanMime(raw: String?): String? {
        val m = raw?.trim()?.lowercase(Locale.ROOT)?.substringBefore(';')?.trim() ?: return null
        return if (m.length <= 100 && MIME.matches(m)) m else null
    }

    // ── extras (typed reads on Android 13+, the old calls before) ───────────

    @Suppress("DEPRECATION")
    private fun stream(intent: Intent): Uri? = try {
        if (Build.VERSION.SDK_INT >= 33) intent.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)
        else intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri
    } catch (e: Exception) {
        null
    }

    @Suppress("DEPRECATION")
    private fun streams(intent: Intent): List<Uri> = try {
        if (Build.VERSION.SDK_INT >= 33) intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM, Uri::class.java).orEmpty()
        else intent.getParcelableArrayListExtra<Parcelable>(Intent.EXTRA_STREAM)?.filterIsInstance<Uri>().orEmpty()
    } catch (e: Exception) {
        emptyList()
    }

    private fun clipUris(clip: ClipData?): List<Uri> {
        clip ?: return emptyList()
        val out = ArrayList<Uri>()
        for (i in 0 until minOf(clip.itemCount, MAX_FILES + 1)) clip.getItemAt(i).uri?.let { out.add(it) }
        return out
    }

    private fun textOf(intent: Intent): String? = try {
        intent.getCharSequenceExtra(Intent.EXTRA_TEXT)?.toString()?.take(MAX_TEXT)?.takeIf { it.isNotBlank() }
    } catch (e: Exception) {
        null
    }
}
