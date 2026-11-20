package p046b.p047a.p050c.p053b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.p217b.p218a.p219a.C1887e;
import p046b.p047a.C0461b;

/* compiled from: ResRawStreamDecoder.java */
/* renamed from: b.a.c.b.g */
/* loaded from: classes.dex */
public class C0507g implements InterfaceC0508h {
    @Override // p046b.p047a.p050c.p053b.InterfaceC0508h
    /* renamed from: a */
    public void mo3822a(InputStream inputStream, OutputStream outputStream) {
        try {
            C1887e.m13962a(inputStream, outputStream);
        } catch (IOException e2) {
            throw new C0461b("Could not decode raw stream", e2);
        }
    }
}
