package org.p271f.p272a.p273a;

import org.p271f.p272a.AbstractC2473a;

/* compiled from: RemappingAnnotationAdapter.java */
/* renamed from: org.f.a.a.c */
/* loaded from: classes.dex */
public class C2476c extends AbstractC2473a {

    /* renamed from: c */
    protected final AbstractC2475b f12972c;

    public C2476c(AbstractC2473a abstractC2473a, AbstractC2475b abstractC2475b) {
        this(327680, abstractC2473a, abstractC2475b);
    }

    protected C2476c(int i, AbstractC2473a abstractC2473a, AbstractC2475b abstractC2475b) {
        super(i, abstractC2473a);
        this.f12972c = abstractC2475b;
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15638a(String str, Object obj) {
        this.f12965b.mo15638a(str, this.f12972c.m15652a(obj));
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public void mo15639a(String str, String str2, String str3) {
        this.f12965b.mo15639a(str, this.f12972c.m15658b(str2), str3);
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public AbstractC2473a mo15636a(String str, String str2) {
        AbstractC2473a mo15636a = this.f12965b.mo15636a(str, this.f12972c.m15658b(str2));
        if (mo15636a == null) {
            return null;
        }
        return mo15636a != this.f12965b ? new C2476c(mo15636a, this.f12972c) : this;
    }

    @Override // org.p271f.p272a.AbstractC2473a
    /* renamed from: a */
    public AbstractC2473a mo15635a(String str) {
        AbstractC2473a mo15635a = this.f12965b.mo15635a(str);
        if (mo15635a == null) {
            return null;
        }
        return mo15635a != this.f12965b ? new C2476c(mo15635a, this.f12972c) : this;
    }
}
