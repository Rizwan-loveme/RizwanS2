package org.p210a.p211a.p212a;

import java.util.EmptyStackException;
import org.p210a.p211a.p212a.p213a.C1812v;
import org.p210a.p211a.p212a.p215c.C1838h;
import org.p210a.p211a.p212a.p215c.C1839i;
import org.p210a.p211a.p212a.p215c.C1843m;

/* compiled from: Lexer.java */
/* renamed from: org.a.a.a.r */
/* loaded from: classes.dex */
public abstract class AbstractC1870r extends AbstractC1877y<Integer, C1812v> implements InterfaceC1821ae {

    /* renamed from: j */
    public InterfaceC1858f f10971j;

    /* renamed from: k */
    protected C1843m<InterfaceC1821ae, InterfaceC1858f> f10972k;

    /* renamed from: m */
    public InterfaceC1819ac f10974m;

    /* renamed from: o */
    public int f10976o;

    /* renamed from: p */
    public int f10977p;

    /* renamed from: q */
    public boolean f10978q;

    /* renamed from: r */
    public int f10979r;

    /* renamed from: s */
    public int f10980s;

    /* renamed from: v */
    public String f10983v;

    /* renamed from: l */
    protected InterfaceC1820ad<?> f10973l = C1863k.f10959a;

    /* renamed from: n */
    public int f10975n = -1;

    /* renamed from: t */
    public final C1838h f10981t = new C1838h();

    /* renamed from: u */
    public int f10982u = 0;

    public AbstractC1870r() {
    }

    public AbstractC1870r(InterfaceC1858f interfaceC1858f) {
        this.f10971j = interfaceC1858f;
        this.f10972k = new C1843m<>(this, interfaceC1858f);
    }

    /* renamed from: k */
    public void m13867k() {
        if (this.f10971j != null) {
            this.f10971j.mo13718c(0);
        }
        this.f10974m = null;
        this.f10980s = 0;
        this.f10979r = 0;
        this.f10975n = -1;
        this.f10977p = -1;
        this.f10976o = -1;
        this.f10983v = null;
        this.f10978q = false;
        this.f10982u = 0;
        this.f10981t.m13741c();
        m13926cC().mo13524a();
    }

    /* renamed from: f */
    public InterfaceC1819ac mo4722f() {
        InterfaceC1819ac interfaceC1819ac;
        int i;
        if (this.f10971j == null) {
            throw new IllegalStateException("nextToken requires a non-null input stream.");
        }
        int e2 = this.f10971j.mo13720e();
        while (true) {
            try {
                if (this.f10978q) {
                    m13872r();
                    interfaceC1819ac = this.f10974m;
                    break;
                }
                this.f10974m = null;
                this.f10979r = 0;
                this.f10975n = this.f10971j.mo13717c();
                this.f10977p = m13926cC().m13663c();
                this.f10976o = m13926cC().m13661b();
                this.f10983v = null;
                do {
                    this.f10980s = 0;
                    try {
                        i = m13926cC().m13646a(this.f10971j, this.f10982u);
                    } catch (C1871s e3) {
                        m13863b(e3);
                        m13861a(e3);
                        i = -3;
                    }
                    if (this.f10971j.mo13711a(1) == -1) {
                        this.f10978q = true;
                    }
                    if (this.f10980s == 0) {
                        this.f10980s = i;
                    }
                    if (this.f10980s != -3) {
                    }
                } while (this.f10980s == -2);
                if (this.f10974m == null) {
                    m13871q();
                }
                interfaceC1819ac = this.f10974m;
            } finally {
                this.f10971j.mo13716b(e2);
            }
        }
        return interfaceC1819ac;
    }

    /* renamed from: l */
    public void m13868l() {
        this.f10980s = -3;
    }

    /* renamed from: m */
    public void m13869m() {
        this.f10980s = -2;
    }

    /* renamed from: a */
    public void m13858a(int i) {
        this.f10982u = i;
    }

    /* renamed from: b */
    public void m13862b(int i) {
        this.f10981t.m13743d(this.f10982u);
        m13858a(i);
    }

    /* renamed from: n */
    public int m13870n() {
        if (this.f10981t.m13737a()) {
            throw new EmptyStackException();
        }
        m13858a(this.f10981t.m13744e());
        return this.f10982u;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1821ae
    /* renamed from: o */
    public InterfaceC1820ad<? extends InterfaceC1819ac> mo13682o() {
        return this.f10973l;
    }

    /* renamed from: a */
    public void m13860a(InterfaceC1869q interfaceC1869q) {
        this.f10971j = null;
        this.f10972k = new C1843m<>(this, this.f10971j);
        m13867k();
        this.f10971j = (InterfaceC1858f) interfaceC1869q;
        this.f10972k = new C1843m<>(this, this.f10971j);
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1821ae
    /* renamed from: p */
    public InterfaceC1858f mo13683p() {
        return this.f10971j;
    }

    /* renamed from: a */
    public void m13859a(InterfaceC1819ac interfaceC1819ac) {
        this.f10974m = interfaceC1819ac;
    }

    /* renamed from: q */
    public InterfaceC1819ac m13871q() {
        InterfaceC1819ac mo13681b = this.f10973l.mo13681b(this.f10972k, this.f10980s, this.f10983v, this.f10979r, this.f10975n, m13873u() - 1, this.f10976o, this.f10977p);
        m13859a(mo13681b);
        return mo13681b;
    }

    /* renamed from: r */
    public InterfaceC1819ac m13872r() {
        InterfaceC1819ac mo13681b = this.f10973l.mo13681b(this.f10972k, -1, null, 0, this.f10971j.mo13717c(), this.f10971j.mo13717c() - 1, mo13684s(), mo13685t());
        m13859a(mo13681b);
        return mo13681b;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1821ae
    /* renamed from: s */
    public int mo13684s() {
        return m13926cC().m13661b();
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1821ae
    /* renamed from: t */
    public int mo13685t() {
        return m13926cC().m13663c();
    }

    /* renamed from: u */
    public int m13873u() {
        return this.f10971j.mo13717c();
    }

    /* renamed from: v */
    public String m13874v() {
        return this.f10983v != null ? this.f10983v : m13926cC().m13662b(this.f10971j);
    }

    /* renamed from: c */
    public void m13864c(int i) {
        this.f10980s = i;
    }

    /* renamed from: d */
    public void m13865d(int i) {
        this.f10979r = i;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1877y
    @Deprecated
    /* renamed from: a */
    public String[] mo4046a() {
        return null;
    }

    /* renamed from: a */
    public void m13861a(C1871s c1871s) {
        if (this.f10971j.mo13711a(1) != -1) {
            m13926cC().m13664c(this.f10971j);
        }
    }

    /* renamed from: b */
    public void m13863b(C1871s c1871s) {
        m13929cF().mo13480a(this, (Object) null, this.f10976o, this.f10977p, "token recognition error at: '" + m13857a(this.f10971j.mo13712a(C1839i.m13746a(this.f10975n, this.f10971j.mo13717c()))) + "'", c1871s);
    }

    /* renamed from: a */
    public String m13857a(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            sb.append(m13866e(c2));
        }
        return sb.toString();
    }

    /* renamed from: e */
    public String m13866e(int i) {
        String valueOf = String.valueOf((char) i);
        switch (i) {
            case -1:
                return "<EOF>";
            case 9:
                return "\\t";
            case 10:
                return "\\n";
            case 13:
                return "\\r";
            default:
                return valueOf;
        }
    }
}
