@file:androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)

package com.srizwan.YouTube.player

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.media3.common.Player
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService

/**
 * Background playback (part 5 of the player plan).
 *
 * A foreground `MediaSessionService` (type `mediaPlayback`) that wraps the shared [YtPlayer] in a
 * [MediaSession]. While it runs, the video keeps playing with the screen off, in another app, or after
 * the player screen is closed. It never owns the player: it only watches it, so the player screen and the
 * service always talk to the same ExoPlayer and nothing restarts when you switch between them.
 *
 * Media3 posts the playback notification and keeps the service in the foreground while it plays (default
 * notification; part 6 customises it and the lock-screen controls).
 */
class PlaybackService : MediaSessionService() {

    private var session: MediaSession? = null
    private var watched: Player? = null

    private val listener = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            if (playbackState == Player.STATE_ENDED) stopIfNoScreen()
        }

        override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
            stopIfNoScreen()
        }
    }

    override fun onCreate() {
        super.onCreate()
        val player = YtPlayer.peek()
        if (player == null) {
            stopSelf()
            return
        }
        val builder = MediaSession.Builder(this, player).setId(SESSION_ID)
        // tapping the notification opens the player screen (it picks up the loaded video by itself)
        builder.setSessionActivity(openPlayerIntent(this))
        session = builder.build()
        player.addListener(listener)
        watched = player
    }

    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession? = session

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val result = super.onStartCommand(intent, flags, startId)
        val s = session
        if (s == null || YtPlayer.peek() == null) {
            // nothing to play: leave at once (a started foreground service must not stay silent)
            stopSelf()
            return START_NOT_STICKY
        }
        // We were started with startForegroundService(): go to the foreground now with the notification.
        onUpdateNotification(s, /* startInForegroundRequired = */ true)
        return result
    }

    /** The app was swiped out of recents: keep going if it is playing, otherwise stop. */
    override fun onTaskRemoved(rootIntent: Intent?) {
        if (!isPlaying(watched)) stopSelf()
    }

    override fun onDestroy() {
        watched?.removeListener(listener)
        watched = null
        session?.release() // does not release the player: YtPlayer owns it
        session = null
        // The service ended (notification dismissed / video finished) and no screen is showing the player:
        // free it, otherwise it would stay loaded with nothing to control it.
        if (!YtPlayer.screenVisible) YtPlayer.release()
        super.onDestroy()
    }

    private fun stopIfNoScreen() {
        if (!YtPlayer.screenVisible) stopSelf()
    }

    companion object {
        private const val SESSION_ID = "yt_player"

        /** Playing now, or about to play (buffering with play requested). */
        fun isPlaying(p: Player?): Boolean =
            p != null && (p.isPlaying ||
                (p.playWhenReady && p.playbackState == Player.STATE_BUFFERING))

        /**
         * Starts the service as a foreground service. Call it while the player screen is visible
         * (Android 12+ does not allow starting a foreground service from the background).
         */
        fun start(context: Context) {
            val app = context.applicationContext
            ContextCompat.startForegroundService(app, Intent(app, PlaybackService::class.java))
        }

        fun stop(context: Context) {
            val app = context.applicationContext
            app.stopService(Intent(app, PlaybackService::class.java))
        }

        /** Intent of the notification tap: no url extra, [PlayerActivity] falls back to the loaded video. */
        private fun openPlayerIntent(context: Context): PendingIntent {
            val i = Intent(context, PlayerActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            var flags = PendingIntent.FLAG_UPDATE_CURRENT
            if (Build.VERSION.SDK_INT >= 23) flags = flags or PendingIntent.FLAG_IMMUTABLE
            return PendingIntent.getActivity(context, 0, i, flags)
        }
    }
}
