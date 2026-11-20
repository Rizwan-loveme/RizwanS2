package com.p065b.p086b.p095c.p097b;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.AbstractC0951e;
import com.p065b.p086b.p110h.C1019j;
import com.p065b.p086b.p110h.C1021l;
import com.p065b.p086b.p110h.C1023n;
import com.p065b.p086b.p110h.InterfaceC1007a;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/* compiled from: DalvInsnList.java */
/* renamed from: com.b.b.c.b.j */
/* loaded from: classes.dex */
public final class C0808j extends C1021l {

    /* renamed from: a */
    private final int f4797a;

    /* renamed from: a */
    public static C0808j m7048a(ArrayList<AbstractC0807i> arrayList, int i) {
        int size = arrayList.size();
        C0808j c0808j = new C0808j(size, i);
        for (int i2 = 0; i2 < size; i2++) {
            c0808j.m7050a(i2, arrayList.get(i2));
        }
        c0808j.mo6683e_();
        return c0808j;
    }

    public C0808j(int i, int i2) {
        super(i);
        this.f4797a = i2;
    }

    /* renamed from: a */
    public AbstractC0807i m7049a(int i) {
        return (AbstractC0807i) m8548e(i);
    }

    /* renamed from: a */
    public void m7050a(int i, AbstractC0807i abstractC0807i) {
        m8546a(i, (Object) abstractC0807i);
    }

    /* renamed from: e */
    public int m7053e() {
        int f_ = m8550f_();
        if (f_ == 0) {
            return 0;
        }
        return m7049a(f_ - 1).m7047n();
    }

    /* renamed from: a */
    public void m7051a(InterfaceC1007a interfaceC1007a) {
        String m7034a;
        int g = interfaceC1007a.mo8528g();
        int f_ = m8550f_();
        if (interfaceC1007a.mo8460a()) {
            boolean mo8461b = interfaceC1007a.mo8461b();
            for (int i = 0; i < f_; i++) {
                AbstractC0807i abstractC0807i = (AbstractC0807i) m8548e(i);
                int mo6964a = abstractC0807i.mo6964a() * 2;
                if (mo6964a != 0 || mo8461b) {
                    m7034a = abstractC0807i.m7034a("  ", interfaceC1007a.mo8463d(), true);
                } else {
                    m7034a = null;
                }
                if (m7034a != null) {
                    interfaceC1007a.mo8458a(mo6964a, m7034a);
                } else if (mo6964a != 0) {
                    interfaceC1007a.mo8458a(mo6964a, "");
                }
            }
        }
        for (int i2 = 0; i2 < f_; i2++) {
            AbstractC0807i abstractC0807i2 = (AbstractC0807i) m8548e(i2);
            try {
                abstractC0807i2.mo6967a(interfaceC1007a);
            } catch (RuntimeException e2) {
                throw C1019j.m8537a(e2, "...while writing " + abstractC0807i2);
            }
        }
        int g2 = (interfaceC1007a.mo8528g() - g) / 2;
        if (g2 != m7053e()) {
            throw new RuntimeException("write length mismatch; expected " + m7053e() + " but actually wrote " + g2);
        }
    }

    /* renamed from: f */
    public int m7054f() {
        return this.f4797a;
    }

    /* renamed from: g */
    public int m7055g() {
        int m8046b;
        int f_ = m8550f_();
        int i = 0;
        int i2 = 0;
        while (i < f_) {
            AbstractC0807i abstractC0807i = (AbstractC0807i) m8548e(i);
            if (abstractC0807i instanceof C0805g) {
                AbstractC0945a m7018c = ((C0805g) abstractC0807i).m7018c();
                if (m7018c instanceof AbstractC0951e) {
                    m8046b = ((AbstractC0951e) m7018c).m8046b(abstractC0807i.m7041h().m7057b() == 113);
                    if (m8046b <= i2) {
                        m8046b = i2;
                    }
                } else {
                    m8046b = i2;
                }
            } else {
                m8046b = i2;
            }
            i++;
            i2 = m8046b;
        }
        return i2;
    }

    /* renamed from: a */
    public void m7052a(Writer writer, String str, boolean z) {
        String m7034a;
        C1023n c1023n = new C1023n(writer, 0, str);
        int f_ = m8550f_();
        for (int i = 0; i < f_; i++) {
            try {
                AbstractC0807i abstractC0807i = (AbstractC0807i) m8548e(i);
                if (abstractC0807i.mo6964a() != 0 || z) {
                    m7034a = abstractC0807i.m7034a("", 0, z);
                } else {
                    m7034a = null;
                }
                if (m7034a != null) {
                    c1023n.write(m7034a);
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        c1023n.flush();
    }
}
