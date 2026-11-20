package ru.maximoff.apktool.util.p305c;

/* compiled from: Alibaba.java */
/* renamed from: ru.maximoff.apktool.util.c.g */
/* loaded from: classes.dex */
public class C3190g extends AbstractC3187d {

    /* renamed from: a */
    private final String f18830a = "libmobisec.so";

    /* renamed from: b */
    private boolean f18831b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18831b) {
            return;
        }
        this.f18831b = m19107a(str, "libmobisec.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Alibaba";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18831b;
    }
}
