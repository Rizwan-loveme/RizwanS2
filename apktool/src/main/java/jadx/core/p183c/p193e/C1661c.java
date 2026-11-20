package jadx.core.p183c.p193e;

import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.InterfaceC1641g;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SwitchRegion.java */
/* renamed from: jadx.core.c.e.c */
/* loaded from: classes.dex */
public final class C1661c extends AbstractC1651a implements InterfaceC1641g {

    /* renamed from: a */
    private final C1628a f10452a;

    /* renamed from: b */
    private final List<List<Object>> f10453b;

    /* renamed from: c */
    private final List<InterfaceC1642h> f10454c;

    /* renamed from: d */
    private InterfaceC1642h f10455d;

    public C1661c(InterfaceC1644j interfaceC1644j, C1628a c1628a) {
        super(interfaceC1644j);
        this.f10452a = c1628a;
        this.f10453b = new ArrayList();
        this.f10454c = new ArrayList();
    }

    /* renamed from: e */
    public C1628a m12736e() {
        return this.f10452a;
    }

    /* renamed from: a */
    public void m12735a(List<Object> list, InterfaceC1642h interfaceC1642h) {
        this.f10453b.add(list);
        this.f10454c.add(interfaceC1642h);
    }

    /* renamed from: a */
    public void m12734a(InterfaceC1642h interfaceC1642h) {
        this.f10455d = interfaceC1642h;
    }

    /* renamed from: f */
    public InterfaceC1642h m12737f() {
        return this.f10455d;
    }

    /* renamed from: g */
    public List<List<Object>> m12738g() {
        return this.f10453b;
    }

    /* renamed from: h */
    public List<InterfaceC1642h> m12739h() {
        return this.f10454c;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: d */
    public List<InterfaceC1642h> mo12575d() {
        ArrayList arrayList = new ArrayList(this.f10454c.size() + 2);
        arrayList.add(this.f10452a);
        arrayList.addAll(this.f10454c);
        if (this.f10455d != null) {
            arrayList.add(this.f10455d);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1641g
    /* renamed from: p_ */
    public List<InterfaceC1642h> mo12571p_() {
        ArrayList arrayList = new ArrayList(this.f10454c.size() + 1);
        arrayList.addAll(this.f10454c);
        arrayList.add(this.f10455d);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        return this.f10452a.mo12454r();
    }

    public String toString() {
        return "Switch: " + this.f10454c.size() + ", default: " + this.f10455d;
    }
}
