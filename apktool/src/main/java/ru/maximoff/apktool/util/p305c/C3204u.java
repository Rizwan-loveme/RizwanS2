package ru.maximoff.apktool.util.p305c;

/* compiled from: AppShield.java */
/* renamed from: ru.maximoff.apktool.util.c.u */
/* loaded from: classes.dex */
public class C3204u extends AbstractC3187d {

    /* renamed from: a */
    private final String f18902a = "^lib/(arm.*|x86.*)/libahope(.*)\\.so$";

    /* renamed from: b */
    private boolean f18903b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18903b) {
            return;
        }
        this.f18903b = str.matches("^lib/(arm.*|x86.*)/libahope(.*)\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Ahope AppShield";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18903b;
    }
}
