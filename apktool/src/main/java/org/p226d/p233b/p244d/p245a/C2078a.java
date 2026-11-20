package org.p226d.p233b.p244d.p245a;

import java.util.List;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p244d.p248d.AbstractC2133d;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a;
import org.p226d.p269d.C2453g;

/* compiled from: DexBackedArrayPayload.java */
/* renamed from: org.d.b.d.a.a */
/* loaded from: classes.dex */
public class C2078a extends AbstractC2091b implements InterfaceC2177a {

    /* renamed from: a */
    public static final EnumC2272f f11803a = EnumC2272f.ARRAY_PAYLOAD;

    /* renamed from: b */
    public final int f11804b;

    /* renamed from: c */
    public final int f11805c;

    public C2078a(C2153g c2153g, int i) {
        super(c2153g, f11803a, i);
        this.f11804b = c2153g.m14617c(i + 2);
        this.f11805c = c2153g.m14615a(i + 4);
        if (this.f11804b * this.f11805c > 2147483647L) {
            throw new C2453g("Invalid array-payload instruction: element width*count overflows", new Object[0]);
        }
    }

    @Override // org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a
    /* renamed from: e */
    public int mo14479e() {
        return this.f11804b;
    }

    @Override // org.p226d.p233b.p250e.p252b.p253a.InterfaceC2177a
    /* renamed from: f */
    public List<Number> mo14480f() {
        final int i = this.f11826f + 8;
        switch (this.f11804b) {
            case 1:
                return new a() { // from class: org.d.b.d.a.a.1
                    @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Number mo14625b(int i2) {
                        return Integer.valueOf(C2078a.this.f11824d.m14623i(i + i2));
                    }
                };
            case 2:
                return new a() { // from class: org.d.b.d.a.a.2
                    @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Number mo14625b(int i2) {
                        return Integer.valueOf(C2078a.this.f11824d.m14622h(i + (i2 * 2)));
                    }
                };
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new C2453g("Invalid element width: %d", Integer.valueOf(this.f11804b));
            case 4:
                return new a() { // from class: org.d.b.d.a.a.3
                    @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Number mo14625b(int i2) {
                        return Integer.valueOf(C2078a.this.f11824d.m14621g(i + (i2 * 4)));
                    }
                };
            case 8:
                return new a() { // from class: org.d.b.d.a.a.4
                    @Override // org.p226d.p233b.p244d.p248d.AbstractC2133d
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Number mo14625b(int i2) {
                        return Long.valueOf(C2078a.this.f11824d.m14619e(i + (i2 * 8)));
                    }
                };
        }
    }

    /* compiled from: DexBackedArrayPayload.java */
    /* renamed from: org.d.b.d.a.a$a */
    abstract class a extends AbstractC2133d<Number> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C2078a.this.f11805c;
        }
    }

    @Override // org.p226d.p233b.p244d.p245a.AbstractC2091b, org.p226d.p233b.p250e.p252b.InterfaceC2218f
    /* renamed from: b */
    public int mo14417b() {
        return (((this.f11804b * this.f11805c) + 1) / 2) + 4;
    }
}
