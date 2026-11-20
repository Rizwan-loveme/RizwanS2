package jadx.core.p182b;

import android.app.slice.SliceItem;
import android.provider.Telephony;
import jadx.core.p203d.C1744m;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: NameMapper.java */
/* renamed from: jadx.core.b.d */
/* loaded from: classes.dex */
public class C1559d {

    /* renamed from: a */
    private static final Pattern f9981a = Pattern.compile("\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");

    /* renamed from: b */
    private static final Pattern f9982b = Pattern.compile("(" + f9981a + "\\.)*" + f9981a);

    /* renamed from: c */
    private static final Set<String> f9983c = new HashSet(Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", SliceItem.FORMAT_INT, "interface", SliceItem.FORMAT_LONG, "native", "new", "null", Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"));

    /* renamed from: a */
    public static boolean m12063a(String str) {
        return f9983c.contains(str);
    }

    /* renamed from: b */
    public static boolean m12064b(String str) {
        return C1744m.m13306c(str) && !m12063a(str) && f9981a.matcher(str).matches() && m12065c(str);
    }

    /* renamed from: a */
    public static boolean m12062a(int i) {
        return 32 <= i && i <= 126;
    }

    /* renamed from: c */
    public static boolean m12065c(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!m12062a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
