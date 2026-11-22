# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\tools\adt-bundle-windows-x86_64-20131030\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keep class javax.** { *; }
-keep class com.kddi.** { *; }
-keep class com.siemens.mp.** { *; }
-keep class com.samsung.util.** { *; }
-keep class com.sonyericsson.accelerometer.** { *; }
-keep class com.sprintpcs.media.** { *; }
-keep class com.mascotcapsule.micro3d.v3.** { *; }
-keep class com.mexa.** { *; }
-keep class com.mot.** { *; }
-keep class com.j_phone.** { *; }
-keep class com.jblend.** { *; }
-keep class com.motorola.** { *; }
-keep class com.nokia.mid.** { *; }
-keep class com.sun.midp.midlet.** { *; }
-keep class com.vodafone.** { *; }
-keep class mmpp.media.** { *; }
-keep class org.microemu.** { *; }
-keep class ru.playsoftware.j2meloader.util.SparseIntArrayAdapter { *; }
# Keep the BuildConfig
-keep class ru.playsoftware.j2meloader.BuildConfig { *; }

-keep class androidx.appcompat.widget.SearchView { *; }
-keep class com.arthenica.mobileffmpeg.** { *; }
-keep class org.acra.attachment.DefaultAttachmentProvider { *; }
-keep class ru.playsoftware.j2meloader.crashes.models.* { *; }

# --- added for the release build ---
-keep class ru.woesss.** { *; }
-keep class ru.playsoftware.** { *; }
-keep class com.arthenica.** { *; }
-keep class com.antonkarpenko.** { *; }
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }
-dontwarn io.reactivex.**
-dontwarn com.google.errorprone.annotations.**
-dontwarn org.checkerframework.**
-dontwarn com.google.j2objc.annotations.**

# whole J2ME API packages (used by games loaded from outside the app)
-keep class com.j_phone.** { *; }
-keep class com.jblend.** { *; }
-keep class com.kddi.** { *; }
-keep class com.mascotcapsule.** { *; }
-keep class com.nokia.** { *; }
-keep class com.samsung.** { *; }
-keep class com.siemens.** { *; }
-keep class com.sonyericsson.** { *; }
-keep class com.sprintpcs.** { *; }
-keep class com.sun.** { *; }
-keep class mmpp.** { *; }
-keep class javax.bluetooth.** { *; }
-keep class javax.microedition.** { *; }
-keep class javax.obex.** { *; }
-keep class javax.wireless.** { *; }
