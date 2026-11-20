package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.concurrent.LazyInit;
import com.p129f.p130a.p131a.C1120o;

/* compiled from: SingletonImmutableSet.java */
/* renamed from: com.f.a.c.bd */
/* loaded from: classes.dex */
final class C1178bd<E> extends AbstractC1148aa<E> {

    /* renamed from: a */
    final transient E f7873a;

    /* renamed from: b */
    @LazyInit
    private transient int f7874b;

    C1178bd(E e2) {
        this.f7873a = (E) C1120o.m9547a(e2);
    }

    C1178bd(E e2, int i) {
        this.f7873a = e2;
        this.f7874b = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f7873a.equals(obj);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public AbstractC1185bk<E> iterator() {
        return C1154ag.m9883a(this.f7873a);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa
    /* renamed from: j */
    AbstractC1208w<E> mo9806j() {
        return AbstractC1208w.m10130a(this.f7873a);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: f */
    boolean mo9838f() {
        return false;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: a */
    int mo9986a(Object[] objArr, int i) {
        objArr[i] = this.f7873a;
        return i + 1;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.f7874b;
        if (i == 0) {
            int hashCode = this.f7873a.hashCode();
            this.f7874b = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa
    /* renamed from: h */
    boolean mo9805h() {
        return this.f7874b != 0;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f7873a.toString() + ']';
    }
}
