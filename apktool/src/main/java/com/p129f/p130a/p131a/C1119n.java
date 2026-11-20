package com.p129f.p130a.p131a;

import java.util.Locale;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Platform.java */
/* renamed from: com.f.a.a.n */
/* loaded from: classes.dex */
final class C1119n {

    /* renamed from: a */
    private static final Logger f7536a = Logger.getLogger(C1119n.class.getName());

    /* renamed from: b */
    private static final InterfaceC1118m f7537b = m9544b();

    private C1119n() {
    }

    /* renamed from: a */
    static long m9541a() {
        return System.nanoTime();
    }

    /* renamed from: a */
    static String m9542a(double d2) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d2));
    }

    /* renamed from: a */
    static boolean m9543a(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: b */
    private static InterfaceC1118m m9544b() {
        return new a();
    }

    /* compiled from: Platform.java */
    /* renamed from: com.f.a.a.n$a */
    private static final class a implements InterfaceC1118m {
        private a() {
        }
    }
}
