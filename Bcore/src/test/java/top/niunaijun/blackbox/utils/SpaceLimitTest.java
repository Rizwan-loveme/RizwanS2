package top.niunaijun.blackbox.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpaceLimitTest {

    @Test
    public void clamp_keepsTheLimitInRange() {
        assertEquals(1, SpaceLimit.clamp(0));
        assertEquals(1, SpaceLimit.clamp(-7));
        assertEquals(10, SpaceLimit.clamp(10));
        assertEquals(SpaceLimit.HARD_MAX, SpaceLimit.clamp(500));
    }

    @Test
    public void firstFree_skipsUsedSpaces() {
        Set<Integer> used = new HashSet<>(Arrays.asList(0, 1, 3));
        assertEquals(2, SpaceLimit.firstFree(used, 10));
        assertEquals(0, SpaceLimit.firstFree(new HashSet<Integer>(), 10));
        assertEquals(0, SpaceLimit.firstFree(null, 10));
    }

    @Test
    public void firstFree_returnsMinusOneWhenTheLimitIsReached() {
        Set<Integer> used = new HashSet<>(Arrays.asList(0, 1, 2));
        assertEquals(-1, SpaceLimit.firstFree(used, 3));
        assertEquals(3, SpaceLimit.firstFree(used, 4));
    }

    @Test
    public void firstFree_loweredLimitStillCountsFreeLowSpaces() {
        // a clone sits in space 7, the limit was lowered to 3: spaces 0..2 are still free to use
        Set<Integer> used = new HashSet<>(Arrays.asList(7));
        assertEquals(0, SpaceLimit.firstFree(used, 3));
    }

    @Test
    public void duplicates_findsAppsInSeveralSpaces() {
        Set<String> d = SpaceLimit.duplicates(Arrays.asList("a.b", "c.d", "a.b", "e.f", "a.b", "c.d"));
        assertEquals(new HashSet<>(Arrays.asList("a.b", "c.d")), d);
        assertFalse(d.contains("e.f"));
        assertTrue(SpaceLimit.duplicates(Arrays.asList("x", "y")).isEmpty());
        assertTrue(SpaceLimit.duplicates(null).isEmpty());
    }
}
