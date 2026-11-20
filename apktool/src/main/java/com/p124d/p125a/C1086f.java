package com.p124d.p125a;

/* compiled from: PreserveAspectRatio.java */
/* renamed from: com.d.a.f */
/* loaded from: classes.dex */
public class C1086f {

    /* renamed from: a */
    public static final C1086f f6986a = new C1086f(null, null);

    /* renamed from: b */
    public static final C1086f f6987b = new C1086f(a.none, null);

    /* renamed from: c */
    public static final C1086f f6988c = new C1086f(a.xMidYMid, b.meet);

    /* renamed from: d */
    public static final C1086f f6989d = new C1086f(a.xMinYMin, b.meet);

    /* renamed from: e */
    public static final C1086f f6990e = new C1086f(a.xMaxYMax, b.meet);

    /* renamed from: f */
    public static final C1086f f6991f = new C1086f(a.xMidYMin, b.meet);

    /* renamed from: g */
    public static final C1086f f6992g = new C1086f(a.xMidYMax, b.meet);

    /* renamed from: h */
    public static final C1086f f6993h = new C1086f(a.xMidYMid, b.slice);

    /* renamed from: i */
    public static final C1086f f6994i = new C1086f(a.xMinYMin, b.slice);

    /* renamed from: j */
    private a f6995j;

    /* renamed from: k */
    private b f6996k;

    /* compiled from: PreserveAspectRatio.java */
    /* renamed from: com.d.a.f$a */
    public enum a {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    /* compiled from: PreserveAspectRatio.java */
    /* renamed from: com.d.a.f$b */
    public enum b {
        meet,
        slice
    }

    C1086f(a aVar, b bVar) {
        this.f6995j = aVar;
        this.f6996k = bVar;
    }

    /* renamed from: a */
    public a m9063a() {
        return this.f6995j;
    }

    /* renamed from: b */
    public b m9064b() {
        return this.f6996k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C1086f c1086f = (C1086f) obj;
            return this.f6995j == c1086f.f6995j && this.f6996k == c1086f.f6996k;
        }
        return false;
    }

    public String toString() {
        return this.f6995j + " " + this.f6996k;
    }
}
