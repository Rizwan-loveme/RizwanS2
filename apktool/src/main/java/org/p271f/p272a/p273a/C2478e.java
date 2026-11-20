package org.p271f.p272a.p273a;

import org.p271f.p272a.AbstractC2473a;
import org.p271f.p272a.AbstractC2519k;
import org.p271f.p272a.C2530v;

/* compiled from: RemappingFieldAdapter.java */
/* renamed from: org.f.a.a.e */
/* loaded from: classes.dex */
public class C2478e extends AbstractC2519k {

    /* renamed from: c */
    private final AbstractC2475b f12975c;

    public C2478e(AbstractC2519k abstractC2519k, AbstractC2475b abstractC2475b) {
        this(327680, abstractC2519k, abstractC2475b);
    }

    protected C2478e(int i, AbstractC2519k abstractC2519k, AbstractC2475b abstractC2475b) {
        super(i, abstractC2519k);
        this.f12975c = abstractC2475b;
    }

    @Override // org.p271f.p272a.AbstractC2519k
    /* renamed from: a */
    public AbstractC2473a mo15673a(String str, boolean z) {
        AbstractC2473a mo15673a = this.f13161b.mo15673a(this.f12975c.m15658b(str), z);
        if (mo15673a == null) {
            return null;
        }
        return new C2476c(mo15673a, this.f12975c);
    }

    @Override // org.p271f.p272a.AbstractC2519k
    /* renamed from: a */
    public AbstractC2473a mo15672a(int i, C2530v c2530v, String str, boolean z) {
        AbstractC2473a mo15672a = super.mo15672a(i, c2530v, this.f12975c.m15658b(str), z);
        if (mo15672a == null) {
            return null;
        }
        return new C2476c(mo15672a, this.f12975c);
    }
}
