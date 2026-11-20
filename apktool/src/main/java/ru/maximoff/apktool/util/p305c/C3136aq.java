package ru.maximoff.apktool.util.p305c;

/* compiled from: DingXiang.java */
/* renamed from: ru.maximoff.apktool.util.c.aq */
/* loaded from: classes.dex */
public class C3136aq extends AbstractC3187d {

    /* renamed from: a */
    private final String f18539a = "^lib/(arm.*|x86.*)/libsys_misc\\.so$";

    /* renamed from: b */
    private final String f18540b = "^assets/csn.*\\.data\\d?$";

    /* renamed from: c */
    private final String f18541c = "assets/__param.data";

    /* renamed from: d */
    private final String f18542d = "assets/__version.txt";

    /* renamed from: e */
    private final String f18543e = "dsnstub000.vd";

    /* renamed from: f */
    private boolean f18544f = false;

    /* renamed from: g */
    private int f18545g = 0;

    /* renamed from: h */
    private int f18546h = 0;

    /* renamed from: i */
    private int f18547i = 0;

    /* renamed from: j */
    private int f18548j = 0;

    /* renamed from: k */
    private int f18549k = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18544f) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libsys_misc\\.so$")) {
            this.f18545g++;
        }
        if (str.matches("^assets/csn.*\\.data\\d?$")) {
            this.f18546h++;
        }
        if (str.equals("assets/__param.data")) {
            this.f18547i++;
        }
        if (str.equals("assets/__version.txt")) {
            this.f18548j++;
        }
        if (m19107a(str, "dsnstub000.vd")) {
            this.f18549k++;
        }
        int i = this.f18545g > 0 ? 1 : 0;
        if (this.f18546h > 0) {
            i++;
        }
        if (this.f18547i > 0) {
            i++;
        }
        if (this.f18548j > 0) {
            i++;
        }
        if (this.f18549k > 0) {
            i++;
        }
        this.f18544f = i >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "DingXiang";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18544f;
    }
}
