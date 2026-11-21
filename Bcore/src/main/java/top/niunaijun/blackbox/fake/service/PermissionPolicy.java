package top.niunaijun.blackbox.fake.service;

import android.app.AppOpsManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.app.BActivityThread;
import top.niunaijun.blackbox.core.system.permission.HostBridgePlan;
import top.niunaijun.blackbox.core.system.permission.PermissionCatalog;
import top.niunaijun.blackbox.fake.frameworks.BPermissionManager;

/**
 * One place that answers "is this permission granted for the running clone?" for every
 * hook (package manager, activity manager, permission manager). It replaces the old
 * hard-coded "always granted" returns.
 *
 * Rules:
 *  1. Managed permission (see PermissionCatalog) of the clone itself: the store decides.
 *     Allow -> go on to rule 2. Ask or Deny -> PERMISSION_DENIED (an "Ask" permission looks
 *     like "not granted yet"; the request dialog is PermissionRequestActivity, part 17).
 *  2. Host bridge (part 18): a permission the store allows but the host app does not really
 *     hold is NOT reported as granted (the old forced grant of the microphone / notifications
 *     would hide it). The app then asks, the request goes to PermissionRequestActivity, which
 *     asks the host. Storage / media is not bridged (the clone's files live in the box).
 *  3. Legacy forced grants (audio, storage/media, notification/MIUI) are kept for Allow
 *     and for permissions the store does not manage, same as before.
 *  4. Anything else: NO_OPINION, the caller runs the real check.
 *
 * While {@link HostPermissionCheck} is asking "what does the host really hold?" the policy has no
 * opinion at all, so the real answer comes from the system.
 */
public final class PermissionPolicy {
    /** Returned when the policy has no answer and the real check should run. */
    public static final int NO_OPINION = Integer.MIN_VALUE;

    /** Which old forced grants a hook used to have. */
    public static final int LEGACY_NONE = 0;   // IPermissionManager: nothing was forced
    public static final int LEGACY_MEDIA = 1;  // IActivityManager: audio + storage/media
    public static final int LEGACY_ALL = 2;    // IPackageManager: audio + storage/media + notification/MIUI

    private static final ThreadLocal<Boolean> sInLookup = new ThreadLocal<>();

    private PermissionPolicy() {
    }

    /** True if the package name belongs to the running clone (or is the host package). */
    public static boolean isOwnPackage(String pkg) {
        if (pkg == null) return true;
        try {
            if (pkg.equals(BActivityThread.getAppPackageName())) return true;
            return pkg.equals(BlackBoxCore.getHostPkg());
        } catch (Throwable t) {
            return false;
        }
    }

    /** True if the uid is the clone's own (virtual or host) uid. */
    public static boolean isOwnUid(int uid) {
        try {
            return uid == BlackBoxCore.getBUid() || uid == BlackBoxCore.getHostUid() || uid == Process.myUid();
        } catch (Throwable t) {
            return false;
        }
    }

    /** Effective store mode for the running clone. Returns MODE_ALLOW when it cannot be read. */
    public static int getMode(String permission) {
        if (Boolean.TRUE.equals(sInLookup.get())) {
            return BPermissionManager.MODE_ALLOW; // never recurse into ourselves
        }
        String pkg;
        try {
            pkg = BActivityThread.getAppPackageName();
        } catch (Throwable t) {
            return BPermissionManager.MODE_ALLOW;
        }
        if (pkg == null) return BPermissionManager.MODE_ALLOW;
        sInLookup.set(Boolean.TRUE);
        try {
            return BPermissionManager.get().getMode(BActivityThread.getUserId(), pkg, permission);
        } catch (Throwable t) {
            return BPermissionManager.MODE_ALLOW;
        } finally {
            sInLookup.remove();
        }
    }

    /** True if the store allows this permission (always true for unmanaged ones). */
    public static boolean isAllowed(String permission) {
        if (HostPermissionCheck.isRealCheck()) return true;
        if (!PermissionCatalog.isManaged(permission)) return true;
        return getMode(permission) == BPermissionManager.MODE_ALLOW;
    }

    /** True if the store says Deny (used for "revoked by policy"). */
    public static boolean isDenied(String permission) {
        if (HostPermissionCheck.isRealCheck()) return false;
        if (!PermissionCatalog.isManaged(permission)) return false;
        return getMode(permission) == BPermissionManager.MODE_DENY;
    }

    /**
     * @return PERMISSION_GRANTED, PERMISSION_DENIED, or NO_OPINION.
     */
    public static int decide(String permission, boolean own, int legacy) {
        if (permission == null) return NO_OPINION;
        if (HostPermissionCheck.isRealCheck()) return NO_OPINION;
        if (own && !isAllowed(permission)) {
            return PackageManager.PERMISSION_DENIED;
        }
        if (isLegacyGranted(permission, legacy)) {
            // host bridge: the forced grant must not hide that the host itself lacks the permission
            if (own && HostBridgePlan.isBridged(permission)
                    && HostBridgePlan.appliesOnSdk(permission, Build.VERSION.SDK_INT)
                    && !HostPermissionCheck.holdsCached(permission)) {
                return PackageManager.PERMISSION_DENIED;
            }
            return PackageManager.PERMISSION_GRANTED;
        }
        return NO_OPINION;
    }

    public static int decideForPackage(String permission, String pkg, int legacy) {
        return decide(permission, isOwnPackage(pkg), legacy);
    }

    public static int decideForUid(String permission, int uid, int legacy) {
        return decide(permission, isOwnUid(uid), legacy);
    }

    /**
     * Picks {permission, package} out of the String arguments of an IPermissionManager call.
     * The order differs between Android versions, so the one that is the clone's package
     * name is the package; otherwise the Android 13+ order (package first) is assumed.
     */
    public static String[] pickPermissionAndPackage(Object[] args) {
        String first = null;
        String second = null;
        if (args != null) {
            for (Object a : args) {
                if (a instanceof String) {
                    if (first == null) {
                        first = (String) a;
                    } else {
                        second = (String) a;
                        break;
                    }
                }
            }
        }
        if (first == null || second == null) return null;
        if (isOwnPackage(first) && !isOwnPackage(second)) return new String[]{second, first};
        if (isOwnPackage(second) && !isOwnPackage(first)) return new String[]{first, second};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return new String[]{second, first}; // (package, permission)
        }
        return new String[]{first, second};     // (permission, package)
    }

    public static boolean isLegacyGranted(String permission, int legacy) {
        if (legacy == LEGACY_NONE || permission == null) return false;
        if (isAudioPermission(permission) || isStorageOrMediaPermission(permission)) return true;
        return legacy == LEGACY_ALL && isNotificationOrXiaomiPermission(permission);
    }

    public static boolean isAudioPermission(String permission) {
        if (permission == null) return false;
        return permission.equals(android.Manifest.permission.RECORD_AUDIO)
                || permission.equals(android.Manifest.permission.CAPTURE_AUDIO_OUTPUT)
                || permission.equals(android.Manifest.permission.MODIFY_AUDIO_SETTINGS)
                || permission.equals("android.permission.FOREGROUND_SERVICE_MICROPHONE")
                || permission.equals("android.permission.FOREGROUND_SERVICE_MEDIA_PROJECTION")
                || permission.equals("android.permission.FOREGROUND_SERVICE_CAMERA")
                || permission.equals("android.permission.FOREGROUND_SERVICE_LOCATION")
                || permission.equals("android.permission.FOREGROUND_SERVICE_HEALTH")
                || permission.equals("android.permission.FOREGROUND_SERVICE_DATA_SYNC")
                || permission.equals("android.permission.FOREGROUND_SERVICE_SPECIAL_USE")
                || permission.equals("android.permission.FOREGROUND_SERVICE_SYSTEM_EXEMPTED")
                || permission.equals("android.permission.FOREGROUND_SERVICE_PHONE_CALL")
                || permission.equals("android.permission.FOREGROUND_SERVICE_CONNECTED_DEVICE");
    }

    public static boolean isStorageOrMediaPermission(String permission) {
        if (permission == null) return false;
        if (permission.equals(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                || permission.equals(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            return true;
        }
        if (permission.equals(android.Manifest.permission.READ_MEDIA_AUDIO)
                || permission.equals(android.Manifest.permission.READ_MEDIA_VIDEO)
                || permission.equals(android.Manifest.permission.READ_MEDIA_IMAGES)
                || permission.equals("android.permission.READ_MEDIA_VISUAL")
                || permission.equals("android.permission.READ_MEDIA_AURAL")
                || permission.equals(android.Manifest.permission.ACCESS_MEDIA_LOCATION)) {
            return true;
        }
        return permission.equals("android.permission.READ_MEDIA_AUDIO_USER_SELECTED")
                || permission.equals("android.permission.READ_MEDIA_VIDEO_USER_SELECTED")
                || permission.equals("android.permission.READ_MEDIA_IMAGES_USER_SELECTED")
                || permission.equals("android.permission.READ_MEDIA_VISUAL_USER_SELECTED")
                || permission.equals("android.permission.READ_MEDIA_AURAL_USER_SELECTED");
    }

    public static boolean isNotificationOrXiaomiPermission(String permission) {
        if (permission == null) return false;
        return permission.equals("android.permission.POST_NOTIFICATIONS")
                || permission.equals("miui.permission.USE_INTERNAL_GENERAL_API")
                || permission.equals("miui.permission.OPTIMIZE_POWER")
                || permission.equals("miui.permission.RUN_IN_BACKGROUND")
                || permission.equals("miui.permission.POST_NOTIFICATIONS")
                || permission.equals("miui.permission.AUTO_START")
                || permission.equals("miui.permission.BACKGROUND_POPUP_WINDOW")
                || permission.equals("miui.permission.SHOW_WHEN_LOCKED")
                || permission.equals("miui.permission.TURN_SCREEN_ON");
    }

    // ---------------------------------------------------------------- AppOps / MIUI helpers

    private static final String NO_PERMISSION = "";
    private static final Map<Integer, String> sOpToPermission = new ConcurrentHashMap<>();
    private static final Map<String, String> sOpNameToPermission = new HashMap<>();

    static {
        String[][] ops = {
                {"camera", "android.permission.CAMERA"},
                {"record_audio", "android.permission.RECORD_AUDIO"},
                {"fine_location", "android.permission.ACCESS_FINE_LOCATION"},
                {"coarse_location", "android.permission.ACCESS_COARSE_LOCATION"},
                {"read_contacts", "android.permission.READ_CONTACTS"},
                {"write_contacts", "android.permission.WRITE_CONTACTS"},
                {"read_calendar", "android.permission.READ_CALENDAR"},
                {"write_calendar", "android.permission.WRITE_CALENDAR"},
                {"read_call_log", "android.permission.READ_CALL_LOG"},
                {"write_call_log", "android.permission.WRITE_CALL_LOG"},
                {"call_phone", "android.permission.CALL_PHONE"},
                {"read_phone_state", "android.permission.READ_PHONE_STATE"},
                {"send_sms", "android.permission.SEND_SMS"},
                {"receive_sms", "android.permission.RECEIVE_SMS"},
                {"read_sms", "android.permission.READ_SMS"},
                {"read_external_storage", "android.permission.READ_EXTERNAL_STORAGE"},
                {"write_external_storage", "android.permission.WRITE_EXTERNAL_STORAGE"},
                {"read_media_audio", "android.permission.READ_MEDIA_AUDIO"},
                {"read_media_video", "android.permission.READ_MEDIA_VIDEO"},
                {"read_media_images", "android.permission.READ_MEDIA_IMAGES"},
                {"post_notification", "android.permission.POST_NOTIFICATIONS"},
                {"body_sensors", "android.permission.BODY_SENSORS"},
                {"activity_recognition", "android.permission.ACTIVITY_RECOGNITION"},
                {"bluetooth_scan", "android.permission.BLUETOOTH_SCAN"},
                {"bluetooth_connect", "android.permission.BLUETOOTH_CONNECT"},
                {"bluetooth_advertise", "android.permission.BLUETOOTH_ADVERTISE"},
                {"nearby_wifi_devices", "android.permission.NEARBY_WIFI_DEVICES"},
        };
        for (String[] o : ops) {
            sOpNameToPermission.put(o[0], o[1]);
        }
    }

    /**
     * Permission behind an AppOps op code, or null if the op has none. Uses the hidden
     * AppOpsManager.opToPermission, and falls back to a small name table.
     */
    public static String permissionOfOp(int op) {
        String cached = sOpToPermission.get(op);
        if (cached == null) {
            String result = null;
            try {
                Object r = AppOpsManager.class.getMethod("opToPermission", int.class).invoke(null, op);
                if (r != null) result = r.toString();
            } catch (Throwable ignored) {
            }
            if (result == null) {
                try {
                    Object r = AppOpsManager.class.getMethod("opToPublicName", int.class).invoke(null, op);
                    if (r != null) {
                        String name = r.toString();
                        if (name.startsWith("android:")) name = name.substring("android:".length());
                        result = sOpNameToPermission.get(name);
                    }
                } catch (Throwable ignored) {
                }
            }
            cached = result == null ? NO_PERMISSION : result;
            sOpToPermission.put(op, cached);
        }
        return cached.isEmpty() ? null : cached;
    }

    /**
     * AppOps calls (checkOperation / noteOperation / startOperation and their *Op variants):
     * true when the op belongs to a permission the store does not allow for this clone.
     * The op code is the first int argument, the uid the second, the package the first String.
     */
    public static boolean isOpDeniedByStore(Object[] args) {
        if (args == null) return false;
        int op = 0;
        int uid = 0;
        int ints = 0;
        String pkg = null;
        for (Object a : args) {
            if (a instanceof Integer) {
                if (ints == 0) op = (Integer) a;
                else if (ints == 1) uid = (Integer) a;
                ints++;
            } else if (a instanceof String && pkg == null) {
                pkg = (String) a;
            }
        }
        if (ints == 0) return false;
        boolean own = (ints >= 2 && isOwnUid(uid)) || (pkg != null && isOwnPackage(pkg));
        if (!own) return false;
        String permission = permissionOfOp(op);
        return permission != null && !isAllowed(permission);
    }

    /**
     * MIUI security manager calls: true if any String argument is a managed permission the
     * store does not allow, or any int argument is an AppOps op of such a permission.
     */
    public static boolean isMiuiCallDeniedByStore(Object[] args) {
        if (args == null) return false;
        for (Object a : args) {
            if (a instanceof String && PermissionCatalog.isManaged((String) a) && !isAllowed((String) a)) {
                return true;
            }
        }
        for (Object a : args) {
            if (a instanceof Integer) {
                String permission = permissionOfOp((Integer) a);
                if (permission != null && !isAllowed(permission)) return true;
            }
        }
        return false;
    }
}
