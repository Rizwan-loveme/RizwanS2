# libretroarch-activity.so (RetroArch's C frontend) calls into these Java classes by name (JNI) and NativeActivity loads
# RetroActivityFuture from the manifest; keep them if :app ever turns on minify.
-keep class com.retroarch.** { *; }
# Storage Access Framework VFS: called from libretro-common's C code (JNI)
-keep class com.libretro.common.vfs.** { *; }
