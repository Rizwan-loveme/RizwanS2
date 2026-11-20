package p165d.p167b.p169b;

import java.p209io.IOException;
import p165d.p167b.p172e.C1450m;

/* compiled from: SigningCertificateInfo.java */
/* renamed from: d.b.b.j */
/* loaded from: classes.dex */
public class C1432j {

    /* renamed from: a */
    private byte[] f9274a = null;

    /* renamed from: b */
    private C1424b[] f9275b = null;

    public C1432j(byte[] bArr) {
        m11287a(bArr);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[\n");
        for (int i = 0; i < this.f9275b.length; i++) {
            stringBuffer.append(this.f9275b[i].toString());
        }
        stringBuffer.append("\n]");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public void m11287a(byte[] bArr) {
        C1450m c1450m = new C1450m(bArr);
        if (c1450m.f9357c != 48) {
            throw new IOException("Bad encoding for signingCertificate");
        }
        C1450m[] m11364a = c1450m.f9356b.m11364a(1);
        this.f9275b = new C1424b[m11364a.length];
        for (int i = 0; i < m11364a.length; i++) {
            this.f9275b[i] = new C1424b(m11364a[i]);
        }
        if (c1450m.f9356b.m11362a() > 0) {
            for (int i2 = 0; i2 < c1450m.f9356b.m11364a(1).length; i2++) {
            }
        }
    }
}
