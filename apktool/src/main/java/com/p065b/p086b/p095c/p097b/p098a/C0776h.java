package com.p065b.p086b.p095c.p097b.p098a;

import com.p065b.p086b.p095c.p097b.AbstractC0807i;
import com.p065b.p086b.p095c.p097b.AbstractC0813o;
import com.p065b.p086b.p095c.p097b.C0805g;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0964r;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.BitSet;

/* compiled from: Form21h.java */
/* renamed from: com.b.b.c.b.a.h */
/* loaded from: classes.dex */
public final class C0776h extends AbstractC0813o {

    /* renamed from: b */
    public static final AbstractC0813o f4746b = new C0776h();

    private C0776h() {
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public String mo6970a(AbstractC0807i abstractC0807i) {
        return abstractC0807i.m7043j().m7949b(0).m7937m() + ", " + m7069a((AbstractC0964r) ((C0805g) abstractC0807i).m7018c());
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public String mo6973b(AbstractC0807i abstractC0807i, boolean z) {
        return m7070a((AbstractC0964r) ((C0805g) abstractC0807i).m7018c(), abstractC0807i.m7043j().m7949b(0).m7935k() == 1 ? 32 : 64);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public int mo6969a() {
        return 2;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public boolean mo6974b(AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        if (!(abstractC0807i instanceof C0805g) || m7043j.m8550f_() != 1 || !m7090d(m7043j.m7949b(0).m7931g())) {
            return false;
        }
        AbstractC0945a m7018c = ((C0805g) abstractC0807i).m7018c();
        if (!(m7018c instanceof AbstractC0964r)) {
            return false;
        }
        AbstractC0964r abstractC0964r = (AbstractC0964r) m7018c;
        if (m7043j.m7949b(0).m7935k() == 1) {
            return (abstractC0964r.mo8064j() & 65535) == 0;
        }
        return (abstractC0964r.mo8065k() & 281474976710655L) == 0;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: c */
    public BitSet mo6975c(AbstractC0807i abstractC0807i) {
        C0935q m7043j = abstractC0807i.m7043j();
        BitSet bitSet = new BitSet(1);
        bitSet.set(0, m7090d(m7043j.m7949b(0).m7931g()));
        return bitSet;
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public void mo6971a(InterfaceC1007a interfaceC1007a, AbstractC0807i abstractC0807i) {
        short mo8065k;
        C0935q m7043j = abstractC0807i.m7043j();
        AbstractC0964r abstractC0964r = (AbstractC0964r) ((C0805g) abstractC0807i).m7018c();
        if (m7043j.m7949b(0).m7935k() == 1) {
            mo8065k = (short) (abstractC0964r.mo8064j() >>> 16);
        } else {
            mo8065k = (short) (abstractC0964r.mo8065k() >>> 48);
        }
        m7079a(interfaceC1007a, m7073a(abstractC0807i, m7043j.m7949b(0).m7931g()), mo8065k);
    }
}
