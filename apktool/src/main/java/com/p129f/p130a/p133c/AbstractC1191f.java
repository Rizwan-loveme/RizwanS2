package com.p129f.p130a.p133c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractMultimap.java */
/* renamed from: com.f.a.c.f */
/* loaded from: classes.dex */
abstract class AbstractC1191f<K, V> implements InterfaceC1158ak<K, V> {

    /* renamed from: a */
    @MonotonicNonNullDecl
    private transient Set<K> f7910a;

    /* renamed from: b */
    @MonotonicNonNullDecl
    private transient Map<K, Collection<V>> f7911b;

    /* renamed from: e */
    abstract Set<K> mo10034e();

    /* renamed from: f */
    abstract Map<K, Collection<V>> mo10035f();

    AbstractC1191f() {
    }

    /* renamed from: g */
    public Set<K> mo10050g() {
        Set<K> set = this.f7910a;
        if (set != null) {
            return set;
        }
        Set<K> mo10034e = mo10034e();
        this.f7910a = mo10034e;
        return mo10034e;
    }

    @Override // com.p129f.p130a.p133c.InterfaceC1158ak
    /* renamed from: b */
    public Map<K, Collection<V>> mo9947b() {
        Map<K, Collection<V>> map = this.f7911b;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mo10035f = mo10035f();
        this.f7911b = mo10035f;
        return mo10035f;
    }

    public boolean equals(@NullableDecl Object obj) {
        return C1159al.m9948a(this, obj);
    }

    public int hashCode() {
        return mo9947b().hashCode();
    }

    public String toString() {
        return mo9947b().toString();
    }
}
