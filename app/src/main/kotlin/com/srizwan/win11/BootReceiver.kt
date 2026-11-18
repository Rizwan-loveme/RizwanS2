package com.srizwan.win11

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Starts the launcher when the device finishes booting (including "quick boot"). When the app is the default Home app Android
 * already opens it at boot; this covers the other cases. Newer Android versions
 * may refuse to open an activity from the background, so the call is guarded.
 */
class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_BOOT_COMPLETED,
            "android.intent.action.QUICKBOOT_POWERON",
            "com.htc.intent.action.QUICKBOOT_POWERON" -> {
                try {
                    context.startActivity(
                        Intent(context, MainActivity::class.java)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    )
                } catch (e: Exception) { }
            }
        }
    }
}
