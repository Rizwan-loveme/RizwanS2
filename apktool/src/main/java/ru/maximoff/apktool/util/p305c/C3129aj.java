package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtector.java */
/* renamed from: ru.maximoff.apktool.util.c.aj */
/* loaded from: classes.dex */
public class C3129aj extends AbstractC3187d {

    /* renamed from: a */
    private final String f18477a = "assets/dp.arm.so.dat";

    /* renamed from: b */
    private final String f18478b = "assets/dp.arm-v7.so.dat";

    /* renamed from: c */
    private final String f18479c = "assets/dp.arm-v8.so.dat";

    /* renamed from: d */
    private final String f18480d = "assets/dp.x86.so.dat";

    /* renamed from: e */
    private final String f18481e = "assets/dp.x86_64.so.dat";

    /* renamed from: f */
    private final String f18482f = "^assets/libdexprotect_(arm|arm64|x86|x86_64)\\.so$";

    /* renamed from: g */
    private final String f18483g = "assets/classes.dex.dat";

    /* renamed from: h */
    private final String f18484h = "assets/classes1.dex.dat";

    /* renamed from: i */
    private final String f18485i = "assets/classes2.dex.dat";

    /* renamed from: j */
    private final String f18486j = "assets/classes3.dex.dat";

    /* renamed from: k */
    private final String f18487k = "assets/resources.dat";

    /* renamed from: l */
    private final String f18488l = "assets/dp.mp3";

    /* renamed from: m */
    private final String f18489m = "assets/classes.dat";

    /* renamed from: n */
    private boolean f18490n = false;

    /* renamed from: o */
    private int f18491o = 0;

    /* renamed from: p */
    private int f18492p = 0;

    /* renamed from: q */
    private int f18493q = 0;

    /* renamed from: r */
    private int f18494r = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18490n) {
            return;
        }
        if (this.f18477a.equals(str) || this.f18478b.equals(str) || this.f18479c.equals(str) || this.f18480d.equals(str) || this.f18481e.equals(str)) {
            this.f18491o++;
        }
        if (this.f18483g.equals(str) || this.f18484h.equals(str) || this.f18485i.equals(str) || this.f18486j.equals(str) || this.f18487k.equals(str) || this.f18488l.equals(str)) {
            this.f18492p++;
        }
        if (str.matches("^assets/libdexprotect_(arm|arm64|x86|x86_64)\\.so$")) {
            this.f18493q++;
        } else if (this.f18489m.equals(str)) {
            this.f18494r++;
        }
        this.f18490n = (this.f18491o > 0 && this.f18492p > 0) || (this.f18493q > 0 && this.f18494r > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtector";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18490n;
    }
}
