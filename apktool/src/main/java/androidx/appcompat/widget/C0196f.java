package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.core.p031f.C0308x;

/* compiled from: AppCompatBackgroundHelper.java */
/* renamed from: androidx.appcompat.widget.f */
/* loaded from: classes.dex */
class C0196f {

    /* renamed from: a */
    private final View f1692a;

    /* renamed from: d */
    private C0182ax f1695d;

    /* renamed from: e */
    private C0182ax f1696e;

    /* renamed from: f */
    private C0182ax f1697f;

    /* renamed from: c */
    private int f1694c = -1;

    /* renamed from: b */
    private final C0201k f1693b = C0201k.m1545b();

    C0196f(View view) {
        this.f1692a = view;
    }

    /* renamed from: a */
    void m1530a(AttributeSet attributeSet, int i) {
        C0184az m1432a = C0184az.m1432a(this.f1692a.getContext(), attributeSet, C0059a.j.ViewBackgroundHelper, i, 0);
        C0308x.m2230a(this.f1692a, this.f1692a.getContext(), C0059a.j.ViewBackgroundHelper, attributeSet, m1432a.m1435a(), i, 0);
        try {
            if (m1432a.m1451g(C0059a.j.ViewBackgroundHelper_android_background)) {
                this.f1694c = m1432a.m1450g(C0059a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList m1550b = this.f1693b.m1550b(this.f1692a.getContext(), this.f1694c);
                if (m1550b != null) {
                    m1532b(m1550b);
                }
            }
            if (m1432a.m1451g(C0059a.j.ViewBackgroundHelper_backgroundTint)) {
                C0308x.m2231a(this.f1692a, m1432a.m1447e(C0059a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (m1432a.m1451g(C0059a.j.ViewBackgroundHelper_backgroundTintMode)) {
                C0308x.m2232a(this.f1692a, C0165ag.m1261a(m1432a.m1434a(C0059a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            m1432a.m1441b();
        }
    }

    /* renamed from: a */
    void m1526a(int i) {
        ColorStateList colorStateList;
        this.f1694c = i;
        if (this.f1693b != null) {
            colorStateList = this.f1693b.m1550b(this.f1692a.getContext(), i);
        } else {
            colorStateList = null;
        }
        m1532b(colorStateList);
        m1533c();
    }

    /* renamed from: a */
    void m1529a(Drawable drawable) {
        this.f1694c = -1;
        m1532b((ColorStateList) null);
        m1533c();
    }

    /* renamed from: a */
    void m1527a(ColorStateList colorStateList) {
        if (this.f1696e == null) {
            this.f1696e = new C0182ax();
        }
        this.f1696e.f1584a = colorStateList;
        this.f1696e.f1587d = true;
        m1533c();
    }

    /* renamed from: a */
    ColorStateList m1525a() {
        if (this.f1696e != null) {
            return this.f1696e.f1584a;
        }
        return null;
    }

    /* renamed from: a */
    void m1528a(PorterDuff.Mode mode) {
        if (this.f1696e == null) {
            this.f1696e = new C0182ax();
        }
        this.f1696e.f1585b = mode;
        this.f1696e.f1586c = true;
        m1533c();
    }

    /* renamed from: b */
    PorterDuff.Mode m1531b() {
        if (this.f1696e != null) {
            return this.f1696e.f1585b;
        }
        return null;
    }

    /* renamed from: c */
    void m1533c() {
        Drawable background = this.f1692a.getBackground();
        if (background != null) {
            if (!m1524d() || !m1523b(background)) {
                if (this.f1696e != null) {
                    C0201k.m1544a(background, this.f1696e, this.f1692a.getDrawableState());
                } else if (this.f1695d != null) {
                    C0201k.m1544a(background, this.f1695d, this.f1692a.getDrawableState());
                }
            }
        }
    }

    /* renamed from: b */
    void m1532b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1695d == null) {
                this.f1695d = new C0182ax();
            }
            this.f1695d.f1584a = colorStateList;
            this.f1695d.f1587d = true;
        } else {
            this.f1695d = null;
        }
        m1533c();
    }

    /* renamed from: d */
    private boolean m1524d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1695d != null : i == 21;
    }

    /* renamed from: b */
    private boolean m1523b(Drawable drawable) {
        if (this.f1697f == null) {
            this.f1697f = new C0182ax();
        }
        C0182ax c0182ax = this.f1697f;
        c0182ax.m1429a();
        ColorStateList m2271r = C0308x.m2271r(this.f1692a);
        if (m2271r != null) {
            c0182ax.f1587d = true;
            c0182ax.f1584a = m2271r;
        }
        PorterDuff.Mode m2272s = C0308x.m2272s(this.f1692a);
        if (m2272s != null) {
            c0182ax.f1586c = true;
            c0182ax.f1585b = m2272s;
        }
        if (!c0182ax.f1587d && !c0182ax.f1586c) {
            return false;
        }
        C0201k.m1544a(drawable, c0182ax, this.f1692a.getDrawableState());
        return true;
    }
}
