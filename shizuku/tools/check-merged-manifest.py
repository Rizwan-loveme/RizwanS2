#!/usr/bin/env python3
"""Shizuku step 4E-1: checks the MERGED manifest of :app for the pieces of the built-in Shizuku manager (:shizuku, package moe.shizuku.manager).

Usage:
  python3 shizuku/tools/check-merged-manifest.py [AndroidManifest.xml] [--variant release|debug] [--root DIR] [--require-shizuku]

  AndroidManifest.xml   the merged manifest to check. Without it the script looks for it itself, the same way the workflows do:
                        <root>/app/build/intermediates/**/merged_manifests/<variant>*/**/AndroidManifest.xml (AGP 8.x keeps it in .../merged_manifests/release/processReleaseManifest/)
  --variant             release (default) or debug: which merged manifest to look for
  --root DIR            project root (default: the folder two levels above this script)
  --require-shizuku     fail (exit 1) when the merged manifest has no component of moe.shizuku.manager at all. Without it such a manifest is reported as
                        "Shizuku is not built in (includeShizuku is off)" and passes. Since step 8F Shizuku is ON by default and the three workflows pass this option

Exit codes:
  0   every rule passed, or Shizuku is not in the build (and --require-shizuku was not given)
  1   at least one rule failed (one ::error:: line each), or --require-shizuku and no Shizuku component
  2   the script could not run: bad arguments, manifest not found ("run ./gradlew :app:assembleRelease first"), file is not XML, no <manifest> / <application>

4E-1 built the skeleton: argument parsing, finding and parsing the merged manifest, the helper classes (Merged / Component) and the rule registry. The rules are added one row at a
time, each with @rule(...) and nothing else to change. Rules so far:
  4E-2   provider and authority rules (below: authority, owner, old provider, provider guard)
  4E-3   permission rules (below: dynamic receiver, no API_V23 request, declared once, levels, manager request)
  4E-4a  component rules (below: inventory, exported, launcher, service, boot receivers)
  4E-4b  string rules (below: stale package, application class, old provider string)
  5F     direct-boot rule (finding 12) and custom-action rule (5D), both after the patch that makes them true (below: direct boot, custom actions)
  4E-4c  self-test: shizuku/tools/test-check-merged-manifest.py (a hand-made good manifest and a bad one for every rule, the command line, the registry; check() below is a pure function of
         the parsed root so the self-test can call it). Run it after every change of this file: `python3 -I shizuku/tools/test-check-merged-manifest.py`. A new rule needs a bad case there,
         the self-test fails ("no case needs rule ...") otherwise
  later  the manifest rules of 4F-1 live in check-gradle.py, a different file
Mika has its own checker (mika/tools/check-merged-manifest.py, it knows that Mika's provider may be replaced by the manager's); this one never reads Mika's files.

Needs only python3 (3.8+). Prints GitHub-style ::error:: / ::warning:: lines, like the other checkers of the project.
"""
import argparse
import os
import sys
import xml.etree.ElementTree as ET

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
A = "{http://schemas.android.com/apk/res/android}"
MANAGER_NS = "moe.shizuku.manager"           # the namespace of :shizuku; the merged manifest has fully qualified names
MANAGER_PROVIDER = MANAGER_NS + ".ShizukuManagerProvider"   # the one provider of the manager; owns the authority <applicationId>.shizuku
OLD_PROVIDER = "rikka.shizuku.ShizukuProvider"              # Mika's provider with the same authority; removed on purpose by app/src/shizuku/AndroidManifest.xml (4B)
AUTHORITY_SUFFIX = ".shizuku"
PERM_INTERACT = "android.permission.INTERACT_ACROSS_USERS_FULL"   # the manager's provider is exported but only callable with this system permission
PERM_MANAGER = MANAGER_NS + ".permission.MANAGER"            # signature; declared once by :shizuku; the host also REQUESTS it (the server then sends it the binder)
PERM_API_V23 = MANAGER_NS + ".permission.API_V23"            # dangerous, group PERM_GROUP; declared once by :shizuku; the host must NOT request it (it is the manager)
PERM_GROUP = MANAGER_NS + ".permission-group.API"
DYNAMIC_RECEIVER_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"   # AndroidX core declares <applicationId> + this; the manager manifest must not remove it (4C-1)
MIKA_NS = "com.wangzan101.mika"                                  # the namespace of :mika (names of its components are fully qualified under it)
MIKA_BOOT = MIKA_NS + ".setup.BootRestoreReceiver"               # Mika's BOOT_COMPLETED receiver (4D-3); only present when :mika is in the build
MANAGER_BOOT = MANAGER_NS + ".receiver.BootCompleteReceiver"     # the manager's boot receiver (4D-3)
APP_BOOT_SIMPLE = "BootReceiver"                                 # :app's own `.BootReceiver`; matched by its simple name (its package prefix is :app's namespace, which may differ from <applicationId>)
BOOT_ACTION = "android.intent.action.BOOT_COMPLETED"
LAUNCHER_CATEGORIES = ("android.intent.category.LAUNCHER", "android.intent.category.LEANBACK_LAUNCHER", "android.intent.category.HOME")
# What :shizuku contributes, read on the real v13.6.0 manifest in 4A (names relative to moe.shizuku.manager). The exported set is from 4A / 4D-1 / 4D-2.
MANAGER_EXPECTED = {
    "activity": ["MainActivity", "management.ApplicationManagementActivity", "adb.AdbPairingTutorialActivity", "shell.ShellTutorialActivity", "starter.StarterActivity",
                 "settings.SettingsActivity", "authorization.RequestPermissionActivity", "legacy.ShellRequestHandlerActivity", "legacy.LegacyIsNotSupportedActivity"],
    "activity-alias": [],
    "service": ["adb.AdbPairingService"],
    "receiver": ["receiver.BootCompleteReceiver", "receiver.ShizukuReceiver"],
    "provider": ["ShizukuManagerProvider"],
}
MANAGER_EXPORTED = ["authorization.RequestPermissionActivity", "legacy.ShellRequestHandlerActivity", "legacy.LegacyIsNotSupportedActivity",
                    "receiver.BootCompleteReceiver", "receiver.ShizukuReceiver", "ShizukuManagerProvider"]
SERVICE_TYPE = "shortService"                                    # 4D-2: AdbPairingService passes FOREGROUND_SERVICE_TYPE_MANIFEST, so this is the only type in play
STALE_PACKAGE = "moe.shizuku.privileged.api"                     # the package of the EXTERNAL Shizuku app; with the manager built in, the real package is the host's (finding 7)
STALE_QUERY_ALLOWED = 0                                          # 7A-1.2: no <queries><package> entry for it is allowed any more (7A-1.1 makes Mika's patch script write the host package there)
APPLICATION_CLASS = "ShizukuApplication"                         # upstream's Application class; the patch makes an object of it that :app calls (6E), so it is never an <application android:name>
BOOT_LOCKED_ACTION = "android.intent.action.LOCKED_BOOT_COMPLETED"   # 5F (finding 12): no component of the manager listens to it (the patch removes it from BootCompleteReceiver)
# 5F (5D): the custom actions of the manager. After the merge ${applicationId} is the real package. Suffix -> (does it follow the package, components that carry it: exactly these, each once).
ACTION_PERMISSION = ".intent.action.REQUEST_PERMISSION"
ACTION_AUTHORIZATION = ".intent.action.REQUEST_AUTHORIZATION"
ACTION_BINDER = "rikka.shizuku.intent.action.REQUEST_BINDER"      # a rikka name: stays as upstream has it (outside clients and the shell loader use it)
KINDS = ("activity", "activity-alias", "service", "receiver", "provider")
TAG = "Shizuku manifest"

EXIT_OK, EXIT_RULE, EXIT_SETUP = 0, 1, 2


class SetupError(Exception):
    """The script could not run (exit 2); not a rule failure."""


# ---------------------------------------------------------------- finding and parsing the merged manifest

def find_merged_manifest(root, variant):
    """Same idea as the workflows: find app/build/intermediates -path "*merged_manifests/<variant>*" -name AndroidManifest.xml. Deterministic: shortest path first."""
    base = os.path.join(root, "app", "build", "intermediates")
    if not os.path.isdir(base):
        raise SetupError("%s does not exist: there is no build output yet, run ./gradlew :app:assemble%s first (with -PincludeShizuku=true to have Shizuku in it)"
                         % (base, variant.capitalize()))
    hits = []
    needle = "merged_manifests/" + variant
    for d, _dirs, files in os.walk(base):
        if "AndroidManifest.xml" in files:
            p = os.path.join(d, "AndroidManifest.xml")
            if needle in p.replace(os.sep, "/"):
                hits.append(p)
    if not hits:
        raise SetupError("no merged %s manifest under %s: run ./gradlew :app:assemble%s first" % (variant, base, variant.capitalize()))
    return sorted(hits, key=lambda p: (len(p), p))[0]


def parse(path):
    """Parse the file; returns the <manifest> element. Raises SetupError for a missing file, non-XML, wrong root, no <application>."""
    if not os.path.isfile(path):
        raise SetupError("%s not found (run ./gradlew :app:assembleRelease first, or pass the path of a merged AndroidManifest.xml)" % path)
    try:
        root = ET.parse(path).getroot()
    except ET.ParseError as e:
        raise SetupError("%s is not valid XML: %s" % (path, e))
    if root.tag != "manifest":
        raise SetupError("%s: the root element is <%s>, expected <manifest>" % (path, root.tag))
    if root.find("application") is None:
        raise SetupError("%s has no <application>: this is not a merged application manifest" % path)
    return root


# ---------------------------------------------------------------- helper classes the rules use

class Component:
    """One activity / activity-alias / service / receiver / provider of the merged manifest."""

    def __init__(self, kind, element):
        self.kind = kind
        self.el = element
        self.name = element.get(A + "name") or ""

    def attr(self, name, default=None):
        """android:<name> as a string, or default."""
        v = self.el.get(A + name)
        return default if v is None else v

    def flag(self, name):
        """android:<name> as True / False, or None when it is not written."""
        v = self.el.get(A + name)
        if v is None:
            return None
        return v.strip().lower() == "true"

    @property
    def exported(self):
        return self.flag("exported")

    @property
    def direct_boot_aware(self):
        return self.flag("directBootAware")

    @property
    def authorities(self):
        return [a.strip() for a in (self.attr("authorities") or "").split(";") if a.strip()]

    @property
    def foreground_service_type(self):
        """The manifest value as written, e.g. 'shortService' or 'dataSync|microphone'; None when absent."""
        return self.attr("foregroundServiceType")

    def intent_filters(self):
        """List of dicts: actions, categories (sets of names), priority (the android:priority string or None)."""
        out = []
        for f in self.el.findall("intent-filter"):
            out.append({
                "actions": {a.get(A + "name") for a in f.findall("action")},
                "categories": {c.get(A + "name") for c in f.findall("category")},
                "priority": f.get(A + "priority"),
            })
        return out

    def actions(self):
        return set().union(*[f["actions"] for f in self.intent_filters()]) if self.el.findall("intent-filter") else set()

    def has_category(self, category):
        return any(category in f["categories"] for f in self.intent_filters())

    def is_launcher(self):
        """A MAIN action together with the LAUNCHER category in one filter."""
        return any("android.intent.action.MAIN" in f["actions"] and "android.intent.category.LAUNCHER" in f["categories"] for f in self.intent_filters())

    def __repr__(self):
        return "<%s %s>" % (self.kind, self.name)


class Merged:
    """The merged manifest as the rules see it. Names in a merged manifest are fully qualified, so no namespace resolving is needed."""

    def __init__(self, root):
        self.root = root
        self.app = root.find("application")
        self.notes = []          # a rule may add a note (printed, never an error)

    @property
    def package(self):
        """The package of the merged manifest (= applicationId, e.g. com.srizwan.win11); None when the file has no package attribute."""
        return self.root.get("package") or None

    def components(self, kind=None, prefix=None):
        out = []
        for k in KINDS:
            if kind is not None and k != kind:
                continue
            for e in self.app.findall(k):
                c = Component(k, e)
                if prefix is None or c.name.startswith(prefix):
                    out.append(c)
        return out

    def component(self, name):
        for c in self.components():
            if c.name == name:
                return c
        return None

    def manager_components(self, kind=None):
        """The components of :shizuku (names under moe.shizuku.manager.)."""
        return self.components(kind, MANAGER_NS + ".")

    def requested_permissions(self):
        """Names of every <uses-permission> / <uses-permission-sdk-23>, as a list (duplicates kept, so a rule can count)."""
        return [e.get(A + "name") for tag in ("uses-permission", "uses-permission-sdk-23") for e in self.root.findall(tag)]

    def declared_permissions(self):
        """Names of every <permission> declared at manifest level, as a list (duplicates kept)."""
        return [e.get(A + "name") for e in self.root.findall("permission")]

    def permission_elements(self, name):
        """Every <permission> element of that exact name (duplicates kept), so a rule can read protectionLevel / permissionGroup."""
        return [e for e in self.root.findall("permission") if e.get(A + "name") == name]

    def add_note(self, text):
        """A note is printed, never an error; the same text is kept once."""
        if text not in self.notes:
            self.notes.append(text)

    def uses_features(self):
        return [(e.get(A + "name"), e.get(A + "required")) for e in self.root.findall("uses-feature")]

    def queries_packages(self):
        """Package names inside <queries>."""
        out = []
        q = self.root.find("queries")
        if q is not None:
            out = [p.get(A + "name") for p in q.findall("package")]
        return out

    def strings_with_context(self):
        """Every attribute value and text of the file as (element, attribute name or '#text', value): the string rules of 4E-4b need to know where a string sits."""
        out = []
        for e in self.root.iter():
            for k, v in e.attrib.items():
                out.append((e, k.split("}")[-1], v))
            if e.text and e.text.strip():
                out.append((e, "#text", e.text.strip()))
        return out

    def all_strings(self):
        """Every attribute value and text in the file (for the string rules of 4E-4b)."""
        out = []
        for e in self.root.iter():
            out.extend(e.attrib.values())
            if e.text and e.text.strip():
                out.append(e.text.strip())
        return out


# ---------------------------------------------------------------- rule registry

RULES = []   # (id, title, function); a function takes a Merged and returns a list of error strings (empty = pass)


def rule(rule_id, title):
    """Decorator: @rule("4E-2", "one provider owns the authority") on def fn(m: Merged) -> list[str]."""
    def deco(fn):
        RULES.append((rule_id, title, fn))
        return fn
    return deco


# -- rules go here, one block per row of the plan (4E-2, 4E-3, 4E-4a and 4E-4b below; later 5F) -------------------------------------------------------------------------

# -- 4E-2: provider and authority rules (finding 1 of 4A, mechanism of 4B) -----------------------------------------------------------------------------------------------------

def expected_authority(m):
    """<applicationId>.shizuku. The package attribute of the merged manifest is the applicationId (the CI may rename it, so it is read, not written here).
    Without a package attribute the exact name is unknown: None (the rules then only demand the .shizuku ending and add a note)."""
    return (m.package + AUTHORITY_SUFFIX) if m.package else None


def authority_owners(m):
    """{authority: [provider names]}: every authority of every provider of the merged manifest, one entry per use (a provider that lists it twice appears twice)."""
    owners = {}
    for c in m.components("provider"):
        for a in c.authorities:
            owners.setdefault(a, []).append(c.name)
    return owners


@rule("4E-2 authority", "the authority <applicationId>.shizuku is used exactly once, by the manager's provider")
def rule_authority(m):
    errs = []
    want = expected_authority(m)
    owners = authority_owners(m)
    if want is None:
        m.notes.append("the merged manifest has no package attribute: the authority is checked only for the %s ending, not for <applicationId>%s" % (AUTHORITY_SUFFIX, AUTHORITY_SUFFIX))
        shiz = {a: o for a, o in owners.items() if a.endswith(AUTHORITY_SUFFIX)}
    else:
        shiz = {a: o for a, o in owners.items() if a == want}
        if want not in owners:
            errs.append("authority %s is not declared by any provider (the manager's %s lost it)" % (want, MANAGER_PROVIDER))
    for a, o in sorted(shiz.items()):
        if len(o) > 1:
            errs.append("authority %s is used %d times (%s): two providers with one authority = INSTALL_FAILED_CONFLICTING_PROVIDER" % (a, len(o), ", ".join(sorted(o))))
        elif o != [MANAGER_PROVIDER]:
            errs.append("authority %s is owned by %s, expected only %s" % (a, ", ".join(sorted(set(o))), MANAGER_PROVIDER))
    if want is None and not shiz:
        errs.append("no provider has an authority ending in %s (expected %s)" % (AUTHORITY_SUFFIX, MANAGER_PROVIDER))
    for c in m.components("provider"):
        for a in c.authorities:
            if "${" in a:
                errs.append("provider %s: authority %s still has an unresolved placeholder" % (c.name, a))
    return errs


@rule("4E-2 owner", "the manager's provider exists once and has no other authority")
def rule_owner(m):
    errs = []
    provs = [c for c in m.components("provider") if c.name == MANAGER_PROVIDER]
    if not provs:
        return ["provider %s is not in the merged manifest" % MANAGER_PROVIDER]
    if len(provs) > 1:
        errs.append("provider %s is declared %d times" % (MANAGER_PROVIDER, len(provs)))
    want = expected_authority(m)
    for c in provs:
        auths = c.authorities
        if want is not None and auths != [want]:
            errs.append("provider %s has the authorities %s, expected exactly [%s]" % (c.name, auths or "none", want))
        elif want is None and not any(a.endswith(AUTHORITY_SUFFIX) for a in auths):
            errs.append("provider %s has the authorities %s, none ends in %s" % (c.name, auths or "none", AUTHORITY_SUFFIX))
    return errs


@rule("4E-2 old provider", "Mika's rikka.shizuku.ShizukuProvider is gone (the overlay removed it)")
def rule_old_provider(m):
    return ["%s %s is still in the merged manifest: the overlay app/src/shizuku/AndroidManifest.xml did not remove it (4B), "
            "it would share the authority with the manager's provider" % (c.kind, c.name) for c in m.components() if c.name == OLD_PROVIDER]


@rule("4E-2 provider guard", "the manager's provider is exported, behind INTERACT_ACROSS_USERS_FULL, not multiprocess")
def rule_provider_guard(m):
    errs = []
    for c in m.components("provider"):
        if c.name != MANAGER_PROVIDER:
            continue
        if c.exported is not True:
            errs.append("provider %s: android:exported is %s, expected true (clients reach the binder through it)" % (c.name, c.attr("exported")))
        if c.attr("permission") != PERM_INTERACT:
            errs.append("provider %s: android:permission is %s, expected %s (without it any app could call the provider)" % (c.name, c.attr("permission"), PERM_INTERACT))
        if c.flag("multiprocess"):
            errs.append("provider %s: android:multiprocess is true, expected false (as upstream)" % c.name)
    return errs


# -- 4E-3: permission rules (findings 2, 3 and 4 of 4A; mechanism of 4C-1 ... 4C-3) ---------------------------------------------------------------------------------------------

def names_ending(names, suffix):
    return [n for n in names if n and n.endswith(suffix)]


@rule("4E-3 dynamic receiver", "AndroidX's <applicationId>.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION is still declared (once) and requested")
def rule_dynamic_receiver(m):
    """Finding 2: the manager manifest used to remove it for the whole app (4C-1 dropped the markers). AndroidX core brings both the <permission> and the <uses-permission>;
    without the request ContextCompat.registerReceiver(..., RECEIVER_NOT_EXPORTED) throws on Android 8 - 12 (minSdk 26), in code that has nothing to do with Shizuku."""
    errs = []
    declared, requested = m.declared_permissions(), m.requested_permissions()
    if m.package:
        want = m.package + DYNAMIC_RECEIVER_SUFFIX
        decl = [n for n in declared if n == want]
        req = [n for n in requested if n == want]
    else:
        want = "<applicationId>" + DYNAMIC_RECEIVER_SUFFIX
        decl, req = names_ending(declared, DYNAMIC_RECEIVER_SUFFIX), names_ending(requested, DYNAMIC_RECEIVER_SUFFIX)
        m.add_note("the merged manifest has no package attribute: the permission names of rows 4E-3 are matched by their ending, not by <applicationId>")
    if not decl:
        errs.append("permission %s is not declared: a remove marker (the old manager manifest of finding 2) took it away from the whole app" % want)
    elif len(decl) > 1:
        errs.append("permission %s is declared %d times" % (want, len(decl)))
    if not req:
        errs.append("permission %s is not requested (<uses-permission>): ContextCompat.registerReceiver(..., RECEIVER_NOT_EXPORTED) throws on Android 8 - 12" % want)
    for n in declared + requested:
        if n and DYNAMIC_RECEIVER_SUFFIX in n and "${" in n:
            errs.append("permission %s still has an unresolved placeholder" % n)
    return errs


@rule("4E-3 no API_V23 request", "the host does not request moe.shizuku.manager.permission.API_V23")
def rule_no_api_v23_request(m):
    """Finding 3: the host is the manager; the server treats the manager's own app id as always allowed. The manager manifest keeps `uses-permission API_V23 tools:node="remove"` as a guard
    (4C-3); :shizuku-provider's own manifest (which asks for it) is not merged (shizukuIgnored = manifest). If a request shows up, one of the two stopped working."""
    n = sum(1 for p in m.requested_permissions() if p == PERM_API_V23)
    if not n:
        return []
    return ["%s is requested (%d <uses-permission> element(s)): the host is the manager and must not ask for it; the guard in the manager manifest or "
            "shizukuIgnored on :shizuku-provider no longer keeps it out (finding 3)" % (PERM_API_V23, n)]


@rule("4E-3 declared once", "MANAGER and API_V23 are each declared exactly once")
def rule_declared_once(m):
    """Finding 4: both are declared only by :shizuku (Mika declares neither); the names are kept on purpose, every Shizuku client and the server's BinderSender use them."""
    errs = []
    declared = m.declared_permissions()
    for name in (PERM_MANAGER, PERM_API_V23):
        n = declared.count(name)
        if n == 0:
            errs.append("permission %s is not declared (clients and the server's BinderSender use this exact name)" % name)
        elif n > 1:
            errs.append("permission %s is declared %d times (only :shizuku may declare it)" % (name, n))
    return errs


@rule("4E-3 levels", "MANAGER is signature; API_V23 is dangerous and in the group moe.shizuku.manager.permission-group.API")
def rule_levels(m):
    """Added beyond the row text, from finding 4 (the levels read on the real v13.6.0 manifest): a wrong level changes who may get the permission."""
    errs = []

    def level(e):
        return {x.strip() for x in (e.get(A + "protectionLevel") or "").split("|") if x.strip()}
    for e in m.permission_elements(PERM_MANAGER):
        if level(e) != {"signature"}:
            errs.append("permission %s has protectionLevel %s, expected signature" % (PERM_MANAGER, e.get(A + "protectionLevel")))
    for e in m.permission_elements(PERM_API_V23):
        if level(e) != {"dangerous"}:
            errs.append("permission %s has protectionLevel %s, expected dangerous" % (PERM_API_V23, e.get(A + "protectionLevel")))
        if e.get(A + "permissionGroup") != PERM_GROUP:
            errs.append("permission %s has permissionGroup %s, expected %s" % (PERM_API_V23, e.get(A + "permissionGroup"), PERM_GROUP))
    return errs


@rule("4E-3 manager request", "the host requests moe.shizuku.manager.permission.MANAGER exactly once")
def rule_manager_request(m):
    """Added beyond the row text, from point 4 of 4C-3: the request comes from the uses-permission of the manager manifest; it is what lets the server send the manager the binder."""
    n = sum(1 for p in m.requested_permissions() if p == PERM_MANAGER)
    if n == 1:
        return []
    if n == 0:
        return ["%s is not requested: the server cannot send the manager the binder (the <uses-permission> of the manager manifest got lost)" % PERM_MANAGER]
    return ["%s is requested %d times" % (PERM_MANAGER, n)]

# -- 4E-4a: component rules (findings 6, 8, 9 and the BOOT_COMPLETED order of 4D-1 ... 4D-3) -----------------------------------------------------------------------------------

def full(rel):
    return MANAGER_NS + "." + rel


def is_exported(c):
    """android:exported as written; when it is not written, the Android default: exported only if the component has an intent filter (at targetSdk 31+ the build refuses that, so
    in a merged manifest a component without the attribute is a component without a filter)."""
    f = c.exported
    return f if f is not None else bool(c.el.findall("intent-filter"))


def mika_present(m):
    return bool(m.components(prefix=MIKA_NS + "."))


@rule("4E-4a inventory", "exactly the 9 activities, 1 service, 2 receivers and 1 provider of moe.shizuku.manager, each once, no activity-alias")
def rule_inventory(m):
    """4A: the components of :shizuku (names read on the real v13.6.0 manifest; the other ten Shizuku modules add none). Compares names, so a swapped or renamed component is found, not only a wrong count."""
    errs = []
    plural = {"activity": "activities", "activity-alias": "activity-aliases"}
    found = {}
    for c in m.manager_components():
        found.setdefault(c.kind, []).append(c.name)
    for kind, rels in MANAGER_EXPECTED.items():
        want = [full(r) for r in rels]
        got = found.get(kind, [])
        missing = [n for n in want if n not in got]
        extra = sorted({n for n in got if n not in want})
        dupes = sorted({n for n in got if got.count(n) > 1})
        if missing or extra or dupes:
            msg = "%d %s expected, %d found" % (len(want), plural.get(kind, kind + "s"), len(got))
            if missing:
                msg += "; missing: " + ", ".join(missing)
            if extra:
                msg += "; unexpected: " + ", ".join(extra)
            if dupes:
                msg += "; declared more than once: " + ", ".join(dupes)
            errs.append(msg)
    return errs


@rule("4E-4a exported", "of the manager's components exactly the three activities, the two receivers and the provider of 4A are exported")
def rule_exported(m):
    """4A / 4D-1: RequestPermissionActivity (behind INTERACT_ACROSS_USERS_FULL), ShellRequestHandlerActivity and LegacyIsNotSupportedActivity are exported on purpose; the other six activities and
    the service are not. The two receivers and the provider are exported (the provider's guard is rule '4E-2 provider guard'). A component that is not in the expected list counts as 'must not be exported'."""
    errs = []
    want = {full(r) for r in MANAGER_EXPORTED}
    for c in m.manager_components():
        exp = is_exported(c)
        if c.name in want and not exp:
            errs.append("%s %s is not exported, expected exported (clients reach it)" % (c.kind, c.name))
        elif c.name not in want and exp:
            errs.append("%s %s is exported (android:exported is %s), expected not exported: only the three activities, the two receivers and the provider are" % (c.kind, c.name, c.attr("exported") or "not written, but it has an intent filter"))
    return errs


@rule("4E-4a launcher", "no component of moe.shizuku.manager has a LAUNCHER (or LEANBACK_LAUNCHER / HOME) category: the Start menu opens it")
def rule_launcher(m):
    """The manager has no launcher icon of its own: it is opened from the Start menu (step 6). A MAIN + LAUNCHER filter would put a second app icon in the app drawer;
    HOME would make it a launcher candidate (the HOME and LEANBACK_LAUNCHER cases are beyond the row text)."""
    errs = []
    for c in m.manager_components():
        for cat in LAUNCHER_CATEGORIES:
            if c.has_category(cat):
                errs.append("%s %s has an intent filter with the category %s (the manager must not show up as an app or a launcher)" % (c.kind, c.name, cat))
    return errs


@rule("4E-4a service", "AdbPairingService is not exported and its foregroundServiceType is exactly shortService")
def rule_service(m):
    """4D-2 / finding 6: the service passes FOREGROUND_SERVICE_TYPE_MANIFEST, so the manifest type is the only type in play. 'shortService' needs only FOREGROUND_SERVICE, which every module declares.
    Any other value (or a combination such as dataSync|shortService, which Android would not treat as a short service) changes which permission and which time limit apply."""
    svc = [c for c in m.components("service") if c.name == full("adb.AdbPairingService")]
    if not svc:
        return []          # a missing service is the inventory rule's finding
    errs = []
    for c in svc:
        if is_exported(c):
            errs.append("service %s is exported, expected not exported (only the tutorial activity starts it)" % c.name)
        if c.foreground_service_type != SERVICE_TYPE:
            errs.append("service %s has foregroundServiceType %s, expected exactly %s (4D-2)" % (c.name, c.foreground_service_type, SERVICE_TYPE))
    return errs


@rule("4E-4a boot receivers", "exactly three receivers listen to BOOT_COMPLETED (:app, Mika, the manager), none of their filters sets a priority")
def rule_boot_receivers(m):
    """4D-3: three receivers get BOOT_COMPLETED: :app's .BootReceiver (matched by its simple name), Mika's .setup.BootRestoreReceiver and the manager's receiver.BootCompleteReceiver. They all run, the order
    is not defined and nothing depends on it, as long as nobody sets a priority or consumes the broadcast. When Mika is not in the build (-PincludeMika=false) two are expected and a note says so.
    LOCKED_BOOT_COMPLETED listeners are not counted. The direct-boot rule (finding 12) is not here: it comes with row 5F."""
    errs = []
    listeners = [c for c in m.components() if BOOT_ACTION in c.actions()]
    mika = mika_present(m)
    if not mika:
        m.add_note("Mika is not in the merged manifest (no component of %s): two BOOT_COMPLETED receivers are expected (:app and the manager), not three" % MIKA_NS)
    app_l = [c for c in listeners if c.name.endswith("." + APP_BOOT_SIMPLE) and not c.name.startswith((MANAGER_NS + ".", MIKA_NS + "."))]
    mika_l = [c for c in listeners if c.name == MIKA_BOOT]
    man_l = [c for c in listeners if c.name == MANAGER_BOOT]
    known = app_l + mika_l + man_l
    other = [c for c in listeners if c not in known]
    for label, got, name, need in (("%s (:app)" % APP_BOOT_SIMPLE, app_l, "<package>.%s" % APP_BOOT_SIMPLE, 1), ("Mika's %s" % MIKA_BOOT, mika_l, MIKA_BOOT, 1 if mika else 0),
                                   ("the manager's %s" % MANAGER_BOOT, man_l, MANAGER_BOOT, 1)):
        if len(got) != need:
            errs.append("%d receiver(s) of %s listen to %s, expected %d" % (len(got), label, BOOT_ACTION.rsplit(".", 1)[-1], need))
    for c in other:
        errs.append("%s %s listens to BOOT_COMPLETED, but it is not one of the expected receivers (:app's %s, Mika's, the manager's): a fourth listener" % (c.kind, c.name, APP_BOOT_SIMPLE))
    for c in known:
        if c.kind != "receiver":
            errs.append("%s %s listens to BOOT_COMPLETED, expected a receiver" % (c.kind, c.name))
    for c in known + other:
        for f in c.intent_filters():
            if f["priority"] is not None:
                errs.append("%s %s has an intent filter with android:priority=%s: the three boot receivers must not depend on an order (4D-3)" % (c.kind, c.name, f["priority"]))
    return errs

# -- 4E-4b: string rules (finding 7 of 4A; the 4D-4 decision that :app keeps its own Application; the provider removal of 4B) ---------------------------------------------------

def where(e, attr):
    """Short place of a string for a message: '<tag attr>' (or the element's android:name when it has one)."""
    nm = e.get(A + "name")
    return "<%s%s> %s" % (e.tag, (" " + nm) if nm else "", ("text" if attr == "#text" else "attribute " + attr))


@rule("4E-4b stale package", "moe.shizuku.privileged.api appears nowhere (Mika's <queries> entry is patched to the host package by row 7A-1.1)")
def rule_stale_package(m):
    """Finding 7: that is the package of the EXTERNAL Shizuku app. With the manager built in, the real package is the host's, so the string must not survive in an action, a permission, an authority,
    a meta-data value or anywhere else (the manager's own actions follow the host package, 4A). Mika's <queries><package android:name="moe.shizuku.privileged.api"/> was the one known leftover: 7A-1.1 makes
    Mika's patch script write ${applicationId} there when the manager is built in, and since 7A-1.2 nothing is allowed (STALE_QUERY_ALLOWED = 0), so the entry fails like any other stale string.
    The switch stays a constant: the code below still handles a value above 0. Only the exact name in a <queries><package> counts as that entry."""
    errs = []
    entries = [e for q in m.root.findall("queries") for e in q.findall("package") if e.get(A + "name") == STALE_PACKAGE]
    allowed = {id(e) for e in entries[:STALE_QUERY_ALLOWED]}
    if len(entries) > STALE_QUERY_ALLOWED:
        errs.append("%d <queries><package %s> entries, at most %d allowed (7A-1.1 writes the host package into Mika's entry)" % (len(entries), STALE_PACKAGE, STALE_QUERY_ALLOWED))
    for e, attr, v in m.strings_with_context():
        if STALE_PACKAGE in v:
            if id(e) in allowed and attr == "name" and v == STALE_PACKAGE:
                continue
            if e in entries and attr == "name" and v == STALE_PACKAGE:
                continue            # an extra entry is already reported above
            errs.append("%s holds %s: the package of the external Shizuku app is stale now that the manager is built in (finding 7)" % (where(e, attr), v if len(v) <= 90 else v[:87] + "..."))
    if entries and STALE_QUERY_ALLOWED:
        m.add_note("the <queries> entry for %s is still there: allowed by the switch STALE_QUERY_ALLOWED" % STALE_PACKAGE)
    return errs


@rule("4E-4b application class", "ShizukuApplication is not in the manifest: no <application android:name> of the manager, no string with that class name")
def rule_application_class(m):
    """4D-4: the manager's upstream Application class is turned into an object by the patch script and called from :app's own Application (row 6E), so the merged <application> keeps :app's class.
    If the manager's class (or any string with 'ShizukuApplication') shows up, the host would start with the wrong Application and :app's App.onCreate (log, themes, Seal, Mika) would never run."""
    errs = []
    nm = m.app.get(A + "name")
    if nm and nm.startswith(MANAGER_NS + "."):
        errs.append("<application> has android:name %s: the host must keep its own Application class (4D-4)" % nm)
    for e, attr, v in m.strings_with_context():
        if APPLICATION_CLASS in v:
            if e is m.app and attr == "name" and v == nm and nm.startswith(MANAGER_NS + "."):
                continue            # already reported above
            errs.append("%s holds %s: %s must not be referenced by the manifest (4D-4)" % (where(e, attr), v, APPLICATION_CLASS))
    return errs


@rule("4E-4b old provider string", "rikka.shizuku.ShizukuProvider appears in no string of the manifest")
def rule_old_provider_string(m):
    """Mika's provider was removed on purpose by the 4B overlay. Rule '4E-2 old provider' looks at components; this one looks at every other place (a meta-data value, a leftover marker, a
    comment-like text). A component named exactly that is left to 4E-2 and not reported twice."""
    errs = []
    for e, attr, v in m.strings_with_context():
        if OLD_PROVIDER in v:
            if attr == "name" and v == OLD_PROVIDER and e.tag in KINDS:
                continue
            errs.append("%s holds %s: Mika's provider was removed on purpose (4B), it must not be referenced any more" % (where(e, attr), v if len(v) <= 90 else v[:87] + "..."))
    return errs



# -- 5F: direct boot (finding 12) and custom actions (5D) -----------------------------------------------------------------------------------------------------------------------------

@rule("5F direct boot", "no component of moe.shizuku.manager is directBootAware or listens to LOCKED_BOOT_COMPLETED")
def rule_direct_boot(m):
    """Finding 12, decided in 4D-4 as option (a+): upstream's BootCompleteReceiver, ShizukuReceiver and ShizukuManagerProvider are directBootAware, and the receiver takes LOCKED_BOOT_COMPLETED. In the host
    that would start the main process (App.onCreate with Seal, Mika, the log) before the first unlock. The patch of row 5F (part G of patch-upstream.py) removes the flag and the action, so the merged
    manifest must show neither on any manager component (android:directBootAware="false" is fine; any other value counts as set). Components of :app and Mika are not judged here: they were never
    directBootAware, and other libraries (WorkManager, profile install) may set the flag on their own components for their own reasons."""
    errs = []
    for c in m.manager_components():
        v = c.attr("directBootAware")
        if v is not None and v.strip().lower() != "false":
            errs.append("%s %s is android:directBootAware=\"%s\": the host process must not start before the first unlock because of Shizuku (finding 12)" % (c.kind, c.name, v))
        if BOOT_LOCKED_ACTION in c.actions():
            errs.append("%s %s listens to %s: the manager's boot start runs after the first unlock only (finding 12)" % (c.kind, c.name, BOOT_LOCKED_ACTION.rsplit(".", 1)[-1]))
    return errs


@rule("5F custom actions", "the custom intent actions sit only on their components: REQUEST_PERMISSION, REQUEST_AUTHORIZATION (host package), REQUEST_BINDER (rikka); no other custom action from the manager")
def rule_custom_actions(m):
    """5D. After the merge ${applicationId} is the real package, so: <package>.intent.action.REQUEST_PERMISSION only on authorization.RequestPermissionActivity, <package>.intent.action.REQUEST_AUTHORIZATION
    only on legacy.LegacyIsNotSupportedActivity, rikka.shizuku.intent.action.REQUEST_BINDER only on legacy.ShellRequestHandlerActivity and receiver.ShizukuReceiver (each action on each component exactly
    once or the set of components differs). The first two are looked at on ALL components (a copy in :app or Mika would make the system pick between two receivers), the last one too. Any other action
    that is not an android.* system action and sits on a component of moe.shizuku.manager is unknown: decide whether it follows the host, then add it here. The old package in an action is also found by
    '4E-4b stale package'; without a package attribute (no package to compare with) any prefix is accepted for the first two."""
    pkg = m.package
    want = [   # (action, label, components that carry it); action None = no package attribute, compared by suffix
        ((pkg + ACTION_PERMISSION) if pkg else None, "permission", [full("authorization.RequestPermissionActivity")]),
        ((pkg + ACTION_AUTHORIZATION) if pkg else None, "authorization", [full("legacy.LegacyIsNotSupportedActivity")]),
        (ACTION_BINDER, "binder", [full("legacy.ShellRequestHandlerActivity"), full("receiver.ShizukuReceiver")]),
    ]
    errs = []
    holders = {}                                     # action -> list of component names (one entry per filter occurrence)
    for c in m.components():
        for f in c.intent_filters():
            for a in f["actions"]:
                holders.setdefault(a, []).append(c)
    known = set()
    for act, label, comps in want:
        if act is None:                              # no package attribute: compare by suffix
            suffix = ACTION_PERMISSION if label == "permission" else ACTION_AUTHORIZATION
            hits = sorted(c.name for a, cs in holders.items() if a and a.endswith(suffix) for c in cs)
            known |= {a for a in holders if a and a.endswith(suffix)}
            shown = "*" + suffix
        else:
            hits = sorted(c.name for c in holders.get(act, []))
            known.add(act)
            shown = act
        if hits != sorted(comps):
            errs.append("action %s is on %s, expected exactly %s" % (shown, hits or "no component", sorted(comps)))
    for a, cs in sorted(holders.items()):
        if a is None or a.startswith("android.") or a in known:
            continue
        for c in cs:
            if c.name.startswith(MANAGER_NS + "."):
                errs.append("%s %s has the custom action %s, which is not one of the three expected ones: decide whether it follows the host package (5D), then add it to this rule" % (c.kind, c.name, a))
    return errs


def shizuku_present(m):
    return bool(m.manager_components())


def check(root, require_shizuku=False):
    """Pure function of the parsed <manifest> element (the self-test of 4E-4c calls it). Returns (errors, notes, state).
    state is 'absent' (no moe.shizuku.manager component: Shizuku not built in), 'checked' (rules ran) or 'failed'."""
    m = Merged(root)
    errors, notes = [], []
    if not shizuku_present(m):
        if require_shizuku:
            errors.append("[present] --require-shizuku: the merged manifest has no component of %s (was the build made with -PincludeShizuku=true?)" % MANAGER_NS)
            return errors, notes, "failed"
        notes.append("Shizuku is not built in (no component of %s in the merged manifest; includeShizuku is off): nothing to check" % MANAGER_NS)
        return errors, notes, "absent"
    for rid, title, fn in RULES:
        for msg in fn(m):
            errors.append("[%s] %s" % (rid, msg))
    notes.extend(m.notes)
    return errors, notes, "failed" if errors else "checked"


def summary(m):
    kinds = {}
    for c in m.manager_components():
        kinds[c.kind] = kinds.get(c.kind, 0) + 1
    plural = {"activity": "activities", "activity-alias": "activity-aliases"}
    return ", ".join("%d %s" % (v, k if v == 1 else plural.get(k, k + "s")) for k, v in sorted(kinds.items()))


# ---------------------------------------------------------------- command line

def main(argv=None):
    ap = argparse.ArgumentParser(description="Checks the merged manifest of :app for the built-in Shizuku manager (rows 4E-1 ... 4E-4b and 5F; the self-test of row 4E-4c is test-check-merged-manifest.py).")
    ap.add_argument("manifest", nargs="?", help="merged AndroidManifest.xml (default: look for it under <root>/app/build/intermediates)")
    ap.add_argument("--variant", choices=("release", "debug"), default="release", help="which merged manifest to look for (default release)")
    ap.add_argument("--root", default=ROOT, help="project root (default: %(default)s)")
    ap.add_argument("--require-shizuku", action="store_true", help="fail when the manifest has no moe.shizuku.manager component")
    try:
        args = ap.parse_args(argv)
    except SystemExit as e:
        return EXIT_SETUP if e.code not in (0, None) else EXIT_OK   # argparse exits 2 itself on a usage error; --help exits 0
    try:
        path = args.manifest or find_merged_manifest(os.path.abspath(args.root), args.variant)
        root = parse(path)
    except SetupError as e:
        print("::error::%s: %s" % (TAG, e))
        return EXIT_SETUP
    errors, notes, state = check(root, args.require_shizuku)
    for n in notes:
        print(n)
    if errors:
        for e in errors:
            print("::error::%s: %s" % (TAG, e))
        return EXIT_RULE
    if state == "checked":
        print("Shizuku: %s: %s from %s; %d rule(s) ran and passed%s" % (
            path, summary(Merged(root)), MANAGER_NS, len(RULES),
            "" if RULES else " (SKELETON: no rule is registered yet, rows 4E-2 ... 5F add them)"))
        if RULES:
            print("rules that ran: " + "; ".join(r[0] for r in RULES) + " (self-test: shizuku/tools/test-check-merged-manifest.py)")
    return EXIT_OK


if __name__ == "__main__":
    sys.exit(main())
