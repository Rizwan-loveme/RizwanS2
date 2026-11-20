package jadx.core.p183c.p184a;

import jadx.core.p183c.p184a.p185a.C1563a;
import java.util.List;

/* compiled from: AttrNode.java */
/* renamed from: jadx.core.c.a.d */
/* loaded from: classes.dex */
public abstract class AbstractC1584d implements InterfaceC1588h {

    /* renamed from: a */
    private static final C1585e f10086a = new C1586f();

    /* renamed from: b */
    private C1585e f10087b = f10086a;

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: a */
    public void mo12141a(EnumC1562a enumC1562a) {
        m12138e().m12156a(enumC1562a);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: a */
    public void mo12144a(InterfaceC1587g interfaceC1587g) {
        if (interfaceC1587g != null) {
            m12138e().m12159a(interfaceC1587g);
        }
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: a */
    public <T> void mo12142a(C1566b<C1583c<T>> c1566b, T t) {
        m12138e().m12157a(c1566b, t);
    }

    /* renamed from: a */
    public void m12143a(AbstractC1584d abstractC1584d) {
        C1585e c1585e = abstractC1584d.f10087b;
        if (!c1585e.mo12163b()) {
            m12138e().m12158a(c1585e);
        }
    }

    /* renamed from: e */
    private C1585e m12138e() {
        C1585e c1585e = this.f10087b;
        if (c1585e == f10086a) {
            C1585e c1585e2 = new C1585e();
            this.f10087b = c1585e2;
            return c1585e2;
        }
        return c1585e;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: b */
    public boolean mo12149b(EnumC1562a enumC1562a) {
        return this.f10087b.mo12164b(enumC1562a);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: a */
    public <T extends InterfaceC1587g> boolean mo12145a(C1566b<T> c1566b) {
        return this.f10087b.mo12160a(c1566b);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: b */
    public <T extends InterfaceC1587g> T mo12146b(C1566b<T> c1566b) {
        return (T) this.f10087b.mo12161b(c1566b);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: a */
    public C1563a mo12139a(String str) {
        return this.f10087b.mo12154a(str);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: c */
    public <T> List<T> mo12150c(C1566b<C1583c<T>> c1566b) {
        return this.f10087b.mo12165c(c1566b);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: c */
    public void mo12151c(EnumC1562a enumC1562a) {
        this.f10087b.mo12166c(enumC1562a);
    }

    /* renamed from: d */
    public <T extends InterfaceC1587g> void m12152d(C1566b<T> c1566b) {
        this.f10087b.mo12167d(c1566b);
    }

    /* renamed from: b */
    public void m12148b(InterfaceC1587g interfaceC1587g) {
        this.f10087b.mo12162b(interfaceC1587g);
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1588h
    /* renamed from: a */
    public List<String> mo12140a() {
        return this.f10087b.mo12155a();
    }

    /* renamed from: b */
    public String m12147b() {
        return this.f10087b.toString();
    }

    /* renamed from: o_ */
    public boolean m12153o_() {
        return this.f10087b.mo12163b();
    }
}
