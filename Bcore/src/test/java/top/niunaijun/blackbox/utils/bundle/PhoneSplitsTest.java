package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneSplitsTest {

    private static File file(File dir, String name) throws Exception {
        File f = new File(dir, name);
        Files.write(f.toPath(), new byte[]{1});
        return f;
    }

    @Test
    public void read_returnsTheRealSplitFilesInPhoneOrder() throws Exception {
        File d = Files.createTempDirectory("phone").toFile();
        File base = file(d, "base.apk");
        File abi = file(d, "split_config.arm64_v8a.apk");
        File dpi = file(d, "split_config.xxhdpi.apk");
        List<String> r = PhoneSplits.read("com.x", base.getPath(),
                new String[]{abi.getPath(), dpi.getPath()});
        assertEquals(Arrays.asList(abi.getAbsolutePath(), dpi.getAbsolutePath()), r);
    }

    @Test
    public void read_noSplitsMeansEmptyList() throws Exception {
        assertTrue(PhoneSplits.read("com.x", "/a/base.apk", null).isEmpty());
        assertTrue(PhoneSplits.read("com.x", "/a/base.apk", new String[0]).isEmpty());
    }

    @Test
    public void read_skipsNullEmptyBaseAndDuplicates() throws Exception {
        File d = Files.createTempDirectory("phone").toFile();
        File base = file(d, "base.apk");
        File abi = file(d, "split_config.arm64_v8a.apk");
        List<String> r = PhoneSplits.read("com.x", base.getPath(),
                new String[]{null, "", base.getPath(), abi.getPath(), abi.getPath()});
        assertEquals(Collections.singletonList(abi.getAbsolutePath()), r);
    }

    @Test
    public void read_missingSplitIsAnErrorWithTheFileName() throws Exception {
        File d = Files.createTempDirectory("phone").toFile();
        File base = file(d, "base.apk");
        try {
            PhoneSplits.read("com.play.app", base.getPath(), new String[]{new File(d, "split_gone.apk").getPath()});
            fail("expected BundleException");
        } catch (BundleException e) {
            assertTrue(e.getMessage(), e.getMessage().contains("split_gone.apk"));
            assertTrue(e.getMessage(), e.getMessage().contains("com.play.app"));
            assertTrue(e.getMessage(), e.getMessage().contains("not found"));
        }
    }

    @Test
    public void changed_sameFilesInAnyOrder_isNotChanged() {
        assertFalse(PhoneSplits.changed("/d/base.apk", Arrays.asList("/d/a.apk", "/d/b.apk"),
                "/d/base.apk", new String[]{"/d/b.apk", "/d/a.apk"}));
    }

    @Test
    public void changed_phoneListingTheBaseAsASplitIsIgnored() {
        assertFalse(PhoneSplits.changed("/d/base.apk", Collections.<String>emptyList(),
                "/d/base.apk", new String[]{"/d/base.apk"}));
    }

    @Test
    public void changed_updateMovesTheFolder() {
        assertTrue(PhoneSplits.changed("/data/app/x-1/base.apk", Arrays.asList("/data/app/x-1/a.apk"),
                "/data/app/x-2/base.apk", new String[]{"/data/app/x-2/a.apk"}));
    }

    @Test
    public void changed_newSplitOnThePhone() {
        assertTrue(PhoneSplits.changed("/d/base.apk", Arrays.asList("/d/a.apk"),
                "/d/base.apk", new String[]{"/d/a.apk", "/d/b.apk"}));
    }

    @Test
    public void changed_cloneMadeBeforeSplitSupport_isReadAgain() {
        // nothing stored (null), the phone's copy has splits now
        assertTrue(PhoneSplits.changed("/d/base.apk", (String[]) null,
                "/d/base.apk", new String[]{"/d/a.apk"}));
        // nothing stored and the phone's copy has no splits: nothing to do
        assertFalse(PhoneSplits.changed("/d/base.apk", (String[]) null, "/d/base.apk", null));
    }

    @Test
    public void changed_splitRemovedOnThePhone() {
        assertTrue(PhoneSplits.changed("/d/base.apk", Arrays.asList("/d/a.apk"), "/d/base.apk", null));
    }

    @Test
    public void runsInBox_followsTheBoxBitness() {
        List<String> box64 = Arrays.asList("arm64-v8a");
        List<String> box32 = Arrays.asList("armeabi-v7a", "armeabi");
        assertTrue(PhoneSplits.runsInBox("arm64-v8a", box64));
        assertFalse(PhoneSplits.runsInBox("arm64-v8a", box32));
        assertTrue(PhoneSplits.runsInBox("armeabi-v7a", box32));
        assertFalse(PhoneSplits.runsInBox("armeabi-v7a", box64));
        assertTrue(PhoneSplits.runsInBox("armeabi", box32));
        assertFalse(PhoneSplits.runsInBox("x86_64", box64));
    }

    @Test
    public void runsInBox_pureJavaAppAlwaysRuns() {
        assertTrue(PhoneSplits.runsInBox(null, Arrays.asList("arm64-v8a")));
        assertTrue(PhoneSplits.runsInBox("", Arrays.asList("armeabi-v7a")));
    }

    // ---- independent copy mode (part 20)

    @Test
    public void isInsideRoot_copyInBoxVsPhoneFile() {
        java.io.File root = new java.io.File("/data/user/0/com.srizwan.win11/blackbox");
        org.junit.Assert.assertTrue(PhoneSplits.isInsideRoot(
                "/data/user/0/com.srizwan.win11/blackbox/data/app/com.x/base.apk", root));
        org.junit.Assert.assertFalse(PhoneSplits.isInsideRoot(
                "/data/app/~~abc==/com.x-xyz==/base.apk", root));
        // a folder with the same start is not inside
        org.junit.Assert.assertFalse(PhoneSplits.isInsideRoot(
                "/data/user/0/com.srizwan.win11/blackbox2/base.apk", root));
        // the root itself is not inside itself
        org.junit.Assert.assertFalse(PhoneSplits.isInsideRoot(root.getPath(), root));
        org.junit.Assert.assertFalse(PhoneSplits.isInsideRoot(null, root));
        org.junit.Assert.assertFalse(PhoneSplits.isInsideRoot("/a/b.apk", null));
    }

    @Test
    public void spaceNeededForCopy_twiceTheApksPlusMargin() {
        org.junit.Assert.assertEquals(2L * 100_000_000L + PhoneSplits.COPY_SPACE_MARGIN,
                PhoneSplits.spaceNeededForCopy(100_000_000L));
        org.junit.Assert.assertEquals(PhoneSplits.COPY_SPACE_MARGIN, PhoneSplits.spaceNeededForCopy(0));
        org.junit.Assert.assertEquals(PhoneSplits.COPY_SPACE_MARGIN, PhoneSplits.spaceNeededForCopy(-5));
    }
}

