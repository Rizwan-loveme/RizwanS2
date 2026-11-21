package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AbiCheckTest {

    private static final List<String> ARM64 = Arrays.asList("arm64-v8a");
    private static final List<String> ARM32 = Arrays.asList("armeabi-v7a", "armeabi");

    private static File zip(File dir, String name, String... entries) throws Exception {
        File f = new File(dir, name);
        try (ZipOutputStream z = new ZipOutputStream(new FileOutputStream(f))) {
            for (String e : entries) {
                z.putNextEntry(new ZipEntry(e));
                z.write(1);
                z.closeEntry();
            }
        }
        return f;
    }

    @Test
    public void playStoreBundle_librariesOnlyInTheAbiSplit_areSeen() throws Exception {
        File d = Files.createTempDirectory("abi").toFile();
        File base = zip(d, "base.apk", "classes.dex");                       // no libs in base
        File abi = zip(d, "split_config.arm64_v8a.apk", "lib/arm64-v8a/libg.so");
        AbiCheck.Result r = AbiCheck.check(Arrays.asList(base, abi), ARM64);
        assertTrue(r.toString(), r.supported);
        assertEquals("arm64-v8a", r.abi);
        // the base APK alone looks like pure Java, so it was "supported" before for any box:
        assertTrue(AbiCheck.check(Arrays.asList(base), ARM32).supported);
        // with the split the 32-bit box is correctly refused
        AbiCheck.Result r32 = AbiCheck.check(Arrays.asList(base, abi), ARM32);
        assertFalse(r32.supported);
        assertTrue(r32.message(), r32.message().contains("arm64-v8a"));
        assertTrue(r32.message(), r32.message().contains("armeabi-v7a"));
    }

    @Test
    public void pureJavaApp_isSupported() throws Exception {
        File d = Files.createTempDirectory("abi").toFile();
        AbiCheck.Result r = AbiCheck.check(Arrays.asList(zip(d, "a.apk", "classes.dex")), ARM64);
        assertTrue(r.supported);
        assertNull(r.abi);
        assertEquals("", r.message());
    }

    @Test
    public void x86OnlyApp_isNotSupported_likeTheInstaller() throws Exception {
        File d = Files.createTempDirectory("abi").toFile();
        File a = zip(d, "a.apk", "lib/x86/libx.so", "lib/x86_64/libx.so");
        AbiCheck.Result r = AbiCheck.check(Arrays.asList(a), ARM64);
        assertFalse(r.supported);
        assertEquals("This app does not run on this phone: it only has native code for x86, x86_64, but the box needs arm64-v8a.",
                r.message());
    }

    @Test
    public void v7Libs_runInA32BitBox_notIn64BitBox() throws Exception {
        File d = Files.createTempDirectory("abi").toFile();
        File a = zip(d, "a.apk", "lib/armeabi-v7a/libx.so");
        assertTrue(AbiCheck.check(Arrays.asList(a), ARM32).supported);
        assertFalse(AbiCheck.check(Arrays.asList(a), ARM64).supported);
    }

    @Test
    public void legacyArmeabi_runsInA32BitBox() throws Exception {
        File d = Files.createTempDirectory("abi").toFile();
        File a = zip(d, "a.apk", "lib/armeabi/libx.so");
        assertTrue(AbiCheck.check(Arrays.asList(a), ARM32).supported);
    }

    @Test
    public void installerAndCheckAgree() throws Exception {
        File d = Files.createTempDirectory("abi").toFile();
        File base = zip(d, "b.apk", "classes.dex");
        File abi = zip(d, "s.apk", "lib/arm64-v8a/libg.so");
        for (List<String> device : Arrays.asList(ARM64, ARM32)) {
            boolean check = AbiCheck.check(Arrays.asList(base, abi), device).supported;
            boolean installs;
            try {
                NativeLibInstaller.install(Arrays.asList(base, abi), device, new File(d, "lib"), true);
                installs = true;
            } catch (BundleException e) {
                installs = false;
            }
            assertEquals(device.toString(), check, installs);
        }
    }

    @Test
    public void unreadableFile_countsAsNoLibraries() throws Exception {
        File d = Files.createTempDirectory("abi").toFile();
        File bad = new File(d, "bad.apk");
        Files.write(bad.toPath(), "not a zip".getBytes());
        assertTrue(AbiCheck.check(Arrays.asList(bad), ARM64).supported);
        assertTrue(AbiCheck.check(Arrays.asList(new File(d, "missing.apk")), ARM64).supported);
    }
}
