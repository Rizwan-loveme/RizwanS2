package org.p226d.p268c;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: LiteralTools.java */
/* renamed from: org.d.c.a */
/* loaded from: classes.dex */
public class C2446a {

    /* renamed from: a */
    private static Pattern f12891a = Pattern.compile("((-)?infinityf)|(nanf)", 2);

    /* renamed from: b */
    private static Pattern f12892b = Pattern.compile("((-)?infinityd?)|(nand?)", 2);

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte m15479a(String str) {
        char[] charArray;
        boolean z;
        int i;
        byte b2;
        byte b3 = 0;
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        if (str.toUpperCase().endsWith("T")) {
            charArray = str.substring(0, str.length() - 1).toCharArray();
        } else {
            charArray = str.toCharArray();
        }
        if (charArray[0] == '-') {
            z = true;
            i = 1;
        } else {
            z = false;
            i = 0;
        }
        if (charArray[i] == '0') {
            i++;
            if (i == charArray.length) {
                return (byte) 0;
            }
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                b2 = 16;
                i++;
            } else if (Character.digit(charArray[i], 8) >= 0) {
                b2 = 8;
            }
            byte b4 = (byte) (127 / (b2 / 2));
            while (i < charArray.length) {
                int digit = Character.digit(charArray[i], (int) b2);
                if (digit < 0) {
                    throw new NumberFormatException("The string contains invalid an digit - '" + charArray[i] + "'");
                }
                byte b5 = (byte) (b3 * b2);
                if (b3 > b4) {
                    throw new NumberFormatException(str + " cannot fit into a byte");
                }
                if (b5 < 0 && b5 >= (-digit)) {
                    throw new NumberFormatException(str + " cannot fit into a byte");
                }
                b3 = (byte) (b5 + digit);
                i++;
            }
            if (!z && b3 != Byte.MIN_VALUE) {
                if (b3 < 0) {
                    throw new NumberFormatException(str + " cannot fit into a byte");
                }
                return (byte) (b3 * (-1));
            }
        }
        b2 = 10;
        byte b42 = (byte) (127 / (b2 / 2));
        while (i < charArray.length) {
        }
        return !z ? b3 : b3;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static short m15480b(String str) {
        char[] charArray;
        boolean z;
        int i;
        short s;
        short s2 = 0;
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        if (str.toUpperCase().endsWith("S")) {
            charArray = str.substring(0, str.length() - 1).toCharArray();
        } else {
            charArray = str.toCharArray();
        }
        if (charArray[0] == '-') {
            z = true;
            i = 1;
        } else {
            z = false;
            i = 0;
        }
        if (charArray[i] == '0') {
            i++;
            if (i == charArray.length) {
                return (short) 0;
            }
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                s = 16;
                i++;
            } else if (Character.digit(charArray[i], 8) >= 0) {
                s = 8;
            }
            short s3 = (short) (32767 / (s / 2));
            while (i < charArray.length) {
                int digit = Character.digit(charArray[i], (int) s);
                if (digit < 0) {
                    throw new NumberFormatException("The string contains invalid an digit - '" + charArray[i] + "'");
                }
                short s4 = (short) (s2 * s);
                if (s2 > s3) {
                    throw new NumberFormatException(str + " cannot fit into a short");
                }
                if (s4 < 0 && s4 >= (-digit)) {
                    throw new NumberFormatException(str + " cannot fit into a short");
                }
                s2 = (short) (s4 + digit);
                i++;
            }
            if (!z && s2 != Short.MIN_VALUE) {
                if (s2 < 0) {
                    throw new NumberFormatException(str + " cannot fit into a short");
                }
                return (short) (s2 * (-1));
            }
        }
        s = 10;
        short s32 = (short) (32767 / (s / 2));
        while (i < charArray.length) {
        }
        return !z ? s2 : s2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m15481c(String str) {
        boolean z;
        int i;
        int i2;
        int i3 = 0;
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        char[] charArray = str.toCharArray();
        if (charArray[0] == '-') {
            z = true;
            i = 1;
        } else {
            z = false;
            i = 0;
        }
        if (charArray[i] == '0') {
            i++;
            if (i == charArray.length) {
                return 0;
            }
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                i2 = 16;
                i++;
            } else if (Character.digit(charArray[i], 8) >= 0) {
                i2 = 8;
            }
            int i4 = Integer.MAX_VALUE / (i2 / 2);
            while (i < charArray.length) {
                int digit = Character.digit(charArray[i], i2);
                if (digit < 0) {
                    throw new NumberFormatException("The string contains an invalid digit - '" + charArray[i] + "'");
                }
                int i5 = i3 * i2;
                if (i3 > i4) {
                    throw new NumberFormatException(str + " cannot fit into an int");
                }
                if (i5 < 0 && i5 >= (-digit)) {
                    throw new NumberFormatException(str + " cannot fit into an int");
                }
                i3 = i5 + digit;
                i++;
            }
            if (!z && i3 != Integer.MIN_VALUE) {
                if (i3 < 0) {
                    throw new NumberFormatException(str + " cannot fit into an int");
                }
                return i3 * (-1);
            }
        }
        i2 = 10;
        int i42 = Integer.MAX_VALUE / (i2 / 2);
        while (i < charArray.length) {
        }
        return !z ? i3 : i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long m15482d(String str) {
        char[] charArray;
        boolean z;
        int i;
        int i2;
        long j;
        int i3;
        if (str == null) {
            throw new NumberFormatException("string is null");
        }
        if (str.length() == 0) {
            throw new NumberFormatException("string is blank");
        }
        if (str.toUpperCase().endsWith("L")) {
            charArray = str.substring(0, str.length() - 1).toCharArray();
        } else {
            charArray = str.toCharArray();
        }
        if (charArray[0] == '-') {
            z = true;
            i = 1;
        } else {
            z = false;
            i = 0;
        }
        if (charArray[i] == '0') {
            i++;
            if (i == charArray.length) {
                return 0L;
            }
            if (charArray[i] == 'x' || charArray[i] == 'X') {
                i2 = 16;
                i++;
            } else if (Character.digit(charArray[i], 8) >= 0) {
                i2 = 8;
            }
            long j2 = Long.MAX_VALUE / (i2 / 2);
            j = 0;
            i3 = i;
            while (i3 < charArray.length) {
                int digit = Character.digit(charArray[i3], i2);
                if (digit < 0) {
                    throw new NumberFormatException("The string contains an invalid digit - '" + charArray[i3] + "'");
                }
                long j3 = i2 * j;
                if (j > j2) {
                    throw new NumberFormatException(str + " cannot fit into a long");
                }
                if (j3 < 0 && j3 >= (-digit)) {
                    throw new NumberFormatException(str + " cannot fit into a long");
                }
                i3++;
                j = digit + j3;
            }
            if (!z && j != Long.MIN_VALUE) {
                if (j < 0) {
                    throw new NumberFormatException(str + " cannot fit into a long");
                }
                return j * (-1);
            }
        }
        i2 = 10;
        long j22 = Long.MAX_VALUE / (i2 / 2);
        j = 0;
        i3 = i;
        while (i3 < charArray.length) {
        }
        return !z ? j : j;
    }

    /* renamed from: e */
    public static float m15483e(String str) {
        Matcher matcher = f12891a.matcher(str);
        if (matcher.matches()) {
            if (matcher.start(1) != -1) {
                if (matcher.start(2) != -1) {
                    return Float.NEGATIVE_INFINITY;
                }
                return Float.POSITIVE_INFINITY;
            }
            return Float.NaN;
        }
        return Float.parseFloat(str);
    }

    /* renamed from: f */
    public static double m15484f(String str) {
        Matcher matcher = f12892b.matcher(str);
        if (matcher.matches()) {
            if (matcher.start(1) != -1) {
                if (matcher.start(2) != -1) {
                    return Double.NEGATIVE_INFINITY;
                }
                return Double.POSITIVE_INFINITY;
            }
            return Double.NaN;
        }
        return Double.parseDouble(str);
    }
}
