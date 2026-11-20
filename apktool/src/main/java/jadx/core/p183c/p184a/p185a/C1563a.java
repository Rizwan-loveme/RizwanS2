package jadx.core.p183c.p184a.p185a;

import jadx.core.p183c.p188c.p189a.AbstractC1596a;
import java.util.Map;

/* compiled from: Annotation.java */
/* renamed from: jadx.core.c.a.a.a */
/* loaded from: classes.dex */
public class C1563a {

    /* renamed from: a */
    private final a f10017a;

    /* renamed from: b */
    private final AbstractC1596a f10018b;

    /* renamed from: c */
    private final Map<String, Object> f10019c;

    /* compiled from: Annotation.java */
    /* renamed from: jadx.core.c.a.a.a$a */
    public enum a {
        BUILD,
        RUNTIME,
        SYSTEM;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            int length = valuesCustom.length;
            a[] aVarArr = new a[length];
            System.arraycopy(valuesCustom, 0, aVarArr, 0, length);
            return aVarArr;
        }
    }

    public C1563a(a aVar, AbstractC1596a abstractC1596a, Map<String, Object> map) {
        this.f10017a = aVar;
        this.f10018b = abstractC1596a;
        this.f10019c = map;
    }

    /* renamed from: a */
    public AbstractC1596a m12079a() {
        return this.f10018b;
    }

    /* renamed from: b */
    public String m12080b() {
        return this.f10018b.mo12279e();
    }

    /* renamed from: c */
    public Map<String, Object> m12081c() {
        return this.f10019c;
    }

    /* renamed from: d */
    public Object m12082d() {
        return this.f10019c.get("value");
    }

    public String toString() {
        return "Annotation[" + this.f10017a + ", " + this.f10018b + ", " + this.f10019c + "]";
    }
}
