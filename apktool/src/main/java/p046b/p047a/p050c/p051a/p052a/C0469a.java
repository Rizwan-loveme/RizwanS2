package p046b.p047a.p050c.p051a.p052a;

import java.util.Arrays;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p055d.InterfaceC0515a;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResArrayValue.java */
/* renamed from: b.a.c.a.a.a */
/* loaded from: classes.dex */
public class C0469a extends C0471c implements InterfaceC0515a {

    /* renamed from: b */
    private final AbstractC0486r[] f3372b;

    /* renamed from: c */
    private final String[] f3373c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C0469a(C0485q c0485q, C0538c<Integer, AbstractC0486r>[] c0538cArr, boolean z, InterfaceC0541f interfaceC0541f) {
        super(c0485q, z, interfaceC0541f);
        int i = 0;
        this.f3373c = new String[]{"string", "integer"};
        this.f3372b = new AbstractC0486r[c0538cArr.length];
        while (true) {
            int i2 = i;
            if (i2 >= c0538cArr.length) {
                return;
            }
            this.f3372b[i2] = c0538cArr[i2].f3633b;
            i = i2 + 1;
        }
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0471c, p046b.p047a.p050c.p055d.InterfaceC0515a
    /* renamed from: a */
    public void mo3626a(XmlSerializer xmlSerializer, C0494e c0494e) {
        String m3625a = m3625a();
        String stringBuffer = new StringBuffer().append(m3625a == null ? "" : new StringBuffer().append(m3625a).append("-").toString()).append("array").toString();
        xmlSerializer.startTag((String) null, stringBuffer);
        xmlSerializer.attribute((String) null, "name", c0494e.m3700c().m3693e());
        int i = 0;
        while (true) {
            if (i >= this.f3372b.length) {
                break;
            }
            if (!this.f3372b[i].m3653k()) {
                i++;
            } else {
                xmlSerializer.attribute((String) null, "formatted", "false");
                break;
            }
        }
        for (int i2 = 0; i2 < this.f3372b.length; i2++) {
            xmlSerializer.startTag((String) null, "item");
            xmlSerializer.text(this.f3372b[i2].m3652j());
            xmlSerializer.endTag((String) null, "item");
        }
        xmlSerializer.endTag((String) null, stringBuffer);
    }

    /* renamed from: a */
    public String m3625a() {
        if (this.f3372b.length == 0) {
            return (String) null;
        }
        String m3654l = this.f3372b[0].m3654l();
        for (int i = 0; i < this.f3372b.length; i++) {
            if (this.f3372b[i].mo3650h().startsWith("@string")) {
                return "string";
            }
            if (this.f3372b[i].mo3650h().startsWith("@drawable")) {
                return (String) null;
            }
            if (this.f3372b[i].mo3650h().startsWith("@integer")) {
                return "integer";
            }
            if (!"string".equals(m3654l) && !"integer".equals(m3654l)) {
                return (String) null;
            }
            if (!m3654l.equals(this.f3372b[i].m3654l())) {
                return (String) null;
            }
        }
        return !Arrays.asList(this.f3373c).contains(m3654l) ? "string" : m3654l;
    }
}
