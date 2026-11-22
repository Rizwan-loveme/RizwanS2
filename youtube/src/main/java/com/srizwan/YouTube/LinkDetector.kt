package com.srizwan.YouTube

/** What a piece of text is. */
enum class LinkType { VIDEO, PLAYLIST, CHANNEL, NOT_A_LINK }

/**
 * The result of [LinkDetector.detect].
 * [url] is the clean, normalised address to open (no tracking junk), [id] the video / playlist id or the
 * channel handle / id. Both are null for [LinkType.NOT_A_LINK].
 */
data class DetectedLink(val type: LinkType, val url: String? = null, val id: String? = null) {
    val isLink: Boolean get() = type != LinkType.NOT_A_LINK
}

/**
 * Step 1 of the home-bar plan: tells a YouTube link from a search phrase.
 * Pure Kotlin (no Android classes), so it is cheap to call on every key press.
 *
 * Understood, with or without "https://" and "www.":
 *  - videos:    youtube.com/watch?v=, youtu.be/, /shorts/, /live/, /embed/, /v/, m.youtube.com, music.youtube.com,
 *               youtube-nocookie.com/embed/, and a bare 11-character video id (see [looksLikeBareVideoId])
 *  - playlists: youtube.com/playlist?list=  (and /watch?list= without a v=)
 *  - channels:  /@handle, /channel/UC..., /c/name, /user/name (a trailing /videos, /shorts ... is ignored)
 * A link with both v= and list= is a VIDEO (the video plays, as it always did).
 */
object LinkDetector {

    private val URL_WHOLE = Regex(
        """^(?:https?://)?(?:(?:www|m|music|gaming)\.)?(youtube\.com|youtube-nocookie\.com|youtu\.be)(?::\d+)?(/[^\s?#]*)?(?:\?([^\s#]*))?(?:#\S*)?$""",
        RegexOption.IGNORE_CASE
    )

    // a URL-looking piece inside longer text (a shared message such as "watch this https://youtu.be/xxxx !")
    private val URL_IN_TEXT = Regex(
        """(?<![\w.-])(?:https?://)?(?:(?:www|m|music|gaming)\.)?(?:youtube\.com|youtube-nocookie\.com|youtu\.be)[^\s<>"']*""",
        RegexOption.IGNORE_CASE
    )

    private val VIDEO_ID = Regex("""^[A-Za-z0-9_-]{11}$""")
    private val PLAYLIST_ID = Regex("""^[A-Za-z0-9_-]{10,64}$""")
    private val HANDLE = Regex("""^@[\w.\-]{3,60}$""")
    private val NAME = Regex("""^[\w.\-%]{1,100}$""")
    private val CHANNEL_ID = Regex("""^UC[A-Za-z0-9_-]{22}$""")

    private val NONE = DetectedLink(LinkType.NOT_A_LINK)

    /**
     * Looks at the WHOLE [raw] text (the content of the link bar). Surrounding spaces, quotes, <> and a
     * trailing . , ; ) ! ? are ignored. Text with spaces inside is a search phrase, never a link.
     */
    fun detect(raw: String?): DetectedLink {
        if (raw.isNullOrBlank()) return NONE
        val text = clean(raw)
        if (text.isEmpty() || text.any { it.isWhitespace() }) return NONE

        val m = URL_WHOLE.matchEntire(text)
        if (m == null) {
            return if (looksLikeBareVideoId(text)) video(text) else NONE
        }
        val host = m.groupValues[1].lowercase()
        val path = m.groupValues[2]
        val query = m.groupValues[3]
        val parts = path.split('/').filter { it.isNotEmpty() }

        if (host == "youtu.be") {
            val id = parts.firstOrNull() ?: return NONE
            return if (VIDEO_ID.matches(id)) video(id) else NONE
        }

        if (parts.isEmpty()) return NONE // just "youtube.com": the app's own home, nothing to open

        when (parts[0].lowercase()) {
            "watch" -> {
                val v = param(query, "v")
                if (v != null && VIDEO_ID.matches(v)) return video(v)
                val list = param(query, "list")
                if (list != null && PLAYLIST_ID.matches(list)) return playlist(list)
                return NONE
            }
            "shorts", "live", "embed", "v" -> {
                val id = parts.getOrNull(1) ?: return NONE
                return if (VIDEO_ID.matches(id)) video(id) else NONE
            }
            "playlist" -> {
                val list = param(query, "list") ?: return NONE
                return if (PLAYLIST_ID.matches(list)) playlist(list) else NONE
            }
            "channel" -> {
                val id = parts.getOrNull(1) ?: return NONE
                return if (CHANNEL_ID.matches(id)) channel("channel/$id", id) else NONE
            }
            "c", "user" -> {
                val name = parts.getOrNull(1) ?: return NONE
                return if (NAME.matches(name)) channel("${parts[0].lowercase()}/$name", name) else NONE
            }
        }
        if (parts[0].startsWith("@") && HANDLE.matches(parts[0])) return channel(parts[0], parts[0])
        return NONE
    }

    /** true when the whole text is a YouTube link (what the link bar uses to switch icon and action). */
    fun isLink(raw: String?): Boolean = detect(raw).isLink

    /**
     * Finds the first YouTube link INSIDE a longer text (for the clipboard: a shared message is
     * "title + link"). A text that is only a bare video id counts too. Returns NOT_A_LINK if none.
     */
    fun findIn(text: String?): DetectedLink {
        if (text.isNullOrBlank()) return NONE
        val whole = detect(text)
        if (whole.isLink) return whole
        for (m in URL_IN_TEXT.findAll(text)) {
            val d = detect(m.value)
            if (d.isLink) return d
        }
        return NONE
    }

    /**
     * A bare 11-character id like "dQw4w9WgXcQ". To keep ordinary search words ("horrorstory", "YouTubeApps")
     * from being taken for ids it must mix upper and lower case AND hold a digit, "_" or "-".
     */
    fun looksLikeBareVideoId(s: String): Boolean =
        VIDEO_ID.matches(s) &&
            s.any { it.isUpperCase() } && s.any { it.isLowerCase() } &&
            s.any { it.isDigit() || it == '_' || it == '-' }

    // ---------- helpers ----------

    private fun clean(raw: String): String {
        var t = raw.trim().trim('"', '\'', '<', '>', '(', '[')
        t = t.trimEnd('.', ',', ';', ')', ']', '!', '?', '"', '\'', '>')
        return t.trim()
    }

    /** Value of one query parameter, or null. */
    private fun param(query: String, name: String): String? {
        if (query.isEmpty()) return null
        for (pair in query.split('&')) {
            val i = pair.indexOf('=')
            if (i > 0 && pair.substring(0, i).equals(name, ignoreCase = true)) {
                return pair.substring(i + 1).takeIf { it.isNotEmpty() }
            }
        }
        return null
    }

    private fun video(id: String) = DetectedLink(LinkType.VIDEO, "https://www.youtube.com/watch?v=$id", id)
    private fun playlist(id: String) = DetectedLink(LinkType.PLAYLIST, "https://www.youtube.com/playlist?list=$id", id)
    private fun channel(path: String, id: String) = DetectedLink(LinkType.CHANNEL, "https://www.youtube.com/$path", id)
}
