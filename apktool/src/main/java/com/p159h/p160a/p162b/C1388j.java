package com.p159h.p160a.p162b;

/* compiled from: IndentStringBuilder.java */
/* renamed from: com.h.a.b.j */
/* loaded from: classes.dex */
public class C1388j implements CharSequence {

    /* renamed from: a */
    protected int f9024a;

    /* renamed from: b */
    protected final char[] f9025b;

    /* renamed from: c */
    private final StringBuilder f9026c;

    /* renamed from: d */
    private boolean f9027d;

    public C1388j() {
        this.f9024a = 0;
        this.f9027d = false;
        this.f9025b = new char[24];
        this.f9026c = new StringBuilder();
    }

    public C1388j(int i) {
        this.f9024a = 0;
        this.f9027d = false;
        this.f9025b = new char[24];
        this.f9026c = new StringBuilder(i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f9026c.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f9026c.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f9026c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f9026c.toString();
    }

    /* renamed from: a */
    protected void m11071a() {
        for (int i = 0; i < this.f9024a; i++) {
            this.f9026c.append(' ');
        }
    }

    /* renamed from: a */
    public void m11072a(char c2) {
        if (c2 == '\n') {
            this.f9026c.append("\n");
            this.f9027d = true;
        } else {
            if (this.f9027d) {
                m11071a();
            }
            this.f9027d = false;
            this.f9026c.append(c2);
        }
    }

    /* renamed from: a */
    private void m11068a(char[] cArr, int i, int i2) {
        if (this.f9027d && i2 > 0) {
            m11071a();
            this.f9027d = false;
        }
        this.f9026c.append(cArr, i, i2);
    }

    /* renamed from: a */
    public void m11075a(char[] cArr) {
        m11069b(cArr, 0, cArr.length);
    }

    /* renamed from: b */
    private void m11069b(char[] cArr, int i, int i2) {
        int i3 = i + i2;
        int i4 = i;
        int i5 = i;
        while (i4 < i3) {
            if (cArr[i4] == '\n') {
                m11068a(cArr, i5, i4 - i5);
                this.f9026c.append("\n");
                this.f9027d = true;
                int i6 = i4 + 1;
                i4 = i6;
                i5 = i6;
            } else {
                i4++;
            }
        }
        m11068a(cArr, i5, i4 - i5);
    }

    /* renamed from: a */
    public void m11074a(String str) {
        m11075a(str.toCharArray());
    }

    /* renamed from: a */
    public C1388j m11070a(CharSequence charSequence) {
        m11074a(charSequence.toString());
        return this;
    }

    /* renamed from: b */
    public C1388j m11076b(char c2) {
        m11072a(c2);
        return this;
    }

    /* renamed from: a */
    public void m11073a(int i) {
        this.f9024a += i;
        if (this.f9024a < 0) {
            this.f9024a = 0;
        }
    }

    /* renamed from: b */
    public void m11077b(int i) {
        this.f9024a -= i;
        if (this.f9024a < 0) {
            this.f9024a = 0;
        }
    }
}
