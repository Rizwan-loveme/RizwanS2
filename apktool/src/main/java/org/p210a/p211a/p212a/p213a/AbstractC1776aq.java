package org.p210a.p211a.p212a.p213a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import org.p210a.p211a.p212a.C1878z;
import org.p210a.p211a.p212a.p215c.C1833c;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: PredictionContext.java */
/* renamed from: org.a.a.a.a.aq */
/* loaded from: classes.dex */
public abstract class AbstractC1776aq {

    /* renamed from: d */
    public static final C1808r f10726d;

    /* renamed from: e */
    public static int f10727e;

    /* renamed from: h */
    static final /* synthetic */ boolean f10728h;

    /* renamed from: f */
    public final int f10729f;

    /* renamed from: g */
    public final int f10730g;

    /* renamed from: a */
    public abstract AbstractC1776aq mo13553a(int i);

    /* renamed from: b */
    public abstract int mo13555b();

    /* renamed from: b */
    public abstract int mo13556b(int i);

    public abstract boolean equals(Object obj);

    static {
        f10728h = !AbstractC1776aq.class.desiredAssertionStatus();
        f10726d = new C1808r();
        f10727e = 0;
    }

    protected AbstractC1776aq(int i) {
        int i2 = f10727e;
        f10727e = i2 + 1;
        this.f10729f = i2;
        this.f10730g = i;
    }

    /* renamed from: a */
    public static AbstractC1776aq m13545a(C1759a c1759a, C1878z c1878z) {
        if (c1878z == null) {
            c1878z = C1878z.f11015i;
        }
        if (c1878z.f11016j == null || c1878z == C1878z.f11015i) {
            return f10726d;
        }
        C1808r c1808r = f10726d;
        return C1785az.m13585b(m13545a(c1759a, c1878z.f11016j), ((C1782aw) c1759a.f10690a.get(c1878z.f11017k).m13631a(0)).f10743c.f10798c);
    }

    /* renamed from: a */
    public boolean mo13554a() {
        return this == f10726d;
    }

    /* renamed from: c */
    public boolean m13557c() {
        return mo13556b(mo13555b() + (-1)) == Integer.MAX_VALUE;
    }

    public final int hashCode() {
        return this.f10730g;
    }

    /* renamed from: d */
    protected static int m13552d() {
        return C1841k.m13775b(C1841k.m13771a(1), 0);
    }

    /* renamed from: a */
    protected static int m13543a(AbstractC1776aq abstractC1776aq, int i) {
        return C1841k.m13775b(C1841k.m13772a(C1841k.m13773a(C1841k.m13771a(1), abstractC1776aq), i), 2);
    }

    /* renamed from: a */
    protected static int m13544a(AbstractC1776aq[] abstractC1776aqArr, int[] iArr) {
        int m13771a = C1841k.m13771a(1);
        for (AbstractC1776aq abstractC1776aq : abstractC1776aqArr) {
            m13771a = C1841k.m13773a(m13771a, abstractC1776aq);
        }
        for (int i : iArr) {
            m13771a = C1841k.m13772a(m13771a, i);
        }
        return C1841k.m13775b(m13771a, abstractC1776aqArr.length * 2);
    }

    /* renamed from: a */
    public static AbstractC1776aq m13546a(AbstractC1776aq abstractC1776aq, AbstractC1776aq abstractC1776aq2, boolean z, C1833c<AbstractC1776aq, AbstractC1776aq, AbstractC1776aq> c1833c) {
        if (!f10728h && (abstractC1776aq == null || abstractC1776aq2 == null)) {
            throw new AssertionError();
        }
        if (abstractC1776aq != abstractC1776aq2 && !abstractC1776aq.equals(abstractC1776aq2)) {
            if ((abstractC1776aq instanceof C1785az) && (abstractC1776aq2 instanceof C1785az)) {
                return m13549a((C1785az) abstractC1776aq, (C1785az) abstractC1776aq2, z, c1833c);
            }
            if (z) {
                if (!(abstractC1776aq instanceof C1808r)) {
                    if (abstractC1776aq2 instanceof C1808r) {
                        return abstractC1776aq2;
                    }
                } else {
                    return abstractC1776aq;
                }
            }
            return m13550a((C1801k) (abstractC1776aq instanceof C1785az ? new C1801k((C1785az) abstractC1776aq) : abstractC1776aq), (C1801k) (abstractC1776aq2 instanceof C1785az ? new C1801k((C1785az) abstractC1776aq2) : abstractC1776aq2), z, c1833c);
        }
        return abstractC1776aq;
    }

    /* renamed from: a */
    public static AbstractC1776aq m13549a(C1785az c1785az, C1785az c1785az2, boolean z, C1833c<AbstractC1776aq, AbstractC1776aq, AbstractC1776aq> c1833c) {
        if (c1833c != null) {
            AbstractC1776aq m13728a = c1833c.m13728a(c1785az, c1785az2);
            if (m13728a == null) {
                AbstractC1776aq m13728a2 = c1833c.m13728a(c1785az2, c1785az);
                if (m13728a2 != null) {
                    return m13728a2;
                }
            } else {
                return m13728a;
            }
        }
        AbstractC1776aq m13548a = m13548a(c1785az, c1785az2, z);
        if (m13548a != null) {
            if (c1833c != null) {
                c1833c.m13729a(c1785az, c1785az2, m13548a);
                return m13548a;
            }
            return m13548a;
        }
        if (c1785az.f10754b == c1785az2.f10754b) {
            AbstractC1776aq m13546a = m13546a(c1785az.f10753a, c1785az2.f10753a, z, c1833c);
            if (m13546a == c1785az.f10753a) {
                return c1785az;
            }
            if (m13546a == c1785az2.f10753a) {
                return c1785az2;
            }
            C1785az m13585b = C1785az.m13585b(m13546a, c1785az.f10754b);
            if (c1833c != null) {
                c1833c.m13729a(c1785az, c1785az2, m13585b);
                return m13585b;
            }
            return m13585b;
        }
        AbstractC1776aq abstractC1776aq = null;
        if (c1785az == c1785az2 || (c1785az.f10753a != null && c1785az.f10753a.equals(c1785az2.f10753a))) {
            abstractC1776aq = c1785az.f10753a;
        }
        if (abstractC1776aq != null) {
            int[] iArr = {c1785az.f10754b, c1785az2.f10754b};
            if (c1785az.f10754b > c1785az2.f10754b) {
                iArr[0] = c1785az2.f10754b;
                iArr[1] = c1785az.f10754b;
            }
            C1801k c1801k = new C1801k(new AbstractC1776aq[]{abstractC1776aq, abstractC1776aq}, iArr);
            if (c1833c != null) {
                c1833c.m13729a(c1785az, c1785az2, c1801k);
                return c1801k;
            }
            return c1801k;
        }
        int[] iArr2 = {c1785az.f10754b, c1785az2.f10754b};
        AbstractC1776aq[] abstractC1776aqArr = {c1785az.f10753a, c1785az2.f10753a};
        if (c1785az.f10754b > c1785az2.f10754b) {
            iArr2[0] = c1785az2.f10754b;
            iArr2[1] = c1785az.f10754b;
            abstractC1776aqArr = new AbstractC1776aq[]{c1785az2.f10753a, c1785az.f10753a};
        }
        C1801k c1801k2 = new C1801k(abstractC1776aqArr, iArr2);
        if (c1833c != null) {
            c1833c.m13729a(c1785az, c1785az2, c1801k2);
        }
        return c1801k2;
    }

    /* renamed from: a */
    public static AbstractC1776aq m13548a(C1785az c1785az, C1785az c1785az2, boolean z) {
        if (z) {
            if (c1785az == f10726d || c1785az2 == f10726d) {
                return f10726d;
            }
        } else {
            if (c1785az == f10726d && c1785az2 == f10726d) {
                return f10726d;
            }
            if (c1785az == f10726d) {
                int[] iArr = {c1785az2.f10754b, Integer.MAX_VALUE};
                AbstractC1776aq[] abstractC1776aqArr = new AbstractC1776aq[2];
                abstractC1776aqArr[0] = c1785az2.f10753a;
                return new C1801k(abstractC1776aqArr, iArr);
            }
            if (c1785az2 == f10726d) {
                int[] iArr2 = {c1785az.f10754b, Integer.MAX_VALUE};
                AbstractC1776aq[] abstractC1776aqArr2 = new AbstractC1776aq[2];
                abstractC1776aqArr2[0] = c1785az.f10753a;
                return new C1801k(abstractC1776aqArr2, iArr2);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static AbstractC1776aq m13550a(C1801k c1801k, C1801k c1801k2, boolean z, C1833c<AbstractC1776aq, AbstractC1776aq, AbstractC1776aq> c1833c) {
        int i;
        AbstractC1776aq[] abstractC1776aqArr;
        int[] iArr;
        if (c1833c != null) {
            AbstractC1776aq m13728a = c1833c.m13728a(c1801k, c1801k2);
            if (m13728a == null) {
                AbstractC1776aq m13728a2 = c1833c.m13728a(c1801k2, c1801k);
                if (m13728a2 != null) {
                    return m13728a2;
                }
            } else {
                return m13728a;
            }
        }
        int[] iArr2 = new int[c1801k.f10811b.length + c1801k2.f10811b.length];
        AbstractC1776aq[] abstractC1776aqArr2 = new AbstractC1776aq[c1801k.f10811b.length + c1801k2.f10811b.length];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < c1801k.f10811b.length && i3 < c1801k2.f10811b.length) {
            AbstractC1776aq abstractC1776aq = c1801k.f10810a[i4];
            AbstractC1776aq abstractC1776aq2 = c1801k2.f10810a[i3];
            if (c1801k.f10811b[i4] == c1801k2.f10811b[i3]) {
                int i5 = c1801k.f10811b[i4];
                boolean z2 = i5 == Integer.MAX_VALUE && abstractC1776aq == null && abstractC1776aq2 == null;
                boolean z3 = (abstractC1776aq == null || abstractC1776aq2 == null || !abstractC1776aq.equals(abstractC1776aq2)) ? false : true;
                if (z2 || z3) {
                    abstractC1776aqArr2[i2] = abstractC1776aq;
                    iArr2[i2] = i5;
                } else {
                    abstractC1776aqArr2[i2] = m13546a(abstractC1776aq, abstractC1776aq2, z, c1833c);
                    iArr2[i2] = i5;
                }
                i4++;
                i3++;
            } else if (c1801k.f10811b[i4] < c1801k2.f10811b[i3]) {
                abstractC1776aqArr2[i2] = abstractC1776aq;
                iArr2[i2] = c1801k.f10811b[i4];
                i4++;
            } else {
                abstractC1776aqArr2[i2] = abstractC1776aq2;
                iArr2[i2] = c1801k2.f10811b[i3];
                i3++;
            }
            i2++;
        }
        if (i4 < c1801k.f10811b.length) {
            while (i4 < c1801k.f10811b.length) {
                abstractC1776aqArr2[i2] = c1801k.f10810a[i4];
                iArr2[i2] = c1801k.f10811b[i4];
                i2++;
                i4++;
            }
            i = i2;
        } else {
            while (i3 < c1801k2.f10811b.length) {
                abstractC1776aqArr2[i2] = c1801k2.f10810a[i3];
                iArr2[i2] = c1801k2.f10811b[i3];
                i2++;
                i3++;
            }
            i = i2;
        }
        if (i >= abstractC1776aqArr2.length) {
            abstractC1776aqArr = abstractC1776aqArr2;
            iArr = iArr2;
        } else {
            if (i == 1) {
                C1785az m13585b = C1785az.m13585b(abstractC1776aqArr2[0], iArr2[0]);
                if (c1833c != null) {
                    c1833c.m13729a(c1801k, c1801k2, m13585b);
                    return m13585b;
                }
                return m13585b;
            }
            abstractC1776aqArr = (AbstractC1776aq[]) Arrays.copyOf(abstractC1776aqArr2, i);
            iArr = Arrays.copyOf(iArr2, i);
        }
        C1801k c1801k3 = new C1801k(abstractC1776aqArr, iArr);
        if (c1801k3.equals(c1801k)) {
            if (c1833c != null) {
                c1833c.m13729a(c1801k, c1801k2, c1801k);
            }
            return c1801k;
        }
        if (c1801k3.equals(c1801k2)) {
            if (c1833c != null) {
                c1833c.m13729a(c1801k, c1801k2, c1801k2);
            }
            return c1801k2;
        }
        m13551a(abstractC1776aqArr);
        if (c1833c != null) {
            c1833c.m13729a(c1801k, c1801k2, c1801k3);
        }
        return c1801k3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    protected static void m13551a(AbstractC1776aq[] abstractC1776aqArr) {
        HashMap hashMap = new HashMap();
        for (AbstractC1776aq abstractC1776aq : abstractC1776aqArr) {
            if (!hashMap.containsKey(abstractC1776aq)) {
                hashMap.put(abstractC1776aq, abstractC1776aq);
            }
        }
        for (int i = 0; i < abstractC1776aqArr.length; i++) {
            abstractC1776aqArr[i] = (AbstractC1776aq) hashMap.get(abstractC1776aqArr[i]);
        }
    }

    /* renamed from: a */
    public static AbstractC1776aq m13547a(AbstractC1776aq abstractC1776aq, C1777ar c1777ar, IdentityHashMap<AbstractC1776aq, AbstractC1776aq> identityHashMap) {
        AbstractC1776aq c1801k;
        boolean z;
        if (!abstractC1776aq.mo13554a()) {
            AbstractC1776aq abstractC1776aq2 = identityHashMap.get(abstractC1776aq);
            if (abstractC1776aq2 != null) {
                return abstractC1776aq2;
            }
            AbstractC1776aq m13559b = c1777ar.m13559b(abstractC1776aq);
            if (m13559b != null) {
                identityHashMap.put(abstractC1776aq, m13559b);
                return m13559b;
            }
            AbstractC1776aq[] abstractC1776aqArr = new AbstractC1776aq[abstractC1776aq.mo13555b()];
            boolean z2 = false;
            for (int i = 0; i < abstractC1776aqArr.length; i++) {
                AbstractC1776aq m13547a = m13547a(abstractC1776aq.mo13553a(i), c1777ar, identityHashMap);
                if (z2 || m13547a != abstractC1776aq.mo13553a(i)) {
                    if (z2) {
                        z = z2;
                    } else {
                        AbstractC1776aq[] abstractC1776aqArr2 = new AbstractC1776aq[abstractC1776aq.mo13555b()];
                        for (int i2 = 0; i2 < abstractC1776aq.mo13555b(); i2++) {
                            abstractC1776aqArr2[i2] = abstractC1776aq.mo13553a(i2);
                        }
                        abstractC1776aqArr = abstractC1776aqArr2;
                        z = true;
                    }
                    abstractC1776aqArr[i] = m13547a;
                    z2 = z;
                }
            }
            if (!z2) {
                c1777ar.m13558a(abstractC1776aq);
                identityHashMap.put(abstractC1776aq, abstractC1776aq);
                return abstractC1776aq;
            }
            if (abstractC1776aqArr.length == 0) {
                c1801k = f10726d;
            } else if (abstractC1776aqArr.length == 1) {
                c1801k = C1785az.m13585b(abstractC1776aqArr[0], abstractC1776aq.mo13556b(0));
            } else {
                c1801k = new C1801k(abstractC1776aqArr, ((C1801k) abstractC1776aq).f10811b);
            }
            c1777ar.m13558a(c1801k);
            identityHashMap.put(c1801k, c1801k);
            identityHashMap.put(abstractC1776aq, c1801k);
            return c1801k;
        }
        return abstractC1776aq;
    }
}
