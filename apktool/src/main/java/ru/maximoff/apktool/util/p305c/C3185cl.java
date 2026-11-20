package ru.maximoff.apktool.util.p305c;

/* compiled from: qdbh.java */
/* renamed from: ru.maximoff.apktool.util.c.cl */
/* loaded from: classes.dex */
public class C3185cl extends AbstractC3187d {

    /* renamed from: a */
    private final String f18809a = "assets/qdbh";

    /* renamed from: b */
    private boolean f18810b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18810b) {
            return;
        }
        this.f18810b = this.f18809a.equals(str);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "qdbh packer";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18810b;
    }
}
