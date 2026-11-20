package com.p129f.p130a.p133c;

import java.p209io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ImmutableEntry.java */
/* renamed from: com.f.a.c.v */
/* loaded from: classes.dex */
class C1207v<K, V> extends AbstractC1190e<K, V> implements Serializable {

    /* renamed from: a */
    @NullableDecl
    final K f7957a;

    /* renamed from: b */
    @NullableDecl
    final V f7958b;

    C1207v(@NullableDecl K k, @NullableDecl V v) {
        this.f7957a = k;
        this.f7958b = v;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1190e, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.f7957a;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1190e, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.f7958b;
    }

    @Override // com.p129f.p130a.p133c.AbstractC1190e, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
