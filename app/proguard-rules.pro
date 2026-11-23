# =====================================================================================
# Release build rules (R8 code shrink + resource shrink) for the WHOLE project.
# Goal: the release app must behave exactly like the debug app (no crash from removed or
# renamed code). Safety first, size second:
#   * -dontobfuscate : nothing is renamed, so reflection, JNI (native code calling Java),
#                      class names in strings / intents / XML all keep working.
#   * -dontoptimize  : no risky code rewriting (inlining etc.), only unused code is removed.
#   * -ignorewarnings: a class that is only missing at build time (hidden Android API,
#                      optional library) must not stop the build; it was equally missing in debug.
# Library modules add their own rules through consumer-rules (Bcore, winlator, youtube, j2me, ppsspp, mame).
# =====================================================================================
-dontobfuscate
-dontoptimize
-ignorewarnings
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod,Exceptions,RuntimeVisibleAnnotations,RuntimeInvisibleAnnotations,Deprecated,SourceFile,LineNumberTable

# ---- Own code: :app, :camera, :gallery, :video, :youtube, :chooser (package com.srizwan) ----
# Intents name some screens by class string (e.g. the Camera opens GalleryViewerActivity / VideoPlayerActivity).
-keep class com.srizwan.** { *; }

# ---- Engines that reach classes from native code (JNI) or by reflection ----
-keep class top.niunaijun.** { *; }
# BlackReflection classes (black.android.*, black.com.*, black.java.* ...) are looked up by name at run time
-keep class black.** { *; }
-keep class mirror.** { *; }
-keep class ru.playsoftware.** { *; }
-keep class ru.woesss.** { *; }
-keep class javax.microedition.** { *; }
-keep class org.microemu.** { *; }
# J2ME API classes are used by the .jar games that are loaded from outside the app, so the shrinker cannot see
# any use of them: keep every package of them whole.
-keep class com.j_phone.** { *; }
-keep class com.jblend.** { *; }
-keep class com.kddi.** { *; }
-keep class com.mascotcapsule.** { *; }
-keep class com.mexa.** { *; }
-keep class com.mot.** { *; }
-keep class com.motorola.** { *; }
-keep class com.nokia.** { *; }
-keep class com.samsung.** { *; }
-keep class com.siemens.** { *; }
-keep class com.sonyericsson.** { *; }
-keep class com.sprintpcs.** { *; }
-keep class com.sun.** { *; }
-keep class com.vodafone.** { *; }
-keep class mmpp.** { *; }
-keep class javax.** { *; }
-keep class com.android.dx.** { *; }
-keep class org.objectweb.asm.** { *; }
-keep class me.weishu.reflection.** { *; }
-keep class com.moandjiezana.toml.** { *; }

# ---- Native methods: class and method names are fixed by the .so files ----
-keepclasseswithmembernames,includedescriptorclasses class * { native <methods>; }
-keepclassmembers class * { native <methods>; }

# ---- Built-in Browser: methods the web page calls (AndroidBlobDl, DlEngine, ...) ----
-keepclassmembers class * { @android.webkit.JavascriptInterface <methods>; }

# ---- Common reflection users ----
-keepclassmembers enum * { public static **[] values(); public static ** valueOf(java.lang.String); }
-keepclassmembers class * implements android.os.Parcelable { public static final ** CREATOR; }
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep class kotlin.Metadata { *; }
-keepclassmembers class **$WhenMappings { <fields>; }

# ---- :youtube (NewPipeExtractor, Rhino, OkHttp, jsoup, nanojson) ----
-keep class org.schabi.newpipe.extractor.** { *; }
-keep class org.mozilla.javascript.** { *; }
-keep class org.jsoup.** { *; }
-keep class com.grack.nanojson.** { *; }
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**
-dontwarn okhttp3.internal.platform.**

# ---- Winlator libraries (its own classes are kept by winlator/consumer-rules.pro) (zstd-jni has native code, commons-compress looks codecs up by class name) ----
-keep class com.github.luben.zstd.** { *; }
-keep class org.tukaani.xz.** { *; }
-keep class org.apache.commons.compress.** { *; }

# ---- :j2me (Room, ffmpeg-kit JNI, Gson, RxJava) ----
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }
-keep class com.arthenica.** { *; }
-keep class com.antonkarpenko.** { *; }
-dontwarn io.reactivex.**

# ---- :mame (MAME4droid) ----
# libmame4droid-jni.so and libMAME4droid.so call Java by name (JNI); the settings screen (res/xml/mm_userpreferences.xml) and the manifest name its classes as strings.
# The same rule is in mame/consumer-rules.pro; repeated here so it holds even if the consumer file is ever dropped.
-keep class com.seleuco.mame4droid.** { *; }
