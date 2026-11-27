#!/usr/bin/env python3
"""
Puts the Clone App's native libraries into cloneapp.aar as  jni/<abi>/*.so  (step 2 of the plan in cloneapp/README.md).

The files received had no  lib/  folder, so the AAR has none yet.  Without  libchaos.so  (and libpine.so, the ad SDK libraries ...) the engine cannot
start: App.kt / CloneAppEngine.kt notice that, leave the engine off, and the Settings entry says so instead of crashing.

Usage:
    python3 cloneapp/tools/add-jni.py cloneapp/cloneapp.aar <folder-with-abi-folders>
where <folder-with-abi-folders> is the  lib/  folder of the original Clone App APK (it contains arm64-v8a/, armeabi-v7a/ ...), e.g.
    unzip CloneApp.apk 'lib/*' -d apk && python3 cloneapp/tools/add-jni.py cloneapp/cloneapp.aar apk/lib
Only arm64-v8a, armeabi-v7a, x86, x86_64 folders are used; libraries listed in SKIP (provided by Gradle dependencies) are left out.  Existing jni/ entries of the same name are replaced (idempotent).
Python 3 only, no dependencies.
"""
import os
import sys
import zipfile

ABIS = ("arm64-v8a", "armeabi-v7a", "x86", "x86_64")

# Libraries the app already gets from Gradle dependencies (same reason as the classes taken out of the AAR, see STRIPPED-CLASSES.txt): a second copy would stop the build
# ("2 files found with path 'lib/arm64-v8a/libX.so'") or load two versions.  Not copied into the AAR:
#   ffmpeg-kit (io.github.nikita36078:ffmpeg-kit, used by :j2me; the com.arthenica classes of the Clone App were taken out in favour of it) -> libffmpegkit*, libav*, libsw*
#   MMKV (:seal) -> libmmkv.so      C++ runtime (pickFirst in app/build.gradle.kts) -> libc++_shared.so      CameraX (camera-core) -> libimage_processing_util_jni.so, libsurface_util_jni.so
SKIP = {
    "libffmpegkit.so", "libffmpegkit_abidetect.so", "libavcodec.so", "libavdevice.so", "libavfilter.so", "libavformat.so", "libavutil.so",
    "libswresample.so", "libswscale.so", "libmmkv.so", "libc++_shared.so", "libimage_processing_util_jni.so", "libsurface_util_jni.so",
}


def main():
    if len(sys.argv) != 3:
        sys.exit(__doc__)
    aar, libdir = sys.argv[1], sys.argv[2]
    add = {}
    for abi in ABIS:
        d = os.path.join(libdir, abi)
        if os.path.isdir(d):
            for f in sorted(os.listdir(d)):
                if f.endswith(".so") and f not in SKIP:
                    add["jni/%s/%s" % (abi, f)] = os.path.join(d, f)
    if not add:
        sys.exit("no <abi>/*.so found under " + libdir)
    if not any(k.endswith("/libchaos.so") for k in add):
        print("WARNING: libchaos.so not found: the engine will not start without it")
    src = zipfile.ZipFile(aar)
    tmp = aar + ".tmp"
    with zipfile.ZipFile(tmp, "w", zipfile.ZIP_DEFLATED) as dst:
        for info in src.infolist():
            if info.filename not in add:
                dst.writestr(info, src.read(info.filename))
        for name, f in sorted(add.items()):
            dst.write(f, name)
    os.replace(tmp, aar)
    print("added %d libraries:" % len(add))
    for name in sorted(add):
        print("  " + name)


if __name__ == "__main__":
    main()
