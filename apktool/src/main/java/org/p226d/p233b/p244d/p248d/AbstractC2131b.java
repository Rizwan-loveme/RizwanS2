package org.p226d.p233b.p244d.p248d;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.util.Arrays;
import java.util.Iterator;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.C2156j;
import org.p226d.p233b.p244d.C2157k;
import org.p226d.p233b.p244d.C2161o;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p251a.InterfaceC2167b;
import org.p226d.p233b.p250e.p251a.InterfaceC2170e;
import org.p226d.p233b.p256f.p257a.C2275b;
import org.p226d.p233b.p256f.p257a.C2276c;
import org.p226d.p233b.p256f.p257a.C2277d;
import org.p226d.p233b.p256f.p257a.C2278e;
import org.p226d.p233b.p256f.p257a.C2279f;
import org.p226d.p233b.p256f.p257a.C2280g;
import org.p226d.p233b.p256f.p257a.C2281h;

/* compiled from: DebugInfo.java */
/* renamed from: org.d.b.d.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC2131b implements Iterable<InterfaceC2166a> {
    /* renamed from: a */
    public abstract Iterator<String> mo14709a(C2161o c2161o);

    /* renamed from: a */
    public static AbstractC2131b m14708a(C2153g c2153g, int i, C2157k c2157k) {
        return i == 0 ? b.f11894a : new a(c2153g, i, c2157k);
    }

    /* compiled from: DebugInfo.java */
    /* renamed from: org.d.b.d.d.b$b */
    private static class b extends AbstractC2131b {

        /* renamed from: a */
        public static final b f11894a = new b();

        private b() {
        }

        @Override // java.lang.Iterable
        public Iterator<InterfaceC2166a> iterator() {
            return AbstractC1148aa.m9802i().iterator();
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2131b
        /* renamed from: a */
        public Iterator<String> mo14709a(C2161o c2161o) {
            return AbstractC1148aa.m9802i().iterator();
        }
    }

    /* compiled from: DebugInfo.java */
    /* renamed from: org.d.b.d.d.b$a */
    private static class a extends AbstractC2131b {

        /* renamed from: d */
        private static final InterfaceC2170e f11883d = new InterfaceC2170e() { // from class: org.d.b.d.d.b.a.1
            @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
            /* renamed from: b */
            public String mo14220b() {
                return null;
            }

            @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
            /* renamed from: l */
            public String mo14465l() {
                return null;
            }

            @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
            /* renamed from: c */
            public String mo14452c() {
                return null;
            }
        };

        /* renamed from: a */
        public final C2153g f11884a;

        /* renamed from: b */
        private final int f11885b;

        /* renamed from: c */
        private final C2157k f11886c;

        public a(C2153g c2153g, int i, C2157k c2157k) {
            this.f11884a = c2153g;
            this.f11885b = i;
            this.f11886c = c2157k;
        }

        @Override // java.lang.Iterable
        public Iterator<InterfaceC2166a> iterator() {
            InterfaceC2170e interfaceC2170e;
            String mo14465l;
            C2161o m14783v = this.f11884a.m14783v(this.f11885b);
            final int e2 = m14783v.m14643e();
            int mo14611d = this.f11886c.mo14611d();
            final InterfaceC2170e[] interfaceC2170eArr = new InterfaceC2170e[mo14611d];
            Arrays.fill(interfaceC2170eArr, f11883d);
            C2156j c2156j = this.f11886c.f12046b;
            C2135f c2135f = new C2135f(c2156j.mo14211c(), c2156j.m14794i(), mo14709a(m14783v));
            int i = 0;
            if (!EnumC1959a.STATIC.m14192a(this.f11886c.f12046b.mo14214f())) {
                interfaceC2170eArr[0] = new InterfaceC2170e() { // from class: org.d.b.d.d.b.a.2
                    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
                    /* renamed from: b */
                    public String mo14220b() {
                        return "this";
                    }

                    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
                    /* renamed from: l */
                    public String mo14465l() {
                        return a.this.f11886c.f12046b.mo14209a();
                    }

                    @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
                    /* renamed from: c */
                    public String mo14452c() {
                        return null;
                    }
                };
                i = 1;
            }
            while (c2135f.hasNext()) {
                interfaceC2170eArr[i] = c2135f.next();
                i++;
            }
            if (i < mo14611d) {
                int i2 = mo14611d - 1;
                while (true) {
                    i--;
                    if (i <= -1 || ((mo14465l = (interfaceC2170e = interfaceC2170eArr[i]).mo14465l()) != null && ((mo14465l.equals("J") || mo14465l.equals("D")) && i2 - 1 == i))) {
                        break;
                    }
                    interfaceC2170eArr[i2] = interfaceC2170e;
                    interfaceC2170eArr[i] = f11883d;
                    i2--;
                }
            }
            return new AbstractC2139j<InterfaceC2166a>(this.f11884a, m14783v.m14635a()) { // from class: org.d.b.d.d.b.a.3

                /* renamed from: d */
                private int f11891d = 0;

                /* renamed from: e */
                private int f11892e;

                {
                    this.f11892e = e2;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.p226d.p233b.p244d.p248d.AbstractC2139j
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public InterfaceC2166a mo14714b(C2161o c2161o) {
                    InterfaceC2170e interfaceC2170e2;
                    InterfaceC2170e interfaceC2170e3;
                    InterfaceC2170e interfaceC2170e4;
                    boolean z;
                    while (true) {
                        int i3 = c2161o.m14651i();
                        switch (i3) {
                            case 0:
                                return m10002b();
                            case 1:
                                this.f11891d = c2161o.m14639c() + this.f11891d;
                                break;
                            case 2:
                                this.f11892e = c2161o.m14637b() + this.f11892e;
                                break;
                            case 3:
                                int c2 = c2161o.m14639c();
                                C2281h c2281h = new C2281h(this.f11891d, c2, a.this.f11884a.m14780s(c2161o.m14639c() - 1), a.this.f11884a.m14782u(c2161o.m14639c() - 1), null);
                                if (c2 < 0 || c2 >= interfaceC2170eArr.length) {
                                    return c2281h;
                                }
                                interfaceC2170eArr[c2] = c2281h;
                                return c2281h;
                            case 4:
                                int c3 = c2161o.m14639c();
                                C2281h c2281h2 = new C2281h(this.f11891d, c3, a.this.f11884a.m14780s(c2161o.m14639c() - 1), a.this.f11884a.m14782u(c2161o.m14639c() - 1), a.this.f11884a.m14780s(c2161o.m14639c() - 1));
                                if (c3 < 0 || c3 >= interfaceC2170eArr.length) {
                                    return c2281h2;
                                }
                                interfaceC2170eArr[c3] = c2281h2;
                                return c2281h2;
                            case 5:
                                int c4 = c2161o.m14639c();
                                boolean z2 = true;
                                if (c4 < 0 || c4 >= interfaceC2170eArr.length) {
                                    interfaceC2170e3 = a.f11883d;
                                    z2 = false;
                                } else {
                                    interfaceC2170e3 = interfaceC2170eArr[c4];
                                }
                                if (interfaceC2170e3 instanceof InterfaceC2167b) {
                                    interfaceC2170e4 = a.f11883d;
                                    z = false;
                                } else {
                                    interfaceC2170e4 = interfaceC2170e3;
                                    z = z2;
                                }
                                C2275b c2275b = new C2275b(this.f11891d, c4, interfaceC2170e4.mo14220b(), interfaceC2170e4.mo14465l(), interfaceC2170e4.mo14452c());
                                if (!z) {
                                    return c2275b;
                                }
                                interfaceC2170eArr[c4] = c2275b;
                                return c2275b;
                            case 6:
                                int c5 = c2161o.m14639c();
                                if (c5 < 0 || c5 >= interfaceC2170eArr.length) {
                                    interfaceC2170e2 = a.f11883d;
                                } else {
                                    interfaceC2170e2 = interfaceC2170eArr[c5];
                                }
                                C2279f c2279f = new C2279f(this.f11891d, c5, interfaceC2170e2.mo14220b(), interfaceC2170e2.mo14465l(), interfaceC2170e2.mo14452c());
                                if (c5 < 0 || c5 >= interfaceC2170eArr.length) {
                                    return c2279f;
                                }
                                interfaceC2170eArr[c5] = c2279f;
                                return c2279f;
                            case 7:
                                return new C2278e(this.f11891d);
                            case 8:
                                return new C2276c(this.f11891d);
                            case 9:
                                return new C2280g(this.f11891d, a.this.f11884a.m14780s(c2161o.m14639c() - 1));
                            default:
                                this.f11891d += (i3 - 10) / 15;
                                this.f11892e = ((r0 % 15) - 4) + this.f11892e;
                                return new C2277d(this.f11891d, this.f11892e);
                        }
                    }
                }
            };
        }

        @Override // org.p226d.p233b.p244d.p248d.AbstractC2131b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbstractC2136g<String> mo14709a(C2161o c2161o) {
            if (c2161o == null) {
                c2161o = this.f11884a.m14783v(this.f11885b);
                c2161o.m14646f();
            }
            return new AbstractC2136g<String>(c2161o, c2161o.m14639c()) { // from class: org.d.b.d.d.b.a.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.p226d.p233b.p244d.p248d.AbstractC2136g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public String mo14716b(C2161o c2161o2, int i) {
                    return a.this.f11884a.m14780s(c2161o2.m14639c() - 1);
                }
            };
        }
    }
}
