package com.p129f.p130a.p132b;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: Striped64.java */
/* renamed from: com.f.a.b.o */
/* loaded from: classes.dex */
abstract class AbstractC1145o extends Number {

    /* renamed from: a */
    static final ThreadLocal<int[]> f7752a = new ThreadLocal<>();

    /* renamed from: b */
    static final Random f7753b = new Random();

    /* renamed from: c */
    static final int f7754c = Runtime.getRuntime().availableProcessors();

    /* renamed from: g */
    private static final Unsafe f7755g;

    /* renamed from: h */
    private static final long f7756h;

    /* renamed from: i */
    private static final long f7757i;

    /* renamed from: d */
    @NullableDecl
    volatile transient a[] f7758d;

    /* renamed from: e */
    volatile transient long f7759e;

    /* renamed from: f */
    volatile transient int f7760f;

    /* renamed from: a */
    abstract long mo9782a(long j, long j2);

    /* compiled from: Striped64.java */
    /* renamed from: com.f.a.b.o$a */
    static final class a {

        /* renamed from: b */
        private static final Unsafe f7761b;

        /* renamed from: c */
        private static final long f7762c;

        /* renamed from: a */
        volatile long f7763a;

        a(long j) {
            this.f7763a = j;
        }

        /* renamed from: a */
        final boolean m9792a(long j, long j2) {
            return f7761b.compareAndSwapLong(this, f7762c, j, j2);
        }

        static {
            try {
                f7761b = AbstractC1145o.m9786a();
                f7762c = f7761b.objectFieldOffset(a.class.getDeclaredField("value"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }
    }

    static {
        try {
            f7755g = m9786a();
            f7756h = f7755g.objectFieldOffset(AbstractC1145o.class.getDeclaredField("base"));
            f7757i = f7755g.objectFieldOffset(AbstractC1145o.class.getDeclaredField("busy"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    AbstractC1145o() {
    }

    /* renamed from: b */
    final boolean m9789b(long j, long j2) {
        return f7755g.compareAndSwapLong(this, f7756h, j, j2);
    }

    /* renamed from: c */
    final boolean m9790c() {
        return f7755g.compareAndSwapInt(this, f7757i, 0, 1);
    }

    /* renamed from: a */
    final void m9788a(long j, int[] iArr, boolean z) {
        int i;
        int length;
        int length2;
        if (iArr == null) {
            iArr = new int[1];
            f7752a.set(iArr);
            i = f7753b.nextInt();
            if (i == 0) {
                i = 1;
            }
            iArr[0] = i;
        } else {
            i = iArr[0];
        }
        boolean z2 = false;
        int i2 = i;
        while (true) {
            a[] aVarArr = this.f7758d;
            if (aVarArr != null && (length = aVarArr.length) > 0) {
                a aVar = aVarArr[(length - 1) & i2];
                if (aVar == null) {
                    if (this.f7760f == 0) {
                        a aVar2 = new a(j);
                        if (this.f7760f == 0 && m9790c()) {
                            boolean z3 = false;
                            try {
                                a[] aVarArr2 = this.f7758d;
                                if (aVarArr2 != null && (length2 = aVarArr2.length) > 0) {
                                    int i3 = (length2 - 1) & i2;
                                    if (aVarArr2[i3] == null) {
                                        aVarArr2[i3] = aVar2;
                                        z3 = true;
                                    }
                                }
                                if (z3) {
                                    return;
                                }
                            } finally {
                            }
                        }
                    }
                    z2 = false;
                    int i4 = (i2 << 13) ^ i2;
                    int i5 = i4 ^ (i4 >>> 17);
                    i2 = (i5 << 5) ^ i5;
                    iArr[0] = i2;
                } else {
                    if (!z) {
                        z = true;
                    } else {
                        long j2 = aVar.f7763a;
                        if (!aVar.m9792a(j2, mo9782a(j2, j))) {
                            if (length >= f7754c || this.f7758d != aVarArr) {
                                z2 = false;
                            } else if (!z2) {
                                z2 = true;
                            } else if (this.f7760f == 0 && m9790c()) {
                                try {
                                    if (this.f7758d == aVarArr) {
                                        a[] aVarArr3 = new a[length << 1];
                                        for (int i6 = 0; i6 < length; i6++) {
                                            aVarArr3[i6] = aVarArr[i6];
                                        }
                                        this.f7758d = aVarArr3;
                                    }
                                    this.f7760f = 0;
                                    z2 = false;
                                } finally {
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    int i42 = (i2 << 13) ^ i2;
                    int i52 = i42 ^ (i42 >>> 17);
                    i2 = (i52 << 5) ^ i52;
                    iArr[0] = i2;
                }
            } else if (this.f7760f == 0 && this.f7758d == aVarArr && m9790c()) {
                boolean z4 = false;
                try {
                    if (this.f7758d == aVarArr) {
                        a[] aVarArr4 = new a[2];
                        aVarArr4[i2 & 1] = new a(j);
                        this.f7758d = aVarArr4;
                        z4 = true;
                    }
                    if (z4) {
                        return;
                    }
                } finally {
                }
            } else {
                long j3 = this.f7759e;
                if (m9789b(j3, mo9782a(j3, j))) {
                    return;
                }
            }
            z2 = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static Unsafe m9786a() {
        try {
            return Unsafe.getUnsafe();
        } catch (SecurityException e2) {
            try {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.f.a.b.o.1
                    @Override // java.security.PrivilegedExceptionAction
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Unsafe run() {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }
    }
}
