package p165d.p167b.p172e;

import java.math.BigInteger;
import java.security.AccessController;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p165d.p167b.p168a.C1422b;

/* compiled from: Debug.java */
/* renamed from: d.b.e.g */
/* loaded from: classes.dex */
public class C1444g {

    /* renamed from: a */
    private static String f9338a;

    /* renamed from: b */
    private static final char[] f9339b;

    /* renamed from: c */
    private String f9340c;

    static {
        f9338a = (String) AccessController.doPrivileged(new C1422b("java.security.debug"));
        String str = (String) AccessController.doPrivileged(new C1422b("java.security.auth.debug"));
        if (f9338a == null) {
            f9338a = str;
        } else if (str != null) {
            f9338a = String.valueOf(f9338a) + "," + str;
        }
        if (f9338a != null) {
            f9338a = m11332d(f9338a);
            if (f9338a.equals("help")) {
                m11330a();
            }
        }
        f9339b = "0123456789abcdef".toCharArray();
    }

    /* renamed from: a */
    public static void m11330a() {
        System.err.println();
        System.err.println("all           turn on all debugging");
        System.err.println("access        print all checkPermission results");
        System.err.println("combiner      SubjectDomainCombiner debugging");
        System.err.println("gssloginconfig");
        System.err.println("configfile    JAAS ConfigFile loading");
        System.err.println("configparser  JAAS ConfigFile parsing");
        System.err.println("              GSS LoginConfigImpl debugging");
        System.err.println("jar           jar verification");
        System.err.println("logincontext  login context results");
        System.err.println("policy        loading and granting");
        System.err.println("provider      security provider debugging");
        System.err.println("scl           permissions SecureClassLoader assigns");
        System.err.println("ts            timestamping");
        System.err.println();
        System.err.println("The following can be used with access:");
        System.err.println();
        System.err.println("stack         include stack trace");
        System.err.println("domain        dump all domains in context");
        System.err.println("failure       before throwing exception, dump stack");
        System.err.println("              and domain that didn't have permission");
        System.err.println();
        System.err.println("The following can be used with stack and domain:");
        System.err.println();
        System.err.println("permission=<classname>");
        System.err.println("              only dump output if specified permission");
        System.err.println("              is being checked");
        System.err.println("codebase=<URL>");
        System.err.println("              only dump output if specified codebase");
        System.err.println("              is being checked");
        System.err.println();
        System.err.println("Note: Separate multiple options with a comma");
        System.exit(0);
    }

    /* renamed from: a */
    public static C1444g m11327a(String str) {
        return m11328a(str, str);
    }

    /* renamed from: a */
    public static C1444g m11328a(String str, String str2) {
        if (!m11331b(str)) {
            return null;
        }
        C1444g c1444g = new C1444g();
        c1444g.f9340c = str2;
        return c1444g;
    }

    /* renamed from: b */
    public static boolean m11331b(String str) {
        return (f9338a == null || (f9338a.indexOf("all") == -1 && f9338a.indexOf(str) == -1)) ? false : true;
    }

    /* renamed from: c */
    public void m11333c(String str) {
        System.err.println(String.valueOf(this.f9340c) + ": " + str);
    }

    /* renamed from: a */
    public static String m11329a(BigInteger bigInteger) {
        String bigInteger2 = bigInteger.toString(16);
        StringBuffer stringBuffer = new StringBuffer(bigInteger2.length() * 2);
        if (bigInteger2.startsWith("-")) {
            stringBuffer.append("   -");
            bigInteger2 = bigInteger2.substring(1);
        } else {
            stringBuffer.append("    ");
        }
        if (bigInteger2.length() % 2 != 0) {
            bigInteger2 = "0" + bigInteger2;
        }
        int i = 0;
        while (i < bigInteger2.length()) {
            stringBuffer.append(bigInteger2.substring(i, i + 2));
            i += 2;
            if (i != bigInteger2.length()) {
                if (i % 64 == 0) {
                    stringBuffer.append("\n    ");
                } else if (i % 8 == 0) {
                    stringBuffer.append(" ");
                }
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: d */
    private static String m11332d(String str) {
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile(String.valueOf("[Pp][Ee][Rr][Mm][Ii][Ss][Ss][Ii][Oo][Nn]=") + "[a-zA-Z_$][a-zA-Z0-9_$]*([.][a-zA-Z_$][a-zA-Z0-9_$]*)*").matcher(new StringBuffer(str));
            StringBuffer stringBuffer2 = new StringBuffer();
            while (matcher.find()) {
                stringBuffer.append(matcher.group().replaceFirst("[Pp][Ee][Rr][Mm][Ii][Ss][Ss][Ii][Oo][Nn]=", "permission="));
                stringBuffer.append("  ");
                matcher.appendReplacement(stringBuffer2, "");
            }
            matcher.appendTail(stringBuffer2);
            Matcher matcher2 = Pattern.compile(String.valueOf("[Cc][Oo][Dd][Ee][Bb][Aa][Ss][Ee]=") + "[^, ;]*").matcher(stringBuffer2);
            StringBuffer stringBuffer3 = new StringBuffer();
            while (matcher2.find()) {
                stringBuffer.append(matcher2.group().replaceFirst("[Cc][Oo][Dd][Ee][Bb][Aa][Ss][Ee]=", "codebase="));
                stringBuffer.append("  ");
                matcher2.appendReplacement(stringBuffer3, "");
            }
            matcher2.appendTail(stringBuffer3);
            stringBuffer.append(stringBuffer3.toString().toLowerCase(Locale.ENGLISH));
            return stringBuffer.toString();
        }
        return null;
    }
}
