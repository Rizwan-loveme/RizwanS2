package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.C0059a;

/* compiled from: TooltipPopup.java */
/* renamed from: androidx.appcompat.widget.bd */
/* loaded from: classes.dex */
class C0189bd {

    /* renamed from: a */
    private final Context f1628a;

    /* renamed from: b */
    private final View f1629b;

    /* renamed from: c */
    private final TextView f1630c;

    /* renamed from: d */
    private final WindowManager.LayoutParams f1631d = new WindowManager.LayoutParams();

    /* renamed from: e */
    private final Rect f1632e = new Rect();

    /* renamed from: f */
    private final int[] f1633f = new int[2];

    /* renamed from: g */
    private final int[] f1634g = new int[2];

    C0189bd(Context context) {
        this.f1628a = context;
        this.f1629b = LayoutInflater.from(this.f1628a).inflate(C0059a.g.abc_tooltip, (ViewGroup) null);
        this.f1630c = (TextView) this.f1629b.findViewById(C0059a.f.message);
        this.f1631d.setTitle(getClass().getSimpleName());
        this.f1631d.packageName = this.f1628a.getPackageName();
        this.f1631d.type = 1002;
        this.f1631d.width = -2;
        this.f1631d.height = -2;
        this.f1631d.format = -3;
        this.f1631d.windowAnimations = C0059a.i.Animation_AppCompat_Tooltip;
        this.f1631d.flags = 24;
    }

    /* renamed from: a */
    void m1475a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m1476b()) {
            m1474a();
        }
        this.f1630c.setText(charSequence);
        m1473a(view, i, i2, z, this.f1631d);
        ((WindowManager) this.f1628a.getSystemService(Context.WINDOW_SERVICE)).addView(this.f1629b, this.f1631d);
    }

    /* renamed from: a */
    void m1474a() {
        if (m1476b()) {
            ((WindowManager) this.f1628a.getSystemService(Context.WINDOW_SERVICE)).removeView(this.f1629b);
        }
    }

    /* renamed from: b */
    boolean m1476b() {
        return this.f1629b.getParent() != null;
    }

    /* renamed from: a */
    private void m1473a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1628a.getResources().getDimensionPixelOffset(C0059a.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1628a.getResources().getDimensionPixelOffset(C0059a.d.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1628a.getResources().getDimensionPixelOffset(z ? C0059a.d.tooltip_y_offset_touch : C0059a.d.tooltip_y_offset_non_touch);
        View m1472a = m1472a(view);
        if (m1472a == null) {
            Log.m184e("TooltipPopup", "Cannot find app view");
            return;
        }
        m1472a.getWindowVisibleDisplayFrame(this.f1632e);
        if (this.f1632e.left < 0 && this.f1632e.top < 0) {
            Resources resources = this.f1628a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1632e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        m1472a.getLocationOnScreen(this.f1634g);
        view.getLocationOnScreen(this.f1633f);
        int[] iArr = this.f1633f;
        iArr[0] = iArr[0] - this.f1634g[0];
        int[] iArr2 = this.f1633f;
        iArr2[1] = iArr2[1] - this.f1634g[1];
        layoutParams.f283x = (this.f1633f[0] + i) - (m1472a.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1629b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1629b.getMeasuredHeight();
        int i4 = ((i3 + this.f1633f[1]) - dimensionPixelOffset3) - measuredHeight;
        int i5 = height + this.f1633f[1] + dimensionPixelOffset3;
        if (z) {
            if (i4 >= 0) {
                layoutParams.f284y = i4;
                return;
            } else {
                layoutParams.f284y = i5;
                return;
            }
        }
        if (measuredHeight + i5 <= this.f1632e.height()) {
            layoutParams.f284y = i5;
        } else {
            layoutParams.f284y = i4;
        }
    }

    /* renamed from: a */
    private static View m1472a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
