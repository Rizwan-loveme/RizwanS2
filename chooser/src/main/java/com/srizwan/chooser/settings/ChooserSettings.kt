package com.srizwan.chooser.settings

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Opens the settings screen of the Chooser (step 11). The gear in the Open with and Share sheets calls it, and `:app` calls it for
 * the deep link `rizwans2://chooser`.
 */
object ChooserSettings {

    private const val TAG = "ChooserSettings"

    /** Starts [ChooserSettingsActivity]. A failure is only logged: the caller stays as it is. */
    fun open(context: Context) {
        try {
            val intent = Intent(context, ChooserSettingsActivity::class.java)
            if (context !is Activity) intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } catch (e: Exception) {
            Log.w(TAG, "settings screen could not be opened", e)
        }
    }
}
