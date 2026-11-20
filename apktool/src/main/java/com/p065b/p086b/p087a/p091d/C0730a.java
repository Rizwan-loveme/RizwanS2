package com.p065b.p086b.p087a.p091d;

import com.p065b.p086b.p087a.p092e.C0748i;
import com.p065b.p086b.p087a.p092e.InterfaceC0749j;
import com.p065b.p086b.p103f.p104a.C0914a;
import com.p065b.p086b.p103f.p104a.C0916c;
import com.p065b.p086b.p103f.p104a.C0917d;
import com.p065b.p086b.p103f.p104a.C0918e;
import com.p065b.p086b.p103f.p104a.EnumC0915b;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0949c;
import com.p065b.p086b.p103f.p106c.C0950d;
import com.p065b.p086b.p103f.p106c.C0952f;
import com.p065b.p086b.p103f.p106c.C0953g;
import com.p065b.p086b.p103f.p106c.C0954h;
import com.p065b.p086b.p103f.p106c.C0955i;
import com.p065b.p086b.p103f.p106c.C0956j;
import com.p065b.p086b.p103f.p106c.C0958l;
import com.p065b.p086b.p103f.p106c.C0959m;
import com.p065b.p086b.p103f.p106c.C0965s;
import com.p065b.p086b.p103f.p106c.C0968v;
import com.p065b.p086b.p103f.p106c.C0969w;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p106c.C0971y;
import com.p065b.p086b.p103f.p106c.InterfaceC0948b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1013d;
import com.p065b.p086b.p110h.C1022m;
import java.p209io.IOException;

/* compiled from: AnnotationParser.java */
/* renamed from: com.b.b.a.d.a */
/* loaded from: classes.dex */
public final class C0730a {

    /* renamed from: a */
    private final C0735f f4619a;

    /* renamed from: b */
    private final InterfaceC0948b f4620b;

    /* renamed from: c */
    private final C1013d f4621c;

    /* renamed from: d */
    private final InterfaceC0749j f4622d;

    /* renamed from: e */
    private final C1013d.a f4623e;

    /* renamed from: f */
    private int f4624f;

    public C0730a(C0735f c0735f, int i, int i2, InterfaceC0749j interfaceC0749j) {
        if (c0735f == null) {
            throw new NullPointerException("cf == null");
        }
        this.f4619a = c0735f;
        this.f4620b = c0735f.m6844f();
        this.f4622d = interfaceC0749j;
        this.f4621c = c0735f.m6838a().m8504a(i, i + i2);
        this.f4623e = this.f4621c.m8507b();
        this.f4624f = 0;
    }

    /* renamed from: a */
    public AbstractC0945a m6806a() {
        try {
            AbstractC0945a m6801c = m6801c();
            if (this.f4623e.available() != 0) {
                throw new C0748i("extra data in attribute");
            }
            return m6801c;
        } catch (IOException e2) {
            throw new RuntimeException("shouldn't happen", e2);
        }
    }

    /* renamed from: a */
    public C0917d m6805a(EnumC0915b enumC0915b) {
        try {
            C0917d m6800c = m6800c(enumC0915b);
            if (this.f4623e.available() != 0) {
                throw new C0748i("extra data in attribute");
            }
            return m6800c;
        } catch (IOException e2) {
            throw new RuntimeException("shouldn't happen", e2);
        }
    }

    /* renamed from: b */
    public C0916c m6807b(EnumC0915b enumC0915b) {
        try {
            C0916c m6802d = m6802d(enumC0915b);
            if (this.f4623e.available() != 0) {
                throw new C0748i("extra data in attribute");
            }
            return m6802d;
        } catch (IOException e2) {
            throw new RuntimeException("shouldn't happen", e2);
        }
    }

    /* renamed from: c */
    private C0917d m6800c(EnumC0915b enumC0915b) {
        int readUnsignedByte = this.f4623e.readUnsignedByte();
        if (this.f4622d != null) {
            m6797a(1, "num_parameters: " + C1022m.m8559e(readUnsignedByte));
        }
        C0917d c0917d = new C0917d(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            if (this.f4622d != null) {
                m6797a(0, "parameter_annotations[" + i + "]:");
                m6799b(1);
            }
            c0917d.m7831a(i, m6802d(enumC0915b));
            if (this.f4622d != null) {
                this.f4622d.m6899a(-1);
            }
        }
        c0917d.mo6683e_();
        return c0917d;
    }

    /* renamed from: d */
    private C0916c m6802d(EnumC0915b enumC0915b) {
        int readUnsignedShort = this.f4623e.readUnsignedShort();
        if (this.f4622d != null) {
            m6797a(2, "num_annotations: " + C1022m.m8557c(readUnsignedShort));
        }
        C0916c c0916c = new C0916c();
        for (int i = 0; i < readUnsignedShort; i++) {
            if (this.f4622d != null) {
                m6797a(0, "annotations[" + i + "]:");
                m6799b(1);
            }
            c0916c.m7825a(m6804e(enumC0915b));
            if (this.f4622d != null) {
                this.f4622d.m6899a(-1);
            }
        }
        c0916c.mo6683e_();
        return c0916c;
    }

    /* renamed from: e */
    private C0914a m6804e(EnumC0915b enumC0915b) {
        m6796a(4);
        int readUnsignedShort = this.f4623e.readUnsignedShort();
        int readUnsignedShort2 = this.f4623e.readUnsignedShort();
        C0971y c0971y = new C0971y(C0975c.m8118a(((C0970x) this.f4620b.mo8038a(readUnsignedShort)).m8084j()));
        if (this.f4622d != null) {
            m6797a(2, "type: " + c0971y.mo6681d());
            m6797a(2, "num_elements: " + readUnsignedShort2);
        }
        C0914a c0914a = new C0914a(c0971y, enumC0915b);
        for (int i = 0; i < readUnsignedShort2; i++) {
            if (this.f4622d != null) {
                m6797a(0, "elements[" + i + "]:");
                m6799b(1);
            }
            c0914a.m7819b(m6798b());
            if (this.f4622d != null) {
                m6799b(-1);
            }
        }
        c0914a.mo6683e_();
        return c0914a;
    }

    /* renamed from: b */
    private C0918e m6798b() {
        m6796a(5);
        C0970x c0970x = (C0970x) this.f4620b.mo8038a(this.f4623e.readUnsignedShort());
        if (this.f4622d != null) {
            m6797a(2, "element_name: " + c0970x.mo6681d());
            m6797a(0, "value: ");
            m6799b(1);
        }
        AbstractC0945a m6801c = m6801c();
        if (this.f4622d != null) {
            m6799b(-1);
        }
        return new C0918e(c0970x, m6801c);
    }

    /* renamed from: c */
    private AbstractC0945a m6801c() {
        int readUnsignedByte = this.f4623e.readUnsignedByte();
        if (this.f4622d != null) {
            m6797a(1, "tag: " + new C0970x(Character.toString((char) readUnsignedByte)).m8083i());
        }
        switch (readUnsignedByte) {
            case 64:
                return new C0949c(m6804e(EnumC0915b.EMBEDDED));
            case 66:
                return C0953g.m8053a(((C0959m) m6803d()).m8061k_());
            case 67:
                C0959m c0959m = (C0959m) m6803d();
                c0959m.m8061k_();
                return C0954h.m8055a(c0959m.m8061k_());
            case 68:
                return (C0955i) m6803d();
            case 70:
                return (C0958l) m6803d();
            case 73:
                return (C0959m) m6803d();
            case 74:
                return (C0965s) m6803d();
            case 83:
                return C0969w.m8077a(((C0959m) m6803d()).m8061k_());
            case 90:
                return C0952f.m8050a(((C0959m) m6803d()).m8061k_());
            case 91:
                m6796a(2);
                int readUnsignedShort = this.f4623e.readUnsignedShort();
                C0950d.a aVar = new C0950d.a(readUnsignedShort);
                if (this.f4622d != null) {
                    m6797a(2, "num_values: " + readUnsignedShort);
                    m6799b(1);
                }
                for (int i = 0; i < readUnsignedShort; i++) {
                    if (this.f4622d != null) {
                        m6799b(-1);
                        m6797a(0, "element_value[" + i + "]:");
                        m6799b(1);
                    }
                    aVar.m8044a(i, m6801c());
                }
                if (this.f4622d != null) {
                    m6799b(-1);
                }
                aVar.mo6683e_();
                return new C0950d(aVar);
            case 99:
                C0975c m8120b = C0975c.m8120b(((C0970x) this.f4620b.mo8038a(this.f4623e.readUnsignedShort())).m8084j());
                if (this.f4622d != null) {
                    m6797a(2, "class_info: " + m8120b.mo6681d());
                }
                return new C0971y(m8120b);
            case 101:
                m6796a(4);
                int readUnsignedShort2 = this.f4623e.readUnsignedShort();
                int readUnsignedShort3 = this.f4623e.readUnsignedShort();
                C0970x c0970x = (C0970x) this.f4620b.mo8038a(readUnsignedShort2);
                C0970x c0970x2 = (C0970x) this.f4620b.mo8038a(readUnsignedShort3);
                if (this.f4622d != null) {
                    m6797a(2, "type_name: " + c0970x.mo6681d());
                    m6797a(2, "const_name: " + c0970x2.mo6681d());
                }
                return new C0956j(new C0968v(c0970x2, c0970x));
            case 115:
                return m6803d();
            default:
                throw new C0748i("unknown annotation tag: " + C1022m.m8559e(readUnsignedByte));
        }
    }

    /* renamed from: d */
    private AbstractC0945a m6803d() {
        AbstractC0945a mo8038a = this.f4620b.mo8038a(this.f4623e.readUnsignedShort());
        if (this.f4622d != null) {
            m6797a(2, "constant_value: " + (mo8038a instanceof C0970x ? ((C0970x) mo8038a).m8083i() : mo8038a.mo6681d()));
        }
        return mo8038a;
    }

    /* renamed from: a */
    private void m6796a(int i) {
        if (this.f4623e.available() < i) {
            throw new C0748i("truncated annotation attribute");
        }
    }

    /* renamed from: a */
    private void m6797a(int i, String str) {
        this.f4622d.m6900a(this.f4621c, this.f4624f, i, str);
        this.f4624f += i;
    }

    /* renamed from: b */
    private void m6799b(int i) {
        this.f4622d.m6899a(i);
    }
}
