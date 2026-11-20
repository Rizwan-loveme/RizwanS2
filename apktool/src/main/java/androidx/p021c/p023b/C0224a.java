package androidx.p021c.p023b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.p031f.C0308x;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* renamed from: androidx.c.b.a */
/* loaded from: classes.dex */
public class C0224a {

    /* renamed from: w */
    private static final Interpolator f1800w = new Interpolator() { // from class: androidx.c.b.a.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: a */
    private int f1801a;

    /* renamed from: b */
    private int f1802b;

    /* renamed from: d */
    private float[] f1804d;

    /* renamed from: e */
    private float[] f1805e;

    /* renamed from: f */
    private float[] f1806f;

    /* renamed from: g */
    private float[] f1807g;

    /* renamed from: h */
    private int[] f1808h;

    /* renamed from: i */
    private int[] f1809i;

    /* renamed from: j */
    private int[] f1810j;

    /* renamed from: k */
    private int f1811k;

    /* renamed from: l */
    private VelocityTracker f1812l;

    /* renamed from: m */
    private float f1813m;

    /* renamed from: n */
    private float f1814n;

    /* renamed from: o */
    private int f1815o;

    /* renamed from: p */
    private final int f1816p;

    /* renamed from: q */
    private int f1817q;

    /* renamed from: r */
    private OverScroller f1818r;

    /* renamed from: s */
    private final a f1819s;

    /* renamed from: t */
    private View f1820t;

    /* renamed from: u */
    private boolean f1821u;

    /* renamed from: v */
    private final ViewGroup f1822v;

    /* renamed from: c */
    private int f1803c = -1;

    /* renamed from: x */
    private final Runnable f1823x = new Runnable() { // from class: androidx.c.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            C0224a.this.m1661d(0);
        }
    };

    /* compiled from: ViewDragHelper.java */
    /* renamed from: androidx.c.b.a$a */
    public static abstract class a {
        /* renamed from: b */
        public abstract boolean mo1676b(View view, int i);

        /* renamed from: a */
        public void mo1667a(int i) {
        }

        /* renamed from: a */
        public void mo1671a(View view, int i, int i2, int i3, int i4) {
        }

        /* renamed from: a */
        public void mo1670a(View view, int i) {
        }

        /* renamed from: a */
        public void mo1669a(View view, float f2, float f3) {
        }

        /* renamed from: a */
        public void mo1668a(int i, int i2) {
        }

        /* renamed from: b */
        public boolean mo1675b(int i) {
            return false;
        }

        /* renamed from: b */
        public void mo1674b(int i, int i2) {
        }

        /* renamed from: c */
        public int m1677c(int i) {
            return i;
        }

        /* renamed from: a */
        public int mo1665a(View view) {
            return 0;
        }

        /* renamed from: b */
        public int m1672b(View view) {
            return 0;
        }

        /* renamed from: a */
        public int mo1666a(View view, int i, int i2) {
            return 0;
        }

        /* renamed from: b */
        public int mo1673b(View view, int i, int i2) {
            return 0;
        }
    }

    /* renamed from: a */
    public static C0224a m1625a(ViewGroup viewGroup, a aVar) {
        return new C0224a(viewGroup.getContext(), viewGroup, aVar);
    }

    /* renamed from: a */
    public static C0224a m1624a(ViewGroup viewGroup, float f2, a aVar) {
        C0224a m1625a = m1625a(viewGroup, aVar);
        m1625a.f1802b = (int) (m1625a.f1802b * (1.0f / f2));
        return m1625a;
    }

    private C0224a(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1822v = viewGroup;
        this.f1819s = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1816p = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1815o = this.f1816p;
        this.f1802b = viewConfiguration.getScaledTouchSlop();
        this.f1813m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1814n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1818r = new OverScroller(context, f1800w);
    }

    /* renamed from: a */
    public void m1643a(float f2) {
        this.f1814n = f2;
    }

    /* renamed from: a */
    public int m1642a() {
        return this.f1801a;
    }

    /* renamed from: a */
    public void m1644a(int i) {
        this.f1817q = i;
    }

    /* renamed from: b */
    public int m1650b() {
        return this.f1815o;
    }

    /* renamed from: b */
    public void m1651b(int i) {
        this.f1815o = i;
    }

    /* renamed from: c */
    public int m1656c() {
        return this.f1816p;
    }

    /* renamed from: a */
    public void m1645a(View view, int i) {
        if (view.getParent() != this.f1822v) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1822v + ")");
        }
        this.f1820t = view;
        this.f1803c = i;
        this.f1819s.mo1670a(view, i);
        m1661d(1);
    }

    /* renamed from: d */
    public View m1659d() {
        return this.f1820t;
    }

    /* renamed from: e */
    public int m1662e() {
        return this.f1802b;
    }

    /* renamed from: f */
    public void m1664f() {
        this.f1803c = -1;
        m1638g();
        if (this.f1812l != null) {
            this.f1812l.recycle();
            this.f1812l = null;
        }
    }

    /* renamed from: a */
    public boolean m1648a(View view, int i, int i2) {
        this.f1820t = view;
        this.f1803c = -1;
        boolean m1629a = m1629a(i, i2, 0, 0);
        if (!m1629a && this.f1801a == 0 && this.f1820t != null) {
            this.f1820t = null;
        }
        return m1629a;
    }

    /* renamed from: a */
    public boolean m1646a(int i, int i2) {
        if (!this.f1821u) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return m1629a(i, i2, (int) this.f1812l.getXVelocity(this.f1803c), (int) this.f1812l.getYVelocity(this.f1803c));
    }

    /* renamed from: a */
    private boolean m1629a(int i, int i2, int i3, int i4) {
        int left = this.f1820t.getLeft();
        int top = this.f1820t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1818r.abortAnimation();
            m1661d(0);
            return false;
        }
        this.f1818r.startScroll(left, top, i5, i6, m1623a(this.f1820t, i5, i6, i3, i4));
        m1661d(2);
        return true;
    }

    /* renamed from: a */
    private int m1623a(View view, int i, int i2, int i3, int i4) {
        int m1632b = m1632b(i3, (int) this.f1814n, (int) this.f1813m);
        int m1632b2 = m1632b(i4, (int) this.f1814n, (int) this.f1813m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(m1632b);
        int abs4 = Math.abs(m1632b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((m1632b2 != 0 ? abs4 / i5 : abs2 / i6) * m1622a(i2, m1632b2, this.f1819s.m1672b(view))) + ((m1632b != 0 ? abs3 / i5 : abs / i6) * m1622a(i, m1632b, this.f1819s.mo1665a(view))));
    }

    /* renamed from: a */
    private int m1622a(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.f1822v.getWidth();
        int i4 = width / 2;
        float m1631b = (m1631b(Math.min(1.0f, Math.abs(i) / width)) * i4) + i4;
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(m1631b / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    /* renamed from: b */
    private int m1632b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    /* renamed from: a */
    private float m1621a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 <= 0.0f ? -f4 : f4 : f2;
    }

    /* renamed from: b */
    private float m1631b(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    /* renamed from: a */
    public boolean m1649a(boolean z) {
        boolean z2;
        if (this.f1801a == 2) {
            boolean computeScrollOffset = this.f1818r.computeScrollOffset();
            int currX = this.f1818r.getCurrX();
            int currY = this.f1818r.getCurrY();
            int left = currX - this.f1820t.getLeft();
            int top = currY - this.f1820t.getTop();
            if (left != 0) {
                C0308x.m2253d(this.f1820t, left);
            }
            if (top != 0) {
                C0308x.m2250c(this.f1820t, top);
            }
            if (left != 0 || top != 0) {
                this.f1819s.mo1671a(this.f1820t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f1818r.getFinalX() && currY == this.f1818r.getFinalY()) {
                this.f1818r.abortAnimation();
                z2 = false;
            } else {
                z2 = computeScrollOffset;
            }
            if (!z2) {
                if (z) {
                    this.f1822v.post(this.f1823x);
                } else {
                    m1661d(0);
                }
            }
        }
        return this.f1801a == 2;
    }

    /* renamed from: a */
    private void m1626a(float f2, float f3) {
        this.f1821u = true;
        this.f1819s.mo1669a(this.f1820t, f2, f3);
        this.f1821u = false;
        if (this.f1801a == 1) {
            m1661d(0);
        }
    }

    /* renamed from: g */
    private void m1638g() {
        if (this.f1804d != null) {
            Arrays.fill(this.f1804d, 0.0f);
            Arrays.fill(this.f1805e, 0.0f);
            Arrays.fill(this.f1806f, 0.0f);
            Arrays.fill(this.f1807g, 0.0f);
            Arrays.fill(this.f1808h, 0);
            Arrays.fill(this.f1809i, 0);
            Arrays.fill(this.f1810j, 0);
            this.f1811k = 0;
        }
    }

    /* renamed from: f */
    private void m1637f(int i) {
        if (this.f1804d != null && m1657c(i)) {
            this.f1804d[i] = 0.0f;
            this.f1805e[i] = 0.0f;
            this.f1806f[i] = 0.0f;
            this.f1807g[i] = 0.0f;
            this.f1808h[i] = 0;
            this.f1809i[i] = 0;
            this.f1810j[i] = 0;
            this.f1811k &= (1 << i) ^ (-1);
        }
    }

    /* renamed from: g */
    private void m1639g(int i) {
        if (this.f1804d == null || this.f1804d.length <= i) {
            float[] fArr = new float[i + 1];
            float[] fArr2 = new float[i + 1];
            float[] fArr3 = new float[i + 1];
            float[] fArr4 = new float[i + 1];
            int[] iArr = new int[i + 1];
            int[] iArr2 = new int[i + 1];
            int[] iArr3 = new int[i + 1];
            if (this.f1804d != null) {
                System.arraycopy(this.f1804d, 0, fArr, 0, this.f1804d.length);
                System.arraycopy(this.f1805e, 0, fArr2, 0, this.f1805e.length);
                System.arraycopy(this.f1806f, 0, fArr3, 0, this.f1806f.length);
                System.arraycopy(this.f1807g, 0, fArr4, 0, this.f1807g.length);
                System.arraycopy(this.f1808h, 0, iArr, 0, this.f1808h.length);
                System.arraycopy(this.f1809i, 0, iArr2, 0, this.f1809i.length);
                System.arraycopy(this.f1810j, 0, iArr3, 0, this.f1810j.length);
            }
            this.f1804d = fArr;
            this.f1805e = fArr2;
            this.f1806f = fArr3;
            this.f1807g = fArr4;
            this.f1808h = iArr;
            this.f1809i = iArr2;
            this.f1810j = iArr3;
        }
    }

    /* renamed from: a */
    private void m1627a(float f2, float f3, int i) {
        m1639g(i);
        float[] fArr = this.f1804d;
        this.f1806f[i] = f2;
        fArr[i] = f2;
        float[] fArr2 = this.f1805e;
        this.f1807g[i] = f3;
        fArr2[i] = f3;
        this.f1808h[i] = m1636e((int) f2, (int) f3);
        this.f1811k |= 1 << i;
    }

    /* renamed from: c */
    private void m1635c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m1641h(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1806f[pointerId] = x;
                this.f1807g[pointerId] = y;
            }
        }
    }

    /* renamed from: c */
    public boolean m1657c(int i) {
        return (this.f1811k & (1 << i)) != 0;
    }

    /* renamed from: d */
    void m1661d(int i) {
        this.f1822v.removeCallbacks(this.f1823x);
        if (this.f1801a != i) {
            this.f1801a = i;
            this.f1819s.mo1667a(i);
            if (this.f1801a == 0) {
                this.f1820t = null;
            }
        }
    }

    /* renamed from: b */
    boolean m1654b(View view, int i) {
        if (view == this.f1820t && this.f1803c == i) {
            return true;
        }
        if (view != null && this.f1819s.mo1676b(view, i)) {
            this.f1803c = i;
            m1645a(view, i);
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ff, code lost:
    
        if (r8 != r7) goto L56;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m1647a(MotionEvent motionEvent) {
        View m1660d;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m1664f();
        }
        if (this.f1812l == null) {
            this.f1812l = VelocityTracker.obtain();
        }
        this.f1812l.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                m1627a(x, y, pointerId);
                View m1660d2 = m1660d((int) x, (int) y);
                if (m1660d2 == this.f1820t && this.f1801a == 2) {
                    m1654b(m1660d2, pointerId);
                }
                int i = this.f1808h[pointerId];
                if ((this.f1817q & i) != 0) {
                    this.f1819s.mo1668a(i & this.f1817q, pointerId);
                    break;
                }
                break;
            case 1:
            case 3:
                m1664f();
                break;
            case 2:
                if (this.f1804d != null && this.f1805e != null) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i2 = 0; i2 < pointerCount; i2++) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (m1641h(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f2 = x2 - this.f1804d[pointerId2];
                            float f3 = y2 - this.f1805e[pointerId2];
                            View m1660d3 = m1660d((int) x2, (int) y2);
                            boolean z = m1660d3 != null && m1630a(m1660d3, f2, f3);
                            if (z) {
                                int left = m1660d3.getLeft();
                                int mo1666a = this.f1819s.mo1666a(m1660d3, ((int) f2) + left, (int) f2);
                                int top = m1660d3.getTop();
                                int mo1673b = this.f1819s.mo1673b(m1660d3, ((int) f3) + top, (int) f3);
                                int mo1665a = this.f1819s.mo1665a(m1660d3);
                                int m1672b = this.f1819s.m1672b(m1660d3);
                                if (mo1665a != 0) {
                                    if (mo1665a > 0) {
                                    }
                                }
                                if (m1672b != 0) {
                                    if (m1672b > 0 && mo1673b == top) {
                                    }
                                }
                                m1635c(motionEvent);
                                break;
                            }
                            m1633b(f2, f3, pointerId2);
                            if (this.f1801a != 1) {
                                if (z && m1654b(m1660d3, pointerId2)) {
                                }
                            }
                            m1635c(motionEvent);
                        }
                    }
                    m1635c(motionEvent);
                }
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                float y3 = motionEvent.getY(actionIndex);
                m1627a(x3, y3, pointerId3);
                if (this.f1801a == 0) {
                    int i3 = this.f1808h[pointerId3];
                    if ((this.f1817q & i3) != 0) {
                        this.f1819s.mo1668a(i3 & this.f1817q, pointerId3);
                        break;
                    }
                } else if (this.f1801a == 2 && (m1660d = m1660d((int) x3, (int) y3)) == this.f1820t) {
                    m1654b(m1660d, pointerId3);
                    break;
                }
                break;
            case 6:
                m1637f(motionEvent.getPointerId(actionIndex));
                break;
        }
        return this.f1801a == 1;
    }

    /* renamed from: b */
    public void m1652b(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m1664f();
        }
        if (this.f1812l == null) {
            this.f1812l = VelocityTracker.obtain();
        }
        this.f1812l.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View m1660d = m1660d((int) x, (int) y);
                m1627a(x, y, pointerId);
                m1654b(m1660d, pointerId);
                int i3 = this.f1808h[pointerId];
                if ((this.f1817q & i3) != 0) {
                    this.f1819s.mo1668a(i3 & this.f1817q, pointerId);
                    break;
                }
                break;
            case 1:
                if (this.f1801a == 1) {
                    m1640h();
                }
                m1664f();
                break;
            case 2:
                if (this.f1801a == 1) {
                    if (m1641h(this.f1803c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f1803c);
                        float x2 = motionEvent.getX(findPointerIndex);
                        float y2 = motionEvent.getY(findPointerIndex);
                        int i4 = (int) (x2 - this.f1806f[this.f1803c]);
                        int i5 = (int) (y2 - this.f1807g[this.f1803c]);
                        m1634b(this.f1820t.getLeft() + i4, this.f1820t.getTop() + i5, i4, i5);
                        m1635c(motionEvent);
                        break;
                    }
                } else {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (m1641h(pointerId2)) {
                            float x3 = motionEvent.getX(i2);
                            float y3 = motionEvent.getY(i2);
                            float f2 = x3 - this.f1804d[pointerId2];
                            float f3 = y3 - this.f1805e[pointerId2];
                            m1633b(f2, f3, pointerId2);
                            if (this.f1801a != 1) {
                                View m1660d2 = m1660d((int) x3, (int) y3);
                                if (m1630a(m1660d2, f2, f3) && m1654b(m1660d2, pointerId2)) {
                                }
                            }
                            m1635c(motionEvent);
                            break;
                        }
                        i2++;
                    }
                    m1635c(motionEvent);
                }
                break;
            case 3:
                if (this.f1801a == 1) {
                    m1626a(0.0f, 0.0f);
                }
                m1664f();
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                m1627a(x4, y4, pointerId3);
                if (this.f1801a == 0) {
                    m1654b(m1660d((int) x4, (int) y4), pointerId3);
                    int i6 = this.f1808h[pointerId3];
                    if ((this.f1817q & i6) != 0) {
                        this.f1819s.mo1668a(i6 & this.f1817q, pointerId3);
                        break;
                    }
                } else if (m1658c((int) x4, (int) y4)) {
                    m1654b(this.f1820t, pointerId3);
                    break;
                }
                break;
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f1801a == 1 && pointerId4 == this.f1803c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount2) {
                            i = -1;
                        } else {
                            int pointerId5 = motionEvent.getPointerId(i2);
                            if (pointerId5 != this.f1803c) {
                                if (m1660d((int) motionEvent.getX(i2), (int) motionEvent.getY(i2)) == this.f1820t && m1654b(this.f1820t, pointerId5)) {
                                    i = this.f1803c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        m1640h();
                    }
                }
                m1637f(pointerId4);
                break;
        }
    }

    /* renamed from: b */
    private void m1633b(float f2, float f3, int i) {
        int i2 = m1628a(f2, f3, i, 1) ? 1 : 0;
        if (m1628a(f3, f2, i, 4)) {
            i2 |= 4;
        }
        if (m1628a(f2, f3, i, 2)) {
            i2 |= 2;
        }
        if (m1628a(f3, f2, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1809i;
            iArr[i] = iArr[i] | i2;
            this.f1819s.mo1674b(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m1628a(float f2, float f3, int i, int i2) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f1808h[i] & i2) != i2 || (this.f1817q & i2) == 0 || (this.f1810j[i] & i2) == i2 || (this.f1809i[i] & i2) == i2) {
            return false;
        }
        if (abs <= this.f1802b && abs2 <= this.f1802b) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f1819s.mo1675b(i2)) {
            return (this.f1809i[i] & i2) == 0 && abs > ((float) this.f1802b);
        }
        int[] iArr = this.f1810j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: a */
    private boolean m1630a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1819s.mo1665a(view) > 0;
        boolean z2 = this.f1819s.m1672b(view) > 0;
        return (z && z2) ? (f2 * f2) + (f3 * f3) > ((float) (this.f1802b * this.f1802b)) : z ? Math.abs(f2) > ((float) this.f1802b) : z2 && Math.abs(f3) > ((float) this.f1802b);
    }

    /* renamed from: e */
    public boolean m1663e(int i) {
        int length = this.f1804d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m1653b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m1653b(int i, int i2) {
        if (!m1657c(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f2 = this.f1806f[i2] - this.f1804d[i2];
        float f3 = this.f1807g[i2] - this.f1805e[i2];
        return (z && z2) ? (f2 * f2) + (f3 * f3) > ((float) (this.f1802b * this.f1802b)) : z ? Math.abs(f2) > ((float) this.f1802b) : z2 && Math.abs(f3) > ((float) this.f1802b);
    }

    /* renamed from: h */
    private void m1640h() {
        this.f1812l.computeCurrentVelocity(1000, this.f1813m);
        m1626a(m1621a(this.f1812l.getXVelocity(this.f1803c), this.f1814n, this.f1813m), m1621a(this.f1812l.getYVelocity(this.f1803c), this.f1814n, this.f1813m));
    }

    /* renamed from: b */
    private void m1634b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int left = this.f1820t.getLeft();
        int top = this.f1820t.getTop();
        if (i3 != 0) {
            i5 = this.f1819s.mo1666a(this.f1820t, i, i3);
            C0308x.m2253d(this.f1820t, i5 - left);
        } else {
            i5 = i;
        }
        if (i4 != 0) {
            i6 = this.f1819s.mo1673b(this.f1820t, i2, i4);
            C0308x.m2250c(this.f1820t, i6 - top);
        } else {
            i6 = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f1819s.mo1671a(this.f1820t, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: c */
    public boolean m1658c(int i, int i2) {
        return m1655b(this.f1820t, i, i2);
    }

    /* renamed from: b */
    public boolean m1655b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* renamed from: d */
    public View m1660d(int i, int i2) {
        for (int childCount = this.f1822v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f1822v.getChildAt(this.f1819s.m1677c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: e */
    private int m1636e(int i, int i2) {
        int i3 = i < this.f1822v.getLeft() + this.f1815o ? 1 : 0;
        if (i2 < this.f1822v.getTop() + this.f1815o) {
            i3 |= 4;
        }
        if (i > this.f1822v.getRight() - this.f1815o) {
            i3 |= 2;
        }
        return i2 > this.f1822v.getBottom() - this.f1815o ? i3 | 8 : i3;
    }

    /* renamed from: h */
    private boolean m1641h(int i) {
        if (m1657c(i)) {
            return true;
        }
        Log.m184e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
