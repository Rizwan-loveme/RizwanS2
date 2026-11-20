package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p103f.p106c.C0970x;
import com.p065b.p086b.p110h.C1022m;

/* compiled from: SourcePosition.java */
/* renamed from: com.b.b.f.b.v */
/* loaded from: classes.dex */
public final class C0940v {

    /* renamed from: a */
    public static final C0940v f6128a = new C0940v(null, -1, -1);

    /* renamed from: b */
    private final C0970x f6129b;

    /* renamed from: c */
    private final int f6130c;

    /* renamed from: d */
    private final int f6131d;

    public C0940v(C0970x c0970x, int i, int i2) {
        if (i < -1) {
            throw new IllegalArgumentException("address < -1");
        }
        if (i2 < -1) {
            throw new IllegalArgumentException("line < -1");
        }
        this.f6129b = c0970x;
        this.f6130c = i;
        this.f6131d = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        if (this.f6129b != null) {
            stringBuffer.append(this.f6129b.mo6681d());
            stringBuffer.append(":");
        }
        if (this.f6131d >= 0) {
            stringBuffer.append(this.f6131d);
        }
        stringBuffer.append('@');
        if (this.f6130c < 0) {
            stringBuffer.append("????");
        } else {
            stringBuffer.append(C1022m.m8557c(this.f6130c));
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0940v)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0940v c0940v = (C0940v) obj;
        return this.f6130c == c0940v.f6130c && m8030b(c0940v);
    }

    public int hashCode() {
        return this.f6129b.hashCode() + this.f6130c + this.f6131d;
    }

    /* renamed from: a */
    public boolean m8029a(C0940v c0940v) {
        return this.f6131d == c0940v.f6131d;
    }

    /* renamed from: b */
    public boolean m8030b(C0940v c0940v) {
        return this.f6131d == c0940v.f6131d && (this.f6129b == c0940v.f6129b || (this.f6129b != null && this.f6129b.equals(c0940v.f6129b)));
    }

    /* renamed from: a */
    public int m8028a() {
        return this.f6131d;
    }
}
