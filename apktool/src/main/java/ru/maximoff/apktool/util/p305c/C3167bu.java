package ru.maximoff.apktool.util.p305c;

/* compiled from: SecNeo.java */
/* renamed from: ru.maximoff.apktool.util.c.bu */
/* loaded from: classes.dex */
public class C3167bu extends AbstractC3187d {

    /* renamed from: a */
    private final String f18691a = "libDexHelper.so";

    /* renamed from: b */
    private final String f18692b = "libDexHelper-x86.so";

    /* renamed from: c */
    private final String f18693c = "assets/classes0.jar";

    /* renamed from: d */
    private boolean f18694d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18694d) {
            return;
        }
        this.f18694d = m19107a(str, "libDexHelper.so") || m19107a(str, "libDexHelper-x86.so") || this.f18693c.equals(str);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "SecNeo";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18694d;
    }
}
