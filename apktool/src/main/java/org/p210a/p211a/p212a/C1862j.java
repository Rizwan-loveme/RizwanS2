package org.p210a.p211a.p212a;

import java.io.Serializable;
import org.p210a.p211a.p212a.p215c.C1839i;
import org.p210a.p211a.p212a.p215c.C1843m;

/* compiled from: CommonToken.java */
/* renamed from: org.a.a.a.j */
/* loaded from: classes.dex */
public class C1862j implements Serializable, InterfaceC1825ai {

    /* renamed from: a */
    protected static final C1843m<InterfaceC1821ae, InterfaceC1858f> f10949a = new C1843m<>(null, null);

    /* renamed from: b */
    protected int f10950b;

    /* renamed from: c */
    protected int f10951c;

    /* renamed from: d */
    protected int f10952d;

    /* renamed from: e */
    protected int f10953e;

    /* renamed from: f */
    protected C1843m<InterfaceC1821ae, InterfaceC1858f> f10954f;

    /* renamed from: g */
    protected String f10955g;

    /* renamed from: h */
    protected int f10956h = -1;

    /* renamed from: i */
    protected int f10957i;

    /* renamed from: j */
    protected int f10958j;

    public C1862j(C1843m<InterfaceC1821ae, InterfaceC1858f> c1843m, int i, int i2, int i3, int i4) {
        this.f10952d = -1;
        this.f10953e = 0;
        this.f10954f = c1843m;
        this.f10950b = i;
        this.f10953e = i2;
        this.f10957i = i3;
        this.f10958j = i4;
        if (c1843m.f10912a != null) {
            this.f10951c = c1843m.f10912a.mo13684s();
            this.f10952d = c1843m.f10912a.mo13685t();
        }
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: a */
    public int mo13672a() {
        return this.f10950b;
    }

    /* renamed from: a */
    public void m13834a(int i) {
        this.f10951c = i;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: b */
    public String mo13673b() {
        if (this.f10955g != null) {
            return this.f10955g;
        }
        InterfaceC1858f m13837j = m13837j();
        if (m13837j == null) {
            return null;
        }
        int d2 = m13837j.mo13719d();
        if (this.f10957i < d2 && this.f10958j < d2) {
            return m13837j.mo13712a(C1839i.m13746a(this.f10957i, this.f10958j));
        }
        return "<EOF>";
    }

    /* renamed from: a */
    public void m13835a(String str) {
        this.f10955g = str;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: c */
    public int mo13674c() {
        return this.f10951c;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: d */
    public int mo13675d() {
        return this.f10952d;
    }

    /* renamed from: b */
    public void m13836b(int i) {
        this.f10952d = i;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: e */
    public int mo13676e() {
        return this.f10953e;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: f */
    public int mo13677f() {
        return this.f10957i;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: g */
    public int mo13678g() {
        return this.f10958j;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: h */
    public int mo13679h() {
        return this.f10956h;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1825ai
    /* renamed from: c */
    public void mo13695c(int i) {
        this.f10956h = i;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1819ac
    /* renamed from: i */
    public InterfaceC1821ae mo13680i() {
        return this.f10954f.f10912a;
    }

    /* renamed from: j */
    public InterfaceC1858f m13837j() {
        return this.f10954f.f10913b;
    }

    public String toString() {
        return m13833a((AbstractC1877y) null);
    }

    /* renamed from: a */
    public String m13833a(AbstractC1877y abstractC1877y) {
        String str;
        String str2 = "";
        if (this.f10953e > 0) {
            str2 = ",channel=" + this.f10953e;
        }
        String mo13673b = mo13673b();
        if (mo13673b != null) {
            str = mo13673b.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
        } else {
            str = "<no text>";
        }
        String valueOf = String.valueOf(this.f10950b);
        if (abstractC1877y != null) {
            valueOf = abstractC1877y.mo4047b().mo13693c(this.f10950b);
        }
        return "[@" + mo13679h() + "," + this.f10957i + ":" + this.f10958j + "='" + str + "',<" + valueOf + ">" + str2 + "," + this.f10951c + ":" + mo13675d() + "]";
    }
}
