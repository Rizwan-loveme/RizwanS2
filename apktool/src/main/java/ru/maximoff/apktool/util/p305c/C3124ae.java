package ru.maximoff.apktool.util.p305c;

/* compiled from: ChornClickers.java */
/* renamed from: ru.maximoff.apktool.util.c.ae */
/* loaded from: classes.dex */
public class C3124ae extends AbstractC3187d {

    /* renamed from: a */
    private final String f18438a = "lib/armeabi/libhdus.so";

    /* renamed from: b */
    private final String f18439b = "lib/armeabi/libwjus.so";

    /* renamed from: c */
    private boolean f18440c = false;

    /* renamed from: d */
    private int f18441d = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18440c) {
            return;
        }
        if (this.f18438a.equals(str) || this.f18439b.equals(str)) {
            this.f18441d++;
        }
        this.f18440c = this.f18441d >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "ChornClickers";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18440c;
    }
}
