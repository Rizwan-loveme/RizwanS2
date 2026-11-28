#!/usr/bin/env python3
"""Mika (Rizwan) step 9: checks the MERGED release manifest of :app for the pieces of :mika.
Usage: mika/tools/check-merged-manifest.py path/to/merged/AndroidManifest.xml
Run by the three workflows after the build (the merged manifest is under app/build/intermediates/merged_manifests/release/).
check-manifest.py (step 7) checks the SOURCE manifests before the build; this one checks what the Android manifest merger really produced:

  1. every one of Mika's 30 permissions (patch-upstream.py KEEP_PERMISSIONS) is in the merged manifest (the owner's rule: none is removed)
  2. every component (activity / service / receiver / provider) that Mika's library manifest declares is in the merged manifest. ONE exception (Shizuku step 4B-3): with the built-in
     Shizuku manager in the build, Mika's rikka.shizuku.ShizukuProvider is removed on purpose (app/src/shizuku/AndroidManifest.xml, tools:node="remove"); it may then be missing,
     but only if moe.shizuku.manager.ShizukuManagerProvider is a provider of the merged manifest with an authority ending in .shizuku (the one it replaces). Without the manager
     the provider must still be there (it is the only receiver of the binder from an external Shizuku app)
  3. no component of Mika is a launcher: no MAIN + LAUNCHER filter, no HOME category (:app's MainActivity stays the only HOME activity)
  4. every component of Mika with an intent filter, and every provider, has an explicit android:exported (the merger needs it at targetSdk 31+)
  5. no placeholder (${applicationId}) is left unresolved in a Mika component (authorities, task affinity)
  6. Mika's MainActivity runs in its own task (taskAffinity ending in .rizwan, part 7)
  7. no provider authority is used twice

Needs only python3. Exit 1 with ::error:: lines when something is off. Environment: MIKA_UPSTREAM_DIR overrides mika/upstream.
The package rename of the workflows changes only :app's package; Mika's package (com.wangzan101.mika) is upstream's and stays.
"""
import importlib.util
import os
import sys
import xml.etree.ElementTree as ET

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
UP = os.environ.get("MIKA_UPSTREAM_DIR") or os.path.join(ROOT, "mika", "upstream")
LIB_MANIFEST = os.path.join(UP, "app", "src", "main", "AndroidManifest.xml")
A = "{http://schemas.android.com/apk/res/android}"
MIKA_NS = "com.wangzan101.mika"
MAIN_ACTIVITY = MIKA_NS + ".ui.MainActivity"
HOME = "android.intent.category.HOME"
LAUNCHER = "android.intent.category.LAUNCHER"
KINDS = ("activity", "activity-alias", "service", "receiver", "provider")
# Shizuku step 4B-3: the one component of Mika that may be replaced by a component of the built-in Shizuku manager (same authority ${applicationId}.shizuku)
SHIZUKU_PROVIDER = "rikka.shizuku.ShizukuProvider"
SHIZUKU_MANAGER_PROVIDER = "moe.shizuku.manager.ShizukuManagerProvider"


def fq(name):
    if name.startswith("."):
        return MIKA_NS + name
    return name if "." in name else MIKA_NS + "." + name


def load_patch():
    spec = importlib.util.spec_from_file_location("patch_upstream", os.path.join(ROOT, "mika", "tools", "patch-upstream.py"))
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


def components(app, qualify):
    out = {}
    if app is None:
        return out
    for kind in KINDS:
        for e in app.findall(kind):
            name = e.get(A + "name") or ""
            out[qualify(name)] = (kind, e)
    return out


def main(merged_path):
    errors = []
    if not os.path.isfile(LIB_MANIFEST):
        print("::error::Mika manifest check: %s not found (fetch + patch Mika first)" % LIB_MANIFEST)
        return 1
    merged = ET.parse(merged_path).getroot()
    m_app = merged.find("application")
    if m_app is None:
        print("::error::Mika manifest check: no <application> in the merged manifest")
        return 1
    lib = ET.parse(LIB_MANIFEST).getroot()
    patch = load_patch()

    # 1. permissions
    have = {e.get(A + "name") for tag in ("uses-permission", "uses-permission-sdk-23") for e in merged.findall(tag)}
    lost = [p for p in patch.KEEP_PERMISSIONS if p not in have]
    if lost:
        errors.append("permissions missing from the merged manifest (none of Mika's may be removed): " + ", ".join(lost))

    # 2. components
    lib_comps = components(lib.find("application"), fq)
    merged_comps = components(m_app, lambda n: n)
    replaced = []
    for name, (kind, _e) in sorted(lib_comps.items()):
        if name not in merged_comps:
            if name == SHIZUKU_PROVIDER and SHIZUKU_MANAGER_PROVIDER in merged_comps:
                mk, me = merged_comps[SHIZUKU_MANAGER_PROVIDER]
                auths = [a.strip() for a in (me.get(A + "authorities") or "").split(";") if a.strip()]
                if mk == "provider" and any(a.endswith(".shizuku") for a in auths):
                    replaced.append(name)          # removed on purpose, the manager's provider took over its authority
                    continue
                errors.append("provider %s is gone and %s is not a provider with an authority ending in .shizuku (found %s)" % (name, SHIZUKU_MANAGER_PROVIDER, auths or mk))
                continue
            errors.append("%s %s is in Mika's manifest but not in the merged manifest" % (kind, name))

    # 3 + 4 + 5. no launcher, explicit exported, no open placeholder
    auth_seen = {}
    for name, (kind, _e) in sorted(lib_comps.items()):
        if name not in merged_comps:
            continue
        _k, e = merged_comps[name]
        for c in e.iter("category"):
            if c.get(A + "name") in (HOME, LAUNCHER):
                errors.append("%s has the category %s" % (name, c.get(A + "name").rsplit(".", 1)[-1]))
        for f in e.findall("intent-filter"):
            acts = {a.get(A + "name") for a in f.findall("action")}
            cats = {c.get(A + "name") for c in f.findall("category")}
            if "android.intent.action.MAIN" in acts and LAUNCHER in cats:
                errors.append("%s has a MAIN / LAUNCHER intent filter" % name)
        if (e.findall("intent-filter") or kind == "provider") and e.get(A + "exported") is None:
            errors.append("%s has no explicit android:exported" % name)
        for key, val in e.attrib.items():
            if "${" in val:
                errors.append("%s: %s still has a placeholder: %s" % (name, key.replace(A, "android:"), val))
        if kind == "provider":
            for a in (e.get(A + "authorities") or "").split(";"):
                a = a.strip()
                if a:
                    auth_seen.setdefault(a, []).append(name)

    # 6. Mika's MainActivity in its own task
    main = merged_comps.get(MAIN_ACTIVITY)
    if main is None:
        errors.append("activity %s (Rizwan's chat screen, started by MikaLauncher) is not in the merged manifest" % MAIN_ACTIVITY)
    else:
        aff = main[1].get(A + "taskAffinity") or ""
        if not aff.endswith(".rizwan"):
            errors.append("%s has taskAffinity '%s' (expected <applicationId>.rizwan: its own window in Recents)" % (MAIN_ACTIVITY, aff))

    # 7. authorities (Mika's own providers; every other provider of the merged manifest too)
    for kind, name, e in [(k, n, el) for n, (k, el) in merged_comps.items() if k == "provider"]:
        for a in (e.get(A + "authorities") or "").split(";"):
            a = a.strip()
            if a and a not in auth_seen:
                auth_seen.setdefault(a, []).append(name)
            elif a and name not in auth_seen[a]:
                auth_seen[a].append(name)
    for a, owners in sorted(auth_seen.items()):
        if len(set(owners)) > 1:
            errors.append("provider authority %s is used by: %s" % (a, ", ".join(sorted(set(owners)))))

    # :app must keep exactly one HOME activity, and it must not be one of Mika's
    homes = sorted({n for n, (_k, e) in merged_comps.items() for c in e.iter("category") if c.get(A + "name") == HOME})
    if not homes:
        errors.append("no HOME activity at all in the merged manifest (:app's MainActivity lost its HOME filter)")
    elif len(homes) > 1:
        errors.append("more than one HOME activity: " + ", ".join(homes))

    if errors:
        for m in errors:
            print("::error::Mika manifest: " + m)
        return 1
    kinds = {}
    for _n, (k, _e) in lib_comps.items():
        kinds[k] = kinds.get(k, 0) + 1
    print("Mika: %d permissions and %d components (%s) are in the merged manifest%s; no launcher filter; the only HOME activity is %s"
          % (len(patch.KEEP_PERMISSIONS), len(lib_comps) - len(replaced), ", ".join("%d %s" % (v - (1 if k == "provider" and replaced else 0), k) for k, v in sorted(kinds.items())),
             " (+ %s replaced by %s on purpose, Shizuku built in)" % (replaced[0], SHIZUKU_MANAGER_PROVIDER) if replaced else "", homes[0]))
    return 0


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("usage: check-merged-manifest.py AndroidManifest.xml")
        sys.exit(2)
    sys.exit(main(sys.argv[1]))
