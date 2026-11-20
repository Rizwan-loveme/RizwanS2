package ru.maximoff.apktool.util.p305c;

/* compiled from: Denuvo.java */
/* renamed from: ru.maximoff.apktool.util.c.ag */
/* loaded from: classes.dex */
public class C3126ag extends AbstractC3187d {

    /* renamed from: a */
    private final String f18449a = "assets/tid";

    /* renamed from: b */
    private final String f18450b = "libvmpc.so";

    /* renamed from: c */
    private boolean f18451c = false;

    /* renamed from: d */
    private int f18452d = 0;

    /* renamed from: e */
    private int f18453e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18451c) {
            return;
        }
        if (str.equals("assets/tid")) {
            this.f18452d++;
        } else if (m19107a(str, "libvmpc.so")) {
            this.f18453e++;
        }
        this.f18451c = this.f18452d > 0 && this.f18453e > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Denuvo";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18451c;
    }
}
