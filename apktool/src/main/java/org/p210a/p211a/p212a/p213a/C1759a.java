package org.p210a.p211a.p212a.p213a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.p210a.p211a.p212a.C1878z;
import org.p210a.p211a.p212a.p215c.C1840j;

/* compiled from: ATN.java */
/* renamed from: org.a.a.a.a.a */
/* loaded from: classes.dex */
public class C1759a {

    /* renamed from: c */
    public C1780au[] f10692c;

    /* renamed from: d */
    public C1781av[] f10693d;

    /* renamed from: f */
    public final EnumC1798h f10695f;

    /* renamed from: g */
    public final int f10696g;

    /* renamed from: h */
    public int[] f10697h;

    /* renamed from: i */
    public InterfaceC1813w[] f10698i;

    /* renamed from: a */
    public final List<AbstractC1797g> f10690a = new ArrayList();

    /* renamed from: b */
    public final List<AbstractC1807q> f10691b = new ArrayList();

    /* renamed from: e */
    public final Map<String, C1790bd> f10694e = new LinkedHashMap();

    /* renamed from: j */
    public final List<C1790bd> f10699j = new ArrayList();

    public C1759a(EnumC1798h enumC1798h, int i) {
        this.f10695f = enumC1798h;
        this.f10696g = i;
    }

    /* renamed from: a */
    public C1840j m13486a(AbstractC1797g abstractC1797g, C1878z c1878z) {
        return new C1810t(this).m13639a(abstractC1797g, c1878z);
    }

    /* renamed from: a */
    public C1840j m13485a(AbstractC1797g abstractC1797g) {
        if (abstractC1797g.f10802g != null) {
            return abstractC1797g.f10802g;
        }
        abstractC1797g.f10802g = m13486a(abstractC1797g, (C1878z) null);
        abstractC1797g.f10802g.m13763b(true);
        return abstractC1797g.f10802g;
    }

    /* renamed from: b */
    public void m13487b(AbstractC1797g abstractC1797g) {
        if (abstractC1797g != null) {
            abstractC1797g.f10797b = this;
            abstractC1797g.f10798c = this.f10690a.size();
        }
        this.f10690a.add(abstractC1797g);
    }

    /* renamed from: a */
    public int m13482a(AbstractC1807q abstractC1807q) {
        this.f10691b.add(abstractC1807q);
        abstractC1807q.f10815i = this.f10691b.size() - 1;
        return abstractC1807q.f10815i;
    }

    /* renamed from: a */
    public AbstractC1807q m13483a(int i) {
        if (this.f10691b.isEmpty()) {
            return null;
        }
        return this.f10691b.get(i);
    }

    /* renamed from: a */
    public int m13481a() {
        return this.f10691b.size();
    }

    /* renamed from: a */
    public C1840j m13484a(int i, C1878z c1878z) {
        if (i < 0 || i >= this.f10690a.size()) {
            throw new IllegalArgumentException("Invalid state number.");
        }
        C1840j m13485a = m13485a(this.f10690a.get(i));
        if (m13485a.m13766c(-2)) {
            C1840j c1840j = new C1840j(new int[0]);
            c1840j.m13758a(m13485a);
            c1840j.m13769d(-2);
            while (c1878z != null && c1878z.f11017k >= 0 && m13485a.m13766c(-2)) {
                m13485a = m13485a(((C1782aw) this.f10690a.get(c1878z.f11017k).m13631a(0)).f10743c);
                c1840j.m13758a(m13485a);
                c1840j.m13769d(-2);
                c1878z = c1878z.f11016j;
            }
            if (m13485a.m13766c(-2)) {
                c1840j.m13761b(-1);
            }
            return c1840j;
        }
        return m13485a;
    }
}
