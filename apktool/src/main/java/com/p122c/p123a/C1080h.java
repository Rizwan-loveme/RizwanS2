package com.p122c.p123a;

import java.io.RandomAccessFile;

/* compiled from: RandomAccessFileDataSource.java */
/* renamed from: com.c.a.h */
/* loaded from: classes.dex */
public class C1080h implements InterfaceC1073a {

    /* renamed from: a */
    private RandomAccessFile f6897a;

    public C1080h(RandomAccessFile randomAccessFile) {
        this.f6897a = randomAccessFile;
    }

    @Override // com.p122c.p123a.InterfaceC1073a
    /* renamed from: a */
    public short mo8987a() {
        return this.f6897a.readShort();
    }

    @Override // com.p122c.p123a.InterfaceC1073a
    /* renamed from: b */
    public int mo8988b() {
        return this.f6897a.readInt();
    }

    @Override // com.p122c.p123a.InterfaceC1073a
    /* renamed from: a */
    public int mo8986a(byte[] bArr) {
        return this.f6897a.read(bArr);
    }
}
