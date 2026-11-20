package org.p226d.p233b.p262g;

import java.util.List;
import org.p226d.p233b.p238b.AbstractC2015e;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2271l;

/* compiled from: TryBlockRewriter.java */
/* renamed from: org.d.b.g.s */
/* loaded from: classes.dex */
public class C2378s implements InterfaceC2374o<InterfaceC2271l<? extends InterfaceC2265f>> {

    /* renamed from: a */
    protected final InterfaceC2377r f12731a;

    public C2378s(InterfaceC2377r interfaceC2377r) {
        this.f12731a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2271l<? extends InterfaceC2265f> mo15030a(InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l) {
        return new a(interfaceC2271l);
    }

    /* compiled from: TryBlockRewriter.java */
    /* renamed from: org.d.b.g.s$a */
    protected class a extends AbstractC2015e<InterfaceC2265f> {

        /* renamed from: a */
        protected InterfaceC2271l<? extends InterfaceC2265f> f12732a;

        public a(InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l) {
            this.f12732a = interfaceC2271l;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2271l
        /* renamed from: a */
        public int mo14514a() {
            return this.f12732a.mo14514a();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2271l
        /* renamed from: b */
        public int mo14515b() {
            return this.f12732a.mo14515b();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2271l
        /* renamed from: c */
        public List<? extends InterfaceC2265f> mo14516c() {
            return C2376q.m15064a((InterfaceC2374o) C2378s.this.f12731a.mo15039h(), (List) this.f12732a.mo14516c());
        }
    }
}
