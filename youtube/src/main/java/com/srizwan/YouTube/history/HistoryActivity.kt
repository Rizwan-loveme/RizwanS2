package com.srizwan.YouTube.history

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
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
import com.srizwan.YouTube.search.SuggestionAdapter
import com.srizwan.YouTube.ui.GlassDrawable
import com.srizwan.YouTube.ui.GlassNavBar
import com.srizwan.YouTube.ui.YtTab
import com.srizwan.YouTube.ui.GlassSheet
import com.srizwan.YouTube.ui.VectorLabelDrawable

/**
 * Step 4 of the YouTube screens: history (all local, from [YtHistory]).
 *
 * Two tabs in the top bar: Watched (glass rows, tap to play again, cross to remove one) and Searches (tap runs
 * the search again, cross removes one). The bin at the top right clears the tab that is open, after a glass
 * confirmation sheet. The lists reload in onResume, so a video you just watched is at the top when you come back.
 * No text views: icons are vectors, tab labels and row text are vector outlines.
 */
class HistoryActivity : AppCompatActivity() {

    private enum class Tab { WATCHED, SEARCHES }

    private var tab = Tab.WATCHED
    private val tabs = LinkedHashMap<Tab, ImageView>()

    private lateinit var watchAdapter: WatchHistoryAdapter
    private lateinit var searchAdapter: SuggestionAdapter
    private lateinit var watchList: RecyclerView
    private lateinit var searchList: RecyclerView
    private lateinit var watchGrid: GridLayoutManager
    private lateinit var emptyBox: LinearLayout
    private lateinit var clearBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        YtHistory.init(this)
        val dp = resources.displayMetrics.density
        fun px(v: Int) = (v * dp).toInt()
        val bg = ContextCompat.getColor(this, R.color.yt_bg)

        // ---- top bar: back, the two tabs, clear ----
        val back = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@HistoryActivity, null, R.drawable.ic_back, iconSizeDp = 24f))
            contentDescription = getString(R.string.yt_cd_back)
            setPadding(px(10), px(10), px(10), px(10))
            setOnClickListener { finish() }
        }
        val tabRow = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        for ((t, label, cd) in listOf(
            Triple(Tab.WATCHED, "Watched", R.string.yt_cd_tab_watched),
            Triple(Tab.SEARCHES, "Searches", R.string.yt_cd_tab_searches)
        )) {
            val chip = ImageView(this).apply {
                contentDescription = getString(cd)
                setPadding(px(16), px(9), px(16), px(9))
                this.tag = label
                setOnClickListener {
                    if (tab != t) {
                        tab = t
                        refresh()
                    }
                }
            }
            tabs[t] = chip
            tabRow.addView(chip, LinearLayout.LayoutParams(-2, -2).apply { marginEnd = px(8) })
        }
        clearBtn = ImageView(this).apply {
            setImageDrawable(VectorLabelDrawable(this@HistoryActivity, null, R.drawable.ic_delete, iconSizeDp = 22f))
            contentDescription = getString(R.string.yt_cd_clear_all)
            background = GlassDrawable(this@HistoryActivity, 28f, strong = true)
            setPadding(px(9), px(9), px(9), px(9))
            setOnClickListener { confirmClear() }
        }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            setPadding(px(4), px(8), px(12), px(6))
            addView(back, LinearLayout.LayoutParams(px(44), px(44)))
            addView(tabRow, LinearLayout.LayoutParams(0, -2, 1f).apply { marginStart = px(4) })
            addView(clearBtn, LinearLayout.LayoutParams(px(40), px(40)))
        }

        // ---- lists ----
        watchAdapter = WatchHistoryAdapter(
            onOpen = { YtNav.openVideo(this, it.url) },
            onRemove = {
                YtHistory.removeWatch(it.url)
                updateEmpty()
            }
        )
        watchGrid = GridLayoutManager(this, spanCount())
        watchList = RecyclerView(this).apply {
            layoutManager = watchGrid
            adapter = watchAdapter
            clipToPadding = false
            setPadding(0, px(2), 0, px(12))
        }
        searchAdapter = SuggestionAdapter(
            onPick = { YtNav.openSearch(this, it) },
            onFill = { YtNav.openSearch(this, it) },
            onRemove = {
                YtHistory.removeSearch(it)
                refresh()
            },
            onClearAll = {},
            showFill = false
        )
        searchList = RecyclerView(this).apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = searchAdapter
            background = GlassDrawable(this@HistoryActivity, 20f, strong = true)
            setPadding(0, px(6), 0, px(6))
            clipToPadding = false
            overScrollMode = View.OVER_SCROLL_NEVER
        }

        val ic = ImageView(this).apply {
            setImageDrawable(
                VectorLabelDrawable(this@HistoryActivity, null, R.drawable.ic_history, iconSizeDp = 56f, tint = 0xFF777777.toInt())
            )
            contentDescription = getString(R.string.yt_cd_empty_history)
        }
        emptyBox = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            visibility = View.GONE
            addView(ic, LinearLayout.LayoutParams(px(56), px(56)))
        }

        val content = FrameLayout(this).apply {
            addView(watchList, FrameLayout.LayoutParams(-1, -1))
            addView(searchList, FrameLayout.LayoutParams(-1, -2, Gravity.TOP).apply {
                setMargins(px(12), px(4), px(12), px(12))
            })
            addView(emptyBox, FrameLayout.LayoutParams(-2, -2, Gravity.CENTER))
        }
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            addView(topBar, LinearLayout.LayoutParams(-1, -2))
            addView(content, LinearLayout.LayoutParams(-1, 0, 1f))
            // step 6: bottom navigation; history is the open tab
            val nav = GlassNavBar(this@HistoryActivity, YtTab.HISTORY) { YtNav.switchTab(this@HistoryActivity, YtTab.HISTORY, it) }
            addView(nav, nav.rootParams())
        }
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val b = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(b.left, b.top, b.right, b.bottom)
            insets
        }
        setContentView(root)
    }

    override fun onResume() {
        super.onResume()
        refresh()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        watchGrid.spanCount = spanCount()
    }

    private fun spanCount(): Int = maxOf(1, resources.configuration.screenWidthDp / 460)

    /** Reloads the open tab from [YtHistory] and restyles the tabs. */
    private fun refresh() {
        val d = resources.displayMetrics.density
        for ((t, chip) in tabs) {
            val selected = t == tab
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
        if (tab == Tab.WATCHED) {
            watchAdapter.setAll(YtHistory.watched())
        } else {
            searchAdapter.set(YtHistory.searchHistory().map { SuggestionAdapter.Row(it, true) }, showClearAll = false)
        }
        watchList.visibility = if (tab == Tab.WATCHED) View.VISIBLE else View.GONE
        updateEmpty()
    }

    private fun updateEmpty() {
        val empty = if (tab == Tab.WATCHED) YtHistory.watched().isEmpty() else YtHistory.searchHistory().isEmpty()
        emptyBox.visibility = if (empty) View.VISIBLE else View.GONE
        searchList.visibility = if (tab == Tab.SEARCHES && !empty) View.VISIBLE else View.GONE
        clearBtn.visibility = if (empty) View.INVISIBLE else View.VISIBLE
    }

    /** A glass sheet with the bin (confirm) and a cross (cancel). */
    private fun confirmClear() {
        GlassSheet.show(
            this,
            listOf(
                GlassSheet.Row(R.drawable.ic_delete, "Clear all", false),
                GlassSheet.Row(R.drawable.ic_close, "Cancel", false)
            )
        ) { index ->
            if (index != 0) return@show
            if (tab == Tab.WATCHED) YtHistory.clearWatch() else YtHistory.clearSearches()
            refresh()
        }
    }

    companion object {
        fun start(context: Context) {
            val i = Intent(context, HistoryActivity::class.java)
            if (context !is Activity) i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }
    }
}
