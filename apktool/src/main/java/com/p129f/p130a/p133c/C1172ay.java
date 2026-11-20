package com.p129f.p130a.p133c;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: RegularImmutableSet.java */
/* renamed from: com.f.a.c.ay */
/* loaded from: classes.dex */
final class C1172ay<E> extends AbstractC1148aa<E> {

    /* renamed from: a */
    static final C1172ay<Object> f7855a = new C1172ay<>(new Object[0], 0, null, 0, 0);

    /* renamed from: b */
    final transient Object[] f7856b;

    /* renamed from: c */
    final transient Object[] f7857c;

    /* renamed from: d */
    private final transient int f7858d;

    /* renamed from: e */
    private final transient int f7859e;

    /* renamed from: f */
    private final transient int f7860f;

    C1172ay(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f7856b = objArr;
        this.f7857c = objArr2;
        this.f7858d = i2;
        this.f7859e = i;
        this.f7860f = i3;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.f7857c;
        if (obj == null || objArr == null) {
            return false;
        }
        int m10119a = C1204s.m10119a(obj);
        while (true) {
            int i = m10119a & this.f7858d;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (!obj2.equals(obj)) {
                m10119a = i + 1;
            } else {
                return true;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f7860f;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractC1185bk<E> iterator() {
        return mo9804e().iterator();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: b */
    Object[] mo9987b() {
        return this.f7856b;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: c */
    int mo9988c() {
        return 0;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: d */
    int mo9989d() {
        return this.f7860f;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: a */
    int mo9986a(Object[] objArr, int i) {
        System.arraycopy(this.f7856b, 0, objArr, i, this.f7860f);
        return this.f7860f + i;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa
    /* renamed from: j */
    AbstractC1208w<E> mo9806j() {
        return AbstractC1208w.m10137b(this.f7856b, this.f7860f);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: f */
    boolean mo9838f() {
        return false;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f7859e;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa
    /* renamed from: h */
    boolean mo9805h() {
        return true;
    }
}
