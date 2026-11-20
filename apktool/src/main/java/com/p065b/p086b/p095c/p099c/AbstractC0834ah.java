package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.InterfaceC1007a;

/* compiled from: OffsettedItem.java */
/* renamed from: com.b.b.c.c.ah */
/* loaded from: classes.dex */
public abstract class AbstractC0834ah extends AbstractC0872y implements Comparable<AbstractC0834ah> {

    /* renamed from: a */
    private final int f5170a;

    /* renamed from: b */
    private int f5171b;

    /* renamed from: c */
    private AbstractC0838al f5172c;

    /* renamed from: d */
    private int f5173d;

    /* renamed from: a_ */
    protected abstract void mo7203a_(C0860m c0860m, InterfaceC1007a interfaceC1007a);

    /* renamed from: b */
    public abstract String mo7204b();

    /* renamed from: b */
    public static int m7233b(AbstractC0834ah abstractC0834ah) {
        if (abstractC0834ah == null) {
            return 0;
        }
        return abstractC0834ah.m7237f();
    }

    public AbstractC0834ah(int i, int i2) {
        AbstractC0838al.m7250a(i);
        if (i2 < -1) {
            throw new IllegalArgumentException("writeSize < -1");
        }
        this.f5170a = i;
        this.f5171b = i2;
        this.f5172c = null;
        this.f5173d = -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AbstractC0834ah abstractC0834ah = (AbstractC0834ah) obj;
        return mo7199a() == abstractC0834ah.mo7199a() && mo7198a(abstractC0834ah) == 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AbstractC0834ah abstractC0834ah) {
        if (this == abstractC0834ah) {
            return 0;
        }
        EnumC0873z a2 = mo7199a();
        EnumC0873z a3 = abstractC0834ah.mo7199a();
        if (a2 != a3) {
            return a2.compareTo(a3);
        }
        return mo7198a(abstractC0834ah);
    }

    /* renamed from: a */
    public final void m7234a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeSize < 0");
        }
        if (this.f5171b >= 0) {
            throw new UnsupportedOperationException("writeSize already set");
        }
        this.f5171b = i;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: g_ */
    public final int mo7211g_() {
        if (this.f5171b < 0) {
            throw new UnsupportedOperationException("writeSize is unknown");
        }
        return this.f5171b;
    }

    @Override // com.p065b.p086b.p095c.p099c.AbstractC0872y
    /* renamed from: a */
    public final void mo7207a(C0860m c0860m, InterfaceC1007a interfaceC1007a) {
        interfaceC1007a.mo8531h(this.f5170a);
        try {
            if (this.f5171b < 0) {
                throw new UnsupportedOperationException("writeSize is unknown");
            }
            interfaceC1007a.mo8515a(m7237f());
            mo7203a_(c0860m, interfaceC1007a);
        } catch (RuntimeException e2) {
            throw C1019j.m8537a(e2, "...while writing " + this);
        }
    }

    /* renamed from: f */
    public final int m7237f() {
        if (this.f5173d < 0) {
            throw new RuntimeException("offset not yet known");
        }
        return this.f5172c.m7252c(this.f5173d);
    }

    /* renamed from: b */
    public final int m7235b(AbstractC0838al abstractC0838al, int i) {
        if (abstractC0838al == null) {
            throw new NullPointerException("addedTo == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (this.f5172c != null) {
            throw new RuntimeException("already written");
        }
        int i2 = this.f5170a - 1;
        int i3 = (i2 ^ (-1)) & (i + i2);
        this.f5172c = abstractC0838al;
        this.f5173d = i3;
        mo7200a(abstractC0838al, i3);
        return i3;
    }

    /* renamed from: g */
    public final int m7238g() {
        return this.f5170a;
    }

    /* renamed from: h */
    public final String m7239h() {
        return '[' + Integer.toHexString(m7237f()) + ']';
    }

    /* renamed from: a */
    protected int mo7198a(AbstractC0834ah abstractC0834ah) {
        throw new UnsupportedOperationException("unsupported");
    }

    /* renamed from: a */
    protected void mo7200a(AbstractC0838al abstractC0838al, int i) {
    }
}
