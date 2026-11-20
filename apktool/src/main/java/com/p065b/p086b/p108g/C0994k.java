package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0922d;
import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p108g.AbstractC1004u;
import java.util.HashSet;
import java.util.List;

/* compiled from: MoveParamCombiner.java */
/* renamed from: com.b.b.g.k */
/* loaded from: classes.dex */
public class C0994k {

    /* renamed from: a */
    private final C1005v f6385a;

    /* renamed from: a */
    public static void m8279a(C1005v c1005v) {
        new C0994k(c1005v).m8278a();
    }

    private C0994k(C1005v c1005v) {
        this.f6385a = c1005v;
    }

    /* renamed from: a */
    private void m8278a() {
        final C0934p[] c0934pArr = new C0934p[this.f6385a.m8425h()];
        final HashSet hashSet = new HashSet();
        this.f6385a.m8406a(new AbstractC1004u.a() { // from class: com.b.b.g.k.1
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
                if (c0995l.mo8287e().m7968a() == 3) {
                    int m8276a = C0994k.this.m8276a(c0995l);
                    if (c0934pArr[m8276a] == null) {
                        c0934pArr[m8276a] = c0995l.m8391o();
                        return;
                    }
                    final C0934p c0934p = c0934pArr[m8276a];
                    final C0934p o = c0995l.m8391o();
                    C0928j m7933i = c0934p.m7933i();
                    C0928j m7933i2 = o.m7933i();
                    if (m7933i != null) {
                        if (m7933i2 == null) {
                            m7933i2 = m7933i;
                        } else if (!m7933i.equals(m7933i2)) {
                            return;
                        } else {
                            m7933i2 = m7933i;
                        }
                    }
                    C0994k.this.f6385a.m8418c(c0934p.m7931g()).m8386a(m7933i2);
                    AbstractC0999p abstractC0999p = new AbstractC0999p() { // from class: com.b.b.g.k.1.1
                        @Override // com.p065b.p086b.p108g.AbstractC0999p
                        /* renamed from: a */
                        public int mo8139a() {
                            return C0994k.this.f6385a.m8424g();
                        }

                        @Override // com.p065b.p086b.p108g.AbstractC0999p
                        /* renamed from: a */
                        public C0934p mo8141a(C0934p c0934p2) {
                            if (c0934p2.m7931g() == o.m7931g()) {
                                return c0934p;
                            }
                            return c0934p2;
                        }
                    };
                    List<AbstractC1004u> m8420d = C0994k.this.f6385a.m8420d(o.m7931g());
                    for (int size = m8420d.size() - 1; size >= 0; size--) {
                        m8420d.get(size).mo8283a(abstractC0999p);
                    }
                    hashSet.add(c0995l);
                }
            }
        });
        this.f6385a.m8411a(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m8276a(C0995l c0995l) {
        return ((C0959m) ((AbstractC0922d) c0995l.mo8288f()).m7868i_()).m8061k_();
    }
}
