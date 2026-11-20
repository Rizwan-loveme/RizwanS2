package ru.maximoff.apktool.util.p305c;

/* compiled from: GPresto.java */
/* renamed from: ru.maximoff.apktool.util.c.aw */
/* loaded from: classes.dex */
public class C3142aw extends AbstractC3187d {

    /* renamed from: a */
    private final String f18575a = "^lib/(arm.*|x86.*)/libATG_L\\.so$";

    /* renamed from: b */
    private final String f18576b = "^assets/ATG_E.*\\.sec$";

    /* renamed from: c */
    private final String f18577c = "assets/libData.so";

    /* renamed from: d */
    private boolean f18578d = false;

    /* renamed from: e */
    private int f18579e = 0;

    /* renamed from: f */
    private int f18580f = 0;

    /* renamed from: g */
    private int f18581g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18578d) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libATG_L\\.so$")) {
            this.f18579e++;
        }
        if (str.matches("^assets/ATG_E.*\\.sec$")) {
            this.f18580f++;
        }
        if (str.equals("assets/libData.so")) {
            this.f18581g++;
        }
        if ((this.f18579e <= 0 || this.f18580f <= 0) && ((this.f18579e <= 0 || this.f18581g <= 0) && (this.f18580f <= 0 || this.f18581g <= 0))) {
            return;
        }
        this.f18578d = true;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "G-Presto (anti-cheat)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18578d;
    }
}
