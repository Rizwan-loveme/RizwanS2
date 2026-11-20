package ru.p294a;

/* compiled from: GeneralPurposeBit.java */
/* renamed from: ru.a.f */
/* loaded from: classes.dex */
public final class C2587f implements Cloneable {

    /* renamed from: a */
    private boolean f13430a = false;

    /* renamed from: b */
    private boolean f13431b = false;

    /* renamed from: c */
    private boolean f13432c = false;

    /* renamed from: d */
    private boolean f13433d = false;

    /* renamed from: a */
    public boolean m16083a() {
        return this.f13430a;
    }

    /* renamed from: a */
    public void m16081a(boolean z) {
        this.f13430a = z;
    }

    /* renamed from: b */
    public void m16084b(boolean z) {
        this.f13431b = z;
    }

    /* renamed from: b */
    public boolean m16085b() {
        return this.f13432c;
    }

    /* renamed from: c */
    public void m16086c(boolean z) {
        this.f13432c = z;
    }

    /* renamed from: d */
    public void m16087d(boolean z) {
        this.f13433d = z;
        if (z) {
            m16086c(true);
        }
    }

    /* renamed from: a */
    public void m16082a(byte[] bArr, int i) {
        C2607z.m16239a((this.f13432c ? 1 : 0) | (this.f13430a ? 2048 : 0) | (this.f13431b ? 8 : 0) | (this.f13433d ? 64 : 0), bArr, i);
    }

    /* renamed from: b */
    public static C2587f m16080b(byte[] bArr, int i) {
        int m16238a = C2607z.m16238a(bArr, i);
        C2587f c2587f = new C2587f();
        c2587f.m16084b((m16238a & 8) != 0);
        c2587f.m16081a((m16238a & 2048) != 0);
        c2587f.m16087d((m16238a & 64) != 0);
        c2587f.m16086c((m16238a & 1) != 0);
        return c2587f;
    }

    public int hashCode() {
        return ((((this.f13430a ? 1 : 0) + (((this.f13433d ? 1 : 0) + ((this.f13432c ? 1 : 0) * 17)) * 13)) * 7) + (this.f13431b ? 1 : 0)) * 3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2587f)) {
            return false;
        }
        C2587f c2587f = (C2587f) obj;
        if (c2587f.f13432c) {
            if (!this.f13432c) {
                return false;
            }
        } else if (this.f13432c) {
            return false;
        }
        if (c2587f.f13433d) {
            if (!this.f13433d) {
                return false;
            }
        } else if (this.f13433d) {
            return false;
        }
        if (c2587f.f13430a) {
            if (!this.f13430a) {
                return false;
            }
        } else if (this.f13430a) {
            return false;
        }
        if (c2587f.f13431b) {
            if (!this.f13431b) {
                return false;
            }
        } else if (this.f13431b) {
            return false;
        }
        return true;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException("GeneralPurposeBit is not Cloneable?", e2);
        }
    }
}
