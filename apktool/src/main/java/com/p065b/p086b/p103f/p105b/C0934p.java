package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p106c.AbstractC0945a;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0976d;
import com.p065b.p086b.p110h.InterfaceC1035z;
import java.util.HashMap;

/* compiled from: RegisterSpec.java */
/* renamed from: com.b.b.f.b.p */
/* loaded from: classes.dex */
public final class C0934p implements InterfaceC0976d, InterfaceC1035z, Comparable<C0934p> {

    /* renamed from: a */
    private static final HashMap<Object, C0934p> f5898a = new HashMap<>(1000);

    /* renamed from: b */
    private static final a f5899b = new a();

    /* renamed from: c */
    private final int f5900c;

    /* renamed from: d */
    private final InterfaceC0976d f5901d;

    /* renamed from: e */
    private final C0928j f5902e;

    /* renamed from: d */
    private static C0934p m7920d(int i, InterfaceC0976d interfaceC0976d, C0928j c0928j) {
        C0934p c0934p;
        synchronized (f5898a) {
            f5899b.m7943a(i, interfaceC0976d, c0928j);
            c0934p = f5898a.get(f5899b);
            if (c0934p == null) {
                c0934p = f5899b.m7942a();
                f5898a.put(c0934p, c0934p);
            }
        }
        return c0934p;
    }

    /* renamed from: a */
    public static C0934p m7913a(int i, InterfaceC0976d interfaceC0976d) {
        return m7920d(i, interfaceC0976d, null);
    }

    /* renamed from: a */
    public static C0934p m7914a(int i, InterfaceC0976d interfaceC0976d, C0928j c0928j) {
        if (c0928j == null) {
            throw new NullPointerException("local  == null");
        }
        return m7920d(i, interfaceC0976d, c0928j);
    }

    /* renamed from: b */
    public static C0934p m7918b(int i, InterfaceC0976d interfaceC0976d, C0928j c0928j) {
        return m7920d(i, interfaceC0976d, c0928j);
    }

    /* renamed from: a */
    public static String m7915a(int i) {
        return "v" + i;
    }

    private C0934p(int i, InterfaceC0976d interfaceC0976d, C0928j c0928j) {
        if (i < 0) {
            throw new IllegalArgumentException("reg < 0");
        }
        if (interfaceC0976d == null) {
            throw new NullPointerException("type == null");
        }
        this.f5900c = i;
        this.f5901d = interfaceC0976d;
        this.f5902e = c0928j;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0934p)) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return m7921e(aVar.f5903a, aVar.f5904b, aVar.f5905c);
            }
            return false;
        }
        C0934p c0934p = (C0934p) obj;
        return m7921e(c0934p.f5900c, c0934p.f5901d, c0934p.f5902e);
    }

    /* renamed from: a */
    public boolean m7926a(C0934p c0934p) {
        return m7928b(c0934p) && this.f5900c == c0934p.f5900c;
    }

    /* renamed from: b */
    public boolean m7928b(C0934p c0934p) {
        if (c0934p != null && this.f5901d.mo6695a().equals(c0934p.f5901d.mo6695a())) {
            return this.f5902e == c0934p.f5902e || (this.f5902e != null && this.f5902e.equals(c0934p.f5902e));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m7921e(int i, InterfaceC0976d interfaceC0976d, C0928j c0928j) {
        return this.f5900c == i && this.f5901d.equals(interfaceC0976d) && (this.f5902e == c0928j || (this.f5902e != null && this.f5902e.equals(c0928j)));
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0934p c0934p) {
        if (this.f5900c < c0934p.f5900c) {
            return -1;
        }
        if (this.f5900c > c0934p.f5900c) {
            return 1;
        }
        int compareTo = this.f5901d.mo6695a().compareTo(c0934p.f5901d.mo6695a());
        if (compareTo != 0) {
            return compareTo;
        }
        if (this.f5902e == null) {
            return c0934p.f5902e == null ? 0 : -1;
        }
        if (c0934p.f5902e == null) {
            return 1;
        }
        return this.f5902e.compareTo(c0934p.f5902e);
    }

    public int hashCode() {
        return m7922f(this.f5900c, this.f5901d, this.f5902e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static int m7922f(int i, InterfaceC0976d interfaceC0976d, C0928j c0928j) {
        return ((((c0928j != null ? c0928j.hashCode() : 0) * 31) + interfaceC0976d.hashCode()) * 31) + i;
    }

    public String toString() {
        return m7916a(false);
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return m7916a(true);
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return this.f5901d.mo6695a();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: b */
    public InterfaceC0976d mo6696b() {
        return this.f5901d.mo6696b();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: c */
    public final int mo6697c() {
        return this.f5901d.mo6697c();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: e */
    public final int mo6698e() {
        return this.f5901d.mo6698e();
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: f */
    public final boolean mo6699f() {
        return false;
    }

    /* renamed from: g */
    public int m7931g() {
        return this.f5900c;
    }

    /* renamed from: h */
    public InterfaceC0976d m7932h() {
        return this.f5901d;
    }

    /* renamed from: i */
    public C0928j m7933i() {
        return this.f5902e;
    }

    /* renamed from: j */
    public int m7934j() {
        return this.f5900c + m7935k();
    }

    /* renamed from: k */
    public int m7935k() {
        return this.f5901d.mo6695a().m8127j();
    }

    /* renamed from: l */
    public boolean m7936l() {
        return this.f5901d.mo6695a().m8129l();
    }

    /* renamed from: m */
    public String m7937m() {
        return m7915a(this.f5900c);
    }

    /* renamed from: a */
    public C0934p m7924a(C0934p c0934p, boolean z) {
        C0975c mo6695a;
        if (this == c0934p) {
            return this;
        }
        if (c0934p == null || this.f5900c != c0934p.m7931g()) {
            return null;
        }
        C0928j c0928j = (this.f5902e == null || !this.f5902e.equals(c0934p.m7933i())) ? null : this.f5902e;
        boolean z2 = c0928j == this.f5902e;
        if ((z && !z2) || (mo6695a = mo6695a()) != c0934p.mo6695a()) {
            return null;
        }
        InterfaceC0976d interfaceC0976d = this.f5901d.equals(c0934p.m7932h()) ? this.f5901d : mo6695a;
        if (interfaceC0976d == this.f5901d && z2) {
            return this;
        }
        return c0928j == null ? m7913a(this.f5900c, interfaceC0976d) : m7914a(this.f5900c, interfaceC0976d, c0928j);
    }

    /* renamed from: b */
    public C0934p m7927b(int i) {
        return this.f5900c == i ? this : m7918b(i, this.f5901d, this.f5902e);
    }

    /* renamed from: a */
    public C0934p m7925a(InterfaceC0976d interfaceC0976d) {
        return m7918b(this.f5900c, interfaceC0976d, this.f5902e);
    }

    /* renamed from: c */
    public C0934p m7930c(int i) {
        return i == 0 ? this : m7927b(this.f5900c + i);
    }

    /* renamed from: n */
    public C0934p m7938n() {
        C0975c mo6695a;
        InterfaceC0976d interfaceC0976d = this.f5901d;
        if (interfaceC0976d instanceof C0975c) {
            mo6695a = (C0975c) interfaceC0976d;
        } else {
            mo6695a = interfaceC0976d.mo6695a();
        }
        if (mo6695a.m8135r()) {
            mo6695a = mo6695a.m8136s();
        }
        return mo6695a == interfaceC0976d ? this : m7918b(this.f5900c, mo6695a, this.f5902e);
    }

    /* renamed from: a */
    public C0934p m7923a(C0928j c0928j) {
        if (this.f5902e != c0928j) {
            return (this.f5902e == null || !this.f5902e.equals(c0928j)) ? m7918b(this.f5900c, this.f5901d, c0928j) : this;
        }
        return this;
    }

    /* renamed from: a */
    private String m7916a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(40);
        stringBuffer.append(m7937m());
        stringBuffer.append(":");
        if (this.f5902e != null) {
            stringBuffer.append(this.f5902e.toString());
        }
        C0975c mo6695a = this.f5901d.mo6695a();
        stringBuffer.append(mo6695a);
        if (mo6695a != this.f5901d) {
            stringBuffer.append("=");
            if (z && (this.f5901d instanceof C0970x)) {
                stringBuffer.append(((C0970x) this.f5901d).m8083i());
            } else if (z && (this.f5901d instanceof AbstractC0945a)) {
                stringBuffer.append(this.f5901d.mo6681d());
            } else {
                stringBuffer.append(this.f5901d);
            }
        }
        return stringBuffer.toString();
    }

    /* compiled from: RegisterSpec.java */
    /* renamed from: com.b.b.f.b.p$a */
    private static class a {

        /* renamed from: a */
        private int f5903a;

        /* renamed from: b */
        private InterfaceC0976d f5904b;

        /* renamed from: c */
        private C0928j f5905c;

        private a() {
        }

        /* renamed from: a */
        public void m7943a(int i, InterfaceC0976d interfaceC0976d, C0928j c0928j) {
            this.f5903a = i;
            this.f5904b = interfaceC0976d;
            this.f5905c = c0928j;
        }

        /* renamed from: a */
        public C0934p m7942a() {
            return new C0934p(this.f5903a, this.f5904b, this.f5905c);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0934p) {
                return ((C0934p) obj).m7921e(this.f5903a, this.f5904b, this.f5905c);
            }
            return false;
        }

        public int hashCode() {
            return C0934p.m7922f(this.f5903a, this.f5904b, this.f5905c);
        }
    }
}
