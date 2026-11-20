package jadx.core.p183c.p196f;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.C1721a;
import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TryCatchBlock.java */
/* renamed from: jadx.core.c.f.e */
/* loaded from: classes.dex */
public class C1668e {

    /* renamed from: a */
    private final List<C1666c> f10475a = new LinkedList();

    /* renamed from: b */
    private final List<C1646l> f10476b = new ArrayList();

    /* renamed from: c */
    private final C1664a f10477c = new C1664a(this);

    /* renamed from: a */
    public Iterable<C1666c> m12769a() {
        return this.f10475a;
    }

    /* renamed from: b */
    public int m12776b() {
        return this.f10475a.size();
    }

    /* renamed from: a */
    public boolean m12775a(C1668e c1668e) {
        return this.f10475a.containsAll(c1668e.f10475a);
    }

    /* renamed from: a */
    public C1666c m12768a(C1648n c1648n, int i, C1590b c1590b) {
        C1666c m12619a = c1648n.m12619a(new C1666c(i, c1590b));
        this.f10475a.add(m12619a);
        m12619a.m12754a(this);
        return m12619a;
    }

    /* renamed from: a */
    public void m12773a(C1648n c1648n, C1666c c1666c) {
        Iterator<C1666c> it = this.f10475a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C1666c next = it.next();
            if (next == c1666c) {
                m12767a(next);
                it.remove();
                break;
            }
        }
        if (this.f10475a.isEmpty()) {
            m12766a(c1648n);
        }
    }

    /* renamed from: a */
    private void m12767a(C1666c c1666c) {
        for (C1628a c1628a : c1666c.m12760e()) {
            C1721a.m13217e(c1628a);
            c1628a.mo12141a(EnumC1562a.SKIP);
            C1665b c1665b = (C1665b) c1628a.mo12146b(C1566b.f10033g);
            if (c1665b != null && c1665b.m12749c().equals(c1666c)) {
                c1628a.m12152d(C1566b.f10033g);
            }
            C1667d c1667d = (C1667d) c1666c.m12759d().mo12146b(C1566b.f10035i);
            if (c1667d != null) {
                c1667d.m12765a().m12152d(C1566b.f10035i);
            }
        }
    }

    /* renamed from: a */
    private void m12766a(C1648n c1648n) {
        Iterator<C1666c> it = this.f10475a.iterator();
        while (it.hasNext()) {
            m12767a(it.next());
            it.remove();
        }
        Iterator<C1646l> it2 = this.f10476b.iterator();
        while (it2.hasNext()) {
            it2.next().m12148b(this.f10477c);
        }
        this.f10476b.clear();
        if (c1648n.m12647y() != null) {
            Iterator<C1628a> it3 = c1648n.m12647y().iterator();
            while (it3.hasNext()) {
                it3.next().m12148b(this.f10477c);
            }
        }
    }

    /* renamed from: a */
    public void m12770a(C1646l c1646l) {
        this.f10476b.add(c1646l);
        c1646l.mo12144a(this.f10477c);
    }

    /* renamed from: a */
    public void m12772a(C1648n c1648n, C1646l c1646l) {
        this.f10476b.remove(c1646l);
        c1646l.m12152d(C1566b.f10034h);
        if (this.f10476b.isEmpty()) {
            m12766a(c1648n);
        }
    }

    /* renamed from: a */
    public void m12771a(C1648n c1648n, C1628a c1628a) {
        for (C1646l c1646l : c1628a.mo12446j()) {
            this.f10476b.remove(c1646l);
            c1646l.m12152d(C1566b.f10034h);
        }
        if (this.f10476b.isEmpty()) {
            m12766a(c1648n);
        }
    }

    /* renamed from: c */
    public Iterable<C1646l> m12777c() {
        return this.f10476b;
    }

    /* renamed from: d */
    public C1664a m12778d() {
        return this.f10477c;
    }

    /* renamed from: a */
    public boolean m12774a(C1648n c1648n, C1668e c1668e) {
        if (c1668e == this) {
            return false;
        }
        Iterator<C1646l> it = c1668e.m12777c().iterator();
        while (it.hasNext()) {
            m12770a(it.next());
        }
        this.f10475a.addAll(c1668e.f10475a);
        Iterator<C1666c> it2 = this.f10475a.iterator();
        while (it2.hasNext()) {
            it2.next().m12754a(this);
        }
        c1668e.f10475a.clear();
        c1668e.m12766a(c1648n);
        return true;
    }

    public int hashCode() {
        return this.f10475a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10475a.equals(((C1668e) obj).f10475a);
    }

    public String toString() {
        return "Catch:{ " + C1745n.m13309a((Iterable) this.f10475a) + " }";
    }
}
