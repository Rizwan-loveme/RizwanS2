package com.p065b.p086b.p095c.p096a;

import com.p065b.p086b.p095c.p097b.C0806h;
import com.p065b.p086b.p103f.p105b.C0938t;
import java.io.PrintStream;

/* compiled from: CodeStatistics.java */
/* renamed from: com.b.b.c.a.d */
/* loaded from: classes.dex */
public final class C0763d {

    /* renamed from: a */
    public static int f4721a = 0;

    /* renamed from: b */
    public static int f4722b = 0;

    /* renamed from: c */
    public static int f4723c = 0;

    /* renamed from: d */
    public static int f4724d = 0;

    /* renamed from: e */
    public static int f4725e = 0;

    /* renamed from: f */
    public static int f4726f = 0;

    /* renamed from: g */
    public static int f4727g = 0;

    /* renamed from: a */
    public static void m6955a(int i) {
        f4727g += i;
    }

    /* renamed from: a */
    public static void m6956a(C0806h c0806h, C0806h c0806h2) {
        f4725e += c0806h2.m7028f().m7053e() - c0806h.m7028f().m7053e();
        f4724d += c0806h2.m7028f().m7054f() - c0806h.m7028f().m7054f();
        f4726f += c0806h2.m7028f().m7053e();
    }

    /* renamed from: a */
    public static void m6957a(C0938t c0938t, C0938t c0938t2) {
        int m7861g = c0938t.m7977a().m7861g();
        int m7859e = c0938t.m7977a().m7859e();
        int m7861g2 = c0938t2.m7977a().m7861g();
        f4722b = (m7861g2 - m7861g) + f4722b;
        f4721a += c0938t2.m7977a().m7859e() - m7859e;
        f4723c += m7861g2;
    }

    /* renamed from: a */
    public static void m6958a(PrintStream printStream) {
        printStream.printf("Optimizer Delta Rop Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", Integer.valueOf(f4722b), Integer.valueOf(f4723c), Double.valueOf((f4722b / (f4723c + Math.abs(f4722b))) * 100.0d), Integer.valueOf(f4721a));
        printStream.printf("Optimizer Delta Dex Insns: Insns: %d total: %d (%.2f%%) Delta Registers: %d\n", Integer.valueOf(f4725e), Integer.valueOf(f4726f), Double.valueOf((f4725e / (f4726f + Math.abs(f4725e))) * 100.0d), Integer.valueOf(f4724d));
        printStream.printf("Original bytecode byte count: %d\n", Integer.valueOf(f4727g));
    }
}
