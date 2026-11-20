package org.p271f.p272a.p275c;

import org.p271f.p272a.AbstractC2526r;

/* compiled from: InsnList.java */
/* renamed from: org.f.a.c.g */
/* loaded from: classes.dex */
public class C2492g {

    /* renamed from: a */
    AbstractC2486a[] f13014a;

    /* renamed from: b */
    private int f13015b;

    /* renamed from: c */
    private AbstractC2486a f13016c;

    /* renamed from: d */
    private AbstractC2486a f13017d;

    /* renamed from: a */
    public int m15727a() {
        return this.f13015b;
    }

    /* renamed from: b */
    public AbstractC2486a m15731b() {
        return this.f13017d;
    }

    /* renamed from: a */
    public void m15729a(AbstractC2526r abstractC2526r) {
        for (AbstractC2486a abstractC2486a = this.f13016c; abstractC2486a != null; abstractC2486a = abstractC2486a.f12998e) {
            abstractC2486a.mo15719a(abstractC2526r);
        }
    }

    /* renamed from: a */
    public void m15728a(AbstractC2486a abstractC2486a) {
        this.f13015b++;
        if (this.f13017d == null) {
            this.f13016c = abstractC2486a;
            this.f13017d = abstractC2486a;
        } else {
            this.f13017d.f12998e = abstractC2486a;
            abstractC2486a.f12997d = this.f13017d;
        }
        this.f13017d = abstractC2486a;
        this.f13014a = null;
        abstractC2486a.f12999f = 0;
    }

    /* renamed from: a */
    void m15730a(boolean z) {
        if (z) {
            AbstractC2486a abstractC2486a = this.f13016c;
            while (abstractC2486a != null) {
                AbstractC2486a abstractC2486a2 = abstractC2486a.f12998e;
                abstractC2486a.f12999f = -1;
                abstractC2486a.f12997d = null;
                abstractC2486a.f12998e = null;
                abstractC2486a = abstractC2486a2;
            }
        }
        this.f13015b = 0;
        this.f13016c = null;
        this.f13017d = null;
        this.f13014a = null;
    }

    /* renamed from: c */
    public void m15732c() {
        m15730a(false);
    }

    /* renamed from: d */
    public void m15733d() {
        for (AbstractC2486a abstractC2486a = this.f13016c; abstractC2486a != null; abstractC2486a = abstractC2486a.f12998e) {
            if (abstractC2486a instanceof C2497l) {
                ((C2497l) abstractC2486a).m15735d();
            }
        }
    }
}
