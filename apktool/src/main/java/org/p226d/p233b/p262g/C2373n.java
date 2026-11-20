package org.p226d.p233b.p262g;

import java.util.List;
import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;

/* compiled from: MethodRewriter.java */
/* renamed from: org.d.b.g.n */
/* loaded from: classes.dex */
public class C2373n implements InterfaceC2374o<InterfaceC2267h> {

    /* renamed from: a */
    protected final InterfaceC2377r f12716a;

    public C2373n(InterfaceC2377r interfaceC2377r) {
        this.f12716a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2267h mo15030a(InterfaceC2267h interfaceC2267h) {
        return new a(interfaceC2267h);
    }

    /* compiled from: MethodRewriter.java */
    /* renamed from: org.d.b.g.n$a */
    protected class a extends AbstractC1991e implements InterfaceC2267h {

        /* renamed from: a */
        protected InterfaceC2267h f12717a;

        public a(InterfaceC2267h interfaceC2267h) {
            this.f12717a = interfaceC2267h;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: a */
        public String mo14209a() {
            return C2373n.this.f12716a.mo15043l().mo15030a(this.f12717a).mo14209a();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: b */
        public String mo14210b() {
            return C2373n.this.f12716a.mo15043l().mo15030a(this.f12717a).mo14210b();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
        /* renamed from: c */
        public List<? extends CharSequence> mo14211c() {
            return C2373n.this.f12716a.mo15043l().mo15030a(this.f12717a).mo14211c();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: e */
        public List<? extends InterfaceC2269j> mo14213e() {
            return C2376q.m15064a((InterfaceC2374o) C2373n.this.f12716a.mo15035d(), (List) this.f12717a.mo14213e());
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: d */
        public String mo14212d() {
            return C2373n.this.f12716a.mo15043l().mo15030a(this.f12717a).mo14212d();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: f */
        public int mo14214f() {
            return this.f12717a.mo14214f();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: g */
        public Set<? extends InterfaceC2165a> mo14215g() {
            return C2376q.m15065a((InterfaceC2374o) C2373n.this.f12716a.mo15044m(), (Set) this.f12717a.mo14215g());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: h */
        public InterfaceC2268i mo14216h() {
            return (InterfaceC2268i) C2376q.m15063a(C2373n.this.f12716a.mo15036e(), this.f12717a.mo14216h());
        }
    }
}
