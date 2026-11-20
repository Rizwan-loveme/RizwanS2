package ru.maximoff.apktool.util.p305c;

/* compiled from: Ahnlab.java */
/* renamed from: ru.maximoff.apktool.util.c.f */
/* loaded from: classes.dex */
public class C3189f extends AbstractC3187d {

    /* renamed from: a */
    private final String f18825a = "^lib/(arm.*|x86.*)/libEngineManager\\.so$";

    /* renamed from: b */
    private final String f18826b = "^assets/ahnlab/engine/(arm.*|x86.*)/lib(rc|av)engine.*$";

    /* renamed from: c */
    private final String f18827c = "assets/ahnlab/engine/rootchecker2.rcd";

    /* renamed from: d */
    private boolean f18828d = false;

    /* renamed from: e */
    private int f18829e = 0;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18828d) {
            return;
        }
        if (str.matches("^lib/(arm.*|x86.*)/libEngineManager\\.so$") || str.matches("^assets/ahnlab/engine/(arm.*|x86.*)/lib(rc|av)engine.*$") || str.equals("assets/ahnlab/engine/rootchecker2.rcd")) {
            this.f18829e++;
        }
        this.f18828d = this.f18829e > 1;
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Ahnlab V3 engine";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18828d;
    }
}
