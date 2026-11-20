package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtector5.java */
/* renamed from: ru.maximoff.apktool.util.c.an */
/* loaded from: classes.dex */
public class C3133an extends AbstractC3187d {

    /* renamed from: a */
    private final String f18523a = "^assets/[A-Za-z0-9]{3,64}\\.mp3$";

    /* renamed from: b */
    private final String f18524b = "^assets/[A-Za-z0-9]{3,64}\\.dat$";

    /* renamed from: c */
    private final String f18525c = "^lib/(arm.*|x86.*)/libdexprotector\\.[A-Za-z0-9.]{2,16}\\.so$";

    /* renamed from: d */
    private final String f18526d = "^lib/(arm.*|x86.*)/libalice\\.so$";

    /* renamed from: e */
    private boolean f18527e = false;

    /* renamed from: f */
    private int f18528f = 0;

    /* renamed from: g */
    private int f18529g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18527e) {
            return;
        }
        if (str.matches("^assets/[A-Za-z0-9]{3,64}\\.mp3$") || str.matches("^assets/[A-Za-z0-9]{3,64}\\.dat$")) {
            this.f18528f++;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libdexprotector\\.[A-Za-z0-9.]{2,16}\\.so$") || str.matches("^lib/(arm.*|x86.*)/libalice\\.so$")) {
            this.f18529g++;
        }
        this.f18527e = this.f18528f > 0 && this.f18529g > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtector";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18527e;
    }
}
