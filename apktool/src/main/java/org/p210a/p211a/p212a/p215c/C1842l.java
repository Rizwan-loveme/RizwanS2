package org.p210a.p211a.p212a.p215c;

/* compiled from: ObjectEqualityComparator.java */
/* renamed from: org.a.a.a.c.l */
/* loaded from: classes.dex */
public final class C1842l extends AbstractC1831a<Object> {

    /* renamed from: a */
    public static final C1842l f10911a = new C1842l();

    @Override // org.p210a.p211a.p212a.p215c.InterfaceC1834d
    /* renamed from: a */
    public int mo13573a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // org.p210a.p211a.p212a.p215c.InterfaceC1834d
    /* renamed from: a */
    public boolean mo13575a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
