package jadx.core.p183c.p197g;

import jadx.core.p182b.C1558c;
import jadx.core.p182b.C1559d;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1639e;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.C1650p;
import jadx.core.p203d.p206c.C1731a;
import jadx.p180a.C1534b;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.p217b.p218a.p219a.C1885c;

/* compiled from: RenameVisitor.java */
/* renamed from: jadx.core.c.g.q */
/* loaded from: classes.dex */
public class C1717q extends C1669a {

    /* renamed from: a */
    private C1558c f10564a;

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12780a(C1650p c1650p) {
        List<C1637c> m12658b = c1650p.m12658b();
        if (!m12658b.isEmpty()) {
            String absolutePath = m12658b.get(0).m12560d().m13249c().m13245a().getAbsolutePath();
            String m13957e = C1885c.m13957e(absolutePath);
            File file = new File(m13957e, String.valueOf(C1885c.m13959g(absolutePath)) + ".jobf");
            C1534b m12668j = c1650p.m12668j();
            this.f10564a = new C1558c(m12668j, m12658b, file);
            if (m12668j.m11776k()) {
                this.f10564a.m12051a();
            }
            m13154a(c1650p, C1731a.m13234f(new File(m13957e)));
        }
    }

    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public boolean mo12781a(C1636b c1636b) {
        m13156c(c1636b);
        m13157d(c1636b);
        Iterator<C1636b> it = c1636b.m12534n().iterator();
        while (it.hasNext()) {
            mo12781a(it.next());
        }
        return false;
    }

    /* renamed from: a */
    private void m13154a(C1650p c1650p, boolean z) {
        HashSet hashSet = new HashSet();
        for (C1636b c1636b : c1650p.m12654a(true)) {
            m13155b(c1636b);
            if (!z) {
                C1590b m12544x = c1636b.m12544x();
                if (!hashSet.add(m12544x.m12199b().m12201c().toLowerCase())) {
                    m12544x.m12200b(c1636b.mo12541u(), m12544x.m12196a(this.f10564a.m12050a(c1636b), true));
                    hashSet.add(m12544x.m12199b().m12201c().toLowerCase());
                }
            }
        }
    }

    /* renamed from: b */
    private void m13155b(C1636b c1636b) {
        C1590b m12544x = c1636b.m12544x();
        C1590b m12199b = m12544x.m12199b();
        String m12203e = m12199b.m12203e();
        String str = null;
        char charAt = m12203e.charAt(0);
        if (Character.isDigit(charAt)) {
            str = "AnonymousClass" + m12203e;
        } else if (charAt == '$') {
            str = "C" + m12203e;
        }
        if (str != null) {
            m12544x.m12200b(c1636b.mo12541u(), m12199b.m12196a(str, true));
        }
        if (m12199b.m12204f().isEmpty()) {
            m12544x.m12200b(c1636b.mo12541u(), "defpackage." + m12199b.m12196a(m12199b.m12203e(), true));
        }
    }

    /* renamed from: c */
    private void m13156c(C1636b c1636b) {
        HashSet hashSet = new HashSet();
        for (C1639e c1639e : c1636b.m12531k()) {
            String m12229d = c1639e.m12565f().m12229d();
            if (!hashSet.add(m12229d) || !C1559d.m12064b(m12229d)) {
                this.f10564a.m12052a(c1639e);
            }
        }
    }

    /* renamed from: d */
    private void m13157d(C1636b c1636b) {
        HashSet hashSet = new HashSet();
        for (C1648n c1648n : c1636b.m12530j()) {
            if (!c1648n.mo12149b(EnumC1562a.DONT_GENERATE) && !c1648n.m12615M().m12181j() && (!hashSet.add(c1648n.m12617O().m12240a(false)) || !C1559d.m12064b(c1648n.m12639n()))) {
                this.f10564a.m12053a(c1648n);
            }
        }
    }
}
