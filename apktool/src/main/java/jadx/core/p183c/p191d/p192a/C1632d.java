package jadx.core.p183c.p191d.p192a;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p191d.C1646l;
import jadx.core.p183c.p191d.C1648n;

/* compiled from: FieldInitAttr.java */
/* renamed from: jadx.core.c.d.a.d */
/* loaded from: classes.dex */
public class C1632d implements InterfaceC1587g<C1632d> {

    /* renamed from: a */
    public static final C1632d f10319a = m12469a(null);

    /* renamed from: b */
    private final Object f10320b;

    /* renamed from: c */
    private final a f10321c;

    /* renamed from: d */
    private final C1648n f10322d;

    /* compiled from: FieldInitAttr.java */
    /* renamed from: jadx.core.c.d.a.d$a */
    public enum a {
        CONST,
        INSN;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            int length = valuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    private C1632d(a aVar, Object obj, C1648n c1648n) {
        this.f10320b = obj;
        this.f10321c = aVar;
        this.f10322d = c1648n;
    }

    /* renamed from: a */
    public static C1632d m12469a(Object obj) {
        return new C1632d(a.CONST, obj, null);
    }

    /* renamed from: a */
    public static C1632d m12468a(C1648n c1648n, C1646l c1646l) {
        return new C1632d(a.INSN, c1646l, c1648n);
    }

    /* renamed from: a */
    public Object m12470a() {
        return this.f10320b;
    }

    /* renamed from: c */
    public C1646l m12471c() {
        return (C1646l) this.f10320b;
    }

    /* renamed from: d */
    public a m12472d() {
        return this.f10321c;
    }

    /* renamed from: e */
    public C1648n m12473e() {
        return this.f10322d;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1632d> mo12085b() {
        return C1566b.f10037k;
    }

    public String toString() {
        return "V=" + this.f10320b;
    }
}
