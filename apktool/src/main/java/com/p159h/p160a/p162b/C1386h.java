package com.p159h.p160a.p162b;

import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.C1385g;
import java.util.List;

/* compiled from: DocumentProvider.java */
/* renamed from: com.h.a.b.h */
/* loaded from: classes.dex */
public class C1386h implements CharSequence {

    /* renamed from: a */
    private int f9021a;

    /* renamed from: b */
    private final C1385g f9022b;

    @Override // java.lang.CharSequence
    public int length() {
        return this.f9022b.length();
    }

    public C1386h() {
        this.f9021a = 0;
        this.f9022b = new C1385g((C1385g.a) null);
    }

    public C1386h(C1385g.a aVar) {
        this.f9021a = 0;
        this.f9022b = new C1385g(aVar);
    }

    public C1386h(C1385g c1385g) {
        this.f9021a = 0;
        this.f9022b = c1385g;
    }

    public C1386h(C1386h c1386h) {
        this.f9021a = 0;
        this.f9022b = c1386h.f9022b;
    }

    /* renamed from: a */
    public void m11038a(CharSequence charSequence) {
        this.f9021a = 0;
        this.f9022b.m11022a(charSequence);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f9022b.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (this.f9022b.m11161o(i)) {
            return this.f9022b.charAt(i);
        }
        return (char) 0;
    }

    /* renamed from: a */
    public String m11033a(int i) {
        return this.f9022b.m11026b(i);
    }

    /* renamed from: b */
    public int m11044b(int i) {
        return this.f9022b.m11031e(i);
    }

    /* renamed from: c */
    public int m11045c(int i) {
        try {
            return this.f9022b.m11148i(i);
        } catch (Exception e2) {
            return -1;
        }
    }

    /* renamed from: d */
    public int m11047d(int i) {
        return this.f9022b.m11030d(i);
    }

    /* renamed from: e */
    public int m11049e(int i) {
        return this.f9022b.m11146h(i);
    }

    /* renamed from: f */
    public int m11052f(int i) {
        if (this.f9022b.m11161o(i)) {
            this.f9021a = i;
        } else {
            this.f9021a = -1;
        }
        return this.f9021a;
    }

    /* renamed from: a */
    public boolean m11042a() {
        return this.f9021a >= 0 && this.f9021a < this.f9022b.m11142d();
    }

    /* renamed from: b */
    public char m11043b() {
        char charAt = this.f9022b.charAt(this.f9021a);
        this.f9021a++;
        return charAt;
    }

    /* renamed from: a */
    public void m11034a(char c2, int i, long j) {
        if (!this.f9022b.m11161o(i)) {
            return;
        }
        this.f9022b.mo11024a(new char[]{c2}, i, j, true);
    }

    /* renamed from: a */
    public void m11041a(char[] cArr, int i, long j) {
        if (!this.f9022b.m11161o(i) || cArr.length == 0) {
            return;
        }
        this.f9022b.mo11024a(cArr, i, j, true);
    }

    /* renamed from: a */
    public void m11036a(int i, long j) {
        if (!this.f9022b.m11161o(i)) {
            return;
        }
        this.f9022b.mo11020a(i, 1, j, true);
    }

    /* renamed from: a */
    public void m11035a(int i, int i2, long j) {
        if (this.f9022b.m11161o(i) && i2 > 0) {
            this.f9022b.mo11020a(i, Math.min(i2, this.f9022b.m11142d() - i), j, true);
        }
    }

    /* renamed from: c */
    public boolean m11046c() {
        return this.f9022b.m11149i();
    }

    /* renamed from: d */
    public void m11048d() {
        this.f9022b.m11150j();
    }

    /* renamed from: e */
    public void m11050e() {
        this.f9022b.m11152k();
    }

    /* renamed from: f */
    public int m11051f() {
        return this.f9022b.m11028c();
    }

    /* renamed from: g */
    public int m11053g() {
        return this.f9022b.m11143e();
    }

    /* renamed from: g */
    public int m11054g(int i) {
        return this.f9022b.m11029c(i);
    }

    /* renamed from: h */
    public int m11055h() {
        return this.f9022b.m11142d();
    }

    /* renamed from: i */
    public void m11056i() {
        this.f9022b.m11145g();
    }

    /* renamed from: j */
    public List<C1397s<AbstractC1381c.a>> m11057j() {
        return this.f9022b.m11147h();
    }

    /* renamed from: a */
    public void m11039a(List<C1397s<AbstractC1381c.a>> list) {
        this.f9022b.m11140a(list);
    }

    /* renamed from: a */
    public void m11037a(C1385g.a aVar) {
        this.f9022b.m11021a(aVar);
    }

    /* renamed from: a */
    public void m11040a(boolean z) {
        this.f9022b.m11023a(z);
    }

    /* renamed from: k */
    public boolean m11058k() {
        return this.f9022b.m11025a();
    }

    /* renamed from: l */
    public void m11059l() {
        this.f9022b.m11027b();
    }

    /* renamed from: m */
    public boolean m11060m() {
        return this.f9022b.m11155l();
    }

    /* renamed from: n */
    public boolean m11061n() {
        return this.f9022b.m11157m();
    }

    /* renamed from: o */
    public int m11062o() {
        return this.f9022b.m11158n();
    }

    /* renamed from: p */
    public int m11063p() {
        return this.f9022b.m11160o();
    }

    /* renamed from: q */
    public void m11064q() {
        this.f9022b.m11163p();
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f9022b.toString();
    }
}
