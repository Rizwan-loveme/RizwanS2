package com.p129f.p130a.p133c;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: ArrayListMultimap.java */
/* renamed from: com.f.a.c.h */
/* loaded from: classes.dex */
public final class C1193h<K, V> extends AbstractC1194i<K, V> {

    /* renamed from: a */
    transient int f7913a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p129f.p130a.p133c.AbstractC1188c
    /* renamed from: a */
    public /* bridge */ /* synthetic */ List mo10020a(@NullableDecl Object obj) {
        return super.mo10020a((C1193h<K, V>) obj);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1188c, com.p129f.p130a.p133c.AbstractC1191f, com.p129f.p130a.p133c.InterfaceC1158ak
    /* renamed from: b */
    public /* bridge */ /* synthetic */ Map mo9947b() {
        return super.mo9947b();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1189d
    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo10033d() {
        super.mo10033d();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1188c, com.p129f.p130a.p133c.AbstractC1191f
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.p129f.p130a.p133c.AbstractC1191f
    /* renamed from: g */
    public /* bridge */ /* synthetic */ Set mo10050g() {
        return super.mo10050g();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1191f
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.p129f.p130a.p133c.AbstractC1191f
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* renamed from: h */
    public static <K, V> C1193h<K, V> m10051h() {
        return new C1193h<>();
    }

    private C1193h() {
        this(12, 3);
    }

    private C1193h(int i, int i2) {
        super(C1165ar.m9963a(i));
        C1197l.m10052a(i2, "expectedValuesPerKey");
        this.f7913a = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p129f.p130a.p133c.AbstractC1188c, com.p129f.p130a.p133c.AbstractC1189d
    /* renamed from: a */
    public List<V> mo10021c() {
        return new ArrayList(this.f7913a);
    }
}
