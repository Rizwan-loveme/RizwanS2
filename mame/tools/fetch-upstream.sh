#!/usr/bin/env bash
# Fetches the pinned MAME4droid core into mame/core/ (plan A, see ../README.md step 2):
#   core/jniLibs/arm64-v8a/libMAME4droid.so  <- lib/arm64-v8a/libMAME4droid.so inside the official release APK (366,992,944 bytes)
#   core/res/raw/mm_files.zip                <- upstream's res/raw/files.zip at the pinned tag (64 MB)
# Every download is checked against ../UPSTREAM_SHA256; a wrong hash stops the build. Not stored in the project zip (git-ignored core/).
set -euo pipefail
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
PIN="$HERE/UPSTREAM_SHA256"
CORE="$HERE/core"
val() { awk -v k="$1" '$1==k {print $2; exit}' "$PIN"; }
sha() { sha256sum "$1" | awk '{print $1}'; }

APK_URL="$(val apk_url)";     APK_SHA="$(val apk_sha256)"
SO_SHA="$(val so_core_sha256)"; SO_PATH="$(val so_core_path)"
FZ_URL="$(val files_zip_url)"; FZ_SHA="$(val files_zip_sha256)"
SO_OUT="$CORE/jniLibs/arm64-v8a/libMAME4droid.so"
FZ_OUT="$CORE/res/raw/mm_files.zip"
for v in APK_URL APK_SHA SO_SHA SO_PATH FZ_URL FZ_SHA; do [ -n "${!v}" ] || { echo "UPSTREAM_SHA256: missing value for $v" >&2; exit 1; }; done

download() { # url dest sha
  local tmp="$2.part"; mkdir -p "$(dirname "$2")"
  curl -fL --retry 5 --retry-delay 5 --connect-timeout 30 -o "$tmp" "$1"
  if [ "$(sha "$tmp")" != "$3" ]; then echo "SHA-256 mismatch for $1 (expected $3, got $(sha "$tmp"))" >&2; rm -f "$tmp"; exit 1; fi
  mv "$tmp" "$2"
}

# 0. the version constant in the code must equal the pinned version (it is sent to the core and the NetPlay lobby, and names the files.zip marker)
PIN_VER="$(tr -d 'v\r\n ' < "$HERE/UPSTREAM_VERSION")"
CODE_VER="$(sed -n 's/.*UPSTREAM_VERSION = "\([^"]*\)".*/\1/p' "$HERE/src/main/java/com/seleuco/mame4droid/MameLaunch.java" | head -1)"
if [ "$PIN_VER" != "$CODE_VER" ]; then
  echo "MameLaunch.UPSTREAM_VERSION ($CODE_VER) must equal mame/UPSTREAM_VERSION ($PIN_VER)" >&2; exit 1
fi

# 1. core .so
if [ -f "$SO_OUT" ] && [ "$(sha "$SO_OUT")" = "$SO_SHA" ]; then
  echo "libMAME4droid.so already present and verified"
else
  APK="$CORE/m4d-release.apk"
  if [ ! -f "$APK" ] || [ "$(sha "$APK")" != "$APK_SHA" ]; then
    echo "Downloading $APK_URL"; download "$APK_URL" "$APK" "$APK_SHA"
  fi
  mkdir -p "$(dirname "$SO_OUT")"
  unzip -o -j -q "$APK" "$SO_PATH" -d "$(dirname "$SO_OUT")"
  if [ "$(sha "$SO_OUT")" != "$SO_SHA" ]; then echo "SHA-256 mismatch for extracted libMAME4droid.so" >&2; rm -f "$SO_OUT"; exit 1; fi
  rm -f "$APK"   # 169 MB, only needed to get the .so
  echo "libMAME4droid.so ready ($(stat -c %s "$SO_OUT" 2>/dev/null || wc -c < "$SO_OUT") bytes)"
fi

# 2. files.zip
if [ -f "$FZ_OUT" ] && [ "$(sha "$FZ_OUT")" = "$FZ_SHA" ]; then
  echo "mm_files.zip already present and verified"
else
  echo "Downloading $FZ_URL"; download "$FZ_URL" "$FZ_OUT" "$FZ_SHA"
  echo "mm_files.zip ready"
fi
