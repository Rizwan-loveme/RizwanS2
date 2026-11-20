package jadx.core.p183c.p188c;

import jadx.core.p183c.p191d.C1646l;

/* compiled from: ConstStringNode.java */
/* renamed from: jadx.core.c.c.d */
/* loaded from: classes.dex */
public final class C1613d extends C1646l {

    /* renamed from: a */
    private final String f10216a;

    public C1613d(String str) {
        super(EnumC1621l.CONST_STR, 0);
        this.f10216a = str;
    }

    /* renamed from: f */
    public String m12377f() {
        return this.f10216a;
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: g */
    public C1646l mo12376g() {
        return m12583c(new C1613d(this.f10216a));
    }

    @Override // jadx.core.p183c.p191d.C1646l
    /* renamed from: a */
    public boolean mo12254a(C1646l c1646l) {
        if (this == c1646l) {
            return true;
        }
        if (!(c1646l instanceof C1613d) || !super.mo12254a(c1646l)) {
            return false;
        }
        return this.f10216a.equals(((C1613d) c1646l).f10216a);
    }

    @Override // jadx.core.p183c.p191d.C1646l
    public String toString() {
        return String.valueOf(super.toString()) + " \"" + this.f10216a + "\"";
    }
}
