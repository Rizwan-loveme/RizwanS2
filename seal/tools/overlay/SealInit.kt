package com.junkfood.seal

import android.app.Application
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import androidx.core.content.getSystemService
import com.junkfood.seal.util.AUDIO_DIRECTORY
import com.junkfood.seal.util.COMMAND_DIRECTORY
import com.junkfood.seal.util.DownloadUtil
import com.junkfood.seal.util.FileUtil
import com.junkfood.seal.util.FileUtil.getCookiesFile
import com.junkfood.seal.util.FileUtil.getExternalDownloadDirectory
import com.junkfood.seal.util.NotificationUtil
import com.junkfood.seal.util.PreferenceUtil
import com.junkfood.seal.util.PreferenceUtil.getString
import com.junkfood.seal.util.PreferenceUtil.updateString
import com.junkfood.seal.util.VIDEO_DIRECTORY
import com.tencent.mmkv.MMKV
import com.yausername.aria2c.Aria2c
import com.yausername.ffmpeg.FFmpeg
import com.yausername.youtubedl_android.YoutubeDL
import java.io.File
import java.util.concurrent.atomic.AtomicBoolean
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import com.junkfood.seal.download.DownloaderV2
import com.junkfood.seal.download.DownloaderV2Impl
import com.junkfood.seal.ui.page.download.HomePageViewModel
import com.junkfood.seal.ui.page.downloadv2.configure.DownloadDialogViewModel
import com.junkfood.seal.ui.page.settings.network.CookiesViewModel
import com.junkfood.seal.ui.page.videolist.VideoListViewModel

/**
 * Win11: Seal's start-up, moved out of upstream's `App : Application` (Seal has no Application class of its own here).
 *
 * The host `App.onCreate` (launcher process only) calls [init] once. What it does is what upstream's `App.onCreate` did,
 * minus three things that do not belong in a built-in app:
 *   - no second `Thread.setDefaultUncaughtExceptionHandler` (the launcher's own crash handler covers the whole process);
 *   - no `DynamicColors.applyToActivitiesIfAvailable` (it would recolour every Activity of the launcher; Seal's own theme asks for dynamic colour itself);
 *   - no `UpdateUtil.deleteOutdatedApk` (Seal's self-update was removed, the launcher is not updated by Seal).
 *
 * The Seal screens and the download service only run in the launcher process (no android:process, see part 5), so nothing
 * here is needed in the other processes (:midlet, :mame, :retroarch, BlackBox).
 */
object SealInit {
    private const val TAG = "SealInit"
    private val started = AtomicBoolean(false)

    @Volatile var engineReady: Boolean = false
        private set

    /** Set when YoutubeDL / FFmpeg / Aria2c could not be initialised (kept for the UI, also sent to [onEngineError]). */
    @Volatile var engineError: Throwable? = null
        private set

    /** Safe to call more than once and from any thread that may touch Application; only the first call does work. */
    fun init(app: Application, onEngineError: ((Throwable) -> Unit)? = null) {
        if (!started.compareAndSet(false, true)) return

        // 1. storage for settings (PreferenceUtil reads MMKV; must come first)
        MMKV.initialize(app)

        // 2. the static fields every Seal class reads through App.Companion (must be set before NotificationUtil / DownloadUtil are touched)
        App.context = app.applicationContext
        App.packageInfo =
            app.packageManager.run {
                if (Build.VERSION.SDK_INT >= 33)
                    getPackageInfo(app.packageName, PackageManager.PackageInfoFlags.of(0))
                else getPackageInfo(app.packageName, 0)
            }
        App.applicationScope = CoroutineScope(SupervisorJob())
        App.clipboard = app.getSystemService()!!
        App.connectivityManager = app.getSystemService()!!

        // 3. Koin (DownloaderV2 + 4 ViewModels). Skipped if something else already started Koin in this process.
        if (GlobalContext.getOrNull() == null) {
            startKoin {
                androidLogger()
                androidContext(app)
                modules(
                    module {
                        single<DownloaderV2> { DownloaderV2Impl(androidContext()) }
                        viewModel { DownloadDialogViewModel(downloader = get()) }
                        viewModel { HomePageViewModel() }
                        viewModel { CookiesViewModel() }
                        viewModel { VideoListViewModel() }
                    }
                )
            }
        }

        // 4. download folders. Part 6: getExternalDownloadDirectory() is the launcher's own public Downloads folder (FileUtil patch), so video goes to Download/ (where the Browser saves),
        //    audio to Download/Audio (upstream's rule: <video folder>/Audio). A folder the user picked in Seal's settings is kept (MMKV) and wins.
        App.videoDownloadDir = VIDEO_DIRECTORY.getString(getExternalDownloadDirectory().absolutePath)
        App.audioDownloadDir =
            AUDIO_DIRECTORY.getString(File(App.videoDownloadDir, "Audio").absolutePath)
        if (!PreferenceUtil.containsKey(COMMAND_DIRECTORY)) {
            COMMAND_DIRECTORY.updateString(App.videoDownloadDir)
        }

        // 5. notification channels (minSdk of the project is 26, so no version check)
        NotificationUtil.createNotificationChannel()

        // 6. yt-dlp engine: Python + yt-dlp + FFmpeg + aria2c. The first start unpacks them (slow), so it runs in the background like upstream.
        App.applicationScope.launch(Dispatchers.IO) {
            try {
                YoutubeDL.init(app)
                FFmpeg.init(app)
                Aria2c.init(app)
                DownloadUtil.getCookiesContentFromDatabase().getOrNull()?.let {
                    FileUtil.writeContentToFile(it, app.getCookiesFile())
                }
                engineReady = true
            } catch (th: Throwable) {
                // upstream opened its own crash screen here; the launcher must not show one for a downloader engine, so only log and keep the error
                Log.e(TAG, "yt-dlp engine init failed", th)
                engineError = th
                try {
                    onEngineError?.invoke(th)
                } catch (_: Throwable) {}
            }
        }
    }
}
