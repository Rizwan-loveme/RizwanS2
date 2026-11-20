package ru.maximoff.apktool.util.p305c;

/* compiled from: Aegis.java */
/* renamed from: ru.maximoff.apktool.util.c.e */
/* loaded from: classes.dex */
public class C3188e extends AbstractC3187d {

    /* renamed from: a */
    private final String f18817a = "assets/aegis/aegis.mf";

    /* renamed from: b */
    private final String f18818b = "assets/aegis/aegis.sig";

    /* renamed from: c */
    private final String f18819c = "^assets/aegis/aegis[0-9]{1}\\.dat$";

    /* renamed from: d */
    private final String f18820d = "assets/aegis/nmsscr.nmss";

    /* renamed from: e */
    private final String f18821e = "assets/aegis/nmssey.nmss";

    /* renamed from: f */
    private final String f18822f = "assets/aegis/nmsskc.nmss";

    /* renamed from: g */
    private final String f18823g = "assets/aegis/shield.dat";

    /* renamed from: h */
    private boolean f18824h = false;

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected void mo19086a(String str) {
        if (this.f18824h) {
            return;
        }
        if (str.matches("^assets/aegis/aegis[0-9]{1}\\.dat$") || this.f18817a.equals(str) || this.f18818b.equals(str) || this.f18820d.equals(str) || this.f18821e.equals(str) || this.f18822f.equals(str) || this.f18823g.equals(str)) {
            this.f18824h = true;
        }
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: a */
    protected String mo19085a() {
        return "Aegis - Android Republic Mods";
    }

    @Override // ru.maximoff.apktool.util.p305c.AbstractC3187d
    /* renamed from: b */
    protected boolean mo19087b() {
        return this.f18824h;
    }
}
