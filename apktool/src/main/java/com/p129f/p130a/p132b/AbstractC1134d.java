package com.p129f.p130a.p132b;

import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p138h.p139a.C1227f;
import com.p129f.p130a.p138h.p139a.InterfaceFutureC1231j;

/* compiled from: CacheLoader.java */
/* renamed from: com.f.a.b.d */
/* loaded from: classes.dex */
public abstract class AbstractC1134d<K, V> {
    /* renamed from: a */
    public abstract V mo9629a(K k);

    protected AbstractC1134d() {
    }

    /* renamed from: a */
    public InterfaceFutureC1231j<V> m9628a(K k, V v) {
        C1120o.m9547a(k);
        C1120o.m9547a(v);
        return C1227f.m10222a(mo9629a(k));
    }

    /* compiled from: CacheLoader.java */
    /* renamed from: com.f.a.b.d$a */
    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }
}
