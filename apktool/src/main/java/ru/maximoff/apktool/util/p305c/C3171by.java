package ru.maximoff.apktool.util.p305c;

/* compiled from: Tencent.java */
/* renamed from: ru.maximoff.apktool.util.c.by */
/* loaded from: classes.dex */
public class C3171by extends AbstractC3187d {

    /* renamed from: a */
    private final String f18711a = "^lib/(arm.*|x86.*)/libshell\\.so$";

    /* renamed from: b */
    private final String f18712b = "^lib/(arm.*|x86.*)/libmobisecy\\.so$";

    /* renamed from: c */
    private final String f18713c = "/mix.dex";

    /* renamed from: d */
    private boolean f18714d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18714d) {
            return;
        }
        this.f18714d = str.matches("^lib/(arm.*|x86.*)/libshell\\.so$") || str.matches("^lib/(arm.*|x86.*)/libmobisecy\\.so$") || str.endsWith("/mix.dex");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Mobile Tencent Protect";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18714d;
    }
}
