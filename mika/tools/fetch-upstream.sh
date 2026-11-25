#!/usr/bin/env bash
# Fetches Mika (the commit in ../UPSTREAM_COMMIT, version in ../UPSTREAM_VERSION) into mika/upstream/ and checks that the checkout is exactly that commit.
# Not stored in the project zip (the whole repo is about 133 MB, the part the build needs about 83 MB); CI and local builds run this before the build.
# Needs bash + git (Linux / macOS / CI). Run it alone with:  ./gradlew :mika:fetchMikaUpstream   or   bash mika/tools/fetch-upstream.sh
#
# Differences from retroarch/tools/fetch-upstream.sh:
#   * Mika has no release tag that is pinned here, only a commit: the commit is fetched directly (git fetch --depth 1 origin <sha>, GitHub allows it)
#   * only what the build needs is checked out (sparse checkout, no blobs of docs/ eval/ companions/ plugins/ tools/ downloaded when the server supports
#     partial clones): core/src/main, app/src/main, gradle/libs.versions.toml, the 3 small build files (version check), licenses/, LICENSE, NOTICE, tools/sandbox/ (the PRoot patches + source locks that step 11 puts into the APK assets, 152 KB)
#   * this script does NOT patch anything: tools/patch-upstream.sh (part 4) turns the checkout into a library; it is idempotent and runs after this script
#
# Offline / hand-placed source: unpack the upstream repo (the Mika-main.zip of GitHub's "Download ZIP", without the Mika-main/ wrapper folder) into mika/upstream/.
# Without a .git the commit cannot be checked; the script then compares versionName in app/build.gradle.kts with UPSTREAM_VERSION instead and refuses a different version.
# With a .git the HEAD commit must match UPSTREAM_COMMIT, otherwise the folder is fetched again.
#
# Environment: MIKA_REPO_URL overrides the repository URL (a mirror, or a local path for tests).
set -euo pipefail

HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DEST="$HERE/upstream"
REPO_URL="${MIKA_REPO_URL:-https://github.com/wangzan101/Mika.git}"

VERSION="$(grep -v '^[[:space:]]*#' "$HERE/UPSTREAM_VERSION" | tr -d '[:space:]')"
# UPSTREAM_COMMIT: '#' comment lines + one line with the commit
COMMIT="$(grep -v '^[[:space:]]*#' "$HERE/UPSTREAM_COMMIT" | tr -d '[:space:]')"

if ! [[ "$VERSION" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
  echo "::error::mika/UPSTREAM_VERSION is not a version number: '$VERSION'" >&2; exit 1
fi
if ! [[ "$COMMIT" =~ ^[0-9a-f]{40}$ ]]; then
  echo "::error::mika/UPSTREAM_COMMIT must hold exactly one 40-character commit hash (got '$COMMIT')" >&2; exit 1
fi

# What :mika-core / :mika need from the checkout (parts 2 and 4). A different layout means a version bump needs a review.
REQUIRED=(
  core/src/main/kotlin
  core/src/main/resources/knowledge
  core/src/main/resources/skills
  core/src/main/resources/prompts
  app/src/main/AndroidManifest.xml
  app/src/main/java/com/wangzan101/mika/MikaApp.kt
  app/src/main/res/values/strings.xml
  app/src/main/assets/runtime/rootfs.tar.xz
  app/src/main/aidl
  app/src/main/jniLibs/arm64-v8a/libmikarun.so
  app/src/main/jniLibs/arm64-v8a/libproot.so
  app/src/main/jniLibs/arm64-v8a/libproot_loader.so
  gradle/libs.versions.toml
  licenses/THIRD_PARTY_NOTICES.md
  licenses/GPL-2.0.txt
  licenses/GPL-3.0.txt
  licenses/LGPL-3.0.txt
  LICENSE
  NOTICE
  tools/sandbox/sources.lock
  tools/sandbox/patches
)
check_layout() {
  local missing=0 p
  for p in "${REQUIRED[@]}"; do
    if [ ! -e "$DEST/$p" ]; then echo "::error::Mika $VERSION: '$p' is missing in $DEST" >&2; missing=1; fi
  done
  return $missing
}

# versionName of upstream's app module (hand-placed folders have no .git to check)
check_version_text() {
  local f="$DEST/app/build.gradle.kts" got
  if [ ! -f "$f" ]; then echo "::warning::$f not found: version not checked" >&2; return 0; fi
  got="$(sed -n 's/^[[:space:]]*versionName[[:space:]]*=[[:space:]]*"\([^"]*\)".*/\1/p' "$f" | head -n 1)"
  if [ "$got" != "$VERSION" ]; then
    echo "::error::$DEST holds Mika '$got', but mika/UPSTREAM_VERSION pins '$VERSION'" >&2; return 1
  fi
}

# 1) already there
if [ -d "$DEST/.git" ]; then
  HAVE="$(git -C "$DEST" rev-parse HEAD 2>/dev/null || true)"
  if [ "$HAVE" = "$COMMIT" ] && check_layout 2>/dev/null; then
    echo "Mika $VERSION ($COMMIT) already present in $DEST"; exit 0
  fi
  echo "Mika in $DEST is not $VERSION / $COMMIT (found '${HAVE:-unknown}'): fetching again"
elif [ -f "$DEST/app/src/main/AndroidManifest.xml" ] && { [ -f "$DEST/core/build.gradle.kts" ] || [ -d "$DEST/core/src/main" ]; }; then
  echo "::warning::$DEST has no .git: using it as it is, the commit cannot be checked against UPSTREAM_COMMIT" >&2
  check_version_text; check_layout; echo "Mika $VERSION (hand-placed) found in $DEST"; exit 0
fi

# 2) fetch exactly the pinned commit, 3 tries (GitHub / network hiccups). Sparse + blob-less when the server allows it, a full fetch otherwise.
export GIT_TERMINAL_PROMPT=0
SPARSE=(
  /core/src/main/
  /app/src/main/
  /gradle/libs.versions.toml
  /build.gradle.kts
  /app/build.gradle.kts
  /core/build.gradle.kts
  /licenses/
  /LICENSE
  /NOTICE
  /tools/sandbox/
)
ok=0
for attempt in 1 2 3; do
  rm -rf "$DEST"
  mkdir -p "$DEST"
  if git -C "$DEST" init -q \
     && git -C "$DEST" remote add origin "$REPO_URL" \
     && git -C "$DEST" -c advice.detachedHead=false fetch -q --depth 1 --filter=blob:none origin "$COMMIT" \
     && git -C "$DEST" sparse-checkout init --no-cone \
     && git -C "$DEST" sparse-checkout set --no-cone "${SPARSE[@]}" \
     && git -C "$DEST" -c advice.detachedHead=false checkout -q FETCH_HEAD; then
    ok=1; break
  fi
  echo "git fetch failed (try $attempt of 3)" >&2
  sleep $((attempt * 5))
done
if [ "$ok" -ne 1 ]; then
  rm -rf "$DEST"; echo "::error::could not fetch commit $COMMIT from $REPO_URL" >&2; exit 1
fi

# 3) it must be exactly the pinned commit
GOT="$(git -C "$DEST" rev-parse HEAD)"
if [ "$GOT" != "$COMMIT" ]; then
  rm -rf "$DEST"
  echo "::error::Mika checkout is $GOT, but mika/UPSTREAM_COMMIT pins $COMMIT. Build stopped." >&2
  exit 1
fi
check_version_text || { rm -rf "$DEST"; exit 1; }

# 4) layout
if ! check_layout; then rm -rf "$DEST"; exit 1; fi
echo "Mika $VERSION ($COMMIT) ready in $DEST"
