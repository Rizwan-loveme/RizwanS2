package jadx.core.p183c.p187b;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import jadx.core.p183c.p191d.C1637c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.p226d.p233b.p250e.p254c.InterfaceC2240e;

/* compiled from: InfoStorage.java */
/* renamed from: jadx.core.c.b.e */
/* loaded from: classes.dex */
public class C1593e {

    /* renamed from: a */
    private final Map<AbstractC1596a, C1590b> f10114a = new HashMap();

    /* renamed from: b */
    private final Map<Long, C1594f> f10115b = new HashMap();

    /* renamed from: c */
    private final Map<C1592d, C1592d> f10116c = new HashMap();

    /* renamed from: a */
    public C1590b m12234a(AbstractC1596a abstractC1596a) {
        return this.f10114a.get(abstractC1596a);
    }

    /* renamed from: a */
    public C1590b m12233a(C1590b c1590b) {
        synchronized (this.f10114a) {
            C1590b put = this.f10114a.put(c1590b.m12211m(), c1590b);
            if (put != null) {
                c1590b = put;
            }
        }
        return c1590b;
    }

    /* renamed from: a */
    private long m12232a(InterfaceC2240e interfaceC2240e) {
        long hashCode = interfaceC2240e.mo14209a().hashCode();
        StringBuilder sb = new StringBuilder();
        sb.append(interfaceC2240e.mo14210b());
        sb.append('(');
        Iterator<? extends CharSequence> it = interfaceC2240e.mo14211c().iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        return sb.toString().hashCode() | (hashCode << 32);
    }

    /* renamed from: a */
    public C1594f m12236a(C1637c c1637c, InterfaceC2240e interfaceC2240e) {
        return this.f10115b.get(Long.valueOf(m12232a(interfaceC2240e)));
    }

    /* renamed from: a */
    public C1594f m12237a(C1637c c1637c, InterfaceC2240e interfaceC2240e, C1594f c1594f) {
        synchronized (this.f10115b) {
            C1594f put = this.f10115b.put(Long.valueOf(m12232a(interfaceC2240e)), c1594f);
            if (put != null) {
                c1594f = put;
            }
        }
        return c1594f;
    }

    /* renamed from: a */
    public C1592d m12235a(C1592d c1592d) {
        synchronized (this.f10116c) {
            C1592d c1592d2 = this.f10116c.get(c1592d);
            if (c1592d2 == null) {
                this.f10116c.put(c1592d, c1592d);
                return c1592d;
            }
            return c1592d2;
        }
    }
}
