package com.srizwan.win11

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.srizwan.win11.parallel.Engine

// =====================================================================
// PARALLEL APPS ("Open in black box (parallel)")
//
// The long-press menu of every app (Start > Pinned, Recent, All apps) has the entry
// "Open in black box (parallel)". It runs a second copy of that app inside the BlackBox
// virtual space (modules :Bcore, :black-reflection, :compiler), with its own data and accounts.
// The copy is made the first time (a message tells so), later taps just start it.
// The manager screen (all copies, add / clear data / remove) is the "Parallel" app in Start
// (parallel/ParallelActivity.kt).
// =====================================================================

object ParallelApps {

    const val MENU_TEXT = "Open in black box (parallel)"

    /** Opens (and, the first time, clones) [pkg] in the virtual space. Safe to call from the UI thread. */
    fun open(ctx: Context, pkg: String, label: String): Boolean {
        val appCtx = ctx.applicationContext
        val main = Handler(Looper.getMainLooper())
        fun toast(msg: String) = main.post { Toast.makeText(appCtx, msg, Toast.LENGTH_LONG).show() }

        Engine.io.execute {
            try {
                if (Engine.spaceOf(pkg) < 0) toast("Preparing $label in the black box...")
                val err = Engine.openOrClone(pkg)
                if (err != null) toast("$label: $err")
            } catch (e: Throwable) {
                AppLog.e("ParallelApps", "open $pkg failed", e)
                toast("Can't open $label in the black box")
            }
        }
        return true
    }
}
