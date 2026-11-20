package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.p084c.InterfaceC0669a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: MessageDigestSink.java */
/* renamed from: com.b.a.b.g.i */
/* loaded from: classes.dex */
public class C0650i implements InterfaceC0669a {

    /* renamed from: a */
    private final MessageDigest[] f4249a;

    public C0650i(MessageDigest[] messageDigestArr) {
        this.f4249a = messageDigestArr;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6240a(byte[] bArr, int i, int i2) {
        for (MessageDigest messageDigest : this.f4249a) {
            messageDigest.update(bArr, i, i2);
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0669a
    /* renamed from: a */
    public void mo6239a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        for (MessageDigest messageDigest : this.f4249a) {
            byteBuffer.position(position);
            messageDigest.update(byteBuffer);
        }
    }
}
