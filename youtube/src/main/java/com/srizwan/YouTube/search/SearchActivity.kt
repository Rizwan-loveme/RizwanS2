package com.srizwan.YouTube.search

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
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
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.YouTube.R
import com.srizwan.YouTube.YtNav
import com.srizwan.YouTube.data.YtHistory
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.GlassNavBar
import com.srizwan.YouTube.ui.YtTab
import com.srizwan.YouTube.ui.VectorLabelDrawable
import org.schabi.newpipe.extractor.Page
import kotlin.math.max

/**
 * Step 3 of the YouTube screens: search.
 *
 * Two modes share one screen:
 *  - SUGGEST: the field is focused. Under it a glass panel lists your past searches (the ones that match what
 *    you typed, or the latest ones when the field is empty) and YouTube's own suggestions. A tap searches, the
 *    arrow copies the text into the field, the cross removes a past search, the bin clears the history.
 *  - RESULTS: filter chips (All / Videos / Channels / Playlists) and the result list (glass cards, more load
 *    when you reach the end). Tapping the field again goes back to SUGGEST; Back from there returns to the results.
 *
 * Every search you run is saved in [YtHistory]. No text views: icons are vectors, chips and card text are
 * vector outlines; the field is the only real text (it is yours).
 */
class SearchActivity : AppCompatActivity() {

    private enum class Mode { SUGGEST, RESULTS }

    private lateinit var root: LinearLayout
    private lateinit var nav: GlassNavBar
    private lateinit var input: EditText
    private lateinit var clearBtn: ImageView
    private lateinit var chipRow: HorizontalScrollView
    private val chips = LinkedHashMap<YtRepository.Filter, ImageView>()

    private lateinit var suggestPanel: RecyclerView
    private lateinit var suggestAdapter: SuggestionAdapter

    private lateinit var resultsBox: FrameLayout
    private lateinit var results: RecyclerView
    private lateinit var resultsAdapter: SearchResultAdapter
    private lateinit var grid: GridLayoutManager
    private lateinit var progress: ProgressBar
    private lateinit var errorBox: LinearLayout
    private lateinit var emptyBox: LinearLayout

    private val handler = Handler(Looper.getMainLooper())
    private var mode = Mode.SUGGEST

    // the search that is shown in the results
    private var query = ""
    private var filter = YtRepository.Filter.ALL
    private var next: Page? = null
    private var loadingMore = false
    private var moreFailed = false
    private var generation = 0 // answers of an older search are ignored
    private val seen = HashSet<String>()

    // suggestions
    private var netSuggestions: List<String> = emptyList()
    private var suggestGen = 0
    private var ignoreText = false
    private val suggestRunnable = Runnable { fetchSuggestions() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        YtHistory.init(this)
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()

        val red = ContextCompat.getColor(this, R.color.yt_red)
        val bg = ContextCompat.getColor(this, R.color.yt_bg)
        val dim = 0xFFAAAAAA.toInt()

        // ---- top bar: back, glass field (search icon, text, clear, go) ----
        val back = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@SearchActivity, null, R.drawable.ic_back, iconSizeDp = 24f))
            contentDescription = getString(R.string.yt_cd_back)
            setPadding(px(10), px(10), px(10), px(10))
            setOnClickListener { onBackPressedDispatcher.onBackPressed() }
        }
        val searchIcon = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@SearchActivity, null, R.drawable.ic_search, iconSizeDp = 22f, tint = dim))
        }
        input = EditText(this).apply {
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.TRANSPARENT)
            textSize = 16f
            inputType = InputType.TYPE_CLASS_TEXT
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            setSingleLine(true)
            setPadding(px(8), px(10), px(8), px(10))
            setOnEditorActionListener { _, id, _ ->
                if (id == EditorInfo.IME_ACTION_SEARCH) { submit(text.toString()); true } else false
            }
            setOnFocusChangeListener { _, has -> if (has && mode == Mode.RESULTS) showSuggest() }
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
                override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    if (ignoreText) return
                    updateClear()
                    if (mode != Mode.SUGGEST) showSuggest() else scheduleSuggestions()
                }
            })
        }
        clearBtn = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@SearchActivity, null, R.drawable.ic_close, iconSizeDp = 20f, tint = dim))
            contentDescription = getString(R.string.yt_cd_clear)
            setPadding(px(9), px(9), px(9), px(9))
            visibility = View.GONE
            setOnClickListener {
                setFieldText("")
                if (mode != Mode.SUGGEST) showSuggest() else scheduleSuggestions()
                input.requestFocus()
                showKeyboard()
            }
        }
        val go = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@SearchActivity, null, R.drawable.ic_search, iconSizeDp = 22f))
            contentDescription = getString(R.string.yt_cd_search)
            setPadding(px(7), px(7), px(7), px(7))
            setOnClickListener { submit(input.text.toString()) }
            background = GradientDrawable().apply { // a round red button, like the play button on the home screen
                shape = GradientDrawable.OVAL
                setColor(red)
            }
        }
        val field = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@SearchActivity, 28f, strong = true)
            setPadding(px(14), px(3), px(5), px(3))
            addView(searchIcon, LinearLayout.LayoutParams(px(22), px(22)))
            addView(input, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            addView(clearBtn, LinearLayout.LayoutParams(px(38), px(38)))
            addView(go, LinearLayout.LayoutParams(px(38), px(38)).apply { marginStart = px(2) })
        }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(px(4), px(8), px(12), px(6))
            addView(back, LinearLayout.LayoutParams(px(44), px(44)))
            addView(field, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
        }

        // ---- filter chips ----
        chipRow = buildChips()

        // ---- results ----
        resultsAdapter = SearchResultAdapter(
            onVideo = { YtNav.openVideo(this, it.url) },
            onChannel = { YtNav.openChannel(this, it.url) },
            onPlaylist = { YtNav.openPlaylist(this, it.url) }
        )
        grid = GridLayoutManager(this, spanCount())
        grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            // videos share a row on a wide screen; channels, playlists and the spinner take the whole row
            override fun getSpanSize(position: Int): Int =
                if (resultsAdapter.getItemViewType(position) == SearchResultAdapter.TYPE_VIDEO) 1 else grid.spanCount
        }
        results = RecyclerView(this).apply {
            layoutManager = grid
            adapter = resultsAdapter
            clipToPadding = false
            setPadding(0, px(2), 0, px(12))
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(rv: RecyclerView, dx: Int, dy: Int) {
                    if (dy > 0) checkMore()
                }
            })
        }
        progress = ProgressBar(this).apply {
            isIndeterminate = true
            indeterminateTintList = android.content.res.ColorStateList.valueOf(red)
            visibility = View.GONE
        }
        errorBox = centeredBox(R.drawable.ic_wifi_off, 56f, 0xFFFFFFFF.toInt()).apply {
            val retry = ImageView(this@SearchActivity).apply {
                setImageDrawable(VectorLabelDrawable(this@SearchActivity, null, R.drawable.ic_retry, iconSizeDp = 26f))
                contentDescription = getString(R.string.yt_cd_retry)
                background = GlassDrawable(this@SearchActivity, 32f, strong = true)
                setPadding(px(14), px(14), px(14), px(14))
                setOnClickListener { loadResults() }
            }
            addView(retry, LinearLayout.LayoutParams(px(54), px(54)).apply { topMargin = px(20) })
        }
        emptyBox = centeredBox(R.drawable.ic_search, 56f, 0xFF777777.toInt()).apply {
            getChildAt(0).contentDescription = getString(R.string.yt_cd_no_results)
        }
        resultsBox = FrameLayout(this).apply {
            visibility = View.GONE
            addView(results, FrameLayout.LayoutParams(-1, -1))
            addView(progress, FrameLayout.LayoutParams(px(40), px(40), Gravity.CENTER))
            addView(errorBox, FrameLayout.LayoutParams(-2, -2, Gravity.CENTER))
            addView(emptyBox, FrameLayout.LayoutParams(-2, -2, Gravity.CENTER))
        }

        // ---- suggestions ----
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
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = suggestAdapter
            background = GlassDrawable(this@SearchActivity, 20f, strong = true)
            setPadding(0, px(6), 0, px(6))
            clipToPadding = false
            overScrollMode = View.OVER_SCROLL_NEVER
        }

        val content = FrameLayout(this).apply {
            addView(resultsBox, FrameLayout.LayoutParams(-1, -1))
            addView(suggestPanel, FrameLayout.LayoutParams(-1, -2, Gravity.TOP).apply {
                setMargins(px(12), px(4), px(12), px(12))
            })
        }

        root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            isFocusable = true // takes the focus away from the field after a search
            isFocusableInTouchMode = true
            addView(topBar, LinearLayout.LayoutParams(-1, -2))
            addView(chipRow, LinearLayout.LayoutParams(-1, -2))
            addView(content, LinearLayout.LayoutParams(-1, 0, 1f))
            // step 6: bottom navigation; the open tab (search) puts the cursor in the field
            nav = GlassNavBar(this@SearchActivity, YtTab.SEARCH) { tab ->
                if (tab == YtTab.SEARCH) {
                    input.requestFocus()
                    showKeyboard()
                } else {
                    YtNav.switchTab(this@SearchActivity, YtTab.SEARCH, tab)
                }
            }
            addView(nav, nav.rootParams())
        }
        // keep clear of the status / navigation bars and of the keyboard
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val ime = insets.getInsets(WindowInsetsCompat.Type.ime())
            v.setPadding(b.left, b.top, b.right, max(b.bottom, ime.bottom))
            nav.visibility = if (ime.bottom > 0) View.GONE else View.VISIBLE // no bar above the keyboard
            insets
        }
        setContentView(root)

        // Back: from the suggestions go back to the results of the search that is showing; otherwise leave
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (mode == Mode.SUGGEST && query.isNotEmpty()) {
                    setFieldText(query)
                    showResults()
                } else {
                    finish()
                }
            }
        })

        val start = intent.getStringExtra(EXTRA_QUERY)?.trim().orEmpty()
        if (start.isNotEmpty()) {
            submit(start)
        } else {
            showSuggest()
            input.requestFocus()
            showKeyboard()
        }
    }

    override fun onDestroy() {
        handler.removeCallbacks(suggestRunnable)
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        grid.spanCount = spanCount()
    }

    /** One column on a phone, more on a wide screen (same rule as the home feed). */
    private fun spanCount(): Int = maxOf(1, resources.configuration.screenWidthDp / 340)

    // ---- small view helpers ----

    /** An icon (and room for more views below it), centred. */
    private fun centeredBox(iconRes: Int, sizeDp: Float, tint: Int): LinearLayout {
        val d = resources.displayMetrics.density
        val ic = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@SearchActivity, null, iconRes, iconSizeDp = sizeDp, tint = tint))
        }
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            visibility = View.GONE
            addView(ic, LinearLayout.LayoutParams((sizeDp * d).toInt(), (sizeDp * d).toInt()))
        }
    }

    private fun buildChips(): HorizontalScrollView {
        val d = resources.displayMetrics.density
        fun px(v: Int) = (v * d).toInt()
        val defs = listOf(
            Triple(YtRepository.Filter.ALL, "All", R.string.yt_cd_filter_all),
            Triple(YtRepository.Filter.VIDEOS, "Videos", R.string.yt_cd_filter_videos),
            Triple(YtRepository.Filter.CHANNELS, "Channels", R.string.yt_cd_filter_channels),
            Triple(YtRepository.Filter.PLAYLISTS, "Playlists", R.string.yt_cd_filter_playlists)
        )
        val row = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(px(12), px(2), px(12), px(8))
        }
        for ((f, label, cd) in defs) {
            val chip = ImageView(this).apply {
                contentDescription = getString(cd)
                setPadding(px(16), px(9), px(16), px(9))
                tag = label
                setOnClickListener {
                    if (filter != f) {
                        filter = f
                        updateChips()
                        if (query.isNotEmpty()) loadResults()
                    }
                }
            }
            chips[f] = chip
            row.addView(chip, LinearLayout.LayoutParams(-2, -2).apply { marginEnd = px(8) })
        }
        updateChips()
        return HorizontalScrollView(this).apply {
            isHorizontalScrollBarEnabled = false
            overScrollMode = View.OVER_SCROLL_NEVER
            visibility = View.GONE
            addView(row, ViewGroup.LayoutParams(-2, -2))
        }
    }

    /** The chosen chip is a light pill with dark text, the others are glass with light text. */
    private fun updateChips() {
        val d = resources.displayMetrics.density
        for ((f, chip) in chips) {
            val selected = f == filter
            chip.setImageDrawable(
                VectorLabelDrawable(
                    this, chip.tag as String, 0, textSizeDp = 13f,
                    tint = if (selected) 0xFF0F0F0F.toInt() else Color.WHITE
                )
            )
            chip.background = if (selected) GradientDrawable().apply {
                setColor(0xFFF1F1F1.toInt())
                cornerRadius = 40f * d
            } else GlassDrawable(this, 20f)
        }
    }

    private fun updateClear() {
        clearBtn.visibility = if (input.text.isNullOrEmpty()) View.GONE else View.VISIBLE
    }

    /** Sets the field text without starting a new suggestion round on its own. */
    private fun setFieldText(text: String) {
        ignoreText = true
        input.setText(text)
        input.setSelection(text.length)
        ignoreText = false
        updateClear()
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

    // ---- modes ----

    private fun showSuggest() {
        mode = Mode.SUGGEST
        resultsBox.visibility = View.GONE
        chipRow.visibility = View.GONE
        scheduleSuggestions()
    }

    private fun showResults() {
        mode = Mode.RESULTS
        suggestPanel.visibility = View.GONE
        resultsBox.visibility = View.VISIBLE
        chipRow.visibility = View.VISIBLE
        handler.removeCallbacks(suggestRunnable)
        suggestGen++ // a late suggestion answer must not bring the panel back
        hideKeyboard()
        root.requestFocus()
    }

    // ---- suggestions ----

    private fun renderSuggestions() {
        if (mode != Mode.SUGGEST) return
        val q = input.text.toString().trim()
        val history = YtHistory.searchHistory(q).take(if (q.isEmpty()) 15 else 5)
        val net = if (q.isEmpty()) emptyList()
        else netSuggestions.filter { s -> history.none { it.equals(s, ignoreCase = true) } }.take(10)
        val rows = history.map { SuggestionAdapter.Row(it, true) } + net.map { SuggestionAdapter.Row(it, false) }
        suggestAdapter.set(rows, showClearAll = q.isEmpty() && history.isNotEmpty())
        suggestPanel.visibility = if (rows.isEmpty()) View.GONE else View.VISIBLE
    }

    /** Shows the past searches at once, then asks YouTube for suggestions after a short pause in typing. */
    private fun scheduleSuggestions() {
        handler.removeCallbacks(suggestRunnable)
        val q = input.text.toString().trim()
        if (q.isEmpty()) {
            suggestGen++
            netSuggestions = emptyList()
            renderSuggestions()
            return
        }
        renderSuggestions()
        handler.postDelayed(suggestRunnable, 220L)
    }

    private fun fetchSuggestions() {
        val q = input.text.toString().trim()
        if (q.isEmpty() || mode != Mode.SUGGEST) return
        val g = ++suggestGen
        YtRepository.async({ YtRepository.suggestions(q) }) { result ->
            if (g != suggestGen || mode != Mode.SUGGEST) return@async
            result.onSuccess {
                netSuggestions = it
                renderSuggestions()
            }
        }
    }

    // ---- searching ----

    private fun submit(raw: String) {
        val q = raw.trim()
        if (q.isEmpty()) return
        YtHistory.addSearch(q)
        setFieldText(q)
        query = q
        updateChips()
        showResults()
        loadResults()
    }

    private fun loadResults() {
        val g = ++generation
        loadingMore = false
        moreFailed = false
        next = null
        errorBox.visibility = View.GONE
        emptyBox.visibility = View.GONE
        resultsAdapter.setFooter(false)
        resultsAdapter.setAll(emptyList())
        progress.visibility = View.VISIBLE
        val q = query
        val f = filter
        YtRepository.async({ YtRepository.search(q, f) }) { result ->
            if (g != generation) return@async
            progress.visibility = View.GONE
            result.onSuccess { page ->
                seen.clear()
                val fresh = page.items.filter { seen.add(it.url) }
                resultsAdapter.setAll(fresh)
                next = page.next
                emptyBox.visibility = if (fresh.isEmpty()) View.VISIBLE else View.GONE
                results.scrollToPosition(0)
                results.post { checkMore() }
            }.onFailure {
                errorBox.visibility = View.VISIBLE
            }
        }
    }

    /** Loads the next page when the last rows are close. */
    private fun checkMore() {
        if (resultsAdapter.itemCount == 0) return
        if (grid.findLastVisibleItemPosition() >= resultsAdapter.itemCount - 5) loadMore()
    }

    private fun loadMore() {
        val page = next ?: return
        if (loadingMore || moreFailed) return
        loadingMore = true
        resultsAdapter.setFooter(true)
        val g = generation
        val q = query
        val f = filter
        YtRepository.async({ YtRepository.searchMore(q, f, page) }) { result ->
            if (g != generation) return@async
            loadingMore = false
            resultsAdapter.setFooter(false)
            result.onSuccess { more ->
                val fresh = more.items.filter { seen.add(it.url) }
                resultsAdapter.append(fresh)
                next = more.next
                results.post { checkMore() }
            }.onFailure {
                moreFailed = true // stop until the next search
            }
        }
    }

    companion object {
        private const val EXTRA_QUERY = "query"

        /** Opens the search screen; with [query] it searches at once, otherwise it opens the field with the history. */
        fun start(context: Context, query: String? = null) {
            val i = Intent(context, SearchActivity::class.java)
            if (!query.isNullOrBlank()) i.putExtra(EXTRA_QUERY, query)
            if (context !is android.app.Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}
