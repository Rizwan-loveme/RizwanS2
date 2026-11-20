package jadx.core.p203d;

import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import java.util.Iterator;
import java.util.List;

/* compiled from: InsnList.java */
/* renamed from: jadx.core.d.g */
/* loaded from: classes.dex */
public final class C1738g implements Iterable<C1646l> {

    /* renamed from: a */
    private final List<C1646l> f10599a;

    public C1738g(List<C1646l> list) {
        this.f10599a = list;
    }

    /* renamed from: a */
    public static void m13263a(List<C1646l> list, C1646l c1646l) {
        Iterator<C1646l> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == c1646l) {
                it.remove();
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m13262a(C1628a c1628a, C1646l c1646l) {
        m13263a(c1628a.mo12446j(), c1646l);
    }

    /* renamed from: b */
    public static int m13264b(List<C1646l> list, C1646l c1646l) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == c1646l) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public int m13266a(C1646l c1646l) {
        return m13264b(this.f10599a, c1646l);
    }

    @Override // java.lang.Iterable
    public Iterator<C1646l> iterator() {
        return this.f10599a.iterator();
    }

    /* renamed from: a */
    public C1646l m13267a(int i) {
        return this.f10599a.get(i);
    }

    /* renamed from: a */
    public int m13265a() {
        return this.f10599a.size();
    }
}
