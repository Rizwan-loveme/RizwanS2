package top.niunaijun.blackbox.core.system.permission;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PermissionRequestPlanTest {

    private static final String CAM = "android.permission.CAMERA";
    private static final String MIC = "android.permission.RECORD_AUDIO";
    private static final String FINE = "android.permission.ACCESS_FINE_LOCATION";
    private static final String COARSE = "android.permission.ACCESS_COARSE_LOCATION";
    private static final String INTERNET = "android.permission.INTERNET";

    private static PermissionRequestPlan.ModeSource modes(final Map<String, Integer> m, final int fallback) {
        return new PermissionRequestPlan.ModeSource() {
            @Override
            public int modeOf(String permission) {
                Integer v = m.get(permission);
                return v == null ? fallback : v;
            }
        };
    }

    private static final PermissionRequestPlan.OtherResolver OTHER_GRANTED = new PermissionRequestPlan.OtherResolver() {
        @Override
        public int resultOf(String permission) {
            return PermissionRequestPlan.RESULT_GRANTED;
        }
    };

    @Test
    public void allowAndDenyNeedNoDialog() {
        Map<String, Integer> m = new HashMap<>();
        m.put(CAM, PermissionStore.MODE_ALLOW);
        m.put(MIC, PermissionStore.MODE_DENY);
        PermissionRequestPlan p = PermissionRequestPlan.build(new String[]{CAM, MIC}, modes(m, PermissionStore.MODE_ALLOW));
        assertFalse(p.needsDialog());
        assertTrue(p.hasManaged());
        assertArrayEquals(new int[]{PermissionRequestPlan.RESULT_GRANTED, PermissionRequestPlan.RESULT_DENIED},
                p.resolve(null, OTHER_GRANTED));
    }

    @Test
    public void askPermissionsOfOneGroupShareOneQuestion() {
        PermissionRequestPlan p = PermissionRequestPlan.build(new String[]{FINE, CAM, COARSE},
                modes(new HashMap<String, Integer>(), PermissionStore.MODE_ASK));
        assertTrue(p.needsDialog());
        assertEquals(2, p.askSteps.size());
        assertEquals(PermissionCatalog.LOCATION, p.askSteps.get(0).groupId);   // order of the request
        assertEquals(2, p.askSteps.get(0).permissions.size());
        assertEquals(PermissionCatalog.CAMERA, p.askSteps.get(1).groupId);
    }

    @Test
    public void answersAreAppliedPerGroupInRequestOrder() {
        PermissionRequestPlan p = PermissionRequestPlan.build(new String[]{FINE, CAM, COARSE},
                modes(new HashMap<String, Integer>(), PermissionStore.MODE_ASK));
        Map<String, Boolean> answers = new HashMap<>();
        answers.put(PermissionCatalog.LOCATION, true);
        answers.put(PermissionCatalog.CAMERA, false);
        assertArrayEquals(new int[]{0, -1, 0}, p.resolve(answers, OTHER_GRANTED));
    }

    @Test
    public void unansweredAskIsDenied() {
        PermissionRequestPlan p = PermissionRequestPlan.build(new String[]{CAM},
                modes(new HashMap<String, Integer>(), PermissionStore.MODE_ASK));
        assertArrayEquals(new int[]{-1}, p.resolve(new HashMap<String, Boolean>(), OTHER_GRANTED));
        assertArrayEquals(new int[]{-1}, p.resolve(null, null));
    }

    @Test
    public void unmanagedPermissionsKeepTheOldBehaviour() {
        PermissionRequestPlan p = PermissionRequestPlan.build(new String[]{INTERNET},
                modes(new HashMap<String, Integer>(), PermissionStore.MODE_DENY));
        assertFalse(p.hasManaged());        // the hook leaves such a request to the system
        assertFalse(p.needsDialog());
        assertArrayEquals(new int[]{0}, p.resolve(null, OTHER_GRANTED));
    }

    @Test
    public void mixedRequestIsAnsweredForEveryEntry() {
        Map<String, Integer> m = new HashMap<>();
        m.put(CAM, PermissionStore.MODE_ASK);
        m.put(MIC, PermissionStore.MODE_DENY);
        PermissionRequestPlan p = PermissionRequestPlan.build(new String[]{INTERNET, CAM, MIC},
                modes(m, PermissionStore.MODE_ALLOW));
        Map<String, Boolean> answers = new HashMap<>();
        answers.put(PermissionCatalog.CAMERA, true);
        assertArrayEquals(new int[]{0, 0, -1}, p.resolve(answers, OTHER_GRANTED));
    }

    @Test
    public void nullAndEmptyRequestsAreSafe() {
        PermissionRequestPlan p = PermissionRequestPlan.build(null, modes(new HashMap<String, Integer>(), 1));
        assertFalse(p.hasManaged());
        assertFalse(p.needsDialog());
        assertEquals(0, p.resolve(null, null).length);
    }

    @Test
    public void duplicateRequestedPermissionIsAskedOnce() {
        PermissionRequestPlan p = PermissionRequestPlan.build(new String[]{CAM, CAM},
                modes(new HashMap<String, Integer>(), PermissionStore.MODE_ASK));
        assertEquals(1, p.askSteps.size());
        assertEquals(1, p.askSteps.get(0).permissions.size());
        Map<String, Boolean> a = new HashMap<>();
        a.put(PermissionCatalog.CAMERA, true);
        assertArrayEquals(new int[]{0, 0}, p.resolve(a, OTHER_GRANTED));
    }
}
