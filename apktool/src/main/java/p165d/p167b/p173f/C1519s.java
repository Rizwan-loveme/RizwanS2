package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: CertificatePoliciesExtension.java */
/* renamed from: d.b.f.s */
/* loaded from: classes.dex */
public class C1519s extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private List<C1484bb> f9728d;

    /* renamed from: b */
    private void m11679b() {
        if (this.f9728d == null || this.f9728d.isEmpty()) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        Iterator<C1484bb> it = this.f9728d.iterator();
        while (it.hasNext()) {
            it.next().m11530a(c1449l2);
        }
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9412c = c1449l.toByteArray();
    }

    public C1519s(List<C1484bb> list) {
        this(Boolean.FALSE, list);
    }

    public C1519s(Boolean bool, List<C1484bb> list) {
        this.f9728d = list;
        this.f9411b = C1481az.f9488g;
        this.f9410a = bool.booleanValue();
        m11679b();
    }

    public C1519s(Boolean bool, Object obj) {
        this.f9411b = C1481az.f9488g;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for CertificatePoliciesExtension.");
        }
        this.f9728d = new ArrayList();
        while (c1450m.f9356b.m11362a() != 0) {
            this.f9728d.add(new C1484bb(c1450m.f9356b.m11371d()));
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        if (this.f9728d == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("CertificatePolicies [\n");
        Iterator<C1484bb> it = this.f9728d.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        sb.append("]\n");
        return sb.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9488g;
            this.f9410a = false;
            m11679b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "CertificatePolicies";
    }
}
