package ru.maximoff.apktool.util;

/* compiled from: PublicItem.java */
/* renamed from: ru.maximoff.apktool.util.av */
/* loaded from: classes.dex */
public class C3090av {

    /* renamed from: a */
    private String f18120a;

    /* renamed from: b */
    private String f18121b;

    /* renamed from: c */
    private String f18122c;

    /* renamed from: d */
    private String f18123d;

    /* renamed from: e */
    private int f18124e;

    public C3090av(int i, String str, String str2, String str3) {
        this(i, str, str2, str3, str2.startsWith("APKTOOL_DUMMY_") ? str2 : (String) null);
    }

    public C3090av(int i, String str, String str2, String str3, String str4) {
        this.f18120a = str;
        this.f18121b = str2;
        this.f18123d = str3;
        this.f18122c = str4;
        this.f18124e = i;
    }

    /* renamed from: a */
    public String m18724a() {
        return this.f18120a;
    }

    /* renamed from: b */
    public String m18727b() {
        return this.f18121b;
    }

    /* renamed from: c */
    public String m18729c() {
        return this.f18122c;
    }

    /* renamed from: d */
    public String m18730d() {
        return this.f18123d;
    }

    /* renamed from: e */
    public boolean m18731e() {
        return this.f18121b.startsWith("APKTOOL_DUMMY_");
    }

    /* renamed from: a */
    public void m18725a(int i) {
        this.f18124e = i;
    }

    /* renamed from: a */
    public void m18726a(String str) {
        this.f18121b = str;
    }

    /* renamed from: b */
    public void m18728b(String str) {
        this.f18122c = str;
    }

    /* renamed from: f */
    public int m18732f() {
        try {
            return (((int) Long.parseLong(this.f18123d.substring(2), 16)) >> 24) & 255;
        } catch (Exception e2) {
            return 0;
        }
    }

    /* renamed from: g */
    public int m18733g() {
        try {
            return (((int) Long.parseLong(this.f18123d.substring(4), 16)) >> 16) & 255;
        } catch (Exception e2) {
            return 0;
        }
    }

    /* renamed from: h */
    public long m18734h() {
        try {
            return Long.parseLong(this.f18123d.substring(2), 16);
        } catch (Exception e2) {
            return 0;
        }
    }

    public int hashCode() {
        return this.f18124e;
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<public type=\"").append(this.f18120a).toString()).append("\" name=\"").toString()).append(this.f18121b).toString()).append("\" id=\"").toString()).append(this.f18123d).toString()).append("\" />").toString();
    }
}
