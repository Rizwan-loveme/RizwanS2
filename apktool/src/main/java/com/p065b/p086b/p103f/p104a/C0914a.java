package com.p065b.p086b.p103f.p104a;

import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p110h.C1031v;
import com.p065b.p086b.p110h.InterfaceC1035z;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: Annotation.java */
/* renamed from: com.b.b.f.a.a */
/* loaded from: classes.dex */
public final class C0914a extends C1031v implements InterfaceC1035z, Comparable<C0914a> {

    /* renamed from: a */
    private final C0971y f5842a;

    /* renamed from: b */
    private final EnumC0915b f5843b;

    /* renamed from: c */
    private final TreeMap<C0970x, C0918e> f5844c;

    public C0914a(C0971y c0971y, EnumC0915b enumC0915b) {
        if (c0971y == null) {
            throw new NullPointerException("type == null");
        }
        if (enumC0915b == null) {
            throw new NullPointerException("visibility == null");
        }
        this.f5842a = c0971y;
        this.f5843b = enumC0915b;
        this.f5844c = new TreeMap<>();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0914a)) {
            return false;
        }
        C0914a c0914a = (C0914a) obj;
        if (this.f5842a.equals(c0914a.f5842a) && this.f5843b == c0914a.f5843b) {
            return this.f5844c.equals(c0914a.f5844c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f5842a.hashCode() * 31) + this.f5844c.hashCode()) * 31) + this.f5843b.hashCode();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0914a c0914a) {
        int a2 = this.f5842a.compareTo(c0914a.f5842a);
        if (a2 == 0) {
            int compareTo = this.f5843b.compareTo(c0914a.f5843b);
            if (compareTo == 0) {
                Iterator<C0918e> it = this.f5844c.values().iterator();
                Iterator<C0918e> it2 = c0914a.f5844c.values().iterator();
                while (it.hasNext() && it2.hasNext()) {
                    int compareTo2 = it.next().compareTo(it2.next());
                    if (compareTo2 != 0) {
                        return compareTo2;
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
            return compareTo;
        }
        return a2;
    }

    public String toString() {
        return mo6681d();
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5843b.mo6681d());
        sb.append("-annotation ");
        sb.append(this.f5842a.mo6681d());
        sb.append(" {");
        boolean z = true;
        for (C0918e c0918e : this.f5844c.values()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(c0918e.m7833a().mo6681d());
            sb.append(": ");
            sb.append(c0918e.m7834b().mo6681d());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: b */
    public C0971y m7818b() {
        return this.f5842a;
    }

    /* renamed from: e */
    public EnumC0915b m7820e() {
        return this.f5843b;
    }

    /* renamed from: a */
    public void m7817a(C0918e c0918e) {
        m8595l();
        if (c0918e == null) {
            throw new NullPointerException("pair == null");
        }
        this.f5844c.put(c0918e.m7833a(), c0918e);
    }

    /* renamed from: b */
    public void m7819b(C0918e c0918e) {
        m8595l();
        if (c0918e == null) {
            throw new NullPointerException("pair == null");
        }
        C0970x m7833a = c0918e.m7833a();
        if (this.f5844c.get(m7833a) != null) {
            throw new IllegalArgumentException("name already added: " + m7833a);
        }
        this.f5844c.put(m7833a, c0918e);
    }

    /* renamed from: f */
    public Collection<C0918e> m7821f() {
        return Collections.unmodifiableCollection(this.f5844c.values());
    }
}
