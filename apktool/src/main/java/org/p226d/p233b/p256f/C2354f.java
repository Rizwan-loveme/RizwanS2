package org.p226d.p233b.p256f;

import com.p129f.p130a.p133c.AbstractC1148aa;
import com.p129f.p130a.p133c.AbstractC1151ad;
import com.p129f.p130a.p133c.AbstractC1163ap;
import java.util.Collection;
import org.p226d.p233b.p238b.p239a.AbstractC1988b;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p256f.p261e.C2341h;
import org.p226d.p233b.p256f.p261e.InterfaceC2340g;
import org.p226d.p269d.AbstractC2455i;
import org.p226d.p269d.C2456j;

/* compiled from: ImmutableField.java */
/* renamed from: org.d.b.f.f */
/* loaded from: classes.dex */
public class C2354f extends AbstractC1988b implements InterfaceC2266g {

    /* renamed from: g */
    private static final AbstractC2455i<C2354f, InterfaceC2266g> f12608g = new AbstractC2455i<C2354f, InterfaceC2266g>() { // from class: org.d.b.f.f.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo14890b(InterfaceC2266g interfaceC2266g) {
            return interfaceC2266g instanceof C2354f;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.p226d.p269d.AbstractC2455i
        /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public C2354f mo14889a(InterfaceC2266g interfaceC2266g) {
            return C2354f.m15005a(interfaceC2266g);
        }
    };

    /* renamed from: a */
    protected final String f12609a;

    /* renamed from: b */
    protected final String f12610b;

    /* renamed from: c */
    protected final String f12611c;

    /* renamed from: d */
    protected final int f12612d;

    /* renamed from: e */
    protected final InterfaceC2340g f12613e;

    /* renamed from: f */
    protected final AbstractC1148aa<? extends C2273a> f12614f;

    public C2354f(String str, String str2, String str3, int i, InterfaceC2251g interfaceC2251g, Collection<? extends InterfaceC2165a> collection) {
        this.f12609a = str;
        this.f12610b = str2;
        this.f12611c = str3;
        this.f12612d = i;
        this.f12613e = C2341h.m14987b(interfaceC2251g);
        this.f12614f = C2273a.m14886a(collection);
    }

    public C2354f(String str, String str2, String str3, int i, InterfaceC2340g interfaceC2340g, AbstractC1148aa<? extends C2273a> abstractC1148aa) {
        this.f12609a = str;
        this.f12610b = str2;
        this.f12611c = str3;
        this.f12612d = i;
        this.f12613e = interfaceC2340g;
        this.f12614f = C2456j.m15527a(abstractC1148aa);
    }

    /* renamed from: a */
    public static C2354f m15005a(InterfaceC2266g interfaceC2266g) {
        if (interfaceC2266g instanceof C2354f) {
            return (C2354f) interfaceC2266g;
        }
        return new C2354f(interfaceC2266g.mo14225d(), interfaceC2266g.mo14226e(), interfaceC2266g.mo14227f(), interfaceC2266g.mo14222a(), interfaceC2266g.mo14223b(), interfaceC2266g.mo14224c());
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: d */
    public String mo14225d() {
        return this.f12609a;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: e */
    public String mo14226e() {
        return this.f12610b;
    }

    @Override // org.p226d.p233b.p250e.p254c.InterfaceC2237b, org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: f */
    public String mo14227f() {
        return this.f12611c;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: a */
    public int mo14222a() {
        return this.f12612d;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: b */
    public InterfaceC2251g mo14223b() {
        return this.f12613e;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2266g
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC1148aa<? extends C2273a> mo14224c() {
        return this.f12614f;
    }

    /* renamed from: a */
    public static AbstractC1151ad<C2354f> m15004a(Iterable<? extends InterfaceC2266g> iterable) {
        return f12608g.m15524a(AbstractC1163ap.m9957b(), iterable);
    }
}
