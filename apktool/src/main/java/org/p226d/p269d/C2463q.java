package org.p226d.p269d;

/* compiled from: SparseIntArray.java */
/* renamed from: org.d.d.q */
/* loaded from: classes.dex */
public class C2463q {

    /* renamed from: a */
    private int[] f12948a;

    /* renamed from: b */
    private int[] f12949b;

    /* renamed from: c */
    private int f12950c;

    public C2463q() {
        this(10);
    }

    public C2463q(int i) {
        this.f12948a = new int[i];
        this.f12949b = new int[i];
        this.f12950c = 0;
    }

    /* renamed from: a */
    public int m15556a(int i, int i2) {
        int m15555a = m15555a(this.f12948a, 0, this.f12950c, i);
        return m15555a < 0 ? i2 : this.f12949b[m15555a];
    }

    /* renamed from: b */
    public void m15557b(int i, int i2) {
        int m15555a = m15555a(this.f12948a, 0, this.f12950c, i);
        if (m15555a >= 0) {
            this.f12949b[m15555a] = i2;
            return;
        }
        int i3 = m15555a ^ (-1);
        if (this.f12950c >= this.f12948a.length) {
            int max = Math.max(this.f12950c + 1, this.f12948a.length * 2);
            int[] iArr = new int[max];
            int[] iArr2 = new int[max];
            System.arraycopy(this.f12948a, 0, iArr, 0, this.f12948a.length);
            System.arraycopy(this.f12949b, 0, iArr2, 0, this.f12949b.length);
            this.f12948a = iArr;
            this.f12949b = iArr2;
        }
        if (this.f12950c - i3 != 0) {
            System.arraycopy(this.f12948a, i3, this.f12948a, i3 + 1, this.f12950c - i3);
            System.arraycopy(this.f12949b, i3, this.f12949b, i3 + 1, this.f12950c - i3);
        }
        this.f12948a[i3] = i;
        this.f12949b[i3] = i2;
        this.f12950c++;
    }

    /* renamed from: c */
    public void m15558c(int i, int i2) {
        if (this.f12950c != 0 && i <= this.f12948a[this.f12950c - 1]) {
            m15557b(i, i2);
            return;
        }
        int i3 = this.f12950c;
        if (i3 >= this.f12948a.length) {
            int max = Math.max(i3 + 1, this.f12948a.length * 2);
            int[] iArr = new int[max];
            int[] iArr2 = new int[max];
            System.arraycopy(this.f12948a, 0, iArr, 0, this.f12948a.length);
            System.arraycopy(this.f12949b, 0, iArr2, 0, this.f12949b.length);
            this.f12948a = iArr;
            this.f12949b = iArr2;
        }
        this.f12948a[i3] = i;
        this.f12949b[i3] = i2;
        this.f12950c = i3 + 1;
    }

    /* renamed from: a */
    private static int m15555a(int[] iArr, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = i - 1;
        while (i4 - i5 > 1) {
            int i6 = (i4 + i5) / 2;
            if (iArr[i6] < i3) {
                i5 = i6;
            } else {
                i4 = i6;
            }
        }
        if (i4 == i + i2) {
            return (i + i2) ^ (-1);
        }
        return iArr[i4] != i3 ? i4 ^ (-1) : i4;
    }
}
