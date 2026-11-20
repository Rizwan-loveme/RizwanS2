package com.p065b.p086b.p110h;

import java.io.Writer;
import java.util.ArrayList;

/* compiled from: ByteArrayAnnotatedOutput.java */
/* renamed from: com.b.b.h.e */
/* loaded from: classes.dex */
public final class C1014e implements InterfaceC1007a, InterfaceC1017h {

    /* renamed from: a */
    private final boolean f6482a;

    /* renamed from: b */
    private byte[] f6483b;

    /* renamed from: c */
    private int f6484c;

    /* renamed from: d */
    private boolean f6485d;

    /* renamed from: e */
    private ArrayList<a> f6486e;

    /* renamed from: f */
    private int f6487f;

    /* renamed from: g */
    private int f6488g;

    public C1014e(byte[] bArr) {
        this(bArr, false);
    }

    public C1014e() {
        this(1000);
    }

    public C1014e(int i) {
        this(new byte[i], true);
    }

    private C1014e(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        this.f6482a = z;
        this.f6483b = bArr;
        this.f6484c = 0;
        this.f6485d = false;
        this.f6486e = null;
        this.f6487f = 0;
        this.f6488g = 0;
    }

    /* renamed from: e */
    public byte[] m8525e() {
        return this.f6483b;
    }

    /* renamed from: f */
    public byte[] m8527f() {
        byte[] bArr = new byte[this.f6484c];
        System.arraycopy(this.f6483b, 0, bArr, 0, this.f6484c);
        return bArr;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: g */
    public int mo8528g() {
        return this.f6484c;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: a */
    public void mo8515a(int i) {
        if (this.f6484c != i) {
            throw new C1019j("expected cursor " + i + "; actual value: " + this.f6484c);
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y, com.p065b.p086b.p110h.InterfaceC1017h
    /* renamed from: c */
    public void mo7631c(int i) {
        int i2 = this.f6484c;
        int i3 = i2 + 1;
        if (this.f6482a) {
            m8514i(i3);
        } else if (i3 > this.f6483b.length) {
            m8513i();
            return;
        }
        this.f6483b[i2] = (byte) i;
        this.f6484c = i3;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: b */
    public void mo8522b(int i) {
        int i2 = this.f6484c;
        int i3 = i2 + 2;
        if (this.f6482a) {
            m8514i(i3);
        } else if (i3 > this.f6483b.length) {
            m8513i();
            return;
        }
        this.f6483b[i2] = (byte) i;
        this.f6483b[i2 + 1] = (byte) (i >> 8);
        this.f6484c = i3;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: d */
    public void mo8523d(int i) {
        int i2 = this.f6484c;
        int i3 = i2 + 4;
        if (this.f6482a) {
            m8514i(i3);
        } else if (i3 > this.f6483b.length) {
            m8513i();
            return;
        }
        this.f6483b[i2] = (byte) i;
        this.f6483b[i2 + 1] = (byte) (i >> 8);
        this.f6483b[i2 + 2] = (byte) (i >> 16);
        this.f6483b[i2 + 3] = (byte) (i >> 24);
        this.f6484c = i3;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: a */
    public void mo8517a(long j) {
        int i = this.f6484c;
        int i2 = i + 8;
        if (this.f6482a) {
            m8514i(i2);
        } else if (i2 > this.f6483b.length) {
            m8513i();
            return;
        }
        int i3 = (int) j;
        this.f6483b[i] = (byte) i3;
        this.f6483b[i + 1] = (byte) (i3 >> 8);
        this.f6483b[i + 2] = (byte) (i3 >> 16);
        this.f6483b[i + 3] = (byte) (i3 >> 24);
        int i4 = (int) (j >> 32);
        this.f6483b[i + 4] = (byte) i4;
        this.f6483b[i + 5] = (byte) (i4 >> 8);
        this.f6483b[i + 6] = (byte) (i4 >> 16);
        this.f6483b[i + 7] = (byte) (i4 >> 24);
        this.f6484c = i2;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: e */
    public int mo8524e(int i) {
        if (this.f6482a) {
            m8514i(this.f6484c + 5);
        }
        int i2 = this.f6484c;
        C1029t.m8590a(this, i);
        return this.f6484c - i2;
    }

    /* renamed from: f */
    public int m8526f(int i) {
        if (this.f6482a) {
            m8514i(this.f6484c + 5);
        }
        int i2 = this.f6484c;
        C1029t.m8592b(this, i);
        return this.f6484c - i2;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: a */
    public void mo8518a(C1013d c1013d) {
        int m8502a = c1013d.m8502a();
        int i = this.f6484c;
        int i2 = m8502a + i;
        if (this.f6482a) {
            m8514i(i2);
        } else if (i2 > this.f6483b.length) {
            m8513i();
            return;
        }
        c1013d.m8505a(this.f6483b, i);
        this.f6484c = i2;
    }

    /* renamed from: a */
    public void m8521a(byte[] bArr, int i, int i2) {
        int i3 = this.f6484c;
        int i4 = i3 + i2;
        int i5 = i + i2;
        if ((i | i2 | i4) < 0 || i5 > bArr.length) {
            throw new IndexOutOfBoundsException("bytes.length " + bArr.length + "; " + i + "..!" + i4);
        }
        if (this.f6482a) {
            m8514i(i4);
        } else if (i4 > this.f6483b.length) {
            m8513i();
            return;
        }
        System.arraycopy(bArr, i, this.f6483b, i3, i2);
        this.f6484c = i4;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: a */
    public void mo8520a(byte[] bArr) {
        m8521a(bArr, 0, bArr.length);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: g */
    public void mo8529g(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        int i2 = this.f6484c + i;
        if (this.f6482a) {
            m8514i(i2);
        } else if (i2 > this.f6483b.length) {
            m8513i();
            return;
        }
        this.f6484c = i2;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1034y
    /* renamed from: h */
    public void mo8531h(int i) {
        int i2 = i - 1;
        if (i < 0 || (i2 & i) != 0) {
            throw new IllegalArgumentException("bogus alignment");
        }
        int i3 = (i2 ^ (-1)) & (this.f6484c + i2);
        if (this.f6482a) {
            m8514i(i3);
        } else if (i3 > this.f6483b.length) {
            m8513i();
            return;
        }
        this.f6484c = i3;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1007a
    /* renamed from: a */
    public boolean mo8460a() {
        return this.f6486e != null;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1007a
    /* renamed from: b */
    public boolean mo8461b() {
        return this.f6485d;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1007a
    /* renamed from: a */
    public void mo8459a(String str) {
        if (this.f6486e != null) {
            mo8462c();
            this.f6486e.add(new a(this.f6484c, str));
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1007a
    /* renamed from: a */
    public void mo8458a(int i, String str) {
        if (this.f6486e != null) {
            mo8462c();
            int size = this.f6486e.size();
            int m8534b = size == 0 ? 0 : this.f6486e.get(size - 1).m8534b();
            if (m8534b <= this.f6484c) {
                m8534b = this.f6484c;
            }
            this.f6486e.add(new a(m8534b, m8534b + i, str));
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1007a
    /* renamed from: c */
    public void mo8462c() {
        int size;
        if (this.f6486e != null && (size = this.f6486e.size()) != 0) {
            this.f6486e.get(size - 1).m8533a(this.f6484c);
        }
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1007a
    /* renamed from: d */
    public int mo8463d() {
        return this.f6487f - (((this.f6488g * 2) + 8) + (this.f6488g / 2));
    }

    /* renamed from: a */
    public void m8516a(int i, boolean z) {
        int i2 = 6;
        if (this.f6486e != null || this.f6484c != 0) {
            throw new RuntimeException("cannot enable annotations");
        }
        if (i < 40) {
            throw new IllegalArgumentException("annotationWidth < 40");
        }
        int i3 = (((i - 7) / 15) + 1) & (-2);
        if (i3 >= 6) {
            i2 = i3 > 10 ? 10 : i3;
        }
        this.f6486e = new ArrayList<>(1000);
        this.f6487f = i;
        this.f6488g = i2;
        this.f6485d = z;
    }

    /* renamed from: h */
    public void m8530h() {
        mo8462c();
        if (this.f6486e != null) {
            for (int size = this.f6486e.size(); size > 0; size--) {
                a aVar = this.f6486e.get(size - 1);
                if (aVar.m8532a() > this.f6484c) {
                    this.f6486e.remove(size - 1);
                } else {
                    if (aVar.m8534b() > this.f6484c) {
                        aVar.m8535b(this.f6484c);
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public void m8519a(Writer writer) {
        int m8534b;
        String m8536c;
        C1008aa c1008aa = new C1008aa(writer, (this.f6487f - r1) - 1, mo8463d(), "|");
        Writer m8470a = c1008aa.m8470a();
        Writer m8471b = c1008aa.m8471b();
        int size = this.f6486e.size();
        int i = 0;
        int i2 = 0;
        while (i2 < this.f6484c && i < size) {
            a aVar = this.f6486e.get(i);
            int m8532a = aVar.m8532a();
            if (i2 < m8532a) {
                m8536c = "";
                m8534b = m8532a;
            } else {
                m8534b = aVar.m8534b();
                i++;
                m8536c = aVar.m8536c();
                i2 = m8532a;
            }
            m8470a.write(C1022m.m8554a(this.f6483b, i2, m8534b - i2, i2, this.f6488g, 6));
            m8471b.write(m8536c);
            c1008aa.m8472c();
            i2 = m8534b;
        }
        if (i2 < this.f6484c) {
            m8470a.write(C1022m.m8554a(this.f6483b, i2, this.f6484c - i2, i2, this.f6488g, 6));
        }
        while (i < size) {
            m8471b.write(this.f6486e.get(i).m8536c());
            i++;
        }
        c1008aa.m8472c();
    }

    /* renamed from: i */
    private static void m8513i() {
        throw new IndexOutOfBoundsException("attempt to write past the end");
    }

    /* renamed from: i */
    private void m8514i(int i) {
        if (this.f6483b.length < i) {
            byte[] bArr = new byte[(i * 2) + 1000];
            System.arraycopy(this.f6483b, 0, bArr, 0, this.f6484c);
            this.f6483b = bArr;
        }
    }

    /* compiled from: ByteArrayAnnotatedOutput.java */
    /* renamed from: com.b.b.h.e$a */
    private static class a {

        /* renamed from: a */
        private final int f6489a;

        /* renamed from: b */
        private int f6490b;

        /* renamed from: c */
        private final String f6491c;

        public a(int i, int i2, String str) {
            this.f6489a = i;
            this.f6490b = i2;
            this.f6491c = str;
        }

        public a(int i, String str) {
            this(i, Integer.MAX_VALUE, str);
        }

        /* renamed from: a */
        public void m8533a(int i) {
            if (this.f6490b == Integer.MAX_VALUE) {
                this.f6490b = i;
            }
        }

        /* renamed from: b */
        public void m8535b(int i) {
            this.f6490b = i;
        }

        /* renamed from: a */
        public int m8532a() {
            return this.f6489a;
        }

        /* renamed from: b */
        public int m8534b() {
            return this.f6490b;
        }

        /* renamed from: c */
        public String m8536c() {
            return this.f6491c;
        }
    }
}
