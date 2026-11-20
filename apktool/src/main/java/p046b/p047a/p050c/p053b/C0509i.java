package p046b.p047a.p050c.p053b;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import p046b.p047a.C0461b;

/* compiled from: ResStreamDecoderContainer.java */
/* renamed from: b.a.c.b.i */
/* loaded from: classes.dex */
public class C0509i {

    /* renamed from: a */
    private final Map<String, InterfaceC0508h> f3550a = new HashMap();

    /* renamed from: a */
    public void m3837a(InputStream inputStream, OutputStream outputStream, String str) {
        m3836a(str).mo3822a(inputStream, outputStream);
    }

    /* renamed from: a */
    public InterfaceC0508h m3836a(String str) {
        InterfaceC0508h interfaceC0508h = this.f3550a.get(str);
        if (interfaceC0508h == null) {
            throw new C0461b(new StringBuffer().append("Undefined decoder: ").append(str).toString());
        }
        return interfaceC0508h;
    }

    /* renamed from: a */
    public void m3838a(String str, InterfaceC0508h interfaceC0508h) {
        this.f3550a.put(str, interfaceC0508h);
    }
}
