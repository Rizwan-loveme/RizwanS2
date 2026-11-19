package com.srizwan.win11

import android.app.Application
import android.os.Build

/** Starts logging + crash capture before any Activity / Service / Receiver runs. */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppLog.init(this)
        AppLog.installCrashHandler()
        AppLog.i("App", "process start | ${Build.MANUFACTURER} ${Build.MODEL} | Android ${Build.VERSION.RELEASE} (API ${Build.VERSION.SDK_INT})")
    }
}
