package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p014a.p015a.C0060a;
import androidx.core.p031f.C0308x;
import androidx.core.widget.C0335e;

/* compiled from: AppCompatImageHelper.java */
/* renamed from: androidx.appcompat.widget.o */
/* loaded from: classes.dex */
public class C0205o {

    /* renamed from: a */
    private final ImageView f1726a;

    /* renamed from: b */
    private C0182ax f1727b;

    /* renamed from: c */
    private C0182ax f1728c;

    /* renamed from: d */
    private C0182ax f1729d;

    public C0205o(ImageView imageView) {
        this.f1726a = imageView;
    }

    /* renamed from: a */
    public void m1566a(AttributeSet attributeSet, int i) {
        int m1450g;
        C0184az m1432a = C0184az.m1432a(this.f1726a.getContext(), attributeSet, C0059a.j.AppCompatImageView, i, 0);
        C0308x.m2230a(this.f1726a, this.f1726a.getContext(), C0059a.j.AppCompatImageView, attributeSet, m1432a.m1435a(), i, 0);
        try {
            Drawable drawable = this.f1726a.getDrawable();
            if (drawable == null && (m1450g = m1432a.m1450g(C0059a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = C0060a.m348b(this.f1726a.getContext(), m1450g)) != null) {
                this.f1726a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                C0165ag.m1262a(drawable);
            }
            if (m1432a.m1451g(C0059a.j.AppCompatImageView_tint)) {
                C0335e.m2501a(this.f1726a, m1432a.m1447e(C0059a.j.AppCompatImageView_tint));
            }
            if (m1432a.m1451g(C0059a.j.AppCompatImageView_tintMode)) {
                C0335e.m2502a(this.f1726a, C0165ag.m1261a(m1432a.m1434a(C0059a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            m1432a.m1441b();
        }
    }

    /* renamed from: a */
    public void m1563a(int i) {
        if (i != 0) {
            Drawable m348b = C0060a.m348b(this.f1726a.getContext(), i);
            if (m348b != null) {
                C0165ag.m1262a(m348b);
            }
            this.f1726a.setImageDrawable(m348b);
        } else {
            this.f1726a.setImageDrawable(null);
        }
        m1570d();
    }

    /* renamed from: a */
    boolean m1567a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1726a.getBackground() instanceof RippleDrawable);
    }

    /* renamed from: a */
    void m1564a(ColorStateList colorStateList) {
        if (this.f1728c == null) {
            this.f1728c = new C0182ax();
        }
        this.f1728c.f1584a = colorStateList;
        this.f1728c.f1587d = true;
        m1570d();
    }

    /* renamed from: b */
    ColorStateList m1568b() {
        if (this.f1728c != null) {
            return this.f1728c.f1584a;
        }
        return null;
    }

    /* renamed from: a */
    void m1565a(PorterDuff.Mode mode) {
        if (this.f1728c == null) {
            this.f1728c = new C0182ax();
        }
        this.f1728c.f1585b = mode;
        this.f1728c.f1586c = true;
        m1570d();
    }

    /* renamed from: c */
    PorterDuff.Mode m1569c() {
        if (this.f1728c != null) {
            return this.f1728c.f1585b;
        }
        return null;
    }

    /* renamed from: d */
    void m1570d() {
        Drawable drawable = this.f1726a.getDrawable();
        if (drawable != null) {
            C0165ag.m1262a(drawable);
        }
        if (drawable != null) {
            if (!m1562e() || !m1561a(drawable)) {
                if (this.f1728c != null) {
                    C0201k.m1544a(drawable, this.f1728c, this.f1726a.getDrawableState());
                } else if (this.f1727b != null) {
                    C0201k.m1544a(drawable, this.f1727b, this.f1726a.getDrawableState());
                }
            }
        }
    }

    /* renamed from: e */
    private boolean m1562e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1727b != null : i == 21;
    }

    /* renamed from: a */
    private boolean m1561a(Drawable drawable) {
        if (this.f1729d == null) {
            this.f1729d = new C0182ax();
        }
        C0182ax c0182ax = this.f1729d;
        c0182ax.m1429a();
        ColorStateList m2500a = C0335e.m2500a(this.f1726a);
        if (m2500a != null) {
            c0182ax.f1587d = true;
            c0182ax.f1584a = m2500a;
        }
        PorterDuff.Mode m2503b = C0335e.m2503b(this.f1726a);
        if (m2503b != null) {
            c0182ax.f1586c = true;
            c0182ax.f1585b = m2503b;
        }
        if (!c0182ax.f1587d && !c0182ax.f1586c) {
            return false;
        }
        C0201k.m1544a(drawable, c0182ax, this.f1726a.getDrawableState());
        return true;
    }
}
