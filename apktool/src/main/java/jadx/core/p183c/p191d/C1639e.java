package jadx.core.p183c.p191d;

import jadx.core.p183c.p184a.p186b.AbstractC1577k;
import jadx.core.p183c.p187b.C1589a;
import jadx.core.p183c.p187b.C1592d;
import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import org.p226d.p233b.p250e.InterfaceC2266g;

/* compiled from: FieldNode.java */
/* renamed from: jadx.core.c.d.e */
/* loaded from: classes.dex */
public class C1639e extends AbstractC1577k {

    /* renamed from: a */
    private final C1636b f10362a;

    /* renamed from: b */
    private final C1592d f10363b;

    /* renamed from: c */
    private final C1589a f10364c;

    /* renamed from: d */
    private AbstractC1596a f10365d;

    public C1639e(C1636b c1636b, InterfaceC2266g interfaceC2266g) {
        this(c1636b, C1592d.m12224a(c1636b.mo12540t(), interfaceC2266g), interfaceC2266g.mo14222a());
    }

    public C1639e(C1636b c1636b, C1592d c1592d, int i) {
        this.f10362a = c1636b;
        this.f10363b = c1592d;
        this.f10365d = c1592d.m12227b();
        this.f10364c = new C1589a(i, C1589a.a.FIELD);
    }

    /* renamed from: f */
    public C1592d m12565f() {
        return this.f10363b;
    }

    /* renamed from: g */
    public C1589a m12566g() {
        return this.f10364c;
    }

    /* renamed from: h */
    public String m12567h() {
        return this.f10363b.m12225a();
    }

    /* renamed from: i */
    public String m12568i() {
        return this.f10363b.m12229d();
    }

    /* renamed from: j */
    public AbstractC1596a m12569j() {
        return this.f10365d;
    }

    /* renamed from: a */
    public void m12564a(AbstractC1596a abstractC1596a) {
        this.f10365d = abstractC1596a;
    }

    /* renamed from: k */
    public C1636b m12570k() {
        return this.f10362a;
    }

    public int hashCode() {
        return this.f10363b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10363b.equals(((C1639e) obj).f10363b);
    }

    public String toString() {
        return this.f10363b.m12228c() + "." + this.f10363b.m12225a() + " :" + this.f10365d;
    }
}
