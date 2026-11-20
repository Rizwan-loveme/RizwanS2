package com.p065b.p066a.p068b.p075b.p076a;

import com.p065b.p066a.p068b.p075b.EnumC0624h;
import com.p065b.p066a.p068b.p075b.EnumC0626j;

/* compiled from: BerEncoding.java */
/* renamed from: com.b.a.b.b.a.d */
/* loaded from: classes.dex */
public abstract class AbstractC0616d {
    public static final int ID_FLAG_CONSTRUCTED_ENCODING = 32;
    public static final int TAG_CLASS_APPLICATION = 1;
    public static final int TAG_CLASS_CONTEXT_SPECIFIC = 2;
    public static final int TAG_CLASS_PRIVATE = 3;
    public static final int TAG_CLASS_UNIVERSAL = 0;
    public static final int TAG_NUMBER_BIT_STRING = 3;
    public static final int TAG_NUMBER_BOOLEAN = 1;
    public static final int TAG_NUMBER_GENERALIZED_TIME = 24;
    public static final int TAG_NUMBER_INTEGER = 2;
    public static final int TAG_NUMBER_NULL = 5;
    public static final int TAG_NUMBER_OBJECT_IDENTIFIER = 6;
    public static final int TAG_NUMBER_OCTET_STRING = 4;
    public static final int TAG_NUMBER_SEQUENCE = 16;
    public static final int TAG_NUMBER_SET = 17;
    public static final int TAG_NUMBER_UTC_TIME = 23;

    /* renamed from: a */
    public static byte m6126a(byte b2, int i) {
        return (byte) ((b2 & 63) | (i << 6));
    }

    /* renamed from: a */
    public static int m6127a(byte b2) {
        return (b2 & 255) >> 6;
    }

    /* renamed from: b */
    public static byte m6132b(byte b2, int i) {
        return (byte) ((b2 & (-32)) | i);
    }

    /* renamed from: b */
    public static int m6133b(byte b2) {
        return b2 & 31;
    }

    /* renamed from: c */
    public static boolean m6135c(byte b2) {
        return (b2 & 32) != 0;
    }

    private AbstractC0616d() {
    }

    /* renamed from: a */
    public static int m6129a(EnumC0626j enumC0626j) {
        switch (AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1Type[enumC0626j.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 6;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 17;
            case 6:
            case 7:
                return 16;
            case 8:
                return 23;
            case 9:
                return 24;
            case 10:
                return 1;
            default:
                throw new IllegalArgumentException("Unsupported data type: " + enumC0626j);
        }
    }

    /* compiled from: BerEncoding.java */
    /* renamed from: com.b.a.b.b.a.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass;
        static final int[] $SwitchMap$com$android$apksig$internal$asn1$Asn1Type;

        static {
            int[] iArr = new int[EnumC0624h.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass = iArr;
            try {
                iArr[EnumC0624h.APPLICATION.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[EnumC0624h.CONTEXT_SPECIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[EnumC0624h.PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[EnumC0624h.UNIVERSAL.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[EnumC0626j.values().length];
            $SwitchMap$com$android$apksig$internal$asn1$Asn1Type = iArr2;
            try {
                iArr2[EnumC0626j.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.OBJECT_IDENTIFIER.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.OCTET_STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.BIT_STRING.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SET_OF.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SEQUENCE.ordinal()] = 6;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.SEQUENCE_OF.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.UTC_TIME.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.GENERALIZED_TIME.ordinal()] = 9;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$android$apksig$internal$asn1$Asn1Type[EnumC0626j.BOOLEAN.ordinal()] = 10;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    /* renamed from: a */
    public static int m6128a(EnumC0624h enumC0624h) {
        int i = AnonymousClass1.$SwitchMap$com$android$apksig$internal$asn1$Asn1TagClass[enumC0624h.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        if (i == 3) {
            return 3;
        }
        if (i == 4) {
            return 0;
        }
        throw new IllegalArgumentException("Unsupported tag class: " + enumC0624h);
    }

    /* renamed from: a */
    public static String m6130a(int i) {
        if (i == 0) {
            return "UNIVERSAL";
        }
        if (i == 1) {
            return "APPLICATION";
        }
        if (i == 2) {
            return "";
        }
        if (i == 3) {
            return "PRIVATE";
        }
        throw new IllegalArgumentException("Unsupported type class: " + i);
    }

    /* renamed from: a */
    public static String m6131a(int i, int i2) {
        String m6130a = m6130a(i);
        String m6134b = m6134b(i2);
        if (m6130a.isEmpty()) {
            return m6134b;
        }
        return m6130a + " " + m6134b;
    }

    /* renamed from: b */
    public static String m6134b(int i) {
        if (i == 16) {
            return "SEQUENCE";
        }
        if (i == 17) {
            return "SET";
        }
        if (i == 23) {
            return "UTC TIME";
        }
        if (i == 24) {
            return "GENERALIZED TIME";
        }
        switch (i) {
            case 1:
                return "BOOLEAN";
            case 2:
                return "INTEGER";
            case 3:
                return "BIT STRING";
            case 4:
                return "OCTET STRING";
            case 5:
                return "NULL";
            case 6:
                return "OBJECT IDENTIFIER";
            default:
                return "0x" + Integer.toHexString(i);
        }
    }
}
