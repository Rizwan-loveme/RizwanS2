package com.p065b.p086b.p103f.p106c;

import com.p065b.p086b.p110h.InterfaceC1035z;

/* compiled from: Constant.java */
/* renamed from: com.b.b.f.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC0945a implements InterfaceC1035z, Comparable<AbstractC0945a> {
    /* renamed from: b */
    protected abstract int mo8034b(AbstractC0945a abstractC0945a);

    /* renamed from: g */
    public abstract boolean mo8035g();

    /* renamed from: h */
    public abstract String mo8036h();

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC0945a abstractC0945a) {
        Class<?> cls = getClass();
        Class<?> cls2 = abstractC0945a.getClass();
        return cls != cls2 ? cls.getName().compareTo(cls2.getName()) : mo8034b(abstractC0945a);
    }
}
