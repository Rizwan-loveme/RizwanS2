package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p184a.EnumC1562a;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1640f;
import jadx.core.p183c.p191d.InterfaceC1641g;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.C1661c;
import jadx.core.p183c.p193e.p195b.C1659c;
import jadx.core.p183c.p197g.C1669a;
import jadx.core.p203d.p205b.C1729f;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* compiled from: ReturnVisitor.java */
/* renamed from: jadx.core.c.g.b.o */
/* loaded from: classes.dex */
public class C1692o extends C1669a {
    @Override // jadx.core.p183c.p197g.C1669a, jadx.core.p183c.p197g.InterfaceC1712l
    /* renamed from: a */
    public void mo12779a(C1648n c1648n) {
        if (c1648n.m12636k().equals(AbstractC1596a.f10133i)) {
            C1681d.m12888a(c1648n, new a(null));
        }
    }

    /* compiled from: ReturnVisitor.java */
    /* renamed from: jadx.core.c.g.b.o$a */
    private static final class a extends AbstractC1694q {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        @Override // jadx.core.p183c.p197g.p200b.AbstractC1694q, jadx.core.p183c.p197g.p200b.InterfaceC1683f
        /* renamed from: a */
        public boolean mo12881a(C1648n c1648n, InterfaceC1644j interfaceC1644j) {
            super.mo12881a(c1648n, interfaceC1644j);
            return !(interfaceC1644j instanceof C1661c);
        }

        @Override // jadx.core.p183c.p197g.p200b.AbstractC1694q
        /* renamed from: a */
        public void mo12950a(C1648n c1648n, InterfaceC1640f interfaceC1640f, InterfaceC1644j interfaceC1644j) {
            if (interfaceC1640f.getClass() == C1628a.class) {
                C1628a c1628a = (C1628a) interfaceC1640f;
                if (c1628a.mo12149b(EnumC1562a.RETURN)) {
                    List<C1646l> mo12446j = c1628a.mo12446j();
                    if (mo12446j.size() == 1 && m13007a(c1648n, c1628a) && m13005a(c1628a)) {
                        mo12446j.remove(0);
                        c1628a.mo12151c(EnumC1562a.RETURN);
                    }
                }
            }
        }

        /* renamed from: a */
        private boolean m13007a(C1648n c1648n, C1628a c1628a) {
            if (c1648n.m12604B() == 0) {
                return true;
            }
            if (c1648n.m12629c(c1628a) != null) {
                return false;
            }
            Iterator<InterfaceC1644j> it = this.f10529a.iterator();
            while (it.hasNext()) {
                if (it.next().getClass() == C1659c.class) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        private boolean m13005a(C1628a c1628a) {
            InterfaceC1642h previous;
            for (InterfaceC1644j interfaceC1644j : this.f10529a) {
                if (interfaceC1644j instanceof InterfaceC1641g) {
                    c1628a = interfaceC1644j;
                } else {
                    List<InterfaceC1642h> mo12575d = interfaceC1644j.mo12575d();
                    if (!mo12575d.isEmpty()) {
                        ListIterator<InterfaceC1642h> listIterator = mo12575d.listIterator(mo12575d.size());
                        while (listIterator.hasPrevious() && (previous = listIterator.previous()) != c1628a) {
                            if (!m13006a(previous)) {
                                return false;
                            }
                        }
                    }
                    c1628a = interfaceC1644j;
                }
            }
            return true;
        }

        /* renamed from: a */
        private static boolean m13006a(InterfaceC1642h interfaceC1642h) {
            if (interfaceC1642h instanceof InterfaceC1640f) {
                InterfaceC1640f interfaceC1640f = (InterfaceC1640f) interfaceC1642h;
                return interfaceC1640f.mo12446j().isEmpty() || interfaceC1640f.mo12149b(EnumC1562a.RETURN);
            }
            if (interfaceC1642h instanceof InterfaceC1644j) {
                Iterator<InterfaceC1642h> it = ((InterfaceC1644j) interfaceC1642h).mo12575d().iterator();
                while (it.hasNext()) {
                    if (!m13006a(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            throw new C1729f("Unknown container type: " + interfaceC1642h.getClass());
        }
    }
}
