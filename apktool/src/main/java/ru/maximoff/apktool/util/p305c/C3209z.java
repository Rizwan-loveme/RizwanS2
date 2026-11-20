package ru.maximoff.apktool.util.p305c;

/* compiled from: Bangcle.java */
/* renamed from: ru.maximoff.apktool.util.c.z */
/* loaded from: classes.dex */
public class C3209z extends AbstractC3187d {

    /* renamed from: a */
    private final String f18920a = "libsecexe.so";

    /* renamed from: b */
    private final String f18921b = "libsecmain.so";

    /* renamed from: c */
    private final String f18922c = "assets/bangcleplugin/container.dex";

    /* renamed from: d */
    private final String f18923d = "bangcleclasses.jar";

    /* renamed from: e */
    private final String f18924e = "bangcle_classes.jar";

    /* renamed from: f */
    private boolean f18925f = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18925f) {
            return;
        }
        if (this.f18922c.equals(str) || m19107a(str, "libsecexe.so") || m19107a(str, "libsecmain.so") || m19107a(str, "bangcleclasses.jar") || m19107a(str, "bangcle_classes.jar")) {
            this.f18925f = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Bangcle";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18925f;
    }
}
