package org.p226d.p269d;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: SparseArray.java */
/* renamed from: org.d.d.p */
/* loaded from: classes.dex */
public class C2462p<E> {

    /* renamed from: a */
    private static final Object f12943a = new Object();

    /* renamed from: b */
    private boolean f12944b;

    /* renamed from: c */
    private int[] f12945c;

    /* renamed from: d */
    private Object[] f12946d;

    /* renamed from: e */
    private int f12947e;

    public C2462p() {
        this(10);
    }

    public C2462p(int i) {
        this.f12944b = false;
        this.f12945c = new int[i];
        this.f12946d = new Object[i];
        this.f12947e = 0;
    }

    /* renamed from: a */
    public E m15546a(int i) {
        return m15547a(i, null);
    }

    /* renamed from: a */
    public E m15547a(int i, E e2) {
        int m15543a = m15543a(this.f12945c, 0, this.f12947e, i);
        return (m15543a < 0 || this.f12946d[m15543a] == f12943a) ? e2 : (E) this.f12946d[m15543a];
    }

    /* renamed from: c */
    private void m15544c() {
        int i = this.f12947e;
        int[] iArr = this.f12945c;
        Object[] objArr = this.f12946d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f12943a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.f12944b = false;
        this.f12947e = i2;
    }

    /* renamed from: b */
    public void m15550b(int i, E e2) {
        int m15543a = m15543a(this.f12945c, 0, this.f12947e, i);
        if (m15543a >= 0) {
            this.f12946d[m15543a] = e2;
            return;
        }
        int i2 = m15543a ^ (-1);
        if (i2 < this.f12947e && this.f12946d[i2] == f12943a) {
            this.f12945c[i2] = i;
            this.f12946d[i2] = e2;
            return;
        }
        if (this.f12944b && this.f12947e >= this.f12945c.length) {
            m15544c();
            i2 = m15543a(this.f12945c, 0, this.f12947e, i) ^ (-1);
        }
        if (this.f12947e >= this.f12945c.length) {
            int max = Math.max(this.f12947e + 1, this.f12945c.length * 2);
            int[] iArr = new int[max];
            Object[] objArr = new Object[max];
            System.arraycopy(this.f12945c, 0, iArr, 0, this.f12945c.length);
            System.arraycopy(this.f12946d, 0, objArr, 0, this.f12946d.length);
            this.f12945c = iArr;
            this.f12946d = objArr;
        }
        if (this.f12947e - i2 != 0) {
            System.arraycopy(this.f12945c, i2, this.f12945c, i2 + 1, this.f12947e - i2);
            System.arraycopy(this.f12946d, i2, this.f12946d, i2 + 1, this.f12947e - i2);
        }
        this.f12945c[i2] = i;
        this.f12946d[i2] = e2;
        this.f12947e++;
    }

    /* renamed from: a */
    public int m15545a() {
        if (this.f12944b) {
            m15544c();
        }
        return this.f12947e;
    }

    /* renamed from: b */
    public int m15548b(int i) {
        if (this.f12944b) {
            m15544c();
        }
        return this.f12945c[i];
    }

    /* renamed from: c */
    public E m15551c(int i) {
        if (this.f12944b) {
            m15544c();
        }
        return (E) this.f12946d[i];
    }

    /* renamed from: d */
    public int m15553d(int i) {
        if (this.f12944b) {
            m15544c();
        }
        return m15543a(this.f12945c, 0, this.f12947e, i);
    }

    /* renamed from: c */
    public void m15552c(int i, E e2) {
        if (this.f12947e != 0 && i <= this.f12945c[this.f12947e - 1]) {
            m15550b(i, e2);
            return;
        }
        if (this.f12944b && this.f12947e >= this.f12945c.length) {
            m15544c();
        }
        int i2 = this.f12947e;
        if (i2 >= this.f12945c.length) {
            int max = Math.max(i2 + 1, this.f12945c.length * 2);
            int[] iArr = new int[max];
            Object[] objArr = new Object[max];
            System.arraycopy(this.f12945c, 0, iArr, 0, this.f12945c.length);
            System.arraycopy(this.f12946d, 0, objArr, 0, this.f12946d.length);
            this.f12945c = iArr;
            this.f12946d = objArr;
        }
        this.f12945c[i2] = i;
        this.f12946d[i2] = e2;
        this.f12947e = i2 + 1;
    }

    /* renamed from: e */
    public void m15554e(int i) {
        if (this.f12944b && this.f12947e >= this.f12945c.length) {
            m15544c();
        }
        if (this.f12945c.length < i) {
            int[] iArr = new int[i];
            Object[] objArr = new Object[i];
            System.arraycopy(this.f12945c, 0, iArr, 0, this.f12945c.length);
            System.arraycopy(this.f12946d, 0, objArr, 0, this.f12946d.length);
            this.f12945c = iArr;
            this.f12946d = objArr;
        }
    }

    /* renamed from: a */
    private static int m15543a(int[] iArr, int i, int i2, int i3) {
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

    /* renamed from: b */
    public List<E> m15549b() {
        return Collections.unmodifiableList(Arrays.asList(this.f12946d));
    }
}
