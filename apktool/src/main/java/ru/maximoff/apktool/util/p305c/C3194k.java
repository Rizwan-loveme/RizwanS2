package ru.maximoff.apktool.util.p305c;

/* compiled from: ApkEncryptor.java */
/* renamed from: ru.maximoff.apktool.util.c.k */
/* loaded from: classes.dex */
public class C3194k extends AbstractC3187d {

    /* renamed from: a */
    private final String f18847a = "src/2ba5b2615b9b71b48c7694d6489e0171";

    /* renamed from: b */
    private final String f18848b = "src/2e15f58d32a5ff652706ef41ec85a763";

    /* renamed from: c */
    private final String f18849c = "src/3676d55f84497cbeadfc614c1b1b62fc";

    /* renamed from: d */
    private boolean f18850d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18850d) {
            return;
        }
        if (this.f18847a.equals(str) || this.f18848b.equals(str) || this.f18849c.equals(str)) {
            this.f18850d = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "ApkEncryptor";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18850d;
    }
}
