package p165d.p167b.p173f;

import java.p209io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;
import p165d.p166a.C1420b;
import p165d.p167b.p172e.C1449l;
import p165d.p167b.p172e.C1450m;

/* compiled from: KeyIdentifier.java */
/* renamed from: d.b.f.as */
/* loaded from: classes.dex */
public class C1474as {

    /* renamed from: a */
    private byte[] f9433a;

    public C1474as(byte[] bArr) {
        this.f9433a = (byte[]) bArr.clone();
    }

    public C1474as(C1450m c1450m) {
        this.f9433a = c1450m.m11432m();
    }

    public C1474as(PublicKey publicKey) {
        C1450m c1450m = new C1450m(publicKey.getEncoded());
        if (c1450m.f9357c != 48) {
            throw new IOException("PublicKey value is not a valid X.509 public key");
        }
        C1505e.m11630a(c1450m.f9356b.m11371d());
        byte[] m11323c = c1450m.f9356b.m11379k().m11323c();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(m11323c);
            this.f9433a = messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            throw new IOException("SHA1 not supported");
        }
    }

    /* renamed from: a */
    public byte[] m11512a() {
        return (byte[]) this.f9433a.clone();
    }

    public String toString() {
        return String.valueOf(String.valueOf("KeyIdentifier [\n") + new C1420b().m11234b(this.f9433a)) + "]\n";
    }

    /* renamed from: a */
    void m11511a(C1449l c1449l) {
        c1449l.m11405b(this.f9433a);
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.f9433a.length) {
                i = (this.f9433a[i2] * i2) + i3;
                i2++;
            } else {
                return i3;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1474as)) {
            return false;
        }
        return Arrays.equals(this.f9433a, ((C1474as) obj).f9433a);
    }
}
