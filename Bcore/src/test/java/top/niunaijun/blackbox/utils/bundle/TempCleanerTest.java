package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

public class TempCleanerTest {

    private static final long HOUR = 60L * 60L * 1000L;

    private File cache;

    @Before
    public void setUp() throws IOException {
        cache = Files.createTempDirectory("tempcleaner").toFile();
    }

    @After
    public void tearDown() {
        BundleUnpacker.deleteRecursively(cache);
        while (TempCleaner.isBusy()) {
            TempCleaner.end();
        }
    }

    private File file(String name, int bytes, long ageMs) throws IOException {
        File f = new File(cache, name);
        FileOutputStream out = new FileOutputStream(f);
        try {
            out.write(new byte[bytes]);
        } finally {
            out.close();
        }
        assertTrue(f.setLastModified(System.currentTimeMillis() - ageMs));
        return f;
    }

    private File folderWithFile(String name, long ageMs) throws IOException {
        File dir = new File(cache, name);
        assertTrue(dir.mkdirs());
        File inner = new File(dir, "splits/config.arm64_v8a.apk");
        assertTrue(inner.getParentFile().mkdirs());
        FileOutputStream out = new FileOutputStream(inner);
        try {
            out.write(new byte[100]);
        } finally {
            out.close();
        }
        inner.setLastModified(System.currentTimeMillis() - ageMs);
        inner.getParentFile().setLastModified(System.currentTimeMillis() - ageMs);
        dir.setLastModified(System.currentTimeMillis() - ageMs);
        return dir;
    }

    @Test
    public void names_onlyInstallCodeFilesMatch() {
        assertTrue(TempCleaner.isTempName("install_" + UUID.randomUUID() + ".tmp"));
        assertTrue(TempCleaner.isTempName("install_" + UUID.randomUUID() + ".apk"));
        assertTrue(TempCleaner.isTempName("bundle_1700000000000_4242"));
        assertTrue(TempCleaner.isTempName("cluster_" + UUID.randomUUID().toString().replace("-", "")));
        assertTrue(TempCleaner.isTempName(UUID.randomUUID() + ".apk"));
        assertFalse(TempCleaner.isTempName("junit.apk"));
        assertFalse(TempCleaner.isTempName("empty.apk"));
        assertFalse(TempCleaner.isTempName("base.apk"));
        assertFalse(TempCleaner.isTempName("something.jar"));
        assertFalse(TempCleaner.isTempName(null));
    }

    @Test
    public void oldLeftovers_areDeleted_otherFilesStay() throws Exception {
        File tmp = file("install_" + UUID.randomUUID() + ".tmp", 1000, 2 * HOUR);
        File uuidApk = file(UUID.randomUUID() + ".apk", 500, 2 * HOUR);
        File bundle = folderWithFile("bundle_1_2", 2 * HOUR);
        File cluster = folderWithFile("cluster_abc", 2 * HOUR);
        File junit = file("junit.apk", 10, 2 * HOUR);
        File jar = file("framework.jar", 10, 2 * HOUR);

        TempCleaner.Report r = TempCleaner.sweep(cache, TempCleaner.STALE_AGE_MS, System.currentTimeMillis());

        assertFalse(tmp.exists());
        assertFalse(uuidApk.exists());
        assertFalse(bundle.exists());
        assertFalse(cluster.exists());
        assertTrue(junit.exists());
        assertTrue(jar.exists());
        assertEquals(4, r.deleted);
        assertEquals(1000 + 500 + 100 + 100, r.freedBytes);
    }

    @Test
    public void freshFiles_ofARunningInstall_stay() throws Exception {
        File tmp = file("install_" + UUID.randomUUID() + ".tmp", 10, 1000);
        File bundle = folderWithFile("bundle_3_4", 1000);

        TempCleaner.Report r = TempCleaner.sweep(cache, TempCleaner.STALE_AGE_MS, System.currentTimeMillis());

        assertTrue(tmp.exists());
        assertTrue(bundle.exists());
        assertEquals(0, r.deleted);
    }

    @Test
    public void folderWithRecentFile_staysEvenWhenFolderIsOld() throws Exception {
        File bundle = folderWithFile("bundle_5_6", 2 * HOUR);
        // a file inside is still being written
        assertTrue(new File(bundle, "splits/config.arm64_v8a.apk").setLastModified(System.currentTimeMillis()));

        TempCleaner.sweep(cache, TempCleaner.STALE_AGE_MS, System.currentTimeMillis());

        assertTrue(bundle.exists());
    }

    @Test
    public void sweepStale_doesNothingWhileAnInstallRuns() throws Exception {
        File tmp = file("install_" + UUID.randomUUID() + ".tmp", 10, 2 * HOUR);

        TempCleaner.begin();
        try {
            assertEquals(0, TempCleaner.sweepStale(cache).deleted);
            assertTrue(tmp.exists());
        } finally {
            TempCleaner.end();
        }
        assertFalse(TempCleaner.isBusy());
        assertEquals(1, TempCleaner.sweepStale(cache).deleted);
        assertFalse(tmp.exists());
    }

    @Test
    public void maxAgeZero_deletesEverythingThatMatches() throws Exception {
        File fresh = file("install_" + UUID.randomUUID() + ".tmp", 10, 0);
        File other = file("keep.txt", 10, 0);

        TempCleaner.sweep(cache, 0, System.currentTimeMillis());

        assertFalse(fresh.exists());
        assertTrue(other.exists());
    }

    @Test
    public void link_isRemoved_itsTargetIsNot() throws Exception {
        File realDir = Files.createTempDirectory("realtarget").toFile();
        try {
            File real = new File(realDir, "real.apk");
            Files.write(real.toPath(), new byte[50]);
            File cluster = new File(cache, "cluster_links");
            assertTrue(cluster.mkdirs());
            try {
                Files.createSymbolicLink(new File(cluster, "base.apk").toPath(), real.toPath());
            } catch (UnsupportedOperationException | IOException e) {
                return; // no symlinks on this file system, nothing to test
            }
            cluster.setLastModified(System.currentTimeMillis() - 2 * HOUR);
            new File(cluster, "base.apk").setLastModified(System.currentTimeMillis() - 2 * HOUR);

            TempCleaner.sweep(cache, TempCleaner.STALE_AGE_MS, System.currentTimeMillis());

            assertFalse(cluster.exists());
            assertTrue(real.exists());
        } finally {
            BundleUnpacker.deleteRecursively(realDir);
        }
    }

    @Test
    public void missingOrNullFolder_doesNotThrow() {
        assertEquals(0, TempCleaner.sweep(null, 0, 0).deleted);
        assertEquals(0, TempCleaner.sweep(new File(cache, "nope"), 0, 0).deleted);
    }
}
