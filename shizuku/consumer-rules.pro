# :shizuku (Shizuku step 3E): keep rules that go to the app which uses this library when it shrinks / obfuscates (:app has isMinifyEnabled = false today, so nothing here is applied
# yet; the file is there so that turning R8 on does not break the Shizuku server). Taken from upstream's manager/proguard-rules.pro (v13.6.0), only the rules that are about names that
# something looks up at run time. NOT taken: upstream's global options (-allowaccessmodification, -repackageclasses, -keepattributes, the -assumenosideeffects on Log.d / Intrinsics /
# Objects.requireNonNull): they would change the whole Win11 app, not only Shizuku.

# Entrance of the Shizuku server: started by app_process from the APK path (moe.shizuku.starter.ServiceStarter -> ShizukuService.main)
-keep class rikka.shizuku.server.ShizukuService {
    public static void main(java.lang.String[]);
}

# Entrance of the user service starter
-keep class moe.shizuku.starter.ServiceStarter {
    public static void main(java.lang.String[]);
}

# Entrance of the shell: rish_shizuku.dex (ShizukuShellLoader) loads this class from the host APK by name
-keep class moe.shizuku.manager.shell.Shell {
    public static void main(java.lang.String[], java.lang.String, android.os.IBinder, android.os.Handler);
}

# read by name through a Parcel (the provider module has the same rules)
-keepnames class moe.shizuku.api.BinderContainer
-keepclassmembers class moe.shizuku.api.BinderContainer {
    public static final android.os.Parcelable$Creator CREATOR;
}

# hidden-API adapters: their classes extend system classes that are missing at compile time
# (Missing class android.app.IProcessObserver$Stub / android.app.IUidObserver$Stub)
-keepclassmembers class rikka.hidden.compat.adapter.ProcessObserverAdapter {
    <methods>;
}
-keepclassmembers class rikka.hidden.compat.adapter.UidObserverAdapter {
    <methods>;
}

# native code that registers its methods with RegisterNatives by class name (libadb.so: adb_pairing.cpp, librish.so: rikka_rish_RishHost.cpp / rikka_rish_RishTerminal.cpp)
-keep class moe.shizuku.manager.adb.PairingContext { native <methods>; }
-keep class rikka.rish.RishHost { native <methods>; }
-keep class rikka.rish.RishTerminal { native <methods>; }
