package p046b.p047a.p050c.p054c;

import java.p209io.OutputStream;
import java.p209io.Writer;
import org.xmlpull.p290a.C2573a;

/* compiled from: ExtMXSerializer.java */
/* renamed from: b.a.c.c.a */
/* loaded from: classes.dex */
public class C0513a extends C2573a implements InterfaceC0514b {

    /* renamed from: L */
    private String f3576L;

    /* renamed from: M */
    private boolean f3577M = false;

    @Override // org.xmlpull.p290a.C2573a, org.xmlpull.p291v1.XmlSerializer
    public void startDocument(String str, Boolean bool) {
        if (str == null) {
            str = this.f3576L;
        }
        super.startDocument(str, bool);
        mo3865a();
    }

    @Override // org.xmlpull.p290a.C2573a
    /* renamed from: a */
    protected void mo3866a(String str, Writer writer) {
        if (this.f3577M) {
            if (str == null) {
                str = "";
            }
            writer.write(str);
            return;
        }
        super.mo3866a(str, writer);
    }

    @Override // org.xmlpull.p290a.C2573a, org.xmlpull.p291v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) {
        if (str == null) {
            str = this.f3576L;
        }
        super.setOutput(outputStream, str);
    }

    @Override // org.xmlpull.p290a.C2573a, org.xmlpull.p291v1.XmlSerializer
    public Object getProperty(String str) {
        return InterfaceC0514b.f3578a_.equals(str) ? this.f3576L : super.getProperty(str);
    }

    @Override // org.xmlpull.p290a.C2573a, org.xmlpull.p291v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        if (InterfaceC0514b.f3578a_.equals(str)) {
            this.f3576L = (String) obj;
        } else {
            super.setProperty(str, obj);
        }
    }

    @Override // p046b.p047a.p050c.p054c.InterfaceC0514b
    /* renamed from: a */
    public InterfaceC0514b mo3865a() {
        this.f13388k.write(this.f13386i);
        return this;
    }

    /* renamed from: a */
    public void m3867a(boolean z) {
        this.f3577M = z;
    }

    @Override // p046b.p047a.p050c.p054c.InterfaceC0514b
    /* renamed from: b */
    public void mo3868b(boolean z) {
        this.f13403z = z;
    }
}
