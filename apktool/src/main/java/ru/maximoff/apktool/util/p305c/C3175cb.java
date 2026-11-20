package ru.maximoff.apktool.util.p305c;

/* compiled from: Tencent4.java */
/* renamed from: ru.maximoff.apktool.util.c.cb */
/* loaded from: classes.dex */
public class C3175cb extends AbstractC3187d {

    /* renamed from: a */
    private final String f18734a = "^assets/libwsDataEncryption_AZAPP.*\\.so$";

    /* renamed from: b */
    private final String f18735b = "^assets/wslib/(arm.*|x86.*)/libWSSecV?\\.so$";

    /* renamed from: c */
    private final String f18736c = "^assets/WSSEC(A|B|C|D)\\.jar$";

    /* renamed from: d */
    private final String f18737d = "assets/wsDal.jar";

    /* renamed from: e */
    private boolean f18738e = false;

    /* renamed from: f */
    private int f18739f = 0;

    /* renamed from: g */
    private int f18740g = 0;

    /* renamed from: h */
    private int f18741h = 0;

    /* renamed from: i */
    private int f18742i = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18738e) {
            return;
        }
        if (str.matches("^assets/libwsDataEncryption_AZAPP.*\\.so$")) {
            this.f18739f++;
        } else if (str.matches("^assets/wslib/(arm.*|x86.*)/libWSSecV?\\.so$")) {
            this.f18740g++;
        } else if (str.matches("^assets/WSSEC(A|B|C|D)\\.jar$")) {
            this.f18741h++;
        } else if (this.f18737d.equals(str)) {
            this.f18742i++;
        }
        this.f18738e = this.f18740g > 0 && this.f18739f > 0 && this.f18741h > 0 && this.f18742i > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Tencent's Legu (VMP)";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18738e;
    }
}
