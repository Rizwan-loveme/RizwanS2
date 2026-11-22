#!/usr/bin/env bash
# Fetches the PPSSPP C++ core (pinned in ../UPSTREAM_VERSION) into ppsspp/upstream/.
# Not stored in the project zip (several hundred MB incl. FFmpeg); CI and local builds run this before Gradle.
set -euo pipefail
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TAG="$(tr -d '[:space:]' < "$HERE/UPSTREAM_VERSION")"
DEST="$HERE/upstream"
if [ -f "$DEST/CMakeLists.txt" ] && [ "$(git -C "$DEST" describe --tags 2>/dev/null)" = "$TAG" ]; then
  echo "PPSSPP $TAG already present in $DEST"; exit 0
fi
rm -rf "$DEST"
git clone --depth 1 --branch "$TAG" --recurse-submodules --shallow-submodules -j8 \
  https://github.com/hrydgard/ppsspp.git "$DEST"
# only the (large, test-only) autotests are dropped; CMakeLists.txt references the other platform dirs
rm -rf "$DEST/pspautotests"
echo "PPSSPP $TAG ready in $DEST"
