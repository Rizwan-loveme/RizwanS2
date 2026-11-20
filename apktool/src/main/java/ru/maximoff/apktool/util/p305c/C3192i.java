package ru.maximoff.apktool.util.p305c;

/* compiled from: AndroidRepublic.java */
/* renamed from: ru.maximoff.apktool.util.c.i */
/* loaded from: classes.dex */
public class C3192i extends AbstractC3187d {

    /* renamed from: a */
    private final String f18835a = "assets/emt.androidrepublic/config.png";

    /* renamed from: b */
    private final String f18836b = "assets/emt.androidrepublic/monkey.png";

    /* renamed from: c */
    private final String f18837c = "assets/emt.androidrepublic/system.png";

    /* renamed from: d */
    private final String f18838d = "assets/emt.androidrepublic/system_000.png";

    /* renamed from: e */
    private final String f18839e = "assets/emt.androidrepublic/system_001.png";

    /* renamed from: f */
    private final String f18840f = "assets/emt.androidrepublic/system_002.png";

    /* renamed from: g */
    private final String f18841g = "assets/emt.androidrepublic/system_003.png";

    /* renamed from: h */
    private final String f18842h = "assets/emt.androidrepublic/system_004.png";

    /* renamed from: i */
    private final String f18843i = "assets/emt.androidrepublic/system_005.png";

    /* renamed from: j */
    private boolean f18844j = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18844j) {
            return;
        }
        if (this.f18835a.equals(str) || this.f18836b.equals(str) || this.f18837c.equals(str) || this.f18838d.equals(str) || this.f18839e.equals(str) || this.f18840f.equals(str) || this.f18841g.equals(str) || this.f18842h.equals(str) || this.f18843i.equals(str)) {
            this.f18844j = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AndroidRepublic";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18844j;
    }
}
