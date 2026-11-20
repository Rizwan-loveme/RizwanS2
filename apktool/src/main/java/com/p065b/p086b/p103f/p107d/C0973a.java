package com.p065b.p086b.p103f.p107d;

import java.util.HashMap;

/* compiled from: Prototype.java */
/* renamed from: com.b.b.f.d.a */
/* loaded from: classes.dex */
public final class C0973a implements Comparable<C0973a> {

    /* renamed from: a */
    private static final HashMap<String, C0973a> f6194a = new HashMap<>(500);

    /* renamed from: b */
    private final String f6195b;

    /* renamed from: c */
    private final C0975c f6196c;

    /* renamed from: d */
    private final C0974b f6197d;

    /* renamed from: e */
    private C0974b f6198e;

    /* renamed from: a */
    public static C0973a m8096a(String str) {
        C0973a c0973a;
        int i;
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        synchronized (f6194a) {
            c0973a = f6194a.get(str);
        }
        if (c0973a == null) {
            C0975c[] m8099b = m8099b(str);
            int i2 = 1;
            int i3 = 0;
            while (true) {
                char charAt = str.charAt(i2);
                if (charAt != ')') {
                    int i4 = i2;
                    while (charAt == '[') {
                        i4++;
                        charAt = str.charAt(i4);
                    }
                    if (charAt == 'L') {
                        int indexOf = str.indexOf(59, i4);
                        if (indexOf == -1) {
                            throw new IllegalArgumentException("bad descriptor");
                        }
                        i = indexOf + 1;
                    } else {
                        i = i4 + 1;
                    }
                    m8099b[i3] = C0975c.m8118a(str.substring(i2, i));
                    i3++;
                    i2 = i;
                } else {
                    C0975c m8120b = C0975c.m8120b(str.substring(i2 + 1));
                    C0974b c0974b = new C0974b(i3);
                    for (int i5 = 0; i5 < i3; i5++) {
                        c0974b.m8114a(i5, m8099b[i5]);
                    }
                    return m8098b(new C0973a(str, m8120b, c0974b));
                }
            }
        } else {
            return c0973a;
        }
    }

    /* renamed from: b */
    private static C0975c[] m8099b(String str) {
        int length = str.length();
        if (str.charAt(0) != '(') {
            throw new IllegalArgumentException("bad descriptor");
        }
        int i = 1;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                i = 0;
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == ')') {
                break;
            }
            if (charAt >= 'A' && charAt <= 'Z') {
                i2++;
            }
            i++;
        }
        if (i == 0 || i == length - 1) {
            throw new IllegalArgumentException("bad descriptor");
        }
        if (str.indexOf(41, i + 1) != -1) {
            throw new IllegalArgumentException("bad descriptor");
        }
        return new C0975c[i2];
    }

    /* renamed from: a */
    public static C0973a m8097a(String str, C0975c c0975c, boolean z, boolean z2) {
        C0973a m8096a = m8096a(str);
        if (!z) {
            if (z2) {
                c0975c = c0975c.m8123a(Integer.MAX_VALUE);
            }
            return m8096a.m8101a(c0975c);
        }
        return m8096a;
    }

    /* renamed from: a */
    public static C0973a m8095a(C0975c c0975c, int i) {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append('(');
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append('I');
        }
        stringBuffer.append(')');
        stringBuffer.append(c0975c.m8125h());
        return m8096a(stringBuffer.toString());
    }

    private C0973a(String str, C0975c c0975c, C0974b c0974b) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        if (c0975c == null) {
            throw new NullPointerException("returnType == null");
        }
        if (c0974b == null) {
            throw new NullPointerException("parameterTypes == null");
        }
        this.f6195b = str;
        this.f6196c = c0975c;
        this.f6197d = c0974b;
        this.f6198e = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0973a)) {
            return false;
        }
        return this.f6195b.equals(((C0973a) obj).f6195b);
    }

    public int hashCode() {
        return this.f6195b.hashCode();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C0973a c0973a) {
        if (this == c0973a) {
            return 0;
        }
        int compareTo = this.f6196c.compareTo(c0973a.f6196c);
        if (compareTo != 0) {
            return compareTo;
        }
        int f_ = this.f6197d.m8550f_();
        int f_2 = c0973a.f6197d.m8550f_();
        int min = Math.min(f_, f_2);
        for (int i = 0; i < min; i++) {
            int compareTo2 = this.f6197d.m8115b(i).compareTo(c0973a.f6197d.m8115b(i));
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        if (f_ < f_2) {
            return -1;
        }
        return f_ > f_2 ? 1 : 0;
    }

    public String toString() {
        return this.f6195b;
    }

    /* renamed from: a */
    public String m8102a() {
        return this.f6195b;
    }

    /* renamed from: b */
    public C0975c m8103b() {
        return this.f6196c;
    }

    /* renamed from: c */
    public C0974b m8104c() {
        return this.f6197d;
    }

    /* renamed from: d */
    public C0974b m8105d() {
        if (this.f6198e == null) {
            int f_ = this.f6197d.m8550f_();
            C0974b c0974b = new C0974b(f_);
            boolean z = false;
            for (int i = 0; i < f_; i++) {
                C0975c m8115b = this.f6197d.m8115b(i);
                if (m8115b.m8130m()) {
                    z = true;
                    m8115b = C0975c.f6251f;
                }
                c0974b.m8114a(i, m8115b);
            }
            this.f6198e = z ? c0974b : this.f6197d;
        }
        return this.f6198e;
    }

    /* renamed from: a */
    public C0973a m8101a(C0975c c0975c) {
        String str = "(" + c0975c.m8125h() + this.f6195b.substring(1);
        C0974b m8116c = this.f6197d.m8116c(c0975c);
        m8116c.mo6683e_();
        return m8098b(new C0973a(str, this.f6196c, m8116c));
    }

    /* renamed from: b */
    private static C0973a m8098b(C0973a c0973a) {
        synchronized (f6194a) {
            String m8102a = c0973a.m8102a();
            C0973a c0973a2 = f6194a.get(m8102a);
            if (c0973a2 == null) {
                f6194a.put(m8102a, c0973a);
                return c0973a;
            }
            return c0973a2;
        }
    }
}
