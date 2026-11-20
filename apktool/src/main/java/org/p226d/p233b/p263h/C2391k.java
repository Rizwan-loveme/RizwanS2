package org.p226d.p233b.p263h;

import com.p129f.p130a.p133c.AbstractC1208w;
import java.util.Iterator;
import java.util.Map;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p250e.p254c.InterfaceC2241f;

/* compiled from: SyntheticAccessorResolver.java */
/* renamed from: org.d.b.h.k */
/* loaded from: classes.dex */
public class C2391k {

    /* renamed from: a */
    private final C2390j f12754a;

    /* renamed from: b */
    private final Map<String, InterfaceC2244d> f12755b;

    /* renamed from: c */
    private final Map<String, a> f12756c;

    /* renamed from: a */
    public static boolean m15143a(String str) {
        return str.startsWith("access$");
    }

    /* renamed from: a */
    public a m15145a(InterfaceC2240e interfaceC2240e) {
        InterfaceC2268i interfaceC2268i;
        InterfaceC2267h interfaceC2267h;
        AbstractC1208w m10129a;
        int m15142a;
        String m15120a = C2389i.m15120a(interfaceC2240e);
        a aVar = this.f12756c.get(m15120a);
        if (aVar == null) {
            InterfaceC2244d interfaceC2244d = this.f12755b.get(interfaceC2240e.mo14209a());
            if (interfaceC2244d == null) {
                return null;
            }
            Iterator<? extends InterfaceC2267h> it = interfaceC2244d.mo14206m().iterator();
            while (true) {
                if (!it.hasNext()) {
                    interfaceC2268i = null;
                    interfaceC2267h = null;
                    break;
                }
                interfaceC2267h = it.next();
                interfaceC2268i = interfaceC2267h.mo14216h();
                if (interfaceC2268i != null && m15144a(interfaceC2267h, interfaceC2240e)) {
                    break;
                }
            }
            if (interfaceC2267h != null && EnumC1959a.SYNTHETIC.m14192a(interfaceC2267h.mo14214f()) && (m15142a = this.f12754a.m15142a((m10129a = AbstractC1208w.m10129a((Iterable) interfaceC2268i.mo14608b())))) >= 0) {
                a aVar2 = new a(m15142a, ((InterfaceC2225m) m10129a.get(0)).mo14489f());
                this.f12756c.put(m15120a, aVar2);
                return aVar2;
            }
            return null;
        }
        return aVar;
    }

    /* compiled from: SyntheticAccessorResolver.java */
    /* renamed from: org.d.b.h.k$a */
    public static class a {

        /* renamed from: a */
        public final int f12757a;

        /* renamed from: b */
        public final InterfaceC2241f f12758b;

        public a(int i, InterfaceC2241f interfaceC2241f) {
            this.f12757a = i;
            this.f12758b = interfaceC2241f;
        }
    }

    /* renamed from: a */
    private static boolean m15144a(InterfaceC2240e interfaceC2240e, InterfaceC2240e interfaceC2240e2) {
        return interfaceC2240e.mo14210b().equals(interfaceC2240e2.mo14210b()) && interfaceC2240e.mo14212d().equals(interfaceC2240e2.mo14212d()) && interfaceC2240e.mo14211c().equals(interfaceC2240e2.mo14211c());
    }
}
