package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.List;
import org.p226d.p233b.p238b.AbstractC2015e;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p269d.AbstractC2455i;

/* compiled from: ImmutableTryBlock.java */
/* renamed from: org.d.b.f.j */
/* loaded from: classes.dex */
public class C2358j extends AbstractC2015e<C2333e> {

    /* renamed from: d */
    private static final AbstractC2455i<C2358j, InterfaceC2271l<? extends InterfaceC2265f>> f12631d = new AbstractC2455i<C2358j, InterfaceC2271l<? extends InterfaceC2265f>>() { // from class: org.d.b.f.j.1
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b */
        protected /* synthetic */ boolean mo14890b(InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l) {
            return a2((InterfaceC2271l) interfaceC2271l);
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        protected boolean a2(InterfaceC2271l interfaceC2271l) {
            return interfaceC2271l instanceof C2358j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2358j mo14889a(InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l) {
            return C2358j.m15020a(interfaceC2271l);
        }
    };

    /* renamed from: a */
    protected final int f12632a;

    /* renamed from: b */
    protected final int f12633b;

    /* renamed from: c */
    protected final AbstractC1208w<? extends C2333e> f12634c;

    public C2358j(int i, int i2, List<? extends InterfaceC2265f> list) {
        this.f12632a = i;
        this.f12633b = i2;
        this.f12634c = C2333e.m14973a(list);
    }

    /* renamed from: a */
    public static C2358j m15020a(InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l) {
        if (interfaceC2271l instanceof C2358j) {
            return (C2358j) interfaceC2271l;
        }
        return new C2358j(interfaceC2271l.mo14514a(), interfaceC2271l.mo14515b(), interfaceC2271l.mo14516c());
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: a */
    public int mo14514a() {
        return this.f12632a;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: b */
    public int mo14515b() {
        return this.f12633b;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC1208w<? extends C2333e> mo14516c() {
        return this.f12634c;
    }

    /* renamed from: a */
    public static AbstractC1208w<C2358j> m15019a(List<? extends InterfaceC2271l<? extends InterfaceC2265f>> list) {
        return f12631d.m15525a(list);
    }
}
