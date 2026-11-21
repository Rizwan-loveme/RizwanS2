package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SplitPickerTest {

    private static final File DIR = new File("/nonexistent-bundle-dir");

    private static List<File> files(String... names) {
        List<File> list = new ArrayList<>();
        for (String n : names) {
            list.add(new File(DIR, n));
        }
        return list;
    }

    private static DeviceProfile phone(int dpi, String... abisThenLocales) {
        List<String> abis = new ArrayList<>();
        List<String> locales = new ArrayList<>();
        for (String s : abisThenLocales) {
            if (s.contains("-") && (s.startsWith("arm") || s.startsWith("x86"))) {
                abis.add(s);
            } else if (s.equals("x86") || s.equals("x86_64")) {
                abis.add(s);
            } else {
                locales.add(s);
            }
        }
        return new DeviceProfile(abis, dpi, locales);
    }

    private static List<String> names(List<File> files) {
        List<String> out = new ArrayList<>();
        for (File f : files) {
            out.add(f.getName());
        }
        return out;
    }

    // ------------------------------------------------------------------ file name styles

    @Test
    public void xapkStyle_picksAbiDensityLanguageAndEnglish() throws Exception {
        List<File> splits = files(
                "config.arm64_v8a.apk", "config.armeabi_v7a.apk", "config.x86.apk", "config.x86_64.apk",
                "config.ldpi.apk", "config.mdpi.apk", "config.hdpi.apk", "config.xhdpi.apk",
                "config.xxhdpi.apk", "config.xxxhdpi.apk",
                "config.en.apk", "config.bn.apk", "config.de.apk", "config.fr.apk",
                "feature_video.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, Collections.<String>emptyList(),
                phone(440, "arm64-v8a", "armeabi-v7a", "bn-BD", "en-US"));
        assertEquals(Arrays.asList("config.arm64_v8a.apk", "config.bn.apk", "config.en.apk",
                "config.xxhdpi.apk", "feature_video.apk"), names(s.selected));
        assertEquals("arm64-v8a", s.abi);
        assertEquals("xxhdpi", s.density);
        assertEquals("bn", s.language);
        assertEquals(splits.size() - 5, s.skipped.size());
    }

    @Test
    public void apkmStyle() throws Exception {
        List<File> splits = files("split_config.arm64_v8a.apk", "split_config.armeabi_v7a.apk",
                "split_config.xxhdpi.apk", "split_config.hdpi.apk", "split_config.en.apk",
                "split_config.es.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, Arrays.asList("arm64-v8a", "armeabi-v7a"),
                phone(400, "arm64-v8a", "es-ES"));
        assertEquals(Arrays.asList("split_config.arm64_v8a.apk", "split_config.en.apk",
                "split_config.es.apk", "split_config.xxhdpi.apk"), names(s.selected));
    }

    @Test
    public void apksStyle_featureModuleConfigsFollowSameRules() throws Exception {
        List<File> splits = files(
                "base-arm64_v8a.apk", "base-armeabi_v7a.apk", "base-xxhdpi.apk", "base-xhdpi.apk",
                "base-en.apk", "base-pt_BR.apk", "base-pt.apk",
                "ar-master.apk", "ar-arm64_v8a.apk", "ar-armeabi_v7a.apk", "ar-xxhdpi.apk", "ar-xhdpi.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, Collections.<String>emptyList(),
                phone(480, "arm64-v8a", "pt-BR"));
        assertEquals(Arrays.asList("ar-arm64_v8a.apk", "ar-master.apk", "ar-xxhdpi.apk",
                "base-arm64_v8a.apk", "base-en.apk", "base-pt_BR.apk", "base-xxhdpi.apk"), names(s.selected));
    }

    // ------------------------------------------------------------------ individual rules

    @Test
    public void abi_followsDevicePriority_and32BitFallback() throws Exception {
        List<File> splits = files("config.arm64_v8a.apk", "config.armeabi_v7a.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, null, phone(320, "armeabi-v7a", "en"));
        assertEquals(Arrays.asList("config.armeabi_v7a.apk"), names(s.selected));
        assertEquals("armeabi-v7a", s.abi);
    }

    @Test
    public void x86_isNotConfusedWithX86_64() throws Exception {
        List<File> splits = files("config.x86.apk", "config.x86_64.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, null, phone(320, "x86_64"));
        assertEquals(Arrays.asList("config.x86_64.apk"), names(s.selected));
    }

    @Test
    public void density_closestNotBelow_elseBiggest() throws Exception {
        List<File> splits = files("config.mdpi.apk", "config.hdpi.apk", "config.xhdpi.apk");
        assertEquals("xhdpi", SplitPicker.pick(splits, null, phone(280, "arm64-v8a")).density);
        assertEquals("hdpi", SplitPicker.pick(splits, null, phone(240, "arm64-v8a")).density);
        assertEquals("xhdpi", SplitPicker.pick(splits, null, phone(560, "arm64-v8a")).density);
        assertEquals("mdpi", SplitPicker.pick(splits, null, phone(120, "arm64-v8a")).density);
    }

    @Test
    public void language_regionAndFallbacks() throws Exception {
        List<File> splits = files("config.en.apk", "config.pt.apk", "config.pt_BR.apk", "config.zh_hans.apk");
        assertEquals("pt_br", SplitPicker.pick(splits, null, phone(320, "pt-BR")).language);
        assertEquals("pt", SplitPicker.pick(splits, null, phone(320, "pt-PT")).language);
        assertEquals("zh_hans", SplitPicker.pick(splits, null, phone(320, "zh-Hans")).language);
        // second preferred language is used when the first has no split
        assertEquals("pt", SplitPicker.pick(splits, null, phone(320, "bn-BD", "pt-PT")).language);
    }

    @Test
    public void language_noMatch_onlyEnglishIsKept() throws Exception {
        List<File> splits = files("config.en.apk", "config.de.apk", "config.fr.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, null, phone(320, "arm64-v8a", "bn-BD"));
        assertEquals(Arrays.asList("config.en.apk"), names(s.selected));
        assertNull(s.language);
    }

    @Test
    public void language_deviceIsEnglish_englishKeptOnce() throws Exception {
        List<File> splits = files("config.en.apk", "config.de.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, null, phone(320, "arm64-v8a", "en-US"));
        assertEquals(Arrays.asList("config.en.apk"), names(s.selected));
    }

    @Test
    public void language_oldHebrewAndIndonesianCodes() throws Exception {
        List<File> splits = files("config.he.apk", "config.id.apk");
        assertEquals("he", SplitPicker.pick(splits, null, phone(320, "iw-IL")).language);
        assertEquals("id", SplitPicker.pick(splits, null, phone(320, "in-ID")).language);
    }

    @Test
    public void unknownConfigSplits_andFeatureSplits_areKept() throws Exception {
        List<File> splits = files("config.tcf_astc.apk", "split_dynamic_feature.apk", "base_assets.apk");
        SplitPicker.Selection s = SplitPicker.pick(splits, null, phone(320, "arm64-v8a", "en"));
        assertEquals(3, s.selected.size());
        assertTrue(s.skipped.isEmpty());
    }

    @Test
    public void noSplits_isFine() throws Exception {
        SplitPicker.Selection s = SplitPicker.pick(new ArrayList<File>(), null, phone(320, "arm64-v8a"));
        assertTrue(s.selected.isEmpty());
        assertNull(s.abi);
    }

    // ------------------------------------------------------------------ wrong architecture

    @Test
    public void wrongArchitecture_clearError() {
        List<File> splits = files("config.x86.apk", "config.x86_64.apk", "config.xxhdpi.apk");
        try {
            SplitPicker.pick(splits, null, phone(480, "arm64-v8a", "armeabi-v7a"));
            fail("expected BundleException");
        } catch (BundleException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("x86, x86_64"));
            assertTrue(e.getMessage(), e.getMessage().contains("arm64-v8a, armeabi-v7a"));
        }
    }

    @Test
    public void wrongArchitecture_32BitOnlyBundleInside64BitBox() {
        List<File> splits = files("config.armeabi_v7a.apk");
        try {
            SplitPicker.pick(splits, null, phone(480, "arm64-v8a"));
            fail("expected BundleException");
        } catch (BundleException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("armeabi-v7a"));
            assertTrue(e.getMessage(), e.getMessage().contains("arm64-v8a"));
        }
    }

    @Test
    public void wrongArchitecture_inFeatureModule_namesTheModule() {
        List<File> splits = files("base-arm64_v8a.apk", "ar-master.apk", "ar-x86.apk");
        try {
            SplitPicker.pick(splits, null, phone(480, "arm64-v8a"));
            fail("expected BundleException");
        } catch (BundleException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("\"ar\""));
        }
    }

    @Test
    public void wrongArchitecture_declaredInInfoJson() {
        try {
            SplitPicker.pick(files("config.xxhdpi.apk"), Arrays.asList("x86", "x86_64"),
                    phone(480, "arm64-v8a"));
            fail("expected BundleException");
        } catch (BundleException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("x86, x86_64"));
        }
    }

    @Test
    public void declaredAbis_universalAndMatching_areAccepted() throws Exception {
        SplitPicker.pick(files("config.xxhdpi.apk"), Arrays.asList("universal"), phone(480, "arm64-v8a"));
        SplitPicker.pick(files("config.xxhdpi.apk"), Arrays.asList("arm64-v8a", "x86"), phone(480, "arm64-v8a"));
    }

    // ------------------------------------------------------------------ manifest reader

    @Test
    public void manifestIsPreferredOverFileName() throws Exception {
        File tmp = File.createTempFile("split", ".apk");
        tmp.deleteOnExit();
        // file name says feature, manifest says ABI split of base
        writeApk(tmp, axml("config.arm64_v8a", "", false, true));
        SplitPicker.SplitInfo si = SplitPicker.describe(tmp);
        assertEquals(SplitPicker.Kind.ABI, si.kind);
        assertEquals("base", si.module);
        assertEquals("arm64_v8a", si.token);
    }

    @Test
    public void manifest_featureModuleConfigSplit() throws Exception {
        File tmp = File.createTempFile("split", ".apk");
        tmp.deleteOnExit();
        writeApk(tmp, axml("videos.config.xxhdpi", "videos", false, false));
        SplitPicker.SplitInfo si = SplitPicker.describe(tmp);
        assertEquals(SplitPicker.Kind.DENSITY, si.kind);
        assertEquals("videos", si.module);
        assertEquals("xxhdpi", si.token);
    }

    @Test
    public void manifest_configSplitWithoutConfigForSplitAttribute() throws Exception {
        File tmp = File.createTempFile("split", ".apk");
        tmp.deleteOnExit();
        writeApk(tmp, axml("config.en", null, false, false));
        SplitPicker.SplitInfo si = SplitPicker.describe(tmp);
        assertEquals(SplitPicker.Kind.LANGUAGE, si.kind);
        assertEquals("base", si.module);
    }

    @Test
    public void manifest_featureSplit_utf8Pool() throws Exception {
        File tmp = File.createTempFile("split", ".apk");
        tmp.deleteOnExit();
        writeApk(tmp, axml("game_assets", null, true, false));
        SplitPicker.SplitInfo si = SplitPicker.describe(tmp);
        assertEquals(SplitPicker.Kind.FEATURE, si.kind);
        assertEquals("game_assets", si.module);
    }

    @Test
    public void manifest_baseApkWithoutSplitAttributes_fallsBackToName() throws Exception {
        File dir = java.nio.file.Files.createTempDirectory("sp").toFile();
        File apk = new File(dir, "config.hdpi.apk");
        apk.deleteOnExit();
        dir.deleteOnExit();
        writeApk(apk, axml(null, null, false, false));
        assertEquals(SplitPicker.Kind.DENSITY, SplitPicker.describe(apk).kind);
    }

    @Test
    public void damagedManifest_fallsBackToName() throws Exception {
        File dir = java.nio.file.Files.createTempDirectory("sp").toFile();
        File apk = new File(dir, "config.xxhdpi.apk");
        apk.deleteOnExit();
        dir.deleteOnExit();
        writeApk(apk, new byte[]{3, 0, 8, 0, 1, 2, 3});
        assertEquals(SplitPicker.Kind.DENSITY, SplitPicker.describe(apk).kind);
    }

    @Test
    public void applyTo_replacesSplitList() throws Exception {
        BundleInfo info = new BundleInfo();
        info.splitApks.addAll(files("config.arm64_v8a.apk", "config.x86.apk", "config.xxhdpi.apk"));
        SplitPicker.Selection s = SplitPicker.pick(info, phone(480, "arm64-v8a", "en"));
        s.applyTo(info, false);
        assertEquals(Arrays.asList("config.arm64_v8a.apk", "config.xxhdpi.apk"), names(info.splitApks));
        assertEquals(2, s.getSelectedPaths().size());
        assertFalse(s.getSelectedPaths().get(0).isEmpty());
        assertNotNull(s.toString());
    }

    // ------------------------------------------------------------------ helpers: binary XML writer

    private static void writeApk(File target, byte[] manifest) throws Exception {
        ZipOutputStream z = new ZipOutputStream(new FileOutputStream(target));
        try {
            z.putNextEntry(new ZipEntry("AndroidManifest.xml"));
            z.write(manifest);
            z.closeEntry();
        } finally {
            z.close();
        }
    }

    /**
     * Builds a minimal binary AndroidManifest.xml: &lt;manifest split configForSplit isFeatureSplit&gt;.
     * Null attribute values are left out. Uses UTF-16 strings, or UTF-8 when {@code utf8} is true.
     */
    private static byte[] axml(String split, String configForSplit, boolean feature, boolean utf16) {
        boolean utf8 = !utf16;
        List<String> pool = new ArrayList<>();
        pool.add("manifest");
        pool.add("split");
        pool.add("configForSplit");
        pool.add("isFeatureSplit");
        if (split != null) pool.add(split);
        if (configForSplit != null) pool.add(configForSplit);

        List<int[]> attrs = new ArrayList<>(); // name, raw, type, data
        if (split != null) attrs.add(new int[]{1, pool.indexOf(split), 0x03, pool.indexOf(split)});
        if (configForSplit != null) {
            attrs.add(new int[]{2, pool.indexOf(configForSplit), 0x03, pool.indexOf(configForSplit)});
        }
        if (feature) attrs.add(new int[]{3, -1, 0x12, -1});

        ByteArrayOutputStream strData = new ByteArrayOutputStream();
        List<Integer> offsets = new ArrayList<>();
        for (String s : pool) {
            offsets.add(strData.size());
            byte[] raw;
            if (utf8) {
                byte[] b = s.getBytes(java.nio.charset.StandardCharsets.UTF_8);
                strData.write(s.length());
                strData.write(b.length);
                strData.write(b, 0, b.length);
                strData.write(0);
            } else {
                ByteBuffer bb = ByteBuffer.allocate(2 + s.length() * 2 + 2).order(ByteOrder.LITTLE_ENDIAN);
                bb.putShort((short) s.length());
                for (char c : s.toCharArray()) bb.putShort((short) c);
                bb.putShort((short) 0);
                strData.write(bb.array(), 0, bb.position());
            }
        }
        while (strData.size() % 4 != 0) strData.write(0);

        int poolHeader = 28;
        int poolSize = poolHeader + pool.size() * 4 + strData.size();
        ByteBuffer p = ByteBuffer.allocate(poolSize).order(ByteOrder.LITTLE_ENDIAN);
        p.putShort((short) 0x0001).putShort((short) poolHeader).putInt(poolSize);
        p.putInt(pool.size()).putInt(0).putInt(utf8 ? (1 << 8) : 0);
        p.putInt(poolHeader + pool.size() * 4).putInt(0);
        for (int o : offsets) p.putInt(o);
        p.put(strData.toByteArray());

        int startSize = 36 + attrs.size() * 20;
        ByteBuffer st = ByteBuffer.allocate(startSize).order(ByteOrder.LITTLE_ENDIAN);
        st.putShort((short) 0x0102).putShort((short) 16).putInt(startSize).putInt(1).putInt(-1);
        st.putInt(-1).putInt(0); // ns, name = "manifest"
        st.putShort((short) 20).putShort((short) 20).putShort((short) attrs.size());
        st.putShort((short) 0).putShort((short) 0).putShort((short) 0);
        for (int[] a : attrs) {
            st.putInt(-1).putInt(a[0]).putInt(a[1]);
            st.putShort((short) 8).put((byte) 0).put((byte) a[2]).putInt(a[3] == -1 ? -1 : a[3]);
        }

        int total = 8 + poolSize + startSize;
        ByteBuffer out = ByteBuffer.allocate(total).order(ByteOrder.LITTLE_ENDIAN);
        out.putShort((short) 0x0003).putShort((short) 8).putInt(total);
        out.put(p.array()).put(st.array());
        return out.array();
    }
}
