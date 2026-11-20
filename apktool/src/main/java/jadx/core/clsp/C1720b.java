package jadx.core.clsp;

/* compiled from: NClass.java */
/* renamed from: jadx.core.clsp.b */
/* loaded from: classes.dex */
public class C1720b {

    /* renamed from: a */
    private final String f10574a;

    /* renamed from: b */
    private C1720b[] f10575b;

    /* renamed from: c */
    private int f10576c;

    public C1720b(String str, int i) {
        this.f10574a = str;
        this.f10576c = i;
    }

    /* renamed from: a */
    public String m13183a() {
        return this.f10574a;
    }

    /* renamed from: b */
    public C1720b[] m13185b() {
        return this.f10575b;
    }

    /* renamed from: a */
    public void m13184a(C1720b[] c1720bArr) {
        this.f10575b = c1720bArr;
    }

    public int hashCode() {
        return this.f10574a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10574a.equals(((C1720b) obj).f10574a);
    }

    public String toString() {
        return this.f10574a;
    }
}
