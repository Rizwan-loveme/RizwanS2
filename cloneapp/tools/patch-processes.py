#!/usr/bin/env python3
"""
Renames the Clone App engine's processes so they cannot collide with the BlackBox engine (:Bcore) of the same app.

Why: both engines declare the stub processes  :p0 ... :p49  (and the Clone App also :hs).  In one merged manifest those names belong to
BOTH engines, so a process started for a BlackBox virtual app could be given to a Clone App stub (or the other way round) and the wrong
engine would run in it.  After this patch the Clone App uses   :chs   and   :cp0 ... :cp49   ; BlackBox keeps :black / :p0 ... :p49.

What it changes inside cloneapp.aar (nothing else is touched, everything is checked before and after):
  1. AndroidManifest.xml : android:process=":hs" -> ":chs"  and  ":pN" -> ":cpN"  (270 attributes).
  2. com/bly/chaosapp/application/BLYApplication.class : the two string constants ":hs" -> ":chs" and ":p" -> ":cp"
     (it decides "which process am I" with  processName.equals(pkg + ":hs")  /  startsWith(pkg + ":p")  and parses the number with
     substring(prefix.length()), so a longer prefix is fine).
  3. cn1.class : the string constant ":hs" -> ":chs" (it compares process names of running processes with pkg + ":hs").
Constant-pool Utf8 entries are rewritten in place (all references are by index, so the length change is safe).

Usage:   python3 cloneapp/tools/patch-processes.py cloneapp/cloneapp.aar        (idempotent: running it twice changes nothing)
Python 3 only, no dependencies.
"""
import io
import re
import struct
import sys
import zipfile

CLASS_PATCHES = {
    "com/bly/chaosapp/application/BLYApplication.class": {b":hs": b":chs", b":p": b":cp"},
    "cn1.class": {b":hs": b":chs"},
}


def patch_class(data, repl):
    """Returns (new_bytes, {old: count}) after replacing whole Utf8 constants that equal a key of repl."""
    n = struct.unpack(">H", data[8:10])[0]
    p, i = 10, 1
    out = bytearray(data[:10])
    done = {}
    while i < n:
        tag = data[p]
        if tag == 1:
            ln = struct.unpack(">H", data[p + 1:p + 3])[0]
            val = data[p + 3:p + 3 + ln]
            if val in repl:
                new = repl[val]
                out += b"\x01" + struct.pack(">H", len(new)) + new
                done[val] = done.get(val, 0) + 1
            else:
                out += data[p:p + 3 + ln]
            p += 3 + ln
        else:
            size = {3: 5, 4: 5, 9: 5, 10: 5, 11: 5, 12: 5, 17: 5, 18: 5, 5: 9, 6: 9,
                    7: 3, 8: 3, 16: 3, 19: 3, 20: 3, 15: 4}[tag]
            out += data[p:p + size]
            p += size
            if tag in (5, 6):
                i += 1
        i += 1
    out += data[p:]
    return bytes(out), done


def patch_manifest(text):
    text, a = re.subn(r'android:process=":hs"', 'android:process=":chs"', text)
    text, b = re.subn(r'android:process=":p(\d+)"', r'android:process=":cp\1"', text)
    return text, a, b


def main():
    if len(sys.argv) != 2:
        sys.exit(__doc__)
    path = sys.argv[1]
    src = zipfile.ZipFile(path)
    manifest = src.read("AndroidManifest.xml").decode("utf-8")
    if 'android:process=":chs"' in manifest:
        print("already patched, nothing to do")
        return
    manifest, n_hs, n_p = patch_manifest(manifest)
    assert n_hs > 0 and n_p > 0, "no :hs / :pN process attributes found"
    assert not re.search(r'android:process=":(hs|p\d+)"', manifest)

    jar_in = zipfile.ZipFile(io.BytesIO(src.read("classes.jar")))
    jar_buf = io.BytesIO()
    with zipfile.ZipFile(jar_buf, "w", zipfile.ZIP_DEFLATED) as jar_out:
        for info in jar_in.infolist():
            data = jar_in.read(info.filename)
            if info.filename in CLASS_PATCHES:
                data, done = patch_class(data, CLASS_PATCHES[info.filename])
                assert set(done) == set(CLASS_PATCHES[info.filename]), (info.filename, done)
                print("patched", info.filename, {k.decode(): v for k, v in done.items()})
            jar_out.writestr(info, data)

    tmp = path + ".tmp"
    with zipfile.ZipFile(tmp, "w", zipfile.ZIP_DEFLATED) as dst:
        for info in src.infolist():
            if info.filename == "AndroidManifest.xml":
                dst.writestr(info, manifest.encode("utf-8"))
            elif info.filename == "classes.jar":
                dst.writestr(info, jar_buf.getvalue())
            else:
                dst.writestr(info, src.read(info.filename))
    import os
    os.replace(tmp, path)
    print("manifest: %d x :hs -> :chs, %d x :pN -> :cpN" % (n_hs, n_p))


if __name__ == "__main__":
    main()
