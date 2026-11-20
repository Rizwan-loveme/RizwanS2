package org.p226d.p233b.p263h;

import org.p226d.p233b.C2393i;
import org.p226d.p233b.EnumC2076d;
import org.p226d.p233b.EnumC2272f;

/* compiled from: Preconditions.java */
/* renamed from: org.d.b.h.h */
/* loaded from: classes.dex */
public class C2388h {
    /* renamed from: a */
    public static void m15100a(EnumC2272f enumC2272f, EnumC2076d enumC2076d) {
        if (enumC2272f.f12386ei != enumC2076d) {
            throw new IllegalArgumentException(String.format("Invalid opcode %s for %s", enumC2272f.f12384eg, enumC2076d.name()));
        }
    }

    /* renamed from: a */
    public static int m15097a(int i) {
        if ((i & (-16)) != 0) {
            throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v15, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: b */
    public static int m15101b(int i) {
        if ((i & (-256)) != 0) {
            throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v255, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: c */
    public static int m15102c(int i) {
        if (((-65536) & i) != 0) {
            throw new IllegalArgumentException(String.format("Invalid register: v%d. Must be between v0 and v65535, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: d */
    public static int m15103d(int i) {
        if (i < -8 || i > 7) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -8 and 7, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: e */
    public static int m15104e(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -128 and 127, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: f */
    public static int m15105f(int i) {
        if (i < -32768 || i > 32767) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Must be between -32768 and 32767, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: g */
    public static int m15106g(int i) {
        if ((65535 & i) != 0) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Low 16 bits must be zeroed out.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: a */
    public static long m15098a(long j) {
        if ((281474976710655L & j) != 0) {
            throw new IllegalArgumentException(String.format("Invalid literal value: %d. Low 48 bits must be zeroed out.", Long.valueOf(j)));
        }
        return j;
    }

    /* renamed from: h */
    public static int m15107h(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException(String.format("Invalid code offset: %d. Must be between -128 and 127, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: i */
    public static int m15108i(int i) {
        if (i < -32768 || i > 32767) {
            throw new IllegalArgumentException(String.format("Invalid code offset: %d. Must be between -32768 and 32767, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: j */
    public static int m15109j(int i) {
        if (i < 0 || i > 5) {
            throw new IllegalArgumentException(String.format("Invalid register count: %d. Must be between 0 and 5, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: k */
    public static int m15110k(int i) {
        if ((i & (-256)) != 0) {
            throw new IllegalArgumentException(String.format("Invalid register count: %d. Must be between 0 and 255, inclusive.", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: a */
    public static void m15099a(int i, int i2) {
        if (i > i2) {
            if (i2 == 0) {
                throw new IllegalArgumentException(String.format("Invalid value_arg value %d for an encoded_value. Expecting 0", Integer.valueOf(i)));
            }
            throw new IllegalArgumentException(String.format("Invalid value_arg value %d for an encoded_value. Expecting 0..%d, inclusive", Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    /* renamed from: l */
    public static int m15111l(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(String.format("Invalid field offset: 0x%x. Must be between 0x0000 and 0xFFFF inclusive", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: m */
    public static int m15112m(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(String.format("Invalid vtable index: %d. Must be between 0 and 65535, inclusive", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: n */
    public static int m15113n(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException(String.format("Invalid inline index: %d. Must be between 0 and 65535, inclusive", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: o */
    public static int m15114o(int i) {
        if (!C2393i.m15153b(i)) {
            throw new IllegalArgumentException(String.format("Invalid verification error value: %d. Must be between 1 and 9, inclusive", Integer.valueOf(i)));
        }
        return i;
    }
}
