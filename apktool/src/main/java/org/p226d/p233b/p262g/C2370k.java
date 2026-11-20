package org.p226d.p233b.p262g;

import java.util.List;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;

/* compiled from: MethodImplementationRewriter.java */
/* renamed from: org.d.b.g.k */
/* loaded from: classes.dex */
public class C2370k implements InterfaceC2374o<InterfaceC2268i> {

    /* renamed from: a */
    protected final InterfaceC2377r f12706a;

    public C2370k(InterfaceC2377r interfaceC2377r) {
        this.f12706a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2268i mo15030a(InterfaceC2268i interfaceC2268i) {
        return new a(interfaceC2268i);
    }

    /* compiled from: MethodImplementationRewriter.java */
    /* renamed from: org.d.b.g.k$a */
    protected class a implements InterfaceC2268i {

        /* renamed from: a */
        protected InterfaceC2268i f12707a;

        public a(InterfaceC2268i interfaceC2268i) {
            this.f12707a = interfaceC2268i;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2268i
        /* renamed from: d */
        public int mo14611d() {
            return this.f12707a.mo14611d();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2268i
        /* renamed from: b */
        public Iterable<? extends InterfaceC2218f> mo14608b() {
            return C2376q.m15062a((InterfaceC2374o) C2370k.this.f12706a.mo15037f(), (Iterable) this.f12707a.mo14608b());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2268i
        /* renamed from: e */
        public List<? extends InterfaceC2271l<? extends InterfaceC2265f>> mo14612e() {
            return C2376q.m15064a((InterfaceC2374o) C2370k.this.f12706a.mo15038g(), (List) this.f12707a.mo14612e());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2268i
        /* renamed from: a */
        public Iterable<? extends InterfaceC2166a> mo14601a() {
            return C2376q.m15062a((InterfaceC2374o) C2370k.this.f12706a.mo15040i(), (Iterable) this.f12707a.mo14601a());
        }
    }
}
