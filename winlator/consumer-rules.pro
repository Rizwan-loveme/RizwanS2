# Winlator reaches many classes from native code (JNI) and by reflection.
-keep class com.winlator.** { *; }
-keepclasseswithmembernames class * { native <methods>; }

# --- added for the release build ---
-keep class com.github.luben.zstd.** { *; }
-keep class org.tukaani.xz.** { *; }
-keep class org.apache.commons.compress.** { *; }
-dontwarn org.apache.commons.compress.**
-dontwarn org.brotli.**
-dontwarn org.objectweb.asm.**
