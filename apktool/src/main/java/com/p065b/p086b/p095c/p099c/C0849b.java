package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0914a;
import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Iterator;

/* compiled from: AnnotationSetItem.java */
/* renamed from: com.b.b.c.c.b */
/* loaded from: classes.dex */
public final class C0849b extends AbstractC0834ah {

    /* renamed from: a */
    private final C0916c f5202a;

    /* renamed from: b */
    private final C0826a[] f5203b;

    public C0849b(C0916c c0916c) {
        super(4, m7297a(c0916c));
        this.f5202a = c0916c;
        this.f5203b = new C0826a[c0916c.m7826b()];
        int i = 0;
        Iterator<C0914a> it = c0916c.m7828d().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                this.f5203b[i2] = new C0826a(it.next());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static int m7297a(C0916c c0916c) {
        try {
            return (c0916c.m7826b() * 4) + 4;
        } catch (NullPointerException e2) {
            throw new NullPointerException("list == null");
        }
    }

    /* renamed from: c */
    public C0916c m7298c() {
        return this.f5202a;
    }

    public int hashCode() {
        return this.f5202a.hashCode();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected int mo7198a(AbstractC0834ah abstractC0834ah) {
        return this.f5202a.compareTo(((C0849b) abstractC0834ah).f5202a);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_ANNOTATION_SET_ITEM;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        return this.f5202a.toString();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        C0833ag m7411o = c0860m.m7411o();
        int length = this.f5203b.length;
        for (int i = 0; i < length; i++) {
            this.f5203b[i] = (C0826a) m7411o.m7228b((C0833ag) this.f5203b[i]);
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        C0826a.m7197a(this.f5203b);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        boolean mo8460a = interfaceC1007a.mo8460a();
        int length = this.f5203b.length;
        if (mo8460a) {
            interfaceC1007a.mo8458a(0, m7239h() + " annotation set");
            interfaceC1007a.mo8458a(4, "  size: " + C1022m.m8552a(length));
        }
        interfaceC1007a.mo8523d(length);
        for (int i = 0; i < length; i++) {
            int f2 = this.f5203b[i].m7237f();
            if (mo8460a) {
                interfaceC1007a.mo8458a(4, "  entries[" + Integer.toHexString(i) + "]: " + C1022m.m8552a(f2));
                this.f5203b[i].m7202a(interfaceC1007a, "    ");
            }
            interfaceC1007a.mo8523d(f2);
        }
    }
}
