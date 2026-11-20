package ru.maximoff.apktool.util.p305c;

/* compiled from: ApkPacker.java */
/* renamed from: ru.maximoff.apktool.util.c.l */
/* loaded from: classes.dex */
public class C3195l extends AbstractC3187d {

    /* renamed from: a */
    private final String f18851a = "assets/ApkPacker/apkPackerConfiguration";

    /* renamed from: b */
    private final String f18852b = "assets/ApkPacker/classes.dex";

    /* renamed from: c */
    private boolean f18853c = false;

    /* renamed from: d */
    private int f18854d = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18853c) {
            return;
        }
        if (this.f18851a.equals(str) || this.f18852b.equals(str)) {
            this.f18854d++;
        }
        this.f18853c = this.f18854d >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "ApkPacker";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18853c;
    }
}
