package org.p226d.p233b.p262g;

import org.p226d.p233b.p238b.p239a.AbstractC1988b;
import org.p226d.p233b.p250e.p254c.InterfaceC2237b;

/* compiled from: FieldReferenceRewriter.java */
/* renamed from: org.d.b.g.h */
/* loaded from: classes.dex */
public class C2367h implements InterfaceC2374o<InterfaceC2237b> {

    /* renamed from: a */
    protected final InterfaceC2377r f12690a;

    public C2367h(InterfaceC2377r interfaceC2377r) {
        this.f12690a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2237b mo15030a(InterfaceC2237b interfaceC2237b) {
        return new a(interfaceC2237b);
    }

    /* compiled from: FieldReferenceRewriter.java */
    /* renamed from: org.d.b.g.h$a */
    protected class a extends AbstractC1988b {

        /* renamed from: a */
        protected InterfaceC2237b f12691a;

        public a(InterfaceC2237b interfaceC2237b) {
            this.f12691a = interfaceC2237b;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: d */
        public String mo14225d() {
            return C2367h.this.f12690a.mo15041j().mo15030a(this.f12691a.mo14225d());
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: e */
        public String mo14226e() {
            return this.f12691a.mo14226e();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
        /* renamed from: f */
        public String mo14227f() {
            return C2367h.this.f12690a.mo15041j().mo15030a(this.f12691a.mo14227f());
        }
    }
}
