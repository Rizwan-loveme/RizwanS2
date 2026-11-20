package com.p065b.p086b.p110h;

import java.util.Arrays;

/* compiled from: FixedSizeList.java */
/* renamed from: com.b.b.h.l */
/* loaded from: classes.dex */
public class C1021l extends C1031v implements InterfaceC1035z {

    /* renamed from: a */
    private Object[] f6495a;

    public C1021l(int i) {
        super(i != 0);
        try {
            this.f6495a = new Object[i];
        } catch (NegativeArraySizeException e2) {
            throw new IllegalArgumentException("size < 0");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f6495a, ((C1021l) obj).f6495a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f6495a);
    }

    public String toString() {
        String name = getClass().getName();
        return m8544a(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", false);
    }

    /* renamed from: d */
    public String mo6681d() {
        String name = getClass().getName();
        return m8544a(name.substring(name.lastIndexOf(46) + 1) + '{', ", ", "}", true);
    }

    /* renamed from: a */
    public String m8545a(String str, String str2, String str3) {
        return m8544a(str, str2, str3, false);
    }

    /* renamed from: b */
    public String m8547b(String str, String str2, String str3) {
        return m8544a(str, str2, str3, true);
    }

    /* renamed from: f_ */
    public final int m8550f_() {
        return this.f6495a.length;
    }

    /* renamed from: i */
    public void mo8551i() {
        int length = this.f6495a.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f6495a[i2] != null) {
                i++;
            }
        }
        if (length != i) {
            m8595l();
            Object[] objArr = new Object[i];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                Object obj = this.f6495a[i4];
                if (obj != null) {
                    objArr[i3] = obj;
                    i3++;
                }
            }
            this.f6495a = objArr;
            if (i == 0) {
                mo6683e_();
            }
        }
    }

    /* renamed from: e */
    protected final Object m8548e(int i) {
        try {
            Object obj = this.f6495a[i];
            if (obj == null) {
                throw new NullPointerException("unset: " + i);
            }
            return obj;
        } catch (ArrayIndexOutOfBoundsException e2) {
            return m8543a(i);
        }
    }

    /* renamed from: f */
    protected final Object m8549f(int i) {
        return this.f6495a[i];
    }

    /* renamed from: a */
    protected final void m8546a(int i, Object obj) {
        m8595l();
        try {
            this.f6495a[i] = obj;
        } catch (ArrayIndexOutOfBoundsException e2) {
            m8543a(i);
        }
    }

    /* renamed from: a */
    private Object m8543a(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("n < 0");
        }
        throw new IndexOutOfBoundsException("n >= size()");
    }

    /* renamed from: a */
    private String m8544a(String str, String str2, String str3, boolean z) {
        int length = this.f6495a.length;
        StringBuffer stringBuffer = new StringBuffer((length * 10) + 10);
        if (str != null) {
            stringBuffer.append(str);
        }
        for (int i = 0; i < length; i++) {
            if (i != 0 && str2 != null) {
                stringBuffer.append(str2);
            }
            if (z) {
                stringBuffer.append(((InterfaceC1035z) this.f6495a[i]).mo6681d());
            } else {
                stringBuffer.append(this.f6495a[i]);
            }
        }
        if (str3 != null) {
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }
}
