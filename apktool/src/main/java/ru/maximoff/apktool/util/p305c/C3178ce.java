package ru.maximoff.apktool.util.p305c;

/* compiled from: Unicom.java */
/* renamed from: ru.maximoff.apktool.util.c.ce */
/* loaded from: classes.dex */
public class C3178ce extends AbstractC3187d {

    /* renamed from: a */
    private final String f18759a = "libdecrypt.jar";

    /* renamed from: b */
    private final String f18760b = "libunicomsdk.jar";

    /* renamed from: c */
    private final String f18761c = "classes.jar";

    /* renamed from: d */
    private boolean f18762d = false;

    /* renamed from: e */
    private int f18763e = 0;

    /* renamed from: f */
    private int f18764f = 0;

    /* renamed from: g */
    private int f18765g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18762d) {
            return;
        }
        if (m19107a(str, "libdecrypt.jar")) {
            this.f18763e++;
        } else if (m19107a(str, "libunicomsdk.jar")) {
            this.f18764f++;
        } else if (m19107a(str, "classes.jar")) {
            this.f18765g++;
        }
        this.f18762d = this.f18764f > 0 && (this.f18763e > 0 || this.f18765g > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Unicom SDK Loader";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18762d;
    }
}
