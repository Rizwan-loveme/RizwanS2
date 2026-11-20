package ru.maximoff.apktool.util.p305c;

/* compiled from: Bangcle2.java */
/* renamed from: ru.maximoff.apktool.util.c.aa */
/* loaded from: classes.dex */
public class C3120aa extends AbstractC3187d {

    /* renamed from: a */
    private final String f18415a = "assets/secData0.jar";

    /* renamed from: b */
    private final String f18416b = "libSecShell.so";

    /* renamed from: c */
    private final String f18417c = "libSecShell-x86.so";

    /* renamed from: d */
    private boolean f18418d = false;

    /* renamed from: e */
    private int f18419e = 0;

    /* renamed from: f */
    private int f18420f = 0;

    /* renamed from: g */
    private int f18421g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18418d) {
            return;
        }
        if (this.f18415a.equals(str)) {
            this.f18419e++;
        } else if (m19107a(str, "libSecShell.so")) {
            this.f18420f++;
        } else if (m19107a(str, "libSecShell-x86.so")) {
            this.f18421g++;
        }
        this.f18418d = this.f18419e > 0 && (this.f18420f > 0 || this.f18421g > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Bangcle (SecShell)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18418d;
    }
}
