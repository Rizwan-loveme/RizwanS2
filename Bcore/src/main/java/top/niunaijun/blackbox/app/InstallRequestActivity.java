package top.niunaijun.blackbox.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.OpenableColumns;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;

import top.niunaijun.blackbox.BlackBoxCore;
import top.niunaijun.blackbox.utils.Slog;
import top.niunaijun.blackbox.utils.bundle.BundleInstaller;
import top.niunaijun.blackbox.utils.bundle.InstallErrors;

/**
 * Part 31: the install dialog of the box. Runs in the host main process and replaces the system
 * package installer for clones (see {@link top.niunaijun.blackbox.fake.service.InstallRequestRedirect}).
 *
 * One request = one file (.apk / .apks / .xapk / .apkm). The user is asked once; then the file is
 * installed with {@link BundleInstaller} into the SAME space as the clone that asked. An app that is
 * already in that space is updated and keeps its data. The answer goes back with the result codes of
 * the system installer (RESULT_OK = installed, RESULT_CANCELED = cancelled, RESULT_FIRST_USER = failed),
 * so a clone that used startActivityForResult() sees a normal result.
 */
public class InstallRequestActivity extends Activity {
    private static final String TAG = "InstallRequestUi";

    public static final String EXTRA_CLONE_PACKAGE = "bb_clone_package";
    public static final String EXTRA_CLONE_USER = "bb_clone_user";
    public static final String EXTRA_CLONE_LABEL = "bb_clone_label";
    /** Absolute path of the file when the clone's own provider could be mapped to one. */
    public static final String EXTRA_FILE = "bb_install_file";

    /** Intent.EXTRA_RETURN_RESULT / EXTRA_INSTALL_RESULT of the system installer. */
    private static final String EXTRA_RETURN_RESULT = "android.intent.extra.RETURN_RESULT";
    private static final String EXTRA_INSTALL_RESULT = "android.intent.extra.INSTALL_RESULT";
    private static final int INSTALL_SUCCEEDED = 1;
    private static final int INSTALL_FAILED_INTERNAL_ERROR = -110;

    private final Handler ui = new Handler(Looper.getMainLooper());
    private String cloneLabel;
    private int space;
    private File file;
    private Uri uri;
    private String fileName = "?";
    private long fileSize;
    private boolean returnResult;
    private boolean busy;
    private AlertDialog dialog;
    private TextView progressText;
    private ProgressBar progressBar;
    /** Set by the space chooser when the file turns out to be the launcher itself. */
    private volatile boolean selfBlocked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent in = getIntent();
        if (in == null) {
            finishWith(RESULT_CANCELED, 0);
            return;
        }
        cloneLabel = in.getStringExtra(EXTRA_CLONE_LABEL);
        if (cloneLabel == null) cloneLabel = in.getStringExtra(EXTRA_CLONE_PACKAGE);
        space = in.getIntExtra(EXTRA_CLONE_USER, 0);
        returnResult = in.getBooleanExtra(EXTRA_RETURN_RESULT, false);
        String path = in.getStringExtra(EXTRA_FILE);
        if (path != null) {
            file = new File(path);
            fileName = file.getName();
            fileSize = file.length();
        } else {
            uri = in.getData();
            readUriInfo();
        }
        if (file == null && uri == null) {
            showError("ইনস্টল করার ফাইলটি পাওয়া যায়নি।");
            return;
        }
        if (savedInstanceState == null) {
            showAsk();
        }
    }

    private void readUriInfo() {
        if (uri == null) return;
        Cursor c = null;
        try {
            c = getContentResolver().query(uri, new String[]{OpenableColumns.DISPLAY_NAME, OpenableColumns.SIZE}, null, null, null);
            if (c != null && c.moveToFirst()) {
                String n = c.getString(0);
                if (n != null) fileName = n;
                if (!c.isNull(1)) fileSize = c.getLong(1);
            }
        } catch (Throwable ignored) {
            // the name and size are only shown, the install does not need them
            String last = uri.getLastPathSegment();
            if (last != null) fileName = last;
        } finally {
            if (c != null) c.close();
        }
    }

    private static String sizeText(long bytes) {
        if (bytes <= 0) return "";
        if (bytes >= 1048576L) return " (" + (bytes / 1048576L) + " MB)";
        return " (" + ((bytes + 1023L) / 1024L) + " KB)";
    }

    // ------------------------------------------------------------------ dialogs

    private void showAsk() {
        String msg = cloneLabel + " (স্পেস " + (space + 1) + ") একটি অ্যাপ ইনস্টল করতে চায়।\n\n"
                + "ফাইল: " + fileName + sizeText(fileSize) + "\n\n"
                + "অ্যাপটি এই স্পেসের ভেতরেই ইনস্টল হবে, ফোনে নয়। আগে থেকে থাকলে আপডেট হবে, ডেটা থাকবে।";
        dialog = new AlertDialog.Builder(this)
                .setTitle("📥 ইনস্টল করবেন?")
                .setMessage(msg)
                .setPositiveButton("ইনস্টল", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface d, int which) {
                        startInstall();
                    }
                })
                .setNegativeButton("বাতিল", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface d, int which) {
                        finishWith(RESULT_CANCELED, 0);
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface d) {
                        finishWith(RESULT_CANCELED, 0);
                    }
                })
                .show();
    }

    private void showProgress() {
        int p = (int) (getResources().getDisplayMetrics().density * 20);
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setPadding(p, p, p, p / 2);
        progressText = new TextView(this);
        progressText.setText("⏳ প্রস্তুত হচ্ছে…");
        progressText.setTextSize(15);
        box.addView(progressText);
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setMax(1000);
        progressBar.setIndeterminate(true);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.topMargin = p / 2;
        box.addView(progressBar, lp);
        TextView name = new TextView(this);
        name.setText(fileName);
        name.setTextSize(12);
        name.setGravity(Gravity.START);
        box.addView(name);
        dismissDialog();
        dialog = new AlertDialog.Builder(this).setTitle("📥 ইনস্টল হচ্ছে").setView(box).setCancelable(false).show();
    }

    private void showDone(final BundleInstaller.Result r) {
        dismissDialog();
        final String label = labelOf(r.packageName, r.userId);
        StringBuilder msg = new StringBuilder("✅ ").append(label).append(" ইনস্টল হয়েছে (স্পেস ").append(r.userId + 1).append(")");
        if (r.obbCount > 0) msg.append("\n🎮 OBB ফাইল কপি হয়েছে (").append(r.obbCount).append(" টি)");
        AlertDialog.Builder b = new AlertDialog.Builder(this)
                .setTitle("ইনস্টল সম্পন্ন")
                .setMessage(msg.toString())
                .setPositiveButton("ঠিক আছে", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface d, int which) {
                        finishWith(RESULT_OK, INSTALL_SUCCEEDED);
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface d) {
                        finishWith(RESULT_OK, INSTALL_SUCCEEDED);
                    }
                });
        if (r.packageName != null) {
            final String pkg = r.packageName;
            b.setNeutralButton("খুলুন", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface d, int which) {
                    try {
                        BlackBoxCore.get().launchApk(pkg, r.userId);
                    } catch (Throwable t) {
                        Slog.w(TAG, "launch failed: " + t);
                    }
                    finishWith(RESULT_OK, INSTALL_SUCCEEDED);
                }
            });
        }
        dialog = b.show();
    }

    private void showError(String text) {
        dismissDialog();
        dialog = new AlertDialog.Builder(this)
                .setTitle("❌ ইনস্টল হয়নি")
                .setMessage(text)
                .setPositiveButton("ঠিক আছে", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface d, int which) {
                        finishWith(RESULT_FIRST_USER, INSTALL_FAILED_INTERNAL_ERROR);
                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface d) {
                        finishWith(RESULT_FIRST_USER, INSTALL_FAILED_INTERNAL_ERROR);
                    }
                })
                .show();
    }

    private void dismissDialog() {
        try {
            if (dialog != null && dialog.isShowing()) dialog.dismiss();
        } catch (Throwable ignored) {
        }
        dialog = null;
    }

    // ------------------------------------------------------------------ install

    private void startInstall() {
        if (busy) return;
        busy = true;
        showProgress();
        final BundleInstaller.SpaceChooser chooser = new BundleInstaller.SpaceChooser() {
            @Override
            public int spaceFor(String packageName) {
                if (packageName != null && packageName.equals(BlackBoxCore.getHostPkg())) {
                    selfBlocked = true;
                    return -1;
                }
                return space; // always the space of the clone that asked (an existing copy is updated)
            }
        };
        final BundleInstaller.Listener listener = new BundleInstaller.Listener() {
            @Override
            public void onProgress(final BundleInstaller.Stage stage, final long done, final long total) {
                ui.post(new Runnable() {
                    @Override
                    public void run() {
                        if (isFinishing() || progressText == null) return;
                        progressText.setText(stageText(stage) + amount(done, total));
                        boolean determinate = total > 0 && (stage == BundleInstaller.Stage.COPYING
                                || stage == BundleInstaller.Stage.UNPACKING || stage == BundleInstaller.Stage.COPYING_OBB);
                        progressBar.setIndeterminate(!determinate);
                        if (determinate) {
                            progressBar.setProgress((int) Math.max(0, Math.min(1000, (done * 1000L) / total)));
                        }
                    }
                });
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                BundleInstaller.Result r;
                try {
                    r = file != null
                            ? BundleInstaller.install(file, chooser, listener)
                            : BundleInstaller.install(getApplicationContext(), uri, fileSize, chooser, listener);
                } catch (Throwable t) {
                    r = new BundleInstaller.Result();
                    r.success = false;
                    r.message = String.valueOf(t.getMessage());
                }
                final BundleInstaller.Result result = r;
                ui.post(new Runnable() {
                    @Override
                    public void run() {
                        busy = false;
                        if (isFinishing()) return;
                        if (result.success) showDone(result);
                        else showError(errorText(result));
                    }
                });
            }
        }, "InstallRequest").start();
    }

    private String errorText(BundleInstaller.Result r) {
        if (selfBlocked) {
            return "এই ফাইলটি Parallel অ্যাপ নিজেই। নিজের ভেতরে নিজেকে ইনস্টল করা যায় না।";
        }
        InstallErrors.Kind k = r.kind == null ? InstallErrors.Kind.UNKNOWN : r.kind;
        String head;
        switch (k) {
            case WRONG_ABI:
                head = "এই অ্যাপের নেটিভ কোড এই ফোনে চলে না (আর্কিটেকচার মেলেনি)।";
                break;
            case BAD_FILE:
                head = "ফাইলটি ঠিক নেই (পড়ার মতো zip বা APK নয়)।";
                break;
            case NO_APK:
                head = "ফাইলের ভেতরে কোনো APK পাওয়া যায়নি।";
                break;
            case NOT_ENOUGH_SPACE:
                head = "ফোনে জায়গা কম।";
                break;
            case SPLIT_UNREADABLE:
                head = "একটি split ফাইল পড়া যায়নি।";
                break;
            case BROKEN_APK:
                head = "APK ফাইলটি নষ্ট বা পড়া যায়নি।";
                break;
            case CANNOT_READ:
                head = "ফাইলটি পড়া বা কপি করা যায়নি।";
                break;
            case OBB_COPY:
                head = "OBB ফাইল কপি করা যায়নি, অ্যাপ ইনস্টল হয়নি।";
                break;
            case SELF:
                head = "নিজের ভেতরে নিজেকে ইনস্টল করা যায় না।";
                break;
            default:
                head = "ইনস্টল করা যায়নি।";
        }
        String detail = r.message == null || r.message.isEmpty() ? "" : "\n\n" + r.message;
        return head + detail;
    }

    private String labelOf(String pkg, int userId) {
        if (pkg == null) return "অ্যাপ";
        try {
            ApplicationInfo ai = BlackBoxCore.getBPackageManager().getApplicationInfo(pkg, 0, userId);
            if (ai != null) {
                CharSequence l = getPackageManager().getApplicationLabel(ai);
                if (l != null && l.length() > 0) return l.toString();
            }
        } catch (Throwable ignored) {
        }
        return pkg;
    }

    private static String stageText(BundleInstaller.Stage s) {
        switch (s) {
            case COPYING:
                return "⏳ ফাইল কপি হচ্ছে";
            case UNPACKING:
                return "⏳ ফাইল খোলা হচ্ছে";
            case CHECKING:
                return "⏳ ফাইল দেখা হচ্ছে";
            case COPYING_OBB:
                return "⏳ OBB কপি হচ্ছে";
            default:
                return "⏳ ইনস্টল হচ্ছে";
        }
    }

    private static String amount(long done, long total) {
        if (total <= 0) return "";
        return "  " + (done / 1048576L) + "/" + (total / 1048576L) + " MB";
    }

    // ------------------------------------------------------------------ result

    private void finishWith(int resultCode, int installResult) {
        if (returnResult || resultCode == RESULT_OK) {
            Intent out = new Intent();
            out.putExtra(EXTRA_INSTALL_RESULT, installResult);
            setResult(resultCode, out);
        } else {
            setResult(resultCode);
        }
        finish();
    }

    @Override
    public void onBackPressed() {
        if (busy) return; // the install must finish first
        finishWith(RESULT_CANCELED, 0);
    }

    @Override
    protected void onDestroy() {
        dismissDialog();
        super.onDestroy();
    }
}
