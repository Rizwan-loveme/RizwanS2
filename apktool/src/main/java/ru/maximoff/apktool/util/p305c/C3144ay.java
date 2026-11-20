package ru.maximoff.apktool.util.p305c;

/* compiled from: Haiyunan.java */
/* renamed from: ru.maximoff.apktool.util.c.ay */
/* loaded from: classes.dex */
public class C3144ay extends AbstractC3187d {

    /* renamed from: a */
    private final String f18584a = "^lib/(arm.*|x86.*)/libitsec\\.so$";

    /* renamed from: b */
    private final String f18585b = "assets/itse";

    /* renamed from: c */
    private boolean f18586c = false;

    /* renamed from: d */
    private int f18587d = 0;

    /* renamed from: e */
    private int f18588e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18586c) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libitsec\\.so$")) {
            this.f18587d++;
        } else if (str.equals("assets/itse")) {
            this.f18588e++;
        }
        this.f18586c = this.f18587d > 0 && this.f18588e > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Haiyun'an Security";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18586c;
    }
}
