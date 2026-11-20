package com.srizwan.win11

import android.content.ComponentName
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import com.winlator.XServerDisplayActivity
import com.winlator.container.Container
import com.winlator.container.ContainerManager
import com.winlator.core.ExternalRun
import com.winlator.xenvironment.RootFS
import java.io.File

/**
 * Opens the built-in Winlator (module :winlator, Wine + Box64 for PC software).
 * Used by the Start menu, the taskbar, the desktop icon and the rizwans2://winlator link.
 * Part 6: [runFile] runs a Windows file (.exe .msi .bat .lnk, or any file via "Open with Winlator") from the File Manager.
 * Part 7: no more "tap again" - when Winlator is not set up yet, or has no container, it opens its two-step
 * set-up (rootfs, first container "Win11") and then starts the file by itself. Phone storage is drive F:.
 */
object WinlatorLauncher {

    private const val TAG = "Winlator"

    /**
     * Part 9: sends every message of the :winlator module (set-up, container, Wine start / exit, errors)
     * to [AppLog], tag "Winlator/<area>", so they show in the Debug log (Quick Settings -> Debug log).
     * Called once from App.onCreate in the launcher process.
     */
    fun installLogBridge() {
        com.winlator.core.WinlatorLog.setSink(com.winlator.core.WinlatorLog.Sink { level, tag, message, error ->
            val t = "Winlator/$tag"
            when (level) {
                'E' -> AppLog.e(t, message, error)
                'W' -> AppLog.w(t, message, error)
                'D' -> AppLog.d(t, message)
                else -> AppLog.i(t, message)
            }
        })
    }

    /** Section name used by the shell (taskbar / desktop / Start menu entry). */
    const val SECTION = "winlator"

    /** Disabled alias in the :winlator manifest: its LAUNCHER filter is the optional Android app-drawer icon. */
    private const val DRAWER_ALIAS = "com.winlator.WinlatorLauncherAlias"

    /** Winlator (Wine + Box64 + the Linux root file system) only exists for 64-bit ARM. */
    fun isSupported(): Boolean = Build.SUPPORTED_64_BIT_ABIS.any { it == "arm64-v8a" }

    /**
     * Starts the Winlator home screen in its own task (see taskAffinity in the :winlator manifest).
     * [extras] are passed to com.winlator.MainActivity unchanged.
     */
    fun open(ctx: Context, extras: android.os.Bundle? = null): Boolean {
        if (!isSupported()) {
            Toast.makeText(ctx, "Winlator needs a 64-bit ARM (arm64-v8a) phone", Toast.LENGTH_LONG).show()
            return false
        }
        return try {
            val i = Intent(ctx, com.winlator.MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                if (extras != null) putExtras(extras)
            }
            ctx.startActivity(i)
            AppLog.i(TAG, "Winlator opened")
            true
        } catch (e: Throwable) {
            AppLog.e(TAG, "cannot open Winlator", e)
            Toast.makeText(ctx, "Can't open Winlator", Toast.LENGTH_SHORT).show()
            false
        }
    }

    // ── Part 6: run a file from the File Manager ─────────────────────────────

    /** Windows programs the File Manager runs on a tap. */
    private val WINDOWS_EXT = setOf("exe", "msi", "bat", "lnk")

    fun isWindowsProgram(name: String): Boolean =
        isSupported() && name.substringAfterLast('.', "").lowercase() in WINDOWS_EXT

    private const val PREFS = "winlator_launcher"
    private const val KEY_LAST_CONTAINER = "last_container"

    /**
     * Runs [file] in a Winlator container. Steps: Winlator set up? (otherwise it is opened so it can
     * install itself) -> a container exists? -> which container (the last used one; a chooser when
     * [pickContainer] is set or none was used yet and there are several) -> the file's storage becomes a
     * drive of that container -> XServerDisplayActivity starts with container_id + exec_path.
     */
    fun runFile(activity: Activity, file: File, pickContainer: Boolean = false) {
        if (!isSupported()) {
            Toast.makeText(activity, "Winlator needs a 64-bit ARM (arm64-v8a) phone", Toast.LENGTH_LONG).show()
            return
        }
        if (!file.isFile || !file.canRead()) {
            Toast.makeText(activity, "Can't read ${file.name}", Toast.LENGTH_SHORT).show()
            return
        }
        try {
            if (!RootFS.find(activity).isValid) {
                Toast.makeText(activity, "Winlator needs its one-time setup first. It starts now and runs ${file.name} when it is done.", Toast.LENGTH_LONG).show()
                open(activity, pendingExtras(file))
                return
            }
            if (XServerDisplayActivity.sessionRunning) {
                Toast.makeText(activity, "A Windows program is already running in Winlator. Exit it first.", Toast.LENGTH_LONG).show()
                activity.startActivity(Intent(activity, XServerDisplayActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                return
            }
            val containers: List<Container> = ContainerManager(activity).containers.sortedBy { it.id }
            if (containers.isEmpty()) {
                Toast.makeText(activity, "Creating the first Winlator container, then ${file.name} starts.", Toast.LENGTH_LONG).show()
                open(activity, pendingExtras(file))
                return
            }
            val prefs = activity.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            val last = containers.firstOrNull { it.id == prefs.getInt(KEY_LAST_CONTAINER, -1) }
            when {
                containers.size == 1 -> start(activity, containers[0], file)
                last != null && !pickContainer -> start(activity, last, file)
                else -> {
                    val names = containers.map { it.name }.toTypedArray()
                    W11Dialog.Builder(activity).setTitle("Run in container")
                        .setItems(names) { _, which -> start(activity, containers[which], file) }
                        .setNegativeButton("Cancel", null).show()
                }
            }
        } catch (e: Throwable) {
            AppLog.e(TAG, "runFile failed: ${file.absolutePath}", e)
            Toast.makeText(activity, "Can't run ${file.name} with Winlator", Toast.LENGTH_SHORT).show()
        }
    }

    /** Extras for com.winlator.MainActivity: set up first, then run [file] (see MainActivity.EXTRA_RUN_EXEC_PATH). */
    private fun pendingExtras(file: File) = android.os.Bundle().apply {
        putString(com.winlator.MainActivity.EXTRA_RUN_EXEC_PATH, file.absolutePath)
    }

    private fun start(activity: Activity, container: Container, file: File) {
        try {
            // Part 7: the whole phone storage (what the File Manager shows) is a Wine drive, also in older containers
            ExternalRun.ensureSharedDrive(container)
            val execPath = ExternalRun.ensureDrive(container, file.absolutePath)
            if (execPath == null) {
                Toast.makeText(activity, "No free drive letter in container \"${container.name}\". Remove a drive in the container settings.", Toast.LENGTH_LONG).show()
                return
            }
            activity.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putInt(KEY_LAST_CONTAINER, container.id).apply()
            AppLog.i(TAG, "run ${file.absolutePath} in container ${container.id} (${container.name})")
            activity.startActivity(ExternalRun.buildRunIntent(activity, container.id, execPath))
        } catch (e: Throwable) {
            AppLog.e(TAG, "start failed: ${file.absolutePath}", e)
            Toast.makeText(activity, "Can't run ${file.name} with Winlator", Toast.LENGTH_SHORT).show()
        }
    }

    private fun alias(ctx: Context) = ComponentName(ctx.packageName, DRAWER_ALIAS)

    /** True when the extra "Winlator" icon is shown in the Android app drawer (off by default). */
    fun isDrawerIconEnabled(ctx: Context): Boolean = try {
        ctx.packageManager.getComponentEnabledSetting(alias(ctx)) == PackageManager.COMPONENT_ENABLED_STATE_ENABLED
    } catch (e: Throwable) { false }

    fun setDrawerIconEnabled(ctx: Context, enabled: Boolean) {
        try {
            ctx.packageManager.setComponentEnabledSetting(
                alias(ctx),
                if (enabled) PackageManager.COMPONENT_ENABLED_STATE_ENABLED else PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        } catch (e: Throwable) { AppLog.e(TAG, "drawer icon switch failed", e) }
    }

    /** Text of the long-press menu item that flips the app-drawer icon. */
    fun drawerMenuText(ctx: Context): String =
        if (isDrawerIconEnabled(ctx)) "Hide Winlator icon from app drawer" else "Show Winlator icon in app drawer"
}
