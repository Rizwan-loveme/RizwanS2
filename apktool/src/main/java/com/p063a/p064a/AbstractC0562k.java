package com.p063a.p064a;

import org.p210a.p211a.p212a.AbstractC1873u;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1822af;

/* compiled from: JavaScriptBaseParser.java */
/* renamed from: com.a.a.k */
/* loaded from: classes.dex */
public abstract class AbstractC0562k extends AbstractC1873u {
    public AbstractC0562k(InterfaceC1822af interfaceC1822af) {
        super(interfaceC1822af);
    }

    /* renamed from: a */
    protected boolean m4728a(String str) {
        return m4729b(str);
    }

    /* renamed from: b */
    protected boolean m4729b(String str) {
        return this.f10991i.mo13689h(-1).mo13673b().equals(str);
    }

    /* renamed from: c */
    protected boolean m4730c(String str) {
        return m4731d(str);
    }

    /* renamed from: d */
    protected boolean m4731d(String str) {
        return this.f10991i.mo13689h(1).mo13673b().equals(str);
    }

    /* renamed from: e */
    protected boolean m4732e() {
        return !m4727b(107);
    }

    /* renamed from: f */
    protected boolean m4733f() {
        int mo13672a = this.f10991i.mo13689h(1).mo13672a();
        return (mo13672a == 8 || mo13672a == 78) ? false : true;
    }

    /* renamed from: g */
    protected boolean m4734g() {
        return this.f10991i.mo13689h(1).mo13672a() == 9;
    }

    /* renamed from: b */
    private boolean m4727b(int i) {
        InterfaceC1819ac mo13688f = this.f10991i.mo13688f(m13902cv().mo13679h() - 1);
        return mo13688f.mo13676e() == 1 && mo13688f.mo13672a() == i;
    }

    /* renamed from: h */
    protected boolean m4735h() {
        InterfaceC1819ac mo13688f = this.f10991i.mo13688f(m13902cv().mo13679h() - 1);
        if (mo13688f.mo13676e() != 1) {
            return false;
        }
        if (mo13688f.mo13672a() == 107) {
            return true;
        }
        if (mo13688f.mo13672a() == 106) {
            mo13688f = this.f10991i.mo13688f(m13902cv().mo13679h() - 2);
        }
        String mo13673b = mo13688f.mo13673b();
        int mo13672a = mo13688f.mo13672a();
        return (mo13672a == 1 && (mo13673b.contains("\r") || mo13673b.contains("\n"))) || mo13672a == 107;
    }
}
