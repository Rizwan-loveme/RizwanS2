package ru.maximoff.apktool.p296a;

import com.p159h.p160a.p162b.C1388j;

/* compiled from: SmaliFormatter.java */
/* renamed from: ru.maximoff.apktool.a.k */
/* loaded from: classes.dex */
public class C2891k {
    /* renamed from: a */
    public static void m16927a(C1388j c1388j, String str, boolean z) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 == '\\') {
                i += m16924a(c1388j, charArray, i + 1, z);
            } else {
                c1388j.m11076b(c2);
            }
            i++;
        }
    }

    /* renamed from: a */
    private static int m16924a(C1388j c1388j, char[] cArr, int i, boolean z) {
        char c2 = cArr[i];
        if (c2 == 'u') {
            m16925a(c1388j, (char) Integer.parseInt(new String(cArr, i + 1, 4)), z);
            return 5;
        }
        c1388j.m11076b('\\');
        c1388j.m11076b(c2);
        return 1;
    }

    /* renamed from: a */
    private static void m16925a(C1388j c1388j, char c2, boolean z) {
        switch (c2) {
            case '\b':
                c1388j.m11070a("\\b");
                break;
            case '\t':
                c1388j.m11070a("\\t");
                break;
            case '\n':
                c1388j.m11070a("\\n");
                break;
            case '\f':
                c1388j.m11070a("\\f");
                break;
            case '\r':
                c1388j.m11070a("\\r");
                break;
            case '\"':
                if (z) {
                    c1388j.m11070a("\\\"");
                    break;
                } else {
                    c1388j.m11076b('\"');
                    break;
                }
            case '\'':
                if (z) {
                    c1388j.m11076b('\'');
                    break;
                } else {
                    c1388j.m11070a("\\'");
                    break;
                }
            case '\\':
                c1388j.m11070a("\\\\");
                break;
            default:
                c1388j.m11076b(c2);
                break;
        }
    }

    /* renamed from: a */
    public static void m16926a(C1388j c1388j, String str) {
        if (str.contains("\n")) {
            for (char c2 : str.toCharArray()) {
                if (c2 == '\n') {
                    c1388j.m11076b(c2);
                }
            }
            return;
        }
        c1388j.m11070a(" ");
    }
}
