package org.p226d.p233b.p262g;

import org.p226d.p233b.p238b.AbstractC1994b;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;

/* compiled from: AnnotationElementRewriter.java */
/* renamed from: org.d.b.g.a */
/* loaded from: classes.dex */
public class C2360a implements InterfaceC2374o<InterfaceC2175b> {

    /* renamed from: a */
    protected final InterfaceC2377r f12640a;

    public C2360a(InterfaceC2377r interfaceC2377r) {
        this.f12640a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2175b mo15030a(InterfaceC2175b interfaceC2175b) {
        return new a(interfaceC2175b);
    }

    /* compiled from: AnnotationElementRewriter.java */
    /* renamed from: org.d.b.g.a$a */
    protected class a extends AbstractC1994b {

        /* renamed from: b */
        protected InterfaceC2175b f12641b;

        public a(InterfaceC2175b interfaceC2175b) {
            this.f12641b = interfaceC2175b;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2175b
        /* renamed from: a */
        public String mo14692a() {
            return this.f12641b.mo14692a();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2175b
        /* renamed from: b */
        public InterfaceC2251g mo14693b() {
            return C2360a.this.f12640a.mo15046o().mo15030a(this.f12641b.mo14693b());
        }
    }
}
