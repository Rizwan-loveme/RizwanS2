package com.p065b.p066a.p068b.p081g;

import com.p065b.p066a.C0681h;
import com.p065b.p066a.p084c.InterfaceC0669a;
import com.p065b.p066a.p084c.InterfaceC0671c;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: ChainedDataSource.java */
/* renamed from: com.b.a.b.g.d */
/* loaded from: classes.dex */
public class C0645d implements InterfaceC0671c {

    /* renamed from: a */
    private final InterfaceC0671c[] f4239a;

    /* renamed from: b */
    private final long f4240b;

    public C0645d(InterfaceC0671c... interfaceC0671cArr) {
        this.f4239a = interfaceC0671cArr;
        long j = 0;
        for (InterfaceC0671c interfaceC0671c : interfaceC0671cArr) {
            j += interfaceC0671c.mo6233a();
        }
        this.f4240b = j;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public long mo6233a() {
        return this.f4240b;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public void mo6237a(long j, long j2, InterfaceC0669a interfaceC0669a) {
        long j3;
        if (j + j2 > this.f4240b) {
            throw new IndexOutOfBoundsException("Requested more than available");
        }
        InterfaceC0671c[] interfaceC0671cArr = this.f4239a;
        int length = interfaceC0671cArr.length;
        int i = 0;
        long j4 = j2;
        long j5 = j;
        while (i < length) {
            InterfaceC0671c interfaceC0671c = interfaceC0671cArr[i];
            if (j5 >= interfaceC0671c.mo6233a()) {
                j3 = j5 - interfaceC0671c.mo6233a();
            } else {
                long mo6233a = interfaceC0671c.mo6233a() - j5;
                if (mo6233a >= j4) {
                    interfaceC0671c.mo6237a(j5, j4, interfaceC0669a);
                    return;
                } else {
                    interfaceC0671c.mo6237a(j5, mo6233a, interfaceC0669a);
                    j4 -= mo6233a;
                    j3 = 0;
                }
            }
            i++;
            j5 = j3;
        }
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public ByteBuffer mo6235a(long j, int i) {
        long j2 = i;
        if (j + j2 > this.f4240b) {
            throw new IndexOutOfBoundsException("Requested more than available");
        }
        C0652k<Integer, Long> m6242a = m6242a(j);
        int intValue = m6242a.m6251a().intValue();
        long longValue = m6242a.m6252b().longValue();
        if (j2 + longValue <= this.f4239a[intValue].mo6233a()) {
            return this.f4239a[intValue].mo6235a(longValue, i);
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        for (int i2 = intValue; i2 < this.f4239a.length && allocate.hasRemaining(); i2++) {
            this.f4239a[i2].mo6236a(longValue, C0681h.m6494a(Math.min(this.f4239a[i2].mo6233a() - longValue, allocate.remaining())), allocate);
            longValue = 0;
        }
        allocate.rewind();
        return allocate;
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: a */
    public void mo6236a(long j, int i, ByteBuffer byteBuffer) {
        mo6237a(j, i, new C0643b(byteBuffer));
    }

    @Override // com.p065b.p066a.p084c.InterfaceC0671c
    /* renamed from: b */
    public InterfaceC0671c mo6238b(long j, long j2) {
        C0652k<Integer, Long> m6242a = m6242a(j);
        int intValue = m6242a.m6251a().intValue();
        long longValue = m6242a.m6252b().longValue();
        InterfaceC0671c interfaceC0671c = this.f4239a[intValue];
        if (longValue + j2 <= interfaceC0671c.mo6233a()) {
            return interfaceC0671c.mo6238b(longValue, j2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(interfaceC0671c.mo6238b(longValue, interfaceC0671c.mo6233a() - longValue));
        C0652k<Integer, Long> m6242a2 = m6242a((j + j2) - 1);
        int intValue2 = m6242a2.m6251a().intValue();
        long longValue2 = m6242a2.m6252b().longValue();
        int i = intValue;
        while (true) {
            i++;
            if (i < intValue2) {
                arrayList.add(this.f4239a[i]);
            } else {
                arrayList.add(this.f4239a[intValue2].mo6238b(0L, longValue2 + 1));
                return new C0645d((InterfaceC0671c[]) arrayList.toArray(new InterfaceC0671c[0]));
            }
        }
    }

    /* renamed from: a */
    private C0652k<Integer, Long> m6242a(long j) {
        int i = 0;
        long j2 = j;
        while (true) {
            InterfaceC0671c[] interfaceC0671cArr = this.f4239a;
            if (i >= interfaceC0671cArr.length) {
                throw new IndexOutOfBoundsException("Access is out of bound, offset: " + j + ", totalSize: " + this.f4240b);
            }
            if (j2 < interfaceC0671cArr[i].mo6233a()) {
                return C0652k.m6250a(Integer.valueOf(i), Long.valueOf(j2));
            }
            j2 -= this.f4239a[i].mo6233a();
            i++;
        }
    }
}
