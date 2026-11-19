# Winlator reaches many classes from native code (JNI) and by reflection.
-keep class com.winlator.** { *; }
-keepclasseswithmembernames class * { native <methods>; }
