package p046b.p047a.p050c.p051a.p052a;

import android.app.slice.Slice;
import org.xmlpull.p291v1.XmlSerializer;
import p046b.p047a.C0461b;
import p046b.p047a.p050c.p051a.C0492c;
import p046b.p047a.p050c.p051a.C0494e;
import p046b.p047a.p050c.p051a.C0497h;
import p046b.p047a.p050c.p055d.InterfaceC0515a;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResAttr.java */
/* renamed from: b.a.c.a.a.b */
/* loaded from: classes.dex */
public class C0470b extends C0471c implements InterfaceC0515a {

    /* renamed from: f */
    private static boolean f3374f;

    /* renamed from: b */
    private final int f3375b;

    /* renamed from: c */
    private final Integer f3376c;

    /* renamed from: d */
    private final Integer f3377d;

    /* renamed from: e */
    private final Boolean f3378e;

    /* renamed from: b */
    protected void mo3631b(XmlSerializer xmlSerializer, C0494e c0494e) {
    }

    C0470b(C0485q c0485q, int i, Integer num, Integer num2, Boolean bool, boolean z, InterfaceC0541f interfaceC0541f) {
        super(c0485q, z, interfaceC0541f);
        this.f3375b = i;
        this.f3376c = num;
        this.f3377d = num2;
        this.f3378e = bool;
        f3374f = z;
    }

    /* renamed from: a */
    public String mo3629a(AbstractC0486r abstractC0486r) {
        return (String) null;
    }

    @Override // p046b.p047a.p050c.p051a.p052a.C0471c, p046b.p047a.p050c.p055d.InterfaceC0515a
    /* renamed from: a */
    public void mo3626a(XmlSerializer xmlSerializer, C0494e c0494e) {
        String m3628a = m3628a();
        xmlSerializer.startTag((String) null, C0497h.f3457a);
        xmlSerializer.attribute((String) null, "name", c0494e.m3700c().m3693e());
        if (m3628a != null) {
            xmlSerializer.attribute((String) null, "format", m3628a);
        }
        if (this.f3376c != null) {
            xmlSerializer.attribute((String) null, "min", this.f3376c.toString());
        }
        if (this.f3377d != null) {
            xmlSerializer.attribute((String) null, Slice.SUBTYPE_MAX, this.f3377d.toString());
        }
        if (this.f3378e != null && this.f3378e.booleanValue()) {
            xmlSerializer.attribute((String) null, "localization", "suggested");
        }
        mo3631b(xmlSerializer, c0494e);
        xmlSerializer.endTag((String) null, C0497h.f3457a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0470b m3627a(C0485q c0485q, C0538c<Integer, AbstractC0486r>[] c0538cArr, C0490v c0490v, C0492c c0492c, InterfaceC0541f interfaceC0541f) {
        int m3643b = ((C0483o) c0538cArr[0].f3633b).m3643b();
        int i = m3643b & 65535;
        Boolean bool = (Boolean) null;
        Integer num = (Integer) null;
        Integer num2 = (Integer) null;
        for (int i2 = 1; i2 < c0538cArr.length; i2++) {
            switch (c0538cArr[i2].f3632a.intValue()) {
                case 16777217:
                    num2 = new Integer(((C0483o) c0538cArr[i2].f3633b).m3643b());
                    continue;
                case 16777218:
                    num = new Integer(((C0483o) c0538cArr[i2].f3633b).m3643b());
                    continue;
                case 16777219:
                    bool = new Boolean(((C0483o) c0538cArr[i2].f3633b).m3643b() != 0);
                    continue;
            }
            if (i2 != c0538cArr.length) {
                return new C0470b(c0485q, i, num2, num, bool, f3374f, interfaceC0541f);
            }
            C0538c[] c0538cArr2 = new C0538c[c0538cArr.length - i2];
            int i3 = 0;
            for (int i4 = i2; i4 < c0538cArr.length; i4++) {
                int intValue = c0538cArr[i4].f3632a.intValue();
                c0492c.m3662a(intValue);
                c0538cArr2[i3] = new C0538c(c0490v.m3658a(intValue, (String) null), (C0483o) c0538cArr[i4].f3633b);
                i3++;
            }
            switch (16711680 & m3643b) {
                case 65536:
                    return new C0476h(c0485q, i, num2, num, bool, c0538cArr2, f3374f, interfaceC0541f);
                case 131072:
                    return new C0478j(c0485q, i, num2, num, bool, c0538cArr2, f3374f, interfaceC0541f);
                default:
                    throw new C0461b("Could not decode attr value");
            }
        }
        if (i2 != c0538cArr.length) {
        }
    }

    /* renamed from: a */
    protected String m3628a() {
        String stringBuffer = (this.f3375b & 1) != 0 ? new StringBuffer().append("").append("|reference").toString() : "";
        if ((this.f3375b & 2) != 0) {
            stringBuffer = new StringBuffer().append(stringBuffer).append("|string").toString();
        }
        if ((this.f3375b & 4) != 0) {
            stringBuffer = new StringBuffer().append(stringBuffer).append("|integer").toString();
        }
        if ((this.f3375b & 8) != 0) {
            stringBuffer = new StringBuffer().append(stringBuffer).append("|boolean").toString();
        }
        if ((this.f3375b & 16) != 0) {
            stringBuffer = new StringBuffer().append(stringBuffer).append("|color").toString();
        }
        if ((this.f3375b & 32) != 0) {
            stringBuffer = new StringBuffer().append(stringBuffer).append("|float").toString();
        }
        if ((this.f3375b & 64) != 0) {
            stringBuffer = new StringBuffer().append(stringBuffer).append("|dimension").toString();
        }
        if ((this.f3375b & 128) != 0) {
            stringBuffer = new StringBuffer().append(stringBuffer).append("|fraction").toString();
        }
        return stringBuffer.isEmpty() ? (String) null : stringBuffer.substring(1);
    }

    /* renamed from: b */
    public int m3630b() {
        return this.f3375b;
    }
}
