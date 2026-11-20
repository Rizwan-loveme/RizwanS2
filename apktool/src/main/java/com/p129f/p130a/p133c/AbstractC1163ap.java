package com.p129f.p130a.p133c;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.InterfaceC1112g;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Ordering.java */
/* renamed from: com.f.a.c.ap */
/* loaded from: classes.dex */
public abstract class AbstractC1163ap<T> implements Comparator<T> {
    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);

    /* renamed from: b */
    public static <C extends Comparable> AbstractC1163ap<C> m9957b() {
        return C1161an.f7826a;
    }

    /* renamed from: a */
    public static <T> AbstractC1163ap<T> m9956a(Comparator<T> comparator) {
        return comparator instanceof AbstractC1163ap ? (AbstractC1163ap) comparator : new C1200o(comparator);
    }

    /* renamed from: c */
    public static AbstractC1163ap<Object> m9958c() {
        return C1187bm.f7886a;
    }

    protected AbstractC1163ap() {
    }

    /* renamed from: a */
    public <S extends T> AbstractC1163ap<S> mo9951a() {
        return new C1176bb(this);
    }

    /* renamed from: a */
    public <F> AbstractC1163ap<F> m9959a(InterfaceC1112g<F, ? extends T> interfaceC1112g) {
        return new C1196k(interfaceC1112g, this);
    }

    /* renamed from: d */
    <T2 extends T> AbstractC1163ap<Map.Entry<T2, ?>> m9962d() {
        return (AbstractC1163ap<Map.Entry<T2, ?>>) m9959a(C1157aj.m9925a());
    }

    /* renamed from: a */
    public <E extends T> List<E> m9960a(Iterable<E> iterable) {
        Object[] m9875c = C1153af.m9875c(iterable);
        Arrays.sort(m9875c, this);
        return C1156ai.m9910a((Iterable) Arrays.asList(m9875c));
    }

    /* renamed from: b */
    public <E extends T> AbstractC1208w<E> m9961b(Iterable<E> iterable) {
        return AbstractC1208w.m10133a((Comparator) this, (Iterable) iterable);
    }
}
