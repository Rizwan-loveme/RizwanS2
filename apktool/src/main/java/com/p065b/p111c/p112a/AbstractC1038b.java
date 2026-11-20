package com.p065b.p111c.p112a;

import android.telephony.PhoneNumberUtils;
import com.p065b.p111c.p113b.p114a.C1042a;
import com.p065b.p111c.p113b.p118c.C1059g;
import com.p065b.p111c.p113b.p119d.AbstractC1065d;
import com.p065b.p111c.p120c.InterfaceC1069c;
import com.p065b.p111c.p121d.C1072a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: ApkUtils.java */
/* renamed from: com.b.c.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC1038b {
    /* renamed from: a */
    public static c m8625a(InterfaceC1069c interfaceC1069c) {
        C1059g<ByteBuffer, Long> m8894a = AbstractC1065d.m8894a(interfaceC1069c);
        if (m8894a == null) {
            throw new C1072a("ZIP End of Central Directory record not found");
        }
        ByteBuffer m8852a = m8894a.m8852a();
        long longValue = m8894a.m8853b().longValue();
        m8852a.order(ByteOrder.LITTLE_ENDIAN);
        long m8906e = AbstractC1065d.m8906e(m8852a);
        if (m8906e > longValue) {
            throw new C1072a("ZIP Central Directory start offset out of range: " + m8906e + ". ZIP End of Central Directory offset: " + longValue);
        }
        long m8907f = AbstractC1065d.m8907f(m8852a);
        long j = m8906e + m8907f;
        if (j > longValue) {
            throw new C1072a("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + longValue);
        }
        return new c(m8906e, m8907f, AbstractC1065d.m8908g(m8852a), longValue, m8852a);
    }

    /* compiled from: ApkUtils.java */
    /* renamed from: com.b.c.a.b$c */
    public static class c {

        /* renamed from: a */
        private final long f6541a;

        /* renamed from: b */
        private final int f6542b;

        /* renamed from: c */
        private final long f6543c;

        /* renamed from: d */
        private final ByteBuffer f6544d;

        /* renamed from: e */
        private final long f6545e;

        public c(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
            this.f6541a = j;
            this.f6543c = j2;
            this.f6542b = i;
            this.f6545e = j3;
            this.f6544d = byteBuffer;
        }

        /* renamed from: a */
        public long m8629a() {
            return this.f6541a;
        }

        /* renamed from: c */
        public long m8631c() {
            return this.f6543c;
        }

        /* renamed from: b */
        public int m8630b() {
            return this.f6542b;
        }

        /* renamed from: e */
        public long m8633e() {
            return this.f6545e;
        }

        /* renamed from: d */
        public ByteBuffer m8632d() {
            return this.f6544d;
        }
    }

    /* renamed from: a */
    public static int m8624a(ByteBuffer byteBuffer) {
        int i;
        if (byteBuffer == null) {
            return 14;
        }
        try {
            C1042a c1042a = new C1042a(byteBuffer);
            int i2 = 1;
            for (int m8661c = c1042a.m8661c(); m8661c != 2; m8661c = c1042a.m8666f()) {
                if (m8661c == 3 && c1042a.m8659b() == 2 && "uses-sdk".equals(c1042a.m8664d()) && c1042a.m8665e().isEmpty()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= c1042a.m8657a()) {
                            i = 1;
                        } else if (c1042a.m8660b(i3) != 16843276) {
                            i3++;
                        } else {
                            switch (c1042a.m8663d(i3)) {
                                case 1:
                                    i = m8623a(c1042a.m8662c(i3));
                                    break;
                                case 2:
                                    i = c1042a.m8658a(i3);
                                    break;
                                default:
                                    throw new C1040d("Unable to determine APK's minimum supported Android: unsupported value type in AndroidManifest.xml's minSdkVersion. Only integer values supported.");
                            }
                        }
                    }
                    i2 = Math.max(i2, i);
                }
            }
            return i2;
        } catch (C1042a.e e2) {
            throw new C1040d("Unable to determine APK's minimum supported Android platform version: malformed binary resource: AndroidManifest.xml", e2);
        }
    }

    /* compiled from: ApkUtils.java */
    /* renamed from: com.b.c.a.b$a */
    private static class a {

        /* renamed from: b */
        private static final C1059g<Character, Integer>[] f6540b = {C1059g.m8851a('C', 2), C1059g.m8851a('D', 3), C1059g.m8851a('E', 4), C1059g.m8851a('F', 7), C1059g.m8851a('G', 8), C1059g.m8851a('H', 10), C1059g.m8851a('I', 13), C1059g.m8851a('J', 15), C1059g.m8851a('K', 18), C1059g.m8851a('L', 20), C1059g.m8851a('M', 22), C1059g.m8851a(Character.valueOf(PhoneNumberUtils.WILD), 23), C1059g.m8851a('O', 25)};

        /* renamed from: a */
        private static final Comparator<C1059g<Character, Integer>> f6539a = new b(null);
    }

    /* compiled from: ApkUtils.java */
    /* renamed from: com.b.c.a.b$b */
    private static class b implements Comparator<C1059g<Character, Integer>> {
        private b() {
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1059g<Character, Integer> c1059g, C1059g<Character, Integer> c1059g2) {
            return c1059g.m8852a().charValue() - c1059g2.m8852a().charValue();
        }
    }

    /* renamed from: a */
    static int m8623a(String str) {
        char charAt = str.isEmpty() ? ' ' : str.charAt(0);
        if (charAt >= 'A' && charAt <= 'Z') {
            C1059g[] c1059gArr = a.f6540b;
            int binarySearch = Arrays.binarySearch(c1059gArr, C1059g.m8851a(Character.valueOf(charAt), null), a.f6539a);
            if (binarySearch >= 0) {
                return ((Integer) c1059gArr[binarySearch].m8853b()).intValue();
            }
            int i = (-1) - binarySearch;
            if (i == 0) {
                return 1;
            }
            C1059g c1059g = c1059gArr[i - 1];
            return ((Integer) c1059g.m8853b()).intValue() + (charAt - ((Character) c1059g.m8852a()).charValue());
        }
        throw new C1039c("Unable to determine APK's minimum supported Android platform version : Unsupported codename in AndroidManifest.xml's minSdkVersion: \"" + str + "\"", str);
    }
}
