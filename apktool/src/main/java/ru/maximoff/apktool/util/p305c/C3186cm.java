package ru.maximoff.apktool.util.p305c;

/* compiled from: yidun.java */
/* renamed from: ru.maximoff.apktool.util.c.cm */
/* loaded from: classes.dex */
public class C3186cm extends AbstractC3187d {

    /* renamed from: a */
    private final String f18811a = "libnesec.so";

    /* renamed from: b */
    private final String f18812b = "assets/nedata.db";

    /* renamed from: c */
    private final String f18813c = "assets/nedig.properties";

    /* renamed from: d */
    private boolean f18814d = false;

    /* renamed from: e */
    private int f18815e = 0;

    /* renamed from: f */
    private int f18816f = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18814d) {
            return;
        }
        if (this.f18812b.equals(str)) {
            this.f18815e++;
        } else if (this.f18813c.equals(str)) {
            this.f18816f++;
        }
        this.f18814d = m19107a(str, "libnesec.so") || (this.f18815e > 0 && this.f18816f > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "NetEase Yidun";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18814d;
    }
}
