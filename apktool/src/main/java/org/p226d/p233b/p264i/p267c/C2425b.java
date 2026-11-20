package org.p226d.p233b.p264i.p267c;

import com.p129f.p130a.p131a.InterfaceC1112g;
import com.p129f.p130a.p131a.InterfaceC1121p;
import com.p129f.p130a.p133c.AbstractC1203r;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import org.p226d.p233b.p238b.p240b.AbstractC1996b;
import org.p226d.p233b.p250e.InterfaceC2266g;
import org.p226d.p233b.p250e.p255d.InterfaceC2246b;
import org.p226d.p233b.p250e.p255d.InterfaceC2251g;
import org.p226d.p233b.p256f.p261e.C2341h;
import org.p226d.p233b.p263h.C2383c;
import org.p226d.p269d.AbstractC2447a;
import org.p226d.p269d.C2452f;

/* compiled from: StaticInitializerUtil.java */
/* renamed from: org.d.b.i.c.b */
/* loaded from: classes.dex */
public class C2425b {

    /* renamed from: a */
    private static final InterfaceC1121p<InterfaceC2266g> f12802a = new InterfaceC1121p<InterfaceC2266g>() { // from class: org.d.b.i.c.b.2
        @Override // com.p129f.p130a.p131a.InterfaceC1121p
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public boolean mo9509a(InterfaceC2266g interfaceC2266g) {
            InterfaceC2251g mo14223b = interfaceC2266g.mo14223b();
            return (mo14223b == null || C2383c.m15080a(mo14223b)) ? false : true;
        }
    };

    /* renamed from: b */
    private static final InterfaceC1112g<InterfaceC2266g, InterfaceC2251g> f12803b = new InterfaceC1112g<InterfaceC2266g, InterfaceC2251g>() { // from class: org.d.b.i.c.b.3
        @Override // com.p129f.p130a.p131a.InterfaceC1112g
        /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public InterfaceC2251g mo9517a(InterfaceC2266g interfaceC2266g) {
            InterfaceC2251g mo14223b = interfaceC2266g.mo14223b();
            if (mo14223b == null) {
                return C2341h.m14985a(interfaceC2266g.mo14227f());
            }
            return mo14223b;
        }
    };

    /* renamed from: a */
    public static InterfaceC2246b m15326a(final SortedSet<? extends InterfaceC2266g> sortedSet) {
        final int m15513a = C2452f.m15513a(sortedSet, f12802a);
        if (m15513a > -1) {
            return new AbstractC1996b() { // from class: org.d.b.i.c.b.1
                @Override // org.p226d.p233b.p250e.p255d.InterfaceC2246b
                /* renamed from: b */
                public List<? extends InterfaceC2251g> mo14733b() {
                    return new AbstractC2447a<InterfaceC2251g>() { // from class: org.d.b.i.c.b.1.1
                        @Override // org.p226d.p269d.AbstractC2447a, java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                        public Iterator<InterfaceC2251g> iterator() {
                            return AbstractC1203r.m10108a(SortedSet.this).m10113a(m15513a + 1).m10114a(C2425b.f12803b).iterator();
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                        public int size() {
                            return m15513a + 1;
                        }
                    };
                }
            };
        }
        return null;
    }
}
