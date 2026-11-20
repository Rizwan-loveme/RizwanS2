package ru.maximoff.apktool.util.p305c;

/* compiled from: Obfuscapk.java */
/* renamed from: ru.maximoff.apktool.util.c.bo */
/* loaded from: classes.dex */
public class C3161bo extends AbstractC3187d {

    /* renamed from: a */
    private final String f18666a = "^assets/lib\\.arm(eabi|64)-v[0-9a-zA-Z]{2}\\.[!-~]+\\.so$";

    /* renamed from: b */
    private final String f18667b = "^assets/lib\\.x86(_64)?\\.[!-~]+\\.so$";

    /* renamed from: c */
    private boolean f18668c = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18668c) {
            return;
        }
        this.f18668c = str.matches("^assets/lib\\.arm(eabi|64)-v[0-9a-zA-Z]{2}\\.[!-~]+\\.so$") || str.matches("^assets/lib\\.x86(_64)?\\.[!-~]+\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Obfuscapk";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18668c;
    }
}
