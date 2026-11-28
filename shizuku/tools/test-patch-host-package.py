#!/usr/bin/env python3
"""Hand-made cases for the host-package rules (step 5B-1), the application-attribute rule (step 5B-2) and the binder-protocol rules (step 5C) of patch-upstream.py. Needs nothing: no network, no fetched source, no Gradle.

Rules tried: check_host_name (a plain Android package name only), host_package (reads applicationId of app/build.gradle.kts, refuses an
applicationIdSuffix, env / option override is validated too), check_native_package (starter.cpp has exactly one `#define PACKAGE_NAME "<host>"`, the old name nowhere),
check_application_attrs (5B-2: the library manifest's <application> has no extractNativeLibs; APP_ATTRS_DROP removes it),
patch_package + check_binder_protocol + OLD_NAME_RE (5C: the binder extra key stays as upstream has it in four files, the package-name uses become the host package, the key is
never spelled with the host package),
check_intent_actions (5D: the permission action is built from the host package and aimed at it, each custom action sits only on its components, no unknown action),
patch_pairing_service + check_pairing_timeout (5E: AdbPairingService gets the two onTimeout overrides that stop the foreground state and the service; every anchor stops the script when it is not there),
patch_direct_boot + check_direct_boot (5F: directBootAware leaves the five manager components (three receiver / provider, two activities: the two activities were found on the real tree in 5G), LOCKED_BOOT_COMPLETED leaves BootCompleteReceiver, BOOT_COMPLETED stays; every anchor stops the script when it is not there),
patch_night_mode + check_night_mode (5G: the process-wide night-mode setter leaves ShizukuApplication and SettingsFragment, AppActivity applies the stored mode in a guarded attachBaseContext before super; every anchor stops the script when it is not there).
It copies patch-upstream.py into a throw-away project folder, so nothing in the real project is read or changed.

Run: python3 -I shizuku/tools/test-patch-host-package.py    (exit 0 = all cases ok, 1 = a case failed). Part of check-all.py since row 10A (step S8).
"""
import contextlib, importlib.util, io, os, shutil, sys, tempfile

HERE = os.path.dirname(os.path.abspath(__file__))
fails = 0
total = 0


def ok(cond, msg):
    global fails, total
    total += 1
    if not cond:
        fails += 1
        print('FAIL ' + msg)


def dies(f, *a):
    with contextlib.redirect_stderr(io.StringIO()):
        try:
            f(*a)
        except SystemExit as e:
            return e.code == 1
    return False


def main():
    tmp = tempfile.mkdtemp(prefix='t5b-')
    try:
        os.makedirs(os.path.join(tmp, 'shizuku', 'tools'))
        os.makedirs(os.path.join(tmp, 'app'))
        shutil.copy(os.path.join(HERE, 'patch-upstream.py'), os.path.join(tmp, 'shizuku', 'tools', 'patch-upstream.py'))
        spec = importlib.util.spec_from_file_location('pu', os.path.join(tmp, 'shizuku', 'tools', 'patch-upstream.py'))
        pu = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(pu)
        env_old = os.environ.pop('SHIZUKU_HOST_PACKAGE', None)

        for good in ['com.srizwan.win11', 'a.b', 'com.My_App.x9']:
            ok(pu.check_host_name(good) == good, 'name ok: ' + good)
        for bad in ['', 'nodot', 'com.a b', 'com.a;rm -rf', 'com.a"b', 'com.$x', 'com..a', '1com.a', 'com.a\\b', 'com.a\n', "com.a'b", 'com.a.', 'com.a`b`']:
            ok(dies(pu.check_host_name, bad), 'name stops: %r' % bad)

        def gradle(text):
            with open(os.path.join(tmp, 'app', 'build.gradle.kts'), 'w') as f:
                f.write(text)
            pu.PROJECT = tmp

        gradle('android { defaultConfig { applicationId = "com.x.y" } }')
        ok(pu.host_package(None) == 'com.x.y', 'applicationId is read')
        gradle('android { defaultConfig { applicationId = "com.x.y" }\n buildTypes { debug { applicationIdSuffix = ".debug" } } }')
        ok(dies(pu.host_package, None), 'applicationIdSuffix stops the script')
        ok(pu.host_package('com.o.p') == 'com.o.p', '--host-package wins (build file not read)')
        gradle('android { defaultConfig { applicationId = "com.x.y" }\n // applicationIdSuffix = ".debug"\n }')
        ok(pu.host_package(None) == 'com.x.y', 'a commented-out suffix is fine')
        gradle('android { defaultConfig { applicationId = "com bad" } }')
        ok(dies(pu.host_package, None), 'applicationId with a space stops')
        gradle('android { }')
        ok(dies(pu.host_package, None), 'no applicationId stops')
        os.environ['SHIZUKU_HOST_PACKAGE'] = 'bad name'
        ok(dies(pu.host_package, None), 'environment override is validated')
        ok(dies(pu.host_package, 'x;y.z'), 'option override is validated')
        del os.environ['SHIZUKU_HOST_PACKAGE']
        if env_old is not None:
            os.environ['SHIZUKU_HOST_PACKAGE'] = env_old

        def native(cpp, host='com.h.w'):
            d = os.path.join(tmp, 'upstream', 'manager/src/main/jni')
            os.makedirs(d, exist_ok=True)
            with open(os.path.join(d, 'starter.cpp'), 'w') as f:
                f.write(cpp)
            e = []
            pu.check_native_package(os.path.join(tmp, 'upstream'), host, e)
            return e

        good_cpp = '#include <x>\n#define PACKAGE_NAME "com.h.w"\n#define SERVER_NAME "shizuku_server"\n'
        ok(native(good_cpp) == [], 'patched starter.cpp passes')
        ok(len(native(good_cpp.replace('com.h.w', 'moe.shizuku.privileged.api'))) == 2, 'unpatched: wrong value and old name = 2 errors')
        ok(len(native(good_cpp + '#define PACKAGE_NAME "com.h.w"\n')) == 1, 'defined twice fails')
        ok(len(native('#define SERVER_NAME "x"\n')) == 1, 'macro missing fails')
        ok(len(native(good_cpp, 'com.other.app')) == 1, 'other host fails')
        ok(native('  #  define   PACKAGE_NAME   "com.h.w"  // pm path\n') == [], 'spacing and a trailing comment are fine')
        ok(len(native('// #define PACKAGE_NAME "com.h.w"\n')) == 1, 'a commented-out define does not count')
        ok(len(native(good_cpp + '// was moe.shizuku.privileged.api\n')) == 1, 'the old name in a comment still fails')

        def attrs(man):
            e = []
            pu.check_application_attrs(man, e)
            return e

        A = 'xmlns:android="http://schemas.android.com/apk/res/android"'
        ok(attrs(f'<manifest {A}><application><activity/></application></manifest>') == [], 'application without attributes passes')
        ok(len(attrs(f'<manifest {A}><application android:extractNativeLibs="true"><activity/></application></manifest>')) == 1, 'extractNativeLibs true fails')
        ok(len(attrs(f'<manifest {A}><application\n  android:label="x"\n  android:extractNativeLibs="false">\n</application></manifest>')) == 1, 'extractNativeLibs false on another line fails')
        ok(attrs(f'<manifest {A}><application/><!-- extractNativeLibs --></manifest>') == [], 'the word outside the <application> tag is fine')
        ok('extractNativeLibs' in pu.APP_ATTRS_DROP, 'APP_ATTRS_DROP removes extractNativeLibs')
        ok(attrs(f'<manifest {A}><application android:name=".A"><service android:extractNativeLibs="x"/></application></manifest>') == [], 'only the <application> tag itself is read')

        # ---- 5C: binder extra key kept, package-name uses replaced
        OLD, KEY = pu.OLD_PKG, pu.BINDER_EXTRA
        ok(KEY == OLD + '.intent.extra.BINDER', '5C: the kept key is the old name + .intent.extra.BINDER')
        ok(sorted(pu.BINDER_EXTRA_KEPT) == sorted(['server/src/main/java/rikka/shizuku/server/ShizukuService.java', 'starter/src/main/java/moe/shizuku/starter/ServiceStarter.java',
                                                   'manager/src/main/java/moe/shizuku/manager/ShizukuManagerProvider.kt', 'api/provider/src/main/java/rikka/shizuku/ShizukuProvider.java']),
           '5C: the key is kept in exactly the four files that spell it')
        ok(all(n <= dict(pu.PACKAGE_FILES)[rel] for rel, n in pu.BINDER_EXTRA_KEPT.items()), '5C: a file never keeps more than it names')
        ok(sum(pu.host_places(r) for r, _ in pu.PACKAGE_FILES) == 5, '5C: 5 package-name places are replaced (9 uses of the old name minus 4 kept keys)')
        ok(pu.OLD_NAME_RE.search('x = "' + KEY + '"') is None, '5C: the kept key alone is not "the old name"')
        ok(pu.OLD_NAME_RE.search('x = "' + OLD + '"') is not None, '5C: the bare old name is')
        ok(pu.OLD_NAME_RE.search('x = "' + KEY + '_X"') is not None, '5C: a longer key that only starts like the kept one is')
        ok(pu.OLD_NAME_RE.search('a "' + KEY + '" b "' + OLD + '"') is not None, '5C: the old name next to the kept key is still found')

        def tree(name, mutate=None):
            r = os.path.join(tmp, name)
            shutil.rmtree(r, ignore_errors=True)
            for rel, n in pu.PACKAGE_FILES:
                k = pu.BINDER_EXTRA_KEPT.get(rel, 0)
                body = ''.join('String p%d = "%s";\n' % (i, OLD) for i in range(n - k)) + ''.join('String k%d = "%s";\n' % (i, KEY) for i in range(k))
                os.makedirs(os.path.dirname(os.path.join(r, rel)), exist_ok=True)
                with open(os.path.join(r, rel), 'w') as f:
                    f.write(body)
            if mutate:
                mutate(r)
            return r

        def edit_file(r, rel, fn):
            with open(os.path.join(r, rel), 'r+') as f:
                t = fn(f.read())
                f.seek(0); f.truncate(); f.write(t)

        SVC = 'server/src/main/java/rikka/shizuku/server/ShizukuService.java'
        CONST = 'server/src/main/java/rikka/shizuku/server/ServerConstants.java'
        r = tree('t_good')
        with contextlib.redirect_stdout(io.StringIO()) as out:
            pu.patch_package(r, 'com.h.w')
        ok('binder extra key' in out.getvalue() and 'kept in 4 files' in out.getvalue() and '5 files (5 places)' in out.getvalue(), '5C: patch_package reports 5 places in 5 files and 4 kept keys')
        svc_text = open(os.path.join(r, SVC)).read()
        ok(KEY in svc_text and 'com.h.w' not in svc_text, '5C: ShizukuService keeps the key and gets no host name (its only old name was the key)')
        ok('"com.h.w"' in open(os.path.join(r, CONST)).read() and OLD not in open(os.path.join(r, CONST)).read(), '5C: ServerConstants names the host and not the old name')
        e = []
        pu.check_binder_protocol(r, 'com.h.w', e)
        ok(e == [], '5C: a patched tree passes check_binder_protocol')
        ok(not any(pu.OLD_NAME_RE.search(open(os.path.join(r, rel)).read()) for rel, _ in pu.PACKAGE_FILES), '5C: no old name is left outside the kept key')
        ok(dies(pu.patch_package, tree('t_nokey', lambda r: edit_file(r, SVC, lambda t: 'String p0 = "%s";\n' % OLD)), 'com.h.w'), '5C: patch_package stops when a file does not spell the key')
        ok(dies(pu.patch_package, tree('t_extra', lambda r: edit_file(r, CONST, lambda t: t + 'String z = "%s";\n' % OLD)), 'com.h.w'), '5C: patch_package stops when a file has one old name more')
        ok(dies(pu.patch_package, tree('t_key2', lambda r: edit_file(r, CONST, lambda t: t + 'String z = "%s";\n' % KEY)), 'com.h.w'), '5C: patch_package stops when a file has the key where upstream had none')

        def bad(mutate, host='com.h.w'):
            r = tree('t_bad')
            with contextlib.redirect_stdout(io.StringIO()):
                pu.patch_package(r, host)
            mutate(r)
            e = []
            pu.check_binder_protocol(r, host, e)
            return e

        ok(len(bad(lambda r: edit_file(r, SVC, lambda t: t.replace(KEY, 'com.h.w.intent.extra.BINDER')))) == 3, '5C: the key renamed to the host fails (key missing, key with host, host count)')
        ok(len(bad(lambda r: edit_file(r, SVC, lambda t: ''))) == 1, '5C: the key missing in one file fails')
        ok(len(bad(lambda r: edit_file(r, CONST, lambda t: t.replace('com.h.w', 'x.y')))) == 1, '5C: a file that lost its host-package place fails')
        ok(len(bad(lambda r: edit_file(r, CONST, lambda t: t + 'String z = "%s";\n' % OLD))) == 1, '5C: the old name outside the key fails')
        ok(len(bad(lambda r: edit_file(r, CONST, lambda t: t + 'String z = "com.h.w";\n'))) == 1, '5C: one host-package place too many fails')
        ok(len(bad(lambda r: edit_file(r, CONST, lambda t: t + 'String z = "%s";\n' % KEY))) == 1, '5C: the key in a file that should not have it fails')

        # ---- 5D: intent actions
        ok(sorted(pu.MANIFEST_ACTIONS) == sorted(['${applicationId}.intent.action.REQUEST_PERMISSION', '${applicationId}.intent.action.REQUEST_AUTHORIZATION',
                                                  'rikka.shizuku.intent.action.REQUEST_BINDER']), '5D: three custom actions are in the manifest table')
        ok(all(k.startswith('${applicationId}') for k in pu.MANIFEST_ACTIONS if not k.startswith('rikka.')), '5D: the host-following actions go through the placeholder')
        ok(sum(pu.BINDER_ACTION_FILES.values()) == 4 and len(pu.BINDER_ACTION_FILES) == 3, '5D: the REQUEST_BINDER literal is spelled 4x in 3 files')
        ok(pu.ACTION_LITERALS_ALLOWED == {pu.ACTION_BINDER, pu.ACTION_BINDER_RECEIVED, pu.ACTION_PERMISSION_SUFFIX}, '5D: three action-looking literals are allowed in the sources')
        ok(pu.ACTION_LITERAL_RE.findall('a "x.y.action.Z" b "plain" c "android.intent.action.MAIN"') == ['x.y.action.Z', 'android.intent.action.MAIN'], '5D: the literal finder reads action-looking strings only')

        A5 = 'xmlns:android="http://schemas.android.com/apk/res/android"'
        MAN = ('<manifest %s><application>'
               '<activity android:name=".authorization.RequestPermissionActivity"><intent-filter><action android:name="${applicationId}.intent.action.REQUEST_PERMISSION"/></intent-filter></activity>'
               '<activity android:name=".legacy.ShellRequestHandlerActivity"><intent-filter><action android:name="rikka.shizuku.intent.action.REQUEST_BINDER"/></intent-filter></activity>'
               '<activity android:name=".legacy.LegacyIsNotSupportedActivity"><intent-filter><action android:name="${applicationId}.intent.action.REQUEST_AUTHORIZATION"/></intent-filter></activity>'
               '<receiver android:name=".receiver.BootCompleteReceiver"><intent-filter><action android:name="android.intent.action.BOOT_COMPLETED"/></intent-filter></receiver>'
               '<receiver android:name=".receiver.ShizukuReceiver"><intent-filter><action android:name="rikka.shizuku.intent.action.REQUEST_BINDER"/></intent-filter></receiver>'
               '</application></manifest>') % A5
        F5 = {
            'ct': 'server/src/main/java/rikka/shizuku/server/ServerConstants.java',
            'sv': 'server/src/main/java/rikka/shizuku/server/ShizukuService.java',
            'ld': 'shell/src/main/java/rikka/shizuku/shell/ShizukuShellLoader.java',
            'hd': 'manager/src/main/java/moe/shizuku/manager/shell/ShellBinderRequestHandler.kt',
            'rc': 'manager/src/main/java/moe/shizuku/manager/receiver/ShizukuReceiver.kt',
            'pv': 'api/provider/src/main/java/rikka/shizuku/ShizukuProvider.java',
            'demo': 'api/demo/src/main/java/rikka/shizuku/demo/DemoActivity.java',
        }
        BIND = '"rikka.shizuku.intent.action.REQUEST_BINDER"'

        def atree(name, host='com.h.w', mutate=None):
            r = os.path.join(tmp, name)
            shutil.rmtree(r, ignore_errors=True)
            files = {
                'ct': 'String MANAGER_APPLICATION_ID = "%s";\nString REQUEST_PERMISSION_ACTION = MANAGER_APPLICATION_ID + ".intent.action.REQUEST_PERMISSION";\n' % host,
                'sv': 'Intent intent = new Intent(ServerConstants.REQUEST_PERMISSION_ACTION)\n        .setPackage(MANAGER_APPLICATION_ID)\n        .addFlags(1);\n',
                'ld': 'Intent a = new Intent(%s)\n        .setPackage("%s")\n        .addFlags(2);\nIntent b = new Intent(%s)\n        .addFlags(4);\n' % (BIND, host, BIND),
                'hd': 'if (intent.action != %s) return false\n' % BIND,
                'rc': 'if (%s == intent.action) { }\n' % BIND,
                'pv': 'public static final String ACTION_BINDER_RECEIVED = "moe.shizuku.api.action.BINDER_RECEIVED";\n',
                'demo': 'String x = "com.demo.intent.action.NOT_SHIPPED";\n',
            }
            for k, body in files.items():
                os.makedirs(os.path.dirname(os.path.join(r, F5[k])), exist_ok=True)
                with open(os.path.join(r, F5[k]), 'w') as f:
                    f.write(body)
            if mutate:
                mutate(r)
            return r

        def acts(mutate=None, manifest=MAN, host='com.h.w'):
            r = atree('t_act', host, mutate)
            e = []
            pu.check_intent_actions(r, manifest, host, e)
            return e

        ok(acts() == [], '5D: a patched-like tree passes check_intent_actions (the API demo file with an action literal is ignored)')
        ok(acts(host='a.b.c', mutate=None) == [], '5D: the rules follow another host package name')
        ok(len(acts(lambda r: edit_file(r, F5['ct'], lambda t: t.replace('MANAGER_APPLICATION_ID + ".intent', '"com.h.w" + ".intent')))) == 1, '5D: ServerConstants not built from MANAGER_APPLICATION_ID fails')
        ok(len(acts(lambda r: edit_file(r, F5['ct'], lambda t: t.replace('MANAGER_APPLICATION_ID + ".intent.action.REQUEST_PERMISSION"', '"com.h.w.intent.action.REQUEST_PERMISSION"')))) == 4, '5D: the permission action as a host literal fails (rule, literal, prefix, unknown literal)')
        ok(len(acts(lambda r: edit_file(r, F5['ct'], lambda t: t.replace('REQUEST_PERMISSION"', 'REQUEST_PERMISSIONS"')))) == 2, '5D: a changed action tail fails (rule, unknown literal)')
        ok(len(acts(lambda r: edit_file(r, F5['sv'], lambda t: t.replace('.setPackage(MANAGER_APPLICATION_ID)', '')))) == 1, '5D: the permission request not aimed at the host fails')
        ok(len(acts(lambda r: edit_file(r, F5['sv'], lambda t: t.replace('.setPackage(MANAGER_APPLICATION_ID)', '.setPackage("x.y")')))) == 1, '5D: the permission request aimed at another package fails')
        ok(len(acts(manifest=MAN.replace('${applicationId}.intent.action.REQUEST_PERMISSION', 'com.h.w.intent.action.REQUEST_PERMISSION'))) == 3, '5D: a literal host in the manifest action fails (unknown, missing, literal)')
        ok(len(acts(manifest=MAN.replace('${applicationId}.intent.action.REQUEST_AUTHORIZATION', 'moe.shizuku.privileged.api.intent.action.REQUEST_AUTHORIZATION'))) == 3, '5D: the old package in a manifest action fails')
        ok(len(acts(manifest=MAN.replace('<activity android:name=".legacy.LegacyIsNotSupportedActivity"><intent-filter><action android:name="${applicationId}.intent.action.REQUEST_AUTHORIZATION"/></intent-filter></activity>', ''))) == 1, '5D: REQUEST_AUTHORIZATION missing fails')
        ok(len(acts(manifest=MAN.replace('<receiver android:name=".receiver.BootCompleteReceiver">', '<activity android:name=".legacy.LegacyIsNotSupportedActivity"><intent-filter><action android:name="${applicationId}.intent.action.REQUEST_AUTHORIZATION"/></intent-filter></activity><receiver android:name=".receiver.BootCompleteReceiver">'))) == 1, '5D: REQUEST_AUTHORIZATION twice fails')
        ok(len(acts(manifest=MAN.replace('<receiver android:name=".receiver.ShizukuReceiver"><intent-filter><action android:name="rikka.shizuku.intent.action.REQUEST_BINDER"/></intent-filter></receiver>', ''))) == 1, '5D: REQUEST_BINDER on one component only fails')
        ok(len(acts(manifest=MAN.replace('</application>', '<service android:name=".X"><intent-filter><action android:name="com.x.ACTION_FOO"/></intent-filter></service></application>'))) == 1, '5D: another custom action in the manifest fails')
        ok(len(acts(manifest=MAN.replace('</application>', '<service android:name=".X"><intent-filter><action android:name="android.intent.action.VIEW"/></intent-filter></service></application>'))) == 0, '5D: a system action is not a custom action')
        ok(len(acts(manifest='<manifest')) == 1, '5D: a manifest that is not well-formed is one error')
        ok(len(acts(lambda r: edit_file(r, F5['rc'], lambda t: ''))) == 1, '5D: the REQUEST_BINDER literal missing from the receiver fails')
        ok(len(acts(lambda r: edit_file(r, F5['hd'], lambda t: t + 'val z = %s\n' % BIND))) == 1, '5D: one REQUEST_BINDER literal too many fails')
        ok(len(acts(lambda r: edit_file(r, F5['ld'], lambda t: t.replace('.setPackage("com.h.w")', '')))) == 1, '5D: the shell loader without setPackage fails')
        ok(len(acts(lambda r: edit_file(r, F5['ld'], lambda t: t.replace('.setPackage("com.h.w")', '.setPackage("moe.shizuku.privileged.api")')))) == 1, '5D: the shell loader aimed at the old package fails (the old name alone is 5C\'s rule, here only the target)')
        ok(len(acts(lambda r: edit_file(r, F5['rc'], lambda t: t.replace('rikka.shizuku.intent', 'com.h.w.intent')))) == 3, '5D: the receiver listening to a host-named action fails (count, prefix, unknown literal)')
        ok(len(acts(lambda r: edit_file(r, F5['pv'], lambda t: t.replace('moe.shizuku.api.action', 'com.h.w.action')))) == 1, '5D: the provider broadcast renamed to the host fails (unknown literal)')
        ok(len(acts(lambda r: edit_file(r, F5['hd'], lambda t: t + 'val z = "com.z.intent.action.FOO"\n'))) == 1, '5D: a new action literal in the manager fails until decided')
        ok(len(acts(lambda r: edit_file(r, F5['hd'], lambda t: t + 'val z = "moe.shizuku.privileged.api.intent.action.X"\n'))) == 2, '5D: an old-package action literal fails (prefix, unknown literal)')

        # ---- 5E: pairing service timeout (finding 11)
        PS = pu.PAIRING_SERVICE
        ok(PS == 'manager/src/main/java/moe/shizuku/manager/adb/AdbPairingService.kt', '5E: the patched file is the pairing service of the manager')
        ok(len(pu.PAIRING_TIMEOUT_SIGS) == 2 and sorted(pu.PAIRING_TIMEOUT_SIGS.values()) == ['onTimeout(startId)', 'onTimeout(startId, fgsType)'], '5E: two signatures are required (API 34 and API 35)')
        ok(pu.PAIRING_TIMEOUT_CODE.count('override fun onTimeout') == 2 and pu.PAIRING_TIMEOUT_CODE.count('stopForeground(STOP_FOREGROUND_REMOVE)') == 2
           and pu.PAIRING_TIMEOUT_CODE.count('stopSelf()') == 2, '5E: the inserted code has two overrides, each with stopForeground and stopSelf')
        ok(all(__import__('re').search(sig, pu.PAIRING_TIMEOUT_CODE) for sig in pu.PAIRING_TIMEOUT_SIGS), '5E: the inserted code matches both signature rules of the self-check')

        KT = ('package moe.shizuku.manager.adb\n\nimport android.app.Service\n\n@TargetApi(Build.VERSION_CODES.R)\nclass AdbPairingService : Service() {\n\n'
              '    companion object {\n        const val x = 1\n    }\n\n    override fun onCreate() {\n        super.onCreate()\n    }\n\n'
              '    override fun onDestroy() {\n        stopSearch()\n        super.onDestroy()\n    }\n\n    private fun handleResult() {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }\n}\n')

        def ptree(name, text=KT, mutate=None):
            r = os.path.join(tmp, name)
            shutil.rmtree(r, ignore_errors=True)
            if text is not None:
                os.makedirs(os.path.dirname(os.path.join(r, PS)), exist_ok=True)
                with open(os.path.join(r, PS), 'w') as f:
                    f.write(text)
            else:
                os.makedirs(r)
            if mutate:
                mutate(r)
            return r

        def ppatch(r):
            with contextlib.redirect_stdout(io.StringIO()) as out:
                pu.patch_pairing_service(r)
            return out.getvalue()

        def pcheck(r):
            e = []
            pu.check_pairing_timeout(r, e)
            return e

        r = ptree('t_ps')
        ok(len(pcheck(r)) == 2 + 1 and 'onTimeout' not in open(os.path.join(r, PS)).read(), '5E: the unpatched file fails the self-check (2 missing overrides + the count of 0 functions)')
        out = ppatch(r)
        txt = open(os.path.join(r, PS)).read()
        ok(out.startswith('F. pairing service') and '1 file' in out, '5E: patch_pairing_service reports part F, 1 file')
        ok(txt.count('override fun onTimeout') == 2 and txt.index('class AdbPairingService') < txt.index('override fun onTimeout(startId: Int)'), '5E: both overrides were added, inside the class (after its opening line)')
        ok(txt.startswith(KT.split('class AdbPairingService : Service() {')[0]) and txt.endswith(KT.split('class AdbPairingService : Service() {')[1]), '5E: nothing else of the file changed (head and tail are as before)')
        ok(pcheck(r) == [], '5E: a patched file passes check_pairing_timeout')
        ok(dies(pu.patch_pairing_service, r), '5E: patching twice stops (an onTimeout is already there)')

        ok(dies(pu.patch_pairing_service, ptree('t_ps_nofile', None)), '5E: patch stops when the file is missing')
        ok(dies(pu.patch_pairing_service, ptree('t_ps_has', KT.replace('    override fun onCreate()', '    override fun onTimeout(startId: Int) {}\n    override fun onCreate()'))), '5E: patch stops when upstream already has an onTimeout')
        ok(dies(pu.patch_pairing_service, ptree('t_ps_nodestroy', KT.replace('onDestroy', 'onStop'))), '5E: patch stops when onDestroy is gone')
        ok(dies(pu.patch_pairing_service, ptree('t_ps_cls', KT.replace('class AdbPairingService : Service() {', 'class AdbPairingService : Service {'))), '5E: patch stops when the class line is not the known one')
        ok(dies(pu.patch_pairing_service, ptree('t_ps_cls2', KT + '\nclass AdbPairingService : Service() {\n}\n')), '5E: patch stops when the class line appears twice')
        ok(not dies(ppatch, ptree('t_ps_sp', KT.replace('class AdbPairingService : Service() {', 'class  AdbPairingService:Service(){'))), '5E: odd spacing of the class line is still found')
        ok(not dies(ppatch, ptree('t_ps_ann', KT.replace('@TargetApi(Build.VERSION_CODES.R)\\n', '@TargetApi(Build.VERSION_CODES.R) '))), '5E: an annotation on the class line does not matter')

        def pbad(fn):
            r = ptree('t_ps_bad')
            ppatch(r)
            edit_file(r, PS, fn)
            return pcheck(r)

        ok(len(pcheck(ptree('t_ps_none', None))) == 1, '5E: the check reports a missing file as one error')
        ok(len(pbad(lambda t: t.replace('override fun onTimeout(startId: Int) {', 'private fun gone1() {'))) == 2, '5E: the one-argument override missing fails (count of 2, signature)')
        ok(len(pbad(lambda t: t.replace('override fun onTimeout(startId: Int, fgsType: Int) {', 'private fun gone2() {'))) == 2, '5E: the two-argument override missing fails (count of 2, signature)')
        ok(len(pbad(lambda t: t.replace('override fun onTimeout(startId: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }', 'override fun onTimeout(startId: Int) {\n        stopSelf()\n    }'))) == 1, '5E: an override without stopForeground fails')
        ok(len(pbad(lambda t: t.replace('override fun onTimeout(startId: Int, fgsType: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }', 'override fun onTimeout(startId: Int, fgsType: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n    }'))) == 1, '5E: an override without stopSelf fails')
        ok(len(pbad(lambda t: t.replace('override fun onTimeout(startId: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }', 'override fun onTimeout(startId: Int) {\n        stopSelf()\n        stopForeground(STOP_FOREGROUND_REMOVE)\n    }'))) == 1, '5E: stopSelf before stopForeground fails (the notification would stay)')
        ok(len(pbad(lambda t: t.replace('override fun onTimeout(startId: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }', 'override fun onTimeout(startId: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n        stopSelf()\n    }'))) == 1, '5E: stopSelf twice fails')
        ok(len(pbad(lambda t: t.replace('override fun onTimeout(startId: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }', 'override fun onTimeout(startId: Int) {\n        // stopForeground(STOP_FOREGROUND_REMOVE)\n        // stopSelf()\n    }'))) == 1, '5E: calls that are only in comments do not count')
        ok(len(pbad(lambda t: t + '\nfun Service.onTimeout(a: Int, b: Int, c: Int) {}\n')) == 1, '5E: a third onTimeout function fails (exactly two)')
        ok(len(pbad(lambda t: t.replace('onDestroy', 'onStopped'))) == 1, '5E: onDestroy removed from the patched file fails')
        ok(len(pbad(lambda t: t.replace('class AdbPairingService : Service() {', 'class AdbPairingService : Service(), Foo {'))) == 1, '5E: another class line fails (anchor of the check)')
        ok(len(pbad(lambda t: 'class Other {\n    override fun onTimeout(startId: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }\n    override fun onTimeout(startId: Int, fgsType: Int) {\n        stopForeground(STOP_FOREGROUND_REMOVE)\n        stopSelf()\n    }\n}\n' + t.replace(pu.PAIRING_TIMEOUT_CODE, '\n'))) == 2, '5E: overrides placed before the service class fail (not inside it)')
        ok(pu.kotlin_block('x { a { b } c } d', 2) == ' a { b } c ' and pu.kotlin_block('x { a', 2) is None, '5E: the brace matcher finds the matching end and returns None for an open block')

        # ---- 5F: direct boot (finding 12, option a+)
        MP = 'manager/src/main/AndroidManifest.xml'
        NS2 = 'xmlns:android="http://schemas.android.com/apk/res/android" xmlns:tools="http://schemas.android.com/tools"'
        UPS = ('<?xml version="1.0" encoding="utf-8"?>\n<manifest %s>\n'
               '    <permission android:name="${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION" tools:node="remove" />\n'
               '    <uses-permission android:name="${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION" tools:node="remove" />\n'
               '    <application android:name=".ShizukuApplication" android:icon="@mipmap/ic_launcher" android:label="@string/app_name" android:theme="@style/AppTheme">\n'
               '        <activity android:name=".MainActivity" android:banner="@drawable/b"><intent-filter><action android:name="android.intent.action.MAIN" /><category android:name="android.intent.category.LAUNCHER" /></intent-filter></activity>\n'
               '        <activity android:name=".settings.SettingsActivity" android:exported="false" />\n'
               '        <receiver android:name=".receiver.BootCompleteReceiver" android:directBootAware="true" android:exported="true">\n'
               '            <intent-filter><action android:name="android.intent.action.LOCKED_BOOT_COMPLETED" /></intent-filter>\n'
               '            <intent-filter><action android:name="android.intent.action.BOOT_COMPLETED" /></intent-filter>\n'
               '        </receiver>\n'
               '        <receiver android:name=".receiver.ShizukuReceiver" android:directBootAware="true" android:exported="true"><intent-filter><action android:name="rikka.shizuku.intent.action.REQUEST_BINDER" /></intent-filter></receiver>\n'
               '        <provider android:name=".ShizukuManagerProvider" android:authorities="${applicationId}.shizuku" android:directBootAware="true" android:exported="true" android:multiprocess="false" android:permission="android.permission.INTERACT_ACROSS_USERS_FULL" />\n'
               '        <activity android:name=".authorization.RequestPermissionActivity" android:directBootAware="true" android:exported="true" />\n'
               '        <activity android:name=".legacy.ShellRequestHandlerActivity" android:directBootAware="true" android:exported="true" />\n'
               '    </application>\n</manifest>\n') % NS2

        def mtree(name, text=UPS, run_b=True):
            r = os.path.join(tmp, name)
            shutil.rmtree(r, ignore_errors=True)
            os.makedirs(os.path.dirname(os.path.join(r, MP)))
            if text is not None:
                with open(os.path.join(r, MP), 'w') as f:
                    f.write(text)
                if run_b:
                    with contextlib.redirect_stdout(io.StringIO()):
                        pu.patch_manifest(r)
            return r

        def mpatch(r):
            with contextlib.redirect_stdout(io.StringIO()) as out:
                pu.patch_direct_boot(r)
            return out.getvalue()

        def mread(r):
            with open(os.path.join(r, MP)) as f:
                return f.read()

        def mcheck(xml):
            e = []
            pu.check_direct_boot(xml, e)
            return e

        import re as _re
        ok(sorted(pu.DIRECT_BOOT_COMPONENTS) == [('activity', '.authorization.RequestPermissionActivity'), ('activity', '.legacy.ShellRequestHandlerActivity'), ('provider', '.ShizukuManagerProvider'), ('receiver', '.receiver.BootCompleteReceiver'), ('receiver', '.receiver.ShizukuReceiver')], '5F: the five components of option (a+) are the ones listed (3 of 4D-3, 2 found on the real tree in 5G)')
        ok(pu.LOCKED_BOOT_ACTION == 'android.intent.action.LOCKED_BOOT_COMPLETED' and pu.BOOT_ACTION == 'android.intent.action.BOOT_COMPLETED', '5F: the two action names are the platform ones')
        src = open(os.path.join(HERE, 'patch-upstream.py')).read()
        ok('    patch_manifest(root)\n    patch_direct_boot(root)\n' in src, '5F: main() runs patch_direct_boot right after patch_manifest')
        ok('    check_direct_boot(man, errors)\n' in src, '5F: check() runs check_direct_boot on the generated manifest')

        r = mtree('t_db')
        before = mread(r)
        ok(before.count('directBootAware') == 5 and 'LOCKED_BOOT_COMPLETED' in before, '5F: after patch_manifest the five flags and the LOCKED action are still there')
        ok(len(mcheck(before)) == 6, '5F: the unpatched manifest fails the self-check (5 flags + 1 LOCKED action)')
        out = mpatch(r)
        after = mread(r)
        ok(out.startswith('G. direct boot') and '1 file' in out, '5F: patch_direct_boot reports part G, 1 file')
        body = lambda t: t[t.index('<manifest'):]          # the header comment names both words on purpose
        ok('directBootAware' not in body(after) and 'LOCKED_BOOT_COMPLETED' not in body(after), '5F: no flag and no LOCKED action left (header comment apart)')
        ok(after.count('android.intent.action.BOOT_COMPLETED') == 1, '5F: BOOT_COMPLETED is still there, once')
        ok(mcheck(after) == [], '5F: a patched manifest passes check_direct_boot')
        ok(after.startswith('<?xml version="1.0" encoding="utf-8"?>\n<!-- Win11 library manifest') and after.count('Step 5F (finding 12)') == 1, '5F: the XML declaration and the part B header stay, with one sentence added')
        ok('merge time.\n     Step 5F' in after and after.index('-->') < after.index('<manifest'), '5F: the added sentence is inside the header comment')
        expect_after = before.replace(' android:directBootAware="true"', '')
        expect_after = _re.sub(r'\n\s*<intent-filter>\s*<action android:name="android.intent.action.LOCKED_BOOT_COMPLETED" />\s*</intent-filter>', '', expect_after)
        expect_after = expect_after.replace(pu.MANIFEST_HEADER_END, pu.MANIFEST_HEADER_NOTE, 1)
        ok(after == expect_after, '5F: nothing else of the manifest changed (the five flags, the LOCKED filter and the header sentence are the whole difference)')
        ok(all(x in after for x in ('android:exported="true"', 'android:multiprocess="false"', 'android:permission="android.permission.INTERACT_ACROSS_USERS_FULL"', 'android:authorities="${applicationId}.shizuku"', 'rikka.shizuku.intent.action.REQUEST_BINDER')), '5F: exported, multiprocess, permission, authority and the REQUEST_BINDER action are kept')
        ok(dies(pu.patch_direct_boot, r), '5F: patching twice stops (the flags are gone)')

        ok(dies(pu.patch_direct_boot, mtree('t_db_nofile', None)), '5F: patch stops when the manifest is missing')
        ok(dies(pu.patch_direct_boot, mtree('t_db_noheader', UPS, run_b=False)), '5F: patch stops when part B has not run (no header comment)')
        for label, old in (('BootCompleteReceiver', '<receiver android:name=".receiver.BootCompleteReceiver" android:directBootAware="true"'), ('ShizukuReceiver', '<receiver android:name=".receiver.ShizukuReceiver" android:directBootAware="true"'),
                           ('ShizukuManagerProvider', '<provider android:name=".ShizukuManagerProvider" android:authorities="${applicationId}.shizuku" android:directBootAware="true"'),
                           ('RequestPermissionActivity', '<activity android:name=".authorization.RequestPermissionActivity" android:directBootAware="true"'),
                           ('ShellRequestHandlerActivity', '<activity android:name=".legacy.ShellRequestHandlerActivity" android:directBootAware="true"')):
            ok(old in UPS, '5F: test manifest has the line for ' + label)
            ok(dies(pu.patch_direct_boot, mtree('t_db_noflag_' + label, UPS.replace(' android:directBootAware="true"', '', 1) if label == 'BootCompleteReceiver' else UPS.replace(old, old.replace(' android:directBootAware="true"', ''), 1))), '5F: patch stops when %s is not directBootAware' % label)
        ok(dies(pu.patch_direct_boot, mtree('t_db_other', UPS.replace('<activity android:name=".settings.SettingsActivity" android:exported="false" />', '<activity android:name=".settings.SettingsActivity" android:directBootAware="true" android:exported="false" />'))), '5F: patch stops when another component is directBootAware')
        ok(not dies(mpatch, mtree('t_db_false', UPS.replace('<activity android:name=".settings.SettingsActivity" android:exported="false" />', '<activity android:name=".settings.SettingsActivity" android:directBootAware="false" android:exported="false" />'))), '5F: directBootAware="false" on another component is fine')
        ok(not dies(mpatch, mtree('t_db_caps', UPS.replace('directBootAware="true"', 'directBootAware="TRUE"', 1))), '5F: the flag written as TRUE is found and removed')
        ok(dies(pu.patch_direct_boot, mtree('t_db_twice', UPS.replace('</application>', '<receiver android:name=".receiver.ShizukuReceiver" android:directBootAware="true" /></application>'))), '5F: patch stops when a component is declared twice')
        LF = '<intent-filter><action android:name="android.intent.action.LOCKED_BOOT_COMPLETED" /></intent-filter>'
        ok(LF in UPS, '5F: test manifest has the LOCKED filter')
        ok(dies(pu.patch_direct_boot, mtree('t_db_nolocked', UPS.replace(LF, ''))), '5F: patch stops when there is no LOCKED action')
        ok(dies(pu.patch_direct_boot, mtree('t_db_two_locked', UPS.replace(LF, LF + LF))), '5F: patch stops when there are two LOCKED actions')
        ok(dies(pu.patch_direct_boot, mtree('t_db_noboot', UPS.replace('<intent-filter><action android:name="android.intent.action.BOOT_COMPLETED" /></intent-filter>', ''))), '5F: patch stops when BOOT_COMPLETED is missing')
        ok(dies(pu.patch_direct_boot, mtree('t_db_twoboot', UPS.replace(LF, '<intent-filter><action android:name="android.intent.action.BOOT_COMPLETED" /></intent-filter>' + LF))), '5F: patch stops when BOOT_COMPLETED is there twice')
        shared = UPS.replace(LF, '').replace('<intent-filter><action android:name="android.intent.action.BOOT_COMPLETED" /></intent-filter>',
                                              '<intent-filter><action android:name="android.intent.action.LOCKED_BOOT_COMPLETED" /><action android:name="android.intent.action.BOOT_COMPLETED" /></intent-filter>')
        r = mtree('t_db_shared', shared)
        mpatch(r)
        ok('LOCKED_BOOT_COMPLETED' not in body(mread(r)) and mread(r).count('android.intent.action.BOOT_COMPLETED') == 1 and mcheck(mread(r)) == [], '5F: a LOCKED action that shares its filter with BOOT_COMPLETED is removed alone, the filter stays')

        MM = ('<manifest %s><application>%%s</application></manifest>') % NS2
        BR = '<receiver android:name="%s"><intent-filter><action android:name="android.intent.action.BOOT_COMPLETED"/></intent-filter></receiver>' % pu.BOOT_RECEIVER_NAME
        ok(mcheck(MM % BR) == [], '5F: the smallest good manifest passes check_direct_boot')
        ok(len(mcheck('<manifest')) == 1, '5F: a manifest that is not well-formed is one error')
        ok(len(mcheck(MM % (BR + '<activity android:name=".A" android:directBootAware="true"/>'))) == 1, '5F: a directBootAware activity fails')
        ok(len(mcheck((MM % BR).replace('<application>', '<application android:directBootAware="true">'))) == 1, '5F: directBootAware on <application> fails')
        ok(len(mcheck(MM % (BR + '<activity android:name=".A" android:directBootAware="false"/>'))) == 0, '5F: directBootAware="false" passes')
        ok(len(mcheck(MM % (BR + '<activity android:name=".A" android:directBootAware="yes"/>'))) == 1, '5F: any value but false counts as set')
        ok(len(mcheck(MM % (BR + '<service android:name=".S"><intent-filter><action android:name="android.intent.action.LOCKED_BOOT_COMPLETED"/></intent-filter></service>'))) == 1, '5F: a LOCKED action on any component fails')
        ok(len(mcheck(MM % '')) == 1, '5F: no BootCompleteReceiver fails')
        ok(len(mcheck(MM % (BR + BR))) == 1, '5F: BootCompleteReceiver twice fails once')
        ok(len(mcheck(MM % BR.replace('BOOT_COMPLETED', 'OTHER'))) == 1, '5F: BootCompleteReceiver without BOOT_COMPLETED fails')
        ok(len(mcheck(MM % BR.replace('</receiver>', '<intent-filter><action android:name="android.intent.action.BOOT_COMPLETED"/></intent-filter></receiver>'))) == 1, '5F: BOOT_COMPLETED twice in the receiver fails')

        # ---- 5G: night mode per activity (finding 14)
        PRE = 'manager/src/main/java/moe/shizuku/manager/'
        AA = ('package moe.shizuku.manager.app\n\nimport android.content.res.Resources\nimport android.content.res.Resources.Theme\nimport android.graphics.Color\nimport android.os.Build\n'
              'import androidx.annotation.RequiresApi\nimport moe.shizuku.manager.R\nimport rikka.core.res.isNight\nimport rikka.material.app.MaterialActivity\n\n'
              'abstract class AppActivity : MaterialActivity() {\n\n    override fun computeUserThemeKey(): String {\n        return ThemeHelper.getTheme(this) + ThemeHelper.isUsingSystemColor()\n    }\n}\n')
        SF = ('package moe.shizuku.manager.settings\n\nimport androidx.appcompat.app.AppCompatDelegate\n\nclass SettingsFragment : PreferenceFragmentCompat() {\n\n'
              '    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {\n        nightModePreference.value = ShizukuSettings.getNightMode()\n'
              '        nightModePreference.onPreferenceChangeListener =\n            Preference.OnPreferenceChangeListener { _: Preference?, value: Any? ->\n                if (value is Int) {\n'
              '                    if (ShizukuSettings.getNightMode() != value) {\n                        AppCompatDelegate.setDefaultNightMode(value)\n                        activity?.recreate()\n                    }\n'
              '                }\n                true\n            }\n        if (ShizukuSettings.getNightMode() != AppCompatDelegate.MODE_NIGHT_NO) {\n            blackNightThemePreference.isVisible = true\n        }\n    }\n}\n')
        HIER = {   # path -> source: the activity chain of the real tree (MainActivity is Java upstream)
            'MainActivity.java': 'package moe.shizuku.manager;\n\npublic class MainActivity extends HomeActivity {\n}\n',
            'home/HomeActivity.kt': 'abstract class HomeActivity : AppBarActivity() {\n}\n',
            'app/AppBarActivity.kt': 'abstract class AppBarActivity : AppActivity() {\n}\n\nabstract class AppBarFragmentActivity : AppBarActivity() {\n}\n',
            'settings/SettingsActivity.kt': 'class SettingsActivity : AppBarFragmentActivity() {\n}\n',
            'authorization/RequestPermissionActivity.kt': 'class RequestPermissionActivity : AppActivity() {\n}\n',
        }
        NMAN = ('<manifest %s><application><activity android:name=".MainActivity"/><activity android:name=".settings.SettingsActivity"/>'
                '<activity android:name=".authorization.RequestPermissionActivity"/></application></manifest>') % NS2
        APPKT = pu.APPLICATION_KT

        def ntree(name, aa=AA, sf=SF, app=APPKT, hier=HIER):
            r = os.path.join(tmp, name)
            shutil.rmtree(r, ignore_errors=True)
            files = {'app/AppActivity.kt': aa, 'settings/SettingsFragment.kt': sf, 'ShizukuApplication.kt': app}
            files.update(hier)
            for rel, text in files.items():
                if text is None:
                    continue
                fp = os.path.join(r, PRE + rel)
                os.makedirs(os.path.dirname(fp), exist_ok=True)
                with open(fp, 'w') as f:
                    f.write(text)
            return r

        def npatch(r):
            with contextlib.redirect_stdout(io.StringIO()) as out:
                pu.patch_night_mode(r)
            return out.getvalue()

        def nread(r, rel):
            with open(os.path.join(r, PRE + rel)) as f:
                return f.read()

        def nput(r, rel, text):
            fp = os.path.join(r, PRE + rel)
            os.makedirs(os.path.dirname(fp), exist_ok=True)
            with open(fp, 'w') as f:
                f.write(text)

        def ncheck(r, man=NMAN):
            e = []
            pu.check_night_mode(r, man, e)
            return e

        def patched(name, **kw):
            r = ntree(name, **kw)
            npatch(r)
            return r

        ok(pu.NIGHT_SETTER == 'setDefaultNightMode' and pu.NIGHT_CALL == 'delegate.localNightMode = ShizukuSettings.getNightMode()', '5G: the setter name and the per-activity call are the ones written in finding 14')
        ok('AppCompatDelegate' not in pu.APPLICATION_KT and pu.NIGHT_SETTER not in pu.APPLICATION_KT, '5G: the ShizukuApplication template of part B no longer touches AppCompatDelegate')
        ok('    patch_direct_boot(root)\n    patch_night_mode(root)\n' in src, '5G: main() runs patch_night_mode right after patch_direct_boot')
        ok('    check_night_mode(root, man, errors)\n' in src, '5G: check() runs check_night_mode')
        ok(pu.NIGHT_ATTACH_CODE.count('super.attachBaseContext(newBase)') == 1 and pu.NIGHT_ATTACH_CODE.index(pu.NIGHT_CALL) < pu.NIGHT_ATTACH_CODE.index('super.attachBaseContext(newBase)')
           and 'try {' in pu.NIGHT_ATTACH_CODE and 'catch (e: Throwable)' in pu.NIGHT_ATTACH_CODE, '5G: the inserted override sets the mode before super, inside try / catch')
        ok(pu.NIGHT_SETTER not in pu.strip_kotlin_comments(pu.NIGHT_ATTACH_CODE + pu.NIGHT_SETTINGS_NOTE), '5G: the inserted code does not spell the setter outside comments')

        r = ntree('t_nm')
        before_aa, before_sf = nread(r, 'app/AppActivity.kt'), nread(r, 'settings/SettingsFragment.kt')
        ok(len(ncheck(r)) >= 1, '5G: the unpatched tree (setter in SettingsFragment, no override) fails the check')
        out = npatch(r)
        aa, sf = nread(r, 'app/AppActivity.kt'), nread(r, 'settings/SettingsFragment.kt')
        ok(out.startswith('H. night mode') and '2 files' in out, '5G: patch_night_mode reports part H, 2 files')
        ok(ncheck(r) == [], '5G: a patched tree passes check_night_mode')
        ok(aa.count('override fun attachBaseContext(newBase: Context)') == 1 and aa.count(pu.NIGHT_CALL) == 1 and aa.count('super.attachBaseContext(newBase)') == 1, '5G: AppActivity has the override once, with the call and super once each')
        ok(aa.index(pu.NIGHT_CALL) < aa.index('super.attachBaseContext(newBase)') and aa.index('abstract class AppActivity') < aa.index('attachBaseContext'), '5G: the call comes before super and the override is inside the class')
        ok(all(aa.count(i) == 1 for i in ('import android.content.Context\n', 'import android.util.Log\n', 'import moe.shizuku.manager.ShizukuSettings\n')), '5G: the three imports are added once each')
        back = aa.replace('import android.content.Context\n', '', 1).replace('import android.util.Log\n', '', 1).replace('import moe.shizuku.manager.ShizukuSettings\n', '', 1).replace('\n' + pu.NIGHT_ATTACH_CODE, '', 1)
        ok(back == before_aa, '5G: nothing else of AppActivity changed (imports and the override are the whole difference)')
        ok(pu.NIGHT_SETTER not in sf.replace(pu.NIGHT_SETTINGS_NOTE, '') and sf.count('activity?.recreate()') == 1 and sf.count(pu.NIGHT_SETTINGS_NOTE) == 1, '5G: SettingsFragment lost the setter call, kept activity?.recreate(), got the note once')
        ok(sf.replace(pu.NIGHT_SETTINGS_NOTE, '                        AppCompatDelegate.setDefaultNightMode(value)\n', 1) == before_sf, '5G: nothing else of SettingsFragment changed (the one line is the whole difference)')
        ok(dies(pu.patch_night_mode, r), '5G: patching twice stops (the setter line is gone)')

        ok(dies(pu.patch_night_mode, ntree('t_nm_noaa', aa=None)), '5G: patch stops when AppActivity.kt is missing')
        ok(dies(pu.patch_night_mode, ntree('t_nm_nosf', sf=None)), '5G: patch stops when SettingsFragment.kt is missing')
        ok(dies(pu.patch_night_mode, ntree('t_nm_nosetter', sf=SF.replace('                        AppCompatDelegate.setDefaultNightMode(value)\n', ''))), '5G: patch stops when SettingsFragment has no setter line')
        two = SF.replace('                        activity?.recreate()\n', '                        AppCompatDelegate.setDefaultNightMode(value)\n                        activity?.recreate()\n')
        ok(dies(pu.patch_night_mode, ntree('t_nm_twosetter', sf=two)), '5G: patch stops when SettingsFragment has two setter lines')
        ok(dies(pu.patch_night_mode, ntree('t_nm_norecreate', sf=SF.replace('                        activity?.recreate()\n', ''))), '5G: patch stops when SettingsFragment has no activity?.recreate()')
        ok(dies(pu.patch_night_mode, ntree('t_nm_other', sf=SF.replace('(value)', '(value) // x') + '\nfun f() { AppCompatDelegate.setDefaultNightMode(1) }\n')), '5G: patch stops on a second use of the setter (inline call)')
        ok(dies(pu.patch_night_mode, ntree('t_nm_hasattach', aa=AA.replace('    override fun computeUserThemeKey', '    override fun attachBaseContext(newBase: Context) { super.attachBaseContext(newBase) }\n    override fun computeUserThemeKey'))), '5G: patch stops when AppActivity already has an attachBaseContext')
        ok(dies(pu.patch_night_mode, ntree('t_nm_class', aa=AA.replace('MaterialActivity()', 'AppCompatActivity()'))), '5G: patch stops when AppActivity extends another class')
        for imp in ('import android.content.res.Resources\n', 'import android.os.Build\n', 'import moe.shizuku.manager.R\n'):
            ok(dies(pu.patch_night_mode, ntree('t_nm_imp', aa=AA.replace(imp, '', 1))), '5G: patch stops when the anchor %s is missing' % imp.strip())
        ok(dies(pu.patch_night_mode, ntree('t_nm_app', app=APPKT.replace('        LocaleDelegate.defaultLocale', '        AppCompatDelegate.setDefaultNightMode(1)\n        LocaleDelegate.defaultLocale'))), '5G: patch stops when ShizukuApplication.kt still sets the night mode')
        ok(dies(pu.patch_night_mode, ntree('t_nm_app2', app=APPKT.replace('import com.topjohnwu', 'import androidx.appcompat.app.AppCompatDelegate\nimport com.topjohnwu'))), '5G: patch stops when ShizukuApplication.kt still imports AppCompatDelegate')

        # check_night_mode on mutated, patched trees
        P = patched('t_nm_p')
        ok(ncheck(P) == [], '5G: the patched tree is the reference for the mutations')
        r = patched('t_nm_m1'); nput(r, 'home/Extra.kt', 'fun f() { AppCompatDelegate.setDefaultNightMode(2) }\n')
        ok(len(ncheck(r)) == 1, '5G: a setter call in another Kotlin file fails')
        r = patched('t_nm_m2'); nput(r, 'home/Extra.java', 'class Extra { void f() { AppCompatDelegate.setDefaultNightMode(2); } }\n')
        ok(len(ncheck(r)) == 1, '5G: a setter call in a Java file fails')
        r = patched('t_nm_m3'); nput(r, 'home/Extra.kt', '// AppCompatDelegate.setDefaultNightMode(2) was here\n/* and AppCompatDelegate.setDefaultNightMode(1)\n   here */\nfun f() {}\n')
        ok(ncheck(r) == [], '5G: the setter name in a line or block comment is not a call')
        r = patched('t_nm_m4'); nput(r, 'ShizukuApplication.kt', nread(r, 'ShizukuApplication.kt').replace('object ShizukuApplication {', 'object ShizukuApplication {\n    val d = AppCompatDelegate.MODE_NIGHT_YES'))
        ok(len(ncheck(r)) == 1, '5G: ShizukuApplication using AppCompatDelegate fails')
        a = nread(P, 'app/AppActivity.kt')
        r = patched('t_nm_m5'); nput(r, 'app/AppActivity.kt', a.replace(pu.NIGHT_CALL, 'val x = 1'))
        ok(len(ncheck(r)) == 1, '5G: AppActivity without the call fails')
        r = patched('t_nm_m6'); nput(r, 'app/AppActivity.kt', a.replace('override fun attachBaseContext(newBase: Context) {', 'override fun attachBaseContext2(newBase: Context) {'))
        ok(len(ncheck(r)) == 1, '5G: AppActivity without the attachBaseContext override fails')
        r = patched('t_nm_m7'); nput(r, 'app/AppActivity.kt', a + '\nabstract class Other {\n    override fun attachBaseContext(newBase: Context) {}\n}\n')
        ok(len(ncheck(r)) == 1, '5G: a second attachBaseContext override fails (exactly one)')
        r = patched('t_nm_m8'); nput(r, 'app/AppActivity.kt', a.replace('        try {\n            ' + pu.NIGHT_CALL + '\n        } catch (e: Throwable) {\n            Log.w("AppActivity", "Shizuku night mode not applied", e)\n        }\n        super.attachBaseContext(newBase)', '        super.attachBaseContext(newBase)\n        try {\n            ' + pu.NIGHT_CALL + '\n        } catch (e: Throwable) {\n            Log.w("AppActivity", "Shizuku night mode not applied", e)\n        }'))
        ok(a != nread(r, 'app/AppActivity.kt') and len(ncheck(r)) == 1 and 'after super' in ncheck(r)[0], '5G: the call after super.attachBaseContext fails (AppCompat would recreate)')
        r = patched('t_nm_m9'); nput(r, 'app/AppActivity.kt', a.replace('        try {\n            ' + pu.NIGHT_CALL + '\n        } catch (e: Throwable) {\n            Log.w("AppActivity", "Shizuku night mode not applied", e)\n        }\n', '        ' + pu.NIGHT_CALL + '\n'))
        ok(a != nread(r, 'app/AppActivity.kt') and len(ncheck(r)) == 1 and 'try' in ncheck(r)[0], '5G: the call without try / catch fails')
        r = patched('t_nm_m10'); nput(r, 'app/AppActivity.kt', a.replace('catch (e: Throwable)', 'catch (e: Exception)'))
        ok(len(ncheck(r)) == 1, '5G: catching only Exception (not Throwable) fails')
        r = patched('t_nm_m11'); nput(r, 'app/AppActivity.kt', a.replace('super.attachBaseContext(newBase)', 'super.attachBaseContext(newBase)\n        super.attachBaseContext(newBase)'))
        ok(len(ncheck(r)) == 1, '5G: super.attachBaseContext twice fails')
        for imp in ('import android.content.Context', 'import android.util.Log', 'import moe.shizuku.manager.ShizukuSettings'):
            r = patched('t_nm_imp2'); nput(r, 'app/AppActivity.kt', a.replace(imp + '\n', '', 1))
            ok(len(ncheck(r)) == 1 and imp in ncheck(r)[0], '5G: a missing %s fails' % imp)
        r = patched('t_nm_m12'); nput(r, 'app/AppActivity.kt', a.replace('abstract class AppActivity : MaterialActivity()', 'abstract class AppActivity : AppCompatActivity()'))
        ok(len(ncheck(r)) >= 1, '5G: AppActivity with another superclass fails')
        s0 = nread(P, 'settings/SettingsFragment.kt')
        r = patched('t_nm_m13'); nput(r, 'settings/SettingsFragment.kt', s0.replace('activity?.recreate()', 'activity?.finish()'))
        ok(len(ncheck(r)) == 1, '5G: a Settings listener without activity?.recreate() fails')
        r = patched('t_nm_m14'); nput(r, 'settings/SettingsFragment.kt', s0.replace('nightModePreference.onPreferenceChangeListener', 'nightModePreference.other'))
        ok(len(ncheck(r)) == 1, '5G: a Settings screen without the night-mode listener fails (anchor of the check)')
        r = patched('t_nm_m15'); nput(r, 'settings/SettingsFragment.kt', s0.replace('        if (ShizukuSettings.getNightMode() != AppCompatDelegate.MODE_NIGHT_NO) {', '        // recreate lives only in a comment: activity?.recreate()\n        if (ShizukuSettings.getNightMode() != AppCompatDelegate.MODE_NIGHT_NO) {').replace('                        activity?.recreate()\n', ''))
        ok(len(ncheck(r)) == 1, '5G: activity?.recreate() only in a comment, outside the listener, fails')
        r = os.path.join(tmp, 't_nm_nofiles'); shutil.rmtree(r, ignore_errors=True); os.makedirs(os.path.join(r, 'manager/src/main/java'))
        ok(len(ncheck(r, '<manifest %s><application/></manifest>' % NS2)) == 2, '5G: a tree without AppActivity.kt and SettingsFragment.kt is two errors (no crash; ShizukuApplication.kt is part B output and checked by check() itself)')
        ok(len(ncheck(r)) == 5, '5G: ... and with three manifest activities whose classes are not there, five')
        # every activity reaches AppActivity
        ok(ncheck(P, NMAN.replace('</application>', '<activity android:name=".MainActivity"/></application>')) == [], '5G: an activity named twice is fine')
        r = patched('t_nm_h1', hier=dict(HIER, **{'home/HomeActivity.kt': 'abstract class HomeActivity : AppCompatActivity() {\n}\n'}))
        e = ncheck(r)
        ok(len(e) == 1 and '.MainActivity' in e[0], '5G: MainActivity -> HomeActivity -> AppCompatActivity (the chain leaves AppActivity) fails for MainActivity only')
        r = patched('t_nm_h2', hier=dict(HIER, **{'MainActivity.java': 'public class MainActivity extends Foo {\n}\n'}))
        ok(len(ncheck(r)) == 1, '5G: a Java activity with an unknown superclass fails')
        r = patched('t_nm_h3', hier=dict(HIER, **{'MainActivity.java': 'public class MainActivity extends HomeActivity {\n}\n', 'home/HomeActivity.kt': 'abstract class HomeActivity : MainActivity() {\n}\n'}))
        ok(len(ncheck(r)) == 1, '5G: a cyclic hierarchy fails and does not loop')
        r = patched('t_nm_h4', hier={k: v for k, v in HIER.items() if k != 'settings/SettingsActivity.kt'})
        ok(len(ncheck(r)) == 1 and 'SettingsActivity' in ncheck(r)[0], '5G: an activity whose class is not found fails')
        r = patched('t_nm_h5', hier=dict(HIER, **{'authorization/RequestPermissionActivity.kt': 'class RequestPermissionActivity : AppActivity() {\n}\n', 'home/HomeActivity.kt': 'abstract class HomeActivity(val x: Int) : AppBarActivity() {\n}\n'}))
        ok(ncheck(r) == [], '5G: a Kotlin class with a primary constructor is read')
        ok(ncheck(P, '<manifest') == [], '5G: a manifest that is not well-formed adds no error of its own (the other rules report it)')
        ok(ncheck(P, '<manifest %s><application/></manifest>' % NS2) == [], '5G: a manifest without activities passes')
    finally:
        shutil.rmtree(tmp, ignore_errors=True)
    print(f'test-patch-host-package: {total - fails} of {total} cases ok' + ('' if not fails else ' - FAILED'))
    return 1 if fails else 0


if __name__ == '__main__':
    sys.exit(main())
