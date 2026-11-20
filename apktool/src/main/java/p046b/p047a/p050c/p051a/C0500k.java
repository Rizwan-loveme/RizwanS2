package p046b.p047a.p050c.p051a;

/* compiled from: StringUtils.java */
/* renamed from: b.a.c.a.k */
/* loaded from: classes.dex */
public class C0500k {
    /* renamed from: a */
    public static String m3756a(String str, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length == strArr2.length) {
            for (int i = 0; i < strArr.length; i++) {
                str = m3754a(str, strArr[i], strArr2[i], -1);
            }
        }
        return str;
    }

    /* renamed from: a */
    public static String m3753a(String str, String str2, String str3) {
        return m3754a(str, str2, str3, -1);
    }

    /* renamed from: a */
    private static String m3754a(String str, String str2, String str3, int i) {
        return m3755a(str, str2, str3, i, false);
    }

    /* renamed from: a */
    private static String m3755a(String str, String str2, String str3, int i, boolean z) {
        String str4;
        int i2;
        int i3 = 64;
        if (!m3757a(str) && !m3757a(str2) && str3 != null && i != 0) {
            if (z) {
                str4 = str.toLowerCase();
                str2 = str2.toLowerCase();
            } else {
                str4 = str;
            }
            int indexOf = str4.indexOf(str2, 0);
            if (indexOf != -1) {
                int length = str2.length();
                int length2 = str3.length() - length;
                if (length2 < 0) {
                    length2 = 0;
                }
                if (i < 0) {
                    i3 = 16;
                } else if (i <= 64) {
                    i3 = i;
                }
                StringBuilder sb = new StringBuilder((i3 * length2) + str.length());
                int i4 = 0;
                while (true) {
                    if (indexOf == -1) {
                        i2 = i4;
                        break;
                    }
                    sb.append(str.substring(i4, indexOf)).append(str3);
                    i4 = indexOf + length;
                    i--;
                    if (i == 0) {
                        i2 = i4;
                        break;
                    }
                    indexOf = str4.indexOf(str2, i4);
                }
                sb.append(str.substring(i2));
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    /* renamed from: a */
    private static boolean m3757a(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
