package jadx.core.p183c.p188c.p190b;

import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p187b.C1594f;
import jadx.core.p183c.p188c.C1622m;
import jadx.core.p183c.p188c.EnumC1621l;
import jadx.core.p183c.p188c.p189a.C1604i;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;

/* compiled from: ConstructorInsn.java */
/* renamed from: jadx.core.c.c.b.a */
/* loaded from: classes.dex */
public class C1610a extends C1646l {

    /* renamed from: a */
    private final C1594f f10206a;

    /* renamed from: b */
    private final a f10207b;

    /* renamed from: e */
    private final C1604i f10208e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConstructorInsn.java */
    /* renamed from: jadx.core.c.c.b.a$a */
    public enum a {
        CONSTRUCTOR,
        SUPER,
        THIS,
        SELF;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            int length = valuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public C1610a(C1648n c1648n, C1622m c1622m) {
        super(EnumC1621l.CONSTRUCTOR, c1622m.m12590r() - 1);
        this.f10206a = c1622m.m12417h();
        C1590b m12245d = this.f10206a.m12245d();
        this.f10208e = (C1604i) c1622m.mo12426d(0);
        if (this.f10208e.m12315m()) {
            if (m12245d.equals(c1648n.m12640o().m12544x())) {
                if (this.f10206a.m12244c().equals(c1648n.m12617O().m12244c())) {
                    this.f10207b = a.SELF;
                } else {
                    this.f10207b = a.THIS;
                }
            } else {
                this.f10207b = a.SUPER;
            }
        } else {
            this.f10207b = a.CONSTRUCTOR;
            m12581b(this.f10208e);
            this.f10208e.m12331p().m12336a(this.f10208e);
        }
        this.f10208e.m12331p().m12342c(this.f10208e);
        for (int i = 1; i < c1622m.m12590r(); i++) {
            m12584c(c1622m.mo12426d(i));
        }
        this.f10371d = c1622m.m12591s();
        m12118a(c1622m.m12122d());
    }

    public C1610a(C1594f c1594f, a aVar, C1604i c1604i) {
        super(EnumC1621l.CONSTRUCTOR, c1594f.m12248g());
        this.f10206a = c1594f;
        this.f10207b = aVar;
        this.f10208e = c1604i;
    }

    /* renamed from: f */
    public C1594f m12363f() {
        return this.f10206a;
    }

    /* renamed from: h */
    public C1604i m12364h() {
        return this.f10208e;
    }

    /* renamed from: i */
    public C1590b m12365i() {
        return this.f10206a.m12245d();
    }

    /* renamed from: j */
    public a m12366j() {
        return this.f10207b;
    }

    /* renamed from: k */
    public boolean m12367k() {
        return this.f10207b == a.CONSTRUCTOR;
    }

    /* renamed from: l */
    public boolean m12368l() {
        return this.f10207b == a.SUPER;
    }

    /* renamed from: m */
    public boolean m12369m() {
        return this.f10207b == a.THIS;
    }

    /* renamed from: n */
    public boolean m12370n() {
        return this.f10207b == a.SELF;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1610a) || !super.mo12254a(c1646l)) {
            return false;
        }
        C1610a c1610a = (C1610a) c1646l;
        return this.f10206a.equals(c1610a.f10206a) && this.f10207b == c1610a.f10207b;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(super.toString()) + " " + this.f10206a + " " + this.f10207b;
    }
}
