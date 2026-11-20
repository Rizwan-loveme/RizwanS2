package ru.maximoff.apktool.util.p305c;

/* compiled from: APKProtect.java */
/* renamed from: ru.maximoff.apktool.util.c.a */
/* loaded from: classes.dex */
public class C3119a extends AbstractC3187d {

    /* renamed from: a */
    private final String f18407a = "apkprotect.com/key.dat";

    /* renamed from: b */
    private final String f18408b = "apkprotect.com/";

    /* renamed from: c */
    private final String f18409c = "libAPKProtect.so";

    /* renamed from: d */
    private boolean f18410d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18410d) {
            return;
        }
        if (this.f18407a.equals(str) || str.startsWith("apkprotect.com/") || m19107a(str, "libAPKProtect.so")) {
            this.f18410d = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "APKProtect";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18410d;
    }
}
