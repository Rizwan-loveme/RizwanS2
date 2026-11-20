package ru.maximoff.apktool.util.p305c;

/* compiled from: LIAPP.java */
/* renamed from: ru.maximoff.apktool.util.c.bg */
/* loaded from: classes.dex */
public class C3153bg extends AbstractC3187d {

    /* renamed from: a */
    private final String f18640a = "/LIAPPEgg";

    /* renamed from: b */
    private final String f18641b = "LIAPPClient.sc";

    /* renamed from: c */
    private final String f18642c = "assets/LIAPP.ini";

    /* renamed from: d */
    private boolean f18643d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18643d) {
            return;
        }
        this.f18643d = str.contains("/LIAPPEgg") || this.f18642c.equals(str) || m19107a(str, "LIAPPClient.sc");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "LIAPP";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18643d;
    }
}
