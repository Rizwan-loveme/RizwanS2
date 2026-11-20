package org.p226d.p233b.p262g;

import java.util.Set;
import org.p226d.p233b.p238b.p239a.AbstractC1988b;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: FieldRewriter.java */
/* renamed from: org.d.b.g.i */
/* loaded from: classes.dex */
public class C2368i implements InterfaceC2374o<InterfaceC2266g> {

    /* renamed from: a */
    protected final InterfaceC2377r f12693a;

    public C2368i(InterfaceC2377r interfaceC2377r) {
        this.f12693a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2266g mo15030a(InterfaceC2266g interfaceC2266g) {
        return new a(interfaceC2266g);
    }

    /* compiled from: FieldRewriter.java */
    /* renamed from: org.d.b.g.i$a */
    protected class a extends AbstractC1988b implements InterfaceC2266g {

        /* renamed from: a */
        protected InterfaceC2266g f12694a;

        public a(InterfaceC2266g interfaceC2266g) {
            this.f12694a = interfaceC2266g;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: d */
        public String mo14225d() {
            return C2368i.this.f12693a.mo15042k().mo15030a(this.f12694a).mo14225d();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: e */
        public String mo14226e() {
            return C2368i.this.f12693a.mo15042k().mo15030a(this.f12694a).mo14226e();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: f */
        public String mo14227f() {
            return C2368i.this.f12693a.mo15042k().mo15030a(this.f12694a).mo14227f();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: a */
        public int mo14222a() {
            return this.f12694a.mo14222a();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: b */
        public InterfaceC2251g mo14223b() {
            return (InterfaceC2251g) C2376q.m15063a(C2368i.this.f12693a.mo15046o(), this.f12694a.mo14223b());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: c */
        public Set<? extends InterfaceC2165a> mo14224c() {
            return C2376q.m15065a((InterfaceC2374o) C2368i.this.f12693a.mo15044m(), (Set) this.f12694a.mo14224c());
        }
    }
}
