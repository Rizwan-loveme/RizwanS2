package com.p065b.p086b.p095c.p096a;

import com.p065b.p086b.p087a.p088a.C0682a;
import com.p065b.p086b.p087a.p088a.C0686e;
import com.p065b.p086b.p087a.p088a.C0687f;
import com.p065b.p086b.p087a.p088a.C0688g;
import com.p065b.p086b.p087a.p088a.C0692k;
import com.p065b.p086b.p087a.p088a.C0693l;
import com.p065b.p086b.p087a.p088a.C0694m;
import com.p065b.p086b.p087a.p088a.C0695n;
import com.p065b.p086b.p087a.p088a.C0696o;
import com.p065b.p086b.p087a.p088a.C0703v;
import com.p065b.p086b.p087a.p091d.C0735f;
import com.p065b.p086b.p087a.p092e.InterfaceC0741b;
import com.p065b.p086b.p087a.p092e.InterfaceC0746g;
import com.p065b.p086b.p087a.p092e.InterfaceC0747h;
import com.p065b.p086b.p095c.p099c.C0851d;
import com.p065b.p086b.p103f.p104a.C0914a;
import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p103f.p104a.C0918e;
import com.p065b.p086b.p103f.p104a.EnumC0915b;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.C0967u;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.C1010ac;
import java.util.ArrayList;

/* compiled from: AttributeTranslator.java */
/* renamed from: com.b.b.c.a.a */
/* loaded from: classes.dex */
class C0760a {
    /* renamed from: a */
    public static InterfaceC0977e m6942a(InterfaceC0746g interfaceC0746g) {
        C0687f c0687f = (C0687f) interfaceC0746g.mo6607e().mo6891a("Exceptions");
        return c0687f == null ? C0974b.f6209a : c0687f.m6505b();
    }

    /* renamed from: a */
    public static C0916c m6940a(InterfaceC0741b interfaceC0741b) {
        C0916c m6943b = m6943b(interfaceC0741b);
        C0914a m6945c = m6945c(interfaceC0741b);
        if (m6945c != null) {
            return C0916c.m7822a(m6943b, m6945c);
        }
        return m6943b;
    }

    /* renamed from: a */
    public static C0916c m6939a(C0735f c0735f, C0761b c0761b) {
        C0914a m6938a;
        C0971y m6842d = c0735f.m6842d();
        InterfaceC0741b m6848j = c0735f.m6848j();
        C0916c m6940a = m6940a(m6848j);
        C0914a m6947d = m6947d(m6848j);
        try {
            C0916c m6941a = m6941a(m6842d, m6848j, m6947d == null);
            if (m6941a != null) {
                m6940a = C0916c.m7823a(m6940a, m6941a);
            }
        } catch (C1010ac e2) {
            c0761b.f4720h.println("warning: " + e2.getMessage());
        }
        if (m6947d != null) {
            m6940a = C0916c.m7822a(m6940a, m6947d);
        }
        if (C0919a.m7845j(c0735f.mo6841c()) && (m6938a = m6938a(c0735f)) != null) {
            return C0916c.m7822a(m6940a, m6938a);
        }
        return m6940a;
    }

    /* renamed from: b */
    public static C0916c m6944b(InterfaceC0746g interfaceC0746g) {
        C0916c m6940a = m6940a(interfaceC0746g.mo6607e());
        InterfaceC0977e m6942a = m6942a(interfaceC0746g);
        if (m6942a.mo6856f_() != 0) {
            return C0916c.m7822a(m6940a, C0851d.m7305b(m6942a));
        }
        return m6940a;
    }

    /* renamed from: b */
    private static C0916c m6943b(InterfaceC0741b interfaceC0741b) {
        C0694m c0694m = (C0694m) interfaceC0741b.mo6891a("RuntimeVisibleAnnotations");
        C0692k c0692k = (C0692k) interfaceC0741b.mo6891a("RuntimeInvisibleAnnotations");
        if (c0694m == null) {
            if (c0692k == null) {
                return C0916c.f5851a;
            }
            return c0692k.m6510b();
        }
        if (c0692k == null) {
            return c0694m.m6510b();
        }
        return C0916c.m7823a(c0694m.m6510b(), c0692k.m6510b());
    }

    /* renamed from: c */
    private static C0914a m6945c(InterfaceC0741b interfaceC0741b) {
        C0696o c0696o = (C0696o) interfaceC0741b.mo6891a("Signature");
        if (c0696o == null) {
            return null;
        }
        return C0851d.m7301a(c0696o.m6508b());
    }

    /* renamed from: d */
    private static C0914a m6947d(InterfaceC0741b interfaceC0741b) {
        C0686e c0686e = (C0686e) interfaceC0741b.mo6891a("EnclosingMethod");
        if (c0686e == null) {
            return null;
        }
        C0971y m6503b = c0686e.m6503b();
        C0968v m6504c = c0686e.m6504c();
        if (m6504c == null) {
            return C0851d.m7303a(m6503b);
        }
        return C0851d.m7300a(new C0967u(m6503b, m6504c));
    }

    /* renamed from: a */
    private static C0916c m6941a(C0971y c0971y, InterfaceC0741b interfaceC0741b, boolean z) {
        C0688g c0688g = (C0688g) interfaceC0741b.mo6891a("InnerClasses");
        if (c0688g == null) {
            return null;
        }
        C0703v m6506b = c0688g.m6506b();
        int f_ = m6506b.m8550f_();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        C0703v.a aVar = null;
        while (i < f_) {
            C0703v.a m6514a = m6506b.m6514a(i);
            C0971y m6516a = m6514a.m6516a();
            if (!m6516a.equals(c0971y)) {
                if (c0971y.equals(m6514a.m6517b())) {
                    arrayList.add(m6516a.m8090i());
                }
                m6514a = aVar;
            }
            i++;
            aVar = m6514a;
        }
        int size = arrayList.size();
        if (aVar == null && size == 0) {
            return null;
        }
        C0916c c0916c = new C0916c();
        if (aVar != null) {
            c0916c.m7825a(C0851d.m7302a(aVar.m6518c(), aVar.m6519d()));
            if (z) {
                if (aVar.m6517b() == null) {
                    throw new C1010ac("Ignoring InnerClasses attribute for an anonymous inner class\n(" + c0971y.mo6681d() + ") that doesn't come with an\nassociated EnclosingMethod attribute. This class was probably produced by a\ncompiler that did not target the modern .class file format. The recommended\nsolution is to recompile the class from source, using an up-to-date compiler\nand without specifying any \"-target\" type options. The consequence of ignoring\nthis warning is that reflective operations on this class will incorrectly\nindicate that it is *not* an inner class.");
                }
                c0916c.m7825a(C0851d.m7303a(aVar.m6517b()));
            }
        }
        if (size != 0) {
            C0974b c0974b = new C0974b(size);
            for (int i2 = 0; i2 < size; i2++) {
                c0974b.m8114a(i2, (C0975c) arrayList.get(i2));
            }
            c0974b.mo6683e_();
            c0916c.m7825a(C0851d.m7304a(c0974b));
        }
        c0916c.mo6683e_();
        return c0916c;
    }

    /* renamed from: c */
    public static C0917d m6946c(InterfaceC0746g interfaceC0746g) {
        InterfaceC0741b e2 = interfaceC0746g.mo6607e();
        C0695n c0695n = (C0695n) e2.mo6891a("RuntimeVisibleParameterAnnotations");
        C0693l c0693l = (C0693l) e2.mo6891a("RuntimeInvisibleParameterAnnotations");
        if (c0695n == null) {
            if (c0693l == null) {
                return C0917d.f5853a;
            }
            return c0693l.m6513b();
        }
        if (c0693l == null) {
            return c0695n.m6513b();
        }
        return C0917d.m7829a(c0695n.m6513b(), c0693l.m6513b());
    }

    /* renamed from: a */
    private static C0914a m6938a(C0735f c0735f) {
        boolean z;
        C0971y m6842d = c0735f.m6842d();
        InterfaceC0747h m6847i = c0735f.m6847i();
        int m6898f_ = m6847i.m6898f_();
        C0914a c0914a = new C0914a(m6842d, EnumC0915b.EMBEDDED);
        int i = 0;
        boolean z2 = false;
        while (i < m6898f_) {
            InterfaceC0746g mo6897a = m6847i.mo6897a(i);
            C0682a c0682a = (C0682a) mo6897a.mo6607e().mo6891a("AnnotationDefault");
            if (c0682a != null) {
                c0914a.m7819b(new C0918e(mo6897a.mo6603a().m8072a(), c0682a.m6496b()));
                z = true;
            } else {
                z = z2;
            }
            i++;
            z2 = z;
        }
        if (!z2) {
            return null;
        }
        c0914a.mo6683e_();
        return C0851d.m7299a(c0914a);
    }
}
