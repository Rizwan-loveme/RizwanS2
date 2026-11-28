#!/usr/bin/env python3
"""Turns the Shizuku checkout fetched by tools/fetch-upstream.sh (shizuku/upstream/) into code that can run INSIDE the Win11 app (step 2 of 10; part E added in step 3, part F in step 5E, part G in step 5F, part H in step 5G).

Why a patch script and not a hand-edited copy: the pinned upstream (UPSTREAM_VERSION / UPSTREAM_COMMIT) can be bumped by changing one file, the changes are
listed in one place (NOTICE-Shizuku.md asks for that: Apache-2.0 section 4), and the package rename of the CI (new_package_name) is followed automatically,
because the host package is read from app/build.gradle.kts at patch time (the rename runs before this script).

Does NOT touch Gradle files: upstream's build.gradle files are not used (step 3: shizuku/build.gradle.kts and shizuku/modules/*/build.gradle.kts point at the patched sources).

What it does (every edit asserts that its anchor exists, so an upstream change fails loudly instead of being skipped):

 A. HOST PACKAGE. The manager package "moe.shizuku.privileged.api" is a RUN-TIME string in 8 places (server, starter, shell, native starter.cpp, API ShizukuProvider,
    manager provider): "pm path <package>", PackageManager lookups, binder extras, intent actions. A library has no package of its own: at run time it is the host app
    (com.srizwan.win11), so every package-name use of them becomes the host package. The Java / Kotlin package (moe.shizuku.manager = the library namespace) and the permission
    names (moe.shizuku.manager.permission.API_V23 / MANAGER, which every Shizuku client asks for) are NOT renamed. Step 5C: neither is the binder EXTRA KEY
    "moe.shizuku.privileged.api.intent.extra.BINDER" (4 of the 9 uses of the old name): it is the name under which the server hands the binder to a provider, and every
    outside Shizuku client reads exactly that key, so it stays (BINDER_EXTRA_KEPT); the self-check requires it in those four files and nowhere spelled with the host package.
 B. LIBRARY CONVERSION of the manager (application -> library):
      - ShizukuApplication (an Application subclass) becomes an object; the host Application calls ShizukuApplication.onCreate(app) (step 6)
      - Context.application and BuildConfig.APPLICATION_ID (a library has none) use Application / the host package
      - AndroidManifest.xml: no application attributes (name, icon, theme, backup ... belong to :app), no LAUNCHER filter (Start menu starts MainActivity, not exported),
        every activity gets the Shizuku theme itself (it used to get it from <application>)
      - the <permission> and <uses-permission> of ${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION (both tools:node="remove" upstream) are deleted (step 4C-1): in an
        application the markers only cut what AndroidX core adds, in a library a marker applies to everything below it, so the permission would also vanish from :app and every
        module that calls ContextCompat.registerReceiver(..., RECEIVER_NOT_EXPORTED) = a crash on Android 8 - 12 (minSdk 26). The manager itself does not need the removal.
      - styles that override library styles BY NAME (themes_override.xml: Base.ThemeOverlay.AppCompat.*, Widget.MaterialComponents.CompoundButton.*) are dropped:
        in an app they restyle that widget everywhere, in a library they would restyle the whole Win11 app
 C. RESOURCES: every resource of the manager gets the prefix sh_ (files and value names, references in XML and R.type.name in Kotlin / Java, ViewBinding class names that
    follow the layout file names). Ids, attrs and styleables are kept (an id cannot override anything; the 2 attrs are Shizuku-specific, checked against the project).
 E. GENERATED SOURCE (step 3). Upstream's manager build uses Rikka's Gradle plugin "autoresconfig" to generate rikka.shizuku.manager.ShizukuLocales (LOCALES / DISPLAY_LOCALES,
    used by the language setting). That plugin only runs in an application module (it throws "Android application extension not found" in a library), so the same class is
    generated here, with the plugin's own rules (values-*/strings.xml folders of the manager's res, "en" always, \"SYSTEM\" first, zh-CN / zh-TW shown as zh-Hans / zh-Hant).
    The plugin's other two outputs are NOT made: resConfig filter (a library has none; :app decides) and xml/locales_config.xml (needs android:localeConfig on <application>, which belongs to :app).
 F. PAIRING SERVICE (step 5E, finding 11). adb/AdbPairingService.kt is a foreground service of type shortService (about 3 minutes from startForeground) that keeps the mDNS search
    open until pairing works or the user stops it. On Android 14+ the system calls Service.onTimeout when the limit is over and raises RemoteServiceException if the service does not
    stop. Upstream that kills only the Shizuku app; here the manager runs in the MAIN process of the host, so the same crash would close the whole app. The patch adds two overrides at the
    top of the class body, onTimeout(startId) and onTimeout(startId, fgsType), each doing stopForeground(STOP_FOREGROUND_REMOVE) + stopSelf() (onDestroy stops the search and the
    pairing coroutine's owner, as upstream's own stop action does). The user just taps "pair" again. Anchors: the class line and an existing onDestroy; upstream must not have an
    onTimeout yet (a new upstream one must be reviewed, so it stops the script).
 G. DIRECT BOOT (step 5F, finding 12, option a+). The manager's BootCompleteReceiver, ShizukuReceiver and ShizukuManagerProvider are android:directBootAware, and BootCompleteReceiver also takes
    LOCKED_BOOT_COMPLETED. In the host that makes Android start the MAIN process before the first unlock (App.attachBaseContext / App.onCreate run while credential-protected storage is
    locked: AppLog, ThemeManager, Seal, Mika), which no component of :app or Mika ever did. The patch removes android:directBootAware from exactly the five components that carry it (BootCompleteReceiver, ShizukuReceiver, ShizukuManagerProvider and, found in 5G on the real tree, RequestPermissionActivity and ShellRequestHandlerActivity) and the
    LOCKED_BOOT_COMPLETED action of BootCompleteReceiver (its BOOT_COMPLETED filter stays). Cost: Shizuku's boot start runs after the first unlock instead of before it. Anchors: each of the
    five components exists once and carries the flag, no other component carries it (an upstream change must be reviewed, so it stops the script), the receiver has exactly one LOCKED_BOOT_COMPLETED
    action and keeps a BOOT_COMPLETED one. The manifest keeps the header comment of part B (one sentence is added to it).
 H. NIGHT MODE (step 5G, finding 14). Upstream's ShizukuApplication.onCreate and the manager's Settings screen call AppCompatDelegate's process-wide default night mode setter. In the host that static is
    shared with every AppCompat screen of :app (the Rikka fork is excluded, decision 1), so one tap on "Dark" in Shizuku's Settings would force the whole host dark, again at every start. The patch keeps the stored
    setting but applies it per activity: (1) ShizukuApplication.onCreate (part B's template) no longer sets it; (2) SettingsFragment no longer sets it (its activity?.recreate() stays, the new instance reads the
    stored value; the preference persists the value right after the change listener returns, the relaunch comes later); (3) the base class AppActivity gets an attachBaseContext override that sets
    `delegate.localNightMode = ShizukuSettings.getNightMode()` BEFORE super.attachBaseContext (AppCompat reads the local mode while it wraps the base context, so the first frame is right; set in onCreate
    AppCompat would recreate the activity), inside try / catch so an uninitialised ShizukuSettings cannot break a screen. Anchors: the AppActivity class line and its imports, no attachBaseContext in
    AppActivity yet (a new upstream one must be reviewed), exactly one setter call in SettingsFragment.
 D. SELF-CHECK (also: python3 patch-upstream.py --check): XML well-formed, no old name left, no R.* / @type/ reference to a name that does not exist, no BuildConfig, package string only where allowed,
    no tools:node="remove" (or removeAll / replace) marker on DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION anywhere in the manifest (step 4C-2),
    native starter (step 5B-1): `#define PACKAGE_NAME` of starter.cpp is exactly once the host package (the `pm path <package>` the starter runs), and the host package is a plain package name
    (checked before patching; an applicationIdSuffix in app/build.gradle.kts stops the script),
    native libraries (step 5B-2): the library manifest's <application> has no android:extractNativeLibs (the host app sets it, libshizuku.so is run from nativeLibraryDir),
    permission ownership (step 4C-3): MANAGER (signature) and API_V23 (dangerous, group ...permission-group.API) declared once each, one uses-permission MANAGER, one uses-permission API_V23 with
    tools:node="remove" (the guard),
    intent actions (step 5D): ServerConstants builds REQUEST_PERMISSION_ACTION from MANAGER_APPLICATION_ID and ShizukuService aims it at that package, the manifest carries
    ${applicationId}.intent.action.REQUEST_PERMISSION / REQUEST_AUTHORIZATION and rikka.shizuku.intent.action.REQUEST_BINDER only on their expected components (no literal package in an
    action name), the REQUEST_BINDER literal appears in its four places and the shell loader aims it at the host, no other action-looking literal exists in the sources,
    pairing service (step 5E): AdbPairingService.kt has exactly the two onTimeout overrides, inside the class, each stopping the foreground state and then the service, and keeps its onDestroy,
    direct boot (step 5F): no element of the manifest is android:directBootAware, no LOCKED_BOOT_COMPLETED action is left, BootCompleteReceiver still listens to BOOT_COMPLETED once,
    night mode (step 5G): no call of the process-wide night-mode setter left in any source (comments do not count), AppActivity applies the stored mode in a guarded attachBaseContext before super, the Settings
    screen still recreates after a change, ShizukuApplication no longer touches AppCompatDelegate, every activity of the manifest reaches AppActivity through its superclasses,
    ShizukuLocales present and consistent.

Idempotent: the marker shizuku/upstream/.win11-patched holds the hash of this script + the host package. Same hash -> nothing to do. Different hash -> the checkout is first
put back to the pristine pinned state (git checkout + git clean inside upstream/ and upstream/api/) and patched again. SHIZUKU_FORCE_PATCH=1 forces that.
Needs python3 (3.8+) and git. Environment / options: SHIZUKU_UPSTREAM_DIR (checkout folder, tests), SHIZUKU_HOST_PACKAGE or --host-package (default: applicationId of app/build.gradle.kts).
"""
import argparse, collections, hashlib, os, re, subprocess, sys
import xml.etree.ElementTree as ET

HERE = os.path.dirname(os.path.abspath(__file__))
SHIZUKU = os.path.dirname(HERE)                      # shizuku/
PROJECT = os.path.dirname(SHIZUKU)
OLD_PKG = 'moe.shizuku.privileged.api'
PREFIX = 'sh_'
MARKER = '.win11-patched'

ANDROID_NS = 'http://schemas.android.com/apk/res/android'
TOOLS_NS = 'http://schemas.android.com/tools'

# (file relative to upstream/, number of occurrences of OLD_PKG that must be there)
PACKAGE_FILES = [
    ('server/src/main/java/rikka/shizuku/server/ServerConstants.java', 1),
    ('server/src/main/java/rikka/shizuku/server/ShizukuService.java', 1),
    ('starter/src/main/java/moe/shizuku/starter/ServiceStarter.java', 2),
    ('shell/src/main/java/rikka/shizuku/shell/ShizukuShellLoader.java', 1),
    ('manager/src/main/jni/starter.cpp', 1),
    ('manager/src/main/java/moe/shizuku/manager/ShizukuManagerProvider.kt', 1),
    ('api/provider/src/main/java/rikka/shizuku/ShizukuProvider.java', 2),
]
# files that may still name the old package after patching (unused by our build / documentation)
PACKAGE_ALLOWED_LEFT = ['manager/build.gradle']

# Step 5C: the binder EXTRA KEY is not a package. "moe.shizuku.privileged.api.intent.extra.BINDER" is the name under which the server hands the binder to an app's
# provider (`call(\"sendBinder\", ..., extras)`), and every Shizuku client in the world (third-party apps with the stock rikka.shizuku.ShizukuProvider) reads exactly this
# key. Renaming it to "<host>.intent.extra.BINDER" would make the server and the built-in manager agree with each other and with nobody else: no outside client would
# ever get the binder. So the key stays as upstream has it, in the four files that spell it (the count of OLD_PKG in PACKAGE_FILES includes it); only the real
# package-name uses (MANAGER_APPLICATION_ID, `pm path`, setPackage, packageName) become the host package.
BINDER_EXTRA = OLD_PKG + '.intent.extra.BINDER'
BINDER_EXTRA_KEPT = {   # file -> how many times it spells BINDER_EXTRA (kept as it is)
    'server/src/main/java/rikka/shizuku/server/ShizukuService.java': 1,
    'starter/src/main/java/moe/shizuku/starter/ServiceStarter.java': 1,
    'manager/src/main/java/moe/shizuku/manager/ShizukuManagerProvider.kt': 1,
    'api/provider/src/main/java/rikka/shizuku/ShizukuProvider.java': 1,
}
OLD_NAME_RE = re.compile(re.escape(OLD_PKG) + r'(?!\.intent\.extra\.BINDER(?![\w]))')   # the old name, but not as the start of the binder extra key
BINDER_EXTRA_RE = re.compile(re.escape(BINDER_EXTRA) + r'(?![\w])')

# Step 5D: INTENT ACTIONS. Same principle as the binder key: a name that outside clients or other apps know stays as upstream has it, a name that only the server and the
# built-in manager use follows the host package. Read on the real v13.6.0 tree (5D section of the README):
#   REQUEST_PERMISSION   server -> manager activity. Sent by ShizukuService.showPermissionConfirmation as `ServerConstants.REQUEST_PERMISSION_ACTION` =
#                        MANAGER_APPLICATION_ID + ".intent.action.REQUEST_PERMISSION" with setPackage(MANAGER_APPLICATION_ID); received by RequestPermissionActivity through the
#                        manifest filter "${applicationId}.intent.action.REQUEST_PERMISSION". After part A both are the host package, nothing to patch. Outside clients never send
#                        it (they ask over the binder; the server sends the intent), so it follows the host.
#   REQUEST_AUTHORIZATION  nobody sends it (not in the server, the API or the manager); only the manifest filter of LegacyIsNotSupportedActivity has it, and that activity is
#                        protected by a permission nobody declares. It follows ${applicationId}; nothing to patch.
#   rikka.shizuku.intent.action.REQUEST_BINDER   rish / shell loader -> manager (broadcast to ShizukuReceiver, activity fallback on Android 8.0 / 8.1). A rikka name, spelled as a
#                        literal in four places; stays. The loader aims it at the host with setPackage (5A).
#   moe.shizuku.api.action.BINDER_RECEIVED   the API provider's own in-app broadcast (sender and receiver are the same class, RECEIVER_NOT_EXPORTED); a library name, stays.
ACTION_PERMISSION_SUFFIX = '.intent.action.REQUEST_PERMISSION'
ACTION_AUTHORIZATION_SUFFIX = '.intent.action.REQUEST_AUTHORIZATION'
ACTION_BINDER = 'rikka.shizuku.intent.action.REQUEST_BINDER'
ACTION_BINDER_RECEIVED = 'moe.shizuku.api.action.BINDER_RECEIVED'
MANIFEST_ACTIONS = {   # custom action in the generated manifest -> the components (relative names) that carry it, each exactly once
    '${applicationId}' + ACTION_PERMISSION_SUFFIX: ['.authorization.RequestPermissionActivity'],
    '${applicationId}' + ACTION_AUTHORIZATION_SUFFIX: ['.legacy.LegacyIsNotSupportedActivity'],
    ACTION_BINDER: ['.legacy.ShellRequestHandlerActivity', '.receiver.ShizukuReceiver'],
}
BINDER_ACTION_FILES = {   # file -> how many times it spells the literal ACTION_BINDER (sender: the shell loader, twice; receivers: the manager's handler and receiver)
    'shell/src/main/java/rikka/shizuku/shell/ShizukuShellLoader.java': 2,
    'manager/src/main/java/moe/shizuku/manager/shell/ShellBinderRequestHandler.kt': 1,
    'manager/src/main/java/moe/shizuku/manager/receiver/ShizukuReceiver.kt': 1,
}
ACTION_LITERAL_RE = re.compile(r'"([^"\n]*\.action\.[^"\n]*)"')   # any string literal that looks like an action name
ACTION_LITERALS_ALLOWED = {ACTION_BINDER, ACTION_BINDER_RECEIVED, ACTION_PERMISSION_SUFFIX}   # the third is the tail ServerConstants appends to MANAGER_APPLICATION_ID

# Step 5E (finding 11): the pairing service is a shortService; Android 14+ calls onTimeout at the limit and crashes the process if the service does not stop. Read on the real v13.6.0
# file in 4D-2 (330 lines, `@TargetApi(R) class AdbPairingService : Service()`, no onTimeout anywhere in upstream, onDestroy stops the search, handleResult ends with
# stopForeground(REMOVE) + stopSelf()). Both signatures are overridden: onTimeout(int) exists from API 34, onTimeout(int, int) from API 35 (compileSdk is 37, minSdk 26: on older systems
# the methods are simply never called).
PAIRING_SERVICE = 'manager/src/main/java/moe/shizuku/manager/adb/AdbPairingService.kt'
PAIRING_CLASS_RE = re.compile(r'\bclass\s+AdbPairingService\s*:\s*Service\(\)\s*\{')
PAIRING_TIMEOUT_CODE = '''
    // win11 (step 5E, finding 11): this is a shortService (about 3 minutes). Android 14+ calls onTimeout at the limit and raises RemoteServiceException if the service
    // does not stop; here the manager runs in the main process of the host, so that would close the whole app. Stop quietly instead, the user taps "pair" again.
    override fun onTimeout(startId: Int) {
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }

    override fun onTimeout(startId: Int, fgsType: Int) {
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }
'''
PAIRING_TIMEOUT_SIGS = {   # signature regex -> label
    r'override\s+fun\s+onTimeout\(\s*startId\s*:\s*Int\s*\)\s*\{': 'onTimeout(startId)',
    r'override\s+fun\s+onTimeout\(\s*startId\s*:\s*Int\s*,\s*fgsType\s*:\s*Int\s*\)\s*\{': 'onTimeout(startId, fgsType)',
}

# Step 5F (finding 12, option a+): the components that are directBootAware upstream lose the flag, and BootCompleteReceiver loses its LOCKED_BOOT_COMPLETED action (it keeps BOOT_COMPLETED).
# 4D-3 read three of them (BootCompleteReceiver, ShizukuReceiver, ShizukuManagerProvider). The first run on the REAL v13.6.0 tree (step 5G) showed two more: RequestPermissionActivity and
# ShellRequestHandlerActivity carry the flag too (the script stopped on its own "no other component" anchor, as designed). They lose it for the same reason: an activity of the manager would start
# the host process in direct boot just the same. Names as they are written in the library manifest (relative to moe.shizuku.manager).
DIRECT_BOOT_COMPONENTS = {   # (tag, android:name) of the components that must carry the flag upstream and must not after the patch
    ('receiver', '.receiver.BootCompleteReceiver'), ('receiver', '.receiver.ShizukuReceiver'), ('provider', '.ShizukuManagerProvider'),
    ('activity', '.authorization.RequestPermissionActivity'), ('activity', '.legacy.ShellRequestHandlerActivity'),   # found on the real tree in 5G (the 5F list had only the first three)
}
BOOT_RECEIVER_NAME = '.receiver.BootCompleteReceiver'
BOOT_ACTION = 'android.intent.action.BOOT_COMPLETED'
LOCKED_BOOT_ACTION = 'android.intent.action.LOCKED_BOOT_COMPLETED'
MANIFEST_HEADER_END = 'merge time. -->'
MANIFEST_HEADER_NOTE = ('merge time.\n'
                        '     Step 5F (finding 12): no android:directBootAware and no LOCKED_BOOT_COMPLETED filter, so the host process never starts in direct boot because of Shizuku. -->')

# Step 5G (finding 14): night mode per activity. Read on the real v13.6.0 tree: ShizukuApplication.onCreate (via init) and SettingsFragment's night-mode listener are the only two callers of the
# process-wide setter; AppActivity (extends rikka MaterialActivity, whose ThemedAppCompatActivity overrides attachBaseContext and calls super) is the base class of all nine activities.
APP_ACTIVITY = 'manager/src/main/java/moe/shizuku/manager/app/AppActivity.kt'
APP_ACTIVITY_CLASS_RE = re.compile(r'\babstract\s+class\s+AppActivity\s*:\s*MaterialActivity\(\)\s*\{')
SETTINGS_FRAGMENT = 'manager/src/main/java/moe/shizuku/manager/settings/SettingsFragment.kt'
SHIZUKU_APPLICATION = 'manager/src/main/java/moe/shizuku/manager/ShizukuApplication.kt'
NIGHT_SETTER = 'setDefaultNightMode'               # the process-wide static; must not be called from any source after the patch
NIGHT_CALL = 'delegate.localNightMode = ShizukuSettings.getNightMode()'
NIGHT_ATTACH_CODE = '''
    // win11 (step 5G, finding 14): apply Shizuku's stored night mode to THIS activity only. AppCompat's process-wide default is shared with every screen of the host, so it is never set here.
    // It has to happen before super.attachBaseContext (AppCompat reads the local mode while it wraps the base context; set later, it would recreate the activity). A broken or not yet initialised
    // ShizukuSettings must not stop a screen from opening: then the screen simply follows the system.
    override fun attachBaseContext(newBase: Context) {
        try {
            delegate.localNightMode = ShizukuSettings.getNightMode()
        } catch (e: Throwable) {
            Log.w("AppActivity", "Shizuku night mode not applied", e)
        }
        super.attachBaseContext(newBase)
    }
'''
NIGHT_SETTER_LINE_RE = re.compile(r'^[ \t]*AppCompatDelegate\.setDefaultNightMode\(value\)[ \t]*\n', re.M)
NIGHT_SETTINGS_NOTE = '                        // win11 (step 5G, finding 14): no process-wide night mode here; the recreate below makes every manager screen read the stored value itself (AppActivity).\n'

# styles that override a library style by name (see B above); dropped from every values*/ file
DROP_STYLES = [
    'Base.ThemeOverlay.AppCompat.ActionBar',
    'Base.ThemeOverlay.AppCompat.Dark.ActionBar',
    'Widget.MaterialComponents.CompoundButton.CheckBox',
    'Widget.MaterialComponents.CompoundButton.RadioButton',
]

APP_ATTRS_DROP = ['name', 'banner', 'dataExtractionRules', 'fullBackupContent', 'localeConfig', 'icon', 'label', 'theme', 'allowBackup',
                  'autoRevokePermissions', 'directBootAware', 'enableOnBackInvokedCallback', 'supportsRtl', 'roundIcon', 'usesCleartextTraffic',
                  'extractNativeLibs']   # 5B-2: the host decides whether native libraries are extracted (libshizuku.so is RUN from nativeLibraryDir); a library value that disagrees would break the manifest merge

# resource kinds
VAL_TAGS = {'string': 'string', 'string-array': 'array', 'integer-array': 'array', 'array': 'array', 'plurals': 'plurals', 'color': 'color',
            'style': 'style', 'dimen': 'dimen', 'bool': 'bool', 'integer': 'integer'}
FILE_TYPES = {'drawable', 'layout', 'menu', 'mipmap', 'color', 'animator', 'anim', 'xml', 'raw', 'font', 'transition', 'interpolator'}
REF_TYPES = sorted(set(VAL_TAGS.values()) | FILE_TYPES)


def die(msg):
    print('::error::patch-upstream: ' + msg, file=sys.stderr)
    sys.exit(1)


def read(p):
    with open(p, encoding='utf-8') as f:
        return f.read()


def write(p, s):
    with open(p, 'w', encoding='utf-8', newline='\n') as f:
        f.write(s)


def sub_once(path, old, new, count=1):
    s = read(path)
    n = s.count(old)
    if n != count:
        die(f'{os.path.relpath(path)}: expected {count} x {old!r}, found {n} (upstream changed? then update patch-upstream.py)')
    write(path, s.replace(old, new))


def git(cwd, *args, check=True):
    r = subprocess.run(['git', '-C', cwd, *args], capture_output=True, text=True)
    if check and r.returncode != 0:
        die(f'git {" ".join(args)} in {cwd} failed: {r.stderr.strip()}')
    return r.stdout.strip()


HOST_NAME_RE = re.compile(r'^[A-Za-z][A-Za-z0-9_]*(\.[A-Za-z][A-Za-z0-9_]*)+$')


def check_host_name(host):
    """Step 5B-1: the host package ends up in a C string literal (starter.cpp, `pm path <host>` run through a shell by the native starter) and in Java / Kotlin string
    literals, with no quoting or escaping anywhere. A legal Android package name (letters, digits, underscore, at least one dot) is safe in all of them; anything else
    (a space, a quote, a `$`, a `;`, a backslash) would change what the shell command or the literal means, so it stops the build here."""
    if not HOST_NAME_RE.fullmatch(host):
        die(f'host package {host!r} is not a plain Android package name (letters, digits, "_" and "." only): it is written unquoted into `pm path <package>` and into string literals')
    return host


def host_package(arg):
    if arg:
        return check_host_name(arg)
    if os.environ.get('SHIZUKU_HOST_PACKAGE'):
        return check_host_name(os.environ['SHIZUKU_HOST_PACKAGE'])
    gradle = os.path.join(PROJECT, 'app', 'build.gradle.kts')
    text = read(gradle)
    m = re.search(r'applicationId\s*=\s*"([^"]+)"', text)
    if not m:
        die('applicationId not found in app/build.gradle.kts (pass --host-package)')
    # Step 5B-1: `pm path <host>` and every PackageManager lookup of the built-in manager use ONE name. A build type or flavor with an applicationIdSuffix would install
    # the app under another name than the one written here, and the lookup would find nothing in that build. None exists today; this keeps it that way.
    if re.search(r'^[^/\n]*\bapplicationIdSuffix\b', text, re.M):
        die('app/build.gradle.kts sets applicationIdSuffix: the built-in Shizuku looks the host app up by ONE package name (`pm path <package>`), so a suffix would break it in that build type')
    return check_host_name(m.group(1))


def script_hash(host):
    h = hashlib.sha256()
    h.update(read(os.path.abspath(__file__)).encode())
    h.update(host.encode())
    return h.hexdigest()


def xml_files(root):
    out = []
    res = os.path.join(root, 'manager/src/main/res')
    for dp, _, fs in os.walk(res):
        out += [os.path.join(dp, f) for f in fs if f.endswith('.xml')]
    out.append(os.path.join(root, 'manager/src/main/AndroidManifest.xml'))
    return sorted(out)


def code_files(root):
    out = []
    base = os.path.join(root, 'manager/src/main/java')
    for dp, _, fs in os.walk(base):
        out += [os.path.join(dp, f) for f in fs if f.endswith(('.kt', '.java'))]
    return sorted(out)


# ---------------------------------------------------------------- A. host package
def host_places(rel):
    """Step 5C: how many places of PACKAGE_FILES' file become the host package (all uses of the old name except the kept binder extra key)."""
    n = dict(PACKAGE_FILES)[rel]
    return n - BINDER_EXTRA_KEPT.get(rel, 0)


def patch_package(root, host):
    for rel, n in PACKAGE_FILES:
        path = os.path.join(root, rel)
        s = read(path)
        total, kept = s.count(OLD_PKG), len(BINDER_EXTRA_RE.findall(s))
        want_kept = BINDER_EXTRA_KEPT.get(rel, 0)
        if total != n or kept != want_kept:
            die(f'{rel}: expected {n} x {OLD_PKG!r} of which {want_kept} as the binder extra key {BINDER_EXTRA!r} (kept), found {total} of which {kept} '
                f'(upstream changed? then update PACKAGE_FILES / BINDER_EXTRA_KEPT in patch-upstream.py)')
        write(path, OLD_NAME_RE.sub(host, s))
    places = sum(host_places(rel) for rel, _ in PACKAGE_FILES)
    files = sum(1 for rel, _ in PACKAGE_FILES if host_places(rel))
    print(f'A. host package: {OLD_PKG} -> {host} in {files} files ({places} places); binder extra key {BINDER_EXTRA} kept in {len(BINDER_EXTRA_KEPT)} files')


# ---------------------------------------------------------------- B. library conversion
APPLICATION_KT = '''package moe.shizuku.manager

import android.app.Application
import android.os.Build
import com.topjohnwu.superuser.Shell
import moe.shizuku.manager.ktx.logd
import org.lsposed.hiddenapibypass.HiddenApiBypass
import rikka.core.util.BuildUtils.atLeast30
import rikka.material.app.LocaleDelegate

lateinit var application: Application

/**
 * Win11 patch (shizuku/tools/patch-upstream.py): upstream's `class ShizukuApplication : Application()` is an object here, because the Win11 app has its own
 * Application class. The host Application calls [onCreate] once from its own onCreate (same moment as upstream's Application.onCreate).
 */
object ShizukuApplication {

    init {
        logd("ShizukuApplication", "init")

        Shell.setDefaultBuilder(Shell.Builder.create().setFlags(Shell.FLAG_REDIRECT_STDERR))
        if (Build.VERSION.SDK_INT >= 28) {
            HiddenApiBypass.setHiddenApiExemptions("")
        }
        if (atLeast30) {
            System.loadLibrary("adb")
        }
    }

    @JvmStatic
    fun onCreate(app: Application) {
        application = app
        ShizukuSettings.initialize(app)
        LocaleDelegate.defaultLocale = ShizukuSettings.getLocale()
        // Step 5G (finding 14): upstream also set AppCompat's process-wide night mode here. That would force Shizuku's choice on every screen of the host, so it is applied
        // per activity instead (AppActivity.attachBaseContext, part H of patch-upstream.py).
    }
}
'''


def patch_library_code(root, host):
    java = os.path.join(root, 'manager/src/main/java/moe/shizuku/manager')
    app_kt = os.path.join(java, 'ShizukuApplication.kt')
    # the whole file is replaced: check that upstream's is still the one we know
    s = read(app_kt)
    for needle in ('class ShizukuApplication : Application()', 'lateinit var application: ShizukuApplication',
                   'ShizukuSettings.initialize(context)', 'System.loadLibrary("adb")'):
        if needle not in s:
            die(f'ShizukuApplication.kt: {needle!r} not found (upstream changed? then update patch-upstream.py)')
    write(app_kt, APPLICATION_KT)

    ctx = os.path.join(java, 'ktx/Context.kt')
    sub_once(ctx, 'import moe.shizuku.manager.ShizukuApplication\n', 'import android.app.Application\n')
    sub_once(ctx, 'val Context.application: ShizukuApplication\n    get() {\n        return applicationContext as ShizukuApplication\n    }',
             'val Context.application: Application\n    get() {\n        return applicationContext as Application\n    }')

    # BuildConfig.APPLICATION_ID (a library has none): the host package, at run time the same as context.packageName
    lit = '"' + host + '"'
    for rel in ('home/HomeViewModel.kt', 'authorization/AuthorizationManager.kt'):
        p = os.path.join(java, rel)
        sub_once(p, 'import moe.shizuku.manager.BuildConfig\n', '')
        s = read(p)
        n = s.count('BuildConfig.APPLICATION_ID')
        if n != 1:
            die(f'{rel}: expected 1 x BuildConfig.APPLICATION_ID, found {n}')
        write(p, s.replace('BuildConfig.APPLICATION_ID', lit))
    print('B. code: ShizukuApplication -> object, Context.application -> Application, BuildConfig.APPLICATION_ID -> host package (2 files)')


def patch_pairing_service(root):
    """Part F (step 5E): onTimeout overrides in AdbPairingService.kt. Every anchor is asserted; nothing is skipped silently."""
    path = os.path.join(root, PAIRING_SERVICE)
    if not os.path.isfile(path):
        die(f'{PAIRING_SERVICE} not found (upstream moved it? then update patch-upstream.py)')
    s = read(path)
    if 'onTimeout' in s:
        die(f'{PAIRING_SERVICE}: already has an onTimeout (upstream changed? review it, then drop or adapt part F of patch-upstream.py)')
    if not re.search(r'override\s+fun\s+onDestroy\s*\(', s):
        die(f'{PAIRING_SERVICE}: no onDestroy found (the search is stopped there; upstream changed? then update patch-upstream.py)')
    found = PAIRING_CLASS_RE.findall(s)
    if len(found) != 1:
        die(f'{PAIRING_SERVICE}: expected exactly one `class AdbPairingService : Service() {{`, found {len(found)} (upstream changed? then update patch-upstream.py)')
    m = PAIRING_CLASS_RE.search(s)
    write(path, s[:m.end()] + '\n' + PAIRING_TIMEOUT_CODE + s[m.end():])
    print('F. pairing service: onTimeout(startId) and onTimeout(startId, fgsType) stop the foreground state and the service (1 file)')


def patch_manifest(root):
    path = os.path.join(root, 'manager/src/main/AndroidManifest.xml')
    ET.register_namespace('android', ANDROID_NS)
    ET.register_namespace('tools', TOOLS_NS)
    tree = ET.parse(path)
    man = tree.getroot()
    A = lambda n: '{%s}%s' % (ANDROID_NS, n)
    T = lambda n: '{%s}%s' % (TOOLS_NS, n)
    app = man.find('application')
    if app is None:
        die('manifest: <application> not found')
    for a in APP_ATTRS_DROP:
        app.attrib.pop(A(a), None)
    for t in ('ignore', 'remove', 'targetApi'):
        app.attrib.pop(T(t), None)
    main = None
    for act in app.findall('activity'):
        if act.get(A('name')) == '.MainActivity':
            main = act
        if A('theme') not in act.attrib:
            act.set(A('theme'), '@style/AppTheme')       # it came from <application android:theme>
    if main is None:
        die('manifest: .MainActivity not found')
    filters = main.findall('intent-filter')
    if not any(f.find("category[@%s='android.intent.category.LAUNCHER']" % A('name')) is not None for f in filters):
        die('manifest: MainActivity has no LAUNCHER filter (upstream changed?)')
    for f in filters:
        main.remove(f)
    main.attrib.pop(A('banner'), None)
    main.set(A('exported'), 'false')
    main.set(A('label'), '@string/app_name')
    # step 4C-1: DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION markers (see the docstring, part B). Exactly one <permission> and one <uses-permission>, both with tools:node="remove".
    dyn = '${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION'
    dropped = [e for e in list(man) if e.tag in ('permission', 'uses-permission') and e.get(A('name')) == dyn]
    if sorted(e.tag for e in dropped) != ['permission', 'uses-permission'] or any(e.get(T('node')) != 'remove' for e in dropped):
        die('manifest: expected one <permission> and one <uses-permission> of DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION, both tools:node="remove" (upstream changed?)')
    for e in dropped:
        man.remove(e)
    ET.indent(tree, space='    ')
    body = ET.tostring(man, encoding='unicode')
    header = ('<?xml version="1.0" encoding="utf-8"?>\n'
              '<!-- Win11 library manifest, generated from upstream by shizuku/tools/patch-upstream.py (step 2):\n'
              '     no <application> attributes (name, icon, theme, backup ... belong to :app), MainActivity has no LAUNCHER filter and is not exported\n'
              '     (the Start menu starts it), every activity carries the Shizuku theme itself. ${applicationId} becomes the host package at merge time. -->\n')
    write(path, header + body + '\n')
    print(f'B. manifest: application attributes removed, MainActivity LAUNCHER filter removed, {len(app.findall("activity"))} activities themed, DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION markers dropped (2 elements)')


def patch_direct_boot(root):
    """Part G (step 5F, finding 12, option a+): android:directBootAware leaves the five components of DIRECT_BOOT_COMPONENTS, and the LOCKED_BOOT_COMPLETED action leaves
    BootCompleteReceiver. Runs on the manifest that patch_manifest has written (so after it). Every anchor is asserted; nothing is skipped silently."""
    path = os.path.join(root, 'manager/src/main/AndroidManifest.xml')
    if not os.path.isfile(path):
        die('manager/src/main/AndroidManifest.xml not found (run patch_manifest first)')
    text = read(path)
    if MANIFEST_HEADER_END not in text.split('<manifest', 1)[0]:
        die('manifest: the header comment of part B is not there (patch_direct_boot runs after patch_manifest; did the header text change?)')
    head, rest = text.split('<manifest', 1)
    ET.register_namespace('android', ANDROID_NS)
    ET.register_namespace('tools', TOOLS_NS)
    tree = ET.ElementTree(ET.fromstring('<manifest' + rest))
    man = tree.getroot()
    A = lambda n: '{%s}%s' % (ANDROID_NS, n)
    app = man.find('application')
    if app is None:
        die('manifest: <application> not found')
    flagged = {(e.tag, e.get(A('name'))): e for e in man.iter() if e.get(A('directBootAware')) is not None and e.get(A('directBootAware')).strip().lower() == 'true'}
    for key in sorted(DIRECT_BOOT_COMPONENTS):
        if key not in flagged:
            die(f'manifest: <{key[0]} {key[1]}> is not directBootAware (upstream changed? then review finding 12 and part G of patch-upstream.py)')
        matches = [e for e in app.findall(key[0]) if e.get(A('name')) == key[1]]
        if len(matches) != 1:
            die(f'manifest: expected exactly one <{key[0]} {key[1]}>, found {len(matches)}')
    extra = sorted(k for k in flagged if k not in DIRECT_BOOT_COMPONENTS)
    if extra:
        die(f'manifest: other components are directBootAware too: {extra} (upstream changed? decide for them, then add them to DIRECT_BOOT_COMPONENTS in patch-upstream.py)')
    for key in sorted(DIRECT_BOOT_COMPONENTS):
        del flagged[key].attrib[A('directBootAware')]
    boot = [e for e in app.findall('receiver') if e.get(A('name')) == BOOT_RECEIVER_NAME][0]
    locked = [(f, a) for f in boot.findall('intent-filter') for a in f.findall('action') if a.get(A('name')) == LOCKED_BOOT_ACTION]
    if len(locked) != 1:
        die(f'manifest: expected exactly one {LOCKED_BOOT_ACTION} action in {BOOT_RECEIVER_NAME}, found {len(locked)} (upstream changed? then update part G)')
    filt, act = locked[0]
    if len(filt.findall('action')) == 1:
        boot.remove(filt)               # a filter of its own: the whole filter goes
    else:
        filt.remove(act)                # shares the filter with other actions: only the action goes
    kept = [a for f in boot.findall('intent-filter') for a in f.findall('action') if a.get(A('name')) == BOOT_ACTION]
    if len(kept) != 1:
        die(f'manifest: {BOOT_RECEIVER_NAME} must keep exactly one {BOOT_ACTION} action after the patch, has {len(kept)} (upstream changed? then update part G)')
    ET.indent(tree, space='    ')
    write(path, head.replace(MANIFEST_HEADER_END, MANIFEST_HEADER_NOTE, 1) + ET.tostring(man, encoding='unicode') + '\n')
    print(f'G. direct boot: android:directBootAware removed from {len(DIRECT_BOOT_COMPONENTS)} components (3 receiver / provider, 2 activities), LOCKED_BOOT_COMPLETED removed from BootCompleteReceiver (1 file)')


def patch_night_mode(root):
    """Part H (step 5G, finding 14): Shizuku's night-mode setting is applied per activity instead of through AppCompat's process-wide default. ShizukuApplication.kt needs no edit here (part B's
    template already leaves the call out; this part asserts it). Every anchor is asserted; nothing is skipped silently."""
    app_kt = os.path.join(root, SHIZUKU_APPLICATION)
    if NIGHT_SETTER in read(app_kt) or 'AppCompatDelegate' in read(app_kt):
        die(f'{SHIZUKU_APPLICATION}: still touches AppCompatDelegate (part B writes this file; part H runs after it)')
    # SettingsFragment: the one other caller. Exactly one call line; the line goes, a comment takes its place, activity?.recreate() stays.
    sf = os.path.join(root, SETTINGS_FRAGMENT)
    if not os.path.isfile(sf):
        die(f'{SETTINGS_FRAGMENT} not found (upstream moved it? then update patch-upstream.py)')
    t = read(sf)
    hits = NIGHT_SETTER_LINE_RE.findall(t)
    if len(hits) != 1 or t.count(NIGHT_SETTER) != 1:
        die(f'{SETTINGS_FRAGMENT}: expected exactly one `AppCompatDelegate.{NIGHT_SETTER}(value)` line, found {len(hits)} line(s) / {t.count(NIGHT_SETTER)} use(s) (upstream changed? then update patch-upstream.py)')
    if 'activity?.recreate()' not in t:
        die(f'{SETTINGS_FRAGMENT}: no activity?.recreate() (the new night mode would never be applied; upstream changed?)')
    write(sf, NIGHT_SETTER_LINE_RE.sub(lambda m: NIGHT_SETTINGS_NOTE, t, count=1))
    # AppActivity: the per-activity application.
    aa = os.path.join(root, APP_ACTIVITY)
    if not os.path.isfile(aa):
        die(f'{APP_ACTIVITY} not found (upstream moved it? then update patch-upstream.py)')
    u = read(aa)
    if 'attachBaseContext' in u:
        die(f'{APP_ACTIVITY}: already has an attachBaseContext (upstream changed? review it, then adapt part H of patch-upstream.py)')
    if len(APP_ACTIVITY_CLASS_RE.findall(u)) != 1:
        die(f'{APP_ACTIVITY}: expected exactly one `abstract class AppActivity : MaterialActivity() {{` (upstream changed? then update patch-upstream.py)')
    for imp in ('import android.os.Build\n', 'import android.content.res.Resources\n', 'import moe.shizuku.manager.R\n'):
        if u.count(imp) != 1:
            die(f'{APP_ACTIVITY}: expected exactly one {imp.strip()!r} (anchor for the new imports; upstream changed?)')
    u = u.replace('import android.content.res.Resources\n', 'import android.content.Context\nimport android.content.res.Resources\n', 1)
    u = u.replace('import android.os.Build\n', 'import android.os.Build\nimport android.util.Log\n', 1)
    u = u.replace('import moe.shizuku.manager.R\n', 'import moe.shizuku.manager.R\nimport moe.shizuku.manager.ShizukuSettings\n', 1)
    m = APP_ACTIVITY_CLASS_RE.search(u)
    write(aa, u[:m.end()] + '\n' + NIGHT_ATTACH_CODE + u[m.end():])
    print('H. night mode: the process-wide setter removed from ShizukuApplication and SettingsFragment, AppActivity applies the stored mode per activity (2 files patched, ShizukuApplication from part B)')


def drop_override_styles(root):
    n = 0
    for p in xml_files(root):
        if '/res/values' not in p:
            continue
        s = read(p)
        orig = s
        for name in DROP_STYLES:
            s = re.sub(r'[ \t]*<style\s+name="' + re.escape(name) + r'"[^>]*?(?:/>|>.*?</style>)[ \t]*\n?', '', s, flags=re.S)
        if s != orig:
            n += 1
            write(p, s)
    if n == 0:
        die('no override style was dropped (themes_override.xml changed upstream?)')
    print(f'B. styles: {len(DROP_STYLES)} styles that override library styles by name dropped ({n} file)')


# ---------------------------------------------------------------- C. resources
def pascal(base):
    return ''.join(p[:1].upper() + p[1:] for p in base.split('_'))


def collect_names(res):
    names = collections.defaultdict(set)
    bindings = set()
    tag_rx = re.compile(r'<(string-array|integer-array|string|array|plurals|color|style|dimen|bool|integer)\s[^>]*?\bname="([^"]+)"', re.S)
    for d in sorted(os.listdir(res)):
        t = d.split('-')[0]
        full = os.path.join(res, d)
        if t == 'values':
            for f in sorted(os.listdir(full)):
                s = re.sub(r'<!--.*?-->', '', read(os.path.join(full, f)), flags=re.S)
                for m in tag_rx.finditer(s):
                    names[VAL_TAGS[m.group(1)]].add(m.group(2))
        elif t in FILE_TYPES:
            for f in sorted(os.listdir(full)):
                base = f.split('.')[0]
                names[t].add(base)
                if t == 'layout':
                    bindings.add(pascal(base) + 'Binding')
    return names, bindings


def rename_resources(root):
    res = os.path.join(root, 'manager/src/main/res')
    names, bindings = collect_names(res)
    # 1. rename the files
    nfiles = 0
    for d in sorted(os.listdir(res)):
        if d.split('-')[0] in FILE_TYPES:
            for f in sorted(os.listdir(os.path.join(res, d))):
                if not f.startswith(PREFIX):
                    os.rename(os.path.join(res, d, f), os.path.join(res, d, PREFIX + f))
                    nfiles += 1
    # 2. rewrite XML (values names, parents, @type/name references)
    ref_rx = re.compile(r'@(' + '|'.join(REF_TYPES) + r')/([A-Za-z0-9_.]+)')
    tag_rx = re.compile(r'(<(string-array|integer-array|string|array|plurals|color|style|dimen|bool|integer)\s[^>]*?\bname=")([^"]+)(")', re.S)
    parent_rx = re.compile(r'(\bparent=")([^"@?][^"]*)(")')
    stats = collections.Counter()

    def fix_ref(m):
        t, n = m.group(1), m.group(2)
        if n in names.get(t, ()) and not n.startswith(PREFIX):
            stats['xml refs'] += 1
            return f'@{t}/{PREFIX}{n}'
        return m.group(0)

    def fix_tag(m):
        t = VAL_TAGS[m.group(2)]
        n = m.group(3)
        if n.startswith(PREFIX):
            return m.group(0)
        stats['value names'] += 1
        return m.group(1) + PREFIX + n + m.group(4)

    def fix_parent(m):
        if m.group(2) in names['style']:
            stats['style parents'] += 1
            return m.group(1) + PREFIX + m.group(2) + m.group(3)
        return m.group(0)

    # dotted style name without explicit parent whose implicit parent is NOT ours: keep the inheritance by writing it down
    def add_implicit_parent(s):
        def f(m):
            name, rest = m.group(2), m.group(3)
            if 'parent=' in rest or '.' not in name:
                return m.group(0)
            implicit = name.rsplit('.', 1)[0]
            if implicit in names['style']:
                return m.group(0)
            stats['explicit parents added'] += 1
            return f'{m.group(1)}{name}" parent="{implicit}"{rest}'
        return re.sub(r'(<style\s[^>]*?\bname=")([^"]+)"([^>]*)', f, s, flags=re.S)

    for p in xml_files(root):
        s = read(p)
        orig = s
        if '/res/values' in p:
            s = add_implicit_parent(s)
            s = parent_rx.sub(fix_parent, s)
            s = tag_rx.sub(fix_tag, s)
        s = ref_rx.sub(fix_ref, s)
        if s != orig:
            write(p, s)
    # 3. Kotlin / Java: R.type.name and the ViewBinding class names
    r_rx = re.compile(r'(?<!android\.)\bR\.(' + '|'.join(REF_TYPES) + r')\.([A-Za-z0-9_]+)')
    under = {t: {n.replace('.', '_') for n in ns} for t, ns in names.items()}
    bind_rx = re.compile(r'\b(' + '|'.join(sorted(bindings, key=len, reverse=True)) + r')\b')

    def fix_r(m):
        t, n = m.group(1), m.group(2)
        if n in under.get(t, ()) and not n.startswith(PREFIX):
            stats['R refs'] += 1
            return f'R.{t}.{PREFIX}{n}'
        return m.group(0)

    def fix_bind(m):
        stats['binding classes'] += 1
        return 'Sh' + m.group(1)

    for p in code_files(root):
        s = read(p)
        n = r_rx.sub(fix_r, s)
        n = bind_rx.sub(fix_bind, n)
        if n != s:
            write(p, n)
    total = sum(len(v) for v in names.values())
    print(f'C. resources: {total} names, {nfiles} files renamed; rewritten: ' + ', '.join(f'{v} {k}' for k, v in sorted(stats.items())))
    return names, bindings


# ---------------------------------------------------------------- D. self-check
# ---------------------------------------------------------------- E. generated source (autoresconfig replacement)
LOCALES_FILE = 'manager/src/main/java/rikka/shizuku/manager/ShizukuLocales.java'
DISPLAY_LOCALE_MAP = {'zh-CN': 'zh-Hans', 'zh-TW': 'zh-Hant'}   # same two entries as AutoResConfigPlugin.displayLocaleMap


def locale_modifiers(root):
    """Resource folder modifiers that count as a language: same rule as AutoResConfigPlugin.collectModifiers (+ \"en\" always)."""
    res = os.path.join(root, 'manager/src/main/res')
    mods = {'en'}
    for d in os.listdir(res):
        f = os.path.join(res, d, 'strings.xml')
        # \"> 62 bytes\" = not an empty <resources/> file (the plugin's own test)
        if d.startswith('values-') and os.path.isfile(f) and os.path.getsize(f) > 62:
            m = d[len('values-'):]
            if len(m.split('-')) <= 3:
                mods.add(m)
    return sorted(mods, key=str.lower)


def modifier_to_locale(m):
    """values-b+zh+Hans -> zh-Hans, values-pt-rBR -> pt-BR, values-de -> de (AutoResConfigPlugin.convertModifiersToLocales)."""
    if m.startswith('b+'):
        names = m[2:].split('+', 1)
        return names[0] + '-' + names[1] if len(names) == 2 else names[0]
    names = m.split('-', 1)
    return names[0] + '-' + names[1][1:] if len(names) == 2 else names[0]


def generate_locales(root):
    locales = sorted((modifier_to_locale(m) for m in locale_modifiers(root)), key=str.lower)
    display = [DISPLAY_LOCALE_MAP.get(l, l) for l in locales]
    q = lambda items: ', '.join('\"' + i + '\"' for i in ['SYSTEM'] + items)
    path = os.path.join(root, LOCALES_FILE)
    os.makedirs(os.path.dirname(path), exist_ok=True)
    write(path, 'package rikka.shizuku.manager;\n\n'
                '/** Generated by shizuku/tools/patch-upstream.py (part E): replaces the class that upstream\'s Gradle plugin autoresconfig generates. */\n'
                'public final class ShizukuLocales {\n'
                f'    public static final String[] LOCALES = {{{q(locales)}}};\n'
                f'    public static final String[] DISPLAY_LOCALES = {{{q(display)}}};\n'
                '}\n')
    print(f'E. generated: ShizukuLocales ({len(locales)} languages + SYSTEM)')


def check_locales(root, errors):
    path = os.path.join(root, LOCALES_FILE)
    if not os.path.isfile(path):
        errors.append(f'{LOCALES_FILE} is missing')
        return
    arrays = re.findall(r'String\[\] (LOCALES|DISPLAY_LOCALES) = \{([^}]*)\};', read(path))
    got = {k: re.findall(r'\"([^\"]+)\"', v) for k, v in arrays}
    if set(got) != {'LOCALES', 'DISPLAY_LOCALES'}:
        errors.append('ShizukuLocales: LOCALES / DISPLAY_LOCALES not found')
        return
    a, b = got['LOCALES'], got['DISPLAY_LOCALES']
    if a[:1] != ['SYSTEM'] or b[:1] != ['SYSTEM']:
        errors.append('ShizukuLocales: first item is not SYSTEM (SettingsFragment treats index 0 as \"follow system\")')
    if len(a) != len(b) or len(a) != len(locale_modifiers(root)) + 1:
        errors.append(f'ShizukuLocales: {len(a)} / {len(b)} items, expected {len(locale_modifiers(root)) + 1}')
    if 'en' not in a:
        errors.append('ShizukuLocales: en is missing')
    for tag in a[1:] + b[1:]:
        if not re.fullmatch(r'[a-z]{2,3}(-[A-Za-z0-9]{2,8}){0,2}', tag):
            errors.append(f'ShizukuLocales: {tag!r} is not a language tag')


def check_dynamic_receiver_permission(man_xml, errors):
    """Step 4C-2: the DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION must not carry a tools:node="remove" marker in the generated manager manifest (4C-1 deleted both
    elements; a marker left, or one that came back with an upstream change, would remove the permission from the whole app, see the docstring part B). Looks at every
    element of the manifest, not only the direct children, so a marker moved somewhere else is found too. Takes the XML text so that it can be tested without a checkout."""
    try:
        man = ET.fromstring(man_xml)
    except ET.ParseError as e:
        errors.append(f'manifest: not well-formed: {e}')
        return
    name, node = '{%s}name' % ANDROID_NS, '{%s}node' % TOOLS_NS
    for e in man.iter():
        if 'DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION' in (e.get(name) or '') and e.get(node) in ('remove', 'removeAll', 'replace'):
            errors.append(f'manifest: <{e.tag}> {e.get(name)} carries tools:node="{e.get(node)}" (it would remove the permission from the whole app)')


def check_shizuku_permissions(man_xml, errors):
    """Step 4C-3 (4A findings 3 and 4): permission ownership in the generated manager manifest. :shizuku is the ONE owner of the two Shizuku permissions, so exactly one <permission>
    of moe.shizuku.manager.permission.MANAGER (signature) and one of ...API_V23 (dangerous, group moe.shizuku.manager.permission-group.API) must be declared; the host asks for MANAGER
    itself (one <uses-permission>, no remove marker: it is what lets the server send the manager the binder); and it must NOT ask for API_V23: one <uses-permission> of API_V23 with
    tools:node="remove" is kept as a guard against any other library that brings the request back (the manager is the server's always-allowed app id). Takes the XML text (testable
    without a checkout)."""
    try:
        man = ET.fromstring(man_xml)
    except ET.ParseError as e:
        errors.append(f'manifest: not well-formed: {e}')
        return
    name, level, group = ('{%s}%s' % (ANDROID_NS, n) for n in ('name', 'protectionLevel', 'permissionGroup'))
    node = '{%s}node' % TOOLS_NS
    mgr, api = 'moe.shizuku.manager.permission.MANAGER', 'moe.shizuku.manager.permission.API_V23'
    kids = list(man)
    for perm, want in ((mgr, 'signature'), (api, 'dangerous')):
        decl = [e for e in kids if e.tag == 'permission' and e.get(name) == perm]
        if len(decl) != 1:
            errors.append(f'manifest: expected exactly one <permission> {perm}, found {len(decl)}')
        elif decl[0].get(level) != want:
            errors.append(f'manifest: <permission> {perm} has protectionLevel {decl[0].get(level)!r}, expected {want!r}')
        elif decl[0].get(node):
            errors.append(f'manifest: <permission> {perm} carries tools:node="{decl[0].get(node)}"')
    grp = [e for e in kids if e.tag == 'permission' and e.get(name) == api]
    if len(grp) == 1 and grp[0].get(group) != 'moe.shizuku.manager.permission-group.API':
        errors.append(f'manifest: <permission> {api} is not in the group moe.shizuku.manager.permission-group.API')
    ask_mgr = [e for e in kids if e.tag == 'uses-permission' and e.get(name) == mgr]
    if len(ask_mgr) != 1 or ask_mgr[0].get(node):
        errors.append(f'manifest: expected exactly one <uses-permission> {mgr} without a tools:node marker (the host must ask for MANAGER), found {len(ask_mgr)}')
    ask_api = [e for e in kids if e.tag == 'uses-permission' and e.get(name) == api]
    if len(ask_api) != 1 or ask_api[0].get(node) != 'remove':
        errors.append(f'manifest: expected exactly one <uses-permission> {api} with tools:node="remove" (guard: the host must not request API_V23), found {len(ask_api)}')


def check_application_attrs(man, errors):
    """Step 5B-2: the library manifest carries no <application> attribute that decides how the host packs native libraries. libshizuku.so is executed from the host's
    nativeLibraryDir, so :app must keep android:extractNativeLibs="true" (+ useLegacyPackaging = true); a different value in this manifest would fail the manifest merge,
    the same value would be a second place to keep in step."""
    for m in re.finditer(r'<application\b[^>]*>', man, re.S):
        if 'extractNativeLibs' in m.group(0):
            errors.append('manifest: <application> still sets extractNativeLibs (the host app decides, see step 5B-2)')


def check_native_package(root, host, errors):
    """Step 5B-1: native/starter.cpp finds the APK with `pm path` + PACKAGE_NAME. After patch part A the macro must be the host package, once, and the old name nowhere."""
    rel = 'manager/src/main/jni/starter.cpp'
    s = read(os.path.join(root, rel))
    defs = re.findall(r'^[ \t]*#[ \t]*define[ \t]+PACKAGE_NAME[ \t]+"([^"]*)"', s, re.M)
    if defs != [host]:
        errors.append(f'{rel}: expected exactly one `#define PACKAGE_NAME "{host}"`, found {defs!r}')
    if OLD_PKG in s:
        errors.append(f'{rel}: still names {OLD_PKG}')


def check_binder_protocol(root, host, errors):
    """Step 5C: the binder hand-over between the server, the starter, the manager's provider and the API provider. After patch part A:
    - the binder extra key is spelled as upstream has it, in exactly the four files of BINDER_EXTRA_KEPT (sender and receivers agree, and so does every outside client);
    - nowhere is it spelled with the host package (`<host>.intent.extra.BINDER`: a key nobody else knows);
    - every file of PACKAGE_FILES names the host package exactly as often as part A replaced the old name there (the real package-name uses: MANAGER_APPLICATION_ID,
      `pm path`, setPackage, packageName) and no old name is left except the kept key."""
    host_re = re.compile(r'(?<![\w.])' + re.escape(host) + r'(?!\w)')
    for rel, _ in PACKAGE_FILES:
        s = read(os.path.join(root, rel))
        kept, want_kept = len(BINDER_EXTRA_RE.findall(s)), BINDER_EXTRA_KEPT.get(rel, 0)
        if kept != want_kept:
            errors.append(f'{rel}: the binder extra key {BINDER_EXTRA!r} appears {kept}x, expected {want_kept}x (server, starter and providers must use the one key every Shizuku client knows)')
        if (host + '.intent.extra.BINDER') in s:
            errors.append(f'{rel}: spells the binder extra key with the host package ({host}.intent.extra.BINDER): outside Shizuku clients would never receive the binder')
        got, want = len(host_re.findall(s)), host_places(rel)
        if got != want:
            errors.append(f'{rel}: names the host package {got}x, expected {want}x (the package-name uses of this file)')
        if OLD_NAME_RE.search(s):
            errors.append(f'{rel}: still names {OLD_PKG} outside the binder extra key')


def action_source_files(root):
    """Java / Kotlin files of the server, starter, shell, manager and the API modules (not the API demo app, not build folders)."""
    out = []
    for dp, dns, fs in os.walk(root):
        dns[:] = [d for d in dns if d not in ('.git', 'demo', 'build')]
        out += [os.path.join(dp, f) for f in fs if f.endswith(('.java', '.kt'))]
    return sorted(out)


def check_intent_actions(root, man_xml, host, errors):
    """Step 5D: the intent actions between the server, the shell loader and the built-in manager (see the comment at ACTION_PERMISSION_SUFFIX). After patch part A:
    - the server builds the permission action from MANAGER_APPLICATION_ID (the host) and aims it at that package, so it matches the manifest's ${applicationId} filter;
    - the manifest carries each custom action exactly on the components of MANIFEST_ACTIONS, the two host-following ones through the ${applicationId} placeholder (never a literal
      host or old package), the rikka one as upstream has it; no other custom action is declared;
    - the literal rikka.shizuku.intent.action.REQUEST_BINDER is spelled exactly as often as BINDER_ACTION_FILES says and never with the host package in front;
    - the shell loader aims its broadcast at the host package;
    - no other string literal that looks like an action name exists in the sources (an upstream bump that adds one has to be decided here, not slip through).
    Takes the manifest XML text so it can be tried without a checkout of the manifest, and the host name so it follows a CI package rename."""
    consts = read(os.path.join(root, 'server/src/main/java/rikka/shizuku/server/ServerConstants.java'))
    if len(re.findall(r'\bREQUEST_PERMISSION_ACTION\s*=\s*MANAGER_APPLICATION_ID\s*\+\s*"' + re.escape(ACTION_PERMISSION_SUFFIX) + r'"\s*;', consts)) != 1:
        errors.append('ServerConstants: REQUEST_PERMISSION_ACTION is not exactly `MANAGER_APPLICATION_ID + "' + ACTION_PERMISSION_SUFFIX + '"` (the server must build the action from the host package, like the manifest does with ${applicationId})')
    svc = read(os.path.join(root, 'server/src/main/java/rikka/shizuku/server/ShizukuService.java'))
    if len(re.findall(r'new Intent\(ServerConstants\.REQUEST_PERMISSION_ACTION\)\s*\.setPackage\(MANAGER_APPLICATION_ID\)', svc)) != 1:
        errors.append('ShizukuService: the permission request is not exactly one `new Intent(ServerConstants.REQUEST_PERMISSION_ACTION).setPackage(MANAGER_APPLICATION_ID)` (it must be aimed at the host package)')
    for a in re.findall(r'"([^"\n]*' + re.escape(ACTION_PERMISSION_SUFFIX) + r')"', consts + svc):
        if a != ACTION_PERMISSION_SUFFIX:
            errors.append(f'server: the permission action is spelled as a literal ({a!r}); it must come from MANAGER_APPLICATION_ID')
    # manifest
    try:
        mroot = ET.fromstring(man_xml)
    except ET.ParseError as e:
        errors.append(f'manifest: not well-formed ({e}); the action rules cannot be read')
        return
    where = collections.defaultdict(list)   # action -> components
    for comp in mroot.iter():
        if comp.tag not in ('activity', 'receiver', 'service', 'provider', 'activity-alias'):
            continue
        for filt in comp.findall('intent-filter'):
            for act in filt.findall('action'):
                where[act.get('{%s}name' % ANDROID_NS, '')].append(comp.get('{%s}name' % ANDROID_NS, '?'))
    for name, comps in sorted(where.items()):
        if name.startswith('android.intent.action.'):
            continue
        if name not in MANIFEST_ACTIONS:
            errors.append(f'manifest: unknown custom action {name!r} on {sorted(comps)}: decide whether it follows the host (use ${{applicationId}}) or stays, and add it to MANIFEST_ACTIONS')
    for name, want in MANIFEST_ACTIONS.items():
        got = sorted(where.get(name, []))
        if got != sorted(want):
            errors.append(f'manifest: action {name!r} is on {got}, expected exactly {sorted(want)}')
    for name in where:
        if (host in name or OLD_PKG in name) and not name.startswith('android.'):
            errors.append(f'manifest: action {name!r} names a package literally; the host-following actions must use ${{applicationId}} so a package rename moves them')
    # literal REQUEST_BINDER and the loader's target
    host_prefixed = host + '.intent.action.'
    for rel, want in BINDER_ACTION_FILES.items():
        t = read(os.path.join(root, rel))
        got = len(re.findall(r'"' + re.escape(ACTION_BINDER) + r'"', t))
        if got != want:
            errors.append(f'{rel}: the action literal {ACTION_BINDER!r} appears {got}x, expected {want}x')
    loader = read(os.path.join(root, 'shell/src/main/java/rikka/shizuku/shell/ShizukuShellLoader.java'))
    if len(re.findall(r'new Intent\("' + re.escape(ACTION_BINDER) + r'"\)\s*\.setPackage\("' + re.escape(host) + r'"\)', loader)) != 1:
        errors.append('ShizukuShellLoader: the broadcast is not exactly one `new Intent("' + ACTION_BINDER + '").setPackage("' + host + '")` (the shell must aim it at the host package)')
    # every action-looking literal in the sources
    for p in action_source_files(root):
        t = read(p)
        rel = os.path.relpath(p, root)
        if host_prefixed in t or (OLD_PKG + '.intent.action.') in t:
            errors.append(f'{rel}: spells an action with a package in front ({host_prefixed}... or the old name); only the server builds it, from MANAGER_APPLICATION_ID')
        for lit in ACTION_LITERAL_RE.findall(t):
            if lit not in ACTION_LITERALS_ALLOWED:
                errors.append(f'{rel}: unknown action literal {lit!r}: decide whether it follows the host or stays, then add it to ACTION_LITERALS_ALLOWED')


def kotlin_block(s, open_brace):
    """Text between the `{` at s[open_brace] and its matching `}` (strings and comments are not special-cased: the generated block has none that matter)."""
    depth = 0
    for i in range(open_brace, len(s)):
        if s[i] == '{':
            depth += 1
        elif s[i] == '}':
            depth -= 1
            if depth == 0:
                return s[open_brace + 1:i]
    return None


def check_pairing_timeout(root, errors):
    """Step 5E (finding 11): AdbPairingService.kt has exactly the two onTimeout overrides, both inside the class, each calling stopForeground(STOP_FOREGROUND_REMOVE) and then
    stopSelf() (in that order, once each), and it still has its onDestroy (which stops the mDNS search)."""
    path = os.path.join(root, PAIRING_SERVICE)
    if not os.path.isfile(path):
        errors.append(f'{PAIRING_SERVICE}: file not found')
        return
    s = read(path)
    cls = PAIRING_CLASS_RE.search(s)
    if len(PAIRING_CLASS_RE.findall(s)) != 1 or not cls:
        errors.append(f'{PAIRING_SERVICE}: not exactly one `class AdbPairingService : Service() {{`')
        return
    n_fun = len(re.findall(r'\bfun\s+(?:[\w<>?.]+\.)?onTimeout\s*\(', re.sub(r'//[^\n]*', '', s)))
    if n_fun != 2:
        errors.append(f'{PAIRING_SERVICE}: {n_fun} onTimeout functions, expected exactly 2 (startId; startId + fgsType)')
    for sig, label in PAIRING_TIMEOUT_SIGS.items():
        hits = list(re.finditer(sig, s))
        if len(hits) != 1:
            errors.append(f'{PAIRING_SERVICE}: {len(hits)}x `override fun {label}`, expected 1 (finding 11: the service must stop itself at the short-service limit)')
            continue
        if hits[0].start() < cls.end():
            errors.append(f'{PAIRING_SERVICE}: `override fun {label}` is not inside the class')
        body = kotlin_block(s, hits[0].end() - 1)
        if body is None:
            errors.append(f'{PAIRING_SERVICE}: `{label}` has no closing brace')
            continue
        code = re.sub(r'//[^\n]*', '', body)
        a, b = code.count('stopForeground(STOP_FOREGROUND_REMOVE)'), code.count('stopSelf()')
        if a != 1 or b != 1:
            errors.append(f'{PAIRING_SERVICE}: `{label}` calls stopForeground(STOP_FOREGROUND_REMOVE) {a}x and stopSelf() {b}x, expected once each')
        elif code.index('stopForeground(STOP_FOREGROUND_REMOVE)') > code.index('stopSelf()'):
            errors.append(f'{PAIRING_SERVICE}: `{label}` calls stopSelf() before stopForeground (the notification would stay)')
    if not re.search(r'override\s+fun\s+onDestroy\s*\(', s):
        errors.append(f'{PAIRING_SERVICE}: no onDestroy any more (it stops the mDNS search that stopSelf() relies on)')


def check_direct_boot(man_xml, errors):
    """Step 5F (finding 12): in the generated manager manifest no element is android:directBootAware (a value other than false counts as set), no LOCKED_BOOT_COMPLETED action is left anywhere,
    and BootCompleteReceiver still has exactly one BOOT_COMPLETED action (it is the manager's boot start, which now runs after the first unlock). Takes the XML text (testable without a checkout).
    The merged-manifest checker has the matching rule for the merged result (`5F direct boot`)."""
    try:
        man = ET.fromstring(man_xml)
    except ET.ParseError as e:
        errors.append(f'manifest: not well-formed: {e}')
        return
    name, dba = '{%s}name' % ANDROID_NS, '{%s}directBootAware' % ANDROID_NS
    for e in man.iter():
        v = e.get(dba)
        if v is not None and v.strip().lower() != 'false':
            errors.append(f'manifest: <{e.tag} {e.get(name, "")}> is android:directBootAware="{v}" (finding 12: the host process must not start before the first unlock because of Shizuku)')
        if e.tag == 'action' and e.get(name) == LOCKED_BOOT_ACTION:
            errors.append(f'manifest: a {LOCKED_BOOT_ACTION} action is left (finding 12)')
    boot = [e for e in man.iter('receiver') if e.get(name) == BOOT_RECEIVER_NAME]
    if len(boot) != 1:
        errors.append(f'manifest: expected exactly one <receiver {BOOT_RECEIVER_NAME}>, found {len(boot)}')
    else:
        n = sum(1 for f in boot[0].findall('intent-filter') for a in f.findall('action') if a.get(name) == BOOT_ACTION)
        if n != 1:
            errors.append(f'manifest: {BOOT_RECEIVER_NAME} has {n} {BOOT_ACTION} action(s), expected exactly 1')


def strip_kotlin_comments(s):
    """Source without // and /* */ comments (string literals are not special-cased: the files checked have no comment markers inside strings that matter)."""
    return re.sub(r'//[^\n]*', '', re.sub(r'/\*.*?\*/', '', s, flags=re.S))


CLASS_DECL_RE = re.compile(r'\b(?:abstract\s+|open\s+)?class\s+(\w+)\s*(?:\([^)]*\))?\s*:\s*(\w+)\s*\(')            # Kotlin: class A : B(
JAVA_CLASS_RE = re.compile(r'\bclass\s+(\w+)(?:<[^>]*>)?\s+extends\s+(\w+)')                                          # Java: class A extends B (MainActivity is Java upstream)


def check_night_mode(root, man_xml, errors):
    """Step 5G (finding 14): the process-wide night-mode setter is called from no source (comments do not count), AppActivity applies the stored mode in a guarded attachBaseContext before
    super.attachBaseContext, SettingsFragment still recreates after a change, ShizukuApplication does not touch AppCompatDelegate, and every <activity> of the manifest reaches AppActivity
    through its superclasses (a screen outside AppActivity would ignore the setting)."""
    for p in code_files(root):
        if NIGHT_SETTER in strip_kotlin_comments(read(p)):
            errors.append(f'{os.path.relpath(p, root)}: calls {NIGHT_SETTER} (finding 14: it is process-wide and would force Shizuku\'s night mode on the whole host)')
    app_kt = os.path.join(root, SHIZUKU_APPLICATION)
    if os.path.isfile(app_kt) and 'AppCompatDelegate' in strip_kotlin_comments(read(app_kt)):
        errors.append(f'{SHIZUKU_APPLICATION}: still uses AppCompatDelegate')
    aa = os.path.join(root, APP_ACTIVITY)
    if not os.path.isfile(aa):
        errors.append(f'{APP_ACTIVITY}: file not found')
    else:
        u = read(aa)
        code = strip_kotlin_comments(u)
        cls = APP_ACTIVITY_CLASS_RE.search(code)
        sigs = list(re.finditer(r'override\s+fun\s+attachBaseContext\s*\(\s*newBase\s*:\s*Context\s*\)\s*\{', code))
        if len(APP_ACTIVITY_CLASS_RE.findall(code)) != 1 or not cls:
            errors.append(f'{APP_ACTIVITY}: not exactly one `abstract class AppActivity : MaterialActivity() {{`')
        elif len(sigs) != 1 or sigs[0].start() < cls.end():
            errors.append(f'{APP_ACTIVITY}: expected exactly one `override fun attachBaseContext(newBase: Context)` inside the class, found {len(sigs)}')
        else:
            body = kotlin_block(code, sigs[0].end() - 1) or ''
            sup = [m.start() for m in re.finditer(r'\bsuper\.attachBaseContext\(newBase\)', body)]
            call = [m.start() for m in re.finditer(re.escape(NIGHT_CALL), body)]
            if len(call) != 1 or len(sup) != 1:
                errors.append(f'{APP_ACTIVITY}: attachBaseContext has `{NIGHT_CALL}` {len(call)}x and super.attachBaseContext(newBase) {len(sup)}x, expected once each')
            elif call[0] > sup[0]:
                errors.append(f'{APP_ACTIVITY}: the night mode is set after super.attachBaseContext (AppCompat would recreate the activity; it must be set before)')
            elif not re.search(r'\btry\s*\{[^}]*' + re.escape(NIGHT_CALL) + r'[^}]*\}\s*catch\s*\(\s*e\s*:\s*Throwable\s*\)', body):
                errors.append(f'{APP_ACTIVITY}: `{NIGHT_CALL}` is not inside try {{ }} catch (e: Throwable) (an uninitialised ShizukuSettings would break the screen)')
        for imp in ('import android.content.Context', 'import android.util.Log', 'import moe.shizuku.manager.ShizukuSettings'):
            if not re.search(r'^' + re.escape(imp) + r'\s*$', u, re.M):
                errors.append(f'{APP_ACTIVITY}: `{imp}` is missing')
    sf = os.path.join(root, SETTINGS_FRAGMENT)
    if os.path.isfile(sf):
        t = strip_kotlin_comments(read(sf))
        m = re.search(r'nightModePreference\.onPreferenceChangeListener\s*=(.*?)\n\s*if\s*\(ShizukuSettings\.getNightMode\(\)\s*!=\s*AppCompatDelegate\.MODE_NIGHT_NO', t, re.S)
        if not m:
            errors.append(f'{SETTINGS_FRAGMENT}: the night-mode change listener was not found (upstream changed?)')
        elif 'activity?.recreate()' not in m.group(1):
            errors.append(f'{SETTINGS_FRAGMENT}: the night-mode change listener no longer calls activity?.recreate() (the new mode would not be applied)')
    else:
        errors.append(f'{SETTINGS_FRAGMENT}: file not found')
    # every activity reaches AppActivity
    supers = {}
    for p in code_files(root):
        pat = CLASS_DECL_RE if p.endswith('.kt') else JAVA_CLASS_RE
        for m in pat.finditer(strip_kotlin_comments(read(p))):
            supers.setdefault(m.group(1), set()).add(m.group(2))
    try:
        man = ET.fromstring(man_xml)
    except ET.ParseError:
        return          # reported by the other manifest rules
    name = '{%s}name' % ANDROID_NS
    for a in man.iter('activity'):
        simple = (a.get(name) or '').rsplit('.', 1)[-1]
        seen, cur, ok = set(), {simple}, False
        while cur and not ok:
            nxt = set()
            for c in cur:
                if c == 'AppActivity':
                    ok = True
                elif c not in seen:
                    seen.add(c)
                    nxt |= supers.get(c, set())
            cur = nxt
        if not ok:
            errors.append(f'manifest: <activity {a.get(name)}> does not reach AppActivity through its superclasses (finding 14: it would ignore Shizuku\'s night-mode setting)')


def check(root, host, names=None, bindings=None):
    errors = []
    res = os.path.join(root, 'manager/src/main/res')
    if names is None:
        # after patching every local name starts with sh_: rebuild the "old" sets from the current ones
        cur, curb = collect_names(res)
        names = {t: {n[len(PREFIX):] for n in ns if n.startswith(PREFIX)} for t, ns in cur.items()}
        bindings = {b[2:] for b in curb if b.startswith('Sh')}
        for t, ns in cur.items():
            for n in ns:
                if not n.startswith(PREFIX):
                    errors.append(f'resource {t}/{n} has no {PREFIX} prefix')
    defined = {t: {PREFIX + n for n in ns} for t, ns in names.items()}
    for p in xml_files(root):
        try:
            ET.parse(p)
        except ET.ParseError as e:
            errors.append(f'{os.path.relpath(p, root)}: not well-formed: {e}')
            continue
        s = read(p)
        for m in re.finditer(r'@(' + '|'.join(REF_TYPES) + r')/([A-Za-z0-9_.]+)', s):
            t, n = m.group(1), m.group(2)
            if n in names.get(t, ()) and not n.startswith(PREFIX):
                errors.append(f'{os.path.relpath(p, root)}: old reference @{t}/{n}')
            if n.startswith(PREFIX) and n not in defined.get(t, ()):
                errors.append(f'{os.path.relpath(p, root)}: @{t}/{n} is not defined')
    under = {t: {PREFIX + n.replace('.', '_') for n in ns} for t, ns in names.items()}
    old_under = {t: {n.replace('.', '_') for n in ns} for t, ns in names.items()}
    for p in code_files(root):
        s = read(p)
        rel = os.path.relpath(p, root)
        for m in re.finditer(r'(?<!android\.)\bR\.(' + '|'.join(REF_TYPES) + r')\.([A-Za-z0-9_]+)', s):
            t, n = m.group(1), m.group(2)
            if n in old_under.get(t, ()) and not n.startswith(PREFIX):
                errors.append(f'{rel}: old R.{t}.{n}')
            if n.startswith(PREFIX) and n not in under.get(t, ()):
                errors.append(f'{rel}: R.{t}.{n} is not defined')
        for b in bindings:
            if re.search(r'(?<![A-Za-z0-9_])' + b + r'\b', s):
                errors.append(f'{rel}: old binding class {b}')
        if 'BuildConfig' in s:
            errors.append(f'{rel}: BuildConfig is used (a library has none)')
    for dp, _, fs in os.walk(root):
        if '/.git' in dp or '/demo' in dp:
            continue
        for f in fs:
            p = os.path.join(dp, f)
            rel = os.path.relpath(p, root)
            if f.endswith(('.java', '.kt', '.cpp', '.xml', '.aidl', '.h', '.gradle', '.sh')) or f == 'rish':
                try:
                    s = read(p)
                except UnicodeDecodeError:
                    continue
                if OLD_NAME_RE.search(s) and rel not in PACKAGE_ALLOWED_LEFT:
                    errors.append(f'{rel}: still names {OLD_PKG}')
    man = read(os.path.join(root, 'manager/src/main/AndroidManifest.xml'))
    if 'android.intent.category.LAUNCHER' in man:
        errors.append('manifest: LAUNCHER filter still there')
    check_native_package(root, host, errors)
    check_binder_protocol(root, host, errors)
    check_intent_actions(root, man, host, errors)
    check_pairing_timeout(root, errors)
    check_application_attrs(man, errors)
    check_dynamic_receiver_permission(man, errors)
    check_shizuku_permissions(man, errors)
    check_direct_boot(man, errors)
    check_night_mode(root, man, errors)
    if 'android:name=".ShizukuApplication"' in man:
        errors.append('manifest: ShizukuApplication is still the application class')
    if re.search(r'^\s*class ShizukuApplication', read(os.path.join(root, 'manager/src/main/java/moe/shizuku/manager/ShizukuApplication.kt')), re.M):
        errors.append('ShizukuApplication is still a class')
    if host not in read(os.path.join(root, 'server/src/main/java/rikka/shizuku/server/ServerConstants.java')):
        errors.append('ServerConstants does not name the host package')
    check_locales(root, errors)
    if errors:
        for e in errors[:60]:
            print('::error::patch-upstream check: ' + e, file=sys.stderr)
        die(f'{len(errors)} problem(s) in the patched checkout')
    print('D. self-check ok (XML well-formed, no old names, every R.* / @type/ reference defined, no BuildConfig, package string only where allowed, starter.cpp PACKAGE_NAME is the host package, binder extra key kept in its four files and never spelled with the host package, no extractNativeLibs in the library manifest, no remove marker on DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION, MANAGER / API_V23 declared once each with the API_V23 request guarded, intent actions: the permission action built from the host package and aimed at it, each custom action only on its components, no unknown action, pairing service: the two onTimeout overrides stop the service (5E), direct boot: no directBootAware and no LOCKED_BOOT_COMPLETED left, the boot receiver keeps BOOT_COMPLETED (5F), night mode: no process-wide setter call left, AppActivity applies the stored mode in a guarded attachBaseContext before super, Settings still recreates, every activity reaches AppActivity (5G), ShizukuLocales consistent)')


# ---------------------------------------------------------------- main
def reset_pristine(root):
    for d in (root, os.path.join(root, 'api')):
        if not os.path.isdir(os.path.join(d, '.git')):
            die(f'{d} is patched but has no .git, so it cannot be put back; delete shizuku/upstream/ and run tools/fetch-upstream.sh')
        git(d, 'checkout', '-q', '-f', '--', '.', *([':!api'] if d == root else []))
        git(d, 'clean', '-fdq')
    print('checkout put back to the pinned state')


def main():
    ap = argparse.ArgumentParser()
    ap.add_argument('--host-package')
    ap.add_argument('--check', action='store_true', help='only run the self-check on an already patched checkout')
    a = ap.parse_args()
    root = os.environ.get('SHIZUKU_UPSTREAM_DIR') or os.path.join(SHIZUKU, 'upstream')
    if not os.path.isfile(os.path.join(root, 'settings.gradle')):
        die(f'{root} is empty: run shizuku/tools/fetch-upstream.sh first')
    host = host_package(a.host_package)
    if a.check:
        check(root, host)
        return
    marker = os.path.join(root, MARKER)
    h = script_hash(host)
    if os.path.isfile(marker) and not os.environ.get('SHIZUKU_FORCE_PATCH'):
        if read(marker).split()[0] == h:
            print(f'Shizuku already patched for {host} (marker {MARKER})')
            return
    if os.path.isfile(marker) or git(root, 'status', '--porcelain', '--untracked-files=no', '--', '.', ':!api'):
        reset_pristine(root)
    want = open(os.path.join(SHIZUKU, 'UPSTREAM_COMMIT')).read().strip()
    got = git(root, 'rev-parse', 'HEAD')
    if got != want:
        die(f'upstream is at {got}, pinned {want}: run shizuku/tools/fetch-upstream.sh')
    print(f'Patching Shizuku {os.path.basename(open(os.path.join(SHIZUKU, "UPSTREAM_VERSION")).read().strip())} for host package {host}')
    patch_package(root, host)
    patch_library_code(root, host)
    patch_pairing_service(root)
    patch_manifest(root)
    patch_direct_boot(root)
    patch_night_mode(root)
    drop_override_styles(root)
    names, bindings = rename_resources(root)
    generate_locales(root)
    check(root, host, names, bindings)
    write(marker, h + f'  host={host}\n')


if __name__ == '__main__':
    main()
