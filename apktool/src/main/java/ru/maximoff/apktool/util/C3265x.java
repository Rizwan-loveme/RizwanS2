package ru.maximoff.apktool.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: GifEncoder.java */
/* renamed from: ru.maximoff.apktool.util.x */
/* loaded from: classes.dex */
public class C3265x {

    /* renamed from: a */
    protected int f20723a;

    /* renamed from: b */
    protected int f20724b;

    /* renamed from: f */
    protected int f20728f;

    /* renamed from: j */
    protected OutputStream f20732j;

    /* renamed from: k */
    protected Bitmap f20733k;

    /* renamed from: l */
    protected byte[] f20734l;

    /* renamed from: m */
    protected byte[] f20735m;

    /* renamed from: n */
    protected int f20736n;

    /* renamed from: o */
    protected byte[] f20737o;

    /* renamed from: c */
    protected int f20725c = 0;

    /* renamed from: d */
    protected int f20726d = 0;

    /* renamed from: e */
    protected int f20727e = -1;

    /* renamed from: g */
    protected int f20729g = -1;

    /* renamed from: h */
    protected int f20730h = 0;

    /* renamed from: i */
    protected boolean f20731i = false;

    /* renamed from: p */
    protected boolean[] f20738p = new boolean[256];

    /* renamed from: q */
    protected int f20739q = 7;

    /* renamed from: r */
    protected int f20740r = -1;

    /* renamed from: s */
    protected boolean f20741s = false;

    /* renamed from: t */
    protected boolean f20742t = true;

    /* renamed from: u */
    protected boolean f20743u = false;

    /* renamed from: v */
    protected int f20744v = 10;

    /* renamed from: a */
    public void m19692a(int i) {
        this.f20727e = i;
    }

    /* renamed from: a */
    public boolean m19696a(Bitmap bitmap) {
        if (bitmap == null || !this.f20731i) {
            return false;
        }
        try {
            if (!this.f20743u) {
                m19693a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f20733k = bitmap;
            m19701c();
            m19699b();
            if (this.f20742t) {
                m19705f();
                m19707h();
                if (this.f20729g >= 0) {
                    m19706g();
                }
            }
            m19703d();
            m19704e();
            if (!this.f20742t) {
                m19707h();
            }
            m19708i();
            this.f20742t = false;
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m19695a() {
        boolean z;
        if (!this.f20731i) {
            return false;
        }
        this.f20731i = false;
        try {
            this.f20732j.write(59);
            this.f20732j.flush();
            if (this.f20741s) {
                this.f20732j.close();
            }
            z = true;
        } catch (IOException e2) {
            z = false;
        }
        this.f20728f = 0;
        this.f20732j = (OutputStream) null;
        this.f20733k = (Bitmap) null;
        this.f20734l = (byte[]) null;
        this.f20735m = (byte[]) null;
        this.f20737o = (byte[]) null;
        this.f20741s = false;
        this.f20742t = true;
        return z;
    }

    /* renamed from: a */
    public void m19693a(int i, int i2) {
        this.f20723a = i;
        this.f20724b = i2;
        if (this.f20723a < 1) {
            this.f20723a = 320;
        }
        if (this.f20724b < 1) {
            this.f20724b = 240;
        }
        this.f20743u = true;
    }

    /* renamed from: a */
    public boolean m19697a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.f20741s = false;
        this.f20732j = outputStream;
        try {
            m19694a("GIF89a");
        } catch (IOException e2) {
            z = false;
        }
        this.f20731i = z;
        return z;
    }

    /* renamed from: b */
    protected void m19699b() {
        int length = this.f20734l.length;
        int i = length / 3;
        this.f20735m = new byte[i];
        C3087as c3087as = new C3087as(this.f20734l, length, this.f20744v);
        this.f20737o = c3087as.m18680d();
        for (int i2 = 0; i2 < this.f20737o.length; i2 += 3) {
            byte b2 = this.f20737o[i2];
            this.f20737o[i2] = this.f20737o[i2 + 2];
            this.f20737o[i2 + 2] = b2;
            this.f20738p[i2 / 3] = false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i3 = i6 + 1;
            int m18673a = c3087as.m18673a(this.f20734l[i3] & 255, this.f20734l[i5] & 255, this.f20734l[i6] & 255);
            this.f20738p[m18673a] = true;
            this.f20735m[i4] = (byte) m18673a;
        }
        this.f20734l = (byte[]) null;
        this.f20736n = 8;
        this.f20739q = 7;
        if (this.f20727e != -1) {
            this.f20728f = m19698b(this.f20727e);
        }
    }

    /* renamed from: b */
    protected int m19698b(int i) {
        if (this.f20737o == null) {
            return -1;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = (i >> 0) & 255;
        int i5 = 16777216;
        int length = this.f20737o.length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = i6 + 1;
            int i9 = i2 - (this.f20737o[i6] & 255);
            int i10 = i8 + 1;
            int i11 = i3 - (this.f20737o[i8] & 255);
            int i12 = i4 - (this.f20737o[i10] & 255);
            int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
            int i14 = i10 / 3;
            if (!this.f20738p[i14] || i13 >= i5) {
                i13 = i5;
                i14 = i7;
            }
            i6 = i10 + 1;
            i5 = i13;
            i7 = i14;
        }
        return i7;
    }

    /* renamed from: c */
    protected void m19701c() {
        int width = this.f20733k.getWidth();
        int height = this.f20733k.getHeight();
        if (width != this.f20723a || height != this.f20724b) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f20723a, this.f20724b, Bitmap.Config.RGB_565);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            new Canvas(createBitmap).drawBitmap(this.f20733k, 0, 0, paint);
            this.f20733k = createBitmap;
        }
        int[] m19700b = m19700b(this.f20733k);
        this.f20734l = new byte[m19700b.length * 3];
        for (int i = 0; i < m19700b.length; i++) {
            int i2 = m19700b[i];
            int i3 = i * 3;
            int i4 = i3 + 1;
            this.f20734l[i3] = (byte) ((i2 >> 0) & 255);
            this.f20734l[i4] = (byte) ((i2 >> 8) & 255);
            this.f20734l[i4 + 1] = (byte) ((i2 >> 16) & 255);
        }
    }

    /* renamed from: b */
    protected int[] m19700b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        return iArr;
    }

    /* renamed from: d */
    protected void m19703d() {
        int i;
        int i2;
        this.f20732j.write(33);
        this.f20732j.write(249);
        this.f20732j.write(4);
        if (this.f20727e == -1) {
            i2 = 0;
            i = 0;
        } else {
            i = 1;
            i2 = 2;
        }
        if (this.f20740r >= 0) {
            i2 = this.f20740r & 7;
        }
        this.f20732j.write((i2 << 2) | 0 | 0 | i);
        m19702c(this.f20730h);
        this.f20732j.write(this.f20728f);
        this.f20732j.write(0);
    }

    /* renamed from: e */
    protected void m19704e() {
        this.f20732j.write(44);
        m19702c(this.f20725c);
        m19702c(this.f20726d);
        m19702c(this.f20723a);
        m19702c(this.f20724b);
        if (this.f20742t) {
            this.f20732j.write(0);
        } else {
            this.f20732j.write(this.f20739q | 128);
        }
    }

    /* renamed from: f */
    protected void m19705f() {
        m19702c(this.f20723a);
        m19702c(this.f20724b);
        this.f20732j.write(this.f20739q | 240);
        this.f20732j.write(0);
        this.f20732j.write(0);
    }

    /* renamed from: g */
    protected void m19706g() {
        this.f20732j.write(33);
        this.f20732j.write(255);
        this.f20732j.write(11);
        m19694a(new StringBuffer().append("NETSCAPE").append("2.0").toString());
        this.f20732j.write(3);
        this.f20732j.write(1);
        m19702c(this.f20729g);
        this.f20732j.write(0);
    }

    /* renamed from: h */
    protected void m19707h() {
        this.f20732j.write(this.f20737o, 0, this.f20737o.length);
        int length = 768 - this.f20737o.length;
        for (int i = 0; i < length; i++) {
            this.f20732j.write(0);
        }
    }

    /* renamed from: i */
    protected void m19708i() {
        new C3076ah(this.f20723a, this.f20724b, this.f20735m, this.f20736n).m18486b(this.f20732j);
    }

    /* renamed from: c */
    protected void m19702c(int i) {
        this.f20732j.write(i & 255);
        this.f20732j.write((i >> 8) & 255);
    }

    /* renamed from: a */
    protected void m19694a(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f20732j.write((byte) str.charAt(i));
        }
    }
}
