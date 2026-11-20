package ru.maximoff.apktool.util.p305c;

/* compiled from: BugsMirror.java */
/* renamed from: ru.maximoff.apktool.util.c.ab */
/* loaded from: classes.dex */
public class C3121ab extends AbstractC3187d {

    /* renamed from: a */
    private final String f18422a = "^lib/(arm.*|x86.*)/libdefender\\.so$";

    /* renamed from: b */
    private final String f18423b = "^lib/(arm.*|x86.*)/libsettings\\.so$";

    /* renamed from: c */
    private final String f18424c = "^res/xml/(com_bugsmirror_)?(defender|bugsmirror)_authenticator\\.xml$";

    /* renamed from: d */
    private boolean f18425d = false;

    /* renamed from: e */
    private int f18426e = 0;

    /* renamed from: f */
    private int f18427f = 0;

    /* renamed from: g */
    private int f18428g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18425d) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libdefender\\.so$")) {
            this.f18426e++;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libsettings\\.so$")) {
            this.f18427f++;
        }
        if (str.matches("^res/xml/(com_bugsmirror_)?(defender|bugsmirror)_authenticator\\.xml$")) {
            this.f18428g++;
        }
        if ((this.f18426e <= 0 || this.f18427f <= 0) && ((this.f18426e <= 0 || this.f18428g <= 0) && (this.f18427f <= 0 || this.f18428g <= 0))) {
            return;
        }
        this.f18425d = true;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "BugsMirror";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18425d;
    }
}
