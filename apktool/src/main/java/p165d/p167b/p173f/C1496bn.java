package p165d.p167b.p173f;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.x500.X500Principal;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;

/* compiled from: X500Name.java */
/* renamed from: d.b.f.bn */
/* loaded from: classes.dex */
public class C1496bn implements InterfaceC1466ak, Principal {

    /* renamed from: J */
    private String f9566J;

    /* renamed from: K */
    private String f9567K;

    /* renamed from: L */
    private C1487be[] f9568L;

    /* renamed from: M */
    private String f9569M;

    /* renamed from: N */
    private X500Principal f9570N;

    /* renamed from: A */
    private static final Map<C1454q, C1454q> f9531A = new HashMap();

    /* renamed from: y */
    private static final int[] f9564y = {2, 5, 4, 3};

    /* renamed from: x */
    private static final int[] f9563x = {2, 5, 4, 4};

    /* renamed from: w */
    private static final int[] f9562w = {2, 5, 4, 5};

    /* renamed from: z */
    private static final int[] f9565z = {2, 5, 4, 6};

    /* renamed from: C */
    private static final int[] f9533C = {2, 5, 4, 7};

    /* renamed from: F */
    private static final int[] f9536F = {2, 5, 4, 8};

    /* renamed from: G */
    private static final int[] f9537G = {2, 5, 4, 9};

    /* renamed from: D */
    private static final int[] f9534D = {2, 5, 4, 10};

    /* renamed from: E */
    private static final int[] f9535E = {2, 5, 4, 11};

    /* renamed from: H */
    private static final int[] f9538H = {2, 5, 4, 12};

    /* renamed from: u */
    private static final int[] f9560u = {2, 5, 4, 42};

    /* renamed from: v */
    private static final int[] f9561v = {2, 5, 4, 43};

    /* renamed from: t */
    private static final int[] f9559t = {2, 5, 4, 44};

    /* renamed from: r */
    private static final int[] f9557r = {2, 5, 4, 46};

    /* renamed from: B */
    private static final int[] f9532B = {1, 3, 6, 1, 4, 1, 42, 2, 11, 2, 1};

    /* renamed from: s */
    private static final int[] f9558s = {0, 9, 2342, 19200300, 100, 1, 25};

    /* renamed from: I */
    private static final int[] f9539I = {0, 9, 2342, 19200300, 100, 1, 1};

    /* renamed from: h */
    public static final C1454q f9547h = m11556a(C1454q.m11454a(f9564y));

    /* renamed from: f */
    public static final C1454q f9545f = m11556a(C1454q.m11454a(f9562w));

    /* renamed from: i */
    public static final C1454q f9548i = m11556a(C1454q.m11454a(f9565z));

    /* renamed from: k */
    public static final C1454q f9550k = m11556a(C1454q.m11454a(f9533C));

    /* renamed from: l */
    public static final C1454q f9551l = m11556a(C1454q.m11454a(f9534D));

    /* renamed from: m */
    public static final C1454q f9552m = m11556a(C1454q.m11454a(f9535E));

    /* renamed from: n */
    public static final C1454q f9553n = m11556a(C1454q.m11454a(f9536F));

    /* renamed from: o */
    public static final C1454q f9554o = m11556a(C1454q.m11454a(f9537G));

    /* renamed from: p */
    public static final C1454q f9555p = m11556a(C1454q.m11454a(f9538H));

    /* renamed from: a */
    public static final C1454q f9540a = m11556a(C1454q.m11454a(f9557r));

    /* renamed from: g */
    public static final C1454q f9546g = m11556a(C1454q.m11454a(f9563x));

    /* renamed from: d */
    public static final C1454q f9543d = m11556a(C1454q.m11454a(f9560u));

    /* renamed from: e */
    public static final C1454q f9544e = m11556a(C1454q.m11454a(f9561v));

    /* renamed from: c */
    public static final C1454q f9542c = m11556a(C1454q.m11454a(f9559t));

    /* renamed from: j */
    public static final C1454q f9549j = m11556a(C1454q.m11454a(f9532B));

    /* renamed from: b */
    public static final C1454q f9541b = m11556a(C1454q.m11454a(f9558s));

    /* renamed from: q */
    public static final C1454q f9556q = m11556a(C1454q.m11454a(f9539I));

    public C1496bn(String str) {
        this(str, Collections.emptyMap());
    }

    public C1496bn(String str, Map<String, String> map) {
        m11558a(str, map);
    }

    public C1496bn(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f9568L = new C1487be[6];
        this.f9568L[5] = new C1487be(1);
        this.f9568L[5].f9516a[0] = new C1455a(f9547h, new C1450m(str));
        this.f9568L[4] = new C1487be(1);
        this.f9568L[4].f9516a[0] = new C1455a(f9552m, new C1450m(str2));
        this.f9568L[3] = new C1487be(1);
        this.f9568L[3].f9516a[0] = new C1455a(f9551l, new C1450m(str3));
        this.f9568L[2] = new C1487be(1);
        this.f9568L[2].f9516a[0] = new C1455a(f9550k, new C1450m(str4));
        this.f9568L[1] = new C1487be(1);
        this.f9568L[1].f9516a[0] = new C1455a(f9553n, new C1450m(str5));
        this.f9568L[0] = new C1487be(1);
        this.f9568L[0].f9516a[0] = new C1455a(f9548i, new C1450m(str6));
    }

    public C1496bn(C1450m c1450m) {
        this(c1450m.m11441v());
    }

    public C1496bn(C1448k c1448k) {
        m11557a(c1448k);
    }

    /* renamed from: e */
    public boolean m11567e() {
        int length = this.f9568L.length;
        for (int i = 0; i < length; i++) {
            if (this.f9568L[i].f9516a.length != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.security.Principal
    public int hashCode() {
        return m11565c().hashCode();
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1496bn)) {
            return false;
        }
        C1496bn c1496bn = (C1496bn) obj;
        if (this.f9566J != null && c1496bn.f9566J != null) {
            return this.f9566J.equals(c1496bn.f9566J);
        }
        int length = this.f9568L.length;
        if (length != c1496bn.f9568L.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (this.f9568L[i].f9516a.length != c1496bn.f9568L[i].f9516a.length) {
                return false;
            }
        }
        return m11565c().equals(c1496bn.m11565c());
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: b */
    public int mo11480b() {
        return 4;
    }

    @Override // java.security.Principal
    public String toString() {
        if (this.f9567K == null) {
            m11562f();
        }
        return this.f9567K;
    }

    /* renamed from: d */
    public String m11566d() {
        return m11563a(Collections.emptyMap());
    }

    /* renamed from: a */
    public String m11563a(Map<String, String> map) {
        if (map.isEmpty()) {
            if (this.f9569M != null) {
                return this.f9569M;
            }
            this.f9569M = m11561b(map);
            return this.f9569M;
        }
        return m11561b(map);
    }

    /* renamed from: b */
    private String m11561b(Map<String, String> map) {
        if (this.f9568L.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(48);
        for (int length = this.f9568L.length - 1; length >= 0; length--) {
            if (length < this.f9568L.length - 1) {
                sb.append(',');
            }
            sb.append(this.f9568L[length].m11535a(map));
        }
        return sb.toString();
    }

    /* renamed from: c */
    public String m11565c() {
        if (this.f9566J != null) {
            return this.f9566J;
        }
        if (this.f9568L.length == 0) {
            this.f9566J = "";
            return this.f9566J;
        }
        StringBuilder sb = new StringBuilder(48);
        for (int length = this.f9568L.length - 1; length >= 0; length--) {
            if (length < this.f9568L.length - 1) {
                sb.append(',');
            }
            sb.append(this.f9568L[length].m11536a(true));
        }
        this.f9566J = sb.toString();
        return this.f9566J;
    }

    @Override // java.security.Principal
    public String getName() {
        return toString();
    }

    /* renamed from: a */
    private void m11557a(C1448k c1448k) {
        C1450m[] m11364a;
        byte[] m11382n = c1448k.m11382n();
        try {
            m11364a = c1448k.m11364a(5);
        } catch (IOException e2) {
            if (m11382n == null) {
                m11364a = null;
            } else {
                m11364a = new C1448k(new C1450m((byte) 48, m11382n).m11440u()).m11364a(5);
            }
        }
        if (m11364a == null) {
            this.f9568L = new C1487be[0];
            return;
        }
        this.f9568L = new C1487be[m11364a.length];
        for (int i = 0; i < m11364a.length; i++) {
            this.f9568L[i] = new C1487be(m11364a[i]);
        }
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public void mo11479a(C1449l c1449l) {
        C1449l c1449l2 = new C1449l();
        for (int i = 0; i < this.f9568L.length; i++) {
            this.f9568L[i].m11537a(c1449l2);
        }
        c1449l.m11388a((byte) 48, c1449l2);
    }

    /* renamed from: a */
    private void m11558a(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            this.f9568L = new C1487be[0];
            return;
        }
        this.f9570N = new X500Principal(str, map);
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(44);
        int indexOf2 = str.indexOf(59);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (indexOf >= 0 || indexOf2 >= 0) {
                if (indexOf2 < 0) {
                    indexOf2 = indexOf;
                } else if (indexOf >= 0) {
                    indexOf2 = Math.min(indexOf, indexOf2);
                }
                int m11555a = m11555a(str, i, indexOf2) + i2;
                if (indexOf2 < 0 || m11555a == 1 || m11559a(indexOf2, i, str)) {
                    i2 = m11555a;
                } else {
                    arrayList.add(new C1487be(str.substring(i3, indexOf2), map));
                    i3 = indexOf2 + 1;
                    i2 = 0;
                }
                i = indexOf2 + 1;
                indexOf = str.indexOf(44, i);
                indexOf2 = str.indexOf(59, i);
            } else {
                arrayList.add(new C1487be(str.substring(i3), map));
                Collections.reverse(arrayList);
                this.f9568L = (C1487be[]) arrayList.toArray(new C1487be[arrayList.size()]);
                return;
            }
        }
    }

    /* renamed from: a */
    static int m11555a(String str, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4++) {
            if ((str.charAt(i4) == '\"' && i4 == i) || (str.charAt(i4) == '\"' && str.charAt(i4 - 1) != '\\')) {
                i3++;
            }
        }
        return i3;
    }

    /* renamed from: a */
    private static boolean m11559a(int i, int i2, String str) {
        if (i == 1 && str.charAt(i - 1) == '\\') {
            return true;
        }
        if (i > 1 && str.charAt(i - 1) == '\\' && str.charAt(i - 2) != '\\') {
            return true;
        }
        if (i <= 1 || str.charAt(i - 1) != '\\' || str.charAt(i - 2) != '\\') {
            return false;
        }
        int i3 = 0;
        for (int i4 = i - 1; i4 >= i2; i4--) {
            if (str.charAt(i4) == '\\') {
                i3++;
            }
        }
        return i3 % 2 != 0;
    }

    /* renamed from: f */
    private void m11562f() {
        if (this.f9568L.length == 1) {
            this.f9567K = this.f9568L[0].toString();
            return;
        }
        StringBuilder sb = new StringBuilder(48);
        if (this.f9568L != null) {
            for (int length = this.f9568L.length - 1; length >= 0; length--) {
                if (length != this.f9568L.length - 1) {
                    sb.append(", ");
                }
                sb.append(this.f9568L[length].toString());
            }
        }
        this.f9567K = sb.toString();
    }

    /* renamed from: a */
    static C1454q m11556a(C1454q c1454q) {
        C1454q c1454q2 = f9531A.get(c1454q);
        if (c1454q2 == null) {
            f9531A.put(c1454q, c1454q);
            return c1454q;
        }
        return c1454q2;
    }

    @Override // p165d.p167b.p173f.InterfaceC1466ak
    /* renamed from: a */
    public int mo11477a(InterfaceC1466ak interfaceC1466ak) {
        if (interfaceC1466ak == null || interfaceC1466ak.mo11480b() != 4) {
            return -1;
        }
        C1496bn c1496bn = (C1496bn) interfaceC1466ak;
        if (c1496bn.equals(this)) {
            return 0;
        }
        if (c1496bn.f9568L.length == 0) {
            return 2;
        }
        if (this.f9568L.length != 0 && !c1496bn.m11560a(this)) {
            return m11560a(c1496bn) ? 2 : 3;
        }
        return 1;
    }

    /* renamed from: a */
    private boolean m11560a(C1496bn c1496bn) {
        if (this == c1496bn) {
            return true;
        }
        if (c1496bn == null) {
            return false;
        }
        if (c1496bn.f9568L.length == 0) {
            return true;
        }
        if (this.f9568L.length != 0 && this.f9568L.length >= c1496bn.f9568L.length) {
            for (int i = 0; i < c1496bn.f9568L.length; i++) {
                if (!this.f9568L[i].equals(c1496bn.f9568L[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public X500Principal m11564a() {
        return this.f9570N;
    }
}
