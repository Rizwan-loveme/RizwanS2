package ru.maximoff.apktool.util.p305c;

/* compiled from: ApkProtector.java */
/* renamed from: ru.maximoff.apktool.util.c.m */
/* loaded from: classes.dex */
public class C3196m extends AbstractC3187d {

    /* renamed from: a */
    private final String f18855a = "^assets/protect/cls-v\\d+\\.mz$";

    /* renamed from: b */
    private final String f18856b = "^assets/dex/classes-v\\d+\\.bin$";

    /* renamed from: c */
    private boolean f18857c = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18857c) {
            return;
        }
        this.f18857c = str.matches("^assets/protect/cls-v\\d+\\.mz$") || str.matches("^assets/dex/classes-v\\d+\\.bin$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "ApkProtector";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18857c;
    }
}
