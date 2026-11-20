package com.p129f.p130a.p133c;

import com.p129f.p130a.p133c.C1171ax;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: RegularImmutableBiMap.java */
/* renamed from: com.f.a.c.av */
/* loaded from: classes.dex */
final class C1169av<K, V> extends AbstractC1205t<K, V> {

    /* renamed from: b */
    static final C1169av<Object, Object> f7832b = new C1169av<>();

    /* renamed from: c */
    final transient Object[] f7833c;

    /* renamed from: d */
    private final transient int[] f7834d;

    /* renamed from: e */
    private final transient int f7835e;

    /* renamed from: f */
    private final transient int f7836f;

    /* renamed from: g */
    private final transient C1169av<V, K> f7837g;

    /* JADX WARN: Multi-variable type inference failed */
    private C1169av() {
        this.f7834d = null;
        this.f7833c = new Object[0];
        this.f7835e = 0;
        this.f7836f = 0;
        this.f7837g = this;
    }

    C1169av(Object[] objArr, int i) {
        this.f7833c = objArr;
        this.f7836f = i;
        this.f7835e = 0;
        int m9794a = i >= 2 ? AbstractC1148aa.m9794a(i) : 0;
        this.f7834d = C1171ax.m9991a(objArr, i, m9794a, 0);
        this.f7837g = new C1169av<>(C1171ax.m9991a(objArr, i, m9794a, 1), objArr, i, this);
    }

    private C1169av(int[] iArr, Object[] objArr, int i, C1169av<V, K> c1169av) {
        this.f7834d = iArr;
        this.f7833c = objArr;
        this.f7835e = 1;
        this.f7836f = i;
        this.f7837g = c1169av;
    }

    @Override // java.util.Map
    public int size() {
        return this.f7836f;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1205t, com.p129f.p130a.p133c.InterfaceC1195j
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC1205t<V, K> mo9984a() {
        return this.f7837g;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x, java.util.Map
    public V get(@NullableDecl Object obj) {
        return (V) C1171ax.m9990a(this.f7834d, this.f7833c, this.f7836f, this.f7835e, obj);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: k */
    AbstractC1148aa<Map.Entry<K, V>> mo9832k() {
        return new C1171ax.a(this, this.f7833c, this.f7835e, this.f7836f);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: m */
    AbstractC1148aa<K> mo9834m() {
        return new C1171ax.b(this, new C1171ax.c(this.f7833c, this.f7835e, this.f7836f));
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: n */
    boolean mo9835n() {
        return false;
    }
}
