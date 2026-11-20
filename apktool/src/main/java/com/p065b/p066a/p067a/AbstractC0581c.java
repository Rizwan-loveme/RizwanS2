package com.p065b.p066a.p067a;

import android.telephony.PhoneNumberUtils;
import com.p065b.p066a.p067a.C0582d;
import com.p065b.p066a.p068b.p069a.C0586a;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0677b;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: ApkUtils.java */
/* renamed from: com.b.a.a.c */
/* loaded from: classes.dex */
public abstract class AbstractC0581c {
    public static final String ANDROID_MANIFEST_ZIP_ENTRY_NAME = "AndroidManifest.xml";
    private static final int DEBUGGABLE_ATTR_ID = 16842767;
    private static final String MANIFEST_ELEMENT_TAG = "manifest";
    private static final int MIN_SDK_VERSION_ATTR_ID = 16843276;
    public static final String SOURCE_STAMP_CERTIFICATE_HASH_ZIP_ENTRY_NAME = "stamp-cert-sha256";
    private static final int TARGET_SANDBOX_VERSION_ATTR_ID = 16844108;
    private static final int TARGET_SDK_VERSION_ATTR_ID = 16843376;
    private static final String USES_SDK_ELEMENT_TAG = "uses-sdk";
    private static final int VERSION_CODE_ATTR_ID = 16843291;
    private static final int VERSION_CODE_MAJOR_ATTR_ID = 16844150;

    private AbstractC0581c() {
    }

    /* renamed from: a */
    public static c m5771a(InterfaceC0671c interfaceC0671c) {
        C0677b m5786a = C0582d.m5786a(interfaceC0671c);
        return new c(m5786a.m6355a(), m5786a.m6357c(), m5786a.m6356b(), m5786a.m6359e(), m5786a.m6358d());
    }

    /* compiled from: ApkUtils.java */
    /* renamed from: com.b.a.a.c$c */
    public static class c extends C0677b {
        public c(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
            super(j, j2, i, j3, byteBuffer);
        }
    }

    /* renamed from: a */
    public static a m5770a(InterfaceC0671c interfaceC0671c, c cVar) {
        C0582d.a m5785a = C0582d.m5785a(interfaceC0671c, cVar);
        return new a(m5785a.m5789b(), m5785a.m5788a());
    }

    /* compiled from: ApkUtils.java */
    /* renamed from: com.b.a.a.c$a */
    public static class a extends C0582d.a {
        public a(long j, InterfaceC0671c interfaceC0671c) {
            super(j, interfaceC0671c);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        r3 = r4.m5822d(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        if (r3 == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r3 != 2) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        r0 = r4.m5817a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004a, code lost:
    
        r1 = java.lang.Math.max(r1, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        throw new com.p065b.p066a.p067a.C0584f("Unable to determine APK's minimum supported Android: unsupported value type in AndroidManifest.xml's minSdkVersion. Only integer values supported.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
    
        r0 = m5768a(r4.m5821c(r0));
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m5774b(ByteBuffer byteBuffer) {
        try {
            C0586a c0586a = new C0586a(byteBuffer);
            int i = 1;
            int m5820c = c0586a.m5820c();
            while (m5820c != 2) {
                if (m5820c == 3 && c0586a.m5818b() == 2 && USES_SDK_ELEMENT_TAG.equals(c0586a.m5823d()) && c0586a.m5824e().isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= c0586a.m5816a()) {
                            int i3 = 1;
                            break;
                        }
                        if (c0586a.m5819b(i2) == 16843276) {
                            break;
                        }
                        i2++;
                    }
                }
                m5820c = c0586a.m5825f();
                i = i;
            }
            return i;
        } catch (C0586a.e e2) {
            throw new C0584f("Unable to determine APK's minimum supported Android platform version: malformed binary resource: AndroidManifest.xml", e2);
        }
    }

    /* compiled from: ApkUtils.java */
    /* renamed from: com.b.a.a.c$b */
    private static class b {
        private static final C0652k<Character, Integer>[] SORTED_CODENAMES_FIRST_CHAR_TO_API_LEVEL = {C0652k.m6250a('C', 2), C0652k.m6250a('D', 3), C0652k.m6250a('E', 4), C0652k.m6250a('F', 7), C0652k.m6250a('G', 8), C0652k.m6250a('H', 10), C0652k.m6250a('I', 13), C0652k.m6250a('J', 15), C0652k.m6250a('K', 18), C0652k.m6250a('L', 20), C0652k.m6250a('M', 22), C0652k.m6250a(Character.valueOf(PhoneNumberUtils.WILD), 23), C0652k.m6250a('O', 25)};
        private static final Comparator<C0652k<Character, Integer>> CODENAME_FIRST_CHAR_COMPARATOR = new a();

        private b() {
        }

        /* compiled from: ApkUtils.java */
        /* renamed from: com.b.a.a.c$b$a */
        private static class a implements Comparator<C0652k<Character, Integer>> {
            private a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0652k<Character, Integer> c0652k, C0652k<Character, Integer> c0652k2) {
                return c0652k.m6251a().charValue() - c0652k2.m6251a().charValue();
            }
        }
    }

    /* renamed from: a */
    static int m5768a(String str) {
        char charAt = str.isEmpty() ? ' ' : str.charAt(0);
        if (charAt >= 'A' && charAt <= 'Z') {
            C0652k[] c0652kArr = b.SORTED_CODENAMES_FIRST_CHAR_TO_API_LEVEL;
            int binarySearch = Arrays.binarySearch(c0652kArr, C0652k.m6250a(Character.valueOf(charAt), null), b.CODENAME_FIRST_CHAR_COMPARATOR);
            if (binarySearch >= 0) {
                return ((Integer) c0652kArr[binarySearch].m6252b()).intValue();
            }
            int i = (-1) - binarySearch;
            if (i == 0) {
                return 1;
            }
            C0652k c0652k = c0652kArr[i - 1];
            return ((Integer) c0652k.m6252b()).intValue() + (charAt - ((Character) c0652k.m6251a()).charValue());
        }
        throw new C0583e("Unable to determine APK's minimum supported Android platform version : Unsupported codename in AndroidManifest.xml's minSdkVersion: \"" + str + "\"", str);
    }

    /* renamed from: a */
    public static boolean m5772a(ByteBuffer byteBuffer) {
        try {
            C0586a c0586a = new C0586a(byteBuffer);
            for (int m5820c = c0586a.m5820c(); m5820c != 2; m5820c = c0586a.m5825f()) {
                if (m5820c == 3 && c0586a.m5818b() == 2 && "application".equals(c0586a.m5823d()) && c0586a.m5824e().isEmpty()) {
                    for (int i = 0; i < c0586a.m5816a(); i++) {
                        if (c0586a.m5819b(i) == 16842767) {
                            int m5822d = c0586a.m5822d(i);
                            if (m5822d != 1 && m5822d != 2) {
                                if (m5822d == 3) {
                                    throw new C0579a("Unable to determine whether APK is debuggable: AndroidManifest.xml's android:debuggable attribute references a resource. References are not supported for security reasons. Only constant boolean, string and int values are supported.");
                                }
                                if (m5822d != 4) {
                                    throw new C0579a("Unable to determine whether APK is debuggable: AndroidManifest.xml's android:debuggable attribute uses unsupported value type. Only boolean, string and int values are supported.");
                                }
                            }
                            String m5821c = c0586a.m5821c(i);
                            return "true".equals(m5821c) || "TRUE".equals(m5821c) || "1".equals(m5821c);
                        }
                    }
                    return false;
                }
            }
            return false;
        } catch (C0586a.e e2) {
            throw new C0579a("Unable to determine whether APK is debuggable: malformed binary resource: AndroidManifest.xml", e2);
        }
    }

    /* renamed from: c */
    public static int m5775c(ByteBuffer byteBuffer) {
        try {
            return m5769a(byteBuffer, MANIFEST_ELEMENT_TAG, 16844108);
        } catch (C0579a e2) {
            return 1;
        }
    }

    /* renamed from: d */
    public static int m5776d(ByteBuffer byteBuffer) {
        try {
            return m5769a(byteBuffer, USES_SDK_ELEMENT_TAG, 16843376);
        } catch (C0579a e2) {
            byteBuffer.rewind();
            try {
                return m5774b(byteBuffer);
            } catch (C0579a e3) {
                return 1;
            }
        }
    }

    /* renamed from: a */
    private static int m5769a(ByteBuffer byteBuffer, String str, int i) {
        if (str == null) {
            throw new NullPointerException("elementName cannot be null");
        }
        try {
            C0586a c0586a = new C0586a(byteBuffer);
            for (int m5820c = c0586a.m5820c(); m5820c != 2; m5820c = c0586a.m5825f()) {
                if (m5820c == 3 && str.equals(c0586a.m5823d())) {
                    for (int i2 = 0; i2 < c0586a.m5816a(); i2++) {
                        if (c0586a.m5819b(i2) == i) {
                            int m5822d = c0586a.m5822d(i2);
                            if (m5822d == 1 || m5822d == 2) {
                                return c0586a.m5817a(i2);
                            }
                            throw new C0579a("Unsupported value type, " + m5822d + ", for attribute " + String.format("0x%08X", Integer.valueOf(i)) + " under element " + str);
                        }
                    }
                }
            }
            throw new C0579a("Failed to determine APK's " + str + " attribute " + String.format("0x%08X", Integer.valueOf(i)) + " value");
        } catch (C0586a.e e2) {
            throw new C0579a("Unable to determine value for attribute " + String.format("0x%08X", Integer.valueOf(i)) + " under element " + str + "; malformed binary resource: " + ANDROID_MANIFEST_ZIP_ENTRY_NAME, e2);
        }
    }

    /* renamed from: a */
    public static byte[] m5773a(byte[] bArr) {
        return C0582d.m5787a(bArr);
    }
}
