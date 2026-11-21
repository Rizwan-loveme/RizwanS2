package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class CodePathsTest {

    @Test
    public void baseFirst_thenSplitsInOrder() {
        assertEquals(Arrays.asList("/a/base.apk", "/a/split_x.apk", "/a/split_y.apk"),
                CodePaths.all("/a/base.apk", new String[]{"/a/split_x.apk", "/a/split_y.apk"}));
        assertEquals("/a/base.apk" + File.pathSeparator + "/a/split_x.apk",
                CodePaths.dexPath("/a/base.apk", new String[]{"/a/split_x.apk"}));
    }

    @Test
    public void noSplits_isJustTheBaseApk() {
        assertEquals("/a/base.apk", CodePaths.dexPath("/a/base.apk", null));
        assertEquals(Arrays.asList("/a/base.apk"), CodePaths.resourcePaths("/a/base.apk", new String[0]));
    }

    @Test
    public void nullEmptyAndDuplicateEntriesAreDropped() {
        assertEquals(Arrays.asList("/a/base.apk", "/a/s.apk"),
                CodePaths.all("/a/base.apk", new String[]{null, "", "/a/s.apk", "/a/s.apk", "/a/base.apk"}));
    }

    @Test
    public void noBase_meansNoDexPath() {
        assertNull(CodePaths.dexPath(null, new String[0]));
        assertTrue(CodePaths.all("", null).isEmpty());
    }

    @Test
    public void libraryPathForTheClassLoader_followsTheSplits() {
        String[] splits = {"/a/split_config.arm64_v8a.apk"};
        String lib = NativeLibPaths.join(NativeLibPaths.build("/a/lib",
                CodePaths.all("/a/base.apk", splits), "arm64-v8a", false));
        assertEquals("/a/lib:/a/base.apk!/lib/arm64-v8a:/a/split_config.arm64_v8a.apk!/lib/arm64-v8a", lib);
        assertEquals("/a/lib", NativeLibPaths.join(NativeLibPaths.build("/a/lib",
                CodePaths.all("/a/base.apk", splits), "arm64-v8a", true)));
    }
}
