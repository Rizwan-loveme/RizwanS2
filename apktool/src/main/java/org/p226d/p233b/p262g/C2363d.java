package org.p226d.p233b.p262g;

import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p251a.InterfaceC2167b;
import org.p226d.p233b.p250e.p251a.InterfaceC2170e;
import org.p226d.p233b.p250e.p251a.InterfaceC2172g;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;
import org.p226d.p233b.p250e.p254c.InterfaceC2242g;
import org.p226d.p233b.p250e.p254c.InterfaceC2243h;

/* compiled from: DebugItemRewriter.java */
/* renamed from: org.d.b.g.d */
/* loaded from: classes.dex */
public class C2363d implements InterfaceC2374o<InterfaceC2166a> {

    /* renamed from: a */
    protected final InterfaceC2377r f12651a;

    public C2363d(InterfaceC2377r interfaceC2377r) {
        this.f12651a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2166a mo15030a(InterfaceC2166a interfaceC2166a) {
        switch (interfaceC2166a.mo14464f()) {
            case 3:
                return new d((InterfaceC2174i) interfaceC2166a);
            case 4:
            default:
                return interfaceC2166a;
            case 5:
                return new b((InterfaceC2167b) interfaceC2166a);
            case 6:
                return new c((InterfaceC2172g) interfaceC2166a);
        }
    }

    /* compiled from: DebugItemRewriter.java */
    /* renamed from: org.d.b.g.d$a */
    protected class a<T extends InterfaceC2166a & InterfaceC2170e> implements InterfaceC2166a, InterfaceC2170e {

        /* renamed from: a */
        protected T f12652a;

        public a(T t) {
            this.f12652a = t;
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
        /* renamed from: f */
        public int mo14464f() {
            return this.f12652a.mo14464f();
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2166a
        /* renamed from: a */
        public int mo14461a() {
            return this.f12652a.mo14461a();
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
        /* renamed from: b */
        public String mo14220b() {
            return this.f12652a.mo14220b();
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
        /* renamed from: l */
        public String mo14465l() {
            return (String) C2376q.m15063a(C2363d.this.f12651a.mo15041j(), this.f12652a.mo14465l());
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2170e
        /* renamed from: c */
        public String mo14452c() {
            return this.f12652a.mo14452c();
        }
    }

    /* compiled from: DebugItemRewriter.java */
    /* renamed from: org.d.b.g.d$d */
    protected class d extends a<InterfaceC2174i> implements InterfaceC2174i {
        public d(InterfaceC2174i interfaceC2174i) {
            super(interfaceC2174i);
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
        /* renamed from: e */
        public int mo14470e() {
            return ((InterfaceC2174i) this.f12652a).mo14470e();
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
        /* renamed from: g */
        public InterfaceC2242g mo14471g() {
            return ((InterfaceC2174i) this.f12652a).mo14471g();
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
        /* renamed from: h */
        public InterfaceC2243h mo14472h() {
            InterfaceC2243h mo14472h = ((InterfaceC2174i) this.f12652a).mo14472h();
            if (mo14472h == null) {
                return null;
            }
            return C2376q.m15066a(C2363d.this.f12651a.mo15041j(), mo14472h);
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2174i
        /* renamed from: i */
        public InterfaceC2242g mo14473i() {
            return ((InterfaceC2174i) this.f12652a).mo14473i();
        }
    }

    /* compiled from: DebugItemRewriter.java */
    /* renamed from: org.d.b.g.d$b */
    protected class b extends a<InterfaceC2167b> implements InterfaceC2167b {
        public b(InterfaceC2167b interfaceC2167b) {
            super(interfaceC2167b);
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2167b
        /* renamed from: e */
        public int mo14463e() {
            return ((InterfaceC2167b) this.f12652a).mo14463e();
        }
    }

    /* compiled from: DebugItemRewriter.java */
    /* renamed from: org.d.b.g.d$c */
    protected class c extends a<InterfaceC2172g> implements InterfaceC2172g {
        public c(InterfaceC2172g interfaceC2172g) {
            super(interfaceC2172g);
        }

        @Override // org.p226d.p233b.p250e.p251a.InterfaceC2172g
        /* renamed from: e */
        public int mo14467e() {
            return ((InterfaceC2172g) this.f12652a).mo14467e();
        }
    }
}
