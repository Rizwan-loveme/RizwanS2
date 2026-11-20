package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1440c;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: KeyUsageExtension.java */
/* renamed from: d.b.f.at */
/* loaded from: classes.dex */
public class C1475at extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private boolean[] f9434d;

    /* renamed from: f */
    private void m11514f() {
        C1449l c1449l = new C1449l();
        c1449l.m11392a(new C1440c(this.f9434d));
        this.f9412c = c1449l.toByteArray();
    }

    /* renamed from: a */
    private boolean m11513a(int i) {
        return i < this.f9434d.length && this.f9434d[i];
    }

    public C1475at(byte[] bArr) {
        this.f9434d = new C1440c(bArr.length * 8, bArr).m11322b();
        this.f9411b = C1481az.f9497p;
        this.f9410a = true;
        m11514f();
    }

    public C1475at(boolean[] zArr) {
        this.f9434d = zArr;
        this.f9411b = C1481az.f9497p;
        this.f9410a = true;
        m11514f();
    }

    public C1475at(C1440c c1440c) {
        this.f9434d = c1440c.m11322b();
        this.f9411b = C1481az.f9497p;
        this.f9410a = true;
        m11514f();
    }

    public C1475at(Boolean bool, Object obj) {
        this.f9411b = C1481az.f9497p;
        this.f9410a = bool.booleanValue();
        byte[] bArr = (byte[]) obj;
        if (bArr[0] == 4) {
            this.f9412c = new C1450m(bArr).m11432m();
        } else {
            this.f9412c = bArr;
        }
        this.f9434d = new C1450m(this.f9412c).m11436q().m11322b();
    }

    public C1475at() {
        this.f9411b = C1481az.f9497p;
        this.f9410a = true;
        this.f9434d = new boolean[0];
    }

    /* renamed from: a */
    public Boolean m11515a(String str) {
        if (str.equalsIgnoreCase("digital_signature")) {
            return Boolean.valueOf(m11513a(0));
        }
        if (str.equalsIgnoreCase("non_repudiation")) {
            return Boolean.valueOf(m11513a(1));
        }
        if (str.equalsIgnoreCase("key_encipherment")) {
            return Boolean.valueOf(m11513a(2));
        }
        if (str.equalsIgnoreCase("data_encipherment")) {
            return Boolean.valueOf(m11513a(3));
        }
        if (str.equalsIgnoreCase("key_agreement")) {
            return Boolean.valueOf(m11513a(4));
        }
        if (str.equalsIgnoreCase("key_certsign")) {
            return Boolean.valueOf(m11513a(5));
        }
        if (str.equalsIgnoreCase("crl_sign")) {
            return Boolean.valueOf(m11513a(6));
        }
        if (str.equalsIgnoreCase("encipher_only")) {
            return Boolean.valueOf(m11513a(7));
        }
        if (str.equalsIgnoreCase("decipher_only")) {
            return Boolean.valueOf(m11513a(8));
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:KeyUsage.");
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("KeyUsage [\n");
        if (m11513a(0)) {
            sb.append("  DigitalSignature\n");
        }
        if (m11513a(1)) {
            sb.append("  Non_repudiation\n");
        }
        if (m11513a(2)) {
            sb.append("  Key_Encipherment\n");
        }
        if (m11513a(3)) {
            sb.append("  Data_Encipherment\n");
        }
        if (m11513a(4)) {
            sb.append("  Key_Agreement\n");
        }
        if (m11513a(5)) {
            sb.append("  Key_CertSign\n");
        }
        if (m11513a(6)) {
            sb.append("  Crl_Sign\n");
        }
        if (m11513a(7)) {
            sb.append("  Encipher_Only\n");
        }
        if (m11513a(8)) {
            sb.append("  Decipher_Only\n");
        }
        sb.append("]\n");
        return sb.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9497p;
            this.f9410a = true;
            m11514f();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: b */
    public boolean[] m11516b() {
        return (boolean[]) this.f9434d.clone();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "KeyUsage";
    }
}
