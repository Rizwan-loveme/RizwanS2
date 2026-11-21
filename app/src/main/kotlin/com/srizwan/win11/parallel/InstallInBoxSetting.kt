package com.srizwan.win11.parallel

import android.content.Context
import java.io.File

/**
 * Part 31: "install from inside the box".
 *
 * On (default): when a cloned app asks to install an APK, the box shows its own install dialog and puts
 * the app into the same space. Off: the system installer runs and the app lands on the phone.
 *
 * Cloned apps run in other processes of this app and ask `ClientConfiguration.isInstallInsideBox()` there,
 * so (like [DaemonSetting]) the value is a marker file every process can read. Here the file means OFF,
 * because the default is on.
 */
object InstallInBoxSetting {
    private const val FILE_NAME = "parallel_install_in_box.off"

    private fun flag(context: Context) = File(context.filesDir, FILE_NAME)

    /** Safe to call from any process. Default: on. */
    fun isEnabled(context: Context): Boolean = try {
        !flag(context).exists()
    } catch (e: Throwable) {
        true
    }

    fun setEnabled(context: Context, on: Boolean) {
        try {
            val f = flag(context)
            if (on) {
                f.delete()
            } else {
                f.parentFile?.mkdirs()
                if (!f.exists()) f.createNewFile()
            }
        } catch (e: Throwable) {
            // the choice could not be saved; the old value stays
        }
    }
}
