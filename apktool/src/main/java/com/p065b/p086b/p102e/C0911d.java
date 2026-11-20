package com.p065b.p086b.p102e;

import com.p065b.p086b.p100d.C0897e;
import com.p065b.p086b.p100d.p101a.AbstractC0880f;
import com.p065b.p086b.p100d.p101a.C0889o;
import com.p065b.p086b.p110h.C1018i;

/* compiled from: InstructionTransformer.java */
/* renamed from: com.b.b.e.d */
/* loaded from: classes.dex */
final class C0911d {

    /* renamed from: a */
    private final C0910c f5826a;

    /* renamed from: b */
    private final C0897e f5827b = new C0897e();

    /* renamed from: c */
    private AbstractC0880f[] f5828c;

    /* renamed from: d */
    private int f5829d;

    /* renamed from: b */
    static /* synthetic */ int m7803b(C0911d c0911d) {
        int i = c0911d.f5829d;
        c0911d.f5829d = i + 1;
        return i;
    }

    public C0911d(C0910c c0910c) {
        this.f5826a = c0910c;
        this.f5827b.m7576a(new b());
        this.f5827b.m7578b(new d());
        this.f5827b.m7579c(new e());
        this.f5827b.m7580d(new a());
        this.f5827b.m7581e(new c());
    }

    /* renamed from: a */
    public short[] m7806a(short[] sArr) {
        AbstractC0880f[] m7467a = AbstractC0880f.m7467a(sArr);
        int length = m7467a.length;
        this.f5828c = new AbstractC0880f[length];
        this.f5829d = 0;
        this.f5827b.m7577a(m7467a);
        C0889o c0889o = new C0889o(length);
        for (AbstractC0880f abstractC0880f : this.f5828c) {
            if (abstractC0880f != null) {
                abstractC0880f.m7470a(c0889o);
            }
        }
        return c0889o.m7541c();
    }

    /* compiled from: InstructionTransformer.java */
    /* renamed from: com.b.b.e.d$b */
    private class b implements C0897e.a {
        private b() {
        }

        @Override // com.p065b.p086b.p100d.C0897e.a
        /* renamed from: a */
        public void mo7582a(AbstractC0880f[] abstractC0880fArr, AbstractC0880f abstractC0880f) {
            C0911d.this.f5828c[C0911d.m7803b(C0911d.this)] = abstractC0880f;
        }
    }

    /* compiled from: InstructionTransformer.java */
    /* renamed from: com.b.b.e.d$d */
    private class d implements C0897e.a {
        private d() {
        }

        @Override // com.p065b.p086b.p100d.C0897e.a
        /* renamed from: a */
        public void mo7582a(AbstractC0880f[] abstractC0880fArr, AbstractC0880f abstractC0880f) {
            int m7475d = abstractC0880f.m7475d();
            int m7777a = C0911d.this.f5826a.m7777a(m7475d);
            C0911d.m7804b(m7475d, m7777a);
            C0911d.this.f5828c[C0911d.m7803b(C0911d.this)] = abstractC0880f.mo7476d(m7777a);
        }
    }

    /* compiled from: InstructionTransformer.java */
    /* renamed from: com.b.b.e.d$a */
    private class a implements C0897e.a {
        private a() {
        }

        @Override // com.p065b.p086b.p100d.C0897e.a
        /* renamed from: a */
        public void mo7582a(AbstractC0880f[] abstractC0880fArr, AbstractC0880f abstractC0880f) {
            int m7475d = abstractC0880f.m7475d();
            int m7792d = C0911d.this.f5826a.m7792d(m7475d);
            C0911d.m7804b(m7475d, m7792d);
            C0911d.this.f5828c[C0911d.m7803b(C0911d.this)] = abstractC0880f.mo7476d(m7792d);
        }
    }

    /* compiled from: InstructionTransformer.java */
    /* renamed from: com.b.b.e.d$e */
    private class e implements C0897e.a {
        private e() {
        }

        @Override // com.p065b.p086b.p100d.C0897e.a
        /* renamed from: a */
        public void mo7582a(AbstractC0880f[] abstractC0880fArr, AbstractC0880f abstractC0880f) {
            int m7475d = abstractC0880f.m7475d();
            int m7787b = C0911d.this.f5826a.m7787b(m7475d);
            C0911d.m7804b(m7475d, m7787b);
            C0911d.this.f5828c[C0911d.m7803b(C0911d.this)] = abstractC0880f.mo7476d(m7787b);
        }
    }

    /* compiled from: InstructionTransformer.java */
    /* renamed from: com.b.b.e.d$c */
    private class c implements C0897e.a {
        private c() {
        }

        @Override // com.p065b.p086b.p100d.C0897e.a
        /* renamed from: a */
        public void mo7582a(AbstractC0880f[] abstractC0880fArr, AbstractC0880f abstractC0880f) {
            int m7475d = abstractC0880f.m7475d();
            int m7794e = C0911d.this.f5826a.m7794e(m7475d);
            C0911d.m7804b(m7475d, m7794e);
            C0911d.this.f5828c[C0911d.m7803b(C0911d.this)] = abstractC0880f.mo7476d(m7794e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m7804b(int i, int i2) {
        if (i <= 65535 && i2 > 65535) {
            throw new C1018i("Cannot handle conversion to jumbo index!");
        }
    }
}
