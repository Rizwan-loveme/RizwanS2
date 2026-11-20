package com.p140g.p152b.p153a;

import android.app.slice.SliceItem;

/* compiled from: Util.java */
/* renamed from: com.g.b.a.i */
/* loaded from: classes.dex */
public class C1368i {
    /* renamed from: a */
    public static void m10771a(StringBuffer stringBuffer, String str) {
        stringBuffer.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                stringBuffer.append("\\n");
            } else if (charAt == '\r') {
                stringBuffer.append("\\r");
            } else if (charAt == '\\') {
                stringBuffer.append("\\\\");
            } else if (charAt == '\"') {
                stringBuffer.append("\\\"");
            } else if (charAt < ' ' || charAt > 127) {
                stringBuffer.append("\\u");
                if (charAt < 16) {
                    stringBuffer.append("000");
                } else if (charAt < 256) {
                    stringBuffer.append("00");
                } else if (charAt < 4096) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(Integer.toString(charAt, 16));
            } else {
                stringBuffer.append(charAt);
            }
        }
        stringBuffer.append('\"');
    }

    /* renamed from: a */
    public static String m10770a(String str) {
        switch (str.charAt(0)) {
            case 'B':
                return "byte";
            case 'C':
                return "char";
            case 'D':
                return "double";
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                throw new UnsupportedOperationException();
            case 'F':
                return "float";
            case 'I':
                return SliceItem.FORMAT_INT;
            case 'J':
                return SliceItem.FORMAT_LONG;
            case 'L':
                int lastIndexOf = str.lastIndexOf(47);
                return str.substring(lastIndexOf >= 0 ? lastIndexOf + 1 : 1, str.length() - 1);
            case 'S':
                return "short";
            case 'V':
                return "void";
            case 'Z':
                return "boolean";
            case '[':
                break;
        }
        while (r0 < str.length() && str.charAt(r0) == '[') {
            r0++;
        }
        StringBuilder append = new StringBuilder().append(m10770a(str.substring(r0)));
        for (int i = 0; i < r0; i++) {
            append.append("[]");
        }
        return append.toString();
    }
}
