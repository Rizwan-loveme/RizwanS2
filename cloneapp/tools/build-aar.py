#!/usr/bin/env python3
"""
Builds cloneapp/cloneapp.aar from a decoded Clone App (apktool-style folder: AndroidManifest.xml, res/, assets/)
plus the dex2jar jars of its classes*.dex.

    python3 cloneapp/tools/build-aar.py --clone <decoded-apk-dir> --jars classes.jar classes2.jar ... \
        [--project .] [--out cloneapp/cloneapp.aar]

Everything the script changes is listed in cloneapp/README.md ("What was changed") and in cloneapp/STRIPPED-CLASSES.txt.
Needs only Python 3 (standard library).
"""
import argparse, collections, io, os, re, struct, sys, zipfile
import xml.etree.ElementTree as ET

PKG = "com.pengyou.cloneapp"
ANDROID = "http://schemas.android.com/apk/res/android"
ET.register_namespace("android", ANDROID)
A = "{%s}" % ANDROID

# Classes that the host project gets from Gradle libraries (declared in cloneapp/build.gradle.kts) or already holds itself.
# Keeping a second copy would stop the build with "Duplicate class ...".
STRIP_PREFIXES = (
    "androidx/", "kotlin/", "kotlinx/", "org/jetbrains/", "org/intellij/",
    "com/google/android/material/",          # com.google.android.material:material
    "com/google/protobuf/",                  # protobuf-javalite (:mika / :ppsspp already pin 4.36.2)
    "com/google/gson/",                      # gson
    "com/arthenica/",                        # ffmpeg-kit (:seal / :j2me bring io.github.nikita36078:ffmpeg-kit, same package)
    "org/chromium/support_lib_boundary/",    # androidx.webkit
)
# Files that do not belong to the Clone App at all (added by a patching tool, see README)
DROP_JAR_PARTS = ("classes5",)               # signature killer, packer stub, pop-up dialog; only org/lsposed/hiddenapibypass is unused
# Class-file patches (see README "What was changed")
PATCH_SUPER = ("com/bly/chaosapp/application/BLYApplication", "bin/mt/signature/KillerApplication", "android/app/Application")
PATCH_NOP_CALL = ("com/pengyou/cloneapp/UserActivity", "com/zx/LB", "ll")


def cp_parse(b):
    """Constant pool of a class file: returns (entries, end_offset). entries[i] = (tag, data) ; index 0 unused."""
    n = struct.unpack(">H", b[8:10])[0]
    off, ents, i = 10, [None], 1
    while i < n:
        t = b[off]
        if t == 1:
            l = struct.unpack(">H", b[off + 1:off + 3])[0]
            ents.append((1, b[off + 3:off + 3 + l])); off += 3 + l
        elif t in (3, 4):
            ents.append((t, b[off + 1:off + 5])); off += 5
        elif t in (5, 6):
            ents.append((t, b[off + 1:off + 9])); ents.append(None); off += 9; i += 1
        elif t in (7, 8, 16, 19, 20):
            ents.append((t, struct.unpack(">H", b[off + 1:off + 3])[0])); off += 3
        elif t in (9, 10, 11, 12, 17, 18):
            ents.append((t, struct.unpack(">HH", b[off + 1:off + 5]))); off += 5
        elif t == 15:
            ents.append((t, b[off + 1:off + 4])); off += 4
        else:
            raise ValueError("bad constant pool tag %d" % t)
        i += 1
    return ents, off


def class_index(b, ents, name):
    for i, e in enumerate(ents):
        if e and e[0] == 7:
            u = ents[e[1]]
            if u and u[0] == 1 and u[1] == name.encode():
                return i
    return None


def patch_super(b, cls, old_super, new_super):
    ents, end = cp_parse(b)
    old_i, new_i = class_index(b, ents, old_super), class_index(b, ents, new_super)
    if old_i is None or new_i is None:
        raise SystemExit("patch_super: %s / %s not found in %s" % (old_super, new_super, cls))
    super_off = end + 4          # access_flags(2) this_class(2) super_class(2)
    assert struct.unpack(">H", b[end + 4:end + 6])[0] == old_i, "unexpected super class in " + cls
    return b[:end + 4] + struct.pack(">H", new_i) + b[end + 6:]


def patch_nop_call(b, cls, owner, method):
    """Replaces `aload_0; invokestatic owner.method(Landroid/app/Activity;)V` by four nops (stack neutral)."""
    ents, _ = cp_parse(b)
    oi = class_index(b, ents, owner)
    hit = None
    for i, e in enumerate(ents):
        if e and e[0] == 10 and e[1][0] == oi:
            nat = ents[e[1][1]]
            nm = ents[nat[1][0]][1]
            if nm == method.encode():
                hit = i
    if hit is None:
        raise SystemExit("patch_nop_call: %s.%s not referenced in %s" % (owner, method, cls))
    pat = b"\x2a\xb8" + struct.pack(">H", hit)
    if b.count(pat) != 1:
        raise SystemExit("patch_nop_call: pattern count %d in %s" % (b.count(pat), cls))
    return b.replace(pat, b"\x00\x00\x00\x00")


def bcore_classes(project):
    host, base = set(), os.path.join(project, "Bcore", "src", "main")
    for r, _, fs in os.walk(base):
        for f in fs:
            if f.endswith((".java", ".aidl", ".kt")):
                pk = None
                for line in open(os.path.join(r, f), encoding="utf8", errors="ignore"):
                    m = re.match(r"\s*package\s+([\w.]+)", line)
                    if m:
                        pk = m.group(1); break
                if pk:
                    host.add(pk.replace(".", "/") + "/" + f.rsplit(".", 1)[0])
    return host


def build_classes_jar(jars, project):
    host = bcore_classes(project)
    out, stripped, seen = io.BytesIO(), collections.defaultdict(list), set()
    with zipfile.ZipFile(out, "w", zipfile.ZIP_DEFLATED) as zo:
        for jp in jars:
            if any(p in os.path.basename(jp) for p in DROP_JAR_PARTS):
                continue
            with zipfile.ZipFile(jp) as zi:
                for info in zi.infolist():
                    n = info.filename
                    if n.endswith("/") or not n.endswith(".class"):
                        continue
                    base = n[:-6].split("$")[0]
                    pre = next((x for x in STRIP_PREFIXES if n.startswith(x)), None)
                    if pre:
                        stripped["bundled library copy, replaced by Gradle dependency: " + "/".join(n.split("/")[:2])].append(n); continue
                    if base in host:
                        stripped["duplicate of :Bcore"].append(n); continue
                    if n in seen:
                        stripped["duplicate entry"].append(n); continue
                    seen.add(n)
                    data = zi.read(info)
                    if base == PATCH_SUPER[0]:
                        data = patch_super(data, base, PATCH_SUPER[1], PATCH_SUPER[2])
                    if base == PATCH_NOP_CALL[0] and "$" not in n:
                        data = patch_nop_call(data, base, PATCH_NOP_CALL[1], PATCH_NOP_CALL[2])
                    zo.writestr(n, data)
    return out.getvalue(), stripped


def fix_manifest(src):
    ET.parse(src)
    tree = ET.parse(src)
    root = tree.getroot()
    for k in ("compileSdkVersion", "compileSdkVersionCodename"):
        root.attrib.pop(A + k, None)
    for k in ("platformBuildVersionCode", "platformBuildVersionName"):
        root.attrib.pop(k, None)
    app = root.find("application")
    removed_app = {k.replace(A, "android:"): v for k, v in app.attrib.items()}
    app.attrib.clear()                       # the host's own <application> decides name / icon / theme / label / flags
    prefix = PKG + "."
    n_auth = n_perm = n_launch = 0
    def sub(v):
        return "${applicationId}." + v[len(prefix):] if v.startswith(prefix) else v
    for el in root.iter():
        for key in ("authorities", "permission"):
            v = el.attrib.get(A + key)
            if v and v.startswith(prefix):
                el.attrib[A + key] = ";".join(sub(x) for x in v.split(";")); n_auth += 1
        if el.tag in ("permission", "uses-permission", "uses-permission-sdk-23"):
            v = el.attrib.get(A + "name", "")
            if v.startswith(prefix):
                el.attrib[A + "name"] = sub(v); n_perm += 1
    for parent in list(root.iter()):
        for ch in list(parent):
            if ch.tag == "intent-filter" and any(
                    c.attrib.get(A + "name") == "android.intent.category.LAUNCHER" for c in ch.iter("category")):
                parent.remove(ch); n_launch += 1
    buf = io.BytesIO()
    tree.write(buf, encoding="utf-8", xml_declaration=True)
    return buf.getvalue(), removed_app, n_auth, n_perm, n_launch


FILE_TYPES = {"anim", "animator", "color", "drawable", "font", "interpolator", "layout", "menu", "mipmap", "raw", "xml", "transition", "navigation"}


def defined_resources(res):
    d = set()
    for r, _, fs in os.walk(res):
        t = os.path.basename(r).split("-")[0]
        for f in fs:
            p = os.path.join(r, f)
            if t in FILE_TYPES:
                d.add((t, f.split(".")[0]))
            elif t == "values" and f.endswith(".xml"):
                for el in ET.parse(p).getroot():
                    nm = el.attrib.get("name")
                    if not nm:
                        continue
                    ty = {"item": el.attrib.get("type", ""), "string-array": "array", "integer-array": "array",
                          "declare-styleable": "styleable"}.get(el.tag, el.tag)
                    d.add((ty, nm.replace(".", "_")))
                    if el.tag == "declare-styleable":
                        for a in el:
                            d.add(("attr", a.attrib["name"]))
    return d


def public_and_rtxt(res):
    """Keeps res/values/public.xml (the ids the dex code was compiled against) but only for resources that exist; writes R.txt."""
    pub = os.path.join(res, "values", "public.xml")
    tree = ET.parse(pub)
    defined = defined_resources(res)
    keep, drop = [], []
    for el in list(tree.getroot()):
        key = (el.attrib["type"], el.attrib["name"].replace(".", "_"))
        (keep if key in defined else drop).append(el)
    for el in drop:
        tree.getroot().remove(el)
    buf = io.BytesIO(); tree.write(buf, encoding="utf-8", xml_declaration=True)
    rtxt = "".join("int %s %s %s\n" % (e.attrib["type"], e.attrib["name"].replace(".", "_"), e.attrib["id"])
                   for e in sorted(keep, key=lambda e: (e.attrib["type"], int(e.attrib["id"], 16))))
    return buf.getvalue(), rtxt, len(keep), [(e.attrib["type"], e.attrib["name"]) for e in drop]


CONSUMER_RULES = """# Clone App (:cloneapp) - the engine is reflection / JNI based and its classes are already obfuscated: keep them as they are.
-keep class com.bly.** { *; }
-keep class com.pengyou.cloneapp.** { *; }
-keep class top.canyie.pine.** { *; }
-keepclasseswithmembernames class * { native <methods>; }
-dontwarn com.bly.**
-dontwarn com.google.android.gms.**
-dontwarn com.applovin.**
-dontwarn com.bytedance.**
-dontwarn com.mbridge.**
-dontwarn com.ironsource.**
-dontwarn com.unity3d.**
-dontwarn com.vungle.**
"""


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--clone", required=True)
    ap.add_argument("--jars", nargs="+", required=True)
    ap.add_argument("--project", default=".")
    ap.add_argument("--out", default="cloneapp/cloneapp.aar")
    a = ap.parse_args()

    classes, stripped = build_classes_jar(sorted(a.jars), a.project)
    manifest, removed_app, n_auth, n_perm, n_launch = fix_manifest(os.path.join(a.clone, "AndroidManifest.xml"))
    res = os.path.join(a.clone, "res")
    pubxml, rtxt, n_pub, dropped_pub = public_and_rtxt(res)

    os.makedirs(os.path.dirname(os.path.abspath(a.out)), exist_ok=True)
    with zipfile.ZipFile(a.out, "w", zipfile.ZIP_DEFLATED, compresslevel=9) as z:
        z.writestr("AndroidManifest.xml", manifest)
        z.writestr("classes.jar", classes)
        z.writestr("R.txt", rtxt)
        z.writestr("proguard.txt", CONSUMER_RULES)
        z.writestr("META-INF/com/android/build/gradle/aar-metadata.properties",
                   "aarFormatVersion=1.0\naarMetadataVersion=1.0\nminCompileSdk=36\n")
        for r, _, fs in os.walk(res):
            for f in sorted(fs):
                p = os.path.join(r, f)
                rel = os.path.relpath(p, a.clone).replace(os.sep, "/")
                if rel == "res/values/public.xml":
                    z.writestr(rel, pubxml)
                else:
                    z.write(p, rel)
        for r, _, fs in os.walk(os.path.join(a.clone, "assets")):
            for f in sorted(fs):
                p = os.path.join(r, f)
                z.write(p, os.path.relpath(p, a.clone).replace(os.sep, "/"))

    lst = os.path.join(os.path.dirname(os.path.abspath(a.out)), "STRIPPED-CLASSES.txt")
    with open(lst, "w", encoding="utf8") as f:
        f.write("# Classes of the original dex files that are NOT in cloneapp.aar (generated by tools/build-aar.py)\n")
        for why, names in sorted(stripped.items()):
            f.write("\n## %s (%d)\n" % (why, len(names)))
            f.write("\n".join(sorted(names)) + "\n")
        f.write("\n## public.xml entries dropped because the resource is not defined (%d)\n" % len(dropped_pub))
        f.write("\n".join("%s/%s" % x for x in dropped_pub) + "\n")
    print("classes.jar %.1f MB, stripped %d classes, public ids kept %d dropped %d" % (
        len(classes) / 1e6, sum(len(v) for v in stripped.values()), n_pub, len(dropped_pub)))
    print("manifest: %d authorities/permissions, %d permission names, %d launcher filters removed; application attrs removed: %s" % (
        n_auth, n_perm, n_launch, sorted(removed_app)))


if __name__ == "__main__":
    main()
