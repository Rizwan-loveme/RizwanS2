package top.niunaijun.blackbox.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import top.niunaijun.blackbox.core.system.permission.HostBridgePlan;
import top.niunaijun.blackbox.core.system.permission.PermissionCatalog;
import top.niunaijun.blackbox.core.system.permission.PermissionRequestPlan;
import top.niunaijun.blackbox.core.system.permission.XiaomiPermissionManager;
import top.niunaijun.blackbox.fake.frameworks.BPermissionManager;
import top.niunaijun.blackbox.fake.service.HostPermissionCheck;
import top.niunaijun.blackbox.fake.service.PermissionPolicy;
import top.niunaijun.blackbox.fake.service.PermissionRequestRedirect;
import top.niunaijun.blackbox.utils.Slog;

/**
 * Part 17: the "Ask" dialog. Runs in the host main process and replaces the system permission
 * controller for clones (see {@link PermissionRequestRedirect}).
 *
 * What it does with one requestPermissions() call:
 *  1. builds a {@link PermissionRequestPlan} from the permission store,
 *  2. asks the user once per permission group whose mode is Ask (4 choices: always allow,
 *     allow this time, deny this time, always deny),
 *  3. writes the "always" choices into the permission store and the "this time" choices into the
 *     temporary grants, so the app's next checkSelfPermission() sees the same answer,
 *  4. returns the result with the same extras as the real controller, so the app gets a normal
 *     onRequestPermissionsResult().
 *
 * Closing the dialog (back button or touch outside) counts as "deny this time" and stores nothing.
 *
 * Part 18, host bridge: a clone runs with the host app's uid, so Android and MIUI judge camera,
 * microphone, location ... by what the HOST really holds. After the answers above, every
 * permission that is about to be "granted" is checked against the host ({@link HostBridgePlan}):
 *  - the host holds it: nothing more happens;
 *  - the host does not: the system permission dialog of the host is shown first (background
 *    location in a second request, as Android 11+ demands);
 *  - the system will not ask any more ("don't ask again"): a prompt sends the user to the
 *    settings of the host (MIUI: its own permission editor), and the answer is re-checked when
 *    the user comes back;
 *  - still not held: the clone gets "denied", never a "granted" the system would contradict. That
 *    is what ends the MIUI "Camera, Microphone" dialog loop.
 * The clone's own Allow / Ask / Deny rules are not changed by any of this.
 */
public class PermissionRequestActivity extends Activity {
    private static final String TAG = "PermissionRequestUi";

    public static final String EXTRA_CLONE_PACKAGE = "bb_clone_package";
    public static final String EXTRA_CLONE_USER = "bb_clone_user";
    public static final String EXTRA_CLONE_LABEL = "bb_clone_label";

    // what the user chose for one group
    private static final int CHOICE_ALWAYS = 1;
    private static final int CHOICE_ONCE = 2;
    private static final int CHOICE_DENY_ONCE = 3;
    private static final int CHOICE_DENY_ALWAYS = 4;

    // request codes of the host bridge (part 18)
    private static final int REQ_HOST = 0x4252;
    private static final int REQ_SETTINGS = 0x4253;

    private String mPackage;
    private int mUserId;
    private String mLabel;
    private String[] mNames;
    private int[] mDeviceIds;

    private PermissionRequestPlan mPlan;
    private final Map<String, Integer> mChoices = new LinkedHashMap<>();
    private int mStep;
    private AlertDialog mDialog;
    private boolean mFinishing;

    // host bridge state (part 18)
    private int[] mResults;
    private HostBridgePlan mBridge;
    private HostBridgePlan.Host mHost;
    private boolean mBackgroundDone;
    private final List<String> mAsked = new ArrayList<>();
    private final List<String> mBlocked = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in = getIntent();
        mPackage = in.getStringExtra(EXTRA_CLONE_PACKAGE);
        mUserId = in.getIntExtra(EXTRA_CLONE_USER, 0);
        mLabel = in.getStringExtra(EXTRA_CLONE_LABEL);
        mNames = in.getStringArrayExtra(PermissionRequestRedirect.EXTRA_NAMES);
        mDeviceIds = in.getIntArrayExtra(PermissionRequestRedirect.EXTRA_DEVICE_IDS);
        if (mLabel == null) mLabel = mPackage;

        if (mPackage == null || mNames == null) {
            // nothing to answer: same as a cancelled request
            setResult(RESULT_CANCELED);
            finish();
            return;
        }
        // binder calls to the permission service: not on the main thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                final PermissionRequestPlan plan = PermissionRequestPlan.build(mNames,
                        new PermissionRequestPlan.ModeSource() {
                            @Override
                            public int modeOf(String permission) {
                                return BPermissionManager.get().getMode(mUserId, mPackage, permission);
                            }
                        });
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isFinishing() || isDestroyed()) return;
                        mPlan = plan;
                        mStep = 0;
                        next();
                    }
                });
            }
        }, "bb-perm-plan").start();
    }

    @Override
    protected void onDestroy() {
        if (mDialog != null && mDialog.isShowing()) mDialog.dismiss();
        super.onDestroy();
    }

    // ------------------------------------------------------------------ questions

    private void next() {
        if (mPlan == null || mFinishing) return;
        if (mStep >= mPlan.askSteps.size()) {
            complete();
            return;
        }
        showQuestion(mPlan.askSteps.get(mStep), mStep + 1, mPlan.askSteps.size());
    }

    private void answer(String groupId, int choice) {
        mChoices.put(groupId, choice);
        mStep++;
        next();
    }

    private void showQuestion(final PermissionRequestPlan.AskStep step, int number, int total) {
        if (mDialog != null && mDialog.isShowing()) mDialog.dismiss();

        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setPadding(dp(20), dp(18), dp(20), dp(8));

        String title = groupTitle(step.groupId);
        box.addView(text("“" + mLabel + "” " + title + " ব্যবহার করতে চায়", 17f, Color.parseColor("#1B1F3B"), true));
        String sub = "স্পেস " + (mUserId + 1) + (total > 1 ? "  ·  প্রশ্ন " + number + "/" + total : "");
        box.addView(text(sub, 12f, Color.parseColor("#6B7280"), false), margins(0, dp(2), 0, dp(10)));

        StringBuilder names = new StringBuilder();
        for (String p : step.permissions) {
            if (names.length() > 0) names.append("\n");
            names.append("• ").append(shortName(p));
        }
        box.addView(text(names.toString(), 12f, Color.parseColor("#6B7280"), false), margins(0, 0, 0, dp(14)));

        final String group = step.groupId;
        box.addView(button("✅ সবসময় দিন", "#BFEBCB", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer(group, CHOICE_ALWAYS);
            }
        }));
        box.addView(button("🕒 শুধু এবার দিন", "#D9E6FF", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer(group, CHOICE_ONCE);
            }
        }));
        box.addView(button("❌ এবার দেব না", "#FFE2A8", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer(group, CHOICE_DENY_ONCE);
            }
        }));
        box.addView(button("⛔ কখনো দেব না", "#F9BDBD", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer(group, CHOICE_DENY_ALWAYS);
            }
        }));

        mDialog = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
                .setView(box)
                .setCancelable(true)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        // back / outside touch: deny this time, store nothing
                        answer(group, CHOICE_DENY_ONCE);
                    }
                })
                .create();
        mDialog.show();
    }

    // ------------------------------------------------------------------ result

    private void complete() {
        if (mFinishing) return;
        mFinishing = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // store answers first, then the host bridge (part 18); both are Binder calls
                    startBridge(applyAndResolve());
                } catch (Throwable t) {
                    Slog.w(TAG, "could not apply the answers: " + t);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            deliver(allDenied());
                        }
                    });
                }
            }
        }, "bb-perm-apply").start();
    }

    /** Writes the "always" / "this time" answers, then returns the result for every permission. */
    private int[] applyAndResolve() {
        BPermissionManager pm = BPermissionManager.get();
        Map<String, Boolean> allowed = new HashMap<>();
        for (Map.Entry<String, Integer> e : mChoices.entrySet()) {
            String group = e.getKey();
            int choice = e.getValue();
            List<String> all = PermissionCatalog.getPermissions(group);
            switch (choice) {
                case CHOICE_ALWAYS:
                    for (String p : all) pm.setMode(mUserId, mPackage, p, BPermissionManager.MODE_ALLOW);
                    allowed.put(group, true);
                    break;
                case CHOICE_ONCE:
                    for (String p : all) pm.grantTemporary(mUserId, mPackage, p);
                    allowed.put(group, true);
                    break;
                case CHOICE_DENY_ALWAYS:
                    for (String p : all) pm.setMode(mUserId, mPackage, p, BPermissionManager.MODE_DENY);
                    allowed.put(group, false);
                    break;
                case CHOICE_DENY_ONCE:
                default:
                    allowed.put(group, false);
                    break;
            }
        }
        return mPlan.resolve(allowed, new PermissionRequestPlan.OtherResolver() {
            @Override
            public int resultOf(String permission) {
                // not controlled by the store: the old forced grants stay, anything else is
                // answered by what the host app really holds
                if (PermissionPolicy.isLegacyGranted(permission, PermissionPolicy.LEGACY_ALL)) {
                    return PackageManager.PERMISSION_GRANTED;
                }
                try {
                    return androidx.core.content.ContextCompat.checkSelfPermission(PermissionRequestActivity.this, permission);
                } catch (Throwable t) {
                    return PackageManager.PERMISSION_DENIED;
                }
            }
        });
    }

    // ------------------------------------------------------------------ host bridge (part 18)

    /** Worker thread. Works out what the host is missing, then continues on the UI thread. */
    private void startBridge(final int[] results) {
        mResults = results;
        mHost = HostPermissionCheck.host(this);
        List<String> granted = new ArrayList<>();
        for (int i = 0; i < mNames.length && i < results.length; i++) {
            if (results[i] == PackageManager.PERMISSION_GRANTED) granted.add(mNames[i]);
        }
        mBridge = HostBridgePlan.build(granted, mHost, android.os.Build.VERSION.SDK_INT);
        Slog.d(TAG, "host bridge for " + mPackage + ": held=" + mBridge.alreadyHeld
                + " ask=" + mBridge.toAsk + " notDeclared=" + mBridge.notDeclared);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isFinishing() || isDestroyed()) return;
                askHostRound(mBridge.firstRound());
            }
        });
    }

    /** UI thread. Shows the system dialog of the host for one round, or goes on when it is empty. */
    private void askHostRound(List<String> round) {
        if (round == null || round.isEmpty()) {
            afterRound();
            return;
        }
        mAsked.addAll(round);
        try {
            androidx.core.app.ActivityCompat.requestPermissions(this, round.toArray(new String[0]), REQ_HOST);
        } catch (Throwable t) {
            Slog.w(TAG, "could not ask the host for " + round + ": " + t);
            afterRound();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != REQ_HOST) return;
        for (int i = 0; i < permissions.length && i < grantResults.length; i++) {
            boolean granted = grantResults[i] == PackageManager.PERMISSION_GRANTED;
            boolean rationale = androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i]);
            if (HostBridgePlan.isBlocked(granted, rationale)) mBlocked.add(permissions[i]);
        }
        HostPermissionCheck.forget();
        afterRound();
    }

    /** After a system round: background location next (Android 11+), then the final answer. */
    private void afterRound() {
        if (mBackgroundDone) {
            finishBridge();
            return;
        }
        mBackgroundDone = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<String> bg = mBridge.backgroundRound(mHost);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isFinishing() || isDestroyed()) return;
                        if (bg.isEmpty()) finishBridge();
                        else askHostRound(bg);
                    }
                });
            }
        }, "bb-perm-bg").start();
    }

    /** Re-checks the host, then either asks the user to open settings or delivers the answer. */
    private void finishBridge() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final int[] answer = mBridge.apply(mNames, mResults, mHost);
                final List<String> groups = mBlocked.isEmpty() ? new ArrayList<String>()
                        : mBridge.blockedGroups(mAsked, mBlocked, mHost);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isFinishing() || isDestroyed()) return;
                        if (groups.isEmpty()) {
                            deliver(answer);
                        } else {
                            showSettingsPrompt(groups, answer);
                        }
                    }
                });
            }
        }, "bb-perm-final").start();
    }

    private void showSettingsPrompt(List<String> groups, final int[] answer) {
        if (mDialog != null && mDialog.isShowing()) mDialog.dismiss();
        StringBuilder names = new StringBuilder();
        for (String g : groups) {
            if (names.length() > 0) names.append(", ");
            names.append(groupTitle(g));
        }
        String hostLabel = getApplicationInfo().loadLabel(getPackageManager()).toString();
        StringBuilder msg = new StringBuilder();
        msg.append("“").append(mLabel).append("” কে ").append(names).append(" ব্যবহার করতে দিতে হলে আগে এই অ্যাপের (")
                .append(hostLabel).append(") নিজেরই ফোনের অনুমতি লাগে। Android আর জিজ্ঞেস করবে না, তাই সেটিংস থেকে ")
                .append(names).append(" চালু করে ফিরে আসুন।");
        if (XiaomiPermissionManager.get().isXiaomiDevice()) {
            msg.append("\n\nMIUI / HyperOS: সেটিংস → অ্যাপ → অনুমতি → ").append(names).append(" → অনুমতি দিন।");
        }
        msg.append("\n\n(ক্লোনের নিজস্ব Allow / Ask / Deny নিয়ম বদলাবে না।)");

        mDialog = new AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
                .setTitle("⚠️ ফোনের অনুমতি বন্ধ আছে")
                .setMessage(msg.toString())
                .setCancelable(true)
                .setPositiveButton("⚙️ সেটিংস খুলুন", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!openHostSettings()) deliver(answer);
                    }
                })
                .setNegativeButton("এখন না", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deliver(answer);
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        deliver(answer);
                    }
                })
                .create();
        mDialog.show();
    }

    /** Opens the settings of the host app (MIUI: its own permission editor first). */
    private boolean openHostSettings() {
        if (XiaomiPermissionManager.get().isXiaomiDevice()) {
            try {
                Intent miui = new Intent("miui.intent.action.APP_PERM_EDITOR");
                miui.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                miui.putExtra("extra_pkgname", getPackageName());
                startActivityForResult(miui, REQ_SETTINGS);
                return true;
            } catch (Throwable t) {
                Slog.d(TAG, "MIUI permission editor not available: " + t);
            }
        }
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts("package", getPackageName(), null));
            startActivityForResult(intent, REQ_SETTINGS);
            return true;
        } catch (Throwable t) {
            Slog.w(TAG, "could not open the settings: " + t);
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQ_SETTINGS) return;
        // back from settings: look at the host again; the prompt is not shown a second time
        HostPermissionCheck.forget();
        mBlocked.clear();
        finishBridge();
    }

    private int[] allDenied() {
        int[] r = new int[mNames.length];
        for (int i = 0; i < r.length; i++) r[i] = PackageManager.PERMISSION_DENIED;
        return r;
    }

    private void deliver(int[] results) {
        Intent data = new Intent();
        data.putExtra(PermissionRequestRedirect.EXTRA_NAMES, mNames);
        data.putExtra(PermissionRequestRedirect.EXTRA_RESULTS, results);
        if (mDeviceIds != null) {
            data.putExtra(PermissionRequestRedirect.EXTRA_DEVICE_IDS, mDeviceIds);
        }
        setResult(RESULT_OK, data);
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        // the dialog handles back itself; this is only reached while nothing is shown yet
        if (mPlan == null) {
            mFinishing = true;
            deliver(allDenied());
            return;
        }
        super.onBackPressed();
    }

    // ------------------------------------------------------------------ small view helpers

    private static String groupTitle(String groupId) {
        if (groupId == null) return "অনুমতি";
        switch (groupId) {
            case PermissionCatalog.CAMERA: return "ক্যামেরা";
            case PermissionCatalog.MICROPHONE: return "মাইক্রোফোন";
            case PermissionCatalog.LOCATION: return "লোকেশন";
            case PermissionCatalog.CONTACTS: return "কন্টাক্ট";
            case PermissionCatalog.CALENDAR: return "ক্যালেন্ডার";
            case PermissionCatalog.PHONE: return "ফোন";
            case PermissionCatalog.SMS: return "এসএমএস";
            case PermissionCatalog.STORAGE: return "স্টোরেজ ও মিডিয়া";
            case PermissionCatalog.NOTIFICATIONS: return "নোটিফিকেশন";
            case PermissionCatalog.SENSORS: return "বডি সেন্সর";
            case PermissionCatalog.ACTIVITY: return "শারীরিক কার্যকলাপ";
            case PermissionCatalog.NEARBY: return "কাছের ডিভাইস";
            default: return groupId;
        }
    }

    private static String shortName(String permission) {
        int dot = permission.lastIndexOf('.');
        return dot >= 0 ? permission.substring(dot + 1) : permission;
    }

    private int dp(int v) {
        return Math.round(v * getResources().getDisplayMetrics().density);
    }

    private TextView text(String s, float sp, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(sp);
        t.setTextColor(color);
        if (bold) t.setTypeface(null, Typeface.BOLD);
        return t;
    }

    private LinearLayout.LayoutParams margins(int l, int t, int r, int b) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(l, t, r, b);
        return lp;
    }

    private TextView button(String label, String color, View.OnClickListener click) {
        TextView t = text(label, 15f, Color.parseColor("#1B1F3B"), true);
        t.setGravity(Gravity.CENTER);
        t.setPadding(dp(14), dp(13), dp(14), dp(13));
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.parseColor(color));
        bg.setCornerRadius(dp(14));
        t.setBackground(bg);
        t.setOnClickListener(click);
        t.setLayoutParams(margins(0, 0, 0, dp(8)));
        return t;
    }
}
