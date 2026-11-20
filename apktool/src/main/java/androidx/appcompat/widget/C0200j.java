package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.graphics.drawable.C0315a;
import androidx.core.p031f.C0308x;
import androidx.core.widget.C0333c;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* renamed from: androidx.appcompat.widget.j */
/* loaded from: classes.dex */
class C0200j {

    /* renamed from: a */
    private final CompoundButton f1705a;

    /* renamed from: b */
    private ColorStateList f1706b = null;

    /* renamed from: c */
    private PorterDuff.Mode f1707c = null;

    /* renamed from: d */
    private boolean f1708d = false;

    /* renamed from: e */
    private boolean f1709e = false;

    /* renamed from: f */
    private boolean f1710f;

    C0200j(CompoundButton compoundButton) {
        this.f1705a = compoundButton;
    }

    /* renamed from: a */
    void m1538a(AttributeSet attributeSet, int i) {
        int m1450g;
        int m1450g2;
        boolean z = false;
        C0184az m1432a = C0184az.m1432a(this.f1705a.getContext(), attributeSet, C0059a.j.CompoundButton, i, 0);
        C0308x.m2230a(this.f1705a, this.f1705a.getContext(), C0059a.j.CompoundButton, attributeSet, m1432a.m1435a(), i, 0);
        try {
            if (m1432a.m1451g(C0059a.j.CompoundButton_buttonCompat) && (m1450g2 = m1432a.m1450g(C0059a.j.CompoundButton_buttonCompat, 0)) != 0) {
                try {
                    this.f1705a.setButtonDrawable(C0060a.m348b(this.f1705a.getContext(), m1450g2));
                    z = true;
                } catch (Resources.NotFoundException e2) {
                }
            }
            if (!z && m1432a.m1451g(C0059a.j.CompoundButton_android_button) && (m1450g = m1432a.m1450g(C0059a.j.CompoundButton_android_button, 0)) != 0) {
                this.f1705a.setButtonDrawable(C0060a.m348b(this.f1705a.getContext(), m1450g));
            }
            if (m1432a.m1451g(C0059a.j.CompoundButton_buttonTint)) {
                C0333c.m2497a(this.f1705a, m1432a.m1447e(C0059a.j.CompoundButton_buttonTint));
            }
            if (m1432a.m1451g(C0059a.j.CompoundButton_buttonTintMode)) {
                C0333c.m2498a(this.f1705a, C0165ag.m1261a(m1432a.m1434a(C0059a.j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            m1432a.m1441b();
        }
    }

    /* renamed from: a */
    void m1536a(ColorStateList colorStateList) {
        this.f1706b = colorStateList;
        this.f1708d = true;
        m1541d();
    }

    /* renamed from: a */
    ColorStateList m1535a() {
        return this.f1706b;
    }

    /* renamed from: a */
    void m1537a(PorterDuff.Mode mode) {
        this.f1707c = mode;
        this.f1709e = true;
        m1541d();
    }

    /* renamed from: b */
    PorterDuff.Mode m1539b() {
        return this.f1707c;
    }

    /* renamed from: c */
    void m1540c() {
        if (this.f1710f) {
            this.f1710f = false;
        } else {
            this.f1710f = true;
            m1541d();
        }
    }

    /* renamed from: d */
    void m1541d() {
        Drawable m2496a = C0333c.m2496a(this.f1705a);
        if (m2496a != null) {
            if (this.f1708d || this.f1709e) {
                Drawable mutate = C0315a.m2369f(m2496a).mutate();
                if (this.f1708d) {
                    C0315a.m2359a(mutate, this.f1706b);
                }
                if (this.f1709e) {
                    C0315a.m2362a(mutate, this.f1707c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1705a.getDrawableState());
                }
                this.f1705a.setButtonDrawable(mutate);
            }
        }
    }

    /* renamed from: a */
    int m1534a(int i) {
        Drawable m2496a;
        if (Build.VERSION.SDK_INT < 17 && (m2496a = C0333c.m2496a(this.f1705a)) != null) {
            return i + m2496a.getIntrinsicWidth();
        }
        return i;
    }
}
