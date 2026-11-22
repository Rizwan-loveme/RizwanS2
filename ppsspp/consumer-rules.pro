# libppsspp_jni.so calls into these classes by name (JNI), keep them if :app ever turns on minify
-keep class org.ppsspp.ppsspp.** { *; }
-keepclassmembers class org.ppsspp.proto.** { *; }
