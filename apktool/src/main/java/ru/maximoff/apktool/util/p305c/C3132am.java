package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtector4.java */
/* renamed from: ru.maximoff.apktool.util.c.am */
/* loaded from: classes.dex */
public class C3132am extends AbstractC3187d {

    /* renamed from: a */
    private final String f18518a = "^assets/dp\\.(arm-v7|arm-v8|x86|x86_64)\\.so\\.[A-Za-z0-9]{2,8}\\.mp3$";

    /* renamed from: b */
    private final String f18519b = "^assets/[A-Za-z0-9]{2,8}\\.mp3$";

    /* renamed from: c */
    private boolean f18520c = false;

    /* renamed from: d */
    private int f18521d = 0;

    /* renamed from: e */
    private int f18522e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18520c) {
            return;
        }
        if (str.matches("^assets/dp\\.(arm-v7|arm-v8|x86|x86_64)\\.so\\.[A-Za-z0-9]{2,8}\\.mp3$")) {
            this.f18521d++;
        }
        if (str.matches("^assets/[A-Za-z0-9]{2,8}\\.mp3$")) {
            this.f18522e++;
        }
        this.f18520c = this.f18521d > 0 && this.f18522e > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtector";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18520c;
    }
}
