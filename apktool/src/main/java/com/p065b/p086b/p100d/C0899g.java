package com.p065b.p086b.p100d;

import android.security.keystore.KeyProperties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

/* compiled from: DexHasher.java */
/* renamed from: com.b.b.d.g */
/* loaded from: classes.dex */
public final class C0899g {
    /* renamed from: a */
    public byte[] m7652a(C0898f c0898f) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyProperties.DIGEST_SHA1);
            byte[] m7601d = c0898f.m7601d();
            messageDigest.update(m7601d, 32, m7601d.length - 32);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError();
        }
    }

    /* renamed from: b */
    public int m7653b(C0898f c0898f) {
        Adler32 adler32 = new Adler32();
        byte[] m7601d = c0898f.m7601d();
        adler32.update(m7601d, 12, m7601d.length - 12);
        return (int) adler32.getValue();
    }

    /* renamed from: c */
    public void m7654c(C0898f c0898f) {
        c0898f.m7595a(12).m7625a(m7652a(c0898f));
        c0898f.m7595a(8).m7635e(m7653b(c0898f));
    }
}
