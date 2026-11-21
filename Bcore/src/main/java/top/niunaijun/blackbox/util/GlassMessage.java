package top.niunaijun.blackbox.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A toast drawn as a glass pill (dark translucent card, thin light border, rounded corners), the same look as
 * the launcher's glass toast. Inside an activity it floats at the bottom centre; from another context it floats
 * over any app when "Display over other apps" is allowed; otherwise it falls back to the system toast so the
 * message is never lost. One message at a time; safe to call from any thread.
 */
public final class GlassMessage {
    private static final String TAG = "glass_message";
    private static final Handler MAIN = new Handler(Looper.getMainLooper());

    private static View current;
    private static WindowManager currentWm;
    private static Runnable dismiss;

    private GlassMessage() {}

    public static void show(final Context context, final CharSequence text, final boolean longDuration) {
        if (context == null || text == null || text.length() == 0) return;
        final String message = text.toString();
        final long ms = longDuration ? 3500L : 2000L;
        MAIN.post(new Runnable() {
            @Override public void run() {
                boolean shown = false;
                try {
                    Activity activity = unwrap(context);
                    if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                        shown = showInActivity(activity, message, ms);
                    } else {
                        shown = showOverlay(context.getApplicationContext(), message, ms);
                    }
                } catch (Throwable ignored) {
                    shown = false;
                }
                if (!shown) {
                    try {
                        Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    } catch (Throwable ignored) {}
                }
            }
        });
    }

    private static Activity unwrap(Context c) {
        Context x = c;
        while (x instanceof ContextWrapper) {
            if (x instanceof Activity) return (Activity) x;
            x = ((ContextWrapper) x).getBaseContext();
        }
        return null;
    }

    private static int dp(Context c, int v) {
        return (int) (v * c.getResources().getDisplayMetrics().density);
    }

    private static LinearLayout buildCard(Context c, String message) {
        LinearLayout card = new LinearLayout(c);
        card.setTag(TAG);
        card.setOrientation(LinearLayout.HORIZONTAL);
        card.setGravity(Gravity.CENTER_VERTICAL);
        card.setPadding(dp(c, 18), dp(c, 11), dp(c, 18), dp(c, 11));
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.argb(225, 32, 36, 44));
        bg.setStroke(dp(c, 1), Color.argb(46, 255, 255, 255));
        bg.setCornerRadius(dp(c, 22));
        card.setBackground(bg);
        card.setElevation(dp(c, 10));
        card.setClickable(false);
        card.setFocusable(false);

        TextView tv = new TextView(c);
        tv.setText(message);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(14f);
        tv.setMaxLines(3);
        tv.setEllipsize(TextUtils.TruncateAt.END);
        card.addView(tv, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return card;
    }

    private static void animateIn(View card, float fromY) {
        card.setAlpha(0f);
        card.setTranslationY(fromY);
        card.animate().alpha(1f).translationY(0f).setDuration(200).start();
    }

    private static void scheduleDismiss(final View card, long ms) {
        if (dismiss != null) MAIN.removeCallbacks(dismiss);
        dismiss = new Runnable() {
            @Override public void run() {
                if (current == card) removeCurrent();
            }
        };
        MAIN.postDelayed(dismiss, ms);
    }

    private static void removeCurrent() {
        if (dismiss != null) MAIN.removeCallbacks(dismiss);
        dismiss = null;
        View v = current;
        if (v == null) return;
        current = null;
        WindowManager wm = currentWm;
        currentWm = null;
        try { v.animate().cancel(); } catch (Throwable ignored) {}
        try {
            if (wm != null) wm.removeViewImmediate(v);
            else if (v.getParent() instanceof ViewGroup) ((ViewGroup) v.getParent()).removeView(v);
        } catch (Throwable ignored) {}
    }

    private static boolean showInActivity(Activity activity, String message, long ms) {
        ViewGroup host = activity.findViewById(android.R.id.content);
        if (host == null) return false;
        removeCurrent();
        View old = host.findViewWithTag(TAG);
        if (old != null) host.removeView(old);

        LinearLayout card = buildCard(activity, message);
        int maxW = Math.min(activity.getResources().getDisplayMetrics().widthPixels - dp(activity, 48), dp(activity, 420));
        card.measure(View.MeasureSpec.makeMeasureSpec(maxW, View.MeasureSpec.AT_MOST),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        int w = Math.min(card.getMeasuredWidth(), maxW);

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                w, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
        lp.setMargins(dp(activity, 24), 0, dp(activity, 24), dp(activity, 48));
        host.addView(card, lp);
        current = card;
        currentWm = null;
        animateIn(card, dp(activity, 24));
        scheduleDismiss(card, ms);
        return true;
    }

    @SuppressWarnings("deprecation")
    private static boolean showOverlay(Context app, String message, long ms) {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(app)) return false;
        WindowManager wm = (WindowManager) app.getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) return false;
        removeCurrent();
        LinearLayout card = buildCard(app, message);

        int nbId = app.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        int navBar = nbId > 0 ? app.getResources().getDimensionPixelSize(nbId) : dp(app, 24);
        int type = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                : WindowManager.LayoutParams.TYPE_PHONE;
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, type,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);
        lp.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        lp.y = navBar + dp(app, 48);
        wm.addView(card, lp);
        current = card;
        currentWm = wm;
        animateIn(card, dp(app, 24));
        scheduleDismiss(card, ms);
        return true;
    }
}
