package top.niunaijun.blackbox.core.system.permission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Host bridge (part 18). A clone runs inside the host app's process and uid, so Android (and
 * MIUI) judge every camera / microphone / location use by what the <b>host app</b> really holds,
 * no matter what the permission store of the clone says. If the store says Allow but the host
 * does not hold the permission, the app is told "granted", opens the camera, and MIUI shows its
 * "Camera, Microphone" dialog again and again.
 *
 * The rule of the bridge: <b>the clone only gets "granted" for a permission the host really
 * holds</b>. When the host does not hold it yet, the host is asked first (system dialog); if the
 * system will not ask any more ("don't ask again"), the user is sent to the settings of the host.
 *
 * This class is the decision part, plain Java (no Android classes), unit-tested on the JVM.
 *
 * Not bridged: storage / media (the clone's files are redirected into the box, the host never
 * needs the real permission for them), and everything the store does not manage.
 */
public final class HostBridgePlan {
    public static final String BACKGROUND_LOCATION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";

    /** What the plan needs to know about the host app. */
    public interface Host {
        /** The host really holds this permission right now. */
        boolean holds(String permission);

        /** The host app's manifest declares it (without that, Android never shows a dialog). */
        boolean declared(String permission);
    }

    /** Lowest Android version on which a permission exists; below that it is not asked at all. */
    private static final Map<String, Integer> MIN_SDK = new HashMap<>();

    static {
        MIN_SDK.put("android.permission.ANSWER_PHONE_CALLS", 26);
        MIN_SDK.put("android.permission.READ_PHONE_NUMBERS", 26);
        MIN_SDK.put("android.permission.ACCEPT_HANDOVER", 28);
        MIN_SDK.put("android.permission.ACTIVITY_RECOGNITION", 29);
        MIN_SDK.put(BACKGROUND_LOCATION, 29);
        MIN_SDK.put("android.permission.BLUETOOTH_CONNECT", 31);
        MIN_SDK.put("android.permission.BLUETOOTH_SCAN", 31);
        MIN_SDK.put("android.permission.BLUETOOTH_ADVERTISE", 31);
        MIN_SDK.put("android.permission.UWB_RANGING", 31);
        MIN_SDK.put("android.permission.POST_NOTIFICATIONS", 33);
        MIN_SDK.put("android.permission.NEARBY_WIFI_DEVICES", 33);
        MIN_SDK.put("android.permission.BODY_SENSORS_BACKGROUND", 33);
    }

    /** True if this permission follows the bridge: managed by the store, and not storage / media. */
    public static boolean isBridged(String permission) {
        if (!PermissionCatalog.isManaged(permission)) return false;
        return !PermissionCatalog.STORAGE.equals(PermissionCatalog.groupOf(permission));
    }

    /** True if the permission exists as a runtime permission on this Android version. */
    public static boolean appliesOnSdk(String permission, int sdk) {
        Integer min = MIN_SDK.get(permission);
        return min == null || sdk >= min;
    }

    /**
     * What happened to one permission after the host was asked.
     *
     * @return true if the system will not ask again: it was denied and Android says no rationale
     * (the user chose "don't allow" twice, or "deny and don't ask again"). Only meaningful right
     * after a request, never before one.
     */
    public static boolean isBlocked(boolean grantedNow, boolean shouldShowRationale) {
        return !grantedNow && !shouldShowRationale;
    }

    // ------------------------------------------------------------------ the plan

    /** Permissions the clone is about to get and the bridge looks at, in request order. */
    public final List<String> wanted;
    /** Wanted and already held by the host: nothing to do. */
    public final List<String> alreadyHeld;
    /** Wanted, not held, and not in the host manifest: cannot be asked, the clone gets "denied". */
    public final List<String> notDeclared;
    /** Wanted, not held, declared: the host has to be asked. */
    public final List<String> toAsk;

    private final int mSdk;

    private HostBridgePlan(int sdk, List<String> wanted, List<String> held, List<String> undeclared,
                           List<String> ask) {
        mSdk = sdk;
        this.wanted = Collections.unmodifiableList(wanted);
        this.alreadyHeld = Collections.unmodifiableList(held);
        this.notDeclared = Collections.unmodifiableList(undeclared);
        this.toAsk = Collections.unmodifiableList(ask);
    }

    /**
     * @param grantedForClone permissions the clone is about to be answered "granted" for
     * @param host            what the host app holds and declares
     * @param sdk             Build.VERSION.SDK_INT
     */
    public static HostBridgePlan build(Collection<String> grantedForClone, Host host, int sdk) {
        Set<String> seen = new LinkedHashSet<>();
        if (grantedForClone != null) {
            for (String p : grantedForClone) {
                if (p != null && isBridged(p) && appliesOnSdk(p, sdk)) seen.add(p);
            }
        }
        List<String> wanted = new ArrayList<>(seen);
        List<String> held = new ArrayList<>();
        List<String> undeclared = new ArrayList<>();
        List<String> ask = new ArrayList<>();
        for (String p : wanted) {
            if (host.holds(p)) {
                held.add(p);
            } else if (!host.declared(p)) {
                undeclared.add(p);
            } else {
                ask.add(p);
            }
        }
        return new HostBridgePlan(sdk, wanted, held, undeclared, ask);
    }

    /** True if the system permission dialog has to be shown at least once. */
    public boolean needsHostRequest() {
        return !toAsk.isEmpty();
    }

    /**
     * First system request. From Android 11 background location may not be asked together with
     * the foreground location permissions (the system would refuse the whole request), so it is
     * taken out here and asked in {@link #backgroundRound(Host)}.
     */
    public List<String> firstRound() {
        List<String> round = new ArrayList<>();
        for (String p : toAsk) {
            if (BACKGROUND_LOCATION.equals(p) && mSdk >= 30) continue;
            round.add(p);
        }
        return round;
    }

    /**
     * Second system request, after the first one is done: background location, only if the host
     * now holds foreground location (the system ignores it otherwise). Empty if not needed.
     */
    public List<String> backgroundRound(Host hostNow) {
        if (mSdk < 30 || !toAsk.contains(BACKGROUND_LOCATION)) return Collections.emptyList();
        if (hostNow.holds(FINE_LOCATION) || hostNow.holds(COARSE_LOCATION)) {
            return Collections.singletonList(BACKGROUND_LOCATION);
        }
        return Collections.emptyList();
    }

    /**
     * Final answer for the clone. A permission that was going to be "granted" stays granted only if
     * the host holds it now; everything else keeps the result it had.
     */
    public int[] apply(String[] requested, int[] results, Host hostNow) {
        int[] out = results.clone();
        for (int i = 0; i < requested.length && i < out.length; i++) {
            if (out[i] == PermissionRequestPlan.RESULT_GRANTED
                    && wanted.contains(requested[i])
                    && !hostNow.holds(requested[i])) {
                out[i] = PermissionRequestPlan.RESULT_DENIED;
            }
        }
        return out;
    }

    /**
     * Groups for which the settings prompt is needed: the system asked, the host is still missing
     * the permission and the system will not ask again. A group counts as fine if any permission
     * of it is held (for example "approximate location" was chosen for a fine + coarse request).
     *
     * @param asked     permissions that were really put to the system dialog
     * @param blocked   the subset for which {@link #isBlocked} was true
     * @param hostNow   what the host holds now
     * @return group ids in request order, no duplicates
     */
    public List<String> blockedGroups(Collection<String> asked, Collection<String> blocked, Host hostNow) {
        Set<String> blockedSet = new HashSet<>(blocked);
        Set<String> groups = new LinkedHashSet<>();
        for (String p : wanted) {
            if (!asked.contains(p) || !blockedSet.contains(p) || hostNow.holds(p)) continue;
            String group = PermissionCatalog.groupOf(p);
            // "allow all the time" is a separate switch in settings, so it is never covered by the
            // foreground permissions of the same group
            if (group != null && (BACKGROUND_LOCATION.equals(p) || !groupHasHeld(group, hostNow))) {
                groups.add(group);
            }
        }
        return new ArrayList<>(groups);
    }

    private boolean groupHasHeld(String group, Host hostNow) {
        for (String p : wanted) {
            if (group.equals(PermissionCatalog.groupOf(p)) && hostNow.holds(p)
                    && !BACKGROUND_LOCATION.equals(p)) {
                return true;
            }
        }
        return false;
    }
}
