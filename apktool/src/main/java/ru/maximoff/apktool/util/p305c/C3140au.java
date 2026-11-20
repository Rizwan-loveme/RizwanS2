package ru.maximoff.apktool.util.p305c;

/* compiled from: Fortify.java */
/* renamed from: ru.maximoff.apktool.util.c.au */
/* loaded from: classes.dex */
public class C3140au extends AbstractC3187d {

    /* renamed from: a */
    private final String f18562a = "libNSaferOnly.so";

    /* renamed from: b */
    private boolean f18563b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18563b) {
            return;
        }
        this.f18563b = m19107a(str, "libNSaferOnly.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "App Fortify";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18563b;
    }
}
