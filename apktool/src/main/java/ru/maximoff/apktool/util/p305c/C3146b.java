package ru.maximoff.apktool.util.p305c;

/* compiled from: APKProtect2.java */
/* renamed from: ru.maximoff.apktool.util.c.b */
/* loaded from: classes.dex */
public class C3146b extends AbstractC3187d {

    /* renamed from: a */
    private final String f18593a = "^lib/(arm.*|x86.*)/libapkprotect\\.so$";

    /* renamed from: b */
    private final String f18594b = "assets/apkprotect.bin";

    /* renamed from: c */
    private final String f18595c = "assets/apkprotect/classes.dex.bin";

    /* renamed from: d */
    private final String f18596d = "apkprotect-build.properties";

    /* renamed from: e */
    private final String f18597e = "META-INF/APKPROTECT.RSA";

    /* renamed from: f */
    private final String f18598f = "META-INF/APKPROTECT.SF";

    /* renamed from: g */
    private boolean f18599g = false;

    /* renamed from: h */
    private int f18600h = 0;

    /* renamed from: i */
    private int f18601i = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18599g) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libapkprotect\\.so$")) {
            this.f18600h++;
        } else if (this.f18594b.equals(str) || this.f18595c.equals(str) || this.f18596d.equals(str) || this.f18597e.equals(str) || this.f18598f.equals(str)) {
            this.f18601i++;
        }
        this.f18599g = (this.f18600h > 0 && this.f18601i >= 3) || this.f18601i >= 4;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "APKProtect 6.x";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18599g;
    }
}
