package ru.maximoff.apktool.util.p305c;

/* compiled from: Approov.java */
/* renamed from: ru.maximoff.apktool.util.c.w */
/* loaded from: classes.dex */
public class C3206w extends AbstractC3187d {

    /* renamed from: a */
    private final String f18910a = "libapproov.so";

    /* renamed from: b */
    private final String f18911b = "assets/cbconfig.JSON";

    /* renamed from: c */
    private boolean f18912c = false;

    /* renamed from: d */
    private int f18913d = 0;

    /* renamed from: e */
    private int f18914e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18912c) {
            return;
        }
        if (m19107a(str, "libapproov.so")) {
            this.f18913d++;
        }
        if (this.f18911b.equals(str)) {
            this.f18914e++;
        }
        this.f18912c = this.f18913d > 0 && this.f18914e > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Approov";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18912c;
    }
}
