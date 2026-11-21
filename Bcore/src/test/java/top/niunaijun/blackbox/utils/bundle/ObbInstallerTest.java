package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Part 12: OBB files of an .xapk go to the OBB folder of the app inside the box (plain JVM). */
public class ObbInstallerTest {

    private static File tmp() throws Exception {
        File d = Files.createTempDirectory("obbtest").toFile();
        d.deleteOnExit();
        return d;
    }

    private static BundleInfo.ObbFile obb(File dir, String name, int size) throws Exception {
        File f = new File(dir, name);
        try (FileOutputStream o = new FileOutputStream(f)) {
            byte[] b = new byte[size];
            Arrays.fill(b, (byte) 7);
            o.write(b);
        }
        return new BundleInfo.ObbFile(f, "com.game", name);
    }

    @Test
    public void filesArriveInTheAppFolder_andTheSourceIsGone() throws Exception {
        File src = tmp();
        File dest = new File(tmp(), "Android/obb/com.game");
        BundleInfo.ObbFile main = obb(src, "main.5.com.game.obb", 3 * 1024 * 1024);
        BundleInfo.ObbFile patch = obb(src, "patch.5.com.game.obb", 1024);
        final List<long[]> seen = new ArrayList<>();
        ObbInstaller.Result r = ObbInstaller.copy(Arrays.asList(main, patch), dest, new ObbInstaller.Progress() {
            @Override
            public void onProgress(long done, long total) {
                seen.add(new long[]{done, total});
            }
        });
        assertEquals(2, r.files.size());
        assertEquals(3L * 1024 * 1024, new File(dest, "main.5.com.game.obb").length());
        assertTrue(new File(dest, "patch.5.com.game.obb").isFile());
        assertTrue(!main.file.exists());
        assertTrue(!new File(dest, "main.5.com.game.obb.part").exists());
        long[] last = seen.get(seen.size() - 1);
        assertEquals(last[1], last[0]);
    }

    @Test
    public void sameSizeFileIsKept_differentSizeIsReplaced() throws Exception {
        File src = tmp();
        File dest = tmp();
        obb(dest, "main.1.com.game.obb", 100);
        obb(dest, "patch.1.com.game.obb", 50);
        BundleInfo.ObbFile same = obb(src, "main.1.com.game.obb", 100);
        BundleInfo.ObbFile other = obb(src, "patch.1.com.game.obb", 60);
        ObbInstaller.Result r = ObbInstaller.copy(Arrays.asList(same, other), dest, null);
        assertEquals(2, r.files.size());
        assertEquals(1, r.written.size()); // only the replaced one was written
        assertEquals(60, new File(dest, "patch.1.com.game.obb").length());
    }

    @Test
    public void unsafeNamesAreRefused_andNothingIsLeftBehind() throws Exception {
        File src = tmp();
        File dest = new File(tmp(), "obb/com.game");
        BundleInfo.ObbFile good = obb(src, "main.1.com.game.obb", 10);
        File evil = new File(src, "evil.obb");
        Files.write(evil.toPath(), new byte[5]);
        BundleInfo.ObbFile bad = new BundleInfo.ObbFile(evil, "com.game", "../../evil.obb");
        try {
            ObbInstaller.copy(Arrays.asList(good, bad), dest, null);
            throw new AssertionError("should have failed");
        } catch (BundleException e) {
            assertEquals(InstallErrors.Kind.OBB_COPY, InstallErrors.classify(e.getMessage()));
        }
        assertTrue(!dest.exists()); // the folder this call created is removed again
        assertTrue(!ObbInstallerNames.safe(".."));
        assertTrue(ObbInstallerNames.safe("main.12.com.game.obb"));
    }

    @Test
    public void rollbackDeletesWhatWasWritten() throws Exception {
        File src = tmp();
        File dest = new File(tmp(), "obb/com.game");
        ObbInstaller.Result r = ObbInstaller.copy(Arrays.asList(obb(src, "main.2.com.game.obb", 20)), dest, null);
        assertTrue(new File(dest, "main.2.com.game.obb").exists());
        ObbInstaller.delete(r);
        assertTrue(!dest.exists());
    }

    @Test
    public void noObbFiles_doesNothing() throws Exception {
        File dest = new File(tmp(), "never");
        ObbInstaller.Result r = ObbInstaller.copy(new ArrayList<BundleInfo.ObbFile>(), dest, null);
        assertTrue(r.files.isEmpty());
        assertTrue(!dest.exists());
    }

    @Test
    public void spaceErrorsAreSortedAsObbErrors() {
        assertEquals(InstallErrors.Kind.OBB_COPY, InstallErrors.classify(InstallErrors.MSG_OBB_NO_SPACE));
        assertEquals(InstallErrors.Kind.NOT_ENOUGH_SPACE, InstallErrors.classify(InstallErrors.MSG_NOT_ENOUGH_SPACE));
    }

    /** isSafeName is package private; reach it from the same package. */
    private static final class ObbInstallerNames {
        static boolean safe(String n) {
            return ObbInstallerAccess.safe(n);
        }
    }
}

final class ObbInstallerAccess {
    static boolean safe(String n) {
        return ObbInstaller.isSafeName(n);
    }
}
