package ru.maximoff.apktool.util.p305c;

/* compiled from: Secucen.java */
/* renamed from: ru.maximoff.apktool.util.c.bw */
/* loaded from: classes.dex */
public class C3169bw extends AbstractC3187d {

    /* renamed from: a */
    private final String f18702a = "^lib/(.*)/libAppIron-jni_v(.*)\\.so$";

    /* renamed from: b */
    private final String f18703b = "^.*libAppIronExpress_v(.*)\\.so$";

    /* renamed from: c */
    private final String f18704c = "^assets/appiron/(.*)$";

    /* renamed from: d */
    private boolean f18705d = false;

    /* renamed from: e */
    private int f18706e = 0;

    /* renamed from: f */
    private int f18707f = 0;

    /* renamed from: g */
    private int f18708g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18705d) {
            return;
        }
        if (str.matches("^lib/(.*)/libAppIron-jni_v(.*)\\.so$")) {
            this.f18706e++;
        }
        if (str.matches("^.*libAppIronExpress_v(.*)\\.so$")) {
            this.f18707f++;
        }
        if (str.matches("^assets/appiron/(.*)$")) {
            this.f18708g++;
        }
        this.f18705d = m19104c();
    }

    /* renamed from: c */
    private boolean m19104c() {
        int i = this.f18706e > 0 ? 1 : 0;
        if (this.f18707f > 0) {
            i++;
        }
        if (this.f18708g > 0) {
            i++;
        }
        return i >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Secucen AppIron";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18705d;
    }
}
