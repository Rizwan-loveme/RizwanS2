package ru.maximoff.apktool.util;

import java.util.List;

/* compiled from: MethodItem.java */
/* renamed from: ru.maximoff.apktool.util.ap */
/* loaded from: classes.dex */
public class C3084ap {

    /* renamed from: a */
    private int f18021a;

    /* renamed from: b */
    private int f18022b;

    /* renamed from: c */
    private String f18023c;

    /* renamed from: d */
    private String f18024d;

    /* renamed from: e */
    private String f18025e;

    /* renamed from: f */
    private String f18026f;

    /* renamed from: g */
    private String f18027g;

    /* renamed from: h */
    private String[] f18028h;

    /* renamed from: i */
    private boolean f18029i;

    public C3084ap(int i, int i2, String str, String str2, String str3, String str4, List<String> list, String str5) {
        this.f18021a = i;
        this.f18022b = i2;
        this.f18023c = str;
        this.f18024d = str2;
        this.f18025e = str3;
        this.f18026f = str4;
        if (list != null) {
            this.f18028h = (String[]) list.toArray(new String[list.size()]);
        } else {
            this.f18028h = (String[]) null;
        }
        this.f18027g = str5;
        this.f18029i = false;
    }

    /* renamed from: a */
    public void m18654a(boolean z) {
        this.f18029i = z;
    }

    /* renamed from: a */
    public boolean m18655a() {
        return this.f18029i;
    }

    /* renamed from: b */
    public int m18656b() {
        return this.f18021a;
    }

    /* renamed from: c */
    public int m18657c() {
        return this.f18022b;
    }

    /* renamed from: d */
    public String m18658d() {
        return this.f18023c;
    }

    /* renamed from: e */
    public String m18659e() {
        return this.f18024d;
    }

    /* renamed from: f */
    public String m18660f() {
        return this.f18025e;
    }

    /* renamed from: g */
    public String m18661g() {
        return this.f18026f;
    }

    /* renamed from: h */
    public String[] m18662h() {
        return this.f18028h;
    }

    /* renamed from: i */
    public String m18663i() {
        return this.f18027g;
    }

    /* renamed from: j */
    public String m18664j() {
        return this.f18026f.endsWith(";->") ? this.f18026f.substring(0, this.f18026f.length() - 2) : this.f18026f;
    }

    public String toString() {
        return new StringBuffer().append(this.f18023c).append(this.f18024d).toString();
    }
}
