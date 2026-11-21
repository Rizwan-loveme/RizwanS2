package com.srizwan.chooser.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.content.ContextCompat

/**
 * Tells a sheet that an app was installed, removed, updated or enabled / disabled while the sheet is open (step 11), so the list
 * can be built again and a tile never points at an app that is gone. Several broadcasts in a row (an update sends a remove and an
 * add) become one call, [DELAY_MS] after the last. The receiver is registered with the application context and must be stopped
 * with [stop]; calling [start] or [stop] twice does no harm. Everything runs on the main thread.
 */
class PackageWatcher(context: Context, private val onChange: () -> Unit) {

    private val app = context.applicationContext
    private val handler = Handler(Looper.getMainLooper())
    private var registered = false

    private val fire = Runnable { onChange() }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            handler.removeCallbacks(fire)
            handler.postDelayed(fire, DELAY_MS)
        }
    }

    fun start() {
        if (registered) return
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_PACKAGE_ADDED)
            addAction(Intent.ACTION_PACKAGE_REMOVED)
            addAction(Intent.ACTION_PACKAGE_REPLACED)
            addAction(Intent.ACTION_PACKAGE_CHANGED)
            addDataScheme("package")
        }
        try {
            // these are protected system broadcasts: only the system can send them, so "exported" is safe
            ContextCompat.registerReceiver(app, receiver, filter, ContextCompat.RECEIVER_EXPORTED)
            registered = true
        } catch (e: Exception) {
            Log.w(TAG, "package watcher not started", e)
        }
    }

    fun stop() {
        handler.removeCallbacks(fire)
        if (!registered) return
        registered = false
        try {
            app.unregisterReceiver(receiver)
        } catch (e: IllegalArgumentException) {
            // already gone
        }
    }

    private companion object {
        const val TAG = "PackageWatcher"
        const val DELAY_MS = 400L
    }
}
