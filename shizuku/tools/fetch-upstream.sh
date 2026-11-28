#!/usr/bin/env bash
# Fetches Shizuku (manager + server + starter + shell + common) at the tag pinned in ../UPSTREAM_VERSION / ../UPSTREAM_COMMIT into shizuku/upstream/,
# and its "api" git submodule (RikkaApps/Shizuku-API) at the commit pinned in ../UPSTREAM_API_COMMIT into shizuku/upstream/api/.
# Not stored in the project zip; CI and local builds run this before Gradle. Both commits are verified, so a moved tag fails the build instead of changing it silently.
# Upstream lists the submodule with an ssh URL (git@github.com:...), so it is fetched here by hand over https.
set -euo pipefail
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TAG="$(tr -d '[:space:]' < "$HERE/UPSTREAM_VERSION")"
COMMIT="$(tr -d '[:space:]' < "$HERE/UPSTREAM_COMMIT")"
API_COMMIT="$(tr -d '[:space:]' < "$HERE/UPSTREAM_API_COMMIT")"
DEST="$HERE/upstream"
REPO="https://github.com/RikkaApps/Shizuku.git"
API_REPO="https://github.com/RikkaApps/Shizuku-API.git"

if [ -f "$DEST/settings.gradle" ] \
   && [ "$(git -C "$DEST" rev-parse HEAD 2>/dev/null || true)" = "$COMMIT" ] \
   && [ "$(git -C "$DEST/api" rev-parse HEAD 2>/dev/null || true)" = "$API_COMMIT" ]; then
  echo "Shizuku $TAG ($COMMIT) + API ($API_COMMIT) already present in $DEST"; exit 0
fi

rm -rf "$DEST"
git -c advice.detachedHead=false clone --quiet --depth 1 --branch "$TAG" "$REPO" "$DEST"
GOT="$(git -C "$DEST" rev-parse HEAD)"
if [ "$GOT" != "$COMMIT" ]; then
  echo "ERROR: Shizuku $TAG is $GOT, expected $COMMIT (tag moved? update shizuku/UPSTREAM_COMMIT on purpose)" >&2; exit 1
fi

# the api submodule: an empty folder in the clone above, fill it with the pinned commit
rm -rf "$DEST/api"; mkdir -p "$DEST/api"
git -C "$DEST/api" init --quiet
git -C "$DEST/api" remote add origin "$API_REPO"
git -C "$DEST/api" fetch --quiet --depth 1 origin "$API_COMMIT"
git -C "$DEST/api" -c advice.detachedHead=false checkout --quiet FETCH_HEAD
GOT_API="$(git -C "$DEST/api" rev-parse HEAD)"
if [ "$GOT_API" != "$API_COMMIT" ]; then
  echo "ERROR: Shizuku-API is $GOT_API, expected $API_COMMIT" >&2; exit 1
fi

echo "Shizuku $TAG ($COMMIT) + API ($API_COMMIT) ready in $DEST"
