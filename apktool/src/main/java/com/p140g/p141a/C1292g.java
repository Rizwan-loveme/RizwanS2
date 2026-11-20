package com.p140g.p141a;

import java.util.Arrays;

/* compiled from: Proto.java */
/* renamed from: com.g.a.g */
/* loaded from: classes.dex */
public class C1292g {

    /* renamed from: a */
    private String f8509a;

    /* renamed from: b */
    private String[] f8510b;

    /* renamed from: c */
    private String f8511c;

    public C1292g(String[] strArr, String str) {
        this.f8510b = strArr;
        this.f8511c = str;
    }

    /* renamed from: a */
    public String[] m10470a() {
        return this.f8510b;
    }

    /* renamed from: b */
    public String m10471b() {
        return this.f8511c;
    }

    /* renamed from: c */
    public String m10472c() {
        if (this.f8509a == null) {
            StringBuilder sb = new StringBuilder("(");
            if (this.f8510b != null) {
                for (String str : this.f8510b) {
                    sb.append(str);
                }
            }
            sb.append(")").append(this.f8511c);
            this.f8509a = sb.toString();
        }
        return this.f8509a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1292g c1292g = (C1292g) obj;
        if (Arrays.equals(this.f8510b, c1292g.f8510b)) {
            return this.f8511c != null ? this.f8511c.equals(c1292g.f8511c) : c1292g.f8511c == null;
        }
        return false;
    }

    public int hashCode() {
        return (this.f8511c != null ? this.f8511c.hashCode() : 0) + (Arrays.hashCode(this.f8510b) * 31);
    }
}
