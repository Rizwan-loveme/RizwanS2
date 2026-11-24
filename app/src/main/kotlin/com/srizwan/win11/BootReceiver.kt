package com.srizwan.win11

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Starts the launcher when the device finishes booting (including "quick boot"). When the app is the default Home app Android
 * already opens it at boot; this covers the other cases. Newer Android versions
 * may refuse to open an activity from the background, so the call is guarded.
 * Terminal step 9: it starts the home screen of the saved launcher theme (ThemeManager.homeIntent()): MainActivity for Win11, the terminal screen
 * directly for TERMINAL (so the Win11 UI is not built just to be forwarded).
 */
class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_BOOT_COMPLETED,
            "android.intent.action.QUICKBOOT_POWERON",
            "com.htc.intent.action.QUICKBOOT_POWERON" -> {
                try {
                    context.startActivity(
                        ThemeManager.homeIntent(context)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    )
                } catch (e: Exception) { }
            }
        }
    }
}
