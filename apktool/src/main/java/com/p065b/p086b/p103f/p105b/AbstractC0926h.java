package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p107d.C0974b;
import com.p065b.p086b.p103f.p107d.C0975c;
import com.p065b.p086b.p103f.p107d.InterfaceC0977e;
import com.p065b.p086b.p110h.InterfaceC1035z;

/* compiled from: Insn.java */
/* renamed from: com.b.b.f.b.h */
/* loaded from: classes.dex */
public abstract class AbstractC0926h implements InterfaceC1035z {

    /* renamed from: a */
    private final C0937s f5884a;

    /* renamed from: b */
    private final C0940v f5885b;

    /* renamed from: c */
    private final C0934p f5886c;

    /* renamed from: d */
    private final C0935q f5887d;

    /* compiled from: Insn.java */
    /* renamed from: com.b.b.f.b.h$b */
    public interface b {
        /* renamed from: a */
        void mo7185a(C0925g c0925g);

        /* renamed from: a */
        void mo7176a(C0931m c0931m);

        /* renamed from: a */
        void mo7178a(C0932n c0932n);

        /* renamed from: a */
        void mo7179a(C0941w c0941w);

        /* renamed from: a */
        void mo7180a(C0942x c0942x);

        /* renamed from: a */
        void mo7181a(C0943y c0943y);
    }

    /* renamed from: a */
    public abstract AbstractC0926h mo7873a(C0934p c0934p, C0935q c0935q);

    /* renamed from: a */
    public abstract AbstractC0926h mo7874a(C0975c c0975c);

    /* renamed from: a */
    public abstract void mo7875a(b bVar);

    /* renamed from: b */
    public abstract InterfaceC0977e mo7876b();

    public AbstractC0926h(C0937s c0937s, C0940v c0940v, C0934p c0934p, C0935q c0935q) {
        if (c0937s == null) {
            throw new NullPointerException("opcode == null");
        }
        if (c0940v == null) {
            throw new NullPointerException("position == null");
        }
        if (c0935q == null) {
            throw new NullPointerException("sources == null");
        }
        this.f5884a = c0937s;
        this.f5885b = c0940v;
        this.f5886c = c0934p;
        this.f5887d = c0935q;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public String toString() {
        return m7880a(mo7866a());
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        return m7881b(mo7866a());
    }

    /* renamed from: a */
    public String mo7866a() {
        return null;
    }

    /* renamed from: f */
    public final C0937s m7882f() {
        return this.f5884a;
    }

    /* renamed from: g */
    public final C0940v m7883g() {
        return this.f5885b;
    }

    /* renamed from: h */
    public final C0934p m7884h() {
        return this.f5886c;
    }

    /* renamed from: i */
    public final C0934p m7885i() {
        C0934p c0934p;
        if (this.f5884a.m7968a() == 54) {
            c0934p = this.f5887d.m7949b(0);
        } else {
            c0934p = this.f5886c;
        }
        if (c0934p == null || c0934p.m7933i() == null) {
            return null;
        }
        return c0934p;
    }

    /* renamed from: j */
    public final C0935q m7886j() {
        return this.f5887d;
    }

    /* renamed from: k */
    public final boolean m7887k() {
        return this.f5884a.m7975h();
    }

    /* renamed from: l */
    public AbstractC0926h mo7888l() {
        return this;
    }

    /* renamed from: a */
    private static boolean m7879a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public boolean mo7867a(AbstractC0926h abstractC0926h) {
        return this.f5884a == abstractC0926h.m7882f() && this.f5885b.equals(abstractC0926h.m7883g()) && getClass() == abstractC0926h.getClass() && m7879a(this.f5886c, abstractC0926h.m7884h()) && m7879a(this.f5887d, abstractC0926h.m7886j()) && C0974b.m8110a(mo7876b(), abstractC0926h.mo7876b());
    }

    /* renamed from: a */
    protected final String m7880a(String str) {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append("Insn{");
        stringBuffer.append(this.f5885b);
        stringBuffer.append(' ');
        stringBuffer.append(this.f5884a);
        if (str != null) {
            stringBuffer.append(' ');
            stringBuffer.append(str);
        }
        stringBuffer.append(" :: ");
        if (this.f5886c != null) {
            stringBuffer.append(this.f5886c);
            stringBuffer.append(" <- ");
        }
        stringBuffer.append(this.f5887d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    /* renamed from: b */
    protected final String m7881b(String str) {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append(this.f5885b);
        stringBuffer.append(": ");
        stringBuffer.append(this.f5884a.m7974g());
        if (str != null) {
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")");
        }
        if (this.f5886c == null) {
            stringBuffer.append(" .");
        } else {
            stringBuffer.append(" ");
            stringBuffer.append(this.f5886c.mo6681d());
        }
        stringBuffer.append(" <-");
        int f_ = this.f5887d.m8550f_();
        if (f_ == 0) {
            stringBuffer.append(" .");
        } else {
            for (int i = 0; i < f_; i++) {
                stringBuffer.append(" ");
                stringBuffer.append(this.f5887d.m7949b(i).mo6681d());
            }
        }
        return stringBuffer.toString();
    }

    /* compiled from: Insn.java */
    /* renamed from: com.b.b.f.b.h$a */
    public static class a implements b {
        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7178a(C0932n c0932n) {
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7176a(C0931m c0931m) {
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7179a(C0941w c0941w) {
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7180a(C0942x c0942x) {
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7181a(C0943y c0943y) {
        }

        @Override // com.p065b.p086b.p103f.p105b.AbstractC0926h.b
        /* renamed from: a */
        public void mo7185a(C0925g c0925g) {
        }
    }
}
