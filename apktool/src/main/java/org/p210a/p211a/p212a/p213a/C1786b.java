package org.p210a.p211a.p212a.p213a;

import org.p210a.p211a.p212a.AbstractC1877y;
import org.p210a.p211a.p212a.p215c.C1841k;

/* compiled from: ATNConfig.java */
/* renamed from: org.a.a.a.a.b */
/* loaded from: classes.dex */
public class C1786b {

    /* renamed from: a */
    public final AbstractC1797g f10755a;

    /* renamed from: b */
    public final int f10756b;

    /* renamed from: c */
    public AbstractC1776aq f10757c;

    /* renamed from: d */
    public int f10758d;

    /* renamed from: e */
    public final AbstractC1783ax f10759e;

    public C1786b(AbstractC1797g abstractC1797g, int i, AbstractC1776aq abstractC1776aq) {
        this(abstractC1797g, i, abstractC1776aq, AbstractC1783ax.f10744a);
    }

    public C1786b(AbstractC1797g abstractC1797g, int i, AbstractC1776aq abstractC1776aq, AbstractC1783ax abstractC1783ax) {
        this.f10755a = abstractC1797g;
        this.f10756b = i;
        this.f10757c = abstractC1776aq;
        this.f10759e = abstractC1783ax;
    }

    public C1786b(C1786b c1786b, AbstractC1797g abstractC1797g) {
        this(c1786b, abstractC1797g, c1786b.f10757c, c1786b.f10759e);
    }

    public C1786b(C1786b c1786b, AbstractC1797g abstractC1797g, AbstractC1783ax abstractC1783ax) {
        this(c1786b, abstractC1797g, c1786b.f10757c, abstractC1783ax);
    }

    public C1786b(C1786b c1786b, AbstractC1783ax abstractC1783ax) {
        this(c1786b, c1786b.f10755a, c1786b.f10757c, abstractC1783ax);
    }

    public C1786b(C1786b c1786b, AbstractC1797g abstractC1797g, AbstractC1776aq abstractC1776aq) {
        this(c1786b, abstractC1797g, abstractC1776aq, c1786b.f10759e);
    }

    public C1786b(C1786b c1786b, AbstractC1797g abstractC1797g, AbstractC1776aq abstractC1776aq, AbstractC1783ax abstractC1783ax) {
        this.f10755a = abstractC1797g;
        this.f10756b = c1786b.f10756b;
        this.f10757c = abstractC1776aq;
        this.f10759e = abstractC1783ax;
        this.f10758d = c1786b.f10758d;
    }

    /* renamed from: a */
    public final int m13586a() {
        return this.f10758d & (-1073741825);
    }

    /* renamed from: b */
    public final boolean m13590b() {
        return (this.f10758d & 1073741824) != 0;
    }

    /* renamed from: a */
    public final void m13588a(boolean z) {
        if (z) {
            this.f10758d |= 1073741824;
        } else {
            this.f10758d &= -1073741825;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1786b) {
            return mo13589a((C1786b) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo13589a(C1786b c1786b) {
        if (this == c1786b) {
            return true;
        }
        if (c1786b == null) {
            return false;
        }
        return this.f10755a.f10798c == c1786b.f10755a.f10798c && this.f10756b == c1786b.f10756b && (this.f10757c == c1786b.f10757c || (this.f10757c != null && this.f10757c.equals(c1786b.f10757c))) && this.f10759e.equals(c1786b.f10759e) && m13590b() == c1786b.m13590b();
    }

    public int hashCode() {
        return C1841k.m13775b(C1841k.m13773a(C1841k.m13773a(C1841k.m13772a(C1841k.m13772a(C1841k.m13771a(7), this.f10755a.f10798c), this.f10756b), this.f10757c), this.f10759e), 4);
    }

    public String toString() {
        return m13587a(null, true);
    }

    /* renamed from: a */
    public String m13587a(AbstractC1877y<?, ?> abstractC1877y, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(this.f10755a);
        if (z) {
            sb.append(",");
            sb.append(this.f10756b);
        }
        if (this.f10757c != null) {
            sb.append(",[");
            sb.append(this.f10757c.toString());
            sb.append("]");
        }
        if (this.f10759e != null && this.f10759e != AbstractC1783ax.f10744a) {
            sb.append(",");
            sb.append(this.f10759e);
        }
        if (m13586a() > 0) {
            sb.append(",up=").append(m13586a());
        }
        sb.append(')');
        return sb.toString();
    }
}
