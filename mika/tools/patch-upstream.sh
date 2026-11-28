#!/usr/bin/env bash
# Turns the Mika checkout fetched by tools/fetch-upstream.sh (mika/upstream/) into the library :mika, shown in Win11 as "Rizwan" (part 4).
# The work is done by tools/patch-upstream.py (library manifest, MikaApp open, mk_ resource names, Rizwan name + "Hey Rizwan" greeting, icon); see its header.
# Idempotent: a second run changes nothing (a marker file mika/upstream/.rizwan-patched holds the hash of the script + icon; MIKA_FORCE_PATCH=1 runs it anyway).
# Needs bash + python3 (Linux / macOS / CI). Run it alone with:  ./gradlew :mika:patchMikaUpstream   or   bash mika/tools/patch-upstream.sh
# Environment: MIKA_UPSTREAM_DIR overrides the checkout folder (tests).
set -euo pipefail
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
if ! command -v python3 >/dev/null 2>&1; then
  echo "::error::patch-upstream: python3 is needed (ubuntu runners have it)" >&2
  exit 1
fi
exec python3 "$HERE/patch-upstream.py" "$@"
