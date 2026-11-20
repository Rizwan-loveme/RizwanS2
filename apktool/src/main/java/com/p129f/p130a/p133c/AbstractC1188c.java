package com.p129f.p130a.p133c;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: AbstractListMultimap.java */
/* renamed from: com.f.a.c.c */
/* loaded from: classes.dex */
abstract class AbstractC1188c<K, V> extends AbstractC1189d<K, V> implements InterfaceC1155ah<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p129f.p130a.p133c.AbstractC1189d
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public abstract List<V> mo10021c();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p129f.p130a.p133c.AbstractC1189d, com.p129f.p130a.p133c.InterfaceC1158ak
    /* renamed from: b */
    public /* synthetic */ Collection mo9946b(@NullableDecl Object obj) {
        return mo10020a((AbstractC1188c<K, V>) obj);
    }

    protected AbstractC1188c(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1189d
    /* renamed from: a */
    Collection<V> mo10018a(K k, Collection<V> collection) {
        return m10031a(k, (List) collection, null);
    }

    /* renamed from: a */
    public List<V> mo10020a(@NullableDecl K k) {
        return (List) super.mo9946b((AbstractC1188c<K, V>) k);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1191f, com.p129f.p130a.p133c.InterfaceC1158ak
    /* renamed from: b */
    public Map<K, Collection<V>> mo9947b() {
        return super.mo9947b();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1191f
    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}
