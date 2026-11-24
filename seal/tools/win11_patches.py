"""
Win11 changes on top of the copied Seal sources (called by import-upstream.py after the copy; also safe to run again on a tree
that already has them: a patch whose text is already in place is skipped).

  PATCHES  string replacements, each must match exactly once (or already be applied), otherwise upstream changed: look at it again
  DROP     files that are not wanted (part 4: Seal's self-update screens)
  OVERLAY  files of seal/tools/overlay/ that replace or add a file under seal/src/main/java/com/junkfood/seal/ (same relative path)
  OVERLAY_MAIN  files of seal/tools/overlay-main/ that go under seal/src/main/ (part 5: AndroidManifest.xml; import-upstream.py wipes seal/src first)
  RES_PATCHES  string replacements in files under seal/src/main/res (part 6: the display name "Downloader"), same exactly-once rule
"""
import os, shutil, sys

HERE = os.path.dirname(os.path.abspath(__file__))
BASE = "src/main/java/com/junkfood/seal"

PATCHES = [
    # part 3: Seal compiles against OkHttp 4.12.0 here (same as :youtube), where Response.body is nullable (upstream uses 5.0.0-alpha.10, non-null)
    ("util/SponsorUtil.kt", "newCall(request).execute().body.string()",
     "newCall(request).execute().body!!.string() /* Win11: !! (OkHttp 4.12: body is nullable) */"),
    # part 4: Seal's self-update is removed (the launcher is not updated by Seal) -> nothing may open or link to the update screens
    ("ui/page/AppEntry.kt", "import com.junkfood.seal.ui.page.settings.about.UpdatePage\n", ""),
    ("ui/page/AppEntry.kt", "            AppUpdater()\n            YtdlpUpdater()", "            YtdlpUpdater()"),
    ("ui/page/AppEntry.kt", "                onNavigateToUpdatePage = { onNavigateTo(Route.AUTO_UPDATE) },\n", ""),
    ("ui/page/AppEntry.kt", "        animatedComposable(Route.AUTO_UPDATE) { UpdatePage(onNavigateBack) }\n", ""),
    ("ui/common/Route.kt", "    const val AUTO_UPDATE = \"auto_update\"\n", ""),
    ("util/PreferenceUtil.kt",
     "    fun isAutoUpdateEnabled(): Boolean {\n        return when {\n            isFDroidBuild() -> false\n            isDebugBuild() -> false\n            else -> AUTO_UPDATE.getBoolean()\n        }\n    }\n\n", ""),
    ("ui/page/settings/about/AboutPage.kt", "import androidx.compose.material.icons.outlined.Update\n", ""),
    ("ui/page/settings/about/AboutPage.kt", "import com.junkfood.seal.util.AUTO_UPDATE\n", ""),
    ("ui/page/settings/about/AboutPage.kt", "    onNavigateToUpdatePage: () -> Unit,\n", ""),
    ("ui/page/settings/about/AboutPage.kt",
     "    var isAutoUpdateEnabled by remember { mutableStateOf(PreferenceUtil.isAutoUpdateEnabled()) }\n", ""),
    ("ui/page/settings/about/AboutPage.kt",
     "                item {\n                    PreferenceSwitchWithDivider(\n                        title = stringResource(R.string.sl_auto_update),\n"
     "                        description = stringResource(R.string.sl_check_for_updates_desc),\n"
     "                        icon =\n                            if (isAutoUpdateEnabled) Icons.Outlined.Update\n"
     "                            else Icons.Outlined.UpdateDisabled,\n                        isChecked = isAutoUpdateEnabled,\n"
     "                        isSwitchEnabled = !App.isFDroidBuild(),\n                        onClick = onNavigateToUpdatePage,\n"
     "                        onChecked = {\n                            isAutoUpdateEnabled = !isAutoUpdateEnabled\n"
     "                            PreferenceUtil.updateValue(AUTO_UPDATE, isAutoUpdateEnabled)\n                        },\n                    )\n                }\n", ""),
    # part 6: a link handed over by the launcher (Browser / Media Grabber / rizwans2://seal?url=) must open the download sheet on a cold start too;
    # upstream reads the shared link only in onNewIntent (its intent filters start the app through the share sheet, which it handles elsewhere)
    ("MainActivity.kt", "        context = this.baseContext\n        setContent {",
     "        context = this.baseContext\n"
     "        // Win11: the link of the launcher's explicit ACTION_SEND intent opens the download sheet on a cold start too (upstream only reads it in onNewIntent)\n"
     "        intent.getSharedURL()?.let {\n"
     "            dialogViewModel.postAction(DownloadDialogViewModel.Action.ShowSheet(listOf(it)))\n"
     "        }\n"
     "        setContent {"),
    # part 6: downloads go to the launcher's own Downloads folder (where the Browser and the File Manager look), not to Download/Seal;
    # the temp folder becomes a hidden one inside it (it used to be Download/Seal/tmp)
    ("util/FileUtil.kt", "File(getExternalDownloadDirectory(), \"tmp\").apply {",
     "File(getExternalDownloadDirectory(), \".downloader-tmp\").apply { // Win11: hidden temp folder (was \"tmp\" inside Download/Seal)"),
    ("util/FileUtil.kt",
     "        File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), \"Seal\")\n            .also { it.mkdir() }",
     "        // Win11: the public Downloads folder itself (upstream: its subfolder \"Seal\"), the same folder the launcher's Browser saves to\n"
     "        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).also { it.mkdirs() }"),
    # part 6: Seal's language page calls AppCompatDelegate.setApplicationLocales, which changes the language of the whole launcher process -> hidden
    ("ui/page/settings/appearance/AppearancePreferences.kt",
     "                PreferenceItem(\n                    title = stringResource(R.string.sl_language),\n                    icon = Icons.Outlined.Language,\n"
     "                    description = Locale.getDefault().toDisplayName(),\n                ) {\n                    onNavigateTo(Route.LANGUAGES)\n                }\n", ""),
]

RES_PATCHES = [
    # part 6: Seal's README forbids other parties from using the name "Seal" for a downloader app (derivatives included): shown as "Downloader"
    ("values/strings.xml", '<string name="sl_app_name" translatable="false">Seal</string>',
     '<string name="sl_app_name" translatable="false">Downloader</string>'),
    ("values/strings.xml", '<string name="sl_service_title">Seal is downloading…</string>',
     '<string name="sl_service_title">Downloader is downloading…</string>'),
]

DROP = [
    "ui/page/AppUpdater.kt",
    "ui/page/UpdateDialog.kt",
    "ui/page/settings/about/UpdatePage.kt",
]


def _rd(p):
    with open(p, encoding="utf-8") as f:
        return f.read()


def _wr(p, s):
    os.makedirs(os.path.dirname(p), exist_ok=True)
    with open(p, "w", encoding="utf-8", newline="") as f:
        f.write(s)


def apply(seal_dir):
    root = os.path.join(seal_dir, BASE)
    n_patch = n_skip = 0
    for rel, old, new in PATCHES:
        fp = os.path.join(root, rel)
        t = _rd(fp)
        c = t.count(old)
        if c == 1:
            _wr(fp, t.replace(old, new))
            n_patch += 1
        elif c == 0 and (new == "" or new in t):
            n_skip += 1  # already applied
        else:
            sys.exit("PATCH does not match exactly once: %s: %r (found %d)" % (rel, old[:70], c))
    res = os.path.join(seal_dir, "src/main/res")
    for rel, old, new in RES_PATCHES:
        fp = os.path.join(res, rel)
        t = _rd(fp)
        c = t.count(old)
        if c == 1:
            _wr(fp, t.replace(old, new))
            n_patch += 1
        elif c == 0 and new in t:
            n_skip += 1  # already applied
        else:
            sys.exit("RES_PATCH does not match exactly once: %s: %r (found %d)" % (rel, old[:70], c))
    n_drop = 0
    for rel in DROP:
        fp = os.path.join(root, rel)
        if os.path.exists(fp):
            os.remove(fp)
            n_drop += 1
    ov = os.path.join(HERE, "overlay")
    n_ov = 0
    for dp, _, fs in os.walk(ov):
        for f in fs:
            sp = os.path.join(dp, f)
            dst = os.path.join(root, os.path.relpath(sp, ov))
            os.makedirs(os.path.dirname(dst), exist_ok=True)
            shutil.copyfile(sp, dst)
            n_ov += 1
    ovm = os.path.join(HERE, "overlay-main")
    main = os.path.join(seal_dir, "src/main")
    for dp, _, fs in os.walk(ovm):
        for f in fs:
            sp = os.path.join(dp, f)
            dst = os.path.join(main, os.path.relpath(sp, ovm))
            os.makedirs(os.path.dirname(dst), exist_ok=True)
            shutil.copyfile(sp, dst)
            n_ov += 1
    print("win11 patches applied: %d (already in place: %d), files dropped: %d, overlay files: %d" % (n_patch, n_skip, n_drop, n_ov))
