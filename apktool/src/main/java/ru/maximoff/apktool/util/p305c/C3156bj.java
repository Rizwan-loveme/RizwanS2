package ru.maximoff.apktool.util.p305c;

/* compiled from: Medusah2.java */
/* renamed from: ru.maximoff.apktool.util.c.bj */
/* loaded from: classes.dex */
public class C3156bj extends AbstractC3187d {

    /* renamed from: a */
    private final String f18653a = "assets/high_resolution.png";

    /* renamed from: b */
    private boolean f18654b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18654b) {
            return;
        }
        this.f18654b = this.f18653a.equals(str);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Medusah (AppSolid)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18654b;
    }
}
