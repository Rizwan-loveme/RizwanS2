package ru.maximoff.apktool.util.p305c;

/* compiled from: Secenh.java */
/* renamed from: ru.maximoff.apktool.util.c.bv */
/* loaded from: classes.dex */
public class C3168bv extends AbstractC3187d {

    /* renamed from: a */
    private final String f18695a = "assets/libsecenh.so";

    /* renamed from: b */
    private final String f18696b = "assets/libsecenh_x86.so";

    /* renamed from: c */
    private final String f18697c = "assets/respatcher.jar";

    /* renamed from: d */
    private final String f18698d = "assets/res.zip";

    /* renamed from: e */
    private boolean f18699e = false;

    /* renamed from: f */
    private int f18700f = 0;

    /* renamed from: g */
    private int f18701g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18699e) {
            return;
        }
        if (this.f18695a.equals(str) || this.f18696b.equals(str)) {
            this.f18700f++;
        } else if (this.f18697c.equals(str) || this.f18698d.equals(str)) {
            this.f18701g++;
        }
        this.f18699e = this.f18700f > 0 && this.f18701g > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Secenh";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18699e;
    }
}
