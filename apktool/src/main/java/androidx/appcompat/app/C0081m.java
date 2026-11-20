package androidx.appcompat.app;

/* compiled from: TwilightCalculator.java */
/* renamed from: androidx.appcompat.app.m */
/* loaded from: classes.dex */
class C0081m {

    /* renamed from: d */
    private static C0081m f682d;

    /* renamed from: a */
    public long f683a;

    /* renamed from: b */
    public long f684b;

    /* renamed from: c */
    public int f685c;

    C0081m() {
    }

    /* renamed from: a */
    static C0081m m622a() {
        if (f682d == null) {
            f682d = new C0081m();
        }
        return f682d;
    }

    /* renamed from: a */
    public void m623a(long j, double d2, double d3) {
        float f2 = 6.24006f + (0.01720197f * ((j - 946728000000L) / 8.64E7f));
        double sin = f2 + (0.03341960161924362d * Math.sin(f2)) + (3.4906598739326E-4d * Math.sin(2.0f * f2)) + (5.236000106378924E-6d * Math.sin(3.0f * f2)) + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(f2) * 0.0053d) + ((-d3) / 360.0d) + Math.round((r2 - 9.0E-4f) - r6) + 9.0E-4f + ((-0.0069d) * Math.sin(2.0d * sin));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d2;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(asin))) / (Math.cos(asin) * Math.cos(d4));
        if (sin3 >= 1.0d) {
            this.f685c = 1;
            this.f683a = -1L;
            this.f684b = -1L;
        } else {
            if (sin3 <= -1.0d) {
                this.f685c = 0;
                this.f683a = -1L;
                this.f684b = -1L;
                return;
            }
            float acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.f683a = Math.round((acos + sin2) * 8.64E7d) + 946728000000L;
            this.f684b = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            if (this.f684b < j && this.f683a > j) {
                this.f685c = 0;
            } else {
                this.f685c = 1;
            }
        }
    }
}
