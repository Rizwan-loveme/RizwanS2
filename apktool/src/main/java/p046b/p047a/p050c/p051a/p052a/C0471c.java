package p046b.p047a.p050c.p051a.p052a;

import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p055d.InterfaceC0515a;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResBagValue.java */
/* renamed from: b.a.c.a.a.c */
/* loaded from: classes.dex */
public class C0471c extends C0489u implements InterfaceC0515a {

    /* renamed from: a */
    protected final C0485q f3379a;

    /* renamed from: b */
    private final InterfaceC0541f f3380b;

    /* renamed from: c */
    private boolean f3381c;

    public C0471c(C0485q c0485q, boolean z, InterfaceC0541f interfaceC0541f) {
        this.f3379a = c0485q;
        this.f3380b = interfaceC0541f;
        this.f3381c = z;
    }

    /* renamed from: a */
    public void mo3626a(XmlSerializer xmlSerializer, C0494e c0494e) {
        String m3740a = c0494e.m3700c().m3695g().m3740a();
        if ("style".equals(m3740a)) {
            new C0488t(this.f3379a, new C0538c[0], (C0490v) null, this.f3381c, this.f3380b).mo3626a(xmlSerializer, c0494e);
            return;
        }
        if ("array".equals(m3740a)) {
            new C0469a(this.f3379a, new C0538c[0], this.f3381c, this.f3380b).mo3626a(xmlSerializer, c0494e);
            return;
        }
        if ("plurals".equals(m3740a)) {
            new C0484p(this.f3379a, new C0538c[0], this.f3381c, this.f3380b).mo3626a(xmlSerializer, c0494e);
            return;
        }
        xmlSerializer.startTag((String) null, "item");
        xmlSerializer.attribute((String) null, "type", m3740a);
        xmlSerializer.attribute((String) null, "name", c0494e.m3700c().m3693e());
        xmlSerializer.endTag((String) null, "item");
    }
}
