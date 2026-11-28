#!/usr/bin/env python3
"""Structural check of the Shizuku Gradle files (step 3C; no Gradle, no Kotlin compiler needed).

NOT a Kotlin parser. It checks what can be checked without one:
  1. every .kts file under shizuku/ plus settings.gradle.kts and build.gradle.kts: brackets ( ) { } [ ] balanced and properly nested, strings / raw strings / char
     literals / comments / ${...} templates closed (a small tokenizer that knows Kotlin's lexical rules);
  2. settings.gradle.kts: every Shizuku project it includes has a folder with a build.gradle.kts, and every module folder is included (and the other way round);
  3. every apply(from = "...") points at an existing file; every project(":x") names an included project (or a project of the rest of the build);
  4. namespaces: unique across the shizuku modules (AGP refuses two modules with the same namespace);
  5. the project dependency graph of the shizuku modules has no cycle (a cycle is a Gradle configuration error);
  6. every module that applies after-fetch.gradle.kts sets extra["shizukuUpstreamPath"] and extra["shizukuWired"] BEFORE the apply line;
  7. (3E) "kotlin" in extra["shizukuWired"] <-> the module applies the Kotlin Android plugin (a .kt file without the plugin is silently not compiled);
     every consumerProguardFiles("x") / proguardFiles("x") file next to a build file exists; every extra["shizukuRequired"] entry is in the form "<folder>/..." (the file itself
     only exists after the fetch, so it is not looked for here); :shizuku (shizuku/build.gradle.kts) is part of the dependency graph (cycle check) and defines the tasks that
     after-fetch.gradle.kts names (:shizuku:fetchShizukuUpstream / :shizuku:patchShizukuUpstream) and the rish dex task.
  8. (3F) the root / :app side: app/build.gradle.kts is checked like the others (brackets, strings); the root build file maps EVERY dev.rikka.shizuku:<x> Maven coordinate that any build
     file of the project asks for (:mika asks for api + provider) to an included :shizuku-* project, behind a findProject(":shizuku-api") guard, and no shizuku module asks for such a
     coordinate itself (it would be substituted by itself); :app depends on :shizuku and excludes the Rikka AppCompat fork, both only behind `if (shizukuIncluded)`, which is defined by
     findProject(":shizuku"); nothing outside the shizuku modules depends on the application module :shizuku-shell (its APK must never be part of Win11); mika/build.gradle.kts still
     has the two Maven lines (mika/tools/check-manifest.py reads them); settings.gradle.kts switches Shizuku ON by default (8F; was OFF until 8E); gradle.properties documents includeShizuku and shizukuAbis.
  9. (4F-1) the manifest side, what can be checked without a build and without the fetched sources: the overlay app/src/shizuku/AndroidManifest.xml is present and has exactly the shape of
     4B-2 (no package, one <application> with one <provider rikka.shizuku.ShizukuProvider tools:node="remove">); it is wired in app/build.gradle.kts only inside `if (shizukuIncluded) { }`,
     exactly for the source sets debug and release, and no other build file mentions src/shizuku; app/src has no debug / release manifest of its own (srcFile would replace it); no
     `ShizukuProvider` string anywhere in app/src/main (a removal there would act in every build); the helper scripts are callable: check-provider-match.py (--self-test, and without the
     fetched sources exit 2), patch-upstream.py (--help, and --check on an empty checkout folder fails with its own message, not a traceback), patch-upstream.sh (the same through bash),
     check-merged-manifest.py (--help) and test-check-merged-manifest.py (--list).
  10. (5B-2) native libraries: libshizuku.so is started from the host app's native library folder, so :app keeps packaging { jniLibs { useLegacyPackaging = true } } and
     android:extractNativeLibs="true"; the default of shizukuAbis names all four ABIs and feeds both ndk and cmake abiFilters; an uncommented shizukuAbis in gradle.properties covers every ABI
     the APK ships (apkAbis, or all four); the patch script drops extractNativeLibs from the library manifest.
  11. (5C) binder hand-over: the patch script keeps the binder extra key (moe.shizuku.privileged.api.intent.extra.BINDER) as upstream has it in the four files that spell it
     (BINDER_EXTRA_KEPT names ShizukuService, ServiceStarter, ShizukuManagerProvider and the API ShizukuProvider), replaces the old package name only through OLD_NAME_RE
     (a plain replace of the old name would rename the key too and no outside Shizuku client would get the binder), and its self-check calls check_binder_protocol.
  12. (5D) intent actions: the patch script's table of custom manifest actions (MANIFEST_ACTIONS) names REQUEST_PERMISSION and REQUEST_AUTHORIZATION through the ${applicationId} placeholder and the
     rikka REQUEST_BINDER, BINDER_ACTION_FILES names the three files that spell the REQUEST_BINDER literal (shell loader, manager handler, manager receiver), ACTION_LITERALS_ALLOWED exists,
     and its self-check calls check_intent_actions (an action name that follows the host must stay built from the host package, one that outside clients know must stay as upstream has it).
  13. (5E) pairing-service timeout: the patch script names the file (PAIRING_SERVICE = .../adb/AdbPairingService.kt), requires both onTimeout signatures (PAIRING_TIMEOUT_SIGS: startId; startId + fgsType),
     inserts code that calls stopForeground(STOP_FOREGROUND_REMOVE) and stopSelf() (PAIRING_TIMEOUT_CODE), main() calls patch_pairing_service(root) and its self-check calls check_pairing_timeout
     (without the override a pairing that takes longer than the short-service limit crashes the main process on Android 14+).
  14. (5F) direct boot: the patch script names the five components that lose android:directBootAware (DIRECT_BOOT_COMPONENTS: BootCompleteReceiver, ShizukuReceiver, ShizukuManagerProvider and, found on the real tree in 5G, RequestPermissionActivity, ShellRequestHandlerActivity),
     main() calls patch_direct_boot(root) right after patch_manifest(root), its self-check calls check_direct_boot, and the merged-manifest checker registers its two rules of row 5F
     ('5F direct boot', '5F custom actions'); without them the host process would start before the first unlock because of Shizuku (finding 12).
  15. (5G) night mode (finding 14): the patch script names AppActivity, SettingsFragment and ShizukuApplication (APP_ACTIVITY, SETTINGS_FRAGMENT, SHIZUKU_APPLICATION), the process-wide setter (NIGHT_SETTER) and the
     per-activity call (NIGHT_CALL = delegate.localNightMode = ShizukuSettings.getNightMode()); its inserted code (NIGHT_ATTACH_CODE) sets it before super.attachBaseContext inside try / catch (Throwable);
     main() calls patch_night_mode(root) right after patch_direct_boot(root) and its self-check calls check_night_mode (without it one tap on Dark in Shizuku's Settings would force the whole host dark).
Run from anywhere:  python3 shizuku/tools/check-gradle.py [--no-run]   (exit code 1 = a problem was found; 3D / 3E modules that do not exist yet are reported as "not written yet", not as errors)
  --no-run      skip the runs of the helper scripts in item 9 (the static rules of item 9 still run)
  --self-test   (4F-1) copies the files this script reads into a temp folder, breaks one thing at a time and expects exit 1 with the right message; no Gradle, no network
"""
import os, re, shutil, subprocess, sys, tempfile
import xml.etree.ElementTree as ET

ROOT = os.path.abspath(os.path.join(os.path.dirname(__file__), '..', '..'))
SHIZUKU = os.path.join(ROOT, 'shizuku')
errors, notes = [], []


def err(msg): errors.append(msg)


def self_test():
    """4F-1: the rules of item 9 on a copy of the project, one broken thing at a time. Returns 0 / 1."""
    me = os.path.abspath(__file__)
    need_files = ['settings.gradle.kts', 'build.gradle.kts', 'gradle.properties', os.path.join('app', 'build.gradle.kts'), os.path.join('mika', 'build.gradle.kts'),
                  os.path.join('app', 'src', 'main', 'AndroidManifest.xml'), os.path.join('app', 'src', 'shizuku', 'AndroidManifest.xml')]

    def build():
        d = tempfile.mkdtemp(prefix='check-gradle-')
        for f in need_files:
            os.makedirs(os.path.dirname(os.path.join(d, f)), exist_ok=True)
            shutil.copy(os.path.join(ROOT, f), os.path.join(d, f))
        shutil.copytree(SHIZUKU, os.path.join(d, 'shizuku'), ignore=shutil.ignore_patterns('upstream', '__pycache__'))
        return d

    def edit(d, rel, old, new, count=1):
        path = os.path.join(d, rel)
        t = open(path, encoding='utf-8').read()
        assert t.count(old) == count, f'self-test bug: {rel} has {t.count(old)} x {old[:50]!r}'
        open(path, 'w', encoding='utf-8').write(t.replace(old, new))

    def append(d, rel, text):
        os.makedirs(os.path.dirname(os.path.join(d, rel)), exist_ok=True)
        with open(os.path.join(d, rel), 'a', encoding='utf-8') as f: f.write(text)

    def delete(d, rel): os.remove(os.path.join(d, rel))
    OV, APP, MIKA = os.path.join('app', 'src', 'shizuku', 'AndroidManifest.xml'), os.path.join('app', 'build.gradle.kts'), os.path.join('mika', 'build.gradle.kts')
    WIRE_D = 'sourceSets.getByName("debug").manifest.srcFile("src/shizuku/AndroidManifest.xml")'
    WIRE_R = 'sourceSets.getByName("release").manifest.srcFile("src/shizuku/AndroidManifest.xml")'
    TOOLS = os.path.join('shizuku', 'tools')
    cases = [
        ('good copy', lambda d: None, 0, ''),
        ('overlay missing', lambda d: delete(d, OV), 1, '4F-1 overlay'),
        ('overlay is not XML', lambda d: open(os.path.join(d, OV), 'w').write('<manifest'), 1, 'not valid XML'),
        ('overlay has a package attribute', lambda d: edit(d, OV, '<manifest xmlns:android', '<manifest package="x.y" xmlns:android'), 1, 'package attribute'),
        ('overlay marker is not remove', lambda d: edit(d, OV, 'tools:node="remove"', 'tools:node="merge"'), 1, 'tools:node="remove"'),
        ('overlay marker missing', lambda d: edit(d, OV, 'tools:node="remove"', ''), 1, 'tools:node="remove"'),
        ('overlay removes another name', lambda d: edit(d, OV, '<provider\n            android:name="rikka.shizuku.ShizukuProvider"', '<provider\n            android:name="moe.shizuku.manager.ShizukuManagerProvider"'), 1, 'rikka.shizuku.ShizukuProvider'),
        ('overlay has a second element in <application>', lambda d: edit(d, OV, '</application>', '<service android:name="x.S" tools:node="remove" /></application>'), 1, 'exactly one'),
        ('overlay has an element outside <application>', lambda d: edit(d, OV, '<application>', '<uses-permission android:name="x.P" /><application>'), 1, 'exactly one <application>'),
        ('overlay <application> has attributes', lambda d: edit(d, OV, '<application>', '<application android:label="x">'), 1, 'attributes'),
        ('overlay provider has children', lambda d: edit(d, OV, 'tools:node="remove" />', 'tools:node="remove"><meta-data android:name="a" android:value="b" /></provider>'), 1, 'children'),
        ('wiring moved outside the if block', lambda d: edit(d, APP, '    if (shizukuIncluded) {\n        sourceSets.getByName("debug")', '    run {\n        sourceSets.getByName("debug")'), 1, 'shizukuIncluded'),
        ('only debug is wired', lambda d: edit(d, APP, WIRE_R, ''), 1, 'once for debug and once for release'),
        ('only release is wired', lambda d: edit(d, APP, WIRE_D, ''), 1, 'once for debug and once for release'),
        ('wired a third time (main)', lambda d: edit(d, APP, WIRE_D, WIRE_D + '\n        sourceSets.getByName("main").manifest.srcFile("src/shizuku/AndroidManifest.xml")'), 1, 'once for debug and once for release'),
        ('wired in the else branch', lambda d: edit(d, APP, WIRE_R + '\n    }', WIRE_R + '\n    } else {\n        ' + WIRE_D + '\n    }'), 1, 'shizukuIncluded'),
        ('wired under the negated switch', lambda d: edit(d, APP, '    if (shizukuIncluded) {\n        sourceSets.getByName("debug")', '    if (!shizukuIncluded) {\n        sourceSets.getByName("debug")'), 1, 'shizukuIncluded'),
        ('another build file mentions src/shizuku', lambda d: append(d, MIKA, '\nval x = "src/shizuku/AndroidManifest.xml"\n'), 1, 'mika/build.gradle.kts'),
        ('8F: default flipped back to false', lambda d: edit(d, 'settings.gradle.kts', '?: "true") == "true"', '?: "false") == "true"'), 1, '8F default'),
        ('8F: gradle.properties sets includeShizuku=false', lambda d: append(d, 'gradle.properties', '\nincludeShizuku=false\n'), 1, '8F default'),
        ('8F: gradle.properties sets includeShizuku=true (fine)', lambda d: append(d, 'gradle.properties', '\nincludeShizuku=true\n'), 0, ''),
        ('8F: the commented opt-out is fine', lambda d: append(d, 'gradle.properties', '\n# includeShizuku=false\n'), 0, ''),
        ('a comment about src/shizuku is fine', lambda d: append(d, MIKA, '\n// see src/shizuku/AndroidManifest.xml\n'), 0, ''),
        ('app/src/debug has a manifest', lambda d: append(d, os.path.join('app', 'src', 'debug', 'AndroidManifest.xml'), '<manifest/>'), 1, 'app/src/debug'),
        ('app/src/release has a manifest', lambda d: append(d, os.path.join('app', 'src', 'release', 'AndroidManifest.xml'), '<manifest/>'), 1, 'app/src/release'),
        ('ShizukuProvider in the src/main manifest', lambda d: edit(d, os.path.join('app', 'src', 'main', 'AndroidManifest.xml'), '<application', '<!-- rikka.shizuku.ShizukuProvider -->\n    <application', 1), 1, 'ShizukuProvider'),
        ('ShizukuProvider in a Kotlin file of src/main', lambda d: append(d, os.path.join('app', 'src', 'main', 'java', 'x', 'A.kt'), 'val n = "ShizukuProvider"\n'), 1, 'A.kt'),
        ('"Shizuku provider" with a space is not the string', lambda d: append(d, os.path.join('app', 'src', 'main', 'java', 'x', 'B.kt'), '// Shizuku provider\n'), 0, ''),
        ('check-provider-match.py missing', lambda d: delete(d, os.path.join(TOOLS, 'check-provider-match.py')), 1, 'check-provider-match.py'),
        ('check-provider-match.py --self-test fails', lambda d: open(os.path.join(d, TOOLS, 'check-provider-match.py'), 'w').write('import sys\nsys.exit(3)\n'), 1, 'check-provider-match.py'),
        ('patch-upstream.py --help fails', lambda d: open(os.path.join(d, TOOLS, 'patch-upstream.py'), 'w').write('import sys\nsys.exit(4)\n'), 1, 'patch-upstream.py'),
        ('patch-upstream.py has no --check message', lambda d: open(os.path.join(d, TOOLS, 'patch-upstream.py'), 'w').write('import sys\nprint("usage --check --help")\n'), 1, 'patch-upstream.py'),
        ('patch-upstream.sh missing', lambda d: delete(d, os.path.join(TOOLS, 'patch-upstream.sh')), 1, 'patch-upstream.sh'),
        ('check-merged-manifest.py missing', lambda d: delete(d, os.path.join(TOOLS, 'check-merged-manifest.py')), 1, 'check-merged-manifest.py'),
        ('test-check-merged-manifest.py missing', lambda d: delete(d, os.path.join(TOOLS, 'test-check-merged-manifest.py')), 1, 'test-check-merged-manifest.py'),
        ('test-check-merged-manifest.py --list fails', lambda d: open(os.path.join(d, TOOLS, 'test-check-merged-manifest.py'), 'w').write('import sys\nsys.exit(1)\n'), 1, 'test-check-merged-manifest.py'),
        ('useLegacyPackaging removed from :app', lambda d: edit(d, APP, 'useLegacyPackaging = true', ''), 1, '5B-2 packaging'),
        ('useLegacyPackaging set to false', lambda d: edit(d, APP, 'useLegacyPackaging = true', 'useLegacyPackaging = false'), 1, '5B-2 packaging'),
        ('extractNativeLibs removed from the :app manifest', lambda d: edit(d, os.path.join('app', 'src', 'main', 'AndroidManifest.xml'), 'android:extractNativeLibs="true"', ''), 1, '5B-2 manifest'),
        ('extractNativeLibs false in the :app manifest', lambda d: edit(d, os.path.join('app', 'src', 'main', 'AndroidManifest.xml'), 'android:extractNativeLibs="true"', 'android:extractNativeLibs="false"'), 1, '5B-2 manifest'),
        ('default shizukuAbis narrowed', lambda d: edit(d, os.path.join('shizuku', 'build.gradle.kts'), '"arm64-v8a,armeabi-v7a,x86,x86_64"', '"arm64-v8a"'), 1, '5B-2 abis'),
        ('cmake abiFilters no longer fed by shizukuAbis', lambda d: edit(d, os.path.join('shizuku', 'build.gradle.kts'), '                abiFilters += shizukuAbis\n', ''), 1, 'both ndk'),
        ('gradle.properties narrows shizukuAbis below the APK', lambda d: append(d, 'gradle.properties', '\nshizukuAbis=arm64-v8a\n'), 1, '5B-2 abis property'),
        ('shizukuAbis covers a narrowed apkAbis', lambda d: append(d, 'gradle.properties', '\napkAbis=arm64-v8a\nshizukuAbis=arm64-v8a,armeabi-v7a\n'), 0, ''),
        ('apkAbis wider than shizukuAbis', lambda d: append(d, 'gradle.properties', '\napkAbis=arm64-v8a,x86\nshizukuAbis=arm64-v8a\n'), 1, '5B-2 abis property'),
        ('a commented shizukuAbis line is not a setting', lambda d: append(d, 'gradle.properties', '\n#shizukuAbis=arm64-v8a\n'), 0, ''),
        ('patch script keeps extractNativeLibs', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "'extractNativeLibs']", "]"), 1, '5B-2 patch'),
        ('BINDER_EXTRA_KEPT loses ServiceStarter', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "    'starter/src/main/java/moe/shizuku/starter/ServiceStarter.java': 1,\n", ''), 1, '5C binder keys'),
        ('patch_package renames the binder extra key too', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), 'OLD_NAME_RE.sub(host, s)', 's.replace(OLD_PKG, host)'), 1, '5C binder patch'),
        ('check() no longer calls check_binder_protocol', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    check_native_package(root, host, errors)\n    check_binder_protocol(root, host, errors)\n', '    check_native_package(root, host, errors)\n'), 1, '5C binder check'),
        ('MANIFEST_ACTIONS loses REQUEST_AUTHORIZATION', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "    '${applicationId}' + ACTION_AUTHORIZATION_SUFFIX: ['.legacy.LegacyIsNotSupportedActivity'],\n", ''), 1, '5D action table'),
        ('REQUEST_PERMISSION action named without the host placeholder', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "    '${applicationId}' + ACTION_PERMISSION_SUFFIX: ['.authorization.RequestPermissionActivity'],\n", "    'com.srizwan.win11' + ACTION_PERMISSION_SUFFIX: ['.authorization.RequestPermissionActivity'],\n"), 1, '5D action table'),
        ('BINDER_ACTION_FILES loses the shell loader', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "    'shell/src/main/java/rikka/shizuku/shell/ShizukuShellLoader.java': 2,\n    'manager/src/main/java/moe/shizuku/manager/shell/ShellBinderRequestHandler.kt'", "    'manager/src/main/java/moe/shizuku/manager/shell/ShellBinderRequestHandler.kt'"), 1, '5D binder action'),
        ('check() no longer calls check_intent_actions', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    check_intent_actions(root, man, host, errors)\n', ''), 1, '5D action check'),
        ('PAIRING_SERVICE points at another file', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "adb/AdbPairingService.kt'\nPAIRING_CLASS_RE", "adb/AdbPairingTutorialActivity.kt'\nPAIRING_CLASS_RE"), 1, '5E pairing file'),
        ('PAIRING_TIMEOUT_SIGS loses the API 35 signature', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "'onTimeout(startId, fgsType)',\n}", "'x',\n}"), 1, '5E pairing signatures'),
        ('inserted code loses stopSelf in one override', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    override fun onTimeout(startId: Int, fgsType: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n', '    override fun onTimeout(startId: Int, fgsType: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n'), 1, '5E pairing code'),
        ('main() no longer calls patch_pairing_service', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    patch_pairing_service(root)\n', ''), 1, '5E pairing patch'),
        ('check() no longer calls check_pairing_timeout', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    check_pairing_timeout(root, errors)\n', ''), 1, '5E pairing check'),
        ('DIRECT_BOOT_COMPONENTS loses the provider', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), ", ('provider', '.ShizukuManagerProvider'),\n    ('activity'", ",\n    ('activity'"), 1, '5F direct boot components'),
        ('DIRECT_BOOT_COMPONENTS loses RequestPermissionActivity', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "    ('activity', '.authorization.RequestPermissionActivity'), ", "    "), 1, '5F direct boot components'),
        ('NIGHT_CALL changes', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "NIGHT_CALL = 'delegate.localNightMode = ", "NIGHT_CALL = 'x.localNightMode = "), 1, '5G night mode call'),
        ('inserted code loses the try', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), "        try {\n            delegate.localNightMode", "        run {\n            delegate.localNightMode"), 1, '5G night mode code'),
        ('main() no longer calls patch_night_mode', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    patch_night_mode(root)\n', ''), 1, '5G night mode patch'),
        ('check() no longer calls check_night_mode', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    check_night_mode(root, man, errors)\n', ''), 1, '5G night mode check'),
        ('main() no longer calls patch_direct_boot', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    patch_direct_boot(root)\n', ''), 1, '5F direct boot patch'),
        ('check() no longer calls check_direct_boot', lambda d: edit(d, os.path.join('shizuku', 'tools', 'patch-upstream.py'), '    check_direct_boot(man, errors)\n', ''), 1, '5F direct boot check'),
        ('merged checker loses the direct-boot rule', lambda d: edit(d, os.path.join('shizuku', 'tools', 'check-merged-manifest.py'), '@rule("5F direct boot"', '@rule("5F boot"'), 1, '5F merged rule'),
        ('merged checker loses the custom-action rule', lambda d: edit(d, os.path.join('shizuku', 'tools', 'check-merged-manifest.py'), '@rule("5F custom actions"', '@rule("5F actions"'), 1, '5F merged rule'),
        ('broken tool with --no-run is not run', lambda d: delete(d, os.path.join(TOOLS, 'check-provider-match.py')), 0, '--no-run'),
    ]
    bad = 0
    for name, fn, want, text in cases:
        d = build()
        try:
            fn(d)
            extra = ['--no-run'] if text == '--no-run' else []
            p = subprocess.run([sys.executable, '-I', os.path.join(d, 'shizuku', 'tools', 'check-gradle.py')] + extra, capture_output=True, text=True, timeout=120)
            out = p.stdout + p.stderr
            ok = p.returncode == want and (want == 0 or text in out) and 'Traceback' not in out
            first = next((l for l in out.splitlines() if l.startswith('ERROR')), out.strip().splitlines()[-1] if out.strip() else '')
        finally:
            shutil.rmtree(d, ignore_errors=True)
        bad += 0 if ok else 1
        print('  [%s] %s%s' % ('ok  ' if ok else 'FAIL', name, '' if ok and want == 0 else '  -> ' + first[:130]))
    print('self-test: %d of %d cases as expected' % (len(cases) - bad, len(cases)))
    return 1 if bad else 0


if '--self-test' in sys.argv:
    sys.exit(self_test())


def balance(path):
    s = open(path, encoding='utf-8').read()
    stack, i, n, line = [], 0, len(s), 1
    pairs = {')': '(', '}': '{', ']': '['}
    # tokenizer state: stack of modes; 'code' brace depth tracked for ${ } in strings
    modes = ['code']          # 'code' | ('str', raw) handled inline
    tmpl = []                 # stack of brace-stack depths where a ${ started
    def fail(msg): err(f'{os.path.relpath(path, ROOT)}:{line}: {msg}')
    while i < n:
        c = s[i]
        if c == '\n': line += 1
        if s.startswith('//', i):
            j = s.find('\n', i); i = n if j < 0 else j; continue
        if s.startswith('/*', i):
            depth, i = 1, i + 2
            while i < n and depth:
                if s.startswith('/*', i): depth += 1; i += 2
                elif s.startswith('*/', i): depth -= 1; i += 2
                else:
                    if s[i] == '\n': line += 1
                    i += 1
            if depth: fail('unterminated /* comment')
            continue
        if c == "'":
            j = i + 1
            while j < n and s[j] != "'" and s[j] != '\n':
                j += 2 if s[j] == '\\' else 1
            if j >= n or s[j] != "'": fail('unterminated char literal'); return
            i = j + 1; continue
        if c == '"':
            raw = s.startswith('"""', i)
            i += 3 if raw else 1
            # scan the string body; ${ ... } switches back to code
            while True:
                if i >= n: fail('unterminated string'); return
                ch = s[i]
                if ch == '\n':
                    line += 1
                    if not raw: fail('newline in a normal string'); return
                if not raw and ch == '\\': i += 2; continue
                if raw and s.startswith('"""', i):
                    i += 3
                    while i < n and s[i] == '"': i += 1
                    break
                if not raw and ch == '"': i += 1; break
                if ch == '$' and s.startswith('${', i):
                    # find the matching } with a nested scan (strings inside are handled by recursion on the substring)
                    depth, j = 1, i + 2
                    while j < n and depth:
                        if s[j] == '{': depth += 1
                        elif s[j] == '}': depth -= 1
                        elif s[j] == '"':
                            k = j + 1
                            while k < n and s[k] != '"': k += 2 if s[k] == '\\' else 1
                            j = k
                        elif s[j] == '\n': line += 1
                        j += 1
                    if depth: fail('unterminated ${ in a string'); return
                    i = j; continue
                i += 1
            continue
        if c in '({[': stack.append((c, line))
        elif c in ')}]':
            if not stack: fail(f"unmatched '{c}'"); return
            o, ol = stack.pop()
            if o != pairs[c]: fail(f"'{c}' closes '{o}' opened in line {ol}"); return
        i += 1
    if stack:
        o, ol = stack[-1]
        err(f'{os.path.relpath(path, ROOT)}:{ol}: unclosed \'{o}\'')


kts = [os.path.join(ROOT, 'settings.gradle.kts'), os.path.join(ROOT, 'build.gradle.kts'), os.path.join(ROOT, 'app', 'build.gradle.kts')]
for dp, dn, fs in os.walk(SHIZUKU):
    dn[:] = [d for d in dn if d != 'upstream']
    kts += [os.path.join(dp, f) for f in fs if f.endswith('.kts')]
for f in sorted(kts):
    balance(f)

# 2. settings.gradle.kts <-> module folders
settings = open(os.path.join(ROOT, 'settings.gradle.kts'), encoding='utf-8').read()
m = re.search(r'listOf\(([^)]*)\)\s*\)\s*\{\s*include\(":shizuku-\$sub"\)', settings)
subs = re.findall(r'"([a-z-]+)"', m.group(1)) if m else []
if not subs: err('settings.gradle.kts: the include list of the shizuku-* projects was not found')
modules_dir = os.path.join(SHIZUKU, 'modules')
folders = sorted(d for d in os.listdir(modules_dir) if os.path.isdir(os.path.join(modules_dir, d))) if os.path.isdir(modules_dir) else []
for s in subs:
    if not os.path.isfile(os.path.join(modules_dir, s, 'build.gradle.kts')):
        notes.append(f'module shizuku-{s} (shizuku/modules/{s}): build file not written yet')
for d in folders:
    if d not in subs: err(f'shizuku/modules/{d} is not in the include list of settings.gradle.kts')
if not os.path.isfile(os.path.join(SHIZUKU, 'build.gradle.kts')):
    notes.append('module shizuku (shizuku/build.gradle.kts): build file not written yet')

# 3. apply(from) + project(":x")
known = {':shizuku'} | {f':shizuku-{s}' for s in subs} | {':app', ':mika', ':mika-core'}
namespaces = {}
for f in sorted(kts):
    if not f.startswith(SHIZUKU): continue
    t = re.sub(r'(?m)^\s*//.*$', '', open(f, encoding='utf-8').read())   # whole-line comments (usage examples) are not code
    rel = os.path.relpath(f, ROOT)
    for a in re.findall(r'apply\(from\s*=\s*"([^"]+)"\)', t):
        if not os.path.isfile(os.path.normpath(os.path.join(os.path.dirname(f), a))):
            err(f'{rel}: apply(from = "{a}") does not exist')
    for p in re.findall(r'project\("(:[^"]+)"\)', t):
        if p not in known: err(f'{rel}: project("{p}") is not an included project')
    ns = re.search(r'namespace\s*=\s*"([^"]+)"', t)
    if ns:
        if ns.group(1) in namespaces: err(f'{rel}: namespace {ns.group(1)} already used by {namespaces[ns.group(1)]}')
        namespaces[ns.group(1)] = rel
    # 5. extras before apply
    if 'after-fetch.gradle.kts' in t and not f.endswith('after-fetch.gradle.kts'):
        ai = t.index('apply(from')
        for key in ('shizukuUpstreamPath', 'shizukuWired'):
            k = t.find(f'extra["{key}"]')
            if k < 0 or k > ai:
                if key == 'shizukuUpstreamPath' and 'shizukuWired' not in t: pass
                err(f'{rel}: extra["{key}"] must be set before apply(from = ".../after-fetch.gradle.kts")')

# 7. (3E) Kotlin plugin <-> wired "kotlin"; proguard files exist; :shizuku defines the tasks the other modules wait for
for f in sorted(kts):
    if not f.startswith(SHIZUKU) or f.endswith('after-fetch.gradle.kts'): continue
    raw = open(f, encoding='utf-8').read()
    t = re.sub(r'(?m)^\s*//.*$', '', raw)
    rel = os.path.relpath(f, ROOT)
    w = re.search(r'extra\["shizukuWired"\]\s*=\s*listOf\(([^)]*)\)', t)
    if w:
        wired_kotlin = '"kotlin"' in w.group(1)
        has_plugin = 'id("org.jetbrains.kotlin.android")' in t
        if wired_kotlin and not has_plugin: err(f'{rel}: wires "kotlin" sources but does not apply id("org.jetbrains.kotlin.android")')
        if has_plugin and not wired_kotlin: err(f'{rel}: applies the Kotlin plugin but extra["shizukuWired"] has no "kotlin"')
    for pf in re.findall(r'(?:consumerProguardFiles|proguardFiles)\(([^)]*)\)', t):
        for name in re.findall(r'"([^"$]+\.pro)"', pf):
            if not os.path.isfile(os.path.join(os.path.dirname(f), name)):
                err(f'{rel}: proguard file "{name}" does not exist next to the build file')
root_build = os.path.join(SHIZUKU, 'build.gradle.kts')
if os.path.isfile(root_build):
    rb = re.sub(r'(?m)^\s*//.*$', '', open(root_build, encoding='utf-8').read())
    for tname in ('fetchShizukuUpstream', 'patchShizukuUpstream', 'shizukuRishDex'):
        if f'"{tname}"' not in rb: err(f'shizuku/build.gradle.kts: task "{tname}" is not registered')
    for need in ('modules/after-fetch.gradle.kts',):
        if need not in rb: err(f'shizuku/build.gradle.kts: does not apply {need}')
    for key in ('shizukuUpstreamPath', 'shizukuWired'):
        k = rb.find(f'extra["{key}"]'); a = rb.find('apply(from')
        if k < 0 or k > a: err(f'shizuku/build.gradle.kts: extra["{key}"] must be set before apply(from = ...)')

# 5. no cycle in project(...) dependencies
graph = {}
for f in kts:
    if f.endswith('after-fetch.gradle.kts'): continue
    if f == os.path.join(SHIZUKU, 'build.gradle.kts'): node = ':shizuku'
    elif f.startswith(modules_dir): node = ':shizuku-' + os.path.basename(os.path.dirname(f))
    else: continue
    t = re.sub(r'(?m)^\s*//.*$', '', open(f, encoding='utf-8').read())
    graph[node] = set(re.findall(r'project\("(:[^"]+)"\)', t))
state = {}
def dfs(n, path):
    state[n] = 1
    for m in sorted(graph.get(n, ())):
        if state.get(m) == 1: err('dependency cycle: ' + ' -> '.join(path + [n, m])); continue
        if state.get(m) is None: dfs(m, path + [n])
    state[n] = 2
for n in sorted(graph):
    if state.get(n) is None: dfs(n, [])

# 8. (3F) root / :app side
def code(path):
    """file text without whole-line comments (they explain, they are not code)"""
    return re.sub(r'(?m)^\s*//.*$', '', open(path, encoding='utf-8').read())

root_kts, app_kts = os.path.join(ROOT, 'build.gradle.kts'), os.path.join(ROOT, 'app', 'build.gradle.kts')
mika_kts, props = os.path.join(ROOT, 'mika', 'build.gradle.kts'), os.path.join(ROOT, 'gradle.properties')
rt, at = code(root_kts), code(app_kts)

# 8a. substitution in the root build file
sub_map = dict(re.findall(r'"(dev\.rikka\.shizuku:[a-z-]+)"\s+to\s+"(:[^"]+)"', rt))
if not sub_map: err('build.gradle.kts: no dev.rikka.shizuku:<x> -> :shizuku-<x> substitution map (3F) found')
if 'findProject(":shizuku-api") != null' not in rt: err('build.gradle.kts: the substitution is not behind findProject(":shizuku-api") != null (it would fail with the switch off)')
if 'dependencySubstitution' not in rt or 'substitute(module(' not in rt or '.using(project(' not in rt:
    err('build.gradle.kts: dependencySubstitution { substitute(module(..)).using(project(..)) } not found')
for artifact, target in sub_map.items():
    if target not in known: err(f'build.gradle.kts: {artifact} is substituted by {target}, which is not an included Shizuku project')
    if artifact.split(':')[1] != target.replace(':shizuku-', ''): err(f'build.gradle.kts: {artifact} -> {target}: name mismatch')
asked = {}
for f in sorted(os.listdir(ROOT)):    # every build file of the project (top-level folders), not the fetched sources
    fp = os.path.join(ROOT, f)
    for cand in ([fp] if f.endswith('.kts') else [os.path.join(fp, 'build.gradle.kts')] if os.path.isdir(fp) and f != 'upstream' else []):
        if os.path.isfile(cand):
            for coord in re.findall(r'"(dev\.rikka\.shizuku:[a-z-]+):[^"]*"', code(cand)):
                asked.setdefault(coord, []).append(os.path.relpath(cand, ROOT))
for dp, dn, fs in os.walk(modules_dir):
    for f in fs:
        if f.endswith('.kts'):
            for coord in re.findall(r'"(dev\.rikka\.shizuku:[a-z-]+)[:"]', code(os.path.join(dp, f))):
                err(f'{os.path.relpath(os.path.join(dp, f), ROOT)}: asks for {coord} from Maven: the root substitution would turn it into a dependency on itself')
for coord, who in asked.items():
    if coord not in sub_map: err(f'{who[0]}: asks for the Maven artifact {coord}, which build.gradle.kts does not substitute: duplicate classes once :shizuku-api is on the class path')
if not any(c.endswith(':api') for c in asked) or not any(c.endswith(':provider') for c in asked):
    notes.append('mika/build.gradle.kts no longer asks for dev.rikka.shizuku:api / :provider: the root substitution has nothing to replace (not an error, but mika/tools/check-manifest.py expects the lines)')
if os.path.isfile(mika_kts) and 'dev.rikka.shizuku' not in open(mika_kts, encoding='utf-8').read():
    err('mika/build.gradle.kts has no dev.rikka.shizuku dependency (mika/tools/check-manifest.py needs it)')

# 8b. :app
if 'val shizukuIncluded: Boolean = rootProject.findProject(":shizuku") != null' not in at: err('app/build.gradle.kts: shizukuIncluded is not defined from findProject(":shizuku")')
for what, pat in (('implementation(project(":shizuku"))', r'if \(shizukuIncluded\)\s*\{\s*implementation\(project\(":shizuku"\)\)\s*\}'),
                  ('the exclusion of dev.rikka.rikkax.appcompat', r'if \(shizukuIncluded\)\s*\{\s*configurations\.configureEach\s*\{\s*exclude\(group = "dev\.rikka\.rikkax\.appcompat", module = "appcompat"\)\s*\}\s*\}')):
    if not re.search(pat, at): err(f'app/build.gradle.kts: {what} is missing or not behind `if (shizukuIncluded)`')
if re.search(r'project\("(:shizuku[^"]*)"\)', at) and set(re.findall(r'project\("(:shizuku[^"]*)"\)', at)) != {':shizuku'}:
    err('app/build.gradle.kts: depends on a :shizuku-* helper directly (only :shizuku belongs here)')
for f in sorted(kts):                 # nothing outside the shizuku modules may depend on the application module :shizuku-shell
    if not f.startswith(SHIZUKU) and ':shizuku-shell' in code(f): err(f'{os.path.relpath(f, ROOT)}: depends on :shizuku-shell (an application module: its APK must never be part of Win11)')
for f in kts:
    if f.startswith(modules_dir) and f != os.path.join(modules_dir, 'shell', 'build.gradle.kts') and 'project(":shizuku-shell")' in code(f):
        err(f'{os.path.relpath(f, ROOT)}: depends on :shizuku-shell (only :shizuku may, through the dex task, never as a dependency)')

# 8c. (8F) the switch is ON by default, and documented
if '?: "true") == "true"' not in re.sub(r'(?m)^\s*//.*$', '', settings): err('8F default: settings.gradle.kts: includeShizuku is not ON by default (8F flipped it; `?: "true"`)')
pt = open(props, encoding='utf-8').read()
for key in ('includeShizuku', 'shizukuAbis'):
    if not re.search(r'(?m)^# ' + key + r'[= ]', pt): err(f'gradle.properties: {key} is not documented')
if re.search(r'(?m)^includeShizuku\s*=\s*false\b', pt): err('8F default: gradle.properties: includeShizuku=false is set (the opt-out must stay a commented example; the workflows demand Shizuku)')

# 9. (4F-1) the manifest side, without a build and without the fetched sources
ov_rel = 'app/src/shizuku/AndroidManifest.xml'
ov_path = os.path.join(ROOT, 'app', 'src', 'shizuku', 'AndroidManifest.xml')
TOOLS_NS = '{http://schemas.android.com/tools}'
ANDROID_NS = '{http://schemas.android.com/apk/res/android}'
MIKA_PROVIDER = 'rikka.shizuku.ShizukuProvider'

# 9a. the overlay: present, and exactly the shape of 4B-2
if not os.path.isfile(ov_path):
    err(f'4F-1 overlay: {ov_rel} is missing (4B-2): with Shizuku on, Mika\'s provider and the manager\'s provider share one authority')
else:
    try:
        ovr = ET.parse(ov_path).getroot()
    except ET.ParseError as e:
        ovr = None
        err(f'4F-1 overlay: {ov_rel} is not valid XML: {e}')
    if ovr is not None:
        if ovr.tag != 'manifest': err(f'4F-1 overlay: {ov_rel}: the root element is <{ovr.tag}>, expected <manifest>')
        if 'package' in ovr.attrib: err(f'4F-1 overlay: {ov_rel} has a package attribute (AGP 8 takes the namespace; a second package would be read as another app)')
        kids = list(ovr)
        if len(kids) != 1 or kids[0].tag != 'application':
            err(f'4F-1 overlay: {ov_rel} must hold exactly one <application> and nothing else under <manifest> (found: {[k.tag for k in kids] or "nothing"})')
        else:
            appel = kids[0]
            if appel.attrib: err(f'4F-1 overlay: the <application> of {ov_rel} has attributes {sorted(appel.attrib)}: they would be merged into the app')
            ch = list(appel)
            if len(ch) != 1 or ch[0].tag != 'provider':
                err(f'4F-1 overlay: {ov_rel}: <application> must hold exactly one <provider> (found: {[c.tag for c in ch] or "nothing"})')
            else:
                pv = ch[0]
                if pv.get(ANDROID_NS + 'name') != MIKA_PROVIDER:
                    err(f'4F-1 overlay: the provider of {ov_rel} is named {pv.get(ANDROID_NS + "name")}, expected {MIKA_PROVIDER} (Mika\'s provider; the merger keys a provider by name)')
                if pv.get(TOOLS_NS + 'node') != 'remove':
                    err(f'4F-1 overlay: the provider of {ov_rel} has ' + (f'tools:node="{pv.get(TOOLS_NS + "node")}"' if pv.get(TOOLS_NS + 'node') else 'no tools:node') + ', expected tools:node="remove"')
                if list(pv): err(f'4F-1 overlay: the provider of {ov_rel} has children {[c.tag for c in pv]}: a marker must stay empty')

# 9b. wired only inside `if (shizukuIncluded) { }`, exactly for debug and release, and nowhere else
blank = re.sub(r'"(?:\\.|[^"\\\n])*"', lambda mm: '"' + ' ' * (len(mm.group(0)) - 2) + '"', at)    # same length, string bodies blanked, so braces inside strings do not count
inside = []
for mm in re.finditer(r'if\s*\(\s*shizukuIncluded\s*\)\s*\{', blank):
    depth, i = 0, mm.end() - 1
    while i < len(blank):
        if blank[i] == '{': depth += 1
        elif blank[i] == '}':
            depth -= 1
            if depth == 0: break
        i += 1
    inside.append((mm.end(), i))
refs = [mm.start() for mm in re.finditer(r'src/shizuku', at)]
for pos in refs:
    if not any(a <= pos < b for a, b in inside):
        err('4F-1 wiring: app/build.gradle.kts mentions src/shizuku outside `if (shizukuIncluded) { }` (line %d of the file without comment lines): with the switch off the overlay would remove Mika\'s provider in every build' % (at.count('\n', 0, pos) + 1))
wired = sorted(re.findall(r'sourceSets\.getByName\("([a-z]+)"\)\.manifest\.srcFile\("src/shizuku/AndroidManifest\.xml"\)', at))
if wired != ['debug', 'release'] or len(refs) != 2:
    err(f'4F-1 wiring: app/build.gradle.kts must wire src/shizuku/AndroidManifest.xml exactly once for debug and once for release (found {len(refs)} mention(s), source sets {wired})')
for dp, dn, fs in os.walk(ROOT):
    dn[:] = [d for d in dn if d not in ('.git', 'upstream', 'build', 'node_modules', '.gradle')]
    for f in fs:
        if f.endswith(('.kts', '.gradle')) and os.path.join(dp, f) != app_kts and 'src/shizuku' in code(os.path.join(dp, f)):
            err(f'4F-1 wiring: {os.path.relpath(os.path.join(dp, f), ROOT)} mentions src/shizuku: only app/build.gradle.kts wires the overlay')
for bt in ('debug', 'release'):
    if os.path.exists(os.path.join(ROOT, 'app', 'src', bt, 'AndroidManifest.xml')):
        err(f'4F-1 wiring: app/src/{bt}/AndroidManifest.xml exists: srcFile("src/shizuku/AndroidManifest.xml") replaces the manifest of the {bt} source set, so this file would be dropped (with Shizuku on)')

# 9c. no ShizukuProvider string in app/src/main (the removal must never act in every build, and nothing there may name the provider)
TEXT_EXT = ('.xml', '.kt', '.java', '.kts', '.gradle', '.pro', '.txt', '.json', '.md', '.properties', '.cfg', '.yml', '.yaml', '.html', '.js', '.css')
for dp, dn, fs in os.walk(os.path.join(ROOT, 'app', 'src', 'main')):
    for f in fs:
        if f.endswith(TEXT_EXT):
            fp = os.path.join(dp, f)
            try: txt = open(fp, encoding='utf-8', errors='ignore').read()
            except OSError: continue
            if 'ShizukuProvider' in txt:
                err(f'4F-1 src/main: {os.path.relpath(fp, ROOT)} contains the string ShizukuProvider: the removal belongs in app/src/shizuku only (it would act in every build, also in a :mika build without :shizuku)')

# 10. (5B-2) native libraries: libshizuku.so is RUN from the host's nativeLibraryDir, so it must be extracted to disk and exist for every ABI the APK ships
ALL_ABIS = {'arm64-v8a', 'armeabi-v7a', 'x86', 'x86_64'}
at10 = code(app_kts)
if not re.search(r'packaging\s*\{[\s\S]*?jniLibs\s*\{[^}]*?useLegacyPackaging\s*=\s*true', at10):
    err('5B-2 packaging: app/build.gradle.kts has no packaging { jniLibs { useLegacyPackaging = true } } (libshizuku.so is started from nativeLibraryDir: it must be extracted)')
app_manifest = os.path.join(ROOT, 'app', 'src', 'main', 'AndroidManifest.xml')
try:
    app_el = ET.parse(app_manifest).getroot().find('application')
    if app_el is None or app_el.get('{http://schemas.android.com/apk/res/android}extractNativeLibs') != 'true':
        err('5B-2 manifest: the <application> of app/src/main/AndroidManifest.xml has no android:extractNativeLibs="true"')
except (ET.ParseError, OSError) as e:
    err(f'5B-2 manifest: app/src/main/AndroidManifest.xml cannot be read ({e})')
shz_kts = os.path.join(SHIZUKU, 'build.gradle.kts')
if os.path.isfile(shz_kts):
    st = code(shz_kts)
    dm = re.search(r'findProperty\("shizukuAbis"\)\s*as\s*String\?\)\s*\?:\s*"([^"]+)"', st)
    if not dm:
        err('5B-2 abis: shizuku/build.gradle.kts: the default of shizukuAbis was not found')
    elif not ALL_ABIS <= {a.strip() for a in dm.group(1).split(',')}:
        err('5B-2 abis: shizuku/build.gradle.kts: the default of shizukuAbis is ' + dm.group(1) + ', it must name all four ABIs (a device of a missing ABI would have no libshizuku.so)')
    if len(re.findall(r'abiFilters\s*\+=\s*shizukuAbis', st)) < 2:
        err('5B-2 abis: shizuku/build.gradle.kts: shizukuAbis must feed both ndk { abiFilters } and cmake { abiFilters }')
def prop_abis(name):
    m = re.search(r'(?m)^' + name + r'\s*=\s*(\S+)', open(props, encoding='utf-8').read())
    return {a.strip() for a in m.group(1).split(',') if a.strip()} if m else None
shz_abis, apk_abis = prop_abis('shizukuAbis'), prop_abis('apkAbis')
if shz_abis is not None and not (apk_abis or ALL_ABIS) <= shz_abis:
    err('5B-2 abis property: gradle.properties sets shizukuAbis=' + ','.join(sorted(shz_abis)) + ' but the APK ships ' + ','.join(sorted(apk_abis or ALL_ABIS)) + ': libshizuku.so must exist for every ABI of the APK')
pu_text = open(os.path.join(SHIZUKU, 'tools', 'patch-upstream.py'), encoding='utf-8').read() if os.path.isfile(os.path.join(SHIZUKU, 'tools', 'patch-upstream.py')) else ''
if not re.search(r"APP_ATTRS_DROP\s*=\s*\[[^\]]*'extractNativeLibs'", pu_text):
    err("5B-2 patch: patch-upstream.py does not drop extractNativeLibs from the library manifest (APP_ATTRS_DROP)")

# 11. (5C) binder hand-over: the extra key is the one every Shizuku client knows, so the patch must not rename it
kept_m = re.search(r"BINDER_EXTRA_KEPT\s*=\s*\{([^}]*)\}", pu_text)
kept_body = kept_m.group(1) if kept_m else ''
for must in ('server/src/main/java/rikka/shizuku/server/ShizukuService.java', 'starter/src/main/java/moe/shizuku/starter/ServiceStarter.java',
             'manager/src/main/java/moe/shizuku/manager/ShizukuManagerProvider.kt', 'api/provider/src/main/java/rikka/shizuku/ShizukuProvider.java'):
    if must not in kept_body:
        err(f'5C binder keys: patch-upstream.py: BINDER_EXTRA_KEPT does not name {must} (the binder extra key must stay as upstream has it in every file that spells it)')
if 'OLD_NAME_RE.sub(host, s)' not in pu_text:
    err('5C binder patch: patch-upstream.py: patch_package does not replace the old name through OLD_NAME_RE.sub (a plain replace would also rename the binder extra key)')
if not re.search(r'check_native_package\(root, host, errors\)\s*\n\s*check_binder_protocol\(root, host, errors\)', pu_text):
    err('5C binder check: patch-upstream.py: check() does not call check_binder_protocol(root, host, errors)')

# 12. (5D) intent actions: names that follow the host go through the placeholder, names that outside clients know stay, and the self-check reads both
act_m = re.search(r"MANIFEST_ACTIONS\s*=\s*\{(.*?)\n\}", pu_text, re.S)
act_body = act_m.group(1) if act_m else ''
for must in ("'${applicationId}' + ACTION_PERMISSION_SUFFIX", "'${applicationId}' + ACTION_AUTHORIZATION_SUFFIX", 'ACTION_BINDER:'):
    if must not in act_body:
        err(f'5D action table: patch-upstream.py: MANIFEST_ACTIONS does not hold {must} (the custom actions of the manager manifest must be listed, the host-following ones through ${{applicationId}})')
if not re.search(r"ACTION_PERMISSION_SUFFIX\s*=\s*'\.intent\.action\.REQUEST_PERMISSION'", pu_text) or not re.search(r"ACTION_BINDER\s*=\s*'rikka\.shizuku\.intent\.action\.REQUEST_BINDER'", pu_text):
    err('5D action names: patch-upstream.py: ACTION_PERMISSION_SUFFIX / ACTION_BINDER are not the names upstream uses (.intent.action.REQUEST_PERMISSION, rikka.shizuku.intent.action.REQUEST_BINDER)')
bf_m = re.search(r"BINDER_ACTION_FILES\s*=\s*\{(.*?)\n\}", pu_text, re.S)
bf_body = bf_m.group(1) if bf_m else ''
for must in ('shell/src/main/java/rikka/shizuku/shell/ShizukuShellLoader.java', 'manager/src/main/java/moe/shizuku/manager/shell/ShellBinderRequestHandler.kt',
             'manager/src/main/java/moe/shizuku/manager/receiver/ShizukuReceiver.kt'):
    if must not in bf_body:
        err(f'5D binder action: patch-upstream.py: BINDER_ACTION_FILES does not name {must} (the REQUEST_BINDER literal is checked in every file that spells it)')
if 'ACTION_LITERALS_ALLOWED' not in pu_text:
    err('5D unknown actions: patch-upstream.py: ACTION_LITERALS_ALLOWED is gone (no check for an action name nobody decided on)')
if not re.search(r'check_binder_protocol\(root, host, errors\)\s*\n\s*check_intent_actions\(root, man, host, errors\)', pu_text):
    err('5D action check: patch-upstream.py: check() does not call check_intent_actions(root, man, host, errors)')

# 13. (5E) pairing-service timeout (finding 11): the patch adds the onTimeout overrides, the self-check reads them
if not re.search(r"PAIRING_SERVICE\s*=\s*'manager/src/main/java/moe/shizuku/manager/adb/AdbPairingService\.kt'", pu_text):
    err('5E pairing file: patch-upstream.py: PAIRING_SERVICE is not manager/src/main/java/moe/shizuku/manager/adb/AdbPairingService.kt (the service whose short-service limit is handled)')
sig_m = re.search(r"PAIRING_TIMEOUT_SIGS\s*=\s*\{(.*?)\n\}", pu_text, re.S)
sig_body = sig_m.group(1) if sig_m else ''
for must in ("'onTimeout(startId)'", "'onTimeout(startId, fgsType)'"):
    if must not in sig_body:
        err(f'5E pairing signatures: patch-upstream.py: PAIRING_TIMEOUT_SIGS does not hold {must} (Android 14 calls the one-argument form, Android 15+ the two-argument form: both must be overridden)')
code_m = re.search(r"PAIRING_TIMEOUT_CODE\s*=\s*\'\'\'(.*?)\'\'\'", pu_text, re.S)
code_body = code_m.group(1) if code_m else ''
if code_body.count('stopForeground(STOP_FOREGROUND_REMOVE)') != 2 or code_body.count('stopSelf()') != 2:
    err('5E pairing code: patch-upstream.py: PAIRING_TIMEOUT_CODE does not call stopForeground(STOP_FOREGROUND_REMOVE) and stopSelf() in each of the two overrides')
if not re.search(r'patch_library_code\(root, host\)\s*\n\s*patch_pairing_service\(root\)', pu_text):
    err('5E pairing patch: patch-upstream.py: main() does not call patch_pairing_service(root) after patch_library_code(root, host)')
if not re.search(r'check_intent_actions\(root, man, host, errors\)\s*\n\s*check_pairing_timeout\(root, errors\)', pu_text):
    err('5E pairing check: patch-upstream.py: check() does not call check_pairing_timeout(root, errors)')

# 14. (5F) direct boot (finding 12): the patch removes the flag and the LOCKED_BOOT_COMPLETED filter, the self-check and the merged-manifest checker read the result
dbc = re.search(r"DIRECT_BOOT_COMPONENTS\s*=\s*\{(.*?)\n\}", pu_text, re.S)
dbc_body = dbc.group(1) if dbc else ''
for must in ("'.receiver.BootCompleteReceiver'", "'.receiver.ShizukuReceiver'", "'.ShizukuManagerProvider'", "'.authorization.RequestPermissionActivity'", "'.legacy.ShellRequestHandlerActivity'"):
    if must not in dbc_body:
        err(f'5F direct boot components: patch-upstream.py: DIRECT_BOOT_COMPONENTS does not hold {must} (option a+ of finding 12 strips android:directBootAware from exactly these five)')
if not re.search(r'patch_manifest\(root\)\s*\n\s*patch_direct_boot\(root\)', pu_text):
    err('5F direct boot patch: patch-upstream.py: main() does not call patch_direct_boot(root) right after patch_manifest(root)')
if not re.search(r'check_shizuku_permissions\(man, errors\)\s*\n\s*check_direct_boot\(man, errors\)', pu_text):
    err('5F direct boot check: patch-upstream.py: check() does not call check_direct_boot(man, errors)')
cmm_path = os.path.join(SHIZUKU, 'tools', 'check-merged-manifest.py')
cmm_text = open(cmm_path, encoding='utf-8').read() if os.path.isfile(cmm_path) else ''
for rid in ('5F direct boot', '5F custom actions'):
    if '@rule("%s"' % rid not in cmm_text:
        err(f'5F merged rule: check-merged-manifest.py: the rule "{rid}" is not registered (the merged manifest must show no directBootAware / LOCKED_BOOT_COMPLETED and the custom actions only on their components)')

# 15. (5G) night mode (finding 14): per activity instead of AppCompat's process-wide default
for const in ('APP_ACTIVITY', 'SETTINGS_FRAGMENT', 'SHIZUKU_APPLICATION', 'NIGHT_SETTER', 'NIGHT_CALL', 'NIGHT_ATTACH_CODE'):
    if not re.search(r'^' + const + r'\s*=', pu_text, re.M):
        err(f'5G night mode constants: patch-upstream.py: {const} is not defined')
if "NIGHT_CALL = 'delegate.localNightMode = ShizukuSettings.getNightMode()'" not in pu_text:
    err('5G night mode call: patch-upstream.py: NIGHT_CALL is not delegate.localNightMode = ShizukuSettings.getNightMode()')
nac = re.search(r"NIGHT_ATTACH_CODE = '''(.*?)'''", pu_text, re.S)
nac_body = nac.group(1) if nac else ''
if not (nac_body.count('super.attachBaseContext(newBase)') == 1 and 'delegate.localNightMode = ShizukuSettings.getNightMode()' in nac_body
        and nac_body.index('delegate.localNightMode') < nac_body.index('super.attachBaseContext(newBase)') and 'try {' in nac_body and 'catch (e: Throwable)' in nac_body):
    err('5G night mode code: patch-upstream.py: NIGHT_ATTACH_CODE does not set the mode before super.attachBaseContext inside try / catch (e: Throwable)')
if not re.search(r'patch_direct_boot\(root\)\s*\n\s*patch_night_mode\(root\)', pu_text):
    err('5G night mode patch: patch-upstream.py: main() does not call patch_night_mode(root) right after patch_direct_boot(root)')
if not re.search(r'check_night_mode\(root, man, errors\)', pu_text):
    err('5G night mode check: patch-upstream.py: check() does not call check_night_mode(root, man, errors)')

# 9d. the helper scripts are callable (they run without the fetched sources, so nothing is built or downloaded)
if '--no-run' not in sys.argv:
    tools_dir = os.path.join(SHIZUKU, 'tools')
    empty = tempfile.mkdtemp(prefix='shz-empty-')
    env = dict(os.environ, SHIZUKU_UPSTREAM_DIR=empty, MIKA_UPSTREAM_DIR=empty)
    runs = 0

    def run_tool(label, argv, want_code, want_text=None, run_env=None):
        global runs
        script = argv[0] if argv[0].endswith(('.py', '.sh')) else None
        path = os.path.join(tools_dir, script) if script else None
        if path and not os.path.isfile(path):
            err(f'4F-1 tools: shizuku/tools/{script} is missing ({label})'); return
        cmd = ([sys.executable, '-I', path] if script.endswith('.py') else ['bash', path]) + argv[1:]
        try:
            p = subprocess.run(cmd, capture_output=True, text=True, timeout=120, env=run_env or os.environ)
        except (OSError, subprocess.TimeoutExpired) as e:
            err(f'4F-1 tools: {label}: could not run ({e})'); return
        runs += 1
        out = p.stdout + p.stderr
        if p.returncode != want_code:
            err(f'4F-1 tools: {label}: exit {p.returncode}, expected {want_code}: ' + (out.strip().splitlines() or [''])[-1][:160])
        elif 'Traceback' in out:
            err(f'4F-1 tools: {label}: printed a traceback')
        elif want_text and want_text not in out:
            err(f'4F-1 tools: {label}: the output does not contain {want_text!r}')

    run_tool('check-provider-match.py --self-test', ['check-provider-match.py', '--self-test'], 0, 'cases as expected')
    run_tool('check-provider-match.py without the fetched sources', ['check-provider-match.py'], 2, 'not found', env)
    run_tool('patch-upstream.py --help', ['patch-upstream.py', '--help'], 0, '--check')
    run_tool('patch-upstream.py --check on an empty checkout folder', ['patch-upstream.py', '--check'], 1, 'fetch-upstream.sh first', env)
    if shutil.which('bash'):
        run_tool('patch-upstream.sh --check on an empty checkout folder', ['patch-upstream.sh', '--check'], 1, 'fetch-upstream.sh first', env)
    else:
        notes.append('4F-1: bash not found, patch-upstream.sh was not run')
    run_tool('check-merged-manifest.py --help', ['check-merged-manifest.py', '--help'], 0, '--require-shizuku')
    run_tool('test-check-merged-manifest.py --list', ['test-check-merged-manifest.py', '--list'], 0, '2-01')
    shutil.rmtree(empty, ignore_errors=True)
    notes.append(f'4F-1: {runs} helper script run(s) as expected' if not errors else f'4F-1: {runs} helper script run(s) made')
else:
    notes.append('4F-1: the helper scripts were not run (--no-run)')

for n in notes: print('note:', n)
if errors:
    for e in errors: print('ERROR:', e)
    print(f'{len(errors)} problem(s)'); sys.exit(1)
print(f'check-gradle ok: {len(kts)} .kts files structurally fine, {len(namespaces)} unique namespaces, includes <-> folders consistent')
