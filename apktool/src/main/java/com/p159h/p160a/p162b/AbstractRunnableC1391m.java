package com.p159h.p160a.p162b;

import com.p159h.p160a.p162b.AbstractC1381c;
import java.util.ArrayList;
import java.util.List;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: LexTask.java */
/* renamed from: com.h.a.b.m */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1391m implements Runnable {

    /* renamed from: b */
    protected final AbstractC1389k f9036b;

    /* renamed from: c */
    private C1392n f9037c;

    /* renamed from: e */
    private C3055a f9039e;

    /* renamed from: d */
    private boolean f9038d = false;

    /* renamed from: a */
    protected boolean f9035a = false;

    /* renamed from: a */
    protected abstract void mo11088a(List<C1397s<AbstractC1381c.a>> list, String str);

    public AbstractRunnableC1391m(AbstractC1389k abstractC1389k, C3055a c3055a) {
        this.f9036b = abstractC1389k;
        this.f9039e = c3055a;
    }

    /* renamed from: a */
    public C3055a m11086a() {
        return this.f9039e;
    }

    /* renamed from: b */
    public void m11090b() {
        this.f9035a = true;
    }

    /* renamed from: c */
    public boolean m11091c() {
        return this.f9038d;
    }

    /* renamed from: a */
    void m11087a(C1392n c1392n) {
        this.f9037c = c1392n;
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        this.f9038d = true;
        ArrayList arrayList = new ArrayList();
        this.f9035a = false;
        try {
            mo11088a(arrayList, this.f9037c.m11098b());
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        if (arrayList.size() > 0) {
            this.f9037c.m11097a(arrayList);
        }
        this.f9038d = false;
    }

    /* renamed from: a */
    public int mo11084a(C1388j c1388j, CharSequence charSequence, int i, int i2) {
        c1388j.m11070a(charSequence);
        return i2;
    }

    /* renamed from: d */
    public boolean mo11092d() {
        return false;
    }

    /* renamed from: a */
    public a mo11085a(String str, int i, int i2) {
        return new a(0, str.length());
    }

    /* renamed from: e */
    public final AbstractC1389k m11093e() {
        return this.f9036b;
    }

    /* compiled from: LexTask.java */
    /* renamed from: com.h.a.b.m$a */
    public static class a {

        /* renamed from: a */
        public final int f9040a;

        /* renamed from: b */
        public final int f9041b;

        public a(int i, int i2) {
            this.f9040a = i;
            this.f9041b = i2 - i;
        }
    }

    /* renamed from: a */
    public boolean mo11089a(int i) {
        return false;
    }
}
