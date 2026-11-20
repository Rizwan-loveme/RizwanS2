package ru.maximoff.apktool.util.p305c;

/* compiled from: AndroidRepublic2.java */
/* renamed from: ru.maximoff.apktool.util.c.j */
/* loaded from: classes.dex */
public class C3193j extends AbstractC3187d {

    /* renamed from: a */
    private final String f18845a = "^assets/androidrepublic\\.org/(.*)\\.png$";

    /* renamed from: b */
    private boolean f18846b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18846b) {
            return;
        }
        this.f18846b = str.matches("^assets/androidrepublic\\.org/(.*)\\.png$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AndroidRepublic VIP";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18846b;
    }
}
