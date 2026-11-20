package jadx.core.p183c.p184a.p186b;

import jadx.core.p183c.p184a.C1566b;
import jadx.core.p183c.p184a.InterfaceC1587g;
import jadx.core.p183c.p187b.C1590b;
import jadx.core.p183c.p188c.p189a.AbstractC1598c;

/* compiled from: FieldReplaceAttr.java */
/* renamed from: jadx.core.c.a.b.e */
/* loaded from: classes.dex */
public class C1571e implements InterfaceC1587g<C1571e> {

    /* renamed from: a */
    private final a f10061a;

    /* renamed from: b */
    private final Object f10062b;

    /* compiled from: FieldReplaceAttr.java */
    /* renamed from: jadx.core.c.a.b.e$a */
    public enum a {
        CLASS_INSTANCE,
        VAR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            int length = valuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public C1571e(C1590b c1590b) {
        this.f10061a = a.CLASS_INSTANCE;
        this.f10062b = c1590b;
    }

    public C1571e(AbstractC1598c abstractC1598c) {
        this.f10061a = a.VAR;
        this.f10062b = abstractC1598c;
    }

    /* renamed from: a */
    public a m12107a() {
        return this.f10061a;
    }

    /* renamed from: c */
    public C1590b m12108c() {
        return (C1590b) this.f10062b;
    }

    /* renamed from: d */
    public AbstractC1598c m12109d() {
        return (AbstractC1598c) this.f10062b;
    }

    @Override // jadx.core.p183c.p184a.InterfaceC1587g
    /* renamed from: b */
    public C1566b<C1571e> mo12085b() {
        return C1566b.f10038l;
    }

    public String toString() {
        return "REPLACE: " + this.f10061a + " " + this.f10062b;
    }
}
