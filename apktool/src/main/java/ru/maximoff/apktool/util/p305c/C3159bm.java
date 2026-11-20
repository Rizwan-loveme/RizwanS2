package ru.maximoff.apktool.util.p305c;

/* compiled from: Nesun.java */
/* renamed from: ru.maximoff.apktool.util.c.bm */
/* loaded from: classes.dex */
public class C3159bm extends AbstractC3187d {

    /* renamed from: a */
    private final String f18661a = "^lib/(arm.*|x86.*)/libzprotect\\.so$";

    /* renamed from: b */
    private boolean f18662b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18662b) {
            return;
        }
        this.f18662b = str.matches("^lib/(arm.*|x86.*)/libzprotect\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Nesun";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18662b;
    }
}
