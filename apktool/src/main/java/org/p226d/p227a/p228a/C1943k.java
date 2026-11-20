package org.p226d.p227a.p228a;

import android.widget.ExpandableListView;
import com.p129f.p130a.p133c.AbstractC1185bk;
import com.p129f.p130a.p133c.AbstractC1208w;
import com.p129f.p130a.p133c.C1156ai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p227a.C1950b;
import org.p226d.p227a.p228a.p229a.AbstractC1916b;
import org.p226d.p227a.p228a.p231c.C1931c;
import org.p226d.p233b.EnumC1959a;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;
import org.p226d.p233b.p234a.C1960a;
import org.p226d.p233b.p234a.C1966b;
import org.p226d.p233b.p234a.C1976k;
import org.p226d.p233b.p244d.C2153g;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2265f;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2268i;
import org.p226d.p233b.p250e.InterfaceC2269j;
import org.p226d.p233b.p250e.InterfaceC2271l;
import org.p226d.p233b.p250e.p251a.InterfaceC2166a;
import org.p226d.p233b.p250e.p252b.InterfaceC2218f;
import org.p226d.p233b.p250e.p252b.InterfaceC2222j;
import org.p226d.p233b.p250e.p252b.InterfaceC2225m;
import org.p226d.p233b.p250e.p252b.p253a.InterfaceC2211x;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;
import org.p226d.p233b.p256f.p258b.C2318y;
import org.p226d.p233b.p263h.C2385e;
import org.p226d.p233b.p263h.C2389i;
import org.p226d.p233b.p263h.C2391k;
import org.p226d.p233b.p263h.C2392l;
import org.p226d.p269d.C2453g;
import org.p226d.p269d.C2457k;
import org.p226d.p269d.C2463q;

/* compiled from: MethodDefinition.java */
/* renamed from: org.d.a.a.k */
/* loaded from: classes.dex */
public class C1943k {

    /* renamed from: a */
    public final C1936d f11328a;

    /* renamed from: b */
    public final InterfaceC2267h f11329b;

    /* renamed from: c */
    public final InterfaceC2268i f11330c;

    /* renamed from: d */
    public final AbstractC1208w<InterfaceC2218f> f11331d;

    /* renamed from: e */
    public final List<InterfaceC2218f> f11332e;

    /* renamed from: f */
    public final AbstractC1208w<InterfaceC2269j> f11333f;

    /* renamed from: g */
    public C1948p f11334g;

    /* renamed from: h */
    private final b f11335h = new b();

    /* renamed from: i */
    private final C2463q f11336i;

    /* renamed from: j */
    private final C2463q f11337j;

    /* renamed from: k */
    private final C2385e f11338k;

    public C1943k(C1936d c1936d, InterfaceC2267h interfaceC2267h, InterfaceC2268i interfaceC2268i) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        this.f11328a = c1936d;
        this.f11329b = interfaceC2267h;
        this.f11330c = interfaceC2268i;
        try {
            this.f11331d = AbstractC1208w.m10129a((Iterable) interfaceC2268i.mo14608b());
            this.f11333f = AbstractC1208w.m10132a((Collection) interfaceC2267h.mo14213e());
            this.f11332e = C1156ai.m9910a((Iterable) this.f11331d);
            this.f11336i = new C2463q(0);
            this.f11337j = new C2463q(0);
            this.f11338k = new C2385e(this.f11331d);
            int m15084b = this.f11338k.m15084b(this.f11331d.size() - 1) + this.f11331d.get(this.f11331d.size() - 1).mo14417b();
            for (int i3 = 0; i3 < this.f11331d.size(); i3++) {
                InterfaceC2218f interfaceC2218f = this.f11331d.get(i3);
                EnumC2272f mo14416a = interfaceC2218f.mo14416a();
                if (mo14416a == EnumC2272f.PACKED_SWITCH) {
                    int m15084b2 = this.f11338k.m15084b(i3);
                    int mo14507e = ((InterfaceC2222j) interfaceC2218f).mo14507e() + m15084b2;
                    try {
                        mo14507e = m14158b(mo14507e, EnumC2272f.PACKED_SWITCH_PAYLOAD);
                        z2 = true;
                    } catch (a e2) {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.f11336i.m15556a(mo14507e, -1) != -1) {
                            InterfaceC2218f m14155a = m14155a(mo14507e, EnumC2272f.PACKED_SWITCH_PAYLOAD);
                            this.f11332e.set(i3, new C2318y(mo14416a, ((InterfaceC2211x) interfaceC2218f).mo14495q_(), m15084b - m15084b2));
                            this.f11332e.add(m14155a);
                            i2 = m14155a.mo14417b() + m15084b;
                            mo14507e = m15084b;
                        } else {
                            i2 = m15084b;
                        }
                        this.f11336i.m15558c(mo14507e, m15084b2);
                    } else {
                        i2 = m15084b;
                    }
                    m15084b = i2;
                } else if (mo14416a == EnumC2272f.SPARSE_SWITCH) {
                    int m15084b3 = this.f11338k.m15084b(i3);
                    int mo14507e2 = ((InterfaceC2222j) interfaceC2218f).mo14507e() + m15084b3;
                    try {
                        mo14507e2 = m14158b(mo14507e2, EnumC2272f.SPARSE_SWITCH_PAYLOAD);
                        z = true;
                    } catch (a e3) {
                        z = false;
                    }
                    if (z) {
                        if (this.f11337j.m15556a(mo14507e2, -1) != -1) {
                            InterfaceC2218f m14155a2 = m14155a(mo14507e2, EnumC2272f.SPARSE_SWITCH_PAYLOAD);
                            this.f11332e.set(i3, new C2318y(mo14416a, ((InterfaceC2211x) interfaceC2218f).mo14495q_(), m15084b - m15084b3));
                            this.f11332e.add(m14155a2);
                            i = m14155a2.mo14417b() + m15084b;
                            mo14507e2 = m15084b;
                        } else {
                            i = m15084b;
                        }
                        this.f11337j.m15558c(mo14507e2, m15084b3);
                        m15084b = i;
                    }
                }
            }
        } catch (Exception e4) {
            try {
                throw C2453g.m15520a(e4, "Error while processing method %s", C2389i.m15120a((InterfaceC2240e) interfaceC2267h));
            } catch (Exception e5) {
                throw C2453g.m15520a(e4, "Error while processing method", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m14146a(C2457k c2457k, InterfaceC2267h interfaceC2267h, C1950b c1950b) {
        c2457k.write(".method ");
        m14144a(c2457k, interfaceC2267h.mo14214f());
        c2457k.write(interfaceC2267h.mo14210b());
        c2457k.write("(");
        AbstractC1208w m10132a = AbstractC1208w.m10132a((Collection) interfaceC2267h.mo14213e());
        AbstractC1185bk it = m10132a.iterator();
        while (it.hasNext()) {
            c2457k.write(((InterfaceC2269j) it.next()).mo14465l());
        }
        c2457k.write(")");
        c2457k.write(interfaceC2267h.mo14212d());
        c2457k.write(10);
        c2457k.m15532a(4);
        m14145a(c2457k, interfaceC2267h, m10132a, c1950b);
        String str = null;
        if (c1950b.f11364j) {
            str = interfaceC2267h.mo14209a();
        }
        C1914a.m14087a(c2457k, interfaceC2267h.mo14215g(), str);
        c2457k.m15534b(4);
        c2457k.write(".end method\n");
    }

    /* renamed from: a */
    public void m14156a(C2457k c2457k) {
        int i;
        int i2 = 0;
        if (!EnumC1959a.STATIC.m14192a(this.f11329b.mo14214f())) {
            i2 = 1;
        }
        c2457k.write(".method ");
        m14144a(c2457k, this.f11329b.mo14214f());
        c2457k.write(this.f11329b.mo14210b());
        c2457k.write("(");
        AbstractC1185bk<InterfaceC2269j> it = this.f11333f.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            String mo14465l = it.next().mo14465l();
            c2457k.write(mo14465l);
            i2 = i + 1;
            if (C2392l.m15146a(mo14465l)) {
                i2++;
            }
        }
        c2457k.write(")");
        c2457k.write(this.f11329b.mo14212d());
        c2457k.write(10);
        c2457k.m15532a(4);
        if (this.f11328a.f11317a.f11357c) {
            c2457k.write(".locals ");
            c2457k.m15536c(this.f11330c.mo14611d() - i);
        } else {
            c2457k.write(".registers ");
            c2457k.m15536c(this.f11330c.mo14611d());
        }
        c2457k.write(10);
        m14145a(c2457k, this.f11329b, this.f11333f, this.f11328a.f11317a);
        if (this.f11334g == null) {
            this.f11334g = new C1948p(this.f11328a.f11317a, this.f11330c.mo14611d(), i);
        }
        String str = null;
        if (this.f11328a.f11317a.f11364j) {
            str = this.f11329b.mo14209a();
        }
        C1914a.m14087a(c2457k, this.f11329b.mo14215g(), str);
        c2457k.write(10);
        Iterator<AbstractC1944l> it2 = m14147b().iterator();
        while (it2.hasNext()) {
            if (it2.next().mo14089a(c2457k)) {
                c2457k.write(10);
            }
        }
        c2457k.m15534b(4);
        c2457k.write(".end method\n");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        if (r0.mo14416a() == r5) goto L11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InterfaceC2218f m14155a(int i, EnumC2272f enumC2272f) {
        int i2;
        try {
            int m15082a = this.f11338k.m15082a(i);
            InterfaceC2218f interfaceC2218f = this.f11331d.get(m15082a);
            if (interfaceC2218f.mo14416a() != enumC2272f) {
                if (interfaceC2218f.mo14416a() == EnumC2272f.NOP && (i2 = m15082a + 1) < this.f11331d.size()) {
                    interfaceC2218f = this.f11331d.get(i2);
                }
                throw new a(i);
            }
            return interfaceC2218f;
        } catch (C2385e.b e2) {
            throw new a(i);
        }
    }

    /* renamed from: b */
    public int m14158b(int i, EnumC2272f enumC2272f) {
        int i2;
        try {
            int m15082a = this.f11338k.m15082a(i);
            InterfaceC2218f interfaceC2218f = this.f11331d.get(m15082a);
            if (interfaceC2218f.mo14416a() != enumC2272f) {
                if (interfaceC2218f.mo14416a() == EnumC2272f.NOP && (i2 = m15082a + 1) < this.f11331d.size() && this.f11331d.get(i2).mo14416a() == enumC2272f) {
                    return this.f11338k.m15084b(i2);
                }
                throw new a(i);
            }
            return i;
        } catch (C2385e.b e2) {
            throw new a(i);
        }
    }

    /* renamed from: a */
    private static void m14144a(C2457k c2457k, int i) {
        for (EnumC1959a enumC1959a : EnumC1959a.m14187d(i)) {
            c2457k.write(enumC1959a.toString());
            c2457k.write(32);
        }
    }

    /* renamed from: a */
    private static void m14145a(C2457k c2457k, InterfaceC2267h interfaceC2267h, List<? extends InterfaceC2269j> list, C1950b c1950b) {
        int i = EnumC1959a.STATIC.m14192a(interfaceC2267h.mo14214f()) ? 0 : 1;
        Iterator<? extends InterfaceC2269j> it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                InterfaceC2269j next = it.next();
                String mo14465l = next.mo14465l();
                String mo14220b = next.mo14220b();
                Set<? extends InterfaceC2165a> mo14219a = next.mo14219a();
                if ((c1950b.f11359e && mo14220b != null) || mo14219a.size() != 0) {
                    c2457k.write(".param p");
                    c2457k.m15536c(i2);
                    if (mo14220b != null && c1950b.f11359e) {
                        c2457k.write(", ");
                        C1947o.m14170a(c2457k, mo14220b);
                    }
                    c2457k.write("    # ");
                    c2457k.write(mo14465l);
                    c2457k.write("\n");
                    if (mo14219a.size() > 0) {
                        c2457k.m15532a(4);
                        String str = null;
                        if (c1950b.f11364j) {
                            str = interfaceC2267h.mo14209a();
                        }
                        C1914a.m14087a(c2457k, mo14219a, str);
                        c2457k.m15534b(4);
                        c2457k.write(".end param\n");
                    }
                }
                i = i2 + 1;
                if (C2392l.m15146a(mo14465l)) {
                    i++;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public b m14154a() {
        return this.f11335h;
    }

    /* renamed from: a */
    public int m14153a(int i) {
        return this.f11336i.m15556a(i, -1);
    }

    /* renamed from: b */
    public int m14157b(int i) {
        return this.f11337j.m15556a(i, -1);
    }

    /* renamed from: b */
    private List<AbstractC1944l> m14147b() {
        ArrayList arrayList = new ArrayList();
        if (this.f11328a.f11317a.f11366l != 0 || this.f11328a.f11317a.f11365k || (this.f11328a.f11317a.f11363i && m14150c())) {
            m14148b(arrayList);
        } else {
            m14143a(arrayList);
        }
        m14149c(arrayList);
        if (this.f11328a.f11317a.f11359e) {
            m14152d(arrayList);
        }
        if (this.f11328a.f11317a.f11358d) {
            m14151d();
        }
        Iterator<C1942j> it = this.f11335h.m14159a().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: c */
    private boolean m14150c() {
        Iterator<? extends InterfaceC2218f> it = this.f11330c.mo14608b().iterator();
        while (it.hasNext()) {
            if (it.next().mo14416a().m14878b()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m14143a(List<AbstractC1944l> list) {
        InterfaceC2240e interfaceC2240e;
        C2391k.a m15145a;
        int i = 0;
        int i2 = 0;
        while (i < this.f11332e.size()) {
            InterfaceC2218f interfaceC2218f = this.f11332e.get(i);
            list.add(C1931c.m14118a(this, i2, interfaceC2218f));
            if (i != this.f11332e.size() - 1) {
                list.add(new C1924b(i2));
            }
            if (this.f11328a.f11317a.f11360f) {
                list.add(new AbstractC1944l(i2) { // from class: org.d.a.a.k.1
                    @Override // org.p226d.p227a.p228a.AbstractC1944l
                    /* renamed from: a */
                    public double mo14091a() {
                        return -1000.0d;
                    }

                    @Override // org.p226d.p227a.p228a.AbstractC1944l
                    /* renamed from: a */
                    public boolean mo14089a(C2457k c2457k) {
                        c2457k.write("#@");
                        c2457k.m15533a(this.f11343f & ExpandableListView.PACKED_POSITION_VALUE_NULL);
                        return true;
                    }
                });
            }
            if (this.f11328a.f11317a.f11361g && this.f11328a.f11317a.f11370p != null && (interfaceC2218f instanceof InterfaceC2225m) && interfaceC2218f.mo14416a().f12385eh == 3) {
                try {
                    interfaceC2240e = (InterfaceC2240e) ((InterfaceC2225m) interfaceC2218f).mo14489f();
                } catch (C2153g.a e2) {
                    interfaceC2240e = null;
                }
                if (interfaceC2240e != null && C2391k.m15143a(interfaceC2240e.mo14210b()) && (m15145a = this.f11328a.f11317a.f11370p.m15145a(interfaceC2240e)) != null) {
                    list.add(new C1949q(m15145a, i2));
                }
            }
            i++;
            i2 += interfaceC2218f.mo14417b();
        }
    }

    /* renamed from: b */
    private void m14148b(List<AbstractC1944l> list) {
        C1976k c1976k = new C1976k(this.f11328a.f11317a.f11369o, this.f11329b, this.f11328a.f11317a.f11368n, this.f11328a.f11317a.f11365k);
        C1960a m14397c = c1976k.m14397c();
        if (m14397c != null) {
            list.add(new C1937e(String.format("AnalysisException: %s", m14397c.getMessage()), m14397c.f11398a, -2.147483648E9d));
            m14397c.printStackTrace(System.err);
        }
        List<C1966b> m14396b = c1976k.m14396b();
        int i = 0;
        for (int i2 = 0; i2 < m14396b.size(); i2++) {
            C1966b c1966b = m14396b.get(i2);
            list.add(C1931c.m14118a(this, i, c1966b.m14247e()));
            if (c1966b.m14247e().mo14416a().f12386ei == EnumC2076d.UnresolvedOdexInstruction) {
                list.add(new C1938f(C1931c.m14118a(this, i, c1966b.m14248f())));
            }
            if (i2 != m14396b.size() - 1) {
                list.add(new C1924b(i));
            }
            if (this.f11328a.f11317a.f11360f) {
                list.add(new AbstractC1944l(i) { // from class: org.d.a.a.k.2
                    @Override // org.p226d.p227a.p228a.AbstractC1944l
                    /* renamed from: a */
                    public double mo14091a() {
                        return -1000.0d;
                    }

                    @Override // org.p226d.p227a.p228a.AbstractC1944l
                    /* renamed from: a */
                    public boolean mo14089a(C2457k c2457k) {
                        c2457k.write("#@");
                        c2457k.m15533a(this.f11343f & ExpandableListView.PACKED_POSITION_VALUE_NULL);
                        return true;
                    }
                });
            }
            if (this.f11328a.f11317a.f11366l != 0 && !c1966b.m14247e().mo14416a().f12386ei.f11800M) {
                list.add(new C1946n(this.f11328a.f11317a.f11366l, c1976k, this.f11334g, c1966b, i));
                list.add(new C1945m(this.f11334g, c1966b, i));
            }
            i += c1966b.m14247e().mo14417b();
        }
    }

    /* renamed from: c */
    private void m14149c(List<AbstractC1944l> list) {
        List<? extends InterfaceC2271l<? extends InterfaceC2265f>> mo14612e = this.f11330c.mo14612e();
        if (mo14612e.size() != 0) {
            int m15084b = this.f11338k.m15084b(this.f11331d.size() - 1) + this.f11331d.get(this.f11331d.size() - 1).mo14417b();
            for (InterfaceC2271l<? extends InterfaceC2265f> interfaceC2271l : mo14612e) {
                int mo14514a = interfaceC2271l.mo14514a();
                int mo14515b = mo14514a + interfaceC2271l.mo14515b();
                if (mo14514a >= m15084b) {
                    throw new RuntimeException(String.format("Try start offset %d is past the end of the code block.", Integer.valueOf(mo14514a)));
                }
                if (mo14515b > m15084b) {
                    throw new RuntimeException(String.format("Try end offset %d is past the end of the code block.", Integer.valueOf(mo14515b)));
                }
                int m15084b2 = this.f11338k.m15084b(this.f11338k.m15083a(mo14515b - 1, false));
                Iterator<? extends Object> it = interfaceC2271l.mo14516c().iterator();
                while (it.hasNext()) {
                    InterfaceC2265f interfaceC2265f = (InterfaceC2265f) it.next();
                    int mo14477c = interfaceC2265f.mo14477c();
                    if (mo14477c >= m15084b) {
                        throw new C2453g("Exception handler offset %d is past the end of the code block.", Integer.valueOf(mo14477c));
                    }
                    list.add(new C1928c(this.f11328a.f11317a, this.f11335h, m15084b2, interfaceC2265f.mo14476b(), mo14514a, mo14515b, mo14477c));
                }
            }
        }
    }

    /* renamed from: d */
    private void m14152d(List<AbstractC1944l> list) {
        Iterator<? extends InterfaceC2166a> it = this.f11330c.mo14601a().iterator();
        while (it.hasNext()) {
            list.add(AbstractC1916b.m14090a(this.f11334g, it.next()));
        }
    }

    /* renamed from: d */
    private void m14151d() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(this.f11335h.m14159a());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1942j c1942j = (C1942j) it.next();
            Integer num = (Integer) hashMap.get(c1942j.m14142c());
            if (num == null) {
                num = 0;
            }
            c1942j.m14141a(num.intValue());
            hashMap.put(c1942j.m14142c(), Integer.valueOf(num.intValue() + 1));
        }
    }

    /* compiled from: MethodDefinition.java */
    /* renamed from: org.d.a.a.k$b */
    public static class b {

        /* renamed from: a */
        protected HashMap<C1942j, C1942j> f11342a = new HashMap<>();

        /* renamed from: a */
        public C1942j m14160a(C1942j c1942j) {
            C1942j c1942j2 = this.f11342a.get(c1942j);
            if (c1942j2 == null) {
                this.f11342a.put(c1942j, c1942j);
                return c1942j;
            }
            return c1942j2;
        }

        /* renamed from: a */
        public Collection<C1942j> m14159a() {
            return this.f11342a.values();
        }
    }

    /* compiled from: MethodDefinition.java */
    /* renamed from: org.d.a.a.k$a */
    public static class a extends C2453g {

        /* renamed from: a */
        private final int f11341a;

        public a(int i) {
            super("No switch payload at offset: %d", Integer.valueOf(i));
            this.f11341a = i;
        }
    }
}
