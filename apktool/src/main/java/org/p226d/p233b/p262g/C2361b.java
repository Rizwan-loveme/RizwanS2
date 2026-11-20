package org.p226d.p233b.p262g;

import java.util.Set;
import org.p226d.p233b.p238b.AbstractC1986a;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2175b;

/* compiled from: AnnotationRewriter.java */
/* renamed from: org.d.b.g.b */
/* loaded from: classes.dex */
public class C2361b implements InterfaceC2374o<InterfaceC2165a> {

    /* renamed from: a */
    protected final InterfaceC2377r f12643a;

    public C2361b(InterfaceC2377r interfaceC2377r) {
        this.f12643a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2165a mo15030a(InterfaceC2165a interfaceC2165a) {
        return new a(interfaceC2165a);
    }

    /* compiled from: AnnotationRewriter.java */
    /* renamed from: org.d.b.g.b$a */
    protected class a extends AbstractC1986a {

        /* renamed from: b */
        protected InterfaceC2165a f12644b;

        public a(InterfaceC2165a interfaceC2165a) {
            this.f12644b = interfaceC2165a;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2165a
        /* renamed from: a */
        public int mo14671a() {
            return this.f12644b.mo14671a();
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2165a, org.p226d.p233b.p250e.InterfaceC2235c
        /* renamed from: b */
        public String mo14672b() {
            return C2361b.this.f12643a.mo15041j().mo15030a(this.f12644b.mo14672b());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2165a, org.p226d.p233b.p250e.InterfaceC2235c
        /* renamed from: c */
        public Set<? extends InterfaceC2175b> mo14673c() {
            return C2376q.m15065a((InterfaceC2374o) C2361b.this.f12643a.mo15045n(), (Set) this.f12644b.mo14673c());
        }
    }
}
