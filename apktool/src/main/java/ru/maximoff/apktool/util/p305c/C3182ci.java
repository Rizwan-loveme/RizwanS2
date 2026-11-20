package ru.maximoff.apktool.util.p305c;

/* compiled from: Virbox.java */
/* renamed from: ru.maximoff.apktool.util.c.ci */
/* loaded from: classes.dex */
public class C3182ci extends AbstractC3187d {

    /* renamed from: a */
    private final String f18778a = "libsandhook.so";

    /* renamed from: b */
    private final String f18779b = "libsandhook-native.so";

    /* renamed from: c */
    private final String f18780c = "libv++_64.so";

    /* renamed from: d */
    private final String f18781d = "libv++.so";

    /* renamed from: e */
    private boolean f18782e = false;

    /* renamed from: f */
    private int f18783f = 0;

    /* renamed from: g */
    private int f18784g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18782e) {
            return;
        }
        if (m19107a(str, "libsandhook.so") || m19107a(str, "libsandhook-native.so")) {
            this.f18783f++;
        } else if (m19107a(str, "libv++_64.so") || m19107a(str, "libv++.so")) {
            this.f18784g++;
        }
        this.f18782e = this.f18783f > 0 && this.f18784g > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Virbox";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18782e;
    }
}
