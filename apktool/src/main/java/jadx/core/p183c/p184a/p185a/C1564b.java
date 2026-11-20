package jadx.core.p183c.p184a.p185a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p203d.C1745n;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AnnotationsList.java */
/* renamed from: jadx.core.c.a.a.b */
/* loaded from: classes.dex */
public class C1564b implements InterfaceC1587g<C1564b> {

    /* renamed from: a */
    public static final C1564b f10024a = new C1564b(Collections.emptyList());

    /* renamed from: b */
    private final Map<String, C1563a> f10025b;

    public C1564b(List<C1563a> list) {
        this.f10025b = new HashMap(list.size());
        for (C1563a c1563a : list) {
            this.f10025b.put(c1563a.m12080b(), c1563a);
        }
    }

    /* renamed from: a */
    public C1563a m12083a(String str) {
        return this.f10025b.get(str);
    }

    /* renamed from: a */
    public Collection<C1563a> m12084a() {
        return this.f10025b.values();
    }

    /* renamed from: c */
    public boolean m12086c() {
        return this.f10025b.isEmpty();
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1564b> mo12085b() {
        return C1566b.f10042p;
    }

    public String toString() {
        return C1745n.m13309a(this.f10025b.values());
    }
}
