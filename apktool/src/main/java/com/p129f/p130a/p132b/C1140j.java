package com.p129f.p130a.p132b;

import com.p129f.p130a.p132b.AbstractC1145o;
import java.io.Serializable;

/* compiled from: LongAdder.java */
/* renamed from: com.f.a.b.j */
/* loaded from: classes.dex */
final class C1140j extends AbstractC1145o implements InterfaceC1138h, Serializable {
    @Override // com.p129f.p130a.p132b.AbstractC1145o
    /* renamed from: a */
    final long mo9782a(long j, long j2) {
        return j + j2;
    }

    @Override // com.p129f.p130a.p132b.InterfaceC1138h
    /* renamed from: a */
    public void mo9778a(long j) {
        int length;
        AbstractC1145o.a aVar;
        boolean z = true;
        AbstractC1145o.a[] aVarArr = this.f7758d;
        if (aVarArr == null) {
            long j2 = this.f7759e;
            if (m9789b(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = f7752a.get();
        if (iArr != null && aVarArr != null && (length = aVarArr.length) >= 1 && (aVar = aVarArr[(length - 1) & iArr[0]]) != null) {
            long j3 = aVar.f7763a;
            z = aVar.m9792a(j3, j3 + j);
            if (z) {
                return;
            }
        }
        m9788a(j, iArr, z);
    }

    @Override // com.p129f.p130a.p132b.InterfaceC1138h
    /* renamed from: a */
    public void mo9777a() {
        mo9778a(1L);
    }

    /* renamed from: b */
    public long m9783b() {
        long j = this.f7759e;
        AbstractC1145o.a[] aVarArr = this.f7758d;
        if (aVarArr != null) {
            for (AbstractC1145o.a aVar : aVarArr) {
                if (aVar != null) {
                    j += aVar.f7763a;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(m9783b());
    }

    @Override // java.lang.Number
    public long longValue() {
        return m9783b();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) m9783b();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return m9783b();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return m9783b();
    }
}
