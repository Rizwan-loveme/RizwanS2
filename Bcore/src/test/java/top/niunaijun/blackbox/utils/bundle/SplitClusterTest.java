package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SplitClusterTest {

    private static File write(File dir, String name, String content) throws IOException {
        File f = new File(dir, name);
        f.getParentFile().mkdirs();
        FileOutputStream out = new FileOutputStream(f);
        try {
            out.write(content.getBytes("UTF-8"));
        } finally {
            out.close();
        }
        return f;
    }

    private static String read(File f) throws IOException {
        return new String(Files.readAllBytes(f.toPath()), "UTF-8");
    }

    @Test
    public void flatFolder_baseAndSplits_mapBackToRealFiles() throws Exception {
        File root = Files.createTempDirectory("bundle").toFile();
        File base = write(root, "splits/base-master.apk", "BASE");
        File s1 = write(root, "splits/base-arm64_v8a.apk", "ABI");
        File s2 = write(root, "other/config.xxhdpi.apk", "DPI");
        File cache = new File(root, "cache");
        cache.mkdirs();

        SplitCluster c = SplitCluster.create(cache, base,
                Arrays.asList(s1.getAbsolutePath(), s2.getAbsolutePath()));
        try {
            assertEquals(3, c.size());
            File[] files = c.dir.listFiles();
            List<String> names = new ArrayList<>();
            for (File f : files) {
                assertTrue(f.isFile());
                names.add(f.getName());
            }
            Collections.sort(names);
            assertEquals(Arrays.asList("base-arm64_v8a.apk", "base.apk", "config.xxhdpi.apk"), names);
            assertEquals("BASE", read(new File(c.dir, "base.apk")));
            assertEquals(s1, c.original(new File(c.dir, "base-arm64_v8a.apk").getAbsolutePath()));
            assertEquals(base, c.original(new File(c.dir, "base.apk").getAbsolutePath()));
            assertNull(c.original("/nope"));
            assertNull(c.original(null));
        } finally {
            c.delete();
        }
        assertFalse(c.dir.exists());
        assertTrue(base.exists());   // real files are untouched
        assertTrue(s1.exists());
    }

    @Test
    public void sameNameInDifferentFolders_andReservedName_getUniqueNames() throws Exception {
        File root = Files.createTempDirectory("bundle").toFile();
        File base = write(root, "a/base.apk", "B");
        File x1 = write(root, "a/config.en.apk", "1");
        File x2 = write(root, "b/config.en.apk", "2");
        File x3 = write(root, "c/base.apk", "3");     // a split that is called base.apk
        File x4 = write(root, "d/readme.bin", "4");   // not an apk name
        SplitCluster c = SplitCluster.create(root, base, Arrays.asList(x1.getAbsolutePath(),
                x2.getAbsolutePath(), x3.getAbsolutePath(), x4.getAbsolutePath()));
        try {
            assertEquals(5, c.size());
            assertEquals(5, c.dir.listFiles().length);
            for (File f : c.dir.listFiles()) {
                assertTrue(f.getName(), f.getName().endsWith(".apk"));
                File orig = c.original(f.getAbsolutePath());
                assertNotNull(orig);
                assertEquals(read(orig), read(f));
            }
        } finally {
            c.delete();
        }
    }

    @Test
    public void missingFile_throws_andLeavesNoFolder() throws Exception {
        File root = Files.createTempDirectory("bundle").toFile();
        File base = write(root, "base.apk", "B");
        File cache = new File(root, "cache");
        cache.mkdirs();
        try {
            SplitCluster.create(cache, base, Arrays.asList(new File(root, "missing.apk").getAbsolutePath()));
            fail("expected IOException");
        } catch (IOException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("missing.apk"));
        }
        assertEquals(0, cache.listFiles().length);
    }

    @Test
    public void missingBase_throws() throws Exception {
        File root = Files.createTempDirectory("bundle").toFile();
        try {
            SplitCluster.create(root, new File(root, "nobase.apk"), new ArrayList<String>());
            fail("expected IOException");
        } catch (IOException expected) {
        }
    }
}
