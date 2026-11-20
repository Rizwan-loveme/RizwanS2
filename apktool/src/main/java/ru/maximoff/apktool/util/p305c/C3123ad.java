package ru.maximoff.apktool.util.p305c;

/* compiled from: Bureau.java */
/* renamed from: ru.maximoff.apktool.util.c.ad */
/* loaded from: classes.dex */
public class C3123ad extends AbstractC3187d {

    /* renamed from: a */
    private final String f18436a = "^lib/(arm.*|x86.*)/libbureau-.*\\.so$";

    /* renamed from: b */
    private boolean f18437b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18437b) {
            return;
        }
        this.f18437b = str.matches("^lib/(arm.*|x86.*)/libbureau-.*\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Bureau";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18437b;
    }
}
