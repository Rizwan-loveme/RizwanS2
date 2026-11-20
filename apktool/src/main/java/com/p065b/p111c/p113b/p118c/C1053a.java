package com.p065b.p111c.p113b.p118c;

import com.p065b.p111c.p120c.InterfaceC1067a;
import com.p065b.p111c.p120c.InterfaceC1069c;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferDataSource.java */
/* renamed from: com.b.c.b.c.a */
/* loaded from: classes.dex */
public class C1053a implements InterfaceC1069c {

    /* renamed from: a */
    private final ByteBuffer f6692a;

    /* renamed from: b */
    private final int f6693b;

    public C1053a(ByteBuffer byteBuffer) {
        this(byteBuffer, true);
    }

    private C1053a(ByteBuffer byteBuffer, boolean z) {
        this.f6692a = z ? byteBuffer.slice() : byteBuffer;
        this.f6693b = byteBuffer.remaining();
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public long mo8840a() {
        return this.f6693b;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public ByteBuffer mo8842a(long j, int i) {
        ByteBuffer slice;
        m8839c(j, i);
        int i2 = (int) j;
        synchronized (this.f6692a) {
            this.f6692a.position(0);
            this.f6692a.limit(i2 + i);
            this.f6692a.position(i2);
            slice = this.f6692a.slice();
        }
        return slice;
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public void mo8843a(long j, int i, ByteBuffer byteBuffer) {
        byteBuffer.put(mo8842a(j, i));
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a */
    public void mo8844a(long j, long j2, InterfaceC1067a interfaceC1067a) {
        if (j2 < 0 || j2 > this.f6693b) {
            throw new IndexOutOfBoundsException("size: " + j2 + ", source size: " + this.f6693b);
        }
        interfaceC1067a.mo8846a(mo8842a(j, (int) j2));
    }

    @Override // com.p065b.p111c.p120c.InterfaceC1069c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1053a mo8845b(long j, long j2) {
        if (j == 0 && j2 == this.f6693b) {
            return this;
        }
        if (j2 < 0 || j2 > this.f6693b) {
            throw new IndexOutOfBoundsException("size: " + j2 + ", source size: " + this.f6693b);
        }
        return new C1053a(mo8842a(j, (int) j2), false);
    }

    /* renamed from: c */
    private void m8839c(long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: " + j);
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: " + j2);
        }
        if (j > this.f6693b) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + this.f6693b + ")");
        }
        long j3 = j + j2;
        if (j3 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j3 > this.f6693b) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + this.f6693b + ")");
        }
    }
}
