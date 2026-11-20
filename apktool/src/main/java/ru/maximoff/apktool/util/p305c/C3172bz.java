package ru.maximoff.apktool.util.p305c;

/* compiled from: Tencent2.java */
/* renamed from: ru.maximoff.apktool.util.c.bz */
/* loaded from: classes.dex */
public class C3172bz extends AbstractC3187d {

    /* renamed from: a */
    private final String f18715a = "^lib/(arm.*|x86.*)/libshell(a|x)-\\d+\\.\\d+\\.\\d+\\.\\d+\\.so$";

    /* renamed from: b */
    private boolean f18716b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18716b) {
            return;
        }
        this.f18716b = str.matches("^lib/(arm.*|x86.*)/libshell(a|x)-\\d+\\.\\d+\\.\\d+\\.\\d+\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Mobile Tencent Protect";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18716b;
    }
}
