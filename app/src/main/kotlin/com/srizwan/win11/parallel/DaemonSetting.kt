package com.srizwan.win11.parallel

import android.content.Context
import android.content.Intent
import android.os.Build
import top.niunaijun.blackbox.core.system.DaemonService
import java.io.File

/**
 * The "background service" option (the engine's `isEnableDaemonService`).
 *
 * When it is on, the engine process runs a small foreground service (with a low-priority
 * notification), so the system is less likely to kill the engine and the cloned apps in it. It costs
 * a permanent notification and some battery, so it is off by default.
 *
 * The engine runs in its own process and asks `ClientConfiguration.isEnableDaemonService()` there
 * (also later, when it recovers from a problem). SharedPreferences are not reliable across processes,
 * so the value is a marker file in the app's files folder, which every process of the app can read.
 * The file exists = on.
 */
object DaemonSetting {
    private const val FILE_NAME = "parallel_daemon_service.on"

    private fun flag(context: Context) = File(context.filesDir, FILE_NAME)

    /** Safe to call from any process. Default: off. */
    fun isEnabled(context: Context): Boolean = try {
        flag(context).exists()
    } catch (e: Throwable) {
        false
    }

    /** Saves the choice and starts / stops the service right away (no restart needed). */
    fun setEnabled(context: Context, on: Boolean) {
        try {
            val f = flag(context)
            if (on) {
                f.parentFile?.mkdirs()
                if (!f.exists()) f.createNewFile()
            } else {
                f.delete()
            }
        } catch (e: Throwable) {
            // the choice could not be saved: do not start or stop anything
            return
        }
        applyNow(context, on)
    }

    private fun applyNow(context: Context, on: Boolean) {
        try {
            val intent = Intent(context, DaemonService::class.java)
            if (on) {
                if (Build.VERSION.SDK_INT >= 26) context.startForegroundService(intent) else context.startService(intent)
            } else {
                context.stopService(intent)
            }
        } catch (e: Throwable) {
            // the engine applies the saved choice the next time it starts
        }
    }
}
