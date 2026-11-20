package org.p226d.p233b.p244d;

import java.util.List;
import org.p226d.p233b.p238b.AbstractC2015e;
import org.p226d.p233b.p244d.p248d.AbstractC2137h;

/* compiled from: DexBackedTryBlock.java */
/* renamed from: org.d.b.d.m */
/* loaded from: classes.dex */
public class C2159m extends AbstractC2015e<AbstractC2154h> {

    /* renamed from: a */
    public final C2153g f12058a;

    /* renamed from: b */
    private final int f12059b;

    /* renamed from: c */
    private final int f12060c;

    public C2159m(C2153g c2153g, int i, int i2) {
        this.f12058a = c2153g;
        this.f12059b = i;
        this.f12060c = i2;
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: a */
    public int mo14514a() {
        return this.f12058a.m14615a(this.f12059b + 0);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: b */
    public int mo14515b() {
        return this.f12058a.m14617c(this.f12059b + 4);
    }

    @Override // org.p226d.p233b.p250e.InterfaceC2271l
    /* renamed from: c */
    public List<? extends AbstractC2154h> mo14516c() {
        C2161o m14783v = this.f12058a.m14783v(this.f12060c + this.f12058a.m14617c(this.f12059b + 6));
        int b2 = m14783v.m14637b();
        if (b2 > 0) {
            return new AbstractC2137h<C2160n>(this.f12058a, m14783v.m14635a(), b2) { // from class: org.d.b.d.m.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.p226d.p233b.p244d.p248d.AbstractC2137h
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public C2160n mo14725b(C2161o c2161o, int i) {
                    return new C2160n(c2161o);
                }
            };
        }
        final int i = (b2 * (-1)) + 1;
        return new AbstractC2137h<AbstractC2154h>(this.f12058a, m14783v.m14635a(), i) { // from class: org.d.b.d.m.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.p226d.p233b.p244d.p248d.AbstractC2137h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AbstractC2154h mo14725b(C2161o c2161o, int i2) {
                return i2 == i + (-1) ? new C2141e(c2161o) : new C2160n(c2161o);
            }
        };
    }
}
