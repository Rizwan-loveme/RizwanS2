package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.p215c.C1841k;
import org.p210a.p211a.p212a.p215c.C1842l;

/* compiled from: LexerATNConfig.java */
/* renamed from: org.a.a.a.a.u */
/* loaded from: classes.dex */
public class C1811u extends C1786b {

    /* renamed from: f */
    private final C1814x f10819f;

    /* renamed from: g */
    private final boolean f10820g;

    public C1811u(AbstractC1797g abstractC1797g, int i, AbstractC1776aq abstractC1776aq) {
        super(abstractC1797g, i, abstractC1776aq, AbstractC1783ax.f10744a);
        this.f10820g = false;
        this.f10819f = null;
    }

    public C1811u(C1811u c1811u, AbstractC1797g abstractC1797g) {
        super(c1811u, abstractC1797g, c1811u.f10757c, c1811u.f10759e);
        this.f10819f = c1811u.f10819f;
        this.f10820g = m13641a(c1811u, abstractC1797g);
    }

    public C1811u(C1811u c1811u, AbstractC1797g abstractC1797g, C1814x c1814x) {
        super(c1811u, abstractC1797g, c1811u.f10757c, c1811u.f10759e);
        this.f10819f = c1814x;
        this.f10820g = m13641a(c1811u, abstractC1797g);
    }

    public C1811u(C1811u c1811u, AbstractC1797g abstractC1797g, AbstractC1776aq abstractC1776aq) {
        super(c1811u, abstractC1797g, abstractC1776aq, c1811u.f10759e);
        this.f10819f = c1811u.f10819f;
        this.f10820g = m13641a(c1811u, abstractC1797g);
    }

    /* renamed from: c */
    public final C1814x m13642c() {
        return this.f10819f;
    }

    /* renamed from: d */
    public final boolean m13643d() {
        return this.f10820g;
    }

    @Override // org.p210a.p211a.p212a.p213a.C1786b
    public int hashCode() {
        return C1841k.m13775b(C1841k.m13773a(C1841k.m13772a(C1841k.m13773a(C1841k.m13773a(C1841k.m13772a(C1841k.m13772a(C1841k.m13771a(7), this.f10755a.f10798c), this.f10756b), this.f10757c), this.f10759e), this.f10820g ? 1 : 0), this.f10819f), 6);
    }

    @Override // org.p210a.p211a.p212a.p213a.C1786b
    /* renamed from: a */
    public boolean mo13589a(C1786b c1786b) {
        if (this == c1786b) {
            return true;
        }
        if (!(c1786b instanceof C1811u)) {
            return false;
        }
        C1811u c1811u = (C1811u) c1786b;
        if (this.f10820g == c1811u.f10820g && C1842l.f10911a.mo13575a(this.f10819f, c1811u.f10819f)) {
            return super.mo13589a(c1786b);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m13641a(C1811u c1811u, AbstractC1797g abstractC1797g) {
        return c1811u.f10820g || ((abstractC1797g instanceof AbstractC1807q) && ((AbstractC1807q) abstractC1797g).f10816j);
    }
}
