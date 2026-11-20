package org.p226d.p233b.p262g;

import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p133c.C1156ai;
import java.util.List;
import org.p226d.p233b.p238b.p239a.AbstractC1991e;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;

/* compiled from: MethodReferenceRewriter.java */
/* renamed from: org.d.b.g.m */
/* loaded from: classes.dex */
public class C2372m implements InterfaceC2374o<InterfaceC2240e> {

    /* renamed from: a */
    protected final InterfaceC2377r f12712a;

    public C2372m(InterfaceC2377r interfaceC2377r) {
        this.f12712a = interfaceC2377r;
    }

    @Override // org.p226d.p233b.p262g.InterfaceC2374o
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public InterfaceC2240e mo15030a(InterfaceC2240e interfaceC2240e) {
        return new a(interfaceC2240e);
    }

    /* compiled from: MethodReferenceRewriter.java */
    /* renamed from: org.d.b.g.m$a */
    protected class a extends AbstractC1991e {

        /* renamed from: a */
        protected InterfaceC2240e f12713a;

        public a(InterfaceC2240e interfaceC2240e) {
            this.f12713a = interfaceC2240e;
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: a */
        public String mo14209a() {
            return C2372m.this.f12712a.mo15041j().mo15030a(this.f12713a.mo14209a());
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: b */
        public String mo14210b() {
            return this.f12713a.mo14210b();
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e
        /* renamed from: c */
        public List<? extends CharSequence> mo14211c() {
            return C2376q.m15064a((InterfaceC2374o) C2372m.this.f12712a.mo15041j(), C1156ai.m9914a((List) this.f12713a.mo14211c(), (InterfaceC1112g) new InterfaceC1112g<CharSequence, String>() { // from class: org.d.b.g.m.a.1
                @Override // com.p129f.p130a.p131a.InterfaceC1112g
                /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public String mo9517a(CharSequence charSequence) {
                    return charSequence.toString();
                }
            }));
        }

        @Override // org.p226d.p233b.p250e.p254c.InterfaceC2240e, org.p226d.p233b.p250e.InterfaceC2267h
        /* renamed from: d */
        public String mo14212d() {
            return C2372m.this.f12712a.mo15041j().mo15030a(this.f12713a.mo14212d());
        }
    }
}
