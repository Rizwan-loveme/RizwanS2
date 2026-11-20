package com.p159h.p160a.p162b;

import com.p159h.p160a.p162b.AbstractC1381c;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Lexer.java */
/* renamed from: com.h.a.b.n */
/* loaded from: classes.dex */
public class C1392n {

    /* renamed from: a */
    private static final ExecutorService f9042a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private String f9043b;

    /* renamed from: c */
    private AbstractRunnableC1391m f9044c;

    /* renamed from: d */
    private final a f9045d;

    /* compiled from: Lexer.java */
    /* renamed from: com.h.a.b.n$a */
    public interface a {
        /* renamed from: a */
        void mo10941a(List<C1397s<AbstractC1381c.a>> list);
    }

    public C1392n(a aVar, AbstractRunnableC1391m abstractRunnableC1391m) {
        abstractRunnableC1391m.m11087a(this);
        this.f9045d = aVar;
        this.f9044c = abstractRunnableC1391m;
    }

    /* renamed from: a */
    public void m11096a(AbstractRunnableC1391m abstractRunnableC1391m) {
        this.f9044c = abstractRunnableC1391m;
        abstractRunnableC1391m.m11087a(this);
    }

    /* renamed from: a */
    public void m11095a(C1386h c1386h) {
        AbstractRunnableC1391m abstractRunnableC1391m = this.f9044c;
        if (abstractRunnableC1391m.m11093e().mo11080a()) {
            m11099b(new C1386h(c1386h));
            if (abstractRunnableC1391m.m11091c()) {
                abstractRunnableC1391m.m11090b();
            }
            f9042a.execute(abstractRunnableC1391m);
        }
    }

    /* renamed from: a */
    void m11097a(List<C1397s<AbstractC1381c.a>> list) {
        if (this.f9045d != null) {
            this.f9045d.mo10941a(list);
        }
    }

    /* renamed from: a */
    public void m11094a() {
        if (this.f9044c != null) {
            this.f9044c.m11090b();
        }
    }

    /* renamed from: b */
    public synchronized void m11099b(C1386h c1386h) {
        this.f9043b = c1386h.toString();
    }

    /* renamed from: b */
    public synchronized String m11098b() {
        return this.f9043b;
    }
}
