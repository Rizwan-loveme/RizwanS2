package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p133c.AbstractC1209x;

/* compiled from: ImmutableBiMap.java */
/* renamed from: com.f.a.c.t */
/* loaded from: classes.dex */
public abstract class AbstractC1205t<K, V> extends AbstractC1209x<K, V> implements InterfaceC1195j<K, V> {
    @Override // com.p129f.p130a.p133c.InterfaceC1195j
    /* renamed from: d */
    public abstract AbstractC1205t<V, K> mo9984a();

    /* renamed from: b */
    public static <K, V> AbstractC1205t<K, V> m10120b() {
        return C1169av.f7832b;
    }

    /* renamed from: c */
    public static <K, V> a<K, V> m10121c() {
        return new a<>();
    }

    /* compiled from: ImmutableBiMap.java */
    /* renamed from: com.f.a.c.t$a */
    public static final class a<K, V> extends AbstractC1209x.a<K, V> {
        @Override // com.p129f.p130a.p133c.AbstractC1209x.a
        @CanIgnoreReturnValue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a<K, V> mo10126b(K k, V v) {
            super.mo10126b(k, v);
            return this;
        }

        /* renamed from: a */
        public AbstractC1205t<K, V> m10125a() {
            if (this.f7971c == 0) {
                return AbstractC1205t.m10120b();
            }
            m10152b();
            this.f7972d = true;
            return new C1169av(this.f7970b, this.f7971c);
        }
    }

    AbstractC1205t() {
    }

    @Override // com.p129f.p130a.p133c.AbstractC1209x, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<V> values() {
        return mo9984a().keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p129f.p130a.p133c.AbstractC1209x
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final AbstractC1148aa<V> mo9829g() {
        throw new AssertionError("should never be called");
    }
}
