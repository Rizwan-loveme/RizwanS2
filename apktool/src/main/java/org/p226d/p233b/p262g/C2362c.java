package org.p226d.p233b.p262g;

import com.p129f.p130a.p133c.C1154ag;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1993g;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;

/* compiled from: ClassDefRewriter.java */
/* renamed from: org.d.b.g.c */
/* loaded from: classes.dex */
public class C2362c implements InterfaceC2374o<InterfaceC2244d> {

    /* renamed from: a */
    protected final InterfaceC2377r f12646a;

    public C2362c(InterfaceC2377r interfaceC2377r) {
        this.f12646a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2244d mo15030a(InterfaceC2244d interfaceC2244d) {
        return new a(interfaceC2244d);
    }

    /* compiled from: ClassDefRewriter.java */
    /* renamed from: org.d.b.g.c$a */
    protected class a extends AbstractC1993g implements InterfaceC2244d {

        /* renamed from: a */
        protected InterfaceC2244d f12647a;

        public a(InterfaceC2244d interfaceC2244d) {
            this.f12647a = interfaceC2244d;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: l */
        public String mo14205l() {
            return C2362c.this.f12646a.mo15041j().mo15030a(this.f12647a.mo14205l());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: a */
        public int mo14194a() {
            return this.f12647a.mo14194a();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: b */
        public String mo14195b() {
            return (String) C2376q.m15063a(C2362c.this.f12646a.mo15041j(), this.f12647a.mo14195b());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: c */
        public List<String> mo14196c() {
            return C2376q.m15064a((InterfaceC2374o) C2362c.this.f12646a.mo15041j(), (List) this.f12647a.mo14196c());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: d */
        public String mo14197d() {
            return this.f12647a.mo14197d();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: e */
        public Set<? extends InterfaceC2165a> mo14198e() {
            return C2376q.m15065a((InterfaceC2374o) C2362c.this.f12646a.mo15044m(), (Set) this.f12647a.mo14198e());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: f */
        public Iterable<? extends InterfaceC2266g> mo14199f() {
            return C2376q.m15062a((InterfaceC2374o) C2362c.this.f12646a.mo15033b(), (Iterable) this.f12647a.mo14199f());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: g */
        public Iterable<? extends InterfaceC2266g> mo14200g() {
            return C2376q.m15062a((InterfaceC2374o) C2362c.this.f12646a.mo15033b(), (Iterable) this.f12647a.mo14200g());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: n */
        public Iterable<? extends InterfaceC2266g> mo14207n() {
            return new Iterable<InterfaceC2266g>() { // from class: org.d.b.g.c.a.1
                @Override // java.lang.Iterable
                public Iterator<InterfaceC2266g> iterator() {
                    return C1154ag.m9895b(a.this.mo14199f().iterator(), a.this.mo14200g().iterator());
                }
            };
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: i */
        public Iterable<? extends InterfaceC2267h> mo14202i() {
            return C2376q.m15062a((InterfaceC2374o) C2362c.this.f12646a.mo15034c(), (Iterable) this.f12647a.mo14202i());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: j */
        public Iterable<? extends InterfaceC2267h> mo14203j() {
            return C2376q.m15062a((InterfaceC2374o) C2362c.this.f12646a.mo15034c(), (Iterable) this.f12647a.mo14203j());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: m */
        public Iterable<? extends InterfaceC2267h> mo14206m() {
            return new Iterable<InterfaceC2267h>() { // from class: org.d.b.g.c.a.2
                @Override // java.lang.Iterable
                public Iterator<InterfaceC2267h> iterator() {
                    return C1154ag.m9895b(a.this.mo14202i().iterator(), a.this.mo14203j().iterator());
                }
            };
        }
    }
}
