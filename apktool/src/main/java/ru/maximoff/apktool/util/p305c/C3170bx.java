package ru.maximoff.apktool.util.p305c;

/* compiled from: ShieldSDK.java */
/* renamed from: ru.maximoff.apktool.util.c.bx */
/* loaded from: classes.dex */
public class C3170bx extends AbstractC3187d {

    /* renamed from: a */
    private final String f18709a = "^lib/(arm.*|x86.*)/libcashshieldabc-native-lib\\.so$";

    /* renamed from: b */
    private boolean f18710b = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18710b) {
            return;
        }
        this.f18710b = str.matches("^lib/(arm.*|x86.*)/libcashshieldabc-native-lib\\.so$");
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Shield SDK";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18710b;
    }
}
