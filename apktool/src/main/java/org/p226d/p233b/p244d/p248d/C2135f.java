package org.p226d.p233b.p244d.p248d;

import com.p129f.p130a.p133c.AbstractC1148aa;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p226d.p233b.p238b.AbstractC2014d;
import org.p226d.p233b.p250e.InterfaceC2165a;
import org.p226d.p233b.p250e.InterfaceC2269j;

/* compiled from: ParameterIterator.java */
/* renamed from: org.d.b.d.d.f */
/* loaded from: classes.dex */
public class C2135f implements Iterator<InterfaceC2269j> {

    /* renamed from: a */
    private final Iterator<? extends CharSequence> f11901a;

    /* renamed from: b */
    private final Iterator<? extends Set<? extends InterfaceC2165a>> f11902b;

    /* renamed from: c */
    private final Iterator<String> f11903c;

    public C2135f(List<? extends CharSequence> list, List<? extends Set<? extends InterfaceC2165a>> list2, Iterator<String> it) {
        this.f11901a = list.iterator();
        this.f11902b = list2.iterator();
        this.f11903c = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f11901a.hasNext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.Set] */
    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceC2269j next() {
        final AbstractC1148aa m9802i;
        final String str;
        final String charSequence = this.f11901a.next().toString();
        if (this.f11902b.hasNext()) {
            m9802i = (Set) this.f11902b.next();
        } else {
            m9802i = AbstractC1148aa.m9802i();
        }
        if (this.f11903c.hasNext()) {
            str = this.f11903c.next();
        } else {
            str = null;
        }
        return new AbstractC2014d() { // from class: org.d.b.d.d.f.1
            @Override // org.p226d.p233b.p250e.InterfaceC2269j
            /* renamed from: a */
            public Set<? extends InterfaceC2165a> mo14219a() {
                return m9802i;
            }

            @Override // org.p226d.p233b.p250e.InterfaceC2269j, org.p226d.p233b.p250e.p251a.InterfaceC2170e
            /* renamed from: b */
            public String mo14220b() {
                return str;
            }

            @Override // org.p226d.p233b.p250e.p254c.InterfaceC2243h, org.p226d.p233b.p250e.InterfaceC2244d
            /* renamed from: l */
            public String mo14205l() {
                return charSequence;
            }
        };
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
