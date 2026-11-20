package org.p226d.p233b.p234a;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p233b.p250e.p252b.InterfaceC2215c;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2221i;
import org.p226d.p233b.p250e.p252b.InterfaceC2222j;
import org.p226d.p233b.p250e.p252b.InterfaceC2223k;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p252b.InterfaceC2226n;
import org.p226d.p233b.p250e.p252b.InterfaceC2227o;
import org.p226d.p233b.p250e.p252b.InterfaceC2228p;
import org.p226d.p233b.p250e.p252b.InterfaceC2229q;
import org.p226d.p233b.p250e.p252b.InterfaceC2230r;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2178aa;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2179ab;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2180ac;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2181ad;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2182ae;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2200m;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2202o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2203p;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2213z;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;
import org.p226d.p233b.p256f.p258b.C2284aa;
import org.p226d.p233b.p256f.p258b.C2287ad;
import org.p226d.p233b.p256f.p258b.C2297d;
import org.p226d.p233b.p256f.p258b.C2303j;
import org.p226d.p233b.p256f.p258b.C2309p;
import org.p226d.p233b.p256f.p259c.C2322b;
import org.p226d.p233b.p256f.p259c.C2325e;
import org.p226d.p233b.p263h.C2387g;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p233b.p263h.C2392l;
import org.p226d.p233b.p264i.p267c.C2426c;
import org.p226d.p269d.C2449c;
import org.p226d.p269d.C2453g;
import org.p226d.p269d.C2462p;

/* compiled from: MethodAnalyzer.java */
/* renamed from: org.d.b.a.k */
/* loaded from: classes.dex */
public class C1976k {

    /* renamed from: a */
    static final /* synthetic */ boolean f11506a;

    /* renamed from: l */
    private static final BitSet f11507l;

    /* renamed from: m */
    private static final BitSet f11508m;

    /* renamed from: n */
    private static final BitSet f11509n;

    /* renamed from: o */
    private static final BitSet f11510o;

    /* renamed from: p */
    private static final BitSet f11511p;

    /* renamed from: b */
    private final InterfaceC2267h f11512b;

    /* renamed from: c */
    private final InterfaceC2268i f11513c;

    /* renamed from: d */
    private final boolean f11514d;

    /* renamed from: e */
    private final int f11515e;

    /* renamed from: f */
    private final C1970e f11516f;

    /* renamed from: g */
    private final AbstractC1975j f11517g;

    /* renamed from: i */
    private final BitSet f11519i;

    /* renamed from: k */
    private final C1966b f11521k;

    /* renamed from: h */
    private final C2462p<C1966b> f11518h = new C2462p<>(0);

    /* renamed from: j */
    private C1960a f11520j = null;

    static {
        f11506a = !C1976k.class.desiredAssertionStatus();
        f11507l = C2449c.m15488a(2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        f11508m = C2449c.m15488a(12, 14);
        f11509n = C2449c.m15488a(13, 15);
        f11510o = C2449c.m15488a(2, 16, 17, 18);
        f11511p = C2449c.m15488a(2, 3, 4);
    }

    public C1976k(C1970e c1970e, InterfaceC2267h interfaceC2267h, AbstractC1975j abstractC1975j, boolean z) {
        this.f11516f = c1970e;
        this.f11517g = abstractC1975j;
        this.f11514d = z;
        this.f11512b = interfaceC2267h;
        InterfaceC2268i mo14216h = interfaceC2267h.mo14216h();
        if (mo14216h == null) {
            throw new IllegalArgumentException("The method has no implementation");
        }
        this.f11513c = mo14216h;
        this.f11521k = new C1966b(this, new C2297d(EnumC2272f.NOP), -1, mo14216h.mo14611d()) { // from class: org.d.b.a.k.1
            @Override // org.p226d.p233b.p234a.C1966b
            /* renamed from: a */
            protected boolean mo14237a(C1966b c1966b) {
                throw new UnsupportedOperationException();
            }

            @Override // org.p226d.p233b.p234a.C1966b
            /* renamed from: a */
            public C1980o mo14233a(C1966b c1966b, int i) {
                throw new UnsupportedOperationException();
            }
        };
        m14371f();
        this.f11519i = new BitSet(this.f11518h.m15545a());
        this.f11515e = C2387g.m15096d(interfaceC2267h);
        m14368e();
    }

    /* renamed from: a */
    public C1970e m14395a() {
        return this.f11516f;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0141 A[EDGE_INSN: B:52:0x0141->B:53:0x0141 BREAK  A[LOOP:3: B:18:0x0093->B:90:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[LOOP:3: B:18:0x0093->B:90:?, LOOP_END, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m14368e() {
        int mo14491h;
        boolean z;
        InterfaceC2267h interfaceC2267h = this.f11512b;
        int mo14611d = this.f11513c.mo14611d();
        int i = this.f11515e;
        int i2 = mo14611d - i;
        if (!C2387g.m15094b(interfaceC2267h)) {
            int i3 = mo14611d - i;
            if (C2387g.m15091a((InterfaceC2240e) interfaceC2267h)) {
                m14345a(this.f11521k, i3, C1980o.m14410a((byte) 17, this.f11516f.m14273a((CharSequence) interfaceC2267h.mo14209a())));
            } else {
                m14345a(this.f11521k, i3, C1980o.m14410a((byte) 18, this.f11516f.m14273a((CharSequence) interfaceC2267h.mo14209a())));
            }
            m14340a((mo14611d - i) + 1);
        } else {
            m14340a(mo14611d - i);
        }
        C1980o m14410a = C1980o.m14410a((byte) 1, (InterfaceC1981p) null);
        for (int i4 = 0; i4 < i2; i4++) {
            m14345a(this.f11521k, i4, m14410a);
        }
        BitSet bitSet = new BitSet(this.f11518h.m15545a());
        Iterator<C1966b> it = this.f11521k.f11442e.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().f11440c);
        }
        BitSet bitSet2 = new BitSet(this.f11518h.m15545a());
        while (true) {
            boolean z2 = false;
            while (!bitSet.isEmpty()) {
                int nextSetBit = bitSet.nextSetBit(0);
                boolean z3 = z2;
                while (nextSetBit >= 0) {
                    bitSet.clear(nextSetBit);
                    if (this.f11519i.get(nextSetBit)) {
                        z = z3;
                    } else {
                        C1966b m15551c = this.f11518h.m15551c(nextSetBit);
                        try {
                            if (m15551c.f11446i.mo14416a().m14878b()) {
                                m15551c.m14246d();
                            }
                            if (!m14360b(m15551c)) {
                                bitSet2.set(nextSetBit);
                                z = z3;
                            } else {
                                try {
                                    bitSet2.clear(nextSetBit);
                                    this.f11519i.set(m15551c.m14231a());
                                    Iterator<C1966b> it2 = m15551c.f11442e.iterator();
                                    while (it2.hasNext()) {
                                        bitSet.set(it2.next().m14231a());
                                    }
                                    z = true;
                                } catch (C1960a e2) {
                                    e = e2;
                                    z3 = true;
                                    this.f11520j = e;
                                    int m14394a = m14394a(m15551c);
                                    e.f11398a = m14394a;
                                    e.m15521a(String.format("opcode: %s", m15551c.f11439b.mo14416a().f12384eg));
                                    e.m15521a(String.format("code address: %d", Integer.valueOf(m14394a)));
                                    e.m15521a(String.format("method: %s", C2389i.m15122a((InterfaceC2241f) interfaceC2267h)));
                                    z2 = z3;
                                    if (this.f11520j == null) {
                                    }
                                }
                            }
                        } catch (C1960a e3) {
                            e = e3;
                        }
                    }
                    nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
                    z3 = z;
                }
                z2 = z3;
                if (this.f11520j == null) {
                    break;
                }
            }
            if (!z2) {
                break;
            }
            if (!bitSet2.isEmpty()) {
                for (int nextSetBit2 = bitSet2.nextSetBit(0); nextSetBit2 >= 0; nextSetBit2 = bitSet2.nextSetBit(nextSetBit2 + 1)) {
                    bitSet.set(nextSetBit2);
                }
            }
        }
        for (int i5 = 0; i5 < this.f11518h.m15545a(); i5++) {
            C1966b m15551c2 = this.f11518h.m15551c(i5);
            InterfaceC2218f m14247e = m15551c2.m14247e();
            if (m14247e.mo14416a().m14878b()) {
                switch (m14247e.mo14416a().f12386ei) {
                    case Format10x:
                        m14351a(m15551c2, false);
                        continue;
                    case Format21c:
                    case Format22c:
                        m14373f(m15551c2, false);
                        continue;
                    case Format35c:
                        m14364c(m15551c2, false);
                        continue;
                    case Format3rc:
                        m14367d(m15551c2, false);
                        continue;
                    case Format22cs:
                        mo14491h = ((InterfaceC2203p) m14247e).mo14500r_();
                        break;
                    case Format35mi:
                    case Format35ms:
                        mo14491h = ((InterfaceC2215c) m14247e).mo14483h();
                        break;
                    case Format3rmi:
                    case Format3rms:
                        mo14491h = ((InterfaceC2226n) m14247e).mo14491h();
                        break;
                }
                m15551c2.m14234a(new C1984s(m14247e, mo14491h));
            }
        }
    }

    /* renamed from: a */
    private void m14340a(int i) {
        int i2;
        int i3 = 0;
        for (InterfaceC2269j interfaceC2269j : this.f11512b.mo14213e()) {
            if (C2392l.m15148a(interfaceC2269j)) {
                int i4 = i3 + 1;
                m14345a(this.f11521k, i3 + i, C1980o.m14412a((CharSequence) interfaceC2269j, true));
                m14345a(this.f11521k, i4 + i, C1980o.m14412a((CharSequence) interfaceC2269j, false));
                i2 = i4 + 1;
            } else {
                m14345a(this.f11521k, i3 + i, C1980o.m14413a(this.f11516f, interfaceC2269j));
                i2 = i3 + 1;
            }
            i3 = i2;
        }
    }

    /* renamed from: b */
    public List<C1966b> m14396b() {
        return this.f11518h.m15549b();
    }

    /* renamed from: c */
    public C1960a m14397c() {
        return this.f11520j;
    }

    /* renamed from: d */
    public int m14398d() {
        return this.f11515e;
    }

    /* renamed from: a */
    public int m14394a(C1966b c1966b) {
        return this.f11518h.m15548b(c1966b.f11440c);
    }

    /* renamed from: a */
    private void m14349a(C1966b c1966b, C1980o c1980o) {
        m14345a(c1966b, c1966b.m14252j(), c1980o);
    }

    /* renamed from: a */
    private void m14342a(BitSet bitSet, int i, boolean z) {
        while (!bitSet.isEmpty()) {
            int nextSetBit = bitSet.nextSetBit(0);
            while (nextSetBit >= 0) {
                bitSet.clear(nextSetBit);
                m14344a(this.f11518h.m15551c(nextSetBit), i, bitSet, z);
                nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            }
        }
    }

    /* renamed from: a */
    private void m14346a(C1966b c1966b, C1966b c1966b2, int i, C1980o c1980o) {
        BitSet bitSet = new BitSet(this.f11518h.m15545a());
        if (c1966b.m14238a(c1966b2, i, c1980o, this.f11519i)) {
            bitSet.set(c1966b.f11440c);
            m14342a(bitSet, i, true);
            if (c1980o.f11561a == 12) {
                m14341a(i, c1966b);
                m14346a(c1966b, c1966b2, i + 1, C1980o.f11556r);
            } else if (c1980o.f11561a == 14) {
                m14341a(i, c1966b);
                m14346a(c1966b, c1966b2, i + 1, C1980o.f11558t);
            }
        }
    }

    /* renamed from: a */
    private void m14345a(C1966b c1966b, int i, C1980o c1980o) {
        BitSet bitSet = new BitSet(this.f11518h.m15545a());
        if (c1966b.m14235a(i, c1980o)) {
            m14344a(c1966b, i, bitSet, false);
            m14342a(bitSet, i, false);
            if (c1980o.f11561a == 12) {
                m14341a(i, c1966b);
                m14345a(c1966b, i + 1, C1980o.f11556r);
            } else if (c1980o.f11561a == 14) {
                m14341a(i, c1966b);
                m14345a(c1966b, i + 1, C1980o.f11558t);
            }
        }
    }

    /* renamed from: a */
    private void m14344a(C1966b c1966b, int i, BitSet bitSet, boolean z) {
        C1980o m14244c = c1966b.m14244c(i);
        Iterator<C1966b> it = c1966b.f11442e.iterator();
        while (it.hasNext()) {
            C1966b next = it.next();
            if (next.m14236a(i, m14244c, this.f11519i, z)) {
                bitSet.set(next.f11440c);
            }
        }
    }

    /* renamed from: f */
    private void m14371f() {
        int mo14611d = this.f11513c.mo14611d();
        AbstractC1208w m10129a = AbstractC1208w.m10129a((Iterable) this.f11513c.mo14608b());
        this.f11518h.m15554e(m10129a.size());
        int i = 0;
        for (int i2 = 0; i2 < m10129a.size(); i2++) {
            InterfaceC2218f interfaceC2218f = (InterfaceC2218f) m10129a.get(i2);
            this.f11518h.m15552c(i, new C1966b(this, interfaceC2218f, i2, mo14611d));
            if (!f11506a && this.f11518h.m15553d(i) != i2) {
                throw new AssertionError();
            }
            i += interfaceC2218f.mo14417b();
        }
        List m15327a = C2426c.m15327a(this.f11513c.mo14612e());
        C1966b[][] c1966bArr = new C1966b[m10129a.size()][];
        if (m15327a != null) {
            C1966b[] c1966bArr2 = null;
            InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l = null;
            int i3 = 0;
            for (int i4 = 0; i4 < this.f11518h.m15545a(); i4++) {
                C1966b m15551c = this.f11518h.m15551c(i4);
                EnumC2272f mo14416a = m15551c.f11439b.mo14416a();
                int m14394a = m14394a(m15551c);
                if (interfaceC2271l != null && interfaceC2271l.mo14514a() + interfaceC2271l.mo14515b() <= m14394a) {
                    i3++;
                    interfaceC2271l = null;
                }
                if (interfaceC2271l == null && i3 < m15327a.size()) {
                    InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l2 = (InterfaceC2271l) m15327a.get(i3);
                    if (interfaceC2271l2.mo14514a() <= m14394a) {
                        if (!f11506a && interfaceC2271l2.mo14514a() + interfaceC2271l2.mo14515b() <= m14394a) {
                            throw new AssertionError();
                        }
                        c1966bArr2 = m14356a(interfaceC2271l2);
                        interfaceC2271l = interfaceC2271l2;
                    }
                }
                if (interfaceC2271l != null && mo14416a.m14877a()) {
                    c1966bArr[i4] = c1966bArr2;
                }
            }
        }
        if (!f11506a && this.f11518h.m15545a() <= 0) {
            throw new AssertionError();
        }
        BitSet bitSet = new BitSet(m10129a.size());
        m14347a(this.f11521k, this.f11518h.m15551c(0), c1966bArr, bitSet);
        while (!bitSet.isEmpty()) {
            int nextSetBit = bitSet.nextSetBit(0);
            bitSet.clear(nextSetBit);
            C1966b m15551c2 = this.f11518h.m15551c(nextSetBit);
            EnumC2272f mo14416a2 = m15551c2.f11439b.mo14416a();
            int m14394a2 = m14394a(m15551c2);
            if (m15551c2.f11439b.mo14416a().m14879c()) {
                if (nextSetBit == this.f11518h.m15545a() - 1) {
                    throw new C1960a("Execution can continue past the last instruction", new Object[0]);
                }
                m14347a(m15551c2, this.f11518h.m15551c(nextSetBit + 1), c1966bArr, bitSet);
            }
            if (m15551c2.f11439b instanceof InterfaceC2222j) {
                InterfaceC2222j interfaceC2222j = (InterfaceC2222j) m15551c2.f11439b;
                if (mo14416a2 == EnumC2272f.PACKED_SWITCH || mo14416a2 == EnumC2272f.SPARSE_SWITCH) {
                    C1966b m15546a = this.f11518h.m15546a(interfaceC2222j.mo14507e() + m14394a2);
                    if (m15546a == null) {
                        throw new C1960a("Invalid switch payload offset", new Object[0]);
                    }
                    Iterator<? extends InterfaceC2227o> it = ((InterfaceC2228p) m15546a.f11439b).mo14496f().iterator();
                    while (it.hasNext()) {
                        C1966b m15546a2 = this.f11518h.m15546a(it.next().mo14498b() + m14394a2);
                        if (m15546a2 == null) {
                            throw new C1960a("Invalid switch target offset", new Object[0]);
                        }
                        m14347a(m15551c2, m15546a2, c1966bArr, bitSet);
                    }
                } else if (mo14416a2 != EnumC2272f.FILL_ARRAY_DATA) {
                    m14347a(m15551c2, this.f11518h.m15546a(interfaceC2222j.mo14507e() + m14394a2), c1966bArr, bitSet);
                }
            }
        }
    }

    /* renamed from: a */
    private void m14347a(C1966b c1966b, C1966b c1966b2, C1966b[][] c1966bArr, BitSet bitSet) {
        m14348a(c1966b, c1966b2, c1966bArr, bitSet, false);
    }

    /* renamed from: a */
    private void m14348a(C1966b c1966b, C1966b c1966b2, C1966b[][] c1966bArr, BitSet bitSet, boolean z) {
        if (!z && c1966b2.f11439b.mo14416a() == EnumC2272f.MOVE_EXCEPTION) {
            throw new C1960a("Execution can pass from the " + c1966b.f11439b.mo14416a().f12384eg + " instruction at code address 0x" + Integer.toHexString(m14394a(c1966b)) + " to the move-exception instruction at address 0x" + Integer.toHexString(m14394a(c1966b2)), new Object[0]);
        }
        if (c1966b2.mo14237a(c1966b)) {
            c1966b.m14240b(c1966b2);
            bitSet.set(c1966b2.m14231a());
            C1966b[] c1966bArr2 = c1966bArr[c1966b2.f11440c];
            if (c1966bArr2 != null) {
                if (!f11506a && !c1966b2.f11439b.mo14416a().m14877a()) {
                    throw new AssertionError();
                }
                for (C1966b c1966b3 : c1966bArr2) {
                    m14348a(c1966b, c1966b3, c1966bArr, bitSet, true);
                }
            }
        }
    }

    /* renamed from: a */
    private C1966b[] m14356a(InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l) {
        List<? extends Object> mo14516c = interfaceC2271l.mo14516c();
        C1966b[] c1966bArr = new C1966b[mo14516c.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < mo14516c.size()) {
                c1966bArr[i2] = this.f11518h.m15546a(((InterfaceC2265f) mo14516c.get(i2)).mo14477c());
                i = i2 + 1;
            } else {
                return c1966bArr;
            }
        }
    }

    /* renamed from: b */
    private boolean m14360b(C1966b c1966b) {
        switch (c1966b.f11439b.mo14416a()) {
            case NOP:
            case RETURN_VOID:
            case RETURN:
            case RETURN_WIDE:
            case RETURN_OBJECT:
            case MONITOR_ENTER:
            case MONITOR_EXIT:
            case FILLED_NEW_ARRAY:
            case FILLED_NEW_ARRAY_RANGE:
            case FILL_ARRAY_DATA:
            case THROW:
            case GOTO:
            case GOTO_16:
            case GOTO_32:
            case PACKED_SWITCH:
            case SPARSE_SWITCH:
            case IF_EQ:
            case IF_NE:
            case IF_LT:
            case IF_GE:
            case IF_GT:
            case IF_LE:
            case IF_LTZ:
            case IF_GEZ:
            case IF_GTZ:
            case IF_LEZ:
            case APUT:
            case APUT_BOOLEAN:
            case APUT_BYTE:
            case APUT_CHAR:
            case APUT_SHORT:
            case APUT_WIDE:
            case APUT_OBJECT:
            case IPUT:
            case IPUT_BOOLEAN:
            case IPUT_BYTE:
            case IPUT_CHAR:
            case IPUT_SHORT:
            case IPUT_WIDE:
            case IPUT_OBJECT:
            case SPUT:
            case SPUT_BOOLEAN:
            case SPUT_BYTE:
            case SPUT_CHAR:
            case SPUT_SHORT:
            case SPUT_WIDE:
            case SPUT_OBJECT:
            case INVOKE_STATIC:
            case INVOKE_INTERFACE:
            case INVOKE_STATIC_RANGE:
            case INVOKE_INTERFACE_RANGE:
            case THROW_VERIFICATION_ERROR:
                return true;
            case MOVE:
            case MOVE_FROM16:
            case MOVE_16:
            case MOVE_WIDE:
            case MOVE_WIDE_FROM16:
            case MOVE_WIDE_16:
            case MOVE_OBJECT:
            case MOVE_OBJECT_FROM16:
            case MOVE_OBJECT_16:
                m14361c(c1966b);
                return true;
            case MOVE_RESULT:
            case MOVE_RESULT_WIDE:
            case MOVE_RESULT_OBJECT:
                m14365d(c1966b);
                return true;
            case MOVE_EXCEPTION:
                m14369e(c1966b);
                return true;
            case RETURN_VOID_BARRIER:
            case RETURN_VOID_NO_BARRIER:
                m14372f(c1966b);
                return true;
            case CONST_4:
            case CONST_16:
            case CONST:
            case CONST_HIGH16:
                m14374g(c1966b);
                return true;
            case CONST_WIDE_16:
            case CONST_WIDE_32:
            case CONST_WIDE:
            case CONST_WIDE_HIGH16:
                m14375h(c1966b);
                return true;
            case CONST_STRING:
            case CONST_STRING_JUMBO:
                m14376i(c1966b);
                return true;
            case CONST_CLASS:
                m14377j(c1966b);
                return true;
            case CHECK_CAST:
                m14378k(c1966b);
                return true;
            case INSTANCE_OF:
                m14380m(c1966b);
                return true;
            case ARRAY_LENGTH:
                m14381n(c1966b);
                return true;
            case NEW_INSTANCE:
                m14382o(c1966b);
                return true;
            case NEW_ARRAY:
                m14383p(c1966b);
                return true;
            case CMPL_FLOAT:
            case CMPG_FLOAT:
            case CMPL_DOUBLE:
            case CMPG_DOUBLE:
            case CMP_LONG:
                m14384q(c1966b);
                return true;
            case IF_EQZ:
            case IF_NEZ:
                m14379l(c1966b);
                return true;
            case AGET:
                m14358b(c1966b, C1980o.f11553o);
                return true;
            case AGET_BOOLEAN:
                m14358b(c1966b, C1980o.f11547i);
                return true;
            case AGET_BYTE:
                m14358b(c1966b, C1980o.f11548j);
                return true;
            case AGET_CHAR:
                m14358b(c1966b, C1980o.f11552n);
                return true;
            case AGET_SHORT:
                m14358b(c1966b, C1980o.f11550l);
                return true;
            case AGET_WIDE:
                m14385r(c1966b);
                return true;
            case AGET_OBJECT:
                m14386s(c1966b);
                return true;
            case IGET:
                m14362c(c1966b, C1980o.f11553o);
                return true;
            case IGET_BOOLEAN:
                m14362c(c1966b, C1980o.f11547i);
                return true;
            case IGET_BYTE:
                m14362c(c1966b, C1980o.f11548j);
                return true;
            case IGET_CHAR:
                m14362c(c1966b, C1980o.f11552n);
                return true;
            case IGET_SHORT:
                m14362c(c1966b, C1980o.f11550l);
                return true;
            case IGET_WIDE:
            case IGET_OBJECT:
                m14387t(c1966b);
                return true;
            case SGET:
                m14362c(c1966b, C1980o.f11553o);
                return true;
            case SGET_BOOLEAN:
                m14362c(c1966b, C1980o.f11547i);
                return true;
            case SGET_BYTE:
                m14362c(c1966b, C1980o.f11548j);
                return true;
            case SGET_CHAR:
                m14362c(c1966b, C1980o.f11552n);
                return true;
            case SGET_SHORT:
                m14362c(c1966b, C1980o.f11550l);
                return true;
            case SGET_WIDE:
            case SGET_OBJECT:
                m14387t(c1966b);
                return true;
            case INVOKE_VIRTUAL:
                m14370e(c1966b, false);
                return true;
            case INVOKE_SUPER:
                m14370e(c1966b, false);
                return true;
            case INVOKE_DIRECT:
                m14388u(c1966b);
                return true;
            case INVOKE_VIRTUAL_RANGE:
                m14370e(c1966b, true);
                return true;
            case INVOKE_SUPER_RANGE:
                m14370e(c1966b, true);
                return true;
            case INVOKE_DIRECT_RANGE:
                m14389v(c1966b);
                return true;
            case NEG_INT:
            case NOT_INT:
                m14366d(c1966b, C1980o.f11553o);
                return true;
            case NEG_LONG:
            case NOT_LONG:
                m14366d(c1966b, C1980o.f11555q);
                return true;
            case NEG_FLOAT:
                m14366d(c1966b, C1980o.f11554p);
                return true;
            case NEG_DOUBLE:
                m14366d(c1966b, C1980o.f11557s);
                return true;
            case INT_TO_LONG:
                m14366d(c1966b, C1980o.f11555q);
                return true;
            case INT_TO_FLOAT:
                m14366d(c1966b, C1980o.f11554p);
                return true;
            case INT_TO_DOUBLE:
                m14366d(c1966b, C1980o.f11557s);
                return true;
            case LONG_TO_INT:
            case DOUBLE_TO_INT:
                m14366d(c1966b, C1980o.f11553o);
                return true;
            case LONG_TO_FLOAT:
            case DOUBLE_TO_FLOAT:
                m14366d(c1966b, C1980o.f11554p);
                return true;
            case LONG_TO_DOUBLE:
                m14366d(c1966b, C1980o.f11557s);
                return true;
            case FLOAT_TO_INT:
                m14366d(c1966b, C1980o.f11553o);
                return true;
            case FLOAT_TO_LONG:
                m14366d(c1966b, C1980o.f11555q);
                return true;
            case FLOAT_TO_DOUBLE:
                m14366d(c1966b, C1980o.f11557s);
                return true;
            case DOUBLE_TO_LONG:
                m14366d(c1966b, C1980o.f11555q);
                return true;
            case INT_TO_BYTE:
                m14366d(c1966b, C1980o.f11548j);
                return true;
            case INT_TO_CHAR:
                m14366d(c1966b, C1980o.f11552n);
                return true;
            case INT_TO_SHORT:
                m14366d(c1966b, C1980o.f11550l);
                return true;
            case ADD_INT:
            case SUB_INT:
            case MUL_INT:
            case DIV_INT:
            case REM_INT:
            case SHL_INT:
            case SHR_INT:
            case USHR_INT:
                m14350a(c1966b, C1980o.f11553o, false);
                return true;
            case AND_INT:
            case OR_INT:
            case XOR_INT:
                m14350a(c1966b, C1980o.f11553o, true);
                return true;
            case ADD_LONG:
            case SUB_LONG:
            case MUL_LONG:
            case DIV_LONG:
            case REM_LONG:
            case AND_LONG:
            case OR_LONG:
            case XOR_LONG:
            case SHL_LONG:
            case SHR_LONG:
            case USHR_LONG:
                m14350a(c1966b, C1980o.f11555q, false);
                return true;
            case ADD_FLOAT:
            case SUB_FLOAT:
            case MUL_FLOAT:
            case DIV_FLOAT:
            case REM_FLOAT:
                m14350a(c1966b, C1980o.f11554p, false);
                return true;
            case ADD_DOUBLE:
            case SUB_DOUBLE:
            case MUL_DOUBLE:
            case DIV_DOUBLE:
            case REM_DOUBLE:
                m14350a(c1966b, C1980o.f11557s, false);
                return true;
            case ADD_INT_2ADDR:
            case SUB_INT_2ADDR:
            case MUL_INT_2ADDR:
            case DIV_INT_2ADDR:
            case REM_INT_2ADDR:
            case SHL_INT_2ADDR:
            case SHR_INT_2ADDR:
            case USHR_INT_2ADDR:
                m14359b(c1966b, C1980o.f11553o, false);
                return true;
            case AND_INT_2ADDR:
            case OR_INT_2ADDR:
            case XOR_INT_2ADDR:
                m14359b(c1966b, C1980o.f11553o, true);
                return true;
            case ADD_LONG_2ADDR:
            case SUB_LONG_2ADDR:
            case MUL_LONG_2ADDR:
            case DIV_LONG_2ADDR:
            case REM_LONG_2ADDR:
            case AND_LONG_2ADDR:
            case OR_LONG_2ADDR:
            case XOR_LONG_2ADDR:
            case SHL_LONG_2ADDR:
            case SHR_LONG_2ADDR:
            case USHR_LONG_2ADDR:
                m14359b(c1966b, C1980o.f11555q, false);
                return true;
            case ADD_FLOAT_2ADDR:
            case SUB_FLOAT_2ADDR:
            case MUL_FLOAT_2ADDR:
            case DIV_FLOAT_2ADDR:
            case REM_FLOAT_2ADDR:
                m14359b(c1966b, C1980o.f11554p, false);
                return true;
            case ADD_DOUBLE_2ADDR:
            case SUB_DOUBLE_2ADDR:
            case MUL_DOUBLE_2ADDR:
            case DIV_DOUBLE_2ADDR:
            case REM_DOUBLE_2ADDR:
                m14359b(c1966b, C1980o.f11557s, false);
                return true;
            case ADD_INT_LIT16:
            case RSUB_INT:
            case MUL_INT_LIT16:
            case DIV_INT_LIT16:
            case REM_INT_LIT16:
                m14363c(c1966b, C1980o.f11553o, false);
                return true;
            case AND_INT_LIT16:
            case OR_INT_LIT16:
            case XOR_INT_LIT16:
                m14363c(c1966b, C1980o.f11553o, true);
                return true;
            case ADD_INT_LIT8:
            case RSUB_INT_LIT8:
            case MUL_INT_LIT8:
            case DIV_INT_LIT8:
            case REM_INT_LIT8:
            case SHL_INT_LIT8:
                m14363c(c1966b, C1980o.f11553o, false);
                return true;
            case AND_INT_LIT8:
            case OR_INT_LIT8:
            case XOR_INT_LIT8:
                m14363c(c1966b, C1980o.f11553o, true);
                return true;
            case SHR_INT_LIT8:
                m14363c(c1966b, m14357b(c1966b, true), false);
                return true;
            case USHR_INT_LIT8:
                m14363c(c1966b, m14357b(c1966b, false), false);
                return true;
            case IGET_VOLATILE:
            case IPUT_VOLATILE:
            case SGET_VOLATILE:
            case SPUT_VOLATILE:
            case IGET_OBJECT_VOLATILE:
            case IGET_WIDE_VOLATILE:
            case IPUT_WIDE_VOLATILE:
            case SGET_WIDE_VOLATILE:
            case SPUT_WIDE_VOLATILE:
                m14337B(c1966b);
                return true;
            case EXECUTE_INLINE:
                m14390w(c1966b);
                return true;
            case EXECUTE_INLINE_RANGE:
                m14391x(c1966b);
                return true;
            case INVOKE_DIRECT_EMPTY:
                m14392y(c1966b);
                return true;
            case INVOKE_OBJECT_INIT_RANGE:
                m14393z(c1966b);
                return true;
            case IGET_QUICK:
            case IGET_WIDE_QUICK:
            case IGET_OBJECT_QUICK:
            case IPUT_QUICK:
            case IPUT_WIDE_QUICK:
            case IPUT_OBJECT_QUICK:
            case IPUT_BOOLEAN_QUICK:
            case IPUT_BYTE_QUICK:
            case IPUT_CHAR_QUICK:
            case IPUT_SHORT_QUICK:
            case IGET_BOOLEAN_QUICK:
            case IGET_BYTE_QUICK:
            case IGET_CHAR_QUICK:
            case IGET_SHORT_QUICK:
                return m14336A(c1966b);
            case INVOKE_VIRTUAL_QUICK:
                return m14354a(c1966b, false, false);
            case INVOKE_SUPER_QUICK:
                return m14354a(c1966b, true, false);
            case INVOKE_VIRTUAL_QUICK_RANGE:
                return m14354a(c1966b, false, true);
            case INVOKE_SUPER_QUICK_RANGE:
                return m14354a(c1966b, true, true);
            case IPUT_OBJECT_VOLATILE:
            case SGET_OBJECT_VOLATILE:
            case SPUT_OBJECT_VOLATILE:
                m14337B(c1966b);
                return true;
            default:
                if (f11506a) {
                    return true;
                }
                throw new AssertionError();
        }
    }

    /* renamed from: c */
    private void m14361c(C1966b c1966b) {
        m14349a(c1966b, c1966b.m14245d(((InterfaceC2230r) c1966b.f11439b).mo14500r_()));
    }

    /* renamed from: d */
    private void m14365d(C1966b c1966b) {
        C1980o m14413a;
        C1966b c1966b2 = null;
        if (c1966b.f11440c > 0) {
            c1966b2 = this.f11518h.m15551c(c1966b.f11440c - 1);
        }
        if (c1966b2 == null || !c1966b2.f11439b.mo14416a().m14880d()) {
            throw new C1960a(c1966b.f11439b.mo14416a().f12384eg + " must occur after an invoke-*/fill-new-array instruction", new Object[0]);
        }
        InterfaceC2241f mo14489f = ((InterfaceC2225m) c1966b2.f11439b).mo14489f();
        if (mo14489f instanceof InterfaceC2240e) {
            m14413a = C1980o.m14413a(this.f11516f, ((InterfaceC2240e) mo14489f).mo14212d());
        } else {
            m14413a = C1980o.m14413a(this.f11516f, (InterfaceC2243h) mo14489f);
        }
        m14349a(c1966b, m14413a);
    }

    /* renamed from: e */
    private void m14369e(C1966b c1966b) {
        int m14394a = m14394a(c1966b);
        C1980o c1980o = C1980o.f11543e;
        Iterator<? extends InterfaceC2271l<? extends InterfaceC2265f>> it = this.f11513c.mo14612e().iterator();
        C1980o c1980o2 = c1980o;
        while (it.hasNext()) {
            Iterator<? extends Object> it2 = it.next().mo14516c().iterator();
            while (it2.hasNext()) {
                InterfaceC2265f interfaceC2265f = (InterfaceC2265f) it2.next();
                if (interfaceC2265f.mo14477c() == m14394a) {
                    String mo14476b = interfaceC2265f.mo14476b();
                    if (mo14476b == null) {
                        c1980o2 = C1980o.m14410a((byte) 18, this.f11516f.m14273a((CharSequence) "Ljava/lang/Throwable;"));
                    } else {
                        c1980o2 = C1980o.m14410a((byte) 18, this.f11516f.m14273a((CharSequence) mo14476b)).m14414a(c1980o2);
                    }
                }
            }
        }
        if (c1980o2.f11561a == 0) {
            throw new C1960a("move-exception must be the first instruction in an exception handler block", new Object[0]);
        }
        m14349a(c1966b, c1980o2);
    }

    /* renamed from: f */
    private void m14372f(C1966b c1966b) {
        m14351a(c1966b, true);
    }

    /* renamed from: a */
    private void m14351a(C1966b c1966b, boolean z) {
        c1966b.m14234a(new C2297d(EnumC2272f.RETURN_VOID));
        if (z) {
            m14360b(c1966b);
        }
    }

    /* renamed from: g */
    private void m14374g(C1966b c1966b) {
        m14349a(c1966b, C1980o.m14411a(((InterfaceC2221i) c1966b.f11439b).mo14499f()));
    }

    /* renamed from: h */
    private void m14375h(C1966b c1966b) {
        m14349a(c1966b, C1980o.f11555q);
    }

    /* renamed from: i */
    private void m14376i(C1966b c1966b) {
        m14349a(c1966b, C1980o.m14410a((byte) 18, this.f11516f.m14273a((CharSequence) "Ljava/lang/String;")));
    }

    /* renamed from: j */
    private void m14377j(C1966b c1966b) {
        m14349a(c1966b, C1980o.m14410a((byte) 18, this.f11516f.m14273a((CharSequence) "Ljava/lang/Class;")));
    }

    /* renamed from: k */
    private void m14378k(C1966b c1966b) {
        m14349a(c1966b, C1980o.m14413a(this.f11516f, (InterfaceC2243h) ((InterfaceC2225m) c1966b.f11439b).mo14489f()));
    }

    /* renamed from: a */
    public static boolean m14355a(C1980o c1980o, C1980o c1980o2) {
        if (c1980o.f11562b == null || c1980o2.f11562b == null) {
            return true;
        }
        if (c1980o.f11562b.mo14267c()) {
            return c1980o2.f11562b.mo14264a(c1980o.f11562b.mo14265b());
        }
        InterfaceC1981p mo14262a = c1980o2.f11562b.mo14262a(c1980o.f11562b);
        return mo14262a.mo14265b().equals(c1980o.f11562b.mo14265b()) || !mo14262a.mo14265b().equals(c1980o2.f11562b.mo14265b());
    }

    /* renamed from: a */
    static boolean m14353a(C1966b c1966b, C1966b c1966b2, C1970e c1970e) {
        if (!c1970e.m14275a()) {
            return false;
        }
        if (((InterfaceC2200m) c1966b2.f11439b).mo14495q_() == c1966b.m14252j()) {
            C1980o m14413a = C1980o.m14413a(c1970e, (InterfaceC2243h) ((InterfaceC2202o) c1966b.m14247e()).mo14489f());
            try {
                if (m14413a.f11562b != null && !m14413a.f11562b.mo14267c()) {
                    return m14355a(c1966b2.m14245d(((InterfaceC2230r) c1966b.m14247e()).mo14500r_()), m14413a);
                }
            } catch (C1983r e2) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: l */
    private void m14379l(C1966b c1966b) {
        if (this.f11516f.m14275a() && c1966b.m14231a() > 0 && c1966b.m14239b() == 1) {
            C1966b first = c1966b.m14243c().first();
            if (first.f11439b.mo14416a() == EnumC2272f.INSTANCE_OF) {
                C1966b m15551c = this.f11518h.m15551c(c1966b.m14231a() + 1);
                C1966b m15546a = this.f11518h.m15546a(((InterfaceC2200m) c1966b.f11439b).mo14507e() + m14394a(c1966b));
                C1980o m14245d = c1966b.m14245d(((InterfaceC2202o) first.f11439b).mo14500r_());
                C1980o m14413a = C1980o.m14413a(this.f11516f, (InterfaceC2243h) ((InterfaceC2202o) first.f11439b).mo14489f());
                Iterator<Integer> it = c1966b.m14251i().iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (c1966b.f11439b.mo14416a() == EnumC2272f.IF_EQZ) {
                        m14346a(m15551c, c1966b, intValue, m14413a);
                        m14346a(m15546a, c1966b, intValue, m14245d);
                    } else {
                        m14346a(m15551c, c1966b, intValue, m14245d);
                        m14346a(m15546a, c1966b, intValue, m14413a);
                    }
                }
            }
        }
    }

    /* renamed from: m */
    private void m14380m(C1966b c1966b) {
        m14349a(c1966b, C1980o.f11547i);
    }

    /* renamed from: n */
    private void m14381n(C1966b c1966b) {
        m14349a(c1966b, C1980o.f11553o);
    }

    /* renamed from: o */
    private void m14382o(C1966b c1966b) {
        InterfaceC2225m interfaceC2225m = (InterfaceC2225m) c1966b.f11439b;
        C1980o m14244c = c1966b.m14244c(((InterfaceC2223k) c1966b.f11439b).mo14495q_());
        if (m14244c.f11561a != 0) {
            if (!f11506a && m14244c.f11561a != 16) {
                throw new AssertionError();
            }
        } else {
            m14349a(c1966b, C1980o.m14410a((byte) 16, C1980o.m14413a(this.f11516f, (InterfaceC2243h) interfaceC2225m.mo14489f()).f11562b));
        }
    }

    /* renamed from: p */
    private void m14383p(C1966b c1966b) {
        InterfaceC2243h interfaceC2243h = (InterfaceC2243h) ((InterfaceC2225m) c1966b.f11439b).mo14489f();
        if (interfaceC2243h.mo14205l().charAt(0) != '[') {
            throw new C1960a("new-array used with non-array type", new Object[0]);
        }
        m14349a(c1966b, C1980o.m14413a(this.f11516f, interfaceC2243h));
    }

    /* renamed from: q */
    private void m14384q(C1966b c1966b) {
        m14349a(c1966b, C1980o.f11548j);
    }

    /* renamed from: b */
    private void m14358b(C1966b c1966b, C1980o c1980o) {
        m14349a(c1966b, c1980o);
    }

    /* renamed from: r */
    private void m14385r(C1966b c1966b) {
        C1980o m14245d = c1966b.m14245d(((InterfaceC2229q) c1966b.f11439b).mo14500r_());
        if (m14245d.f11561a != 2) {
            if (m14245d.f11561a != 18 || !(m14245d.f11562b instanceof C1969d)) {
                throw new C1960a("aget-wide used with non-array register: %s", m14245d.toString());
            }
            C1969d c1969d = (C1969d) m14245d.f11562b;
            if (c1969d.f11454b != 1) {
                throw new C1960a("aget-wide used with multi-dimensional array: %s", m14245d.toString());
            }
            char charAt = c1969d.m14268d().charAt(0);
            if (charAt == 'J') {
                m14349a(c1966b, C1980o.f11555q);
                return;
            } else {
                if (charAt == 'D') {
                    m14349a(c1966b, C1980o.f11557s);
                    return;
                }
                throw new C1960a("aget-wide used with narrow array: %s", m14245d);
            }
        }
        m14349a(c1966b, C1980o.f11555q);
    }

    /* renamed from: s */
    private void m14386s(C1966b c1966b) {
        C1980o m14245d = c1966b.m14245d(((InterfaceC2229q) c1966b.f11439b).mo14500r_());
        if (m14245d.f11561a != 2) {
            if (m14245d.f11561a != 18 || !(m14245d.f11562b instanceof C1969d)) {
                throw new C1960a("aget-object used with non-array register: %s", m14245d.toString());
            }
            m14349a(c1966b, C1980o.m14410a((byte) 18, this.f11516f.m14273a((CharSequence) ((C1969d) m14245d.f11562b).m14269e())));
            return;
        }
        m14349a(c1966b, C1980o.f11545g);
    }

    /* renamed from: c */
    private void m14362c(C1966b c1966b, C1980o c1980o) {
        m14349a(c1966b, c1980o);
    }

    /* renamed from: t */
    private void m14387t(C1966b c1966b) {
        m14349a(c1966b, C1980o.m14413a(this.f11516f, ((InterfaceC2237b) ((InterfaceC2225m) c1966b.f11439b).mo14489f()).mo14227f()));
    }

    /* renamed from: u */
    private void m14388u(C1966b c1966b) {
        m14343a(c1966b, ((InterfaceC2215c) c1966b.f11439b).mo14483h());
    }

    /* renamed from: v */
    private void m14389v(C1966b c1966b) {
        m14343a(c1966b, ((InterfaceC2226n) c1966b.f11439b).mo14491h());
    }

    /* renamed from: a */
    private void m14343a(C1966b c1966b, int i) {
        if (c1966b.m14250h()) {
            C1980o m14245d = c1966b.m14245d(i);
            if (m14245d.f11561a != 16 && m14245d.f11561a != 17) {
                if (!f11506a && !c1966b.m14251i().isEmpty()) {
                    throw new AssertionError();
                }
                return;
            }
            C1980o m14410a = C1980o.m14410a((byte) 18, m14245d.f11562b);
            Iterator<Integer> it = c1966b.m14251i().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                C1980o m14245d2 = c1966b.m14245d(intValue);
                if (m14245d2 == m14245d) {
                    m14345a(c1966b, intValue, m14410a);
                } else {
                    m14345a(c1966b, intValue, m14245d2);
                }
            }
        }
    }

    /* renamed from: d */
    private void m14366d(C1966b c1966b, C1980o c1980o) {
        m14349a(c1966b, c1980o);
    }

    /* renamed from: a */
    private void m14350a(C1966b c1966b, C1980o c1980o, boolean z) {
        if (z) {
            InterfaceC2229q interfaceC2229q = (InterfaceC2229q) c1966b.f11439b;
            C1980o m14245d = c1966b.m14245d(interfaceC2229q.mo14500r_());
            C1980o m14245d2 = c1966b.m14245d(interfaceC2229q.mo14504g());
            if (f11511p.get(m14245d.f11561a) && f11511p.get(m14245d2.f11561a)) {
                c1980o = C1980o.f11547i;
            }
        }
        m14349a(c1966b, c1980o);
    }

    /* renamed from: b */
    private void m14359b(C1966b c1966b, C1980o c1980o, boolean z) {
        if (z) {
            InterfaceC2230r interfaceC2230r = (InterfaceC2230r) c1966b.f11439b;
            C1980o m14245d = c1966b.m14245d(interfaceC2230r.mo14495q_());
            C1980o m14245d2 = c1966b.m14245d(interfaceC2230r.mo14500r_());
            if (f11511p.get(m14245d.f11561a) && f11511p.get(m14245d2.f11561a)) {
                c1980o = C1980o.f11547i;
            }
        }
        m14349a(c1966b, c1980o);
    }

    /* renamed from: c */
    private void m14363c(C1966b c1966b, C1980o c1980o, boolean z) {
        int mo14499f;
        if (z) {
            if (f11511p.get(c1966b.m14245d(((InterfaceC2230r) c1966b.f11439b).mo14500r_()).f11561a) && ((mo14499f = ((InterfaceC2221i) c1966b.f11439b).mo14499f()) == 0 || mo14499f == 1)) {
                c1980o = C1980o.f11547i;
            }
        }
        m14349a(c1966b, c1980o);
    }

    /* renamed from: b */
    private C1980o m14357b(C1966b c1966b, boolean z) {
        C1980o m14338a = m14338a(c1966b, ((InterfaceC2230r) c1966b.f11439b).mo14500r_(), f11507l);
        long mo14499f = ((InterfaceC2221i) c1966b.f11439b).mo14499f();
        if (mo14499f != 0) {
            C1980o c1980o = !z ? C1980o.f11553o : m14338a;
            long j = mo14499f & 31;
            switch (m14338a.f11561a) {
                case 2:
                case 3:
                case 4:
                    return C1980o.f11545g;
                case 5:
                    break;
                case 6:
                    return C1980o.f11549k;
                case 7:
                    if (z && j >= 8) {
                        return C1980o.f11548j;
                    }
                    break;
                case 8:
                    if (j >= 8) {
                        return C1980o.f11549k;
                    }
                    break;
                case 9:
                    if (j > 8) {
                        return C1980o.f11549k;
                    }
                    break;
                case 10:
                case 11:
                    if (z) {
                        if (j >= 24) {
                            return C1980o.f11548j;
                        }
                        if (j >= 16) {
                            return C1980o.f11550l;
                        }
                    } else {
                        if (j > 24) {
                            return C1980o.f11549k;
                        }
                        if (j >= 16) {
                            return C1980o.f11552n;
                        }
                    }
                    break;
                default:
                    if (!f11506a) {
                        throw new AssertionError();
                    }
                    break;
            }
            return c1980o;
        }
        return m14338a;
    }

    /* renamed from: w */
    private void m14390w(C1966b c1966b) {
        EnumC2272f enumC2272f;
        if (this.f11517g == null) {
            throw new C1960a("Cannot analyze an odexed instruction unless we are deodexing", new Object[0]);
        }
        InterfaceC2178aa interfaceC2178aa = (InterfaceC2178aa) c1966b.f11439b;
        InterfaceC2267h mo14335a = this.f11517g.mo14335a(c1966b);
        int mo14214f = mo14335a.mo14214f();
        if (EnumC1959a.STATIC.m14192a(mo14214f)) {
            enumC2272f = EnumC2272f.INVOKE_STATIC;
        } else if (EnumC1959a.PRIVATE.m14192a(mo14214f)) {
            enumC2272f = EnumC2272f.INVOKE_DIRECT;
        } else {
            enumC2272f = EnumC2272f.INVOKE_VIRTUAL;
        }
        c1966b.m14234a(new C2284aa(enumC2272f, interfaceC2178aa.mo14481e(), interfaceC2178aa.mo14483h(), interfaceC2178aa.mo14484i(), interfaceC2178aa.mo14485j(), interfaceC2178aa.mo14486k(), interfaceC2178aa.mo14487l(), mo14335a));
        m14360b(c1966b);
    }

    /* renamed from: x */
    private void m14391x(C1966b c1966b) {
        EnumC2272f enumC2272f;
        if (this.f11517g == null) {
            throw new C1960a("Cannot analyze an odexed instruction unless we are deodexing", new Object[0]);
        }
        InterfaceC2181ad interfaceC2181ad = (InterfaceC2181ad) c1966b.f11439b;
        InterfaceC2267h mo14335a = this.f11517g.mo14335a(c1966b);
        int mo14214f = mo14335a.mo14214f();
        if (EnumC1959a.STATIC.m14192a(mo14214f)) {
            enumC2272f = EnumC2272f.INVOKE_STATIC_RANGE;
        } else if (EnumC1959a.PRIVATE.m14192a(mo14214f)) {
            enumC2272f = EnumC2272f.INVOKE_DIRECT_RANGE;
        } else {
            enumC2272f = EnumC2272f.INVOKE_VIRTUAL_RANGE;
        }
        c1966b.m14234a(new C2287ad(enumC2272f, interfaceC2181ad.mo14491h(), interfaceC2181ad.mo14481e(), mo14335a));
        m14360b(c1966b);
    }

    /* renamed from: y */
    private void m14392y(C1966b c1966b) {
        m14364c(c1966b, true);
    }

    /* renamed from: c */
    private void m14364c(C1966b c1966b, boolean z) {
        InterfaceC2213z interfaceC2213z = (InterfaceC2213z) c1966b.f11439b;
        c1966b.m14234a(new C2284aa(EnumC2272f.INVOKE_DIRECT, interfaceC2213z.mo14481e(), interfaceC2213z.mo14483h(), interfaceC2213z.mo14484i(), interfaceC2213z.mo14485j(), interfaceC2213z.mo14486k(), interfaceC2213z.mo14487l(), interfaceC2213z.mo14489f()));
        if (z) {
            m14360b(c1966b);
        }
    }

    /* renamed from: z */
    private void m14393z(C1966b c1966b) {
        m14367d(c1966b, true);
    }

    /* renamed from: d */
    private void m14367d(C1966b c1966b, boolean z) {
        InterfaceC2218f c2287ad;
        InterfaceC2180ac interfaceC2180ac = (InterfaceC2180ac) c1966b.f11439b;
        int h = interfaceC2180ac.mo14491h();
        if (h < 16) {
            c2287ad = new C2284aa(EnumC2272f.INVOKE_DIRECT, 1, h, 0, 0, 0, 0, interfaceC2180ac.mo14489f());
        } else {
            c2287ad = new C2287ad(EnumC2272f.INVOKE_DIRECT_RANGE, h, 1, interfaceC2180ac.mo14489f());
        }
        c1966b.m14234a(c2287ad);
        if (z) {
            m14360b(c1966b);
        }
    }

    /* renamed from: A */
    private boolean m14336A(C1966b c1966b) {
        InterfaceC2237b interfaceC2237b;
        InterfaceC2203p interfaceC2203p = (InterfaceC2203p) c1966b.f11439b;
        int g = interfaceC2203p.mo14503g();
        C1980o m14338a = m14338a(c1966b, interfaceC2203p.mo14500r_(), f11510o);
        if (m14338a.f11561a == 2) {
            return false;
        }
        InterfaceC1981p interfaceC1981p = m14338a.f11562b;
        if (!f11506a && interfaceC1981p == null) {
            throw new AssertionError();
        }
        InterfaceC2237b mo14263a = this.f11516f.m14273a((CharSequence) interfaceC1981p.mo14265b()).mo14263a(g);
        if (mo14263a == null) {
            throw new C1960a("Could not resolve the field in class %s at offset %d", m14338a.f11562b.mo14265b(), Integer.valueOf(g));
        }
        InterfaceC2244d m14274a = this.f11516f.m14274a(this.f11512b.mo14209a());
        if (C2392l.m15147a(m14274a.mo14205l(), this.f11516f.m14274a(mo14263a.mo14225d()))) {
            interfaceC2237b = mo14263a;
        } else {
            InterfaceC2244d m14274a2 = this.f11516f.m14274a(interfaceC1981p.mo14265b());
            while (!C2392l.m15147a(m14274a.mo14205l(), m14274a2)) {
                String mo14195b = m14274a2.mo14195b();
                if (mo14195b == null) {
                    throw new C2453g("Couldn't find accessible class while resolving field %s", C2389i.m15131b(mo14263a));
                }
                m14274a2 = this.f11516f.m14274a(mo14195b);
            }
            InterfaceC2237b mo14263a2 = this.f11516f.m14273a((CharSequence) m14274a2.mo14205l()).mo14263a(g);
            if (mo14263a2 == null) {
                throw new C2453g("Couldn't find accessible class while resolving field %s", C2389i.m15131b(mo14263a));
            }
            interfaceC2237b = new C2322b(m14274a2.mo14205l(), mo14263a2.mo14226e(), mo14263a2.mo14227f());
        }
        c1966b.m14234a(new C2309p(this.f11516f.m14278d().m14404a(interfaceC2237b.mo14227f(), interfaceC2203p.mo14416a()), (byte) interfaceC2203p.mo14495q_(), (byte) interfaceC2203p.mo14500r_(), interfaceC2237b));
        m14360b(c1966b);
        return true;
    }

    /* renamed from: e */
    private boolean m14370e(C1966b c1966b, boolean z) {
        InterfaceC2240e interfaceC2240e;
        InterfaceC2218f c2284aa;
        if (this.f11514d) {
            if (z) {
                interfaceC2240e = (InterfaceC2240e) ((InterfaceC2180ac) c1966b.f11439b).mo14489f();
            } else {
                interfaceC2240e = (InterfaceC2240e) ((InterfaceC2213z) c1966b.f11439b).mo14489f();
            }
            InterfaceC2240e m14339a = m14339a(interfaceC2240e);
            if (m14339a != null && !m14339a.equals(interfaceC2240e)) {
                if (z) {
                    InterfaceC2180ac interfaceC2180ac = (InterfaceC2180ac) c1966b.f11439b;
                    c2284aa = new C2287ad(interfaceC2180ac.mo14416a(), interfaceC2180ac.mo14491h(), interfaceC2180ac.mo14481e(), m14339a);
                } else {
                    InterfaceC2213z interfaceC2213z = (InterfaceC2213z) c1966b.f11439b;
                    c2284aa = new C2284aa(interfaceC2213z.mo14416a(), interfaceC2213z.mo14481e(), interfaceC2213z.mo14483h(), interfaceC2213z.mo14484i(), interfaceC2213z.mo14485j(), interfaceC2213z.mo14486k(), interfaceC2213z.mo14487l(), m14339a);
                }
                c1966b.m14234a(c2284aa);
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m14354a(C1966b c1966b, boolean z, boolean z2) {
        int f2;
        int h;
        InterfaceC2267h mo14266b;
        InterfaceC2240e interfaceC2240e;
        InterfaceC2240e interfaceC2240e2;
        EnumC2272f enumC2272f;
        InterfaceC2218f c2284aa;
        EnumC2272f enumC2272f2;
        if (z2) {
            InterfaceC2182ae interfaceC2182ae = (InterfaceC2182ae) c1966b.f11439b;
            f2 = interfaceC2182ae.mo14488f();
            h = interfaceC2182ae.mo14491h();
        } else {
            InterfaceC2179ab interfaceC2179ab = (InterfaceC2179ab) c1966b.f11439b;
            f2 = interfaceC2179ab.mo14488f();
            h = interfaceC2179ab.mo14483h();
        }
        C1980o m14338a = m14338a(c1966b, h, f11510o);
        InterfaceC1981p interfaceC1981p = m14338a.f11562b;
        if (m14338a.f11561a == 2) {
            return false;
        }
        if (!f11506a && interfaceC1981p == null) {
            throw new AssertionError();
        }
        if (z) {
            InterfaceC1981p m14273a = this.f11516f.m14273a((CharSequence) this.f11512b.mo14209a());
            String mo14270f = m14273a.mo14270f();
            if (mo14270f != null) {
                m14273a = this.f11516f.m14273a((CharSequence) mo14270f);
            }
            mo14266b = m14273a.mo14266b(f2);
        } else {
            mo14266b = interfaceC1981p.mo14266b(f2);
        }
        if (mo14266b == null) {
            throw new C1960a("Could not resolve the method in class %s at index %d", m14338a.f11562b.mo14265b(), Integer.valueOf(f2));
        }
        InterfaceC2244d m14274a = this.f11516f.m14274a(this.f11512b.mo14209a());
        if (this.f11516f.m14273a((CharSequence) mo14266b.mo14209a()).mo14267c()) {
            interfaceC2240e = new a(mo14266b, interfaceC1981p.mo14265b());
        } else if (z || C2392l.m15147a(m14274a.mo14205l(), this.f11516f.m14274a(mo14266b.mo14209a()))) {
            interfaceC2240e = mo14266b;
        } else {
            InterfaceC2244d m14274a2 = this.f11516f.m14274a(interfaceC1981p.mo14265b());
            while (!C2392l.m15147a(m14274a.mo14205l(), m14274a2)) {
                String mo14195b = m14274a2.mo14195b();
                if (mo14195b == null) {
                    throw new C2453g("Couldn't find accessible class while resolving method %s", C2389i.m15121a((InterfaceC2240e) mo14266b, true));
                }
                m14274a2 = this.f11516f.m14274a(mo14195b);
            }
            InterfaceC2267h mo14266b2 = this.f11516f.m14273a((CharSequence) m14274a2.mo14205l()).mo14266b(f2);
            if (mo14266b2 == null) {
                throw new C2453g("Couldn't find accessible class while resolving method %s", C2389i.m15121a((InterfaceC2240e) mo14266b, true));
            }
            interfaceC2240e = new C2325e(m14274a2.mo14205l(), mo14266b2.mo14210b(), mo14266b2.mo14211c(), mo14266b2.mo14212d());
        }
        if (!this.f11514d || (interfaceC2240e2 = m14339a(interfaceC2240e)) == null) {
            interfaceC2240e2 = interfaceC2240e;
        }
        if (z2) {
            InterfaceC2182ae interfaceC2182ae2 = (InterfaceC2182ae) c1966b.f11439b;
            if (z) {
                enumC2272f2 = EnumC2272f.INVOKE_SUPER_RANGE;
            } else {
                enumC2272f2 = EnumC2272f.INVOKE_VIRTUAL_RANGE;
            }
            c2284aa = new C2287ad(enumC2272f2, interfaceC2182ae2.mo14491h(), interfaceC2182ae2.mo14481e(), interfaceC2240e2);
        } else {
            InterfaceC2179ab interfaceC2179ab2 = (InterfaceC2179ab) c1966b.f11439b;
            if (z) {
                enumC2272f = EnumC2272f.INVOKE_SUPER;
            } else {
                enumC2272f = EnumC2272f.INVOKE_VIRTUAL;
            }
            c2284aa = new C2284aa(enumC2272f, interfaceC2179ab2.mo14481e(), interfaceC2179ab2.mo14483h(), interfaceC2179ab2.mo14484i(), interfaceC2179ab2.mo14485j(), interfaceC2179ab2.mo14486k(), interfaceC2179ab2.mo14487l(), interfaceC2240e2);
        }
        c1966b.m14234a(c2284aa);
        m14360b(c1966b);
        return true;
    }

    /* renamed from: B */
    private boolean m14337B(C1966b c1966b) {
        return m14373f(c1966b, true);
    }

    /* renamed from: f */
    private boolean m14373f(C1966b c1966b, boolean z) {
        InterfaceC2218f c2309p;
        InterfaceC2237b interfaceC2237b = (InterfaceC2237b) ((InterfaceC2225m) c1966b.f11439b).mo14489f();
        String mo14227f = interfaceC2237b.mo14227f();
        EnumC2272f mo14416a = c1966b.f11439b.mo14416a();
        EnumC2272f m14404a = this.f11516f.m14278d().m14404a(mo14227f, mo14416a);
        if (mo14416a.m14884h()) {
            c2309p = new C2303j(m14404a, ((InterfaceC2223k) c1966b.f11439b).mo14495q_(), interfaceC2237b);
        } else {
            InterfaceC2230r interfaceC2230r = (InterfaceC2230r) c1966b.f11439b;
            c2309p = new C2309p(m14404a, interfaceC2230r.mo14495q_(), interfaceC2230r.mo14500r_(), interfaceC2237b);
        }
        c1966b.m14234a(c2309p);
        if (z) {
            m14360b(c1966b);
            return true;
        }
        return true;
    }

    /* renamed from: a */
    private static C1980o m14338a(C1966b c1966b, int i, BitSet bitSet) {
        if (!f11506a && (i < 0 || i >= c1966b.f11444g.length)) {
            throw new AssertionError();
        }
        C1980o m14245d = c1966b.m14245d(i);
        m14352a(m14245d, i, bitSet);
        if (bitSet == f11508m) {
            m14352a(m14245d, i, f11508m);
            m14341a(i, c1966b);
            m14352a(c1966b.m14245d(i + 1), i + 1, f11509n);
        }
        return m14245d;
    }

    /* renamed from: a */
    private static void m14352a(C1980o c1980o, int i, BitSet bitSet) {
        if (!bitSet.get(c1980o.f11561a)) {
            throw new C1960a(String.format("Invalid register type %s for register v%d.", c1980o.toString(), Integer.valueOf(i)), new Object[0]);
        }
    }

    /* renamed from: a */
    private static void m14341a(int i, C1966b c1966b) {
        if (i + 1 >= c1966b.f11444g.length) {
            throw new C1960a(String.format("v%d cannot be used as the first register in a wide registerpair because it is the last register.", Integer.valueOf(i)), new Object[0]);
        }
    }

    /* renamed from: a */
    private InterfaceC2240e m14339a(InterfaceC2240e interfaceC2240e) {
        InterfaceC2267h mo14266b;
        InterfaceC2267h interfaceC2267h = null;
        InterfaceC1981p m14273a = this.f11516f.m14273a((CharSequence) interfaceC2240e.mo14209a());
        try {
            int mo14260a = m14273a.mo14260a(interfaceC2240e);
            if (mo14260a >= 0) {
                C1972g c1972g = (C1972g) this.f11516f.m14273a((CharSequence) this.f11512b.mo14209a());
                interfaceC2267h = m14273a.mo14266b(mo14260a);
                if (!f11506a && interfaceC2267h == null) {
                    throw new AssertionError();
                }
                while (true) {
                    String mo14270f = m14273a.mo14270f();
                    if (mo14270f == null || (mo14266b = (m14273a = this.f11516f.m14273a((CharSequence) mo14270f)).mo14266b(mo14260a)) == null) {
                        break;
                    }
                    if (!mo14266b.equals(interfaceC2267h) && C1968c.m14258a(c1972g, mo14266b, false, false, true)) {
                        interfaceC2267h = mo14266b;
                    }
                }
            }
        } catch (C1983r e2) {
        }
        return interfaceC2267h;
    }

    /* compiled from: MethodAnalyzer.java */
    /* renamed from: org.d.b.a.k$a */
    private static class a extends AbstractC1991e {

        /* renamed from: a */
        private final InterfaceC2240e f11525a;

        /* renamed from: b */
        private final String f11526b;

        public a(InterfaceC2240e interfaceC2240e, String str) {
            this.f11525a = interfaceC2240e;
            this.f11526b = str;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: b */
        public String mo14210b() {
            return this.f11525a.mo14210b();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
        /* renamed from: c */
        public List<? extends CharSequence> mo14211c() {
            return this.f11525a.mo14211c();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: d */
        public String mo14212d() {
            return this.f11525a.mo14212d();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: a */
        public String mo14209a() {
            return this.f11526b;
        }
    }
}
