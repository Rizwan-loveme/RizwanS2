package jadx.core.p183c.p197g.p202d;

import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p197g.C1669a;
import java.util.Iterator;

/* compiled from: FinishTypeInference.java */
/* renamed from: jadx.core.c.g.d.b */
/* loaded from: classes.dex */
public class C1701b extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (!c1648n.m12641p()) {
            int i = 0;
            while (true) {
                Iterator<C1628a> it = c1648n.m12647y().iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Iterator<C1646l> it2 = it.next().mo12446j().iterator();
                    while (it2.hasNext()) {
                        if (C1702c.m13071a(c1648n, it2.next())) {
                            z = true;
                        }
                    }
                }
                int i2 = i + 1;
                if (i2 <= 1000 && z) {
                    i = i2;
                }
            }
            C1637c mo12540t = c1648n.mo12540t();
            Iterator<C1628a> it3 = c1648n.m12647y().iterator();
            while (it3.hasNext()) {
                Iterator<C1646l> it4 = it3.next().mo12446j().iterator();
                while (it4.hasNext()) {
                    C1703d.m13074a(mo12540t, it4.next());
                }
            }
            Iterator<C1628a> it5 = c1648n.m12647y().iterator();
            while (it5.hasNext()) {
                Iterator<C1646l> it6 = it5.next().mo12446j().iterator();
                while (it6.hasNext()) {
                    C1700a.m13067a(c1648n, it6.next());
                }
            }
        }
    }
}
