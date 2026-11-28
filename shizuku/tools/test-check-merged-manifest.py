#!/usr/bin/env python3
"""Shizuku step 4E-4c: self-test of shizuku/tools/check-merged-manifest.py (the merged-manifest checker of rows 4E-1 ... 4E-4b and 5F).

Usage:
  python3 -I shizuku/tools/test-check-merged-manifest.py [-v] [-k TEXT] [--list] [--dump-good] [--no-real] [--root DIR]

  -v          print every case, not only the failures
  -k TEXT     run only the cases whose id or title contains TEXT (the rule-coverage check and the real-manifest step are skipped then)
  --list      print the id and title of every case and stop
  --dump-good print the hand-made GOOD merged manifest (the one every case starts from) and stop
  --no-real   do not look for a real merged manifest under <root>/app/build/intermediates
  --root DIR  project root for the real-manifest step (default: the folder two levels above this script)

Exit codes: 0 everything as expected; 1 a case, a command-line check, the rule coverage or the real manifest failed (one ::error:: line each).

What it does (no Gradle, no network, no files outside a temp folder):
  1. CASES    hand-made merged manifests, a GOOD one and a BAD one for every rule of the checker. Each case builds the good manifest, applies one change (or a few) and
              states EXACTLY which rules must fire (and how many errors each), the state ('checked' / 'failed' / 'absent') and, where it matters, a note or a piece of an error message.
              The cases are numbered like the lists of the README: 2-NN = row 4E-2 (22), 3-NN = 4E-3 (30), 4a-NN = 4E-4a (40 + 2), 4b-NN = 4E-4b (24), 5f-NN = row 5F (direct boot and custom actions, 25); x-NN are added by 4E-4c.
  2. COVERAGE for every registered rule the self-test switches that rule off and requires at least one case to report "did not fire". A rule with no bad case (a future rule, say)
              makes the self-test fail with "no case needs rule ...": add the case, not an exception.
  3. REGISTRY the empty registry passes, a planted rule fails with "[T] boom" (and is removed again); the SKELETON text appears only with no rule.
  3b CONSTANTS the checker's switch STALE_QUERY_ALLOWED has the value this file expects (row 7A-1.2 changed both in one step, to 0; the cases that depend on it set it themselves).
  4. HELPERS  Merged / Component read what the rules rely on (duplicates kept, several authorities, filters, priority, foregroundServiceType ...).
  5. CLI      main() on files in a temp folder: exit 0 / 1 / 2, the messages, the search under app/build/intermediates (release / debug / missing), and three runs of the script as a real
              process (python3 -I) for the exit codes.
  6. REAL     if <root>/app/build/intermediates holds a merged manifest (a Gradle build was made), the checker also runs on it and the result is part of this run. No build = skipped.

Needs only python3 (3.8+). Prints GitHub-style ::error:: lines, like the other checkers of the project.
"""
import argparse
import contextlib
import importlib.util
import io
import os
import re
import subprocess
import sys
import tempfile
import xml.etree.ElementTree as ET

sys.dont_write_bytecode = True   # loading the checker must not leave a __pycache__ in the project (and so in the zip)

HERE = os.path.dirname(os.path.abspath(__file__))
ROOT = os.path.dirname(os.path.dirname(HERE))
CHECKER = os.path.join(HERE, "check-merged-manifest.py")
NS = "http://schemas.android.com/apk/res/android"
A = "{%s}" % NS
ET.register_namespace("android", NS)
ET.register_namespace("tools", "http://schemas.android.com/tools")
TAG = "Shizuku manifest self-test"


def load_checker():
    spec = importlib.util.spec_from_file_location("check_merged_manifest", CHECKER)
    mod = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(mod)
    return mod


cmm = load_checker()

# rule ids as the checker prints them (kept as constants so a typo is a NameError, not a silently passing case)
R_AUTH, R_OWNER, R_OLD, R_GUARD = "4E-2 authority", "4E-2 owner", "4E-2 old provider", "4E-2 provider guard"
R_DYN, R_NOV23, R_ONCE, R_LEV, R_MREQ = "4E-3 dynamic receiver", "4E-3 no API_V23 request", "4E-3 declared once", "4E-3 levels", "4E-3 manager request"
R_INV, R_EXP, R_LAUNCH, R_SVC, R_BOOT = "4E-4a inventory", "4E-4a exported", "4E-4a launcher", "4E-4a service", "4E-4a boot receivers"
R_STALE, R_APPCLS, R_OLDS = "4E-4b stale package", "4E-4b application class", "4E-4b old provider string"
R_DB, R_ACT = "5F direct boot", "5F custom actions"
R_PRESENT = "present"

APP_PKG = "com.srizwan.win11"
OTHER_PKG = "com.other.app"
MGR = "moe.shizuku.manager"
INTERACT = "android.permission.INTERACT_ACROSS_USERS_FULL"
GROUP = "moe.shizuku.manager.permission-group.API"
STALE = "moe.shizuku.privileged.api"
BOOT = "android.intent.action.BOOT_COMPLETED"
LOCKED = "android.intent.action.LOCKED_BOOT_COMPLETED"


# ---------------------------------------------------------------- the GOOD merged manifest and the helpers that change it

def frag(xml):
    """One element from a fragment (the android: prefix is declared for it)."""
    return list(ET.fromstring('<w xmlns:android="%s">%s</w>' % (NS, xml)))[0]


def filt(*actions, cats=(), prio=None):
    return "<intent-filter%s>%s%s</intent-filter>" % (
        (' android:priority="%s"' % prio) if prio is not None else "",
        "".join('<action android:name="%s"/>' % a for a in actions),
        "".join('<category android:name="%s"/>' % c for c in cats))


def good_xml(pkg=APP_PKG, app_ns=APP_PKG, mika=True, shizuku=True):
    """What a correct merge should look like (as far as the rules read it). pkg = the package attribute (= applicationId, the CI may rename it); app_ns = the namespace of :app, which
    its component names are written under (it does not have to be the applicationId). shizuku=False: no component or permission of :shizuku (the build without includeShizuku)."""
    p = ['<manifest xmlns:android="%s" package="%s">' % (NS, pkg)]
    p.append('<uses-permission android:name="android.permission.INTERNET"/>')
    p.append('<uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>')
    p.append('<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>')
    if shizuku:
        p.append('<permission android:name="%s.permission.MANAGER" android:protectionLevel="signature"/>' % MGR)
        p.append('<permission android:name="%s.permission.API_V23" android:protectionLevel="dangerous" android:permissionGroup="%s"/>' % (MGR, GROUP))
        p.append('<permission android:name="%s.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION" android:protectionLevel="signature"/>' % pkg)
        p.append('<uses-permission android:name="%s.permission.MANAGER"/>' % MGR)
        p.append('<uses-permission android:name="%s.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"/>' % pkg)
    p.append('<application android:label="host" android:name="%s.App">' % app_ns)
    p.append('<activity android:name="%s.MainActivity" android:exported="true">%s</activity>'
             % (app_ns, filt("android.intent.action.MAIN", cats=("android.intent.category.LAUNCHER",))))
    p.append('<receiver android:name="%s.BootReceiver" android:exported="true">%s</receiver>' % (app_ns, filt(BOOT)))
    if mika:
        p.append('<activity android:name="com.wangzan101.mika.MikaActivity" android:exported="false"/>')
        p.append('<receiver android:name="com.wangzan101.mika.setup.BootRestoreReceiver" android:exported="true">%s</receiver>' % filt(BOOT))
    if shizuku:
        for rel in ("MainActivity", "management.ApplicationManagementActivity", "adb.AdbPairingTutorialActivity", "shell.ShellTutorialActivity", "starter.StarterActivity"):
            p.append('<activity android:name="%s.%s" android:exported="false"/>' % (MGR, rel))
        p.append('<activity android:name="%s.settings.SettingsActivity" android:exported="false">%s</activity>'
                 % (MGR, filt("android.intent.action.APPLICATION_PREFERENCES", cats=("android.intent.category.DEFAULT",))))
        p.append('<activity android:name="%s.authorization.RequestPermissionActivity" android:exported="true" android:permission="%s">%s</activity>'
                 % (MGR, INTERACT, filt("%s.intent.action.REQUEST_PERMISSION" % pkg, cats=("android.intent.category.DEFAULT",))))
        p.append('<activity android:name="%s.legacy.ShellRequestHandlerActivity" android:exported="true">%s</activity>'
                 % (MGR, filt("rikka.shizuku.intent.action.REQUEST_BINDER", cats=("android.intent.category.DEFAULT",))))
        p.append('<activity android:name="%s.legacy.LegacyIsNotSupportedActivity" android:exported="true" android:permission="%s.permission.API">%s</activity>'
                 % (MGR, MGR, filt("%s.intent.action.REQUEST_AUTHORIZATION" % pkg, cats=("android.intent.category.DEFAULT",))))
        p.append('<service android:name="%s.adb.AdbPairingService" android:exported="false" android:foregroundServiceType="shortService"/>' % MGR)
        p.append('<receiver android:name="%s.receiver.BootCompleteReceiver" android:exported="true">%s</receiver>' % (MGR, filt(BOOT)))
        p.append('<receiver android:name="%s.receiver.ShizukuReceiver" android:exported="true">%s</receiver>' % (MGR, filt("rikka.shizuku.intent.action.REQUEST_BINDER")))
        p.append('<provider android:name="%s.ShizukuManagerProvider" android:authorities="%s.shizuku" android:exported="true" android:permission="%s"/>' % (MGR, pkg, INTERACT))
    p.append("</application></manifest>")
    return "".join(p)


def good(**kw):
    return ET.fromstring(good_xml(**kw))


def application(r):
    return r.find("application")


def comps(r, name):
    return [e for e in application(r) if e.get(A + "name") == name]


def comp(r, name):
    found = comps(r, name)
    assert found, "self-test bug: the good manifest has no component %s" % name
    return found[0]


def mgr(rel):
    return MGR + "." + rel


def put(r, xml):
    """Add a component (or any element) to <application>; returns it."""
    el = frag(xml)
    application(r).append(el)
    return el


def put_root(r, xml):
    el = frag(xml)
    r.append(el)
    return el


def drop(r, name):
    for e in comps(r, name):
        application(r).remove(e)


def setv(el, attr, value=None):
    """Set android:<attr> (value None removes it)."""
    if value is None:
        el.attrib.pop(A + attr, None)
    else:
        el.set(A + attr, value)


def perm_els(r, tag, name):
    return [e for e in r.findall(tag) if e.get(A + "name") == name]


def drop_perm(r, tag, name):
    for e in perm_els(r, tag, name):
        r.remove(e)


def dyn(pkg=APP_PKG):
    return pkg + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"


MANAGER_PERM = MGR + ".permission.MANAGER"
API_V23 = MGR + ".permission.API_V23"
SVC = mgr("adb.AdbPairingService")
PROV = mgr("ShizukuManagerProvider")
B_APP = APP_PKG + ".BootReceiver"
B_MIKA = "com.wangzan101.mika.setup.BootRestoreReceiver"
B_MGR = mgr("receiver.BootCompleteReceiver")
MAIN_MGR = mgr("MainActivity")
STARTER = mgr("starter.StarterActivity")
SETTINGS = mgr("settings.SettingsActivity")
REQ_ACT = mgr("authorization.RequestPermissionActivity")
SHIZUKU_RECV = mgr("receiver.ShizukuReceiver")


def strip_shizuku_but_keep_mika_provider(r):
    """Mika's own provider, as it was before the 4B overlay removed it."""
    put(r, '<provider android:name="rikka.shizuku.ShizukuProvider" android:authorities="%s.shizuku" android:exported="true"/>' % APP_PKG)


# ---------------------------------------------------------------- the cases

CASES = []


def case(cid, title, mutate=None, expect=(), kw=None, require=False, state=None, notes=(), no_notes=(), patch=None, contains=()):
    """expect: rule ids that must fire; an id alone = any number of errors >= 1, (id, n) = exactly n errors. No other rule may fire.
    state default: 'checked' when nothing is expected, else 'failed'. notes / no_notes: substrings that must / must not be in a note. contains: substrings that must be in the error text.
    patch: {module constant: value} set on the checker for this case only (the switch of row 7A-1.2)."""
    CASES.append(dict(id=cid, title=title, mutate=mutate, expect=list(expect), kw=kw or {}, require=require, state=state, notes=list(notes), no_notes=list(no_notes),
                      patch=patch or {}, contains=list(contains)))


def run_case(c):
    """Returns a list of problems (empty = the case behaved as stated)."""
    problems = []
    root = good(**c["kw"])
    if c["mutate"]:
        c["mutate"](root)
    saved = {k: getattr(cmm, k) for k in c["patch"]}
    try:
        for k, v in c["patch"].items():
            setattr(cmm, k, v)
        errors, notes, state = cmm.check(root, c["require"])
    finally:
        for k, v in saved.items():
            setattr(cmm, k, v)
    fired = {}
    for e in errors:
        mt = re.match(r"\[([^\]]+)\] ", e)
        if not mt:
            problems.append("an error line without [rule id]: %s" % e)
            continue
        fired[mt.group(1)] = fired.get(mt.group(1), 0) + 1
    want = {}
    for x in c["expect"]:
        want[x[0] if isinstance(x, tuple) else x] = x[1] if isinstance(x, tuple) else None
    for rid, n in want.items():
        if rid not in fired:
            problems.append("rule [%s] did not fire" % rid)
        elif n is not None and fired[rid] != n:
            problems.append("rule [%s] fired %d time(s), expected %d: %s" % (rid, fired[rid], n, [e for e in errors if e.startswith("[%s]" % rid)]))
    for rid in fired:
        if rid not in want:
            problems.append("rule [%s] fired but is not expected: %s" % (rid, [e for e in errors if e.startswith("[%s]" % rid)]))
    wstate = c["state"] or ("failed" if want else "checked")
    if state != wstate:
        problems.append("state is %s, expected %s" % (state, wstate))
    for s in c["notes"]:
        if not any(s in n for n in notes):
            problems.append("no note contains %r (notes: %s)" % (s, notes))
    for s in c["no_notes"]:
        if any(s in n for n in notes):
            problems.append("a note contains %r but must not (notes: %s)" % (s, notes))
    for s in c["contains"]:
        if not any(s in e for e in errors):
            problems.append("no error contains %r" % s)
    return problems


# ---- 4E-2 (22 cases): provider and authority

def m_clash(r):
    strip_shizuku_but_keep_mika_provider(r)


def m_mika_alone(r):
    setv(comp(r, PROV), "authorities", APP_PKG + ".other")
    strip_shizuku_but_keep_mika_provider(r)


def m_guard_perm(value):
    return lambda r: setv(comp(r, PROV), "permission", value)


def m_provider_twice(r):
    application(r).append(frag(ET.tostring(comp(r, PROV), encoding="unicode")))


def m_other_provider(r):
    put(r, '<provider android:name="com.example.OtherProvider" android:authorities="%s.shizuku" android:exported="false"/>' % APP_PKG)


def m_not_built_in_with_mika_provider(r):
    strip_shizuku_but_keep_mika_provider(r)


case("2-01", "good manifest passes with every rule", no_notes=("package attribute", "Mika is not", "still there"))
case("2-02", "clash with Mika's provider: the authority is used twice, and the old provider is left", m_clash, [(R_AUTH, 1), (R_OLD, 1)], contains=("used 2 times", "INSTALL_FAILED_CONFLICTING_PROVIDER"))
case("2-03", "Mika's provider alone owns the authority", m_mika_alone, [(R_AUTH, 1), (R_OWNER, 1), (R_OLD, 1)])
case("2-04", "the manager's provider has no authority", lambda r: setv(comp(r, PROV), "authorities", None), [(R_AUTH, 1), (R_OWNER, 1)])
case("2-05", "package renamed, authority not", lambda r: setv(comp(r, PROV), "authorities", APP_PKG + ".shizuku"), [(R_AUTH, 1), (R_OWNER, 1)], kw={"pkg": OTHER_PKG})
case("2-06", "package renamed and authority renamed with it passes", kw={"pkg": OTHER_PKG})
case("2-07", "unresolved ${applicationId} in the authority", lambda r: setv(comp(r, PROV), "authorities", "${applicationId}.shizuku"), [(R_AUTH, 2), (R_OWNER, 1)], contains=("unresolved placeholder",))
case("2-08", "provider guard: exported false (the exported rule of 4E-4a fires too)", lambda r: setv(comp(r, PROV), "exported", "false"), [(R_GUARD, 1), (R_EXP, 1)])
case("2-09", "provider guard: exported not written (a provider without a filter is not exported)", lambda r: setv(comp(r, PROV), "exported", None), [(R_GUARD, 1), (R_EXP, 1)])
case("2-10", "provider guard: no permission", m_guard_perm(None), [(R_GUARD, 1)], contains=("without it any app could call the provider",))
case("2-11", "provider guard: a different permission", m_guard_perm("android.permission.INTERNET"), [(R_GUARD, 1)])
case("2-12", "provider guard: multiprocess true", lambda r: setv(comp(r, PROV), "multiprocess", "true"), [(R_GUARD, 1)])
case("2-13", "provider guard: multiprocess written as false passes (not written = false passes in 2-01)", lambda r: setv(comp(r, PROV), "multiprocess", "false"))
case("2-14", "the manager's provider declared twice", m_provider_twice, [(R_AUTH, 1), (R_OWNER, 1), (R_INV, 1)])
case("2-15", "the manager's provider lists a second authority", lambda r: setv(comp(r, PROV), "authorities", "%s.shizuku;%s.extra" % (APP_PKG, APP_PKG)), [(R_OWNER, 1)])
case("2-16", "another provider owns <applicationId>.shizuku as well", m_other_provider, [(R_AUTH, 1)])
case("2-17", "no manager provider at all", lambda r: drop(r, PROV), [(R_AUTH, 1), (R_OWNER, 1), (R_INV, 1)])
case("2-18", "no package attribute: passes through the .shizuku ending, with notes", lambda r: r.attrib.pop("package"), notes=("no package attribute",))
case("2-19", "no package attribute and a wrong authority suffix fails twice", lambda r: (r.attrib.pop("package"), setv(comp(r, PROV), "authorities", APP_PKG + ".other")), [(R_AUTH, 1), (R_OWNER, 1)])
case("2-20", "whitespace and empty entries in authorities are ignored", lambda r: setv(comp(r, PROV), "authorities", "  %s.shizuku ; ; " % APP_PKG))
case("2-21", "Shizuku not built in: no rule runs, even with Mika's provider present", m_not_built_in_with_mika_provider, kw={"shizuku": False}, state="absent", notes=("not built in",))
case("2-22", "the same with --require-shizuku fails", m_not_built_in_with_mika_provider, [R_PRESENT], kw={"shizuku": False}, require=True, state="failed", contains=("--require-shizuku",))


# ---- 4E-3 (30 cases): permissions

def m_dyn_both_gone(r):
    drop_perm(r, "permission", dyn())
    drop_perm(r, "uses-permission", dyn())


def m_dyn_rename(new, old=None):
    """Rename the dynamic receiver permission (both elements) from old (default: the name under APP_PKG) to new."""
    def f(r):
        for tag in ("permission", "uses-permission"):
            for e in perm_els(r, tag, old or dyn()):
                e.set(A + "name", new)
    return f


def m_perm_twice(tag, name):
    def f(r):
        r.append(frag(ET.tostring(perm_els(r, tag, name)[0], encoding="unicode")))
    return f


def m_request(tag, name, n=1):
    def f(r):
        for _ in range(n):
            put_root(r, '<%s android:name="%s"/>' % (tag, name))
    return f


def m_level(name, value):
    return lambda r: setv(perm_els(r, "permission", name)[0], "protectionLevel", value)


def m_group(value):
    return lambda r: setv(perm_els(r, "permission", API_V23)[0], "permissionGroup", value)


def m_both(*fs):
    def f(r):
        for g in fs:
            g(r)
    return f


def m_no_package_and_no_dyn(r):
    r.attrib.pop("package")
    m_dyn_both_gone(r)


case("3-01", "good: the five permission facts as the real merge should give them")
case("3-02", "dynamic receiver permission removed completely (<permission> and <uses-permission>)", m_dyn_both_gone, [(R_DYN, 2)], contains=("a remove marker",))
case("3-03", "dynamic receiver permission declared but not requested", lambda r: drop_perm(r, "uses-permission", dyn()), [(R_DYN, 1)])
case("3-04", "dynamic receiver permission requested but not declared", lambda r: drop_perm(r, "permission", dyn()), [(R_DYN, 1)])
case("3-05", "dynamic receiver permission declared twice", m_perm_twice("permission", dyn()), [(R_DYN, 1)])
case("3-06", "dynamic receiver permission only under another package prefix", m_dyn_rename(dyn(OTHER_PKG)), [(R_DYN, 2)])
case("3-07", "unresolved ${applicationId} in the permission name", m_dyn_rename("${applicationId}.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"), [R_DYN], contains=("unresolved placeholder",))
case("3-08", "package renamed, the permission names renamed with it, passes", kw={"pkg": OTHER_PKG})
case("3-09", "package renamed but the permission names not", m_dyn_rename(dyn(APP_PKG), dyn(OTHER_PKG)), [(R_DYN, 2)], kw={"pkg": OTHER_PKG})
case("3-10", "no package attribute: the permission is matched by its ending and passes, with a note", lambda r: r.attrib.pop("package"), notes=("matched by their ending",))
case("3-11", "no package attribute and the permission missing", m_no_package_and_no_dyn, [(R_DYN, 2)])
case("3-12", "API_V23 requested through <uses-permission>", m_request("uses-permission", API_V23), [(R_NOV23, 1)])
case("3-13", "API_V23 requested through <uses-permission-sdk-23>", m_request("uses-permission-sdk-23", API_V23), [(R_NOV23, 1)])
case("3-14", "API_V23 requested twice is still one error", m_request("uses-permission", API_V23, 2), [(R_NOV23, 1)], contains=("finding 3",))
case("3-15", "MANAGER not declared", lambda r: drop_perm(r, "permission", MANAGER_PERM), [(R_ONCE, 1)])
case("3-16", "API_V23 not declared", lambda r: drop_perm(r, "permission", API_V23), [(R_ONCE, 1)])
case("3-17", "MANAGER declared twice", m_perm_twice("permission", MANAGER_PERM), [(R_ONCE, 1)])
case("3-18", "API_V23 declared twice", m_perm_twice("permission", API_V23), [(R_ONCE, 1)])
case("3-19", "neither declared", m_both(lambda r: drop_perm(r, "permission", MANAGER_PERM), lambda r: drop_perm(r, "permission", API_V23)), [(R_ONCE, 2)])
case("3-20", "MANAGER has protectionLevel normal", m_level(MANAGER_PERM, "normal"), [(R_LEV, 1)])
case("3-21", "MANAGER has no protectionLevel", m_level(MANAGER_PERM, None), [(R_LEV, 1)])
case("3-22", "API_V23 has protectionLevel signature", m_level(API_V23, "signature"), [(R_LEV, 1)])
case("3-23", "API_V23 is in the wrong group", m_group("some.other.group"), [(R_LEV, 1)])
case("3-24", "API_V23 has no group", m_group(None), [(R_LEV, 1)])
case("3-25", "MANAGER has protectionLevel signature|privileged", m_level(MANAGER_PERM, "signature|privileged"), [(R_LEV, 1)])
case("3-26", "MANAGER not requested", lambda r: drop_perm(r, "uses-permission", MANAGER_PERM), [(R_MREQ, 1)], contains=("binder",))
case("3-27", "MANAGER requested twice", m_request("uses-permission", MANAGER_PERM), [(R_MREQ, 1)])
case("3-28", "Shizuku not built in: no permission rule runs although every permission is missing", kw={"shizuku": False}, state="absent")
case("3-29", "--require-shizuku with no Shizuku component (the present check)", kw={"shizuku": False}, require=True, expect=[R_PRESENT], state="failed")
case("3-30", "three faults at once: exactly three rules fire", m_both(lambda r: drop_perm(r, "uses-permission", dyn()), m_request("uses-permission", API_V23), lambda r: drop_perm(r, "uses-permission", MANAGER_PERM)),
     [(R_DYN, 1), (R_NOV23, 1), (R_MREQ, 1)])


# ---- 4E-4a (40 + 2 cases): components

def m_exported(name, value):
    return lambda r: setv(comp(r, name), "exported", value)


def m_add_filter(name, xml):
    return lambda r: comp(r, name).append(frag(xml))


def m_service_type(value):
    return lambda r: setv(comp(r, SVC), "foregroundServiceType", value)


def m_priority(name, prio="100"):
    def f(r):
        for fl in comp(r, name).findall("intent-filter"):
            fl.set(A + "priority", prio)
    return f


def m_replace_actions(name, *actions):
    def f(r):
        el = comp(r, name)
        for fl in el.findall("intent-filter"):
            el.remove(fl)
        el.append(frag(filt(*actions)))
    return f


def m_rename(old, new):
    return lambda r: comp(r, old).set(A + "name", new)


def m_launcher(cat):
    return m_add_filter(MAIN_MGR, filt("android.intent.action.MAIN", cats=(cat,)))


def m_faults_4a(r):
    setv(comp(r, STARTER), "exported", "true")
    setv(comp(r, SVC), "foregroundServiceType", None)
    m_launcher("android.intent.category.LAUNCHER")(r)
    m_priority(B_APP)(r)


def m_break_when_not_built_in(r):
    drop(r, B_APP)
    comp(r, APP_PKG + ".MainActivity").append(frag(filt("android.intent.action.MAIN", cats=("android.intent.category.HOME",))))


def m_service_listens(r):
    drop(r, B_APP)
    put(r, '<service android:name="%s" android:exported="false">%s</service>' % (B_APP, filt(BOOT)))


case("4a-01", "good manifest with Mika: 13 manager components, three boot receivers", no_notes=("Mika is not",))
case("4a-02", "good manifest without Mika: two boot receivers, a note says so", kw={"mika": False}, notes=("Mika is not in the merged manifest",))
case("4a-03", "good with the package renamed (the :app boot receiver is matched by its simple name)", kw={"pkg": OTHER_PKG})
case("4a-04", "inventory: an activity missing", lambda r: drop(r, SETTINGS), [(R_INV, 1)], contains=("missing: " + SETTINGS,))
case("4a-05", "inventory: the service missing (the service rule says nothing)", lambda r: drop(r, SVC), [(R_INV, 1)])
case("4a-06", "inventory: the provider missing", lambda r: drop(r, PROV), [(R_INV, 1), (R_AUTH, 1), (R_OWNER, 1)])
case("4a-07", "inventory: a receiver missing (ShizukuReceiver also carries REQUEST_BINDER, so the action rule of 5F fires too)", lambda r: drop(r, SHIZUKU_RECV), [(R_INV, 1), (R_ACT, 1)])
case("4a-08", "inventory: an activity declared twice", lambda r: application(r).append(frag(ET.tostring(comp(r, STARTER), encoding="unicode"))), [(R_INV, 1)], contains=("declared more than once",))
case("4a-09", "inventory: an extra manager activity", lambda r: put(r, '<activity android:name="%s" android:exported="false"/>' % mgr("extra.ExtraActivity")), [(R_INV, 1)], contains=("unexpected: " + mgr("extra.ExtraActivity"),))
case("4a-10", "inventory: a manager activity renamed (missing and unexpected in one message)", m_rename(SETTINGS, mgr("settings.SettingsActivity2")), [(R_INV, 1)])
case("4a-11", "inventory: an activity-alias of the manager", lambda r: put(r, '<activity-alias android:name="%s" android:targetActivity="%s" android:exported="false"/>' % (mgr("Alias"), MAIN_MGR)), [(R_INV, 1)])
case("4a-12", "exported: StarterActivity exported", m_exported(STARTER, "true"), [(R_EXP, 1)])
case("4a-13", "exported: SettingsActivity exported", m_exported(SETTINGS, "true"), [(R_EXP, 1)])
case("4a-14", "exported: RequestPermissionActivity not exported", m_exported(REQ_ACT, "false"), [(R_EXP, 1)])
case("4a-15", "exported: ShizukuReceiver not exported", m_exported(SHIZUKU_RECV, "false"), [(R_EXP, 1)])
case("4a-16", "exported not written on a component with a filter = exported (RequestPermissionActivity): passes", m_exported(REQ_ACT, None))
case("4a-17", "exported not written on a component without a filter = not exported (StarterActivity): passes", m_exported(STARTER, None))
case("4a-18", "exported not written and a filter added = exported (StarterActivity)", m_both(m_exported(STARTER, None), m_add_filter(STARTER, filt("android.intent.action.VIEW"))), [(R_EXP, 1)])
case("4a-19", "the service exported (the exported rule and the service rule both fire)", m_exported(SVC, "true"), [(R_EXP, 1), (R_SVC, 1)])
case("4a-20", "launcher: LAUNCHER on the manager's MainActivity", m_launcher("android.intent.category.LAUNCHER"), [(R_LAUNCH, 1)])
case("4a-21", "launcher: LEANBACK_LAUNCHER on the manager's MainActivity", m_launcher("android.intent.category.LEANBACK_LAUNCHER"), [(R_LAUNCH, 1)])
case("4a-22", "launcher: HOME on the manager's MainActivity", m_launcher("android.intent.category.HOME"), [(R_LAUNCH, 1)])
case("4a-23", ":app's own MainActivity with LAUNCHER and HOME does not trip the launcher rule", m_add_filter(APP_PKG + ".MainActivity", filt("android.intent.action.MAIN", cats=("android.intent.category.HOME",))))
case("4a-24", "service type dataSync", m_service_type("dataSync"), [(R_SVC, 1)])
case("4a-25", "service type missing", m_service_type(None), [(R_SVC, 1)])
case("4a-26", "service type dataSync|shortService (a combination is not a short service)", m_service_type("dataSync|shortService"), [(R_SVC, 1)])
case("4a-27", "boot: a priority on :app's receiver", m_priority(B_APP), [(R_BOOT, 1)], contains=("android:priority=100",))
case("4a-28", "boot: a priority on Mika's receiver", m_priority(B_MIKA), [(R_BOOT, 1)])
case("4a-29", "boot: a priority on the manager's receiver", m_priority(B_MGR), [(R_BOOT, 1)])
case("4a-30", "boot: :app's receiver loses BOOT_COMPLETED", m_replace_actions(B_APP, "com.example.OTHER"), [(R_BOOT, 1)])
case("4a-31", "boot: Mika's receiver loses BOOT_COMPLETED", m_replace_actions(B_MIKA, "com.example.OTHER"), [(R_BOOT, 1)])
case("4a-32", "boot: a fourth listener", lambda r: put(r, '<receiver android:name="com.example.FourthReceiver" android:exported="false">%s</receiver>' % filt(BOOT)), [(R_BOOT, 1)], contains=("a fourth listener",))
case("4a-33", "boot: a second ...BootReceiver", lambda r: put(r, '<receiver android:name="com.other.BootReceiver" android:exported="false">%s</receiver>' % filt(BOOT)), [(R_BOOT, 1)])
case("4a-34", "boot: the manager's receiver left with LOCKED_BOOT_COMPLETED only (the direct-boot rule of 5F fires too)", m_replace_actions(B_MGR, LOCKED), [(R_BOOT, 1), (R_DB, 1)])
case("4a-35", "boot: :app's BootReceiver is a service, not a receiver", m_service_listens, [(R_BOOT, 1)], contains=("expected a receiver",))
case("4a-36", "boot: Mika's receiver renamed (one missing, one unexpected)", m_rename(B_MIKA, "com.wangzan101.mika.setup.RenamedReceiver"), [(R_BOOT, 2)])
case("4a-37", "boot: Mika out and :app's receiver gone", lambda r: drop(r, B_APP), [(R_BOOT, 1)], kw={"mika": False}, notes=("Mika is not in the merged manifest",))
case("4a-38", "boot: :app's receiver listens to LOCKED_BOOT_COMPLETED only", m_replace_actions(B_APP, LOCKED), [(R_BOOT, 1)])
case("4a-39", "Shizuku not built in: no component rule runs, even with a broken :app", m_break_when_not_built_in, kw={"shizuku": False}, state="absent")
case("4a-40", "several faults at once: exactly the four rules concerned fire", m_faults_4a, [(R_EXP, 1), (R_SVC, 1), (R_LAUNCH, 1), (R_BOOT, 1)])
case("4a-41", "exported not written on SettingsActivity (it has the APPLICATION_PREFERENCES filter) = exported", m_exported(SETTINGS, None), [(R_EXP, 1)])
case("4a-42", "the manager's BootCompleteReceiver not exported", m_exported(B_MGR, "false"), [(R_EXP, 1)])


# ---- 4E-4b (24 cases): strings

def q(inner):
    return lambda r: put_root(r, "<queries>%s</queries>" % inner)


PKG_ENTRY = '<package android:name="%s"/>' % STALE
EXPECTED_STALE_QUERY_ALLOWED = 0   # the value of the checker's switch since row 7A-1.2 (it was 1 until then): change this line and the checker's constant together


def m_in_app(xml):
    return lambda r: put(r, xml)


def m_old_provider_component(r):
    put(r, '<provider android:name="rikka.shizuku.ShizukuProvider" android:authorities="%s.old" android:exported="false"/>' % APP_PKG)


def m_all_three_stale(r):
    put(r, '<meta-data android:name="a" android:value="%s"/>' % STALE)
    put(r, '<meta-data android:name="b" android:value="rikka.shizuku.ShizukuProvider"/>')
    put(r, '<meta-data android:name="c" android:value="com.example.ShizukuApplication"/>')


def m_faults_4b(r):
    put(r, '<service android:name="com.example.S" android:exported="false">%s</service>' % filt(STALE + ".intent.action.X"))
    setv(application(r), "name", mgr("ShizukuApplication"))
    put(r, '<meta-data android:name="old" android:value="rikka.shizuku.ShizukuProvider"/>')


case("4b-01", "no stale string, no note about the <queries> entry", no_notes=("<queries> entry",))
case("4b-02", "the one allowed <queries><package> entry passes, with the note", q(PKG_ENTRY), notes=("allowed by the switch",), patch={"STALE_QUERY_ALLOWED": 1})
case("4b-03", "the entry twice, in two <queries> blocks", m_both(q(PKG_ENTRY), q(PKG_ENTRY)), [(R_STALE, 1)], contains=("2 <queries><package",), patch={"STALE_QUERY_ALLOWED": 1})
case("4b-04", "stale package in an action name", m_in_app('<service android:name="com.example.S" android:exported="false">%s</service>' % filt(STALE + ".intent.action.X")), [(R_STALE, 1)])
case("4b-05", "stale package in a <uses-permission>", lambda r: put_root(r, '<uses-permission android:name="%s.permission.API"/>' % STALE), [(R_STALE, 1)])
case("4b-06", "stale package in a meta-data value", m_in_app('<meta-data android:name="x" android:value="%s"/>' % STALE), [(R_STALE, 1)])
case("4b-07", "the allowed entry plus a stale meta-data value: exactly one error, for the value", m_both(q(PKG_ENTRY), m_in_app('<meta-data android:name="x" android:value="%s"/>' % STALE)), [(R_STALE, 1)], contains=("<meta-data x> attribute value",), patch={"STALE_QUERY_ALLOWED": 1})
case("4b-08", "a <queries><package> with a longer name is not the allowed entry", q('<package android:name="%s.extra"/>' % STALE), [(R_STALE, 1)])
case("4b-09", "stale package as element text", m_in_app("<note>%s</note>" % STALE), [(R_STALE, 1)], contains=("text",))
case("4b-10", "stale package in a <queries><intent> action", q('<intent><action android:name="%s.intent.action.X"/></intent>' % STALE), [(R_STALE, 1)])
case("4b-11", "<application> named moe.shizuku.manager.ShizukuApplication", lambda r: setv(application(r), "name", mgr("ShizukuApplication")), [(R_APPCLS, 1)], contains=("must keep its own Application",))
case("4b-12", "<application> named another class of the manager", lambda r: setv(application(r), "name", mgr("SomeApp")), [(R_APPCLS, 1)])
case("4b-13", "rikka.shizuku.ShizukuApplication in a meta-data value", m_in_app('<meta-data android:name="x" android:value="rikka.shizuku.ShizukuApplication"/>'), [(R_APPCLS, 1)])
case("4b-14", "ShizukuApplication as the name of another component", m_in_app('<activity android:name="com.example.ShizukuApplication" android:exported="false"/>'), [(R_APPCLS, 1)])
case("4b-15", "the host <application> without a name passes", lambda r: setv(application(r), "name", None))
case("4b-16", "the old provider component left: only 4E-2 old provider fires (the string rule does not report it twice)", m_old_provider_component, [(R_OLD, 1)])
case("4b-17", "rikka.shizuku.ShizukuProvider in a meta-data value", m_in_app('<meta-data android:name="x" android:value="rikka.shizuku.ShizukuProvider"/>'), [(R_OLDS, 1)])
case("4b-18", "rikka.shizuku.ShizukuProvider inside a longer string", m_in_app('<meta-data android:name="x" android:value="a/rikka.shizuku.ShizukuProvider/b"/>'), [(R_OLDS, 1)])
case("4b-19", "rikka.shizuku.ShizukuProvider in an attribute of another element", lambda r: setv(comp(r, APP_PKG + ".MainActivity"), "label", "rikka.shizuku.ShizukuProvider"), [(R_OLDS, 1)])
case("4b-20", "the manager's own provider name in a string is fine", m_in_app('<meta-data android:name="x" android:value="%s"/>' % PROV))
case("4b-21", "Shizuku not built in with all three stale strings present: no rule runs", m_all_three_stale, kw={"shizuku": False}, state="absent")
case("4b-22", "several faults at once: the three string rules fire, nothing else", m_faults_4b, [(R_STALE, 1), (R_APPCLS, 1), (R_OLDS, 1)])
case("4b-23", "STALE_QUERY_ALLOWED = 0 (the shipped value since 7A-1.2): the entry fails", q(PKG_ENTRY), [(R_STALE, 1)], patch={"STALE_QUERY_ALLOWED": 0}, no_notes=("allowed by the switch",))
case("4b-24", "STALE_QUERY_ALLOWED = 0 and no entry: passes", None, patch={"STALE_QUERY_ALLOWED": 0})


# ---- 5F (25 cases): direct boot (finding 12) and custom actions (5D)

REQ_BINDER = "rikka.shizuku.intent.action.REQUEST_BINDER"
SHELL_ACT = mgr("legacy.ShellRequestHandlerActivity")
LEGACY_ACT = mgr("legacy.LegacyIsNotSupportedActivity")


def m_dba(*names, value="true"):
    def f(r):
        for n in names:
            setv(comp(r, n), "directBootAware", value)
    return f


def m_action_on(name, action):
    return lambda r: comp(r, name).append(frag(filt(action)))


def m_set_action(name, old, new):
    def f(r):
        for a in comp(r, name).iter("action"):
            if a.get(A + "name") == old:
                a.set(A + "name", new)
    return f


def m_drop_filters(name):
    def f(r):
        el = comp(r, name)
        for fl in el.findall("intent-filter"):
            el.remove(fl)
    return f


def m_both_faults_5f(r):
    setv(comp(r, PROV), "directBootAware", "true")
    comp(r, SHIZUKU_RECV).append(frag(filt("%s.intent.action.NOTIFY" % APP_PKG)))


case("5f-01", "good manifest: no flag, no LOCKED listener, every custom action on its components", no_notes=("package attribute",))
case("5f-02", "direct boot: BootCompleteReceiver is directBootAware", m_dba(B_MGR), [(R_DB, 1)], contains=("finding 12",))
case("5f-03", "direct boot: ShizukuReceiver is directBootAware", m_dba(SHIZUKU_RECV), [(R_DB, 1)])
case("5f-04", "direct boot: the provider is directBootAware", m_dba(PROV), [(R_DB, 1)])
case("5f-05", "direct boot: all three are directBootAware", m_dba(B_MGR, SHIZUKU_RECV, PROV), [(R_DB, 3)])
case("5f-06", "direct boot: android:directBootAware=\"false\" written on the three passes", m_dba(B_MGR, SHIZUKU_RECV, PROV, value="false"))
case("5f-07", "direct boot: the value TRUE (capitals) counts as set", m_dba(PROV, value="TRUE"), [(R_DB, 1)])
case("5f-08", "direct boot: another manager component (SettingsActivity) is directBootAware", m_dba(SETTINGS), [(R_DB, 1)])
case("5f-09", "direct boot: BootCompleteReceiver gets a second filter with LOCKED_BOOT_COMPLETED", m_add_filter(B_MGR, filt(LOCKED)), [(R_DB, 1)], contains=("LOCKED_BOOT_COMPLETED",))
case("5f-10", "direct boot: LOCKED_BOOT_COMPLETED in the same filter as BOOT_COMPLETED", m_replace_actions(B_MGR, BOOT, LOCKED), [(R_DB, 1)])
case("5f-11", "direct boot: a manager service that listens to LOCKED_BOOT_COMPLETED", m_add_filter(SVC, filt(LOCKED)), [(R_DB, 1)])
case("5f-12", "direct boot: :app's own components are not judged (flag and LOCKED listener on :app's receiver pass)", m_both(m_dba(B_APP), m_add_filter(B_APP, filt(LOCKED))))
case("5f-13", "direct boot: Shizuku not built in, the rule does not run", m_dba(B_APP), kw={"shizuku": False}, state="absent")
case("5f-14", "actions: REQUEST_PERMISSION is on RequestPermissionActivity only (good manifest passes with the package renamed)", kw={"pkg": OTHER_PKG})
case("5f-15", "actions: REQUEST_PERMISSION still has the old package (missing + unknown; the stale-package rule fires too)", m_set_action(REQ_ACT, "%s.intent.action.REQUEST_PERMISSION" % APP_PKG, STALE + ".intent.action.REQUEST_PERMISSION"), [(R_ACT, 2), (R_STALE, 1)], contains=("expected exactly",))
case("5f-16", "actions: REQUEST_PERMISSION missing (its filter is gone)", m_drop_filters(REQ_ACT), [(R_ACT, 1)], contains=("no component",))
case("5f-17", "actions: REQUEST_PERMISSION also on StarterActivity", m_action_on(STARTER, "%s.intent.action.REQUEST_PERMISSION" % APP_PKG), [(R_ACT, 1)])
case("5f-18", "actions: REQUEST_PERMISSION also on a component of :app", m_action_on(B_APP, "%s.intent.action.REQUEST_PERMISSION" % APP_PKG), [(R_ACT, 1)])
case("5f-19", "actions: REQUEST_AUTHORIZATION moved from LegacyIsNotSupportedActivity to RequestPermissionActivity", m_both(m_drop_filters(LEGACY_ACT), m_action_on(REQ_ACT, "%s.intent.action.REQUEST_AUTHORIZATION" % APP_PKG)), [(R_ACT, 1)])
case("5f-20", "actions: REQUEST_BINDER only on one of its two components (the receiver went back to a host-named action: missing + unknown)", m_set_action(SHIZUKU_RECV, REQ_BINDER, "%s.intent.action.NOTIFY" % APP_PKG), [(R_ACT, 2)])
case("5f-21", "actions: REQUEST_BINDER also on SettingsActivity, and an unknown custom action on the manager's service (two errors)", m_both(m_action_on(SETTINGS, REQ_BINDER), m_add_filter(SVC, filt("%s.intent.action.NOTIFY" % APP_PKG))), [(R_ACT, 2)], contains=("not one of the three expected ones",))
case("5f-22", "several faults at once: exactly the direct-boot and the custom-action rule fire", m_both_faults_5f, [(R_DB, 1), (R_ACT, 1)])
case("5f-23", "actions: package renamed but the host-following action kept the old host package (missing + unknown)", m_set_action(REQ_ACT, "%s.intent.action.REQUEST_PERMISSION" % OTHER_PKG, "%s.intent.action.REQUEST_PERMISSION" % APP_PKG), [(R_ACT, 2)], kw={"pkg": OTHER_PKG})
case("5f-24", "actions: no package attribute, any prefix is accepted for the two host-following actions", lambda r: r.attrib.pop("package"), notes=("no package attribute",))
case("5f-25", "actions: Shizuku not built in, a stray REQUEST_PERMISSION on :app is not judged", m_action_on(B_APP, "%s.intent.action.REQUEST_PERMISSION" % APP_PKG), kw={"shizuku": False}, state="absent")


# ---- x-NN: added by 4E-4c, for the parts the earlier lists did not name

case("x-01", "a Mika-only build (no manager component) with Mika's old provider: state absent, nothing runs", m_not_built_in_with_mika_provider, kw={"shizuku": False}, state="absent")
case("x-02", "two faults of different parts at once (4E-2 + 4E-3): exactly two rules fire", m_both(lambda r: setv(comp(r, PROV), "authorities", None), lambda r: drop_perm(r, "permission", API_V23)),
     [(R_AUTH, 1), (R_OWNER, 1), (R_ONCE, 1)])
case("x-03", "the package renamed AND Mika out: the good manifest still passes", kw={"pkg": OTHER_PKG, "mika": False}, notes=("Mika is not in the merged manifest",))
case("x-04", "a manager receiver with a priority AND the stale <queries> entry: only the boot rule fails, the entry stays a note", m_both(m_priority(B_MGR, "5"), q(PKG_ENTRY)), [(R_BOOT, 1)], notes=("allowed by the switch",), patch={"STALE_QUERY_ALLOWED": 1})


# ---------------------------------------------------------------- the other checks

def run_all_cases(selected):
    """-> list of (case, problems)."""
    return [(c, run_case(c)) for c in selected]


def check_coverage(failures):
    """Switch each rule off in turn; some case must then report "rule [id] did not fire" (a rule no case needs is a rule nobody tests)."""
    saved = list(cmm.RULES)
    try:
        for i, (rid, title, _fn) in enumerate(saved):
            cmm.RULES[:] = saved[:i] + [(rid, title, lambda m: [])] + saved[i + 1:]
            needle = "rule [%s] did not fire" % rid
            noticed = [c["id"] for c in CASES if needle in run_case(c)]
            cmm.RULES[:] = saved
            if not noticed:
                failures.append("COVERAGE: no case needs rule [%s]: switched off, no case reports that it did not fire. Add a bad case for it." % rid)
    finally:
        cmm.RULES[:] = saved
    return len(saved)


def check_registry(failures):
    saved = list(cmm.RULES)
    try:
        cmm.RULES[:] = []
        errs, _n, state = cmm.check(good(), False)
        if errs or state != "checked":
            failures.append("REGISTRY: the empty registry must pass (got %s, %s)" % (errs, state))
        with io.StringIO() as buf, contextlib.redirect_stdout(buf):
            path = os.path.join(tempfile.mkdtemp(prefix="shz-reg-"), "AndroidManifest.xml")
            ET.ElementTree(good()).write(path)
            code = cmm.main([path])
            out = buf.getvalue()
        if code != 0 or "SKELETON" not in out:
            failures.append("REGISTRY: with no rule the success line must say SKELETON (exit %s, output %r)" % (code, out))
        cmm.RULES[:] = [("T", "planted", lambda m: ["boom"])]
        errs, _n, state = cmm.check(good(), False)
        if errs != ["[T] boom"] or state != "failed":
            failures.append("REGISTRY: a planted rule must fail with '[T] boom' (got %s, %s)" % (errs, state))
    finally:
        cmm.RULES[:] = saved
    errs, _n, _s = cmm.check(good(), False)
    if errs:
        failures.append("REGISTRY: the registry was not restored: %s" % errs)
    with io.StringIO() as buf, contextlib.redirect_stdout(buf):
        path = os.path.join(tempfile.mkdtemp(prefix="shz-reg-"), "AndroidManifest.xml")
        ET.ElementTree(good()).write(path)
        cmm.main([path])
        out = buf.getvalue()
    if "SKELETON" in out:
        failures.append("REGISTRY: SKELETON shows although rules are registered")
    if ("%d rule(s) ran and passed" % len(cmm.RULES)) not in out:
        failures.append("REGISTRY: the success line does not say %d rule(s) ran and passed: %r" % (len(cmm.RULES), out))
    if not all(rid in out for rid, _t, _f in cmm.RULES):
        failures.append("REGISTRY: the 'rules that ran:' line does not list every rule id")
    return 6


def check_constants(failures):
    """The cases that depend on the switch of row 7A-1.2 set it themselves (patch=), so they do not care about its value. This check is the guard for the shipped value."""
    if cmm.STALE_QUERY_ALLOWED != EXPECTED_STALE_QUERY_ALLOWED:
        failures.append("CONSTANTS: STALE_QUERY_ALLOWED is %s in the checker, this self-test expects %s. If a row like 7A-1.2 (Mika's <queries> entry patched to the host package) did this on purpose, change "
                        "EXPECTED_STALE_QUERY_ALLOWED in this file in the same step; if not, the switch was changed by mistake." % (cmm.STALE_QUERY_ALLOWED, EXPECTED_STALE_QUERY_ALLOWED))
    return 1


HELPER_XML = """<manifest xmlns:android="%s" package="p.q">
<uses-permission android:name="A"/><uses-permission android:name="A"/><uses-permission-sdk-23 android:name="B"/>
<permission android:name="P" android:protectionLevel="signature" android:permissionGroup="G"/><permission android:name="P"/>
<uses-feature android:name="touch" android:required="false"/><uses-feature android:name="lean"/>
<queries><package android:name="x.y"/><package android:name="z"/></queries>
<application>
<activity android:name=".Rel" android:exported="true" android:directBootAware="true">
  <intent-filter android:priority="7"><action android:name="android.intent.action.MAIN"/><category android:name="android.intent.category.LAUNCHER"/></intent-filter>
  <intent-filter><action android:name="act.two"/></intent-filter></activity>
<activity android:name="moe.shizuku.manager.X" android:exported="false"/>
<service android:name="p.q.S" android:foregroundServiceType="dataSync|microphone"/>
<provider android:name="p.q.Pr" android:authorities=" a.one ; ;b.two"/>
</application></manifest>""" % NS


def check_helpers(failures):
    r = ET.fromstring(HELPER_XML)
    m = cmm.Merged(r)
    n = 0

    def expect(label, got, want):
        nonlocal n
        n += 1
        if got != want:
            failures.append("HELPERS: %s: got %r, expected %r" % (label, got, want))
    expect("package", m.package, "p.q")
    expect("requested permissions keep duplicates and include -sdk-23", sorted(m.requested_permissions()), ["A", "A", "B"])
    expect("declared permissions keep duplicates", m.declared_permissions(), ["P", "P"])
    expect("permission_elements", len(m.permission_elements("P")), 2)
    expect("uses_features", m.uses_features(), [("touch", "false"), ("lean", None)])
    expect("queries_packages", m.queries_packages(), ["x.y", "z"])
    expect("components by kind", sorted(c.name for c in m.components("activity")), [".Rel", "moe.shizuku.manager.X"])
    expect("manager_components", [c.name for c in m.manager_components()], ["moe.shizuku.manager.X"])
    expect("component() finds by exact name, None otherwise", (m.component("p.q.S") is not None, m.component("nope")), (True, None))
    rel = m.component(".Rel")
    expect("an unqualified component name stays as written", rel.name, ".Rel")
    expect("exported / directBootAware", (rel.exported, rel.direct_boot_aware), (True, True))
    expect("exported not written is None", m.component("p.q.S").exported, None)
    expect("actions over all filters", rel.actions(), {"android.intent.action.MAIN", "act.two"})
    expect("priority per filter", [f["priority"] for f in rel.intent_filters()], ["7", None])
    expect("is_launcher", (rel.is_launcher(), m.component("p.q.S").is_launcher()), (True, False))
    expect("has_category", rel.has_category("android.intent.category.LAUNCHER"), True)
    expect("several authorities, trimmed, empty ones dropped", m.component("p.q.Pr").authorities, ["a.one", "b.two"])
    expect("foregroundServiceType as written", m.component("p.q.S").foreground_service_type, "dataSync|microphone")
    expect("strings_with_context knows the element and the attribute", any(e.tag == "queries" or e.tag == "package" for e, a, v in m.strings_with_context() if v == "x.y"), True)
    expect("all_strings holds attribute values", "act.two" in m.all_strings(), True)
    expect("notes keep a text once", (m.add_note("t"), m.add_note("t"), m.notes)[2], ["t"])
    expect("expected_authority", cmm.expected_authority(m), "p.q.shizuku")
    expect("is_exported: not written, no filter = False; not written, filter = True", (cmm.is_exported(m.component("p.q.S")), cmm.is_exported(cmm.Component("activity", ET.fromstring('<activity xmlns:android="%s"><intent-filter/></activity>' % NS)))), (False, True))
    return n


def write(path, root_or_text):
    if isinstance(root_or_text, str):
        with open(path, "w", encoding="utf-8") as f:
            f.write(root_or_text)
    else:
        ET.ElementTree(root_or_text).write(path, encoding="utf-8", xml_declaration=True)


def run_main(argv):
    out, err = io.StringIO(), io.StringIO()
    with contextlib.redirect_stdout(out), contextlib.redirect_stderr(err):
        code = cmm.main(argv)
    return code, out.getvalue(), err.getvalue()


def check_cli(failures):
    n = [0]

    def expect(label, cond, detail=""):
        n[0] += 1
        if not cond:
            failures.append("CLI: %s%s" % (label, (": " + detail) if detail else ""))
    tmp = tempfile.mkdtemp(prefix="shz-cli-")
    good_p = os.path.join(tmp, "good.xml")
    write(good_p, good())
    bad_root = good()
    put_root(bad_root, '<uses-permission android:name="%s"/>' % API_V23)
    bad_p = os.path.join(tmp, "bad.xml")
    write(bad_p, bad_root)
    mika_root = good(shizuku=False)
    mika_p = os.path.join(tmp, "mika-only.xml")
    write(mika_p, mika_root)
    code, out, _ = run_main([good_p])
    expect("good file -> exit 0", code == 0, out)
    expect("good file: success line with the number of rules", ("%d rule(s) ran and passed" % len(cmm.RULES)) in out and "rules that ran:" in out, out)
    expect("good file: the last line points to the self-test and no longer promises row 5F", "test-check-merged-manifest.py" in out and "later: row 5F" not in out, out)
    code, out, _ = run_main([bad_p])
    lines = [x for x in out.splitlines() if x.startswith("::error::")]
    expect("bad file (API_V23 requested) -> exit 1, one ::error:: line", code == 1 and len(lines) == 1, out)
    expect("the error line names the rule and the permission", bool(lines) and "[4E-3 no API_V23 request]" in lines[0] and API_V23 in lines[0], out)
    code, out, _ = run_main([mika_p])
    expect("Mika-only file -> exit 0 and the 'not built in' line", code == 0 and "not built in" in out, out)
    code, out, _ = run_main([mika_p, "--require-shizuku"])
    expect("Mika-only file with --require-shizuku -> exit 1 and the present error", code == 1 and "[present]" in out, out)
    dup_root = good()
    setv(application(dup_root), "name", mgr("ShizukuApplication"))
    dup_p = os.path.join(tmp, "dup.xml")
    write(dup_p, dup_root)
    code, out, _ = run_main([dup_p])
    errs = [x for x in out.splitlines() if x.startswith("::error::")]
    expect("a string error is printed once (the duplicate of 4E-4b is fixed)", code == 1 and len(errs) == len(set(errs)) == 1, out)
    code, out, _ = run_main([os.path.join(tmp, "missing.xml")])
    expect("missing file -> exit 2", code == 2 and "::error::" in out, out)
    broken = os.path.join(tmp, "broken.xml")
    write(broken, "<manifest><application>")
    code, out, _ = run_main([broken])
    expect("broken XML -> exit 2, 'not valid XML'", code == 2 and "not valid XML" in out, out)
    wrong = os.path.join(tmp, "wrong.xml")
    write(wrong, "<resources/>")
    code, out, _ = run_main([wrong])
    expect("wrong root element -> exit 2", code == 2 and "expected <manifest>" in out, out)
    noapp = os.path.join(tmp, "noapp.xml")
    write(noapp, '<manifest xmlns:android="%s" package="x"/>' % NS)
    code, out, _ = run_main([noapp])
    expect("no <application> -> exit 2", code == 2 and "no <application>" in out, out)
    code, _o, _e = run_main([good_p, "--variant", "foo"])
    expect("--variant foo -> exit 2", code == 2)
    code, out, _e = run_main(["--help"])
    expect("--help -> exit 0", code == 0 and "--require-shizuku" in out)
    # the search under app/build/intermediates, like the workflows do it
    root = os.path.join(tmp, "proj")
    for variant, doc in (("release", good()), ("debug", bad_root)):
        d = os.path.join(root, "app", "build", "intermediates", "merged_manifests", variant, "process%sManifest" % variant.capitalize())
        os.makedirs(d)
        write(os.path.join(d, "AndroidManifest.xml"), doc)
    code, out, _ = run_main(["--root", root])
    expect("search: release found (default variant), good -> exit 0", code == 0 and "merged_manifests/release" in out.replace(os.sep, "/"), out)
    code, out, _ = run_main(["--root", root, "--variant", "debug"])
    expect("search: debug found, bad -> exit 1", code == 1, out)
    only_release = os.path.join(tmp, "proj2")
    d = os.path.join(only_release, "app", "build", "intermediates", "merged_manifests", "release", "processReleaseManifest")
    os.makedirs(d)
    write(os.path.join(d, "AndroidManifest.xml"), good())
    code, out, _ = run_main(["--root", only_release, "--variant", "debug"])
    expect("search: a missing variant -> exit 2 with 'run ./gradlew :app:assembleDebug first'", code == 2 and "assembleDebug" in out, out)
    code, out, _ = run_main(["--root", os.path.join(tmp, "nothing-here")])
    expect("search: no build folder -> exit 2 with 'run ./gradlew'", code == 2 and "./gradlew" in out and "does not exist" in out, out)
    # three runs as a real process, the way a workflow calls it
    py = [sys.executable, "-I", CHECKER]
    for label, args, want in (("good file", [good_p], 0), ("bad file", [bad_p], 1), ("missing file", [os.path.join(tmp, "missing.xml")], 2)):
        p = subprocess.run(py + args, capture_output=True, text=True, timeout=60)
        expect("as a process (python3 -I): %s -> exit %d" % (label, want), p.returncode == want, "exit %d, %s %s" % (p.returncode, p.stdout, p.stderr))
    return n[0]


def real_manifest(root, failures):
    """If a Gradle build exists, run the checker on its merged manifests. Returns a one-line report."""
    report = []
    for variant in ("release", "debug"):
        try:
            path = cmm.find_merged_manifest(os.path.abspath(root), variant)
        except cmm.SetupError:
            report.append("%s: none" % variant)
            continue
        try:
            doc = cmm.parse(path)
        except cmm.SetupError as e:
            failures.append("REAL: %s" % e)
            continue
        errors, notes, state = cmm.check(doc, False)
        for e in errors:
            failures.append("REAL %s manifest %s: %s" % (variant, path, e))
        report.append("%s: %s (%s)" % (variant, state, path))
    return "; ".join(report)


def main(argv=None):
    ap = argparse.ArgumentParser(description="Self-test of shizuku/tools/check-merged-manifest.py (row 4E-4c).")
    ap.add_argument("-v", "--verbose", action="store_true", help="print every case")
    ap.add_argument("-k", metavar="TEXT", help="run only the cases whose id or title contains TEXT")
    ap.add_argument("--list", action="store_true", help="print the id and title of every case")
    ap.add_argument("--dump-good", action="store_true", help="print the good merged manifest")
    ap.add_argument("--no-real", action="store_true", help="do not look for a real merged manifest")
    ap.add_argument("--root", default=ROOT, help="project root for the real-manifest step (default: %(default)s)")
    args = ap.parse_args(argv)
    ids = [c["id"] for c in CASES]
    dup = sorted({i for i in ids if ids.count(i) > 1})
    if dup:
        print("::error::%s: duplicate case ids: %s" % (TAG, ", ".join(dup)))
        return 1
    if args.dump_good:
        r = good()
        if hasattr(ET, "indent"):
            ET.indent(r, space="  ")
        print(ET.tostring(r, encoding="unicode"))
        return 0
    if args.list:
        for c in CASES:
            print("%-6s %s" % (c["id"], c["title"]))
        return 0
    selected = [c for c in CASES if not args.k or args.k in c["id"] or args.k in c["title"]]
    if not selected:
        print("::error::%s: no case matches %r" % (TAG, args.k))
        return 1
    failures = []
    results = run_all_cases(selected)
    groups = {}
    for c, problems in results:
        g = c["id"].split("-")[0]
        groups.setdefault(g, [0, 0])
        groups[g][0] += 1
        if problems:
            groups[g][1] += 1
            for p in problems:
                failures.append("case %s (%s): %s" % (c["id"], c["title"], p))
        elif args.verbose:
            print("ok   %-6s %s" % (c["id"], c["title"]))
    names = {"2": "4E-2", "3": "4E-3", "4a": "4E-4a", "4b": "4E-4b", "5f": "5F", "x": "4E-4c"}
    for g in ("2", "3", "4a", "4b", "5f", "x"):
        if g in groups:
            print("%-6s %2d cases, %d failed" % (names[g], groups[g][0], groups[g][1]))
    extra = ""
    if not args.k:
        nrules = check_coverage(failures)
        nreg = check_registry(failures)
        ncon = check_constants(failures)
        nhelp = check_helpers(failures)
        ncli = check_cli(failures)
        extra = "; coverage: switching off any of the %d rules breaks a case; registry %d checks; constants %d check; helpers %d checks; command line %d checks" % (nrules, nreg, ncon, nhelp, ncli)
        if not args.no_real:
            print("real merged manifest: " + real_manifest(args.root, failures))
    if failures:
        for f in failures:
            print("::error::%s: %s" % (TAG, f))
        print("self-test FAILED: %d problem(s)" % len(failures))
        return 1
    print("self-test ok: %d case(s)%s" % (len(selected), extra))
    return 0


if __name__ == "__main__":
    sys.exit(main())
