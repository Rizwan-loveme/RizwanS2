package top.niunaijun.blackbox.utils.bundle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SplitFieldsTest {

    @Test
    public void usable_needsMatchingNonEmptyArrays() {
        assertTrue(SplitFields.usable(new String[]{"config.arm64_v8a"}, new String[]{"/a/split_config.arm64_v8a.apk"}));
        assertTrue(SplitFields.usable(new String[]{"a", "b"}, new String[]{"/x/a.apk", "/x/b.apk"}));
    }

    @Test
    public void usable_rejectsNullEmptyAndMismatch() {
        assertFalse(SplitFields.usable(null, null));
        assertFalse(SplitFields.usable(new String[0], new String[0]));
        assertFalse(SplitFields.usable(new String[]{"a"}, null));
        assertFalse(SplitFields.usable(null, new String[]{"/x/a.apk"}));
        assertFalse(SplitFields.usable(new String[]{"a", "b"}, new String[]{"/x/a.apk"}));
        assertFalse(SplitFields.usable(new String[]{"a"}, new String[]{""}));
        assertFalse(SplitFields.usable(new String[]{"a"}, new String[]{null}));
    }

    @Test
    public void copy_isIndependentOfTheOriginal() {
        String[] src = {"/a.apk", "/b.apk"};
        String[] c = SplitFields.copy(src);
        assertNotSame(src, c);
        assertArrayEquals(src, c);
        c[0] = "/changed.apk";
        assertArrayEquals(new String[]{"/a.apk", "/b.apk"}, src);
        assertNull(SplitFields.copy(null));
    }
}
