package org.p226d.p233b.p234a;

import com.p129f.p130a.p131a.C1116k;
import com.p129f.p130a.p133c.C1156ai;
import com.p129f.p130a.p133c.C1157aj;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2215c;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2223k;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p252b.InterfaceC2226n;
import org.p226d.p233b.p250e.p252b.InterfaceC2230r;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2202o;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p226d.p269d.C2453g;

/* compiled from: AnalyzedInstruction.java */
/* renamed from: org.d.b.a.b */
/* loaded from: classes.dex */
public class C1966b implements Comparable<C1966b> {

    /* renamed from: j */
    static final /* synthetic */ boolean f11437j;

    /* renamed from: a */
    protected final C1976k f11438a;

    /* renamed from: b */
    protected InterfaceC2218f f11439b;

    /* renamed from: c */
    protected final int f11440c;

    /* renamed from: f */
    protected final C1980o[] f11443f;

    /* renamed from: g */
    protected final C1980o[] f11444g;

    /* renamed from: i */
    protected final InterfaceC2218f f11446i;

    /* renamed from: d */
    protected final TreeSet<C1966b> f11441d = new TreeSet<>();

    /* renamed from: e */
    protected final LinkedList<C1966b> f11442e = new LinkedList<>();

    /* renamed from: h */
    protected Map<a, C1980o> f11445h = null;

    static {
        f11437j = !C1966b.class.desiredAssertionStatus();
    }

    public C1966b(C1976k c1976k, InterfaceC2218f interfaceC2218f, int i, int i2) {
        this.f11438a = c1976k;
        this.f11439b = interfaceC2218f;
        this.f11446i = interfaceC2218f;
        this.f11440c = i;
        this.f11444g = new C1980o[i2];
        this.f11443f = new C1980o[i2];
        C1980o m14410a = C1980o.m14410a((byte) 0, (InterfaceC1981p) null);
        for (int i3 = 0; i3 < i2; i3++) {
            this.f11443f[i3] = m14410a;
            this.f11444g[i3] = m14410a;
        }
    }

    /* renamed from: a */
    public int m14231a() {
        return this.f11440c;
    }

    /* renamed from: b */
    public int m14239b() {
        return this.f11441d.size();
    }

    /* renamed from: c */
    public SortedSet<C1966b> m14243c() {
        return Collections.unmodifiableSortedSet(this.f11441d);
    }

    /* renamed from: a */
    public C1980o mo14233a(C1966b c1966b, int i) {
        C1980o c1980o;
        return (this.f11445h == null || (c1980o = this.f11445h.get(new a(c1966b, i))) == null) ? c1966b.f11444g[i] : c1980o;
    }

    /* renamed from: a */
    protected boolean mo14237a(C1966b c1966b) {
        return this.f11441d.add(c1966b);
    }

    /* renamed from: b */
    protected void m14240b(C1966b c1966b) {
        this.f11442e.add(c1966b);
    }

    /* renamed from: a */
    protected void m14234a(InterfaceC2218f interfaceC2218f) {
        if (!f11437j && !this.f11446i.mo14416a().m14878b()) {
            throw new AssertionError();
        }
        this.f11439b = interfaceC2218f;
    }

    /* renamed from: d */
    protected void m14246d() {
        if (!f11437j && !this.f11446i.mo14416a().m14878b()) {
            throw new AssertionError();
        }
        this.f11439b = this.f11446i;
    }

    /* renamed from: e */
    public InterfaceC2218f m14247e() {
        return this.f11439b;
    }

    /* renamed from: f */
    public InterfaceC2218f m14248f() {
        return this.f11446i;
    }

    /* renamed from: g */
    public boolean m14249g() {
        if (this.f11441d.size() == 0) {
            return false;
        }
        return this.f11441d.first().f11440c == -1;
    }

    /* renamed from: a */
    protected boolean m14236a(int i, C1980o c1980o, BitSet bitSet, boolean z) {
        C1980o m14414a;
        if (!f11437j && (i < 0 || i >= this.f11444g.length)) {
            throw new AssertionError();
        }
        if (!f11437j && c1980o == null) {
            throw new AssertionError();
        }
        C1980o c1980o2 = this.f11443f[i];
        if (z) {
            m14414a = m14232a(i);
        } else {
            m14414a = c1980o2.m14414a(c1980o);
        }
        if (m14414a.equals(c1980o2)) {
            return false;
        }
        this.f11443f[i] = m14414a;
        bitSet.clear(this.f11440c);
        if (m14241b(i)) {
            return false;
        }
        this.f11444g[i] = m14414a;
        return true;
    }

    /* renamed from: a */
    protected C1980o m14232a(int i) {
        C1980o c1980o = null;
        Iterator<C1966b> it = this.f11441d.iterator();
        while (it.hasNext()) {
            C1980o mo14233a = mo14233a(it.next(), i);
            if (mo14233a == null) {
                mo14233a = c1980o;
            } else if (c1980o != null) {
                mo14233a = mo14233a.m14414a(c1980o);
            }
            c1980o = mo14233a;
        }
        if (c1980o == null) {
            throw new IllegalStateException();
        }
        return c1980o;
    }

    /* renamed from: a */
    protected boolean m14235a(int i, C1980o c1980o) {
        if (!f11437j && (i < 0 || i >= this.f11444g.length)) {
            throw new AssertionError();
        }
        if (!f11437j && c1980o == null) {
            throw new AssertionError();
        }
        if (this.f11444g[i].equals(c1980o)) {
            return false;
        }
        this.f11444g[i] = c1980o;
        return true;
    }

    /* renamed from: a */
    protected boolean m14238a(C1966b c1966b, int i, C1980o c1980o, BitSet bitSet) {
        if (this.f11445h == null) {
            this.f11445h = C1157aj.m9935c();
        }
        this.f11445h.put(new a(c1966b, i), c1980o);
        C1980o m14232a = m14232a(i);
        if (this.f11443f[i].equals(m14232a)) {
            return false;
        }
        this.f11443f[i] = m14232a;
        bitSet.clear(this.f11440c);
        if (m14241b(i) || this.f11444g[i].equals(m14232a)) {
            return false;
        }
        this.f11444g[i] = m14232a;
        return true;
    }

    /* renamed from: h */
    public boolean m14250h() {
        if (!this.f11439b.mo14416a().m14885i()) {
            return false;
        }
        InterfaceC2241f mo14489f = ((InterfaceC2225m) this.f11439b).mo14489f();
        if (mo14489f instanceof InterfaceC2240e) {
            return ((InterfaceC2240e) mo14489f).mo14210b().equals("<init>");
        }
        return false;
    }

    /* renamed from: b */
    public boolean m14241b(int i) {
        int i2;
        int mo14491h;
        if (m14250h()) {
            if (this.f11439b instanceof InterfaceC2215c) {
                if (!f11437j && ((InterfaceC2215c) this.f11439b).mo14481e() <= 0) {
                    throw new AssertionError();
                }
                mo14491h = ((InterfaceC2215c) this.f11439b).mo14483h();
            } else {
                if (!f11437j && !(this.f11439b instanceof InterfaceC2226n)) {
                    throw new AssertionError();
                }
                InterfaceC2226n interfaceC2226n = (InterfaceC2226n) this.f11439b;
                if (!f11437j && interfaceC2226n.mo14481e() <= 0) {
                    throw new AssertionError();
                }
                mo14491h = interfaceC2226n.mo14491h();
            }
            C1980o m14245d = m14245d(mo14491h);
            if (m14245d.f11561a == 0) {
                C1980o m14245d2 = m14245d(i);
                if (m14245d2.f11561a == 16 || m14245d2.f11561a == 17) {
                    return true;
                }
            }
            if (m14245d.f11561a != 16 && m14245d.f11561a != 17) {
                return false;
            }
            if (i == mo14491h) {
                return true;
            }
            return m14245d.equals(m14245d(i));
        }
        if (this.f11440c > 0 && this.f11438a.m14395a().m14275a() && m14239b() == 1 && (this.f11439b.mo14416a() == EnumC2272f.IF_EQZ || this.f11439b.mo14416a() == EnumC2272f.IF_NEZ)) {
            C1966b first = this.f11441d.first();
            if (first.f11439b.mo14416a() == EnumC2272f.INSTANCE_OF && C1976k.m14353a(first, this, this.f11438a.m14395a())) {
                InterfaceC2202o interfaceC2202o = (InterfaceC2202o) first.f11439b;
                if (i == interfaceC2202o.mo14500r_()) {
                    return true;
                }
                if (this.f11440c > 1) {
                    C1980o c1980o = null;
                    Iterator<C1966b> it = first.f11441d.iterator();
                    int i3 = -1;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C1966b next = it.next();
                        EnumC2272f mo14416a = next.f11439b.mo14416a();
                        if (mo14416a != EnumC2272f.MOVE_OBJECT && mo14416a != EnumC2272f.MOVE_OBJECT_16 && mo14416a != EnumC2272f.MOVE_OBJECT_FROM16) {
                            i3 = -1;
                            break;
                        }
                        InterfaceC2230r interfaceC2230r = (InterfaceC2230r) next.f11439b;
                        C1980o m14244c = next.m14244c(interfaceC2230r.mo14500r_());
                        if (interfaceC2230r.mo14495q_() != interfaceC2202o.mo14500r_()) {
                            i3 = -1;
                            break;
                        }
                        if (m14244c.f11562b == null) {
                            i3 = -1;
                            break;
                        }
                        C1980o m14413a = c1980o == null ? C1980o.m14413a(this.f11438a.m14395a(), (InterfaceC2243h) interfaceC2202o.mo14489f()) : c1980o;
                        if (C1976k.m14355a(m14244c, m14413a)) {
                            if (i3 != -1) {
                                if (i3 != interfaceC2230r.mo14500r_()) {
                                    i3 = -1;
                                    break;
                                }
                            } else {
                                i2 = interfaceC2230r.mo14500r_();
                                c1980o = m14413a;
                                i3 = i2;
                            }
                        }
                        i2 = i3;
                        c1980o = m14413a;
                        i3 = i2;
                    }
                    if (i3 != -1 && i == i3) {
                        return true;
                    }
                }
            }
        }
        if (!this.f11439b.mo14416a().m14881e()) {
            return false;
        }
        int m14252j = m14252j();
        if (i == m14252j) {
            return true;
        }
        return this.f11439b.mo14416a().m14882f() && i == m14252j + 1;
    }

    /* renamed from: i */
    public List<Integer> m14251i() {
        int i;
        int mo14491h;
        ArrayList m9909a = C1156ai.m9909a();
        if (this.f11439b.mo14416a().m14881e()) {
            m9909a.add(Integer.valueOf(m14252j()));
        }
        if (this.f11439b.mo14416a().m14882f()) {
            m9909a.add(Integer.valueOf(m14252j() + 1));
        }
        if (m14250h()) {
            if (this.f11439b instanceof InterfaceC2215c) {
                int mo14483h = ((InterfaceC2215c) this.f11439b).mo14483h();
                if (!f11437j && ((InterfaceC2215c) this.f11439b).mo14481e() <= 0) {
                    throw new AssertionError();
                }
                mo14491h = mo14483h;
            } else {
                if (!f11437j && !(this.f11439b instanceof InterfaceC2226n)) {
                    throw new AssertionError();
                }
                InterfaceC2226n interfaceC2226n = (InterfaceC2226n) this.f11439b;
                if (!f11437j && interfaceC2226n.mo14481e() <= 0) {
                    throw new AssertionError();
                }
                mo14491h = interfaceC2226n.mo14491h();
            }
            C1980o m14245d = m14245d(mo14491h);
            if (m14245d.f11561a == 16 || m14245d.f11561a == 17) {
                m9909a.add(Integer.valueOf(mo14491h));
                C1980o c1980o = this.f11443f[mo14491h];
                for (int i2 = 0; i2 < this.f11443f.length; i2++) {
                    if (i2 != mo14491h) {
                        C1980o c1980o2 = this.f11443f[i2];
                        if (c1980o2.equals(c1980o)) {
                            m9909a.add(Integer.valueOf(i2));
                        } else if ((c1980o2.f11561a == 16 || c1980o2.f11561a == 17) && this.f11444g[i2].f11561a == 0) {
                            m9909a.add(Integer.valueOf(i2));
                        }
                    }
                }
            } else if (m14245d.f11561a == 0) {
                for (int i3 = 0; i3 < this.f11443f.length; i3++) {
                    C1980o c1980o3 = this.f11443f[i3];
                    if (c1980o3.f11561a == 16 || c1980o3.f11561a == 17) {
                        m9909a.add(Integer.valueOf(i3));
                    }
                }
            }
        }
        if (this.f11440c > 0 && this.f11438a.m14395a().m14275a() && m14239b() == 1 && (this.f11439b.mo14416a() == EnumC2272f.IF_EQZ || this.f11439b.mo14416a() == EnumC2272f.IF_NEZ)) {
            C1966b first = this.f11441d.first();
            if (first.f11439b.mo14416a() == EnumC2272f.INSTANCE_OF && C1976k.m14353a(first, this, this.f11438a.m14395a())) {
                InterfaceC2202o interfaceC2202o = (InterfaceC2202o) first.f11439b;
                m9909a.add(Integer.valueOf(interfaceC2202o.mo14500r_()));
                if (this.f11440c > 1) {
                    C1980o c1980o4 = null;
                    Iterator<C1966b> it = first.f11441d.iterator();
                    int i4 = -1;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        C1966b next = it.next();
                        EnumC2272f mo14416a = next.f11439b.mo14416a();
                        if (mo14416a != EnumC2272f.MOVE_OBJECT && mo14416a != EnumC2272f.MOVE_OBJECT_16 && mo14416a != EnumC2272f.MOVE_OBJECT_FROM16) {
                            i4 = -1;
                            break;
                        }
                        InterfaceC2230r interfaceC2230r = (InterfaceC2230r) next.f11439b;
                        C1980o m14244c = next.m14244c(interfaceC2230r.mo14500r_());
                        if (interfaceC2230r.mo14495q_() != interfaceC2202o.mo14500r_()) {
                            i4 = -1;
                            break;
                        }
                        if (m14244c.f11562b == null) {
                            i4 = -1;
                            break;
                        }
                        C1980o m14413a = c1980o4 == null ? C1980o.m14413a(this.f11438a.m14395a(), (InterfaceC2243h) interfaceC2202o.mo14489f()) : c1980o4;
                        if (C1976k.m14355a(m14244c, m14413a)) {
                            if (i4 != -1) {
                                if (i4 != interfaceC2230r.mo14500r_()) {
                                    i4 = -1;
                                    break;
                                }
                            } else {
                                i = interfaceC2230r.mo14500r_();
                                c1980o4 = m14413a;
                                i4 = i;
                            }
                        }
                        i = i4;
                        c1980o4 = m14413a;
                        i4 = i;
                    }
                    if (i4 != -1) {
                        m9909a.add(Integer.valueOf(i4));
                    }
                }
            }
        }
        return m9909a;
    }

    /* renamed from: j */
    public int m14252j() {
        if (!this.f11439b.mo14416a().m14881e()) {
            throw new C2453g("Cannot call getDestinationRegister() for an instruction that doesn't store a value", new Object[0]);
        }
        return ((InterfaceC2223k) this.f11439b).mo14495q_();
    }

    /* renamed from: k */
    public int m14253k() {
        return this.f11444g.length;
    }

    /* renamed from: c */
    public C1980o m14244c(int i) {
        return this.f11444g[i];
    }

    /* renamed from: d */
    public C1980o m14245d(int i) {
        return this.f11443f[i];
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1966b c1966b) {
        if (this.f11440c < c1966b.f11440c) {
            return -1;
        }
        if (this.f11440c == c1966b.f11440c) {
            return 0;
        }
        return 1;
    }

    /* compiled from: AnalyzedInstruction.java */
    /* renamed from: org.d.b.a.b$a */
    private static class a {

        /* renamed from: a */
        public final C1966b f11447a;

        /* renamed from: b */
        public final int f11448b;

        public a(C1966b c1966b, int i) {
            this.f11447a = c1966b;
            this.f11448b = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return C1116k.m9538a(Integer.valueOf(this.f11448b), Integer.valueOf(aVar.f11448b)) && C1116k.m9538a(this.f11447a, aVar.f11447a);
        }

        public int hashCode() {
            return C1116k.m9537a(this.f11447a, Integer.valueOf(this.f11448b));
        }
    }
}
