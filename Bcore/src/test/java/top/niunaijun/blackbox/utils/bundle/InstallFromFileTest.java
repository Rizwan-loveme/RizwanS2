package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/** Part 11: what the "install from file" screen relies on (plain JVM). */
public class InstallFromFileTest {

    private static File zip(String name, String... entries) throws Exception {
        File f = File.createTempFile("zip_" + name, ".bin");
        f.deleteOnExit();
        try (ZipOutputStream z = new ZipOutputStream(new FileOutputStream(f))) {
            for (String e : entries) {
                z.putNextEntry(new ZipEntry(e));
                byte[] data = new byte[300 * 1024];
                z.write(data);
                z.closeEntry();
            }
        }
        return f;
    }

    @Test
    public void errorKinds_areRecognisedFromTheEngineTexts() {
        assertEquals(InstallErrors.Kind.WRONG_ABI, InstallErrors.classify(
                "This app does not run on this phone: the bundle only has native code for x86, x86_64, but the box needs arm64-v8a."));
        assertEquals(InstallErrors.Kind.SPLIT_UNREADABLE, InstallErrors.classify(
                "Cannot read the split file split_x.apk of com.x on this phone (file not found). Update the original app and try again."));
        assertEquals(InstallErrors.Kind.BAD_FILE, InstallErrors.classify(
                "This file is not a valid bundle (it is not a readable zip file): a.xapk"));
        assertEquals(InstallErrors.Kind.NO_APK, InstallErrors.classify("No APK files were found inside the bundle: a.zip"));
        assertEquals(InstallErrors.Kind.BROKEN_APK, InstallErrors.classify("getPackageArchiveInfo error.Please check whether APK is normal."));
        assertEquals(InstallErrors.Kind.SELF, InstallErrors.classify("Cannot clone BlackBox app from within BlackBox. This would create infinite recursion"));
        assertEquals(InstallErrors.Kind.NOT_ENOUGH_SPACE, InstallErrors.classify(InstallErrors.MSG_NOT_ENOUGH_SPACE));
        assertEquals(InstallErrors.Kind.NO_FREE_SPACE_SLOT, InstallErrors.classify(InstallErrors.MSG_NO_FREE_SLOT));
        assertEquals(InstallErrors.Kind.CANNOT_READ, InstallErrors.classify(InstallErrors.MSG_CANNOT_READ + " (no stream)"));
        assertEquals(InstallErrors.Kind.UNKNOWN, InstallErrors.classify("something else"));
        assertEquals(InstallErrors.Kind.UNKNOWN, InstallErrors.classify(null));
    }

    @Test
    public void fileKind_looksInsideTheFile() throws Exception {
        assertEquals(FileKind.Kind.APK, FileKind.sniff(zip("a", "AndroidManifest.xml", "classes.dex")));
        assertEquals(FileKind.Kind.BUNDLE, FileKind.sniff(zip("b", "manifest.json", "base.apk", "split_config.en.apk")));
        assertEquals(FileKind.Kind.BUNDLE, FileKind.sniff(zip("c", "splits/base-master.apk")));
        assertEquals(FileKind.Kind.ZIP_WITHOUT_APK, FileKind.sniff(zip("d", "readme.txt")));
        File text = File.createTempFile("text_e", ".xapk");
        text.deleteOnExit();
        try (FileOutputStream o = new FileOutputStream(text)) {
            o.write("not a zip".getBytes());
        }
        assertEquals(FileKind.Kind.NOT_ZIP, FileKind.sniff(text));
        assertEquals(FileKind.Kind.NOT_ZIP, FileKind.sniff(new File("/no/such/file")));
    }

    @Test
    public void unpackReportsProgress_untilEverythingIsWritten() throws Exception {
        File bundle = zip("f", "base.apk", "split_config.arm64_v8a.apk", "Android/obb/com.x/main.1.com.x.obb");
        File out = new File(bundle.getParentFile(), "unpack_" + System.nanoTime());
        final List<long[]> seen = new ArrayList<>();
        BundleInfo info = BundleUnpacker.unpack(bundle, out, new String[]{"arm64-v8a"}, new BundleUnpacker.Progress() {
            @Override
            public void onProgress(long done, long total) {
                seen.add(new long[]{done, total});
            }
        });
        try {
            assertTrue(!seen.isEmpty());
            long[] last = seen.get(seen.size() - 1);
            assertEquals(3L * 300 * 1024, last[1]);
            assertEquals(last[1], last[0]);
            long before = -1;
            for (long[] s : seen) {
                assertTrue(s[0] >= before);
                before = s[0];
            }
            assertEquals(1, info.splitApks.size());
            assertEquals(1, info.obbFiles.size());
        } finally {
            info.cleanup();
        }
        assertTrue(!out.exists());
    }
}
