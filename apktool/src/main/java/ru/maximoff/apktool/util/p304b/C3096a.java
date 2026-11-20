package ru.maximoff.apktool.util.p304b;

/* compiled from: ColorItem.java */
/* renamed from: ru.maximoff.apktool.util.b.a */
/* loaded from: classes.dex */
public class C3096a {

    /* renamed from: a */
    private String f18200a;

    /* renamed from: b */
    private String f18201b;

    /* renamed from: c */
    private String f18202c;

    /* renamed from: d */
    private String f18203d;

    /* renamed from: e */
    private String f18204e;

    /* renamed from: f */
    private boolean f18205f;

    public C3096a(String str, String str2) {
        this(str, str2, (String) null);
    }

    public C3096a(String str, String str2, String str3) {
        this.f18205f = false;
        this.f18200a = str;
        this.f18201b = str2;
        this.f18202c = str3;
        this.f18203d = (String) null;
        if (str2.startsWith("@color/") || str2.startsWith("@android:color/")) {
            this.f18204e = str2;
        } else {
            this.f18204e = (String) null;
        }
    }

    /* renamed from: a */
    public void m18807a(String str) {
        this.f18203d = str;
    }

    /* renamed from: b */
    public void m18810b(String str) {
        this.f18202c = str;
    }

    /* renamed from: a */
    public void m18808a(boolean z) {
        this.f18205f = z;
    }

    /* renamed from: a */
    public String m18806a() {
        return this.f18200a;
    }

    /* renamed from: b */
    public String m18809b() {
        return this.f18203d;
    }

    /* renamed from: c */
    public String m18811c() {
        return this.f18201b;
    }

    /* renamed from: d */
    public String m18812d() {
        return this.f18202c;
    }

    /* renamed from: e */
    public String m18813e() {
        return this.f18204e;
    }

    /* renamed from: f */
    public boolean m18814f() {
        return this.f18202c != null;
    }

    /* renamed from: g */
    public boolean m18815g() {
        return this.f18203d != null;
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<").append(this.f18205f ? "item type=\"color\"" : "color").toString()).append(" name=\"").toString()).append(m18815g() ? this.f18203d : this.f18200a).toString()).append("\">").toString()).append(m18814f() ? this.f18202c : this.f18201b).toString()).append("</").toString()).append(this.f18205f ? "item" : "color").toString()).append(">").toString();
    }
}
