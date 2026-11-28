#!/usr/bin/env bash
# Turns the Shizuku checkout fetched by tools/fetch-upstream.sh (shizuku/upstream/) into code that runs inside the Win11 app (step 2).
# The work is done by tools/patch-upstream.py (host package, library conversion, sh_ resource names, self-check); see its header.
# Idempotent: the marker shizuku/upstream/.win11-patched holds the hash of the script + the host package (read from app/build.gradle.kts, so the CI package rename is followed);
# SHIZUKU_FORCE_PATCH=1 patches again from the pristine checkout. Needs bash + python3 + git. Run it with:  bash shizuku/tools/patch-upstream.sh   (check only: ... --check)
# Environment: SHIZUKU_UPSTREAM_DIR overrides the checkout folder (tests), SHIZUKU_HOST_PACKAGE overrides the host package.
set -euo pipefail
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
if ! command -v python3 >/dev/null 2>&1; then
  echo "::error::patch-upstream: python3 is needed (ubuntu runners have it)" >&2
  exit 1
fi
exec python3 "$HERE/patch-upstream.py" "$@"
