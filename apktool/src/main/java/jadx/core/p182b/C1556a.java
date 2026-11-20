package jadx.core.p182b;

import jadx.core.p183c.p191d.C1636b;

/* compiled from: DeobfClsInfo.java */
/* renamed from: jadx.core.b.a */
/* loaded from: classes.dex */
class C1556a {

    /* renamed from: a */
    private final C1558c f9952a;

    /* renamed from: b */
    private final C1636b f9953b;

    /* renamed from: c */
    private final C1561f f9954c;

    /* renamed from: d */
    private final String f9955d;

    public C1556a(C1558c c1558c, C1636b c1636b, C1561f c1561f, String str) {
        this.f9952a = c1558c;
        this.f9953b = c1636b;
        this.f9954c = c1561f;
        this.f9955d = str;
    }

    /* renamed from: a */
    public String m12011a() {
        String str;
        String m12049a;
        C1636b m12532l = this.f9953b.m12532l();
        if (m12532l != this.f9953b) {
            C1556a c1556a = this.f9952a.m12058c().get(m12532l.m12544x());
            if (c1556a != null) {
                m12049a = c1556a.m12011a();
            } else {
                m12049a = this.f9952a.m12049a(m12532l.m12544x());
            }
            str = String.valueOf(m12049a) + "$";
        } else {
            str = "";
        }
        return String.valueOf(str) + (this.f9955d != null ? this.f9955d : this.f9953b.m12546z());
    }

    /* renamed from: b */
    public String m12012b() {
        return String.valueOf(this.f9954c.m12076e()) + "." + m12011a();
    }

    /* renamed from: c */
    public C1636b m12013c() {
        return this.f9953b;
    }

    /* renamed from: d */
    public String m12014d() {
        return this.f9955d;
    }
}
