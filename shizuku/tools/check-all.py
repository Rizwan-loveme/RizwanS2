#!/usr/bin/env python3
"""Shizuku step 4F-3 (S8 - S11 added in row 10A): runs every Shizuku check in one go, the way the root check (mika/tools/static-check.py, check 11) and a person do.

Usage:
  python3 -I shizuku/tools/check-all.py [-v] [--no-real | --require-real] [--root DIR] [--timeout SECONDS]
  python3 -I shizuku/tools/check-all.py --list          the steps, in the order they run
  python3 -I shizuku/tools/check-all.py --self-test     the self-test of this script (stub scripts in a temp folder; touches nothing of the project)

Needs only python3. No Gradle, no network. It never changes a file of the project (the helper scripts write only into temp folders). Each step is one helper script run as its own
process through `python3 -I -B`, with the project root as the working folder; ALL steps run even after one failed, so one run shows every problem.

Steps (ids are stable, `--list` prints them):
  S1 gradle           check-gradle.py                          static rules of the Gradle side incl. 4F-1 (overlay, wiring, src/main, 7 helper runs)       always
  S2 gradle-self      check-gradle.py --self-test              its 70 cases                                                                                    always
  S3 manifest-self    test-check-merged-manifest.py --no-real  the self-test of the merged-manifest checker (147 cases, 19 rules covered)                      always
  S4 provider-self    check-provider-match.py --self-test      its 17 cases                                                                                    always
  S5 provider-real    check-provider-match.py                  the REAL patched manifests of Shizuku and Mika (4B-3)                                           only if a fetched manifest exists
  S6 patch-real       patch-upstream.py --check                the patch self-check on the patched Shizuku checkout                                            only if the checkout is patched
  S7 manifest-real    check-merged-manifest.py --variant V     the 19 rules on the real merged manifest of a Gradle build (V = release, debug: each that exists)   only if app/build has one
  S8 patch-self       test-patch-host-package.py               the patch rules on hand-made files (224 cases; added in row 10A)                                 always
  S9 sweep-self       sweep-package-strings.py --self-test     the package-string sweep on hand-made files (37 cases; row 10A)                                  always
  S10 apk-self        check-apk-contents.py --self-test        the APK-content check on hand-made APKs (33 cases; row 10A)                                     always
  S11 sweep-real      sweep-package-strings.py                 the sweep on the patched Shizuku checkout (exit 2 = no checkout = skip; row 10A)                 only if the checkout is patched
S5 - S7 and S11 need things that are not in the project zip (the fetched sources, a Gradle build). Without them the step is SKIPPED with a note, so a bare checkout is green; --require-real turns
every skip into a failure (for a CI step after fetch + patch + build); --no-real skips S5 - S7 and S11 even if their inputs exist. Folders: SHIZUKU_UPSTREAM_DIR / MIKA_UPSTREAM_DIR are honoured like
in the helper scripts. A real step that exits 2 (its input is missing after all) is a skip too, not a failure: only exit 0 is ok, exit 1 is a failure.

Output: one line per step (`ok`, `FAIL` or `skip`), for a failed step one `::error::shizuku checks: [Sn] ...` line with the exit code and the last lines of its output, then a summary line.
Exit code: 0 every step ok or skipped; 1 at least one step failed (a rule, a missing script or a timeout); 2 the script could not run (bad option, no shizuku/tools under the root).
"""
import argparse
import os
import shutil
import subprocess
import sys
import tempfile

HERE = os.path.dirname(os.path.abspath(__file__))
ROOT = os.path.abspath(os.path.join(HERE, "..", ".."))
TIMEOUT = 600          # seconds per step; check-gradle.py --self-test is the slowest, a few seconds
TAIL = 12              # lines of a failed step's output that are printed

# (id, short name, script under shizuku/tools, arguments, kind, what it is)  kind: always | provider | patch | sweep | manifest
STEPS = [
    ("S1", "gradle",          "check-gradle.py",                 [],                  "always",   "static rules of the Gradle side"),
    ("S2", "gradle-self",     "check-gradle.py",                 ["--self-test"],     "always",   "self-test of check-gradle.py"),
    ("S3", "manifest-self",   "test-check-merged-manifest.py",   ["--no-real"],       "always",   "self-test of check-merged-manifest.py"),
    ("S4", "provider-self",   "check-provider-match.py",         ["--self-test"],     "always",   "self-test of check-provider-match.py"),
    ("S5", "provider-real",   "check-provider-match.py",         [],                  "provider", "provider match on the real patched manifests"),
    ("S6", "patch-real",      "patch-upstream.py",               ["--check"],         "patch",    "patch self-check on the patched checkout"),
    ("S7", "manifest-real",   "check-merged-manifest.py",        [],                  "manifest", "rules on the real merged manifest"),
    ("S8", "patch-self",      "test-patch-host-package.py",      [],                  "always",   "self-test of the patch rules on hand-made files (row 10A)"),
    ("S9", "sweep-self",      "sweep-package-strings.py",        ["--self-test"],     "always",   "self-test of the package-string sweep (row 10A)"),
    ("S10", "apk-self",       "check-apk-contents.py",           ["--self-test"],     "always",   "self-test of the APK-content check (row 10A)"),
    ("S11", "sweep-real",     "sweep-package-strings.py",        [],                  "sweep",    "package-string sweep on the patched checkout (row 10A)"),
]


class Setup(Exception):
    """The script could not run (exit 2)."""


def upstream_dirs(root, env):
    s = env.get("SHIZUKU_UPSTREAM_DIR") or os.path.join(root, "shizuku", "upstream")
    m = env.get("MIKA_UPSTREAM_DIR") or os.path.join(root, "mika", "upstream")
    return s, m


def merged_variants(root):
    """Variants (release, debug) that have a merged manifest under app/build/intermediates: the same test as check-merged-manifest.py."""
    base = os.path.join(root, "app", "build", "intermediates")
    found = []
    if not os.path.isdir(base):
        return found
    for v in ("release", "debug"):
        needle = "merged_manifests/" + v
        hit = False
        for d, _dirs, files in os.walk(base):
            if "AndroidManifest.xml" in files and needle in os.path.join(d, "AndroidManifest.xml").replace(os.sep, "/"):
                hit = True
                break
        if hit:
            found.append(v)
    return found


def real_inputs(kind, root, env):
    """For a real step: (runs?, [argument lists], why not)."""
    s_up, m_up = upstream_dirs(root, env)
    if kind == "provider":
        mika = os.path.join(m_up, "app", "src", "main", "AndroidManifest.xml")
        mgr = os.path.join(s_up, "manager", "src", "main", "AndroidManifest.xml")
        if os.path.isfile(mika) or os.path.isfile(mgr):
            return True, [[]], ""
        return False, [], "no fetched Shizuku / Mika manifest (run shizuku/tools/fetch-upstream.sh + patch-upstream.sh and the Mika ones first)"
    if kind in ("patch", "sweep"):
        if not os.path.isfile(os.path.join(s_up, "settings.gradle")):
            return False, [], "Shizuku source not fetched (run shizuku/tools/fetch-upstream.sh first)"
        if not os.path.isfile(os.path.join(s_up, ".win11-patched")):
            return False, [], "Shizuku source fetched but not patched (run shizuku/tools/patch-upstream.sh first)"
        return True, ([["--check"]] if kind == "patch" else [[]]), ""
    if kind == "manifest":
        vs = merged_variants(root)
        if not vs:
            return False, [], "no merged manifest under app/build/intermediates (run ./gradlew :app:assembleRelease first: Shizuku is on by default since 8F)"
        return True, [["--variant", v, "--root", root] for v in vs], ""
    raise AssertionError(kind)


def run_one(root, script, args, timeout, env):
    """Run one helper script. Returns (exit code or None, output text, problem or '')."""
    path = os.path.join(root, "shizuku", "tools", script)
    if not os.path.isfile(path):
        return None, "", "script not found: shizuku/tools/" + script
    try:
        p = subprocess.run([sys.executable, "-I", "-B", path] + args, cwd=root, env=env, capture_output=True, timeout=timeout)
    except subprocess.TimeoutExpired:
        return None, "", "timed out after %s s" % timeout
    except OSError as e:
        return None, "", "could not start: %s" % e
    return p.returncode, (p.stdout + p.stderr).decode("utf-8", "replace"), ""


def tail(text, n=TAIL):
    lines = [l for l in text.splitlines() if l.strip()]
    return lines[-n:]


def run_checks(root, no_real=False, require_real=False, timeout=TIMEOUT, env=None, out=print, verbose=False):
    """Runs every step. Returns a list of (id, name, status, detail); status is ok, fail or skip. Prints through `out`."""
    env = dict(os.environ if env is None else env)
    results = []

    def report(sid, name, status, detail, output=""):
        results.append((sid, name, status, detail))
        label = {"ok": "ok  ", "fail": "FAIL", "skip": "skip"}[status]
        out("shizuku checks: %s [%s] %s%s" % (label, sid, name, (" - " + detail) if detail else ""))
        if status == "fail":
            out("::error::shizuku checks: [%s] %s: %s" % (sid, name, detail))
            for l in tail(output):
                out("    | " + l)
        elif verbose:
            for l in tail(output, 3):
                out("    | " + l)

    for sid, name, script, args, kind, _what in STEPS:
        if kind == "always":
            runs = [args]
        else:
            if no_real:
                report(sid, name, "skip", "skipped by --no-real")
                continue
            ok_, runs, why = real_inputs(kind, root, env)
            if not ok_:
                if require_real:
                    report(sid, name, "fail", "--require-real: " + why)
                else:
                    report(sid, name, "skip", why)
                continue
        step_bad = ""
        step_out = ""
        last_out = ""
        skipped_missing = 0
        for a in runs:
            code, output, problem = run_one(root, script, a, timeout, env)
            where = (" (%s)" % " ".join(a)) if a else ""
            if problem:
                step_bad, step_out = problem + where, output
                break
            if code == 0:
                last_out = output
                continue
            if code == 2 and kind != "always":
                skipped_missing += 1       # a real step whose input turned out to be missing
                continue
            step_bad, step_out = "exit %s%s" % (code, where), output
            break
        if step_bad:
            report(sid, name, "fail", step_bad, step_out)
        elif skipped_missing and skipped_missing == len(runs):
            if require_real:
                report(sid, name, "fail", "--require-real: the script exited 2 (its input is missing)")
            else:
                report(sid, name, "skip", "the script exited 2 (its input is missing)")
        else:
            report(sid, name, "ok", "%d run(s)" % len(runs) if len(runs) > 1 else "", last_out)
    return results


def summary(results, out=print):
    bad = [r for r in results if r[2] == "fail"]
    nok = sum(1 for r in results if r[2] == "ok")
    nskip = sum(1 for r in results if r[2] == "skip")
    if bad:
        out("shizuku checks FAILED: %d of %d step(s) failed (%s); %d ok, %d skipped" % (len(bad), len(results), ", ".join(r[0] for r in bad), nok, nskip))
        return 1
    out("shizuku checks ok: %d step(s) ran ok, %d skipped (%s)" % (nok, nskip, ", ".join(r[0] for r in results if r[2] == "skip") or "none"))
    return 0


def check_root(root):
    if not os.path.isdir(os.path.join(root, "shizuku", "tools")):
        raise Setup("%s has no shizuku/tools folder: not the project root (use --root)" % root)


def main(argv=None):
    ap = argparse.ArgumentParser(prog="check-all.py", description="Runs every Shizuku check (see the header of the script).")
    ap.add_argument("-v", "--verbose", action="store_true", help="print the last lines of the output of every step")
    ap.add_argument("--no-real", action="store_true", help="skip S5 - S7 and S11 (the steps that need fetched sources or a build) even if their inputs exist")
    ap.add_argument("--require-real", action="store_true", help="a skipped S5 - S7 or S11 is a failure (for a CI step after fetch + patch + build)")
    ap.add_argument("--root", default=ROOT, help="project root (default: %(default)s)")
    ap.add_argument("--timeout", type=int, default=TIMEOUT, help="seconds per step (default %(default)s)")
    ap.add_argument("--list", action="store_true", help="print the steps")
    ap.add_argument("--self-test", action="store_true", help="run the self-test of this script")
    try:
        a = ap.parse_args(argv)
    except SystemExit as e:
        return 0 if e.code in (0, None) else 2
    if a.self_test:
        return self_test()
    if a.list:
        for sid, name, script, args, kind, what in STEPS:
            print("%s  %-14s %-32s %-9s %s" % (sid, name, " ".join([script] + args), kind, what))
        return 0
    try:
        if a.no_real and a.require_real:
            raise Setup("--no-real and --require-real exclude each other")
        if a.timeout < 1:
            raise Setup("--timeout must be at least 1")
        root = os.path.abspath(a.root)
        check_root(root)
    except Setup as e:
        print("::error::shizuku checks: " + str(e))
        return 2
    results = run_checks(root, a.no_real, a.require_real, a.timeout, None, print, a.verbose)
    return summary(results)


# ---------------------------------------------------------------------------------------------------------------- self-test
def self_test():
    """Builds a fake project root of stub scripts in a temp folder and drives run_checks / main on it. 40-odd checks; prints one ::error:: line per failed check."""
    failures = []
    count = [0]
    tmp = tempfile.mkdtemp(prefix="shizuku-check-all-")

    def check(cond, text):
        count[0] += 1
        if not cond:
            failures.append(text)
            print("::error::check-all self-test: " + text)

    names = {"S1": "check-gradle.py", "S2": "check-gradle.py", "S3": "test-check-merged-manifest.py", "S4": "check-provider-match.py",
             "S5": "check-provider-match.py", "S6": "patch-upstream.py", "S7": "check-merged-manifest.py",
             "S8": "test-patch-host-package.py", "S9": "sweep-package-strings.py", "S10": "check-apk-contents.py", "S11": "sweep-package-strings.py"}

    def make_root(name, codes=None, missing=(), outputs=None, sleeps=None):
        """codes: script file name -> exit code (default 0). One stub per script FILE (S1 / S2 and S4 / S5 share a file, so they share a code, which is how the real ones are)."""
        root = os.path.join(tmp, name)
        os.makedirs(os.path.join(root, "shizuku", "tools"))
        log = os.path.join(tmp, name + ".log")
        for f in sorted(set(names.values())):
            if f in missing:
                continue
            code = (codes or {}).get(f, 0)
            line = (outputs or {}).get(f, "stub %s output" % f)
            sl = (sleeps or {}).get(f, 0)
            with open(os.path.join(root, "shizuku", "tools", f), "w") as fh:
                fh.write("import sys, time\nopen(%r, 'a').write(%r + '|' + ' '.join(sys.argv[1:]) + '|iso=' + str(sys.flags.isolated) + '\\n')\n"
                         "time.sleep(%d)\nprint(%r)\nsys.exit(%d)\n" % (log, f, sl, line, code))
        return root, log

    def calls(log):
        return [l.rstrip("\n") for l in open(log)] if os.path.exists(log) else []

    def put(root, rel, text="x"):
        p = os.path.join(root, rel)
        os.makedirs(os.path.dirname(p), exist_ok=True)
        open(p, "w").write(text)

    def tree(root):
        return sorted(os.path.relpath(os.path.join(d, f), root) for d, _x, fs in os.walk(root) for f in fs)

    def go(root, **kw):
        lines = []
        env = {k: v for k, v in os.environ.items() if k not in ("SHIZUKU_UPSTREAM_DIR", "MIKA_UPSTREAM_DIR")}
        env.update(kw.pop("env", {}))
        res = run_checks(root, env=env, out=lines.append, **kw)
        return res, lines

    def status(res):
        return {r[0]: r[2] for r in res}

    try:
        # 1. nothing to check but the seven static steps (S1 - S4, S8 - S10): green, the four real steps (S5 - S7, S11) skipped with a reason
        root, log = make_root("t1")
        before = tree(root)
        res, lines = go(root)
        st = status(res)
        check(all(st[s] == "ok" for s in ("S1", "S2", "S3", "S4", "S8", "S9", "S10")), "1: the static steps run ok on a bare checkout: %s" % st)
        check(all(st[s] == "skip" for s in ("S5", "S6", "S7", "S11")), "1: S5 - S7 and S11 are skipped without inputs: %s" % st)
        check(summary(res, lambda *_: None) == 0, "1: a bare checkout gives exit 0")
        check(any("run shizuku/tools/fetch-upstream.sh" in l for l in lines), "1: a skip says what to run first")
        c = calls(log)
        check(len(c) == 7, "1: exactly seven script runs: %s" % c)
        check(c[4:] == ["test-patch-host-package.py||iso=1", "sweep-package-strings.py|--self-test|iso=1", "check-apk-contents.py|--self-test|iso=1"], "1: S8 - S10 arguments and isolated mode: %s" % c[4:])
        check(c[0] == "check-gradle.py||iso=1" and c[1] == "check-gradle.py|--self-test|iso=1", "1: S1 / S2 arguments and isolated mode: %s" % c[:2])
        check(c[2] == "test-check-merged-manifest.py|--no-real|iso=1" and c[3] == "check-provider-match.py|--self-test|iso=1", "1: S3 / S4 arguments: %s" % c[2:])
        check(tree(root) == before, "1: the project tree is unchanged")

        # 2. a failing static step does not stop the others; message names id, exit code and the last output line
        for f, ids in (("check-gradle.py", ("S1", "S2")), ("test-check-merged-manifest.py", ("S3",)), ("check-provider-match.py", ("S4",)),
                      ("test-patch-host-package.py", ("S8",)), ("sweep-package-strings.py", ("S9",)), ("check-apk-contents.py", ("S10",))):
            root, log = make_root("t2-" + f, codes={f: 1}, outputs={f: "the rule that broke"})
            res, lines = go(root)
            st = status(res)
            check(all(st[i] == "fail" for i in ids), "2: %s exit 1 fails %s: %s" % (f, ids, st))
            check(sum(1 for v in st.values() if v == "fail") == len(ids), "2: %s fails only its own steps: %s" % (f, st))
            check(len(calls(log)) == 7, "2: %s: all seven static steps still ran" % f)
            check(any(l.startswith("::error::shizuku checks: [%s]" % ids[0]) and "exit 1" in l for l in lines), "2: %s: ::error:: line with the exit code" % f)
            check(any("the rule that broke" in l for l in lines), "2: %s: the last output line is shown" % f)
            check(summary(res, lambda *_: None) == 1, "2: %s: exit 1" % f)
        # exit 2 in a static step is a failure (only the real steps may skip)
        root, log = make_root("t2b", codes={"check-gradle.py": 2})
        res, _ = go(root)
        check(status(res)["S1"] == "fail", "2: exit 2 of a static step is a failure")

        # 3. missing script, timeout
        root, log = make_root("t3", missing=("check-gradle.py",))
        res, lines = go(root)
        check(status(res)["S1"] == "fail" and status(res)["S2"] == "fail" and status(res)["S3"] == "ok", "3: a missing script fails its steps only")
        check(any("script not found: shizuku/tools/check-gradle.py" in l for l in lines), "3: the message names the script")
        root, log = make_root("t3b", sleeps={"test-check-merged-manifest.py": 5})
        res, lines = go(root, timeout=1)
        check(status(res)["S3"] == "fail" and status(res)["S4"] == "ok", "3: a hanging step fails and the next one still runs")
        check(any("timed out after 1 s" in l for l in lines), "3: the message says timed out")

        # 4. provider-real: runs when any fetched manifest exists
        root, log = make_root("t4")
        put(root, "mika/upstream/app/src/main/AndroidManifest.xml")
        res, _ = go(root)
        check(status(res)["S5"] == "ok", "4: S5 runs with only Mika's manifest present")
        check("check-provider-match.py||iso=1" in calls(log)[4:], "4: S5 runs the script without arguments: %s" % calls(log))
        root, log = make_root("t4b", codes={"check-provider-match.py": 1})
        put(root, "shizuku/upstream/manager/src/main/AndroidManifest.xml")
        res, _ = go(root)
        check(status(res)["S4"] == "fail" and status(res)["S5"] == "fail", "4: the stub of the script fails S4 and S5 (same file)")
        # the real step skips on exit 2, fails on exit 2 with --require-real
        root, log = make_root("t4c", codes={"check-provider-match.py": 2})
        put(root, "shizuku/upstream/manager/src/main/AndroidManifest.xml")
        res, _ = go(root)
        check(status(res)["S4"] == "fail" and status(res)["S5"] == "skip", "4: exit 2 fails the self-test step (S4) and only skips S5: %s" % status(res))
        # env override of the upstream folder
        root, log = make_root("t4d")
        other = os.path.join(tmp, "elsewhere")
        put(other, "manager/src/main/AndroidManifest.xml")
        res, _ = go(root, env={"SHIZUKU_UPSTREAM_DIR": other})
        check(status(res)["S5"] == "ok", "4: SHIZUKU_UPSTREAM_DIR is honoured")

        # 5. patch-real: fetched but not patched -> skip; patched -> --check
        root, log = make_root("t5")
        put(root, "shizuku/upstream/settings.gradle")
        res, lines = go(root)
        check(status(res)["S6"] == "skip" and any("not patched" in l for l in lines), "5: fetched but not patched is a skip with that reason")
        put(root, "shizuku/upstream/.win11-patched", "hash host")
        res, _ = go(root)
        check(status(res)["S6"] == "ok" and any(x.startswith("patch-upstream.py|--check|") for x in calls(log)), "5: patched checkout: patch-upstream.py --check runs")
        check(status(res)["S11"] == "ok" and calls(log).count("sweep-package-strings.py||iso=1") == 1, "5: patched checkout: the sweep runs once without arguments (S11): %s" % calls(log))
        root, log = make_root("t5b", codes={"patch-upstream.py": 1}, outputs={"patch-upstream.py": "D. self-check FAILED"})
        put(root, "shizuku/upstream/settings.gradle")
        put(root, "shizuku/upstream/.win11-patched", "h")
        res, lines = go(root)
        check(status(res)["S6"] == "fail" and any("D. self-check FAILED" in l for l in lines), "5: a failing patch self-check fails S6 and shows its line")

        # 6. manifest-real: one run per existing variant, with --variant and --root
        root, log = make_root("t6")
        put(root, "app/build/intermediates/merged_manifests/release/processReleaseManifest/AndroidManifest.xml")
        res, _ = go(root)
        c = [x for x in calls(log) if x.startswith("check-merged-manifest.py")]
        check(status(res)["S7"] == "ok" and len(c) == 1 and c[0].startswith("check-merged-manifest.py|--variant release --root %s|" % root), "6: release only: one run: %s" % c)
        put(root, "app/build/intermediates/merged_manifests/debug/processDebugManifest/AndroidManifest.xml")
        res, lines = go(root)
        c = [x for x in calls(log) if x.startswith("check-merged-manifest.py")]
        check(len(c) == 3 and "--variant debug" in c[2], "6: both variants: two more runs, debug second: %s" % c)
        check(any("S7" in l and "2 run(s)" in l for l in lines), "6: the report says 2 run(s)")
        root, log = make_root("t6b", codes={"check-merged-manifest.py": 1}, outputs={"check-merged-manifest.py": "::error::Shizuku manifest: [4E-2 authority] boom"})
        put(root, "app/build/intermediates/merged_manifests/debug/processDebugManifest/AndroidManifest.xml")
        res, lines = go(root)
        check(status(res)["S7"] == "fail" and any("variant debug" in l and "exit 1" in l for l in lines) and any("4E-2 authority" in l for l in lines),
              "6: a failing rule of the real manifest fails S7 with the variant and the rule line")
        root, log = make_root("t6c")
        put(root, "app/build/intermediates/other/AndroidManifest.xml")
        res, _ = go(root)
        check(status(res)["S7"] == "skip", "6: a manifest that is not under merged_manifests/<variant> does not count")

        # 7. --no-real and --require-real
        root, log = make_root("t7")
        put(root, "mika/upstream/app/src/main/AndroidManifest.xml")
        put(root, "shizuku/upstream/settings.gradle")
        put(root, "shizuku/upstream/.win11-patched")
        put(root, "app/build/intermediates/merged_manifests/release/x/AndroidManifest.xml")
        res, lines = go(root, no_real=True)
        check(all(status(res)[s] == "skip" for s in ("S5", "S6", "S7", "S11")) and len(calls(log)) == 7, "7: --no-real skips S5 - S7 and S11 although their inputs exist")
        root, log = make_root("t7b")
        res, lines = go(root, require_real=True)
        check(all(status(res)[s] == "fail" for s in ("S5", "S6", "S7", "S11")) and all(status(res)[s] == "ok" for s in ("S1", "S2", "S3", "S4", "S8", "S9", "S10")), "7: --require-real on a bare checkout fails the real steps only")
        check(any("--require-real" in l and "[S5]" in l for l in lines), "7: the message names the option")
        root, log = make_root("t7c", codes={"check-provider-match.py": 2})
        put(root, "mika/upstream/app/src/main/AndroidManifest.xml")
        res, _ = go(root, require_real=True)
        check(status(res)["S5"] == "fail", "7: exit 2 of a real step fails with --require-real")

        # 8. summary text
        res = [("S1", "a", "ok", ""), ("S2", "b", "fail", "x"), ("S5", "c", "skip", "y")]
        lines = []
        check(summary(res, lines.append) == 1 and "FAILED" in lines[0] and "S2" in lines[0] and "1 ok, 1 skipped" in lines[0], "8: summary of a failed run: %s" % lines)
        lines = []
        check(summary([("S1", "a", "ok", ""), ("S5", "c", "skip", "y")], lines.append) == 0 and lines[0].startswith("shizuku checks ok: 1 step(s) ran ok, 1 skipped (S5)"), "8: summary of a good run: %s" % lines)

        # 9. command line, in-process
        import io, contextlib

        def cli(argv):
            buf = io.StringIO()
            with contextlib.redirect_stdout(buf), contextlib.redirect_stderr(buf):
                rc = main(argv)
            return rc, buf.getvalue()

        root, log = make_root("t9")
        rc, text = cli(["--root", root])
        check(rc == 0 and "shizuku checks ok" in text, "9: main on the stub root: exit 0 and the summary: %s" % text[-120:])
        rc, text = cli(["--list"])
        check(rc == 0 and all(s[0] in text for s in STEPS) and len(text.splitlines()) == len(STEPS), "9: --list prints every step")
        rc, text = cli(["--bogus"])
        check(rc == 2, "9: a bad option exits 2")
        rc, text = cli(["--no-real", "--require-real", "--root", root])
        check(rc == 2 and "exclude each other" in text, "9: --no-real with --require-real exits 2")
        rc, text = cli(["--root", os.path.join(tmp, "nothing-here")])
        check(rc == 2 and "no shizuku/tools folder" in text, "9: a root without shizuku/tools exits 2")
        rc, text = cli(["--root", root, "--timeout", "0"])
        check(rc == 2, "9: --timeout 0 exits 2")
        root2, _ = make_root("t9b", codes={"check-gradle.py": 1})
        rc, text = cli(["--root", root2])
        check(rc == 1 and "shizuku checks FAILED" in text and "::error::shizuku checks: [S1]" in text, "9: main on a failing stub root: exit 1")
        rc, text = cli(["--root", root, "--no-real", "-v"])
        check(rc == 0 and "stub check-gradle.py output" in text, "9: -v prints the output lines of the steps")

        # 10. as a real process, the way the root check calls it
        p = subprocess.run([sys.executable, "-I", "-B", os.path.abspath(__file__), "--root", root, "--no-real"], capture_output=True)
        check(p.returncode == 0 and b"shizuku checks ok" in p.stdout, "10: real process on a good stub root: exit 0")
        p = subprocess.run([sys.executable, "-I", "-B", os.path.abspath(__file__), "--root", root2], capture_output=True)
        check(p.returncode == 1 and b"::error::shizuku checks: [S1]" in p.stdout, "10: real process on a bad stub root: exit 1")
        p = subprocess.run([sys.executable, "-I", "-B", os.path.abspath(__file__), "--root", os.path.join(tmp, "nope")], capture_output=True)
        check(p.returncode == 2, "10: real process on a wrong root: exit 2")

        # 11. the step table itself
        ids = [s[0] for s in STEPS]
        check(ids == ["S%d" % i for i in range(1, len(STEPS) + 1)] and len(set(ids)) == len(ids), "11: step ids are S1 ... Sn in order")
        check(all(os.path.isfile(os.path.join(HERE, s[2])) for s in STEPS) or not os.path.isfile(os.path.join(HERE, "check-gradle.py")),
              "11: every step names a script that exists next to this one")
        check(set(s[4] for s in STEPS) == {"always", "provider", "patch", "sweep", "manifest"}, "11: the five kinds of step are all used")
    finally:
        shutil.rmtree(tmp, ignore_errors=True)
    if failures:
        print("check-all self-test: %d of %d checks failed" % (len(failures), count[0]))
        return 1
    print("check-all self-test ok: %d checks" % count[0])
    return 0


if __name__ == "__main__":
    sys.exit(main())
