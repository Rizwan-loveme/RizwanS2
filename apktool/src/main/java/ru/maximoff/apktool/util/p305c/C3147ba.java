package ru.maximoff.apktool.util.p305c;

/* compiled from: Jiagu.java */
/* renamed from: ru.maximoff.apktool.util.c.ba */
/* loaded from: classes.dex */
public class C3147ba extends AbstractC3187d {

    /* renamed from: a */
    private final String f18605a = "libjiagu.so";

    /* renamed from: b */
    private final String f18606b = "libjiagu_art.so";

    /* renamed from: c */
    private boolean f18607c = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18607c) {
            return;
        }
        this.f18607c = m19107a(str, "libjiagu.so") || m19107a(str, "libjiagu_art.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Jiagu";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18607c;
    }
}
