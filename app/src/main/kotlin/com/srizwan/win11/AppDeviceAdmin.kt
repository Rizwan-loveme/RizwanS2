package com.srizwan.win11

import android.app.Activity
import android.app.admin.DevicePolicyManager
import android.app.admin.DeviceAdminReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Device-admin receiver used only to make uninstalling the app a deliberate,
 * two-step action: while it's active, Android blocks the normal uninstall
 * flow until the user deactivates it from here or from
 * Settings → Security → Device admin apps. It declares no device policies
 * (no password rules, no remote wipe, nothing else) — it only occupies the
 * "active admin" slot that the OS checks before allowing an uninstall.
 */
class AppDeviceAdmin : DeviceAdminReceiver() {

    override fun onEnabled(context: Context, intent: Intent) {
        Toast.makeText(context, "Uninstall protection turned on", Toast.LENGTH_SHORT).show()
    }

    override fun onDisabled(context: Context, intent: Intent) {
        Toast.makeText(context, "Uninstall protection turned off", Toast.LENGTH_SHORT).show()
    }

    companion object {
        private fun componentName(ctx: Context) = ComponentName(ctx, AppDeviceAdmin::class.java)

        fun isActive(ctx: Context): Boolean {
            val dpm = ctx.getSystemService(Context.DEVICE_POLICY_SERVICE) as? DevicePolicyManager
                ?: return false
            return try { dpm.isAdminActive(componentName(ctx)) } catch (e: Exception) { false }
        }

        /** Shows the system's own consent screen; the user must tap Activate there. */
        fun requestActivation(activity: Activity, requestCode: Int) {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName(activity))
                putExtra(
                    DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                    "Keeps RizwanS2 from being uninstalled by accident. You can turn this " +
                        "off any time from this screen or from Settings → Security → Device admin apps."
                )
            }
            activity.startActivityForResult(intent, requestCode)
        }

        /** Turns protection off immediately (no system dialog needed to disable). */
        fun deactivate(ctx: Context) {
            val dpm = ctx.getSystemService(Context.DEVICE_POLICY_SERVICE) as? DevicePolicyManager
                ?: return
            try {
                dpm.removeActiveAdmin(componentName(ctx))
            } catch (e: Exception) { }
        }
    }
}
