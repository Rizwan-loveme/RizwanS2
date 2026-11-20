package org.p226d.p233b.p262g;

import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2180ac;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2194g;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2196i;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2202o;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2209v;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2213z;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: InstructionRewriter.java */
/* renamed from: org.d.b.g.j */
/* loaded from: classes.dex */
public class C2369j implements InterfaceC2374o<InterfaceC2218f> {

    /* renamed from: a */
    protected final InterfaceC2377r f12696a;

    public C2369j(InterfaceC2377r interfaceC2377r) {
        this.f12696a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2218f mo15030a(InterfaceC2218f interfaceC2218f) {
        if (interfaceC2218f instanceof InterfaceC2225m) {
            switch (interfaceC2218f.mo14416a().f12386ei) {
                case Format20bc:
                    return new b((InterfaceC2194g) interfaceC2218f);
                case Format21c:
                    return new c((InterfaceC2196i) interfaceC2218f);
                case Format22c:
                    return new d((InterfaceC2202o) interfaceC2218f);
                case Format31c:
                    return new e((InterfaceC2209v) interfaceC2218f);
                case Format35c:
                    return new f((InterfaceC2213z) interfaceC2218f);
                case Format3rc:
                    return new g((InterfaceC2180ac) interfaceC2218f);
                default:
                    throw new IllegalArgumentException();
            }
        }
        return interfaceC2218f;
    }

    /* compiled from: InstructionRewriter.java */
    /* renamed from: org.d.b.g.j$a */
    protected class a<T extends InterfaceC2225m> implements InterfaceC2225m {

        /* renamed from: a */
        protected T f12698a;

        protected a(T t) {
            this.f12698a = t;
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
        /* renamed from: f */
        public InterfaceC2241f mo14489f() {
            switch (mo14490g()) {
                case 0:
                    return this.f12698a.mo14489f();
                case 1:
                    return C2376q.m15066a(C2369j.this.f12696a.mo15041j(), (InterfaceC2243h) this.f12698a.mo14489f());
                case 2:
                    return C2369j.this.f12696a.mo15042k().mo15030a((InterfaceC2237b) this.f12698a.mo14489f());
                case 3:
                    return C2369j.this.f12696a.mo15043l().mo15030a((InterfaceC2240e) this.f12698a.mo14489f());
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2225m
        /* renamed from: g */
        public int mo14490g() {
            return this.f12698a.mo14490g();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
        /* renamed from: a */
        public EnumC2272f mo14416a() {
            return this.f12698a.mo14416a();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2218f
        /* renamed from: b */
        public int mo14417b() {
            return this.f12698a.mo14417b();
        }
    }

    /* compiled from: InstructionRewriter.java */
    /* renamed from: org.d.b.g.j$b */
    protected class b extends a<InterfaceC2194g> implements InterfaceC2194g {
        public b(InterfaceC2194g interfaceC2194g) {
            super(interfaceC2194g);
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2232t
        /* renamed from: e */
        public int mo14501e() {
            return ((InterfaceC2194g) this.f12698a).mo14501e();
        }
    }

    /* compiled from: InstructionRewriter.java */
    /* renamed from: org.d.b.g.j$c */
    protected class c extends a<InterfaceC2196i> implements InterfaceC2196i {
        public c(InterfaceC2196i interfaceC2196i) {
            super(interfaceC2196i);
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
        /* renamed from: q_ */
        public int mo14495q_() {
            return ((InterfaceC2196i) this.f12698a).mo14495q_();
        }
    }

    /* compiled from: InstructionRewriter.java */
    /* renamed from: org.d.b.g.j$d */
    protected class d extends a<InterfaceC2202o> implements InterfaceC2202o {
        public d(InterfaceC2202o interfaceC2202o) {
            super(interfaceC2202o);
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
        /* renamed from: q_ */
        public int mo14495q_() {
            return ((InterfaceC2202o) this.f12698a).mo14495q_();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2230r
        /* renamed from: r_ */
        public int mo14500r_() {
            return ((InterfaceC2202o) this.f12698a).mo14500r_();
        }
    }

    /* compiled from: InstructionRewriter.java */
    /* renamed from: org.d.b.g.j$e */
    protected class e extends a<InterfaceC2209v> implements InterfaceC2209v {
        public e(InterfaceC2209v interfaceC2209v) {
            super(interfaceC2209v);
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2223k
        /* renamed from: q_ */
        public int mo14495q_() {
            return ((InterfaceC2209v) this.f12698a).mo14495q_();
        }
    }

    /* compiled from: InstructionRewriter.java */
    /* renamed from: org.d.b.g.j$f */
    protected class f extends a<InterfaceC2213z> implements InterfaceC2213z {
        public f(InterfaceC2213z interfaceC2213z) {
            super(interfaceC2213z);
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
        /* renamed from: h */
        public int mo14483h() {
            return ((InterfaceC2213z) this.f12698a).mo14483h();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
        /* renamed from: j */
        public int mo14485j() {
            return ((InterfaceC2213z) this.f12698a).mo14485j();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
        /* renamed from: l */
        public int mo14487l() {
            return ((InterfaceC2213z) this.f12698a).mo14487l();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
        /* renamed from: e */
        public int mo14481e() {
            return ((InterfaceC2213z) this.f12698a).mo14481e();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
        /* renamed from: i */
        public int mo14484i() {
            return ((InterfaceC2213z) this.f12698a).mo14484i();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2215c
        /* renamed from: k */
        public int mo14486k() {
            return ((InterfaceC2213z) this.f12698a).mo14486k();
        }
    }

    /* compiled from: InstructionRewriter.java */
    /* renamed from: org.d.b.g.j$g */
    protected class g extends a<InterfaceC2180ac> implements InterfaceC2180ac {
        public g(InterfaceC2180ac interfaceC2180ac) {
            super(interfaceC2180ac);
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2226n
        /* renamed from: h */
        public int mo14491h() {
            return ((InterfaceC2180ac) this.f12698a).mo14491h();
        }

        @Override // org.p226d.p233b.p250e.p252b.InterfaceC2231s
        /* renamed from: e */
        public int mo14481e() {
            return ((InterfaceC2180ac) this.f12698a).mo14481e();
        }
    }
}
