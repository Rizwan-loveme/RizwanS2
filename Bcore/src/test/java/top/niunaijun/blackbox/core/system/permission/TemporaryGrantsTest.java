package top.niunaijun.blackbox.core.system.permission;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TemporaryGrantsTest {

    private static final class FakeClock implements TemporaryGrants.Clock {
        long now = 1_000;

        @Override
        public long now() {
            return now;
        }
    }

    private static final String CAM = "android.permission.CAMERA";
    private static final String MIC = "android.permission.RECORD_AUDIO";

    @Test
    public void grantIsValidUntilItExpires() {
        FakeClock c = new FakeClock();
        TemporaryGrants g = new TemporaryGrants(c);
        g.grant(0, "com.a", CAM, 5_000);
        assertTrue(g.isGranted(0, "com.a", CAM));
        c.now += 4_999;
        assertTrue(g.isGranted(0, "com.a", CAM));
        c.now += 1;
        assertFalse(g.isGranted(0, "com.a", CAM));
        assertEquals(0, g.size());
    }

    @Test
    public void grantIsOnlyForThatUserPackageAndPermission() {
        TemporaryGrants g = new TemporaryGrants(new FakeClock());
        g.grant(0, "com.a", CAM);
        assertFalse(g.isGranted(1, "com.a", CAM));
        assertFalse(g.isGranted(0, "com.b", CAM));
        assertFalse(g.isGranted(0, "com.a", MIC));
    }

    @Test
    public void clearPackageKeepsOtherPackagesAndUsers() {
        TemporaryGrants g = new TemporaryGrants(new FakeClock());
        g.grant(0, "com.a", CAM);
        g.grant(0, "com.a", MIC);
        g.grant(0, "com.ab", CAM);   // name that starts with the same letters
        g.grant(1, "com.a", CAM);
        g.clearPackage(0, "com.a");
        assertFalse(g.isGranted(0, "com.a", CAM));
        assertFalse(g.isGranted(0, "com.a", MIC));
        assertTrue(g.isGranted(0, "com.ab", CAM));
        assertTrue(g.isGranted(1, "com.a", CAM));
    }

    @Test
    public void clearUserAndClearAll() {
        TemporaryGrants g = new TemporaryGrants(new FakeClock());
        g.grant(0, "com.a", CAM);
        g.grant(10, "com.a", CAM);
        g.clearUser(1);                       // user 1 must not match user 10 / 0
        assertTrue(g.isGranted(0, "com.a", CAM));
        assertTrue(g.isGranted(10, "com.a", CAM));
        g.clearUser(10);
        assertFalse(g.isGranted(10, "com.a", CAM));
        assertTrue(g.isGranted(0, "com.a", CAM));
        g.clearAll();
        assertEquals(0, g.size());
    }

    @Test
    public void badInputIsIgnored() {
        TemporaryGrants g = new TemporaryGrants(new FakeClock());
        g.grant(0, null, CAM);
        g.grant(0, "com.a", null);
        g.grant(0, "com.a", CAM, 0);
        assertEquals(0, g.size());
        assertFalse(g.isGranted(0, null, CAM));
        assertFalse(g.isGranted(0, "com.a", null));
    }

    @Test
    public void defaultLifetimeIsThirtyMinutes() {
        FakeClock c = new FakeClock();
        TemporaryGrants g = new TemporaryGrants(c);
        g.grant(0, "com.a", CAM);
        c.now += TemporaryGrants.DEFAULT_TTL_MS - 1;
        assertTrue(g.isGranted(0, "com.a", CAM));
        c.now += 1;
        assertFalse(g.isGranted(0, "com.a", CAM));
    }
}
