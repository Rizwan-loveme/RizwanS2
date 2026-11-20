package ru.maximoff.apktool.util.p305c;

/* compiled from: NQShield.java */
/* renamed from: ru.maximoff.apktool.util.c.bk */
/* loaded from: classes.dex */
public class C3157bk extends AbstractC3187d {

    /* renamed from: a */
    private final String f18655a = "libnqshield.so";

    /* renamed from: b */
    private final String f18656b = "nqshield";

    /* renamed from: c */
    private final String f18657c = "nqshell";

    /* renamed from: d */
    private boolean f18658d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18658d) {
            return;
        }
        this.f18658d = m19107a(str, "libnqshield.so") || m19107a(str, "nqshield") || m19107a(str, "nqshell");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "NQ Shield";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18658d;
    }
}
