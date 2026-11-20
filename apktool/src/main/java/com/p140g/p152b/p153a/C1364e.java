package com.p140g.p152b.p153a;

import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;

/* compiled from: StmtSearcher.java */
/* renamed from: com.g.b.a.e */
/* loaded from: classes.dex */
public class C1364e {
    /* renamed from: a */
    public void mo10694a(AbstractC1333j abstractC1333j) {
        EnumC1302a enumC1302a = abstractC1333j.f8645i;
        if (enumC1302a != EnumC1302a.E0) {
            if (enumC1302a == EnumC1302a.E1) {
                mo10693a(abstractC1333j.mo10561c());
                return;
            }
            if (enumC1302a == EnumC1302a.E2) {
                mo10693a(abstractC1333j.mo10563d());
                mo10693a(abstractC1333j.mo10564e());
            } else if (enumC1302a == EnumC1302a.En) {
                for (AbstractC1322t abstractC1322t : abstractC1333j.m10565f()) {
                    mo10693a(abstractC1322t);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo10693a(AbstractC1322t abstractC1322t) {
        EnumC1302a enumC1302a = abstractC1322t.f8560e;
        if (enumC1302a != EnumC1302a.E0) {
            if (enumC1302a == EnumC1302a.E1) {
                mo10693a(abstractC1322t.mo10544g());
                return;
            }
            if (enumC1302a == EnumC1302a.E2) {
                mo10693a(abstractC1322t.mo10545h());
                mo10693a(abstractC1322t.mo10546i());
            } else if (enumC1302a == EnumC1302a.En) {
                for (AbstractC1322t abstractC1322t2 : abstractC1322t.mo10547j()) {
                    mo10693a(abstractC1322t2);
                }
            }
        }
    }
}
