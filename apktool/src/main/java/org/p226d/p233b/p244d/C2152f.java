package org.p226d.p233b.p244d;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1153af;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p244d.p248d.AbstractC2130a;
import org.p226d.p233b.p244d.p248d.AbstractC2132c;
import org.p226d.p233b.p244d.p248d.AbstractC2139j;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p256f.p259c.C2322b;
import org.p226d.p233b.p256f.p259c.C2325e;

/* compiled from: DexBackedClassDef.java */
/* renamed from: org.d.b.d.f */
/* loaded from: classes.dex */
public class C2152f extends AbstractC1993g implements InterfaceC2244d {

    /* renamed from: a */
    public final C2153g f11948a;

    /* renamed from: b */
    private final int f11949b;

    /* renamed from: c */
    private final int f11950c;

    /* renamed from: d */
    private int f11951d = 0;

    /* renamed from: e */
    private int f11952e = 0;

    /* renamed from: f */
    private int f11953f = 0;

    /* renamed from: g */
    private final int f11954g;

    /* renamed from: h */
    private final int f11955h;

    /* renamed from: i */
    private final int f11956i;

    /* renamed from: j */
    private final int f11957j;

    /* renamed from: k */
    private AbstractC2130a f11958k;

    public C2152f(C2153g c2153g, int i) {
        this.f11948a = c2153g;
        this.f11949b = i;
        int a2 = c2153g.m14615a(i + 24);
        if (a2 == 0) {
            this.f11950c = -1;
            this.f11954g = 0;
            this.f11955h = 0;
            this.f11956i = 0;
            this.f11957j = 0;
            return;
        }
        C2161o m14783v = c2153g.m14783v(a2);
        this.f11954g = m14783v.m14639c();
        this.f11955h = m14783v.m14639c();
        this.f11956i = m14783v.m14639c();
        this.f11957j = m14783v.m14639c();
        this.f11950c = m14783v.m14635a();
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: l */
    public String mo14205l() {
        return this.f11948a.m14781t(this.f11948a.m14615a(this.f11949b + 0));
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: b */
    public String mo14195b() {
        return this.f11948a.m14782u(this.f11948a.m14616b(this.f11949b + 8));
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: a */
    public int mo14194a() {
        return this.f11948a.m14615a(this.f11949b + 4);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: d */
    public String mo14197d() {
        return this.f11948a.m14780s(this.f11948a.m14616b(this.f11949b + 16));
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: c */
    public List<String> mo14196c() {
        final int a2 = this.f11948a.m14615a(this.f11949b + 12);
        if (a2 <= 0) {
            return AbstractC1208w.m10138g();
        }
        final int a3 = this.f11948a.m14615a(a2);
        return new AbstractList<String>() { // from class: org.d.b.d.f.1
            @Override // java.util.AbstractList, java.util.List
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public String get(int i) {
                return C2152f.this.f11948a.m14781t(C2152f.this.f11948a.m14617c(a2 + 4 + (i * 2)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return a3;
            }
        };
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: e */
    public Set<? extends C2120c> mo14198e() {
        return m14751h().mo14697a();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: f */
    public Iterable<? extends C2155i> mo14199f() {
        return m14755a(true);
    }

    /* renamed from: a */
    public Iterable<? extends C2155i> m14755a(final boolean z) {
        if (this.f11954g > 0) {
            C2161o m14783v = this.f11948a.m14783v(this.f11950c);
            final AbstractC2130a m14751h = m14751h();
            final int a2 = this.f11948a.m14615a(this.f11949b + 28);
            final int a3 = m14783v.m14635a();
            return new Iterable<C2155i>() { // from class: org.d.b.d.f.2
                @Override // java.lang.Iterable
                public Iterator<C2155i> iterator() {
                    final AbstractC2130a.a mo14698b = m14751h.mo14698b();
                    final AbstractC2132c m14717a = AbstractC2132c.m14717a(C2152f.this.f11948a, a2);
                    return new AbstractC2139j<C2155i>(C2152f.this.f11948a, a3) { // from class: org.d.b.d.f.2.1

                        /* renamed from: d */
                        private int f11970d;

                        /* renamed from: e */
                        private InterfaceC2237b f11971e;

                        /* renamed from: f */
                        private int f11972f;

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // org.p226d.p233b.p244d.p248d.AbstractC2139j
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public C2155i mo14714b(C2161o c2161o) {
                            C2155i c2155i;
                            InterfaceC2237b interfaceC2237b;
                            C2322b m14959b;
                            do {
                                int i = this.f11970d + 1;
                                this.f11970d = i;
                                if (i > C2152f.this.f11954g) {
                                    C2152f.this.f11951d = c2161o.m14635a();
                                    return m10002b();
                                }
                                c2155i = new C2155i(c2161o, C2152f.this, this.f11972f, m14717a, mo14698b);
                                interfaceC2237b = this.f11971e;
                                m14959b = C2322b.m14959b(c2155i);
                                this.f11971e = m14959b;
                                this.f11972f = c2155i.f12025f;
                                if (!z || interfaceC2237b == null) {
                                    return c2155i;
                                }
                            } while (interfaceC2237b.equals(m14959b));
                            return c2155i;
                        }
                    };
                }
            };
        }
        this.f11951d = this.f11950c;
        return AbstractC1148aa.m9802i();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: g */
    public Iterable<? extends C2155i> mo14200g() {
        return m14756b(true);
    }

    /* renamed from: b */
    public Iterable<? extends C2155i> m14756b(final boolean z) {
        if (this.f11955h > 0) {
            C2161o m14783v = this.f11948a.m14783v(m14752k());
            final AbstractC2130a m14751h = m14751h();
            final int a2 = m14783v.m14635a();
            return new Iterable<C2155i>() { // from class: org.d.b.d.f.3
                @Override // java.lang.Iterable
                public Iterator<C2155i> iterator() {
                    final AbstractC2130a.a mo14698b = m14751h.mo14698b();
                    return new AbstractC2139j<C2155i>(C2152f.this.f11948a, a2) { // from class: org.d.b.d.f.3.1

                        /* renamed from: c */
                        private int f11979c;

                        /* renamed from: d */
                        private InterfaceC2237b f11980d;

                        /* renamed from: e */
                        private int f11981e;

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // org.p226d.p233b.p244d.p248d.AbstractC2139j
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public C2155i mo14714b(C2161o c2161o) {
                            C2155i c2155i;
                            InterfaceC2237b interfaceC2237b;
                            C2322b m14959b;
                            do {
                                int i = this.f11979c + 1;
                                this.f11979c = i;
                                if (i > C2152f.this.f11955h) {
                                    C2152f.this.f11952e = c2161o.m14635a();
                                    return m10002b();
                                }
                                c2155i = new C2155i(c2161o, C2152f.this, this.f11981e, mo14698b);
                                interfaceC2237b = this.f11980d;
                                m14959b = C2322b.m14959b(c2155i);
                                this.f11980d = m14959b;
                                this.f11981e = c2155i.f12025f;
                                if (!z || interfaceC2237b == null) {
                                    return c2155i;
                                }
                            } while (interfaceC2237b.equals(m14959b));
                            return c2155i;
                        }
                    };
                }
            };
        }
        if (this.f11951d > 0) {
            this.f11952e = this.f11951d;
        }
        return AbstractC1148aa.m9802i();
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: n */
    public Iterable<? extends C2155i> mo14207n() {
        return C1153af.m9870a((Iterable) mo14199f(), (Iterable) mo14200g());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: i */
    public Iterable<? extends C2156j> mo14202i() {
        return m14757c(true);
    }

    /* renamed from: c */
    public Iterable<? extends C2156j> m14757c(final boolean z) {
        if (this.f11956i > 0) {
            C2161o m14783v = this.f11948a.m14783v(m14753o());
            final AbstractC2130a m14751h = m14751h();
            final int a2 = m14783v.m14635a();
            return new Iterable<C2156j>() { // from class: org.d.b.d.f.4
                @Override // java.lang.Iterable
                public Iterator<C2156j> iterator() {
                    final AbstractC2130a.a mo14699c = m14751h.mo14699c();
                    final AbstractC2130a.a mo14700d = m14751h.mo14700d();
                    return new AbstractC2139j<C2156j>(C2152f.this.f11948a, a2) { // from class: org.d.b.d.f.4.1

                        /* renamed from: d */
                        private int f11989d;

                        /* renamed from: e */
                        private InterfaceC2240e f11990e;

                        /* renamed from: f */
                        private int f11991f;

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // org.p226d.p233b.p244d.p248d.AbstractC2139j
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public C2156j mo14714b(C2161o c2161o) {
                            C2156j c2156j;
                            InterfaceC2240e interfaceC2240e;
                            C2325e m14962b;
                            do {
                                int i = this.f11989d + 1;
                                this.f11989d = i;
                                if (i > C2152f.this.f11956i) {
                                    C2152f.this.f11953f = c2161o.m14635a();
                                    return m10002b();
                                }
                                c2156j = new C2156j(c2161o, C2152f.this, this.f11991f, mo14699c, mo14700d);
                                interfaceC2240e = this.f11990e;
                                m14962b = C2325e.m14962b(c2156j);
                                this.f11990e = m14962b;
                                this.f11991f = c2156j.f12032d;
                                if (!z || interfaceC2240e == null) {
                                    return c2156j;
                                }
                            } while (interfaceC2240e.equals(m14962b));
                            return c2156j;
                        }
                    };
                }
            };
        }
        if (this.f11952e > 0) {
            this.f11953f = this.f11952e;
        }
        return AbstractC1148aa.m9802i();
    }

    /* renamed from: d */
    public Iterable<? extends C2156j> m14758d(boolean z) {
        if (this.f11957j <= 0) {
            return AbstractC1148aa.m9802i();
        }
        return new AnonymousClass5(m14751h(), this.f11948a.m14783v(m14754p()).m14635a(), z);
    }

    /* compiled from: DexBackedClassDef.java */
    /* renamed from: org.d.b.d.f$5, reason: invalid class name */
    class AnonymousClass5 implements Iterable<C2156j> {

        /* renamed from: a */
        final AbstractC2130a.a f11992a;

        /* renamed from: b */
        final AbstractC2130a.a f11993b;

        /* renamed from: c */
        final /* synthetic */ AbstractC2130a f11994c;

        /* renamed from: d */
        final /* synthetic */ int f11995d;

        /* renamed from: e */
        final /* synthetic */ boolean f11996e;

        AnonymousClass5(AbstractC2130a abstractC2130a, int i, boolean z) {
            this.f11994c = abstractC2130a;
            this.f11995d = i;
            this.f11996e = z;
            this.f11992a = this.f11994c.mo14699c();
            this.f11993b = this.f11994c.mo14700d();
        }

        @Override // java.lang.Iterable
        public Iterator<C2156j> iterator() {
            return new AbstractC2139j<C2156j>(C2152f.this.f11948a, this.f11995d) { // from class: org.d.b.d.f.5.1

                /* renamed from: b */
                private int f11999b;

                /* renamed from: c */
                private InterfaceC2240e f12000c;

                /* renamed from: d */
                private int f12001d;

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.p226d.p233b.p244d.p248d.AbstractC2139j
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public C2156j mo14714b(C2161o c2161o) {
                    C2156j c2156j;
                    InterfaceC2240e interfaceC2240e;
                    C2325e m14962b;
                    do {
                        int i = this.f11999b + 1;
                        this.f11999b = i;
                        if (i > C2152f.this.f11957j) {
                            return m10002b();
                        }
                        c2156j = new C2156j(c2161o, C2152f.this, this.f12001d, AnonymousClass5.this.f11992a, AnonymousClass5.this.f11993b);
                        interfaceC2240e = this.f12000c;
                        m14962b = C2325e.m14962b(c2156j);
                        this.f12000c = m14962b;
                        this.f12001d = c2156j.f12032d;
                        if (!AnonymousClass5.this.f11996e || interfaceC2240e == null) {
                            return c2156j;
                        }
                    } while (interfaceC2240e.equals(m14962b));
                    return c2156j;
                }
            };
        }
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: j */
    public Iterable<? extends C2156j> mo14203j() {
        return m14758d(true);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2244d
    /* renamed from: m */
    public Iterable<? extends C2156j> mo14206m() {
        return C1153af.m9870a((Iterable) mo14202i(), (Iterable) mo14203j());
    }

    /* renamed from: h */
    private AbstractC2130a m14751h() {
        if (this.f11958k == null) {
            this.f11958k = AbstractC2130a.m14694a(this.f11948a, this.f11948a.m14615a(this.f11949b + 20));
        }
        return this.f11958k;
    }

    /* renamed from: k */
    private int m14752k() {
        if (this.f11951d > 0) {
            return this.f11951d;
        }
        C2161o c2161o = new C2161o(this.f11948a, this.f11950c);
        C2155i.m14788a(c2161o, this.f11954g);
        this.f11951d = c2161o.m14635a();
        return this.f11951d;
    }

    /* renamed from: o */
    private int m14753o() {
        if (this.f11952e > 0) {
            return this.f11952e;
        }
        C2161o m14783v = this.f11948a.m14783v(m14752k());
        C2155i.m14788a(m14783v, this.f11955h);
        this.f11952e = m14783v.m14635a();
        return this.f11952e;
    }

    /* renamed from: p */
    private int m14754p() {
        if (this.f11953f > 0) {
            return this.f11953f;
        }
        C2161o m14783v = this.f11948a.m14783v(m14753o());
        C2156j.m14790a(m14783v, this.f11956i);
        this.f11953f = m14783v.m14635a();
        return this.f11953f;
    }
}
