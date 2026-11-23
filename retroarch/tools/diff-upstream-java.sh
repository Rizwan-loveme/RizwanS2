#!/usr/bin/env bash
# Compares the Java files copied into retroarch/src/main/java (step 6) with the same files of the upstream clone in retroarch/upstream/.
# Use it after every change of UPSTREAM_VERSION / UPSTREAM_COMMIT: files marked "same" need nothing, files with a diff must be re-merged by hand
# (the known Win11 changes are listed in retroarch/README.md, "Step 6"). Also lists upstream Java files that are NOT copied, so a new class is noticed.
# Usage:  bash retroarch/tools/diff-upstream-java.sh [path-to-upstream-clone]     (default: retroarch/upstream; run ./gradlew :retroarch:fetchRetroarchUpstream first)
# Exit code: 0 = only the expected Win11 changes, 1 = a copied file differs more than expected or a new upstream file exists.
set -u
HERE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
UP="${1:-$HERE/upstream}"
J="$HERE/src/main/java"
A="$UP/pkg/android"
[ -d "$A/phoenix" ] || { echo "no upstream clone at $UP (run: ./gradlew :retroarch:fetchRetroarchUpstream)"; exit 2; }

# <path under src/main/java>|<upstream file>|<expected: same or changed>
MAP="
com/retroarch/browser/mainmenu/MainMenuActivity.java|$A/phoenix/src/com/retroarch/browser/mainmenu/MainMenuActivity.java|changed
com/retroarch/browser/retroactivity/RetroActivityFuture.java|$A/phoenix/src/com/retroarch/browser/retroactivity/RetroActivityFuture.java|same
com/retroarch/browser/retroactivity/RetroActivityCamera.java|$A/phoenix-common/src/com/retroarch/browser/retroactivity/RetroActivityCamera.java|same
com/retroarch/browser/retroactivity/RetroActivityCommon.java|$A/phoenix-common/src/com/retroarch/browser/retroactivity/RetroActivityCommon.java|same
com/retroarch/browser/retroactivity/RetroActivityIntent.java|$A/phoenix-common/src/com/retroarch/browser/retroactivity/RetroActivityIntent.java|same
com/retroarch/browser/preferences/util/ConfigFile.java|$A/phoenix-common/src/com/retroarch/browser/preferences/util/ConfigFile.java|same
com/retroarch/browser/preferences/util/UserPreferences.java|$A/phoenix-common/src/com/retroarch/browser/preferences/util/UserPreferences.java|changed
com/retroarch/browser/provider/RetroDocumentsProvider.java|$A/phoenix/src/com/retroarch/browser/provider/RetroDocumentsProvider.java|changed
com/retroarch/playcore/PlayCoreManager.java|$A/play-core-stub/com/retroarch/playcore/PlayCoreManager.java|same
com/libretro/common/vfs/VfsImplementationSaf.java|$UP/libretro-common/vfs/saf/src/com/libretro/common/vfs/VfsImplementationSaf.java|same
"
# upstream Java files we deliberately do not use: debug-only CoreSideloadActivity, RetroArchApplication (Application class of the upstream app)
SKIP="CoreSideloadActivity.java RetroArchApplication.java"

rc=0
for line in $MAP; do
  rel="${line%%|*}"; rest="${line#*|}"; up="${rest%%|*}"; want="${rest##*|}"
  if [ ! -f "$up" ]; then echo "MISSING upstream: $up"; rc=1; continue; fi
  if cmp -s "$J/$rel" "$up"; then state=same; else state=changed; fi
  if [ "$state" = "$want" ]; then echo "ok      ($state)  $rel"; else echo "UNEXPECTED ($state, expected $want)  $rel"; rc=1; fi
done

# upstream Java files that are neither copied nor deliberately skipped
for f in $(find "$A/phoenix/src" "$A/phoenix-common/src" "$A/play-core-stub" "$UP/libretro-common/vfs/saf/src" -name '*.java' | sort); do
  base="$(basename "$f")"
  [ -f "$(find "$J" -name "$base" | head -1)" ] && continue
  case " $SKIP " in *" $base "*) echo "skipped (on purpose)  $base"; continue;; esac
  echo "NEW upstream Java file, not copied: $f"; rc=1
done
[ $rc -eq 0 ] && echo "result: only the expected Win11 changes" || echo "result: CHECK the lines above"
exit $rc
