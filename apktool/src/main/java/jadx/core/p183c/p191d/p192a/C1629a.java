package jadx.core.p183c.p191d.p192a;

import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p184a.p185a.C1563a;
import jadx.core.p183c.p184a.p185a.C1564b;
import jadx.core.p183c.p184a.p185a.C1565c;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1636b;
import jadx.core.p183c.p191d.C1637c;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p203d.p205b.C1725b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2175b;
import org.p226d.p233b.p250e.InterfaceC2235c;
import org.p226d.p233b.p250e.InterfaceC2244d;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.InterfaceC2267h;
import org.p226d.p233b.p250e.InterfaceC2269j;

/* compiled from: AnnotationsParser.java */
/* renamed from: jadx.core.c.d.a.a */
/* loaded from: classes.dex */
public class C1629a {

    /* renamed from: a */
    private static final C1563a.a[] f10309a = {C1563a.a.BUILD, C1563a.a.RUNTIME, C1563a.a.SYSTEM};

    /* renamed from: b */
    private final C1637c f10310b;

    /* renamed from: c */
    private final C1636b f10311c;

    public C1629a(C1636b c1636b) {
        this.f10311c = c1636b;
        this.f10310b = c1636b.mo12540t();
    }

    /* renamed from: a */
    public void m12457a(InterfaceC2244d interfaceC2244d) {
        this.f10311c.mo12144a((InterfaceC1587g) m12456a(interfaceC2244d.mo14198e()));
        for (InterfaceC2266g interfaceC2266g : interfaceC2244d.mo14207n()) {
            this.f10311c.m12518a(interfaceC2266g).mo12144a(m12456a(interfaceC2266g.mo14224c()));
        }
        for (InterfaceC2267h interfaceC2267h : interfaceC2244d.mo14206m()) {
            C1648n m12520a = this.f10311c.m12520a(interfaceC2267h);
            m12520a.mo12144a(m12456a(interfaceC2267h.mo14215g()));
            List<? extends InterfaceC2269j> mo14213e = interfaceC2267h.mo14213e();
            C1565c c1565c = new C1565c(mo14213e.size());
            Iterator<? extends InterfaceC2269j> it = mo14213e.iterator();
            while (it.hasNext()) {
                c1565c.m12087a().add(m12456a(it.next().mo14219a()));
            }
            m12520a.mo12144a(c1565c);
        }
    }

    /* renamed from: a */
    private C1564b m12456a(Set<? extends InterfaceC2165a> set) {
        int size = set.size();
        if (size == 0) {
            return C1564b.f10024a;
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<? extends InterfaceC2165a> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(m12455a(this.f10310b, it.next(), true));
        }
        return new C1564b(arrayList);
    }

    /* renamed from: a */
    public static C1563a m12455a(C1637c c1637c, InterfaceC2235c interfaceC2235c, boolean z) {
        C1563a.a aVar;
        C1631c c1631c = new C1631c(c1637c);
        if (!z) {
            aVar = null;
        } else {
            aVar = f10309a[((InterfaceC2165a) interfaceC2235c).mo14671a()];
        }
        Set<? extends InterfaceC2175b> mo14673c = interfaceC2235c.mo14673c();
        LinkedHashMap linkedHashMap = new LinkedHashMap(mo14673c.size());
        for (InterfaceC2175b interfaceC2175b : mo14673c) {
            linkedHashMap.put(interfaceC2175b.mo14692a(), c1631c.m12467a(interfaceC2175b.mo14693b()));
        }
        AbstractC1596a m12547a = c1637c.m12547a(interfaceC2235c.mo14672b());
        C1563a c1563a = new C1563a(aVar, m12547a, linkedHashMap);
        if (!m12547a.mo12280f()) {
            throw new C1725b("Incorrect type for annotation: " + c1563a);
        }
        return c1563a;
    }
}
