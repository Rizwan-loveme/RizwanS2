package ru.maximoff.apktool.util.p305c;

/* compiled from: Pairip.java */
/* renamed from: ru.maximoff.apktool.util.c.bp */
/* loaded from: classes.dex */
public class C3162bp extends AbstractC3187d {

    /* renamed from: a */
    private final String f18669a = "^lib/(arm.*|x86.*)/libpairipcore\\.so$";

    /* renamed from: b */
    private boolean f18670b = false;

    /* renamed from: c */
    private boolean f18671c;

    public C3162bp(boolean z) {
        this.f18671c = false;
        this.f18671c = z;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18671c && !this.f18670b) {
            this.f18670b = str.matches("^lib/(arm.*|x86.*)/libpairipcore\\.so$");
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Pairip Protection";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18670b;
    }
}
