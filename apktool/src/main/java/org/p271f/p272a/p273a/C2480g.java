package org.p271f.p272a.p273a;

import android.icu.text.SymbolTable;
import org.p271f.p272a.p274b.AbstractC2483b;

/* compiled from: RemappingSignatureAdapter.java */
/* renamed from: org.f.a.a.g */
/* loaded from: classes.dex */
public class C2480g extends AbstractC2483b {

    /* renamed from: b */
    private final AbstractC2483b f12977b;

    /* renamed from: c */
    private final AbstractC2475b f12978c;

    /* renamed from: d */
    private String f12979d;

    public C2480g(AbstractC2483b abstractC2483b, AbstractC2475b abstractC2475b) {
        this(327680, abstractC2483b, abstractC2475b);
    }

    protected C2480g(int i, AbstractC2483b abstractC2483b, AbstractC2475b abstractC2475b) {
        super(i);
        this.f12977b = abstractC2483b;
        this.f12978c = abstractC2475b;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: a */
    public void mo15691a(String str) {
        this.f12979d = str;
        this.f12977b.mo15691a(this.f12978c.mo10335a(str));
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: b */
    public void mo15694b(String str) {
        String str2 = this.f12978c.mo10335a(this.f12979d) + SymbolTable.SYMBOL_REF;
        this.f12979d += SymbolTable.SYMBOL_REF + str;
        String mo10335a = this.f12978c.mo10335a(this.f12979d);
        this.f12977b.mo15694b(mo10335a.substring(mo10335a.startsWith(str2) ? str2.length() : mo10335a.lastIndexOf(36) + 1));
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: c */
    public void mo15696c(String str) {
        this.f12977b.mo15696c(str);
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: d */
    public void mo15698d(String str) {
        this.f12977b.mo15698d(str);
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: a */
    public AbstractC2483b mo15689a() {
        this.f12977b.mo15689a();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: a */
    public void mo15690a(char c2) {
        this.f12977b.mo15690a(c2);
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: b */
    public AbstractC2483b mo15692b() {
        this.f12977b.mo15692b();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: c */
    public AbstractC2483b mo15695c() {
        this.f12977b.mo15695c();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: d */
    public AbstractC2483b mo15697d() {
        this.f12977b.mo15697d();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: e */
    public AbstractC2483b mo15699e() {
        this.f12977b.mo15699e();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: f */
    public AbstractC2483b mo15700f() {
        this.f12977b.mo15700f();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: g */
    public AbstractC2483b mo15701g() {
        this.f12977b.mo15701g();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: h */
    public AbstractC2483b mo15702h() {
        this.f12977b.mo15702h();
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: i */
    public void mo15703i() {
        this.f12977b.mo15703i();
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: b */
    public AbstractC2483b mo15693b(char c2) {
        this.f12977b.mo15693b(c2);
        return this;
    }

    @Override // org.p271f.p272a.p274b.AbstractC2483b
    /* renamed from: j */
    public void mo15704j() {
        this.f12977b.mo15704j();
    }
}
