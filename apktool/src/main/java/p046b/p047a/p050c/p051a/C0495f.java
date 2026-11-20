package p046b.p047a.p050c.p051a;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import p046b.p047a.C0461b;
import p046b.p047a.p048a.C0460e;
import p046b.p047a.p049b.C0465d;
import p046b.p047a.p050c.C0467a;

/* compiled from: ResTable.java */
/* renamed from: b.a.c.a.f */
/* loaded from: classes.dex */
public class C0495f {

    /* renamed from: a */
    private final C0467a f3439a;

    /* renamed from: b */
    private final Map<Integer, C0492c> f3440b;

    /* renamed from: c */
    private final Map<String, C0492c> f3441c;

    /* renamed from: d */
    private final Set<C0492c> f3442d;

    /* renamed from: e */
    private final Set<C0492c> f3443e;

    /* renamed from: f */
    private String f3444f;

    /* renamed from: g */
    private String f3445g;

    /* renamed from: h */
    private int f3446h;

    /* renamed from: i */
    private int f3447i;

    /* renamed from: j */
    private boolean f3448j;

    /* renamed from: k */
    private boolean f3449k;

    /* renamed from: l */
    private boolean f3450l;

    /* renamed from: m */
    private boolean f3451m;

    /* renamed from: n */
    private boolean f3452n;

    /* renamed from: o */
    private Map<String, String> f3453o;

    /* renamed from: p */
    private C0465d f3454p;

    public C0495f() {
        this.f3440b = new HashMap();
        this.f3441c = new HashMap();
        this.f3442d = new LinkedHashSet();
        this.f3443e = new LinkedHashSet();
        this.f3448j = false;
        this.f3449k = false;
        this.f3450l = false;
        this.f3451m = false;
        this.f3452n = false;
        this.f3453o = new LinkedHashMap();
        this.f3454p = new C0465d();
        this.f3439a = (C0467a) null;
    }

    public C0495f(C0467a c0467a) {
        this.f3440b = new HashMap();
        this.f3441c = new HashMap();
        this.f3442d = new LinkedHashSet();
        this.f3443e = new LinkedHashSet();
        this.f3448j = false;
        this.f3449k = false;
        this.f3450l = false;
        this.f3451m = false;
        this.f3452n = false;
        this.f3453o = new LinkedHashMap();
        this.f3454p = new C0465d();
        this.f3439a = c0467a;
    }

    /* renamed from: a */
    public int m3702a() {
        return this.f3439a.m3603b();
    }

    /* renamed from: a */
    public C0493d m3704a(int i) {
        if ((i >> 24) == 0) {
            i |= ((this.f3446h == 0 ? 2 : this.f3446h) << 24) & (-16777216);
        }
        return m3705a(new C0491b(i));
    }

    /* renamed from: a */
    public C0493d m3705a(C0491b c0491b) {
        return m3709b(c0491b.f3413a).m3669b(c0491b);
    }

    /* renamed from: b */
    public Set<C0492c> m3710b() {
        return this.f3442d;
    }

    /* renamed from: c */
    public Set<C0492c> m3713c() {
        return this.f3443e;
    }

    /* renamed from: d */
    public boolean m3720d() {
        return this.f3451m;
    }

    /* renamed from: b */
    public C0492c m3709b(int i) {
        C0492c c0492c = this.f3440b.get(new Integer(i));
        if (c0492c == null) {
            if (this.f3439a != null) {
                return this.f3439a.m3581a(this, i, this.f3439a.f3322a.f3599t);
            }
            throw new C0460e(String.format("package: id=%d", new Integer(i)));
        }
        return c0492c;
    }

    /* renamed from: e */
    public C0492c m3721e() {
        int i = 0;
        int i2 = 0;
        for (C0492c c0492c : this.f3440b.values()) {
            if (c0492c.m3673c() > i && !c0492c.m3679h().equalsIgnoreCase("android")) {
                i = c0492c.m3673c();
                i2 = c0492c.m3678g();
            }
        }
        return i2 == 0 ? m3709b(1) : m3709b(i2);
    }

    /* renamed from: f */
    public C0492c m3724f() {
        C0492c c0492c = this.f3440b.get(new Integer(this.f3446h));
        if (c0492c == null) {
            if (this.f3442d.size() == 1) {
                return this.f3442d.iterator().next();
            }
            return m3721e();
        }
        return c0492c;
    }

    /* renamed from: a */
    public C0492c m3703a(String str) {
        C0492c c0492c = this.f3441c.get(str);
        if (c0492c == null) {
            throw new C0460e(new StringBuffer().append("package: name=").append(str).toString());
        }
        return c0492c;
    }

    /* renamed from: c */
    public boolean m3716c(int i) {
        return this.f3440b.containsKey(new Integer(i));
    }

    /* renamed from: a */
    public void m3706a(C0492c c0492c, boolean z) {
        Integer num = new Integer(c0492c.m3678g());
        if (this.f3440b.containsKey(num)) {
            throw new C0461b(new StringBuffer().append("Multiple packages: id=").append(num.toString()).toString());
        }
        String m3679h = c0492c.m3679h();
        if (this.f3441c.containsKey(m3679h)) {
            throw new C0461b(new StringBuffer().append("Multiple packages: name=").append(m3679h).toString());
        }
        this.f3440b.put(num, c0492c);
        this.f3441c.put(m3679h, c0492c);
        if (z) {
            this.f3442d.add(c0492c);
        } else {
            this.f3443e.add(c0492c);
        }
        if (!z || this.f3451m) {
            return;
        }
        this.f3451m = true;
    }

    /* renamed from: a */
    public void m3708a(boolean z) {
        this.f3448j = z;
    }

    /* renamed from: b */
    public void m3711b(String str) {
        this.f3444f = str;
    }

    /* renamed from: c */
    public void m3714c(String str) {
        this.f3445g = str;
    }

    /* renamed from: d */
    public void m3717d(int i) {
        this.f3446h = i;
    }

    /* renamed from: b */
    public void m3712b(boolean z) {
        this.f3449k = z;
    }

    /* renamed from: c */
    public void m3715c(boolean z) {
        this.f3450l = z;
    }

    /* renamed from: d */
    public void m3719d(boolean z) {
        this.f3452n = z;
    }

    /* renamed from: g */
    public void m3725g() {
        this.f3453o.clear();
    }

    /* renamed from: a */
    public void m3707a(String str, String str2) {
        this.f3453o.put(str, str2);
    }

    /* renamed from: d */
    public void m3718d(String str) {
        this.f3454p.f3300b = str;
    }

    /* renamed from: e */
    public void m3723e(String str) {
        this.f3454p.f3299a = str;
    }

    /* renamed from: h */
    public C0465d m3726h() {
        return this.f3454p;
    }

    /* renamed from: i */
    public Map<String, String> m3727i() {
        return this.f3453o;
    }

    /* renamed from: j */
    public boolean m3728j() {
        return this.f3448j;
    }

    /* renamed from: k */
    public String m3729k() {
        return this.f3444f;
    }

    /* renamed from: l */
    public String m3730l() {
        return this.f3445g;
    }

    /* renamed from: m */
    public int m3731m() {
        return this.f3446h;
    }

    /* renamed from: n */
    public boolean m3732n() {
        return this.f3449k;
    }

    /* renamed from: o */
    public boolean m3733o() {
        return this.f3450l;
    }

    /* renamed from: p */
    public boolean m3734p() {
        return this.f3452n;
    }

    /* renamed from: e */
    public void m3722e(int i) {
        this.f3447i = i;
    }
}
