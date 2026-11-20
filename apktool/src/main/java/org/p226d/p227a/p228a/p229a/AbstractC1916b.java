package org.p226d.p227a.p228a.p229a;

import org.p226d.p227a.p228a.AbstractC1944l;
import org.p226d.p227a.p228a.C1948p;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p251a.InterfaceC2167b;
import org.p226d.p233b.p250e.p251a.InterfaceC2169d;
import org.p226d.p233b.p250e.p251a.InterfaceC2172g;
import org.p226d.p233b.p250e.p251a.InterfaceC2173h;
import org.p226d.p233b.p250e.p251a.InterfaceC2174i;
import org.p226d.p269d.C2453g;

/* compiled from: DebugMethodItem.java */
/* renamed from: org.d.a.a.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1916b extends AbstractC1944l {

    /* renamed from: a */
    private final int f11269a;

    protected AbstractC1916b(int i, int i2) {
        super(i);
        this.f11269a = i2;
    }

    @Override // org.p226d.p227a.p228a.AbstractC1944l
    /* renamed from: a */
    public double mo14091a() {
        return this.f11269a;
    }

    /* renamed from: a */
    public static AbstractC1916b m14090a(C1948p c1948p, InterfaceC2166a interfaceC2166a) {
        int mo14461a = interfaceC2166a.mo14461a();
        switch (interfaceC2166a.mo14464f()) {
            case 3:
                return new C1923i(mo14461a, -1, c1948p, (InterfaceC2174i) interfaceC2166a);
            case 4:
            default:
                throw new C2453g("Invalid debug item type: %d", Integer.valueOf(interfaceC2166a.mo14464f()));
            case 5:
                return new C1917c(mo14461a, -1, c1948p, (InterfaceC2167b) interfaceC2166a);
            case 6:
                return new C1921g(mo14461a, -1, c1948p, (InterfaceC2172g) interfaceC2166a);
            case 7:
                return new C1918d(mo14461a, -4);
            case 8:
                return new C1915a(mo14461a, -4);
            case 9:
                return new C1922h(mo14461a, -3, (InterfaceC2173h) interfaceC2166a);
            case 10:
                return new C1919e(mo14461a, -2, (InterfaceC2169d) interfaceC2166a);
        }
    }
}
