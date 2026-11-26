#!/usr/bin/env python3
"""Turns the fetched Mika checkout (mika/upstream/) into the library :mika (shown in Win11 as "Rizwan"). Part 4 of the Mika plan.

Run by tools/patch-upstream.sh (and the Gradle task :mika:patchMikaUpstream) AFTER tools/fetch-upstream.sh. Idempotent: every edit below
is written so that a second run finds nothing left to change (the result is byte-identical), so a patched checkout is never fetched again.

What it does (all inside mika/upstream/app/src/main):
  1. MikaApp.kt          `class MikaApp`  ->  `open class MikaApp`   (Win11's App extends it, part 6)
  2. AndroidManifest.xml application -> library: the attributes of <application> are removed (they would be merged into :app and replace its
                         name / icon / label / theme / backup / locale / network settings), and the MAIN + LAUNCHER intent filter of MainActivity is
                         removed (Win11 opens Rizwan from its own Start menu / Home / deep-link hooks, part 8). Everything else (permissions, services,
                         providers, receivers, SEND filters) is kept (part 7 added labels / task affinity only, edit 11).
  3. resource names      the 13 names that clash with other Win11 modules get the prefix mk_ (file or <string name>, @string/x, @mipmap/x, R.string.x,
                         R.mipmap.x). In an app the :app module wins a clash, so an un-renamed `cancel` / `app_name` would silently change Mika's texts.
  4. visible name        "Mika" -> "Rizwan" in the TEXT of the strings of every language (values*/*.xml except themes / ids). URLs, github / wangzan101
                         tokens, resource names, package names and style names are never touched.
  5. greeting            the five time-of-day greetings of the chat (chat_greeting_*) become "Hey Rizwan" in every language.
  6. icon                mika_launcher_art.png (launcher + logo + welcome + about + share card) is replaced by mika/rizwan/drawable-nodpi/mika_launcher_art.png.
  7. host hooks (part 6) MikaApp.onCreate is split: `onCreate() { super.onCreate(); if (startOnCreate()) startMika() }`, with `protected open fun startOnCreate()`
                         (true = upstream behaviour) and a public, idempotent, main-thread `fun startMika()` that holds the original body. Win11's App says
                         "not now" and starts Mika itself (launcher process only, and only once Rizwan was used). MikaQuit ("quit Mika": capsule, Settings,
                         backup import) used to kill the whole process and cancel every notification of the package: in a library that would kill the Win11
                         launcher, so it now calls `MikaApp.onQuitExit()` (default = the old process kill; Win11's App does nothing) and no longer calls cancelAll().
  8. language           AppLanguage no longer uses Android 13's per-app LocaleManager (it would change the language of the WHOLE Win11 process) and no longer sets the
                         process-wide default Locale: the legacy path (own preference + wrap() of Mika's own screens) is used on every Android version (part 7).
  9. self-update        UpdateChecker.check() does nothing (no GitHub / mirror request, "already latest" on a manual check), so Mika can never download or install its own
                         APK over Win11 (part 7). The update screens, ApkUpdater and UpdateFilesProvider stay (nothing reaches them).
 10. backup import      the text after a backup import (13 languages) says what is really needed now that "Close Rizwan" no longer ends the process (part 7).
 11. manifest (part 7)  Mika's own screens get the label "Rizwan" + its icon (else Recents / the share sheet would show "RizwanS2" and Win11's icon) and their own task
                         (taskAffinity ${applicationId}.rizwan: Rizwan opens as its own window and never lands on top of the launcher's task). Every permission, service,
                         provider, receiver, <queries>, <uses-feature> and the SEND / SEND_MULTIPLE filters are kept (nothing is removed: KEEP_PERMISSIONS is checked).
  12. MainActivity       MainActivity.onCreate calls MikaApp.startMika() first (idempotent): a start that does not come from the Win11 hooks (share sheet, tile preferences)
                         must not run Mika's screen on a process where Mika was never started (part 7).
 13. licence assets (part 11) the APK carries the licence texts of what Mika ships: upstream's licenses/ (GPL-2.0, GPL-3.0, LGPL-3.0, THIRD_PARTY_NOTICES.md) and NOTICE go into
                         assets/licenses/ next to Mika's own Apache-2.0.txt, together with mika/rizwan/licenses/RIZWAN-NOTICE.md (what Rizwan is, what was changed, where the source of the
                         GPL / LGPL parts is) and gpl-source/ (PRoot's four patches + the two source locks + Mika's sandbox README from tools/sandbox/). Nothing of Mika's is overwritten.
  14. drawer anchors (build fix) ChatDrawerMotion.kt used `DraggableAnchors.minAnchor()` / `maxAnchor()`, which are gone in the Compose Foundation of the BOM that :mika shares with
                          the other Win11 modules (compose-bom-alpha 2025.03.01; upstream builds with 2024.12.01): `:mika:compileReleaseKotlin` failed with two
                          `Unresolved reference` errors. They become `minOf/maxOf(anchors.positionOf(Closed), anchors.positionOf(Open))`, which means the same (the drawer has
                          exactly these two anchors) and exists in every Foundation version.
Checks at the end (exit 1 with ::error:: when something is off): manifest parses, no application attributes / launcher filter left, `open class MikaApp`,
no un-prefixed clashing resource left, no Latin "Mika" left in the UI text (except URL / github tokens).
Not done here (later parts): persona / prompts (core resources still say Mika, part 14), notification icon.
"""
import hashlib
import os
import re
import sys
import xml.etree.ElementTree as ET

HERE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))        # mika/
UP = os.environ.get("MIKA_UPSTREAM_DIR") or os.path.join(HERE, "upstream")
MAIN = os.path.join(UP, "app", "src", "main")
RES = os.path.join(MAIN, "res")
JAVA = os.path.join(MAIN, "java")
MANIFEST = os.path.join(MAIN, "AndroidManifest.xml")
MARKER = os.path.join(UP, ".rizwan-patched")
NAME = "Rizwan"
GREETING = "Hey Rizwan"
P = "mk_"

# The 13 names that clash with the other Win11 modules (found in step 1 of the plan, 13 of 4,398). A new upstream version needs a new check.
CLASH_STRINGS = ["add", "app_name", "backup_export_failed", "backup_import_failed", "cancel", "loading", "more", "reset", "retry", "save", "search", "show"]
CLASH_MIPMAPS = ["ic_launcher"]
NO_NAME_FILES = {"themes.xml"}            # style names (Theme.Mika) must stay; ids_*.xml hold only ids


def err(msg):
    print("::error::patch-upstream: " + msg, file=sys.stderr)
    sys.exit(1)


def read(path):
    with open(path, encoding="utf-8") as f:
        return f.read()


def write_if_changed(path, new, old):
    if new != old:
        with open(path, "w", encoding="utf-8", newline="") as f:
            f.write(new)
        return 1
    return 0


def walk(root, exts):
    for dp, _dn, fn in os.walk(root):
        for f in sorted(fn):
            if f.endswith(exts):
                yield os.path.join(dp, f)


# ---------------------------------------------------------------- 1. MikaApp open
def patch_app_class():
    path = os.path.join(JAVA, "com", "wangzan101", "mika", "MikaApp.kt")
    s = read(path)
    if re.search(r"^open class MikaApp\b", s, re.M):
        return 0
    n = re.subn(r"^class MikaApp\b", "open class MikaApp", s, count=1, flags=re.M)
    if n[1] != 1:
        err("class MikaApp not found in MikaApp.kt (upstream layout changed, review the patch)")
    return write_if_changed(path, n[0], s)


# ---------------------------------------------------------------- 7. host hooks (part 6): start-up split + quit without killing the host
ONCREATE_HEAD = "    override fun onCreate() {\n        super.onCreate()\n"
HOST_HOOKS = '''    // ---- Rizwan patch (mika/tools/patch-upstream.py, part 6) -------------------------------------------------------------------------
    // Mika is a library inside Win11: this class is the superclass of Win11's App, whose process also hosts the BlackBox engine and the
    // cloned apps. The upstream onCreate body moved to startMika(), which the host calls when and where it wants (launcher process only).
    override fun onCreate() {
        super.onCreate()
        if (startOnCreate()) startMika()
    }

    /** true (upstream behaviour): [startMika] runs from onCreate. The host returns false and starts Mika itself. */
    protected open fun startOnCreate(): Boolean = true

    private val mikaStarted = java.util.concurrent.atomic.AtomicBoolean(false)

    /** true after [startMika] ran in this process. */
    val isMikaStarted: Boolean get() = mikaStarted.get()

    /** "Quit Mika" (capsule, Settings, backup import) ends here. Upstream ends the process; the host decides (Win11 must stay alive). */
    open fun onQuitExit() { android.os.Process.killProcess(android.os.Process.myPid()) }

    /** The upstream onCreate body. Runs once per process (later calls do nothing) and always on the main thread (a call from another thread is posted). */
    fun startMika() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            android.os.Handler(android.os.Looper.getMainLooper()).post { startMika() }
            return
        }
        if (!mikaStarted.compareAndSet(false, true)) return
'''
QUIT_NOTIF_NOW = "        runCatching { app.getSystemService(NotificationManager::class.java)?.cancelAll() }\n"
QUIT_RUNNABLE = ("            // 服务停下来时可能又发了一条「任务已中断」;收干净再走\n"
                 "            app.getSystemService(NotificationManager::class.java)?.cancelAll()\n"
                 "            Process.killProcess(Process.myPid())\n")
QUIT_RUNNABLE_NEW = ("            // Rizwan patch (part 6): no clearing of all notifications (that would clear the whole Win11 app's) and no process kill (the host decides)\n"
                     "            app.onQuitExit()\n")


def patch_host_hooks():
    n = 0
    path = os.path.join(JAVA, "com", "wangzan101", "mika", "MikaApp.kt")
    s = read(path)
    if "fun startMika()" not in s:
        if s.count(ONCREATE_HEAD) != 1:
            err("override fun onCreate() { super.onCreate() not found exactly once in MikaApp.kt (upstream layout changed, review the patch)")
        n += write_if_changed(path, s.replace(ONCREATE_HEAD, HOST_HOOKS, 1), s)
    path = os.path.join(JAVA, "com", "wangzan101", "mika", "MikaQuit.kt")
    s = read(path)
    if "onQuitExit()" not in s:
        if s.count(QUIT_RUNNABLE) != 1 or s.count(QUIT_NOTIF_NOW) != 1:
            err("quit / kill lines not found in MikaQuit.kt (upstream layout changed, review the patch)")
        n += write_if_changed(path, s.replace(QUIT_NOTIF_NOW, "", 1).replace(QUIT_RUNNABLE, QUIT_RUNNABLE_NEW, 1), s)
    return n


# ---------------------------------------------------------------- 2. library manifest
APP_ATTRS = "name|allowBackup|icon|supportsRtl|label|localeConfig|networkSecurityConfig|theme"
LAUNCHER_FILTER = re.compile(
    r'[ \t]*<intent-filter>\s*<action android:name="android\.intent\.action\.MAIN"\s*/>\s*'
    r'<category android:name="android\.intent\.category\.LAUNCHER"\s*/>\s*</intent-filter>[ \t]*\r?\n?')


def patch_manifest():
    s = read(MANIFEST)
    o = s

    def strip_attrs(m):
        return "<application" + re.sub(r'\s+android:(?:%s)="[^"]*"' % APP_ATTRS, "", m.group(1)) + ">"
    s, n = re.subn(r"<application\b([^>]*)>", strip_attrs, s, count=1)
    if n != 1:
        err("<application> not found in AndroidManifest.xml")
    s = LAUNCHER_FILTER.sub("", s)
    return write_if_changed(MANIFEST, s, o)


# ---------------------------------------------------------------- 3. resource names (mk_ prefix)
def drift_guard():
    """A new upstream version may drop / add a clashing name: every name in CLASH_STRINGS must still exist (plain or already prefixed)."""
    text = ""
    for f in sorted(os.listdir(os.path.join(RES, "values"))):
        if f.endswith(".xml"):
            text += read(os.path.join(RES, "values", f))
    missing = [n for n in CLASH_STRINGS if ('name="%s"' % n) not in text and ('name="%s%s"' % (P, n)) not in text]
    if missing:
        err("clashing string(s) not found in this upstream version: " + ", ".join(missing) + " (review CLASH_STRINGS)")


def rename_resources():
    drift_guard()
    changed = 0
    xml_files = list(walk(RES, (".xml",))) + [MANIFEST]
    src_files = list(walk(JAVA, (".kt", ".java")))
    strs = "|".join(map(re.escape, CLASH_STRINGS))
    mips = "|".join(map(re.escape, CLASH_MIPMAPS))

    # <string name="x"> definitions (every values* folder)
    defined = set()
    rx_def = re.compile(r'(<string\s+name=")(%s)(")' % strs)
    for path in xml_files:
        if "/values" not in path.replace("\\", "/"):
            continue
        s = read(path)
        for m in rx_def.finditer(s):
            defined.add(m.group(2))
        changed += write_if_changed(path, rx_def.sub(lambda m: m.group(1) + P + m.group(2) + m.group(3), s), s)
    # a file resource: res/mipmap*/ic_launcher.xml -> mk_ic_launcher.xml
    for dp, _dn, fn in os.walk(RES):
        if os.path.basename(dp).split("-")[0] != "mipmap":
            continue
        for f in fn:
            base, ext = os.path.splitext(f)
            if base in CLASH_MIPMAPS:
                os.rename(os.path.join(dp, f), os.path.join(dp, P + base + ext))
                defined.add(base)
                changed += 1
    # references in XML and in the manifest: @string/x, @mipmap/x (file list read again: a file was renamed above)
    xml_files = list(walk(RES, (".xml",))) + [MANIFEST]
    rx_xml = re.compile(r"@(string|mipmap)/(%s|%s)(?![A-Za-z0-9_.])" % (strs, mips))

    def xml_ref(m):
        names = CLASH_STRINGS if m.group(1) == "string" else CLASH_MIPMAPS
        return "@%s/%s%s" % (m.group(1), P, m.group(2)) if m.group(2) in names else m.group(0)
    for path in xml_files:
        s = read(path)
        changed += write_if_changed(path, rx_xml.sub(xml_ref, s), s)
    # references in Kotlin / Java: R.string.x, R.mipmap.x (also com.wangzan101.mika.R.string.x); android.R.string.x is never touched
    rx_src = re.compile(r"(?<!android\.)(?<![A-Za-z0-9_])R\.(string|mipmap)\.(%s|%s)(?![A-Za-z0-9_])" % (strs, mips))

    def src_ref(m):
        names = CLASH_STRINGS if m.group(1) == "string" else CLASH_MIPMAPS
        return "R.%s.%s%s" % (m.group(1), P, m.group(2)) if m.group(2) in names else m.group(0)
    for path in src_files:
        s = read(path)
        changed += write_if_changed(path, rx_src.sub(src_ref, s), s)
    return changed


# ---------------------------------------------------------------- 4. visible name
KEEP = r"(\S*(?:https?://|github\.com|wangzan101)\S*)"
RX_NAME = re.compile(KEEP + r"|\bMika\b")
RX_TEXT = re.compile(r"(?<=>)([^<>]+)(?=<)")


def rename_visible():
    changed = 0
    for path in walk(RES, (".xml",)):
        d = os.path.basename(os.path.dirname(path))
        f = os.path.basename(path)
        if not d.startswith("values") or f in NO_NAME_FILES or f.startswith("ids_"):
            continue
        s = read(path)
        s2 = RX_TEXT.sub(lambda t: RX_NAME.sub(lambda m: m.group(1) or NAME, t.group(1)), s)
        changed += write_if_changed(path, s2, s)
    return changed


# ---------------------------------------------------------------- 5. greeting
RX_GREET = re.compile(r'(<string\s+name="chat_greeting_(?:morning|noon|afternoon|evening|night)"[^>]*>)[^<]*(</string>)')


def patch_greeting():
    changed = 0
    for path in walk(RES, (".xml",)):
        if not os.path.basename(path).startswith("strings_chat"):
            continue
        s = read(path)
        changed += write_if_changed(path, RX_GREET.sub(lambda m: m.group(1) + GREETING + m.group(2), s), s)
    return changed


# ---------------------------------------------------------------- 6. icon
def patch_icon():
    src = os.path.join(HERE, "rizwan", "drawable-nodpi", "mika_launcher_art.png")
    dst = os.path.join(RES, "drawable-nodpi", "mika_launcher_art.png")
    if not os.path.exists(src):
        print("patch-upstream: no mika/rizwan icon, keeping upstream's art")
        return 0
    data = open(src, "rb").read()
    if os.path.exists(dst) and open(dst, "rb").read() == data:
        return 0
    open(dst, "wb").write(data)
    return 1


# ---------------------------------------------------------------- 8. language (part 7): never touch the host's locale
LANG_FILE = os.path.join(JAVA, "com", "wangzan101", "mika", "i18n", "AppLanguage.kt")
SYS_OLD = "        private val systemManaged get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU\n"
SYS_NEW = ("        // Rizwan patch (part 7): Android 13's LocaleManager would set the language of the WHOLE Win11 process (launcher, clock, other apps' screens in it).\n"
           "        // Mika is a guest here: always the legacy path (own preference + wrap() of its own screens), on every Android version.\n"
           "        private val systemManaged get() = false\n\n"
           "        // Rizwan patch (part 7): the process-wide default Locale (dates, numbers of the launcher) is never changed either.\n"
           "        private val keepHostLocale get() = true\n")
DEF_OLD = "            if (systemManaged) return\n            val locales = legacyLocales(context) ?: Resources.getSystem().configuration.locales\n"
DEF_NEW = "            if (systemManaged || keepHostLocale) return\n            val locales = legacyLocales(context) ?: Resources.getSystem().configuration.locales\n"


def patch_language():
    s = read(LANG_FILE)
    if "keepHostLocale" in s:
        return 0
    if s.count(SYS_OLD) != 1 or s.count(DEF_OLD) != 1:
        err("AppLanguage.kt: systemManaged / applyDefaultLocale lines not found exactly once (upstream layout changed, review the patch)")
    return write_if_changed(LANG_FILE, s.replace(SYS_OLD, SYS_NEW, 1).replace(DEF_OLD, DEF_NEW, 1), s)


# ---------------------------------------------------------------- 9. self-update off (part 7)
UPD_FILE = os.path.join(JAVA, "com", "wangzan101", "mika", "about", "UpdateChecker.kt")
UPD_OLD = "    suspend fun check(manual: Boolean) {\n        mutex.withLock {\n"
UPD_NEW = ("    /** Rizwan patch (part 7): Mika is a library inside Win11; its own update would download and install \"com.wangzan101.mika\" over the host. Never checks. */\n"
           "    private val selfUpdateOff get() = true\n\n"
           "    suspend fun check(manual: Boolean) {\n"
           "        if (selfUpdateOff) {\n"
           "            // no request to GitHub / a mirror; a manual check ends as \"already the latest\"\n"
           "            if (manual) _state.update { it.copy(status = CheckStatus.Done, manualRounds = it.manualRounds + 1) }\n"
           "            return\n"
           "        }\n"
           "        mutex.withLock {\n")


def patch_self_update():
    s = read(UPD_FILE)
    if "selfUpdateOff" in s:
        return 0
    if s.count(UPD_OLD) != 1:
        err("UpdateChecker.kt: `suspend fun check(manual: Boolean) { mutex.withLock {` not found exactly once (upstream layout changed, review the patch)")
    return write_if_changed(UPD_FILE, s.replace(UPD_OLD, UPD_NEW, 1), s)


# ---------------------------------------------------------------- 10. backup import text (part 7)
BACKUP_BODY = {
    "values": "Close Rizwan with the button below, then swipe RizwanS2 away from your recent apps and open Rizwan again to use the restored data. Then re-pair wireless debugging, turn the accessibility service back on in Android Settings, and delete the backup ZIP file.",
    "values-zh": "点下面的按钮关闭 Rizwan，再把 RizwanS2 从最近任务里划掉并重新打开 Rizwan，以使用恢复的数据。然后重新配对无线调试、在 Android 设置里重新打开无障碍服务，并删除备份 ZIP 文件。",
    "values-b+zh+Hant": "點下方按鈕關閉 Rizwan，再把 RizwanS2 從最近使用的應用程式中滑掉並重新開啟 Rizwan，以使用還原的資料。然後重新配對無線偵錯、在 Android 設定中重新開啟無障礙服務，並刪除備份 ZIP 檔案。",
    "values-ar": "أغلق Rizwan بالزر أدناه، ثم اسحب RizwanS2 من التطبيقات الأخيرة وافتح Rizwan مرة أخرى لاستخدام البيانات المستعادة. بعد ذلك، أعد إقران التصحيح اللاسلكي، وأعد تشغيل خدمة الوصول في إعدادات Android، واحذف ملف ZIP للنسخة الاحتياطية.",
    "values-fa": "با دکمهٔ زیر Rizwan را ببندید، سپس RizwanS2 را از برنامه‌های اخیر حذف کنید (بکشید) و Rizwan را دوباره باز کنید تا از داده‌های بازیابی‌شده استفاده شود. سپس اشکال‌زدایی بی‌سیم را دوباره جفت کنید، سرویس دسترس‌پذیری را در تنظیمات Android دوباره روشن کنید و فایل ZIP پشتیبان را پاک کنید.",
    "values-ja": "下のボタンで Rizwan を閉じ、最近使ったアプリから RizwanS2 をスワイプして終了し、Rizwan を開き直すと、復元したデータが使えます。その後ワイヤレスデバッグを再ペアリングし、Android 設定でアクセシビリティサービスを再度有効化し、バックアップ ZIP を削除してください。",
    "values-ko": "아래 버튼으로 Rizwan을 닫은 뒤, 최근 앱 목록에서 RizwanS2를 밀어 종료하고 Rizwan을 다시 열면 복원된 데이터를 사용할 수 있습니다. 그다음 무선 디버깅을 다시 페어링하고, Android 설정에서 접근성 서비스를 다시 켠 뒤, 백업 ZIP 파일을 삭제하세요.",
    "values-es": "Cierra Rizwan con el botón de abajo, luego quita RizwanS2 de las apps recientes y abre Rizwan de nuevo para usar los datos restaurados. Después vuelve a vincular la depuración inalámbrica, activa de nuevo el servicio de accesibilidad en los ajustes de Android y elimina el archivo ZIP de la copia de seguridad.",
    "values-pt": "Feche o Rizwan com o botão abaixo, depois deslize o RizwanS2 para fora dos apps recentes e abra o Rizwan novamente para usar os dados restaurados. Em seguida, pareie novamente a depuração sem fio, ative de novo o serviço de acessibilidade nas configurações do Android e exclua o arquivo ZIP do backup.",
    "values-ru": "Закройте Rizwan кнопкой ниже, затем смахните RizwanS2 из списка недавних приложений и снова откройте Rizwan, чтобы использовать восстановленные данные. После этого заново выполните сопряжение беспроводной отладки, снова включите службу специальных возможностей в настройках Android и удалите ZIP-файл резервной копии.",
    "values-in": "Tutup Rizwan dengan tombol di bawah, lalu geser RizwanS2 dari aplikasi terbaru dan buka Rizwan lagi untuk memakai data yang dipulihkan. Setelah itu pasangkan ulang debugging nirkabel, aktifkan kembali layanan aksesibilitas di Pengaturan Android, dan hapus file ZIP cadangan.",
    "values-tr": "Aşağıdaki düğmeyle Rizwan’ı kapatın, ardından RizwanS2’yi son uygulamalardan kaydırarak kapatın ve geri yüklenen verileri kullanmak için Rizwan’ı yeniden açın. Sonra kablosuz hata ayıklamayı yeniden eşleştirin, Android Ayarları’nda erişilebilirlik hizmetini tekrar açın ve yedek ZIP dosyasını silin.",
    "values-vi": "Đóng Rizwan bằng nút bên dưới, sau đó vuốt RizwanS2 khỏi danh sách ứng dụng gần đây và mở lại Rizwan để dùng dữ liệu đã khôi phục. Tiếp theo, ghép nối lại gỡ lỗi không dây, bật lại dịch vụ trợ năng trong Cài đặt Android và xóa tệp ZIP sao lưu.",
}
RX_BACKUP = re.compile(r'(<string\s+name="backup_after_import_body"[^>]*>)([^<]*)(</string>)')


def patch_backup_text():
    changed = 0
    seen = set()
    for dn in sorted(os.listdir(RES)):
        path = os.path.join(RES, dn, "strings_backup.xml")
        if not dn.startswith("values") or not os.path.isfile(path):
            continue
        s = read(path)
        if not RX_BACKUP.search(s):
            continue
        if dn not in BACKUP_BODY:
            err("backup_after_import_body exists in %s but has no Rizwan text in BACKUP_BODY (new upstream language, add it)" % dn)
        seen.add(dn)
        changed += write_if_changed(path, RX_BACKUP.sub(lambda m: m.group(1) + BACKUP_BODY[dn] + m.group(3), s), s)
    if "values" not in seen:
        err("backup_after_import_body not found in values/strings_backup.xml (upstream layout changed, review the patch)")
    return changed


# ---------------------------------------------------------------- 11. manifest, part 7: label, icon, own task for Mika's screens; nothing removed
# The 30 uses-permission entries of upstream 0.1.52. The owner's rule: Mika keeps ALL its permissions. check() fails when one is missing.
KEEP_PERMISSIONS = [
    "android.permission.INTERNET", "android.permission.RECEIVE_SMS", "android.permission.RECORD_AUDIO", "android.permission.CAMERA",
    "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.REQUEST_INSTALL_PACKAGES",
    "android.permission.ACCESS_NETWORK_STATE", "android.permission.FOREGROUND_SERVICE", "android.permission.FOREGROUND_SERVICE_SPECIAL_USE",
    "android.permission.FOREGROUND_SERVICE_DATA_SYNC", "android.permission.FOREGROUND_SERVICE_MICROPHONE", "android.permission.MODIFY_AUDIO_SETTINGS",
    "android.permission.POST_NOTIFICATIONS", "android.permission.POST_PROMOTED_NOTIFICATIONS", "android.permission.CALL_PHONE",
    "android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.CALL_COMPANION_APP",
    "android.permission.MANAGE_ONGOING_CALLS", "android.permission.WAKE_LOCK", "android.permission.SCHEDULE_EXACT_ALARM",
    "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR", "com.android.alarm.permission.SET_ALARM",
    "android.permission.RECEIVE_BOOT_COMPLETED", "android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VISUAL_USER_SELECTED",
    "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_SECURE_SETTINGS",
]
AFFINITY = "${applicationId}.rizwan"
# activity -> gets its own task (True) or keeps its own affinity setting (False); all four get the label and icon
UI_ACTIVITIES = {
    ".ui.MainActivity": True,
    ".ui.viewer.FileViewerActivity": True,
    ".ui.terminal.TerminalActivity": True,
    ".web.WebTakeoverActivity": False,       # has taskAffinity="" already (own task, excluded from Recents)
}


def patch_manifest_part7():
    s = read(MANIFEST)
    o = s
    for name, own_task in UI_ACTIVITIES.items():
        m = re.search(r'<activity\b[^>]*?android:name="%s"[^>]*?>' % re.escape(name), s)
        if not m:
            err("<activity %s> not found in AndroidManifest.xml (upstream layout changed, review UI_ACTIVITIES)" % name)
        tag = m.group(0)
        add = []
        if "android:label=" not in tag:
            add.append('android:label="@string/mk_app_name"')
        if "android:icon=" not in tag:
            add.append('android:icon="@mipmap/mk_ic_launcher"')
        if own_task and "android:taskAffinity=" not in tag:
            add.append('android:taskAffinity="%s"' % AFFINITY)
        if not add:
            continue
        nm = re.compile(r'(\n[ \t]*)(android:name="%s")' % re.escape(name))
        if not nm.search(tag):
            err("android:name of <activity %s> is not on its own line (upstream layout changed, review the patch)" % name)
        new_tag = nm.sub(lambda t: t.group(1) + t.group(2) + "".join(t.group(1) + a for a in add), tag, count=1)
        s = s.replace(tag, new_tag, 1)
    return write_if_changed(MANIFEST, s, o)


# ---------------------------------------------------------------- 12. MainActivity starts Mika first (part 7)
MAIN_ACT = os.path.join(JAVA, "com", "wangzan101", "mika", "ui", "MainActivity.kt")
MA_OLD = "        enableEdgeToEdge()\n        super.onCreate(savedInstanceState)\n        if (savedInstanceState == null) {\n            (application as MikaApp).chat.cancelPendingSharedDraft()\n"
MA_NEW = ("        enableEdgeToEdge()\n        super.onCreate(savedInstanceState)\n"
          "        // Rizwan patch (part 7): Mika is started by Win11 (hooks, or at launch once Rizwan was used); a start from the share sheet / tile preferences must start it too (idempotent, main thread)\n"
          "        (application as MikaApp).startMika()\n"
          "        if (savedInstanceState == null) {\n            (application as MikaApp).chat.cancelPendingSharedDraft()\n")


def patch_main_activity():
    s = read(MAIN_ACT)
    if "(application as MikaApp).startMika()" in s:
        return 0
    if s.count(MA_OLD) != 1:
        err("MainActivity.onCreate (enableEdgeToEdge / super.onCreate / cancelPendingSharedDraft) not found exactly once (upstream layout changed, review the patch)")
    return write_if_changed(MAIN_ACT, s.replace(MA_OLD, MA_NEW, 1), s)


# ---------------------------------------------------------------- 13. licence assets (part 11)
ASSETS_LIC = os.path.join(MAIN, "assets", "licenses")
OWN_LIC = os.path.join(HERE, "rizwan", "licenses")
# destination (relative to assets/licenses) -> source (relative to the checkout root); RIZWAN-NOTICE.md comes from mika/rizwan/licenses/
LICENSE_FILES = {
    "GPL-2.0.txt": "licenses/GPL-2.0.txt",
    "GPL-3.0.txt": "licenses/GPL-3.0.txt",
    "LGPL-3.0.txt": "licenses/LGPL-3.0.txt",
    "THIRD_PARTY_NOTICES.md": "licenses/THIRD_PARTY_NOTICES.md",
    "MIKA-NOTICE.txt": "NOTICE",
    "gpl-source/README.md": "tools/sandbox/README.md",
    "gpl-source/sources.lock": "tools/sandbox/sources.lock",
    "gpl-source/runtime-sources.lock": "tools/sandbox/runtime/sources.lock",
}
# what must be in assets/licenses after the patch (also checked by check-manifest.py and, in the APK, by the workflows)
LICENSE_ASSETS = ["Apache-2.0.txt", "RIZWAN-NOTICE.md"] + sorted(LICENSE_FILES)
LICENSE_PATCHES_MIN = 4          # gpl-source/patches/*.patch (upstream has proot-0001 .. 0004)


def copy_if_changed(src, dst):
    data = open(src, "rb").read()
    if os.path.exists(dst) and open(dst, "rb").read() == data:
        return 0
    os.makedirs(os.path.dirname(dst), exist_ok=True)
    open(dst, "wb").write(data)
    return 1


def patch_license_assets():
    n = 0
    for dst, src in LICENSE_FILES.items():
        p = os.path.join(UP, *src.split("/"))
        if not os.path.isfile(p):
            err("licence source %s is missing in the checkout (upstream layout changed, or the fetch left out licenses/ / tools/sandbox/)" % src)
        n += copy_if_changed(p, os.path.join(ASSETS_LIC, *dst.split("/")))
    pdir = os.path.join(UP, "tools", "sandbox", "patches")
    patches = sorted(f for f in os.listdir(pdir) if f.endswith(".patch")) if os.path.isdir(pdir) else []
    if len(patches) < LICENSE_PATCHES_MIN:
        err("tools/sandbox/patches has %d PRoot patch(es), expected at least %d (upstream layout changed, review the patch)" % (len(patches), LICENSE_PATCHES_MIN))
    for f in patches:
        n += copy_if_changed(os.path.join(pdir, f), os.path.join(ASSETS_LIC, "gpl-source", "patches", f))
    own = os.path.join(OWN_LIC, "RIZWAN-NOTICE.md")
    if not os.path.isfile(own):
        err("mika/rizwan/licenses/RIZWAN-NOTICE.md is missing")
    n += copy_if_changed(own, os.path.join(ASSETS_LIC, "RIZWAN-NOTICE.md"))
    return n


# ---------------------------------------------------------------- 14. drawer anchors (build fix)
DRAWER_FILE = os.path.join(JAVA, "com", "wangzan101", "mika", "chat", "ui", "ChatDrawerMotion.kt")
DRAWER_OLD = "anchors.minAnchor(), anchors.maxAnchor()"
DRAWER_NEW = ("minOf(anchors.positionOf(DrawerValue.Closed), anchors.positionOf(DrawerValue.Open)), "
              "maxOf(anchors.positionOf(DrawerValue.Closed), anchors.positionOf(DrawerValue.Open))")


def patch_drawer_anchors():
    s = read(DRAWER_FILE)
    if DRAWER_OLD not in s:
        return 0                                   # already patched (or upstream no longer uses the removed API)
    if s.count(DRAWER_OLD) != 1:
        err("ChatDrawerMotion.kt: `%s` not found exactly once (upstream layout changed, review the patch)" % DRAWER_OLD)
    return write_if_changed(DRAWER_FILE, s.replace(DRAWER_OLD, DRAWER_NEW, 1), s)


# ---------------------------------------------------------------- checks
def check():
    s = read(MANIFEST)
    try:
        ET.fromstring(s.encode("utf-8"))
    except ET.ParseError as e:
        err("AndroidManifest.xml is not well-formed after the patch: %s" % e)
    app = re.search(r"<application\b([^>]*)>", s).group(1)
    if "android:" in app:
        err("<application> still has attributes: " + app.strip())
    if re.search(r'category android:name="android\.intent\.category\.LAUNCHER"\s*/>\s*</intent-filter>', s):
        err("the MAIN/LAUNCHER filter is still in the manifest")
    app_kt = read(os.path.join(JAVA, "com", "wangzan101", "mika", "MikaApp.kt"))
    if not re.search(r"^open class MikaApp\b", app_kt, re.M):
        err("MikaApp is not open")
    for tok in ("protected open fun startOnCreate()", "fun startMika()", "open fun onQuitExit()", "if (startOnCreate()) startMika()"):
        if tok not in app_kt:
            err("host hook missing in MikaApp.kt: " + tok)
    if len(re.findall(r"^    override fun onCreate\(\)", app_kt, re.M)) != 1:
        err("MikaApp.kt must have exactly one onCreate")
    quit_kt = read(os.path.join(JAVA, "com", "wangzan101", "mika", "MikaQuit.kt"))
    if "cancelAll(" in quit_kt or "killProcess(" in quit_kt or "app.onQuitExit()" not in quit_kt:
        err("MikaQuit.kt still kills the process / cancels all notifications, or does not call onQuitExit()")
    # part 7: nothing removed, labels / own task, language, self-update, backup text
    root = ET.fromstring(s.encode("utf-8"))
    ANDROID = "{http://schemas.android.com/apk/res/android}"
    have = {e.get(ANDROID + "name") for e in root.findall("uses-permission")}
    lost = [p for p in KEEP_PERMISSIONS if p not in have]
    if lost:
        err("permission(s) missing from the Mika manifest (Mika keeps all of them): " + ", ".join(lost))
    acts = {e.get(ANDROID + "name"): e for e in root.iter("activity")}
    for name, own_task in UI_ACTIVITIES.items():
        e = acts.get(name)
        if e is None:
            err("activity %s missing" % name)
        if e.get(ANDROID + "label") != "@string/mk_app_name" or e.get(ANDROID + "icon") != "@mipmap/mk_ic_launcher":
            err("activity %s has no Rizwan label / icon" % name)
        if own_task and e.get(ANDROID + "taskAffinity") != AFFINITY:
            err("activity %s has no own task affinity" % name)
    lang_kt = read(LANG_FILE)
    if "private val systemManaged get() = false" not in lang_kt or "systemManaged || keepHostLocale" not in lang_kt:
        err("AppLanguage.kt is not patched (it would change the host's language)")
    if "(application as MikaApp).startMika()" not in read(MAIN_ACT):
        err("MainActivity.kt does not start Mika first")
    if "private val selfUpdateOff get() = true" not in read(UPD_FILE):
        err("UpdateChecker.kt is not patched (Mika could install its own APK over Win11)")
    for dn in sorted(os.listdir(RES)):
        path = os.path.join(RES, dn, "strings_backup.xml")
        if dn.startswith("values") and os.path.isfile(path) and RX_BACKUP.search(read(path)) and "RizwanS2" not in read(path):
            err("backup import text of %s is not patched" % dn)
    for rel in LICENSE_ASSETS:
        lp = os.path.join(ASSETS_LIC, *rel.split("/"))
        if not os.path.isfile(lp) or os.path.getsize(lp) == 0:
            err("licence asset missing or empty: assets/licenses/" + rel)
    gp = os.path.join(ASSETS_LIC, "gpl-source", "patches")
    if not os.path.isdir(gp) or len([f for f in os.listdir(gp) if f.endswith(".patch")]) < LICENSE_PATCHES_MIN:
        err("assets/licenses/gpl-source/patches has fewer than %d patches" % LICENSE_PATCHES_MIN)
    strs = "|".join(map(re.escape, CLASH_STRINGS))
    rx_def = re.compile(r'<string\s+name="(?:%s)"' % strs)
    rx_xml = re.compile(r"@string/(?:%s)(?![A-Za-z0-9_.])|@mipmap/(?:ic_launcher)(?![A-Za-z0-9_.])" % strs)
    rx_src = re.compile(r"(?<!android\.)(?<![A-Za-z0-9_])R\.(?:string\.(?:%s)|mipmap\.ic_launcher)(?![A-Za-z0-9_])" % strs)
    for path in walk(RES, (".xml",)):
        s = read(path)
        if (rx_def.search(s) and "/values" in path) or rx_xml.search(s):
            err("un-prefixed clashing resource left in " + os.path.relpath(path, UP))
    for path in list(walk(JAVA, (".kt", ".java"))) + [MANIFEST]:
        s = read(path)
        if rx_src.search(s) or (path == MANIFEST and rx_xml.search(s)):
            err("un-prefixed clashing resource reference left in " + os.path.relpath(path, UP))
    for path in walk(JAVA, (".kt", ".java")):       # build fix (edit 14): the removed Foundation API must not be left anywhere
        if re.search(r"\.(?:minAnchor|maxAnchor)\(", read(path)):
            err("removed Compose Foundation API minAnchor()/maxAnchor() still used in " + os.path.relpath(path, UP))
    left = 0
    for path in walk(RES, (".xml",)):
        d = os.path.basename(os.path.dirname(path))
        f = os.path.basename(path)
        if not d.startswith("values") or f in NO_NAME_FILES or f.startswith("ids_"):
            continue
        for t in RX_TEXT.finditer(read(path)):
            if any(not m.group(1) for m in RX_NAME.finditer(t.group(1))):
                left += 1
    if left:
        err("%d string(s) still say Mika" % left)


def main():
    if not os.path.isdir(MAIN):
        err("%s not found: run tools/fetch-upstream.sh first" % MAIN)
    me = hashlib.sha256(open(os.path.abspath(__file__), "rb").read())
    icon = os.path.join(HERE, "rizwan", "drawable-nodpi", "mika_launcher_art.png")
    if os.path.exists(icon):
        me.update(open(icon, "rb").read())
    if os.path.isdir(OWN_LIC):                       # part 11: the notice text is part of the result, so it is part of the stamp
        for fn in sorted(os.listdir(OWN_LIC)):
            me.update(fn.encode() + open(os.path.join(OWN_LIC, fn), "rb").read())
    stamp = me.hexdigest()
    if os.path.exists(MARKER) and read(MARKER).strip() == stamp and not os.environ.get("MIKA_FORCE_PATCH"):
        print("patch-upstream: already patched (same script), nothing to do")
        return
    r = {
        "MikaApp open": patch_app_class(),
        "library manifest": patch_manifest(),
        "mk_ resource edits": rename_resources(),
        "name Mika -> %s (files)" % NAME: rename_visible(),
        "greeting (files)": patch_greeting(),
        "icon": patch_icon(),
        "host hooks": patch_host_hooks(),
        "language": patch_language(),
        "self-update off": patch_self_update(),
        "backup text (files)": patch_backup_text(),
        "manifest part 7": patch_manifest_part7(),
        "MainActivity start": patch_main_activity(),
        "licence assets": patch_license_assets(),
        "drawer anchors": patch_drawer_anchors(),
    }
    check()
    with open(MARKER, "w", encoding="utf-8") as f:
        f.write(stamp + "\n")
    print("patch-upstream: done  " + ", ".join("%s=%d" % kv for kv in r.items()))


if __name__ == "__main__":
    main()
