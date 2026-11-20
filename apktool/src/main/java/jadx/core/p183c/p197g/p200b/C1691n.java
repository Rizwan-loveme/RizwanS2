package jadx.core.p183c.p197g.p200b;

import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1648n;
import jadx.core.p183c.p191d.InterfaceC1644j;
import jadx.core.p203d.p205b.C1728e;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.p285i.C2568c;
import org.p285i.InterfaceC2558b;

/* compiled from: RegionStack.java */
/* renamed from: jadx.core.c.g.b.n */
/* loaded from: classes.dex */
final class C1691n {

    /* renamed from: a */
    private static final InterfaceC2558b f10524a = C2568c.m15995a((Class<?>) C1691n.class);

    /* renamed from: b */
    private final Deque<a> f10525b = new ArrayDeque();

    /* renamed from: c */
    private a f10526c = new a();

    /* compiled from: RegionStack.java */
    /* renamed from: jadx.core.c.g.b.n$a */
    private static final class a {

        /* renamed from: a */
        final Set<C1628a> f10527a;

        /* renamed from: b */
        InterfaceC1644j f10528b;

        public a() {
            this.f10527a = new HashSet(4);
        }

        private a(a aVar) {
            this.f10527a = new HashSet(aVar.f10527a);
        }

        /* renamed from: a */
        public a m13004a() {
            return new a(this);
        }

        public String toString() {
            return "Region: " + this.f10528b + ", exits: " + this.f10527a;
        }
    }

    public C1691n(C1648n c1648n) {
    }

    /* renamed from: a */
    public void m12998a(InterfaceC1644j interfaceC1644j) {
        this.f10525b.push(this.f10526c);
        if (this.f10525b.size() > 1000) {
            throw new C1728e("Regions stack size limit reached");
        }
        this.f10526c = this.f10526c.m13004a();
        this.f10526c.f10528b = interfaceC1644j;
    }

    /* renamed from: a */
    public void m12996a() {
        this.f10526c = this.f10525b.pop();
    }

    /* renamed from: a */
    public void m12997a(C1628a c1628a) {
        if (c1628a != null) {
            this.f10526c.f10527a.add(c1628a);
        }
    }

    /* renamed from: a */
    public void m12999a(Collection<C1628a> collection) {
        Iterator<C1628a> it = collection.iterator();
        while (it.hasNext()) {
            m12997a(it.next());
        }
    }

    /* renamed from: b */
    public void m13001b(C1628a c1628a) {
        if (c1628a != null) {
            this.f10526c.f10527a.remove(c1628a);
        }
    }

    /* renamed from: c */
    public boolean m13003c(C1628a c1628a) {
        return this.f10526c.f10527a.contains(c1628a);
    }

    /* renamed from: b */
    public InterfaceC1644j m13000b() {
        return this.f10526c.f10528b;
    }

    /* renamed from: c */
    public int m13002c() {
        return this.f10525b.size();
    }

    public String toString() {
        return "Region stack size: " + m13002c() + ", last: " + this.f10526c;
    }
}
