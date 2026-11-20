package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: AuthorityInfoAccessExtension.java */
/* renamed from: d.b.f.f */
/* loaded from: classes.dex */
public class C1506f extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private List<C1504d> f9703d;

    public C1506f(List<C1504d> list) {
        this.f9411b = C1481az.f9482a;
        this.f9410a = false;
        this.f9703d = list;
        m11646b();
    }

    public C1506f(Boolean bool, Object obj) {
        this.f9411b = C1481az.f9482a;
        this.f9410a = bool.booleanValue();
        if (!(obj instanceof byte[])) {
            throw new IOException("Illegal argument type");
        }
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for AuthorityInfoAccessExtension.");
        }
        this.f9703d = new ArrayList();
        while (c1450m.f9356b.m11362a() != 0) {
            this.f9703d.add(new C1504d(c1450m.f9356b.m11371d()));
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "AuthorityInfoAccess";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9482a;
            this.f9410a = false;
            m11646b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: b */
    private void m11646b() {
        if (this.f9703d.isEmpty()) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        Iterator<C1504d> it = this.f9703d.iterator();
        while (it.hasNext()) {
            it.next().m11627a(c1449l);
        }
        C1449l c1449l2 = new C1449l();
        c1449l2.m11388a((byte) 48, c1449l);
        this.f9412c = c1449l2.toByteArray();
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + "AuthorityInfoAccess [\n  " + this.f9703d + "\n]\n";
    }
}
