package com.p065b.p086b.p100d.p101a;

/* compiled from: ShortArrayCodeOutput.java */
/* renamed from: com.b.b.d.a.o */
/* loaded from: classes.dex */
public final class C0889o extends AbstractC0876b implements InterfaceC0879e {

    /* renamed from: a */
    private final short[] f5399a;

    public C0889o(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("maxSize < 0");
        }
        this.f5399a = new short[i];
    }

    /* renamed from: c */
    public short[] m7541c() {
        int a2 = mo7449a();
        if (a2 == this.f5399a.length) {
            return this.f5399a;
        }
        short[] sArr = new short[a2];
        System.arraycopy(this.f5399a, 0, sArr, 0, a2);
        return sArr;
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7456a(short s) {
        this.f5399a[mo7449a()] = s;
        m7450a(1);
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7457a(short s, short s2) {
        mo7456a(s);
        mo7456a(s2);
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7458a(short s, short s2, short s3) {
        mo7456a(s);
        mo7456a(s2);
        mo7456a(s3);
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7459a(short s, short s2, short s3, short s4) {
        mo7456a(s);
        mo7456a(s2);
        mo7456a(s3);
        mo7456a(s4);
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7460a(short s, short s2, short s3, short s4, short s5) {
        mo7456a(s);
        mo7456a(s2);
        mo7456a(s3);
        mo7456a(s4);
        mo7456a(s5);
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a_ */
    public void mo7465a_(int i) {
        mo7456a((short) i);
        mo7456a((short) (i >> 16));
    }

    /* renamed from: a */
    public void m7540a(long j) {
        mo7456a((short) j);
        mo7456a((short) (j >> 16));
        mo7456a((short) (j >> 32));
        mo7456a((short) (j >> 48));
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7461a(byte[] bArr) {
        boolean z = true;
        int i = 0;
        for (byte b2 : bArr) {
            if (z) {
                i = b2 & 255;
                z = false;
            } else {
                i |= b2 << 8;
                mo7456a((short) i);
                z = true;
            }
        }
        if (!z) {
            mo7456a((short) i);
        }
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7464a(short[] sArr) {
        for (short s : sArr) {
            mo7456a(s);
        }
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7462a(int[] iArr) {
        for (int i : iArr) {
            mo7465a_(i);
        }
    }

    @Override // com.p065b.p086b.p100d.p101a.InterfaceC0879e
    /* renamed from: a */
    public void mo7463a(long[] jArr) {
        for (long j : jArr) {
            m7540a(j);
        }
    }
}
