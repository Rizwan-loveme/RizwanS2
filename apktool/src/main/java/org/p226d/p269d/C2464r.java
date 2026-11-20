package org.p226d.p269d;

import java.p209io.Writer;

/* compiled from: StringUtils.java */
/* renamed from: org.d.d.r */
/* loaded from: classes.dex */
public class C2464r {
    /* renamed from: a */
    public static void m15560a(Writer writer, char c2) {
        if (c2 >= ' ' && c2 < 127) {
            if (c2 == '\'' || c2 == '\"' || c2 == '\\') {
                writer.write(92);
            }
            writer.write(c2);
            return;
        }
        if (c2 <= 127) {
            switch (c2) {
                case '\t':
                    writer.write("\\t");
                    break;
                case '\n':
                    writer.write("\\n");
                    break;
                case '\r':
                    writer.write("\\r");
                    break;
            }
            return;
        }
        writer.write("\\u");
        writer.write(Character.forDigit(c2 >> '\f', 16));
        writer.write(Character.forDigit((c2 >> '\b') & 15, 16));
        writer.write(Character.forDigit((c2 >> 4) & 15, 16));
        writer.write(Character.forDigit(c2 & 15, 16));
    }

    /* renamed from: a */
    public static void m15561a(Writer writer, String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= ' ' && charAt < 127) {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    writer.write(92);
                }
                writer.write(charAt);
            } else {
                if (charAt <= 127) {
                    switch (charAt) {
                        case '\t':
                            writer.write("\\t");
                            break;
                        case '\n':
                            writer.write("\\n");
                            break;
                        case '\r':
                            writer.write("\\r");
                            break;
                    }
                }
                writer.write("\\u");
                writer.write(Character.forDigit(charAt >> '\f', 16));
                writer.write(Character.forDigit((charAt >> '\b') & 15, 16));
                writer.write(Character.forDigit((charAt >> 4) & 15, 16));
                writer.write(Character.forDigit(charAt & 15, 16));
            }
        }
    }

    /* renamed from: a */
    public static String m15559a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder((length * 3) / 2);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= ' ' && charAt < 127) {
                if (charAt == '\'' || charAt == '\"' || charAt == '\\') {
                    sb.append('\\');
                }
                sb.append(charAt);
            } else {
                if (charAt <= 127) {
                    switch (charAt) {
                        case '\t':
                            sb.append("\\t");
                            break;
                        case '\n':
                            sb.append("\\n");
                            break;
                        case '\r':
                            sb.append("\\r");
                            break;
                    }
                }
                sb.append("\\u");
                sb.append(Character.forDigit(charAt >> '\f', 16));
                sb.append(Character.forDigit((charAt >> '\b') & 15, 16));
                sb.append(Character.forDigit((charAt >> 4) & 15, 16));
                sb.append(Character.forDigit(charAt & 15, 16));
            }
        }
        return sb.toString();
    }
}
