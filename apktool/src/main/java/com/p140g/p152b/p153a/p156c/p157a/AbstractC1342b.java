package com.p140g.p152b.p153a.p156c.p157a;

import com.p140g.p152b.p153a.C1323b;
import com.p140g.p152b.p153a.p154a.AbstractC1322t;
import com.p140g.p152b.p153a.p154a.C1314l;
import com.p140g.p152b.p153a.p155b.AbstractC1333j;
import com.p140g.p152b.p153a.p155b.C1324a;
import com.p140g.p152b.p153a.p156c.C1345b;
import com.p140g.p152b.p153a.p156c.p157a.InterfaceC1341a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BaseAnalyze.java */
@SuppressWarnings({"unchecked"})
/* renamed from: com.g.b.a.c.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1342b<T extends InterfaceC1341a> implements C1345b.b<T[]>, C1345b.e {

    /* renamed from: a */
    private boolean f8687a;

    /* renamed from: b */
    public List<T> f8688b;

    /* renamed from: c */
    protected int f8689c;

    /* renamed from: d */
    protected C1323b f8690d;

    /* renamed from: e */
    private T[] f8691e;

    /* renamed from: f */
    private T[] f8692f;

    @Override // com.p140g.p152b.p153a.p156c.C1345b.d
    /* renamed from: a */
    public AbstractC1322t mo10611a(C1314l c1314l) {
        return m10619b(c1314l);
    }

    @Override // com.p140g.p152b.p153a.p156c.C1345b.c
    /* renamed from: a */
    public AbstractC1322t mo10612a(C1314l c1314l, C1324a c1324a) {
        return m10620b(c1314l, c1324a);
    }

    @Override // com.p140g.p152b.p153a.p156c.C1345b.b
    /* renamed from: a */
    public Object mo10614a(AbstractC1333j abstractC1333j) {
        return m10623b(abstractC1333j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p140g.p152b.p153a.p156c.C1345b.b
    /* renamed from: a */
    public Object mo10615a(Object obj, AbstractC1333j abstractC1333j) {
        return m10624b((InterfaceC1341a[]) obj, abstractC1333j);
    }

    /* renamed from: a */
    protected void mo10616a() {
    }

    /* renamed from: a */
    protected void mo10617a(T t, C1314l c1314l) {
    }

    /* renamed from: a */
    protected void m10618a(T[] tArr, AbstractC1333j abstractC1333j) {
    }

    /* renamed from: b */
    protected abstract T[] mo10622b(int i);

    /* renamed from: d */
    protected abstract T mo10625d();

    public AbstractC1342b(C1323b c1323b) {
        this(c1323b, true);
    }

    public AbstractC1342b(C1323b c1323b, boolean z) {
        this.f8688b = new ArrayList();
        this.f8690d = c1323b;
        if (!z) {
            int i = -1;
            for (C1314l c1314l : c1323b.f8624c) {
                if (c1314l.f8546a > i) {
                    i = c1314l.f8546a;
                }
            }
            this.f8689c = i + 1;
        } else {
            this.f8689c = c1323b.f8624c.size();
        }
        this.f8687a = z;
    }

    /* renamed from: e */
    public void m10626e() {
        m10628g();
        m10627f();
        mo10616a();
    }

    /* renamed from: f */
    protected void m10627f() {
        this.f8692f = mo10622b(this.f8689c);
        C1345b.m10642a(this.f8690d.f8628g, this);
        this.f8692f = (T[]) ((InterfaceC1341a[]) null);
    }

    /* renamed from: b */
    public T[] m10624b(T[] tArr, AbstractC1333j abstractC1333j) {
        this.f8691e = tArr;
        try {
            C1345b.m10649b(abstractC1333j, (C1345b.e) this, false);
            T[] tArr2 = this.f8691e;
            this.f8691e = (T[]) ((InterfaceC1341a[]) null);
            m10618a((InterfaceC1341a[]) tArr2, abstractC1333j);
            return tArr2;
        } catch (Exception e2) {
            throw new RuntimeException(new StringBuffer().append("fail exe ").append(abstractC1333j).toString(), e2);
        }
    }

    /* renamed from: g */
    protected void m10628g() {
        if (this.f8687a) {
            int i = 0;
            Iterator<C1314l> it = this.f8690d.f8624c.iterator();
            while (it.hasNext()) {
                it.next().f8546a = i;
                i++;
            }
        }
        m10629h();
    }

    /* renamed from: h */
    protected void m10629h() {
        C1345b.m10653c(this.f8690d);
    }

    /* renamed from: i */
    protected T[] m10630i() {
        return mo10622b(this.f8689c);
    }

    /* renamed from: b */
    public T[] m10623b(AbstractC1333j abstractC1333j) {
        return mo10622b(this.f8689c);
    }

    /* renamed from: b */
    public C1314l m10620b(C1314l c1314l, C1324a c1324a) {
        System.arraycopy(this.f8691e, 0, this.f8692f, 0, this.f8689c);
        this.f8691e = this.f8692f;
        T mo10621b = mo10621b(c1314l, c1324a.f8653b);
        this.f8688b.add(mo10621b);
        this.f8691e[c1314l.f8546a] = mo10621b;
        return c1314l;
    }

    /* renamed from: b */
    protected T mo10621b(C1314l c1314l, AbstractC1322t abstractC1322t) {
        return mo10625d();
    }

    /* renamed from: b */
    public C1314l m10619b(C1314l c1314l) {
        mo10617a((AbstractC1342b<T>) this.f8691e[c1314l.f8546a], c1314l);
        return c1314l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (AbstractC1333j m10574a = this.f8690d.f8628g.m10574a(); m10574a != null; m10574a = m10574a.m10559b()) {
            InterfaceC1341a[] interfaceC1341aArr = (InterfaceC1341a[]) m10574a.f8644h;
            if (interfaceC1341aArr != null) {
                for (InterfaceC1341a interfaceC1341a : interfaceC1341aArr) {
                    if (interfaceC1341a == null) {
                        sb.append('.');
                    } else {
                        sb.append(interfaceC1341a.mo10613a());
                    }
                }
                sb.append(" | ");
            }
            sb.append(m10574a.toString()).append('\n');
        }
        return sb.toString();
    }
}
