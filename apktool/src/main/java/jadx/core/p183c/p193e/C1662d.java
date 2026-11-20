package jadx.core.p183c.p193e;

import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.InterfaceC1642h;
import jadx.core.p183c.p191d.InterfaceC1644j;
import java.util.LinkedList;
import java.util.List;

/* compiled from: SynchronizedRegion.java */
/* renamed from: jadx.core.c.e.d */
/* loaded from: classes.dex */
public final class C1662d extends AbstractC1651a {

    /* renamed from: a */
    private final C1646l f10456a;

    /* renamed from: b */
    private final List<C1646l> f10457b;

    /* renamed from: c */
    private final C1656b f10458c;

    public C1662d(InterfaceC1644j interfaceC1644j, C1646l c1646l) {
        super(interfaceC1644j);
        this.f10457b = new LinkedList();
        this.f10456a = c1646l;
        this.f10458c = new C1656b(this);
    }

    /* renamed from: e */
    public C1646l m12740e() {
        return this.f10456a;
    }

    /* renamed from: f */
    public List<C1646l> m12741f() {
        return this.f10457b;
    }

    /* renamed from: g */
    public C1656b m12742g() {
        return this.f10458c;
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1644j
    /* renamed from: d */
    public List<InterfaceC1642h> mo12575d() {
        return this.f10458c.mo12575d();
    }

    @Override // jadx.core.p183c.p191d.InterfaceC1642h
    /* renamed from: r */
    public String mo12454r() {
        return Integer.toHexString(this.f10456a.m12591s());
    }

    public String toString() {
        return "Synchronized:" + this.f10458c;
    }
}
