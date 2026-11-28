# Fix: release build #10, `:app:packageRelease` OutOfMemoryError

## What failed
`./gradlew assembleRelease` ran for 6m 29s, compiled everything and then stopped in the last task:

```
Execution failed for task ':app:packageRelease'.
Caused by: java.lang.OutOfMemoryError: Java heap space
    at com.android.zipflinger.Compressor.deflate(Compressor.java:35)
    at com.android.builder.internal.packaging.ApkFlinger.close(ApkFlinger.kt:246)
```

Nothing else failed. The many `Info: Class org.acra... has malformed kotlin.Metadata (2.4.0, max 2.3.0)` lines are R8 info
messages about the ACRA library, not errors, and the `C/C++ ... warning:` lines are normal compiler warnings from j2me's m3g code.

## Cause
`org.gradle.jvmargs` was `-Xmx4g`. The release APK is very large (MAME, PPSSPP, Mika rootfs, Python + FFmpeg for 4 ABIs) and
`:app` uses `useLegacyPackaging = true`, so every native library is deflated in memory while the APK is written. The packaging
worker runs inside the Gradle daemon, so the 4 GB daemon heap ran out.

## Changes
- `gradle.properties`: `org.gradle.jvmargs` `-Xmx4g` -> `-Xmx8g -XX:MaxMetaspaceSize=1g`; new `kotlin.daemon.jvmargs=-Xmx3g -XX:MaxMetaspaceSize=1g`.
- `.github/workflows/UltimateBuild.yml`, `UltimateBuild_NoWinlator.yml`, `UltimateBuild_WithoutMe.yml`: new step
  "Add swap space (packaging needs a big heap)" (6 GB swap file) right before "Build Unsigned Release APK".

Everything else is unchanged. Not built here (no Android SDK / network in this environment); the next CI run decides.
If it still runs out of memory, set the `apk_abis` input to `arm64-v8a,armeabi-v7a` (drops the x86 copies, the biggest size saving).
