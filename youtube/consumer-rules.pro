## Rules for NewPipeExtractor
-keep class org.schabi.newpipe.extractor.timeago.patterns.** { *; }
-keep class org.mozilla.javascript.** { *; }
-keep class org.mozilla.classfile.ClassFileWriter
-dontwarn org.mozilla.javascript.tools.**

# --- added for the release build ---
-keep class org.schabi.newpipe.extractor.** { *; }
-keep class org.jsoup.** { *; }
-keep class com.grack.nanojson.** { *; }
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**
-dontwarn okhttp3.internal.platform.**
-dontwarn javax.script.**
-dontwarn java.beans.**
