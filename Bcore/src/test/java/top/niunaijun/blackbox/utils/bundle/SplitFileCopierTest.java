package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;

public class SplitFileCopierTest {

    private static File write(File dir, String name, String content) throws IOException {
        File f = new File(dir, name);
        f.getParentFile().mkdirs();
        Files.write(f.toPath(), content.getBytes("UTF-8"));
        return f;
    }

    private static String read(String path) throws IOException {
        return new String(Files.readAllBytes(new File(path).toPath()), "UTF-8");
    }

    @Test
    public void copiesOutsideFiles_movesTempFiles_allExistInAppDir() throws Exception {
        File root = Files.createTempDirectory("t").toFile();
        File cache = new File(root, "cache");
        File phone = new File(root, "phone");
        File a = write(cache, "bundle_1/splits/a.apk", "AAA");
        File b = write(phone, "b.apk", "BBB");
        File app = new File(root, "data/app/com.x");

        String[] out = SplitFileCopier.copyAll(new String[]{a.getPath(), b.getPath()},
                new String[]{"config.arm64_v8a", "config.xxhdpi"}, app, cache);

        assertEquals(new File(app, "split_config.arm64_v8a.apk").getAbsolutePath(), out[0]);
        assertEquals(new File(app, "split_config.xxhdpi.apk").getAbsolutePath(), out[1]);
        assertEquals("AAA", read(out[0]));
        assertEquals("BBB", read(out[1]));
        assertFalse(a.exists());          // inside cache: moved
        assertTrue(b.exists());           // outside: copied, original kept
    }

    @Test
    public void failure_undoesEverything() throws Exception {
        File root = Files.createTempDirectory("t").toFile();
        File cache = new File(root, "cache");
        File a = write(cache, "a.apk", "AAA");
        File b = write(root, "b.apk", "BBB");
        File app = new File(root, "app");
        try {
            SplitFileCopier.copyAll(new String[]{a.getPath(), b.getPath(), new File(root, "gone.apk").getPath()},
                    new String[]{"s1", "s2", "s3"}, app, cache);
            fail("expected IOException");
        } catch (IOException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("gone.apk"));
        }
        assertTrue("moved file goes back", a.exists());
        assertEquals("AAA", read(a.getPath()));
        assertEquals(0, app.listFiles().length);
    }

    @Test
    public void mismatchedArrays_throw() throws Exception {
        try {
            SplitFileCopier.copyAll(new String[]{"x"}, new String[]{}, new File("/tmp"), null);
            fail();
        } catch (IOException expected) {
        }
    }

    @Test
    public void fileNames_areSafeAndUnique() {
        HashSet<String> used = new HashSet<>();
        assertEquals("split_config.en.apk", SplitFileCopier.fileNameFor("config.en", 0, used));
        assertEquals("split_config.en_1.apk", SplitFileCopier.fileNameFor("config.en", 1, used));
        assertEquals("split_a_b_c.apk", SplitFileCopier.fileNameFor("a/b\\c", 2, used));
        assertEquals("split_3.apk", SplitFileCopier.fileNameFor("", 3, used));
    }
}
