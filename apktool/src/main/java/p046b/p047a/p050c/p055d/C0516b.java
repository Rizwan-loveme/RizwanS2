package p046b.p047a.p050c.p055d;

import android.icu.text.SymbolTable;
import java.lang.Character;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p046b.p047a.p050c.p051a.C0500k;
import p046b.p059d.C0538c;

/* compiled from: ResXmlEncoders.java */
/* renamed from: b.a.c.d.b */
/* loaded from: classes.dex */
public final class C0516b {
    /* renamed from: a */
    public static String m3870a(String str) {
        return C0500k.m3756a(str, new String[]{"&", "<", "]]>"}, new String[]{"&amp;", "&lt;", "]]&gt;"});
    }

    /* renamed from: b */
    public static String m3872b(String str) {
        if (str != null && !str.isEmpty()) {
            char[] charArray = str.toCharArray();
            StringBuilder sb = new StringBuilder(str.length() + 10);
            switch (charArray[0]) {
                case '#':
                case '?':
                case '@':
                    sb.append('\\');
                    break;
            }
            for (char c2 : charArray) {
                switch (c2) {
                    case '\n':
                        sb.append("\\n");
                        continue;
                    case '\"':
                        sb.append("&quot;");
                        continue;
                    case '\\':
                        sb.append('\\');
                        break;
                    default:
                        if (!m3871a(c2)) {
                            sb.append(String.format("\\u%04x", new Integer(c2)));
                            break;
                        }
                        break;
                }
                sb.append(c2);
            }
            return sb.toString();
        }
        return str;
    }

    /* renamed from: c */
    public static String m3873c(String str) {
        if (str != null && !str.isEmpty()) {
            char[] charArray = str.toCharArray();
            StringBuilder sb = new StringBuilder(str.length() + 10);
            switch (charArray[0]) {
                case '#':
                case '?':
                case '@':
                    sb.append('\\');
                    break;
            }
            boolean z = true;
            boolean z2 = false;
            int i = 0;
            boolean z3 = false;
            for (char c2 : charArray) {
                if (z3) {
                    if (c2 == '>') {
                        i = sb.length() + 1;
                        z2 = false;
                        z3 = false;
                    }
                } else if (c2 == ' ') {
                    if (z) {
                        z2 = true;
                    }
                    z = true;
                } else {
                    switch (c2) {
                        case '\n':
                        case '\'':
                            z = false;
                            z2 = true;
                            break;
                        case '\"':
                            sb.append('\\');
                            z = false;
                            break;
                        case '<':
                            if (z2) {
                                sb.insert(i, '\"').append('\"');
                            }
                            z = false;
                            z3 = true;
                            break;
                        case '\\':
                            sb.append('\\');
                            z = false;
                            break;
                        default:
                            if (m3871a(c2)) {
                                z = false;
                                break;
                            } else if (sb.length() + 1 != str.length() || c2 != 0) {
                                sb.append(String.format("\\u%04x", new Integer(c2)));
                                z = false;
                                break;
                            } else {
                                z = false;
                                break;
                            }
                    }
                }
                sb.append(c2);
            }
            if (z2 || z) {
                sb.insert(i, '\"').append('\"');
            }
            return sb.toString();
        }
        return str;
    }

    /* renamed from: d */
    public static boolean m3874d(String str) {
        C0538c<List<Integer>, List<Integer>> m3869a = m3869a(str, 4);
        if (!m3869a.f3632a.isEmpty()) {
            if (m3869a.f3633b.size() + m3869a.f3632a.size() > 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static String m3875e(String str) {
        int i = 0;
        C0538c<List<Integer>, List<Integer>> m3869a = m3869a(str, 4);
        if (m3869a.f3632a.isEmpty()) {
            return str;
        }
        if (m3869a.f3633b.size() + m3869a.f3632a.size() >= 2) {
            List<Integer> list = m3869a.f3632a;
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> it = list.iterator();
            int i2 = 0;
            while (true) {
                int i3 = i;
                if (it.hasNext()) {
                    Integer num = new Integer(it.next().intValue() + 1);
                    int i4 = i2 + 1;
                    sb.append(str.substring(i3, num.intValue())).append(i4).append(SymbolTable.SYMBOL_REF);
                    i = num.intValue();
                    i2 = i4;
                } else {
                    sb.append(str.substring(i3));
                    return sb.toString();
                }
            }
        } else {
            return str;
        }
    }

    /* renamed from: a */
    private static C0538c<List<Integer>, List<Integer>> m3869a(String str, int i) {
        char charAt;
        if (i == -1) {
            i = Integer.MAX_VALUE;
        }
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (str == null) {
            return new C0538c<>(arrayList, arrayList2);
        }
        int length = str.length();
        while (true) {
            int indexOf = str.indexOf(37, i2);
            if (indexOf == -1) {
                break;
            }
            int i3 = indexOf + 1;
            if (i3 == length) {
                arrayList.add(new Integer(indexOf));
                break;
            }
            i2 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 != '%') {
                if (charAt2 >= '0' && charAt2 <= '9' && i2 < length) {
                    do {
                        int i4 = i2;
                        i2 = i4 + 1;
                        charAt = str.charAt(i4);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                    } while (i2 < length);
                    if (charAt == '$') {
                        arrayList2.add(new Integer(indexOf));
                    }
                }
                arrayList.add(new Integer(indexOf));
                if (arrayList.size() >= i) {
                    break;
                }
            }
        }
        return new C0538c<>(arrayList, arrayList2);
    }

    /* renamed from: a */
    private static boolean m3871a(char c2) {
        Character.UnicodeBlock m13387of = Character.UnicodeBlock.m13387of(c2);
        return (Character.isISOControl(c2) || c2 == 65535 || m13387of == null || m13387of == Character.UnicodeBlock.SPECIALS) ? false : true;
    }
}
