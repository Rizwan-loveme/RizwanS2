package top.niunaijun.blackbox.core.system.permission;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HostBridgePlanTest {

    private static final String CAM = "android.permission.CAMERA";
    private static final String MIC = "android.permission.RECORD_AUDIO";
    private static final String FINE = HostBridgePlan.FINE_LOCATION;
    private static final String COARSE = HostBridgePlan.COARSE_LOCATION;
    private static final String BG = HostBridgePlan.BACKGROUND_LOCATION;
    private static final String NOTIF = "android.permission.POST_NOTIFICATIONS";
    private static final String STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    private static final String INTERNET = "android.permission.INTERNET";
    private static final String UWB = "android.permission.UWB_RANGING";

    /** A host that holds and declares what the test says; "held" changes between rounds. */
    private static final class FakeHost implements HostBridgePlan.Host {
        final Set<String> held = new HashSet<>();
        final Set<String> declared = new HashSet<>();

        FakeHost declare(String... p) {
            declared.addAll(Arrays.asList(p));
            return this;
        }

        FakeHost hold(String... p) {
            held.addAll(Arrays.asList(p));
            declared.addAll(Arrays.asList(p));
            return this;
        }

        @Override
        public boolean holds(String permission) {
            return held.contains(permission);
        }

        @Override
        public boolean declared(String permission) {
            return declared.contains(permission);
        }
    }

    private static List<String> list(String... p) {
        return Arrays.asList(p);
    }

    @Test
    public void storageAndUnmanagedPermissionsAreNotBridged() {
        assertFalse(HostBridgePlan.isBridged(STORAGE));
        assertFalse(HostBridgePlan.isBridged(INTERNET));
        assertFalse(HostBridgePlan.isBridged(null));
        assertTrue(HostBridgePlan.isBridged(CAM));
        assertTrue(HostBridgePlan.isBridged(MIC));
        FakeHost host = new FakeHost().declare(CAM, STORAGE, INTERNET);
        HostBridgePlan p = HostBridgePlan.build(list(STORAGE, INTERNET, CAM), host, 34);
        assertEquals(list(CAM), p.wanted);
        assertEquals(list(CAM), p.toAsk);
    }

    @Test
    public void heldPermissionsNeedNothing() {
        FakeHost host = new FakeHost().hold(CAM, MIC);
        HostBridgePlan p = HostBridgePlan.build(list(CAM, MIC), host, 34);
        assertFalse(p.needsHostRequest());
        assertEquals(list(CAM, MIC), p.alreadyHeld);
        assertTrue(p.firstRound().isEmpty());
        assertArrayEquals(new int[]{0, 0}, p.apply(new String[]{CAM, MIC}, new int[]{0, 0}, host));
    }

    @Test
    public void missingPermissionIsAskedAndAnsweredByWhatTheHostHoldsAfterwards() {
        FakeHost host = new FakeHost().declare(CAM, MIC);
        String[] requested = {CAM, MIC};
        HostBridgePlan p = HostBridgePlan.build(list(CAM, MIC), host, 34);
        assertTrue(p.needsHostRequest());
        assertEquals(list(CAM, MIC), p.firstRound());
        // the user allows the camera and refuses the microphone in the host's system dialog
        host.hold(CAM);
        assertArrayEquals(new int[]{0, -1}, p.apply(requested, new int[]{0, 0}, host));
    }

    @Test
    public void aClonePermissionThatWasNotGrantedStaysDenied() {
        FakeHost host = new FakeHost().hold(CAM);
        // the store said Deny for the camera: it was never "wanted", the bridge does not turn it into a grant
        HostBridgePlan p = HostBridgePlan.build(Collections.<String>emptyList(), host, 34);
        assertArrayEquals(new int[]{-1}, p.apply(new String[]{CAM}, new int[]{-1}, host));
    }

    @Test
    public void notDeclaredPermissionCannotBeAskedAndIsDenied() {
        FakeHost host = new FakeHost().declare(CAM);
        HostBridgePlan p = HostBridgePlan.build(list(CAM, UWB), host, 34);
        assertEquals(list(UWB), p.notDeclared);
        assertEquals(list(CAM), p.toAsk);
        host.hold(CAM);
        assertArrayEquals(new int[]{0, -1}, p.apply(new String[]{CAM, UWB}, new int[]{0, 0}, host));
    }

    @Test
    public void permissionsThatDoNotExistOnThisAndroidAreLeftAlone() {
        FakeHost host = new FakeHost().declare(NOTIF);
        // Android 12 has no POST_NOTIFICATIONS: nothing to ask, nothing to deny
        HostBridgePlan old = HostBridgePlan.build(list(NOTIF), host, 32);
        assertTrue(old.wanted.isEmpty());
        assertArrayEquals(new int[]{0}, old.apply(new String[]{NOTIF}, new int[]{0}, host));
        // Android 13 has it
        HostBridgePlan now = HostBridgePlan.build(list(NOTIF), host, 33);
        assertEquals(list(NOTIF), now.toAsk);
        assertTrue(HostBridgePlan.appliesOnSdk(CAM, 23));
        assertFalse(HostBridgePlan.appliesOnSdk("android.permission.BLUETOOTH_CONNECT", 30));
        assertTrue(HostBridgePlan.appliesOnSdk("android.permission.BLUETOOTH_CONNECT", 31));
    }

    @Test
    public void backgroundLocationIsAskedSeparatelyFromAndroid11() {
        FakeHost host = new FakeHost().declare(FINE, COARSE, BG);
        HostBridgePlan p = HostBridgePlan.build(list(FINE, COARSE, BG), host, 33);
        assertEquals(list(FINE, COARSE), p.firstRound());
        // foreground location refused: the system would ignore a background request, so none is made
        assertTrue(p.backgroundRound(host).isEmpty());
        // foreground location allowed: now background is asked
        host.hold(FINE);
        assertEquals(list(BG), p.backgroundRound(host));
    }

    @Test
    public void backgroundLocationAloneIsAskedWhenForegroundIsAlreadyHeld() {
        FakeHost host = new FakeHost().hold(FINE).declare(BG);
        HostBridgePlan p = HostBridgePlan.build(list(BG), host, 34);
        assertTrue(p.firstRound().isEmpty());
        assertEquals(list(BG), p.backgroundRound(host));
    }

    @Test
    public void onAndroid10BackgroundLocationIsAskedTogether() {
        FakeHost host = new FakeHost().declare(FINE, BG);
        HostBridgePlan p = HostBridgePlan.build(list(FINE, BG), host, 29);
        assertEquals(list(FINE, BG), p.firstRound());
        assertTrue(p.backgroundRound(host).isEmpty());
    }

    @Test
    public void blockedMeansDeniedAndNoMoreRationale() {
        assertTrue(HostBridgePlan.isBlocked(false, false));
        assertFalse(HostBridgePlan.isBlocked(false, true));   // denied once, the system will ask again
        assertFalse(HostBridgePlan.isBlocked(true, false));
        assertFalse(HostBridgePlan.isBlocked(true, true));
    }

    @Test
    public void settingsPromptNamesEachBlockedGroupOnce() {
        FakeHost host = new FakeHost().declare(CAM, FINE, COARSE, MIC);
        HostBridgePlan p = HostBridgePlan.build(list(CAM, FINE, COARSE, MIC), host, 34);
        List<String> asked = p.firstRound();
        List<String> groups = p.blockedGroups(asked, list(CAM, FINE, COARSE), host);
        assertEquals(list(PermissionCatalog.CAMERA, PermissionCatalog.LOCATION), groups);
        // the microphone was refused but not blocked: asked again next time, no prompt
        assertFalse(groups.contains(PermissionCatalog.MICROPHONE));
    }

    @Test
    public void approximateLocationIsEnoughSoNoPrompt() {
        FakeHost host = new FakeHost().declare(FINE, COARSE);
        HostBridgePlan p = HostBridgePlan.build(list(FINE, COARSE), host, 34);
        host.hold(COARSE); // user picked "approximate"
        assertTrue(p.blockedGroups(p.firstRound(), list(FINE), host).isEmpty());
        assertArrayEquals(new int[]{-1, 0}, p.apply(new String[]{FINE, COARSE}, new int[]{0, 0}, host));
    }

    @Test
    public void blockedBackgroundLocationStillGetsThePromptEvenWithForeground() {
        FakeHost host = new FakeHost().declare(FINE, BG);
        HostBridgePlan p = HostBridgePlan.build(list(FINE, BG), host, 34);
        host.hold(FINE);
        List<String> asked = Arrays.asList(FINE, BG);
        assertEquals(list(PermissionCatalog.LOCATION), p.blockedGroups(asked, list(BG), host));
    }

    @Test
    public void permissionNotPutToTheSystemIsNeverBlocked() {
        FakeHost host = new FakeHost().declare(CAM);
        HostBridgePlan p = HostBridgePlan.build(list(CAM), host, 34);
        // nothing was asked (for example the request was cancelled): no prompt
        assertTrue(p.blockedGroups(Collections.<String>emptyList(), list(CAM), host).isEmpty());
    }

    @Test
    public void userAllowsInSettingsAndTheCloneGetsGranted() {
        FakeHost host = new FakeHost().declare(MIC);
        HostBridgePlan p = HostBridgePlan.build(list(MIC), host, 34);
        assertEquals(list(PermissionCatalog.MICROPHONE), p.blockedGroups(p.firstRound(), list(MIC), host));
        assertArrayEquals(new int[]{-1}, p.apply(new String[]{MIC}, new int[]{0}, host));
        host.hold(MIC); // back from settings
        assertArrayEquals(new int[]{0}, p.apply(new String[]{MIC}, new int[]{0}, host));
        assertTrue(p.blockedGroups(p.firstRound(), list(MIC), host).isEmpty());
    }

    @Test
    public void nullAndEmptyInputAreHarmless() {
        FakeHost host = new FakeHost();
        HostBridgePlan p = HostBridgePlan.build(null, host, 34);
        assertTrue(p.wanted.isEmpty());
        assertFalse(p.needsHostRequest());
        assertArrayEquals(new int[0], p.apply(new String[0], new int[0], host));
    }

    @Test
    public void duplicatePermissionIsAskedOnce() {
        FakeHost host = new FakeHost().declare(CAM);
        HostBridgePlan p = HostBridgePlan.build(list(CAM, CAM), host, 34);
        assertEquals(list(CAM), p.toAsk);
    }
}
