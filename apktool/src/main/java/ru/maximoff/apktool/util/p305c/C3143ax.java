package ru.maximoff.apktool.util.p305c;

/* compiled from: Gemalto.java */
/* renamed from: ru.maximoff.apktool.util.c.ax */
/* loaded from: classes.dex */
public class C3143ax extends AbstractC3187d {

    /* renamed from: a */
    private final String f18582a = "^lib/(arm.*|x86.*)/libmedl\\.so$";

    /* renamed from: b */
    private boolean f18583b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18583b) {
            return;
        }
        this.f18583b = str.matches("^lib/(arm.*|x86.*)/libmedl\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Gemalto";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18583b;
    }
}
