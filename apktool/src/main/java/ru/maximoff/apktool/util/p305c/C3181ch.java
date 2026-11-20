package ru.maximoff.apktool.util.p305c;

/* compiled from: Verimatrix.java */
/* renamed from: ru.maximoff.apktool.util.c.ch */
/* loaded from: classes.dex */
public class C3181ch extends AbstractC3187d {

    /* renamed from: a */
    private final String f18776a = "^lib/(arm.*|x86.*)/libmfjava\\.so$";

    /* renamed from: b */
    private boolean f18777b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18777b) {
            return;
        }
        this.f18777b = str.matches("^lib/(arm.*|x86.*)/libmfjava\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "InsideSecure Verimatrix";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18777b;
    }
}
