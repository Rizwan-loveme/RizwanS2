package org.p271f.p272a.p273a;

import org.p271f.p272a.AbstractC2473a;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2522n;
import org.p271f.p272a.C2525q;
import org.p271f.p272a.C2530v;

/* compiled from: RemappingMethodAdapter.java */
/* renamed from: org.f.a.a.f */
/* loaded from: classes.dex */
public class C2479f extends C2474a {

    /* renamed from: e */
    protected final AbstractC2475b f12976e;

    public C2479f(int i, String str, AbstractC2526r abstractC2526r, AbstractC2475b abstractC2475b) {
        this(327680, i, str, abstractC2526r, abstractC2475b);
    }

    protected C2479f(int i, int i2, String str, AbstractC2526r abstractC2526r, AbstractC2475b abstractC2475b) {
        super(i, i2, str, abstractC2526r);
        this.f12976e = abstractC2475b;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15676a() {
        AbstractC2473a a2 = super.mo15676a();
        return a2 == null ? a2 : new C2476c(a2, this.f12976e);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15679a(String str, boolean z) {
        AbstractC2473a a2 = super.mo15679a(this.f12976e.m15658b(str), z);
        return a2 == null ? a2 : new C2476c(a2, this.f12976e);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15678a(int i, C2530v c2530v, String str, boolean z) {
        AbstractC2473a a2 = super.mo15678a(i, c2530v, this.f12976e.m15658b(str), z);
        return a2 == null ? a2 : new C2476c(a2, this.f12976e);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15677a(int i, String str, boolean z) {
        AbstractC2473a a2 = super.mo15677a(i, this.f12976e.m15658b(str), z);
        return a2 == null ? a2 : new C2476c(a2, this.f12976e);
    }

    @Override // org.p271f.p272a.p273a.C2474a, org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15644a(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        super.mo15644a(i, i2, m15674a(i2, objArr), i3, m15674a(i3, objArr2));
    }

    /* renamed from: a */
    private Object[] m15674a(int i, Object[] objArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] instanceof String) {
                Object[] objArr2 = new Object[i];
                if (i2 > 0) {
                    System.arraycopy(objArr, 0, objArr2, 0, i2);
                }
                int i3 = i2;
                while (true) {
                    Object obj = objArr[i3];
                    int i4 = i3 + 1;
                    if (obj instanceof String) {
                        obj = this.f12976e.mo10335a((String) obj);
                    }
                    objArr2[i3] = obj;
                    if (i4 >= i) {
                        return objArr2;
                    }
                    i3 = i4;
                }
            }
        }
        return objArr;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15681a(int i, String str, String str2, String str3) {
        super.mo15681a(i, this.f12976e.mo10335a(str), this.f12976e.m15659b(str, str2, str3), this.f12976e.m15658b(str3));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    @Deprecated
    /* renamed from: b */
    public void mo15686b(int i, String str, String str2, String str3) {
        if (this.f13213b_ >= 327680) {
            super.mo15686b(i, str, str2, str3);
        } else {
            m15675b(i, str, str2, str3, i == 185);
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15682a(int i, String str, String str2, String str3, boolean z) {
        if (this.f13213b_ < 327680) {
            super.mo15682a(i, str, str2, str3, z);
        } else {
            m15675b(i, str, str2, str3, z);
        }
    }

    /* renamed from: b */
    private void m15675b(int i, String str, String str2, String str3, boolean z) {
        if (this.f13214c_ != null) {
            this.f13214c_.mo15682a(i, this.f12976e.mo10335a(str), this.f12976e.m15654a(str, str2, str3), this.f12976e.m15660c(str3), z);
        }
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15683a(String str, String str2, C2522n c2522n, Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = this.f12976e.m15652a(objArr[i]);
        }
        super.mo15683a(this.f12976e.m15653a(str, str2), this.f12976e.m15660c(str2), (C2522n) this.f12976e.m15652a(c2522n), objArr);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15680a(int i, String str) {
        super.mo15680a(i, this.f12976e.mo10335a(str));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo10229a(Object obj) {
        super.mo10229a(this.f12976e.m15652a(obj));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15687b(String str, int i) {
        super.mo15687b(this.f12976e.m15658b(str), i);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public AbstractC2473a mo15685b(int i, C2530v c2530v, String str, boolean z) {
        AbstractC2473a b2 = super.mo15685b(i, c2530v, this.f12976e.m15658b(str), z);
        return b2 == null ? b2 : new C2476c(b2, this.f12976e);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15684a(C2525q c2525q, C2525q c2525q2, C2525q c2525q3, String str) {
        super.mo15684a(c2525q, c2525q2, c2525q3, str == null ? null : this.f12976e.mo10335a(str));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public AbstractC2473a mo15688c(int i, C2530v c2530v, String str, boolean z) {
        AbstractC2473a c2 = super.mo15688c(i, c2530v, this.f12976e.m15658b(str), z);
        return c2 == null ? c2 : new C2476c(c2, this.f12976e);
    }

    @Override // org.p271f.p272a.p273a.C2474a, org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15646a(String str, String str2, String str3, C2525q c2525q, C2525q c2525q2, int i) {
        super.mo15646a(str, this.f12976e.m15658b(str2), this.f12976e.m15655a(str3, true), c2525q, c2525q2, i);
    }

    @Override // org.p271f.p272a.p273a.C2474a, org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15643a(int i, C2530v c2530v, C2525q[] c2525qArr, C2525q[] c2525qArr2, int[] iArr, String str, boolean z) {
        AbstractC2473a mo15643a = super.mo15643a(i, c2530v, c2525qArr, c2525qArr2, iArr, this.f12976e.m15658b(str), z);
        return mo15643a == null ? mo15643a : new C2476c(mo15643a, this.f12976e);
    }
}
