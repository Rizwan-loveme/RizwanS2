package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p133c.AbstractC1206u;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableSet.java */
/* renamed from: com.f.a.c.aa */
/* loaded from: classes.dex */
public abstract class AbstractC1148aa<E> extends AbstractC1206u<E> implements Set<E> {

    /* renamed from: a */
    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient AbstractC1208w<E> f7766a;

    @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: a */
    public abstract AbstractC1185bk<E> iterator();

    /* renamed from: i */
    public static <E> AbstractC1148aa<E> m9802i() {
        return C1172ay.f7855a;
    }

    /* renamed from: a */
    public static <E> AbstractC1148aa<E> m9796a(E e2) {
        return new C1178bd(e2);
    }

    @SafeVarargs
    /* renamed from: a */
    public static <E> AbstractC1148aa<E> m9797a(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        C1120o.m9551a(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 6];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return m9800b(objArr.length, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static <E> AbstractC1148aa<E> m9800b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return m9802i();
            case 1:
                return m9796a(objArr[0]);
            default:
                int m9794a = m9794a(i);
                Object[] objArr2 = new Object[m9794a];
                int i2 = m9794a - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object m9952a = C1162ao.m9952a(objArr[i5], i5);
                    int hashCode = m9952a.hashCode();
                    int m10117a = C1204s.m10117a(hashCode);
                    while (true) {
                        int i6 = m10117a & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            objArr[i3] = m9952a;
                            objArr2[i6] = m9952a;
                            i4 += hashCode;
                            i3++;
                        } else if (!obj.equals(m9952a)) {
                            m10117a++;
                        }
                    }
                }
                Arrays.fill(objArr, i3, i, (Object) null);
                if (i3 == 1) {
                    return new C1178bd(objArr[0], i4);
                }
                if (m9794a(i3) < m9794a / 2) {
                    return m9800b(i3, objArr);
                }
                return new C1172ay(m9801b(i3, objArr.length) ? Arrays.copyOf(objArr, i3) : objArr, i4, objArr2, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m9801b(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    /* renamed from: a */
    static int m9794a(int i) {
        int max = Math.max(i, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit <<= 1;
            } while (highestOneBit * 0.7d < max);
            return highestOneBit;
        }
        C1120o.m9551a(max < 1073741824, "collection too large");
        return 1073741824;
    }

    /* renamed from: a */
    public static <E> AbstractC1148aa<E> m9798a(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return m9802i();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return m9796a(next);
        }
        return new a().mo9812b(next).mo9810a((Iterator) it).mo9808a();
    }

    AbstractC1148aa() {
    }

    /* renamed from: h */
    boolean mo9805h() {
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof AbstractC1148aa) && mo9805h() && ((AbstractC1148aa) obj).mo9805h() && hashCode() != obj.hashCode()) {
            return false;
        }
        return C1177bc.m10007a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return C1177bc.m10004a(this);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: e */
    public AbstractC1208w<E> mo9804e() {
        AbstractC1208w<E> abstractC1208w = this.f7766a;
        if (abstractC1208w != null) {
            return abstractC1208w;
        }
        AbstractC1208w<E> mo9806j = mo9806j();
        this.f7766a = mo9806j;
        return mo9806j;
    }

    /* renamed from: j */
    AbstractC1208w<E> mo9806j() {
        return AbstractC1208w.m10135a(toArray());
    }

    /* compiled from: ImmutableSet.java */
    /* renamed from: com.f.a.c.aa$a */
    public static class a<E> extends AbstractC1206u.a<E> {

        /* renamed from: d */
        @NullableDecl
        Object[] f7767d;

        /* renamed from: e */
        private int f7768e;

        public a() {
            super(4);
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u.a, com.p129f.p130a.p133c.AbstractC1206u.b
        @CanIgnoreReturnValue
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a<E> mo9812b(E e2) {
            C1120o.m9547a(e2);
            if (this.f7767d != null && AbstractC1148aa.m9794a(this.f7955b) <= this.f7767d.length) {
                m9807d(e2);
            } else {
                this.f7767d = null;
                super.mo9812b((a<E>) e2);
            }
            return this;
        }

        /* renamed from: d */
        private void m9807d(E e2) {
            int length = this.f7767d.length - 1;
            int hashCode = e2.hashCode();
            int m10117a = C1204s.m10117a(hashCode);
            while (true) {
                int i = m10117a & length;
                Object obj = this.f7767d[i];
                if (obj == null) {
                    this.f7767d[i] = e2;
                    this.f7768e += hashCode;
                    super.mo9812b((a<E>) e2);
                    return;
                } else if (!obj.equals(e2)) {
                    m10117a = i + 1;
                } else {
                    return;
                }
            }
        }

        @Override // com.p129f.p130a.p133c.AbstractC1206u.b
        @CanIgnoreReturnValue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a<E> mo9810a(Iterator<? extends E> it) {
            C1120o.m9547a(it);
            while (it.hasNext()) {
                mo9812b(it.next());
            }
            return this;
        }

        /* renamed from: a */
        public AbstractC1148aa<E> mo9808a() {
            AbstractC1148aa<E> m9800b;
            switch (this.f7955b) {
                case 0:
                    return AbstractC1148aa.m9802i();
                case 1:
                    return AbstractC1148aa.m9796a(this.f7954a[0]);
                default:
                    if (this.f7767d == null || AbstractC1148aa.m9794a(this.f7955b) != this.f7767d.length) {
                        m9800b = AbstractC1148aa.m9800b(this.f7955b, this.f7954a);
                        this.f7955b = m9800b.size();
                    } else {
                        m9800b = new C1172ay<>(AbstractC1148aa.m9801b(this.f7955b, this.f7954a.length) ? Arrays.copyOf(this.f7954a, this.f7955b) : this.f7954a, this.f7768e, this.f7767d, this.f7767d.length - 1, this.f7955b);
                    }
                    this.f7956c = true;
                    this.f7767d = null;
                    return m9800b;
            }
        }
    }
}
