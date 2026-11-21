package com.srizwan.YouTube

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.srizwan.YouTube.channel.ChannelActivity
import com.srizwan.YouTube.history.HistoryActivity
import com.srizwan.YouTube.player.PlayerActivity
import com.srizwan.YouTube.playlist.PlaylistActivity
import com.srizwan.YouTube.search.SearchActivity
import com.srizwan.YouTube.ui.YtTab

/**
 * Where a tap on a list row goes. Every list screen (home feed, search results, history, channel, playlist)
 * calls these, so a new screen is hooked in at ONE place.
 */
object YtNav {

    fun openVideo(context: Context, url: String) = PlayerActivity.start(context, url)

    fun openSearch(context: Context, query: String? = null) = SearchActivity.start(context, query)

    fun openHistory(context: Context) = HistoryActivity.start(context)

    fun openChannel(context: Context, url: String) = ChannelActivity.start(context, url)

    fun openPlaylist(context: Context, url: String) = PlaylistActivity.start(context, url)

    /**
     * Bottom navigation: goes from the main screen [from] to [to]. Home is the bottom of the stack (everything
     * above it is closed); search and history replace each other, so Back always returns to home.
     * Tapping the open tab does nothing here (the search screen handles that itself).
     */
    fun switchTab(activity: Activity, from: YtTab, to: YtTab) {
        if (from == to) return
        when (to) {
            YtTab.HOME -> activity.startActivity(
                Intent(activity, YouTubeActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            )
            YtTab.SEARCH -> {
                SearchActivity.start(activity)
                if (from != YtTab.HOME) activity.finish()
            }
            YtTab.HISTORY -> {
                HistoryActivity.start(activity)
                if (from != YtTab.HOME) activity.finish()
            }
        }
        @Suppress("DEPRECATION")
        activity.overridePendingTransition(0, 0) // tabs switch without a slide
    }
}
