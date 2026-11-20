package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.p084c.InterfaceC0669a;
import java.nio.ByteBuffer;

/* compiled from: TeeDataSink.java */
/* renamed from: com.b.a.b.g.m */
/* loaded from: classes.dex */
public class C0654m implements InterfaceC0669a {

    /* renamed from: a */
    private final InterfaceC0669a[] f4256a;

    public C0654m(InterfaceC0669a[] interfaceC0669aArr) {
        this.f4256a = interfaceC0669aArr;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6240a(byte[] bArr, int i, int i2) {
        for (InterfaceC0669a interfaceC0669a : this.f4256a) {
            interfaceC0669a.mo6240a(bArr, i, i2);
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6239a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        for (int i = 0; i < this.f4256a.length; i++) {
            if (i > 0) {
                byteBuffer.position(position);
            }
            this.f4256a[i].mo6239a(byteBuffer);
        }
    }
}
