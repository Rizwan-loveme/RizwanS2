#!/bin/sh
# Step 4.15.4 test helper: rotation / split-screen / dark-light checks for the File Explorer.
# Run from the PC with the phone connected:  sh tools/rotation_config_test.sh
# Pre-condition: open Files > BigTest > 5000 (see make_big_folders.sh), scroll to the middle, pick Grid or Large.
# After each step look at the screen and at the app's Debug Log line "ExplorerUi: config: columns A -> B".
# NOTE: MainActivity is android:screenOrientation="portrait". Phones stay portrait (rotation steps change
# nothing there); on tablets / foldables (smallest width >= 600dp, Android 16+ ignores the lock) and in
# split-screen / free-form windows the width really changes, so use those to test the column change.
PKG=com.srizwan.win11
adb shell settings put system accelerometer_rotation 0
for R in 1 0 3 0; do
  echo "user_rotation=$R"; adb shell settings put system user_rotation $R; sleep 2
done
adb shell settings put system accelerometer_rotation 1
echo "dark mode ON"  ; adb shell cmd uimode night yes; sleep 2
echo "dark mode OFF" ; adb shell cmd uimode night no ; sleep 2
echo "dark mode AUTO"; adb shell cmd uimode night auto
echo "Check: same folder, same scroll position, same view mode, no reload, no restart of the app."
echo "pid before/after must be equal and the Activity must NOT be recreated:"
adb shell pidof $PKG
adb shell dumpsys activity activities | grep -m3 -E "mResumedActivity|ActivityRecord.*$PKG"
echo "Debug Log lines:"; adb logcat -d | grep -E "ExplorerUi|FolderLoader" | tail -20
