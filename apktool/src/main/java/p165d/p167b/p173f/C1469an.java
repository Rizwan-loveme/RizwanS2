package p165d.p167b.p173f;

import java.p209io.IOException;
import java.util.ArrayList;
import java.util.List;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: GeneralSubtrees.java */
/* renamed from: d.b.f.an */
/* loaded from: classes.dex */
public class C1469an implements Cloneable {

    /* renamed from: a */
    private final List<C1468am> f9419a;

    public C1469an() {
        this.f9419a = new ArrayList();
    }

    private C1469an(C1469an c1469an) {
        this.f9419a = new ArrayList(c1469an.f9419a);
    }

    public C1469an(C1450m c1450m) {
        this();
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding of GeneralSubtrees.");
        }
        while (c1450m.f9356b.m11362a() != 0) {
            m11503a(new C1468am(c1450m.f9356b.m11371d()));
        }
    }

    /* renamed from: a */
    public C1468am m11501a(int i) {
        return this.f9419a.get(i);
    }

    /* renamed from: a */
    public void m11503a(C1468am c1468am) {
        if (c1468am == null) {
            throw new NullPointerException();
        }
        this.f9419a.add(c1468am);
    }

    /* renamed from: a */
    public int m11500a() {
        return this.f9419a.size();
    }

    public Object clone() {
        return new C1469an(this);
    }

    public String toString() {
        return "   GeneralSubtrees:\n" + this.f9419a.toString() + "\n";
    }

    /* renamed from: a */
    public void m11502a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        int m11500a = m11500a();
        for (int i = 0; i < m11500a; i++) {
            m11501a(i).m11499a(c1449l2);
        }
        c1449l.m11388a((byte) 48, c1449l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1469an)) {
            return false;
        }
        return this.f9419a.equals(((C1469an) obj).f9419a);
    }

    public int hashCode() {
        return this.f9419a.hashCode();
    }
}
