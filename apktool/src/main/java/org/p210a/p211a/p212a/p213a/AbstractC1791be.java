package org.p210a.p211a.p212a.p213a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.p210a.p211a.p212a.p215c.C1840j;

/* compiled from: Transition.java */
/* renamed from: org.a.a.a.a.be */
/* loaded from: classes.dex */
public abstract class AbstractC1791be {

    /* renamed from: d */
    public static final List<String> f10762d = Collections.unmodifiableList(Arrays.asList("INVALID", "EPSILON", "RANGE", "RULE", "PREDICATE", "ATOM", "ACTION", "SET", "NOT_SET", "WILDCARD", "PRECEDENCE"));

    /* renamed from: e */
    public static final Map<Class<? extends AbstractC1791be>, Integer> f10763e = Collections.unmodifiableMap(new HashMap<Class<? extends AbstractC1791be>, Integer>() { // from class: org.a.a.a.a.be.1
        {
            put(C1809s.class, 1);
            put(C1779at.class, 2);
            put(C1782aw.class, 3);
            put(C1775ap.class, 4);
            put(C1802l.class, 5);
            put(C1800j.class, 6);
            put(C1784ay.class, 7);
            put(C1769aj.class, 8);
            put(C1792bf.class, 9);
            put(C1774ao.class, 10);
        }
    });

    /* renamed from: f */
    public AbstractC1797g f10764f;

    /* renamed from: a */
    public abstract int mo13500a();

    /* renamed from: a */
    public abstract boolean mo13501a(int i, int i2, int i3);

    protected AbstractC1791be(AbstractC1797g abstractC1797g) {
        if (abstractC1797g == null) {
            throw new NullPointerException("target cannot be null.");
        }
        this.f10764f = abstractC1797g;
    }

    /* renamed from: b */
    public boolean mo13540b() {
        return false;
    }

    /* renamed from: c */
    public C1840j mo13577c() {
        return null;
    }
}
