package ru.maximoff.apktool.util.p305c;

/* compiled from: Kony.java */
/* renamed from: ru.maximoff.apktool.util.c.bf */
/* loaded from: classes.dex */
public class C3152bf extends AbstractC3187d {

    /* renamed from: a */
    private final String f18634a = "libkonyjsvm.so";

    /* renamed from: b */
    private final String f18635b = "assets/application.properties";

    /* renamed from: c */
    private final String f18636c = "assets/js/startup.js";

    /* renamed from: d */
    private boolean f18637d = false;

    /* renamed from: e */
    private int f18638e = 0;

    /* renamed from: f */
    private int f18639f = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18637d) {
            return;
        }
        if (m19107a(str, "libkonyjsvm.so")) {
            this.f18638e++;
        } else if (this.f18635b.equals(str) || this.f18636c.equals(str)) {
            this.f18639f++;
        }
        this.f18637d = this.f18638e > 0 && this.f18639f >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Kony";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18637d;
    }
}
