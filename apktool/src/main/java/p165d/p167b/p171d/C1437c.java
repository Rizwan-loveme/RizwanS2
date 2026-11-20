package p165d.p167b.p171d;

import java.io.IOException;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.Arrays;
import p165d.p167b.p169b.C1425c;
import p165d.p167b.p169b.C1427e;
import p165d.p167b.p172e.C1450m;
import p165d.p167b.p172e.C1454q;
import p165d.p167b.p173f.C1505e;

/* compiled from: KeyProtector.java */
/* renamed from: d.b.d.c */
/* loaded from: classes.dex */
final class C1437c {

    /* renamed from: a */
    private MessageDigest f9318a;

    /* renamed from: b */
    private byte[] f9319b;

    public C1437c(char[] cArr) {
        int i = 0;
        if (cArr == null) {
            throw new IllegalArgumentException("password can't be null");
        }
        this.f9318a = MessageDigest.getInstance("SHA");
        this.f9319b = new byte[cArr.length * 2];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i3 < cArr.length) {
                int i4 = i2 + 1;
                this.f9319b[i2] = (byte) (cArr[i3] >> '\b');
                i2 = i4 + 1;
                this.f9319b[i4] = (byte) cArr[i3];
                i = i3 + 1;
            } else {
                return;
            }
        }
    }

    protected void finalize() {
        if (this.f9319b != null) {
            Arrays.fill(this.f9319b, (byte) 0);
            this.f9319b = null;
        }
    }

    /* renamed from: a */
    public byte[] m11310a(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("plaintext key can't be null");
        }
        if (!"PKCS#8".equalsIgnoreCase(key.getFormat())) {
            throw new KeyStoreException("Cannot get key bytes, not PKCS#8 encoded");
        }
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new KeyStoreException("Cannot get key bytes, encoding not supported");
        }
        int length = encoded.length / 20;
        if (encoded.length % 20 != 0) {
            length++;
        }
        byte[] bArr = new byte[20];
        new SecureRandom().nextBytes(bArr);
        byte[] bArr2 = new byte[encoded.length];
        int i = 0;
        int i2 = 0;
        byte[] bArr3 = bArr;
        while (i < length) {
            this.f9318a.update(this.f9319b);
            this.f9318a.update(bArr3);
            bArr3 = this.f9318a.digest();
            this.f9318a.reset();
            if (i < length - 1) {
                System.arraycopy(bArr3, 0, bArr2, i2, bArr3.length);
            } else {
                System.arraycopy(bArr3, 0, bArr2, i2, bArr2.length - i2);
            }
            i++;
            i2 += 20;
        }
        byte[] bArr4 = new byte[encoded.length];
        for (int i3 = 0; i3 < bArr4.length; i3++) {
            bArr4[i3] = (byte) (encoded[i3] ^ bArr2[i3]);
        }
        byte[] bArr5 = new byte[bArr.length + bArr4.length + 20];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        int length2 = bArr.length + 0;
        System.arraycopy(bArr4, 0, bArr5, length2, bArr4.length);
        int length3 = bArr4.length;
        this.f9318a.update(this.f9319b);
        Arrays.fill(this.f9319b, (byte) 0);
        this.f9319b = null;
        this.f9318a.update(encoded);
        byte[] digest = this.f9318a.digest();
        this.f9318a.reset();
        System.arraycopy(digest, 0, bArr5, length3 + length2, digest.length);
        try {
            return new C1425c(new C1505e(new C1454q("1.3.6.1.4.1.42.2.17.1.1")), bArr5).m11247b();
        } catch (IOException e2) {
            throw new KeyStoreException(e2.getMessage());
        }
    }

    /* renamed from: a */
    public Key m11309a(C1425c c1425c) {
        if (!c1425c.m11246a().m11643e().toString().equals("1.3.6.1.4.1.42.2.17.1.1")) {
            throw new UnrecoverableKeyException("Unsupported key protection algorithm");
        }
        byte[] m11248c = c1425c.m11248c();
        byte[] bArr = new byte[20];
        System.arraycopy(m11248c, 0, bArr, 0, 20);
        int length = (m11248c.length - 20) - 20;
        int i = length / 20;
        if (length % 20 != 0) {
            i++;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(m11248c, 20, bArr2, 0, length);
        byte[] bArr3 = new byte[bArr2.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            this.f9318a.update(this.f9319b);
            this.f9318a.update(bArr);
            bArr = this.f9318a.digest();
            this.f9318a.reset();
            if (i2 < i - 1) {
                System.arraycopy(bArr, 0, bArr3, i3, bArr.length);
            } else {
                System.arraycopy(bArr, 0, bArr3, i3, bArr3.length - i3);
            }
            i2++;
            i3 += 20;
        }
        byte[] bArr4 = new byte[bArr2.length];
        for (int i4 = 0; i4 < bArr4.length; i4++) {
            bArr4[i4] = (byte) (bArr2[i4] ^ bArr3[i4]);
        }
        this.f9318a.update(this.f9319b);
        Arrays.fill(this.f9319b, (byte) 0);
        this.f9319b = null;
        this.f9318a.update(bArr4);
        byte[] digest = this.f9318a.digest();
        this.f9318a.reset();
        for (int i5 = 0; i5 < digest.length; i5++) {
            if (digest[i5] != m11248c[length + 20 + i5]) {
                throw new UnrecoverableKeyException("Cannot recover key");
            }
        }
        try {
            return C1427e.m11262a(new C1450m(bArr4));
        } catch (IOException e2) {
            throw new UnrecoverableKeyException(e2.getMessage());
        }
    }
}
