package ru.maximoff.apktool.p296a;

import com.p159h.p160a.p162b.AbstractC1381c;
import com.p159h.p160a.p162b.AbstractC1389k;
import com.p159h.p160a.p162b.AbstractRunnableC1391m;
import com.p159h.p160a.p162b.C1388j;
import com.p159h.p160a.p162b.C1397s;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.p210a.p211a.p212a.AbstractC1870r;
import org.p210a.p211a.p212a.C1830c;
import org.p210a.p211a.p212a.C1874v;
import org.p210a.p211a.p212a.InterfaceC1819ac;
import org.p210a.p211a.p212a.InterfaceC1823ag;
import org.p210a.p211a.p212a.p216d.InterfaceC1849d;
import org.p210a.p211a.p212a.p216d.InterfaceC1854i;
import ru.maximoff.apktool.fragment.p301a.C2978b;
import ru.maximoff.apktool.service.C3055a;

/* compiled from: Antlr4LexTask.java */
/* renamed from: ru.maximoff.apktool.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2881a<L extends AbstractC1870r> extends AbstractRunnableC1391m {

    /* renamed from: d */
    private static final ExecutorService f14831d = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private final L f14832c;

    /* renamed from: a */
    protected abstract void mo16888a(List<C1397s<AbstractC1381c.a>> list, L l);

    /* renamed from: a */
    protected void mo16889a(C1830c c1830c) {
    }

    /* renamed from: a */
    protected abstract void mo16890a(L l);

    /* renamed from: g */
    protected abstract L mo16892g();

    /* renamed from: h */
    protected void mo16893h() {
    }

    protected AbstractC2881a(InterfaceC1823ag interfaceC1823ag, C3055a c3055a) {
        this(new a(interfaceC1823ag), c3055a);
    }

    /* renamed from: f */
    protected boolean mo16891f() {
        return false;
    }

    protected AbstractC2881a(AbstractC1389k abstractC1389k, C3055a c3055a) {
        super(abstractC1389k, c3055a);
        this.f14832c = mo16892g();
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: a */
    protected final synchronized void mo11088a(List<C1397s<AbstractC1381c.a>> list, String str) {
        C1830c c1830c = new C1830c(str);
        L l = this.f14832c;
        l.m13860a(c1830c);
        mo16888a(list, (List<C1397s<AbstractC1381c.a>>) l);
        if (mo16891f()) {
            c1830c.m13713a();
            mo16893h();
            f14831d.execute(new Runnable(this, c1830c) { // from class: ru.maximoff.apktool.a.a.1

                /* renamed from: a */
                private final AbstractC2881a f14833a;

                /* renamed from: b */
                private final C1830c f14834b;

                {
                    this.f14833a = this;
                    this.f14834b = c1830c;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        this.f14833a.mo16889a(this.f14834b);
                    } catch (Error e2) {
                    } catch (Exception e3) {
                    }
                    C2978b.f16135a.m17713g();
                }
            });
        }
    }

    /* compiled from: Antlr4LexTask.java */
    /* renamed from: ru.maximoff.apktool.a.a$a */
    public static class a extends AbstractC1389k {
        a(InterfaceC1823ag interfaceC1823ag) {
            m11079a(C2887g.m16905a(interfaceC1823ag));
        }
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: a */
    public synchronized int mo11084a(C1388j c1388j, CharSequence charSequence, int i, int i2) {
        this.f14832c.m13860a(new C1830c(charSequence.toString()));
        return mo16887a(c1388j, (C1388j) this.f14832c, i, i2);
    }

    /* renamed from: a */
    protected int mo16887a(C1388j c1388j, L l, int i, int i2) {
        return i2;
    }

    @Override // com.p159h.p160a.p162b.AbstractRunnableC1391m
    /* renamed from: a */
    public AbstractRunnableC1391m.a mo11085a(String str, int i, int i2) {
        InterfaceC1849d interfaceC1849d;
        InterfaceC1849d mo16894i = mo16894i();
        if (mo16894i == null) {
            L l = this.f14832c;
            l.m13867k();
            mo16890a((AbstractC2881a<L>) l);
            interfaceC1849d = mo16894i();
        } else {
            interfaceC1849d = mo16894i;
        }
        AbstractRunnableC1391m.a aVar = (AbstractRunnableC1391m.a) null;
        if (interfaceC1849d != null) {
            aVar = m16886a(interfaceC1849d, i, i2 - 1);
        }
        if (aVar == null) {
            return super.mo11085a(str, i, i2);
        }
        return aVar;
    }

    /* renamed from: i */
    protected InterfaceC1849d mo16894i() {
        return (InterfaceC1849d) null;
    }

    /* renamed from: a */
    private AbstractRunnableC1391m.a m16886a(InterfaceC1849d interfaceC1849d, int i, int i2) {
        if (interfaceC1849d instanceof InterfaceC1854i) {
            InterfaceC1819ac mo13792a = ((InterfaceC1854i) interfaceC1849d).mo13792a();
            return m16885a(i, i2, mo13792a.mo13677f(), mo13792a.mo13678g());
        }
        C1874v c1874v = (C1874v) interfaceC1849d;
        int mo13677f = c1874v.f11000f.mo13677f();
        int mo13678g = c1874v.f11001g.mo13678g();
        if (i >= mo13677f && i2 <= mo13678g) {
            if (i == mo13677f && i2 == mo13678g) {
                return (AbstractRunnableC1391m.a) null;
            }
            int mo13793k = c1874v.mo13793k();
            for (int i3 = 0; i3 < mo13793k; i3++) {
                AbstractRunnableC1391m.a m16886a = m16886a(c1874v.mo13785b(i3), i, i2);
                if (m16886a != null) {
                    return m16886a;
                }
            }
            return m16885a(i, i2, mo13677f, mo13678g);
        }
        return (AbstractRunnableC1391m.a) null;
    }

    /* renamed from: a */
    private AbstractRunnableC1391m.a m16885a(int i, int i2, int i3, int i4) {
        if (i >= i3 && i2 <= i4) {
            if (i == i3 && i2 == i4) {
                return (AbstractRunnableC1391m.a) null;
            }
            return new AbstractRunnableC1391m.a(i3, i4 + 1);
        }
        return (AbstractRunnableC1391m.a) null;
    }

    /* renamed from: a */
    public static int m16884a(int i, int i2, int i3, int i4, int i5) {
        if (i3 < i4) {
            return i + 1;
        }
        if (i4 >= i2 && i4 <= i3) {
            int i6 = (i - i3) + i4;
            int i7 = (i - i3) + i2;
            if (i6 >= i7) {
                i7 = i6;
            }
            return i7 + 1;
        }
        return i5;
    }
}
