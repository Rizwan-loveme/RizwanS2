package org.p226d.p227a.p228a;

import java.util.BitSet;
import java.util.Iterator;
import org.p226d.p233b.p234a.C1966b;
import org.p226d.p233b.p234a.C1976k;
import org.p226d.p233b.p234a.C1980o;
import org.p226d.p233b.p250e.p252b.InterfaceC2215c;
import org.p226d.p233b.p250e.p252b.InterfaceC2223k;
import org.p226d.p233b.p250e.p252b.InterfaceC2226n;
import org.p226d.p233b.p250e.p252b.InterfaceC2229q;
import org.p226d.p233b.p250e.p252b.InterfaceC2230r;
import org.p226d.p269d.C2457k;

/* compiled from: PreInstructionRegisterInfoMethodItem.java */
/* renamed from: org.d.a.a.n */
/* loaded from: classes.dex */
public class C1946n extends AbstractC1944l {

    /* renamed from: a */
    private final int f11346a;

    /* renamed from: b */
    private final C1976k f11347b;

    /* renamed from: c */
    private final C1948p f11348c;

    /* renamed from: d */
    private final C1966b f11349d;

    public C1946n(int i, C1976k c1976k, C1948p c1948p, C1966b c1966b, int i2) {
        super(i2);
        this.f11346a = i;
        this.f11347b = c1976k;
        this.f11348c = c1948p;
        this.f11349d = c1966b;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return 99.9d;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        BitSet bitSet;
        int m14253k = this.f11349d.m14253k();
        BitSet bitSet2 = new BitSet(m14253k);
        if ((this.f11346a & 1) != 0) {
            bitSet2.set(0, m14253k);
            bitSet = null;
        } else if ((this.f11346a & 2) != 0) {
            bitSet2.set(0, m14253k);
            bitSet = null;
        } else {
            if ((this.f11346a & 8) != 0) {
                m14164a(bitSet2);
            }
            if ((this.f11346a & 32) != 0) {
                if (this.f11349d.m14249g()) {
                    m14168b(bitSet2, m14253k);
                }
                bitSet = new BitSet(m14253k);
                m14165a(bitSet, m14253k);
            } else {
                if ((this.f11346a & 64) != 0 && this.f11349d.m14249g()) {
                    m14168b(bitSet2, m14253k);
                }
                bitSet = null;
            }
        }
        if ((this.f11346a & 64) != 0) {
            if (bitSet == null) {
                bitSet = new BitSet(m14253k);
                m14165a(bitSet, m14253k);
            }
            bitSet2.mo13226or(bitSet);
        } else if (bitSet != null) {
            bitSet2.mo13226or(bitSet);
            bitSet = null;
        }
        return m14167a(c2457k, bitSet2, bitSet);
    }

    /* renamed from: a */
    private void m14164a(BitSet bitSet) {
        if (this.f11349d.m14247e() instanceof InterfaceC2226n) {
            InterfaceC2226n interfaceC2226n = (InterfaceC2226n) this.f11349d.m14247e();
            bitSet.set(interfaceC2226n.mo14491h(), interfaceC2226n.mo14481e() + interfaceC2226n.mo14491h());
            return;
        }
        if (this.f11349d.m14247e() instanceof InterfaceC2215c) {
            InterfaceC2215c interfaceC2215c = (InterfaceC2215c) this.f11349d.m14247e();
            switch (interfaceC2215c.mo14481e()) {
                case 5:
                    bitSet.set(interfaceC2215c.mo14487l());
                case 4:
                    bitSet.set(interfaceC2215c.mo14486k());
                case 3:
                    bitSet.set(interfaceC2215c.mo14485j());
                case 2:
                    bitSet.set(interfaceC2215c.mo14484i());
                case 1:
                    bitSet.set(interfaceC2215c.mo14483h());
                    break;
            }
            return;
        }
        if (this.f11349d.m14247e() instanceof InterfaceC2229q) {
            InterfaceC2229q interfaceC2229q = (InterfaceC2229q) this.f11349d.m14247e();
            bitSet.set(interfaceC2229q.mo14495q_());
            bitSet.set(interfaceC2229q.mo14500r_());
            bitSet.set(interfaceC2229q.mo14504g());
            return;
        }
        if (this.f11349d.m14247e() instanceof InterfaceC2230r) {
            InterfaceC2230r interfaceC2230r = (InterfaceC2230r) this.f11349d.m14247e();
            bitSet.set(interfaceC2230r.mo14495q_());
            bitSet.set(interfaceC2230r.mo14500r_());
        } else if (this.f11349d.m14247e() instanceof InterfaceC2223k) {
            bitSet.set(((InterfaceC2223k) this.f11349d.m14247e()).mo14495q_());
        }
    }

    /* renamed from: a */
    private void m14165a(BitSet bitSet, int i) {
        if (this.f11349d.m14239b() > 1) {
            for (int i2 = 0; i2 < i; i2++) {
                C1980o m14245d = this.f11349d.m14245d(i2);
                Iterator<C1966b> it = this.f11349d.m14243c().iterator();
                while (it.hasNext()) {
                    C1980o mo14233a = this.f11349d.mo14233a(it.next(), i2);
                    if (mo14233a.f11561a != 0 && !mo14233a.equals(m14245d)) {
                        bitSet.set(i2);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m14168b(BitSet bitSet, int i) {
        bitSet.set(i - this.f11347b.m14398d(), i);
    }

    /* renamed from: a */
    private void m14166a(C2457k c2457k, int i) {
        this.f11348c.m14172a(c2457k, i);
        c2457k.write(61);
        this.f11349d.m14245d(i).m14415a(c2457k);
        c2457k.write(":merge{");
        boolean z = true;
        Iterator<C1966b> it = this.f11349d.m14243c().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                C1966b next = it.next();
                C1980o mo14233a = this.f11349d.mo14233a(next, i);
                if (!z2) {
                    c2457k.write(44);
                }
                if (next.m14231a() == -1) {
                    c2457k.write("Start:");
                } else {
                    c2457k.write("0x");
                    c2457k.m15533a(this.f11347b.m14394a(next));
                    c2457k.write(58);
                }
                mo14233a.m14415a(c2457k);
                z = false;
            } else {
                c2457k.write(125);
                return;
            }
        }
    }

    /* renamed from: a */
    private boolean m14167a(C2457k c2457k, BitSet bitSet, BitSet bitSet2) {
        int nextSetBit = bitSet.nextSetBit(0);
        if (nextSetBit < 0) {
            return false;
        }
        c2457k.write(35);
        int i = nextSetBit;
        boolean z = false;
        boolean z2 = true;
        while (i >= 0) {
            if (bitSet2 != null && bitSet2.get(i)) {
                if (!z2) {
                    c2457k.write(10);
                    c2457k.write(35);
                }
                m14166a(c2457k, i);
                z = true;
            } else {
                if (z) {
                    c2457k.write(10);
                    c2457k.write(35);
                    z = false;
                }
                C1980o m14245d = this.f11349d.m14245d(i);
                this.f11348c.m14172a(c2457k, i);
                c2457k.write(61);
                m14245d.m14415a(c2457k);
                c2457k.write(59);
            }
            i = bitSet.nextSetBit(i + 1);
            z2 = false;
        }
        return true;
    }
}
