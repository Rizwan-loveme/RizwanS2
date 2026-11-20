package ru.maximoff.apktool.util.p305c;

/* compiled from: Zimperium.java */
/* renamed from: ru.maximoff.apktool.util.c.ck */
/* loaded from: classes.dex */
public class C3184ck extends AbstractC3187d {

    /* renamed from: a */
    private final String f18802a = "^lib/(arm.*|x86.*)/lib.*\\.so$";

    /* renamed from: b */
    private final String f18803b = "^assets/.*/0\\.odex$";

    /* renamed from: c */
    private final String f18804c = "^assets/.*\\.szip$";

    /* renamed from: d */
    private boolean f18805d = false;

    /* renamed from: e */
    private int f18806e = 0;

    /* renamed from: f */
    private int f18807f = 0;

    /* renamed from: g */
    private int f18808g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18805d) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/lib.*\\.so$")) {
            this.f18806e++;
        } else if (str.matches("^assets/.*/0\\.odex$")) {
            this.f18807f++;
        } else if (str.matches("^assets/.*\\.szip$")) {
            this.f18808g++;
        }
        this.f18805d = this.f18807f > 0 && this.f18806e > 0 && this.f18808g > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Zimperium (zShield)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18805d;
    }
}
