package p165d.p167b.p173f;

import android.provider.Telephony;
import java.io.IOException;
import java.io.OutputStream;
import javax.security.auth.x500.X500Principal;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;

/* compiled from: CertificateSubjectName.java */
/* renamed from: d.b.f.w */
/* loaded from: classes.dex */
public class C1523w implements InterfaceC1513m<String> {

    /* renamed from: a */
    private C1496bn f9733a;

    /* renamed from: b */
    private X500Principal f9734b;

    public C1523w(C1496bn c1496bn) {
        this.f9733a = c1496bn;
    }

    public C1523w(C1448k c1448k) {
        this.f9733a = new C1496bn(c1448k);
    }

    public String toString() {
        return this.f9733a == null ? "" : this.f9733a.toString();
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public void mo11475a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        this.f9733a.mo11479a(c1449l);
        outputStream.write(c1449l.toByteArray());
    }

    /* renamed from: a */
    public void m11686a(String str, Object obj) {
        if (!(obj instanceof C1496bn)) {
            throw new IOException("Attribute must be of type X500Name.");
        }
        if (str.equalsIgnoreCase("dname")) {
            this.f9733a = (C1496bn) obj;
            this.f9734b = null;
            return;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateSubjectName.");
    }

    /* renamed from: a */
    public Object m11685a(String str) {
        if (str.equalsIgnoreCase("dname")) {
            return this.f9733a;
        }
        if (str.equalsIgnoreCase("x500principal")) {
            if (this.f9734b == null && this.f9733a != null) {
                this.f9734b = this.f9733a.m11564a();
            }
            return this.f9734b;
        }
        throw new IOException("Attribute name not recognized by CertAttrSet:CertificateSubjectName.");
    }

    @Override // p165d.p167b.p173f.InterfaceC1513m
    /* renamed from: a */
    public String mo11473a() {
        return Telephony.TextBasedSmsColumns.SUBJECT;
    }
}
