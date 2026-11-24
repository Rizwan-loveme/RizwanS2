#!/usr/bin/env python3
"""Seal part 8: checks the MERGED release manifest of :app for the Seal (Downloader) pieces.
Usage: seal/tools/check-merged-manifest.py path/to/merged/AndroidManifest.xml
Exit 1 when a piece is missing or when Seal could be reached from outside (an intent filter on one of its activities).
Run by the three workflows after the build (the merged manifest is under app/build/intermediates/merged_manifests/release/)."""
import sys
import xml.etree.ElementTree as ET

A = "{http://schemas.android.com/apk/res/android}"
PKG = "com.junkfood.seal."

def main(path):
    root = ET.parse(path).getroot()
    app = root.find("application")
    if app is None:
        print("::error::no <application> in the merged manifest"); return 1
    def find(tag, cls):
        for e in app.findall(tag):
            if e.get(A + "name") == PKG + cls:
                return e
        return None
    errors = []
    # activities: present, and NO intent filter (Seal must not appear in share sheets or as a link handler; part 5)
    for cls in ("MainActivity", "QuickDownloadActivity", "CrashReportActivity"):
        e = find("activity", cls)
        if e is None:
            errors.append(f"activity {PKG}{cls} is not in the merged manifest"); continue
        if e.findall("intent-filter"):
            errors.append(f"activity {PKG}{cls} has an intent filter (it must have none: no own launcher icon, no SEND / VIEW filters)")
        if e.get(A + "exported") == "true":
            errors.append(f"activity {PKG}{cls} is exported")
    svc = find("service", "DownloadService")
    if svc is None:
        errors.append(f"service {PKG}DownloadService is not in the merged manifest")
    elif "specialUse" not in (svc.get(A + "foregroundServiceType") or ""):
        errors.append("DownloadService has no foregroundServiceType specialUse")
    if find("receiver", "NotificationActionReceiver") is None:
        errors.append(f"receiver {PKG}NotificationActionReceiver is not in the merged manifest")
    if find("provider", "SealFileProvider") is None:
        errors.append(f"provider {PKG}SealFileProvider is not in the merged manifest")
    # nothing of Seal may carry the LAUNCHER category anywhere in the merged file
    for e in app.iter("activity"):
        if (e.get(A + "name") or "").startswith(PKG):
            for c in e.iter("category"):
                if c.get(A + "name") == "android.intent.category.LAUNCHER":
                    errors.append(f"{e.get(A + 'name')} has a LAUNCHER category")
    if errors:
        for m in errors:
            print("::error::Seal manifest: " + m)
        return 1
    print("Seal: 3 activities (no intent filter), DownloadService (specialUse), receiver and FileProvider are in the merged manifest")
    return 0

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("usage: check-merged-manifest.py AndroidManifest.xml"); sys.exit(2)
    sys.exit(main(sys.argv[1]))
