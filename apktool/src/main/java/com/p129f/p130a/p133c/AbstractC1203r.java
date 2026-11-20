package com.p129f.p130a.p133c;

import com.p129f.p130a.p131a.AbstractC1117l;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p131a.InterfaceC1121p;
import java.util.Iterator;

/* compiled from: FluentIterable.java */
/* renamed from: com.f.a.c.r */
/* loaded from: classes.dex */
public abstract class AbstractC1203r<E> implements Iterable<E> {

    /* renamed from: a */
    private final AbstractC1117l<Iterable<E>> f7948a;

    protected AbstractC1203r() {
        this.f7948a = AbstractC1117l.m9539b();
    }

    AbstractC1203r(Iterable<E> iterable) {
        C1120o.m9547a(iterable);
        this.f7948a = AbstractC1117l.m9540b(this == iterable ? null : iterable);
    }

    /* renamed from: a */
    private Iterable<E> m10111a() {
        return this.f7948a.mo9498a(this);
    }

    /* renamed from: a */
    public static <E> AbstractC1203r<E> m10108a(final Iterable<E> iterable) {
        return iterable instanceof AbstractC1203r ? (AbstractC1203r) iterable : new AbstractC1203r<E>(iterable) { // from class: com.f.a.c.r.1
            @Override // java.lang.Iterable
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    /* renamed from: a */
    public static <T> AbstractC1203r<T> m10109a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return m10110a(iterable, iterable2);
    }

    /* renamed from: b */
    public static <T> AbstractC1203r<T> m10112b(final Iterable<? extends Iterable<? extends T>> iterable) {
        C1120o.m9547a(iterable);
        return new AbstractC1203r<T>() { // from class: com.f.a.c.r.2
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return C1154ag.m9899c(C1154ag.m9889a((Iterator) Iterable.this.iterator(), C1153af.m9866a()));
            }
        };
    }

    /* renamed from: a */
    private static <T> AbstractC1203r<T> m10110a(final Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            C1120o.m9547a(iterable);
        }
        return new AbstractC1203r<T>() { // from class: com.f.a.c.r.3
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return C1154ag.m9899c(new AbstractC1147a<Iterator<? extends T>>(iterableArr.length) { // from class: com.f.a.c.r.3.1
                    @Override // com.p129f.p130a.p133c.AbstractC1147a
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public Iterator<? extends T> mo9793a(int i) {
                        return iterableArr[i].iterator();
                    }
                });
            }
        };
    }

    public String toString() {
        return C1153af.m9873b(m10111a());
    }

    /* renamed from: a */
    public final AbstractC1203r<E> m10115a(InterfaceC1121p<? super E> interfaceC1121p) {
        return m10108a(C1153af.m9869a((Iterable) m10111a(), (InterfaceC1121p) interfaceC1121p));
    }

    /* renamed from: a */
    public final <T> AbstractC1203r<T> m10114a(InterfaceC1112g<? super E, T> interfaceC1112g) {
        return m10108a(C1153af.m9868a((Iterable) m10111a(), (InterfaceC1112g) interfaceC1112g));
    }

    /* renamed from: a */
    public final AbstractC1203r<E> m10113a(int i) {
        return m10108a(C1153af.m9867a(m10111a(), i));
    }
}
