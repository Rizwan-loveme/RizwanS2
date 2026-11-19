#!/system/bin/sh
# Step 4.15.2 test data: creates /sdcard/BigTest/{5000,10000,20000} with mixed files.
# Run:  adb shell sh /sdcard/make_big_folders.sh   (push it first: adb push make_big_folders.sh /sdcard/)
# Then open Files > BigTest in the app and read the timing lines in the app's Debug Log
# ("FolderLoader: N files: list .. stat .. sort .." and "ExplorerUi: N files: tap -> list handed ..").
# Remove afterwards:  adb shell rm -r /sdcard/BigTest
for N in 5000 10000 20000; do
  D=/sdcard/BigTest/$N
  mkdir -p "$D"
  i=0
  while [ $i -lt $N ]; do
    case $((i % 5)) in
      0) : > "$D/photo_$i.jpg" ;;
      1) : > "$D/clip_$i.mp4" ;;
      2) : > "$D/doc_$i.pdf" ;;
      3) : > "$D/song_$i.mp3" ;;
      4) mkdir -p "$D/dir_$i" ;;
    esac
    i=$((i + 1))
  done
done
echo done
