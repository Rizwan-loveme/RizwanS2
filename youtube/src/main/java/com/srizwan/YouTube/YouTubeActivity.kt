package com.srizwan.YouTube

import android.content.ClipboardManager
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.srizwan.YouTube.data.HomeChannel
import com.srizwan.YouTube.data.YtFeedCache
import com.srizwan.YouTube.data.YtHistory
import com.srizwan.YouTube.data.YtItem
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.home.VideoCardAdapter
import com.srizwan.YouTube.search.SuggestionAdapter
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.GlassNavBar
import com.srizwan.YouTube.ui.GlassToast
import com.srizwan.YouTube.ui.YtTab
import com.srizwan.YouTube.ui.VectorLabelDrawable
import com.srizwan.YouTube.ui.VectorText
import org.schabi.newpipe.extractor.Page

/**
 * The built-in YouTube app (opened by :app, Start menu, section = "youtube").
 *
 * Step 2 of the YouTube screens: the home feed. At the top the logo, the link bar (paste or type a video
 * link and play it, as before) and, at the bottom, the glass navigation bar (step 6: home, search, history; [GlassNavBar]); below it the feed of glass video cards (the uploads of the "Afnan the horror world" channel, pull down to refresh, more
 * cards load when you reach the end). A tap on a card opens [com.srizwan.YouTube.player.PlayerActivity].
 * Step 2 (smart bar): the same field now does two jobs, decided by [LinkDetector] on every key press.
 * A YouTube link (video, playlist or channel) is opened (the icons turn into link / play); anything else is
 * a search (icons turn into magnifier / search) and opens [com.srizwan.YouTube.search.SearchActivity]. While
 * you type, a glass panel under the bar lists your past searches and YouTube's suggestions (same rows as the
 * search screen). The paste button still pastes and opens a copied link at once.
 * Step 3 (clipboard chip): when you come back to this screen and the clipboard holds a YouTube link
 * ([LinkDetector.findIn]), a glass chip appears under the bar with the link; one tap opens it, the cross
 * dismisses it. A link you already opened or dismissed is not offered again. The chip hides while the bar has text.
 * Step 4 (home channel): the feed is no longer the trending list but the uploads of [HomeChannel] ("Afnan the
 * horror world"), with a slim channel row above the feed (tap it to open the channel screen). If that channel
 * cannot be found or loaded, the feed is a video search for its name.
 * Step 5 (offline and speed): the last feed page is kept ([YtFeedCache]) and shown at once on start, also without a
 * connection; thumbnails are kept on disk ([com.srizwan.YouTube.ui.ThumbLoader]).
 * No text views: the logo and icons are vectors, the card text is vector ([com.srizwan.YouTube.ui.VectorText]);
 * the link you type is the only real text, and it is the user's own.
 */
class YouTubeActivity : AppCompatActivity() {

    private lateinit var adapter: VideoCardAdapter
    private lateinit var refresh: SwipeRefreshLayout
    private lateinit var recycler: RecyclerView
    private lateinit var grid: GridLayoutManager
    private lateinit var errorBox: LinearLayout
    private lateinit var root: LinearLayout

    // smart bar (step 2)
    private lateinit var input: EditText
    private lateinit var barIcon: ImageView
    private lateinit var clearBtn: ImageView
    private lateinit var pasteBtn: ImageView
    private lateinit var goBtn: ImageView
    private lateinit var suggestPanel: RecyclerView
    private lateinit var suggestAdapter: SuggestionAdapter
    // Back closes the suggestion panel first; only then does it leave the screen (enabled while the panel shows)
    private val backCallback = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            hideKeyboard()
            hideSuggest()
            root.requestFocus()
        }
    }
    // clipboard chip (step 3)
    private lateinit var clipChip: LinearLayout
    private lateinit var clipIcon: ImageView
    private lateinit var clipText: VectorText
    private var clipLink: DetectedLink? = null
    private val uiHandler = Handler(Looper.getMainLooper())
    private var barIsLink = false
    private var netSuggestions: List<String> = emptyList()
    private var suggestGen = 0
    private var ignoreText = false
    private val suggestRunnable = Runnable { fetchSuggestions() }

    private var next: Page? = null
    private var loadingMore = false
    private var moreFailed = false
    private var generation = 0   // answers of an older load are ignored
    private val seen = HashSet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        YtHistory.init(this) // local watch / search history
        HomeChannel.init(this) // the channel of the home feed (step 4)
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()

        val red = ContextCompat.getColor(this, R.color.yt_red)
        val bg = ContextCompat.getColor(this, R.color.yt_bg)

        val logo = ImageView(this).apply {
            setImageResource(R.drawable.ic_yt_logo)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }

        // ---- the smart bar: a YouTube link is opened, words are searched (step 2) ----
        input = EditText(this).apply {
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.TRANSPARENT)
            textSize = 15f
            inputType = InputType.TYPE_CLASS_TEXT // a normal keyboard: words (with spaces) are searched too
            imeOptions = EditorInfo.IME_ACTION_GO
            setSingleLine(true)
            setPadding(px(8), px(10), px(8), px(10))
            setOnEditorActionListener { _, id, _ ->
                if (id == EditorInfo.IME_ACTION_GO) { submit(text.toString()); true } else false
            }
            setOnFocusChangeListener { _, has -> if (has) scheduleSuggestions() else hideSuggest() }
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
                override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (ignoreText) return
                    updateBar()
                    scheduleSuggestions()
                }
            })
        }

        barIcon = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_search, iconSizeDp = 22f))
        }
        clearBtn = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_close, iconSizeDp = 20f, tint = 0xFFAAAAAA.toInt()))
            contentDescription = getString(R.string.yt_cd_clear)
            setPadding(px(9), px(9), px(9), px(9))
            visibility = View.GONE
            setOnClickListener {
                setFieldText("")
                input.requestFocus()
                showKeyboard()
                scheduleSuggestions()
            }
        }
        pasteBtn = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_paste, iconSizeDp = 22f))
            contentDescription = getString(R.string.yt_cd_paste)
            setPadding(px(8), px(8), px(8), px(8))
            setOnClickListener {
                val clip = (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip
                val text = clip?.takeIf { it.itemCount > 0 }?.getItemAt(0)?.coerceToText(this@YouTubeActivity)?.toString()
                if (!text.isNullOrBlank()) {
                    val d = LinkDetector.findIn(text)
                    if (d.isLink) {
                        setFieldText(d.url ?: text.trim())
                        open(d) // a copied link is opened at once, as before
                    } else {
                        // not a link: put the words in the bar and let the user search them
                        setFieldText(text.trim())
                        input.requestFocus()
                        showKeyboard()
                        scheduleSuggestions()
                    }
                }
            }
        }
        goBtn = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_search, iconSizeDp = 22f))
            contentDescription = getString(R.string.yt_cd_search)
            setPadding(px(7), px(7), px(7), px(7))
            setOnClickListener { submit(input.text.toString()) }
            background = android.graphics.drawable.GradientDrawable().apply { // a round red button
                shape = android.graphics.drawable.GradientDrawable.OVAL
                setColor(red)
            }
        }
        val field = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@YouTubeActivity, 28f, strong = true)
            setPadding(px(14), px(3), px(5), px(3))
            addView(barIcon, LinearLayout.LayoutParams(px(22), px(22)))
            addView(input, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            // the clear button and the paste button share one slot: paste while the bar is empty, clear when it has text
            addView(clearBtn, LinearLayout.LayoutParams(px(38), px(38)))
            addView(pasteBtn, LinearLayout.LayoutParams(px(38), px(38)))
            addView(goBtn, LinearLayout.LayoutParams(px(38), px(38)).apply { marginStart = px(4) })
        }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(px(12), px(8), px(12), px(6))
            addView(logo, LinearLayout.LayoutParams(px(34), px(34)).apply { marginEnd = px(10) })
            addView(field, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
        }

        // ---- the feed ----
        adapter = VideoCardAdapter { video -> YtNav.openVideo(this, video.url) }
        grid = GridLayoutManager(this, spanCount())
        recycler = RecyclerView(this).apply {
            layoutManager = grid
            adapter = this@YouTubeActivity.adapter
            clipToPadding = false
            setPadding(0, px(2), 0, px(12))
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) checkMore()
                }
            })
        }
        refresh = SwipeRefreshLayout(this).apply {
            setColorSchemeColors(red)
            setProgressBackgroundColorSchemeColor(ContextCompat.getColor(this@YouTubeActivity, R.color.yt_surface))
            setOnRefreshListener { loadHome() }
            addView(recycler, ViewGroup.LayoutParams(-1, -1))
        }

        // shown when the feed could not be loaded and there is nothing to show: a vector icon and a retry button
        val errorIcon = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_wifi_off, iconSizeDp = 56f))
        }
        val retry = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_retry, iconSizeDp = 26f))
            contentDescription = getString(R.string.yt_cd_retry)
            background = GlassDrawable(this@YouTubeActivity, 32f, strong = true)
            setPadding(px(14), px(14), px(14), px(14))
            setOnClickListener { loadHome() }
        }
        errorBox = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            visibility = View.GONE
            addView(errorIcon, LinearLayout.LayoutParams(px(56), px(56)))
            addView(retry, LinearLayout.LayoutParams(px(54), px(54)).apply { topMargin = px(20) })
        }
        // ---- the clipboard chip (step 3): a copied YouTube link, one tap to open ----
        clipIcon = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_link, iconSizeDp = 22f))
        }
        clipText = VectorText(this)
        val clipGo = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_play, iconSizeDp = 20f))
            contentDescription = getString(R.string.yt_cd_go)
            setPadding(px(6), px(6), px(6), px(6))
            background = android.graphics.drawable.GradientDrawable().apply {
                shape = android.graphics.drawable.GradientDrawable.OVAL
                setColor(red)
            }
        }
        val clipClose = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_close, iconSizeDp = 20f, tint = 0xFFAAAAAA.toInt()))
            contentDescription = getString(R.string.yt_cd_close)
            setPadding(px(9), px(9), px(9), px(9))
            setOnClickListener {
                handledUrl = clipLink?.url
                clipLink = null
                updateChip()
            }
        }
        clipChip = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@YouTubeActivity, 28f, strong = true)
            setPadding(px(14), px(3), px(5), px(3))
            visibility = View.GONE
            isClickable = true
            setOnClickListener { clipLink?.let { open(it) } }
            addView(clipIcon, LinearLayout.LayoutParams(px(22), px(22)))
            addView(clipText, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
                marginStart = px(10); marginEnd = px(8)
            })
            addView(clipGo, LinearLayout.LayoutParams(px(34), px(34)))
            addView(clipClose, LinearLayout.LayoutParams(px(38), px(38)).apply { marginStart = px(2) })
        }

        // ---- the channel row (step 4): who the feed is from; tap = the channel screen ----
        val chIcon = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_person, iconSizeDp = 20f, tint = 0xFFAAAAAA.toInt()))
        }
        val chName = VectorText(this).apply { set(HomeChannel.NAME, 15f, Color.WHITE, bold = true, maxLines = 1) }
        val channelRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(px(16), px(6), px(16), px(6))
            isClickable = true
            setOnClickListener { HomeChannel.url?.let { YtNav.openChannel(this@YouTubeActivity, it) } }
            addView(chIcon, LinearLayout.LayoutParams(px(20), px(20)))
            addView(chName, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply { marginStart = px(10) })
        }

        // the suggestion panel (step 2): past searches and YouTube's suggestions under the smart bar
        suggestAdapter = SuggestionAdapter(
            onPick = { submit(it) },
            onFill = {
                setFieldText(it)
                scheduleSuggestions()
            },
            onRemove = {
                YtHistory.removeSearch(it)
                renderSuggestions()
            },
            onClearAll = {
                YtHistory.clearSearches()
                renderSuggestions()
            }
        )
        suggestPanel = RecyclerView(this).apply {
            layoutManager = LinearLayoutManager(this@YouTubeActivity)
            adapter = suggestAdapter
            background = GlassDrawable(this@YouTubeActivity, 20f, strong = true)
            setPadding(0, px(6), 0, px(6))
            clipToPadding = false
            overScrollMode = View.OVER_SCROLL_NEVER
            visibility = View.GONE
        }
        val content = FrameLayout(this).apply {
            addView(refresh, FrameLayout.LayoutParams(-1, -1))
            addView(errorBox, FrameLayout.LayoutParams(-2, -2, Gravity.CENTER))
            addView(suggestPanel, FrameLayout.LayoutParams(-1, -2, Gravity.TOP).apply {
                setMargins(px(12), px(4), px(12), px(12))
            })
        }

        root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            isFocusable = true // takes the focus away from the bar after a search / when the panel closes
            isFocusableInTouchMode = true
            addView(topBar, LinearLayout.LayoutParams(-1, -2))
            addView(clipChip, LinearLayout.LayoutParams(-1, -2).apply { setMargins(px(12), px(2), px(12), px(6)) })
            addView(channelRow, LinearLayout.LayoutParams(-1, -2))
            addView(content, LinearLayout.LayoutParams(-1, 0, 1f))
            // step 6: bottom navigation (home, search, history)
            val nav = GlassNavBar(this@YouTubeActivity, YtTab.HOME) { YtNav.switchTab(this@YouTubeActivity, YtTab.HOME, it) }
            addView(nav, nav.rootParams())
        }
        // keep clear of the status / navigation bars when the window draws edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(b.left, b.top, b.right, b.bottom)
            insets
        }
        setContentView(root)

        onBackPressedDispatcher.addCallback(this, backCallback)

        // step 5: the last feed is shown at once (also offline); the fresh one replaces it when it has loaded
        val cached = YtFeedCache.load(this)
        if (cached.isNotEmpty()) {
            seen.addAll(cached.map { it.url })
            adapter.setAll(cached)
        }
        loadHome()
    }

    override fun onResume() {
        super.onResume()
        // coming back from a search / player: no panel, no keyboard (the text stays in the bar)
        hideSuggest()
        hideKeyboard()
        root.requestFocus()
    }

    /** Android lets an app read the clipboard only while its window has focus, so this is where it is checked. */
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) checkClipboard()
    }

    override fun onDestroy() {
        uiHandler.removeCallbacks(suggestRunnable)
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        grid.spanCount = spanCount()
    }

    /** One column on a phone, more on a wide screen. */
    private fun spanCount(): Int = maxOf(1, resources.configuration.screenWidthDp / 340)

    // ---- smart bar (step 2) ----

    /** Opens a detected link in the screen that fits it. */
    private fun open(d: DetectedLink) {
        val url = d.url ?: return
        handledUrl = url // the clipboard chip does not offer a link that was opened
        clipLink = null
        updateChip()
        hideKeyboard()
        hideSuggest()
        root.requestFocus()
        when (d.type) {
            LinkType.VIDEO -> YtNav.openVideo(this, url)
            LinkType.PLAYLIST -> YtNav.openPlaylist(this, url)
            LinkType.CHANNEL -> YtNav.openChannel(this, url)
            LinkType.NOT_A_LINK -> {}
        }
    }

    /** Go / keyboard Go: a link is opened, anything else is searched. */
    private fun submit(raw: String) {
        val text = raw.trim()
        if (text.isEmpty()) return
        val d = LinkDetector.findIn(text)
        if (d.isLink) {
            open(d)
        } else {
            hideKeyboard()
            hideSuggest()
            root.requestFocus()
            YtNav.openSearch(this, text) // the search screen saves it in the history
        }
    }

    /** Link in the bar: link icon + play button. Otherwise: magnifier + search button. Clear / paste share a slot. */
    private fun updateBar() {
        val text = input.text?.toString().orEmpty()
        val has = text.isNotEmpty()
        clearBtn.visibility = if (has) View.VISIBLE else View.GONE
        pasteBtn.visibility = if (has) View.GONE else View.VISIBLE
        updateChip()
        val isLink = LinkDetector.findIn(text).isLink
        if (isLink == barIsLink) return
        barIsLink = isLink
        barIcon.setImageDrawable(
            VectorLabelDrawable(this, null, if (isLink) R.drawable.ic_link else R.drawable.ic_search, iconSizeDp = 22f)
        )
        goBtn.setImageDrawable(
            VectorLabelDrawable(this, null, if (isLink) R.drawable.ic_play else R.drawable.ic_search, iconSizeDp = 22f)
        )
        goBtn.contentDescription = getString(if (isLink) R.string.yt_cd_go else R.string.yt_cd_search)
    }

    /** Sets the bar text without starting a new suggestion round on its own. */
    private fun setFieldText(text: String) {
        ignoreText = true
        input.setText(text)
        input.setSelection(text.length)
        ignoreText = false
        updateBar()
    }

    private fun showKeyboard() {
        input.post {
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .showSoftInput(input, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun hideKeyboard() {
        val token = input.windowToken ?: return
        (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(token, 0)
    }

    private fun hideSuggest() {
        uiHandler.removeCallbacks(suggestRunnable)
        suggestGen++ // a late suggestion answer must not bring the panel back
        suggestPanel.visibility = View.GONE
        backCallback.isEnabled = false
    }

    /** Past searches (the ones that match what is typed, or the latest when the bar is empty) + YouTube's suggestions. */
    private fun renderSuggestions() {
        val q = input.text.toString().trim()
        if (!input.hasFocus() || LinkDetector.findIn(q).isLink) { // a link needs no suggestions
            suggestPanel.visibility = View.GONE
            backCallback.isEnabled = false
            return
        }
        val history = YtHistory.searchHistory(q).take(if (q.isEmpty()) 15 else 5)
        val net = if (q.isEmpty()) emptyList()
        else netSuggestions.filter { s -> history.none { it.equals(s, ignoreCase = true) } }.take(10)
        val rows = history.map { SuggestionAdapter.Row(it, true) } + net.map { SuggestionAdapter.Row(it, false) }
        suggestAdapter.set(rows, showClearAll = q.isEmpty() && history.isNotEmpty())
        val show = rows.isNotEmpty()
        suggestPanel.visibility = if (show) View.VISIBLE else View.GONE
        backCallback.isEnabled = show
    }

    /** Shows the past searches at once, then asks YouTube for suggestions after a short pause in typing. */
    private fun scheduleSuggestions() {
        uiHandler.removeCallbacks(suggestRunnable)
        if (!input.hasFocus()) return
        val q = input.text.toString().trim()
        if (q.isEmpty() || LinkDetector.findIn(q).isLink) {
            suggestGen++
            netSuggestions = emptyList()
            renderSuggestions()
            return
        }
        renderSuggestions()
        uiHandler.postDelayed(suggestRunnable, 220L)
    }

    private fun fetchSuggestions() {
        val q = input.text.toString().trim()
        if (q.isEmpty() || !input.hasFocus() || LinkDetector.findIn(q).isLink) return
        val g = ++suggestGen
        YtRepository.async({ YtRepository.suggestions(q) }) { result ->
            if (g != suggestGen) return@async
            result.onSuccess {
                netSuggestions = it
                renderSuggestions()
            }
        }
    }

    // ---- clipboard chip (step 3) ----

    /** Looks at the clipboard; a YouTube link that was not handled yet becomes the chip. */
    private fun checkClipboard() {
        val text = runCatching {
            val cm = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if (!cm.hasPrimaryClip() || cm.primaryClipDescription?.hasMimeType("text/*") != true) return@runCatching null
            cm.primaryClip?.takeIf { it.itemCount > 0 }?.getItemAt(0)?.coerceToText(this)?.toString()
        }.getOrNull()
        val d = LinkDetector.findIn(text)
        clipLink = if (d.isLink && d.url != handledUrl) d else null
        updateChip()
    }

    /** Shows the chip for [clipLink] while the bar is empty; hides it otherwise. */
    private fun updateChip() {
        val d = clipLink
        if (d == null || !input.text.isNullOrEmpty()) {
            clipChip.visibility = View.GONE
            return
        }
        clipIcon.setImageDrawable(
            VectorLabelDrawable(
                this, null,
                when (d.type) {
                    LinkType.PLAYLIST -> R.drawable.ic_playlist
                    LinkType.CHANNEL -> R.drawable.ic_person
                    else -> R.drawable.ic_play
                },
                iconSizeDp = 22f
            )
        )
        clipText.set(d.url.orEmpty().removePrefix("https://www."), 13f, 0xFFDDDDDD.toInt(), maxLines = 1)
        clipChip.visibility = View.VISIBLE
    }

    // ---- loading ----

    private fun loadHome() {
        val g = ++generation
        loadingMore = false
        moreFailed = false
        errorBox.visibility = View.GONE
        refresh.isRefreshing = true
        YtRepository.async({ YtRepository.home() }) { result ->
            if (g != generation) return@async
            refresh.isRefreshing = false
            result.onSuccess { page ->
                val videos = page.items.filterIsInstance<YtItem.Video>()
                seen.clear()
                seen.addAll(videos.map { it.url })
                adapter.setAll(videos)
                YtFeedCache.save(this, videos)
                next = page.next
                errorBox.visibility = if (videos.isEmpty()) View.VISIBLE else View.GONE
                recycler.post { checkMore() }
            }.onFailure {
                if (adapter.itemCount == 0) errorBox.visibility = View.VISIBLE
                else GlassToast.show(this, R.drawable.ic_error)
            }
        }
    }

    /** Loads the next page when the last cards are close. */
    private fun checkMore() {
        if (adapter.itemCount == 0) return
        if (grid.findLastVisibleItemPosition() >= adapter.itemCount - 5) loadMore()
    }

    private fun loadMore() {
        if (loadingMore || moreFailed) return
        val page = next ?: return // the channel has no more uploads: nothing left
        loadingMore = true
        val g = generation
        YtRepository.async({ YtRepository.homeMore(page) }) { result ->
            if (g != generation) return@async
            loadingMore = false
            result.onSuccess { more ->
                val fresh = more.items.filterIsInstance<YtItem.Video>().filter { seen.add(it.url) }
                adapter.append(fresh)
                next = more.next
                recycler.post { checkMore() }
            }.onFailure {
                moreFailed = true // stop until the next pull-to-refresh
            }
        }
    }

    companion object {
        /** The last link that was opened or dismissed from the chip; kept while the process lives so it is not offered again. */
        @Volatile private var handledUrl: String? = null
    }
}
