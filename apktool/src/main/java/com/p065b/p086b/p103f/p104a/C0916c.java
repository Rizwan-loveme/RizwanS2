package com.p065b.p086b.p103f.p104a;

import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.C1031v;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: Annotations.java */
/* renamed from: com.b.b.f.a.c */
/* loaded from: classes.dex */
public final class C0916c extends C1031v implements Comparable<C0916c> {

    /* renamed from: a */
    public static final C0916c f5851a = new C0916c();

    /* renamed from: b */
    private final TreeMap<C0971y, C0914a> f5852b = new TreeMap<>();

    static {
        f5851a.mo6683e_();
    }

    /* renamed from: a */
    public static C0916c m7823a(C0916c c0916c, C0916c c0916c2) {
        C0916c c0916c3 = new C0916c();
        c0916c3.m7827b(c0916c);
        c0916c3.m7827b(c0916c2);
        c0916c3.mo6683e_();
        return c0916c3;
    }

    /* renamed from: a */
    public static C0916c m7822a(C0916c c0916c, C0914a c0914a) {
        C0916c c0916c2 = new C0916c();
        c0916c2.m7827b(c0916c);
        c0916c2.m7825a(c0914a);
        c0916c2.mo6683e_();
        return c0916c2;
    }

    public int hashCode() {
        return this.f5852b.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0916c)) {
            return false;
        }
        return this.f5852b.equals(((C0916c) obj).f5852b);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0916c c0916c) {
        Iterator<C0914a> it = this.f5852b.values().iterator();
        Iterator<C0914a> it2 = c0916c.f5852b.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo = it.next().compareTo(it2.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        if (it2.hasNext()) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("annotations{");
        boolean z = true;
        for (C0914a c0914a : this.f5852b.values()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(c0914a.mo6681d());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: b */
    public int m7826b() {
        return this.f5852b.size();
    }

    /* renamed from: a */
    public void m7825a(C0914a c0914a) {
        m8595l();
        if (c0914a == null) {
            throw new NullPointerException("annotation == null");
        }
        C0971y m7818b = c0914a.m7818b();
        if (this.f5852b.containsKey(m7818b)) {
            throw new IllegalArgumentException("duplicate type: " + m7818b.mo6681d());
        }
        this.f5852b.put(m7818b, c0914a);
    }

    /* renamed from: b */
    public void m7827b(C0916c c0916c) {
        m8595l();
        if (c0916c == null) {
            throw new NullPointerException("toAdd == null");
        }
        Iterator<C0914a> it = c0916c.f5852b.values().iterator();
        while (it.hasNext()) {
            m7825a(it.next());
        }
    }

    /* renamed from: d */
    public Collection<C0914a> m7828d() {
        return Collections.unmodifiableCollection(this.f5852b.values());
    }
}
