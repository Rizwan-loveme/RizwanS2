package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtector2.java */
/* renamed from: ru.maximoff.apktool.util.c.ak */
/* loaded from: classes.dex */
public class C3130ak extends AbstractC3187d {

    /* renamed from: a */
    private final String f18495a = "assets/dp.arm-v7.art.kk.so";

    /* renamed from: b */
    private final String f18496b = "assets/dp.arm-v7.art.l.so";

    /* renamed from: c */
    private final String f18497c = "assets/dp.arm-v7.dvm.so";

    /* renamed from: d */
    private final String f18498d = "assets/dp.arm.art.kk.so";

    /* renamed from: e */
    private final String f18499e = "assets/dp.arm.art.l.so";

    /* renamed from: f */
    private final String f18500f = "assets/dp.arm.dvm.so";

    /* renamed from: g */
    private final String f18501g = "assets/dp.x86.art.kk.so";

    /* renamed from: h */
    private final String f18502h = "assets/dp.x86.art.l.so";

    /* renamed from: i */
    private final String f18503i = "assets/dp.x86.dvm.so";

    /* renamed from: j */
    private final String f18504j = "assets/dp.mp3";

    /* renamed from: k */
    private boolean f18505k = false;

    /* renamed from: l */
    private int f18506l = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18505k) {
            return;
        }
        if (this.f18495a.equals(str) || this.f18496b.equals(str) || this.f18497c.equals(str) || this.f18498d.equals(str) || this.f18499e.equals(str) || this.f18500f.equals(str) || this.f18501g.equals(str) || this.f18502h.equals(str) || this.f18503i.equals(str) || this.f18504j.equals(str)) {
            this.f18506l++;
        }
        this.f18505k = this.f18506l >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtector";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18505k;
    }
}
