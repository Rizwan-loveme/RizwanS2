package androidx.core.p031f;

import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper.java */
/* renamed from: androidx.core.f.m */
/* loaded from: classes.dex */
public class C0297m {

    /* renamed from: a */
    private ViewParent f2199a;

    /* renamed from: b */
    private ViewParent f2200b;

    /* renamed from: c */
    private final View f2201c;

    /* renamed from: d */
    private boolean f2202d;

    /* renamed from: e */
    private int[] f2203e;

    public C0297m(View view) {
        this.f2201c = view;
    }

    /* renamed from: a */
    public void m2190a(boolean z) {
        if (this.f2202d) {
            C0308x.m2274u(this.f2201c);
        }
        this.f2202d = z;
    }

    /* renamed from: a */
    public boolean m2191a() {
        return this.f2202d;
    }

    /* renamed from: b */
    public boolean m2199b() {
        return m2194a(0);
    }

    /* renamed from: a */
    public boolean m2194a(int i) {
        return m2187d(i) != null;
    }

    /* renamed from: b */
    public boolean m2200b(int i) {
        return m2195a(i, 0);
    }

    /* renamed from: a */
    public boolean m2195a(int i, int i2) {
        if (m2194a(i2)) {
            return true;
        }
        if (m2191a()) {
            View view = this.f2201c;
            for (ViewParent parent = this.f2201c.getParent(); parent != null; parent = parent.getParent()) {
                if (C0277aa.m2054a(parent, view, this.f2201c, i, i2)) {
                    m2185a(i2, parent);
                    C0277aa.m2055b(parent, view, this.f2201c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m2201c() {
        m2202c(0);
    }

    /* renamed from: c */
    public void m2202c(int i) {
        ViewParent m2187d = m2187d(i);
        if (m2187d != null) {
            C0277aa.m2049a(m2187d, this.f2201c, i);
            m2185a(i, (ViewParent) null);
        }
    }

    /* renamed from: a */
    public boolean m2196a(int i, int i2, int i3, int i4, int[] iArr) {
        return m2186b(i, i2, i3, i4, iArr, 0, null);
    }

    /* renamed from: a */
    public void m2189a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        m2186b(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: b */
    private boolean m2186b(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent m2187d;
        int i6;
        int i7;
        int[] iArr3;
        if (!m2191a() || (m2187d = m2187d(i5)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            if (iArr == null) {
                i6 = 0;
                i7 = 0;
            } else {
                this.f2201c.getLocationInWindow(iArr);
                int i8 = iArr[0];
                i6 = iArr[1];
                i7 = i8;
            }
            if (iArr2 == null) {
                iArr3 = m2188d();
                iArr3[0] = 0;
                iArr3[1] = 0;
            } else {
                iArr3 = iArr2;
            }
            C0277aa.m2050a(m2187d, this.f2201c, i, i2, i3, i4, i5, iArr3);
            if (iArr != null) {
                this.f2201c.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i7;
                iArr[1] = iArr[1] - i6;
            }
            return true;
        }
        if (iArr != null) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m2197a(int i, int i2, int[] iArr, int[] iArr2) {
        return m2198a(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: a */
    public boolean m2198a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent m2187d;
        int i4;
        int i5;
        if (!m2191a() || (m2187d = m2187d(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f2201c.getLocationInWindow(iArr2);
                int i6 = iArr2[0];
                i4 = iArr2[1];
                i5 = i6;
            } else {
                i4 = 0;
                i5 = 0;
            }
            int[] m2188d = iArr == null ? m2188d() : iArr;
            m2188d[0] = 0;
            m2188d[1] = 0;
            C0277aa.m2051a(m2187d, this.f2201c, i, i2, m2188d, i3);
            if (iArr2 != null) {
                this.f2201c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i5;
                iArr2[1] = iArr2[1] - i4;
            }
            return (m2188d[0] == 0 && m2188d[1] == 0) ? false : true;
        }
        if (iArr2 == null) {
            return false;
        }
        iArr2[0] = 0;
        iArr2[1] = 0;
        return false;
    }

    /* renamed from: a */
    public boolean m2193a(float f2, float f3, boolean z) {
        ViewParent m2187d;
        if (!m2191a() || (m2187d = m2187d(0)) == null) {
            return false;
        }
        return C0277aa.m2053a(m2187d, this.f2201c, f2, f3, z);
    }

    /* renamed from: a */
    public boolean m2192a(float f2, float f3) {
        ViewParent m2187d;
        if (!m2191a() || (m2187d = m2187d(0)) == null) {
            return false;
        }
        return C0277aa.m2052a(m2187d, this.f2201c, f2, f3);
    }

    /* renamed from: d */
    private ViewParent m2187d(int i) {
        switch (i) {
            case 0:
                return this.f2199a;
            case 1:
                return this.f2200b;
            default:
                return null;
        }
    }

    /* renamed from: a */
    private void m2185a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f2199a = viewParent;
                break;
            case 1:
                this.f2200b = viewParent;
                break;
        }
    }

    /* renamed from: d */
    private int[] m2188d() {
        if (this.f2203e == null) {
            this.f2203e = new int[2];
        }
        return this.f2203e;
    }
}
