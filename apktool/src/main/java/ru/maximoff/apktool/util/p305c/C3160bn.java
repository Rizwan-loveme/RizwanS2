package ru.maximoff.apktool.util.p305c;

/* compiled from: OPPOProtect.java */
/* renamed from: ru.maximoff.apktool.util.c.bn */
/* loaded from: classes.dex */
public class C3160bn extends AbstractC3187d {

    /* renamed from: a */
    private final String f18663a = "^lib/(arm.*|x86.*)/libOPPOProtect(2019)?\\.so$";

    /* renamed from: b */
    private final String f18664b = "^lib/(arm.*|x86.*)/libomesStdSco\\.so$";

    /* renamed from: c */
    private boolean f18665c = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18665c) {
            return;
        }
        this.f18665c = str.matches("^lib/(arm.*|x86.*)/libOPPOProtect(2019)?\\.so$") || str.matches("^lib/(arm.*|x86.*)/libomesStdSco\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "OPPO Protect SDK";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18665c;
    }
}
