package ru.maximoff.apktool.util.p305c;

/* compiled from: Qihoo.java */
/* renamed from: ru.maximoff.apktool.util.c.bt */
/* loaded from: classes.dex */
public class C3166bt extends AbstractC3187d {

    /* renamed from: a */
    private final String f18689a = "libprotectClass.so";

    /* renamed from: b */
    private boolean f18690b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18690b) {
            return;
        }
        this.f18690b = m19107a(str, "libprotectClass.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Qihoo 360";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18690b;
    }
}
