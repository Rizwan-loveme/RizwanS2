package ru.maximoff.apktool.util.p305c;

/* compiled from: Jiagu2.java */
/* renamed from: ru.maximoff.apktool.util.c.bb */
/* loaded from: classes.dex */
public class C3148bb extends AbstractC3187d {

    /* renamed from: a */
    private final String f18608a = "assets/jiagu_data.bin";

    /* renamed from: b */
    private final String f18609b = "assets/sign.bin";

    /* renamed from: c */
    private final String f18610c = "libapktoolplus_jiagu.so";

    /* renamed from: d */
    private boolean f18611d = false;

    /* renamed from: e */
    private int f18612e = 0;

    /* renamed from: f */
    private int f18613f = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18611d) {
            return;
        }
        if (this.f18608a.equals(str) || this.f18609b.equals(str)) {
            this.f18612e++;
        } else if (m19107a(str, "libapktoolplus_jiagu.so")) {
            this.f18613f++;
        }
        this.f18611d = this.f18612e >= 2 && this.f18613f > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Jiagu (ApkToolPlus)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18611d;
    }
}
