package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p103f.p106c.AbstractC0951e;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import com.p065b.p086b.p110h.InterfaceC1035z;

/* compiled from: MethodAnnotationStruct.java */
/* renamed from: com.b.b.c.c.ad */
/* loaded from: classes.dex */
public final class C0830ad implements InterfaceC1035z, Comparable<C0830ad> {

    /* renamed from: a */
    private final C0967u f5157a;

    /* renamed from: b */
    private C0849b f5158b;

    public C0830ad(C0967u c0967u, C0849b c0849b) {
        if (c0967u == null) {
            throw new NullPointerException("method == null");
        }
        if (c0849b == null) {
            throw new NullPointerException("annotations == null");
        }
        this.f5157a = c0967u;
        this.f5158b = c0849b;
    }

    public int hashCode() {
        return this.f5157a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0830ad) {
            return this.f5157a.equals(((C0830ad) obj).f5157a);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0830ad c0830ad) {
        return this.f5157a.compareTo(c0830ad.f5157a);
    }

    /* renamed from: a */
    public void m7215a(C0860m c0860m) {
        C0832af m7410n = c0860m.m7410n();
        C0833ag m7401e = c0860m.m7401e();
        m7410n.m7219a((AbstractC0951e) this.f5157a);
        this.f5158b = (C0849b) m7401e.m7228b((C0833ag) this.f5158b);
    }

    /* renamed from: a */
    public void m7216a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int m7223b = c0860m.m7410n().m7223b(this.f5157a);
        int f2 = this.f5158b.m7237f();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, "    " + this.f5157a.mo6681d());
            interfaceC1007a.mo8458a(4, "      method_idx:      " + C1022m.m8552a(m7223b));
            interfaceC1007a.mo8458a(4, "      annotations_off: " + C1022m.m8552a(f2));
        }
        interfaceC1007a.mo8523d(m7223b);
        interfaceC1007a.mo8523d(f2);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f5157a.mo6681d() + ": " + this.f5158b;
    }

    /* renamed from: a */
    public C0967u m7214a() {
        return this.f5157a;
    }

    /* renamed from: b */
    public C0916c m7217b() {
        return this.f5158b.m7298c();
    }
}
