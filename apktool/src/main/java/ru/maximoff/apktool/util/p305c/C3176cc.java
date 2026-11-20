package ru.maximoff.apktool.util.p305c;

/* compiled from: Tencent5.java */
/* renamed from: ru.maximoff.apktool.util.c.cc */
/* loaded from: classes.dex */
public class C3176cc extends AbstractC3187d {

    /* renamed from: a */
    private final String f18743a = "^lib/(arm.*|x86.*)/libshell-superv(.*)\\.\\d{4}\\.so$";

    /* renamed from: b */
    private final String f18744b = "^assets/dexMethod.*\\.dat$";

    /* renamed from: c */
    private boolean f18745c = false;

    /* renamed from: d */
    private int f18746d = 0;

    /* renamed from: e */
    private int f18747e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18745c) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libshell-superv(.*)\\.\\d{4}\\.so$")) {
            this.f18746d++;
        } else if (str.matches("^assets/dexMethod.*\\.dat$")) {
            this.f18747e++;
        }
        this.f18745c = this.f18747e > 0 && this.f18746d > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Tencent Security Enterprise Edition";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18745c;
    }
}
