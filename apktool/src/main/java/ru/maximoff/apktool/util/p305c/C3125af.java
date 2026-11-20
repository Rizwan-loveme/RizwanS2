package ru.maximoff.apktool.util.p305c;

/* compiled from: DPTShell.java */
/* renamed from: ru.maximoff.apktool.util.c.af */
/* loaded from: classes.dex */
public class C3125af extends AbstractC3187d {

    /* renamed from: a */
    private final String f18442a = "^assets/(.*)/(arm.*|x86.*)/libdpt\\.so$";

    /* renamed from: b */
    private final String f18443b = "assets/app_name";

    /* renamed from: c */
    private final String f18444c = "assets/app_acf";

    /* renamed from: d */
    private boolean f18445d = false;

    /* renamed from: e */
    private int f18446e = 0;

    /* renamed from: f */
    private int f18447f = 0;

    /* renamed from: g */
    private int f18448g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18445d) {
            return;
        }
        if (str.matches("^assets/(.*)/(arm.*|x86.*)/libdpt\\.so$")) {
            this.f18446e++;
        } else if (this.f18443b.equals(str)) {
            this.f18447f++;
        } else if (this.f18444c.equals(str)) {
            this.f18448g++;
        }
        this.f18445d = this.f18446e > 0 && (this.f18447f > 0 || this.f18448g > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DPT Shell";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18445d;
    }
}
