package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p088a.C0682a;
import com.p065b.p086b.p087a.p088a.C0683b;
import com.p065b.p086b.p087a.p088a.C0684c;
import com.p065b.p086b.p087a.p088a.C0685d;
import com.p065b.p086b.p087a.p088a.C0686e;
import com.p065b.p086b.p087a.p088a.C0687f;
import com.p065b.p086b.p087a.p088a.C0688g;
import com.p065b.p086b.p087a.p088a.C0689h;
import com.p065b.p086b.p087a.p088a.C0690i;
import com.p065b.p086b.p087a.p088a.C0691j;
import com.p065b.p086b.p087a.p088a.C0692k;
import com.p065b.p086b.p087a.p088a.C0693l;
import com.p065b.p086b.p087a.p088a.C0694m;
import com.p065b.p086b.p087a.p088a.C0695n;
import com.p065b.p086b.p087a.p088a.C0696o;
import com.p065b.p086b.p087a.p088a.C0697p;
import com.p065b.p086b.p087a.p088a.C0698q;
import com.p065b.p086b.p087a.p088a.C0703v;
import com.p065b.p086b.p087a.p089b.C0709e;
import com.p065b.p086b.p087a.p089b.C0711g;
import com.p065b.p086b.p087a.p089b.C0715k;
import com.p065b.p086b.p087a.p089b.C0716l;
import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p087a.p092e.C0750k;
import com.p065b.p086b.p087a.p092e.InterfaceC0740a;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p103f.p104a.EnumC0915b;
import com.p065b.p086b.p103f.p105b.C0919a;
import com.p065b.p086b.p103f.p106c.AbstractC0946aa;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p106c.InterfaceC0948b;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;
import java.p209io.IOException;

/* compiled from: StdAttributeFactory.java */
/* renamed from: com.b.b.a.d.j */
/* loaded from: classes.dex */
public class C0739j extends C0731b {

    /* renamed from: a */
    public static final C0739j f4663a = new C0739j();

    @Override // com.p065b.p086b.p087a.p091d.C0731b
    /* renamed from: a */
    protected InterfaceC0740a mo6809a(C0735f c0735f, int i, String str, int i2, int i3, InterfaceC0749j interfaceC0749j) {
        switch (i) {
            case 0:
                if (str == "Deprecated") {
                    return m6876e(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "EnclosingMethod") {
                    return m6877f(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "InnerClasses") {
                    return m6879h(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return m6883l(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return m6884m(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Synthetic") {
                    return m6889r(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Signature") {
                    return m6887p(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "SourceFile") {
                    return m6888q(c0735f, i2, i3, interfaceC0749j);
                }
                break;
            case 1:
                if (str == "ConstantValue") {
                    return m6875d(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Deprecated") {
                    return m6876e(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return m6883l(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return m6884m(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Signature") {
                    return m6887p(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Synthetic") {
                    return m6889r(c0735f, i2, i3, interfaceC0749j);
                }
                break;
            case 2:
                if (str == "AnnotationDefault") {
                    return m6873b(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Code") {
                    return m6874c(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Deprecated") {
                    return m6876e(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Exceptions") {
                    return m6878g(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeInvisibleAnnotations") {
                    return m6883l(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeVisibleAnnotations") {
                    return m6884m(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeInvisibleParameterAnnotations") {
                    return m6885n(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "RuntimeVisibleParameterAnnotations") {
                    return m6886o(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Signature") {
                    return m6887p(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "Synthetic") {
                    return m6889r(c0735f, i2, i3, interfaceC0749j);
                }
                break;
            case 3:
                if (str == "LineNumberTable") {
                    return m6880i(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "LocalVariableTable") {
                    return m6881j(c0735f, i2, i3, interfaceC0749j);
                }
                if (str == "LocalVariableTypeTable") {
                    return m6882k(c0735f, i2, i3, interfaceC0749j);
                }
                break;
        }
        return super.mo6809a(c0735f, i, str, i2, i3, interfaceC0749j);
    }

    /* renamed from: b */
    private InterfaceC0740a m6873b(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            m6870a();
        }
        return new C0682a(new C0730a(c0735f, i, i2, interfaceC0749j).m6806a(), i2);
    }

    /* renamed from: c */
    private InterfaceC0740a m6874c(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 12) {
            return m6870a();
        }
        C1013d m6838a = c0735f.m6838a();
        InterfaceC0948b m6844f = c0735f.m6844f();
        int m8512f = m6838a.m8512f(i);
        int m8512f2 = m6838a.m8512f(i + 2);
        int m8508c = m6838a.m8508c(i + 4);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "max_stack: " + C1022m.m8557c(m8512f));
            interfaceC0749j.m6900a(m6838a, i + 2, 2, "max_locals: " + C1022m.m8557c(m8512f2));
            interfaceC0749j.m6900a(m6838a, i + 4, 4, "code_length: " + C1022m.m8552a(m8508c));
        }
        int i3 = i + 8;
        int i4 = i2 - 8;
        if (i4 < m8508c + 4) {
            return m6872b();
        }
        int i5 = i3 + m8508c;
        int i6 = i4 - m8508c;
        C0711g c0711g = new C0711g(m6838a.m8504a(i3, m8508c + i3), m6844f);
        if (interfaceC0749j != null) {
            c0711g.m6597a(new C0734e(c0711g.m6596a(), interfaceC0749j));
        }
        int m8512f3 = m6838a.m8512f(i5);
        C0709e c0709e = m8512f3 == 0 ? C0709e.f4516a : new C0709e(m8512f3);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i5, 2, "exception_table_length: " + C1022m.m8557c(m8512f3));
        }
        int i7 = i5 + 2;
        int i8 = i6 - 2;
        if (i8 < (m8512f3 * 8) + 2) {
            return m6872b();
        }
        int i9 = 0;
        int i10 = i8;
        int i11 = i7;
        while (i9 < m8512f3) {
            if (interfaceC0749j != null) {
                interfaceC0749j.m6899a(1);
            }
            int m8512f4 = m6838a.m8512f(i11);
            int m8512f5 = m6838a.m8512f(i11 + 2);
            int m8512f6 = m6838a.m8512f(i11 + 4);
            C0971y c0971y = (C0971y) m6844f.mo8039b(m6838a.m8512f(i11 + 6));
            c0709e.m6579a(i9, m8512f4, m8512f5, m8512f6, c0971y);
            if (interfaceC0749j != null) {
                interfaceC0749j.m6900a(m6838a, i11, 8, C1022m.m8557c(m8512f4) + ".." + C1022m.m8557c(m8512f5) + " -> " + C1022m.m8557c(m8512f6) + " " + (c0971y == null ? "<any>" : c0971y.mo6681d()));
            }
            int i12 = i11 + 8;
            int i13 = i10 - 8;
            if (interfaceC0749j != null) {
                interfaceC0749j.m6899a(-1);
            }
            i9++;
            i10 = i13;
            i11 = i12;
        }
        c0709e.mo6683e_();
        C0732c c0732c = new C0732c(c0735f, 3, i11, this);
        c0732c.m6813a(interfaceC0749j);
        C0750k m6814b = c0732c.m6814b();
        m6814b.mo6683e_();
        int m6812a = c0732c.m6812a() - i11;
        if (m6812a != i10) {
            return m6871a((i11 - i) + m6812a);
        }
        return new C0683b(m8512f, m8512f2, c0711g, c0709e, m6814b);
    }

    /* renamed from: d */
    private InterfaceC0740a m6875d(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 != 2) {
            return m6871a(2);
        }
        C1013d m6838a = c0735f.m6838a();
        AbstractC0946aa abstractC0946aa = (AbstractC0946aa) c0735f.m6844f().mo8038a(m6838a.m8512f(i));
        C0684c c0684c = new C0684c(abstractC0946aa);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "value: " + abstractC0946aa);
        }
        return c0684c;
    }

    /* renamed from: e */
    private InterfaceC0740a m6876e(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        return i2 != 0 ? m6871a(0) : new C0685d();
    }

    /* renamed from: f */
    private InterfaceC0740a m6877f(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 != 4) {
            m6871a(4);
        }
        C1013d m6838a = c0735f.m6838a();
        InterfaceC0948b m6844f = c0735f.m6844f();
        C0971y c0971y = (C0971y) m6844f.mo8038a(m6838a.m8512f(i));
        C0968v c0968v = (C0968v) m6844f.mo8039b(m6838a.m8512f(i + 2));
        C0686e c0686e = new C0686e(c0971y, c0968v);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "class: " + c0971y);
            interfaceC0749j.m6900a(m6838a, i + 2, 2, "method: " + C0735f.m6831a(c0968v));
        }
        return c0686e;
    }

    /* renamed from: g */
    private InterfaceC0740a m6878g(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            return m6870a();
        }
        C1013d m6838a = c0735f.m6838a();
        int m8512f = m6838a.m8512f(i);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "number_of_exceptions: " + C1022m.m8557c(m8512f));
        }
        int i3 = i + 2;
        if (i2 - 2 != m8512f * 2) {
            m6871a((m8512f * 2) + 2);
        }
        return new C0687f(c0735f.m6837a(i3, m8512f));
    }

    /* renamed from: h */
    private InterfaceC0740a m6879h(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            return m6870a();
        }
        C1013d m6838a = c0735f.m6838a();
        InterfaceC0948b m6844f = c0735f.m6844f();
        int m8512f = m6838a.m8512f(i);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "number_of_classes: " + C1022m.m8557c(m8512f));
        }
        int i3 = i + 2;
        if (i2 - 2 != m8512f * 8) {
            m6871a((m8512f * 8) + 2);
        }
        C0703v c0703v = new C0703v(m8512f);
        int i4 = 0;
        int i5 = i3;
        while (i4 < m8512f) {
            int m8512f2 = m6838a.m8512f(i5);
            int m8512f3 = m6838a.m8512f(i5 + 2);
            int m8512f4 = m6838a.m8512f(i5 + 4);
            int m8512f5 = m6838a.m8512f(i5 + 6);
            C0971y c0971y = (C0971y) m6844f.mo8038a(m8512f2);
            C0971y c0971y2 = (C0971y) m6844f.mo8039b(m8512f3);
            C0970x c0970x = (C0970x) m6844f.mo8039b(m8512f4);
            c0703v.m6515a(i4, c0971y, c0971y2, c0970x, m8512f5);
            if (interfaceC0749j != null) {
                interfaceC0749j.m6900a(m6838a, i5, 2, "inner_class: " + C0735f.m6831a(c0971y));
                interfaceC0749j.m6900a(m6838a, i5 + 2, 2, "  outer_class: " + C0735f.m6831a(c0971y2));
                interfaceC0749j.m6900a(m6838a, i5 + 4, 2, "  name: " + C0735f.m6831a(c0970x));
                interfaceC0749j.m6900a(m6838a, i5 + 6, 2, "  access_flags: " + C0919a.m7837b(m8512f5));
            }
            i4++;
            i5 += 8;
        }
        c0703v.mo6683e_();
        return new C0688g(c0703v);
    }

    /* renamed from: i */
    private InterfaceC0740a m6880i(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            return m6870a();
        }
        C1013d m6838a = c0735f.m6838a();
        int m8512f = m6838a.m8512f(i);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "line_number_table_length: " + C1022m.m8557c(m8512f));
        }
        int i3 = i + 2;
        if (i2 - 2 != m8512f * 4) {
            m6871a((m8512f * 4) + 2);
        }
        C0715k c0715k = new C0715k(m8512f);
        for (int i4 = 0; i4 < m8512f; i4++) {
            int m8512f2 = m6838a.m8512f(i3);
            int m8512f3 = m6838a.m8512f(i3 + 2);
            c0715k.m6648a(i4, m8512f2, m8512f3);
            if (interfaceC0749j != null) {
                interfaceC0749j.m6900a(m6838a, i3, 4, C1022m.m8557c(m8512f2) + " " + m8512f3);
            }
            i3 += 4;
        }
        c0715k.mo6683e_();
        return new C0689h(c0715k);
    }

    /* renamed from: j */
    private InterfaceC0740a m6881j(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            return m6870a();
        }
        C1013d m6838a = c0735f.m6838a();
        int m8512f = m6838a.m8512f(i);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "local_variable_table_length: " + C1022m.m8557c(m8512f));
        }
        return new C0690i(m6869a(m6838a.m8504a(i + 2, i + i2), c0735f.m6844f(), interfaceC0749j, m8512f, false));
    }

    /* renamed from: k */
    private InterfaceC0740a m6882k(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            return m6870a();
        }
        C1013d m6838a = c0735f.m6838a();
        int m8512f = m6838a.m8512f(i);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "local_variable_type_table_length: " + C1022m.m8557c(m8512f));
        }
        return new C0691j(m6869a(m6838a.m8504a(i + 2, i + i2), c0735f.m6844f(), interfaceC0749j, m8512f, true));
    }

    /* renamed from: a */
    private C0716l m6869a(C1013d c1013d, InterfaceC0948b interfaceC0948b, InterfaceC0749j interfaceC0749j, int i, boolean z) {
        if (c1013d.m8502a() != i * 10) {
            m6871a((i * 10) + 2);
        }
        C1013d.a m8507b = c1013d.m8507b();
        C0716l c0716l = new C0716l(i);
        for (int i2 = 0; i2 < i; i2++) {
            try {
                int readUnsignedShort = m8507b.readUnsignedShort();
                int readUnsignedShort2 = m8507b.readUnsignedShort();
                int readUnsignedShort3 = m8507b.readUnsignedShort();
                int readUnsignedShort4 = m8507b.readUnsignedShort();
                int readUnsignedShort5 = m8507b.readUnsignedShort();
                C0970x c0970x = (C0970x) interfaceC0948b.mo8038a(readUnsignedShort3);
                C0970x c0970x2 = (C0970x) interfaceC0948b.mo8038a(readUnsignedShort4);
                C0970x c0970x3 = null;
                C0970x c0970x4 = null;
                if (z) {
                    c0970x4 = c0970x2;
                } else {
                    c0970x3 = c0970x2;
                }
                c0716l.m6658a(i2, readUnsignedShort, readUnsignedShort2, c0970x, c0970x3, c0970x4, readUnsignedShort5);
                if (interfaceC0749j != null) {
                    interfaceC0749j.m6900a(c1013d, i2 * 10, 10, C1022m.m8557c(readUnsignedShort) + ".." + C1022m.m8557c(readUnsignedShort + readUnsignedShort2) + " " + C1022m.m8557c(readUnsignedShort5) + " " + c0970x.mo6681d() + " " + c0970x2.mo6681d());
                }
            } catch (IOException e2) {
                throw new RuntimeException("shouldn't happen", e2);
            }
        }
        c0716l.mo6683e_();
        return c0716l;
    }

    /* renamed from: l */
    private InterfaceC0740a m6883l(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            m6870a();
        }
        return new C0692k(new C0730a(c0735f, i, i2, interfaceC0749j).m6807b(EnumC0915b.BUILD), i2);
    }

    /* renamed from: m */
    private InterfaceC0740a m6884m(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            m6870a();
        }
        return new C0694m(new C0730a(c0735f, i, i2, interfaceC0749j).m6807b(EnumC0915b.RUNTIME), i2);
    }

    /* renamed from: n */
    private InterfaceC0740a m6885n(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            m6870a();
        }
        return new C0693l(new C0730a(c0735f, i, i2, interfaceC0749j).m6805a(EnumC0915b.BUILD), i2);
    }

    /* renamed from: o */
    private InterfaceC0740a m6886o(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 < 2) {
            m6870a();
        }
        return new C0695n(new C0730a(c0735f, i, i2, interfaceC0749j).m6805a(EnumC0915b.RUNTIME), i2);
    }

    /* renamed from: p */
    private InterfaceC0740a m6887p(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 != 2) {
            m6871a(2);
        }
        C1013d m6838a = c0735f.m6838a();
        C0970x c0970x = (C0970x) c0735f.m6844f().mo8038a(m6838a.m8512f(i));
        C0696o c0696o = new C0696o(c0970x);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "signature: " + c0970x);
        }
        return c0696o;
    }

    /* renamed from: q */
    private InterfaceC0740a m6888q(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (i2 != 2) {
            m6871a(2);
        }
        C1013d m6838a = c0735f.m6838a();
        C0970x c0970x = (C0970x) c0735f.m6844f().mo8038a(m6838a.m8512f(i));
        C0697p c0697p = new C0697p(c0970x);
        if (interfaceC0749j != null) {
            interfaceC0749j.m6900a(m6838a, i, 2, "source: " + c0970x);
        }
        return c0697p;
    }

    /* renamed from: r */
    private InterfaceC0740a m6889r(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        return i2 != 0 ? m6871a(0) : new C0698q();
    }

    /* renamed from: a */
    private static InterfaceC0740a m6870a() {
        throw new C0748i("severely truncated attribute");
    }

    /* renamed from: b */
    private static InterfaceC0740a m6872b() {
        throw new C0748i("truncated attribute");
    }

    /* renamed from: a */
    private static InterfaceC0740a m6871a(int i) {
        throw new C0748i("bad attribute length; expected length " + C1022m.m8552a(i));
    }
}
