package jadx.core.p183c.p193e;

import jadx.core.p183c.p191d.InterfaceC1641g;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p196f.C1666c;
import jadx.core.p183c.p196f.C1668e;
import jadx.core.p203d.C1745n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TryCatchRegion.java */
/* renamed from: jadx.core.c.e.e */
/* loaded from: classes.dex */
public final class C1663e extends AbstractC1651a implements InterfaceC1641g {

    /* renamed from: a */
    private final InterfaceC1642h f10459a;

    /* renamed from: b */
    private Map<C1666c, InterfaceC1642h> f10460b;

    /* renamed from: c */
    private InterfaceC1642h f10461c;

    /* renamed from: d */
    private C1668e f10462d;

    public C1663e(InterfaceC1644j interfaceC1644j, InterfaceC1642h interfaceC1642h) {
        super(interfaceC1644j);
        this.f10460b = Collections.emptyMap();
        this.f10459a = interfaceC1642h;
    }

    /* renamed from: a */
    public void m12743a(C1668e c1668e) {
        this.f10462d = c1668e;
        this.f10460b = new LinkedHashMap(c1668e.m12776b());
        for (C1666c c1666c : c1668e.m12769a()) {
            InterfaceC1642h m12761f = c1666c.m12761f();
            if (m12761f != null) {
                if (c1666c.m12764i()) {
                    this.f10461c = m12761f;
                } else {
                    this.f10460b.put(c1666c, m12761f);
                }
            }
        }
    }

    /* renamed from: e */
    public InterfaceC1642h m12744e() {
        return this.f10459a;
    }

    /* renamed from: f */
    public Map<C1666c, InterfaceC1642h> m12745f() {
        return this.f10460b;
    }

    /* renamed from: g */
    public InterfaceC1642h m12746g() {
        return this.f10461c;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: d */
    public List<InterfaceC1642h> mo12575d() {
        ArrayList arrayList = new ArrayList(this.f10460b.size() + 2);
        arrayList.add(this.f10459a);
        arrayList.addAll(this.f10460b.values());
        if (this.f10461c != null) {
            arrayList.add(this.f10461c);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1641g
    /* renamed from: p_ */
    public List<InterfaceC1642h> mo12571p_() {
        return mo12575d();
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        return this.f10459a.mo12454r();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Try: ").append(this.f10459a);
        if (!this.f10460b.isEmpty()) {
            sb.append(" catches: ").append(C1745n.m13309a(this.f10460b.values()));
        }
        if (this.f10461c != null) {
            sb.append(" finally: ").append(this.f10461c);
        }
        return sb.toString();
    }
}
