package jadx.core.p183c.p197g.p198a.p199a;

import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1628a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BlocksRemoveInfo.java */
/* renamed from: jadx.core.c.g.a.a.b */
/* loaded from: classes.dex */
public final class C1672b {

    /* renamed from: a */
    private final Set<C1671a> f10480a = new HashSet();

    /* renamed from: b */
    private final Set<C1671a> f10481b = new HashSet();

    /* renamed from: c */
    private final Map<C1604i, C1604i> f10482c = new HashMap();

    /* renamed from: d */
    private C1671a f10483d;

    /* renamed from: e */
    private C1671a f10484e;

    /* renamed from: f */
    private int f10485f;

    /* renamed from: g */
    private int f10486g;

    /* renamed from: h */
    private C1628a f10487h;

    /* renamed from: i */
    private boolean f10488i;

    public C1672b(C1671a c1671a) {
        this.f10483d = c1671a;
    }

    /* renamed from: a */
    public Set<C1671a> m12788a() {
        return this.f10480a;
    }

    /* renamed from: b */
    public Set<C1671a> m12794b() {
        return this.f10481b;
    }

    /* renamed from: c */
    public C1671a m12796c() {
        return this.f10483d;
    }

    /* renamed from: d */
    public C1671a m12797d() {
        return this.f10484e;
    }

    /* renamed from: a */
    public void m12791a(C1671a c1671a) {
        this.f10484e = c1671a;
    }

    /* renamed from: e */
    public int m12798e() {
        return this.f10485f;
    }

    /* renamed from: a */
    public void m12789a(int i) {
        this.f10485f = i;
    }

    /* renamed from: f */
    public int m12799f() {
        return this.f10486g;
    }

    /* renamed from: b */
    public void m12795b(int i) {
        this.f10486g = i;
    }

    /* renamed from: a */
    public void m12790a(C1628a c1628a) {
        this.f10487h = c1628a;
    }

    /* renamed from: g */
    public Map<C1604i, C1604i> m12800g() {
        return this.f10482c;
    }

    /* renamed from: b */
    public C1628a m12793b(C1628a c1628a) {
        for (C1671a c1671a : this.f10480a) {
            if (c1671a.m12787b() == c1628a) {
                return c1671a.m12787b();
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m12792a(boolean z) {
        this.f10488i = z;
    }

    public String toString() {
        return "BRI{start: " + this.f10483d + ", end: " + this.f10484e + ", processed: " + this.f10480a + ", outs: " + this.f10481b + ", regMap: " + this.f10482c + ", split: " + this.f10485f + "-" + this.f10486g + "}";
    }
}
