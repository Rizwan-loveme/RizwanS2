package ru.maximoff.apktool.util.p305c;

/* compiled from: FreeRASP.java */
/* renamed from: ru.maximoff.apktool.util.c.av */
/* loaded from: classes.dex */
public class C3141av extends AbstractC3187d {

    /* renamed from: a */
    private final String f18564a = "^lib/(arm.*|x86.*)/libsecurity\\.so$";

    /* renamed from: b */
    private final String f18565b = "^lib/(arm.*|x86.*)/libpolarssl\\.so$";

    /* renamed from: c */
    private final String f18566c = "^lib/(arm.*|x86.*)/libsecurity\\.so$";

    /* renamed from: d */
    private final String f18567d = "^lib/(arm.*|x86.*)/libpolarssl\\.so$";

    /* renamed from: e */
    private final String f18568e = "assets/talsec";

    /* renamed from: f */
    private boolean f18569f = false;

    /* renamed from: g */
    private int f18570g = 0;

    /* renamed from: h */
    private int f18571h = 0;

    /* renamed from: i */
    private int f18572i = 0;

    /* renamed from: j */
    private int f18573j = 0;

    /* renamed from: k */
    private int f18574k = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18569f) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libsecurity\\.so$")) {
            this.f18570g++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libpolarssl\\.so$")) {
            this.f18571h++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libsecurity\\.so$")) {
            this.f18572i++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libpolarssl\\.so$")) {
            this.f18573j++;
        } else if (this.f18568e.equals(str)) {
            this.f18574k++;
        }
        this.f18569f = (this.f18570g > 0 && this.f18571h > 0) || (this.f18572i > 0 && this.f18573j > 0 && this.f18574k > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "FreeRASP";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18569f;
    }
}
