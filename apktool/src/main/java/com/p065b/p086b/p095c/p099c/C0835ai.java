package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p103f.p106c.AbstractC0951e;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import com.p065b.p086b.p110h.InterfaceC1035z;
import java.util.ArrayList;

/* compiled from: ParameterAnnotationStruct.java */
/* renamed from: com.b.b.c.c.ai */
/* loaded from: classes.dex */
public final class C0835ai implements InterfaceC1035z, Comparable<C0835ai> {

    /* renamed from: a */
    private final C0967u f5174a;

    /* renamed from: b */
    private final C0917d f5175b;

    /* renamed from: c */
    private final C0847au<C0850c> f5176c;

    public C0835ai(C0967u c0967u, C0917d c0917d) {
        if (c0967u == null) {
            throw new NullPointerException("method == null");
        }
        if (c0917d == null) {
            throw new NullPointerException("annotationsList == null");
        }
        this.f5174a = c0967u;
        this.f5175b = c0917d;
        int f_ = c0917d.m8550f_();
        ArrayList arrayList = new ArrayList(f_);
        for (int i = 0; i < f_; i++) {
            arrayList.add(new C0850c(new C0849b(c0917d.m7830a(i))));
        }
        this.f5176c = new C0847au<>(EnumC0873z.TYPE_ANNOTATION_SET_REF_LIST, arrayList);
    }

    public int hashCode() {
        return this.f5174a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0835ai) {
            return this.f5174a.equals(((C0835ai) obj).f5174a);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0835ai c0835ai) {
        return this.f5174a.compareTo(c0835ai.f5174a);
    }

    /* renamed from: a */
    public void m7242a(C0860m c0860m) {
        C0832af m7410n = c0860m.m7410n();
        C0833ag m7401e = c0860m.m7401e();
        m7410n.m7219a((AbstractC0951e) this.f5174a);
        m7401e.m7225a((AbstractC0834ah) this.f5176c);
    }

    /* renamed from: a */
    public void m7243a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        int m7223b = c0860m.m7410n().m7223b(this.f5174a);
        int f2 = this.f5176c.m7237f();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, "    " + this.f5174a.mo6681d());
            interfaceC1007a.mo8458a(4, "      method_idx:      " + C1022m.m8552a(m7223b));
            interfaceC1007a.mo8458a(4, "      annotations_off: " + C1022m.m8552a(f2));
        }
        interfaceC1007a.mo8523d(m7223b);
        interfaceC1007a.mo8523d(f2);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5174a.mo6681d());
        sb.append(": ");
        boolean z = true;
        for (C0850c c0850c : this.f5176c.m7286c()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(c0850c.mo7204b());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public C0967u m7241a() {
        return this.f5174a;
    }

    /* renamed from: b */
    public C0917d m7244b() {
        return this.f5175b;
    }
}
