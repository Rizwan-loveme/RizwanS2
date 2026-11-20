package org.p217b.p218a.p219a;

import java.io.File;

/* compiled from: FilenameUtils.java */
/* renamed from: org.b.a.a.c */
/* loaded from: classes.dex */
public class C1885c {

    /* renamed from: a */
    public static final String f11042a = Character.toString('.');

    /* renamed from: b */
    private static final char f11043b = File.separatorChar;

    /* renamed from: c */
    private static final char f11044c;

    static {
        if (m13952a()) {
            f11044c = '/';
        } else {
            f11044c = '\\';
        }
    }

    /* renamed from: a */
    static boolean m13952a() {
        return f11043b == '\\';
    }

    /* renamed from: a */
    private static boolean m13953a(char c2) {
        return c2 == '/' || c2 == '\\';
    }

    /* renamed from: a */
    public static int m13950a(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            return !m13953a(charAt) ? 0 : 1;
        }
        if (charAt == '~') {
            int indexOf = str.indexOf(47, 1);
            int indexOf2 = str.indexOf(92, 1);
            if (indexOf == -1 && indexOf2 == -1) {
                return length + 1;
            }
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            return Math.min(indexOf, indexOf2) + 1;
        }
        char charAt2 = str.charAt(1);
        if (charAt2 == ':') {
            char upperCase = Character.toUpperCase(charAt);
            if (upperCase < 'A' || upperCase > 'Z') {
                return -1;
            }
            return (length == 2 || !m13953a(str.charAt(2))) ? 2 : 3;
        }
        if (!m13953a(charAt) || !m13953a(charAt2)) {
            return !m13953a(charAt) ? 0 : 1;
        }
        int indexOf3 = str.indexOf(47, 2);
        int indexOf4 = str.indexOf(92, 2);
        if ((indexOf3 == -1 && indexOf4 == -1) || indexOf3 == 2 || indexOf4 == 2) {
            return -1;
        }
        if (indexOf3 == -1) {
            indexOf3 = indexOf4;
        }
        if (indexOf4 == -1) {
            indexOf4 = indexOf3;
        }
        return Math.min(indexOf3, indexOf4) + 1;
    }

    /* renamed from: b */
    public static int m13954b(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    /* renamed from: c */
    public static int m13955c(String str) {
        int lastIndexOf;
        if (str != null && m13954b(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    /* renamed from: d */
    public static String m13956d(String str) {
        int m13950a;
        if (str == null || (m13950a = m13950a(str)) < 0) {
            return null;
        }
        if (m13950a > str.length()) {
            return str + '/';
        }
        return str.substring(0, m13950a);
    }

    /* renamed from: e */
    public static String m13957e(String str) {
        return m13951a(str, false);
    }

    /* renamed from: a */
    private static String m13951a(String str, boolean z) {
        int m13950a;
        if (str != null && (m13950a = m13950a(str)) >= 0) {
            if (m13950a >= str.length()) {
                if (z) {
                    return m13956d(str);
                }
                return str;
            }
            int m13954b = m13954b(str);
            if (m13954b < 0) {
                return str.substring(0, m13950a);
            }
            int i = (z ? 1 : 0) + m13954b;
            if (i == 0) {
                i++;
            }
            return str.substring(0, i);
        }
        return null;
    }

    /* renamed from: f */
    public static String m13958f(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(m13954b(str) + 1);
    }

    /* renamed from: g */
    public static String m13959g(String str) {
        return m13960h(m13958f(str));
    }

    /* renamed from: h */
    public static String m13960h(String str) {
        if (str == null) {
            return null;
        }
        int m13955c = m13955c(str);
        return m13955c != -1 ? str.substring(0, m13955c) : str;
    }
}
