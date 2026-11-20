package p046b.p047a.p050c.p051a.p052a;

import java.util.HashMap;
import java.util.Map;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.p050c.p051a.C0493d;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResEnumAttr.java */
/* renamed from: b.a.c.a.a.h */
/* loaded from: classes.dex */
public class C0476h extends C0470b {

    /* renamed from: b */
    private final C0538c<C0485q, C0483o>[] f3386b;

    /* renamed from: c */
    private final Map<Integer, String> f3387c;

    C0476h(C0485q c0485q, int i, Integer num, Integer num2, Boolean bool, C0538c<C0485q, C0483o>[] c0538cArr, boolean z, InterfaceC0541f interfaceC0541f) {
        super(c0485q, i, num, num2, bool, z, interfaceC0541f);
        this.f3387c = new HashMap();
        this.f3386b = c0538cArr;
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0470b
    /* renamed from: a */
    public String mo3629a(AbstractC0486r abstractC0486r) {
        String m3633a;
        return (!(abstractC0486r instanceof C0483o) || (m3633a = m3633a(((C0483o) abstractC0486r).m3643b())) == null) ? super.mo3629a(abstractC0486r) : m3633a;
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0470b
    /* renamed from: b */
    protected void mo3631b(XmlSerializer xmlSerializer, C0494e c0494e) {
        C0538c<C0485q, C0483o>[] c0538cArr = this.f3386b;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c0538cArr.length) {
                return;
            }
            C0538c<C0485q, C0483o> c0538c = c0538cArr[i2];
            int m3643b = c0538c.f3633b.m3643b();
            C0493d m3645c = c0538c.f3632a.m3645c();
            xmlSerializer.startTag((String) null, "enum");
            xmlSerializer.attribute((String) null, "name", m3645c != null ? m3645c.m3693e() : String.valueOf(m3643b));
            xmlSerializer.attribute((String) null, "value", String.valueOf(m3643b));
            xmlSerializer.endTag((String) null, "enum");
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private String m3633a(int i) {
        String str = this.f3387c.get(new Integer(i));
        if (str == null) {
            C0485q c0485q = (C0485q) null;
            C0538c<C0485q, C0483o>[] c0538cArr = this.f3386b;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= c0538cArr.length) {
                    break;
                }
                C0538c<C0485q, C0483o> c0538c = c0538cArr[i3];
                if (c0538c.f3633b.m3643b() == i) {
                    c0485q = c0538c.f3632a;
                    break;
                }
                i2 = i3 + 1;
            }
            if (c0485q != null) {
                if (!c0485q.m3647f()) {
                    str = c0485q.m3645c().m3693e();
                } else {
                    str = String.valueOf(i);
                }
                this.f3387c.put(new Integer(i), str);
            }
        }
        return str;
    }
}
