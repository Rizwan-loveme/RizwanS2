package org.p271f.p272a.p273a;

import org.p271f.p272a.AbstractC2473a;
import org.p271f.p272a.AbstractC2515g;
import org.p271f.p272a.AbstractC2519k;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2530v;

/* compiled from: RemappingClassAdapter.java */
/* renamed from: org.f.a.a.d */
/* loaded from: classes.dex */
public class C2477d extends AbstractC2515g {

    /* renamed from: c */
    protected final AbstractC2475b f12973c;

    /* renamed from: d */
    protected String f12974d;

    public C2477d(AbstractC2515g abstractC2515g, AbstractC2475b abstractC2475b) {
        this(327680, abstractC2515g, abstractC2475b);
    }

    protected C2477d(int i, AbstractC2515g abstractC2515g, AbstractC2475b abstractC2475b) {
        super(i, abstractC2515g);
        this.f12973c = abstractC2475b;
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public void mo15669a(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.f12974d = str;
        super.mo15669a(i, i2, this.f12973c.mo10335a(str), this.f12973c.m15655a(str2, false), this.f12973c.mo10335a(str3), strArr == null ? null : this.f12973c.m15657a(strArr));
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public AbstractC2473a mo15663a(String str, boolean z) {
        AbstractC2473a mo15663a = super.mo15663a(this.f12973c.m15658b(str), z);
        if (mo15663a == null) {
            return null;
        }
        return m15664a(mo15663a);
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public AbstractC2473a mo15662a(int i, C2530v c2530v, String str, boolean z) {
        AbstractC2473a mo15662a = super.mo15662a(i, c2530v, this.f12973c.m15658b(str), z);
        if (mo15662a == null) {
            return null;
        }
        return m15664a(mo15662a);
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public AbstractC2519k mo15665a(int i, String str, String str2, String str3, Object obj) {
        AbstractC2519k mo15665a = super.mo15665a(i, this.f12973c.m15659b(this.f12974d, str, str2), this.f12973c.m15658b(str2), this.f12973c.m15655a(str3, true), this.f12973c.m15652a(obj));
        if (mo15665a == null) {
            return null;
        }
        return m15666a(mo15665a);
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public AbstractC2526r mo15667a(int i, String str, String str2, String str3, String[] strArr) {
        String m15660c = this.f12973c.m15660c(str2);
        AbstractC2526r mo15667a = super.mo15667a(i, this.f12973c.m15654a(this.f12974d, str, str2), m15660c, this.f12973c.m15655a(str3, false), strArr == null ? null : this.f12973c.m15657a(strArr));
        if (mo15667a == null) {
            return null;
        }
        return m15668a(i, m15660c, mo15667a);
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public void mo15671a(String str, String str2, String str3, int i) {
        super.mo15671a(this.f12973c.mo10335a(str), str2 == null ? null : this.f12973c.mo10335a(str2), str3, i);
    }

    @Override // org.p271f.p272a.AbstractC2515g
    /* renamed from: a */
    public void mo15670a(String str, String str2, String str3) {
        super.mo15670a(this.f12973c.mo10335a(str), str2 == null ? null : this.f12973c.m15654a(str, str2, str3), str3 != null ? this.f12973c.m15660c(str3) : null);
    }

    /* renamed from: a */
    protected AbstractC2519k m15666a(AbstractC2519k abstractC2519k) {
        return new C2478e(abstractC2519k, this.f12973c);
    }

    /* renamed from: a */
    protected AbstractC2526r m15668a(int i, String str, AbstractC2526r abstractC2526r) {
        return new C2479f(i, str, abstractC2526r, this.f12973c);
    }

    /* renamed from: a */
    protected AbstractC2473a m15664a(AbstractC2473a abstractC2473a) {
        return new C2476c(abstractC2473a, this.f12973c);
    }
}
