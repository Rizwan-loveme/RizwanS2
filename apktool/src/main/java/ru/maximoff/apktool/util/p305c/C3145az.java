package ru.maximoff.apktool.util.p305c;

/* compiled from: Ijiami.java */
/* renamed from: ru.maximoff.apktool.util.c.az */
/* loaded from: classes.dex */
public class C3145az extends AbstractC3187d {

    /* renamed from: a */
    private final String f18589a = "assets/ijiami.dat";

    /* renamed from: b */
    private final String f18590b = "ijiami.ajm";

    /* renamed from: c */
    private final String f18591c = "assets/ijm_lib/";

    /* renamed from: d */
    private boolean f18592d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18592d) {
            return;
        }
        this.f18592d = this.f18589a.equals(str) || m19107a(str, "ijiami.ajm") || str.startsWith("assets/ijm_lib/");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Ijiami";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18592d;
    }
}
