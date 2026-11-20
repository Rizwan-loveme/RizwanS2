package ru.maximoff.apktool.util.p305c;

/* compiled from: AppDefence.java */
/* renamed from: ru.maximoff.apktool.util.c.p */
/* loaded from: classes.dex */
public class C3199p extends AbstractC3187d {

    /* renamed from: a */
    private final String f18868a = "assets/appdefence_xml";

    /* renamed from: b */
    private boolean f18869b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18869b) {
            return;
        }
        this.f18869b = this.f18868a.equals(str);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "ExTrus AppDefence";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18869b;
    }
}
