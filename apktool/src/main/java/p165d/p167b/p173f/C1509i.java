package p165d.p167b.p173f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: CRLDistributionPointsExtension.java */
/* renamed from: d.b.f.i */
/* loaded from: classes.dex */
public class C1509i extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private List<C1459ad> f9709d;

    /* renamed from: e */
    private String f9710e;

    public C1509i(List<C1459ad> list) {
        this(false, list);
    }

    public C1509i(boolean z, List<C1459ad> list) {
        this(C1481az.f9485d, z, list, "CRLDistributionPoints");
    }

    protected C1509i(C1454q c1454q, boolean z, List<C1459ad> list, String str) {
        this.f9411b = c1454q;
        this.f9410a = z;
        this.f9709d = list;
        m11650b();
        this.f9710e = str;
    }

    public C1509i(Boolean bool, Object obj) {
        this(C1481az.f9485d, bool, obj, "CRLDistributionPoints");
    }

    protected C1509i(C1454q c1454q, Boolean bool, Object obj, String str) {
        this.f9411b = c1454q;
        this.f9410a = bool.booleanValue();
        if (!(obj instanceof byte[])) {
            throw new IOException("Illegal argument type");
        }
        this.f9412c = (byte[]) obj;
        C1450m c1450m = new C1450m(this.f9412c);
        if (c1450m.f9357c != 48) {
            throw new IOException("Invalid encoding for " + str + " extension.");
        }
        this.f9709d = new ArrayList();
        while (c1450m.f9356b.m11362a() != 0) {
            this.f9709d.add(new C1459ad(c1450m.f9356b.m11371d()));
        }
        this.f9710e = str;
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return this.f9710e;
    }

    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        m11651a(outputStream, C1481az.f9485d, false);
    }

    /* renamed from: a */
    protected void m11651a(OutputStream outputStream, C1454q c1454q, boolean z) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = c1454q;
            this.f9410a = z;
            m11650b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: b */
    private void m11650b() {
        if (this.f9709d.isEmpty()) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        Iterator<C1459ad> it = this.f9709d.iterator();
        while (it.hasNext()) {
            it.next().m11483a(c1449l);
        }
        C1449l c1449l2 = new C1449l();
        c1449l2.m11388a((byte) 48, c1449l);
        this.f9412c = c1449l2.toByteArray();
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + this.f9710e + " [\n  " + this.f9709d + "]\n";
    }
}
