package com.p065b.p111c.p120c;

import com.p065b.p111c.p113b.p118c.C1053a;
import com.p065b.p111c.p113b.p118c.C1061i;
import java.nio.ByteBuffer;
import java.io.RandomAccessFile;

/* compiled from: DataSources.java */
/* renamed from: com.b.c.c.d */
/* loaded from: classes.dex */
public abstract class AbstractC1070d {
    /* renamed from: a */
    public static InterfaceC1069c m8927a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException();
        }
        return new C1053a(byteBuffer);
    }

    /* renamed from: a */
    public static InterfaceC1069c m8925a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile == null) {
            throw new NullPointerException();
        }
        return new C1061i(randomAccessFile);
    }

    /* renamed from: a */
    public static InterfaceC1069c m8926a(RandomAccessFile randomAccessFile, long j, long j2) {
        if (randomAccessFile == null) {
            throw new NullPointerException();
        }
        return new C1061i(randomAccessFile, j, j2);
    }
}
