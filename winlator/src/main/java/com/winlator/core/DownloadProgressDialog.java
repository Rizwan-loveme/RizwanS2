package com.winlator.core;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.winlator.R;
import com.winlator.math.Mathf;

public class DownloadProgressDialog {
    private final Activity activity;
    private Dialog dialog;

    public DownloadProgressDialog(Activity activity) {
        this.activity = activity;
    }

    private void create() {
        if (dialog != null) return;
        dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.download_progress_dialog);
        GlassStyle.apply(activity, dialog.findViewById(R.id.LLCard)); // Win11 glass look (part 9)

        Window window = dialog.getWindow();
        if (window != null) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }
    }

    public void show() {
        show(null);
    }

    public void show(int textResId) {
        show(textResId, null);
    }

    public void show(Runnable onCancelCallback) {
        show(0, onCancelCallback);
    }

    public void show(int textResId, final Runnable onCancelCallback) {
        if (isShowing()) return;
        close();
        if (dialog == null) create();

        if (textResId > 0) ((TextView)dialog.findViewById(R.id.TextView)).setText(textResId);

        setProgress(0);
        if (onCancelCallback != null) {
            dialog.findViewById(R.id.BTCancel).setOnClickListener((v) -> onCancelCallback.run());
            dialog.findViewById(R.id.LLBottomBar).setVisibility(View.VISIBLE);
        }
        dialog.show();
    }

    public void setProgress(int progress) {
        if (dialog == null) return;
        progress = Mathf.clamp(progress, 0, 100);
        ((CircularProgressIndicator)dialog.findViewById(R.id.CircularProgressIndicator)).setProgress(progress);
        ((TextView)dialog.findViewById(R.id.TVProgress)).setText(progress+"%");
    }

    /** Part 7: changes the main line while the dialog is open (e.g. step 1 / step 2 of the set-up). */
    public void setText(final int textResId) {
        activity.runOnUiThread(() -> {
            if (dialog != null) ((TextView)dialog.findViewById(R.id.TextView)).setText(textResId);
        });
    }

    /** Part 7: small second line under the main text (0 hides it). */
    public void setHint(final int textResId) {
        activity.runOnUiThread(() -> {
            if (dialog == null) return;
            TextView hint = dialog.findViewById(R.id.TVHint);
            if (textResId > 0) {
                hint.setText(textResId);
                hint.setVisibility(View.VISIBLE);
            }
            else hint.setVisibility(View.GONE);
        });
    }

    /** Part 7: spinning ring without a percentage, for steps whose length is not known (container creation). */
    public void setIndeterminate(final boolean indeterminate) {
        activity.runOnUiThread(() -> {
            if (dialog == null) return;
            CircularProgressIndicator indicator = dialog.findViewById(R.id.CircularProgressIndicator);
            indicator.setIndeterminate(indeterminate);
            dialog.findViewById(R.id.TVProgress).setVisibility(indeterminate ? View.INVISIBLE : View.VISIBLE);
        });
    }

    public void close() {
        try {
            if (dialog != null) {
                dialog.dismiss();
            }
        }
        catch (Exception e) {}
    }

    public void closeOnUiThread() {
        activity.runOnUiThread(this::close);
    }

    public boolean isShowing() {
        return dialog != null && dialog.isShowing();
    }
}
