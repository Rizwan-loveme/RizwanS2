package androidx.p011a;

/* compiled from: SparseArrayCompat.java */
/* renamed from: androidx.a.h */
/* loaded from: classes.dex */
public class C0043h<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f341a = new Object();

    /* renamed from: b */
    private boolean f342b;

    /* renamed from: c */
    private int[] f343c;

    /* renamed from: d */
    private Object[] f344d;

    /* renamed from: e */
    private int f345e;

    public C0043h() {
        this(10);
    }

    public C0043h(int i) {
        this.f342b = false;
        if (i == 0) {
            this.f343c = C0038c.f303a;
            this.f344d = C0038c.f305c;
        } else {
            int m227a = C0038c.m227a(i);
            this.f343c = new int[m227a];
            this.f344d = new Object[m227a];
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0043h<E> clone() {
        try {
            C0043h<E> c0043h = (C0043h) super.clone();
            c0043h.f343c = (int[]) this.f343c.clone();
            c0043h.f344d = (Object[]) this.f344d.clone();
            return c0043h;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* renamed from: a */
    public E m276a(int i) {
        return m277a(i, null);
    }

    /* renamed from: a */
    public E m277a(int i, E e2) {
        int m228a = C0038c.m228a(this.f343c, this.f345e, i);
        return (m228a < 0 || this.f344d[m228a] == f341a) ? e2 : (E) this.f344d[m228a];
    }

    /* renamed from: d */
    private void m274d() {
        int i = this.f345e;
        int[] iArr = this.f343c;
        Object[] objArr = this.f344d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f341a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f342b = false;
        this.f345e = i2;
    }

    /* renamed from: b */
    public void m280b(int i, E e2) {
        int m228a = C0038c.m228a(this.f343c, this.f345e, i);
        if (m228a >= 0) {
            this.f344d[m228a] = e2;
            return;
        }
        int i2 = m228a ^ (-1);
        if (i2 < this.f345e && this.f344d[i2] == f341a) {
            this.f343c[i2] = i;
            this.f344d[i2] = e2;
            return;
        }
        if (this.f342b && this.f345e >= this.f343c.length) {
            m274d();
            i2 = C0038c.m228a(this.f343c, this.f345e, i) ^ (-1);
        }
        if (this.f345e >= this.f343c.length) {
            int m227a = C0038c.m227a(this.f345e + 1);
            int[] iArr = new int[m227a];
            Object[] objArr = new Object[m227a];
            System.arraycopy(this.f343c, 0, iArr, 0, this.f343c.length);
            System.arraycopy(this.f344d, 0, objArr, 0, this.f344d.length);
            this.f343c = iArr;
            this.f344d = objArr;
        }
        if (this.f345e - i2 != 0) {
            System.arraycopy(this.f343c, i2, this.f343c, i2 + 1, this.f345e - i2);
            System.arraycopy(this.f344d, i2, this.f344d, i2 + 1, this.f345e - i2);
        }
        this.f343c[i2] = i;
        this.f344d[i2] = e2;
        this.f345e++;
    }

    /* renamed from: b */
    public int m278b() {
        if (this.f342b) {
            m274d();
        }
        return this.f345e;
    }

    /* renamed from: b */
    public int m279b(int i) {
        if (this.f342b) {
            m274d();
        }
        return this.f343c[i];
    }

    /* renamed from: c */
    public E m281c(int i) {
        if (this.f342b) {
            m274d();
        }
        return (E) this.f344d[i];
    }

    /* renamed from: c */
    public void m282c() {
        int i = this.f345e;
        Object[] objArr = this.f344d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f345e = 0;
        this.f342b = false;
    }

    /* renamed from: c */
    public void m283c(int i, E e2) {
        if (this.f345e != 0 && i <= this.f343c[this.f345e - 1]) {
            m280b(i, e2);
            return;
        }
        if (this.f342b && this.f345e >= this.f343c.length) {
            m274d();
        }
        int i2 = this.f345e;
        if (i2 >= this.f343c.length) {
            int m227a = C0038c.m227a(i2 + 1);
            int[] iArr = new int[m227a];
            Object[] objArr = new Object[m227a];
            System.arraycopy(this.f343c, 0, iArr, 0, this.f343c.length);
            System.arraycopy(this.f344d, 0, objArr, 0, this.f344d.length);
            this.f343c = iArr;
            this.f344d = objArr;
        }
        this.f343c[i2] = i;
        this.f344d[i2] = e2;
        this.f345e = i2 + 1;
    }

    public String toString() {
        if (m278b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f345e * 28);
        sb.append('{');
        for (int i = 0; i < this.f345e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m279b(i));
            sb.append('=');
            E m281c = m281c(i);
            if (m281c != this) {
                sb.append(m281c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
