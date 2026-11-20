package ru.maximoff.apktool.util.p305c;

/* compiled from: Kiro.java */
/* renamed from: ru.maximoff.apktool.util.c.bd */
/* loaded from: classes.dex */
public class C3150bd extends AbstractC3187d {

    /* renamed from: a */
    private final String f18616a = "libkiroro.so";

    /* renamed from: b */
    private final String f18617b = "assets/sbox";

    /* renamed from: c */
    private boolean f18618c = false;

    /* renamed from: d */
    private int f18619d = 0;

    /* renamed from: e */
    private int f18620e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18618c) {
            return;
        }
        if (this.f18617b.equals(str)) {
            this.f18619d++;
        } else if (m19107a(str, "libkiroro.so")) {
            this.f18620e++;
        }
        this.f18618c = this.f18619d > 0 && this.f18620e > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Kiro";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18618c;
    }
}
