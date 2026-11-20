package ru.maximoff.apktool.util.p305c;

/* compiled from: Naga.java */
/* renamed from: ru.maximoff.apktool.util.c.bl */
/* loaded from: classes.dex */
public class C3158bl extends AbstractC3187d {

    /* renamed from: a */
    private final String f18659a = "libddog.so";

    /* renamed from: b */
    private boolean f18660b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18660b) {
            return;
        }
        this.f18660b = m19107a(str, "libddog.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Naga";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18660b;
    }
}
