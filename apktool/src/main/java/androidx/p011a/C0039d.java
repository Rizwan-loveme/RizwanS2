package androidx.p011a;

/* compiled from: LongSparseArray.java */
/* renamed from: androidx.a.d */
/* loaded from: classes.dex */
public class C0039d<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f306a = new Object();

    /* renamed from: b */
    private boolean f307b;

    /* renamed from: c */
    private long[] f308c;

    /* renamed from: d */
    private Object[] f309d;

    /* renamed from: e */
    private int f310e;

    public C0039d() {
        this(10);
    }

    public C0039d(int i) {
        this.f307b = false;
        if (i == 0) {
            this.f308c = C0038c.f304b;
            this.f309d = C0038c.f305c;
        } else {
            int m231b = C0038c.m231b(i);
            this.f308c = new long[m231b];
            this.f309d = new Object[m231b];
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0039d<E> clone() {
        try {
            C0039d<E> c0039d = (C0039d) super.clone();
            c0039d.f308c = (long[]) this.f308c.clone();
            c0039d.f309d = (Object[]) this.f309d.clone();
            return c0039d;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: a */
    public E m236a(long j) {
        return m237a(j, null);
    }

    /* renamed from: a */
    public E m237a(long j, E e2) {
        int m229a = C0038c.m229a(this.f308c, this.f310e, j);
        return (m229a < 0 || this.f309d[m229a] == f306a) ? e2 : (E) this.f309d[m229a];
    }

    /* renamed from: b */
    public void m240b(long j) {
        int m229a = C0038c.m229a(this.f308c, this.f310e, j);
        if (m229a >= 0 && this.f309d[m229a] != f306a) {
            this.f309d[m229a] = f306a;
            this.f307b = true;
        }
    }

    /* renamed from: d */
    private void m233d() {
        int i = this.f310e;
        long[] jArr = this.f308c;
        Object[] objArr = this.f309d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f306a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f307b = false;
        this.f310e = i2;
    }

    /* renamed from: b */
    public void m241b(long j, E e2) {
        int m229a = C0038c.m229a(this.f308c, this.f310e, j);
        if (m229a >= 0) {
            this.f309d[m229a] = e2;
            return;
        }
        int i = m229a ^ (-1);
        if (i < this.f310e && this.f309d[i] == f306a) {
            this.f308c[i] = j;
            this.f309d[i] = e2;
            return;
        }
        if (this.f307b && this.f310e >= this.f308c.length) {
            m233d();
            i = C0038c.m229a(this.f308c, this.f310e, j) ^ (-1);
        }
        if (this.f310e >= this.f308c.length) {
            int m231b = C0038c.m231b(this.f310e + 1);
            long[] jArr = new long[m231b];
            Object[] objArr = new Object[m231b];
            System.arraycopy(this.f308c, 0, jArr, 0, this.f308c.length);
            System.arraycopy(this.f309d, 0, objArr, 0, this.f309d.length);
            this.f308c = jArr;
            this.f309d = objArr;
        }
        if (this.f310e - i != 0) {
            System.arraycopy(this.f308c, i, this.f308c, i + 1, this.f310e - i);
            System.arraycopy(this.f309d, i, this.f309d, i + 1, this.f310e - i);
        }
        this.f308c[i] = j;
        this.f309d[i] = e2;
        this.f310e++;
    }

    /* renamed from: b */
    public int m238b() {
        if (this.f307b) {
            m233d();
        }
        return this.f310e;
    }

    /* renamed from: a */
    public long m234a(int i) {
        if (this.f307b) {
            m233d();
        }
        return this.f308c[i];
    }

    /* renamed from: b */
    public E m239b(int i) {
        if (this.f307b) {
            m233d();
        }
        return (E) this.f309d[i];
    }

    /* renamed from: c */
    public void m242c() {
        int i = this.f310e;
        Object[] objArr = this.f309d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f310e = 0;
        this.f307b = false;
    }

    /* renamed from: c */
    public void m243c(long j, E e2) {
        if (this.f310e != 0 && j <= this.f308c[this.f310e - 1]) {
            m241b(j, e2);
            return;
        }
        if (this.f307b && this.f310e >= this.f308c.length) {
            m233d();
        }
        int i = this.f310e;
        if (i >= this.f308c.length) {
            int m231b = C0038c.m231b(i + 1);
            long[] jArr = new long[m231b];
            Object[] objArr = new Object[m231b];
            System.arraycopy(this.f308c, 0, jArr, 0, this.f308c.length);
            System.arraycopy(this.f309d, 0, objArr, 0, this.f309d.length);
            this.f308c = jArr;
            this.f309d = objArr;
        }
        this.f308c[i] = j;
        this.f309d[i] = e2;
        this.f310e = i + 1;
    }

    public String toString() {
        if (m238b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f310e * 28);
        sb.append('{');
        for (int i = 0; i < this.f310e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m234a(i));
            sb.append('=');
            E m239b = m239b(i);
            if (m239b != this) {
                sb.append(m239b);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
