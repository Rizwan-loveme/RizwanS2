package com.p129f.p130a.p132b;

import com.p129f.p130a.p131a.C1120o;
import java.util.AbstractMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: RemovalNotification.java */
/* renamed from: com.f.a.b.n */
/* loaded from: classes.dex */
public final class C1144n<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {

    /* renamed from: a */
    private final EnumC1142l f7751a;

    /* renamed from: a */
    public static <K, V> C1144n<K, V> m9785a(@NullableDecl K k, @NullableDecl V v, EnumC1142l enumC1142l) {
        return new C1144n<>(k, v, enumC1142l);
    }

    private C1144n(@NullableDecl K k, @NullableDecl V v, EnumC1142l enumC1142l) {
        super(k, v);
        this.f7751a = (EnumC1142l) C1120o.m9547a(enumC1142l);
    }
}
