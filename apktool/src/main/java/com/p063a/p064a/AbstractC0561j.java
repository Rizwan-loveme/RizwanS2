package com.p063a.p064a;

import java.util.Stack;
import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1858f;

/* compiled from: JavaScriptBaseLexer.java */
/* renamed from: com.a.a.j */
/* loaded from: classes.dex */
public abstract class AbstractC0561j extends AbstractC1870r {

    /* renamed from: a */
    private Stack<Boolean> f3764a;

    /* renamed from: b */
    private InterfaceC1819ac f3765b;

    /* renamed from: c */
    private boolean f3766c;

    /* renamed from: d */
    private boolean f3767d;

    public AbstractC0561j(InterfaceC1858f interfaceC1858f) {
        super(interfaceC1858f);
        this.f3764a = new Stack<>();
        this.f3765b = null;
        this.f3766c = false;
        this.f3767d = false;
    }

    /* renamed from: e */
    public boolean m4721e() {
        return this.f3767d;
    }

    @Override // org.p210a.p211a.p212a.AbstractC1870r, org.p210a.p211a.p212a.InterfaceC1821ae
    /* renamed from: f */
    public InterfaceC1819ac mo4722f() {
        InterfaceC1819ac mo4722f = super.mo4722f();
        if (mo4722f.mo13676e() == 0) {
            this.f3765b = mo4722f;
        }
        return mo4722f;
    }

    /* renamed from: g */
    protected void m4723g() {
        this.f3767d = (this.f3764a.size() <= 0 || !this.f3764a.peek().booleanValue()) ? this.f3766c : true;
        this.f3764a.push(Boolean.valueOf(this.f3767d));
    }

    /* renamed from: h */
    protected void m4724h() {
        this.f3767d = this.f3764a.size() > 0 ? this.f3764a.pop().booleanValue() : this.f3766c;
    }

    /* renamed from: i */
    protected void m4725i() {
        if (this.f3765b == null || this.f3765b.mo13672a() == 8) {
            String v = m13874v();
            if (v.equals("\"use strict\"") || v.equals("'use strict'")) {
                if (this.f3764a.size() > 0) {
                    this.f3764a.pop();
                }
                this.f3767d = true;
                this.f3764a.push(Boolean.valueOf(this.f3767d));
            }
        }
    }

    /* renamed from: j */
    protected boolean m4726j() {
        if (this.f3765b == null) {
            return true;
        }
        switch (this.f3765b.mo13672a()) {
            case 5:
            case 7:
            case 17:
            case 18:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 79:
            case 103:
            case 104:
                break;
        }
        return true;
    }
}
