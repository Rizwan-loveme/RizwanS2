package top.niunaijun.blackbox.core.system.permission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Works out what to do with one {@code requestPermissions(...)} call of a clone (part 17).
 * Pure Java (no Android classes), so it is unit-tested on the JVM.
 *
 * For every requested permission there are four outcomes:
 *  - GRANT: the store says Allow, the app gets PERMISSION_GRANTED without any dialog;
 *  - DENY:  the store says Deny, the app gets PERMISSION_DENIED without any dialog;
 *  - ASK:   the store says Ask, the user decides. Permissions of one group (for example fine and
 *           coarse location) are asked together, in one dialog;
 *  - OTHER: not a managed permission (see {@link PermissionCatalog}), the dialog does not
 *           control it and the old behaviour stays.
 */
public final class PermissionRequestPlan {
    public static final int GRANT = 0;
    public static final int DENY = 1;
    public static final int ASK = 2;
    public static final int OTHER = 3;

    /** Same values as PackageManager.PERMISSION_GRANTED / PERMISSION_DENIED. */
    public static final int RESULT_GRANTED = 0;
    public static final int RESULT_DENIED = -1;

    /** Where the current mode of a permission comes from (the permission store). */
    public interface ModeSource {
        /** One of MODE_ALLOW (1), MODE_ASK (2), MODE_DENY (3). */
        int modeOf(String permission);
    }

    /** What to answer for permissions the store does not manage. */
    public interface OtherResolver {
        int resultOf(String permission);
    }

    /** One question for the user: a group and the requested permissions inside it. */
    public static final class AskStep {
        public final String groupId;
        public final List<String> permissions;

        AskStep(String groupId, List<String> permissions) {
            this.groupId = groupId;
            this.permissions = Collections.unmodifiableList(permissions);
        }
    }

    public final String[] requested;
    public final int[] decisions;
    public final List<AskStep> askSteps;

    private PermissionRequestPlan(String[] requested, int[] decisions, List<AskStep> askSteps) {
        this.requested = requested;
        this.decisions = decisions;
        this.askSteps = Collections.unmodifiableList(askSteps);
    }

    public static PermissionRequestPlan build(String[] requested, ModeSource modes) {
        if (requested == null) requested = new String[0];
        int[] decisions = new int[requested.length];
        Map<String, List<String>> asked = new LinkedHashMap<>();
        for (int i = 0; i < requested.length; i++) {
            String p = requested[i];
            if (!PermissionCatalog.isManaged(p)) {
                decisions[i] = OTHER;
                continue;
            }
            int mode = modes.modeOf(p);
            if (mode == PermissionStore.MODE_ALLOW) {
                decisions[i] = GRANT;
            } else if (mode == PermissionStore.MODE_DENY) {
                decisions[i] = DENY;
            } else {
                decisions[i] = ASK;
                String group = PermissionCatalog.groupOf(p);
                List<String> list = asked.get(group);
                if (list == null) {
                    list = new ArrayList<>();
                    asked.put(group, list);
                }
                if (!list.contains(p)) list.add(p);
            }
        }
        List<AskStep> steps = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : asked.entrySet()) {
            steps.add(new AskStep(e.getKey(), e.getValue()));
        }
        return new PermissionRequestPlan(requested, decisions, steps);
    }

    /** True if at least one requested permission is controlled by the store. */
    public boolean hasManaged() {
        for (int d : decisions) {
            if (d != OTHER) return true;
        }
        return false;
    }

    /** True if the user has to be asked at least once. */
    public boolean needsDialog() {
        return !askSteps.isEmpty();
    }

    /**
     * Final answer for every requested permission, in the order they were requested.
     *
     * @param answers group id -> true if the user allowed it (missing = not allowed)
     * @param other   answer for permissions the store does not manage
     */
    public int[] resolve(Map<String, Boolean> answers, OtherResolver other) {
        int[] results = new int[requested.length];
        for (int i = 0; i < requested.length; i++) {
            switch (decisions[i]) {
                case GRANT:
                    results[i] = RESULT_GRANTED;
                    break;
                case ASK: {
                    Boolean allowed = answers == null ? null : answers.get(PermissionCatalog.groupOf(requested[i]));
                    results[i] = Boolean.TRUE.equals(allowed) ? RESULT_GRANTED : RESULT_DENIED;
                    break;
                }
                case OTHER:
                    results[i] = other == null ? RESULT_DENIED : other.resultOf(requested[i]);
                    break;
                case DENY:
                default:
                    results[i] = RESULT_DENIED;
                    break;
            }
        }
        return results;
    }
}
