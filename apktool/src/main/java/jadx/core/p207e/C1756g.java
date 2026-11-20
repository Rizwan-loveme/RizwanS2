package jadx.core.p207e;

import jadx.core.p207e.p208a.C1750d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceStorage.java */
/* renamed from: jadx.core.e.g */
/* loaded from: classes.dex */
public class C1756g {

    /* renamed from: c */
    private String f10662c;

    /* renamed from: b */
    private final List<C1750d> f10661b = new ArrayList();

    /* renamed from: a */
    Comparator<C1750d> f10660a = new Comparator<C1750d>() { // from class: jadx.core.e.g.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1750d c1750d, C1750d c1750d2) {
            return c1750d.m13332a() - c1750d2.m13332a();
        }
    };

    /* renamed from: a */
    public Collection<C1750d> m13380a() {
        return this.f10661b;
    }

    /* renamed from: a */
    public void m13381a(C1750d c1750d) {
        this.f10661b.add(c1750d);
    }

    /* renamed from: b */
    public void m13383b() {
        Collections.sort(this.f10661b, this.f10660a);
    }

    /* renamed from: c */
    public String m13384c() {
        return this.f10662c;
    }

    /* renamed from: a */
    public void m13382a(String str) {
        this.f10662c = str;
    }

    /* renamed from: d */
    public Map<Integer, String> m13385d() {
        HashMap hashMap = new HashMap();
        for (C1750d c1750d : this.f10661b) {
            hashMap.put(Integer.valueOf(c1750d.m13332a()), String.valueOf(c1750d.m13337b()) + "/" + c1750d.m13338c());
        }
        return hashMap;
    }
}
