package org.p226d.p233b.p262g;

import org.p226d.p233b.p238b.AbstractC2013c;
import org.p226d.p233b.p250e.InterfaceC2265f;

/* compiled from: ExceptionHandlerRewriter.java */
/* renamed from: org.d.b.g.g */
/* loaded from: classes.dex */
public class C2366g implements InterfaceC2374o<InterfaceC2265f> {

    /* renamed from: a */
    protected final InterfaceC2377r f12687a;

    public C2366g(InterfaceC2377r interfaceC2377r) {
        this.f12687a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2265f mo15030a(InterfaceC2265f interfaceC2265f) {
        return new a(interfaceC2265f);
    }

    /* compiled from: ExceptionHandlerRewriter.java */
    /* renamed from: org.d.b.g.g$a */
    protected class a extends AbstractC2013c {

        /* renamed from: b */
        protected InterfaceC2265f f12688b;

        public a(InterfaceC2265f interfaceC2265f) {
            this.f12688b = interfaceC2265f;
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2265f
        /* renamed from: b */
        public String mo14476b() {
            return (String) C2376q.m15063a(C2366g.this.f12687a.mo15041j(), this.f12688b.mo14476b());
        }

        @Override // org.p226d.p233b.p250e.InterfaceC2265f
        /* renamed from: c */
        public int mo14477c() {
            return this.f12688b.mo14477c();
        }
    }
}
