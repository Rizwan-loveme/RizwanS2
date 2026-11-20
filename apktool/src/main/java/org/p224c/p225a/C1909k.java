package org.p224c.p225a;

import java.p209io.InputStream;

/* compiled from: State.java */
/* renamed from: org.c.a.k */
/* loaded from: classes.dex */
final class C1909k {

    /* renamed from: A */
    byte[] f11208A;

    /* renamed from: B */
    int f11209B;

    /* renamed from: C */
    int f11210C;

    /* renamed from: D */
    int f11211D;

    /* renamed from: E */
    int f11212E;

    /* renamed from: F */
    int f11213F;

    /* renamed from: G */
    int f11214G;

    /* renamed from: H */
    byte[] f11215H;

    /* renamed from: I */
    int f11216I;

    /* renamed from: J */
    int f11217J;

    /* renamed from: K */
    int f11218K;

    /* renamed from: L */
    int f11219L;

    /* renamed from: M */
    int f11220M;

    /* renamed from: N */
    int f11221N;

    /* renamed from: O */
    int f11222O;

    /* renamed from: P */
    int f11223P;

    /* renamed from: U */
    int f11228U;

    /* renamed from: V */
    int f11229V;

    /* renamed from: W */
    int f11230W;

    /* renamed from: X */
    int f11231X;

    /* renamed from: Y */
    int f11232Y;

    /* renamed from: Z */
    byte[] f11233Z;

    /* renamed from: b */
    int f11235b;

    /* renamed from: d */
    byte[] f11237d;

    /* renamed from: g */
    int f11240g;

    /* renamed from: h */
    boolean f11241h;

    /* renamed from: i */
    boolean f11242i;

    /* renamed from: j */
    boolean f11243j;

    /* renamed from: w */
    int f11256w;

    /* renamed from: x */
    int f11257x;

    /* renamed from: y */
    int f11258y;

    /* renamed from: z */
    byte[] f11259z;

    /* renamed from: a */
    int f11234a = 0;

    /* renamed from: c */
    final C1899a f11236c = new C1899a();

    /* renamed from: e */
    final int[] f11238e = new int[3240];

    /* renamed from: f */
    final int[] f11239f = new int[3240];

    /* renamed from: k */
    final C1906h f11244k = new C1906h();

    /* renamed from: l */
    final C1906h f11245l = new C1906h();

    /* renamed from: m */
    final C1906h f11246m = new C1906h();

    /* renamed from: n */
    final int[] f11247n = new int[3];

    /* renamed from: o */
    final int[] f11248o = new int[3];

    /* renamed from: p */
    final int[] f11249p = new int[6];

    /* renamed from: q */
    final int[] f11250q = {16, 15, 11, 4};

    /* renamed from: r */
    int f11251r = 0;

    /* renamed from: s */
    int f11252s = 0;

    /* renamed from: t */
    int f11253t = 0;

    /* renamed from: u */
    boolean f11254u = false;

    /* renamed from: v */
    int f11255v = 0;

    /* renamed from: Q */
    int f11224Q = 0;

    /* renamed from: R */
    long f11225R = 0;

    /* renamed from: S */
    byte[] f11226S = new byte[0];

    /* renamed from: T */
    int f11227T = 0;

    C1909k() {
    }

    /* renamed from: a */
    private static int m14073a(C1899a c1899a) {
        if (C1899a.m14029a(c1899a, 1) == 0) {
            return 16;
        }
        int m14029a = C1899a.m14029a(c1899a, 3);
        if (m14029a != 0) {
            return m14029a + 17;
        }
        int m14029a2 = C1899a.m14029a(c1899a, 3);
        if (m14029a2 != 0) {
            return m14029a2 + 8;
        }
        return 17;
    }

    /* renamed from: a */
    static void m14075a(C1909k c1909k, InputStream inputStream) {
        if (c1909k.f11234a != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        C1899a.m14031a(c1909k.f11236c, inputStream);
        int m14073a = m14073a(c1909k.f11236c);
        if (m14073a == 9) {
            throw new C1901c("Invalid 'windowBits' code");
        }
        c1909k.f11223P = 1 << m14073a;
        c1909k.f11222O = c1909k.f11223P - 16;
        c1909k.f11234a = 1;
    }

    /* renamed from: a */
    static void m14074a(C1909k c1909k) {
        if (c1909k.f11234a == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (c1909k.f11234a != 11) {
            c1909k.f11234a = 11;
            C1899a.m14036d(c1909k.f11236c);
        }
    }
}
