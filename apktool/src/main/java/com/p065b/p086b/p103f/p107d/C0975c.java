package com.p065b.p086b.p103f.p107d;

import android.app.slice.SliceItem;
import android.telephony.PhoneNumberUtils;
import com.p065b.p086b.p110h.C1022m;
import java.util.HashMap;

/* compiled from: Type.java */
/* renamed from: com.b.b.f.d.c */
/* loaded from: classes.dex */
public final class C0975c implements InterfaceC0976d, Comparable<C0975c> {

    /* renamed from: A */
    public static final C0975c f6235A;

    /* renamed from: B */
    public static final C0975c f6236B;

    /* renamed from: C */
    public static final C0975c f6237C;

    /* renamed from: D */
    public static final C0975c f6238D;

    /* renamed from: E */
    public static final C0975c f6239E;

    /* renamed from: F */
    public static final C0975c f6240F;

    /* renamed from: G */
    public static final C0975c f6241G;

    /* renamed from: H */
    public static final C0975c f6242H;

    /* renamed from: I */
    public static final C0975c f6243I;

    /* renamed from: J */
    public static final C0975c f6244J;

    /* renamed from: K */
    private static final HashMap<String, C0975c> f6245K = new HashMap<>(500);

    /* renamed from: a */
    public static final C0975c f6246a = new C0975c("Z", 1);

    /* renamed from: b */
    public static final C0975c f6247b = new C0975c("B", 2);

    /* renamed from: c */
    public static final C0975c f6248c = new C0975c("C", 3);

    /* renamed from: d */
    public static final C0975c f6249d = new C0975c("D", 4);

    /* renamed from: e */
    public static final C0975c f6250e = new C0975c("F", 5);

    /* renamed from: f */
    public static final C0975c f6251f = new C0975c("I", 6);

    /* renamed from: g */
    public static final C0975c f6252g = new C0975c("J", 7);

    /* renamed from: h */
    public static final C0975c f6253h = new C0975c("S", 8);

    /* renamed from: i */
    public static final C0975c f6254i = new C0975c("V", 0);

    /* renamed from: j */
    public static final C0975c f6255j = new C0975c("<null>", 9);

    /* renamed from: k */
    public static final C0975c f6256k = new C0975c("<addr>", 10);

    /* renamed from: l */
    public static final C0975c f6257l;

    /* renamed from: m */
    public static final C0975c f6258m;

    /* renamed from: n */
    public static final C0975c f6259n;

    /* renamed from: o */
    public static final C0975c f6260o;

    /* renamed from: p */
    public static final C0975c f6261p;

    /* renamed from: q */
    public static final C0975c f6262q;

    /* renamed from: r */
    public static final C0975c f6263r;

    /* renamed from: s */
    public static final C0975c f6264s;

    /* renamed from: t */
    public static final C0975c f6265t;

    /* renamed from: u */
    public static final C0975c f6266u;

    /* renamed from: v */
    public static final C0975c f6267v;

    /* renamed from: w */
    public static final C0975c f6268w;

    /* renamed from: x */
    public static final C0975c f6269x;

    /* renamed from: y */
    public static final C0975c f6270y;

    /* renamed from: z */
    public static final C0975c f6271z;

    /* renamed from: L */
    private final String f6272L;

    /* renamed from: M */
    private final int f6273M;

    /* renamed from: N */
    private final int f6274N;

    /* renamed from: O */
    private String f6275O;

    /* renamed from: P */
    private C0975c f6276P;

    /* renamed from: Q */
    private C0975c f6277Q;

    /* renamed from: R */
    private C0975c f6278R;

    static {
        m8119b(f6246a);
        m8119b(f6247b);
        m8119b(f6248c);
        m8119b(f6249d);
        m8119b(f6250e);
        m8119b(f6251f);
        m8119b(f6252g);
        m8119b(f6253h);
        f6257l = m8118a("Ljava/lang/annotation/Annotation;");
        f6258m = m8118a("Ljava/lang/Class;");
        f6259n = m8118a("Ljava/lang/Cloneable;");
        f6260o = m8118a("Ljava/lang/Object;");
        f6261p = m8118a("Ljava/io/Serializable;");
        f6262q = m8118a("Ljava/lang/String;");
        f6263r = m8118a("Ljava/lang/Throwable;");
        f6264s = m8118a("Ljava/lang/Boolean;");
        f6265t = m8118a("Ljava/lang/Byte;");
        f6266u = m8118a("Ljava/lang/Character;");
        f6267v = m8118a("Ljava/lang/Double;");
        f6268w = m8118a("Ljava/lang/Float;");
        f6269x = m8118a("Ljava/lang/Integer;");
        f6270y = m8118a("Ljava/lang/Long;");
        f6271z = m8118a("Ljava/lang/Short;");
        f6235A = m8118a("Ljava/lang/Void;");
        f6236B = f6246a.m8137t();
        f6237C = f6247b.m8137t();
        f6238D = f6248c.m8137t();
        f6239E = f6249d.m8137t();
        f6240F = f6250e.m8137t();
        f6241G = f6251f.m8137t();
        f6242H = f6252g.m8137t();
        f6243I = f6260o.m8137t();
        f6244J = f6253h.m8137t();
    }

    /* renamed from: a */
    public static C0975c m8118a(String str) {
        C0975c c0975c;
        synchronized (f6245K) {
            c0975c = f6245K.get(str);
        }
        if (c0975c == null) {
            try {
                char charAt = str.charAt(0);
                if (charAt == '[') {
                    return m8118a(str.substring(1)).m8137t();
                }
                int length = str.length();
                if (charAt != 'L' || str.charAt(length - 1) != ';') {
                    throw new IllegalArgumentException("bad descriptor: " + str);
                }
                int i = length - 1;
                for (int i2 = 1; i2 < i; i2++) {
                    switch (str.charAt(i2)) {
                        case '(':
                        case ')':
                        case '.':
                        case ';':
                        case '[':
                            throw new IllegalArgumentException("bad descriptor: " + str);
                        case '/':
                            if (i2 != 1 && i2 != length - 1 && str.charAt(i2 - 1) != '/') {
                                break;
                            } else {
                                throw new IllegalArgumentException("bad descriptor: " + str);
                            }
                    }
                }
                return m8119b(new C0975c(str, 9));
            } catch (IndexOutOfBoundsException e2) {
                throw new IllegalArgumentException("descriptor is empty");
            } catch (NullPointerException e3) {
                throw new NullPointerException("descriptor == null");
            }
        }
        return c0975c;
    }

    /* renamed from: b */
    public static C0975c m8120b(String str) {
        try {
            if (str.equals("V")) {
                return f6254i;
            }
            return m8118a(str);
        } catch (NullPointerException e2) {
            throw new NullPointerException("descriptor == null");
        }
    }

    /* renamed from: c */
    public static C0975c m8121c(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        return str.startsWith("[") ? m8118a(str) : m8118a('L' + str + ';');
    }

    private C0975c(String str, int i, int i2) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        if (i < 0 || i >= 11) {
            throw new IllegalArgumentException("bad basicType");
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("newAt < -1");
        }
        this.f6272L = str;
        this.f6273M = i;
        this.f6274N = i2;
        this.f6276P = null;
        this.f6277Q = null;
        this.f6278R = null;
    }

    private C0975c(String str, int i) {
        this(str, i, -1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0975c)) {
            return false;
        }
        return this.f6272L.equals(((C0975c) obj).f6272L);
    }

    public int hashCode() {
        return this.f6272L.hashCode();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0975c c0975c) {
        return this.f6272L.compareTo(c0975c.f6272L);
    }

    public String toString() {
        return this.f6272L;
    }

    @Override // com.p065b.p086b.p110h.InterfaceC1035z
    /* renamed from: d */
    public String mo6681d() {
        switch (this.f6273M) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "byte";
            case 3:
                return "char";
            case 4:
                return "double";
            case 5:
                return "float";
            case 6:
                return SliceItem.FORMAT_INT;
            case 7:
                return SliceItem.FORMAT_LONG;
            case 8:
                return "short";
            case 9:
                if (m8133p()) {
                    return m8138u().mo6681d() + "[]";
                }
                return m8126i().replace("/", ".");
            default:
                return this.f6272L;
        }
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: a */
    public C0975c mo6695a() {
        return this;
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0975c mo6696b() {
        switch (this.f6273M) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return f6251f;
            case 4:
            case 5:
            case 7:
            default:
                return this;
        }
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: c */
    public int mo6697c() {
        return this.f6273M;
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: e */
    public int mo6698e() {
        switch (this.f6273M) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return 6;
            case 4:
            case 5:
            case 7:
            default:
                return this.f6273M;
        }
    }

    @Override // com.p065b.p086b.p103f.p107d.InterfaceC0976d
    /* renamed from: f */
    public boolean mo6699f() {
        return false;
    }

    /* renamed from: h */
    public String m8125h() {
        return this.f6272L;
    }

    /* renamed from: i */
    public String m8126i() {
        if (this.f6275O == null) {
            if (!m8132o()) {
                throw new IllegalArgumentException("not an object type: " + this.f6272L);
            }
            if (this.f6272L.charAt(0) == '[') {
                this.f6275O = this.f6272L;
            } else {
                this.f6275O = this.f6272L.substring(1, this.f6272L.length() - 1);
            }
        }
        return this.f6275O;
    }

    /* renamed from: j */
    public int m8127j() {
        switch (this.f6273M) {
            case 4:
            case 7:
                return 2;
            case 5:
            case 6:
            default:
                return 1;
        }
    }

    /* renamed from: k */
    public boolean m8128k() {
        switch (this.f6273M) {
            case 4:
            case 7:
                return false;
            case 5:
            case 6:
            default:
                return true;
        }
    }

    /* renamed from: l */
    public boolean m8129l() {
        switch (this.f6273M) {
            case 4:
            case 7:
                return true;
            case 5:
            case 6:
            default:
                return false;
        }
    }

    /* renamed from: m */
    public boolean m8130m() {
        switch (this.f6273M) {
            case 1:
            case 2:
            case 3:
            case 6:
            case 8:
                return true;
            case 4:
            case 5:
            case 7:
            default:
                return false;
        }
    }

    /* renamed from: n */
    public boolean m8131n() {
        switch (this.f6273M) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: o */
    public boolean m8132o() {
        return this.f6273M == 9;
    }

    /* renamed from: p */
    public boolean m8133p() {
        return this.f6272L.charAt(0) == '[';
    }

    /* renamed from: q */
    public boolean m8134q() {
        return m8133p() || equals(f6255j);
    }

    /* renamed from: r */
    public boolean m8135r() {
        return this.f6274N >= 0;
    }

    /* renamed from: s */
    public C0975c m8136s() {
        if (this.f6278R == null) {
            throw new IllegalArgumentException("initialized type: " + this.f6272L);
        }
        return this.f6278R;
    }

    /* renamed from: t */
    public C0975c m8137t() {
        if (this.f6276P == null) {
            this.f6276P = m8119b(new C0975c('[' + this.f6272L, 9));
        }
        return this.f6276P;
    }

    /* renamed from: u */
    public C0975c m8138u() {
        if (this.f6277Q == null) {
            if (this.f6272L.charAt(0) != '[') {
                throw new IllegalArgumentException("not an array type: " + this.f6272L);
            }
            this.f6277Q = m8118a(this.f6272L.substring(1));
        }
        return this.f6277Q;
    }

    /* renamed from: a */
    public C0975c m8123a(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("newAt < 0");
        }
        if (!m8132o()) {
            throw new IllegalArgumentException("not a reference type: " + this.f6272L);
        }
        if (m8135r()) {
            throw new IllegalArgumentException("already uninitialized: " + this.f6272L);
        }
        C0975c c0975c = new C0975c(PhoneNumberUtils.WILD + C1022m.m8557c(i) + this.f6272L, 9, i);
        c0975c.f6278R = this;
        return m8119b(c0975c);
    }

    /* renamed from: b */
    private static C0975c m8119b(C0975c c0975c) {
        synchronized (f6245K) {
            String m8125h = c0975c.m8125h();
            C0975c c0975c2 = f6245K.get(m8125h);
            if (c0975c2 == null) {
                f6245K.put(m8125h, c0975c);
                return c0975c;
            }
            return c0975c2;
        }
    }
}
