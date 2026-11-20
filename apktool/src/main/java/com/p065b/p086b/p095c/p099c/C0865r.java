package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import com.p065b.p086b.p110h.InterfaceC1035z;

/* compiled from: FieldAnnotationStruct.java */
/* renamed from: com.b.b.c.c.r */
/* loaded from: classes.dex */
public final class C0865r implements InterfaceC1035z, Comparable<C0865r> {

    /* renamed from: a */
    private final C0957k f5294a;

    /* renamed from: b */
    private C0849b f5295b;

    public C0865r(C0957k c0957k, C0849b c0849b) {
        if (c0957k == null) {
            throw new NullPointerException("field == null");
        }
        if (c0849b == null) {
            throw new NullPointerException("annotations == null");
        }
        this.f5294a = c0957k;
        this.f5295b = c0849b;
    }

    public int hashCode() {
        return this.f5294a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0865r) {
            return this.f5294a.equals(((C0865r) obj).f5294a);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0865r c0865r) {
        return this.f5294a.compareTo(c0865r.f5294a);
    }

    /* renamed from: a */
    public void m7426a(C0860m c0860m) {
        C0867t m7409m = c0860m.m7409m();
        C0833ag m7401e = c0860m.m7401e();
        m7409m.m7429a(this.f5294a);
        this.f5295b = (C0849b) m7401e.m7228b((C0833ag) this.f5295b);
    }

    /* renamed from: a */
    public void m7427a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int m7432b = c0860m.m7409m().m7432b(this.f5294a);
        int f2 = this.f5295b.m7237f();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, "    " + this.f5294a.mo6681d());
            interfaceC1007a.mo8458a(4, "      field_idx:       " + C1022m.m8552a(m7432b));
            interfaceC1007a.mo8458a(4, "      annotations_off: " + C1022m.m8552a(f2));
        }
        interfaceC1007a.mo8523d(m7432b);
        interfaceC1007a.mo8523d(f2);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f5294a.mo6681d() + ": " + this.f5295b;
    }
}
