package org.p226d.p227a.p228a.p231c;

import org.p226d.p227a.p228a.AbstractC1944l;
import org.p226d.p227a.p228a.C1943k;
import org.p226d.p227a.p228a.C1947o;
import org.p226d.p227a.p232b.C1957g;
import org.p226d.p233b.C2380h;
import org.p226d.p233b.C2393i;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.p252b.InterfaceC2176a;
import org.p226d.p233b.p250e.p252b.InterfaceC2214b;
import org.p226d.p233b.p250e.p252b.InterfaceC2215c;
import org.p226d.p233b.p250e.p252b.InterfaceC2217e;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2221i;
import org.p226d.p233b.p250e.p252b.InterfaceC2223k;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p252b.InterfaceC2226n;
import org.p226d.p233b.p250e.p252b.InterfaceC2229q;
import org.p226d.p233b.p250e.p252b.InterfaceC2230r;
import org.p226d.p233b.p250e.p252b.InterfaceC2233u;
import org.p226d.p233b.p250e.p252b.InterfaceC2234v;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2188ak;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2194g;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2211x;
import org.p226d.p233b.p250e.p254c.InterfaceC2236a;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p269d.C2453g;
import org.p226d.p269d.C2457k;
import org.p226d.p269d.C2459m;

/* compiled from: InstructionMethodItem.java */
/* renamed from: org.d.a.a.c.b */
/* loaded from: classes.dex */
public class C1930b<T extends InterfaceC2218f> extends AbstractC1944l {

    /* renamed from: c */
    static final /* synthetic */ boolean f11282c;

    /* renamed from: a */
    protected final C1943k f11283a;

    /* renamed from: b */
    protected final T f11284b;

    /* compiled from: InstructionMethodItem.java */
    /* renamed from: org.d.a.a.c.b$a */
    private interface a {
        /* renamed from: a */
        void mo14117a(C2457k c2457k);
    }

    static {
        f11282c = !C1930b.class.desiredAssertionStatus();
    }

    public C1930b(C1943k c1943k, int i, T t) {
        super(i);
        this.f11283a = c1943k;
        this.f11284b = t;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return 100.0d;
    }

    /* renamed from: a */
    private boolean m14098a(EnumC2272f enumC2272f) {
        if (this.f11283a.f11328a.f11317a.f11362h) {
            return true;
        }
        if (this.f11283a.f11328a.f11317a.f11355a < 14) {
            return enumC2272f.m14883g() || enumC2272f == EnumC2272f.THROW_VERIFICATION_ERROR;
        }
        return false;
    }

    /* renamed from: a */
    private String m14097a(C2153g.a aVar, int i, C2457k c2457k) {
        c2457k.write("#");
        c2457k.write(aVar.getMessage());
        c2457k.write("\n");
        return String.format("%s@%d", C2380h.m15068a(i), Integer.valueOf(aVar.m14787a()));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0105  */
    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo14089a(final C2457k c2457k) {
        String str;
        boolean z;
        a aVar;
        a aVar2;
        boolean z2;
        a aVar3;
        EnumC2272f mo14416a = this.f11284b.mo14416a();
        if (this.f11284b instanceof InterfaceC2194g) {
            int e2 = ((InterfaceC2194g) this.f11284b).mo14501e();
            String m15152a = C2393i.m15152a(e2);
            if (m15152a == null) {
                c2457k.write("#was invalid verification error type: ");
                c2457k.m15536c(e2);
                c2457k.write("\n");
                str = "generic-error";
            } else {
                str = m15152a;
            }
        } else {
            str = null;
        }
        if (this.f11284b instanceof InterfaceC2225m) {
            InterfaceC2225m interfaceC2225m = (InterfaceC2225m) this.f11284b;
            final String mo14209a = this.f11283a.f11328a.f11317a.f11364j ? this.f11283a.f11329b.mo14209a() : null;
            try {
                final InterfaceC2241f mo14489f = interfaceC2225m.mo14489f();
                if (mo14489f instanceof InterfaceC2236a) {
                    aVar3 = new a() { // from class: org.d.a.a.c.b.1
                        @Override // org.p226d.p227a.p228a.p231c.C1930b.a
                        /* renamed from: a */
                        public void mo14117a(C2457k c2457k2) {
                            C1947o.m14171a(c2457k2, (InterfaceC2236a) mo14489f);
                        }
                    };
                } else {
                    aVar3 = new a() { // from class: org.d.a.a.c.b.2
                        @Override // org.p226d.p227a.p228a.p231c.C1930b.a
                        /* renamed from: a */
                        public void mo14117a(C2457k c2457k2) {
                            c2457k2.write(C2389i.m15123a(mo14489f, mo14209a));
                        }
                    };
                }
                z = false;
                aVar2 = aVar3;
            } catch (C2153g.a e3) {
                final String m14097a = m14097a(e3, interfaceC2225m.mo14490g(), c2457k);
                a aVar4 = new a() { // from class: org.d.a.a.c.b.3
                    @Override // org.p226d.p227a.p228a.p231c.C1930b.a
                    /* renamed from: a */
                    public void mo14117a(C2457k c2457k2) {
                        c2457k.write(m14097a);
                    }
                };
                z = true;
                aVar2 = aVar4;
            } catch (C2380h.a e4) {
                c2457k.write("#invalid reference type: ");
                c2457k.m15536c(e4.m15072a());
                z = true;
                aVar2 = new a() { // from class: org.d.a.a.c.b.4
                    @Override // org.p226d.p227a.p228a.p231c.C1930b.a
                    /* renamed from: a */
                    public void mo14117a(C2457k c2457k2) {
                        c2457k.write("invalid_reference");
                    }
                };
            }
            if (this.f11284b instanceof InterfaceC2176a) {
                InterfaceC2176a interfaceC2176a = (InterfaceC2176a) this.f11284b;
                try {
                    final InterfaceC2241f mo14492m = interfaceC2176a.mo14492m();
                    aVar = new a() { // from class: org.d.a.a.c.b.5
                        @Override // org.p226d.p227a.p228a.p231c.C1930b.a
                        /* renamed from: a */
                        public void mo14117a(C2457k c2457k2) {
                            c2457k2.write(C2389i.m15123a(mo14492m, mo14209a));
                        }
                    };
                } catch (C2153g.a e5) {
                    final String m14097a2 = m14097a(e5, interfaceC2176a.mo14493n(), c2457k);
                    z = true;
                    aVar = new a() { // from class: org.d.a.a.c.b.6
                        @Override // org.p226d.p227a.p228a.p231c.C1930b.a
                        /* renamed from: a */
                        public void mo14117a(C2457k c2457k2) {
                            c2457k2.write(m14097a2);
                        }
                    };
                } catch (C2380h.a e6) {
                    c2457k.write("#invalid reference type: ");
                    c2457k.m15536c(e6.m15072a());
                    z = true;
                    aVar = new a() { // from class: org.d.a.a.c.b.7
                        @Override // org.p226d.p227a.p228a.p231c.C1930b.a
                        /* renamed from: a */
                        public void mo14117a(C2457k c2457k2) {
                            c2457k2.write("invalid reference");
                        }
                    };
                }
            } else {
                aVar = null;
            }
        } else {
            z = false;
            aVar = null;
            aVar2 = null;
        }
        if (this.f11284b instanceof InterfaceC2211x) {
            switch (this.f11284b.mo14416a()) {
                case PACKED_SWITCH:
                    if (this.f11283a.m14153a(((InterfaceC2211x) this.f11284b).mo14507e() + this.f11343f) == -1) {
                        z2 = false;
                        if (!z2) {
                            c2457k.write("#invalid payload reference\n");
                            z = true;
                            break;
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    break;
                case SPARSE_SWITCH:
                    if (this.f11283a.m14157b(((InterfaceC2211x) this.f11284b).mo14507e() + this.f11343f) == -1) {
                        z2 = false;
                        if (!z2) {
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    break;
                case FILL_ARRAY_DATA:
                    try {
                        this.f11283a.m14158b(((InterfaceC2211x) this.f11284b).mo14507e() + this.f11343f, EnumC2272f.ARRAY_PAYLOAD);
                        z2 = true;
                    } catch (C1943k.a e7) {
                        z2 = false;
                    }
                    if (!z2) {
                    }
                    break;
                default:
                    throw new C2453g("Invalid 31t opcode: %s", this.f11284b.mo14416a());
            }
        }
        if (mo14416a.m14878b() && !m14098a(mo14416a)) {
            c2457k.write("#disallowed odex opcode\n");
            z = true;
        }
        if (z) {
            c2457k.write("#");
        }
        switch (this.f11284b.mo14416a().f12386ei) {
            case Format10t:
                m14101b(c2457k);
                c2457k.write(32);
                mo14103c(c2457k);
                break;
            case Format10x:
                if (this.f11284b instanceof InterfaceC2188ak) {
                    c2457k.write("#unknown opcode: 0x");
                    c2457k.m15533a(((InterfaceC2188ak) this.f11284b).mo14631s_());
                    c2457k.write(10);
                }
                m14101b(c2457k);
                break;
            case Format11n:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14110i(c2457k);
                break;
            case Format11x:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                break;
            case Format12x:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14106e(c2457k);
                break;
            case Format20bc:
                m14101b(c2457k);
                c2457k.write(32);
                c2457k.write(str);
                c2457k.write(", ");
                aVar2.mo14117a(c2457k);
                break;
            case Format20t:
            case Format30t:
                m14101b(c2457k);
                c2457k.write(32);
                mo14103c(c2457k);
                break;
            case Format21c:
            case Format31c:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                aVar2.mo14117a(c2457k);
                break;
            case Format21ih:
            case Format21lh:
            case Format21s:
            case Format31i:
            case Format51l:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14110i(c2457k);
                if (this.f11284b.mo14416a().m14882f()) {
                    m14112k(c2457k);
                    break;
                } else if (!m14113l(c2457k)) {
                    m14111j(c2457k);
                    break;
                }
                break;
            case Format21t:
            case Format31t:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                mo14103c(c2457k);
                break;
            case Format22b:
            case Format22s:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14106e(c2457k);
                c2457k.write(", ");
                m14110i(c2457k);
                break;
            case Format22c:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14106e(c2457k);
                c2457k.write(", ");
                aVar2.mo14117a(c2457k);
                break;
            case Format22cs:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14106e(c2457k);
                c2457k.write(", ");
                m14114m(c2457k);
                break;
            case Format22t:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14106e(c2457k);
                c2457k.write(", ");
                mo14103c(c2457k);
                break;
            case Format22x:
            case Format32x:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14106e(c2457k);
                break;
            case Format23x:
                m14101b(c2457k);
                c2457k.write(32);
                m14105d(c2457k);
                c2457k.write(", ");
                m14106e(c2457k);
                c2457k.write(", ");
                m14107f(c2457k);
                break;
            case Format35c:
                m14101b(c2457k);
                c2457k.write(32);
                m14108g(c2457k);
                c2457k.write(", ");
                aVar2.mo14117a(c2457k);
                break;
            case Format35mi:
                m14101b(c2457k);
                c2457k.write(32);
                m14108g(c2457k);
                c2457k.write(", ");
                m14115n(c2457k);
                break;
            case Format35ms:
                m14101b(c2457k);
                c2457k.write(32);
                m14108g(c2457k);
                c2457k.write(", ");
                m14116o(c2457k);
                break;
            case Format3rc:
                m14101b(c2457k);
                c2457k.write(32);
                m14109h(c2457k);
                c2457k.write(", ");
                aVar2.mo14117a(c2457k);
                break;
            case Format3rmi:
                m14101b(c2457k);
                c2457k.write(32);
                m14109h(c2457k);
                c2457k.write(", ");
                m14115n(c2457k);
                break;
            case Format3rms:
                m14101b(c2457k);
                c2457k.write(32);
                m14109h(c2457k);
                c2457k.write(", ");
                m14116o(c2457k);
                break;
            case Format45cc:
                m14101b(c2457k);
                c2457k.write(32);
                m14108g(c2457k);
                c2457k.write(", ");
                aVar2.mo14117a(c2457k);
                c2457k.write(", ");
                aVar.mo14117a(c2457k);
                break;
            case Format4rcc:
                m14101b(c2457k);
                c2457k.write(32);
                m14109h(c2457k);
                c2457k.write(", ");
                aVar2.mo14117a(c2457k);
                c2457k.write(", ");
                aVar.mo14117a(c2457k);
                break;
            default:
                if (f11282c) {
                    return false;
                }
                throw new AssertionError();
        }
        if (z) {
            c2457k.write("\nnop");
        }
        return true;
    }

    /* renamed from: b */
    protected void m14101b(C2457k c2457k) {
        c2457k.write(this.f11284b.mo14416a().f12384eg);
    }

    /* renamed from: c */
    protected void mo14103c(C2457k c2457k) {
        throw new RuntimeException();
    }

    /* renamed from: a */
    protected void m14099a(C2457k c2457k, int i) {
        this.f11283a.f11334g.m14172a(c2457k, i);
    }

    /* renamed from: d */
    protected void m14105d(C2457k c2457k) {
        m14099a(c2457k, ((InterfaceC2223k) this.f11284b).mo14495q_());
    }

    /* renamed from: e */
    protected void m14106e(C2457k c2457k) {
        m14099a(c2457k, ((InterfaceC2230r) this.f11284b).mo14500r_());
    }

    /* renamed from: f */
    protected void m14107f(C2457k c2457k) {
        m14099a(c2457k, ((InterfaceC2229q) this.f11284b).mo14504g());
    }

    /* renamed from: g */
    protected void m14108g(C2457k c2457k) {
        InterfaceC2215c interfaceC2215c = (InterfaceC2215c) this.f11284b;
        int e2 = interfaceC2215c.mo14481e();
        c2457k.write(123);
        switch (e2) {
            case 1:
                m14099a(c2457k, interfaceC2215c.mo14483h());
                break;
            case 2:
                m14099a(c2457k, interfaceC2215c.mo14483h());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14484i());
                break;
            case 3:
                m14099a(c2457k, interfaceC2215c.mo14483h());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14484i());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14485j());
                break;
            case 4:
                m14099a(c2457k, interfaceC2215c.mo14483h());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14484i());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14485j());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14486k());
                break;
            case 5:
                m14099a(c2457k, interfaceC2215c.mo14483h());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14484i());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14485j());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14486k());
                c2457k.write(", ");
                m14099a(c2457k, interfaceC2215c.mo14487l());
                break;
        }
        c2457k.write(125);
    }

    /* renamed from: h */
    protected void m14109h(C2457k c2457k) {
        InterfaceC2226n interfaceC2226n = (InterfaceC2226n) this.f11284b;
        if (interfaceC2226n.mo14481e() == 0) {
            c2457k.write("{}");
        } else {
            this.f11283a.f11334g.m14173a(c2457k, interfaceC2226n.mo14491h(), (r1 + r0) - 1);
        }
    }

    /* renamed from: i */
    protected void m14110i(C2457k c2457k) {
        C1957g.m14181b(c2457k, ((InterfaceC2234v) this.f11284b).mo14494g());
    }

    /* renamed from: j */
    protected void m14111j(C2457k c2457k) {
        m14102b(c2457k, ((InterfaceC2221i) this.f11284b).mo14499f());
    }

    /* renamed from: b */
    protected void m14102b(C2457k c2457k, int i) {
        if (C2459m.m15541a(i)) {
            c2457k.write("    # ");
            float intBitsToFloat = Float.intBitsToFloat(i);
            if (intBitsToFloat == Float.POSITIVE_INFINITY) {
                c2457k.write("Float.POSITIVE_INFINITY");
                return;
            }
            if (intBitsToFloat == Float.NEGATIVE_INFINITY) {
                c2457k.write("Float.NEGATIVE_INFINITY");
                return;
            }
            if (Float.isNaN(intBitsToFloat)) {
                c2457k.write("Float.NaN");
                return;
            }
            if (intBitsToFloat == Float.MAX_VALUE) {
                c2457k.write("Float.MAX_VALUE");
                return;
            }
            if (intBitsToFloat == 3.1415927f) {
                c2457k.write("(float)Math.PI");
            } else if (intBitsToFloat == 2.7182817f) {
                c2457k.write("(float)Math.E");
            } else {
                c2457k.write(Float.toString(intBitsToFloat));
                c2457k.write(102);
            }
        }
    }

    /* renamed from: k */
    protected void m14112k(C2457k c2457k) {
        m14100a(c2457k, ((InterfaceC2234v) this.f11284b).mo14494g());
    }

    /* renamed from: a */
    protected void m14100a(C2457k c2457k, long j) {
        if (C2459m.m15542a(j)) {
            c2457k.write("    # ");
            double longBitsToDouble = Double.longBitsToDouble(j);
            if (longBitsToDouble == Double.POSITIVE_INFINITY) {
                c2457k.write("Double.POSITIVE_INFINITY");
                return;
            }
            if (longBitsToDouble == Double.NEGATIVE_INFINITY) {
                c2457k.write("Double.NEGATIVE_INFINITY");
                return;
            }
            if (Double.isNaN(longBitsToDouble)) {
                c2457k.write("Double.NaN");
                return;
            }
            if (longBitsToDouble == Double.MAX_VALUE) {
                c2457k.write("Double.MAX_VALUE");
                return;
            }
            if (longBitsToDouble == 3.141592653589793d) {
                c2457k.write("Math.PI");
            } else if (longBitsToDouble == 2.718281828459045d) {
                c2457k.write("Math.E");
            } else {
                c2457k.write(Double.toString(longBitsToDouble));
            }
        }
    }

    /* renamed from: l */
    protected boolean m14113l(C2457k c2457k) {
        return m14104c(c2457k, ((InterfaceC2221i) this.f11284b).mo14499f());
    }

    /* renamed from: c */
    protected boolean m14104c(C2457k c2457k, int i) {
        String str = this.f11283a.f11328a.f11317a.f11367m.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        c2457k.write("    # ");
        c2457k.write(str);
        return true;
    }

    /* renamed from: m */
    protected void m14114m(C2457k c2457k) {
        c2457k.write("field@0x");
        c2457k.m15533a(((InterfaceC2214b) this.f11284b).mo14503g());
    }

    /* renamed from: n */
    protected void m14115n(C2457k c2457k) {
        c2457k.write("inline@");
        c2457k.m15536c(((InterfaceC2217e) this.f11284b).mo14482f());
    }

    /* renamed from: o */
    protected void m14116o(C2457k c2457k) {
        c2457k.write("vtable@");
        c2457k.m15536c(((InterfaceC2233u) this.f11284b).mo14488f());
    }
}
