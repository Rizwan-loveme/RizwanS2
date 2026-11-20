package p165d.p167b.p173f;

import java.p209io.IOException;
import java.p209io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: PolicyMappingsExtension.java */
/* renamed from: d.b.f.bc */
/* loaded from: classes.dex */
public class C1485bc extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private List<C1521u> f9513d;

    /* renamed from: b */
    private void m11532b() {
        if (this.f9513d == null || this.f9513d.isEmpty()) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        Iterator<C1521u> it = this.f9513d.iterator();
        while (it.hasNext()) {
            it.next().m11682a(c1449l2);
        }
        c1449l.m11388a((byte) 48, c1449l2);
        this.f9412c = c1449l.toByteArray();
    }

    public C1485bc(List<C1521u> list) {
        this.f9513d = list;
        this.f9411b = C1481az.f9500s;
        this.f9410a = false;
        m11532b();
    }

    public C1485bc() {
        this.f9411b = C1481az.f9497p;
        this.f9410a = false;
        this.f9513d = Collections.emptyList();
    }

    public C1485bc(Boolean bool, Object obj) {
        this.f9411b = C1481az.f9500s;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for PolicyMappingsExtension.");
        }
        this.f9513d = new ArrayList();
        while (c1450m.f9356b.m11362a() != 0) {
            this.f9513d.add(new C1521u(c1450m.f9356b.m11371d()));
        }
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return this.f9513d == null ? "" : String.valueOf(super.toString()) + "PolicyMappings [\n" + this.f9513d.toString() + "]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9500s;
            this.f9410a = false;
            m11532b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "PolicyMappings";
    }
}
