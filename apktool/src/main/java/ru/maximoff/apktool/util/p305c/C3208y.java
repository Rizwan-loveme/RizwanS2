package ru.maximoff.apktool.util.p305c;

/* compiled from: Baidu.java */
/* renamed from: ru.maximoff.apktool.util.c.y */
/* loaded from: classes.dex */
public class C3208y extends AbstractC3187d {

    /* renamed from: a */
    private final String f18917a = "libbaiduprotect.so";

    /* renamed from: b */
    private final String f18918b = "baiduprotect1.jar";

    /* renamed from: c */
    private boolean f18919c = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18919c) {
            return;
        }
        this.f18919c = m19107a(str, "libbaiduprotect.so") || m19107a(str, "baiduprotect1.jar");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Baidu";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18919c;
    }
}
