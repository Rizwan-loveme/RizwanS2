package org.p271f.p272a.p274b;

/* compiled from: SignatureWriter.java */
/* renamed from: org.f.a.b.c */
/* loaded from: classes.dex */
public class C2484c extends AbstractC2483b {

    /* renamed from: b */
    private final StringBuffer f12990b;

    /* renamed from: c */
    private boolean f12991c;

    /* renamed from: d */
    private boolean f12992d;

    /* renamed from: e */
    private int f12993e;

    public C2484c() {
        super(327680);
        this.f12990b = new StringBuffer();
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: c */
    public void mo15696c(String str) {
        if (!this.f12991c) {
            this.f12991c = true;
            this.f12990b.append('<');
        }
        this.f12990b.append(str);
        this.f12990b.append(':');
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: b */
    public AbstractC2483b mo15692b() {
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: e */
    public AbstractC2483b mo15699e() {
        this.f12990b.append(':');
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: h */
    public AbstractC2483b mo15702h() {
        m15712k();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: d */
    public AbstractC2483b mo15697d() {
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: f */
    public AbstractC2483b mo15700f() {
        m15712k();
        if (!this.f12992d) {
            this.f12992d = true;
            this.f12990b.append('(');
        }
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: g */
    public AbstractC2483b mo15701g() {
        m15712k();
        if (!this.f12992d) {
            this.f12990b.append('(');
        }
        this.f12990b.append(')');
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: c */
    public AbstractC2483b mo15695c() {
        this.f12990b.append('^');
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: a */
    public void mo15690a(char c2) {
        this.f12990b.append(c2);
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: d */
    public void mo15698d(String str) {
        this.f12990b.append('T');
        this.f12990b.append(str);
        this.f12990b.append(';');
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: a */
    public AbstractC2483b mo15689a() {
        this.f12990b.append('[');
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: a */
    public void mo15691a(String str) {
        this.f12990b.append('L');
        this.f12990b.append(str);
        this.f12993e *= 2;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: b */
    public void mo15694b(String str) {
        m15713l();
        this.f12990b.append('.');
        this.f12990b.append(str);
        this.f12993e *= 2;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: i */
    public void mo15703i() {
        if (this.f12993e % 2 == 0) {
            this.f12993e++;
            this.f12990b.append('<');
        }
        this.f12990b.append('*');
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: b */
    public AbstractC2483b mo15693b(char c2) {
        if (this.f12993e % 2 == 0) {
            this.f12993e++;
            this.f12990b.append('<');
        }
        if (c2 != '=') {
            this.f12990b.append(c2);
        }
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: j */
    public void mo15704j() {
        m15713l();
        this.f12990b.append(';');
    }

    public String toString() {
        return this.f12990b.toString();
    }

    /* renamed from: k */
    private void m15712k() {
        if (this.f12991c) {
            this.f12991c = false;
            this.f12990b.append('>');
        }
    }

    /* renamed from: l */
    private void m15713l() {
        if (this.f12993e % 2 != 0) {
            this.f12990b.append('>');
        }
        this.f12993e /= 2;
    }
}
