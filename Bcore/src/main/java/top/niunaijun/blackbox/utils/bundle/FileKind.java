package top.niunaijun.blackbox.utils.bundle;

import java.io.File;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Looks inside a file to see what it is, because the name that a file picker or a download gives
 * is not reliable (a bundle may be called .zip, an APK may have no extension). Plain Java.
 */
public final class FileKind {

    public enum Kind {
        /** A normal APK (zip with AndroidManifest.xml at the top). */
        APK,
        /** A zip that holds APK files: .apks, .xapk, .apkm or a plain zip of APKs. */
        BUNDLE,
        /** A zip without any APK in it. */
        ZIP_WITHOUT_APK,
        /** Not a readable zip file at all. */
        NOT_ZIP
    }

    private FileKind() {
    }

    public static Kind sniff(File file) {
        if (file == null || !file.isFile()) {
            return Kind.NOT_ZIP;
        }
        ZipFile zip = null;
        try {
            zip = new ZipFile(file);
            boolean hasApk = false;
            Enumeration<? extends ZipEntry> entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry e = entries.nextElement();
                if (e.isDirectory()) {
                    continue;
                }
                String name = e.getName().replace('\\', '/');
                String lower = name.toLowerCase(Locale.ROOT);
                if (lower.equals("androidmanifest.xml")) {
                    return Kind.APK;
                }
                if (lower.endsWith(".apk") && !lower.startsWith("__macosx/")) {
                    hasApk = true;
                }
            }
            return hasApk ? Kind.BUNDLE : Kind.ZIP_WITHOUT_APK;
        } catch (Exception e) {
            return Kind.NOT_ZIP;
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception ignored) {
                }
            }
        }
    }
}
