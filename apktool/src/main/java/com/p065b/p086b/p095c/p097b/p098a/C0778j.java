package com.p065b.p086b.p095c.p097b.p098a;

import com.p065b.p086b.p095c.p097b.AbstractC0807i;
import com.p065b.p086b.p095c.p097b.AbstractC0813o;
import com.p065b.p086b.p095c.p097b.C0797ac;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.BitSet;

/* compiled from: Form21t.java */
/* renamed from: com.b.b.c.b.a.j */
/* loaded from: classes.dex */
public final class C0778j extends AbstractC0813o {

    /* renamed from: b */
    public static final AbstractC0813o f4748b = new C0778j();

    private C0778j() {
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public String mo6970a(AbstractC0807i abstractC0807i) {
        return abstractC0807i.m7043j().m7949b(0).m7937m() + ", " + m7089d(abstractC0807i);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: b */
    public String mo6973b(AbstractC0807i abstractC0807i, boolean z) {
        return m7091e(abstractC0807i);
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
        if (!(abstractC0807i instanceof C0797ac) || m7043j.m8550f_() != 1 || !m7090d(m7043j.m7949b(0).m7931g())) {
            return false;
        }
        C0797ac c0797ac = (C0797ac) abstractC0807i;
        if (c0797ac.m6994o()) {
            return mo6972a(c0797ac);
        }
        return true;
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
    public boolean mo6972a(C0797ac c0797ac) {
        int m6993e = c0797ac.m6993e();
        return m6993e != 0 && m7092e(m6993e);
    }

    @Override // com.p065b.p086b.p095c.p097b.AbstractC0813o
    /* renamed from: a */
    public void mo6971a(InterfaceC1007a interfaceC1007a, AbstractC0807i abstractC0807i) {
        m7079a(interfaceC1007a, m7073a(abstractC0807i, abstractC0807i.m7043j().m7949b(0).m7931g()), (short) ((C0797ac) abstractC0807i).m6993e());
    }
}
