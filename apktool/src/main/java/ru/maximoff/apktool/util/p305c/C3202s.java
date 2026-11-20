package ru.maximoff.apktool.util.p305c;

/* compiled from: AppSealing.java */
/* renamed from: ru.maximoff.apktool.util.c.s */
/* loaded from: classes.dex */
public class C3202s extends AbstractC3187d {

    /* renamed from: a */
    private final String f18891a = "libcovault.so";

    /* renamed from: b */
    private final String f18892b = "libcovault-appsec.so";

    /* renamed from: c */
    private final String f18893c = "assets/appsealing.dex";

    /* renamed from: d */
    private final String f18894d = "assets/sealed1.dex";

    /* renamed from: e */
    private boolean f18895e = false;

    /* renamed from: f */
    private int f18896f = 0;

    /* renamed from: g */
    private int f18897g = 0;

    /* renamed from: h */
    private int f18898h = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18895e) {
            return;
        }
        if (m19107a(str, "libcovault.so")) {
            this.f18896f++;
        }
        if (m19107a(str, "libcovault-appsec.so")) {
            this.f18897g++;
        }
        if (this.f18893c.equals(str) || this.f18894d.equals(str)) {
            this.f18898h++;
        }
        this.f18895e = this.f18898h >= 2 && this.f18897g > 0 && this.f18896f > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AppSealing";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18895e;
    }
}
