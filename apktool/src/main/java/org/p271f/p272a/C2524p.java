package org.p271f.p272a;

/* compiled from: Item.java */
/* renamed from: org.f.a.p */
/* loaded from: classes.dex */
final class C2524p {

    /* renamed from: a */
    int f13192a;

    /* renamed from: b */
    int f13193b;

    /* renamed from: c */
    int f13194c;

    /* renamed from: d */
    long f13195d;

    /* renamed from: e */
    String f13196e;

    /* renamed from: f */
    String f13197f;

    /* renamed from: g */
    String f13198g;

    /* renamed from: h */
    int f13199h;

    /* renamed from: i */
    C2524p f13200i;

    C2524p() {
    }

    C2524p(int i) {
        this.f13192a = i;
    }

    C2524p(int i, C2524p c2524p) {
        this.f13192a = i;
        this.f13193b = c2524p.f13193b;
        this.f13194c = c2524p.f13194c;
        this.f13195d = c2524p.f13195d;
        this.f13196e = c2524p.f13196e;
        this.f13197f = c2524p.f13197f;
        this.f13198g = c2524p.f13198g;
        this.f13199h = c2524p.f13199h;
    }

    /* renamed from: a */
    void m15855a(int i) {
        this.f13193b = 3;
        this.f13194c = i;
        this.f13199h = Integer.MAX_VALUE & (this.f13193b + i);
    }

    /* renamed from: a */
    void m15858a(long j) {
        this.f13193b = 5;
        this.f13195d = j;
        this.f13199h = Integer.MAX_VALUE & (this.f13193b + ((int) j));
    }

    /* renamed from: a */
    void m15854a(float f2) {
        this.f13193b = 4;
        this.f13194c = Float.floatToRawIntBits(f2);
        this.f13199h = Integer.MAX_VALUE & (this.f13193b + ((int) f2));
    }

    /* renamed from: a */
    void m15853a(double d2) {
        this.f13193b = 6;
        this.f13195d = Double.doubleToRawLongBits(d2);
        this.f13199h = Integer.MAX_VALUE & (this.f13193b + ((int) d2));
    }

    /* renamed from: a */
    void m15857a(int i, String str, String str2, String str3) {
        this.f13193b = i;
        this.f13196e = str;
        this.f13197f = str2;
        this.f13198g = str3;
        switch (i) {
            case 1:
            case 8:
            case 16:
            case 30:
                break;
            case 7:
                this.f13194c = 0;
                break;
            case 12:
                this.f13199h = ((str.hashCode() * str2.hashCode()) + i) & Integer.MAX_VALUE;
                return;
            default:
                this.f13199h = ((str.hashCode() * str2.hashCode() * str3.hashCode()) + i) & Integer.MAX_VALUE;
                return;
        }
        this.f13199h = (str.hashCode() + i) & Integer.MAX_VALUE;
    }

    /* renamed from: a */
    void m15859a(String str, String str2, int i) {
        this.f13193b = 18;
        this.f13195d = i;
        this.f13196e = str;
        this.f13197f = str2;
        this.f13199h = Integer.MAX_VALUE & ((this.f13196e.hashCode() * i * this.f13197f.hashCode()) + 18);
    }

    /* renamed from: a */
    void m15856a(int i, int i2) {
        this.f13193b = 33;
        this.f13194c = i;
        this.f13199h = i2;
    }

    /* renamed from: a */
    boolean m15860a(C2524p c2524p) {
        switch (this.f13193b) {
            case 1:
            case 7:
            case 8:
            case 16:
            case 30:
                return c2524p.f13196e.equals(this.f13196e);
            case 3:
            case 4:
                return c2524p.f13194c == this.f13194c;
            case 5:
            case 6:
            case 32:
                return c2524p.f13195d == this.f13195d;
            case 12:
                return c2524p.f13196e.equals(this.f13196e) && c2524p.f13197f.equals(this.f13197f);
            case 18:
                return c2524p.f13195d == this.f13195d && c2524p.f13196e.equals(this.f13196e) && c2524p.f13197f.equals(this.f13197f);
            case 31:
                return c2524p.f13194c == this.f13194c && c2524p.f13196e.equals(this.f13196e);
            default:
                return c2524p.f13196e.equals(this.f13196e) && c2524p.f13197f.equals(this.f13197f) && c2524p.f13198g.equals(this.f13198g);
        }
    }
}
