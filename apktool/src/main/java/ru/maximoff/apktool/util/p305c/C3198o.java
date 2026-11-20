package ru.maximoff.apktool.util.p305c;

/* compiled from: AppCamo.java */
/* renamed from: ru.maximoff.apktool.util.c.o */
/* loaded from: classes.dex */
public class C3198o extends AbstractC3187d {

    /* renamed from: a */
    private final String f18863a = "^lib/(.*)/libalib\\.so$";

    /* renamed from: b */
    private final String f18864b = "^assets/[0-9a-f]{32}/[0-9a-f]{32}\\.png$";

    /* renamed from: c */
    private boolean f18865c = false;

    /* renamed from: d */
    private int f18866d = 0;

    /* renamed from: e */
    private int f18867e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18865c) {
            return;
        }
        if (str.matches("^lib/(.*)/libalib\\.so$")) {
            this.f18866d++;
        }
        if (str.matches("^assets/[0-9a-f]{32}/[0-9a-f]{32}\\.png$")) {
            this.f18867e++;
        }
        this.f18865c = this.f18866d > 0 && this.f18867e > 0;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "AppCamo";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18865c;
    }
}
