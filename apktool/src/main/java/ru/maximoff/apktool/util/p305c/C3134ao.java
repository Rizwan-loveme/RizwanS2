package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtectorAIDE.java */
/* renamed from: ru.maximoff.apktool.util.c.ao */
/* loaded from: classes.dex */
public class C3134ao extends AbstractC3187d {

    /* renamed from: a */
    private final String f18530a = "assets/classes.dex.dat";

    /* renamed from: b */
    private final String f18531b = "assets/dp-lib/dp.kotlin-v1.lua.mph";

    /* renamed from: c */
    private boolean f18532c = false;

    /* renamed from: d */
    private int f18533d = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18532c) {
            return;
        }
        if (this.f18530a.equals(str) || this.f18531b.equals(str)) {
            this.f18533d++;
        }
        this.f18532c = this.f18533d >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtector for AIDE";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18532c;
    }
}
