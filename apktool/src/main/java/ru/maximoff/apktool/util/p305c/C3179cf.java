package ru.maximoff.apktool.util.p305c;

/* compiled from: VGuard.java */
/* renamed from: ru.maximoff.apktool.util.c.cf */
/* loaded from: classes.dex */
public class C3179cf extends AbstractC3187d {

    /* renamed from: a */
    private final String f18766a = "^lib/(arm.*|x86.*)/libedex\\.so$";

    /* renamed from: b */
    private final String f18767b = "^assets/dexsky\\.(d|e)b(a|b|x|y)$";

    /* renamed from: c */
    private final String f18768c = "assets/dexsky.ini";

    /* renamed from: d */
    private final String f18769d = "^assets/dex[a-z0-9]{3}\\.zip$";

    /* renamed from: e */
    private final String f18770e = "^assets/vguard\\.(key|enginehash)$";

    /* renamed from: f */
    private boolean f18771f = false;

    /* renamed from: g */
    private int f18772g = 0;

    /* renamed from: h */
    private int f18773h = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18771f) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libedex\\.so$")) {
            this.f18772g++;
        } else if (str.matches("^lib/(arm.*|x86.*)/libedex\\.so$") || str.matches("^assets/dexsky\\.(d|e)b(a|b|x|y)$") || this.f18768c.equals(str) || str.matches("^assets/dex[a-z0-9]{3}\\.zip$") || str.matches("^assets/vguard\\.(key|enginehash)$")) {
            this.f18773h++;
        }
        this.f18771f = this.f18772g > 0 && this.f18773h > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "VGuard";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18771f;
    }
}
