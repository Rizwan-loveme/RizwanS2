package jadx.core.p183c.p184a;

import jadx.core.p183c.p184a.p185a.C1563a;
import jadx.core.p183c.p184a.p185a.C1564b;
import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: AttributeStorage.java */
/* renamed from: jadx.core.c.a.e */
/* loaded from: classes.dex */
public class C1585e {

    /* renamed from: a */
    private final Set<EnumC1562a> f10088a = EnumSet.noneOf(EnumC1562a.class);

    /* renamed from: b */
    private final Map<C1566b<?>, InterfaceC1587g> f10089b = new IdentityHashMap();

    /* renamed from: a */
    public void m12156a(EnumC1562a enumC1562a) {
        this.f10088a.add(enumC1562a);
    }

    /* renamed from: a */
    public void m12159a(InterfaceC1587g interfaceC1587g) {
        this.f10089b.put(interfaceC1587g.mo12085b(), interfaceC1587g);
    }

    /* renamed from: a */
    public <T> void m12157a(C1566b<C1583c<T>> c1566b, T t) {
        C1583c c1583c = (C1583c) mo12161b(c1566b);
        if (c1583c == null) {
            c1583c = new C1583c(c1566b);
            m12159a(c1583c);
        }
        c1583c.m12137a().add(t);
    }

    /* renamed from: a */
    public void m12158a(C1585e c1585e) {
        this.f10088a.addAll(c1585e.f10088a);
        this.f10089b.putAll(c1585e.f10089b);
    }

    /* renamed from: b */
    public boolean mo12164b(EnumC1562a enumC1562a) {
        return this.f10088a.contains(enumC1562a);
    }

    /* renamed from: a */
    public <T extends InterfaceC1587g> boolean mo12160a(C1566b<T> c1566b) {
        return this.f10089b.containsKey(c1566b);
    }

    /* renamed from: b */
    public <T extends InterfaceC1587g> T mo12161b(C1566b<T> c1566b) {
        return (T) this.f10089b.get(c1566b);
    }

    /* renamed from: a */
    public C1563a mo12154a(String str) {
        C1564b c1564b = (C1564b) mo12161b(C1566b.f10042p);
        if (c1564b == null) {
            return null;
        }
        return c1564b.m12083a(str);
    }

    /* renamed from: c */
    public <T> List<T> mo12165c(C1566b<C1583c<T>> c1566b) {
        C1583c c1583c = (C1583c) mo12161b(c1566b);
        return c1583c == null ? Collections.emptyList() : Collections.unmodifiableList(c1583c.m12137a());
    }

    /* renamed from: c */
    public void mo12166c(EnumC1562a enumC1562a) {
        this.f10088a.remove(enumC1562a);
    }

    /* renamed from: d */
    public <T extends InterfaceC1587g> void mo12167d(C1566b<T> c1566b) {
        this.f10089b.remove(c1566b);
    }

    /* renamed from: b */
    public void mo12162b(InterfaceC1587g interfaceC1587g) {
        C1566b mo12085b = interfaceC1587g.mo12085b();
        if (this.f10089b.get(mo12085b) == interfaceC1587g) {
            this.f10089b.remove(mo12085b);
        }
    }

    /* renamed from: a */
    public List<String> mo12155a() {
        int size = this.f10088a.size() + this.f10089b.size() + this.f10089b.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<EnumC1562a> it = this.f10088a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        Iterator<InterfaceC1587g> it2 = this.f10089b.values().iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toString());
        }
        return arrayList;
    }

    /* renamed from: b */
    public boolean mo12163b() {
        return this.f10088a.isEmpty() && this.f10089b.isEmpty();
    }

    public String toString() {
        List<String> mo12155a = mo12155a();
        return mo12155a.isEmpty() ? "" : "A:{" + C1745n.m13309a((Iterable) mo12155a) + "}";
    }
}
