package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.io.IOException;

/* compiled from: FileChannelDataSource.java */
/* renamed from: com.b.a.b.g.f */
/* loaded from: classes.dex */
public class C0647f implements InterfaceC0671c {
    private static final int MAX_READ_CHUNK_SIZE = 1048576;

    /* renamed from: a */
    private final FileChannel f4242a;

    /* renamed from: b */
    private final long f4243b;

    /* renamed from: c */
    private final long f4244c;

    public C0647f(FileChannel fileChannel) {
        this.f4242a = fileChannel;
        this.f4243b = 0L;
        this.f4244c = -1L;
    }

    public C0647f(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j2);
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
        this.f4242a = fileChannel;
        this.f4243b = j;
        this.f4244c = j2;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public long mo6233a() {
        long j = this.f4244c;
        if (j != -1) {
            return j;
        }
        try {
            return this.f4242a.size();
        } catch (IOException e2) {
            return 0L;
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0647f mo6238b(long j, long j2) {
        long mo6233a = mo6233a();
        m6243a(j, j2, mo6233a);
        return (j == 0 && j2 == mo6233a) ? this : new C0647f(this.f4242a, this.f4243b + j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        throw new java.io.IOException("Unexpected EOF encountered");
     */
    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo6237a(long j, long j2, InterfaceC0669a interfaceC0669a) {
        m6243a(j, j2, mo6233a());
        if (j2 != 0) {
            long j3 = this.f4243b + j;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect((int) Math.min(j2, 1048576L));
            loop0: while (true) {
                long j4 = j3;
                if (j2 > 0) {
                    int min = (int) Math.min(j2, allocateDirect.capacity());
                    allocateDirect.limit(min);
                    synchronized (this.f4242a) {
                        this.f4242a.position(j4);
                        int i = min;
                        while (i > 0) {
                            int read = this.f4242a.read(allocateDirect);
                            if (read < 0) {
                                break loop0;
                            } else {
                                i -= read;
                            }
                        }
                    }
                    allocateDirect.flip();
                    interfaceC0669a.mo6239a(allocateDirect);
                    allocateDirect.clear();
                    long j5 = min;
                    j3 = j4 + j5;
                    j2 -= j5;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public void mo6236a(long j, int i, ByteBuffer byteBuffer) {
        int read;
        m6243a(j, i, mo6233a());
        if (i != 0) {
            if (i > byteBuffer.remaining()) {
                throw new BufferOverflowException();
            }
            long j2 = this.f4243b + j;
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                while (i > 0) {
                    synchronized (this.f4242a) {
                        this.f4242a.position(j2);
                        read = this.f4242a.read(byteBuffer);
                    }
                    j2 += read;
                    i -= read;
                }
            } finally {
                byteBuffer.limit(limit);
            }
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public ByteBuffer mo6235a(long j, int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: " + i);
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        mo6236a(j, i, allocate);
        allocate.flip();
        return allocate;
    }

    /* renamed from: a */
    private static void m6243a(long j, long j2, long j3) {
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
        if (j4 <= j3) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
    }
}
