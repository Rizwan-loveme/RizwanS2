package com.p065b.p086b.p108g;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p105b.C0935q;
import com.p065b.p086b.p103f.p105b.C0937s;
import com.p065b.p086b.p103f.p105b.C0940v;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p108g.AbstractC1004u;
import com.p065b.p086b.p110h.C1022m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PhiInsn.java */
/* renamed from: com.b.b.g.n */
/* loaded from: classes.dex */
public final class C0997n extends AbstractC1004u {

    /* renamed from: a */
    private final int f6401a;

    /* renamed from: b */
    private final ArrayList<a> f6402b;

    /* renamed from: c */
    private C0935q f6403c;

    /* compiled from: PhiInsn.java */
    /* renamed from: com.b.b.g.n$b */
    public interface b {
        /* renamed from: a */
        void mo8208a(C0997n c0997n);
    }

    public C0997n(C0934p c0934p, C1002s c1002s) {
        super(c0934p, c1002s);
        this.f6402b = new ArrayList<>();
        this.f6401a = c0934p.m7931g();
    }

    public C0997n(int i, C1002s c1002s) {
        super(C0934p.m7913a(i, C0975c.f6254i), c1002s);
        this.f6402b = new ArrayList<>();
        this.f6401a = i;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0997n mo8296n() {
        throw new UnsupportedOperationException("can't clone phi");
    }

    /* renamed from: a */
    public void m8310a(C1005v c1005v) {
        Iterator<a> it = this.f6402b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            next.f6404a = next.f6404a.m7925a(c1005v.m8418c(next.f6404a.m7931g()).m8391o().mo6695a());
        }
        this.f6403c = null;
    }

    /* renamed from: a */
    public void m8309a(InterfaceC0976d interfaceC0976d, C0928j c0928j) {
        m8387b(C0934p.m7918b(m8391o().m7931g(), interfaceC0976d, c0928j));
    }

    /* renamed from: h */
    public int m8311h() {
        return this.f6401a;
    }

    /* renamed from: a */
    public void m8308a(C0934p c0934p, C1002s c1002s) {
        this.f6402b.add(new a(c0934p, c1002s.m8358e(), c1002s.m8360f()));
        this.f6403c = null;
    }

    /* renamed from: a */
    public void m8307a(C0934p c0934p) {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f6402b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f6404a.m7931g() == c0934p.m7931g()) {
                arrayList.add(next);
            }
        }
        this.f6402b.removeAll(arrayList);
        this.f6403c = null;
    }

    /* renamed from: a */
    public int m8303a(int i) {
        return this.f6402b.get(i).f6405b;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: e */
    public C0937s mo8287e() {
        return null;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: f */
    public AbstractC0926h mo8288f() {
        return null;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: k */
    public boolean mo8293k() {
        return false;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: b */
    public C0935q mo8285b() {
        if (this.f6403c != null) {
            return this.f6403c;
        }
        if (this.f6402b.size() == 0) {
            return C0935q.f5906a;
        }
        int size = this.f6402b.size();
        this.f6403c = new C0935q(size);
        for (int i = 0; i < size; i++) {
            this.f6403c.m7948a(i, this.f6402b.get(i).f6404a);
        }
        this.f6403c.mo6683e_();
        return this.f6403c;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: a */
    public final void mo8283a(AbstractC0999p abstractC0999p) {
        Iterator<a> it = this.f6402b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            C0934p c0934p = next.f6404a;
            next.f6404a = abstractC0999p.mo8141a(c0934p);
            if (c0934p != next.f6404a) {
                m8392p().m8369o().m8409a(this, c0934p, next.f6404a);
            }
        }
        this.f6403c = null;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: c */
    public AbstractC0926h mo8286c() {
        throw new IllegalArgumentException("Cannot convert phi insns to rop form");
    }

    /* renamed from: a */
    public List<C1002s> m8306a(int i, C1005v c1005v) {
        ArrayList arrayList = new ArrayList();
        Iterator<a> it = this.f6402b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f6404a.m7931g() == i) {
                arrayList.add(c1005v.m8427j().get(next.f6405b));
            }
        }
        return arrayList;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: l */
    public boolean mo8294l() {
        return true;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: m */
    public boolean mo8295m() {
        return C0996m.m8301a() && mo8289g() != null;
    }

    @Override // com.p065b.p086b.p108g.AbstractC1004u
    /* renamed from: a */
    public void mo8284a(AbstractC1004u.a aVar) {
        aVar.mo8177a(this);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return m8305a((String) null);
    }

    /* renamed from: a */
    protected final String m8305a(String str) {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append(C0940v.f6128a);
        stringBuffer.append(": phi");
        if (str != null) {
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")");
        }
        C0934p o = m8391o();
        if (o == null) {
            stringBuffer.append(" .");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(o.mo6681d());
        }
        stringBuffer.append(" <-");
        int f_ = mo8285b().m8550f_();
        if (f_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < f_; i++) {
                stringBuffer.append(" ");
                stringBuffer.append(this.f6403c.m7949b(i).mo6681d() + "[b=" + C1022m.m8557c(this.f6402b.get(i).f6406c) + "]");
            }
        }
        return stringBuffer.toString();
    }

    /* compiled from: PhiInsn.java */
    /* renamed from: com.b.b.g.n$a */
    private static class a {

        /* renamed from: a */
        public C0934p f6404a;

        /* renamed from: b */
        public final int f6405b;

        /* renamed from: c */
        public final int f6406c;

        public a(C0934p c0934p, int i, int i2) {
            this.f6404a = c0934p;
            this.f6405b = i;
            this.f6406c = i2;
        }
    }
}
