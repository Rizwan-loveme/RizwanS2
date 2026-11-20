package com.p065b.p086b.p103f.p104a;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0970x;

/* compiled from: NameValuePair.java */
/* renamed from: com.b.b.f.a.e */
/* loaded from: classes.dex */
public final class C0918e implements Comparable<C0918e> {

    /* renamed from: a */
    private final C0970x f5854a;

    /* renamed from: b */
    private final AbstractC0945a f5855b;

    public C0918e(C0970x c0970x, AbstractC0945a abstractC0945a) {
        if (c0970x == null) {
            throw new NullPointerException("name == null");
        }
        if (abstractC0945a == null) {
            throw new NullPointerException("value == null");
        }
        this.f5854a = c0970x;
        this.f5855b = abstractC0945a;
    }

    public String toString() {
        return this.f5854a.mo6681d() + ":" + this.f5855b;
    }

    public int hashCode() {
        return (this.f5854a.hashCode() * 31) + this.f5855b.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0918e)) {
            return false;
        }
        C0918e c0918e = (C0918e) obj;
        return this.f5854a.equals(c0918e.f5854a) && this.f5855b.equals(c0918e.f5855b);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0918e c0918e) {
        int a2 = this.f5854a.compareTo(c0918e.f5854a);
        return a2 != 0 ? a2 : this.f5855b.compareTo(c0918e.f5855b);
    }

    /* renamed from: a */
    public C0970x m7833a() {
        return this.f5854a;
    }

    /* renamed from: b */
    public AbstractC0945a m7834b() {
        return this.f5855b;
    }
}
