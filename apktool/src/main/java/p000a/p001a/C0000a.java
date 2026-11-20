package p000a.p001a;

import android.media.session.PlaybackState;
import java.util.Arrays;

/* compiled from: BufferedRandomAccessFile.java */
/* renamed from: a.a.a */
/* loaded from: classes.dex */
public final class C0000a implements InterfaceC0004e {

    /* renamed from: a */
    private boolean f0a;

    /* renamed from: b */
    private boolean f1b;

    /* renamed from: c */
    private long f2c;

    /* renamed from: d */
    private long f3d;

    /* renamed from: e */
    private long f4e;

    /* renamed from: f */
    private byte[] f5f;

    /* renamed from: g */
    private long f6g;

    /* renamed from: h */
    private boolean f7h;

    /* renamed from: i */
    private long f8i;

    /* renamed from: j */
    private InterfaceC0001b f9j;

    /* renamed from: k */
    private long f10k = -1;

    C0000a(InterfaceC0001b interfaceC0001b) {
        this.f9j = interfaceC0001b;
        m1e();
    }

    /* renamed from: e */
    private void m1e() {
        this.f1b = false;
        this.f0a = false;
        long j = 0;
        this.f4e = j;
        this.f2c = j;
        this.f3d = j;
        this.f5f = new byte[131072];
        this.f6g = PlaybackState.ACTION_PREPARE_FROM_URI;
        this.f7h = false;
        this.f8i = 0L;
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: a */
    public void mo6a(int i) {
        if (this.f2c >= this.f4e) {
            if (this.f7h && this.f4e < this.f6g) {
                this.f4e++;
            } else {
                mo12b(this.f2c);
                if (this.f2c == this.f4e) {
                    this.f4e++;
                }
            }
        }
        this.f5f[(int) (this.f2c - this.f3d)] = (byte) i;
        this.f2c++;
        this.f0a = true;
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: a */
    public void mo8a(byte[] bArr) {
        mo9a(bArr, 0, bArr.length);
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: a */
    public void mo9a(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int m0c = m0c(bArr, i, i2);
            i += m0c;
            i2 -= m0c;
            this.f0a = true;
        }
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: a */
    public int mo5a() {
        if (this.f2c >= this.f4e) {
            if (this.f7h) {
                return -1;
            }
            mo12b(this.f2c);
            if (this.f2c == this.f4e) {
                return -1;
            }
        }
        byte b2 = this.f5f[(int) (this.f2c - this.f3d)];
        this.f2c++;
        return b2 & 255;
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: b */
    public int mo10b(byte[] bArr, int i, int i2) {
        if (this.f2c >= this.f4e) {
            if (this.f7h) {
                return -1;
            }
            mo12b(this.f2c);
            if (this.f2c == this.f4e) {
                return -1;
            }
        }
        int min = Math.min(i2, (int) (this.f4e - this.f2c));
        System.arraycopy(this.f5f, (int) (this.f2c - this.f3d), bArr, i, min);
        this.f2c += min;
        return min;
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: b */
    public long mo11b() {
        return Math.max(this.f2c, m2f());
    }

    /* renamed from: f */
    private long m2f() {
        if (this.f10k == -1) {
            this.f10k = this.f9j.mo16a();
        }
        return this.f10k;
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: a */
    public void mo7a(long j) {
        m3g();
        this.f9j.mo18b(j);
        this.f10k = j;
        if (this.f2c > j) {
            this.f2c = j;
        }
        if (this.f8i > j) {
            this.f9j.mo17a(j);
            this.f8i = j;
        }
        long j2 = 0;
        this.f4e = j2;
        this.f3d = j2;
        mo12b(this.f2c);
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: b */
    public void mo12b(long j) {
        if (j >= this.f4e || j < this.f3d) {
            m3g();
            this.f3d = (-131072) & j;
            this.f6g = this.f3d + this.f5f.length;
            if (this.f8i != this.f3d) {
                this.f9j.mo17a(this.f3d);
                this.f8i = this.f3d;
            }
            this.f4e = m4h() + this.f3d;
        } else if (j < this.f2c) {
            m3g();
        }
        this.f2c = j;
    }

    @Override // p000a.p001a.InterfaceC0004e
    /* renamed from: c */
    public long mo13c() {
        return this.f2c;
    }

    /* renamed from: d */
    public void m14d() {
        m3g();
    }

    @Override // java.p209io.Closeable, java.lang.AutoCloseable
    public void close() {
        m14d();
        this.f1b = true;
        this.f9j.close();
    }

    /* renamed from: g */
    private void m3g() {
        if (this.f0a) {
            if (this.f8i != this.f3d) {
                this.f9j.mo17a(this.f3d);
            }
            this.f9j.mo19b(this.f5f, 0, (int) (this.f2c - this.f3d));
            this.f8i = this.f2c;
            this.f0a = false;
            if (this.f10k == -1 || this.f8i <= this.f10k) {
                return;
            }
            this.f10k = -1;
        }
    }

    /* renamed from: h */
    private int m4h() {
        int length = this.f5f.length;
        int i = 0;
        while (length > 0) {
            int mo15a = this.f9j.mo15a(this.f5f, i, length);
            if (mo15a < 0) {
                break;
            }
            i += mo15a;
            length -= mo15a;
        }
        boolean z = i < this.f5f.length;
        this.f7h = z;
        if (z) {
            Arrays.fill(this.f5f, i, this.f5f.length, (byte) -1);
        }
        this.f8i += i;
        return i;
    }

    /* renamed from: c */
    private int m0c(byte[] bArr, int i, int i2) {
        if (this.f2c >= this.f4e) {
            if (this.f7h && this.f4e < this.f6g) {
                this.f4e = this.f6g;
            } else {
                mo12b(this.f2c);
                if (this.f2c == this.f4e) {
                    this.f4e = this.f6g;
                }
            }
        }
        int min = Math.min(i2, (int) (this.f4e - this.f2c));
        System.arraycopy(bArr, i, this.f5f, (int) (this.f2c - this.f3d), min);
        this.f2c += min;
        return min;
    }
}
