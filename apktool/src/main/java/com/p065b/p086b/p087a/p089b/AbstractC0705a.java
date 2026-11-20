package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p105b.C0934p;
import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p107d.C0973a;
import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import java.util.ArrayList;

/* compiled from: BaseMachine.java */
/* renamed from: com.b.b.a.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC0705a implements InterfaceC0719o {

    /* renamed from: a */
    private final C0973a f4490a;

    /* renamed from: b */
    private InterfaceC0976d[] f4491b;

    /* renamed from: c */
    private int f4492c;

    /* renamed from: d */
    private C0975c f4493d;

    /* renamed from: e */
    private int f4494e;

    /* renamed from: f */
    private AbstractC0945a f4495f;

    /* renamed from: g */
    private int f4496g;

    /* renamed from: h */
    private C0727w f4497h;

    /* renamed from: i */
    private ArrayList<AbstractC0945a> f4498i;

    /* renamed from: j */
    private int f4499j;

    /* renamed from: k */
    private boolean f4500k;

    /* renamed from: l */
    private C0934p f4501l;

    /* renamed from: m */
    private InterfaceC0976d[] f4502m;

    /* renamed from: n */
    private int f4503n;

    public AbstractC0705a(C0973a c0973a) {
        if (c0973a == null) {
            throw new NullPointerException("prototype == null");
        }
        this.f4490a = c0973a;
        this.f4491b = new InterfaceC0976d[10];
        this.f4502m = new InterfaceC0976d[6];
        mo6537b();
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public C0973a mo6521a() {
        return this.f4490a;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: b */
    public final void mo6537b() {
        this.f4492c = 0;
        this.f4493d = null;
        this.f4494e = 0;
        this.f4495f = null;
        this.f4496g = 0;
        this.f4497h = null;
        this.f4498i = null;
        this.f4499j = -1;
        this.f4500k = false;
        this.f4501l = null;
        this.f4503n = -1;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6525a(C0714j c0714j, int i) {
        C0713i m6644d = c0714j.m6644d();
        mo6537b();
        if (i > this.f4491b.length) {
            this.f4491b = new InterfaceC0976d[i + 10];
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            this.f4491b[i2] = m6644d.m6630e();
        }
        this.f4492c = i;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public void mo6526a(C0714j c0714j, C0973a c0973a) {
        C0974b m8104c = c0973a.m8104c();
        int f_ = m8104c.m8550f_();
        mo6525a(c0714j, f_);
        for (int i = 0; i < f_; i++) {
            if (!C0720p.m6688b(m8104c.mo6853a(i), this.f4491b[i])) {
                throw new C0725u("at stack depth " + ((f_ - 1) - i) + ", expected type " + m8104c.mo6853a(i).mo6681d() + " but found " + this.f4491b[i].mo6695a().mo6681d());
            }
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6527a(C0714j c0714j, C0975c c0975c) {
        mo6525a(c0714j, 1);
        if (!C0720p.m6688b(c0975c, this.f4491b[0])) {
            throw new C0725u("expected type " + c0975c.mo6681d() + " but found " + this.f4491b[0].mo6695a().mo6681d());
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6528a(C0714j c0714j, C0975c c0975c, C0975c c0975c2) {
        mo6525a(c0714j, 2);
        if (!C0720p.m6688b(c0975c, this.f4491b[0])) {
            throw new C0725u("expected type " + c0975c.mo6681d() + " but found " + this.f4491b[0].mo6695a().mo6681d());
        }
        if (!C0720p.m6688b(c0975c2, this.f4491b[1])) {
            throw new C0725u("expected type " + c0975c2.mo6681d() + " but found " + this.f4491b[1].mo6695a().mo6681d());
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6529a(C0714j c0714j, C0975c c0975c, C0975c c0975c2, C0975c c0975c3) {
        mo6525a(c0714j, 3);
        if (!C0720p.m6688b(c0975c, this.f4491b[0])) {
            throw new C0725u("expected type " + c0975c.mo6681d() + " but found " + this.f4491b[0].mo6695a().mo6681d());
        }
        if (!C0720p.m6688b(c0975c2, this.f4491b[1])) {
            throw new C0725u("expected type " + c0975c2.mo6681d() + " but found " + this.f4491b[1].mo6695a().mo6681d());
        }
        if (!C0720p.m6688b(c0975c3, this.f4491b[2])) {
            throw new C0725u("expected type " + c0975c3.mo6681d() + " but found " + this.f4491b[2].mo6695a().mo6681d());
        }
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: b */
    public final void mo6539b(C0714j c0714j, int i) {
        mo6537b();
        this.f4491b[0] = c0714j.m6643c().mo6670a(i);
        this.f4492c = 1;
        this.f4499j = i;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6535a(boolean z) {
        this.f4500k = z;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6532a(C0975c c0975c) {
        this.f4493d = c0975c;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6522a(int i) {
        this.f4494e = i;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6531a(AbstractC0945a abstractC0945a) {
        if (abstractC0945a == null) {
            throw new NullPointerException("cst == null");
        }
        this.f4495f = abstractC0945a;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: b */
    public final void mo6538b(int i) {
        this.f4496g = i;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6530a(C0727w c0727w) {
        if (c0727w == null) {
            throw new NullPointerException("cases == null");
        }
        this.f4497h = c0727w;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6534a(ArrayList<AbstractC0945a> arrayList) {
        this.f4498i = arrayList;
    }

    @Override // com.p065b.p086b.p087a.p089b.InterfaceC0719o
    /* renamed from: a */
    public final void mo6523a(int i, C0975c c0975c, C0928j c0928j) {
        this.f4501l = C0934p.m7918b(i, c0975c, c0928j);
    }

    /* renamed from: c */
    protected final int m6541c() {
        return this.f4492c;
    }

    /* renamed from: c */
    protected final InterfaceC0976d m6542c(int i) {
        if (i >= this.f4492c) {
            throw new IllegalArgumentException("n >= argCount");
        }
        try {
            return this.f4491b[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("n < 0");
        }
    }

    /* renamed from: d */
    protected final C0975c m6543d() {
        return this.f4493d;
    }

    /* renamed from: e */
    protected final int m6545e() {
        return this.f4494e;
    }

    /* renamed from: f */
    protected final AbstractC0945a m6546f() {
        return this.f4495f;
    }

    /* renamed from: g */
    protected final int m6547g() {
        return this.f4496g;
    }

    /* renamed from: h */
    protected final C0727w m6548h() {
        return this.f4497h;
    }

    /* renamed from: i */
    protected final ArrayList<AbstractC0945a> m6549i() {
        return this.f4498i;
    }

    /* renamed from: j */
    protected final int m6550j() {
        return this.f4499j;
    }

    /* renamed from: b */
    protected final C0934p m6536b(boolean z) {
        if (this.f4501l == null) {
            return null;
        }
        if (this.f4503n != 1) {
            throw new C0725u("local target with " + (this.f4503n == 0 ? "no" : "multiple") + " results");
        }
        InterfaceC0976d interfaceC0976d = this.f4502m[0];
        C0975c mo6695a = interfaceC0976d.mo6695a();
        C0975c mo6695a2 = this.f4501l.mo6695a();
        if (mo6695a == mo6695a2) {
            if (z) {
                return this.f4501l.m7925a(interfaceC0976d);
            }
            return this.f4501l;
        }
        if (!C0720p.m6688b(mo6695a2, mo6695a)) {
            m6520a(mo6695a, mo6695a2);
            return null;
        }
        if (mo6695a2 == C0975c.f6260o) {
            this.f4501l = this.f4501l.m7925a(interfaceC0976d);
        }
        return this.f4501l;
    }

    /* renamed from: k */
    protected final void m6551k() {
        this.f4503n = 0;
    }

    /* renamed from: a */
    protected final void m6533a(InterfaceC0976d interfaceC0976d) {
        if (interfaceC0976d == null) {
            throw new NullPointerException("result == null");
        }
        this.f4502m[0] = interfaceC0976d;
        this.f4503n = 1;
    }

    /* renamed from: b */
    protected final void m6540b(InterfaceC0976d interfaceC0976d) {
        if (interfaceC0976d == null) {
            throw new NullPointerException("result == null");
        }
        this.f4502m[this.f4503n] = interfaceC0976d;
        this.f4503n++;
    }

    /* renamed from: l */
    protected final int m6552l() {
        if (this.f4503n < 0) {
            throw new C0725u("results never set");
        }
        return this.f4503n;
    }

    /* renamed from: d */
    protected final InterfaceC0976d m6544d(int i) {
        if (i >= this.f4503n) {
            throw new IllegalArgumentException("n >= resultCount");
        }
        try {
            return this.f4502m[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new IllegalArgumentException("n < 0");
        }
    }

    /* renamed from: a */
    protected final void m6524a(C0714j c0714j) {
        if (this.f4503n < 0) {
            throw new C0725u("results never set");
        }
        if (this.f4503n != 0) {
            if (this.f4501l != null) {
                c0714j.m6643c().mo6672a(m6536b(false));
                return;
            }
            C0713i m6644d = c0714j.m6644d();
            for (int i = 0; i < this.f4503n; i++) {
                if (this.f4500k) {
                    m6644d.m6629d();
                }
                m6644d.m6623a(this.f4502m[i]);
            }
        }
    }

    /* renamed from: a */
    public static void m6520a(InterfaceC0976d interfaceC0976d, InterfaceC0976d interfaceC0976d2) {
        throw new C0725u("local variable type mismatch: attempt to set or access a value of type " + interfaceC0976d.mo6681d() + " using a local variable of type " + interfaceC0976d2.mo6681d() + ". This is symptomatic of .class transformation tools that ignore local variable information.");
    }
}
