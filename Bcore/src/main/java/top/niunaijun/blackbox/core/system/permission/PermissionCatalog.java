package top.niunaijun.blackbox.core.system.permission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The permissions the per-app permission store controls, grouped the way the user sees them.
 * Pure Java (no Android classes) so it can be unit-tested and reused by the UI (part 16).
 *
 * Only these "managed" permissions follow the store. Everything else (INTERNET, foreground
 * service types, MIUI helper permissions, ...) keeps its old behaviour, because denying them
 * would break the app instead of protecting the user.
 */
public final class PermissionCatalog {
    public static final String CAMERA = "CAMERA";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String LOCATION = "LOCATION";
    public static final String CONTACTS = "CONTACTS";
    public static final String CALENDAR = "CALENDAR";
    public static final String PHONE = "PHONE";
    public static final String SMS = "SMS";
    public static final String STORAGE = "STORAGE";
    public static final String NOTIFICATIONS = "NOTIFICATIONS";
    public static final String SENSORS = "SENSORS";
    public static final String ACTIVITY = "ACTIVITY";
    public static final String NEARBY = "NEARBY";

    private static final Map<String, String[]> GROUPS = new LinkedHashMap<>();
    private static final Map<String, String> PERMISSION_TO_GROUP = new HashMap<>();

    private static void group(String id, String... permissions) {
        GROUPS.put(id, permissions);
        for (String p : permissions) {
            PERMISSION_TO_GROUP.put(p, id);
        }
    }

    static {
        group(CAMERA, "android.permission.CAMERA");
        group(MICROPHONE, "android.permission.RECORD_AUDIO");
        group(LOCATION,
                "android.permission.ACCESS_FINE_LOCATION",
                "android.permission.ACCESS_COARSE_LOCATION",
                "android.permission.ACCESS_BACKGROUND_LOCATION");
        group(CONTACTS,
                "android.permission.READ_CONTACTS",
                "android.permission.WRITE_CONTACTS",
                "android.permission.GET_ACCOUNTS");
        group(CALENDAR,
                "android.permission.READ_CALENDAR",
                "android.permission.WRITE_CALENDAR");
        group(PHONE,
                "android.permission.READ_PHONE_STATE",
                "android.permission.READ_PHONE_NUMBERS",
                "android.permission.CALL_PHONE",
                "android.permission.ANSWER_PHONE_CALLS",
                "android.permission.READ_CALL_LOG",
                "android.permission.WRITE_CALL_LOG",
                "android.permission.ADD_VOICEMAIL",
                "android.permission.USE_SIP",
                "android.permission.PROCESS_OUTGOING_CALLS",
                "android.permission.ACCEPT_HANDOVER");
        group(SMS,
                "android.permission.SEND_SMS",
                "android.permission.RECEIVE_SMS",
                "android.permission.READ_SMS",
                "android.permission.RECEIVE_WAP_PUSH",
                "android.permission.RECEIVE_MMS");
        group(STORAGE,
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.READ_MEDIA_AUDIO",
                "android.permission.READ_MEDIA_VIDEO",
                "android.permission.READ_MEDIA_IMAGES",
                "android.permission.READ_MEDIA_VISUAL",
                "android.permission.READ_MEDIA_AURAL",
                "android.permission.ACCESS_MEDIA_LOCATION",
                "android.permission.READ_MEDIA_AUDIO_USER_SELECTED",
                "android.permission.READ_MEDIA_VIDEO_USER_SELECTED",
                "android.permission.READ_MEDIA_IMAGES_USER_SELECTED",
                "android.permission.READ_MEDIA_VISUAL_USER_SELECTED",
                "android.permission.READ_MEDIA_AURAL_USER_SELECTED");
        group(NOTIFICATIONS, "android.permission.POST_NOTIFICATIONS");
        group(SENSORS,
                "android.permission.BODY_SENSORS",
                "android.permission.BODY_SENSORS_BACKGROUND");
        group(ACTIVITY, "android.permission.ACTIVITY_RECOGNITION");
        group(NEARBY,
                "android.permission.BLUETOOTH_CONNECT",
                "android.permission.BLUETOOTH_SCAN",
                "android.permission.BLUETOOTH_ADVERTISE",
                "android.permission.NEARBY_WIFI_DEVICES",
                "android.permission.UWB_RANGING");
    }

    private PermissionCatalog() {
    }

    /** True if this permission follows the permission store. */
    public static boolean isManaged(String permission) {
        return permission != null && PERMISSION_TO_GROUP.containsKey(permission);
    }

    /** Group id of a managed permission, or null. */
    public static String groupOf(String permission) {
        return permission == null ? null : PERMISSION_TO_GROUP.get(permission);
    }

    /** All group ids in display order. */
    public static List<String> getGroupIds() {
        return Collections.unmodifiableList(new ArrayList<>(GROUPS.keySet()));
    }

    /** Every permission of one group (empty list for an unknown group). */
    public static List<String> getPermissions(String groupId) {
        String[] p = GROUPS.get(groupId);
        if (p == null) return Collections.emptyList();
        List<String> list = new ArrayList<>(p.length);
        Collections.addAll(list, p);
        return list;
    }
}
