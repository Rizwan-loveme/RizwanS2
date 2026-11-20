package ru.maximoff.apktool.util.p305c;

/* compiled from: Vkey.java */
/* renamed from: ru.maximoff.apktool.util.c.cj */
/* loaded from: classes.dex */
public class C3183cj extends AbstractC3187d {

    /* renamed from: a */
    private final String f18785a = "^lib/(arm.*|x86.*)/libvosWrapperEx\\.so$";

    /* renamed from: b */
    private final String f18786b = "^lib/(arm.*|x86.*)/libvtap\\.so$";

    /* renamed from: c */
    private final String f18787c = "^lib/(arm.*|x86.*)/libloadTA\\.so$";

    /* renamed from: d */
    private final String f18788d = "^lib/(arm.*|x86.*)/libchecks\\.so$";

    /* renamed from: e */
    private final String f18789e = "assets/firmware";

    /* renamed from: f */
    private final String f18790f = "assets/kernel.bin";

    /* renamed from: g */
    private final String f18791g = "assets/signature";

    /* renamed from: h */
    private final String f18792h = "assets/vkeylicensepack";

    /* renamed from: i */
    private final String f18793i = "assets/vkwbc_ta.bin";

    /* renamed from: j */
    private final String f18794j = "assets/voscodesign.vky";

    /* renamed from: k */
    private boolean f18795k = false;

    /* renamed from: l */
    private int f18796l = 0;

    /* renamed from: m */
    private int f18797m = 0;

    /* renamed from: n */
    private int f18798n = 0;

    /* renamed from: o */
    private int f18799o = 0;

    /* renamed from: p */
    private int f18800p = 0;

    /* renamed from: q */
    private int f18801q = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18795k) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libvosWrapperEx\\.so$")) {
            this.f18796l++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libvtap\\.so$")) {
            this.f18797m++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libloadTA\\.so$")) {
            this.f18798n++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libchecks\\.so$")) {
            this.f18799o++;
        } else if (this.f18789e.equals(str) || this.f18790f.equals(str) || this.f18791g.equals(str)) {
            this.f18800p++;
        } else if (this.f18792h.equals(str) || this.f18793i.equals(str) || this.f18794j.equals(str)) {
            this.f18801q++;
        }
        this.f18795k = m19106c() >= 2 && this.f18800p > 0 && this.f18801q > 0;
    }

    /* renamed from: c */
    private int m19106c() {
        int i = 0;
        if (this.f18796l > 0) {
            i = 1;
        }
        if (this.f18797m > 0) {
            i++;
        }
        if (this.f18798n > 0) {
            i++;
        }
        if (this.f18799o > 0) {
            return i + 1;
        }
        return i;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Vkey (V-OS App Protection)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18795k;
    }
}
