package jadx.core.p183c.p193e.p194a;

import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.InterfaceC1641g;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p183c.p193e.AbstractC1651a;
import jadx.core.p203d.p205b.C1729f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: IfRegion.java */
/* renamed from: jadx.core.c.e.a.d */
/* loaded from: classes.dex */
public final class C1655d extends AbstractC1651a implements InterfaceC1641g {

    /* renamed from: a */
    private final C1628a f10435a;

    /* renamed from: b */
    private C1653b f10436b;

    /* renamed from: c */
    private InterfaceC1642h f10437c;

    /* renamed from: d */
    private InterfaceC1642h f10438d;

    public C1655d(InterfaceC1644j interfaceC1644j, C1628a c1628a) {
        super(interfaceC1644j);
        if (c1628a.mo12446j().size() != 1) {
            throw new C1729f("Expected only one instruction in 'if' header");
        }
        this.f10435a = c1628a;
        this.f10436b = C1653b.m12677a(c1628a);
    }

    /* renamed from: e */
    public C1653b m12708e() {
        return this.f10436b;
    }

    /* renamed from: a */
    public void m12706a(C1653b c1653b) {
        this.f10436b = c1653b;
    }

    /* renamed from: f */
    public InterfaceC1642h m12709f() {
        return this.f10437c;
    }

    /* renamed from: a */
    public void m12705a(InterfaceC1642h interfaceC1642h) {
        this.f10437c = interfaceC1642h;
    }

    /* renamed from: g */
    public InterfaceC1642h m12710g() {
        return this.f10438d;
    }

    /* renamed from: b */
    public void m12707b(InterfaceC1642h interfaceC1642h) {
        this.f10438d = interfaceC1642h;
    }

    /* renamed from: h */
    public C1628a m12711h() {
        return this.f10435a;
    }

    /* renamed from: i */
    public boolean m12712i() {
        C1653b m12683d = C1653b.m12683d(this.f10436b);
        if (m12683d == this.f10436b) {
            return false;
        }
        this.f10436b = m12683d;
        return true;
    }

    /* renamed from: j */
    public void m12713j() {
        this.f10436b = C1653b.m12681b(this.f10436b);
        InterfaceC1642h interfaceC1642h = this.f10437c;
        this.f10437c = this.f10438d;
        this.f10438d = interfaceC1642h;
    }

    /* renamed from: k */
    public int m12714k() {
        if (this.f10435a.mo12446j().isEmpty()) {
            return 0;
        }
        return this.f10435a.mo12446j().get(0).m12122d();
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: d */
    public List<InterfaceC1642h> mo12575d() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.f10435a);
        if (this.f10437c != null) {
            arrayList.add(this.f10437c);
        }
        if (this.f10438d != null) {
            arrayList.add(this.f10438d);
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1641g
    /* renamed from: p_ */
    public List<InterfaceC1642h> mo12571p_() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f10437c);
        arrayList.add(this.f10438d);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // jadx.core.p183c.p193e.AbstractC1651a, jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: a */
    public boolean mo12573a(InterfaceC1642h interfaceC1642h, InterfaceC1642h interfaceC1642h2) {
        if (interfaceC1642h == this.f10437c) {
            this.f10437c = interfaceC1642h2;
            m12669a(this.f10437c, (InterfaceC1644j) this);
            return true;
        }
        if (interfaceC1642h == this.f10438d) {
            this.f10438d = interfaceC1642h2;
            m12669a(this.f10438d, (InterfaceC1644j) this);
            return true;
        }
        return false;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        StringBuilder sb = new StringBuilder();
        if (this.f10437c != null) {
            sb.append(this.f10437c.mo12454r());
        }
        if (this.f10438d != null) {
            sb.append(this.f10438d.mo12454r());
        }
        return sb.toString();
    }

    public String toString() {
        return "IF " + this.f10435a + " then (" + this.f10437c + ") else (" + this.f10438d + ")";
    }
}
