# Step 8 (RetroArch, part 5 of 12) — native build (written and checked statically, NOT compiled yet)

Changed files
- retroarch/build.gradle.kts — `externalNativeBuild { ndkBuild }` on upstream/pkg/android/phoenix-common/jni/Android.mk (module `retroarch-activity` -> lib/arm64-v8a/libretroarch-activity.so); arguments APP_PLATFORM=android-26, APP_STL=c++_static, -j<cpus>; properties retroarchNative / retroarchAbis / retroarchCcache / retroarchGles / retroarchCFlags / retroarchCppFlags; fetchRetroarchUpstream now also runs before `preBuild`
- gradle.properties — commented list of the retroarch* switches
- settings.gradle.kts — comment updated (steps 3-5)
- retroarch/README.md — plan table (step 5), "Step 5" section (what the build does, property table, checks, risks)
- README.md — RetroArch section (steps 1 to 5, next step 6)
- docs/CHANGES-step8-retroarch-step5.md — this file
(retroarch/upstream/ was cloned here only to inspect and test; it is NOT in the zip.)

Checked here
- Android.mk evaluated with GNU make + stubbed NDK variables (arm64-v8a): module name, the 3 source files exist, -DANDROID_AARCH64, no -marm, GLESv2 libs / HAVE_OPENGLES2 (GLES=3 switches to GLESv3 / HAVE_OPENGLES3), HAVE_VULKAN on
- API 26 vs upstream's low API: only `ifaddrs` depends on it; with WANT_IFADDRS nothing includes the system <ifaddrs.h> -> no struct clash in the single translation unit
- no native library name clash with the other modules; c++_static adds no libc++_shared.so
- brackets balance in the Gradle file; DSL follows :ppsspp / :mame

NOT verified: an actual ndk-build (no NDK here). Main risk: the tag was written for NDK r22, the project has NDK 29 (newer clang is stricter about old C). Levers without a code change: -PretroarchCFlags="-Wno-error=implicit-function-declaration -Wno-error=int-conversion -Wno-error=incompatible-function-pointer-types"; escape hatch -PretroarchNative=false (gradle.properties) = module empty again.

Effect on CI: the first run now clones RetroArch (about 330 MB) and compiles it (no cache / ccache yet, those come in step 10); the APK gains lib/arm64-v8a/libretroarch-activity.so. Workflows are unchanged. Effect in the app: none yet (no Java, manifest, launcher, hooks).

Next: step 6 — Java sources, resources, real library manifest (ra_ prefix, manifest merge check).
