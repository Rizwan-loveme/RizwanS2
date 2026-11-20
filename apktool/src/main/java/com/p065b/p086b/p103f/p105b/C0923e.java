package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p107d.C0975c;

/* compiled from: DexTranslationAdvice.java */
/* renamed from: com.b.b.f.b.e */
/* loaded from: classes.dex */
public final class C0923e implements InterfaceC0944z {

    /* renamed from: a */
    public static final C0923e f5863a = new C0923e();

    /* renamed from: b */
    public static final C0923e f5864b = new C0923e(true);

    /* renamed from: c */
    private final boolean f5865c;

    private C0923e() {
        this.f5865c = false;
    }

    private C0923e(boolean z) {
        this.f5865c = z;
    }

    @Override // com.p065b.p086b.p103f.p105b.InterfaceC0944z
    /* renamed from: a */
    public boolean mo7871a(C0937s c0937s, C0934p c0934p, C0934p c0934p2) {
        if (c0934p.mo6695a() != C0975c.f6251f) {
            return false;
        }
        if (!(c0934p2.m7932h() instanceof C0959m)) {
            if ((c0934p.m7932h() instanceof C0959m) && c0937s.m7968a() == 15) {
                return ((C0959m) c0934p.m7932h()).m8066l();
            }
            return false;
        }
        C0959m c0959m = (C0959m) c0934p2.m7932h();
        switch (c0937s.m7968a()) {
            case 14:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
                return c0959m.m8066l();
            case 15:
                return C0959m.m8060a(-c0959m.m8061k_()).m8066l();
            case 19:
            default:
                return false;
            case 23:
            case 24:
            case 25:
                return c0959m.m8067m();
        }
    }

    @Override // com.p065b.p086b.p103f.p105b.InterfaceC0944z
    /* renamed from: a */
    public boolean mo7872a(C0937s c0937s, C0935q c0935q) {
        return !this.f5865c && c0937s.m7972e() && m7869a(c0935q) >= 6;
    }

    /* renamed from: a */
    private int m7869a(C0935q c0935q) {
        int f_ = c0935q.m8550f_();
        int i = 0;
        int i2 = 0;
        while (i < f_) {
            int m7935k = c0935q.m7949b(i).m7935k() + i2;
            i++;
            i2 = m7935k;
        }
        return i2;
    }

    @Override // com.p065b.p086b.p103f.p105b.InterfaceC0944z
    /* renamed from: a */
    public int mo7870a() {
        return 16;
    }
}
