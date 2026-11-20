package org.p210a.p211a.p212a.p213a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: PredictionContextCache.java */
/* renamed from: org.a.a.a.a.ar */
/* loaded from: classes.dex */
public class C1777ar {

    /* renamed from: a */
    protected final Map<AbstractC1776aq, AbstractC1776aq> f10731a = new HashMap();

    /* renamed from: a */
    public AbstractC1776aq m13558a(AbstractC1776aq abstractC1776aq) {
        if (abstractC1776aq == AbstractC1776aq.f10726d) {
            return AbstractC1776aq.f10726d;
        }
        AbstractC1776aq abstractC1776aq2 = this.f10731a.get(abstractC1776aq);
        if (abstractC1776aq2 == null) {
            this.f10731a.put(abstractC1776aq, abstractC1776aq);
            return abstractC1776aq;
        }
        return abstractC1776aq2;
    }

    /* renamed from: b */
    public AbstractC1776aq m13559b(AbstractC1776aq abstractC1776aq) {
        return this.f10731a.get(abstractC1776aq);
    }
}
