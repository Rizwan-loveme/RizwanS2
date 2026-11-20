package com.p065b.p086b.p103f.p105b;

import com.p065b.p086b.p110h.C1022m;

/* compiled from: AccessFlags.java */
/* renamed from: com.b.b.f.b.a */
/* loaded from: classes.dex */
public final class C0919a {
    /* renamed from: a */
    public static String m7835a(int i) {
        return m7836a(i, 30257, 1);
    }

    /* renamed from: b */
    public static String m7837b(int i) {
        return m7836a(i, 30239, 1);
    }

    /* renamed from: c */
    public static String m7838c(int i) {
        return m7836a(i, 20703, 2);
    }

    /* renamed from: d */
    public static String m7839d(int i) {
        return m7836a(i, 204287, 3);
    }

    /* renamed from: e */
    public static boolean m7840e(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: f */
    public static boolean m7841f(int i) {
        return (i & 8) != 0;
    }

    /* renamed from: g */
    public static boolean m7842g(int i) {
        return (i & 32) != 0;
    }

    /* renamed from: h */
    public static boolean m7843h(int i) {
        return (i & 1024) != 0;
    }

    /* renamed from: i */
    public static boolean m7844i(int i) {
        return (i & 256) != 0;
    }

    /* renamed from: j */
    public static boolean m7845j(int i) {
        return (i & 8192) != 0;
    }

    /* renamed from: a */
    private static String m7836a(int i, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(80);
        int i4 = (i2 ^ (-1)) & i;
        int i5 = i & i2;
        if ((i5 & 1) != 0) {
            stringBuffer.append("|public");
        }
        if ((i5 & 2) != 0) {
            stringBuffer.append("|private");
        }
        if ((i5 & 4) != 0) {
            stringBuffer.append("|protected");
        }
        if ((i5 & 8) != 0) {
            stringBuffer.append("|static");
        }
        if ((i5 & 16) != 0) {
            stringBuffer.append("|final");
        }
        if ((i5 & 32) != 0) {
            if (i3 == 1) {
                stringBuffer.append("|super");
            } else {
                stringBuffer.append("|synchronized");
            }
        }
        if ((i5 & 64) != 0) {
            if (i3 == 3) {
                stringBuffer.append("|bridge");
            } else {
                stringBuffer.append("|volatile");
            }
        }
        if ((i5 & 128) != 0) {
            if (i3 == 3) {
                stringBuffer.append("|varargs");
            } else {
                stringBuffer.append("|transient");
            }
        }
        if ((i5 & 256) != 0) {
            stringBuffer.append("|native");
        }
        if ((i5 & 512) != 0) {
            stringBuffer.append("|interface");
        }
        if ((i5 & 1024) != 0) {
            stringBuffer.append("|abstract");
        }
        if ((i5 & 2048) != 0) {
            stringBuffer.append("|strictfp");
        }
        if ((i5 & 4096) != 0) {
            stringBuffer.append("|synthetic");
        }
        if ((i5 & 8192) != 0) {
            stringBuffer.append("|annotation");
        }
        if ((i5 & 16384) != 0) {
            stringBuffer.append("|enum");
        }
        if ((65536 & i5) != 0) {
            stringBuffer.append("|constructor");
        }
        if ((i5 & 131072) != 0) {
            stringBuffer.append("|declared_synchronized");
        }
        if (i4 != 0 || stringBuffer.length() == 0) {
            stringBuffer.append('|');
            stringBuffer.append(C1022m.m8557c(i4));
        }
        return stringBuffer.substring(1);
    }
}
