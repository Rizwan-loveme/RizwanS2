package org.p210a.p211a.p212a.p215c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.p210a.p211a.p212a.InterfaceC1823ag;

/* compiled from: IntervalSet.java */
/* renamed from: org.a.a.a.c.j */
/* loaded from: classes.dex */
public class C1840j implements InterfaceC1836f {

    /* renamed from: a */
    public static final C1840j f10907a = m13753a(0, 1114111);

    /* renamed from: b */
    public static final C1840j f10908b;

    /* renamed from: c */
    protected List<C1839i> f10909c;

    /* renamed from: d */
    protected boolean f10910d;

    static {
        f10907a.m13763b(true);
        f10908b = new C1840j(new int[0]);
        f10908b.m13763b(true);
    }

    public C1840j(C1840j c1840j) {
        this(new int[0]);
        m13758a(c1840j);
    }

    public C1840j(int... iArr) {
        if (iArr == null) {
            this.f10909c = new ArrayList(2);
            return;
        }
        this.f10909c = new ArrayList(iArr.length);
        for (int i : iArr) {
            m13761b(i);
        }
    }

    /* renamed from: a */
    public static C1840j m13752a(int i) {
        C1840j c1840j = new C1840j(new int[0]);
        c1840j.m13761b(i);
        return c1840j;
    }

    /* renamed from: a */
    public static C1840j m13753a(int i, int i2) {
        C1840j c1840j = new C1840j(new int[0]);
        c1840j.m13762b(i, i2);
        return c1840j;
    }

    /* renamed from: b */
    public void m13761b(int i) {
        if (this.f10910d) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        m13762b(i, i);
    }

    /* renamed from: b */
    public void m13762b(int i, int i2) {
        m13759a(C1839i.m13746a(i, i2));
    }

    /* renamed from: a */
    protected void m13759a(C1839i c1839i) {
        if (this.f10910d) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        if (c1839i.f10906d >= c1839i.f10905c) {
            ListIterator<C1839i> listIterator = this.f10909c.listIterator();
            while (listIterator.hasNext()) {
                C1839i next = listIterator.next();
                if (!c1839i.equals(next)) {
                    if (c1839i.m13750d(next) || !c1839i.m13749c(next)) {
                        C1839i m13751e = c1839i.m13751e(next);
                        listIterator.set(m13751e);
                        while (listIterator.hasNext()) {
                            C1839i next2 = listIterator.next();
                            if (m13751e.m13750d(next2) || !m13751e.m13749c(next2)) {
                                listIterator.remove();
                                listIterator.previous();
                                listIterator.set(m13751e.m13751e(next2));
                                listIterator.next();
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    if (c1839i.m13747a(next)) {
                        listIterator.previous();
                        listIterator.add(c1839i);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f10909c.add(c1839i);
        }
    }

    /* renamed from: a */
    public C1840j m13758a(InterfaceC1836f interfaceC1836f) {
        if (interfaceC1836f != null) {
            if (interfaceC1836f instanceof C1840j) {
                C1840j c1840j = (C1840j) interfaceC1836f;
                int size = c1840j.f10909c.size();
                for (int i = 0; i < size; i++) {
                    C1839i c1839i = c1840j.f10909c.get(i);
                    m13762b(c1839i.f10905c, c1839i.f10906d);
                }
            } else {
                Iterator<Integer> it = interfaceC1836f.mo13734b().iterator();
                while (it.hasNext()) {
                    m13761b(it.next().intValue());
                }
            }
        }
        return this;
    }

    /* renamed from: b */
    public C1840j m13760b(InterfaceC1836f interfaceC1836f) {
        C1840j c1840j;
        if (interfaceC1836f == null || interfaceC1836f.mo13733a()) {
            return null;
        }
        if (interfaceC1836f instanceof C1840j) {
            c1840j = (C1840j) interfaceC1836f;
        } else {
            C1840j c1840j2 = new C1840j(new int[0]);
            c1840j2.m13758a(interfaceC1836f);
            c1840j = c1840j2;
        }
        return c1840j.m13765c(this);
    }

    /* renamed from: c */
    public C1840j m13765c(InterfaceC1836f interfaceC1836f) {
        if (interfaceC1836f == null || interfaceC1836f.mo13733a()) {
            return new C1840j(this);
        }
        if (interfaceC1836f instanceof C1840j) {
            return m13754a(this, (C1840j) interfaceC1836f);
        }
        C1840j c1840j = new C1840j(new int[0]);
        c1840j.m13758a(interfaceC1836f);
        return m13754a(this, c1840j);
    }

    /* renamed from: a */
    public static C1840j m13754a(C1840j c1840j, C1840j c1840j2) {
        if (c1840j == null || c1840j.mo13733a()) {
            return new C1840j(new int[0]);
        }
        C1840j c1840j3 = new C1840j(c1840j);
        if (c1840j2 == null || c1840j2.mo13733a()) {
            return c1840j3;
        }
        int i = 0;
        int i2 = 0;
        while (i2 < c1840j3.f10909c.size() && i < c1840j2.f10909c.size()) {
            C1839i c1839i = c1840j3.f10909c.get(i2);
            C1839i c1839i2 = c1840j2.f10909c.get(i);
            if (c1839i2.f10906d < c1839i.f10905c) {
                i++;
            } else if (c1839i2.f10905c > c1839i.f10906d) {
                i2++;
            } else {
                C1839i c1839i3 = c1839i2.f10905c > c1839i.f10905c ? new C1839i(c1839i.f10905c, c1839i2.f10905c - 1) : null;
                C1839i c1839i4 = c1839i2.f10906d < c1839i.f10906d ? new C1839i(c1839i2.f10906d + 1, c1839i.f10906d) : null;
                if (c1839i3 != null) {
                    if (c1839i4 != null) {
                        c1840j3.f10909c.set(i2, c1839i3);
                        c1840j3.f10909c.add(i2 + 1, c1839i4);
                        i++;
                        i2++;
                    } else {
                        c1840j3.f10909c.set(i2, c1839i3);
                        i2++;
                    }
                } else if (c1839i4 != null) {
                    c1840j3.f10909c.set(i2, c1839i4);
                    i++;
                } else {
                    c1840j3.f10909c.remove(i2);
                }
            }
        }
        return c1840j3;
    }

    /* renamed from: d */
    public C1840j m13768d(InterfaceC1836f interfaceC1836f) {
        C1840j c1840j = new C1840j(new int[0]);
        c1840j.m13758a(this);
        c1840j.m13758a(interfaceC1836f);
        return c1840j;
    }

    /* renamed from: c */
    public boolean m13766c(int i) {
        int size = this.f10909c.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            C1839i c1839i = this.f10909c.get(i3);
            int i4 = c1839i.f10905c;
            if (c1839i.f10906d < i) {
                i2 = i3 + 1;
            } else if (i4 > i) {
                size = i3 - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // org.p210a.p211a.p212a.p215c.InterfaceC1836f
    /* renamed from: a */
    public boolean mo13733a() {
        return this.f10909c == null || this.f10909c.isEmpty();
    }

    /* renamed from: c */
    public int m13764c() {
        if (mo13733a()) {
            throw new RuntimeException("set is empty");
        }
        return this.f10909c.get(0).f10905c;
    }

    public int hashCode() {
        int m13770a = C1841k.m13770a();
        Iterator<C1839i> it = this.f10909c.iterator();
        while (true) {
            int i = m13770a;
            if (it.hasNext()) {
                C1839i next = it.next();
                m13770a = C1841k.m13772a(C1841k.m13772a(i, next.f10905c), next.f10906d);
            } else {
                return C1841k.m13775b(i, this.f10909c.size() * 2);
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C1840j)) {
            return false;
        }
        return this.f10909c.equals(((C1840j) obj).f10909c);
    }

    public String toString() {
        return m13757a(false);
    }

    /* renamed from: a */
    public String m13757a(boolean z) {
        StringBuilder sb = new StringBuilder();
        if (this.f10909c == null || this.f10909c.isEmpty()) {
            return "{}";
        }
        if (m13767d() > 1) {
            sb.append("{");
        }
        Iterator<C1839i> it = this.f10909c.iterator();
        while (it.hasNext()) {
            C1839i next = it.next();
            int i = next.f10905c;
            int i2 = next.f10906d;
            if (i == i2) {
                if (i == -1) {
                    sb.append("<EOF>");
                } else if (z) {
                    sb.append("'").appendCodePoint(i).append("'");
                } else {
                    sb.append(i);
                }
            } else if (z) {
                sb.append("'").appendCodePoint(i).append("'..'").appendCodePoint(i2).append("'");
            } else {
                sb.append(i).append("..").append(i2);
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (m13767d() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String m13755a(InterfaceC1823ag interfaceC1823ag) {
        StringBuilder sb = new StringBuilder();
        if (this.f10909c == null || this.f10909c.isEmpty()) {
            return "{}";
        }
        if (m13767d() > 1) {
            sb.append("{");
        }
        Iterator<C1839i> it = this.f10909c.iterator();
        while (it.hasNext()) {
            C1839i next = it.next();
            int i = next.f10905c;
            int i2 = next.f10906d;
            if (i == i2) {
                sb.append(m13756a(interfaceC1823ag, i));
            } else {
                for (int i3 = i; i3 <= i2; i3++) {
                    if (i3 > i) {
                        sb.append(", ");
                    }
                    sb.append(m13756a(interfaceC1823ag, i3));
                }
            }
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        if (m13767d() > 1) {
            sb.append("}");
        }
        return sb.toString();
    }

    /* renamed from: a */
    protected String m13756a(InterfaceC1823ag interfaceC1823ag, int i) {
        if (i == -1) {
            return "<EOF>";
        }
        if (i == -2) {
            return "<EPSILON>";
        }
        return interfaceC1823ag.mo13693c(i);
    }

    /* renamed from: d */
    public int m13767d() {
        int size = this.f10909c.size();
        if (size == 1) {
            C1839i c1839i = this.f10909c.get(0);
            return (c1839i.f10906d - c1839i.f10905c) + 1;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            C1839i c1839i2 = this.f10909c.get(i2);
            i += (c1839i2.f10906d - c1839i2.f10905c) + 1;
        }
        return i;
    }

    @Override // org.p210a.p211a.p212a.p215c.InterfaceC1836f
    /* renamed from: b */
    public List<Integer> mo13734b() {
        ArrayList arrayList = new ArrayList();
        int size = this.f10909c.size();
        for (int i = 0; i < size; i++) {
            C1839i c1839i = this.f10909c.get(i);
            int i2 = c1839i.f10905c;
            int i3 = c1839i.f10906d;
            for (int i4 = i2; i4 <= i3; i4++) {
                arrayList.add(Integer.valueOf(i4));
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    public void m13769d(int i) {
        if (this.f10910d) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        int size = this.f10909c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1839i c1839i = this.f10909c.get(i2);
            int i3 = c1839i.f10905c;
            int i4 = c1839i.f10906d;
            if (i >= i3) {
                if (i == i3 && i == i4) {
                    this.f10909c.remove(i2);
                    return;
                }
                if (i == i3) {
                    c1839i.f10905c++;
                    return;
                }
                if (i == i4) {
                    c1839i.f10906d--;
                    return;
                }
                if (i > i3 && i < i4) {
                    int i5 = c1839i.f10906d;
                    c1839i.f10906d = i - 1;
                    m13762b(i + 1, i5);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public void m13763b(boolean z) {
        if (this.f10910d && !z) {
            throw new IllegalStateException("can't alter readonly IntervalSet");
        }
        this.f10910d = z;
    }
}
