package com.p140g.p152b.p153a;

import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1334k;
import java.util.Iterator;

/* compiled from: StmtTraveler.java */
/* renamed from: com.g.b.a.f */
/* loaded from: classes.dex */
public class C1365f {
    /* renamed from: a */
    public void m10765a(C1323b c1323b) {
        m10764a(c1323b.f8628g);
    }

    /* renamed from: a */
    public void m10764a(C1334k c1334k) {
        Iterator<AbstractC1333j> it = c1334k.iterator();
        while (it.hasNext()) {
            AbstractC1333j next = it.next();
            AbstractC1333j mo10687a = mo10687a(next);
            if (mo10687a != next) {
                c1334k.m10582c(next, mo10687a);
                it.remove();
            }
        }
    }

    /* renamed from: a */
    public AbstractC1333j mo10687a(AbstractC1333j abstractC1333j) {
        EnumC1302a enumC1302a = abstractC1333j.f8645i;
        if (enumC1302a != EnumC1302a.E0) {
            if (enumC1302a == EnumC1302a.E1) {
                abstractC1333j.mo10558a(mo10678a(abstractC1333j.mo10561c()));
            } else if (enumC1302a == EnumC1302a.E2) {
                abstractC1333j.mo10560b(mo10678a(abstractC1333j.mo10563d()));
                abstractC1333j.mo10562c(mo10678a(abstractC1333j.mo10564e()));
            } else if (enumC1302a == EnumC1302a.En) {
                AbstractC1322t[] m10565f = abstractC1333j.m10565f();
                for (int i = 0; i < m10565f.length; i++) {
                    m10565f[i] = mo10678a(m10565f[i]);
                }
            }
        }
        return abstractC1333j;
    }

    /* renamed from: a */
    public AbstractC1322t mo10678a(AbstractC1322t abstractC1322t) {
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a != EnumC1302a.E0) {
            if (enumC1302a == EnumC1302a.E1) {
                abstractC1322t.mo10540a(mo10678a(abstractC1322t.mo10544g()));
            } else if (enumC1302a == EnumC1302a.E2) {
                abstractC1322t.mo10542b(mo10678a(abstractC1322t.mo10545h()));
                abstractC1322t.mo10543c(mo10678a(abstractC1322t.mo10546i()));
            } else if (enumC1302a == EnumC1302a.En) {
                AbstractC1322t[] mo10547j = abstractC1322t.mo10547j();
                for (int i = 0; i < mo10547j.length; i++) {
                    mo10547j[i] = mo10678a(mo10547j[i]);
                }
            }
        }
        return abstractC1322t;
    }
}
