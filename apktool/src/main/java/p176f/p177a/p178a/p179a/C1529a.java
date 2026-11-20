package p176f.p177a.p178a.p179a;

import java.lang.reflect.Field;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: LEDataInputStream.java */
/* renamed from: f.a.a.a.a */
/* loaded from: classes.dex */
public class C1529a {

    /* renamed from: b */
    public long f9776b;

    /* renamed from: c */
    private DataInputStream f9777c;

    /* renamed from: d */
    private InputStream f9778d;

    /* renamed from: e */
    private boolean f9779e = true;

    /* renamed from: a */
    protected byte[] f9775a = new byte[8];

    public C1529a(InputStream inputStream) {
        this.f9778d = inputStream;
        this.f9777c = new DataInputStream(this.f9778d);
        this.f9776b = inputStream.available();
    }

    /* renamed from: a */
    public void m11733a() {
        this.f9777c.close();
        this.f9778d.close();
    }

    /* renamed from: b */
    public byte m11739b() {
        return this.f9777c.readByte();
    }

    /* renamed from: a */
    public void m11736a(byte[] bArr) {
        this.f9777c.readFully(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void m11737a(byte[] bArr, int i, int i2) {
        this.f9777c.readFully(bArr, i, i2);
    }

    /* renamed from: c */
    public int m11740c() {
        if (!this.f9779e) {
            return this.f9777c.readInt();
        }
        this.f9777c.readFully(this.f9775a, 0, 4);
        return (this.f9775a[3] << 24) | ((this.f9775a[2] & 255) << 16) | ((this.f9775a[1] & 255) << 8) | (this.f9775a[0] & 255);
    }

    /* renamed from: a */
    public int[] m11738a(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = m11740c();
        }
        return iArr;
    }

    /* renamed from: d */
    public final long m11741d() {
        if (!this.f9779e) {
            return this.f9777c.readLong();
        }
        this.f9777c.readFully(this.f9775a, 0, 8);
        return (this.f9775a[7] << 56) | ((this.f9775a[6] & 255) << 48) | ((this.f9775a[5] & 255) << 40) | ((this.f9775a[4] & 255) << 32) | ((this.f9775a[3] & 255) << 24) | ((this.f9775a[2] & 255) << 16) | ((this.f9775a[1] & 255) << 8) | (this.f9775a[0] & 255);
    }

    /* renamed from: e */
    public short m11742e() {
        if (!this.f9779e) {
            return this.f9777c.readShort();
        }
        this.f9777c.readFully(this.f9775a, 0, 2);
        return (short) (((this.f9775a[1] & 255) << 8) | (this.f9775a[0] & 255));
    }

    /* renamed from: a */
    public void m11734a(long j) {
        if (this.f9778d instanceof ByteArrayInputStream) {
            try {
                try {
                    Field declaredField = Class.forName("java.io.ByteArrayInputStream").getDeclaredField("pos");
                    declaredField.setAccessible(true);
                    declaredField.setInt(this.f9778d, (int) j);
                    return;
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e2) {
                    e2.printStackTrace();
                    throw new IOException("Unsupported");
                }
            } catch (ClassNotFoundException e3) {
                throw new NoClassDefFoundError(e3.getMessage());
            }
        }
        throw new IOException("Unsupported");
    }

    /* renamed from: a */
    public void m11735a(boolean z) {
        this.f9779e = z;
    }
}
