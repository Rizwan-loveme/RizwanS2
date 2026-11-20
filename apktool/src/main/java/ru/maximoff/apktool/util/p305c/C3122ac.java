package ru.maximoff.apktool.util.p305c;

/* compiled from: Build38.java */
/* renamed from: ru.maximoff.apktool.util.c.ac */
/* loaded from: classes.dex */
public class C3122ac extends AbstractC3187d {

    /* renamed from: a */
    private final String f18429a = "^lib/(arm.*|x86.*)/libtak\\.so$";

    /* renamed from: b */
    private final String f18430b = "__license.tak";

    /* renamed from: c */
    private final String f18431c = "license.tak";

    /* renamed from: d */
    private boolean f18432d = false;

    /* renamed from: e */
    private int f18433e = 0;

    /* renamed from: f */
    private int f18434f = 0;

    /* renamed from: g */
    private int f18435g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18432d) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libtak\\.so$")) {
            this.f18433e++;
        }
        if (m19107a(str, "__license.tak")) {
            this.f18434f++;
        }
        if (m19107a(str, "license.tak")) {
            this.f18435g++;
        }
        if ((this.f18433e <= 0 || this.f18434f <= 0) && ((this.f18433e <= 0 || this.f18435g <= 0) && (this.f18434f <= 0 || this.f18435g <= 0))) {
            return;
        }
        this.f18432d = true;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Build38";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18432d;
    }
}
