package p165d.p167b.p173f;

import android.os.health.UidHealthStats;
import android.security.keystore.KeyProperties;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.xml.datatype.DatatypeConstants;
import p165d.p167b.p172e.C1448k;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p172e.InterfaceC1445h;

/* compiled from: AlgorithmId.java */
/* renamed from: d.b.f.e */
/* loaded from: classes.dex */
public class C1505e implements InterfaceC1445h, Serializable {

    /* renamed from: aa */
    private static Map<String, C1454q> f9665aa;

    /* renamed from: O */
    protected C1450m f9699O;

    /* renamed from: aj */
    private AlgorithmParameters f9700aj;

    /* renamed from: ak */
    private C1454q f9701ak;

    /* renamed from: al */
    private boolean f9702al;

    /* renamed from: W */
    private static boolean f9660W = false;

    /* renamed from: g */
    public static final C1454q f9679g = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 2, 2});

    /* renamed from: h */
    public static final C1454q f9680h = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 2, 5});

    /* renamed from: o */
    public static final C1454q f9687o = C1454q.m11454a(new int[]{1, 3, 14, 3, 2, 26});

    /* renamed from: k */
    public static final C1454q f9683k = C1454q.m11454a(new int[]{2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 101, 3, 4, 2, 4});

    /* renamed from: l */
    public static final C1454q f9684l = C1454q.m11454a(new int[]{2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 101, 3, 4, 2, 1});

    /* renamed from: m */
    public static final C1454q f9685m = C1454q.m11454a(new int[]{2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 101, 3, 4, 2, 2});

    /* renamed from: n */
    public static final C1454q f9686n = C1454q.m11454a(new int[]{2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 101, 3, 4, 2, 3});

    /* renamed from: Q */
    private static final int[] f9654Q = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 3, 1};

    /* renamed from: P */
    private static final int[] f9653P = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_BUTTON_USER_ACTIVITY_COUNT, 2, 1};

    /* renamed from: R */
    private static final int[] f9655R = {1, 3, 14, 3, 2, 12};

    /* renamed from: S */
    private static final int[] f9656S = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.TIMER_PROCESS_STATE_TOP_SLEEPING_MS, 4, 1};

    /* renamed from: U */
    private static final int[] f9658U = {1, 2, 5, 8, 1, 1};

    /* renamed from: T */
    private static final int[] f9657T = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 1};

    /* renamed from: f */
    public static final C1454q f9678f = m11629a(1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT, 2, 1);

    /* renamed from: e */
    public static final C1454q f9677e = m11629a(1, 3, 132, 1, 12);

    /* renamed from: X */
    private static final int[] f9661X = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 2};

    /* renamed from: Y */
    private static final int[] f9662Y = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 4};

    /* renamed from: ad */
    private static final int[] f9668ad = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 5};

    /* renamed from: ac */
    private static final int[] f9667ac = {1, 3, 14, 3, 2, 29};

    /* renamed from: ae */
    private static final int[] f9669ae = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 14};

    /* renamed from: af */
    private static final int[] f9670af = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 11};

    /* renamed from: ag */
    private static final int[] f9671ag = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 12};

    /* renamed from: ah */
    private static final int[] f9672ah = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 1, 13};

    /* renamed from: ai */
    private static final int[] f9673ai = {1, 3, 14, 3, 2, 13};

    /* renamed from: ab */
    private static final int[] f9666ab = {1, 3, 14, 3, 2, 27};

    /* renamed from: V */
    private static final int[] f9659V = {1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.TIMER_PROCESS_STATE_TOP_SLEEPING_MS, 4, 3};

    /* renamed from: C */
    public static final C1454q f9641C = m11629a(2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 101, 3, 4, 3, 1);

    /* renamed from: F */
    public static final C1454q f9644F = m11629a(2, 16, DatatypeConstants.MIN_TIMEZONE_OFFSET, 1, 101, 3, 4, 3, 2);

    /* renamed from: z */
    public static final C1454q f9698z = m11629a(1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT, 4, 1);

    /* renamed from: D */
    public static final C1454q f9642D = m11629a(1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT, 4, 3, 1);

    /* renamed from: G */
    public static final C1454q f9645G = m11629a(1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT, 4, 3, 2);

    /* renamed from: I */
    public static final C1454q f9647I = m11629a(1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT, 4, 3, 3);

    /* renamed from: K */
    public static final C1454q f9649K = m11629a(1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT, 4, 3, 4);

    /* renamed from: N */
    public static final C1454q f9652N = m11629a(1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, UidHealthStats.MEASUREMENT_OTHER_USER_ACTIVITY_COUNT, 4, 3);

    /* renamed from: r */
    public static final C1454q f9690r = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 5, 3});

    /* renamed from: s */
    public static final C1454q f9691s = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 5, 6});

    /* renamed from: t */
    public static final C1454q f9692t = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 5, 10});

    /* renamed from: w */
    public static final C1454q f9695w = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 5, 11});

    /* renamed from: u */
    public static C1454q f9693u = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 12, 1, 3});

    /* renamed from: v */
    public static C1454q f9694v = C1454q.m11454a(new int[]{1, 2, DatatypeConstants.MIN_TIMEZONE_OFFSET, 113549, 1, 12, 1, 6});

    /* renamed from: b */
    public static final C1454q f9674b = C1454q.m11454a(f9654Q);

    /* renamed from: a */
    public static final C1454q f9664a = C1454q.m11454a(f9653P);

    /* renamed from: c */
    public static final C1454q f9675c = C1454q.m11454a(f9655R);

    /* renamed from: d */
    public static final C1454q f9676d = C1454q.m11454a(f9656S);

    /* renamed from: j */
    public static final C1454q f9682j = C1454q.m11454a(f9658U);

    /* renamed from: i */
    public static final C1454q f9681i = C1454q.m11454a(f9657T);

    /* renamed from: p */
    public static final C1454q f9688p = C1454q.m11454a(f9661X);

    /* renamed from: q */
    public static final C1454q f9689q = C1454q.m11454a(f9662Y);

    /* renamed from: B */
    public static final C1454q f9640B = C1454q.m11454a(f9668ad);

    /* renamed from: A */
    public static final C1454q f9639A = C1454q.m11454a(f9667ac);

    /* renamed from: E */
    public static final C1454q f9643E = C1454q.m11454a(f9669ae);

    /* renamed from: H */
    public static final C1454q f9646H = C1454q.m11454a(f9670af);

    /* renamed from: J */
    public static final C1454q f9648J = C1454q.m11454a(f9671ag);

    /* renamed from: L */
    public static final C1454q f9650L = C1454q.m11454a(f9672ah);

    /* renamed from: M */
    public static final C1454q f9651M = C1454q.m11454a(f9673ai);

    /* renamed from: x */
    public static final C1454q f9696x = C1454q.m11454a(f9666ab);

    /* renamed from: y */
    public static final C1454q f9697y = C1454q.m11454a(f9659V);

    /* renamed from: Z */
    private static final Map<C1454q, String> f9663Z = new HashMap();

    @Deprecated
    public C1505e() {
        this.f9702al = true;
    }

    public C1505e(C1454q c1454q) {
        this.f9702al = true;
        this.f9701ak = c1454q;
    }

    public C1505e(C1454q c1454q, AlgorithmParameters algorithmParameters) {
        this.f9702al = true;
        this.f9701ak = c1454q;
        this.f9700aj = algorithmParameters;
        this.f9702al = false;
    }

    private C1505e(C1454q c1454q, C1450m c1450m) {
        this.f9702al = true;
        this.f9701ak = c1454q;
        this.f9699O = c1450m;
        if (this.f9699O != null) {
            m11636a();
        }
    }

    /* renamed from: a */
    protected void m11636a() {
        try {
            this.f9700aj = AlgorithmParameters.getInstance(this.f9701ak.toString());
            this.f9700aj.init(this.f9699O.m11440u());
        } catch (NoSuchAlgorithmException e2) {
            this.f9700aj = null;
        }
    }

    /* renamed from: a */
    public final void m11637a(C1449l c1449l) {
        mo11272a((OutputStream) c1449l);
    }

    @Override // p165d.p167b.p172e.InterfaceC1445h
    /* renamed from: a */
    public void mo11272a(OutputStream outputStream) {
        C1449l c1449l = new C1449l();
        C1449l c1449l2 = new C1449l();
        c1449l.m11394a(this.f9701ak);
        if (!this.f9702al) {
            if (this.f9700aj != null) {
                this.f9699O = new C1450m(this.f9700aj.getEncoded());
            } else {
                this.f9699O = null;
            }
        }
        if (this.f9699O == null) {
            c1449l.m11387a();
        } else {
            c1449l.m11393a(this.f9699O);
        }
        c1449l2.m11388a((byte) 48, c1449l);
        outputStream.write(c1449l2.toByteArray());
    }

    /* renamed from: b */
    public final byte[] m11640b() {
        C1449l c1449l = new C1449l();
        mo11272a((OutputStream) c1449l);
        return c1449l.toByteArray();
    }

    /* renamed from: e */
    public final C1454q m11643e() {
        return this.f9701ak;
    }

    /* renamed from: d */
    public String m11642d() {
        String str = f9663Z.get(this.f9701ak);
        if (str == null) {
            if (this.f9699O != null && this.f9701ak.equals(f9652N)) {
                try {
                    String m11642d = m11630a(new C1450m(m11641c())).m11642d();
                    if (m11642d.equals("SHA")) {
                        m11642d = "SHA1";
                    }
                    str = String.valueOf(m11642d) + "withECDSA";
                } catch (IOException e2) {
                }
            }
            return str == null ? this.f9701ak.toString() : str;
        }
        return str;
    }

    /* renamed from: f */
    public AlgorithmParameters m11644f() {
        return this.f9700aj;
    }

    /* renamed from: c */
    public byte[] m11641c() {
        if (this.f9699O == null) {
            return null;
        }
        return this.f9699O.m11440u();
    }

    /* renamed from: a */
    public boolean m11639a(C1505e c1505e) {
        return this.f9701ak.equals(c1505e.f9701ak) && (this.f9699O == null ? c1505e.f9699O == null : this.f9699O.m11418a(c1505e.f9699O));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1505e) {
            return m11639a((C1505e) obj);
        }
        if (obj instanceof C1454q) {
            return m11638a((C1454q) obj);
        }
        return false;
    }

    /* renamed from: a */
    public final boolean m11638a(C1454q c1454q) {
        return this.f9701ak.equals(c1454q);
    }

    public int hashCode() {
        return (this.f9701ak.toString() + m11645g()).hashCode();
    }

    /* renamed from: g */
    protected String m11645g() {
        if (this.f9699O == null) {
            return "";
        }
        if (this.f9700aj != null) {
            return this.f9700aj.toString();
        }
        return ", params unparsed";
    }

    public String toString() {
        return String.valueOf(m11642d()) + m11645g();
    }

    /* renamed from: a */
    public static C1505e m11630a(C1450m c1450m) {
        C1450m c1450m2 = null;
        if (c1450m.f9357c != 48) {
            throw new IOException("algid parse error, not a sequence");
        }
        C1448k m11441v = c1450m.m11441v();
        C1454q m11376h = m11441v.m11376h();
        if (m11441v.m11362a() != 0) {
            C1450m m11371d = m11441v.m11371d();
            if (m11371d.f9357c != 5) {
                c1450m2 = m11371d;
            } else if (m11371d.m11439t() != 0) {
                throw new IOException("invalid NULL");
            }
            if (m11441v.m11362a() != 0) {
                throw new IOException("Invalid AlgorithmIdentifier: extra data");
            }
        }
        return new C1505e(m11376h, c1450m2);
    }

    /* renamed from: a */
    public static C1505e m11631a(String str) {
        try {
            C1454q m11635d = m11635d(str);
            if (m11635d == null) {
                throw new NoSuchAlgorithmException("unrecognized algorithm name: " + str);
            }
            return new C1505e(m11635d);
        } catch (IOException e2) {
            throw new NoSuchAlgorithmException("Invalid ObjectIdentifier " + str);
        }
    }

    /* renamed from: d */
    private static C1454q m11635d(String str) {
        int indexOf;
        if (str.indexOf(46) != -1) {
            if (str.startsWith("OID.")) {
                return new C1454q(str.substring("OID.".length()));
            }
            return new C1454q(str);
        }
        if (str.equalsIgnoreCase(KeyProperties.DIGEST_MD5)) {
            return f9680h;
        }
        if (str.equalsIgnoreCase("MD2")) {
            return f9679g;
        }
        if (str.equalsIgnoreCase("SHA") || str.equalsIgnoreCase("SHA1") || str.equalsIgnoreCase(KeyProperties.DIGEST_SHA1)) {
            return f9687o;
        }
        if (str.equalsIgnoreCase(KeyProperties.DIGEST_SHA256) || str.equalsIgnoreCase("SHA256")) {
            return f9684l;
        }
        if (str.equalsIgnoreCase(KeyProperties.DIGEST_SHA384) || str.equalsIgnoreCase("SHA384")) {
            return f9685m;
        }
        if (str.equalsIgnoreCase(KeyProperties.DIGEST_SHA512) || str.equalsIgnoreCase("SHA512")) {
            return f9686n;
        }
        if (str.equalsIgnoreCase(KeyProperties.DIGEST_SHA224) || str.equalsIgnoreCase("SHA224")) {
            return f9683k;
        }
        if (str.equalsIgnoreCase(KeyProperties.KEY_ALGORITHM_RSA)) {
            return f9681i;
        }
        if (str.equalsIgnoreCase("Diffie-Hellman") || str.equalsIgnoreCase("DH")) {
            return f9674b;
        }
        if (str.equalsIgnoreCase("DSA")) {
            return f9676d;
        }
        if (str.equalsIgnoreCase(KeyProperties.KEY_ALGORITHM_EC)) {
            return f9678f;
        }
        if (str.equalsIgnoreCase("ECDH")) {
            return f9677e;
        }
        if (str.equalsIgnoreCase("MD5withRSA") || str.equalsIgnoreCase("MD5/RSA")) {
            return f9689q;
        }
        if (str.equalsIgnoreCase("MD2withRSA") || str.equalsIgnoreCase("MD2/RSA")) {
            return f9688p;
        }
        if (str.equalsIgnoreCase("SHAwithDSA") || str.equalsIgnoreCase("SHA1withDSA") || str.equalsIgnoreCase("SHA/DSA") || str.equalsIgnoreCase("SHA1/DSA") || str.equalsIgnoreCase("DSAWithSHA1") || str.equalsIgnoreCase("DSS") || str.equalsIgnoreCase("SHA-1/DSA")) {
            return f9697y;
        }
        if (str.equalsIgnoreCase("SHA224WithDSA")) {
            return f9641C;
        }
        if (str.equalsIgnoreCase("SHA256WithDSA")) {
            return f9644F;
        }
        if (str.equalsIgnoreCase("SHA1WithRSA") || str.equalsIgnoreCase("SHA1/RSA")) {
            return f9640B;
        }
        if (str.equalsIgnoreCase("SHA1withECDSA") || str.equalsIgnoreCase("ECDSA")) {
            return f9698z;
        }
        if (str.equalsIgnoreCase("SHA224withECDSA")) {
            return f9642D;
        }
        if (str.equalsIgnoreCase("SHA256withECDSA")) {
            return f9645G;
        }
        if (str.equalsIgnoreCase("SHA384withECDSA")) {
            return f9647I;
        }
        if (str.equalsIgnoreCase("SHA512withECDSA")) {
            return f9649K;
        }
        if (!f9660W) {
            Provider[] providers = Security.getProviders();
            for (int i = 0; i < providers.length; i++) {
                Enumeration<Object> keys = providers[i].keys();
                while (keys.hasMoreElements()) {
                    String str2 = (String) keys.nextElement();
                    String upperCase = str2.toUpperCase(Locale.ENGLISH);
                    if (upperCase.startsWith("ALG.ALIAS") && (indexOf = upperCase.indexOf("OID.", 0)) != -1) {
                        int length = indexOf + "OID.".length();
                        if (length != str2.length()) {
                            if (f9665aa == null) {
                                f9665aa = new HashMap();
                            }
                            String substring = str2.substring(length);
                            String property = providers[i].getProperty(str2);
                            if (property != null) {
                                property = property.toUpperCase(Locale.ENGLISH);
                            }
                            if (property != null && f9665aa.get(property) == null) {
                                f9665aa.put(property, new C1454q(substring));
                            }
                        }
                    }
                }
            }
            if (f9665aa == null) {
                f9665aa = Collections.emptyMap();
            }
            f9660W = true;
        }
        return f9665aa.get(str.toUpperCase(Locale.ENGLISH));
    }

    /* renamed from: a */
    private static C1454q m11629a(int... iArr) {
        return C1454q.m11454a(iArr);
    }

    static {
        f9663Z.put(f9680h, KeyProperties.DIGEST_MD5);
        f9663Z.put(f9679g, "MD2");
        f9663Z.put(f9687o, "SHA");
        f9663Z.put(f9683k, "SHA224");
        f9663Z.put(f9684l, "SHA256");
        f9663Z.put(f9685m, "SHA384");
        f9663Z.put(f9686n, "SHA512");
        f9663Z.put(f9681i, KeyProperties.KEY_ALGORITHM_RSA);
        f9663Z.put(f9682j, KeyProperties.KEY_ALGORITHM_RSA);
        f9663Z.put(f9674b, "Diffie-Hellman");
        f9663Z.put(f9664a, "Diffie-Hellman");
        f9663Z.put(f9676d, "DSA");
        f9663Z.put(f9675c, "DSA");
        f9663Z.put(f9678f, KeyProperties.KEY_ALGORITHM_EC);
        f9663Z.put(f9677e, "ECDH");
        f9663Z.put(f9698z, "SHA1withECDSA");
        f9663Z.put(f9642D, "SHA224withECDSA");
        f9663Z.put(f9645G, "SHA256withECDSA");
        f9663Z.put(f9647I, "SHA384withECDSA");
        f9663Z.put(f9649K, "SHA512withECDSA");
        f9663Z.put(f9689q, "MD5withRSA");
        f9663Z.put(f9688p, "MD2withRSA");
        f9663Z.put(f9697y, "SHA1withDSA");
        f9663Z.put(f9696x, "SHA1withDSA");
        f9663Z.put(f9651M, "SHA1withDSA");
        f9663Z.put(f9641C, "SHA224withDSA");
        f9663Z.put(f9644F, "SHA256withDSA");
        f9663Z.put(f9640B, "SHA1withRSA");
        f9663Z.put(f9639A, "SHA1withRSA");
        f9663Z.put(f9643E, "SHA224withRSA");
        f9663Z.put(f9646H, "SHA256withRSA");
        f9663Z.put(f9648J, "SHA384withRSA");
        f9663Z.put(f9650L, "SHA512withRSA");
        f9663Z.put(f9690r, "PBEWithMD5AndDES");
        f9663Z.put(f9691s, "PBEWithMD5AndRC2");
        f9663Z.put(f9692t, "PBEWithSHA1AndDES");
        f9663Z.put(f9695w, "PBEWithSHA1AndRC2");
        f9663Z.put(f9693u, "PBEWithSHA1AndDESede");
        f9663Z.put(f9694v, "PBEWithSHA1AndRC2_40");
    }

    /* renamed from: a */
    public static String m11632a(String str, String str2) {
        String upperCase = str.replace("-", "").toUpperCase(Locale.ENGLISH);
        if (upperCase.equalsIgnoreCase("SHA")) {
            upperCase = "SHA1";
        }
        String upperCase2 = str2.toUpperCase(Locale.ENGLISH);
        if (upperCase2.equals(KeyProperties.KEY_ALGORITHM_EC)) {
            upperCase2 = "ECDSA";
        }
        return String.valueOf(upperCase) + "with" + upperCase2;
    }

    /* renamed from: b */
    public static String m11633b(String str) {
        String substring;
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int indexOf = upperCase.indexOf("WITH");
        if (indexOf <= 0) {
            return null;
        }
        int indexOf2 = upperCase.indexOf("AND", indexOf + 4);
        if (indexOf2 > 0) {
            substring = upperCase.substring(indexOf + 4, indexOf2);
        } else {
            substring = upperCase.substring(indexOf + 4);
        }
        if (substring.equalsIgnoreCase("ECDSA")) {
            return KeyProperties.KEY_ALGORITHM_EC;
        }
        return substring;
    }

    /* renamed from: c */
    public static String m11634c(String str) {
        if (str.equals("SHA")) {
            return KeyProperties.DIGEST_SHA1;
        }
        if (str.equals("SHA224")) {
            return KeyProperties.DIGEST_SHA224;
        }
        if (str.equals("SHA256")) {
            return KeyProperties.DIGEST_SHA256;
        }
        if (str.equals("SHA384")) {
            return KeyProperties.DIGEST_SHA384;
        }
        if (str.equals("SHA512")) {
            return KeyProperties.DIGEST_SHA512;
        }
        return str;
    }
}
