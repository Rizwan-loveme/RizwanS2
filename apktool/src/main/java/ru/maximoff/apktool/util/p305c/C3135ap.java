package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtectorAIDE2.java */
/* renamed from: ru.maximoff.apktool.util.c.ap */
/* loaded from: classes.dex */
public class C3135ap extends AbstractC3187d {

    /* renamed from: a */
    private final String f18534a = "assets/dexprotect/classes.dex.dat";

    /* renamed from: b */
    private final String f18535b = "assets/eprotect.dat";

    /* renamed from: c */
    private final String f18536c = "dexpro-build.properties";

    /* renamed from: d */
    private boolean f18537d = false;

    /* renamed from: e */
    private int f18538e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18537d) {
            return;
        }
        if (this.f18534a.equals(str) || this.f18535b.equals(str) || m19107a(str, "dexpro-build.properties")) {
            this.f18538e++;
        }
        this.f18537d = this.f18538e >= 3;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtector for AIDE";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18537d;
    }
}
