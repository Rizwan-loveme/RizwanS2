package p046b.p047a.p050c.p051a.p052a;

import android.provider.MediaStore;
import java.util.HashSet;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0493d;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p055d.InterfaceC0515a;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResStyleValue.java */
/* renamed from: b.a.c.a.a.t */
/* loaded from: classes.dex */
public class C0488t extends C0471c implements InterfaceC0515a {

    /* renamed from: b */
    private final C0538c<C0485q, AbstractC0486r>[] f3407b;

    /* renamed from: c */
    private final InterfaceC0541f f3408c;

    /* renamed from: d */
    private boolean f3409d;

    C0488t(C0485q c0485q, C0538c<Integer, AbstractC0486r>[] c0538cArr, C0490v c0490v, boolean z, InterfaceC0541f interfaceC0541f) {
        super(c0485q, z, interfaceC0541f);
        this.f3408c = interfaceC0541f;
        this.f3409d = z;
        this.f3407b = new C0538c[c0538cArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c0538cArr.length) {
                return;
            }
            this.f3407b[i2] = new C0538c<>(c0490v.m3658a(c0538cArr[i2].f3632a.intValue(), (String) null), c0538cArr[i2].f3633b);
            i = i2 + 1;
        }
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0471c, p046b.p047a.p050c.p055d.InterfaceC0515a
    /* renamed from: a */
    public void mo3626a(XmlSerializer xmlSerializer, C0494e c0494e) {
        String stringBuffer;
        xmlSerializer.startTag((String) null, "style");
        xmlSerializer.attribute((String) null, "name", c0494e.m3700c().m3693e());
        if (!this.f3379a.m3646e()) {
            if (!this.f3379a.m3647f()) {
                xmlSerializer.attribute((String) null, MediaStore.Files.FileColumns.PARENT, this.f3379a.mo3649g());
            } else if (this.f3409d) {
                try {
                    xmlSerializer.attribute((String) null, MediaStore.Files.FileColumns.PARENT, new StringBuffer().append("@style/APKTOOL_DUMMY_").append(String.format("0x%08x", new Integer(this.f3379a.m3642d()))).toString());
                } catch (Exception e2) {
                }
            }
        } else if (c0494e.m3700c().m3693e().indexOf(46) != -1) {
            xmlSerializer.attribute((String) null, MediaStore.Files.FileColumns.PARENT, "");
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.f3407b.length; i++) {
            C0493d m3645c = this.f3407b[i].f3632a.m3645c();
            if (m3645c == null) {
                if (this.f3409d) {
                    try {
                        String m3654l = this.f3407b[i].f3633b.m3654l();
                        if (!m3654l.equals("integer")) {
                            String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("@").append(m3654l).toString()).append("/APKTOOL_DUMMY_").toString()).append(String.format("0x%08x", new Integer(this.f3407b[i].f3632a.m3642d()))).toString();
                            xmlSerializer.startTag((String) null, "item");
                            xmlSerializer.attribute((String) null, "name", stringBuffer2);
                            xmlSerializer.text(this.f3407b[i].f3633b.mo3651i());
                            xmlSerializer.endTag((String) null, "item");
                        }
                    } catch (Exception e3) {
                    }
                }
            } else {
                String str = (String) null;
                C0489u m3701d = m3645c.m3689b().m3701d();
                if (!(m3701d instanceof C0485q)) {
                    if (m3701d instanceof C0470b) {
                        str = ((C0470b) m3701d).mo3629a(this.f3407b[i].f3633b);
                        stringBuffer = m3645c.m3683a(c0494e.m3700c().m3694f(), true);
                    } else {
                        stringBuffer = new StringBuffer().append("@").append(m3645c.m3683a(c0494e.m3700c().m3694f(), false)).toString();
                    }
                    if (stringBuffer.startsWith("@attr/")) {
                        stringBuffer = stringBuffer.substring(6);
                    }
                    if (!hashSet.contains(stringBuffer)) {
                        String mo3651i = str == null ? this.f3407b[i].f3633b.mo3651i() : str;
                        if (mo3651i != null) {
                            xmlSerializer.startTag((String) null, "item");
                            xmlSerializer.attribute((String) null, "name", stringBuffer);
                            xmlSerializer.text(mo3651i);
                            xmlSerializer.endTag((String) null, "item");
                            hashSet.add(stringBuffer);
                        }
                    }
                }
            }
        }
        xmlSerializer.endTag((String) null, "style");
    }
}
