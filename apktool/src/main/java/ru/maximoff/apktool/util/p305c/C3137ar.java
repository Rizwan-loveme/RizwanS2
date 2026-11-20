package ru.maximoff.apktool.util.p305c;

/* compiled from: DxShield.java */
/* renamed from: ru.maximoff.apktool.util.c.ar */
/* loaded from: classes.dex */
public class C3137ar extends AbstractC3187d {

    /* renamed from: a */
    private final String f18550a = "libdxbase.so";

    /* renamed from: b */
    private final String f18551b = "assets/DXINFO.XML";

    /* renamed from: c */
    private boolean f18552c = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18552c) {
            return;
        }
        this.f18552c = this.f18551b.equals(str) || m19107a(str, "libdxbase.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DxShield";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18552c;
    }
}
