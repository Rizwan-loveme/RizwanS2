package jadx.core.p203d;

import jadx.p180a.C1534b;

/* compiled from: StringUtils.java */
/* renamed from: jadx.core.d.m */
/* loaded from: classes.dex */
public class C1744m {

    /* renamed from: a */
    private final boolean f10605a;

    public C1744m(C1534b c1534b) {
        this.f10605a = c1534b.m11781p();
    }

    /* renamed from: a */
    public String m13308a(String str) {
        int length = str.length();
        if (length == 0) {
            return "\"\"";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            m13304a(str.charAt(i) & 65535, sb);
        }
        return String.valueOf('\"') + sb.toString() + '\"';
    }

    /* renamed from: a */
    public String m13307a(char c2) {
        if (c2 == '\'') {
            return "'\\''";
        }
        StringBuilder sb = new StringBuilder();
        m13304a(c2, sb);
        return String.valueOf('\'') + sb.toString() + '\'';
    }

    /* renamed from: a */
    private void m13304a(int i, StringBuilder sb) {
        switch (i) {
            case 8:
                sb.append("\\b");
                break;
            case 9:
                sb.append("\\t");
                break;
            case 10:
                sb.append("\\n");
                break;
            case 12:
                sb.append("\\f");
                break;
            case 13:
                sb.append("\\r");
                break;
            case 34:
                sb.append("\\\"");
                break;
            case 39:
                sb.append('\'');
                break;
            case 92:
                sb.append("\\\\");
                break;
            default:
                if (i < 32 || (i >= 127 && this.f10605a)) {
                    sb.append("\\u").append(String.format("%04x", Integer.valueOf(i)));
                    break;
                } else {
                    sb.append((char) i);
                    break;
                }
                break;
        }
    }

    /* renamed from: b */
    public static String m13305b(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case ' ':
                case '$':
                case ',':
                case '.':
                case '/':
                case ';':
                case '<':
                    sb.append('_');
                    break;
                case '*':
                case '>':
                case '?':
                case ']':
                    break;
                case '[':
                    sb.append('A');
                    break;
                default:
                    sb.append(charAt);
                    break;
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static boolean m13306c(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public static int m13303a(String str, String str2) {
        int i = 0;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return 0;
        }
        int length = str2.length();
        int i2 = 0;
        while (true) {
            int i3 = i;
            int indexOf = str.indexOf(str2, i2);
            if (indexOf != -1) {
                i = i3 + 1;
                i2 = indexOf + length;
            } else {
                return i3;
            }
        }
    }
}
