package ru.maximoff.apktool.util;

import java.text.StringCharacterIterator;

/* compiled from: SizeFormat.java */
/* renamed from: ru.maximoff.apktool.util.bh */
/* loaded from: classes.dex */
public class C3106bh {
    /* renamed from: a */
    public static String m18975a(long j, boolean z) {
        String m18976b;
        try {
            if (z) {
                m18976b = m18974a(j);
            } else {
                m18976b = m18976b(j);
            }
            return m18976b;
        } catch (Exception e2) {
            return m18977b(j, z);
        }
    }

    /* renamed from: a */
    public static String m18974a(long j) {
        if (-1000 < j && j < 1000) {
            return new StringBuffer().append(j).append(" B").toString();
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("kMGTPE");
        while (true) {
            if (j <= -999950 || j >= 999950) {
                j /= 1000;
                stringCharacterIterator.next();
            } else {
                return String.format("%.2f %cB", new Double(j / 1000.0d), new Character(stringCharacterIterator.current()));
            }
        }
    }

    /* renamed from: b */
    public static String m18976b(long j) {
        long abs = j == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(j);
        if (abs < 1024) {
            return new StringBuffer().append(j).append(" B").toString();
        }
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("KMGTPE");
        long j2 = abs;
        for (int i = 40; i >= 0 && abs > (1152865209611504844 >> i); i -= 10) {
            j2 >>= 10;
            stringCharacterIterator.next();
        }
        return String.format("%.2f %ciB", new Double((j2 * Long.signum(j)) / 1024.0d), new Character(stringCharacterIterator.current()));
    }

    /* renamed from: b */
    public static String m18977b(long j, boolean z) {
        long j2;
        String str;
        if (z) {
            j2 = 1000;
            str = "";
        } else {
            j2 = 1024;
            str = "i";
        }
        long j3 = j2 * j2;
        long j4 = j3 * j2;
        long j5 = j4 * j2;
        if (j >= 0 && j < j2) {
            return new StringBuffer().append(j).append(" B").toString();
        }
        if (j >= j2 && j < j3) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(j / j2).append(" K").toString()).append(str).toString()).append("B").toString();
        }
        if (j >= j3 && j < j4) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(j / j3).append(" M").toString()).append(str).toString()).append("B").toString();
        }
        if (j >= j4 && j < j5) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(j / j4).append(" G").toString()).append(str).toString()).append("B").toString();
        }
        if (j >= j5) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(j / j5).append(" T").toString()).append(str).toString()).append("B").toString();
        }
        return new StringBuffer().append(j).append(" B").toString();
    }
}
