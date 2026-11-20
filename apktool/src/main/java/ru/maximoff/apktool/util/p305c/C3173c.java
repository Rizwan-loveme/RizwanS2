package ru.maximoff.apktool.util.p305c;

/* compiled from: APKProtect3.java */
/* renamed from: ru.maximoff.apktool.util.c.c */
/* loaded from: classes.dex */
public class C3173c extends AbstractC3187d {

    /* renamed from: a */
    private final String f18717a = "^lib/(arm.*|x86.*)/libapkprotect\\.so$";

    /* renamed from: b */
    private final String f18718b = "^assets/(.*)/apkprotect(.*)\\.bin$";

    /* renamed from: c */
    private final String f18719c = "META-INF/APKPROTECT.RSA";

    /* renamed from: d */
    private final String f18720d = "META-INF/APKPROTECT.SF";

    /* renamed from: e */
    private boolean f18721e = false;

    /* renamed from: f */
    private int f18722f = 0;

    /* renamed from: g */
    private int f18723g = 0;

    /* renamed from: h */
    private int f18724h = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18721e) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libapkprotect\\.so$")) {
            this.f18722f++;
        } else if (str.matches("^assets/(.*)/apkprotect(.*)\\.bin$")) {
            this.f18723g++;
        } else if (this.f18719c.equals(str) || this.f18720d.equals(str)) {
            this.f18724h++;
        }
        this.f18721e = m19105c() >= 3;
    }

    /* renamed from: c */
    private int m19105c() {
        int i = 0;
        if (this.f18722f > 0) {
            i = 1;
        }
        return i + this.f18723g + this.f18724h;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "APKProtect 9.x";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18721e;
    }
}
