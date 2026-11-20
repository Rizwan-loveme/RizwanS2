package org.p226d.p233b;

/* compiled from: VersionMap.java */
/* renamed from: org.d.b.j */
/* loaded from: classes.dex */
public class C2445j {
    /* renamed from: a */
    public static int m15475a(int i) {
        switch (i) {
            case 35:
                return 23;
            case 36:
            default:
                return -1;
            case 37:
                return 25;
            case 38:
                return 27;
            case 39:
                return 28;
        }
    }

    /* renamed from: b */
    public static int m15476b(int i) {
        if (i <= 23) {
            return 35;
        }
        if (i <= 25) {
            return 37;
        }
        if (i <= 27) {
            return 38;
        }
        return 39;
    }

    /* renamed from: c */
    public static int m15477c(int i) {
        if (i >= 144) {
            return 28;
        }
        if (i >= 131) {
            return 27;
        }
        if (i >= 124) {
            return 26;
        }
        if (i >= 79) {
            return 24;
        }
        if (i >= 64) {
            return 23;
        }
        if (i >= 45) {
            return 22;
        }
        if (i >= 39) {
            return 21;
        }
        return 19;
    }

    /* renamed from: d */
    public static int m15478d(int i) {
        if (i < 19) {
            return -1;
        }
        switch (i) {
            case 19:
            case 20:
                return 7;
            case 21:
                return 39;
            case 22:
                return 45;
            case 23:
                return 64;
            case 24:
            case 25:
                return 79;
            case 26:
                return 124;
            case 27:
                return 131;
            default:
                return 144;
        }
    }
}
