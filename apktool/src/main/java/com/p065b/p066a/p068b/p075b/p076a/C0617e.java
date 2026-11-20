package com.p065b.p066a.p068b.p075b.p076a;

import java.nio.ByteBuffer;

/* compiled from: ByteBufferBerDataValueReader.java */
/* renamed from: com.b.a.b.b.a.e */
/* loaded from: classes.dex */
public class C0617e implements InterfaceC0615c {

    /* renamed from: a */
    private final ByteBuffer f4210a;

    /* renamed from: b */
    private int m6139b(int i) {
        return i & 127;
    }

    public C0617e(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("buf == null");
        }
        this.f4210a = byteBuffer;
    }

    @Override // com.p065b.p066a.p068b.p075b.p076a.InterfaceC0615c
    /* renamed from: a */
    public C0613a mo6123a() {
        int position;
        int m6142d;
        int position2 = this.f4210a.position();
        if (!this.f4210a.hasRemaining()) {
            return null;
        }
        byte b2 = this.f4210a.get();
        int m6136a = m6136a(b2);
        boolean m6135c = AbstractC0616d.m6135c(b2);
        if (!this.f4210a.hasRemaining()) {
            throw new C0614b("Missing length");
        }
        int i = this.f4210a.get() & 255;
        if ((i & 128) == 0) {
            int m6139b = m6139b(i);
            position = this.f4210a.position() - position2;
            m6141c(m6139b);
            m6142d = m6139b;
        } else if (i != 128) {
            int m6137a = m6137a(i);
            position = this.f4210a.position() - position2;
            m6141c(m6137a);
            m6142d = m6137a;
        } else {
            position = this.f4210a.position() - position2;
            if (m6135c) {
                m6142d = m6140c();
            } else {
                m6142d = m6142d();
            }
        }
        int position3 = this.f4210a.position();
        this.f4210a.position(position2);
        int limit = this.f4210a.limit();
        this.f4210a.limit(position3);
        ByteBuffer slice = this.f4210a.slice();
        ByteBuffer byteBuffer = this.f4210a;
        byteBuffer.position(byteBuffer.limit());
        this.f4210a.limit(limit);
        slice.position(position);
        slice.limit(position + m6142d);
        ByteBuffer slice2 = slice.slice();
        slice.clear();
        return new C0613a(slice, slice2, AbstractC0616d.m6127a(b2), m6135c, m6136a);
    }

    /* renamed from: a */
    private int m6136a(byte b2) {
        int m6133b = AbstractC0616d.m6133b(b2);
        return m6133b == 31 ? m6138b() : m6133b;
    }

    /* renamed from: b */
    private int m6138b() {
        int i = 0;
        while (this.f4210a.hasRemaining()) {
            byte b2 = this.f4210a.get();
            if (i > 16777215) {
                throw new C0614b("Tag number too large");
            }
            i = (i << 7) | (b2 & Byte.MAX_VALUE);
            if ((b2 & 128) == 0) {
                return i;
            }
        }
        throw new C0614b("Truncated tag number");
    }

    /* renamed from: a */
    private int m6137a(int i) {
        int i2 = i & 127;
        if (i2 > 4) {
            throw new C0614b("Length too large: " + i2 + " bytes");
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            if (!this.f4210a.hasRemaining()) {
                throw new C0614b("Truncated length");
            }
            byte b2 = this.f4210a.get();
            if (i4 > 8388607) {
                throw new C0614b("Length too large");
            }
            i3++;
            i4 = (b2 & 255) | (i4 << 8);
        }
        return i4;
    }

    /* renamed from: c */
    private void m6141c(int i) {
        if (this.f4210a.remaining() < i) {
            throw new C0614b("Truncated contents. Need: " + i + " bytes, available: " + this.f4210a.remaining());
        }
        ByteBuffer byteBuffer = this.f4210a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* renamed from: d */
    private int m6142d() {
        int i = 0;
        while (true) {
            boolean z = false;
            while (this.f4210a.hasRemaining()) {
                byte b2 = this.f4210a.get();
                i++;
                if (i < 0) {
                    throw new C0614b("Indefinite-length contents too long");
                }
                if (b2 == 0) {
                    if (z) {
                        return i - 2;
                    }
                    z = true;
                }
            }
            throw new C0614b("Truncated indefinite-length contents: " + i + " bytes read");
        }
    }

    /* renamed from: c */
    private int m6140c() {
        int position = this.f4210a.position();
        while (this.f4210a.hasRemaining()) {
            if (this.f4210a.remaining() > 1) {
                ByteBuffer byteBuffer = this.f4210a;
                if (byteBuffer.getShort(byteBuffer.position()) == 0) {
                    int position2 = this.f4210a.position();
                    ByteBuffer byteBuffer2 = this.f4210a;
                    byteBuffer2.position(byteBuffer2.position() + 2);
                    return position2 - position;
                }
            }
            mo6123a();
        }
        throw new C0614b("Truncated indefinite-length contents: " + (this.f4210a.position() - position) + " bytes read");
    }
}
