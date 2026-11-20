package com.p065b.p111c.p113b.p118c;

import com.p065b.p111c.p120c.InterfaceC1067a;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: MessageDigestSink.java */
/* renamed from: com.b.c.b.c.e */
/* loaded from: classes.dex */
public class C1057e implements InterfaceC1067a {

    /* renamed from: a */
    private final MessageDigest[] f6698a;

    public C1057e(MessageDigest[] messageDigestArr) {
        this.f6698a = messageDigestArr;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8847a(byte[] bArr, int i, int i2) {
        for (MessageDigest messageDigest : this.f6698a) {
            messageDigest.update(bArr, i, i2);
        }
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1067a
    /* renamed from: a */
    public void mo8846a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        for (MessageDigest messageDigest : this.f6698a) {
            byteBuffer.position(position);
            messageDigest.update(byteBuffer);
        }
    }
}
