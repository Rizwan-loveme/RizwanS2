package com.p065b.p066a.p067a;

import android.security.keystore.KeyProperties;
import com.p065b.p066a.p068b.p081g.C0652k;
import com.p065b.p066a.p068b.p083i.AbstractC0667d;
import com.p065b.p066a.p084c.InterfaceC0671c;
import com.p065b.p066a.p085d.C0676a;
import com.p065b.p066a.p085d.C0677b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ApkUtilsLite.java */
/* renamed from: com.b.a.a.d */
/* loaded from: classes.dex */
public class C0582d {
    private static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    private static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    private static final int APK_SIG_BLOCK_MIN_SIZE = 32;

    private C0582d() {
    }

    /* renamed from: a */
    public static C0677b m5786a(InterfaceC0671c interfaceC0671c) {
        C0652k<ByteBuffer, Long> m6312a = AbstractC0667d.m6312a(interfaceC0671c);
        if (m6312a == null) {
            throw new C0676a("ZIP End of Central Directory record not found");
        }
        ByteBuffer m6251a = m6312a.m6251a();
        long longValue = m6312a.m6252b().longValue();
        m6251a.order(ByteOrder.LITTLE_ENDIAN);
        long m6325e = AbstractC0667d.m6325e(m6251a);
        if (m6325e > longValue) {
            throw new C0676a("ZIP Central Directory start offset out of range: " + m6325e + ". ZIP End of Central Directory offset: " + longValue);
        }
        long m6326f = AbstractC0667d.m6326f(m6251a);
        long j = m6325e + m6326f;
        if (j > longValue) {
            throw new C0676a("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + longValue);
        }
        return new C0677b(m6325e, m6326f, AbstractC0667d.m6327g(m6251a), longValue, m6251a);
    }

    /* renamed from: a */
    public static a m5785a(InterfaceC0671c interfaceC0671c, C0677b c0677b) {
        long m6355a = c0677b.m6355a();
        long m6357c = c0677b.m6357c() + m6355a;
        long m6359e = c0677b.m6359e();
        if (m6357c != m6359e) {
            throw new C0580b("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + m6357c + ", EoCD start: " + m6359e);
        }
        if (m6355a < 32) {
            throw new C0580b("APK too small for APK Signing Block. ZIP Central Directory offset: " + m6355a);
        }
        ByteBuffer mo6235a = interfaceC0671c.mo6235a(m6355a - 24, 24);
        mo6235a.order(ByteOrder.LITTLE_ENDIAN);
        if (mo6235a.getLong(8) != APK_SIG_BLOCK_MAGIC_LO || mo6235a.getLong(16) != APK_SIG_BLOCK_MAGIC_HI) {
            throw new C0580b("No APK Signing Block before ZIP Central Directory");
        }
        long j = mo6235a.getLong(0);
        if (j < mo6235a.capacity() || j > 2147483639) {
            throw new C0580b("APK Signing Block size out of range: " + j);
        }
        long j2 = (int) (8 + j);
        long j3 = m6355a - j2;
        if (j3 < 0) {
            throw new C0580b("APK Signing Block offset out of range: " + j3);
        }
        ByteBuffer mo6235a2 = interfaceC0671c.mo6235a(j3, 8);
        mo6235a2.order(ByteOrder.LITTLE_ENDIAN);
        long j4 = mo6235a2.getLong(0);
        if (j4 != j) {
            throw new C0580b("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
        }
        return new a(j3, interfaceC0671c.mo6238b(j3, j2));
    }

    /* compiled from: ApkUtilsLite.java */
    /* renamed from: com.b.a.a.d$a */
    public static class a {

        /* renamed from: a */
        private final InterfaceC0671c f3971a;

        /* renamed from: b */
        private final long f3972b;

        public a(long j, InterfaceC0671c interfaceC0671c) {
            this.f3972b = j;
            this.f3971a = interfaceC0671c;
        }

        /* renamed from: b */
        public long m5789b() {
            return this.f3972b;
        }

        /* renamed from: a */
        public InterfaceC0671c m5788a() {
            return this.f3971a;
        }
    }

    /* renamed from: a */
    public static byte[] m5787a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyProperties.DIGEST_SHA256);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("SHA-256 is not found", e2);
        }
    }
}
