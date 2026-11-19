package com.srizwan.win11

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.os.Build
import android.view.accessibility.AccessibilityEvent

/**
 * Tiny accessibility service (no XML config; set up in code) whose only job is to
 * perform the global actions Android allows launchers to trigger:
 * lock screen (API 28+), take screenshot (API 28+) and the system power dialog (API 21+, Android 5.0 and up).
 */
class PowerService : AccessibilityService() {

    companion object {
        @Volatile var instance: PowerService? = null
            private set

        val isEnabled: Boolean get() = instance != null

        fun lock(): Boolean =
            Build.VERSION.SDK_INT >= 28 &&
                instance?.performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN) == true

        /** One-tap system screenshot (Android 9+). Needs this accessibility service enabled. */
        fun screenshot(): Boolean =
            Build.VERSION.SDK_INT >= 28 &&
                instance?.performGlobalAction(GLOBAL_ACTION_TAKE_SCREENSHOT) == true

        // FIX: GLOBAL_ACTION_POWER_DIALOG exists since Android 5.0 (API 21), not only 12 (API 31).
        fun powerDialog(): Boolean =
            Build.VERSION.SDK_INT >= 21 &&
                instance?.performGlobalAction(GLOBAL_ACTION_POWER_DIALOG) == true
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        AppLog.i("PowerService", "connected")
        instance = this
        serviceInfo = AccessibilityServiceInfo().apply {
            eventTypes = 0
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            notificationTimeout = 100
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}

    override fun onUnbind(intent: android.content.Intent?): Boolean {
        instance = null
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        instance = null
        super.onDestroy()
    }
}
