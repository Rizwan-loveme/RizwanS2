#!/usr/bin/env python3
"""Static check of the manifest merge  :mika (patched upstream)  ->  :app  (part 7 of the Mika plan; CI step 9 and the checks of step 13 run it too).

AGP merges the library manifest into the app at build time and we cannot run it here, so this script re-checks by hand what usually breaks:

  1. every one of Mika's 30 permissions (patch-upstream.py KEEP_PERMISSIONS) is still declared  (the owner's rule: none is removed)
  2. the library manifest is a library manifest: no <application> attributes, no MAIN/LAUNCHER filter
  3. no component (activity / service / receiver / provider) of Mika has the same class name as one of :app
  4. no provider authority clashes after ${applicationId} is replaced with the host's id (Mika + :app + the other library manifests)
  5. every component class of Mika exists in the fetched sources (a typo or a changed upstream layout shows here, not at run time)
  6. every @string / @xml / @drawable / @mipmap / @style used by the manifest exists in Mika's resources
  7. Mika's user-visible screens have the label / icon / own task of part 7
  8. what Mika adds on top of :app (new permissions) is printed
  9. (part 8, targetSdk 37) every component with an intent filter, and every provider, of Mika, :app and the other library manifests has an explicit android:exported
     (the manifest merger fails at targetSdk 31+ otherwise)
 10. (part 8) every foreground service type used anywhere has its FOREGROUND_SERVICE_<TYPE> permission in some manifest (startForeground throws at targetSdk 34+ otherwise)
 11. (part 8) the hook MikaLauncher.kt starts a class that the Mika manifest declares (an explicit intent to a missing activity only fails at run time)
 12. (part 11) the licence assets that go into the APK are in the patched checkout (assets/licenses: Apache-2.0, GPL-2.0, GPL-3.0, LGPL-3.0, THIRD_PARTY_NOTICES.md, MIKA-NOTICE.txt,
     RIZWAN-NOTICE.md, gpl-source/ with the PRoot patches and source locks): the licences of what the APK ships (PRoot, talloc, the Alpine root file system) must travel with it

CI (part 9) runs it right after the fetch + patch, so a changed upstream layout stops the run before the long build. What AGP really merged is checked after the build by
mika/tools/check-merged-manifest.py (permissions, components, no launcher filter, exported, placeholders, own task, authorities).

Usage (from the project root, after fetch + patch):   python3 mika/tools/check-manifest.py
Environment: MIKA_UPSTREAM_DIR overrides mika/upstream.  Exit 1 with ::error:: lines when something is off.  Needs only python3.
"""
import glob
import importlib.util
import os
import re
import sys
import xml.etree.ElementTree as ET

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
UP = os.environ.get("MIKA_UPSTREAM_DIR") or os.path.join(ROOT, "mika", "upstream")
MAIN = os.path.join(UP, "app", "src", "main")
RES = os.path.join(MAIN, "res")
JAVA = os.path.join(MAIN, "java")
A = "{http://schemas.android.com/apk/res/android}"
errors = []


def err(msg):
    errors.append(msg)
    print("::error::check-manifest: " + msg, file=sys.stderr)


def read(p):
    with open(p, encoding="utf-8") as f:
        return f.read()


def load_patch():
    spec = importlib.util.spec_from_file_location("patch_upstream", os.path.join(ROOT, "mika", "tools", "patch-upstream.py"))
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


def gradle_value(path, key):
    m = re.search(r'%s\s*=\s*"([^"]+)"' % key, read(path))
    return m.group(1) if m else None


def fq(name, ns):
    if name.startswith("."):
        return ns + name
    return name if "." in name else ns + "." + name


def components(root, ns):
    out = []
    app = root.find("application")
    if app is None:
        return out
    for kind in ("activity", "activity-alias", "service", "receiver", "provider"):
        for e in app.findall(kind):
            out.append((kind, fq(e.get(A + "name", ""), ns), e))
    return out


def main():
    mf = os.path.join(MAIN, "AndroidManifest.xml")
    if not os.path.isfile(mf):
        err("%s not found: run mika/tools/fetch-upstream.sh and patch-upstream.sh first" % mf)
        return
    host_mf = os.path.join(ROOT, "app", "src", "main", "AndroidManifest.xml")
    host_ns = gradle_value(os.path.join(ROOT, "app", "build.gradle.kts"), "namespace") or "com.srizwan.win11"
    host_id = gradle_value(os.path.join(ROOT, "app", "build.gradle.kts"), "applicationId") or host_ns
    mika_ns = gradle_value(os.path.join(ROOT, "mika", "build.gradle.kts"), "namespace") or "com.wangzan101.mika"
    patch = load_patch()
    mika = ET.fromstring(read(mf).encode("utf-8"))
    host = ET.fromstring(read(host_mf).encode("utf-8"))

    # 1. permissions
    mika_perms = {e.get(A + "name") for e in mika.findall("uses-permission")}
    host_perms = {e.get(A + "name") for e in host.findall("uses-permission")}
    lost = [p for p in patch.KEEP_PERMISSIONS if p not in mika_perms]
    if lost:
        err("permissions missing from the Mika manifest (none may be removed): " + ", ".join(lost))
    extra = sorted(mika_perms - set(patch.KEEP_PERMISSIONS))
    if extra:
        print("check-manifest: note: Mika declares %d permission(s) not in KEEP_PERMISSIONS (new upstream version? add them): %s" % (len(extra), ", ".join(extra)))

    # 2. library manifest
    app = mika.find("application")
    if app is None:
        err("no <application> in the Mika manifest")
        return
    if app.attrib:
        err("<application> of the Mika manifest still has attributes: " + ", ".join(k.replace(A, "android:") for k in app.attrib))
    for e in app.iter("activity"):
        for f in e.findall("intent-filter"):
            acts = {a.get(A + "name") for a in f.findall("action")}
            cats = {c.get(A + "name") for c in f.findall("category")}
            if "android.intent.action.MAIN" in acts and "android.intent.category.LAUNCHER" in cats:
                err("activity %s still has a MAIN/LAUNCHER filter" % e.get(A + "name"))

    # 3. duplicate component names
    host_comps = {n: k for k, n, _ in components(host, host_ns)}
    mika_comps = components(mika, mika_ns)
    seen = {}
    for kind, name, _e in mika_comps:
        if name in host_comps:
            err("component %s exists in :app and in Mika" % name)
        if name in seen:
            err("component %s declared twice in the Mika manifest" % name)
        seen[name] = kind

    # 4. provider authorities (Mika + :app + the other library manifests)
    auth = {}

    def add_auth(owner, root_el, ns, app_id):
        for k, n, e in components(root_el, ns):
            if k != "provider":
                continue
            for a in (e.get(A + "authorities") or "").split(";"):
                a = a.replace("${applicationId}", app_id).strip()
                if a:
                    auth.setdefault(a, []).append("%s:%s" % (owner, n))
    add_auth("app", host, host_ns, host_id)
    add_auth("mika", mika, mika_ns, host_id)
    for other in sorted(glob.glob(os.path.join(ROOT, "*", "src", "main", "AndroidManifest.xml"))):
        owner = os.path.basename(os.path.dirname(os.path.dirname(os.path.dirname(other))))
        if owner in ("app", "mika"):
            continue
        try:
            add_auth(owner, ET.fromstring(read(other).encode("utf-8")), owner, host_id)
        except ET.ParseError:
            pass
    for a, owners in sorted(auth.items()):
        if len(owners) > 1:
            err("provider authority %s declared by: %s" % (a, ", ".join(owners)))

    # 5. component classes exist
    for kind, name, _e in mika_comps:
        if not name.startswith(mika_ns + "."):
            continue                                     # library class (rikka.shizuku.ShizukuProvider): comes from a dependency
        rel = name[len(mika_ns) + 1:].split(".")
        pkg_dir = os.path.join(JAVA, *mika_ns.split("."), *rel[:-1])
        cls = rel[-1]
        if os.path.isfile(os.path.join(pkg_dir, cls + ".kt")) or os.path.isfile(os.path.join(pkg_dir, cls + ".java")):
            continue
        rx = re.compile(r"\b(?:class|object)\s+%s\b" % re.escape(cls))
        if not any(rx.search(read(f)) for f in glob.glob(os.path.join(pkg_dir, "*.kt")) + glob.glob(os.path.join(pkg_dir, "*.java"))):
            err("%s %s: class not found in the fetched sources" % (kind, name))
    shizuku = [n for _k, n, _e in mika_comps if n.startswith("rikka.")]
    if shizuku and "dev.rikka.shizuku" not in read(os.path.join(ROOT, "mika", "build.gradle.kts")):
        err("Mika's manifest uses %s but mika/build.gradle.kts has no dev.rikka.shizuku dependency" % ", ".join(shizuku))

    # 6. resources used by the manifest
    text = read(mf)
    values = ""
    for f in glob.glob(os.path.join(RES, "values", "*.xml")):
        values += read(f)
    for kind, name in sorted(set(re.findall(r"@(string|xml|drawable|mipmap|style|bool|integer|color)/([A-Za-z0-9_.]+)", text))):
        if kind in ("xml", "drawable", "mipmap"):
            ok = bool(glob.glob(os.path.join(RES, "%s*" % kind, name + ".*")))
        elif kind == "style":
            ok = ('name="%s"' % name) in values
        else:
            ok = ('name="%s"' % name) in values
        if not ok:
            err("@%s/%s used in the manifest does not exist in Mika's resources" % (kind, name))

    # 7. part 7 labels / own task
    acts = {e.get(A + "name"): e for e in app.iter("activity")}
    for name, own_task in patch.UI_ACTIVITIES.items():
        e = acts.get(name)
        if e is None:
            err("activity %s missing" % name)
            continue
        if e.get(A + "label") != "@string/mk_app_name" or e.get(A + "icon") != "@mipmap/mk_ic_launcher":
            err("activity %s has no Rizwan label / icon" % name)
        if own_task and e.get(A + "taskAffinity") != patch.AFFINITY:
            err("activity %s has no own task affinity" % name)

    # 9. exported (part 8: targetSdk 37)
    def need_exported(owner, root_el, ns):
        ap = root_el.find("application")
        if ap is None:
            return
        for k, n, e in components(root_el, ns):
            if e.get(A + "exported") is None and (k == "provider" or e.find("intent-filter") is not None):
                err("%s: %s %s has no android:exported (required at targetSdk 31+)" % (owner, k, n))
    need_exported("mika", mika, mika_ns)
    need_exported("app", host, host_ns)
    others = []
    for other in sorted(glob.glob(os.path.join(ROOT, "*", "src", "main", "AndroidManifest.xml"))):
        owner = os.path.basename(os.path.dirname(os.path.dirname(os.path.dirname(other))))
        if owner in ("app", "mika"):
            continue
        try:
            root_el = ET.fromstring(read(other).encode("utf-8"))
        except ET.ParseError:
            continue
        others.append(root_el)
        need_exported(owner, root_el, owner)

    # 10. foreground service types and their permissions
    all_perms = set(mika_perms) | set(host_perms)
    for root_el in others:
        all_perms |= {e.get(A + "name") for e in root_el.findall("uses-permission")}
    fg_perm = {"dataSync": "FOREGROUND_SERVICE_DATA_SYNC", "mediaPlayback": "FOREGROUND_SERVICE_MEDIA_PLAYBACK", "mediaProjection": "FOREGROUND_SERVICE_MEDIA_PROJECTION",
               "microphone": "FOREGROUND_SERVICE_MICROPHONE", "camera": "FOREGROUND_SERVICE_CAMERA", "location": "FOREGROUND_SERVICE_LOCATION",
               "phoneCall": "FOREGROUND_SERVICE_PHONE_CALL", "connectedDevice": "FOREGROUND_SERVICE_CONNECTED_DEVICE", "remoteMessaging": "FOREGROUND_SERVICE_REMOTE_MESSAGING",
               "specialUse": "FOREGROUND_SERVICE_SPECIAL_USE", "systemExempted": "FOREGROUND_SERVICE_SYSTEM_EXEMPTED", "health": "FOREGROUND_SERVICE_HEALTH",
               "mediaProcessing": "FOREGROUND_SERVICE_MEDIA_PROCESSING", "fileManagement": "FOREGROUND_SERVICE_FILE_MANAGEMENT"}
    used_types = set()
    for root_el, ns in [(mika, mika_ns), (host, host_ns)] + [(r, "") for r in others]:
        ap = root_el.find("application")
        if ap is None:
            continue
        for sv in ap.findall("service"):
            for t in (sv.get(A + "foregroundServiceType") or "").split("|"):
                t = t.strip()
                if t:
                    used_types.add(t)
    for t in sorted(used_types):
        p = fg_perm.get(t)
        if p and "android.permission." + p not in all_perms:
            err("a service uses foregroundServiceType %s but no manifest declares android.permission.%s" % (t, p))

    # 11. the hook starts a class the manifest declares
    launcher = os.path.join(ROOT, "app", "src", "main", "kotlin", *host_ns.split("."), "MikaLauncher.kt")
    if os.path.isfile(launcher):
        hit = re.findall(r"Intent\([^,]+,\s*([A-Za-z0-9_.]+)::class\.java\)", read(launcher))
        if not hit:
            err("MikaLauncher.kt: no explicit Intent(..., X::class.java) found (the check does not know the hook any more)")
        for cls in hit:
            if cls not in {n for _k, n, _e in mika_comps}:
                err("MikaLauncher.kt starts %s but the Mika manifest does not declare it" % cls)
    else:
        err("%s not found (part 8 hook)" % launcher)

    # 12. licence assets (part 11)
    lic_dir = os.path.join(MAIN, "assets", "licenses")
    for rel in patch.LICENSE_ASSETS:
        lp = os.path.join(lic_dir, *rel.split("/"))
        if not os.path.isfile(lp) or os.path.getsize(lp) == 0:
            err("licence asset missing or empty: assets/licenses/%s (run mika/tools/patch-upstream.sh)" % rel)
    gp = os.path.join(lic_dir, "gpl-source", "patches")
    n_patches = len([f for f in os.listdir(gp) if f.endswith(".patch")]) if os.path.isdir(gp) else 0
    if n_patches < patch.LICENSE_PATCHES_MIN:
        err("assets/licenses/gpl-source/patches has %d patches, expected at least %d" % (n_patches, patch.LICENSE_PATCHES_MIN))
    if "libproot.so" in "".join(os.listdir(os.path.join(MAIN, "jniLibs", "arm64-v8a"))) and not os.path.isfile(os.path.join(lic_dir, "GPL-2.0.txt")):
        err("the APK ships libproot.so (GPL-2.0) but assets/licenses/GPL-2.0.txt is missing")

    # 8. report
    new = sorted(mika_perms - host_perms)
    print("check-manifest: Mika declares %d permissions, %d already in :app, %d added to the merged app: %s" % (len(mika_perms), len(mika_perms & host_perms), len(new), ", ".join(p.split(".")[-1] for p in new)))
    kinds = {}
    for k, _n, _e in mika_comps:
        kinds[k] = kinds.get(k, 0) + 1
    print("check-manifest: Mika components merged into :app: " + ", ".join("%d %s" % (v, k) for k, v in sorted(kinds.items())) + "; provider authorities checked: %d" % len(auth))


if __name__ == "__main__":
    main()
    if errors:
        print("check-manifest: %d problem(s)" % len(errors), file=sys.stderr)
        sys.exit(1)
    print("check-manifest: OK")
