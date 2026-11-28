#!/usr/bin/env python3
"""Shizuku step 4B-3 (a): proves, on the REAL fetched + patched manifests, that the provider removal of step 4B-2 hits exactly the right element and nothing else.
Usage:   python3 shizuku/tools/check-provider-match.py            (after shizuku/tools/fetch-upstream.sh + patch-upstream.sh and mika/tools/fetch-upstream.sh + patch-upstream.sh)
         python3 shizuku/tools/check-provider-match.py --self-test (no upstream needed: builds a good and several bad copies of the inputs and expects the verdicts)
Environment: SHIZUKU_UPSTREAM_DIR (default shizuku/upstream), MIKA_UPSTREAM_DIR (default mika/upstream). Needs only python3. Exit 1 with ::error:: lines, exit 2 = inputs missing.

Inputs: Mika's patched library manifest, the patched manager (:shizuku) manifest, the overlay app/src/shizuku/AndroidManifest.xml (4B-2), app/build.gradle.kts, app/src/main/AndroidManifest.xml
and the Kotlin / Java sources of Mika and of the manager. Rules:

  1. Mika's manifest declares exactly ONE provider named rikka.shizuku.ShizukuProvider (the name the overlay has to carry).
  2. The overlay holds exactly one element, a <provider> with tools:node="remove", and its android:name equals Mika's provider name exactly (the manifest merger keys a provider by name).
  3. The manager's provider is a different name (moe.shizuku.manager.ShizukuManagerProvider: the marker cannot remove it), declares the SAME authority as Mika's (so the clash that the removal
     solves is real), and that authority is ${applicationId}.shizuku. The manager's class extends rikka.shizuku.ShizukuProvider (so nothing of the provider's behaviour is lost).
  4. The marker matches no other component of Mika and no component of the manager; Mika has no other provider with the authority.
  5. Nothing in Mika's sources (Kotlin / Java) refers to ShizukuProvider (4A finding 1: removing the provider cannot break Mika's code).
  7. (7B) Nothing of the provider is lost: every attribute of Mika's provider except the name (enabled, exported, multiprocess, permission, ...) is on the manager's provider with the same value
     (the manager's may carry more). Removing Mika's provider therefore cannot change who may call it or in which process it runs.
  8. (7B) The class rikka.shizuku.ShizukuProvider that the manager's provider extends comes from the project :shizuku-provider, not from Mika's Maven copy: the root build.gradle.kts substitutes
     "dev.rikka.shizuku:provider" by ":shizuku-provider" (otherwise two copies of the class = D8 "Duplicate class"). Only checked when the root build file is given (the real run gives it).
  6. Switch OFF touches nothing: app/build.gradle.kts names src/shizuku/AndroidManifest.xml only inside `if (shizukuIncluded) { ... }` and for exactly the two source sets debug and release;
     app/src/main/AndroidManifest.xml carries no removal of ShizukuProvider and no provider of rikka.shizuku / moe.shizuku.manager (it would act in every build).
"""
import os
import re
import sys
import tempfile
import xml.etree.ElementTree as ET

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
A = "{http://schemas.android.com/apk/res/android}"
T = "{http://schemas.android.com/tools}"
MIKA_NS = "com.wangzan101.mika"
MANAGER_NS = "moe.shizuku.manager"
MIKA_PROVIDER = "rikka.shizuku.ShizukuProvider"
MANAGER_PROVIDER = MANAGER_NS + ".ShizukuManagerProvider"
AUTHORITY = "${applicationId}.shizuku"
KINDS = ("activity", "activity-alias", "service", "receiver", "provider")


def fq(name, ns):
    if name.startswith("."):
        return ns + name
    return name if "." in name else ns + "." + name


def comps(manifest_path, ns):
    root = ET.parse(manifest_path).getroot()
    app = root.find("application")
    out = []
    if app is not None:
        for kind in KINDS:
            for e in app.findall(kind):
                out.append((kind, fq(e.get(A + "name") or "", ns), e))
    return out


def read(path):
    with open(path, encoding="utf-8", errors="replace") as f:
        return f.read()


def sources(folder, exts):
    for d, _dirs, files in os.walk(folder):
        for n in files:
            if n.endswith(exts):
                yield os.path.join(d, n)


def if_block(text, header):
    """Text between the braces of the first `header {` block (brace matching, strings / comments ignored: the file is already checked by check-gradle.py)."""
    i = text.find(header)
    if i < 0:
        return None
    j = text.find("{", i)
    depth = 0
    for k in range(j, len(text)):
        if text[k] == "{":
            depth += 1
        elif text[k] == "}":
            depth -= 1
            if depth == 0:
                return text[j + 1:k]
    return None


def check(mika_manifest, mgr_manifest, overlay, app_gradle, app_manifest, mika_src, mgr_src, root_gradle=None):
    errors = []
    mika = comps(mika_manifest, MIKA_NS)
    mgr = comps(mgr_manifest, MANAGER_NS)

    # 1
    mika_prov = [(k, n, e) for k, n, e in mika if k == "provider" and n == MIKA_PROVIDER]
    if len(mika_prov) != 1:
        errors.append("Mika's manifest has %d provider(s) named %s (expected exactly 1; did Mika's patch or upstream change?)" % (len(mika_prov), MIKA_PROVIDER))
    mika_auth = (mika_prov[0][2].get(A + "authorities") or "") if mika_prov else ""

    # 2
    ov = ET.parse(overlay).getroot()
    ov_app = ov.find("application")
    kids = list(ov_app) if ov_app is not None else []
    others = [c for c in list(ov) if c.tag != "application"]
    if ov.get("package") is not None:
        errors.append("overlay has a package attribute (AGP 8 takes the namespace; remove it)")
    if len(kids) != 1 or others:
        errors.append("overlay must hold exactly one <application> child and nothing else (found %d children, %d other top-level elements)" % (len(kids), len(others)))
    marker = kids[0] if kids else None
    if marker is not None:
        if marker.tag != "provider":
            errors.append("overlay element is <%s>, expected <provider>" % marker.tag)
        if marker.get(T + "node") != "remove":
            errors.append("overlay provider has tools:node=%r, expected 'remove'" % marker.get(T + "node"))
        mname = marker.get(A + "name") or ""
        if mname != MIKA_PROVIDER:
            errors.append("overlay provider name is %r, must equal Mika's provider name %r exactly" % (mname, MIKA_PROVIDER))
        # 4
        hit = [n for _k, n, _e in mika if n == mname]
        if len(hit) > 1:
            errors.append("the marker %s would match %d components of Mika" % (mname, len(hit)))
        hit_mgr = [n for _k, n, _e in mgr if n == mname]
        if hit_mgr:
            errors.append("the marker %s would also remove a component of the manager" % mname)
        if marker.get(A + "authority") not in (None, AUTHORITY):
            errors.append("overlay authority %r differs from %s (documentation only, but it must not lie)" % (marker.get(A + "authority"), AUTHORITY))

    # 3
    mgr_prov = [(k, n, e) for k, n, e in mgr if k == "provider"]
    if len(mgr_prov) != 1 or mgr_prov[0][1] != MANAGER_PROVIDER:
        errors.append("manager manifest providers: %s (expected exactly %s)" % ([n for _k, n, _e in mgr_prov], MANAGER_PROVIDER))
    else:
        mgr_auth = mgr_prov[0][2].get(A + "authorities") or ""
        if mgr_auth != AUTHORITY:
            errors.append("manager provider authority is %r, expected %s" % (mgr_auth, AUTHORITY))
        if mika_prov and mgr_auth != mika_auth:
            errors.append("authorities differ (Mika %r, manager %r): the removal would not be needed any more, or one of the two patches changed" % (mika_auth, mgr_auth))
        if mgr_prov[0][1] == MIKA_PROVIDER:
            errors.append("the manager's provider has the same name as Mika's: the marker would remove both")
        src = [p for p in sources(mgr_src, (".kt", ".java")) if os.path.basename(p) in ("ShizukuManagerProvider.kt", "ShizukuManagerProvider.java")]
        if len(src) != 1:
            errors.append("source of ShizukuManagerProvider not found exactly once in %s" % mgr_src)
        elif not re.search(r"class\s+ShizukuManagerProvider\s*(\(\s*\))?\s*(:|extends)\s*ShizukuProvider\b", read(src[0])):
            errors.append("ShizukuManagerProvider no longer extends ShizukuProvider")
    others_auth = [n for k, n, e in mika if k == "provider" and n != MIKA_PROVIDER and (e.get(A + "authorities") or "") == mika_auth and mika_auth]
    if others_auth:
        errors.append("another Mika provider uses the authority %s: %s" % (mika_auth, ", ".join(others_auth)))

    # 7 (7B): nothing of Mika's provider is lost
    if mika_prov and len(mgr_prov) == 1:
        want = {k: v for k, v in mika_prov[0][2].attrib.items() if k != A + "name"}
        have = mgr_prov[0][2].attrib
        for k, v in sorted(want.items()):
            if have.get(k) != v:
                errors.append("manager provider has %s=%r, Mika's has %r: removing Mika's provider would change it" % (k.replace(A, "android:"), have.get(k), v))

    # 8 (7B): one copy of rikka.shizuku.ShizukuProvider
    if root_gradle is not None:
        rg = re.sub(r"//[^\n]*", "", read(root_gradle))
        if not re.search(r'"dev\.rikka\.shizuku:provider"\s+to\s+":shizuku-provider"', rg):
            errors.append("build.gradle.kts does not substitute dev.rikka.shizuku:provider by :shizuku-provider (Mika's Maven copy of ShizukuProvider would be a duplicate class)")

    # 5
    for p in sources(mika_src, (".kt", ".java")):
        if re.search(r"\bShizukuProvider\b", read(p)):
            errors.append("Mika source refers to ShizukuProvider: %s (removing the provider may break it)" % os.path.relpath(p, mika_src))

    # 6
    g = re.sub(r"//[^\n]*", "", read(app_gradle))   # line comments out: a comment may name the file, only code counts
    ref = "src/shizuku/AndroidManifest.xml"
    body = if_block(g, "if (shizukuIncluded)")
    wired = re.findall(r'sourceSets\.getByName\("(\w+)"\)\.manifest\.srcFile\("%s"\)' % re.escape(ref), g)
    if g.count(ref) != len(wired):
        errors.append("app/build.gradle.kts mentions %s %d times but %d are sourceSets lines (every mention in code must be one of the two sourceSets lines)" % (ref, g.count(ref), len(wired)))
    if sorted(wired) != ["debug", "release"]:
        errors.append("app/build.gradle.kts wires the overlay for %s, expected exactly debug and release" % sorted(wired))
    if body is None or ref not in body:
        errors.append("the overlay is not wired inside an `if (shizukuIncluded) { }` block")
    else:
        if g.count(ref) != body.count(ref):
            errors.append("the overlay is also wired OUTSIDE `if (shizukuIncluded)`: the switch-off build would change")
    m = read(app_manifest)
    if "ShizukuProvider" in m or "ShizukuManagerProvider" in m:
        errors.append("app/src/main/AndroidManifest.xml mentions ShizukuProvider: a removal there would act in every build")
    for _k, n, _e in comps(app_manifest, "com.srizwan.win11"):
        if n.startswith("rikka.shizuku.") or n.startswith(MANAGER_NS + "."):
            errors.append("app/src/main/AndroidManifest.xml declares %s (would act in every build)" % n)
    return errors


def paths():
    s_up = os.environ.get("SHIZUKU_UPSTREAM_DIR") or os.path.join(ROOT, "shizuku", "upstream")
    m_up = os.environ.get("MIKA_UPSTREAM_DIR") or os.path.join(ROOT, "mika", "upstream")
    return dict(
        mika_manifest=os.path.join(m_up, "app", "src", "main", "AndroidManifest.xml"),
        mgr_manifest=os.path.join(s_up, "manager", "src", "main", "AndroidManifest.xml"),
        overlay=os.path.join(ROOT, "app", "src", "shizuku", "AndroidManifest.xml"),
        app_gradle=os.path.join(ROOT, "app", "build.gradle.kts"),
        app_manifest=os.path.join(ROOT, "app", "src", "main", "AndroidManifest.xml"),
        mika_src=os.path.join(m_up, "app", "src", "main"),
        mgr_src=os.path.join(s_up, "manager", "src", "main"),
        root_gradle=os.path.join(ROOT, "build.gradle.kts"),
    )


def run():
    p = paths()
    missing = [k for k, v in p.items() if not os.path.exists(v)]
    if missing:
        for k in missing:
            print("::error::provider match check: %s not found: %s (run the fetch + patch scripts of :shizuku and :mika first)" % (k, p[k]))
        return 2
    errs = check(**p)
    if errs:
        for e in errs:
            print("::error::Shizuku provider match: " + e)
        return 1
    print("Shizuku provider match ok: marker %s = Mika's provider (1 match), manager provider %s keeps %s and extends it (no attribute of Mika's provider lost, one copy of the class), overlay wired only for debug + release inside if (shizukuIncluded), src/main untouched"
          % (MIKA_PROVIDER, MANAGER_PROVIDER, AUTHORITY))
    return 0


# ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
GOOD = dict(
    mika="""<manifest xmlns:android="http://schemas.android.com/apk/res/android"><application>
  <activity android:name=".ui.MainActivity"/>
  <provider android:name="rikka.shizuku.ShizukuProvider" android:authorities="${applicationId}.shizuku" android:exported="true" android:multiprocess="false" android:permission="android.permission.INTERACT_ACROSS_USERS_FULL"/>
</application></manifest>""",
    mgr="""<manifest xmlns:android="http://schemas.android.com/apk/res/android"><application>
  <provider android:name=".ShizukuManagerProvider" android:authorities="${applicationId}.shizuku" android:exported="true" android:multiprocess="false" android:permission="android.permission.INTERACT_ACROSS_USERS_FULL"/>
</application></manifest>""",
    overlay="""<manifest xmlns:android="http://schemas.android.com/apk/res/android" xmlns:tools="http://schemas.android.com/tools"><application>
  <provider android:name="rikka.shizuku.ShizukuProvider" android:authority="${applicationId}.shizuku" tools:node="remove"/>
</application></manifest>""",
    gradle="""android {
    buildTypes { release { } }
    // src/shizuku/AndroidManifest.xml (comment)
    if (shizukuIncluded) {
        sourceSets.getByName("debug").manifest.srcFile("src/shizuku/AndroidManifest.xml")
        sourceSets.getByName("release").manifest.srcFile("src/shizuku/AndroidManifest.xml")
    }
}
""",
    appm="""<manifest xmlns:android="http://schemas.android.com/apk/res/android"><application><activity android:name=".MainActivity"/></application></manifest>""",
    mgrkt="package moe.shizuku.manager\nclass ShizukuManagerProvider : ShizukuProvider() {\n}\n",
    mikakt="package com.wangzan101.mika\nclass A\n",
    rootk="""val shizukuSubstitutions: Map<String, String> = mapOf(\n    "dev.rikka.shizuku:provider" to ":shizuku-provider",\n)\n""",
)


def self_test():
    def build(**over):
        d = tempfile.mkdtemp(prefix="provmatch-")
        v = dict(GOOD)
        v.update(over)
        files = {
            "mika.xml": v["mika"], "mgr.xml": v["mgr"], "overlay.xml": v["overlay"], "app.kts": v["gradle"], "appm.xml": v["appm"],
            "mgr/ShizukuManagerProvider.kt": v["mgrkt"], "mikasrc/A.kt": v["mikakt"], "root.kts": v["rootk"],
        }
        for n, c in files.items():
            os.makedirs(os.path.dirname(os.path.join(d, n)), exist_ok=True)
            with open(os.path.join(d, n), "w", encoding="utf-8") as f:
                f.write(c)
        j = lambda n: os.path.join(d, n)
        return check(j("mika.xml"), j("mgr.xml"), j("overlay.xml"), j("app.kts"), j("appm.xml"), j("mikasrc"), j("mgr"), j("root.kts"))

    cases = [
        ("good", {}, 0),
        ("overlay name wrong", dict(overlay=GOOD["overlay"].replace('rikka.shizuku.ShizukuProvider', 'rikka.shizuku.ShizukuProviderX')), 1),
        ("overlay marker is not remove", dict(overlay=GOOD["overlay"].replace('"remove"', '"merge"')), 1),
        ("overlay would hit the manager provider", dict(overlay=GOOD["overlay"].replace('rikka.shizuku.ShizukuProvider', 'moe.shizuku.manager.ShizukuManagerProvider')), 1),
        ("authorities differ", dict(mgr=GOOD["mgr"].replace("${applicationId}.shizuku", "${applicationId}.other")), 1),
        ("Mika has two such providers", dict(mika=GOOD["mika"].replace("</application>", '<provider android:name="rikka.shizuku.ShizukuProvider" android:authorities="x"/></application>')), 1),
        ("Mika source uses ShizukuProvider", dict(mikakt="import rikka.shizuku.ShizukuProvider\nclass A { fun f() { ShizukuProvider.requestBinderForNonProviderProcess(null) } }\n"), 1),
        ("manager provider no longer a subclass", dict(mgrkt="class ShizukuManagerProvider : ContentProvider() {}\n"), 1),
        ("wired outside the guard", dict(gradle=GOOD["gradle"].replace("    if (shizukuIncluded) {\n", "    run {\n")), 1),
        ("wired for debug only", dict(gradle=GOOD["gradle"].replace('        sourceSets.getByName("release").manifest.srcFile("src/shizuku/AndroidManifest.xml")\n', "")), 1),
        ("removal in src/main manifest", dict(appm=GOOD["appm"].replace("<application>", '<application><provider android:name="rikka.shizuku.ShizukuProvider"/>')), 1),
        ("overlay has a package attribute", dict(overlay=GOOD["overlay"].replace("<manifest ", '<manifest package="x.y" ')), 1),
        ("7B manager provider lost the permission", dict(mgr=GOOD["mgr"].replace(' android:permission="android.permission.INTERACT_ACROSS_USERS_FULL"', "")), 1),
        ("7B manager provider differs in multiprocess", dict(mgr=GOOD["mgr"].replace('android:multiprocess="false"', 'android:multiprocess="true"')), 1),
        ("7B manager provider has an extra attribute (allowed)", dict(mgr=GOOD["mgr"].replace(' android:exported="true"', ' android:exported="true" android:enabled="true"')), 0),
        ("7B no substitution of the provider artifact", dict(rootk=GOOD["rootk"].replace('"dev.rikka.shizuku:provider" to ":shizuku-provider"', '"dev.rikka.shizuku:api" to ":shizuku-api"')), 1),
        ("7B substitution only in a comment", dict(rootk="// \"dev.rikka.shizuku:provider\" to \":shizuku-provider\"\n"), 1),
    ]
    bad = 0
    for name, over, expect_errors in cases:
        got = build(**over)
        ok = (not got) if expect_errors == 0 else bool(got)
        print("  [%s] %s%s" % ("ok " if ok else "FAIL", name, "" if not got else "  -> " + got[0][:110]))
        bad += 0 if ok else 1
    print("self-test: %d of %d cases as expected" % (len(cases) - bad, len(cases)))
    return 1 if bad else 0


if __name__ == "__main__":
    if len(sys.argv) > 1 and sys.argv[1] == "--self-test":
        sys.exit(self_test())
    sys.exit(run())
