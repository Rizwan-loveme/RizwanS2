package p046b.p047a.p050c.p051a;

import com.srizwan.apktool.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0460e;
import p046b.p047a.p050c.p051a.p052a.C0477i;
import p046b.p047a.p050c.p051a.p052a.C0490v;
import p046b.p047a.p050c.p055d.InterfaceC0515a;
import p046b.p059d.C0538c;
import p046b.p059d.InterfaceC0541f;

/* compiled from: ResPackage.java */
/* renamed from: b.a.c.a.c */
/* loaded from: classes.dex */
public class C0492c {

    /* renamed from: a */
    private final C0495f f3417a;

    /* renamed from: b */
    private final int f3418b;

    /* renamed from: c */
    private final String f3419c;

    /* renamed from: d */
    private final Map<C0491b, C0493d> f3420d = new LinkedHashMap();

    /* renamed from: e */
    private final Map<C0468a, C0496g> f3421e = new LinkedHashMap();

    /* renamed from: f */
    private final Map<String, C0497h> f3422f = new LinkedHashMap();

    /* renamed from: g */
    private final Set<C0491b> f3423g = new HashSet();

    /* renamed from: h */
    private C0490v f3424h;

    /* renamed from: i */
    private final InterfaceC0541f f3425i;

    /* renamed from: j */
    private boolean f3426j;

    /* renamed from: a */
    public void m3664a(C0494e c0494e) {
    }

    public C0492c(C0495f c0495f, int i, String str, boolean z, InterfaceC0541f interfaceC0541f) {
        this.f3425i = interfaceC0541f;
        this.f3426j = z;
        this.f3417a = c0495f;
        this.f3418b = i;
        this.f3419c = str;
    }

    /* renamed from: a */
    public boolean m3666a() {
        return this.f3426j;
    }

    /* renamed from: b */
    public List<C0493d> m3671b() {
        return new ArrayList(this.f3420d.values());
    }

    /* renamed from: a */
    public boolean m3667a(C0491b c0491b) {
        return this.f3420d.containsKey(c0491b);
    }

    /* renamed from: b */
    public C0493d m3669b(C0491b c0491b) {
        C0493d c0493d = this.f3420d.get(c0491b);
        if (c0493d == null) {
            throw new C0460e(new StringBuffer().append("resource spec: ").append(c0491b.toString()).toString());
        }
        return c0493d;
    }

    /* renamed from: c */
    public int m3673c() {
        return this.f3420d.size();
    }

    /* renamed from: a */
    public C0496g m3661a(C0468a c0468a) {
        C0496g c0496g = this.f3421e.get(c0468a);
        if (c0496g == null) {
            C0496g c0496g2 = new C0496g(c0468a);
            this.f3421e.put(c0468a, c0496g2);
            return c0496g2;
        }
        return c0496g;
    }

    /* renamed from: a */
    public boolean m3668a(String str) {
        return this.f3422f.containsKey(str);
    }

    /* renamed from: b */
    public C0497h m3670b(String str) {
        C0497h c0497h = this.f3422f.get(str);
        if (c0497h == null) {
            throw new C0460e(new StringBuffer().append("type: ").append(str).toString());
        }
        return c0497h;
    }

    /* renamed from: d */
    public Set<C0494e> m3675d() {
        HashSet hashSet = new HashSet();
        Iterator<C0493d> it = this.f3420d.values().iterator();
        while (it.hasNext()) {
            for (C0494e c0494e : it.next().m3685a()) {
                if (c0494e.m3701d() instanceof C0477i) {
                    hashSet.add(c0494e);
                }
            }
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public Collection<C0499j> m3676e() {
        HashMap hashMap = new HashMap();
        Iterator<C0493d> it = this.f3420d.values().iterator();
        while (it.hasNext()) {
            for (C0494e c0494e : it.next().m3685a()) {
                if (c0494e.m3701d() instanceof InterfaceC0515a) {
                    C0497h m3695g = c0494e.m3700c().m3695g();
                    C0496g m3699b = c0494e.m3699b();
                    C0538c c0538c = new C0538c(m3695g, m3699b);
                    C0499j c0499j = (C0499j) hashMap.get(c0538c);
                    if (c0499j == null) {
                        c0499j = new C0499j(this, m3695g, m3699b);
                        hashMap.put(c0538c, c0499j);
                    }
                    c0499j.m3752b(c0494e);
                }
            }
        }
        return hashMap.values();
    }

    /* renamed from: f */
    public C0495f m3677f() {
        return this.f3417a;
    }

    /* renamed from: g */
    public int m3678g() {
        return this.f3418b;
    }

    /* renamed from: h */
    public String m3679h() {
        return this.f3419c;
    }

    /* renamed from: c */
    boolean m3674c(C0491b c0491b) {
        return this.f3423g.contains(c0491b);
    }

    /* renamed from: a */
    public void m3663a(C0493d c0493d) {
        this.f3420d.remove(c0493d.m3692d());
    }

    /* renamed from: b */
    public void m3672b(C0493d c0493d) {
        if (this.f3420d.put(c0493d.m3692d(), c0493d) != null) {
            throw new C0461b(new StringBuffer().append("Multiple resource specs: ").append(c0493d).toString());
        }
    }

    /* renamed from: a */
    public void m3665a(C0497h c0497h) {
        if (this.f3422f.containsKey(c0497h.m3740a())) {
            this.f3425i.mo3983c(R.string.text, new StringBuffer().append(new StringBuffer().append("Multiple types detected! ").append(c0497h).toString()).append(" ignored!").toString());
        } else {
            this.f3422f.put(c0497h.m3740a(), c0497h);
        }
    }

    /* renamed from: a */
    public void m3662a(int i) {
        this.f3423g.add(new C0491b(i));
    }

    public String toString() {
        return this.f3419c;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0492c c0492c = (C0492c) obj;
        return (this.f3417a == c0492c.f3417a || (this.f3417a != null && this.f3417a.equals(c0492c.f3417a))) && this.f3418b == c0492c.f3418b;
    }

    public int hashCode() {
        return (((this.f3417a != null ? this.f3417a.hashCode() : 0) + 527) * 31) + this.f3418b;
    }

    /* renamed from: i */
    public C0490v m3680i() {
        if (this.f3424h == null) {
            this.f3424h = new C0490v(this, this.f3426j, this.f3425i);
        }
        return this.f3424h;
    }

    /* renamed from: j */
    public InterfaceC0541f m3681j() {
        return this.f3425i;
    }
}
