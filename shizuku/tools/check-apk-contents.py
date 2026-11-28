#!/usr/bin/env python3
"""Row 8D-1: looks into a BUILT APK and requires what the Shizuku manager (:shizuku) needs inside it. No Gradle, no network; reads the APK with python's zipfile only.

Usage:   python3 -I shizuku/tools/check-apk-contents.py app-release.apk [--abis a,b,...] [--list] [--strict-align]
         python3 -I shizuku/tools/check-apk-contents.py --self-test        (builds small fake APKs in a temp folder; needs no APK of the project)

What is required (every problem is one `::error::` line; all problems are printed, then exit 1):
  1. Native libraries. For EVERY ABI that has any lib/<abi>/*.so in the APK (or exactly the ABIs of --abis; then each must be present) the three files
         lib/<abi>/libshizuku.so   the starter (run by the shell / root user from nativeLibraryDir)        built by :shizuku  (CMake, 3E)
         lib/<abi>/libadb.so       ADB pairing                                                             built by :shizuku  (CMake, 3E)
         lib/<abi>/librish.so      the rish pty bridge                                                     built by :shizuku-rish (CMake, 3D)
     must be there, non-empty, a real ELF file of the right machine type (arm64-v8a = AArch64, armeabi-v7a = ARM, x86 = Intel 80386, x86_64 = x86-64, class 32 / 64 bit to match),
     and stored EXTRACTABLE. See "Stored or deflated" below. An ABI that ships other libraries but not these three is the failure 5B-2 warned about: a device that picks that ABI installs
     the app fine and the starter is missing.
  2. Assets. assets/rish (upstream's rish shell script) and assets/rish_shizuku.dex (the dex of :shizuku-shell, task shizukuRishDex of 3E), both non-empty; the dex must start with the dex
     magic ("dex\\n" + 3 digits + NUL), and its header size / file size field must equal the real size (one dex, as app_process starts it). The "starter" of the plan is lib/<abi>/libshizuku.so
     (1.), not an asset: upstream's manager has no asset of that name.
  3. At least one ABI with native libraries is in the APK (an APK with no lib/ at all cannot be a Win11 APK).

Stored or deflated (correction of the 8D-1 wording "stored extracted"): the host extracts native libraries (`useLegacyPackaging = true` in app/build.gradle.kts and
android:extractNativeLibs="true", row 5B-2). With that, AGP writes the .so files COMPRESSED (deflated) into the APK and the installer extracts them to nativeLibraryDir, where the
starter can be executed as a file. A .so that is STORED (not compressed) is what AGP writes when extractNativeLibs is off: it is page-aligned inside the APK and mapped from there,
so there is NO file in nativeLibraryDir to run. So the check requires "deflated" (anything but method 0). This is also what the other native files of the project look like in the same
APK. It is a proxy: the final word is the `extractNativeLibs` attribute in the APK's manifest, which is binary XML and part of row 8D-2.

Warning only (never an exit 1 unless --strict-align): for arm64-v8a and x86_64, a PT_LOAD segment with p_align below 16 KB (0x4000): targetSdk 37 devices with 16 KB pages need that
(NDK 29 does it by default; the check reads the program headers of the extracted library bytes).

Exit: 0 = nothing wrong, 1 = at least one problem, 2 = the APK is missing / not a zip / bad arguments.
Needs only python3. The workflows call it on the built APK since rows 8D-2 / 8F; `check-all.py` runs its --self-test (step S10, row 10A), never a real APK.
"""
import argparse
import contextlib
import io
import os
import struct
import sys
import tempfile
import shutil
import zipfile

LIBS = ("libshizuku.so", "libadb.so", "librish.so")
ASSETS = ("assets/rish", "assets/rish_shizuku.dex")
# abi -> (ELF class, e_machine)
ABI_ELF = {
    "arm64-v8a": (2, 183),
    "armeabi-v7a": (1, 40),
    "x86": (1, 3),
    "x86_64": (2, 62),
}
MACHINE_NAME = {183: "AArch64", 40: "ARM", 3: "Intel 80386", 62: "x86-64"}
ALIGN_ABIS = ("arm64-v8a", "x86_64")
PAGE16K = 0x4000
PT_LOAD = 1


def elf_info(data):
    """-> (elf_class, machine, min_load_align or None) or None if `data` is not a usable ELF header."""
    if len(data) < 52 or data[:4] != b"\x7fELF":
        return None
    cls, endian = data[4], data[5]
    if cls not in (1, 2) or endian != 1:          # all Android ABIs are little endian
        return None
    machine = struct.unpack_from("<H", data, 18)[0]
    aligns = []
    try:
        if cls == 2:
            phoff = struct.unpack_from("<Q", data, 32)[0]
            phentsize, phnum = struct.unpack_from("<HH", data, 54)
            for i in range(phnum):
                off = phoff + i * phentsize
                p_type = struct.unpack_from("<I", data, off)[0]
                if p_type == PT_LOAD:
                    aligns.append(struct.unpack_from("<Q", data, off + 48)[0])
        else:
            phoff = struct.unpack_from("<I", data, 28)[0]
            phentsize, phnum = struct.unpack_from("<HH", data, 42)
            for i in range(phnum):
                off = phoff + i * phentsize
                p_type = struct.unpack_from("<I", data, off)[0]
                if p_type == PT_LOAD:
                    aligns.append(struct.unpack_from("<I", data, off + 28)[0])
    except struct.error:
        aligns = []                                # header cut short: class and machine are still reported
    return cls, machine, (min(aligns) if aligns else None)


def check(apk, abis_wanted=None, strict_align=False, out=print):
    """Returns (errors, warnings, rows). rows = list of (abi, name, method, size, note) for --list."""
    errors, warnings, rows = [], [], []
    try:
        zf = zipfile.ZipFile(apk)
    except (OSError, zipfile.BadZipFile) as e:
        raise SystemExit(f"::error::check-apk-contents: {apk} is not a readable APK / zip file ({e})") from None
    with zf:
        infos = {i.filename: i for i in zf.infolist() if not i.filename.endswith("/")}
        shipped = sorted({n.split("/")[1] for n in infos if n.startswith("lib/") and n.count("/") >= 2 and n.endswith(".so")})
        if abis_wanted:
            abis = list(abis_wanted)
            for a in abis:
                if a not in shipped:
                    errors.append(f"lib/{a}/ has no native library in the APK (ABI asked for with --abis, not shipped)")
            abis = [a for a in abis if a in shipped]
        else:
            abis = shipped
            if not abis:
                errors.append("the APK has no lib/<abi>/*.so at all (no native library of any ABI)")
        for abi in abis:
            if abi not in ABI_ELF:
                errors.append(f"lib/{abi}/: unknown ABI name (expected one of {', '.join(sorted(ABI_ELF))})")
                continue
            want_cls, want_machine = ABI_ELF[abi]
            for lib in LIBS:
                name = f"lib/{abi}/{lib}"
                info = infos.get(name)
                if info is None:
                    errors.append(f"{name} is not in the APK ({'the module did not build this ABI' if abi in shipped else 'ABI missing'}: "
                                  f"a device that uses {abi} would install the app and have no Shizuku starter)")
                    continue
                if info.file_size == 0:
                    errors.append(f"{name} is empty (0 bytes)")
                    continue
                method = "stored" if info.compress_type == zipfile.ZIP_STORED else "deflated"
                note = ""
                if info.compress_type == zipfile.ZIP_STORED:
                    errors.append(f"{name} is STORED (not compressed) in the APK: with extractNativeLibs on it must be deflated and extracted at install; "
                                  f"stored means it is mapped from the APK and nativeLibraryDir has no file for the starter to run "
                                  f"(check useLegacyPackaging = true in app/build.gradle.kts and android:extractNativeLibs=\"true\")")
                data = zf.read(info)
                e = elf_info(data)
                if e is None:
                    errors.append(f"{name} is not a little-endian ELF file (first bytes {data[:4].hex()})")
                    note = "not ELF"
                else:
                    cls, machine, align = e
                    note = f"ELF{32 if cls == 1 else 64} {MACHINE_NAME.get(machine, machine)}"
                    if machine != want_machine or cls != want_cls:
                        errors.append(f"{name} is {note}, but lib/{abi}/ needs ELF{32 if want_cls == 1 else 64} {MACHINE_NAME[want_machine]} "
                                      f"(a library of another ABI was packed under this name)")
                    if abi in ALIGN_ABIS and align is not None and align < PAGE16K:
                        msg = f"{name}: PT_LOAD alignment is {align:#x}, below 16 KB (0x4000): not loadable on 16 KB page devices at targetSdk 37"
                        (errors if strict_align else warnings).append(msg)
                        note += f", align {align:#x}"
                rows.append((abi, lib, method, info.file_size, note))
        for name in ASSETS:
            info = infos.get(name)
            if info is None:
                errors.append(f"{name} is not in the APK ({'upstream manager assets/rish missing' if name.endswith('rish') else 'task shizukuRishDex of :shizuku did not deliver it'})")
                continue
            if info.file_size == 0:
                errors.append(f"{name} is empty (0 bytes)")
                continue
            note = ""
            if name.endswith(".dex"):
                data = zf.read(info)
                magic_ok = len(data) >= 112 and data[:4] == b"dex\n" and data[4:7].isdigit() and data[7] == 0
                if not magic_ok:
                    errors.append(f"{name} does not start with a dex header (first bytes {data[:8].hex()})")
                    note = "no dex magic"
                else:
                    (file_size,) = struct.unpack_from("<I", data, 32)
                    note = f"dex {data[4:7].decode()}"
                    if file_size != len(data):
                        errors.append(f"{name}: dex header says {file_size} bytes, the file has {len(data)} (not one whole dex file)")
            rows.append(("assets", name[len("assets/"):], "stored" if info.compress_type == zipfile.ZIP_STORED else "deflated", info.file_size, note))
    return errors, warnings, rows


def run(apk, abis_wanted, strict_align, show_list):
    if not os.path.isfile(apk):
        print(f"::error::check-apk-contents: {apk} does not exist")
        return 2
    try:
        errors, warnings, rows = check(apk, abis_wanted, strict_align)
    except SystemExit as e:
        print(e.code)
        return 2
    if show_list or not errors:
        for abi, name, method, size, note in rows:
            print(f"   {abi:<12} {name:<18} {method:<8} {size:>10}  {note}")
    for w in warnings:
        print(f"::warning::{w}")
    for e in errors:
        print(f"::error::{e}")
    if errors:
        print(f"check-apk-contents: {len(errors)} problem(s)")
        return 1
    abis = sorted({r[0] for r in rows if r[0] != "assets"})
    print(f"check-apk-contents: ok ({', '.join(abis)}: {', '.join(LIBS)}; assets: rish, rish_shizuku.dex)")
    return 0


# ------------------------------------------------------------------ self-test
def fake_elf(abi, align=PAGE16K, size=256):
    cls, machine = ABI_ELF[abi]
    b = bytearray(size)
    b[0:4] = b"\x7fELF"
    b[4], b[5], b[6] = cls, 1, 1
    struct.pack_into("<H", b, 18, machine)
    if cls == 2:
        struct.pack_into("<Q", b, 32, 64)
        struct.pack_into("<HH", b, 54, 56, 1)
        struct.pack_into("<I", b, 64, PT_LOAD)
        struct.pack_into("<Q", b, 64 + 48, align)
    else:
        struct.pack_into("<I", b, 28, 52)
        struct.pack_into("<HH", b, 42, 32, 1)
        struct.pack_into("<I", b, 52, PT_LOAD)
        struct.pack_into("<I", b, 52 + 28, align)
    return bytes(b)


def fake_dex(size=200, claimed=None):
    b = bytearray(size)
    b[0:8] = b"dex\n039\x00"
    struct.pack_into("<I", b, 32, size if claimed is None else claimed)
    return bytes(b)


def make_apk(path, abis=("arm64-v8a", "armeabi-v7a", "x86", "x86_64"), drop=(), stored=(), override=None, extra=None):
    """A good fake APK, then `drop` names removed, `stored` names written uncompressed, `override` name -> bytes, `extra` more files."""
    files = {}
    for abi in abis:
        files[f"lib/{abi}/libmikarun.so"] = fake_elf(abi)
        for lib in LIBS:
            files[f"lib/{abi}/{lib}"] = fake_elf(abi)
    files["assets/rish"] = b"#!/system/bin/sh\nexec app_process ...\n"
    files["assets/rish_shizuku.dex"] = fake_dex()
    files["classes.dex"] = fake_dex(500)
    files.update(extra or {})
    files.update(override or {})
    for d in drop:
        files.pop(d, None)
    with zipfile.ZipFile(path, "w") as z:
        for name, data in files.items():
            z.writestr(name, data, compress_type=zipfile.ZIP_STORED if name in stored else zipfile.ZIP_DEFLATED)


def _quiet(fn):
    with contextlib.redirect_stdout(io.StringIO()):
        return fn()


def self_test():
    tmp = tempfile.mkdtemp(prefix="apk-contents-")
    total = fails = 0

    def case(label, expect_errors, expect_warn=0, abis=None, strict=False, needle=None, **kw):
        nonlocal total, fails
        total += 1
        p = os.path.join(tmp, f"c{total}.apk")
        make_apk(p, **kw)
        errors, warnings, _ = check(p, abis, strict)
        ok = (len(errors) == expect_errors and len(warnings) == expect_warn and (needle is None or any(needle in e for e in errors)))
        if not ok:
            fails += 1
            print(f"  FAIL: {label}: errors={len(errors)} (want {expect_errors}), warnings={len(warnings)} (want {expect_warn}); {errors[:2]}")

    try:
        case("good, all four ABIs", 0)
        # a build with apk_abis (one ABI only)
        total += 1
        p = os.path.join(tmp, "one.apk")
        make_apk(p, abis=("arm64-v8a",))
        e, w, _ = check(p)
        if e or w:
            fails += 1
            print(f"  FAIL: good APK with only arm64-v8a: {e} {w}")
        total += 1
        e, w, _ = check(p, ["arm64-v8a"])
        if e or w:
            fails += 1
            print(f"  FAIL: --abis arm64-v8a on it: {e} {w}")
        total += 1
        e, w, _ = check(p, ["arm64-v8a", "x86_64"])
        if len(e) != 1 or "x86_64" not in e[0]:
            fails += 1
            print(f"  FAIL: --abis asks for an ABI that is not shipped: {e}")
        # each of the three libs missing, in one ABI
        for lib in LIBS:
            case(f"{lib} missing in arm64-v8a", 1, drop=(f"lib/arm64-v8a/{lib}",), needle=lib)
        case("libshizuku.so missing in one of four ABIs only", 1, drop=("lib/x86/libshizuku.so",), needle="lib/x86/libshizuku.so")
        case("all three missing in armeabi-v7a (other libs stay)", 3, drop=tuple(f"lib/armeabi-v7a/{l}" for l in LIBS))
        case("no Shizuku libs at all (module off APK)", 12, drop=tuple(f"lib/{a}/{l}" for a in ABI_ELF for l in LIBS))
        # stored
        case("libshizuku.so stored", 1, stored=("lib/arm64-v8a/libshizuku.so",), needle="STORED")
        case("all three stored in one ABI", 3, stored=tuple(f"lib/x86_64/{l}" for l in LIBS))
        # content
        case("empty library", 1, override={"lib/arm64-v8a/libadb.so": b""}, needle="empty")
        case("not an ELF", 1, override={"lib/arm64-v8a/librish.so": b"hello world" * 10}, needle="not a little-endian ELF")
        case("ELF of another ABI under the name", 1, override={"lib/arm64-v8a/libshizuku.so": fake_elf("x86_64")}, needle="AArch64")
        case("32-bit ELF in a 64-bit ABI dir", 1, override={"lib/arm64-v8a/libshizuku.so": fake_elf("armeabi-v7a")}, needle="needs ELF64")
        case("64-bit ELF in armeabi-v7a", 1, override={"lib/armeabi-v7a/libadb.so": fake_elf("arm64-v8a")}, needle="needs ELF32")
        case("4 KB alignment on arm64 is a warning", 0, expect_warn=1, override={"lib/arm64-v8a/libshizuku.so": fake_elf("arm64-v8a", align=0x1000)})
        case("4 KB alignment on arm64 with --strict-align", 1, strict=True, override={"lib/arm64-v8a/libshizuku.so": fake_elf("arm64-v8a", align=0x1000)}, needle="16 KB")
        case("4 KB alignment on 32-bit ABI is not looked at", 0, override={"lib/armeabi-v7a/libshizuku.so": fake_elf("armeabi-v7a", align=0x1000)})
        # assets
        case("assets/rish missing", 1, drop=("assets/rish",), needle="assets/rish")
        case("rish_shizuku.dex missing", 1, drop=("assets/rish_shizuku.dex",), needle="rish_shizuku.dex")
        case("assets/rish empty", 1, override={"assets/rish": b""}, needle="empty")
        case("dex without magic", 1, override={"assets/rish_shizuku.dex": b"PK" * 100}, needle="dex header")
        case("dex whose header size differs", 1, override={"assets/rish_shizuku.dex": fake_dex(200, claimed=150)}, needle="header says")
        case("both assets missing", 2, drop=("assets/rish", "assets/rish_shizuku.dex"))
        case("rish stored is fine (a text asset)", 0, stored=("assets/rish",))
        # whole APK
        total += 1
        p = os.path.join(tmp, "nolib.apk")
        make_apk(p, abis=())
        e, _, _ = check(p)
        if not any("no lib/<abi>/*.so" in x for x in e):
            fails += 1
            print(f"  FAIL: APK without lib/: {e}")
        total += 1
        p = os.path.join(tmp, "notzip.apk")
        with open(p, "wb") as f:
            f.write(b"not a zip")
        try:
            check(p)
            fails += 1
            print("  FAIL: a non-zip file did not stop the check")
        except SystemExit as ex:
            if "not a readable APK" not in str(ex.code):
                fails += 1
                print(f"  FAIL: non-zip message: {ex.code}")
        total += 1
        if _quiet(lambda: run(os.path.join(tmp, "missing.apk"), None, False, False)) != 2:
            fails += 1
            print("  FAIL: missing file must exit 2")
        total += 1
        good = os.path.join(tmp, "good.apk")
        make_apk(good)
        if _quiet(lambda: run(good, None, False, False)) != 0:
            fails += 1
            print("  FAIL: run() on a good APK must exit 0")
        total += 1
        bad = os.path.join(tmp, "bad.apk")
        make_apk(bad, drop=("lib/x86/librish.so",))
        if _quiet(lambda: run(bad, None, False, False)) != 1:
            fails += 1
            print("  FAIL: run() on a bad APK must exit 1")
        total += 1
        # an ABI name that is not one of the four
        p = os.path.join(tmp, "odd.apk")
        make_apk(p, extra={"lib/mips/libfoo.so": fake_elf("x86")})
        e, _, _ = check(p)
        if not any("unknown ABI" in x for x in e):
            fails += 1
            print(f"  FAIL: unknown ABI directory: {e}")
    finally:
        shutil.rmtree(tmp, ignore_errors=True)
    print(f"check-apk-contents self-test: {total - fails} of {total} cases ok" + ("" if not fails else " - FAILED"))
    return 1 if fails else 0


def main():
    ap = argparse.ArgumentParser(description="row 8D-1: require the Shizuku native libraries and assets in a built APK")
    ap.add_argument("apk", nargs="?")
    ap.add_argument("--abis", default="", help="comma separated: these ABIs must be in the APK and complete (default: every ABI that has native libraries)")
    ap.add_argument("--list", action="store_true", help="print the found files (always printed when everything is fine)")
    ap.add_argument("--strict-align", action="store_true", help="make the 16 KB alignment warning an error")
    ap.add_argument("--self-test", action="store_true")
    a = ap.parse_args()
    if a.self_test:
        return self_test()
    if not a.apk:
        ap.print_usage(sys.stderr)
        return 2
    abis = [x.strip() for x in a.abis.split(",") if x.strip()]
    return run(a.apk, abis or None, a.strict_align, a.list)


if __name__ == "__main__":
    sys.exit(main())
