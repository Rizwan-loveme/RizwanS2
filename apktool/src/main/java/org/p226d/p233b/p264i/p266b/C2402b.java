package org.p226d.p233b.p264i.p266b;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p264i.InterfaceC2400b;

/* compiled from: AnnotationSetPool.java */
/* renamed from: org.d.b.i.b.b */
/* loaded from: classes.dex */
public class C2402b extends AbstractC2404d<Set<? extends InterfaceC2165a>> implements InterfaceC2400b<InterfaceC2165a, Set<? extends InterfaceC2165a>> {
    public C2402b(C2409i c2409i) {
        super(c2409i);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(Set<? extends InterfaceC2165a> set) {
        if (set.size() > 0 && ((Integer) this.f12766b.put(set, 0)) == null) {
            Iterator<? extends InterfaceC2165a> it = set.iterator();
            while (it.hasNext()) {
                ((C2401a) this.f12765a.f12835I).a2(it.next());
            }
        }
    }

    @Override // org.p226d.p233b.p264i.InterfaceC2400b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Collection<? extends InterfaceC2165a> mo15167a(Set<? extends InterfaceC2165a> set) {
        return set;
    }
}
