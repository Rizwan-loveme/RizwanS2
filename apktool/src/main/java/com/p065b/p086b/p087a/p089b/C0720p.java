package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: Merger.java */
/* renamed from: com.b.b.a.b.p */
/* loaded from: classes.dex */
public final class C0720p {
    /* renamed from: a */
    public static C0721q m6686a(C0721q c0721q, C0721q c0721q2) {
        if (c0721q != c0721q2) {
            int m6694f = c0721q.m6694f();
            C0721q c0721q3 = null;
            if (c0721q2.m6694f() != m6694f) {
                throw new C0725u("mismatched maxLocals values");
            }
            for (int i = 0; i < m6694f; i++) {
                InterfaceC0976d m6692c = c0721q.m6692c(i);
                InterfaceC0976d m6687a = m6687a(m6692c, c0721q2.m6692c(i));
                if (m6687a != m6692c) {
                    if (c0721q3 == null) {
                        c0721q3 = c0721q.mo6667a();
                    }
                    if (m6687a == null) {
                        c0721q3.m6691b(i);
                    } else {
                        c0721q3.mo6671a(i, m6687a);
                    }
                }
            }
            if (c0721q3 != null) {
                c0721q3.mo6683e_();
                return c0721q3;
            }
            return c0721q;
        }
        return c0721q;
    }

    /* renamed from: a */
    public static C0713i m6685a(C0713i c0713i, C0713i c0713i2) {
        if (c0713i != c0713i2) {
            int m6625b = c0713i.m6625b();
            C0713i c0713i3 = null;
            if (c0713i2.m6625b() != m6625b) {
                throw new C0725u("mismatched stack depths");
            }
            for (int i = 0; i < m6625b; i++) {
                InterfaceC0976d m6620a = c0713i.m6620a(i);
                InterfaceC0976d m6620a2 = c0713i2.m6620a(i);
                InterfaceC0976d m6687a = m6687a(m6620a, m6620a2);
                if (m6687a != m6620a) {
                    if (c0713i3 == null) {
                        c0713i3 = c0713i.m6618a();
                    }
                    if (m6687a == null) {
                        throw new C0725u("incompatible: " + m6620a + ", " + m6620a2);
                    }
                    try {
                        c0713i3.m6621a(i, m6687a);
                    } catch (C0725u e2) {
                        e2.m8540a("...while merging stack[" + C1022m.m8557c(i) + "]");
                        throw e2;
                    }
                    e2.m8540a("...while merging stack[" + C1022m.m8557c(i) + "]");
                    throw e2;
                }
            }
            if (c0713i3 != null) {
                c0713i3.mo6683e_();
                return c0713i3;
            }
            return c0713i;
        }
        return c0713i;
    }

    /* renamed from: a */
    public static InterfaceC0976d m6687a(InterfaceC0976d interfaceC0976d, InterfaceC0976d interfaceC0976d2) {
        if (interfaceC0976d != null && !interfaceC0976d.equals(interfaceC0976d2)) {
            if (interfaceC0976d2 == null) {
                return null;
            }
            C0975c mo6695a = interfaceC0976d.mo6695a();
            C0975c mo6695a2 = interfaceC0976d2.mo6695a();
            if (mo6695a != mo6695a2) {
                if (mo6695a.m8132o() && mo6695a2.m8132o()) {
                    if (mo6695a == C0975c.f6255j) {
                        return mo6695a2;
                    }
                    if (mo6695a2 != C0975c.f6255j) {
                        if (mo6695a.m8133p() && mo6695a2.m8133p()) {
                            InterfaceC0976d m6687a = m6687a(mo6695a.m8138u(), mo6695a2.m8138u());
                            if (m6687a == null) {
                                return C0975c.f6260o;
                            }
                            return ((C0975c) m6687a).m8137t();
                        }
                        return C0975c.f6260o;
                    }
                    return mo6695a;
                }
                if (mo6695a.m8130m() && mo6695a2.m8130m()) {
                    return C0975c.f6251f;
                }
                return null;
            }
            return mo6695a;
        }
        return interfaceC0976d;
    }

    /* renamed from: b */
    public static boolean m6688b(InterfaceC0976d interfaceC0976d, InterfaceC0976d interfaceC0976d2) {
        C0975c mo6695a = interfaceC0976d.mo6695a();
        C0975c mo6695a2 = interfaceC0976d2.mo6695a();
        if (mo6695a.equals(mo6695a2)) {
            return true;
        }
        int mo6697c = mo6695a.mo6697c();
        int mo6697c2 = mo6695a2.mo6697c();
        if (mo6697c == 10) {
            mo6695a = C0975c.f6260o;
            mo6697c = 9;
        }
        if (mo6697c2 == 10) {
            mo6695a2 = C0975c.f6260o;
            mo6697c2 = 9;
        }
        if (mo6697c != 9 || mo6697c2 != 9) {
            return mo6695a.m8130m() && mo6695a2.m8130m();
        }
        if (mo6695a == C0975c.f6255j) {
            return false;
        }
        if (mo6695a2 == C0975c.f6255j || mo6695a == C0975c.f6260o) {
            return true;
        }
        if (mo6695a.m8133p()) {
            if (!mo6695a2.m8133p()) {
                return false;
            }
            C0975c c0975c = mo6695a2;
            C0975c c0975c2 = mo6695a;
            do {
                c0975c2 = c0975c2.m8138u();
                c0975c = c0975c.m8138u();
                if (!c0975c2.m8133p()) {
                    break;
                }
            } while (c0975c.m8133p());
            return m6688b(c0975c2, c0975c);
        }
        if (mo6695a2.m8133p()) {
            return mo6695a == C0975c.f6261p || mo6695a == C0975c.f6259n;
        }
        return true;
    }
}
