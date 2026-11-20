package p046b.p047a.p050c.p051a;

import android.icu.text.DateFormat;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: ResValuesFile.java */
/* renamed from: b.a.c.a.j */
/* loaded from: classes.dex */
public class C0499j {

    /* renamed from: a */
    private final C0492c f3466a;

    /* renamed from: b */
    private final C0497h f3467b;

    /* renamed from: c */
    private final C0496g f3468c;

    /* renamed from: d */
    private final Set<C0494e> f3469d = new LinkedHashSet();

    public C0499j(C0492c c0492c, C0497h c0497h, C0496g c0496g) {
        this.f3466a = c0492c;
        this.f3467b = c0497h;
        this.f3468c = c0496g;
    }

    /* renamed from: a */
    public String m3749a() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("values").append(this.f3468c.m3735a().m3624a()).toString()).append("/").toString()).append(this.f3467b.m3740a()).toString()).append(this.f3467b.m3740a().endsWith(DateFormat.SECOND) ? "" : DateFormat.SECOND).toString()).append(".xml").toString();
    }

    /* renamed from: b */
    public Set<C0494e> m3751b() {
        return this.f3469d;
    }

    /* renamed from: a */
    public boolean m3750a(C0494e c0494e) {
        return this.f3466a.m3674c(c0494e.m3700c().m3692d());
    }

    /* renamed from: b */
    public void m3752b(C0494e c0494e) {
        this.f3469d.add(c0494e);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0499j c0499j = (C0499j) obj;
        if (this.f3467b == c0499j.f3467b || (this.f3467b != null && this.f3467b.equals(c0499j.f3467b))) {
            return this.f3468c == c0499j.f3468c || (this.f3468c != null && this.f3468c.equals(c0499j.f3468c));
        }
        return false;
    }

    public int hashCode() {
        return (((this.f3467b != null ? this.f3467b.hashCode() : 0) + 527) * 31) + (this.f3468c != null ? this.f3468c.hashCode() : 0);
    }
}
