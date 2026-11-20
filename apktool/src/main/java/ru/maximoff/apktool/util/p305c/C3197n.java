package ru.maximoff.apktool.util.p305c;

/* compiled from: ApkVM.java */
/* renamed from: ru.maximoff.apktool.util.c.n */
/* loaded from: classes.dex */
public class C3197n extends AbstractC3187d {

    /* renamed from: a */
    private final String f18858a = "^lib/(arm.*|x86.*)/librsprotect\\.so$";

    /* renamed from: b */
    private final String f18859b = "^lib/(arm.*|x86.*)/librsvmp\\.so$";

    /* renamed from: c */
    private boolean f18860c = false;

    /* renamed from: d */
    private int f18861d = 0;

    /* renamed from: e */
    private int f18862e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18860c) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/librsprotect\\.so$")) {
            this.f18861d++;
        } else if (str.matches("^lib/(arm.*|x86.*)/librsvmp\\.so$")) {
            this.f18862e++;
        }
        this.f18860c = this.f18861d > 0 && this.f18862e > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Apk-VM";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18860c;
    }
}
