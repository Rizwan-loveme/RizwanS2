package com.p065b.p086b.p100d;

/* compiled from: ClassDef.java */
/* renamed from: com.b.b.d.c */
/* loaded from: classes.dex */
public final class C0895c {

    /* renamed from: a */
    private final C0898f f5416a;

    /* renamed from: b */
    private final int f5417b;

    /* renamed from: c */
    private final int f5418c;

    /* renamed from: d */
    private final int f5419d;

    /* renamed from: e */
    private final int f5420e;

    /* renamed from: f */
    private final int f5421f;

    /* renamed from: g */
    private final int f5422g;

    /* renamed from: h */
    private final int f5423h;

    /* renamed from: i */
    private final int f5424i;

    /* renamed from: j */
    private final int f5425j;

    public C0895c(C0898f c0898f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f5416a = c0898f;
        this.f5417b = i;
        this.f5418c = i2;
        this.f5419d = i3;
        this.f5420e = i4;
        this.f5421f = i5;
        this.f5422g = i6;
        this.f5423h = i7;
        this.f5424i = i8;
        this.f5425j = i9;
    }

    /* renamed from: a */
    public int m7553a() {
        return this.f5417b;
    }

    /* renamed from: b */
    public int m7554b() {
        return this.f5418c;
    }

    /* renamed from: c */
    public int m7555c() {
        return this.f5420e;
    }

    /* renamed from: d */
    public int m7556d() {
        return this.f5421f;
    }

    /* renamed from: e */
    public short[] m7557e() {
        return this.f5416a.m7598b(this.f5421f).m7815a();
    }

    /* renamed from: f */
    public int m7558f() {
        return this.f5419d;
    }

    /* renamed from: g */
    public int m7559g() {
        return this.f5422g;
    }

    /* renamed from: h */
    public int m7560h() {
        return this.f5423h;
    }

    /* renamed from: i */
    public int m7561i() {
        return this.f5424i;
    }

    /* renamed from: j */
    public int m7562j() {
        return this.f5425j;
    }

    public String toString() {
        if (this.f5416a == null) {
            return this.f5418c + " " + this.f5420e;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5416a.m7603f().get(this.f5418c));
        if (this.f5420e != -1) {
            sb.append(" extends ").append(this.f5416a.m7603f().get(this.f5420e));
        }
        return sb.toString();
    }
}
