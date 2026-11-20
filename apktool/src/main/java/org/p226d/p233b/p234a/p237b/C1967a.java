package org.p226d.p233b.p234a.p237b;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.p226d.p233b.p234a.C1983r;
import org.p226d.p233b.p234a.InterfaceC1981p;

/* compiled from: TypeProtoUtils.java */
/* renamed from: org.d.b.a.b.a */
/* loaded from: classes.dex */
public class C1967a {
    /* renamed from: a */
    public static Iterable<InterfaceC1981p> m14254a(final InterfaceC1981p interfaceC1981p) {
        return new Iterable<InterfaceC1981p>() { // from class: org.d.b.a.b.a.1
            @Override // java.lang.Iterable
            public Iterator<InterfaceC1981p> iterator() {
                return new Iterator<InterfaceC1981p>() { // from class: org.d.b.a.b.a.1.1

                    /* renamed from: b */
                    private InterfaceC1981p f11451b;

                    {
                        this.f11451b = C1967a.m14256b(InterfaceC1981p.this);
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f11451b != null;
                    }

                    @Override // java.util.Iterator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public InterfaceC1981p next() {
                        InterfaceC1981p interfaceC1981p2 = this.f11451b;
                        if (interfaceC1981p2 == null) {
                            throw new NoSuchElementException();
                        }
                        this.f11451b = C1967a.m14256b(interfaceC1981p2);
                        return interfaceC1981p2;
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    /* renamed from: b */
    public static InterfaceC1981p m14256b(InterfaceC1981p interfaceC1981p) {
        try {
            String mo14270f = interfaceC1981p.mo14270f();
            if (mo14270f != null) {
                return interfaceC1981p.mo14261a().m14273a((CharSequence) mo14270f);
            }
            return null;
        } catch (C1983r e2) {
            return interfaceC1981p.mo14261a().m14276b();
        }
    }

    /* renamed from: a */
    public static boolean m14255a(InterfaceC1981p interfaceC1981p, String str) {
        if (interfaceC1981p.mo14265b().equals(str)) {
            return true;
        }
        Iterator<InterfaceC1981p> it = m14254a(interfaceC1981p).iterator();
        while (it.hasNext()) {
            if (it.next().mo14265b().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
