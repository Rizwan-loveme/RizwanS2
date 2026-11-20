package com.p140g.p152b.p153a;

import android.icu.text.DateFormat;

/* compiled from: TypeClass.java */
/* renamed from: com.g.b.a.h */
/* loaded from: classes.dex */
public enum EnumC1367h {
    BOOLEAN("Z", true),
    INT("I", true),
    FLOAT("F", true),
    DOUBLE("D", true),
    LONG("J", true),
    OBJECT("L", true),
    VOID("V", true),
    UNKNOWN("?"),
    ZIL(DateFormat.SECOND),
    ZIFL(DateFormat.ABBR_SPECIFIC_TZ),
    ZIF(DateFormat.MINUTE),
    ZI("n"),
    IF("i"),
    JD("w");


    /* renamed from: o */
    public String f8821o;

    /* renamed from: p */
    public boolean f8822p;

    public static EnumC1367h valueOf(String str) {
        for (EnumC1367h enumC1367h : values()) {
            if (enumC1367h.name().equals(str)) {
                return enumC1367h;
            }
        }
        throw new IllegalArgumentException();
    }

    EnumC1367h(String str, boolean z) {
        this.f8821o = str;
        this.f8822p = z;
    }

    EnumC1367h(String str) {
        this.f8821o = str;
        this.f8822p = false;
    }

    /* renamed from: a */
    public static EnumC1367h m10768a(String str) {
        switch (str.charAt(0)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
                return INT;
            case 'D':
                return DOUBLE;
            case 'F':
                return FLOAT;
            case 'J':
                return LONG;
            case 'L':
            case '[':
                return OBJECT;
            case 'V':
                return VOID;
            case 'Z':
                return BOOLEAN;
            case 'i':
                return IF;
            case 'm':
                return ZIF;
            case 'n':
                return ZI;
            case 's':
                return ZIL;
            case 'w':
                return JD;
            case 'z':
                return ZIFL;
            default:
                return UNKNOWN;
        }
    }

    /* renamed from: a */
    public static EnumC1367h m10767a(EnumC1367h enumC1367h, EnumC1367h enumC1367h2) {
        if (enumC1367h != enumC1367h2) {
            if (enumC1367h == UNKNOWN) {
                return enumC1367h2;
            }
            if (enumC1367h2 != UNKNOWN) {
                if (!enumC1367h.f8822p) {
                    return enumC1367h2.f8822p ? enumC1367h2 : m10769b(enumC1367h, enumC1367h2);
                }
                if (enumC1367h2.f8822p) {
                    if ((enumC1367h == INT && enumC1367h2 == BOOLEAN) || enumC1367h == BOOLEAN || enumC1367h2 == INT) {
                        return INT;
                    }
                    throw new RuntimeException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("can not merge ").append(enumC1367h).toString()).append(" and ").toString()).append(enumC1367h2).toString());
                }
                return enumC1367h;
            }
            return enumC1367h;
        }
        return enumC1367h;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static EnumC1367h m10769b(EnumC1367h enumC1367h, EnumC1367h enumC1367h2) {
        if (enumC1367h == JD || enumC1367h2 == JD) {
            throw new RuntimeException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("can not merge ").append(enumC1367h).toString()).append(" and ").toString()).append(enumC1367h2).toString());
        }
        if (enumC1367h == ZIL) {
            if (enumC1367h2 == ZIFL) {
                return ZIL;
            }
            if (enumC1367h2 == IF) {
                return INT;
            }
            if (enumC1367h2 == ZIF || enumC1367h2 == ZI) {
                return ZI;
            }
            return enumC1367h2;
        }
        if (enumC1367h != ZIFL) {
            if (enumC1367h == IF) {
                if (enumC1367h2 != ZIL && enumC1367h2 != ZI) {
                    if (enumC1367h2 == ZIFL || enumC1367h2 == ZIF) {
                        return IF;
                    }
                } else {
                    return INT;
                }
            } else if (enumC1367h != ZIF) {
                if (enumC1367h != ZI) {
                    throw new RuntimeException();
                }
                if (enumC1367h2 != IF) {
                    return INT;
                }
                return ZI;
            }
            if (enumC1367h2 == IF) {
                return IF;
            }
            if (enumC1367h2 != ZIL && enumC1367h2 != ZI) {
                if (enumC1367h2 == ZIFL) {
                    return ZIF;
                }
                if (enumC1367h2 != IF) {
                }
            } else {
                return ZI;
            }
        } else {
            return enumC1367h2;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f8821o;
    }
}
