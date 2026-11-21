package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class NativeLibInstallerTest {

    private static final List<String> ARM64 = Arrays.asList("arm64-v8a");
    private static final List<String> ARM32 = Arrays.asList("armeabi-v7a", "armeabi");

    /** One entry for {@link #zip}. */
    private static final class E {
        final String name;
        final String content;
        final boolean stored;
        final boolean aligned;

        E(String name, String content, boolean stored, boolean aligned) {
            this.name = name;
            this.content = content;
            this.stored = stored;
            this.aligned = aligned;
        }
    }

    private static E deflated(String name, String content) {
        return new E(name, content, false, false);
    }

    private static E stored(String name, String content, boolean aligned) {
        return new E(name, content, true, aligned);
    }

    private static class Counting extends FilterOutputStream {
        long count;

        Counting(OutputStream out) {
            super(out);
        }

        @Override
        public void write(int b) throws IOException {
            out.write(b);
            count++;
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            out.write(b, off, len);
            count += len;
        }
    }

    private static File zip(File dir, String name, E... entries) throws IOException {
        dir.mkdirs();
        File f = new File(dir, name);
        Counting counting = new Counting(new FileOutputStream(f));
        ZipOutputStream zos = new ZipOutputStream(counting);
        for (E e : entries) {
            byte[] data = e.content.getBytes("UTF-8");
            ZipEntry ze = new ZipEntry(e.name);
            if (e.stored) {
                CRC32 crc = new CRC32();
                crc.update(data);
                ze.setMethod(ZipEntry.STORED);
                ze.setSize(data.length);
                ze.setCompressedSize(data.length);
                ze.setCrc(crc.getValue());
                if (e.aligned) {
                    // pad the extra field so that the data starts on a 16 KB boundary
                    long headerEnd = counting.count + 30 + e.name.getBytes("UTF-8").length;
                    int pad = (int) ((ApkNativeLibs.PAGE_ALIGNMENT - headerEnd % ApkNativeLibs.PAGE_ALIGNMENT)
                            % ApkNativeLibs.PAGE_ALIGNMENT);
                    if (pad > 0 && pad < 4) {
                        pad += ApkNativeLibs.PAGE_ALIGNMENT;
                    }
                    if (pad > 0) {
                        byte[] extra = new byte[pad];
                        extra[0] = (byte) 0x35;   // 0xD935, the zipalign padding id
                        extra[1] = (byte) 0xD9;
                        extra[2] = (byte) ((pad - 4) & 0xFF);
                        extra[3] = (byte) (((pad - 4) >> 8) & 0xFF);
                        ze.setExtra(extra);
                    }
                }
            }
            zos.putNextEntry(ze);
            zos.write(data);
            zos.closeEntry();
        }
        zos.close();
        return f;
    }

    private static File tmp() throws IOException {
        return Files.createTempDirectory("nl").toFile();
    }

    private static String read(File f) throws IOException {
        return new String(Files.readAllBytes(f.toPath()), "UTF-8");
    }

    // ------------------------------------------------------------------ scanning

    @Test
    public void scan_readsAbiNamesAndMappableState() throws Exception {
        File dir = tmp();
        File apk = zip(dir, "a.apk",
                deflated("classes.dex", "dex"),
                deflated("lib/arm64-v8a/libz.so", "Z"),
                stored("lib/arm64-v8a/liba.so", "A", true),
                stored("lib/x86/libb.so", "B", false));
        List<ApkNativeLibs.Lib> libs = ApkNativeLibs.scan(apk);
        assertEquals(3, libs.size());
        for (ApkNativeLibs.Lib l : libs) {
            switch (l.fileName) {
                case "libz.so":
                    assertEquals("arm64-v8a", l.abi);
                    assertFalse(l.stored);
                    assertFalse(l.mappable);
                    break;
                case "liba.so":
                    assertTrue(l.stored);
                    assertTrue(l.toString(), l.mappable);
                    break;
                case "libb.so":
                    assertEquals("x86", l.abi);
                    assertTrue(l.stored);
                    assertFalse(l.mappable);
                    break;
                default:
                    fail(l.toString());
            }
        }
    }

    @Test
    public void parseLibEntry_rejectsUnsafeNames() {
        assertNull(ApkNativeLibs.parseLibEntry("lib/arm64-v8a/sub/libx.so"));
        assertNull(ApkNativeLibs.parseLibEntry("lib/arm64-v8a/../libx.so"));
        assertNull(ApkNativeLibs.parseLibEntry("lib/../libx.so"));
        assertNull(ApkNativeLibs.parseLibEntry("lib/arm64-v8a/libx.txt"));
        assertNull(ApkNativeLibs.parseLibEntry("lib/arm64-v8a/"));
        assertNull(ApkNativeLibs.parseLibEntry("lib\\arm64-v8a\\libx.so"));
        assertNull(ApkNativeLibs.parseLibEntry("assets/lib/arm64-v8a/libx.so"));
        assertEquals("libx.so", ApkNativeLibs.parseLibEntry("lib/arm64-v8a/libx.so")[1]);
    }

    // ------------------------------------------------------------------ installing

    @Test
    public void extractsLibsOfAbiSplit_andBase() throws Exception {
        File dir = tmp();
        File base = zip(dir, "base.apk", deflated("classes.dex", "d"), deflated("lib/arm64-v8a/libbase.so", "BASE"));
        File abi = zip(dir, "split_config.arm64_v8a.apk",
                deflated("lib/arm64-v8a/libgame.so", "GAME"), deflated("lib/arm64-v8a/libfmod.so", "FMOD"));
        File lib = new File(dir, "app/lib");

        NativeLibInstaller.Result r = NativeLibInstaller.install(Arrays.asList(base, abi), ARM64, lib, true);

        assertEquals("arm64-v8a", r.abi);
        assertEquals(3, r.extracted);
        assertEquals("GAME", read(new File(lib, "libgame.so")));
        assertEquals("FMOD", read(new File(lib, "libfmod.so")));
        assertEquals("BASE", read(new File(lib, "libbase.so")));
        assertTrue(r.mappedApks.isEmpty());
        assertEquals(0, lib.listFiles((d, n) -> n.endsWith(".tmp")).length);
    }

    @Test
    public void usesOneAbiOnly_inOrderOfTheDeviceList() throws Exception {
        File dir = tmp();
        File apk = zip(dir, "a.apk",
                deflated("lib/armeabi-v7a/libv7.so", "V7"),
                deflated("lib/arm64-v8a/libv8.so", "V8"),
                deflated("lib/x86/libx.so", "X"));
        File lib = new File(dir, "lib");
        NativeLibInstaller.Result r = NativeLibInstaller.install(Arrays.asList(apk),
                Arrays.asList("arm64-v8a", "armeabi-v7a"), lib, true);
        assertEquals("arm64-v8a", r.abi);
        assertEquals(Arrays.asList("libv8.so"), Arrays.asList(lib.list()));
    }

    @Test
    public void abiSplitDecidesAcrossApks() throws Exception {
        // base has v7 libs only, the split has arm64 only: the first device ABI that exists in ANY apk wins
        File dir = tmp();
        File base = zip(dir, "base.apk", deflated("lib/armeabi-v7a/libold.so", "OLD"));
        File split = zip(dir, "s.apk", deflated("lib/arm64-v8a/libnew.so", "NEW"));
        File lib = new File(dir, "lib");
        NativeLibInstaller.Result r = NativeLibInstaller.install(Arrays.asList(base, split),
                Arrays.asList("arm64-v8a", "armeabi-v7a"), lib, true);
        assertEquals("arm64-v8a", r.abi);
        assertEquals(Arrays.asList("libnew.so"), Arrays.asList(lib.list()));
    }

    @Test
    public void wrongArchitecture_givesClearError() throws Exception {
        File dir = tmp();
        File apk = zip(dir, "a.apk", deflated("lib/x86_64/libx.so", "X"), deflated("lib/x86/libx.so", "X"));
        try {
            NativeLibInstaller.install(Arrays.asList(apk), ARM64, new File(dir, "lib"), true);
            fail("expected BundleException");
        } catch (BundleException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("does not run on this phone"));
            assertTrue(e.getMessage(), e.getMessage().contains("x86, x86_64"));
            assertTrue(e.getMessage(), e.getMessage().contains("arm64-v8a"));
        }
    }

    @Test
    public void appWithoutNativeCode_isFine_andOldLibsAreRemoved() throws Exception {
        File dir = tmp();
        File apk = zip(dir, "a.apk", deflated("classes.dex", "d"));
        File lib = new File(dir, "lib");
        lib.mkdirs();
        Files.write(new File(lib, "libstale.so").toPath(), "x".getBytes());
        NativeLibInstaller.Result r = NativeLibInstaller.install(Arrays.asList(apk), ARM64, lib, true);
        assertFalse(r.hasNativeCode());
        assertNull(r.abi);
        assertEquals(0, lib.list().length);
    }

    @Test
    public void update_removesLibsThatNoLongerExist() throws Exception {
        File dir = tmp();
        File lib = new File(dir, "lib");
        File v1 = zip(dir, "v1.apk", deflated("lib/arm64-v8a/libold.so", "1"), deflated("lib/arm64-v8a/libkeep.so", "1"));
        File v2 = zip(dir, "v2.apk", deflated("lib/arm64-v8a/libkeep.so", "2"));
        NativeLibInstaller.install(Arrays.asList(v1), ARM64, lib, true);
        NativeLibInstaller.install(Arrays.asList(v2), ARM64, lib, true);
        assertEquals(Arrays.asList("libkeep.so"), Arrays.asList(lib.list()));
        assertEquals("2", read(new File(lib, "libkeep.so")));
    }

    @Test
    public void extractNativeLibsFalse_mappableApkIsLeftInPlace() throws Exception {
        File dir = tmp();
        File base = zip(dir, "base.apk", deflated("classes.dex", "d"));
        File abi = zip(dir, "split_config.arm64_v8a.apk",
                stored("lib/arm64-v8a/liba.so", "A", true), stored("lib/arm64-v8a/libb.so", "B", true));
        File lib = new File(dir, "lib");
        NativeLibInstaller.Result r = NativeLibInstaller.install(Arrays.asList(base, abi), ARM64, lib, false);
        assertEquals("arm64-v8a", r.abi);
        assertEquals(0, r.extracted);
        assertEquals(Arrays.asList(abi.getAbsolutePath()), r.mappedApks);
        assertEquals(0, lib.list().length);
    }

    @Test
    public void extractNativeLibsFalse_butCompressedOrUnaligned_isExtractedAnyway() throws Exception {
        File dir = tmp();
        File compressed = zip(dir, "c.apk", deflated("lib/arm64-v8a/liba.so", "A"));
        File unaligned = zip(dir, "u.apk", stored("lib/arm64-v8a/libb.so", "B", false));
        File lib = new File(dir, "lib");
        NativeLibInstaller.Result r = NativeLibInstaller.install(Arrays.asList(compressed, unaligned), ARM64, lib, false);
        assertEquals(2, r.extracted);
        assertTrue(r.mappedApks.isEmpty());
        assertEquals("A", read(new File(lib, "liba.so")));
        assertEquals("B", read(new File(lib, "libb.so")));
    }

    @Test
    public void legacyArmeabiLibs_runOnV7Device() throws Exception {
        File dir = tmp();
        File apk = zip(dir, "a.apk", deflated("lib/armeabi/libold.so", "O"));
        NativeLibInstaller.Result r = NativeLibInstaller.install(Arrays.asList(apk), ARM32, new File(dir, "lib"), true);
        assertEquals("armeabi", r.abi);
        assertEquals(1, r.extracted);
    }

    @Test
    public void libPathsMatchTheFramework() {
        List<String> codes = Arrays.asList("/a/base.apk", "/a/split_x.apk");
        assertEquals(Arrays.asList("/a/lib"), NativeLibPaths.build("/a/lib", codes, "arm64-v8a", true));
        assertEquals(Arrays.asList("/a/lib", "/a/base.apk!/lib/arm64-v8a", "/a/split_x.apk!/lib/arm64-v8a"),
                NativeLibPaths.build("/a/lib", codes, "arm64-v8a", false));
        assertEquals(Arrays.asList("/a/lib"), NativeLibPaths.build("/a/lib", codes, null, false));
        assertEquals("/a/lib:/a/base.apk!/lib/arm64-v8a",
                NativeLibPaths.join(NativeLibPaths.build("/a/lib", Arrays.asList("/a/base.apk"), "arm64-v8a", false)));
    }

    @Test
    public void zipWithoutExtraBytes_isReadByFallbackToo() throws Exception {
        // an APK with a trailing comment still has its end record found
        File dir = tmp();
        File apk = zip(dir, "a.apk", deflated("lib/arm64-v8a/libq.so", "Q"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(Files.readAllBytes(apk.toPath()));
        // set a 3-byte comment in the end record
        byte[] all = bos.toByteArray();
        all[all.length - 2] = 3;
        all[all.length - 1] = 0;
        byte[] withComment = Arrays.copyOf(all, all.length + 3);
        Files.write(apk.toPath(), withComment);
        List<ApkNativeLibs.Lib> libs = ApkNativeLibs.scan(apk);
        assertEquals(1, libs.size());
        assertEquals("libq.so", libs.get(0).fileName);
        List<String> unused = new ArrayList<>();
        assertTrue(unused.isEmpty());
    }
}
