package com.p065b.p111c.p113b.p118c;

import com.p065b.p111c.p120c.InterfaceC1067a;
import com.p065b.p111c.p120c.InterfaceC1069c;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: RandomAccessFileDataSource.java */
/* renamed from: com.b.c.b.c.i */
/* loaded from: classes.dex */
public class C1061i implements InterfaceC1069c {

    /* renamed from: a */
    private final RandomAccessFile f6705a;

    /* renamed from: b */
    private final long f6706b;

    /* renamed from: c */
    private final long f6707c;

    public C1061i(RandomAccessFile randomAccessFile) {
        this.f6705a = randomAccessFile;
        this.f6706b = 0L;
        this.f6707c = -1L;
    }

    public C1061i(RandomAccessFile randomAccessFile, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j2);
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
        this.f6705a = randomAccessFile;
        this.f6706b = j;
        this.f6707c = j2;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public long mo8840a() {
        if (this.f6707c == -1) {
            try {
                return this.f6705a.length();
            } catch (IOException e2) {
                return 0L;
            }
        }
        return this.f6707c;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1061i mo8845b(long j, long j2) {
        long mo8840a = mo8840a();
        m8854a(j, j2, mo8840a);
        return (j == 0 && j2 == mo8840a) ? this : new C1061i(this.f6705a, this.f6706b + j, j2);
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public void mo8844a(long j, long j2, InterfaceC1067a interfaceC1067a) {
        m8854a(j, j2, mo8840a());
        if (j2 != 0) {
            long j3 = this.f6706b + j;
            byte[] bArr = new byte[(int) Math.min(j2, 65536L)];
            while (j2 > 0) {
                int min = (int) Math.min(j2, bArr.length);
                synchronized (this.f6705a) {
                    this.f6705a.seek(j3);
                    this.f6705a.readFully(bArr, 0, min);
                }
                interfaceC1067a.mo8847a(bArr, 0, min);
                j3 += min;
                j2 -= min;
            }
        }
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public void mo8843a(long j, int i, ByteBuffer byteBuffer) {
        int read;
        m8854a(j, i, mo8840a());
        if (i != 0) {
            if (i > byteBuffer.remaining()) {
                throw new BufferOverflowException();
            }
            long j2 = this.f6706b + j;
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                FileChannel channel = this.f6705a.getChannel();
                while (i > 0) {
                    synchronized (this.f6705a) {
                        channel.position(j2);
                        read = channel.read(byteBuffer);
                    }
                    j2 += read;
                    i -= read;
                }
            } finally {
                byteBuffer.limit(limit);
            }
        }
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public ByteBuffer mo8842a(long j, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: " + i);
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        mo8843a(j, i, allocate);
        allocate.flip();
        return allocate;
    }

    /* renamed from: a */
    private static void m8854a(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j);
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
        }
    }
}
