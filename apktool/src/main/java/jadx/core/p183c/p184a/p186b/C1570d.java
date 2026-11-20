package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p191d.C1639e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: EnumMapAttr.java */
/* renamed from: jadx.core.c.a.b.d */
/* loaded from: classes.dex */
public class C1570d implements InterfaceC1587g<C1570d> {

    /* renamed from: a */
    private Map<C1639e, a> f10059a;

    /* compiled from: EnumMapAttr.java */
    /* renamed from: jadx.core.c.a.b.d$a */
    public static class a {

        /* renamed from: a */
        private final Map<Object, Object> f10060a = new HashMap();

        /* renamed from: a */
        public Object m12105a(Object obj) {
            return this.f10060a.get(obj);
        }

        /* renamed from: a */
        void m12106a(Object obj, Object obj2) {
            this.f10060a.put(obj, obj2);
        }
    }

    /* renamed from: a */
    public a m12102a(C1639e c1639e) {
        if (this.f10059a == null) {
            return null;
        }
        return this.f10059a.get(c1639e);
    }

    /* renamed from: a */
    public void m12103a(C1639e c1639e, Object obj, Object obj2) {
        a m12102a = m12102a(c1639e);
        if (m12102a == null) {
            m12102a = new a();
            if (this.f10059a == null) {
                this.f10059a = new HashMap();
            }
            this.f10059a.put(c1639e, m12102a);
        }
        m12102a.m12106a(obj, obj2);
    }

    /* renamed from: a */
    public boolean m12104a() {
        return this.f10059a == null || this.f10059a.isEmpty();
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1570d> mo12085b() {
        return C1566b.f10041o;
    }

    public String toString() {
        return "Enum fields map: " + this.f10059a;
    }
}
