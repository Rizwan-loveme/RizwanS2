package com.p065b.p086b.p087a.p089b;

import com.p065b.p086b.p103f.p105b.C0928j;
import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p110h.C1021l;

/* compiled from: LocalVariableList.java */
/* renamed from: com.b.b.a.b.l */
/* loaded from: classes.dex */
public final class C0716l extends C1021l {

    /* renamed from: a */
    public static final C0716l f4546a = new C0716l(0);

    /* renamed from: a */
    public static C0716l m6653a(C0716l c0716l, C0716l c0716l2) {
        if (c0716l != f4546a) {
            int f_ = c0716l.m8550f_();
            int f_2 = c0716l2.m8550f_();
            C0716l c0716l3 = new C0716l(f_ + f_2);
            for (int i = 0; i < f_; i++) {
                c0716l3.m6659a(i, c0716l.m6655a(i));
            }
            for (int i2 = 0; i2 < f_2; i2++) {
                c0716l3.m6659a(f_ + i2, c0716l2.m6655a(i2));
            }
            c0716l3.mo6683e_();
            return c0716l3;
        }
        return c0716l2;
    }

    /* renamed from: b */
    public static C0716l m6654b(C0716l c0716l, C0716l c0716l2) {
        int f_ = c0716l.m8550f_();
        C0716l c0716l3 = new C0716l(f_);
        for (int i = 0; i < f_; i++) {
            a m6655a = c0716l.m6655a(i);
            a m6657a = c0716l2.m6657a(m6655a);
            if (m6657a != null) {
                m6655a = m6655a.m6662a(m6657a.m6661c());
            }
            c0716l3.m6659a(i, m6655a);
        }
        c0716l3.mo6683e_();
        return c0716l3;
    }

    public C0716l(int i) {
        super(i);
    }

    /* renamed from: a */
    public a m6655a(int i) {
        return (a) m8548e(i);
    }

    /* renamed from: a */
    public void m6659a(int i, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("item == null");
        }
        m8546a(i, (Object) aVar);
    }

    /* renamed from: a */
    public void m6658a(int i, int i2, int i3, C0970x c0970x, C0970x c0970x2, C0970x c0970x3, int i4) {
        m8546a(i, (Object) new a(i2, i3, c0970x, c0970x2, c0970x3, i4));
    }

    /* renamed from: a */
    public a m6657a(a aVar) {
        int f_ = m8550f_();
        for (int i = 0; i < f_; i++) {
            a aVar2 = (a) m8548e(i);
            if (aVar2 != null && aVar2.m6665a(aVar)) {
                return aVar2;
            }
        }
        return null;
    }

    /* renamed from: a */
    public a m6656a(int i, int i2) {
        int f_ = m8550f_();
        for (int i3 = 0; i3 < f_; i3++) {
            a aVar = (a) m8548e(i3);
            if (aVar != null && aVar.m6664a(i, i2)) {
                return aVar;
            }
        }
        return null;
    }

    /* compiled from: LocalVariableList.java */
    /* renamed from: com.b.b.a.b.l$a */
    public static class a {

        /* renamed from: a */
        private final int f4547a;

        /* renamed from: b */
        private final int f4548b;

        /* renamed from: c */
        private final C0970x f4549c;

        /* renamed from: d */
        private final C0970x f4550d;

        /* renamed from: e */
        private final C0970x f4551e;

        /* renamed from: f */
        private final int f4552f;

        public a(int i, int i2, C0970x c0970x, C0970x c0970x2, C0970x c0970x3, int i3) {
            if (i < 0) {
                throw new IllegalArgumentException("startPc < 0");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("length < 0");
            }
            if (c0970x == null) {
                throw new NullPointerException("name == null");
            }
            if (c0970x2 == null && c0970x3 == null) {
                throw new NullPointerException("(descriptor == null) && (signature == null)");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("index < 0");
            }
            this.f4547a = i;
            this.f4548b = i2;
            this.f4549c = c0970x;
            this.f4550d = c0970x2;
            this.f4551e = c0970x3;
            this.f4552f = i3;
        }

        /* renamed from: a */
        public C0928j m6663a() {
            return C0928j.m7894a(this.f4549c, this.f4551e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public C0970x m6661c() {
            return this.f4551e;
        }

        /* renamed from: b */
        public C0975c m6666b() {
            return C0975c.m8118a(this.f4550d.m8084j());
        }

        /* renamed from: a */
        public a m6662a(C0970x c0970x) {
            return new a(this.f4547a, this.f4548b, this.f4549c, this.f4550d, c0970x, this.f4552f);
        }

        /* renamed from: a */
        public boolean m6664a(int i, int i2) {
            return i2 == this.f4552f && i >= this.f4547a && i < this.f4547a + this.f4548b;
        }

        /* renamed from: a */
        public boolean m6665a(a aVar) {
            return this.f4547a == aVar.f4547a && this.f4548b == aVar.f4548b && this.f4552f == aVar.f4552f && this.f4549c.equals(aVar.f4549c);
        }
    }
}
