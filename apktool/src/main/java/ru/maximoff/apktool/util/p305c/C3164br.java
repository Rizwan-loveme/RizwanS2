package ru.maximoff.apktool.util.p305c;

/* compiled from: PangXie.java */
/* renamed from: ru.maximoff.apktool.util.c.br */
/* loaded from: classes.dex */
public class C3164br extends AbstractC3187d {

    /* renamed from: a */
    private final String f18683a = "libnsecure.so";

    /* renamed from: b */
    private boolean f18684b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18684b) {
            return;
        }
        this.f18684b = m19107a(str, "libnsecure.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "PangXie";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18684b;
    }
}
