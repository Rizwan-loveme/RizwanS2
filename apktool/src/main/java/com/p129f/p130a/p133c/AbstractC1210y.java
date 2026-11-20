package com.p129f.p130a.p133c;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableMapEntrySet.java */
/* renamed from: com.f.a.c.y */
/* loaded from: classes.dex */
abstract class AbstractC1210y<K, V> extends AbstractC1148aa<Map.Entry<K, V>> {
    /* renamed from: g */
    abstract AbstractC1209x<K, V> mo9836g();

    AbstractC1210y() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return mo9836g().size();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        V v = mo9836g().get(entry.getKey());
        return v != null && v.equals(entry.getValue());
    }

    @Override // com.p129f.p130a.p133c.AbstractC1206u
    /* renamed from: f */
    boolean mo9838f() {
        return mo9836g().mo9835n();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa
    /* renamed from: h */
    boolean mo9805h() {
        return mo9836g().m10150o();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1148aa, java.util.Collection, java.util.Set
    public int hashCode() {
        return mo9836g().hashCode();
    }
}
