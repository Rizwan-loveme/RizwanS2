package ru.maximoff.apktool.util.p305c;

/* compiled from: Venustech.java */
/* renamed from: ru.maximoff.apktool.util.c.cg */
/* loaded from: classes.dex */
public class C3180cg extends AbstractC3187d {

    /* renamed from: a */
    private final String f18774a = "^lib/(arm.*|x86.*)/libven(Sec|ustech)\\.so$";

    /* renamed from: b */
    private boolean f18775b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18775b) {
            return;
        }
        this.f18775b = str.matches("^lib/(arm.*|x86.*)/libven(Sec|ustech)\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Venustech";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18775b;
    }
}
