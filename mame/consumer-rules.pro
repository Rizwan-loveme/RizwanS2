# JNI: the native code looks up these classes / methods by name
-keep class com.seleuco.mame4droid.** { *; }
-keepclasseswithmembernames class * { native <methods>; }
