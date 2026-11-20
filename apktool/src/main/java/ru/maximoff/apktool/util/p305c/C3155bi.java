package ru.maximoff.apktool.util.p305c;

/* compiled from: Medusah.java */
/* renamed from: ru.maximoff.apktool.util.c.bi */
/* loaded from: classes.dex */
public class C3155bi extends AbstractC3187d {

    /* renamed from: a */
    private final String f18651a = "libmd.so";

    /* renamed from: b */
    private boolean f18652b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18652b) {
            return;
        }
        this.f18652b = m19107a(str, "libmd.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Medusah";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18652b;
    }
}
