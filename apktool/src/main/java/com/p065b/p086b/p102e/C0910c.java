package com.p065b.p086b.p102e;

import com.p065b.p086b.p095c.C0825c;
import com.p065b.p086b.p100d.C0874a;
import com.p065b.p086b.p100d.C0895c;
import com.p065b.p086b.p100d.C0898f;
import com.p065b.p086b.p100d.C0900h;
import com.p065b.p086b.p100d.C0901i;
import com.p065b.p086b.p100d.C0902j;
import com.p065b.p086b.p100d.C0904l;
import com.p065b.p086b.p100d.C0907o;
import com.p065b.p086b.p110h.C1009ab;
import com.p065b.p086b.p110h.C1014e;
import com.p065b.p086b.p110h.C1029t;
import com.p065b.p086b.p110h.InterfaceC1016g;
import com.p065b.p086b.p110h.InterfaceC1017h;
import java.util.HashMap;

/* compiled from: IndexMap.java */
/* renamed from: com.b.b.e.c */
/* loaded from: classes.dex */
public final class C0910c {

    /* renamed from: a */
    public final int[] f5814a;

    /* renamed from: b */
    public final short[] f5815b;

    /* renamed from: c */
    public final short[] f5816c;

    /* renamed from: d */
    public final short[] f5817d;

    /* renamed from: e */
    public final short[] f5818e;

    /* renamed from: f */
    private final C0898f f5819f;

    /* renamed from: g */
    private final HashMap<Integer, Integer> f5820g = new HashMap<>();

    /* renamed from: h */
    private final HashMap<Integer, Integer> f5821h = new HashMap<>();

    /* renamed from: i */
    private final HashMap<Integer, Integer> f5822i = new HashMap<>();

    /* renamed from: j */
    private final HashMap<Integer, Integer> f5823j = new HashMap<>();

    public C0910c(C0898f c0898f, C0825c c0825c) {
        this.f5819f = c0898f;
        this.f5814a = new int[c0825c.f5117b.f5143b];
        this.f5815b = new short[c0825c.f5118c.f5143b];
        this.f5816c = new short[c0825c.f5119d.f5143b];
        this.f5817d = new short[c0825c.f5120e.f5143b];
        this.f5818e = new short[c0825c.f5121f.f5143b];
        this.f5820g.put(0, 0);
        this.f5822i.put(0, 0);
        this.f5823j.put(0, 0);
    }

    /* renamed from: a */
    public void m7786a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f5820g.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: b */
    public void m7789b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f5821h.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: c */
    public void m7791c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f5822i.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: d */
    public void m7793d(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.f5823j.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* renamed from: a */
    public int m7777a(int i) {
        if (i == -1) {
            return -1;
        }
        return this.f5814a[i];
    }

    /* renamed from: b */
    public int m7787b(int i) {
        if (i == -1) {
            return -1;
        }
        return this.f5815b[i] & 65535;
    }

    /* renamed from: a */
    public C0913f m7785a(C0913f c0913f) {
        if (c0913f != C0913f.f5839a) {
            short[] sArr = (short[]) c0913f.m7815a().clone();
            for (int i = 0; i < sArr.length; i++) {
                sArr[i] = (short) m7787b(sArr[i]);
            }
            return new C0913f(this.f5819f, sArr);
        }
        return c0913f;
    }

    /* renamed from: c */
    public int m7790c(int i) {
        return this.f5816c[i] & 65535;
    }

    /* renamed from: d */
    public int m7792d(int i) {
        return this.f5817d[i] & 65535;
    }

    /* renamed from: e */
    public int m7794e(int i) {
        return this.f5818e[i] & 65535;
    }

    /* renamed from: f */
    public int m7795f(int i) {
        return this.f5820g.get(Integer.valueOf(i)).intValue();
    }

    /* renamed from: g */
    public int m7796g(int i) {
        return this.f5821h.get(Integer.valueOf(i)).intValue();
    }

    /* renamed from: h */
    public int m7797h(int i) {
        return this.f5822i.get(Integer.valueOf(i)).intValue();
    }

    /* renamed from: i */
    public int m7798i(int i) {
        return this.f5823j.get(Integer.valueOf(i)).intValue();
    }

    /* renamed from: a */
    public C0904l m7782a(C0904l c0904l) {
        return new C0904l(this.f5819f, m7787b(c0904l.m7679a()), m7790c(c0904l.m7682b()), m7777a(c0904l.m7683c()));
    }

    /* renamed from: a */
    public C0902j m7781a(C0902j c0902j) {
        return new C0902j(this.f5819f, m7787b(c0902j.m7674a()), m7787b(c0902j.m7677b()), m7777a(c0902j.m7678c()));
    }

    /* renamed from: a */
    public C0907o m7783a(C0907o c0907o) {
        return new C0907o(this.f5819f, m7777a(c0907o.m7696a()), m7787b(c0907o.m7699b()), m7795f(c0907o.m7700c()));
    }

    /* renamed from: a */
    public C0895c m7779a(C0895c c0895c) {
        return new C0895c(this.f5819f, c0895c.m7553a(), m7787b(c0895c.m7554b()), c0895c.m7558f(), m7787b(c0895c.m7555c()), m7795f(c0895c.m7556d()), c0895c.m7559g(), c0895c.m7560h(), c0895c.m7561i(), c0895c.m7562j());
    }

    /* renamed from: a */
    public C0912e m7784a(C0912e c0912e) {
        return new C0912e(c0912e.m7808a(), m7779a(c0912e.m7810b()));
    }

    /* renamed from: a */
    public C0900h m7780a(C0900h c0900h) {
        C1014e c1014e = new C1014e(32);
        new a(c0900h, c1014e).m7666c();
        return new C0900h(c1014e.m8527f());
    }

    /* renamed from: b */
    public C0900h m7788b(C0900h c0900h) {
        C1014e c1014e = new C1014e(32);
        new a(c0900h, c1014e).m7659a();
        return new C0900h(c1014e.m8527f());
    }

    /* renamed from: a */
    public C0874a m7778a(C0874a c0874a) {
        int[] iArr = (int[]) c0874a.m7445c().clone();
        C0900h[] c0900hArr = (C0900h[]) c0874a.m7446d().clone();
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = m7777a(iArr[i]);
            c0900hArr[i] = m7780a(c0900hArr[i]);
        }
        return new C0874a(this.f5819f, c0874a.m7441a(), m7787b(c0874a.m7444b()), iArr, c0900hArr);
    }

    /* compiled from: IndexMap.java */
    /* renamed from: com.b.b.e.c$a */
    private final class a extends C0901i {

        /* renamed from: c */
        private final InterfaceC1017h f5825c;

        public a(C0900h c0900h, InterfaceC1017h interfaceC1017h) {
            super(c0900h);
            this.f5825c = interfaceC1017h;
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: a */
        protected void mo7660a(int i) {
            C1029t.m8590a(this.f5825c, i);
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: a */
        protected void mo7661a(int i, int i2) {
            C1029t.m8590a(this.f5825c, C0910c.this.m7787b(i));
            C1029t.m8590a(this.f5825c, i2);
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: b */
        protected void mo7664b(int i) {
            C1029t.m8590a(this.f5825c, C0910c.this.m7777a(i));
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: a */
        protected void mo7662a(int i, int i2, int i3, int i4) {
            this.f5825c.mo7631c(i);
            m7799a(this.f5469a, this.f5825c, i4);
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: b */
        protected void mo7665b(int i, int i2) {
            m7800f(i, C0910c.this.m7777a(i2));
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: c */
        protected void mo7668c(int i, int i2) {
            m7800f(i, C0910c.this.m7787b(i2));
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: d */
        protected void mo7670d(int i, int i2) {
            m7800f(i, C0910c.this.m7792d(i2));
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: e */
        protected void mo7672e(int i, int i2) {
            m7800f(i, C0910c.this.m7794e(i2));
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: c */
        protected void mo7667c(int i) {
            this.f5825c.mo7631c(i);
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: d */
        protected void mo7669d(int i) {
            this.f5825c.mo7631c(i);
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: e */
        protected void mo7671e(int i) {
            this.f5825c.mo7631c(i);
        }

        @Override // com.p065b.p086b.p100d.C0901i
        /* renamed from: f */
        protected void mo7673f(int i) {
            this.f5825c.mo7631c(i);
        }

        /* renamed from: f */
        private void m7800f(int i, int i2) {
            int i3;
            if (C1009ab.m8473a(i2, 255) <= 0) {
                i3 = 1;
            } else if (C1009ab.m8473a(i2, 65535) <= 0) {
                i3 = 2;
            } else if (C1009ab.m8473a(i2, 16777215) <= 0) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            this.f5825c.mo7631c(((i3 - 1) << 5) | i);
            for (int i4 = 0; i4 < i3; i4++) {
                this.f5825c.mo7631c(i2 & 255);
                i2 >>>= 8;
            }
        }

        /* renamed from: a */
        private void m7799a(InterfaceC1016g interfaceC1016g, InterfaceC1017h interfaceC1017h, int i) {
            for (int i2 = 0; i2 < i; i2++) {
                interfaceC1017h.mo7631c(interfaceC1016g.mo7634e());
            }
        }
    }
}
