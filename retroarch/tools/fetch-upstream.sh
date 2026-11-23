#!/usr/bin/env bash
# Fetches RetroArch (the tag in ../UPSTREAM_VERSION) into retroarch/upstream/ and checks that the clone is exactly the
# commit in ../UPSTREAM_COMMIT. Not stored in the project zip (about 11,000 files); CI and local builds run this before the
# native build. Needs bash + git (Linux / macOS / CI).
#
# Differences from ppsspp/tools/fetch-upstream.sh:
#   * no --recurse-submodules: the RetroArch tag has no .gitmodules (deps/ is inside the repo)
#   * the clone KEEPS its .git: Android.mk asks `git rev-parse` for the version string
#   * the clone is verified against UPSTREAM_COMMIT (a moved or re-created tag must not change the build silently)
#   * nothing is deleted from the clone: Android.mk reaches the whole repo through RARCH_DIR := ../../../..
#
# Offline / hand-placed source: if retroarch/upstream/ already holds the Android project but has no .git, it is used as it is
# (with a warning: the commit cannot be checked). With a .git it must match UPSTREAM_COMMIT, otherwise it is fetched again.
set -euo pipefail

HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
DEST="$HERE/upstream"
REPO_URL="${RETROARCH_REPO_URL:-https://github.com/libretro/RetroArch.git}"

TAG="$(tr -d '[:space:]' < "$HERE/UPSTREAM_VERSION")"
# UPSTREAM_COMMIT: '#' comment lines + one line with the commit
COMMIT="$(grep -v '^[[:space:]]*#' "$HERE/UPSTREAM_COMMIT" | tr -d '[:space:]')"

if ! [[ "$TAG" =~ ^v[0-9][0-9A-Za-z._-]*$ ]]; then
  echo "::error::retroarch/UPSTREAM_VERSION is not a tag name: '$TAG'" >&2; exit 1
fi
if ! [[ "$COMMIT" =~ ^[0-9a-f]{40}$ ]]; then
  echo "::error::retroarch/UPSTREAM_COMMIT must hold exactly one 40-character commit hash (got '$COMMIT')" >&2; exit 1
fi

# What the :retroarch module needs from the clone (steps 5 and 6). A different layout means a version bump needs a review.
REQUIRED=(
  pkg/android/phoenix-common/jni/Android.mk
  pkg/android/phoenix-common/jni/Application.mk
  pkg/android/phoenix/AndroidManifest.xml
  pkg/android/phoenix/src
  pkg/android/phoenix-common/src
  pkg/android/phoenix-common/res
  pkg/android/play-core-stub
  libretro-common/vfs/saf/src
  griffin/griffin.c
)
check_layout() {
  local missing=0 p
  for p in "${REQUIRED[@]}"; do
    if [ ! -e "$DEST/$p" ]; then echo "::error::RetroArch $TAG: '$p' is missing in $DEST" >&2; missing=1; fi
  done
  return $missing
}

# 1) already there
if [ -d "$DEST/.git" ]; then
  HAVE="$(git -C "$DEST" rev-parse HEAD 2>/dev/null || true)"
  if [ "$HAVE" = "$COMMIT" ] && check_layout 2>/dev/null; then
    echo "RetroArch $TAG ($COMMIT) already present in $DEST"; exit 0
  fi
  echo "RetroArch in $DEST is not $TAG / $COMMIT (found '${HAVE:-unknown}'): fetching again"
elif [ -f "$DEST/pkg/android/phoenix-common/jni/Android.mk" ]; then
  echo "::warning::$DEST has no .git: using it as it is, the commit cannot be checked against UPSTREAM_COMMIT" >&2
  check_layout; echo "RetroArch (hand-placed) found in $DEST"; exit 0
fi

# 2) shallow clone of the tag, 3 tries (GitHub / network hiccups)
export GIT_TERMINAL_PROMPT=0
ok=0
for attempt in 1 2 3; do
  rm -rf "$DEST"
  if git -c advice.detachedHead=false clone --depth 1 --branch "$TAG" "$REPO_URL" "$DEST"; then ok=1; break; fi
  echo "git clone failed (try $attempt of 3)" >&2
  sleep $((attempt * 5))
done
if [ "$ok" -ne 1 ]; then
  rm -rf "$DEST"; echo "::error::could not clone $REPO_URL at $TAG" >&2; exit 1
fi

# 3) it must be exactly the pinned commit
GOT="$(git -C "$DEST" rev-parse HEAD)"
if [ "$GOT" != "$COMMIT" ]; then
  rm -rf "$DEST"
  echo "::error::RetroArch tag $TAG now points to $GOT, but retroarch/UPSTREAM_COMMIT pins $COMMIT. Build stopped." >&2
  echo "If the move is intended, review the new version (README.md 'Step 2') and change both files together." >&2
  exit 1
fi

# 4) layout
if ! check_layout; then rm -rf "$DEST"; exit 1; fi
echo "RetroArch $TAG ($COMMIT) ready in $DEST"
