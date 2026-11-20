package ru.maximoff.apktool.util.p305c;

/* compiled from: KiwiSec.java */
/* renamed from: ru.maximoff.apktool.util.c.be */
/* loaded from: classes.dex */
public class C3151be extends AbstractC3187d {

    /* renamed from: a */
    private final String f18621a = "^lib/(arm.*|x86.*)/libkiwicrash\\.so$";

    /* renamed from: b */
    private final String f18622b = "^lib/(arm.*|x86.*)/libkiwi_dumper\\.so$";

    /* renamed from: c */
    private final String f18623c = "^lib/(arm.*|x86.*)/libKwProtectSDK\\.so$";

    /* renamed from: d */
    private final String f18624d = "^lib/(arm.*|x86.*)/libkwsdataenc\\.so$";

    /* renamed from: e */
    private final String f18625e = "^lib/(arm.*|x86.*)/libkadp\\.so$";

    /* renamed from: f */
    private final String f18626f = "^lib/(arm.*|x86.*)/libwhite-box\\.so$";

    /* renamed from: g */
    private boolean f18627g = false;

    /* renamed from: h */
    private int f18628h = 0;

    /* renamed from: i */
    private int f18629i = 0;

    /* renamed from: j */
    private int f18630j = 0;

    /* renamed from: k */
    private int f18631k = 0;

    /* renamed from: l */
    private int f18632l = 0;

    /* renamed from: m */
    private int f18633m = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18627g) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libkiwicrash\\.so$")) {
            this.f18628h++;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libkiwi_dumper\\.so$")) {
            this.f18629i++;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libKwProtectSDK\\.so$")) {
            this.f18630j++;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libkwsdataenc\\.so$")) {
            this.f18631k++;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libkadp\\.so$")) {
            this.f18632l++;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libwhite-box\\.so$")) {
            this.f18633m++;
        }
        int i = this.f18628h > 0 ? 1 : 0;
        if (this.f18629i > 0) {
            i++;
        }
        if (this.f18630j > 0) {
            i++;
        }
        if (this.f18631k > 0) {
            i++;
        }
        if (this.f18632l > 0) {
            i++;
        }
        if (this.f18633m > 0) {
            i++;
        }
        this.f18627g = i >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "KiwiSec";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18627g;
    }
}
