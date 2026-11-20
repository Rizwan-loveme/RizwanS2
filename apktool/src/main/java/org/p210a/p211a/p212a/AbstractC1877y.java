package org.p210a.p211a.p212a;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.p210a.p211a.p212a.p213a.AbstractC1796f;
import org.p210a.p211a.p212a.p213a.C1759a;

/* compiled from: Recognizer.java */
/* renamed from: org.a.a.a.y */
/* loaded from: classes.dex */
public abstract class AbstractC1877y<Symbol, ATNInterpreter extends AbstractC1796f> {

    /* renamed from: a */
    private static final Map<InterfaceC1823ag, Map<String, Integer>> f11009a = new WeakHashMap();

    /* renamed from: b */
    private static final Map<String[], Map<String, Integer>> f11010b = new WeakHashMap();

    /* renamed from: c */
    private List<InterfaceC1758a> f11011c = new CopyOnWriteArrayList<InterfaceC1758a>() { // from class: org.a.a.a.y.1
        {
            add(C1865m.f10962a);
        }
    };

    /* renamed from: d */
    private int f11012d = -1;

    /* renamed from: w */
    protected ATNInterpreter f11013w;

    @Deprecated
    /* renamed from: a */
    public abstract String[] mo4046a();

    /* renamed from: c */
    public abstract String[] mo4048c();

    /* renamed from: d */
    public abstract C1759a mo4049d();

    /* renamed from: b */
    public InterfaceC1823ag mo4047b() {
        return C1824ah.m13694a(mo4046a());
    }

    /* renamed from: cC */
    public ATNInterpreter m13926cC() {
        return this.f11013w;
    }

    /* renamed from: a */
    public void m13925a(InterfaceC1758a interfaceC1758a) {
        if (interfaceC1758a == null) {
            throw new NullPointerException("listener cannot be null.");
        }
        this.f11011c.add(interfaceC1758a);
    }

    /* renamed from: cD */
    public void m13927cD() {
        this.f11011c.clear();
    }

    /* renamed from: cE */
    public List<? extends InterfaceC1758a> m13928cE() {
        return this.f11011c;
    }

    /* renamed from: cF */
    public InterfaceC1758a m13929cF() {
        return new C1875w(m13928cE());
    }

    /* renamed from: a */
    public boolean mo4147a(C1878z c1878z, int i, int i2) {
        return true;
    }

    /* renamed from: a */
    public boolean mo13889a(C1878z c1878z, int i) {
        return true;
    }

    /* renamed from: b */
    public void mo4753b(C1878z c1878z, int i, int i2) {
    }

    /* renamed from: cG */
    public final int m13930cG() {
        return this.f11012d;
    }

    /* renamed from: f */
    public final void m13931f(int i) {
        this.f11012d = i;
    }
}
