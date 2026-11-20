package ru.maximoff.apktool.util.p305c;

/* compiled from: Eversafe.java */
/* renamed from: ru.maximoff.apktool.util.c.at */
/* loaded from: classes.dex */
public class C3139at extends AbstractC3187d {

    /* renamed from: a */
    private final String f18555a = "^lib/(.*)/libeversafe\\.so$";

    /* renamed from: b */
    private final String f18556b = "^lib/(.*)/libeversafe-loader\\.so$";

    /* renamed from: c */
    private final String f18557c = "^assets/eversafe/eversafe_(.*)\\.data$";

    /* renamed from: d */
    private boolean f18558d = false;

    /* renamed from: e */
    private int f18559e = 0;

    /* renamed from: f */
    private int f18560f = 0;

    /* renamed from: g */
    private int f18561g = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18558d) {
            return;
        }
        if (str.matches("^lib/(.*)/libeversafe\\.so$")) {
            this.f18559e++;
        }
        if (str.matches("^lib/(.*)/libeversafe-loader\\.so$")) {
            this.f18560f++;
        }
        if (str.matches("^assets/eversafe/eversafe_(.*)\\.data$")) {
            this.f18561g++;
        }
        this.f18558d = m19101c();
    }

    /* renamed from: c */
    private boolean m19101c() {
        int i = this.f18559e > 0 ? 1 : 0;
        if (this.f18560f > 0) {
            i++;
        }
        if (this.f18561g > 0) {
            i++;
        }
        return i >= 2;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Eversafe";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18558d;
    }
}
