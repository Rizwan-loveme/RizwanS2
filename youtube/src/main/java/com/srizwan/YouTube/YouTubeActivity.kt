package com.srizwan.YouTube

import android.content.ClipboardManager
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.srizwan.YouTube.data.YtHistory
import com.srizwan.YouTube.data.YtItem
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.home.VideoCardAdapter
import com.srizwan.YouTube.player.PlayerActivity
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.GlassNavBar
import com.srizwan.YouTube.ui.GlassToast
import com.srizwan.YouTube.ui.YtTab
import com.srizwan.YouTube.ui.VectorLabelDrawable
import org.schabi.newpipe.extractor.Page

/**
 * The built-in YouTube app (opened by :app, Start menu, section = "youtube").
 *
 * Step 2 of the YouTube screens: the home feed. At the top the logo, the link bar (paste or type a video
 * link and play it, as before) and, at the bottom, the glass navigation bar (step 6: home, search, history; [GlassNavBar]); below it the feed of glass video cards (trending, pull down to refresh, more
 * cards load when you reach the end). A tap on a card opens [PlayerActivity].
 * No text views: the logo and icons are vectors, the card text is vector ([com.srizwan.YouTube.ui.VectorText]);
 * the link you type is the only real text, and it is the user's own.
 */
class YouTubeActivity : AppCompatActivity() {

    private lateinit var adapter: VideoCardAdapter
    private lateinit var refresh: SwipeRefreshLayout
    private lateinit var recycler: RecyclerView
    private lateinit var grid: GridLayoutManager
    private lateinit var errorBox: LinearLayout

    private var next: Page? = null
    private var loadingMore = false
    private var moreFailed = false
    private var extended = false // the trending list itself is over; continuing with search pages
    private var generation = 0   // answers of an older load are ignored
    private val seen = HashSet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        YtHistory.init(this) // local watch / search history
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()

        val red = ContextCompat.getColor(this, R.color.yt_red)
        val bg = ContextCompat.getColor(this, R.color.yt_bg)

        val logo = ImageView(this).apply {
            setImageResource(R.drawable.ic_yt_logo)
            scaleType = ImageView.ScaleType.FIT_CENTER
        }

        // ---- the link bar: paste or type a video link and play it (unchanged feature) ----
        val input = EditText(this).apply {
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.TRANSPARENT)
            textSize = 15f
            inputType = InputType.TYPE_TEXT_VARIATION_URI
            imeOptions = EditorInfo.IME_ACTION_GO
            setSingleLine(true)
            setPadding(px(8), px(10), px(8), px(10))
        }
        fun play(link: String) {
            val url = link.trim()
            if (url.isNotEmpty()) PlayerActivity.start(this, url)
        }
        input.setOnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_GO) { play(input.text.toString()); true } else false
        }

        val linkIcon = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_link, iconSizeDp = 22f))
        }
        val paste = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_paste, iconSizeDp = 22f))
            contentDescription = getString(R.string.yt_cd_paste)
            setPadding(px(8), px(8), px(8), px(8))
            setOnClickListener {
                val clip = (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).primaryClip
                val text = clip?.takeIf { it.itemCount > 0 }?.getItemAt(0)?.coerceToText(this@YouTubeActivity)?.toString()
                if (!text.isNullOrBlank()) {
                    input.setText(text)
                    play(text)
                }
            }
        }
        val go = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@YouTubeActivity, null, R.drawable.ic_play, iconSizeDp = 22f))
            contentDescription = getString(R.string.yt_cd_go)
            setPadding(px(7), px(7), px(7), px(7))
            setOnClickListener { play(input.text.toString()) }
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
            addView(linkIcon)
            addView(input, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
            addView(paste, LinearLayout.LayoutParams(px(38), px(38)))
            addView(go, LinearLayout.LayoutParams(px(38), px(38)).apply { marginStart = px(4) })
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
        val content = FrameLayout(this).apply {
            addView(refresh, FrameLayout.LayoutParams(-1, -1))
            addView(errorBox, FrameLayout.LayoutParams(-2, -2, Gravity.CENTER))
        }

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            addView(topBar, LinearLayout.LayoutParams(-1, -2))
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

        loadHome()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        grid.spanCount = spanCount()
    }

    /** One column on a phone, more on a wide screen. */
    private fun spanCount(): Int = maxOf(1, resources.configuration.screenWidthDp / 340)

    // ---- loading ----

    private fun loadHome() {
        val g = ++generation
        loadingMore = false
        moreFailed = false
        extended = false
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
        val page = next
        if (page == null && extended) return // nothing left
        loadingMore = true
        val g = generation
        // the trending list has no further pages: continue with search results for the same topic
        YtRepository.async({
            if (page != null) YtRepository.homeMore(page)
            else YtRepository.search("trending videos", YtRepository.Filter.VIDEOS)
        }) { result ->
            if (g != generation) return@async
            loadingMore = false
            result.onSuccess { more ->
                if (page == null) extended = true
                val fresh = more.items.filterIsInstance<YtItem.Video>().filter { seen.add(it.url) }
                adapter.append(fresh)
                next = more.next
                recycler.post { checkMore() }
            }.onFailure {
                moreFailed = true // stop until the next pull-to-refresh
            }
        }
    }
}
