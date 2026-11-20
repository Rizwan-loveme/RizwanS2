package ru.maximoff.apktool.util.p305c;

/* compiled from: DexProtector3.java */
/* renamed from: ru.maximoff.apktool.util.c.al */
/* loaded from: classes.dex */
public class C3131al extends AbstractC3187d {

    /* renamed from: a */
    private final String f18507a = "^assets/[A-Za-z0-9.]{2,50}\\.arm-v7\\.so\\.dat$";

    /* renamed from: b */
    private final String f18508b = "^assets/[A-Za-z0-9.]{2,50}\\.arm-v8\\.so\\.dat$";

    /* renamed from: c */
    private final String f18509c = "^assets/[A-Za-z0-9.]{2,50}\\.arm\\.so\\.dat$";

    /* renamed from: d */
    private final String f18510d = "^assets/[A-Za-z0-9.]{2,50}\\.dex\\.dat$";

    /* renamed from: e */
    private final String f18511e = "^assets/[A-Za-z0-9.]{2,50}\\.x86\\.so\\.dat$";

    /* renamed from: f */
    private final String f18512f = "^assets/[A-Za-z0-9.]{2,50}\\.x86_64\\.so\\.dat$";

    /* renamed from: g */
    private final String f18513g = "^assets/[A-Za-z0-9.]{2,50}\\.mp3$";

    /* renamed from: h */
    private final String f18514h = "^assets/[A-Za-z0-9.]{2,50}\\.dat$";

    /* renamed from: i */
    private boolean f18515i = false;

    /* renamed from: j */
    private int f18516j = 0;

    /* renamed from: k */
    private int f18517k = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18515i) {
            return;
        }
        if (str.matches("^assets/[A-Za-z0-9.]{2,50}\\.arm-v7\\.so\\.dat$") || str.matches("^assets/[A-Za-z0-9.]{2,50}\\.arm-v8\\.so\\.dat$") || str.matches("^assets/[A-Za-z0-9.]{2,50}\\.arm\\.so\\.dat$") || str.matches("^assets/[A-Za-z0-9.]{2,50}\\.dex\\.dat$") || str.matches("^assets/[A-Za-z0-9.]{2,50}\\.x86\\.so\\.dat$") || str.matches("^assets/[A-Za-z0-9.]{2,50}\\.x86_64\\.so\\.dat$")) {
            this.f18516j++;
        }
        if (str.matches("^assets/[A-Za-z0-9.]{2,50}\\.dat$") || str.matches("^assets/[A-Za-z0-9.]{2,50}\\.mp3$")) {
            this.f18517k++;
        }
        this.f18515i = this.f18516j > 0 && this.f18517k > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DexProtector";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18515i;
    }
}
