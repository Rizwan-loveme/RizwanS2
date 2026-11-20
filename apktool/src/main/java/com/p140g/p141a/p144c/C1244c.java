package com.p140g.p141a.p144c;

import com.p140g.p141a.p143b.C1240b;
import com.p140g.p141a.p145d.C1277f;
import com.p140g.p141a.p145d.C1278g;
import com.p140g.p141a.p148e.InterfaceC1281a;
import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1329f;
import java.io.File;
import java.io.FileOutputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import org.p271f.p272a.AbstractC2515g;
import org.p271f.p272a.AbstractC2526r;
import org.p271f.p272a.C2516h;

/* compiled from: Dex2jar.java */
/* renamed from: com.g.a.c.c */
/* loaded from: classes.dex */
public class C1244c {

    /* renamed from: a */
    private InterfaceC1245d f8072a;

    /* renamed from: b */
    private final InterfaceC1281a f8073b;

    /* renamed from: c */
    private int f8074c;

    /* renamed from: d */
    private int f8075d;

    /* renamed from: e */
    private JarOutputStream f8076e;

    /* renamed from: a */
    public static C1244c m10312a(InterfaceC1281a interfaceC1281a) {
        return new C1244c(interfaceC1281a);
    }

    C1244c(InterfaceC1281a interfaceC1281a) {
        this.f8073b = interfaceC1281a;
        this.f8074c |= 1;
    }

    /* renamed from: b */
    private void m10315b(File file) {
        C1277f c1277f = new C1277f();
        try {
            this.f8073b.mo10402a(c1277f, this.f8074c | 32);
        } catch (Exception e2) {
            this.f8072a.m10329a(e2);
        }
        new C1247f(this, this.f8072a) { // from class: com.g.a.c.c.2

            /* renamed from: r */
            private final C1244c f8081r;

            {
                this.f8081r = this;
            }

            @Override // com.p140g.p141a.p144c.C1247f, com.p140g.p141a.p144c.C1243b
            /* renamed from: a */
            public void mo10307a(C1278g c1278g, AbstractC2526r abstractC2526r) {
                if ((this.f8081r.f8074c & 4) == 0 || !c1278g.f8171d.m10398c().equals("<clinit>")) {
                    super.mo10307a(c1278g, abstractC2526r);
                }
            }

            @Override // com.p140g.p141a.p144c.C1243b
            /* renamed from: a */
            public void mo10308a(C1323b c1323b) {
                C1243b.f8049a.m10668a(c1323b);
                if ((this.f8081r.f8075d & 2) != 0) {
                }
                C1243b.f8057i.m10669a(c1323b);
                C1243b.f8054f.mo10706b(c1323b);
                C1243b.f8053e.mo10706b(c1323b);
                C1243b.f8061m.mo10706b(c1323b);
                if (C1243b.f8063o.mo10610a(c1323b)) {
                    C1243b.f8057i.m10669a(c1323b);
                    C1243b.f8054f.mo10706b(c1323b);
                    C1243b.f8053e.mo10706b(c1323b);
                }
                C1243b.f8052d.m10680a(c1323b);
                C1243b.f8058j.mo10706b(c1323b);
                C1243b.f8059k.mo10706b(c1323b);
                C1243b.f8064p.mo10706b(c1323b);
                C1243b.f8062n.mo10706b(c1323b);
                if ((this.f8081r.f8075d & 4) != 0) {
                    int i = 0;
                    for (AbstractC1333j abstractC1333j : c1323b.f8628g) {
                        if (abstractC1333j.f8650n == AbstractC1333j.d.LABEL) {
                            int i2 = i + 1;
                            ((C1329f) abstractC1333j).f8636a = new StringBuffer().append("L").append(i).toString();
                            i = i2;
                        }
                    }
                    System.out.println(c1323b);
                }
                C1243b.f8056h.m10708a(c1323b);
                C1243b.f8060l.m10755a(c1323b);
                C1243b.f8051c.m10676a(c1323b);
                C1243b.f8055g.m10670a(c1323b);
            }

            @Override // com.p140g.p141a.p144c.C1243b
            /* renamed from: a */
            public void mo10309a(C1323b c1323b, AbstractC2526r abstractC2526r) {
                new C1240b((this.f8081r.f8075d & 8) != 0).m10277a(c1323b, abstractC2526r);
            }
        }.m10305a(c1277f, new AnonymousClass1(this));
    }

    /* compiled from: Dex2jar.java */
    /* renamed from: com.g.a.c.c$1, reason: invalid class name */
    class AnonymousClass1 implements InterfaceC1242a {

        /* renamed from: a */
        private final C1244c f8077a;

        AnonymousClass1(C1244c c1244c) {
            this.f8077a = c1244c;
        }

        /* renamed from: a */
        static C1244c m10326a(AnonymousClass1 anonymousClass1) {
            return anonymousClass1.f8077a;
        }

        @Override // com.p140g.p141a.p144c.InterfaceC1242a
        /* renamed from: a */
        public AbstractC2515g mo10278a(String str) {
            C2516h c2516h = new C2516h(1);
            C1248g c1248g = new C1248g(c2516h);
            return new AbstractC2515g(this, 327680, c1248g, c1248g, c2516h) { // from class: com.g.a.c.c.1.1

                /* renamed from: c */
                private final AnonymousClass1 f8078c;

                /* renamed from: d */
                private final C1248g f8079d;

                /* renamed from: e */
                private final C2516h f8080e;

                {
                    this.f8078c = this;
                    this.f8079d = c1248g;
                    this.f8080e = c2516h;
                }

                @Override // org.p271f.p272a.AbstractC2515g
                /* renamed from: a */
                public void mo10327a() {
                    super.mo10327a();
                    String m10334b = this.f8079d.m10334b();
                    System.out.println(new StringBuffer().append("dex->class:").append(m10334b).toString());
                    try {
                        byte[] m15823b = this.f8080e.m15823b();
                        try {
                            AnonymousClass1.m10326a(this.f8078c).f8076e.putNextEntry(new ZipEntry(new StringBuffer().append(m10334b).append(".class").toString()));
                            AnonymousClass1.m10326a(this.f8078c).f8076e.write(m15823b);
                        } catch (Exception e2) {
                            e2.printStackTrace(System.err);
                        }
                    } catch (Exception e3) {
                        System.err.println(String.format("ASM fail to generate .class file: %s", m10334b));
                        AnonymousClass1.m10326a(this.f8078c).f8072a.m10329a(e3);
                    }
                }
            };
        }
    }

    /* renamed from: a */
    public C1244c m10319a(boolean z) {
        if (z) {
            this.f8075d |= 1;
        } else {
            this.f8075d &= -2;
        }
        return this;
    }

    /* renamed from: b */
    public C1244c m10321b(boolean z) {
        if (z) {
            this.f8074c |= 132;
        } else {
            this.f8074c &= -133;
        }
        return this;
    }

    /* renamed from: c */
    public C1244c m10322c(boolean z) {
        if (z) {
            this.f8075d |= 8;
        } else {
            this.f8075d &= -9;
        }
        return this;
    }

    /* renamed from: d */
    public C1244c m10323d(boolean z) {
        if (z) {
            this.f8075d |= 4;
        } else {
            this.f8075d &= -5;
        }
        return this;
    }

    /* renamed from: a */
    public C1244c m10318a() {
        this.f8075d |= 2;
        return this;
    }

    /* renamed from: e */
    public C1244c m10324e(boolean z) {
        if (z) {
            this.f8074c |= 1;
        } else {
            this.f8074c &= -2;
        }
        return this;
    }

    /* renamed from: a */
    public void m10320a(File file) {
        this.f8076e = new JarOutputStream(new FileOutputStream(file));
        m10315b(file);
        this.f8076e.close();
    }

    /* renamed from: f */
    public C1244c m10325f(boolean z) {
        if (z) {
            this.f8074c |= 256;
        } else {
            this.f8074c &= -257;
        }
        return this;
    }
}
