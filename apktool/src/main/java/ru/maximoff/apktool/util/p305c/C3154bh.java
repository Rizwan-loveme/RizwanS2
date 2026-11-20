package ru.maximoff.apktool.util.p305c;

/* compiled from: ManxiSecurity.java */
/* renamed from: ru.maximoff.apktool.util.c.bh */
/* loaded from: classes.dex */
public class C3154bh extends AbstractC3187d {

    /* renamed from: a */
    private final String f18644a = "^assets/mxsafe/(arm.*|x86.*)/libdSafeShell\\.so$";

    /* renamed from: b */
    private final String f18645b = "^assets/mx/(arm.*|x86.*)/libmxacc\\.so$";

    /* renamed from: c */
    private final String f18646c = "^lib/(arm.*|x86.*)/libmanxi\\.so$";

    /* renamed from: d */
    private final String f18647d = "assets/mxsafe.data";

    /* renamed from: e */
    private final String f18648e = "assets/mxsafe.config";

    /* renamed from: f */
    private final String f18649f = "assets/mxsafe.jar";

    /* renamed from: g */
    private boolean f18650g = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18650g) {
            return;
        }
        if (str.matches("^assets/mxsafe/(arm.*|x86.*)/libdSafeShell\\.so$") || str.matches("^assets/mx/(arm.*|x86.*)/libmxacc\\.so$") || str.matches("^lib/(arm.*|x86.*)/libmanxi\\.so$") || str.equals("assets/mxsafe.data") || str.equals("assets/mxsafe.config") || str.equals("assets/mxsafe.jar")) {
            this.f18650g = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Manxi Security";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18650g;
    }
}
