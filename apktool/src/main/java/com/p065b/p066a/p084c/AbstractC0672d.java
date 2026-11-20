package com.p065b.p066a.p084c;

import com.p065b.p066a.p068b.p081g.C0642a;
import com.p065b.p066a.p068b.p081g.C0647f;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.p209io.RandomAccessFile;

/* compiled from: DataSources.java */
/* renamed from: com.b.a.c.d */
/* loaded from: classes.dex */
public abstract class AbstractC0672d {
    private AbstractC0672d() {
    }

    /* renamed from: a */
    public static InterfaceC0671c m6337a(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        return new C0642a(byteBuffer);
    }

    /* renamed from: a */
    public static InterfaceC0671c m6335a(RandomAccessFile randomAccessFile) {
        return m6338a(randomAccessFile.getChannel());
    }

    /* renamed from: a */
    public static InterfaceC0671c m6336a(RandomAccessFile randomAccessFile, long j, long j2) {
        return m6339a(randomAccessFile.getChannel(), j, j2);
    }

    /* renamed from: a */
    public static InterfaceC0671c m6338a(FileChannel fileChannel) {
        fileChannel.getClass();
        return new C0647f(fileChannel);
    }

    /* renamed from: a */
    public static InterfaceC0671c m6339a(FileChannel fileChannel, long j, long j2) {
        fileChannel.getClass();
        return new C0647f(fileChannel, j, j2);
    }
}
