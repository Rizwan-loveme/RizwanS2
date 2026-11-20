package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0931m;
import com.p065b.p086b.p103f.p105b.C0932n;
import com.p065b.p086b.p103f.p105b.C0933o;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0939u;
import com.p065b.p086b.p103f.p105b.InterfaceC0944z;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0964r;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p108g.AbstractC1004u;
import java.util.ArrayList;

/* compiled from: LiteralOpUpgrader.java */
/* renamed from: com.b.b.g.h */
/* loaded from: classes.dex */
public class C0991h {

    /* renamed from: a */
    private final C1005v f6374a;

    /* renamed from: a */
    public static void m8261a(C1005v c1005v) {
        new C0991h(c1005v).m8258a();
    }

    private C0991h(C1005v c1005v) {
        this.f6374a = c1005v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m8265b(C0934p c0934p) {
        InterfaceC0976d m7932h = c0934p.m7932h();
        return (m7932h instanceof AbstractC0964r) && ((AbstractC0964r) m7932h).mo8065k() == 0;
    }

    /* renamed from: a */
    private void m8258a() {
        final InterfaceC0944z m8302b = C0996m.m8302b();
        this.f6374a.m8406a(new AbstractC1004u.a() { // from class: com.b.b.g.h.1
            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8176a(C0995l c0995l) {
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: a */
            public void mo8177a(C0997n c0997n) {
            }

            @Override // com.p065b.p086b.p108g.AbstractC1004u.a
            /* renamed from: b */
            public void mo8178b(C0995l c0995l) {
                C0937s m7882f = c0995l.mo8288f().m7882f();
                C0935q mo8285b = c0995l.mo8285b();
                if (!C0991h.this.m8264a(c0995l) && mo8285b.m8550f_() == 2) {
                    if (m7882f.m7971d() == 4) {
                        if (C0991h.m8265b(mo8285b.m7949b(0))) {
                            C0991h.this.m8260a(c0995l, mo8285b.m7954f(), C0933o.m7912b(m7882f.m7968a()), null);
                            return;
                        } else {
                            if (C0991h.m8265b(mo8285b.m7949b(1))) {
                                C0991h.this.m8260a(c0995l, mo8285b.m7955g(), m7882f.m7968a(), null);
                                return;
                            }
                            return;
                        }
                    }
                    if (m8302b.mo7871a(m7882f, mo8285b.m7949b(0), mo8285b.m7949b(1))) {
                        c0995l.m8290h();
                    } else if (m7882f.m7973f() && m8302b.mo7871a(m7882f, mo8285b.m7949b(1), mo8285b.m7949b(0))) {
                        c0995l.m8282a(C0935q.m7945a(mo8285b.m7949b(1), mo8285b.m7949b(0)));
                        c0995l.m8290h();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public boolean m8264a(C0995l c0995l) {
        C0937s m7882f = c0995l.mo8288f().m7882f();
        C0934p o = c0995l.m8391o();
        if (o != null && !this.f6374a.m8413a(o) && m7882f.m7968a() != 5) {
            InterfaceC0976d m7932h = c0995l.m8391o().m7932h();
            if (m7932h.mo6699f() && m7932h.mo6697c() == 6) {
                m8260a(c0995l, C0935q.f5906a, 5, (AbstractC0945a) m7932h);
                if (m7882f.m7968a() == 56) {
                    m8260a((C0995l) this.f6374a.m8427j().get(c0995l.m8392p().m8362h().nextSetBit(0)).m8353c().get(r0.size() - 1), C0935q.f5906a, 6, null);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8260a(C0995l c0995l, C0935q c0935q, int i, AbstractC0945a abstractC0945a) {
        AbstractC0926h c0931m;
        AbstractC0926h mo8288f = c0995l.mo8288f();
        C0937s m7980a = C0939u.m7980a(i, c0995l.m8391o(), c0935q, abstractC0945a);
        if (abstractC0945a == null) {
            c0931m = new C0932n(m7980a, mo8288f.m7883g(), c0995l.m8391o(), c0935q);
        } else {
            c0931m = new C0931m(m7980a, mo8288f.m7883g(), c0995l.m8391o(), c0935q, abstractC0945a);
        }
        C0995l c0995l2 = new C0995l(c0931m, c0995l.m8392p());
        ArrayList<AbstractC1004u> m8353c = c0995l.m8392p().m8353c();
        this.f6374a.m8416b(c0995l);
        m8353c.set(m8353c.lastIndexOf(c0995l), c0995l2);
        this.f6374a.m8407a(c0995l2);
    }
}
