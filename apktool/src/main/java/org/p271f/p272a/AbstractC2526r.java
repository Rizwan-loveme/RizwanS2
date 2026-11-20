package org.p271f.p272a;

/* compiled from: MethodVisitor.java */
/* renamed from: org.f.a.r */
/* loaded from: classes.dex */
public abstract class AbstractC2526r {

    /* renamed from: b_ */
    protected final int f13213b_;

    /* renamed from: c_ */
    protected AbstractC2526r f13214c_;

    public AbstractC2526r(int i) {
        this(i, null);
    }

    public AbstractC2526r(int i, AbstractC2526r abstractC2526r) {
        if (i != 262144 && i != 327680) {
            throw new IllegalArgumentException();
        }
        this.f13213b_ = i;
        this.f13214c_ = abstractC2526r;
    }

    /* renamed from: a */
    public void mo15744a(String str, int i) {
        if (this.f13213b_ < 327680) {
            throw new RuntimeException();
        }
        if (this.f13214c_ != null) {
            this.f13214c_.mo15744a(str, i);
        }
    }

    /* renamed from: a */
    public AbstractC2473a mo15676a() {
        if (this.f13214c_ != null) {
            return this.f13214c_.mo15676a();
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC2473a mo15679a(String str, boolean z) {
        if (this.f13214c_ != null) {
            return this.f13214c_.mo15679a(str, z);
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC2473a mo15678a(int i, C2530v c2530v, String str, boolean z) {
        if (this.f13213b_ < 327680) {
            throw new RuntimeException();
        }
        if (this.f13214c_ != null) {
            return this.f13214c_.mo15678a(i, c2530v, str, z);
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC2473a mo15677a(int i, String str, boolean z) {
        if (this.f13214c_ != null) {
            return this.f13214c_.mo15677a(i, str, z);
        }
        return null;
    }

    /* renamed from: a */
    public void mo15745a(C2512d c2512d) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15745a(c2512d);
        }
    }

    /* renamed from: b */
    public void mo15751b() {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15751b();
        }
    }

    /* renamed from: a */
    public void mo15644a(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15644a(i, i2, objArr, i3, objArr2);
        }
    }

    /* renamed from: a */
    public void mo15740a(int i) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15740a(i);
        }
    }

    /* renamed from: a */
    public void mo15741a(int i, int i2) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15741a(i, i2);
        }
    }

    /* renamed from: b */
    public void mo15648b(int i, int i2) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15648b(i, i2);
        }
    }

    /* renamed from: a */
    public void mo15680a(int i, String str) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15680a(i, str);
        }
    }

    /* renamed from: a */
    public void mo15681a(int i, String str, String str2, String str3) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15681a(i, str, str2, str3);
        }
    }

    @Deprecated
    /* renamed from: b */
    public void mo15686b(int i, String str, String str2, String str3) {
        if (this.f13213b_ >= 327680) {
            mo15682a(i, str, str2, str3, i == 185);
        } else if (this.f13214c_ != null) {
            this.f13214c_.mo15686b(i, str, str2, str3);
        }
    }

    /* renamed from: a */
    public void mo15682a(int i, String str, String str2, String str3, boolean z) {
        if (this.f13213b_ < 327680) {
            if (z != (i == 185)) {
                throw new IllegalArgumentException("INVOKESPECIAL/STATIC on interfaces require ASM 5");
            }
            mo15686b(i, str, str2, str3);
        } else if (this.f13214c_ != null) {
            this.f13214c_.mo15682a(i, str, str2, str3, z);
        }
    }

    /* renamed from: a */
    public void mo15683a(String str, String str2, C2522n c2522n, Object... objArr) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15683a(str, str2, c2522n, objArr);
        }
    }

    /* renamed from: a */
    public void mo15743a(int i, C2525q c2525q) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15743a(i, c2525q);
        }
    }

    /* renamed from: a */
    public void mo15747a(C2525q c2525q) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15747a(c2525q);
        }
    }

    /* renamed from: a */
    public void mo10229a(Object obj) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo10229a(obj);
        }
    }

    /* renamed from: c */
    public void mo15649c(int i, int i2) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15649c(i, i2);
        }
    }

    /* renamed from: a */
    public void mo15742a(int i, int i2, C2525q c2525q, C2525q... c2525qArr) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15742a(i, i2, c2525q, c2525qArr);
        }
    }

    /* renamed from: a */
    public void mo15748a(C2525q c2525q, int[] iArr, C2525q[] c2525qArr) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15748a(c2525q, iArr, c2525qArr);
        }
    }

    /* renamed from: b */
    public void mo15687b(String str, int i) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15687b(str, i);
        }
    }

    /* renamed from: b */
    public AbstractC2473a mo15685b(int i, C2530v c2530v, String str, boolean z) {
        if (this.f13213b_ < 327680) {
            throw new RuntimeException();
        }
        if (this.f13214c_ != null) {
            return this.f13214c_.mo15685b(i, c2530v, str, z);
        }
        return null;
    }

    /* renamed from: a */
    public void mo15684a(C2525q c2525q, C2525q c2525q2, C2525q c2525q3, String str) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15684a(c2525q, c2525q2, c2525q3, str);
        }
    }

    /* renamed from: c */
    public AbstractC2473a mo15688c(int i, C2530v c2530v, String str, boolean z) {
        if (this.f13213b_ < 327680) {
            throw new RuntimeException();
        }
        if (this.f13214c_ != null) {
            return this.f13214c_.mo15688c(i, c2530v, str, z);
        }
        return null;
    }

    /* renamed from: a */
    public void mo15646a(String str, String str2, String str3, C2525q c2525q, C2525q c2525q2, int i) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15646a(str, str2, str3, c2525q, c2525q2, i);
        }
    }

    /* renamed from: a */
    public AbstractC2473a mo15643a(int i, C2530v c2530v, C2525q[] c2525qArr, C2525q[] c2525qArr2, int[] iArr, String str, boolean z) {
        if (this.f13213b_ < 327680) {
            throw new RuntimeException();
        }
        if (this.f13214c_ != null) {
            return this.f13214c_.mo15643a(i, c2530v, c2525qArr, c2525qArr2, iArr, str, z);
        }
        return null;
    }

    /* renamed from: b */
    public void mo15752b(int i, C2525q c2525q) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15752b(i, c2525q);
        }
    }

    /* renamed from: d */
    public void mo15650d(int i, int i2) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15650d(i, i2);
        }
    }

    /* renamed from: c */
    public void mo15753c() {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15753c();
        }
    }
}
