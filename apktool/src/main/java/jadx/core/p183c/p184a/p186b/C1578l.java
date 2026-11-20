package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p191d.C1628a;
import jadx.core.p183c.p191d.C1638d;
import jadx.core.p203d.C1721a;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* compiled from: LoopInfo.java */
/* renamed from: jadx.core.c.a.b.l */
/* loaded from: classes.dex */
public class C1578l {

    /* renamed from: a */
    private final C1628a f10075a;

    /* renamed from: b */
    private final C1628a f10076b;

    /* renamed from: c */
    private final Set<C1628a> f10077c;

    /* renamed from: d */
    private int f10078d;

    /* renamed from: e */
    private C1578l f10079e;

    public C1578l(C1628a c1628a, C1628a c1628a2) {
        this.f10075a = c1628a;
        this.f10076b = c1628a2;
        this.f10077c = Collections.unmodifiableSet(C1721a.m13209b(c1628a, c1628a2));
    }

    /* renamed from: a */
    public C1628a m12124a() {
        return this.f10075a;
    }

    /* renamed from: b */
    public C1628a m12127b() {
        return this.f10076b;
    }

    /* renamed from: c */
    public Set<C1628a> m12128c() {
        return this.f10077c;
    }

    /* renamed from: d */
    public Set<C1628a> m12129d() {
        HashSet hashSet = new HashSet();
        Set<C1628a> m12128c = m12128c();
        for (C1628a c1628a : m12128c) {
            for (C1628a c1628a2 : c1628a.m12442f()) {
                if (!m12128c.contains(c1628a2) && !c1628a2.mo12145a(C1566b.f10033g)) {
                    hashSet.add(c1628a);
                }
            }
        }
        return hashSet;
    }

    /* renamed from: e */
    public List<C1638d> m12130e() {
        LinkedList linkedList = new LinkedList();
        Set<C1628a> m12128c = m12128c();
        for (C1628a c1628a : m12128c) {
            for (C1628a c1628a2 : c1628a.m12442f()) {
                if (!m12128c.contains(c1628a2) && !c1628a2.mo12145a(C1566b.f10033g)) {
                    linkedList.add(new C1638d(c1628a, c1628a2));
                }
            }
        }
        return linkedList;
    }

    /* renamed from: f */
    public int m12131f() {
        return this.f10078d;
    }

    /* renamed from: a */
    public void m12125a(int i) {
        this.f10078d = i;
    }

    /* renamed from: g */
    public C1578l m12132g() {
        return this.f10079e;
    }

    /* renamed from: a */
    public void m12126a(C1578l c1578l) {
        this.f10079e = c1578l;
    }

    public String toString() {
        return "LOOP:" + this.f10078d + ": " + this.f10075a + "->" + this.f10076b;
    }
}
