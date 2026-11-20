package org.p210a.p211a.p212a;

import java.util.Locale;
import org.p210a.p211a.p212a.p213a.AbstractC1799i;
import org.p210a.p211a.p212a.p213a.C1775ap;

/* compiled from: FailedPredicateException.java */
/* renamed from: org.a.a.a.o */
/* loaded from: classes.dex */
public class C1867o extends C1876x {

    /* renamed from: a */
    private final int f10968a;

    /* renamed from: b */
    private final int f10969b;

    /* renamed from: c */
    private final String f10970c;

    public C1867o(AbstractC1873u abstractC1873u, String str) {
        this(abstractC1873u, str, null);
    }

    public C1867o(AbstractC1873u abstractC1873u, String str, String str2) {
        super(m13856a(str, str2), abstractC1873u, abstractC1873u.m13900ct(), abstractC1873u.f10993k);
        AbstractC1799i abstractC1799i = (AbstractC1799i) abstractC1873u.m13926cC().f10794d.f10690a.get(abstractC1873u.m13930cG()).m13631a(0);
        if (abstractC1799i instanceof C1775ap) {
            this.f10968a = ((C1775ap) abstractC1799i).f10723a;
            this.f10969b = ((C1775ap) abstractC1799i).f10724b;
        } else {
            this.f10968a = 0;
            this.f10969b = 0;
        }
        this.f10970c = str;
        m13922a(abstractC1873u.m13902cv());
    }

    /* renamed from: a */
    private static String m13856a(String str, String str2) {
        return str2 != null ? str2 : String.format(Locale.getDefault(), "failed predicate: {%s}?", str);
    }
}
