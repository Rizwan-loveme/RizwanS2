package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import java.util.Vector;
import javax.xml.datatype.DatatypeConstants;
import p165d.p167b.p172e.C1440c;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: NetscapeCertTypeExtension.java */
/* renamed from: d.b.f.av */
/* loaded from: classes.dex */
public class C1477av extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    public static C1454q f9438d;

    /* renamed from: e */
    private static final int[] f9439e = {2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 113730, 1, 1};

    /* renamed from: f */
    private static final Vector<String> f9440f;

    /* renamed from: g */
    private static a[] f9441g;

    /* renamed from: h */
    private boolean[] f9442h;

    static {
        try {
            f9438d = new C1454q(f9439e);
        } catch (IOException e2) {
        }
        f9441g = new a[]{new a("ssl_client", 0), new a("ssl_server", 1), new a("s_mime", 2), new a("object_signing", 3), new a("ssl_ca", 5), new a("s_mime_ca", 6), new a("object_signing_ca", 7)};
        f9440f = new Vector<>();
        for (a aVar : f9441g) {
            f9440f.add(aVar.f9443a);
        }
    }

    /* compiled from: NetscapeCertTypeExtension.java */
    /* renamed from: d.b.f.av$a */
    private static class a {

        /* renamed from: a */
        String f9443a;

        /* renamed from: b */
        int f9444b;

        a(String str, int i) {
            this.f9443a = str;
            this.f9444b = i;
        }
    }

    /* renamed from: b */
    private void m11519b() {
        C1449l c1449l = new C1449l();
        c1449l.m11392a(new C1440c(this.f9442h));
        this.f9412c = c1449l.toByteArray();
    }

    /* renamed from: a */
    private boolean m11518a(int i) {
        return i < this.f9442h.length && this.f9442h[i];
    }

    public C1477av(byte[] bArr) {
        this.f9442h = new C1440c(bArr.length * 8, bArr).m11322b();
        this.f9411b = f9438d;
        this.f9410a = true;
        m11519b();
    }

    public C1477av(boolean[] zArr) {
        this.f9442h = zArr;
        this.f9411b = f9438d;
        this.f9410a = true;
        m11519b();
    }

    public C1477av(Boolean bool, Object obj) {
        this.f9411b = f9438d;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        this.f9442h = new C1450m(this.f9412c).m11436q().m11322b();
    }

    public C1477av() {
        this.f9411b = f9438d;
        this.f9410a = true;
        this.f9442h = new boolean[0];
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("NetscapeCertType [\n");
        if (m11518a(0)) {
            sb.append("   SSL client\n");
        }
        if (m11518a(1)) {
            sb.append("   SSL server\n");
        }
        if (m11518a(2)) {
            sb.append("   S/MIME\n");
        }
        if (m11518a(3)) {
            sb.append("   Object Signing\n");
        }
        if (m11518a(5)) {
            sb.append("   SSL CA\n");
        }
        if (m11518a(6)) {
            sb.append("   S/MIME CA\n");
        }
        if (m11518a(7)) {
            sb.append("   Object Signing CA");
        }
        sb.append("]\n");
        return sb.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = f9438d;
            this.f9410a = true;
            m11519b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "NetscapeCertType";
    }
}
