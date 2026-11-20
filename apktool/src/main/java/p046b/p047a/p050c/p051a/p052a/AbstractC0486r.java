package p046b.p047a.p050c.p051a.p052a;

import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p055d.C0516b;
import p046b.p047a.p050c.p055d.InterfaceC0515a;

/* compiled from: ResScalarValue.java */
/* renamed from: b.a.c.a.a.r */
/* loaded from: classes.dex */
public abstract class AbstractC0486r extends C0482n implements InterfaceC0515a {

    /* renamed from: c */
    protected final String f3404c;

    /* renamed from: d */
    protected final String f3405d;

    /* renamed from: a */
    protected abstract String mo3632a();

    /* renamed from: b */
    protected void mo3648b(XmlSerializer xmlSerializer, C0494e c0494e) {
    }

    protected AbstractC0486r(String str, int i, String str2) {
        super(i);
        this.f3404c = str;
        this.f3405d = str2;
    }

    /* renamed from: g */
    public String mo3649g() {
        String mo3632a = mo3632a();
        if (mo3632a == null && this.f3405d != null) {
            return this.f3405d;
        }
        return mo3632a;
    }

    /* renamed from: h */
    public String mo3650h() {
        return mo3651i();
    }

    /* renamed from: i */
    public String mo3651i() {
        return this.f3405d != null ? this.f3405d : mo3632a();
    }

    /* renamed from: j */
    public String m3652j() {
        return mo3651i().replace("&amp;", "&").replace("&lt;", "<");
    }

    /* renamed from: k */
    public boolean m3653k() {
        return C0516b.m3874d(this.f3405d);
    }

    @Override // p046b.p047a.p050c.p055d.InterfaceC0515a
    /* renamed from: a */
    public void mo3626a(XmlSerializer xmlSerializer, C0494e c0494e) {
        String m3740a = c0494e.m3700c().m3695g().m3740a();
        boolean z = ("reference".equals(this.f3404c) || m3740a.equals(this.f3404c)) ? false : true;
        String mo3651i = mo3651i();
        if (mo3651i == null) {
            mo3651i = "";
        }
        boolean z2 = (m3740a.equalsIgnoreCase("color") || mo3651i == null || !mo3651i.contains("@") || c0494e.m3697a().contains("string")) ? z : true;
        String str = (!m3740a.equalsIgnoreCase("id") || mo3651i.isEmpty()) ? mo3651i : "";
        String str2 = z2 ? "item" : m3740a;
        xmlSerializer.startTag((String) null, str2);
        if (z2) {
            xmlSerializer.attribute((String) null, "type", m3740a);
        }
        xmlSerializer.attribute((String) null, "name", c0494e.m3700c().m3693e());
        mo3648b(xmlSerializer, c0494e);
        if (!str.isEmpty()) {
            xmlSerializer.ignorableWhitespace(str);
        }
        xmlSerializer.endTag((String) null, str2);
    }

    /* renamed from: l */
    public String m3654l() {
        return this.f3404c;
    }
}
