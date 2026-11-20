package ru.maximoff.apktool.util.p305c;

/* compiled from: Tencent3.java */
/* renamed from: ru.maximoff.apktool.util.c.ca */
/* loaded from: classes.dex */
public class C3174ca extends AbstractC3187d {

    /* renamed from: a */
    private final String f18725a = "assets/tosversion";

    /* renamed from: b */
    private final String f18726b = "assets/0OO00l111l1l";

    /* renamed from: c */
    private final String f18727c = "assets/0OO00oo01l1l";

    /* renamed from: d */
    private final String f18728d = "assets/o0oooOO0ooOo.dat";

    /* renamed from: e */
    private boolean f18729e = false;

    /* renamed from: f */
    private int f18730f = 0;

    /* renamed from: g */
    private int f18731g = 0;

    /* renamed from: h */
    private int f18732h = 0;

    /* renamed from: i */
    private int f18733i = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18729e) {
            return;
        }
        if (this.f18725a.equals(str)) {
            this.f18730f++;
        } else if (this.f18726b.equals(str)) {
            this.f18731g++;
        } else if (this.f18727c.equals(str)) {
            this.f18732h++;
        } else if (this.f18728d.equals(str)) {
            this.f18733i++;
        }
        this.f18729e = this.f18731g > 0 && (this.f18730f > 0 || this.f18732h > 0 || this.f18733i > 0);
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Tencent's Legu";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18729e;
    }
}
