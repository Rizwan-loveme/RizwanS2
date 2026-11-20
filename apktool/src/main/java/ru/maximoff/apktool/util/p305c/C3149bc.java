package ru.maximoff.apktool.util.p305c;

/* compiled from: KangaPack.java */
/* renamed from: ru.maximoff.apktool.util.c.bc */
/* loaded from: classes.dex */
public class C3149bc extends AbstractC3187d {

    /* renamed from: a */
    private final String f18614a = "^lib/(arm.*|x86.*)/libapksadfsalkwes\\.so$";

    /* renamed from: b */
    private boolean f18615b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18615b) {
            return;
        }
        this.f18615b = str.matches("^lib/(arm.*|x86.*)/libapksadfsalkwes\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "KangaPack";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18615b;
    }
}
