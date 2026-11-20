package ru.maximoff.apktool.util.p305c;

/* compiled from: Alibaba2.java */
/* renamed from: ru.maximoff.apktool.util.c.h */
/* loaded from: classes.dex */
public class C3191h extends AbstractC3187d {

    /* renamed from: a */
    private final String f18832a = "^lib/(arm.*|x86.*)/lib(alisecuritysdk|demolish(data)?|reverify1)\\.so$";

    /* renamed from: b */
    private final String f18833b = "assets/ali_sec.dat";

    /* renamed from: c */
    private boolean f18834c = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18834c) {
            return;
        }
        this.f18834c = str.matches("^lib/(arm.*|x86.*)/lib(alisecuritysdk|demolish(data)?|reverify1)\\.so$") || m19107a(str, "assets/ali_sec.dat");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Alibaba Security SDK";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18834c;
    }
}
