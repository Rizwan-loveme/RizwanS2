package ru.maximoff.apktool.util.p305c;

/* compiled from: Protectt.java */
/* renamed from: ru.maximoff.apktool.util.c.bs */
/* loaded from: classes.dex */
public class C3165bs extends AbstractC3187d {

    /* renamed from: a */
    private final String f18685a = "libprotectt-native-lib.so";

    /* renamed from: b */
    private final String f18686b = "libprotecttai.so";

    /* renamed from: c */
    private final String f18687c = "libapp-protectt-native-lib.so";

    /* renamed from: d */
    private boolean f18688d = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18688d) {
            return;
        }
        this.f18688d = m19107a(str, "libprotectt-native-lib.so") || m19107a(str, "libprotecttai.so") || m19107a(str, "libapp-protectt-native-lib.so");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Protectt";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18688d;
    }
}
