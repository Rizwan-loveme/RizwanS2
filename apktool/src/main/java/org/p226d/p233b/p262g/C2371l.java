package org.p226d.p233b.p262g;

import java.util.Set;
import org.p226d.p233b.p238b.AbstractC2014d;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2269j;

/* compiled from: MethodParameterRewriter.java */
/* renamed from: org.d.b.g.l */
/* loaded from: classes.dex */
public class C2371l implements InterfaceC2374o<InterfaceC2269j> {

    /* renamed from: a */
    protected final InterfaceC2377r f12709a;

    public C2371l(InterfaceC2377r interfaceC2377r) {
        this.f12709a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2269j mo15030a(InterfaceC2269j interfaceC2269j) {
        return new a(interfaceC2269j);
    }

    /* compiled from: MethodParameterRewriter.java */
    /* renamed from: org.d.b.g.l$a */
    protected class a extends AbstractC2014d {

        /* renamed from: a */
        protected InterfaceC2269j f12710a;

        public a(InterfaceC2269j interfaceC2269j) {
            this.f12710a = interfaceC2269j;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
        /* renamed from: l */
        public String mo14205l() {
            return C2371l.this.f12709a.mo15041j().mo15030a(this.f12710a.mo14465l());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2269j
        /* renamed from: a */
        public Set<? extends InterfaceC2165a> mo14219a() {
            return C2376q.m15065a((InterfaceC2374o) C2371l.this.f12709a.mo15044m(), (Set) this.f12710a.mo14219a());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
        /* renamed from: b */
        public String mo14220b() {
            return this.f12710a.mo14220b();
        }

        @Override // org.p226d.p233b.p238b.AbstractC2014d, org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
        /* renamed from: c */
        public String mo14452c() {
            return this.f12710a.mo14452c();
        }
    }
}
