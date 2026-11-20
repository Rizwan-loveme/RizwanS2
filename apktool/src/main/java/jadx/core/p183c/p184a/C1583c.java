package jadx.core.p183c.p184a;

import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AttrList.java */
/* renamed from: jadx.core.c.a.c */
/* loaded from: classes.dex */
public class C1583c<T> implements InterfaceC1587g<C1583c<T>> {

    /* renamed from: a */
    private final C1566b<C1583c<T>> f10084a;

    /* renamed from: b */
    private final List<T> f10085b = new ArrayList();

    public C1583c(C1566b<C1583c<T>> c1566b) {
        this.f10084a = c1566b;
    }

    /* renamed from: a */
    public List<T> m12137a() {
        return this.f10085b;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1583c<T>> mo12085b() {
        return this.f10084a;
    }

    public String toString() {
        return C1745n.m13309a((Iterable) this.f10085b);
    }
}
