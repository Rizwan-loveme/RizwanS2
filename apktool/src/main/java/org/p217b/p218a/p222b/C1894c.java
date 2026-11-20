package org.p217b.p218a.p222b;

/* compiled from: IntHashMap.java */
/* renamed from: org.b.a.b.c */
/* loaded from: classes.dex */
class C1894c {

    /* renamed from: a */
    private transient a[] f11092a;

    /* renamed from: b */
    private transient int f11093b;

    /* renamed from: c */
    private int f11094c;

    /* renamed from: d */
    private final float f11095d;

    /* compiled from: IntHashMap.java */
    /* renamed from: org.b.a.b.c$a */
    private static class a {

        /* renamed from: a */
        final int f11096a;

        /* renamed from: b */
        final int f11097b;

        /* renamed from: c */
        Object f11098c;

        /* renamed from: d */
        a f11099d;

        protected a(int i, int i2, Object obj, a aVar) {
            this.f11096a = i;
            this.f11097b = i2;
            this.f11098c = obj;
            this.f11099d = aVar;
        }
    }

    public C1894c() {
        this(20, 0.75f);
    }

    public C1894c(int i, float f2) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal Capacity: ").append(i).toString());
        }
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException(new StringBuffer().append("Illegal Load: ").append(f2).toString());
        }
        i = i == 0 ? 1 : i;
        this.f11095d = f2;
        this.f11092a = new a[i];
        this.f11094c = (int) (i * f2);
    }

    /* renamed from: a */
    protected void m14011a() {
        int length = this.f11092a.length;
        a[] aVarArr = this.f11092a;
        int i = (length * 2) + 1;
        a[] aVarArr2 = new a[i];
        this.f11094c = (int) (i * this.f11095d);
        this.f11092a = aVarArr2;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                a aVar = aVarArr[i2];
                while (aVar != null) {
                    a aVar2 = aVar.f11099d;
                    int i3 = (aVar.f11096a & Integer.MAX_VALUE) % i;
                    aVar.f11099d = aVarArr2[i3];
                    aVarArr2[i3] = aVar;
                    aVar = aVar2;
                }
                length = i2;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public Object m14010a(int i, Object obj) {
        a[] aVarArr = this.f11092a;
        int length = (i & Integer.MAX_VALUE) % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.f11099d) {
            if (aVar.f11096a == i) {
                Object obj2 = aVar.f11098c;
                aVar.f11098c = obj;
                return obj2;
            }
        }
        if (this.f11093b >= this.f11094c) {
            m14011a();
            aVarArr = this.f11092a;
            length = (i & Integer.MAX_VALUE) % aVarArr.length;
        }
        aVarArr[length] = new a(i, i, obj, aVarArr[length]);
        this.f11093b++;
        return null;
    }
}
