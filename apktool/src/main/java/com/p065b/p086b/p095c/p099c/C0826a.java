package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p103f.p104a.C0914a;
import com.p065b.p086b.p103f.p104a.C0918e;
import com.p065b.p086b.p103f.p104a.EnumC0915b;
import com.p065b.p086b.p110h.C1014e;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: AnnotationItem.java */
/* renamed from: com.b.b.c.c.a */
/* loaded from: classes.dex */
public final class C0826a extends AbstractC0834ah {

    /* renamed from: a */
    private static final a f5146a = new a();

    /* renamed from: b */
    private final C0914a f5147b;

    /* renamed from: c */
    private C0843aq f5148c;

    /* renamed from: d */
    private byte[] f5149d;

    /* compiled from: AnnotationItem.java */
    /* renamed from: com.b.b.c.c.a$a */
    private static class a implements Comparator<C0826a> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0826a c0826a, C0826a c0826a2) {
            int i = c0826a.f5148c.m7436i();
            int i2 = c0826a2.f5148c.m7436i();
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            return 0;
        }
    }

    /* renamed from: a */
    public static void m7197a(C0826a[] c0826aArr) {
        Arrays.sort(c0826aArr, f5146a);
    }

    public C0826a(C0914a c0914a) {
        super(1, -1);
        if (c0914a == null) {
            throw new NullPointerException("annotation == null");
        }
        this.f5147b = c0914a;
        this.f5148c = null;
        this.f5149d = null;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public EnumC0873z mo7199a() {
        return EnumC0873z.TYPE_ANNOTATION_ITEM;
    }

    public int hashCode() {
        return this.f5147b.hashCode();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected int mo7198a(AbstractC0834ah abstractC0834ah) {
        return this.f5147b.compareTo(((C0826a) abstractC0834ah).f5147b);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: b */
    public String mo7204b() {
        return this.f5147b.mo6681d();
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public void mo7201a(C0860m c0860m) {
        this.f5148c = c0860m.m7407k().m7276a(this.f5147b.m7818b());
        C0848av.m7288a(c0860m, this.f5147b);
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
        C1014e c1014e = new C1014e();
        new C0848av(abstractC0838al.m7255e(), c1014e).m7294a(this.f5147b, false);
        this.f5149d = c1014e.m8527f();
        m7234a(this.f5149d.length + 1);
    }

    /* renamed from: a */
    public void m7202a(InterfaceC1007a interfaceC1007a, String str) {
        interfaceC1007a.mo8458a(0, str + "visibility: " + this.f5147b.m7820e().mo6681d());
        interfaceC1007a.mo8458a(0, str + "type: " + this.f5147b.m7818b().mo6681d());
        for (C0918e c0918e : this.f5147b.m7821f()) {
            interfaceC1007a.mo8458a(0, str + c0918e.m7833a().mo6681d() + ": " + C0848av.m7290b(c0918e.m7834b()));
        }
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0834ah
    /* renamed from: a_ */
    protected void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        boolean mo8460a = interfaceC1007a.mo8460a();
        EnumC0915b m7820e = this.f5147b.m7820e();
        if (mo8460a) {
            interfaceC1007a.mo8458a(0, m7239h() + " annotation");
            interfaceC1007a.mo8458a(1, "  visibility: VISBILITY_" + m7820e);
        }
        switch (m7820e) {
            case BUILD:
                interfaceC1007a.mo7631c(0);
                break;
            case RUNTIME:
                interfaceC1007a.mo7631c(1);
                break;
            case SYSTEM:
                interfaceC1007a.mo7631c(2);
                break;
            default:
                throw new RuntimeException("shouldn't happen");
        }
        if (mo8460a) {
            new C0848av(c0860m, interfaceC1007a).m7294a(this.f5147b, true);
        } else {
            interfaceC1007a.mo8520a(this.f5149d);
        }
    }
}
