package ru.maximoff.apktool.util.p305c;

/* compiled from: AppSuit.java */
/* renamed from: ru.maximoff.apktool.util.c.v */
/* loaded from: classes.dex */
public class C3205v extends AbstractC3187d {

    /* renamed from: a */
    private final String f18904a = "assets/appsuit/momo";

    /* renamed from: b */
    private final String f18905b = "assets/appsuit/meme";

    /* renamed from: c */
    private final String f18906c = "libAppSuit.so";

    /* renamed from: d */
    private boolean f18907d = false;

    /* renamed from: e */
    private int f18908e = 0;

    /* renamed from: f */
    private int f18909f = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18907d) {
            return;
        }
        if (m19107a(str, "libAppSuit.so")) {
            this.f18908e++;
        }
        if (this.f18904a.equals(str) || this.f18905b.equals(str)) {
            this.f18909f++;
        }
        this.f18907d = this.f18908e > 0 && this.f18909f > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AppSuit";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18907d;
    }
}
