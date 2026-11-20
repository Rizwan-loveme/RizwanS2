package p165d.p167b.p173f;

import java.io.OutputStream;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: SubjectKeyIdentifierExtension.java */
/* renamed from: d.b.f.bj */
/* loaded from: classes.dex */
public class C1492bj extends C1463ah implements InterfaceC1513m<String> {

    /* renamed from: d */
    private C1474as f9523d;

    /* renamed from: b */
    private void m11547b() {
        if (this.f9523d == null) {
            this.f9412c = null;
            return;
        }
        C1449l c1449l = new C1449l();
        this.f9523d.m11511a(c1449l);
        this.f9412c = c1449l.toByteArray();
    }

    public C1492bj(byte[] bArr) {
        this.f9523d = null;
        this.f9523d = new C1474as(bArr);
        this.f9411b = C1481az.f9506y;
        this.f9410a = false;
        m11547b();
    }

    public C1492bj(Boolean bool, Object obj) {
        this.f9523d = null;
        this.f9411b = C1481az.f9506y;
        this.f9410a = bool.booleanValue();
        this.f9412c = (byte[]) obj;
        this.f9523d = new C1474as(new C1450m(this.f9412c));
    }

    @Override // p165d.p167b.p173f.C1463ah
    public String toString() {
        return String.valueOf(super.toString()) + "SubjectKeyIdentifier [\n" + String.valueOf(this.f9523d) + "]\n";
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        if (this.f9412c == null) {
            this.f9411b = C1481az.f9506y;
            this.f9410a = false;
            m11547b();
        }
        super.m11488a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return "SubjectKeyIdentifier";
    }
}
