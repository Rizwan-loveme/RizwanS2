package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: AuthorityKeyIdentifierExtension.java */
/* renamed from: d.b.f.g */
/* loaded from: classes.dex */
public class C1507g extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private C1474as f9704d;

    /* renamed from: e */
    private C1467al f9705e;

    /* renamed from: f */
    private C1490bh f9706f;

    /* renamed from: b */
    private void m11647b() {
        if (this.f9704d == null && this.f9705e == null && this.f9706f == null) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        if (this.f9704d != null) {
            C1449l c1449l3 = new C1449l();
            this.f9704d.m11511a(c1449l3);
            c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 0), c1449l3);
        }
        try {
            if (this.f9705e != null) {
                C1449l c1449l4 = new C1449l();
                this.f9705e.m11496a(c1449l4);
                c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, true, (byte) 1), c1449l4);
            }
            if (this.f9706f != null) {
                C1449l c1449l5 = new C1449l();
                this.f9706f.m11544a(c1449l5);
                c1449l2.m11400b(C1450m.m11408a(Byte.MIN_VALUE, false, (byte) 2), c1449l5);
            }
            c1449l.m11388a((byte) 48, c1449l2);
            this.f9412c = c1449l.toByteArray();
        } catch (Exception e2) {
            throw new IOException(e2.toString());
        }
    }

    public C1507g(C1474as c1474as, C1467al c1467al, C1490bh c1490bh) {
        this.f9704d = null;
        this.f9705e = null;
        this.f9706f = null;
        this.f9704d = c1474as;
        this.f9705e = c1467al;
        this.f9706f = c1490bh;
        this.f9411b = C1481az.f9483b;
        this.f9410a = false;
        m11647b();
    }

    public C1507g(Boolean bool, Object obj) {
        this.f9704d = null;
        this.f9705e = null;
        this.f9706f = null;
        this.f9411b = C1481az.f9483b;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for AuthorityKeyIdentifierExtension.");
        }
        while (c1450m.f9356b != null && c1450m.f9356b.m11362a() != 0) {
            C1450m m11371d = c1450m.f9356b.m11371d();
            if (m11371d.m11420b((byte) 0) && !m11371d.m11437r()) {
                if (this.f9704d != null) {
                    throw new IOException("Duplicate KeyIdentifier in AuthorityKeyIdentifier.");
                }
                m11371d.m11422c((byte) 4);
                this.f9704d = new C1474as(m11371d);
            } else if (m11371d.m11420b((byte) 1) && m11371d.m11437r()) {
                if (this.f9705e != null) {
                    throw new IOException("Duplicate GeneralNames in AuthorityKeyIdentifier.");
                }
                m11371d.m11422c((byte) 48);
                this.f9705e = new C1467al(m11371d);
            } else if (m11371d.m11420b((byte) 2) && !m11371d.m11437r()) {
                if (this.f9706f != null) {
                    throw new IOException("Duplicate SerialNumber in AuthorityKeyIdentifier.");
                }
                m11371d.m11422c((byte) 2);
                this.f9706f = new C1490bh(m11371d);
            } else {
                throw new IOException("Invalid encoding of AuthorityKeyIdentifierExtension.");
            }
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        String str = String.valueOf(super.toString()) + "AuthorityKeyIdentifier [\n";
        if (this.f9704d != null) {
            str = String.valueOf(str) + this.f9704d.toString() + "\n";
        }
        if (this.f9705e != null) {
            str = String.valueOf(str) + this.f9705e.toString() + "\n";
        }
        if (this.f9706f != null) {
            str = String.valueOf(str) + this.f9706f.toString() + "\n";
        }
        return String.valueOf(str) + "]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9483b;
            this.f9410a = false;
            m11647b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "AuthorityKeyIdentifier";
    }
}
