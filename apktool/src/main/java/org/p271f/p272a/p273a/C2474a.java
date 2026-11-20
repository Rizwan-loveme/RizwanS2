package org.p271f.p272a.p273a;

import org.p271f.p272a.AbstractC2473a;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2525q;
import org.p271f.p272a.C2529u;
import org.p271f.p272a.C2530v;
import org.p271f.p272a.InterfaceC2528t;

/* compiled from: LocalVariablesSorter.java */
/* renamed from: org.f.a.a.a */
/* loaded from: classes.dex */
public class C2474a extends AbstractC2526r {

    /* renamed from: e */
    private static final C2529u f12966e = C2529u.m15891b("java/lang/Object");

    /* renamed from: c */
    protected final int f12967c;

    /* renamed from: d */
    protected int f12968d;

    /* renamed from: f */
    private int[] f12969f;

    /* renamed from: g */
    private Object[] f12970g;

    /* renamed from: h */
    private boolean f12971h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected C2474a(int i, int i2, String str, AbstractC2526r abstractC2526r) {
        super(i, abstractC2526r);
        this.f12969f = new int[40];
        this.f12970g = new Object[20];
        C2529u[] m15893d = C2529u.m15893d(str);
        this.f12968d = (i2 & 8) == 0 ? 1 : 0;
        for (C2529u c2529u : m15893d) {
            this.f12968d += c2529u.m15902f();
        }
        this.f12967c = this.f12968d;
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: b */
    public void mo15648b(int i, int i2) {
        C2529u c2529u;
        switch (i) {
            case 21:
            case 54:
                c2529u = C2529u.f13278f;
                break;
            case 22:
            case 55:
                c2529u = C2529u.f13280h;
                break;
            case 23:
            case 56:
                c2529u = C2529u.f13279g;
                break;
            case 24:
            case 57:
                c2529u = C2529u.f13281i;
                break;
            default:
                c2529u = f12966e;
                break;
        }
        this.f13214c_.mo15648b(i, m15641b(i2, c2529u));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: c */
    public void mo15649c(int i, int i2) {
        this.f13214c_.mo15649c(m15641b(i, C2529u.f13278f), i2);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: d */
    public void mo15650d(int i, int i2) {
        this.f13214c_.mo15650d(i, this.f12968d);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15646a(String str, String str2, String str3, C2525q c2525q, C2525q c2525q2, int i) {
        this.f13214c_.mo15646a(str, str2, str3, c2525q, c2525q2, m15641b(i, C2529u.m15888a(str2)));
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public AbstractC2473a mo15643a(int i, C2530v c2530v, C2525q[] c2525qArr, C2525q[] c2525qArr2, int[] iArr, String str, boolean z) {
        C2529u m15888a = C2529u.m15888a(str);
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            iArr2[i2] = m15641b(iArr[i2], m15888a);
        }
        return this.f13214c_.mo15643a(i, c2530v, c2525qArr, c2525qArr2, iArr2, str, z);
    }

    @Override // org.p271f.p272a.AbstractC2526r
    /* renamed from: a */
    public void mo15644a(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4 = 0;
        if (i != -1) {
            throw new IllegalStateException("ClassReader.accept() should be called with EXPAND_FRAMES flag");
        }
        if (!this.f12971h) {
            this.f13214c_.mo15644a(i, i2, objArr, i3, objArr2);
            return;
        }
        Object[] objArr3 = new Object[this.f12970g.length];
        System.arraycopy(this.f12970g, 0, objArr3, 0, objArr3.length);
        m15647a(this.f12970g);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i2) {
            Object obj = objArr[i5];
            int i7 = (obj == InterfaceC2528t.f13270e || obj == InterfaceC2528t.f13269d) ? 2 : 1;
            if (obj != InterfaceC2528t.f13266a) {
                C2529u c2529u = f12966e;
                if (obj == InterfaceC2528t.f13267b) {
                    c2529u = C2529u.f13278f;
                } else if (obj == InterfaceC2528t.f13268c) {
                    c2529u = C2529u.f13279g;
                } else if (obj == InterfaceC2528t.f13270e) {
                    c2529u = C2529u.f13280h;
                } else if (obj == InterfaceC2528t.f13269d) {
                    c2529u = C2529u.f13281i;
                } else if (obj instanceof String) {
                    c2529u = C2529u.m15891b((String) obj);
                }
                m15640a(m15641b(i6, c2529u), obj);
            }
            i5++;
            i6 += i7;
        }
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i4;
            if (i10 < this.f12970g.length) {
                i4 = i10 + 1;
                Object obj2 = this.f12970g[i10];
                if (obj2 != null && obj2 != InterfaceC2528t.f13266a) {
                    this.f12970g[i8] = obj2;
                    i9 = i8 + 1;
                    if (obj2 == InterfaceC2528t.f13270e || obj2 == InterfaceC2528t.f13269d) {
                        i4++;
                    }
                } else {
                    this.f12970g[i8] = InterfaceC2528t.f13266a;
                }
                i8++;
            } else {
                this.f13214c_.mo15644a(i, i9, this.f12970g, i3, objArr2);
                this.f12970g = objArr3;
                return;
            }
        }
    }

    /* renamed from: a */
    protected void m15647a(Object[] objArr) {
    }

    /* renamed from: a */
    protected void m15645a(int i, C2529u c2529u) {
    }

    /* renamed from: a */
    private void m15640a(int i, Object obj) {
        int length = this.f12970g.length;
        if (i >= length) {
            Object[] objArr = new Object[Math.max(length * 2, i + 1)];
            System.arraycopy(this.f12970g, 0, objArr, 0, length);
            this.f12970g = objArr;
        }
        this.f12970g[i] = obj;
    }

    /* renamed from: b */
    private int m15641b(int i, C2529u c2529u) {
        int i2;
        if (c2529u.m15902f() + i > this.f12967c) {
            int m15902f = ((i * 2) + c2529u.m15902f()) - 1;
            int length = this.f12969f.length;
            if (m15902f >= length) {
                int[] iArr = new int[Math.max(length * 2, m15902f + 1)];
                System.arraycopy(this.f12969f, 0, iArr, 0, length);
                this.f12969f = iArr;
            }
            int i3 = this.f12969f[m15902f];
            if (i3 == 0) {
                i2 = m15642a(c2529u);
                m15645a(i2, c2529u);
                this.f12969f[m15902f] = i2 + 1;
            } else {
                i2 = i3 - 1;
            }
            if (i2 != i) {
                this.f12971h = true;
            }
            return i2;
        }
        return i;
    }

    /* renamed from: a */
    protected int m15642a(C2529u c2529u) {
        int i = this.f12968d;
        this.f12968d += c2529u.m15902f();
        return i;
    }
}
