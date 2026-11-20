package ru.maximoff.apktool.util.p305c;

/* compiled from: Tongfu.java */
/* renamed from: ru.maximoff.apktool.util.c.cd */
/* loaded from: classes.dex */
public class C3177cd extends AbstractC3187d {

    /* renamed from: a */
    private final String f18748a = "^lib/(arm.*|x86.*)/libegis\\.so$";

    /* renamed from: b */
    private final String f18749b = "assets/mode";

    /* renamed from: c */
    private final String f18750c = "assets/PK";

    /* renamed from: d */
    private final String f18751d = "assets/virtual";

    /* renamed from: e */
    private final String f18752e = "assets/libegis.a";

    /* renamed from: f */
    private boolean f18753f = false;

    /* renamed from: g */
    private int f18754g = 0;

    /* renamed from: h */
    private int f18755h = 0;

    /* renamed from: i */
    private int f18756i = 0;

    /* renamed from: j */
    private int f18757j = 0;

    /* renamed from: k */
    private int f18758k = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18753f) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libegis\\.so$")) {
            this.f18754g++;
        } else if (this.f18749b.equals(str)) {
            this.f18755h++;
        } else if (this.f18750c.equals(str)) {
            this.f18756i++;
        } else if (this.f18751d.equals(str)) {
            this.f18757j++;
        } else if (this.f18752e.equals(str)) {
            this.f18758k++;
        }
        this.f18753f = this.f18754g > 0 && (this.f18755h > 0 || this.f18756i > 0 || this.f18757j > 0 || this.f18758k > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Tongfu shield";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18753f;
    }
}
