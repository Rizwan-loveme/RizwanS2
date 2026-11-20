package org.p226d.p269d;

import android.icu.text.DateFormat;
import java.text.DecimalFormat;

/* compiled from: NumberUtils.java */
/* renamed from: org.d.d.m */
/* loaded from: classes.dex */
public class C2459m {

    /* renamed from: a */
    private static final int f12930a = Float.floatToRawIntBits(Float.NaN);

    /* renamed from: b */
    private static final int f12931b = Float.floatToRawIntBits(Float.MAX_VALUE);

    /* renamed from: c */
    private static final int f12932c = Float.floatToRawIntBits(3.1415927f);

    /* renamed from: d */
    private static final int f12933d = Float.floatToRawIntBits(2.7182817f);

    /* renamed from: e */
    private static final long f12934e = Double.doubleToRawLongBits(Double.NaN);

    /* renamed from: f */
    private static final long f12935f = Double.doubleToLongBits(Double.MAX_VALUE);

    /* renamed from: g */
    private static final long f12936g = Double.doubleToLongBits(3.141592653589793d);

    /* renamed from: h */
    private static final long f12937h = Double.doubleToLongBits(2.718281828459045d);

    /* renamed from: i */
    private static final DecimalFormat f12938i = new DecimalFormat("0.####################E0");

    /* renamed from: a */
    public static boolean m15541a(int i) {
        if (i == f12930a || i == f12931b || i == f12932c || i == f12933d) {
            return true;
        }
        if (i == Integer.MAX_VALUE || i == Integer.MIN_VALUE) {
            return false;
        }
        int i2 = i >> 24;
        int i3 = (i >> 16) & 255;
        int i4 = 65535 & i;
        if ((i2 == 127 || i2 == 1) && i3 < 31 && i4 < 4095) {
            return false;
        }
        float intBitsToFloat = Float.intBitsToFloat(i);
        if (Float.isNaN(intBitsToFloat)) {
            return false;
        }
        String format = f12938i.format(i);
        String format2 = f12938i.format(intBitsToFloat);
        int indexOf = format2.indexOf(46);
        int indexOf2 = format2.indexOf(DateFormat.ABBR_WEEKDAY);
        int indexOf3 = format2.indexOf("000");
        if (indexOf3 > indexOf && indexOf3 < indexOf2) {
            format2 = format2.substring(0, indexOf3) + format2.substring(indexOf2);
        } else {
            int indexOf4 = format2.indexOf("999");
            if (indexOf4 > indexOf && indexOf4 < indexOf2) {
                format2 = format2.substring(0, indexOf4) + format2.substring(indexOf2);
            }
        }
        return format2.length() < format.length();
    }

    /* renamed from: a */
    public static boolean m15542a(long j) {
        if (j == f12934e || j == f12935f || j == f12936g || j == f12937h) {
            return true;
        }
        if (j == Long.MAX_VALUE || j == Long.MIN_VALUE) {
            return false;
        }
        double longBitsToDouble = Double.longBitsToDouble(j);
        if (Double.isNaN(longBitsToDouble)) {
            return false;
        }
        String format = f12938i.format(j);
        String format2 = f12938i.format(longBitsToDouble);
        int indexOf = format2.indexOf(46);
        int indexOf2 = format2.indexOf(DateFormat.ABBR_WEEKDAY);
        int indexOf3 = format2.indexOf("000");
        if (indexOf3 > indexOf && indexOf3 < indexOf2) {
            format2 = format2.substring(0, indexOf3) + format2.substring(indexOf2);
        } else {
            int indexOf4 = format2.indexOf("999");
            if (indexOf4 > indexOf && indexOf4 < indexOf2) {
                format2 = format2.substring(0, indexOf4) + format2.substring(indexOf2);
            }
        }
        return format2.length() < format.length();
    }
}
