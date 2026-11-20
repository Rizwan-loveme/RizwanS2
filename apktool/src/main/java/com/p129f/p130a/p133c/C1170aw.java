package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.C1120o;

/* compiled from: RegularImmutableList.java */
/* renamed from: com.f.a.c.aw */
/* loaded from: classes.dex */
class C1170aw<E> extends AbstractC1208w<E> {

    /* renamed from: a */
    static final AbstractC1208w<Object> f7838a = new C1170aw(new Object[0], 0);

    /* renamed from: b */
    final transient Object[] f7839b;

    /* renamed from: c */
    private final transient int f7840c;

    C1170aw(Object[] objArr, int i) {
        this.f7839b = objArr;
        this.f7840c = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f7840c;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: f */
    boolean mo9838f() {
        return false;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: b */
    Object[] mo9987b() {
        return this.f7839b;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: c */
    int mo9988c() {
        return 0;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: d */
    int mo9989d() {
        return this.f7840c;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1208w, com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: a */
    int mo9986a(Object[] objArr, int i) {
        System.arraycopy(this.f7839b, 0, objArr, i, this.f7840c);
        return this.f7840c + i;
    }

    @Override // java.util.List
    public E get(int i) {
        C1120o.m9545a(i, this.f7840c);
        return (E) this.f7839b[i];
    }
}
