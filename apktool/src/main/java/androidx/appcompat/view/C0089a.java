package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.p008os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.C0059a;

/* compiled from: ActionBarPolicy.java */
/* renamed from: androidx.appcompat.view.a */
/* loaded from: classes.dex */
public class C0089a {

    /* renamed from: a */
    private Context f805a;

    /* renamed from: a */
    public static C0089a m738a(Context context) {
        return new C0089a(context);
    }

    private C0089a(Context context) {
        this.f805a = context;
    }

    /* renamed from: a */
    public int m739a() {
        Configuration configuration = this.f805a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600 || ((i > 960 && i2 > 720) || (i > 720 && i2 > 960))) {
            return 5;
        }
        if (i >= 500 || ((i > 640 && i2 > 480) || (i > 480 && i2 > 640))) {
            return 4;
        }
        if (i >= 360) {
            return 3;
        }
        return 2;
    }

    /* renamed from: b */
    public boolean m740b() {
        return Build.VERSION.SDK_INT >= 19 || !ViewConfiguration.get(this.f805a).hasPermanentMenuKey();
    }

    /* renamed from: c */
    public int m741c() {
        return this.f805a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: d */
    public boolean m742d() {
        return this.f805a.getResources().getBoolean(C0059a.b.abc_action_bar_embed_tabs);
    }

    /* renamed from: e */
    public int m743e() {
        TypedArray obtainStyledAttributes = this.f805a.obtainStyledAttributes(null, C0059a.j.ActionBar, C0059a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0059a.j.ActionBar_height, 0);
        Resources resources = this.f805a.getResources();
        if (!m742d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0059a.d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: f */
    public boolean m744f() {
        return this.f805a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: g */
    public int m745g() {
        return this.f805a.getResources().getDimensionPixelSize(C0059a.d.abc_action_bar_stacked_tab_max_width);
    }
}
