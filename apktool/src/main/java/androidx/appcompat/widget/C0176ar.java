package androidx.appcompat.widget;

/* compiled from: RtlSpacingHelper.java */
/* renamed from: androidx.appcompat.widget.ar */
/* loaded from: classes.dex */
class C0176ar {

    /* renamed from: a */
    private int f1523a = 0;

    /* renamed from: b */
    private int f1524b = 0;

    /* renamed from: c */
    private int f1525c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f1526d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f1527e = 0;

    /* renamed from: f */
    private int f1528f = 0;

    /* renamed from: g */
    private boolean f1529g = false;

    /* renamed from: h */
    private boolean f1530h = false;

    C0176ar() {
    }

    /* renamed from: a */
    public int m1380a() {
        return this.f1523a;
    }

    /* renamed from: b */
    public int m1383b() {
        return this.f1524b;
    }

    /* renamed from: c */
    public int m1385c() {
        return this.f1529g ? this.f1524b : this.f1523a;
    }

    /* renamed from: d */
    public int m1386d() {
        return this.f1529g ? this.f1523a : this.f1524b;
    }

    /* renamed from: a */
    public void m1381a(int i, int i2) {
        this.f1525c = i;
        this.f1526d = i2;
        this.f1530h = true;
        if (this.f1529g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1523a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1524b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1523a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1524b = i2;
        }
    }

    /* renamed from: b */
    public void m1384b(int i, int i2) {
        this.f1530h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1527e = i;
            this.f1523a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1528f = i2;
            this.f1524b = i2;
        }
    }

    /* renamed from: a */
    public void m1382a(boolean z) {
        if (z != this.f1529g) {
            this.f1529g = z;
            if (this.f1530h) {
                if (z) {
                    this.f1523a = this.f1526d != Integer.MIN_VALUE ? this.f1526d : this.f1527e;
                    this.f1524b = this.f1525c != Integer.MIN_VALUE ? this.f1525c : this.f1528f;
                    return;
                } else {
                    this.f1523a = this.f1525c != Integer.MIN_VALUE ? this.f1525c : this.f1527e;
                    this.f1524b = this.f1526d != Integer.MIN_VALUE ? this.f1526d : this.f1528f;
                    return;
                }
            }
            this.f1523a = this.f1527e;
            this.f1524b = this.f1528f;
        }
    }
}
