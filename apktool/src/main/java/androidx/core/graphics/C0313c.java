package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: PathParser.java */
/* renamed from: androidx.core.graphics.c */
/* loaded from: classes.dex */
public class C0313c {
    /* renamed from: a */
    static float[] m2321a(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    /* renamed from: a */
    public static Path m2317a(String str) {
        Path path = new Path();
        b[] m2324b = m2324b(str);
        if (m2324b != null) {
            try {
                b.m2329a(m2324b, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException("Error in parsing " + str, e2);
            }
        }
        return null;
    }

    /* renamed from: b */
    public static b[] m2324b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int m2316a = m2316a(str, i);
            String trim = str.substring(i2, m2316a).trim();
            if (trim.length() > 0) {
                m2319a((ArrayList<b>) arrayList, trim.charAt(0), m2325c(trim));
            }
            i = m2316a + 1;
            i2 = m2316a;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            m2319a((ArrayList<b>) arrayList, str.charAt(i2), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    /* renamed from: a */
    public static b[] m2322a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new b(bVarArr[i]);
        }
        return bVarArr2;
    }

    /* renamed from: a */
    public static boolean m2320a(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].f2242a != bVarArr2[i].f2242a || bVarArr[i].f2243b.length != bVarArr2[i].f2243b.length) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static void m2323b(b[] bVarArr, b[] bVarArr2) {
        for (int i = 0; i < bVarArr2.length; i++) {
            bVarArr[i].f2242a = bVarArr2[i].f2242a;
            for (int i2 = 0; i2 < bVarArr2[i].f2243b.length; i2++) {
                bVarArr[i].f2243b[i2] = bVarArr2[i].f2243b[i2];
            }
        }
    }

    /* renamed from: a */
    private static int m2316a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    /* renamed from: a */
    private static void m2319a(ArrayList<b> arrayList, char c2, float[] fArr) {
        arrayList.add(new b(c2, fArr));
    }

    /* compiled from: PathParser.java */
    /* renamed from: androidx.core.graphics.c$a */
    private static class a {

        /* renamed from: a */
        int f2240a;

        /* renamed from: b */
        boolean f2241b;

        a() {
        }
    }

    /* renamed from: c */
    private static float[] m2325c(String str) {
        int i;
        int i2 = 0;
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i3 = 1;
            while (i3 < length) {
                m2318a(str, i3, aVar);
                int i4 = aVar.f2240a;
                if (i3 < i4) {
                    i = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i3, i4));
                } else {
                    i = i2;
                }
                if (aVar.f2241b) {
                    i3 = i4;
                    i2 = i;
                } else {
                    i3 = i4 + 1;
                    i2 = i;
                }
            }
            return m2321a(fArr, 0, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private static void m2318a(String str, int i, a aVar) {
        aVar.f2241b = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            switch (str.charAt(i2)) {
                case ' ':
                case ',':
                    z = false;
                    z3 = true;
                    break;
                case '-':
                    if (i2 != i && !z) {
                        aVar.f2241b = true;
                        z = false;
                        z3 = true;
                        break;
                    }
                    z = false;
                    break;
                case '.':
                    if (z2) {
                        aVar.f2241b = true;
                        z = false;
                        z3 = true;
                        break;
                    } else {
                        z = false;
                        z2 = true;
                        break;
                    }
                case 'E':
                case 'e':
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z3) {
                aVar.f2240a = i2;
            }
        }
        aVar.f2240a = i2;
    }

    /* compiled from: PathParser.java */
    /* renamed from: androidx.core.graphics.c$b */
    public static class b {

        /* renamed from: a */
        public char f2242a;

        /* renamed from: b */
        public float[] f2243b;

        b(char c2, float[] fArr) {
            this.f2242a = c2;
            this.f2243b = fArr;
        }

        b(b bVar) {
            this.f2242a = bVar.f2242a;
            this.f2243b = C0313c.m2321a(bVar.f2243b, 0, bVar.f2243b.length);
        }

        /* renamed from: a */
        public static void m2329a(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                m2328a(path, fArr, c2, bVarArr[i].f2242a, bVarArr[i].f2243b);
                c2 = bVarArr[i].f2242a;
            }
        }

        /* renamed from: a */
        public void m2330a(b bVar, b bVar2, float f2) {
            this.f2242a = bVar.f2242a;
            for (int i = 0; i < bVar.f2243b.length; i++) {
                this.f2243b[i] = (bVar.f2243b[i] * (1.0f - f2)) + (bVar2.f2243b[i] * f2);
            }
        }

        /* renamed from: a */
        private static void m2328a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            switch (c3) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f14, f15);
                    f13 = f15;
                    f12 = f14;
                    f11 = f15;
                    f10 = f14;
                    i = 2;
                    break;
                default:
                    i = 2;
                    break;
            }
            int i2 = 0;
            float f16 = f15;
            float f17 = f14;
            float f18 = f13;
            float f19 = f12;
            float f20 = f11;
            float f21 = f10;
            while (i2 < fArr2.length) {
                switch (c3) {
                    case 'A':
                        m2327a(path, f21, f20, fArr2[i2 + 5], fArr2[i2 + 6], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        float f22 = fArr2[i2 + 5];
                        float f23 = fArr2[i2 + 6];
                        f2 = f16;
                        f3 = f17;
                        f4 = f23;
                        f5 = f22;
                        f6 = f23;
                        f7 = f22;
                        break;
                    case 'C':
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        float f24 = fArr2[i2 + 4];
                        float f25 = fArr2[i2 + 5];
                        float f26 = fArr2[i2 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = fArr2[i2 + 3];
                        f5 = f26;
                        f6 = f25;
                        f7 = f24;
                        break;
                    case 'H':
                        path.lineTo(fArr2[i2 + 0], f20);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = f20;
                        f7 = fArr2[i2 + 0];
                        break;
                    case 'L':
                        path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        float f27 = fArr2[i2 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i2 + 1];
                        f7 = f27;
                        break;
                    case 'M':
                        float f28 = fArr2[i2 + 0];
                        float f29 = fArr2[i2 + 1];
                        if (i2 > 0) {
                            path.lineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f2 = f16;
                            f3 = f17;
                            f4 = f18;
                            f5 = f19;
                            f6 = f29;
                            f7 = f28;
                            break;
                        } else {
                            path.moveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f2 = f29;
                            f3 = f28;
                            f4 = f18;
                            f5 = f19;
                            f6 = f29;
                            f7 = f28;
                            break;
                        }
                    case 'Q':
                        path.quadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f30 = fArr2[i2 + 0];
                        float f31 = fArr2[i2 + 1];
                        float f32 = fArr2[i2 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f31;
                        f5 = f30;
                        f6 = fArr2[i2 + 3];
                        f7 = f32;
                        break;
                    case 'S':
                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                            f8 = (2.0f * f21) - f19;
                            f9 = (2.0f * f20) - f18;
                        } else {
                            f9 = f20;
                            f8 = f21;
                        }
                        path.cubicTo(f8, f9, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f33 = fArr2[i2 + 0];
                        float f34 = fArr2[i2 + 1];
                        float f35 = fArr2[i2 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f34;
                        f5 = f33;
                        f6 = fArr2[i2 + 3];
                        f7 = f35;
                        break;
                    case 'T':
                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                            f21 = (2.0f * f21) - f19;
                            f20 = (2.0f * f20) - f18;
                        }
                        path.quadTo(f21, f20, fArr2[i2 + 0], fArr2[i2 + 1]);
                        float f36 = fArr2[i2 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f20;
                        f5 = f21;
                        f6 = fArr2[i2 + 1];
                        f7 = f36;
                        break;
                    case 'V':
                        path.lineTo(f21, fArr2[i2 + 0]);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i2 + 0];
                        f7 = f21;
                        break;
                    case 'a':
                        m2327a(path, f21, f20, fArr2[i2 + 5] + f21, fArr2[i2 + 6] + f20, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        float f37 = f21 + fArr2[i2 + 5];
                        float f38 = f20 + fArr2[i2 + 6];
                        f2 = f16;
                        f3 = f17;
                        f4 = f38;
                        f5 = f37;
                        f6 = f38;
                        f7 = f37;
                        break;
                    case 'c':
                        path.rCubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3], fArr2[i2 + 4], fArr2[i2 + 5]);
                        float f39 = f21 + fArr2[i2 + 2];
                        float f40 = f20 + fArr2[i2 + 3];
                        float f41 = f21 + fArr2[i2 + 4];
                        f2 = f16;
                        f3 = f17;
                        f4 = f40;
                        f5 = f39;
                        f6 = fArr2[i2 + 5] + f20;
                        f7 = f41;
                        break;
                    case 'h':
                        path.rLineTo(fArr2[i2 + 0], 0.0f);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = f20;
                        f7 = f21 + fArr2[i2 + 0];
                        break;
                    case 'l':
                        path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                        float f42 = f21 + fArr2[i2 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i2 + 1] + f20;
                        f7 = f42;
                        break;
                    case 'm':
                        float f43 = f21 + fArr2[i2 + 0];
                        float f44 = fArr2[i2 + 1] + f20;
                        if (i2 > 0) {
                            path.rLineTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f2 = f16;
                            f3 = f17;
                            f4 = f18;
                            f5 = f19;
                            f6 = f44;
                            f7 = f43;
                            break;
                        } else {
                            path.rMoveTo(fArr2[i2 + 0], fArr2[i2 + 1]);
                            f2 = f44;
                            f3 = f43;
                            f4 = f18;
                            f5 = f19;
                            f6 = f44;
                            f7 = f43;
                            break;
                        }
                    case 'q':
                        path.rQuadTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f45 = f21 + fArr2[i2 + 0];
                        float f46 = f20 + fArr2[i2 + 1];
                        float f47 = f21 + fArr2[i2 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f46;
                        f5 = f45;
                        f6 = fArr2[i2 + 3] + f20;
                        f7 = f47;
                        break;
                    case 's':
                        float f48 = 0.0f;
                        float f49 = 0.0f;
                        if (c2 == 'c' || c2 == 's' || c2 == 'C' || c2 == 'S') {
                            f48 = f21 - f19;
                            f49 = f20 - f18;
                        }
                        path.rCubicTo(f48, f49, fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3]);
                        float f50 = f21 + fArr2[i2 + 0];
                        float f51 = f20 + fArr2[i2 + 1];
                        float f52 = f21 + fArr2[i2 + 2];
                        f2 = f16;
                        f3 = f17;
                        f4 = f51;
                        f5 = f50;
                        f6 = fArr2[i2 + 3] + f20;
                        f7 = f52;
                        break;
                    case 't':
                        float f53 = 0.0f;
                        float f54 = 0.0f;
                        if (c2 == 'q' || c2 == 't' || c2 == 'Q' || c2 == 'T') {
                            f53 = f21 - f19;
                            f54 = f20 - f18;
                        }
                        path.rQuadTo(f53, f54, fArr2[i2 + 0], fArr2[i2 + 1]);
                        float f55 = f21 + f53;
                        float f56 = f21 + fArr2[i2 + 0];
                        f2 = f16;
                        f3 = f17;
                        f4 = f20 + f54;
                        f5 = f55;
                        f6 = fArr2[i2 + 1] + f20;
                        f7 = f56;
                        break;
                    case 'v':
                        path.rLineTo(0.0f, fArr2[i2 + 0]);
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = fArr2[i2 + 0] + f20;
                        f7 = f21;
                        break;
                    default:
                        f2 = f16;
                        f3 = f17;
                        f4 = f18;
                        f5 = f19;
                        f6 = f20;
                        f7 = f21;
                        break;
                }
                i2 += i;
                f16 = f2;
                f17 = f3;
                f18 = f4;
                f19 = f5;
                f20 = f6;
                f21 = f7;
                c2 = c3;
            }
            fArr[0] = f21;
            fArr[1] = f20;
            fArr[2] = f19;
            fArr[3] = f18;
            fArr[4] = f17;
            fArr[5] = f16;
        }

        /* renamed from: a */
        private static void m2327a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = ((f2 * cos) + (f3 * sin)) / f6;
            double d5 = (((-f2) * sin) + (f3 * cos)) / f7;
            double d6 = ((f4 * cos) + (f5 * sin)) / f6;
            double d7 = (((-f4) * sin) + (f5 * cos)) / f7;
            double d8 = d4 - d6;
            double d9 = d5 - d7;
            double d10 = (d4 + d6) / 2.0d;
            double d11 = (d5 + d7) / 2.0d;
            double d12 = (d8 * d8) + (d9 * d9);
            if (d12 == 0.0d) {
                Log.m190w("PathParser", " Points are coincident");
                return;
            }
            double d13 = (1.0d / d12) - 0.25d;
            if (d13 < 0.0d) {
                Log.m190w("PathParser", "Points are too far apart " + d12);
                float sqrt = (float) (Math.sqrt(d12) / 1.99999d);
                m2327a(path, f2, f3, f4, f5, f6 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d13);
            double d14 = d8 * sqrt2;
            double d15 = d9 * sqrt2;
            if (z == z2) {
                d2 = d10 - d15;
                d3 = d14 + d11;
            } else {
                d2 = d15 + d10;
                d3 = d11 - d14;
            }
            double atan2 = Math.atan2(d5 - d3, d4 - d2);
            double atan22 = Math.atan2(d7 - d3, d6 - d2) - atan2;
            if (z2 != (atan22 >= 0.0d)) {
                if (atan22 > 0.0d) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d16 = f6 * d2;
            double d17 = d3 * f7;
            m2326a(path, (d16 * cos) - (d17 * sin), (d16 * sin) + (d17 * cos), f6, f7, f2, f3, radians, atan2, atan22);
        }

        /* renamed from: a */
        private static void m2326a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            int ceil = (int) Math.ceil(Math.abs((4.0d * d10) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d11 = (((-d4) * cos) * sin2) - ((d5 * sin) * cos2);
            double d12 = (sin2 * (-d4) * sin) + (cos2 * d5 * cos);
            double d13 = d10 / ceil;
            int i = 0;
            while (i < ceil) {
                double d14 = d9 + d13;
                double sin3 = Math.sin(d14);
                double cos3 = Math.cos(d14);
                double d15 = (((d4 * cos) * cos3) + d2) - ((d5 * sin) * sin3);
                double d16 = (d5 * cos * sin3) + (d4 * sin * cos3) + d3;
                double d17 = (((-d4) * cos) * sin3) - ((d5 * sin) * cos3);
                double d18 = (cos3 * d5 * cos) + (sin3 * (-d4) * sin);
                double tan = Math.tan((d14 - d9) / 2.0d);
                double sqrt = ((Math.sqrt((tan * (3.0d * tan)) + 4.0d) - 1.0d) * Math.sin(d14 - d9)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d11 * sqrt) + d6), (float) ((d12 * sqrt) + d7), (float) (d15 - (sqrt * d17)), (float) (d16 - (sqrt * d18)), (float) d15, (float) d16);
                i++;
                d12 = d18;
                d11 = d17;
                d9 = d14;
                d7 = d16;
                d6 = d15;
            }
        }
    }
}
