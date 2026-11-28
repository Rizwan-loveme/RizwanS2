#!/usr/bin/env python3
"""Row 5A: source sweep of the PATCHED Shizuku checkout (shizuku/upstream/ after fetch-upstream.sh + patch-upstream.py) for the two package strings.

  moe.shizuku.privileged.api   the upstream manager's APPLICATION ID, a RUN-TIME name (pm path, PackageManager lookups, actions).
                               After the patch it must be gone everywhere except manager/build.gradle (not used by our build) and the binder extra key below.
  moe.shizuku.privileged.api.intent.extra.BINDER
                               (5C) the key under which the server hands the binder to a provider; every outside Shizuku client reads exactly this key, so it is KEPT:
                               exactly once in each of the four files of BINDER_EXTRA_KEPT, nowhere else, and nowhere spelled with the host package.
  moe.shizuku.manager          the manager's Java / Kotlin NAMESPACE (R, databinding, class names) and the prefix of the two permission names.
                               It stays on purpose; the sweep sorts every occurrence so that a use that is neither a namespace nor a permission is seen.
  <host package>               what part A of the patch writes in place of the first one. Expected: the 9 places of PACKAGE_FILES minus the 4 kept binder extra keys
                               (5 places in 5 files) plus the 2 places that replace BuildConfig.APPLICATION_ID (HomeViewModel.kt, AuthorizationManager.kt) = 7 places in 7 files,
                               nowhere else.

Categories of `moe.shizuku.manager`:
  namespace   `package` / `import` lines, `namespace` / `applicationId` lines of a build file
  class-name  a fully qualified class name (manifest android:name="moe.shizuku.manager.X", keep rules, a main class named in a string)
  permission  moe.shizuku.manager.permission.*  (API_V23, MANAGER, API; names every Shizuku client asks for: stay)
  review      anything else: an action, extra, path or authority built from the namespace. Look at each one: should it be the host package?

Usage:  python3 shizuku/tools/sweep-package-strings.py [--root DIR] [--host PKG] [--strict] [--report FILE] [-v]
        python3 shizuku/tools/sweep-package-strings.py --self-test
Exit: 0 = nothing wrong (review items are only printed, unless --strict), 1 = the old name is left outside manager/build.gradle, a host-package count differs
from the expected one, or --strict and there is a review item; 2 = no patched checkout found (run fetch-upstream.sh + patch-upstream.sh first) / bad arguments.
Needs nothing but python3. Part of check-all.py since row 10A: S9 runs --self-test, S11 runs the sweep on the patched checkout (no workflow calls it).
"""
import argparse, importlib.util, os, re, sys, tempfile, shutil, contextlib, io

HERE = os.path.dirname(os.path.abspath(__file__))
SHIZUKU = os.path.dirname(HERE)
OLD = 'moe.shizuku.privileged.api'
NS = 'moe.shizuku.manager'
OLD_ALLOWED = ('manager/build.gradle',)
EXTS = ('.java', '.kt', '.kts', '.cpp', '.h', '.c', '.xml', '.aidl', '.gradle', '.pro', '.sh', '.txt', '.properties', '.json', '.cmake')
SKIP_DIRS = ('.git', 'build', 'demo', '.gradle')
EXTRA_HOST_FILES = {  # BuildConfig.APPLICATION_ID -> host literal (patch_library_code)
    'manager/src/main/java/moe/shizuku/manager/home/HomeViewModel.kt': 1,
    'manager/src/main/java/moe/shizuku/manager/authorization/AuthorizationManager.kt': 1,
}


def load_patch():
    spec = importlib.util.spec_from_file_location('patch_upstream', os.path.join(HERE, 'patch-upstream.py'))
    m = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(m)
    return m


def expected_host_counts(patch):
    exp = {rel: n - patch.BINDER_EXTRA_KEPT.get(rel, 0) for rel, n in patch.PACKAGE_FILES}   # 5C: the kept binder extra keys are not host-package places
    for k, v in EXTRA_HOST_FILES.items():
        exp[k] = exp.get(k, 0) + v
    return {k: v for k, v in exp.items() if v}


def text_files(root):
    for dp, dns, fs in os.walk(root):
        dns[:] = [d for d in dns if d not in SKIP_DIRS]
        for f in sorted(fs):
            if f.endswith(EXTS) or f == 'rish':
                p = os.path.join(dp, f)
                try:
                    with open(p, encoding='utf-8') as fh:
                        yield os.path.relpath(p, root).replace(os.sep, '/'), fh.read()
                except UnicodeDecodeError:
                    continue


def classify(rel, line, m):
    rest = line[m.end():]
    st = line.lstrip()
    if re.match(r'(package|import)\s', st):
        return 'namespace'
    if rest.startswith('.permission.'):
        return 'permission'
    if rel.endswith(('.gradle', '.kts')) and re.search(r'\b(namespace|applicationId)\b', line):
        return 'namespace'
    if rel.endswith('.xml') and line[:m.start()].rstrip().endswith('="'):
        return 'class-name'
    if not re.match(r'\.(intent|action|extra|extras)\b', rest) and re.match(r'(\.[a-z]\w*)*\.[A-Z][a-z]\w*', rest):
        return 'class-name'
    return 'review'


def sweep(root, host, patch):
    res = {'old': [], 'extra': {}, 'ns': {'namespace': 0, 'class-name': 0, 'permission': 0, 'review': 0}, 'lines': [], 'host': {}, 'files': 0}
    host_re = re.compile(r'(?<![\w.])' + re.escape(host) + r'(?!\w)')
    ns_re = re.compile(r'(?<![\w.])' + re.escape(NS))
    for rel, s in text_files(root):
        res['files'] += 1
        for n, line in enumerate(s.split('\n'), 1):
            if patch.OLD_NAME_RE.search(line):
                res['old'].append((rel, n, line.strip()))
            k = len(patch.BINDER_EXTRA_RE.findall(line))
            if k:
                res['extra'][rel] = res['extra'].get(rel, 0) + k
            for m in ns_re.finditer(line):
                c = classify(rel, line, m)
                res['ns'][c] += 1
                if c != 'namespace':
                    res['lines'].append((c, rel, n, line.strip()))
            k = len(host_re.findall(line))
            if k:
                res['host'][rel] = res['host'].get(rel, 0) + k
    problems = []
    for rel, n, line in res['old']:
        if rel not in OLD_ALLOWED:
            problems.append(f'{rel}:{n}: still names {OLD}: {line[:100]}')
    exp = expected_host_counts(patch)
    for rel in sorted(set(exp) | set(res['host'])):
        got, want = res['host'].get(rel, 0), exp.get(rel, 0)
        if got != want:
            problems.append(f'{rel}: host package written {got}x, expected {want}x')
    for rel in sorted(set(patch.BINDER_EXTRA_KEPT) | set(res['extra'])):
        got, want = res['extra'].get(rel, 0), patch.BINDER_EXTRA_KEPT.get(rel, 0)
        if got != want:
            problems.append(f'{rel}: binder extra key {patch.BINDER_EXTRA} written {got}x, expected {want}x (kept as upstream has it, row 5C)')
    res['problems'] = problems
    res['kept_exp'] = dict(patch.BINDER_EXTRA_KEPT)
    res['exp'] = exp
    return res


def report(res, host, verbose):
    out = []
    out.append(f'sweep-package-strings: {res["files"]} text files scanned, host package {host}')
    out.append(f'  {OLD}: {len(res["old"])} left, allowed only in {", ".join(OLD_ALLOWED)}')
    for rel, n, line in res['old']:
        out.append(f'    {rel}:{n}' + ('' if rel in OLD_ALLOWED else '   <-- NOT allowed'))
    ns = res['ns']
    out.append(f'  {NS}: namespace {ns["namespace"]}, class-name {ns["class-name"]}, permission {ns["permission"]}, review {ns["review"]}')
    out.append(f'  {OLD}.intent.extra.BINDER (kept): {sum(res["extra"].values())} places in {len(res["extra"])} files (expected {sum(res["kept_exp"].values())} in {len(res["kept_exp"])})')
    out.append(f'  host package written in {len(res["host"])} files, {sum(res["host"].values())} places (expected {len(res["exp"])} files, {sum(res["exp"].values())} places)')
    for c, rel, n, line in sorted(res['lines']):
        if c == 'review' or verbose:
            out.append(f'    [{c}] {rel}:{n}: {line[:120]}')
    return out


def run(argv):
    ap = argparse.ArgumentParser(description='row 5A sweep of the patched Shizuku source for the package strings')
    ap.add_argument('--root')
    ap.add_argument('--host')
    ap.add_argument('--strict', action='store_true', help='a review item fails the run')
    ap.add_argument('--report', help='also write the report (markdown-friendly text) to this file')
    ap.add_argument('-v', '--verbose', action='store_true', help='also list the class-name and permission lines')
    ap.add_argument('--self-test', action='store_true')
    a = ap.parse_args(argv)
    if a.self_test:
        return self_test()
    root = a.root or os.environ.get('SHIZUKU_UPSTREAM_DIR') or os.path.join(SHIZUKU, 'upstream')
    if not os.path.isfile(os.path.join(root, 'settings.gradle')):
        print(f'sweep-package-strings: {root} is not a Shizuku checkout: run shizuku/tools/fetch-upstream.sh and patch-upstream.sh first', file=sys.stderr)
        return 2
    if not os.path.isfile(os.path.join(root, '.win11-patched')):
        print(f'sweep-package-strings: {root} is not patched (no .win11-patched marker): run shizuku/tools/patch-upstream.sh first', file=sys.stderr)
        return 2
    patch = load_patch()
    host = patch.host_package(a.host)
    res = sweep(root, host, patch)
    lines = report(res, host, a.verbose)
    problems = list(res['problems'])
    if a.strict and res['ns']['review']:
        problems.append(f'{res["ns"]["review"]} review item(s) (--strict)')
    lines += [f'  PROBLEM: {p}' for p in problems]
    lines.append('sweep-package-strings: ' + ('FAILED' if problems else 'ok'))
    text = '\n'.join(lines)
    print(text)
    if a.report:
        with open(a.report, 'w', encoding='utf-8', newline='\n') as f:
            f.write(text + '\n')
    return 1 if problems else 0


# ------------------------------------------------------------------ self-test
def self_test():
    patch = load_patch()
    host = 'com.h.w'
    fails = 0
    total = 0

    def ok(c, m):
        nonlocal fails, total
        total += 1
        if not c:
            fails += 1
            print('FAIL ' + m)

    def build(tmp, mutate=None):
        shutil.rmtree(tmp, ignore_errors=True)
        files = {}
        for rel, n in list(expected_host_counts(patch).items()) + [(r, 0) for r in patch.BINDER_EXTRA_KEPT]:
            files[rel] = files.get(rel) or ('package moe.shizuku.manager.x\n' if rel.endswith('.kt') else '')
            files[rel] += ''.join(f'val a{i} = "{host}"\n' for i in range(n))
        for rel, k in patch.BINDER_EXTRA_KEPT.items():
            files[rel] += ''.join(f'val k{i} = "{patch.BINDER_EXTRA}"\n' for i in range(k))
        files['settings.gradle'] = 'include ":manager"\n'
        files['manager/build.gradle'] = f'namespace "{NS}"\napplicationId "{OLD}"\n'
        files['manager/src/main/AndroidManifest.xml'] = (f'<activity android:name="{NS}.MainActivity" />\n'
                                                         f'<permission android:name="{NS}.permission.MANAGER" />\n')
        files['manager/src/main/java/A.kt'] = f'import {NS}.R\nval p = "{NS}.permission.API_V23"\nval c = "{NS}.shell.Shell"\n'
        files['.win11-patched'] = 'x\n'
        if mutate:
            mutate(files)
        for rel, s in files.items():
            p = os.path.join(tmp, rel)
            os.makedirs(os.path.dirname(p), exist_ok=True)
            with open(p, 'w', encoding='utf-8') as f:
                f.write(s)

    def go(mutate=None, *extra):
        tmp = tempfile.mkdtemp(prefix='t5a-')
        try:
            build(os.path.join(tmp, 'u'), mutate)
            buf, err = io.StringIO(), io.StringIO()
            with contextlib.redirect_stdout(buf), contextlib.redirect_stderr(err):
                code = run(['--root', os.path.join(tmp, 'u'), '--host', host, *extra])
            return code, buf.getvalue() + err.getvalue()
        finally:
            shutil.rmtree(tmp, ignore_errors=True)

    code, out = go()
    ok(code == 0 and 'ok' in out.splitlines()[-1], 'clean checkout: exit 0')
    ok('namespace 5, class-name 2, permission 2, review 0' in out, 'clean checkout: categories counted')
    ok(f'{len(expected_host_counts(patch))} files' in out, 'host files counted')
    code, out = go(lambda f: f.update({'manager/src/main/java/B.kt': f'val x = "{OLD}"\n'}))
    ok(code == 1 and 'B.kt:1: still names' in out, 'old name in a source file fails')
    code, out = go(lambda f: f.update({'manager/src/main/res/values/strings.xml': f'<string name="a">{OLD}</string>\n'}))
    ok(code == 1, 'old name in a resource fails')
    code, out = go(lambda f: f.update({'manager/build.gradle': f'applicationId "{OLD}"\n'}))
    ok(code == 0, 'old name only in manager/build.gradle is allowed')
    code, out = go(lambda f: f.update({'manager/src/main/java/C.kt': f'val a = "{NS}.intent.action.X"\n'}))
    ok(code == 0 and '[review]' in out and 'review 1' in out, 'unknown namespace use is listed as review, exit 0')
    code, out = go(lambda f: f.update({'manager/src/main/java/C.kt': f'val a = "{NS}.intent.action.X"\n'}), '--strict')
    ok(code == 1 and '--strict' in out, 'review item fails with --strict')
    code, out = go(lambda f: f.update({'manager/src/main/java/C.kt': f'val a = "{NS}"\n'}))
    ok('review 1' in out, 'the bare namespace in a string is a review item')
    code, out = go(lambda f: f.update({'manager/src/main/java/C.kt': f'val a = "{NS}.permission.API"\n'}))
    ok(code == 0 and 'permission 3' in out, 'another permission name counts as permission')
    code, out = go(lambda f: f.update({'manager/src/main/java/C.kt': f'val a = "x{NS}"\nval b = "rikka.shizuku.manager.ShizukuLocales"\n'}))
    ok('review 0' in out, 'a longer name that only ends in the namespace is not counted')
    rel = 'manager/src/main/jni/starter.cpp'
    code, out = go(lambda f: f.update({rel: f.get(rel, '') + f'#define P2 "{host}"\n'}))
    ok(code == 1 and 'written 2x, expected 1x' in out, 'an extra host-package place fails')
    code, out = go(lambda f: f.update({rel: ''}))
    ok(code == 1 and 'written 0x, expected 1x' in out, 'a missing host-package place fails')
    code, out = go(lambda f: f.update({'manager/src/main/java/D.kt': f'val a = "{host}.shizuku"\n'}))
    ok(code == 1 and 'D.kt: host package written 1x, expected 0x' in out, 'the host package in a new file fails')
    code, out = go(lambda f: f.update({'manager/src/main/java/D.kt': f'val a = "{host}x"\n'}))
    ok(code == 0, 'a longer name that starts with the host package is not a host place')
    code, out = go(lambda f: f.update({'manager/src/main/java/E.kt': f'val a = "{NS}.permission.MANAGER"\n'}), '-v')
    ok('[permission]' in out and '[class-name]' in out, '-v lists class-name and permission lines')
    code, out = go(lambda f: f.update({'manager/src/main/java/F.bin': OLD}))
    ok(code == 0, 'files with another extension are not read')
    code, out = go(lambda f: f.pop('.win11-patched'))
    ok(code == 2 and 'not patched' in out, 'unpatched checkout exits 2')
    buf, err = io.StringIO(), io.StringIO()
    with contextlib.redirect_stdout(buf), contextlib.redirect_stderr(err):
        code = run(['--root', os.path.join(tempfile.gettempdir(), 'no-such-dir-5a')])
    ok(code == 2 and 'fetch-upstream.sh' in err.getvalue(), 'missing checkout exits 2')
    tmp = tempfile.mkdtemp(prefix='t5a-')
    try:
        build(os.path.join(tmp, 'u'))
        rp = os.path.join(tmp, 'r.txt')
        with contextlib.redirect_stdout(io.StringIO()):
            run(['--root', os.path.join(tmp, 'u'), '--host', host, '--report', rp])
        ok(os.path.isfile(rp) and 'sweep-package-strings: ok' in open(rp).read(), '--report writes the file')
    finally:
        shutil.rmtree(tmp, ignore_errors=True)
    # row 5C: the binder extra key is kept, not renamed
    svc = 'server/src/main/java/rikka/shizuku/server/ShizukuService.java'
    ok('7 files, 7 places (expected 7 files, 7 places)' in go()[1], '5C: clean tree has 7 host places in 7 files')
    ok('(kept): 4 places in 4 files (expected 4 in 4)' in go()[1], '5C: the report counts the kept binder extra keys')
    code, out = go(lambda f: f.update({svc: f[svc].replace(patch.BINDER_EXTRA, host + '.intent.extra.BINDER')}))
    ok(code == 1 and 'binder extra key' in out and 'written 0x, expected 1x' in out and 'ShizukuService.java: host package written 1x, expected 0x' in out, '5C: key spelled with the host package fails')
    code, out = go(lambda f: f.update({svc: 'class S {}\n'}))
    ok(code == 1 and 'ShizukuService.java: binder extra key' in out and 'written 0x, expected 1x' in out, '5C: a missing kept key fails')
    code, out = go(lambda f: f.update({'manager/src/main/java/B.kt': f'val k = "{patch.BINDER_EXTRA}"\n'}))
    ok(code == 1 and 'B.kt: binder extra key' in out and 'written 1x, expected 0x' in out, '5C: the key in a fifth file fails')
    code, out = go(lambda f: f.update({svc: f[svc] + f'val old = "{OLD}"\n'}))
    ok(code == 1 and 'ShizukuService.java' in out and 'still names' in out, '5C: the old name next to the kept key still fails')
    code, out = go(lambda f: f.update({svc: f[svc] + f'val x = "{patch.BINDER_EXTRA}_X"\n'}))
    ok(code == 1 and 'still names' in out, '5C: a longer key that only starts like the kept one fails')
    # classification unit cases
    ns_re = re.compile(r'(?<![\w.])' + re.escape(NS))
    for rel, line, want in [
        ('A.kt', f'import {NS}.R', 'namespace'), ('A.kt', f'package {NS}.home', 'namespace'), ('b.gradle', f'    namespace = "{NS}"', 'namespace'),
        ('m.xml', f'<a android:name="{NS}.A"', 'class-name'), ('A.pro', f'-keep class {NS}.shell.Shell {{', 'class-name'),
        ('A.kt', f'"{NS}.permission.MANAGER"', 'permission'), ('A.kt', f'"{NS}.foo"', 'review'), ('A.kt', f'"{NS}"', 'review'),
        ('A.kt', f'"{NS}/files"', 'review'), ('m.xml', f'<x tools:context="{NS}.MainActivity">', 'class-name')]:
        m = ns_re.search(line)
        ok(classify(rel, line, m) == want, f'classify {line!r} -> {want}')
    print(f'sweep-package-strings self-test: {total - fails} of {total} cases ok' + ('' if not fails else ' - FAILED'))
    return 1 if fails else 0


if __name__ == '__main__':
    sys.exit(run(sys.argv[1:]))
