package jadx.core.p183c.p193e.p194a;

import jadx.core.p183c.p191d.C1628a;
import java.util.HashSet;
import java.util.Set;

/* compiled from: IfInfo.java */
/* renamed from: jadx.core.c.e.a.c */
/* loaded from: classes.dex */
public final class C1654c {

    /* renamed from: a */
    private final C1653b f10428a;

    /* renamed from: b */
    private final Set<C1628a> f10429b;

    /* renamed from: c */
    private final C1628a f10430c;

    /* renamed from: d */
    private final C1628a f10431d;

    /* renamed from: e */
    private final Set<C1628a> f10432e;

    /* renamed from: f */
    private C1628a f10433f;

    /* renamed from: g */
    @Deprecated
    private C1628a f10434g;

    public C1654c(C1653b c1653b, C1628a c1628a, C1628a c1628a2) {
        this(c1653b, c1628a, c1628a2, new HashSet(), new HashSet());
    }

    public C1654c(C1654c c1654c, C1628a c1628a, C1628a c1628a2) {
        this(c1654c.m12695a(), c1628a, c1628a2, c1654c.m12698b(), c1654c.m12700c());
    }

    private C1654c(C1653b c1653b, C1628a c1628a, C1628a c1628a2, Set<C1628a> set, Set<C1628a> set2) {
        this.f10428a = c1653b;
        this.f10430c = c1628a;
        this.f10431d = c1628a2;
        this.f10429b = set;
        this.f10432e = set2;
    }

    /* renamed from: a */
    public static C1654c m12694a(C1654c c1654c) {
        C1654c c1654c2 = new C1654c(C1653b.m12681b(c1654c.m12695a()), c1654c.m12702e(), c1654c.m12701d(), c1654c.m12698b(), c1654c.m12700c());
        c1654c2.m12699b(c1654c.m12704g());
        return c1654c2;
    }

    /* renamed from: a */
    public void m12697a(C1654c... c1654cArr) {
        for (C1654c c1654c : c1654cArr) {
            this.f10429b.addAll(c1654c.m12698b());
            this.f10432e.addAll(c1654c.m12700c());
        }
    }

    /* renamed from: a */
    public C1653b m12695a() {
        return this.f10428a;
    }

    /* renamed from: b */
    public Set<C1628a> m12698b() {
        return this.f10429b;
    }

    /* renamed from: c */
    public Set<C1628a> m12700c() {
        return this.f10432e;
    }

    /* renamed from: d */
    public C1628a m12701d() {
        return this.f10430c;
    }

    /* renamed from: e */
    public C1628a m12702e() {
        return this.f10431d;
    }

    /* renamed from: f */
    public C1628a m12703f() {
        return this.f10433f;
    }

    /* renamed from: a */
    public void m12696a(C1628a c1628a) {
        this.f10433f = c1628a;
    }

    /* renamed from: g */
    public C1628a m12704g() {
        return this.f10434g;
    }

    /* renamed from: b */
    public void m12699b(C1628a c1628a) {
        this.f10434g = c1628a;
    }

    public String toString() {
        return "IfInfo: then: " + this.f10430c + ", else: " + this.f10431d;
    }
}
