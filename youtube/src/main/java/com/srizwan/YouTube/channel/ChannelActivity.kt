package com.srizwan.YouTube.channel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.srizwan.YouTube.R
import com.srizwan.YouTube.YtNav
import com.srizwan.YouTube.data.ChannelDetails
import com.srizwan.YouTube.data.PageResult
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.search.SearchResultAdapter
import com.srizwan.YouTube.ui.Format
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.ThumbLoader
import com.srizwan.YouTube.ui.VectorLabelDrawable
import com.srizwan.YouTube.ui.VectorText
import org.schabi.newpipe.extractor.Page
import org.schabi.newpipe.extractor.linkhandler.ListLinkHandler

/**
 * Step 5 of the YouTube screens: a channel.
 *
 * Top: back, round avatar, name and subscriber count; under it the description (two lines, tap to open it up).
 * Then the tabs the channel has (Videos / Playlists) and the list of the open tab, the same glass rows as the
 * search results ([SearchResultAdapter]); more rows load when you reach the end. Each tab is loaded once and kept.
 * Failure shows the wifi-off icon with a retry button. No text views: icons are vectors, text is vector outlines.
 */
class ChannelActivity : AppCompatActivity() {

    private lateinit var url: String
    private lateinit var avatar: ImageView
    private lateinit var nameText: VectorText
    private lateinit var subsText: VectorText
    private lateinit var descText: VectorText
    private lateinit var tabRow: LinearLayout
    private val tabs = LinkedHashMap<String, ImageView>()

    private lateinit var adapter: SearchResultAdapter
    private lateinit var list: RecyclerView
    private lateinit var grid: GridLayoutManager
    private lateinit var progress: ProgressBar
    private lateinit var errorBox: LinearLayout
    private lateinit var emptyBox: LinearLayout

    private var details: ChannelDetails? = null
    private var tabKey: String? = null
    private var next: Page? = null
    private var loadingMore = false
    private var moreFailed = false
    private var generation = 0 // answers of an older load are ignored
    private var descOpen = false
    private val seen = HashSet<String>()
    private val firstPages = HashMap<String, PageResult>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = intent.getStringExtra(EXTRA_URL) ?: run { finish(); return }
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()
        val red = ContextCompat.getColor(this, R.color.yt_red)
        val bg = ContextCompat.getColor(this, R.color.yt_bg)

        // ---- top: back, avatar, name + subscribers ----
        val back = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@ChannelActivity, null, R.drawable.ic_back, iconSizeDp = 24f))
            contentDescription = getString(R.string.yt_cd_back)
            setPadding(px(10), px(10), px(10), px(10))
            setOnClickListener { finish() }
        }
        avatar = ImageView(this).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setBackgroundColor(0xFF2A2A2A.toInt())
            contentDescription = getString(R.string.yt_cd_channel_avatar)
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setOval(0, 0, view.width, view.height)
                }
            }
        }
        nameText = VectorText(this)
        subsText = VectorText(this)
        val nameCol = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(nameText, LinearLayout.LayoutParams(-1, -2))
            addView(subsText, LinearLayout.LayoutParams(-1, -2).apply { topMargin = px(2) })
        }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(px(4), px(8), px(12), px(6))
            addView(back, LinearLayout.LayoutParams(px(44), px(44)))
            addView(avatar, LinearLayout.LayoutParams(px(52), px(52)).apply { marginStart = px(2); marginEnd = px(12) })
            addView(nameCol, LinearLayout.LayoutParams(0, -2, 1f))
        }
        descText = VectorText(this).apply {
            visibility = View.GONE
            contentDescription = getString(R.string.yt_cd_description)
            setOnClickListener {
                descOpen = !descOpen
                bindDescription()
            }
        }
        val descBox = FrameLayout(this).apply {
            setPadding(px(16), px(2), px(16), px(6))
            addView(descText, FrameLayout.LayoutParams(-1, -2))
        }
        tabRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(px(12), px(4), px(12), px(8))
            visibility = View.GONE
        }

        // ---- list ----
        adapter = SearchResultAdapter(
            onVideo = { YtNav.openVideo(this, it.url) },
            onChannel = { YtNav.openChannel(this, it.url) },
            onPlaylist = { YtNav.openPlaylist(this, it.url) }
        )
        grid = GridLayoutManager(this, spanCount())
        grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                if (adapter.getItemViewType(position) == SearchResultAdapter.TYPE_VIDEO) 1 else grid.spanCount
        }
        list = RecyclerView(this).apply {
            layoutManager = grid
            adapter = this@ChannelActivity.adapter
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
            indeterminateTintList = ColorStateList.valueOf(red)
            visibility = View.GONE
        }
        errorBox = centeredBox(R.drawable.ic_wifi_off, 56f, Color.WHITE).apply {
            val retry = ImageView(this@ChannelActivity).apply {
                setImageDrawable(VectorLabelDrawable(this@ChannelActivity, null, R.drawable.ic_retry, iconSizeDp = 26f))
                contentDescription = getString(R.string.yt_cd_retry)
                background = GlassDrawable(this@ChannelActivity, 32f, strong = true)
                setPadding(px(14), px(14), px(14), px(14))
                setOnClickListener { retry() }
            }
            addView(retry, LinearLayout.LayoutParams(px(54), px(54)).apply { topMargin = px(20) })
        }
        emptyBox = centeredBox(R.drawable.ic_search, 56f, 0xFF777777.toInt()).apply {
            getChildAt(0).contentDescription = getString(R.string.yt_cd_no_results)
        }
        val content = FrameLayout(this).apply {
            addView(list, FrameLayout.LayoutParams(-1, -1))
            addView(progress, FrameLayout.LayoutParams(px(40), px(40), Gravity.CENTER))
            addView(errorBox, FrameLayout.LayoutParams(-2, -2, Gravity.CENTER))
            addView(emptyBox, FrameLayout.LayoutParams(-2, -2, Gravity.CENTER))
        }

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            addView(topBar, LinearLayout.LayoutParams(-1, -2))
            addView(descBox, LinearLayout.LayoutParams(-1, -2))
            addView(tabRow, LinearLayout.LayoutParams(-1, -2))
            addView(content, LinearLayout.LayoutParams(-1, 0, 1f))
        }
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(b.left, b.top, b.right, b.bottom)
            insets
        }
        setContentView(root)

        loadChannel()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        grid.spanCount = spanCount()
    }

    private fun spanCount(): Int = maxOf(1, resources.configuration.screenWidthDp / 340)

    private fun centeredBox(iconRes: Int, sizeDp: Float, tint: Int): LinearLayout {
        val d = resources.displayMetrics.density
        val ic = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@ChannelActivity, null, iconRes, iconSizeDp = sizeDp, tint = tint))
        }
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            visibility = View.GONE
            addView(ic, LinearLayout.LayoutParams((sizeDp * d).toInt(), (sizeDp * d).toInt()))
        }
    }

    // ---- header ----

    private fun bindHeader(d: ChannelDetails) {
        val dens = resources.displayMetrics.density
        ThumbLoader.load(avatar, d.avatar, (52 * dens).toInt())
        nameText.set(d.name, 17f, Color.WHITE, bold = true, maxLines = 1)
        val subs = Format.count(d.subscribers)
        if (subs != null) {
            subsText.set("$subs subscribers", 12.5f, 0xFFAAAAAA.toInt(), maxLines = 1)
            subsText.visibility = View.VISIBLE
        } else {
            subsText.visibility = View.GONE
        }
        bindDescription()
    }

    private fun bindDescription() {
        val text = details?.description
        if (text.isNullOrBlank()) {
            descText.visibility = View.GONE
            return
        }
        descText.set(text, 12.5f, 0xFF9A9A9A.toInt(), maxLines = if (descOpen) 12 else 2)
        descText.visibility = View.VISIBLE
    }

    private fun buildTabs(d: ChannelDetails) {
        tabRow.removeAllViews()
        tabs.clear()
        val px = { v: Int -> (v * resources.displayMetrics.density).toInt() }
        for (key in d.tabs.keys) {
            val label = if (key == "playlists") "Playlists" else "Videos"
            val cd = if (key == "playlists") R.string.yt_cd_tab_playlists else R.string.yt_cd_tab_videos
            val chip = ImageView(this).apply {
                contentDescription = getString(cd)
                setPadding(px(16), px(9), px(16), px(9))
                tag = label
                setOnClickListener { if (tabKey != key) loadTab(key) }
            }
            tabs[key] = chip
            tabRow.addView(chip, LinearLayout.LayoutParams(-2, -2).apply { marginEnd = px(8) })
        }
        tabRow.visibility = if (tabs.isEmpty()) View.GONE else View.VISIBLE
    }

    /** The open tab is a light pill with dark text, the others are glass with light text. */
    private fun updateTabs() {
        val d = resources.displayMetrics.density
        for ((key, chip) in tabs) {
            val selected = key == tabKey
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

    // ---- loading ----

    private fun loadChannel() {
        val g = ++generation
        errorBox.visibility = View.GONE
        emptyBox.visibility = View.GONE
        adapter.setFooter(false)
        adapter.setAll(emptyList())
        progress.visibility = View.VISIBLE
        YtRepository.async({ YtRepository.channel(url) }) { result ->
            if (g != generation) return@async
            progress.visibility = View.GONE
            result.onSuccess { d ->
                details = d
                firstPages.clear()
                d.firstTab?.let { firstPages[it] = d.firstPage }
                bindHeader(d)
                buildTabs(d)
                val first = d.firstTab
                if (first == null) {
                    emptyBox.visibility = View.VISIBLE
                } else {
                    loadTab(first)
                }
            }.onFailure {
                errorBox.visibility = View.VISIBLE
            }
        }
    }

    /** Opens a tab: from the kept first page when it was loaded before, otherwise from the network. */
    private fun loadTab(key: String) {
        val g = ++generation
        tabKey = key
        updateTabs()
        loadingMore = false
        moreFailed = false
        next = null
        errorBox.visibility = View.GONE
        emptyBox.visibility = View.GONE
        adapter.setFooter(false)
        adapter.setAll(emptyList())
        firstPages[key]?.let { showPage(it); return }
        val handler = details?.tabs?.get(key) as? ListLinkHandler ?: return
        progress.visibility = View.VISIBLE
        YtRepository.async({ YtRepository.channelTab(handler) }) { result ->
            if (g != generation) return@async
            progress.visibility = View.GONE
            result.onSuccess {
                firstPages[key] = it
                showPage(it)
            }.onFailure {
                errorBox.visibility = View.VISIBLE
            }
        }
    }

    private fun showPage(page: PageResult) {
        seen.clear()
        val fresh = page.items.filter { seen.add(it.url) }
        adapter.setAll(fresh)
        next = page.next
        emptyBox.visibility = if (fresh.isEmpty()) View.VISIBLE else View.GONE
        list.scrollToPosition(0)
        list.post { checkMore() }
    }

    private fun retry() {
        val key = tabKey
        if (details == null || key == null) loadChannel() else loadTab(key)
    }

    private fun checkMore() {
        if (adapter.itemCount == 0) return
        if (grid.findLastVisibleItemPosition() >= adapter.itemCount - 5) loadMore()
    }

    private fun loadMore() {
        val page = next ?: return
        val key = tabKey ?: return
        val handler = details?.tabs?.get(key) ?: return
        if (loadingMore || moreFailed) return
        loadingMore = true
        adapter.setFooter(true)
        val g = generation
        YtRepository.async({ YtRepository.channelTabMore(handler, page) }) { result ->
            if (g != generation) return@async
            loadingMore = false
            adapter.setFooter(false)
            result.onSuccess { more ->
                val fresh = more.items.filter { seen.add(it.url) }
                adapter.append(fresh)
                next = more.next
                list.post { checkMore() }
            }.onFailure {
                moreFailed = true // stop until the tab is opened again
            }
        }
    }

    companion object {
        private const val EXTRA_URL = "url"

        fun start(context: Context, channelUrl: String) {
            val i = Intent(context, ChannelActivity::class.java).putExtra(EXTRA_URL, channelUrl)
            if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}
