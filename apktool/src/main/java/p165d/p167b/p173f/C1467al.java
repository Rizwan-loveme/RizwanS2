package p165d.p167b.p173f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: GeneralNames.java */
/* renamed from: d.b.f.al */
/* loaded from: classes.dex */
public class C1467al {

    /* renamed from: a */
    private final List<C1465aj> f9414a;

    public C1467al(C1450m c1450m) {
        this();
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for GeneralNames.");
        }
        if (c1450m.f9356b.m11362a() == 0) {
            throw new IOException("No data available in passed DER encoded value.");
        }
        while (c1450m.f9356b.m11362a() != 0) {
            m11495a(new C1465aj(c1450m.f9356b.m11371d()));
        }
    }

    public C1467al() {
        this.f9414a = new ArrayList();
    }

    /* renamed from: a */
    public C1467al m11495a(C1465aj c1465aj) {
        if (c1465aj == null) {
            throw new NullPointerException();
        }
        this.f9414a.add(c1465aj);
        return this;
    }

    /* renamed from: a */
    public C1465aj m11494a(int i) {
        return this.f9414a.get(i);
    }

    /* renamed from: a */
    public boolean m11497a() {
        return this.f9414a.isEmpty();
    }

    /* renamed from: b */
    public List<C1465aj> m11498b() {
        return this.f9414a;
    }

    /* renamed from: a */
    public void m11496a(C1449l c1449l) {
        if (!m11497a()) {
            C1449l c1449l2 = new C1449l();
            Iterator<C1465aj> it = this.f9414a.iterator();
            while (it.hasNext()) {
                it.next().m11493a(c1449l2);
            }
            c1449l.m11388a((byte) 48, c1449l2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1467al)) {
            return false;
        }
        return this.f9414a.equals(((C1467al) obj).f9414a);
    }

    public int hashCode() {
        return this.f9414a.hashCode();
    }

    public String toString() {
        return this.f9414a.toString();
    }
}
