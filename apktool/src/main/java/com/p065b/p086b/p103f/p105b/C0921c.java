package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p105b.AbstractC0926h;
import com.p065b.p086b.p110h.C1022m;
import com.p065b.p086b.p110h.C1025p;
import com.p065b.p086b.p110h.C1028s;
import com.p065b.p086b.p110h.InterfaceC1027r;

/* compiled from: BasicBlockList.java */
/* renamed from: com.b.b.f.b.c */
/* loaded from: classes.dex */
public final class C0921c extends C1028s {

    /* renamed from: a */
    private int f5860a;

    public C0921c(int i) {
        super(i);
        this.f5860a = -1;
    }

    private C0921c(C0921c c0921c) {
        super(c0921c);
        this.f5860a = c0921c.f5860a;
    }

    /* renamed from: a */
    public C0920b m7854a(int i) {
        return (C0920b) m8548e(i);
    }

    /* renamed from: a */
    public void m7856a(int i, C0920b c0920b) {
        super.m8585a(i, (InterfaceC1027r) c0920b);
        this.f5860a = -1;
    }

    /* renamed from: e */
    public int m7859e() {
        if (this.f5860a == -1) {
            a aVar = new a();
            m7857a(aVar);
            this.f5860a = aVar.m7865a();
        }
        return this.f5860a;
    }

    /* renamed from: f */
    public int m7860f() {
        int f_ = m8550f_();
        int i = 0;
        int i2 = 0;
        while (i < f_) {
            C0920b c0920b = (C0920b) m8549f(i);
            i++;
            i2 = c0920b != null ? c0920b.m7846b().m8550f_() + i2 : i2;
        }
        return i2;
    }

    /* renamed from: g */
    public int m7861g() {
        int i;
        int f_ = m8550f_();
        int i2 = 0;
        int i3 = 0;
        while (i2 < f_) {
            C0920b c0920b = (C0920b) m8549f(i2);
            if (c0920b != null) {
                C0927i m7846b = c0920b.m7846b();
                int f_2 = m7846b.m8550f_();
                i = i3;
                for (int i4 = 0; i4 < f_2; i4++) {
                    if (m7846b.m7889a(i4).m7882f().m7968a() != 54) {
                        i++;
                    }
                }
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        return i3;
    }

    /* renamed from: b */
    public C0920b m7858b(int i) {
        int c2 = m8586c(i);
        if (c2 < 0) {
            throw new IllegalArgumentException("no such label: " + C1022m.m8557c(i));
        }
        return m7854a(c2);
    }

    /* renamed from: a */
    public void m7857a(AbstractC0926h.b bVar) {
        int f_ = m8550f_();
        for (int i = 0; i < f_; i++) {
            m7854a(i).m7846b().m7891a(bVar);
        }
    }

    /* renamed from: h */
    public C0921c m7862h() {
        return new C0921c(this);
    }

    /* renamed from: a */
    public C0920b m7855a(C0920b c0920b) {
        int m7848d = c0920b.m7848d();
        C1025p m7847c = c0920b.m7847c();
        switch (m7847c.m8568b()) {
            case 0:
                return null;
            case 1:
                return m7858b(m7847c.m8569b(0));
            default:
                if (m7848d != -1) {
                    return m7858b(m7848d);
                }
                return m7858b(m7847c.m8569b(0));
        }
    }

    /* compiled from: BasicBlockList.java */
    /* renamed from: com.b.b.f.b.c$a */
    private static class a implements AbstractC0926h.b {

        /* renamed from: a */
        private int f5861a = 0;

        /* renamed from: a */
        public int m7865a() {
            return this.f5861a;
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7178a(C0932n c0932n) {
            m7863a((AbstractC0926h) c0932n);
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7176a(C0931m c0931m) {
            m7863a((AbstractC0926h) c0931m);
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7179a(C0941w c0941w) {
            m7863a((AbstractC0926h) c0941w);
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7180a(C0942x c0942x) {
            m7863a((AbstractC0926h) c0942x);
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7181a(C0943y c0943y) {
            m7863a((AbstractC0926h) c0943y);
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7185a(C0925g c0925g) {
            m7863a((AbstractC0926h) c0925g);
        }

        /* renamed from: a */
        private void m7863a(AbstractC0926h abstractC0926h) {
            C0934p m7884h = abstractC0926h.m7884h();
            if (m7884h != null) {
                m7864a(m7884h);
            }
            C0935q m7886j = abstractC0926h.m7886j();
            int f_ = m7886j.m8550f_();
            for (int i = 0; i < f_; i++) {
                m7864a(m7886j.m7949b(i));
            }
        }

        /* renamed from: a */
        private void m7864a(C0934p c0934p) {
            int m7934j = c0934p.m7934j();
            if (m7934j > this.f5861a) {
                this.f5861a = m7934j;
            }
        }
    }
}
