package com.p065b.p086b.p095c.p099c;

import com.p065b.p086b.p110h.InterfaceC1007a;
import java.util.Collection;

/* compiled from: Section.java */
/* renamed from: com.b.b.c.c.al */
/* loaded from: classes.dex */
public abstract class AbstractC0838al {

    /* renamed from: a */
    private final String f5181a;

    /* renamed from: b */
    private final C0860m f5182b;

    /* renamed from: c */
    private final int f5183c;

    /* renamed from: d */
    private int f5184d;

    /* renamed from: e */
    private boolean f5185e;

    /* renamed from: a */
    public abstract int mo7224a(AbstractC0872y abstractC0872y);

    /* renamed from: a */
    public abstract Collection<? extends AbstractC0872y> mo7221a();

    /* renamed from: a_ */
    protected abstract void mo7227a_(InterfaceC1007a interfaceC1007a);

    /* renamed from: c */
    protected abstract void mo7229c();

    /* renamed from: h_ */
    public abstract int mo7231h_();

    /* renamed from: a */
    public static void m7250a(int i) {
        if (i <= 0 || ((i - 1) & i) != 0) {
            throw new IllegalArgumentException("invalid alignment");
        }
    }

    public AbstractC0838al(String str, C0860m c0860m, int i) {
        if (c0860m == null) {
            throw new NullPointerException("file == null");
        }
        m7250a(i);
        this.f5181a = str;
        this.f5182b = c0860m;
        this.f5183c = i;
        this.f5184d = -1;
        this.f5185e = false;
    }

    /* renamed from: e */
    public final C0860m m7255e() {
        return this.f5182b;
    }

    /* renamed from: f */
    public final int m7256f() {
        return this.f5183c;
    }

    /* renamed from: g */
    public final int m7257g() {
        if (this.f5184d < 0) {
            throw new RuntimeException("fileOffset not set");
        }
        return this.f5184d;
    }

    /* renamed from: b */
    public final int m7251b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("fileOffset < 0");
        }
        if (this.f5184d >= 0) {
            throw new RuntimeException("fileOffset already set");
        }
        int i2 = this.f5183c - 1;
        int i3 = (i2 ^ (-1)) & (i + i2);
        this.f5184d = i3;
        return i3;
    }

    /* renamed from: c */
    public final void m7253c(InterfaceC1007a interfaceC1007a) {
        m7259i();
        m7254d(interfaceC1007a);
        int g = interfaceC1007a.mo8528g();
        if (this.f5184d < 0) {
            this.f5184d = g;
        } else if (this.f5184d != g) {
            throw new RuntimeException("alignment mismatch: for " + this + ", at " + g + ", but expected " + this.f5184d);
        }
        if (interfaceC1007a.mo8460a()) {
            if (this.f5181a != null) {
                interfaceC1007a.mo8458a(0, "\n" + this.f5181a + ":");
            } else if (g != 0) {
                interfaceC1007a.mo8458a(0, "\n");
            }
        }
        mo7227a_(interfaceC1007a);
    }

    /* renamed from: c */
    public final int m7252c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("relative < 0");
        }
        if (this.f5184d < 0) {
            throw new RuntimeException("fileOffset not yet set");
        }
        return this.f5184d + i;
    }

    /* renamed from: h */
    public final void m7258h() {
        m7260j();
        mo7229c();
        this.f5185e = true;
    }

    /* renamed from: i */
    protected final void m7259i() {
        if (!this.f5185e) {
            throw new RuntimeException("not prepared");
        }
    }

    /* renamed from: j */
    protected final void m7260j() {
        if (this.f5185e) {
            throw new RuntimeException("already prepared");
        }
    }

    /* renamed from: d */
    protected final void m7254d(InterfaceC1007a interfaceC1007a) {
        interfaceC1007a.mo8531h(this.f5183c);
    }
}
