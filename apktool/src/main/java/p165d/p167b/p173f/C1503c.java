package p165d.p167b.p173f;

import java.p209io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import p165d.p167b.p169b.C1428f;
import p165d.p167b.p172e.C1454q;

/* compiled from: AVA.java */
/* renamed from: d.b.f.c */
/* loaded from: classes.dex */
class C1503c {

    /* renamed from: c */
    private String f9628c;

    /* renamed from: d */
    private C1454q f9629d;

    /* renamed from: e */
    private boolean f9630e;

    /* renamed from: f */
    private boolean f9631f;

    /* renamed from: b */
    private static final Map<C1454q, C1503c> f9627b = new HashMap();

    /* renamed from: a */
    private static final Map<String, C1503c> f9626a = new HashMap();

    private C1503c(String str, C1454q c1454q, boolean z, boolean z2) {
        this.f9628c = str;
        this.f9629d = c1454q;
        this.f9630e = z;
        this.f9631f = z2;
        f9627b.put(c1454q, this);
        f9626a.put(str, this);
    }

    /* renamed from: a */
    private boolean m11624a(int i) {
        switch (i) {
            case 1:
                return true;
            case 2:
                return this.f9630e;
            case 3:
                return this.f9631f;
            default:
                throw new IllegalArgumentException("Invalid standard " + i);
        }
    }

    /* renamed from: a */
    static C1454q m11622a(String str, int i, Map<String, String> map) {
        String trim;
        char charAt;
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        if (i == 3) {
            if (upperCase.startsWith(" ") || upperCase.endsWith(" ")) {
                throw new IOException("Invalid leading or trailing space in keyword \"" + upperCase + "\"");
            }
            trim = upperCase;
        } else {
            trim = upperCase.trim();
        }
        String str2 = map.get(trim);
        if (str2 == null) {
            C1503c c1503c = f9626a.get(trim);
            if (c1503c != null && c1503c.m11624a(i)) {
                return c1503c.f9629d;
            }
            if (i == 2) {
                if (!trim.startsWith("OID.")) {
                    throw new IOException("Invalid RFC1779 keyword: " + trim);
                }
                trim = trim.substring(4);
            } else if (i == 1 && trim.startsWith("OID.")) {
                trim = trim.substring(4);
            }
            if (!(trim.length() != 0 && (charAt = trim.charAt(0)) >= '0' && charAt <= '9')) {
                throw new IOException("Invalid keyword \"" + trim + "\"");
            }
            return new C1454q(trim);
        }
        return new C1454q(str2);
    }

    /* renamed from: a */
    static String m11623a(C1454q c1454q, int i, Map<String, String> map) {
        String c1454q2 = c1454q.toString();
        String str = map.get(c1454q2);
        if (str == null) {
            C1503c c1503c = f9627b.get(c1454q);
            if (c1503c == null || !c1503c.m11624a(i)) {
                return i == 3 ? c1454q2 : "OID." + c1454q2;
            }
            return c1503c.f9628c;
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("keyword cannot be empty");
        }
        String trim = str.trim();
        char charAt = trim.charAt(0);
        if (charAt < 'A' || charAt > 'z' || (charAt > 'Z' && charAt < 'a')) {
            throw new IllegalArgumentException("keyword does not start with letter");
        }
        for (int i2 = 1; i2 < trim.length(); i2++) {
            char charAt2 = trim.charAt(i2);
            if ((charAt2 < 'A' || charAt2 > 'z' || (charAt2 > 'Z' && charAt2 < 'a')) && ((charAt2 < '0' || charAt2 > '9') && charAt2 != '_')) {
                throw new IllegalArgumentException("keyword character is not a letter, digit, or underscore");
            }
        }
        return trim;
    }

    /* renamed from: a */
    static boolean m11625a(C1454q c1454q, int i) {
        C1503c c1503c = f9627b.get(c1454q);
        if (c1503c == null) {
            return false;
        }
        return c1503c.m11624a(i);
    }

    static {
        new C1503c("CN", C1496bn.f9547h, true, true);
        new C1503c("C", C1496bn.f9548i, true, true);
        new C1503c("L", C1496bn.f9550k, true, true);
        new C1503c("S", C1496bn.f9553n, false, false);
        new C1503c("ST", C1496bn.f9553n, true, true);
        new C1503c("O", C1496bn.f9551l, true, true);
        new C1503c("OU", C1496bn.f9552m, true, true);
        new C1503c("T", C1496bn.f9555p, false, false);
        new C1503c("IP", C1496bn.f9549j, false, false);
        new C1503c("STREET", C1496bn.f9554o, true, true);
        new C1503c("DC", C1496bn.f9541b, false, true);
        new C1503c("DNQUALIFIER", C1496bn.f9540a, false, false);
        new C1503c("DNQ", C1496bn.f9540a, false, false);
        new C1503c("SURNAME", C1496bn.f9546g, false, false);
        new C1503c("GIVENNAME", C1496bn.f9543d, false, false);
        new C1503c("INITIALS", C1496bn.f9544e, false, false);
        new C1503c("GENERATION", C1496bn.f9542c, false, false);
        new C1503c("EMAIL", C1428f.f9237d, false, false);
        new C1503c("EMAILADDRESS", C1428f.f9237d, false, false);
        new C1503c("UID", C1496bn.f9556q, false, true);
        new C1503c("SERIALNUMBER", C1496bn.f9545f, false, false);
    }
}
