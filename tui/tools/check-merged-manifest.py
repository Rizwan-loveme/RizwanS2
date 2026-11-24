#!/usr/bin/env python3
"""TUI step 13: checks the MERGED release manifest of :app for the Terminal theme (:tui) pieces.
Usage: tui/tools/check-merged-manifest.py path/to/merged/AndroidManifest.xml
Exit 1 when a piece of :tui is missing, when the terminal could be reached from outside (an intent filter on its activities),
or when anything of :tui is a HOME / LAUNCHER activity (:app's MainActivity must stay the only HOME activity).
Run by the three workflows after the build (the merged manifest is under app/build/intermediates/merged_manifests/release/).
The package prefix ohi.andre.consolelauncher is upstream's and is not touched by the package rename of UltimateBuild_WithoutMe.yml."""
import sys
import xml.etree.ElementTree as ET

A = "{http://schemas.android.com/apk/res/android}"
PKG = "ohi.andre.consolelauncher."
HOME = "android.intent.category.HOME"
LAUNCHER = "android.intent.category.LAUNCHER"


def main(path):
    root = ET.parse(path).getroot()
    app = root.find("application")
    if app is None:
        print("::error::no <application> in the merged manifest")
        return 1
    errors = []

    def find(tag, cls):
        for e in app.findall(tag):
            if e.get(A + "name") == PKG + cls:
                return e
        return None

    # activities: present, not exported, NO intent filter (not HOME, not LAUNCHER, not an "Open with" target)
    for cls in ("LauncherActivity", "commands.tuixt.TuixtActivity", "tuils.stuff.FakeLauncherActivity"):
        e = find("activity", cls)
        if e is None:
            errors.append(f"activity {PKG}{cls} is not in the merged manifest")
            continue
        if e.findall("intent-filter"):
            errors.append(f"activity {PKG}{cls} has an intent filter (it must have none: no HOME / LAUNCHER / VIEW / EDIT)")
        if e.get(A + "exported") == "true":
            errors.append(f"activity {PKG}{cls} is exported")

    # services: present, private except the notification listener the system binds
    for cls, exported in (("managers.notifications.KeeperService", "false"),
                          ("managers.music.MusicService", "false"),
                          ("managers.notifications.NotificationMonitorService", "false"),
                          ("managers.notifications.NotificationService", "true")):
        e = find("service", cls)
        if e is None:
            errors.append(f"service {PKG}{cls} is not in the merged manifest")
        elif (e.get(A + "exported") or "false") != exported:
            errors.append(f"service {PKG}{cls}: exported should be {exported}")
    keeper = find("service", "managers.notifications.KeeperService")
    if keeper is not None and "specialUse" not in (keeper.get(A + "foregroundServiceType") or ""):
        errors.append("KeeperService has no foregroundServiceType specialUse")

    # device admin receiver: exported (the system binds it) and protected by BIND_DEVICE_ADMIN
    pol = find("receiver", "tuils.stuff.PolicyReceiver")
    if pol is None:
        errors.append(f"receiver {PKG}tuils.stuff.PolicyReceiver is not in the merged manifest")
    elif pol.get(A + "permission") != "android.permission.BIND_DEVICE_ADMIN":
        errors.append("PolicyReceiver is not protected by BIND_DEVICE_ADMIN")

    # file provider: private, authority = <applicationId>.FILE_PROVIDER (BuildConfig.APPLICATION_ID + ".FILE_PROVIDER" in the Java code)
    prov = find("provider", "tuils.GenericFileProvider")
    if prov is None:
        errors.append(f"provider {PKG}tuils.GenericFileProvider is not in the merged manifest")
    else:
        auth = prov.get(A + "authorities") or ""
        if not auth.endswith(".FILE_PROVIDER") or "${" in auth:
            errors.append(f"file provider authority is '{auth}' (expected <applicationId>.FILE_PROVIDER, placeholders resolved)")
        if prov.get(A + "exported") == "true":
            errors.append("the T-UI file provider is exported")
        others = [p for p in app.findall("provider") if p is not prov and p.get(A + "authorities") == auth]
        if others:
            errors.append(f"another provider uses the authority {auth}")

    # no activity of :tui may carry HOME or LAUNCHER anywhere
    for e in app.iter("activity"):
        if (e.get(A + "name") or "").startswith(PKG):
            for c in e.iter("category"):
                if c.get(A + "name") in (HOME, LAUNCHER):
                    errors.append(f"{e.get(A + 'name')} has the category {c.get(A + 'name').rsplit('.', 1)[-1]}")

    # :app must still have its own HOME activity, and it must not be one of :tui's
    homes = []
    for e in app.iter("activity"):
        for c in e.iter("category"):
            if c.get(A + "name") == HOME:
                homes.append(e.get(A + "name"))
    if not homes:
        errors.append("no HOME activity at all in the merged manifest (:app's MainActivity lost its HOME filter)")
    if len(set(homes)) > 1:
        errors.append("more than one HOME activity: " + ", ".join(sorted(set(homes))))

    if errors:
        for m in errors:
            print("::error::T-UI manifest: " + m)
        return 1
    print(f"T-UI: 3 activities (no intent filter), 4 services, device admin receiver and FileProvider are in the merged manifest; the only HOME activity is {homes[0]}")
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("usage: check-merged-manifest.py AndroidManifest.xml")
        sys.exit(2)
    sys.exit(main(sys.argv[1]))
