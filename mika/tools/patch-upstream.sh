#!/usr/bin/env bash
# Turns the Mika checkout fetched by tools/fetch-upstream.sh (mika/upstream/) into the library :mika, shown in Win11 as "Rizwan" (part 4).
# The work is done by tools/patch-upstream.py (library manifest, MikaApp open, mk_ resource names, Rizwan name + "Hey Rizwan" greeting, icon); see its header.
# Idempotent: a second run changes nothing (a marker file mika/upstream/.rizwan-patched holds the hash of the script + icon; MIKA_FORCE_PATCH=1 runs it anyway).
# Needs bash + python3 (Linux / macOS / CI). Run it alone with:  ./gradlew :mika:patchMikaUpstream   or   bash mika/tools/patch-upstream.sh
# Environment: MIKA_UPSTREAM_DIR overrides the checkout folder (tests). MIKA_SHIZUKU_BUILTIN=1 (set by Gradle when :shizuku is in the build; unset = 0) writes the host package
# into Mika's <queries> entry of the external Shizuku app (step 7A-1.1) and makes ShizukuController.kt ask for the host package / open the built-in manager instead of the
# external app (step 7A-2.1); the value is part of the stamp, so a checkout patched the other way is patched again.
set -euo pipefail
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
if ! command -v python3 >/dev/null 2>&1; then
  echo "::error::patch-upstream: python3 is needed (ubuntu runners have it)" >&2
  exit 1
fi
exec python3 "$HERE/patch-upstream.py" "$@"
