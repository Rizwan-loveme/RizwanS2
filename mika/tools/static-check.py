#!/usr/bin/env python3
"""Static checks for the Mika / Rizwan part of the project (part 13). Needs only python3 (+ PyYAML for the workflow check, skipped if missing) and bash.

Run from the project root:   python3 mika/tools/static-check.py
It never changes a file. With mika/upstream/ present (after fetch + patch) it also checks the patched Mika sources; without it, that part is skipped.
Exit code 1 and `::error::static-check: ...` lines when something is wrong, so CI or a person can use it the same way.

Checks: 1 workflows (YAML + `bash -n` of every run step)   2 shell scripts (`bash -n`) and Python scripts (ast)   3 XML well-formed (project, patched Mika)
4 resource names: no clash between any module and :mika   5 stubs have every member the app uses   6 Kotlin files of the hooks: braces / parentheses balance
7 Gradle wiring: settings / app dependency / unwiring still leaves valid blocks   8 greeting + name in the patched strings   9 line endings + executable bits   10 (patched Mika) no removed Compose Foundation API left (build fix 1)
"""
import ast, glob, os, re, subprocess, sys
import xml.etree.ElementTree as ET
from collections import defaultdict

ROOT = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", ".."))
os.chdir(ROOT)
UP = "mika/upstream"
KT = "app/src/main/kotlin/com/srizwan/win11"
errors = []
notes = []


def err(msg):
    errors.append(msg)
    print("::error::static-check: " + msg)


def ok(msg):
    print("static-check: OK  " + msg)


def read(p):
    with open(p, encoding="utf-8") as f:
        return f.read()


# ---- 1 workflows
def check_workflows():
    try:
        import yaml
    except ImportError:
        notes.append("PyYAML missing: workflow check skipped")
        return
    steps = 0
    files = sorted(glob.glob(".github/workflows/*.yml"))
    for w in files:
        try:
            d = yaml.safe_load(read(w))
        except Exception as e:
            err("%s is not valid YAML: %s" % (w, e))
            continue
        for _jn, j in (d.get("jobs") or {}).items():
            for s in j.get("steps", []):
                r = s.get("run")
                if not r:
                    continue
                steps += 1
                p = subprocess.run(["bash", "-n"], input=r.encode(), capture_output=True)
                if p.returncode:
                    err("%s step '%s': %s" % (w, s.get("name"), p.stderr.decode(errors="replace")[:160]))
    ok("workflows: %d files, %d run steps (YAML + bash -n)" % (len(files), steps))


# ---- 2 scripts
def check_scripts():
    sh = sorted(glob.glob("*/tools/*.sh") + glob.glob("tools/*.sh"))
    for f in sh:
        p = subprocess.run(["bash", "-n", f], capture_output=True)
        if p.returncode:
            err("bash -n %s: %s" % (f, p.stderr.decode(errors="replace")[:160]))
    py = sorted(glob.glob("*/tools/*.py"))
    for f in py:
        try:
            ast.parse(read(f))
        except Exception as e:
            err("python syntax %s: %s" % (f, e))
    ok("scripts: %d shell (bash -n), %d python (ast)" % (len(sh), len(py)))


# ---- 3 XML
def xml_walk(root):
    n = 0
    for dp, dn, fn in os.walk(root):
        dn[:] = [d for d in dn if d not in (".git", "build", "__pycache__")]
        for f in fn:
            if f.endswith(".xml"):
                n += 1
                try:
                    ET.parse(os.path.join(dp, f))
                except Exception as e:
                    err("XML not well-formed: %s: %s" % (os.path.join(dp, f), str(e)[:100]))
    return n


# ---- 4 resource names
def res_names(resdir):
    out = defaultdict(set)
    if not os.path.isdir(resdir):
        return out
    for d in os.listdir(resdir):
        p = os.path.join(resdir, d)
        if not os.path.isdir(p):
            continue
        typ = d.split("-")[0]
        for f in os.listdir(p):
            if typ == "values" and f.endswith(".xml"):
                try:
                    for e in ET.parse(os.path.join(p, f)).getroot():
                        nm = e.get("name")
                        t = e.get("type", "item") if e.tag == "item" else e.tag
                        if nm and t != "declare-styleable":
                            out[t].add(nm)
                except Exception:
                    pass
            else:
                out[typ].add(os.path.splitext(f)[0])
    return out


def check_resources():
    mika = res_names(UP + "/app/src/main/res")
    clashes = 0
    mods = 0
    for mod in sorted(os.listdir(".")):
        rd = os.path.join(mod, "src/main/res")
        if mod == "mika" or not os.path.isdir(rd):
            continue
        mods += 1
        for t, names in res_names(rd).items():
            c = names & mika.get(t, set())
            if c:
                clashes += len(c)
                err("resource clash %s: %s %s (%d)" % (mod, t, sorted(c)[:5], len(c)))
    ok("resources: %d modules compared with :mika, %d clashes" % (mods, clashes))


# ---- 5 stubs vs app use
def check_stubs():
    used_ml = set(re.findall(r"MikaLauncher\.(\w+)", "".join(read(f) for f in glob.glob(KT + "/*.kt") if not f.endswith("MikaLauncher.kt"))))
    stub_ml = read("mika/tools/stub/MikaLauncher.kt.stub")
    for m in sorted(used_ml):
        if not re.search(r"\b%s\b" % m, stub_ml):
            err("MikaLauncher.kt.stub lacks '%s' that the app uses" % m)
    base_src = "".join(read(f) for f in glob.glob(KT + "/*.kt") if not f.endswith("AppBase.kt"))
    used_ab = set(re.findall(r"AppBase\.(?!kt\b)(\w+)", base_src)) | set(re.findall(r"\b(startMikaIfUsed|startMikaNow)\b", base_src))
    stub_ab = read("mika/tools/stub/AppBase.kt.stub")
    for m in sorted(used_ab):
        if not re.search(r"\b%s\b" % m, stub_ab):
            err("AppBase.kt.stub lacks '%s' that the app uses" % m)
    real_ml = read(KT + "/MikaLauncher.kt")
    for m in ("SECTION", "NAME", "isSupported", "open"):
        if m not in stub_ml or m not in real_ml:
            err("MikaLauncher member '%s' missing in the real file or the stub" % m)
    ok("stubs: MikaLauncher uses %s, AppBase uses %s" % (sorted(used_ml), sorted(used_ab)))


# ---- 6 Kotlin balance
def kt_strip(s):
    out = []
    i, n = 0, len(s)
    while i < n:
        c = s[i]
        if s.startswith('"""', i):
            j = s.find('"""', i + 3)
            i = j + 3 if j >= 0 else n
            continue
        if s.startswith("//", i):
            j = s.find("\n", i)
            i = j if j >= 0 else n
            continue
        if s.startswith("/*", i):
            j = s.find("*/", i + 2)
            i = j + 2 if j >= 0 else n
            continue
        if c == '"':
            i += 1
            while i < n and s[i] != '"':
                i += 2 if s[i] == "\\" else 1
            i += 1
            continue
        if c == "'":
            m = re.match(r"'(\\.|[^'\\])'", s[i:i + 6]) or re.match(r"'\\u[0-9a-fA-F]{4}'", s[i:i + 8])
            if m:
                i += m.end()
                continue
        out.append(c)
        i += 1
    return "".join(out)


def check_kotlin():
    names = ["AppBase", "MikaLauncher", "App", "StartApps", "Win11Shell", "MainActivity", "TerminalShare"]
    for nm in names:
        p = KT + "/" + nm + ".kt"
        if not os.path.exists(p):
            err("missing " + p)
            continue
        o = kt_strip(read(p))
        if o.count("{") != o.count("}") or o.count("(") != o.count(")"):
            err("%s: braces %d/%d parentheses %d/%d" % (p, o.count("{"), o.count("}"), o.count("("), o.count(")")))
    ok("kotlin: %d hook files balanced ({} and ())" % len(names))


# ---- 7 Gradle wiring
def check_gradle():
    st, ap = read("settings.gradle.kts"), read("app/build.gradle.kts")
    for m in ("mika", "mika-core"):
        if 'include(":%s")' % m not in st:
            err("settings.gradle.kts does not include :" + m)
    if 'project(":mika")' not in ap:
        err("app/build.gradle.kts has no dependency on :mika")
    s2, a2 = st, ap
    for m in ("mika", "mika-core"):  # what drop_module does in UltimateBuild_WithoutMe.yml
        s2 = re.sub(r'.*include\(":%s"\).*\n' % re.escape(m), "", s2)
        a2 = re.sub(r'.*project\(":%s"\).*\n' % re.escape(m), "", a2)
    for name, txt in (("settings.gradle.kts", s2), ("app/build.gradle.kts", a2)):
        if kt_strip(txt).count("{") != kt_strip(txt).count("}"):
            err("%s: braces unbalanced after removing Mika (without workflow)" % name)
    if 'project(":mika' in a2 or 'include(":mika' in s2:
        err("unwiring left a Mika line behind")
    for lib in ("libc++_shared.so", "liboboe.so"):      # build fix 2: duplicate native libs of the full build (:winlator + :j2me)
        if 'pickFirsts += "**/%s"' % lib not in ap:
            err("app/build.gradle.kts has no pickFirsts for " + lib)
    ok("gradle: modules included, dependency present, pickFirsts (libc++_shared, liboboe), unwiring leaves balanced files")


# ---- 8 patched strings
def check_strings():
    root = UP + "/app/src/main/res"
    fs = [f for f in glob.glob(root + "/values*/*.xml") if "chat_greeting" in read(f)]
    bad = [f for f in fs if "Hey Rizwan" not in read(f)]
    if len(fs) < 13 or bad:
        err("greeting: %d files with chat_greeting (expected 13), %d without 'Hey Rizwan'" % (len(fs), len(bad)))
    left = 0
    for f in glob.glob(root + "/values*/*.xml"):
        for line in read(f).splitlines():
            for m in re.finditer(r"\bMika\b", line):
                tail = line[max(0, m.start() - 30):m.end() + 1]
                if "github.com/wangzan101/Mika" in line or "Theme.Mika" in line:
                    continue  # upstream URLs and the internal style name stay
                left += 1
                err("visible 'Mika' left in %s: %s" % (os.path.relpath(f, root), tail.strip()[:60]))
    ok("strings: %d files carry 'Hey Rizwan', %d visible 'Mika' words left (upstream URLs and Theme.Mika are kept on purpose)" % (len(fs), left))


# ---- 10 removed Compose API (build fix 1: the first CI build failed on DraggableAnchors.minAnchor() / maxAnchor())
def check_removed_api():
    bad = 0
    for dp, dn, fn in os.walk(UP + "/app/src/main/java"):
        for f in fn:
            if f.endswith((".kt", ".java")) and re.search(r"\.(?:minAnchor|maxAnchor)\(", read(os.path.join(dp, f))):
                bad += 1
                err("removed Compose Foundation API minAnchor()/maxAnchor() in " + os.path.join(dp, f))
    ok("api: %d uses of the removed DraggableAnchors.minAnchor()/maxAnchor() left in the patched Mika" % bad)


# ---- 9 line endings / modes
def check_files():
    for f in glob.glob("mika/tools/*") + glob.glob("mika/tools/stub/*"):
        if os.path.isfile(f) and b"\r" in open(f, "rb").read():
            err("CRLF in " + f)
    for f in glob.glob("mika/tools/*.sh"):
        if not os.access(f, os.X_OK):
            err("not executable: " + f)
    ok("files: LF in mika/tools, *.sh executable")


def main():
    check_workflows()
    check_scripts()
    n = xml_walk(".")
    ok("xml: %d project files well-formed" % n)
    check_stubs()
    check_kotlin()
    check_gradle()
    check_files()
    if os.path.isdir(UP + "/app/src/main/res"):
        n2 = xml_walk(UP + "/app/src/main")
        ok("xml: %d patched Mika files well-formed" % n2)
        check_resources()
        check_strings()
        check_removed_api()
    else:
        notes.append("mika/upstream not present: patched-source checks (XML, resource clashes, greeting) skipped; run fetch + patch first")
    for n_ in notes:
        print("static-check: note " + n_)
    if errors:
        print("static-check: %d problem(s)" % len(errors))
        sys.exit(1)
    print("static-check: all checks passed")


if __name__ == "__main__":
    main()
