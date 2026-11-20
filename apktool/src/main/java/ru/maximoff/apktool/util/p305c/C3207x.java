package ru.maximoff.apktool.util.p305c;

/* compiled from: BShield.java */
/* renamed from: ru.maximoff.apktool.util.c.x */
/* loaded from: classes.dex */
public class C3207x extends AbstractC3187d {

    /* renamed from: a */
    private final String f18915a = "assets/bshield.dat";

    /* renamed from: b */
    private boolean f18916b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18916b) {
            return;
        }
        this.f18916b = str.equals("assets/bshield.dat");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "BShield";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18916b;
    }
}
