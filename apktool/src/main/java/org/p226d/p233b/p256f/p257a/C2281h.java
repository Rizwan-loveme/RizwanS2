package org.p226d.p233b.p256f.p257a;

import org.p226d.p233b.p238b.p239a.AbstractC1992f;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: ImmutableStartLocal.java */
/* renamed from: org.d.b.f.a.h */
/* loaded from: classes.dex */
public class C2281h extends AbstractC2274a implements InterfaceC2174i {

    /* renamed from: b */
    protected final int f12409b;

    /* renamed from: c */
    protected final String f12410c;

    /* renamed from: d */
    protected final String f12411d;

    /* renamed from: e */
    protected final String f12412e;

    public C2281h(int i, int i2, String str, String str2, String str3) {
        super(i);
        this.f12409b = i2;
        this.f12410c = str;
        this.f12411d = str2;
        this.f12412e = str3;
    }

    /* renamed from: a */
    public static C2281h m14899a(InterfaceC2174i interfaceC2174i) {
        if (interfaceC2174i instanceof C2281h) {
            return (C2281h) interfaceC2174i;
        }
        return new C2281h(interfaceC2174i.mo14461a(), interfaceC2174i.mo14470e(), interfaceC2174i.mo14220b(), interfaceC2174i.mo14465l(), interfaceC2174i.mo14452c());
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: e */
    public int mo14470e() {
        return this.f12409b;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: g */
    public InterfaceC2242g mo14471g() {
        if (this.f12410c == null) {
            return null;
        }
        return new AbstractC1992f() { // from class: org.d.b.f.a.h.1
            @Override // org.p226d.p233b.p250e.p254c.InterfaceC2242g
            /* renamed from: a */
            public String mo14691a() {
                return C2281h.this.f12410c;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: h */
    public InterfaceC2243h mo14472h() {
        if (this.f12411d == null) {
            return null;
        }
        return new AbstractC1993g() { // from class: org.d.b.f.a.h.2
            @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
            /* renamed from: l */
            public String mo14205l() {
                return C2281h.this.f12411d;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
    /* renamed from: i */
    public InterfaceC2242g mo14473i() {
        if (this.f12412e == null) {
            return null;
        }
        return new AbstractC1992f() { // from class: org.d.b.f.a.h.3
            @Override // org.p226d.p233b.p250e.p254c.InterfaceC2242g
            /* renamed from: a */
            public String mo14691a() {
                return C2281h.this.f12412e;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: b */
    public String mo14220b() {
        return this.f12410c;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: l */
    public String mo14465l() {
        return this.f12411d;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
    /* renamed from: c */
    public String mo14452c() {
        return this.f12412e;
    }

    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
    /* renamed from: f */
    public int mo14464f() {
        return 3;
    }
}
