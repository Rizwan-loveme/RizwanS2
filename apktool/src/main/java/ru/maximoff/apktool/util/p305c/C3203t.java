package ru.maximoff.apktool.util.p305c;

/* compiled from: AppSealing2.java */
/* renamed from: ru.maximoff.apktool.util.c.t */
/* loaded from: classes.dex */
public class C3203t extends AbstractC3187d {

    /* renamed from: a */
    private final String f18899a = "^assets/AppSealing/.*$";

    /* renamed from: b */
    private boolean f18900b = false;

    /* renamed from: c */
    private int f18901c = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18900b) {
            return;
        }
        if (str.matches("^assets/AppSealing/.*$")) {
            this.f18901c++;
        }
        this.f18900b = this.f18901c > 3;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AppSealing";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18900b;
    }
}
