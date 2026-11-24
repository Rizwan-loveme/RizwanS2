#!/usr/bin/env python3
"""
Part 2 of the Seal plan: copies Seal's sources into :seal / :seal-color and gives every Seal resource the prefix "sl_".

Usage (from the project root, UPSTREAM = a checkout of https://github.com/JunkFood02/Seal at the commit in seal/UPSTREAM_COMMIT):
    python3 -I seal/tools/import-upstream.py UPSTREAM

What it does (the same prefix idea as pp_ in :ppsspp, mm_ in :mame, ra_ in :retroarch):
  * app/src/main/java  -> seal/src/main/java          (package com.junkfood.seal kept)
  * app/src/main/res   -> seal/src/main/res           (names of string / plurals / drawable / mipmap / color / xml resources get "sl_";
                                                       files are renamed, <string name=...>, @type/name references and R.type.name in Kotlin follow;
                                                       styles Theme.Seal / Theme.Seal.Dialog keep their names: unique in the whole project)
  * app/schemas        -> seal/schemas                (Room schema history 1..5)
  * app/proguard-rules -> seal/consumer-rules.pro (+ the keep rules of :color)
  * app/AndroidManifest.xml -> seal/reference/AndroidManifest.upstream.xml  (reference only, NOT merged; part 5 writes the real manifest)
  * color/src/main/java -> seal-color/src/main/java
  * seal/tools/win11_patches.py: the source edits Win11 needs, applied after the copy (so a re-import reproduces the tree exactly):
      string patches (part 3: OkHttp 4.12 `Response.body` is nullable -> `!!`; part 4: Seal self-update removed from the screens),
      DROP files (part 4: AppUpdater, UpdateDialog, UpdatePage) and OVERLAY files from seal/tools/overlay/ (part 4: SealInit, App, UpdateUtil).
Nothing else is copied (see seal/README.md, "what goes into the project").
"""
import os, re, shutil, sys

if len(sys.argv) != 2:
    sys.exit(__doc__)
UP = os.path.abspath(sys.argv[1])
HERE = os.path.dirname(os.path.abspath(__file__))
ROOT = os.path.abspath(os.path.join(HERE, "..", ".."))
SEAL = os.path.join(ROOT, "seal")
COLOR = os.path.join(ROOT, "seal-color")
PFX = "sl_"
TYPES = ("string", "plurals", "drawable", "mipmap", "color", "xml")  # renamed resource types

def rd(p):
    with open(p, encoding="utf-8") as f: return f.read()
def wr(p, s):
    os.makedirs(os.path.dirname(p), exist_ok=True)
    with open(p, "w", encoding="utf-8", newline="") as f: f.write(s)

for d in (os.path.join(SEAL, "src"), os.path.join(SEAL, "schemas"), os.path.join(SEAL, "reference"), os.path.join(COLOR, "src")):
    shutil.rmtree(d, ignore_errors=True)

# ---- Seal's OWN resource names per type (a reference to anything else, e.g. R.string.abc_action_mode_done from appcompat, must stay untouched)
own = {t: set() for t in TYPES}
res_in = os.path.join(UP, "app/src/main/res")
rx_decl = re.compile(r'<(string|plurals|color)\b[^>]*?\bname="([A-Za-z0-9_]+)"')
for dp, _, fs in os.walk(res_in):
    typ = os.path.relpath(dp, res_in).split(os.sep)[0].split("-")[0]
    for f in fs:
        if typ in ("drawable", "mipmap", "xml"):
            own[typ].add(os.path.splitext(f)[0])
        elif typ == "values":
            for t, n in rx_decl.findall(rd(os.path.join(dp, f))):
                own[t].add(n)

def pfx_ref(m, form):
    t, n = m.group(1), m.group(2)
    if n not in own[t]:
        return m.group(0)
    return form % (t, PFX + n)

# ---- Kotlin: R.<type>.<name> -> R.<type>.sl_<name>
rx_kt = re.compile(r"\bR\.(%s)\.([A-Za-z0-9_]+)" % "|".join(TYPES))
n_kt = 0
src_java = os.path.join(UP, "app/src/main/java")
for dp, _, fs in os.walk(src_java):
    for f in fs:
        sp = os.path.join(dp, f)
        dst = os.path.join(SEAL, "src/main/java", os.path.relpath(sp, src_java))
        if f.endswith(".kt"):
            s = rd(sp)
            s2, k = rx_kt.subn(lambda m: pfx_ref(m, "R.%s.%s"), s)
            n_kt += k
            wr(dst, s2)
        else:
            os.makedirs(os.path.dirname(dst), exist_ok=True); shutil.copy2(sp, dst)

# ---- resources
rx_ref = re.compile(r"@(%s)/([A-Za-z0-9_]+)" % "|".join(TYPES))
rx_name = re.compile(r'(<(string|plurals|string-array|color)\b[^>]*?\bname=")([A-Za-z0-9_]+)(")')
n_files = n_names = 0
for dp, _, fs in os.walk(res_in):
    rel = os.path.relpath(dp, res_in)
    top = rel.split(os.sep)[0]
    typ = top.split("-")[0]
    for f in fs:
        sp = os.path.join(dp, f)
        if typ in ("drawable", "mipmap", "xml"):
            base, ext = os.path.splitext(f)
            nf = PFX + base + ext
            n_files += 1
            if ext == ".xml":
                s = rx_ref.sub(lambda m: pfx_ref(m, "@%s/%s"), rd(sp))
                wr(os.path.join(SEAL, "src/main/res", rel, nf), s)
            else:
                dst = os.path.join(SEAL, "src/main/res", rel, nf)
                os.makedirs(os.path.dirname(dst), exist_ok=True); shutil.copy2(sp, dst)
        elif typ == "values":
            s = rd(sp)
            s, k = rx_name.subn(lambda m: m.group(1) + PFX + m.group(3) + m.group(4), s)
            n_names += k
            s = rx_ref.sub(lambda m: pfx_ref(m, "@%s/%s"), s)
            wr(os.path.join(SEAL, "src/main/res", rel, f), s)
        else:  # resources.properties and anything else sits next to res/
            dst = os.path.join(SEAL, "src/main/res", rel, f)
            os.makedirs(os.path.dirname(dst), exist_ok=True); shutil.copy2(sp, dst)

# ---- schemas, rules, reference manifest, color module
shutil.copytree(os.path.join(UP, "app/schemas"), os.path.join(SEAL, "schemas"))
wr(os.path.join(SEAL, "reference/AndroidManifest.upstream.xml"), rd(os.path.join(UP, "app/src/main/AndroidManifest.xml")))
rules = "# Seal (:seal) — from upstream app/proguard-rules.pro and color/proguard-rules.pro (only a safety net: :app does not minify)\n"
rules += rd(os.path.join(UP, "app/proguard-rules.pro")).rstrip() + "\n\n" + rd(os.path.join(UP, "color/proguard-rules.pro")).rstrip() + "\n"
wr(os.path.join(SEAL, "consumer-rules.pro"), rules)
shutil.copytree(os.path.join(UP, "color/src/main/java"), os.path.join(COLOR, "src/main/java"))
print("kotlin refs renamed: %d, resource files renamed: %d, value names renamed: %d" % (n_kt, n_files, n_names))

# ---- Win11 changes on top of the copy (patches, dropped files, overlay files): seal/tools/win11_patches.py (parts 3-5)
sys.path.insert(0, HERE)
import win11_patches
win11_patches.apply(SEAL)
