package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p095c.p097b.C0803e;
import com.p065b.p086b.p103f.p105b.C0920b;
import com.p065b.p086b.p103f.p105b.C0921c;
import com.p065b.p086b.p103f.p105b.C0938t;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1025p;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: StdCatchBuilder.java */
/* renamed from: com.b.b.c.b.aa */
/* loaded from: classes.dex */
public final class C0795aa implements InterfaceC0801c {

    /* renamed from: a */
    private final C0938t f4765a;

    /* renamed from: b */
    private final int[] f4766b;

    /* renamed from: c */
    private final C0800b f4767c;

    public C0795aa(C0938t c0938t, int[] iArr, C0800b c0800b) {
        if (c0938t == null) {
            throw new NullPointerException("method == null");
        }
        if (iArr == null) {
            throw new NullPointerException("order == null");
        }
        if (c0800b == null) {
            throw new NullPointerException("addresses == null");
        }
        this.f4765a = c0938t;
        this.f4766b = iArr;
        this.f4767c = c0800b;
    }

    @Override // com.p065b.p086b.p095c.p097b.InterfaceC0801c
    /* renamed from: a */
    public C0803e mo6982a() {
        return m6980a(this.f4765a, this.f4766b, this.f4767c);
    }

    @Override // com.p065b.p086b.p095c.p097b.InterfaceC0801c
    /* renamed from: b */
    public boolean mo6983b() {
        C0921c m7977a = this.f4765a.m7977a();
        int f_ = m7977a.m8550f_();
        for (int i = 0; i < f_; i++) {
            if (m7977a.m7854a(i).m7851g().mo7876b().mo6856f_() != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.p065b.p086b.p095c.p097b.InterfaceC0801c
    /* renamed from: c */
    public HashSet<C0975c> mo6984c() {
        HashSet<C0975c> hashSet = new HashSet<>(20);
        C0921c m7977a = this.f4765a.m7977a();
        int f_ = m7977a.m8550f_();
        for (int i = 0; i < f_; i++) {
            InterfaceC0977e mo7876b = m7977a.m7854a(i).m7851g().mo7876b();
            int mo6856f_ = mo7876b.mo6856f_();
            for (int i2 = 0; i2 < mo6856f_; i2++) {
                hashSet.add(mo7876b.mo6853a(i2));
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public static C0803e m6980a(C0938t c0938t, int[] iArr, C0800b c0800b) {
        int length = iArr.length;
        C0921c m7977a = c0938t.m7977a();
        ArrayList arrayList = new ArrayList(length);
        C0802d c0802d = C0802d.f4776a;
        C0920b c0920b = null;
        C0920b c0920b2 = null;
        for (int i : iArr) {
            C0920b m7858b = m7977a.m7858b(i);
            if (m7858b.m7852h()) {
                C0802d m6978a = m6978a(m7858b, c0800b);
                if (c0802d.m8550f_() == 0) {
                    c0920b = m7858b;
                    c0920b2 = m7858b;
                    c0802d = m6978a;
                } else if (c0802d.equals(m6978a) && m6981a(c0920b2, m7858b, c0800b)) {
                    c0920b = m7858b;
                } else {
                    if (c0802d.m8550f_() != 0) {
                        arrayList.add(m6979a(c0920b2, c0920b, c0802d, c0800b));
                    }
                    c0920b = m7858b;
                    c0920b2 = m7858b;
                    c0802d = m6978a;
                }
            }
        }
        if (c0802d.m8550f_() != 0) {
            arrayList.add(m6979a(c0920b2, c0920b, c0802d, c0800b));
        }
        int size = arrayList.size();
        if (size == 0) {
            return C0803e.f4779a;
        }
        C0803e c0803e = new C0803e(size);
        for (int i2 = 0; i2 < size; i2++) {
            c0803e.m7011a(i2, (C0803e.a) arrayList.get(i2));
        }
        c0803e.mo6683e_();
        return c0803e;
    }

    /* renamed from: a */
    private static C0802d m6978a(C0920b c0920b, C0800b c0800b) {
        C1025p m7847c = c0920b.m7847c();
        int m8568b = m7847c.m8568b();
        int m7848d = c0920b.m7848d();
        InterfaceC0977e mo7876b = c0920b.m7851g().mo7876b();
        int mo6856f_ = mo7876b.mo6856f_();
        if (mo6856f_ == 0) {
            return C0802d.f4776a;
        }
        if ((m7848d == -1 && m8568b != mo6856f_) || (m7848d != -1 && (m8568b != mo6856f_ + 1 || m7848d != m7847c.m8569b(mo6856f_)))) {
            throw new RuntimeException("shouldn't happen: weird successors list");
        }
        int i = 0;
        while (true) {
            if (i >= mo6856f_) {
                break;
            }
            if (!mo7876b.mo6853a(i).equals(C0975c.f6260o)) {
                i++;
            } else {
                mo6856f_ = i + 1;
                break;
            }
        }
        C0802d c0802d = new C0802d(mo6856f_);
        for (int i2 = 0; i2 < mo6856f_; i2++) {
            c0802d.m7004a(i2, new C0971y(mo7876b.mo6853a(i2)), c0800b.m6997a(m7847c.m8569b(i2)).m7040g());
        }
        c0802d.mo6683e_();
        return c0802d;
    }

    /* renamed from: a */
    private static C0803e.a m6979a(C0920b c0920b, C0920b c0920b2, C0802d c0802d, C0800b c0800b) {
        return new C0803e.a(c0800b.m6999b(c0920b).m7040g(), c0800b.m7000c(c0920b2).m7040g(), c0802d);
    }

    /* renamed from: a */
    private static boolean m6981a(C0920b c0920b, C0920b c0920b2, C0800b c0800b) {
        if (c0920b == null) {
            throw new NullPointerException("start == null");
        }
        if (c0920b2 == null) {
            throw new NullPointerException("end == null");
        }
        return c0800b.m7000c(c0920b2).m7040g() - c0800b.m6999b(c0920b).m7040g() <= 65535;
    }
}
