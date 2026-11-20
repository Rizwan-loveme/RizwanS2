package ru.maximoff.apktool.util.p305c;

/* compiled from: AppGuard2.java */
/* renamed from: ru.maximoff.apktool.util.c.r */
/* loaded from: classes.dex */
public class C3201r extends AbstractC3187d {

    /* renamed from: a */
    private final String f18880a = "^assets/classes[1-9]{0,1}\\.(jet|zip)$";

    /* renamed from: b */
    private final String f18881b = "^lib/(arm.*|x86.*)/libloader\\.so$";

    /* renamed from: c */
    private final String f18882c = "^lib/(arm.*|x86.*)/libdiresu\\.so$";

    /* renamed from: d */
    private final String f18883d = "assets/m7a";

    /* renamed from: e */
    private final String f18884e = "assets/m8a";

    /* renamed from: f */
    private final String f18885f = "assets/agconfig";

    /* renamed from: g */
    private final String f18886g = "assets/agmetainfo";

    /* renamed from: h */
    private boolean f18887h = false;

    /* renamed from: i */
    private int f18888i = 0;

    /* renamed from: j */
    private int f18889j = 0;

    /* renamed from: k */
    private int f18890k = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18887h) {
            return;
        }
        if (str.matches("^assets/classes[1-9]{0,1}\\.(jet|zip)$")) {
            this.f18888i++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libloader\\.so$") || str.matches("^lib/(arm.*|x86.*)/libdiresu\\.so$")) {
            this.f18889j++;
        } else if (this.f18883d.equals(str) || this.f18884e.equals(str) || this.f18885f.equals(str) || this.f18886g.equals(str)) {
            this.f18890k++;
        }
        this.f18887h = this.f18889j > 0 && (this.f18888i > 0 || this.f18890k > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AppGuard (TOAST-NHNent)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18887h;
    }
}
