package jadx.core.p207e.p208a;

import java.util.List;

/* compiled from: ResourceEntry.java */
/* renamed from: jadx.core.e.a.d */
/* loaded from: classes.dex */
public final class C1750d {

    /* renamed from: a */
    private final int f10623a;

    /* renamed from: b */
    private final String f10624b;

    /* renamed from: c */
    private final String f10625c;

    /* renamed from: d */
    private final String f10626d;

    /* renamed from: e */
    private int f10627e;

    /* renamed from: f */
    private C1749c f10628f;

    /* renamed from: g */
    private List<C1748b> f10629g;

    /* renamed from: h */
    private C1747a f10630h;

    public C1750d(int i, String str, String str2, String str3) {
        this.f10623a = i;
        this.f10624b = str;
        this.f10625c = str2;
        this.f10626d = str3;
    }

    /* renamed from: a */
    public int m13332a() {
        return this.f10623a;
    }

    /* renamed from: b */
    public String m13337b() {
        return this.f10625c;
    }

    /* renamed from: c */
    public String m13338c() {
        return this.f10626d;
    }

    /* renamed from: a */
    public void m13333a(int i) {
        this.f10627e = i;
    }

    /* renamed from: a */
    public void m13335a(C1749c c1749c) {
        this.f10628f = c1749c;
    }

    /* renamed from: a */
    public void m13336a(List<C1748b> list) {
        this.f10629g = list;
    }

    /* renamed from: a */
    public void m13334a(C1747a c1747a) {
        this.f10630h = c1747a;
    }

    public String toString() {
        return "  0x" + Integer.toHexString(this.f10623a) + " (" + this.f10623a + ")" + this.f10630h + " = " + this.f10625c + "." + this.f10626d;
    }
}
