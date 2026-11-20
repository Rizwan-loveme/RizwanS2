package org.p276g.p283b;

import org.p276g.p277a.InterfaceC2532a;
import org.p276g.p277a.p278a.C2533a;
import org.p276g.p277a.p278a.C2534b;
import org.p276g.p277a.p278a.C2535c;
import org.p276g.p277a.p279b.C2536a;
import org.p276g.p277a.p280c.C2538a;
import org.p276g.p277a.p281d.C2539a;
import org.p276g.p277a.p282e.C2541b;
import org.p276g.p277a.p282e.C2542c;

/* compiled from: StdInstantiatorStrategy.java */
/* renamed from: org.g.b.d */
/* loaded from: classes.dex */
public class C2547d extends AbstractC2544a {
    @Override // org.p276g.p283b.InterfaceC2545b
    /* renamed from: a */
    public <T> InterfaceC2532a<T> mo15921a(Class<T> cls) {
        if (C2546c.m15924a("Java HotSpot") || C2546c.m15924a("OpenJDK")) {
            return new C2541b(cls);
        }
        if (C2546c.m15924a("BEA")) {
            if (C2546c.f13309b.startsWith("1.4") && !C2546c.f13311d.startsWith("R") && (C2546c.f13310c == null || !C2546c.f13310c.startsWith("R25.1") || !C2546c.f13310c.startsWith("R25.2"))) {
                return new C2538a(cls);
            }
            return new C2541b(cls);
        }
        if (C2546c.m15924a("Dalvik")) {
            if (C2546c.f13314g <= 10) {
                return new C2533a(cls);
            }
            if (C2546c.f13314g <= 17) {
                return new C2534b(cls);
            }
            return new C2535c(cls);
        }
        if (C2546c.m15924a("GNU libgcj")) {
            return new C2536a(cls);
        }
        if (C2546c.m15924a("PERC")) {
            return new C2539a(cls);
        }
        return new C2542c(cls);
    }
}
