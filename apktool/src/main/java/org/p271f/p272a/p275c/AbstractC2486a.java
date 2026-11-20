package org.p271f.p272a.p275c;

import java.util.List;
import org.p271f.p272a.AbstractC2526r;

/* compiled from: AbstractInsnNode.java */
/* renamed from: org.f.a.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC2486a {

    /* renamed from: a */
    protected int f12994a;

    /* renamed from: b */
    public List<C2509x> f12995b;

    /* renamed from: c */
    public List<C2509x> f12996c;

    /* renamed from: d */
    AbstractC2486a f12997d;

    /* renamed from: e */
    AbstractC2486a f12998e;

    /* renamed from: f */
    int f12999f = -1;

    /* renamed from: a */
    public abstract void mo15719a(AbstractC2526r abstractC2526r);

    protected AbstractC2486a(int i) {
        this.f12994a = i;
    }

    /* renamed from: a */
    public int m15718a() {
        return this.f12994a;
    }

    /* renamed from: b */
    public AbstractC2486a m15720b() {
        return this.f12997d;
    }

    /* renamed from: b */
    protected final void m15721b(AbstractC2526r abstractC2526r) {
        int size = this.f12995b == null ? 0 : this.f12995b.size();
        for (int i = 0; i < size; i++) {
            C2509x c2509x = this.f12995b.get(i);
            c2509x.m15723a(abstractC2526r.mo15685b(c2509x.f13081h, c2509x.f13082i, c2509x.f13000c, true));
        }
        int size2 = this.f12996c == null ? 0 : this.f12996c.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C2509x c2509x2 = this.f12996c.get(i2);
            c2509x2.m15723a(abstractC2526r.mo15685b(c2509x2.f13081h, c2509x2.f13082i, c2509x2.f13000c, false));
        }
    }
}
