package com.srizwan.YouTube.playlist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Outline
import android.os.Bundle
import android.view.Gravity
import android.view.View
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
import com.srizwan.YouTube.data.PlaylistDetails
import com.srizwan.YouTube.data.YtItem
import com.srizwan.YouTube.data.YtRepository
import com.srizwan.YouTube.home.VideoCardAdapter
import com.srizwan.YouTube.ui.Format
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.ThumbLoader
import com.srizwan.YouTube.ui.VectorLabelDrawable
import com.srizwan.YouTube.ui.VectorText
import org.schabi.newpipe.extractor.Page

/**
 * Step 5 of the YouTube screens: a playlist.
 *
 * Top: back and a glass header (thumbnail, title, owner and video count). Below it the videos as the same glass
 * cards as the home feed ([VideoCardAdapter]); more load when you reach the end. A tap plays the video.
 * No text views: icons are vectors, text is vector outlines.
 */
class PlaylistActivity : AppCompatActivity() {

    private lateinit var url: String
    private lateinit var thumb: ImageView
    private lateinit var titleText: VectorText
    private lateinit var metaText: VectorText

    private lateinit var adapter: VideoCardAdapter
    private lateinit var list: RecyclerView
    private lateinit var grid: GridLayoutManager
    private lateinit var progress: ProgressBar
    private lateinit var errorBox: LinearLayout
    private lateinit var emptyBox: LinearLayout

    private var next: Page? = null
    private var loadingMore = false
    private var moreFailed = false
    private var generation = 0
    private val seen = HashSet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = intent.getStringExtra(EXTRA_URL) ?: run { finish(); return }
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()
        val red = ContextCompat.getColor(this, R.color.yt_red)
        val bg = ContextCompat.getColor(this, R.color.yt_bg)

        val back = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@PlaylistActivity, null, R.drawable.ic_back, iconSizeDp = 24f))
            contentDescription = getString(R.string.yt_cd_back)
            setPadding(px(10), px(10), px(10), px(10))
            setOnClickListener { finish() }
        }
        thumb = ImageView(this).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            setBackgroundColor(0xFF1A1A1A.toInt())
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, 10f * dp)
                }
            }
        }
        titleText = VectorText(this)
        metaText = VectorText(this)
        val info = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(titleText, LinearLayout.LayoutParams(-1, -2))
            addView(metaText, LinearLayout.LayoutParams(-1, -2).apply { topMargin = px(4) })
        }
        val header = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = GlassDrawable(this@PlaylistActivity, 18f, strong = true)
            setPadding(px(8), px(8), px(14), px(8))
            addView(thumb, LinearLayout.LayoutParams(px(112), px(63)).apply { marginEnd = px(12) })
            addView(info, LinearLayout.LayoutParams(0, -2, 1f))
        }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(px(4), px(8), px(12), px(8))
            addView(back, LinearLayout.LayoutParams(px(44), px(44)))
            addView(header, LinearLayout.LayoutParams(0, -2, 1f).apply { marginStart = px(2) })
        }

        adapter = VideoCardAdapter { YtNav.openVideo(this, it.url) }
        grid = GridLayoutManager(this, spanCount())
        list = RecyclerView(this).apply {
            layoutManager = grid
            adapter = this@PlaylistActivity.adapter
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
            val retry = ImageView(this@PlaylistActivity).apply {
                setImageDrawable(VectorLabelDrawable(this@PlaylistActivity, null, R.drawable.ic_retry, iconSizeDp = 26f))
                contentDescription = getString(R.string.yt_cd_retry)
                background = GlassDrawable(this@PlaylistActivity, 32f, strong = true)
                setPadding(px(14), px(14), px(14), px(14))
                setOnClickListener { load() }
            }
            addView(retry, LinearLayout.LayoutParams(px(54), px(54)).apply { topMargin = px(20) })
        }
        emptyBox = centeredBox(R.drawable.ic_playlist, 56f, 0xFF777777.toInt()).apply {
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
            addView(content, LinearLayout.LayoutParams(-1, 0, 1f))
        }
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(b.left, b.top, b.right, b.bottom)
            insets
        }
        setContentView(root)

        load()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        grid.spanCount = spanCount()
    }

    private fun spanCount(): Int = maxOf(1, resources.configuration.screenWidthDp / 340)

    private fun centeredBox(iconRes: Int, sizeDp: Float, tint: Int): LinearLayout {
        val d = resources.displayMetrics.density
        val ic = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@PlaylistActivity, null, iconRes, iconSizeDp = sizeDp, tint = tint))
        }
        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            visibility = View.GONE
            addView(ic, LinearLayout.LayoutParams((sizeDp * d).toInt(), (sizeDp * d).toInt()))
        }
    }

    private fun bindHeader(p: PlaylistDetails) {
        val d = resources.displayMetrics.density
        ThumbLoader.load(thumb, p.thumb, (112 * d).toInt())
        titleText.set(p.name, 15f, Color.WHITE, bold = true, maxLines = 2)
        val parts = ArrayList<String>(2)
        if (p.owner.isNotBlank()) parts.add(p.owner)
        Format.count(p.videoCount)?.let { parts.add("$it videos") }
        if (parts.isEmpty()) {
            metaText.visibility = View.GONE
        } else {
            metaText.set(parts.joinToString("  ·  "), 12.5f, 0xFFAAAAAA.toInt(), maxLines = 2)
            metaText.visibility = View.VISIBLE
        }
    }

    private fun load() {
        val g = ++generation
        loadingMore = false
        moreFailed = false
        next = null
        errorBox.visibility = View.GONE
        emptyBox.visibility = View.GONE
        adapter.setAll(emptyList())
        progress.visibility = View.VISIBLE
        YtRepository.async({ YtRepository.playlist(url) }) { result ->
            if (g != generation) return@async
            progress.visibility = View.GONE
            result.onSuccess { p ->
                bindHeader(p)
                seen.clear()
                val videos = p.firstPage.items.filterIsInstance<YtItem.Video>().filter { seen.add(it.url) }
                adapter.setAll(videos)
                next = p.firstPage.next
                emptyBox.visibility = if (videos.isEmpty()) View.VISIBLE else View.GONE
                list.post { checkMore() }
            }.onFailure {
                errorBox.visibility = View.VISIBLE
            }
        }
    }

    private fun checkMore() {
        if (adapter.itemCount == 0) return
        if (grid.findLastVisibleItemPosition() >= adapter.itemCount - 5) loadMore()
    }

    private fun loadMore() {
        val page = next ?: return
        if (loadingMore || moreFailed) return
        loadingMore = true
        val g = generation
        YtRepository.async({ YtRepository.playlistMore(url, page) }) { result ->
            if (g != generation) return@async
            loadingMore = false
            result.onSuccess { more ->
                val fresh = more.items.filterIsInstance<YtItem.Video>().filter { seen.add(it.url) }
                adapter.append(fresh)
                next = more.next
                list.post { checkMore() }
            }.onFailure {
                moreFailed = true // stop until the playlist is opened again
            }
        }
    }

    companion object {
        private const val EXTRA_URL = "url"

        fun start(context: Context, playlistUrl: String) {
            val i = Intent(context, PlaylistActivity::class.java).putExtra(EXTRA_URL, playlistUrl)
            if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}
