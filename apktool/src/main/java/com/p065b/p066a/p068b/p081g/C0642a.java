package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferDataSource.java */
/* renamed from: com.b.a.b.g.a */
/* loaded from: classes.dex */
public class C0642a implements InterfaceC0671c {

    /* renamed from: a */
    private final ByteBuffer f4236a;

    /* renamed from: b */
    private final int f4237b;

    public C0642a(ByteBuffer byteBuffer) {
        this(byteBuffer, true);
    }

    private C0642a(ByteBuffer byteBuffer, boolean z) {
        this.f4236a = z ? byteBuffer.slice() : byteBuffer;
        this.f4237b = byteBuffer.remaining();
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public long mo6233a() {
        return this.f4237b;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public ByteBuffer mo6235a(long j, int i) {
        ByteBuffer slice;
        m6232c(j, i);
        int i2 = (int) j;
        synchronized (this.f4236a) {
            this.f4236a.position(0);
            this.f4236a.limit(i + i2);
            this.f4236a.position(i2);
            slice = this.f4236a.slice();
        }
        return slice;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public void mo6236a(long j, int i, ByteBuffer byteBuffer) {
        byteBuffer.put(mo6235a(j, i));
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public void mo6237a(long j, long j2, InterfaceC0669a interfaceC0669a) {
        if (j2 < 0 || j2 > this.f4237b) {
            throw new IndexOutOfBoundsException("size: " + j2 + ", source size: " + this.f4237b);
        }
        interfaceC0669a.mo6239a(mo6235a(j, (int) j2));
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0642a mo6238b(long j, long j2) {
        if (j == 0 && j2 == this.f4237b) {
            return this;
        }
        if (j2 < 0 || j2 > this.f4237b) {
            throw new IndexOutOfBoundsException("size: " + j2 + ", source size: " + this.f4237b);
        }
        return new C0642a(mo6235a(j, (int) j2), false);
    }

    /* renamed from: c */
    private void m6232c(long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j);
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
        int i = this.f4237b;
        if (j > i) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + this.f4237b + ")");
        }
        long j3 = j + j2;
        if (j3 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + this.f4237b + ")");
    }
}
