package org.p226d.p233b;

import java.util.HashMap;

/* compiled from: AccessFlags.java */
/* renamed from: org.d.b.a */
/* loaded from: classes.dex */
public enum EnumC1959a {
    PUBLIC(1, "public", true, true, true),
    PRIVATE(2, "private", true, true, true),
    PROTECTED(4, "protected", true, true, true),
    STATIC(8, "static", true, true, true),
    FINAL(16, "final", true, true, true),
    SYNCHRONIZED(32, "synchronized", false, true, false),
    VOLATILE(64, "volatile", false, false, true),
    BRIDGE(64, "bridge", false, true, false),
    TRANSIENT(128, "transient", false, false, true),
    VARARGS(128, "varargs", false, true, false),
    NATIVE(256, "native", false, true, false),
    INTERFACE(512, "interface", true, false, false),
    ABSTRACT(1024, "abstract", true, true, false),
    STRICTFP(2048, "strictfp", false, true, false),
    SYNTHETIC(4096, "synthetic", true, true, true),
    ANNOTATION(8192, "annotation", true, false, false),
    ENUM(16384, "enum", true, false, true),
    CONSTRUCTOR(65536, "constructor", false, true, false),
    DECLARED_SYNCHRONIZED(131072, "declared-synchronized", false, true, false);


    /* renamed from: y */
    private static final EnumC1959a[] f11391y = values();

    /* renamed from: z */
    private static HashMap<String, EnumC1959a> f11392z = new HashMap<>();

    /* renamed from: t */
    private int f11393t;

    /* renamed from: u */
    private String f11394u;

    /* renamed from: v */
    private boolean f11395v;

    /* renamed from: w */
    private boolean f11396w;

    /* renamed from: x */
    private boolean f11397x;

    static {
        for (EnumC1959a enumC1959a : f11391y) {
            f11392z.put(enumC1959a.f11394u, enumC1959a);
        }
    }

    EnumC1959a(int i, String str, boolean z, boolean z2, boolean z3) {
        this.f11393t = i;
        this.f11394u = str;
        this.f11395v = z;
        this.f11396w = z2;
        this.f11397x = z3;
    }

    /* renamed from: a */
    public boolean m14192a(int i) {
        return (this.f11393t & i) != 0;
    }

    /* renamed from: b */
    public static EnumC1959a[] m14185b(int i) {
        int i2;
        int i3 = 0;
        for (EnumC1959a enumC1959a : f11391y) {
            if (enumC1959a.f11395v && (enumC1959a.f11393t & i) != 0) {
                i3++;
            }
        }
        EnumC1959a[] enumC1959aArr = new EnumC1959a[i3];
        EnumC1959a[] enumC1959aArr2 = f11391y;
        int length = enumC1959aArr2.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            EnumC1959a enumC1959a2 = enumC1959aArr2[i4];
            if (!enumC1959a2.f11395v || (enumC1959a2.f11393t & i) == 0) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                enumC1959aArr[i5] = enumC1959a2;
            }
            i4++;
            i5 = i2;
        }
        return enumC1959aArr;
    }

    /* renamed from: a */
    private static String m14183a(EnumC1959a[] enumC1959aArr) {
        int i = 0;
        for (EnumC1959a enumC1959a : enumC1959aArr) {
            i += enumC1959a.toString().length() + 1;
        }
        StringBuilder sb = new StringBuilder(i);
        for (EnumC1959a enumC1959a2 : enumC1959aArr) {
            sb.append(enumC1959a2.toString());
            sb.append(" ");
        }
        if (enumC1959aArr.length > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static String m14186c(int i) {
        return m14183a(m14185b(i));
    }

    /* renamed from: d */
    public static EnumC1959a[] m14187d(int i) {
        int i2;
        int i3 = 0;
        for (EnumC1959a enumC1959a : f11391y) {
            if (enumC1959a.f11396w && (enumC1959a.f11393t & i) != 0) {
                i3++;
            }
        }
        EnumC1959a[] enumC1959aArr = new EnumC1959a[i3];
        EnumC1959a[] enumC1959aArr2 = f11391y;
        int length = enumC1959aArr2.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            EnumC1959a enumC1959a2 = enumC1959aArr2[i4];
            if (!enumC1959a2.f11396w || (enumC1959a2.f11393t & i) == 0) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                enumC1959aArr[i5] = enumC1959a2;
            }
            i4++;
            i5 = i2;
        }
        return enumC1959aArr;
    }

    /* renamed from: e */
    public static String m14188e(int i) {
        return m14183a(m14187d(i));
    }

    /* renamed from: f */
    public static EnumC1959a[] m14189f(int i) {
        int i2;
        int i3 = 0;
        for (EnumC1959a enumC1959a : f11391y) {
            if (enumC1959a.f11397x && (enumC1959a.f11393t & i) != 0) {
                i3++;
            }
        }
        EnumC1959a[] enumC1959aArr = new EnumC1959a[i3];
        EnumC1959a[] enumC1959aArr2 = f11391y;
        int length = enumC1959aArr2.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            EnumC1959a enumC1959a2 = enumC1959aArr2[i4];
            if (!enumC1959a2.f11397x || (enumC1959a2.f11393t & i) == 0) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                enumC1959aArr[i5] = enumC1959a2;
            }
            i4++;
            i5 = i2;
        }
        return enumC1959aArr;
    }

    /* renamed from: g */
    public static String m14190g(int i) {
        return m14183a(m14189f(i));
    }

    /* renamed from: a */
    public static EnumC1959a m14184a(String str) {
        return f11392z.get(str);
    }

    /* renamed from: a */
    public int m14191a() {
        return this.f11393t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f11394u;
    }
}
