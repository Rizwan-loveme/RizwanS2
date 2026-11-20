package p165d.p167b.p173f;

import p165d.p167b.p172e.C1440c;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: UniqueIdentity.java */
/* renamed from: d.b.f.bl */
/* loaded from: classes.dex */
public class C1494bl {

    /* renamed from: a */
    private C1440c f9528a;

    public C1494bl(C1450m c1450m) {
        this.f9528a = c1450m.m11414a(true);
    }

    public String toString() {
        return "UniqueIdentity:" + this.f9528a.toString() + "\n";
    }

    /* renamed from: a */
    public void m11553a(C1449l c1449l, byte b2) {
        byte[] m11323c = this.f9528a.m11323c();
        int length = m11323c.length;
        int m11319a = this.f9528a.m11319a();
        c1449l.write(b2);
        c1449l.m11406c(m11323c.length + 1);
        c1449l.write((length * 8) - m11319a);
        c1449l.write(m11323c);
    }

    /* renamed from: a */
    public boolean[] m11554a() {
        if (this.f9528a == null) {
            return null;
        }
        return this.f9528a.m11322b();
    }
}
