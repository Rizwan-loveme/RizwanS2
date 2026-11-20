package org.p210a.p211a.p212a;

import org.p210a.p211a.p212a.p215c.C1840j;

/* compiled from: RecognitionException.java */
/* renamed from: org.a.a.a.x */
/* loaded from: classes.dex */
public class C1876x extends RuntimeException {

    /* renamed from: a */
    private final AbstractC1877y<?, ?> f11004a;

    /* renamed from: b */
    private final C1878z f11005b;

    /* renamed from: c */
    private final InterfaceC1869q f11006c;

    /* renamed from: d */
    private InterfaceC1819ac f11007d;

    /* renamed from: e */
    private int f11008e;

    public C1876x(AbstractC1877y<?, ?> abstractC1877y, InterfaceC1869q interfaceC1869q, C1874v c1874v) {
        this.f11008e = -1;
        this.f11004a = abstractC1877y;
        this.f11006c = interfaceC1869q;
        this.f11005b = c1874v;
        if (abstractC1877y != null) {
            this.f11008e = abstractC1877y.m13930cG();
        }
    }

    public C1876x(String str, AbstractC1877y<?, ?> abstractC1877y, InterfaceC1869q interfaceC1869q, C1874v c1874v) {
        super(str);
        this.f11008e = -1;
        this.f11004a = abstractC1877y;
        this.f11006c = interfaceC1869q;
        this.f11005b = c1874v;
        if (abstractC1877y != null) {
            this.f11008e = abstractC1877y.m13930cG();
        }
    }

    /* renamed from: a */
    protected final void m13921a(int i) {
        this.f11008e = i;
    }

    /* renamed from: c */
    public C1840j m13923c() {
        if (this.f11004a != null) {
            return this.f11004a.mo4049d().m13484a(this.f11008e, this.f11005b);
        }
        return null;
    }

    /* renamed from: b */
    public InterfaceC1869q mo13876b() {
        return this.f11006c;
    }

    /* renamed from: d */
    public InterfaceC1819ac m13924d() {
        return this.f11007d;
    }

    /* renamed from: a */
    protected final void m13922a(InterfaceC1819ac interfaceC1819ac) {
        this.f11007d = interfaceC1819ac;
    }
}
