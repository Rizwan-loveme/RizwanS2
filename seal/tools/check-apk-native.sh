#!/usr/bin/env bash
# Seal part 7: looks into a built APK and reports what the yt-dlp engine (:seal) needs at run time.
# Usage: seal/tools/check-apk-native.sh app-release.apk [expected-abi, default arm64-v8a]
# Exit 1 only for things that make the Downloader unable to start (no Python / MMKV library for the ABI). Everything else is printed as a note.
# Not run in this environment (no APK here); part 8 wires it into the workflows.
set -u
APK="${1:?usage: $0 file.apk [abi]}"
ABI="${2:-arm64-v8a}"
LIST="$(mktemp)"; trap 'rm -f "$LIST"' EXIT
unzip -lv "$APK" | awk 'NF>=8 && $8 !~ /\/$/ {print $2, $1, $8}' > "$LIST"   # method (Stored / Defl:N), size, name; directories left out
fail=0
echo "== APK: $(stat -c %s "$APK" 2>/dev/null || wc -c < "$APK") bytes"
echo "== ABIs present under lib/:"
awk '$3 ~ /^lib\/[^\/]+\// {split($3,a,"/"); n[a[2]]++} END {for (k in n) printf "   %-14s %d files\n", k, n[k]}' "$LIST" | sort
echo "== Seal engine libraries for $ABI (size in bytes, method):"
for pat in 'libpython' 'libffmpeg' 'libaria2c' 'libmmkv'; do
  hits="$(awk -v abi="$ABI" -v p="$pat" '$3 ~ ("^lib/" abi "/" p) {printf "   %s  %s  %s\n", $2, $1, $3}' "$LIST")"
  if [ -z "$hits" ]; then
    case "$pat" in
      libpython|libmmkv) echo "::error::no lib/$ABI/$pat* in the APK (the Downloader cannot start without it)"; fail=1 ;;
      *) echo "   note: no lib/$ABI/$pat* (file names differ between youtubedl-android versions; check by hand)" ;;
    esac
  else
    echo "$hits"
  fi
done
echo "== libc++_shared.so (pickFirst picks ONE copy for the whole app):"
awk '$3 ~ /libc\+\+_shared\.so$/ {printf "   %s  %s\n", $2, $3}' "$LIST"
echo "== biggest native files:"
awk '$3 ~ /^lib\// {print $2, $3}' "$LIST" | sort -rn | head -8 | sed 's/^/   /'
echo "== extractNativeLibs / stored libs (Stored = mapped from the APK, not extracted):"
awk '$3 ~ /^lib\// && $1=="Stored" {s++} $3 ~ /^lib\// && $1!="Stored" {d++} END {printf "   stored: %d, deflated: %d\n", s, d}' "$LIST"
echo "   (with useLegacyPackaging = true the libs are deflated and extracted at install; a high 'stored' count would mean extractNativeLibs is off)"
exit $fail
