package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.C0957k;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1029t;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: EncodedField.java */
/* renamed from: com.b.b.c.c.o */
/* loaded from: classes.dex */
public final class C0862o extends AbstractC0863p implements Comparable<C0862o> {

    /* renamed from: a */
    private final C0957k f5290a;

    public C0862o(C0957k c0957k, int i) {
        super(i);
        if (c0957k == null) {
            throw new NullPointerException("field == null");
        }
        this.f5290a = c0957k;
    }

    public int hashCode() {
        return this.f5290a.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0862o) && compareTo((C0862o) obj) == 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0862o c0862o) {
        return this.f5290a.compareTo(c0862o.f5290a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(getClass().getName());
        stringBuffer.append('{');
        stringBuffer.append(C1022m.m8557c(m7419b()));
        stringBuffer.append(' ');
        stringBuffer.append(this.f5290a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void m7418a(C0860m c0860m) {
        c0860m.m7409m().m7429a(this.f5290a);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return this.f5290a.mo6681d();
    }

    /* renamed from: a */
    public C0957k m7417a() {
        return this.f5290a;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0863p
    /* renamed from: a */
    public int mo7415a(C0860m c0860m, InterfaceC1007a interfaceC1007a, int i, int i2) {
        int m7432b = c0860m.m7409m().m7432b(this.f5290a);
        int i3 = m7432b - i;
        int b2 = m7419b();
        if (interfaceC1007a.mo8460a()) {
            interfaceC1007a.mo8458a(0, String.format("  [%x] %s", Integer.valueOf(i2), this.f5290a.mo6681d()));
            interfaceC1007a.mo8458a(C1029t.m8588a(i3), "    field_idx:    " + C1022m.m8552a(m7432b));
            interfaceC1007a.mo8458a(C1029t.m8588a(b2), "    access_flags: " + C0919a.m7838c(b2));
        }
        interfaceC1007a.mo8524e(i3);
        interfaceC1007a.mo8524e(b2);
        return m7432b;
    }
}
