package ru.maximoff.apktool.util.p305c;

/* compiled from: EpicVM.java */
/* renamed from: ru.maximoff.apktool.util.c.as */
/* loaded from: classes.dex */
public class C3138as extends AbstractC3187d {

    /* renamed from: a */
    private final String f18553a = "^lib/(arm.*|x86.*)/libEpic_Vm\\.so$";

    /* renamed from: b */
    private boolean f18554b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18554b) {
            return;
        }
        this.f18554b = str.matches("^lib/(arm.*|x86.*)/libEpic_Vm\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Epic VM";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18554b;
    }
}
