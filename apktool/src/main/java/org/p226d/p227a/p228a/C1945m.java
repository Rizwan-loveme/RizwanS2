package org.p226d.p227a.p228a;

import java.util.BitSet;
import org.p226d.p233b.p234a.C1966b;
import org.p226d.p233b.p234a.C1980o;
import org.p226d.p269d.C2457k;

/* compiled from: PostInstructionRegisterInfoMethodItem.java */
/* renamed from: org.d.a.a.m */
/* loaded from: classes.dex */
public class C1945m extends AbstractC1944l {

    /* renamed from: a */
    private final C1948p f11344a;

    /* renamed from: b */
    private final C1966b f11345b;

    public C1945m(C1948p c1948p, C1966b c1966b, int i) {
        super(i);
        this.f11344a = c1948p;
        this.f11345b = c1966b;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return 100.1d;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public boolean mo14089a(C2457k c2457k) {
        int i = this.f11344a.f11351a.f11366l;
        int m14253k = this.f11345b.m14253k();
        BitSet bitSet = new BitSet(m14253k);
        if ((i & 1) != 0) {
            bitSet.set(0, m14253k);
        } else if ((i & 4) != 0) {
            bitSet.set(0, m14253k);
        } else if ((i & 16) != 0) {
            m14162a(bitSet, m14253k);
        }
        return m14163a(c2457k, bitSet);
    }

    /* renamed from: a */
    private void m14162a(BitSet bitSet, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!this.f11345b.m14245d(i2).equals(this.f11345b.m14244c(i2))) {
                bitSet.set(i2);
            }
        }
    }

    /* renamed from: a */
    private boolean m14163a(C2457k c2457k, BitSet bitSet) {
        int nextSetBit = bitSet.nextSetBit(0);
        if (nextSetBit < 0) {
            return false;
        }
        c2457k.write(35);
        int i = nextSetBit;
        while (i >= 0) {
            C1980o m14244c = this.f11345b.m14244c(i);
            this.f11344a.m14172a(c2457k, i);
            c2457k.write(61);
            m14244c.m14415a(c2457k);
            c2457k.write(59);
            i = bitSet.nextSetBit(i + 1);
        }
        return true;
    }
}
