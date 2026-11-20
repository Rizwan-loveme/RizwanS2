package org.p210a.p211a.p212a.p213a;

import java.util.IdentityHashMap;
import java.util.UUID;
import org.p210a.p211a.p212a.p214b.C1829c;

/* compiled from: ATNSimulator.java */
/* renamed from: org.a.a.a.a.f */
/* loaded from: classes.dex */
public abstract class AbstractC1796f {

    /* renamed from: a */
    @Deprecated
    public static final int f10791a = C1795e.f10779a;

    /* renamed from: b */
    @Deprecated
    public static final UUID f10792b = C1795e.f10780b;

    /* renamed from: c */
    public static final C1829c f10793c = new C1829c(new C1793c());

    /* renamed from: d */
    public final C1759a f10794d;

    /* renamed from: e */
    protected final C1777ar f10795e;

    /* renamed from: a */
    public abstract void mo13524a();

    static {
        f10793c.f10862a = Integer.MAX_VALUE;
    }

    public AbstractC1796f(C1759a c1759a, C1777ar c1777ar) {
        this.f10794d = c1759a;
        this.f10795e = c1777ar;
    }

    /* renamed from: a */
    public AbstractC1776aq m13629a(AbstractC1776aq abstractC1776aq) {
        if (this.f10795e != null) {
            synchronized (this.f10795e) {
                abstractC1776aq = AbstractC1776aq.m13547a(abstractC1776aq, this.f10795e, (IdentityHashMap<AbstractC1776aq, AbstractC1776aq>) new IdentityHashMap());
            }
        }
        return abstractC1776aq;
    }
}
