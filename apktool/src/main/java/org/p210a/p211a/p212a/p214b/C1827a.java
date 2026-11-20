package org.p210a.p211a.p212a.p214b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.p210a.p211a.p212a.C1824ah;
import org.p210a.p211a.p212a.InterfaceC1823ag;
import org.p210a.p211a.p212a.p213a.AbstractC1807q;
import org.p210a.p211a.p212a.p213a.C1788bb;
import org.p210a.p211a.p212a.p213a.C1793c;

/* compiled from: DFA.java */
/* renamed from: org.a.a.a.b.a */
/* loaded from: classes.dex */
public class C1827a {

    /* renamed from: a */
    public final Map<C1829c, C1829c> f10854a = new HashMap();

    /* renamed from: b */
    public volatile C1829c f10855b;

    /* renamed from: c */
    public final int f10856c;

    /* renamed from: d */
    public final AbstractC1807q f10857d;

    /* renamed from: e */
    private final boolean f10858e;

    public C1827a(AbstractC1807q abstractC1807q, int i) {
        boolean z;
        this.f10857d = abstractC1807q;
        this.f10856c = i;
        if ((abstractC1807q instanceof C1788bb) && ((C1788bb) abstractC1807q).f10761k) {
            z = true;
            C1829c c1829c = new C1829c(new C1793c());
            c1829c.f10864c = new C1829c[0];
            c1829c.f10865d = false;
            c1829c.f10868g = false;
            this.f10855b = c1829c;
        } else {
            z = false;
        }
        this.f10858e = z;
    }

    /* renamed from: a */
    public final boolean m13706a() {
        return this.f10858e;
    }

    /* renamed from: a */
    public final C1829c m13704a(int i) {
        if (!m13706a()) {
            throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
        }
        if (i < 0 || i >= this.f10855b.f10864c.length) {
            return null;
        }
        return this.f10855b.f10864c[i];
    }

    /* renamed from: a */
    public final void m13705a(int i, C1829c c1829c) {
        if (!m13706a()) {
            throw new IllegalStateException("Only precedence DFAs may contain a precedence start state.");
        }
        if (i >= 0) {
            synchronized (this.f10855b) {
                if (i >= this.f10855b.f10864c.length) {
                    this.f10855b.f10864c = (C1829c[]) Arrays.copyOf(this.f10855b.f10864c, i + 1);
                }
                this.f10855b.f10864c[i] = c1829c;
            }
        }
    }

    /* renamed from: b */
    public List<C1829c> m13707b() {
        ArrayList arrayList = new ArrayList(this.f10854a.keySet());
        Collections.sort(arrayList, new Comparator<C1829c>() { // from class: org.a.a.a.b.a.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C1829c c1829c, C1829c c1829c2) {
                return c1829c.f10862a - c1829c2.f10862a;
            }
        });
        return arrayList;
    }

    public String toString() {
        return m13703a(C1824ah.f10848a);
    }

    /* renamed from: a */
    public String m13703a(InterfaceC1823ag interfaceC1823ag) {
        if (this.f10855b == null) {
            return "";
        }
        return new C1828b(this, interfaceC1823ag).toString();
    }
}
