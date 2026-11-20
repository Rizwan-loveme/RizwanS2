package ru.maximoff.apktool.util.p305c;

/* compiled from: AppGuard.java */
/* renamed from: ru.maximoff.apktool.util.c.q */
/* loaded from: classes.dex */
public class C3200q extends AbstractC3187d {

    /* renamed from: a */
    private final String f18870a = "assets/appguard/";

    /* renamed from: b */
    private final String f18871b = "assets/classes.sox";

    /* renamed from: c */
    private final String f18872c = "assets/AppGuard0.jar";

    /* renamed from: d */
    private final String f18873d = "assets/AppGuard.dgc";

    /* renamed from: e */
    private final String f18874e = "^lib/(arm.*|x86.*)/libAppGuard\\.so$";

    /* renamed from: f */
    private final String f18875f = "libAppGuard-x86.so";

    /* renamed from: g */
    private final String f18876g = "^lib/(arm.*|x86.*)/libcompatible(_x86)?\\.so$";

    /* renamed from: h */
    private boolean f18877h = false;

    /* renamed from: i */
    private int f18878i = 0;

    /* renamed from: j */
    private int f18879j = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18877h) {
            return;
        }
        if (str.startsWith("assets/appguard/")) {
            this.f18878i++;
        }
        if (this.f18871b.equals(str) || str.matches("^lib/(arm.*|x86.*)/libcompatible(_x86)?\\.so$")) {
            this.f18879j++;
        }
        this.f18877h = this.f18878i > 0 && this.f18879j > 0;
        if (this.f18877h) {
            return;
        }
        if (this.f18872c.equals(str) || this.f18873d.equals(str) || str.matches("^lib/(arm.*|x86.*)/libAppGuard\\.so$") || m19107a(str, "libAppGuard-x86.so")) {
            this.f18877h = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AppGuard";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18877h;
    }
}
