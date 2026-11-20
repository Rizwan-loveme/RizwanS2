package org.p210a.p211a.p212a;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import org.p210a.p211a.p212a.p215c.C1839i;

/* compiled from: ANTLRInputStream.java */
/* renamed from: org.a.a.a.c */
/* loaded from: classes.dex */
public class C1830c implements InterfaceC1858f {

    /* renamed from: d */
    static final /* synthetic */ boolean f10872d;

    /* renamed from: a */
    protected char[] f10873a;

    /* renamed from: b */
    protected int f10874b;

    /* renamed from: c */
    protected int f10875c;

    static {
        f10872d = !C1830c.class.desiredAssertionStatus();
    }

    public C1830c() {
        this.f10875c = 0;
    }

    public C1830c(String str) {
        this.f10875c = 0;
        this.f10873a = str.toCharArray();
        this.f10874b = str.length();
    }

    public C1830c(Reader reader, int i) {
        this(reader, i, 1024);
    }

    public C1830c(Reader reader, int i, int i2) {
        this.f10875c = 0;
        m13714a(reader, i, i2);
    }

    public C1830c(InputStream inputStream) {
        this(new InputStreamReader(inputStream), 1024);
    }

    /* renamed from: a */
    public void m13714a(Reader reader, int i, int i2) {
        int read;
        if (reader != null) {
            if (i <= 0) {
                i = 1024;
            }
            if (i2 <= 0) {
                i2 = 1024;
            }
            try {
                this.f10873a = new char[i];
                int i3 = 0;
                do {
                    if (i3 + i2 > this.f10873a.length) {
                        this.f10873a = Arrays.copyOf(this.f10873a, this.f10873a.length * 2);
                    }
                    read = reader.read(this.f10873a, i3, i2);
                    i3 += read;
                } while (read != -1);
                this.f10874b = i3 + 1;
            } finally {
                reader.close();
            }
        }
    }

    /* renamed from: a */
    public void m13713a() {
        this.f10875c = 0;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: b */
    public void mo13715b() {
        if (this.f10875c >= this.f10874b) {
            if (!f10872d && mo13711a(1) != -1) {
                throw new AssertionError();
            }
            throw new IllegalStateException("cannot consume EOF");
        }
        if (this.f10875c < this.f10874b) {
            this.f10875c++;
        }
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: a */
    public int mo13711a(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 0) {
            i++;
            if ((this.f10875c + i) - 1 < 0) {
                return -1;
            }
        }
        if ((this.f10875c + i) - 1 < this.f10874b) {
            return this.f10873a[(this.f10875c + i) - 1];
        }
        return -1;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: c */
    public int mo13717c() {
        return this.f10875c;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: d */
    public int mo13719d() {
        return this.f10874b;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: e */
    public int mo13720e() {
        return -1;
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: b */
    public void mo13716b(int i) {
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1869q
    /* renamed from: c */
    public void mo13718c(int i) {
        if (i <= this.f10875c) {
            this.f10875c = i;
            return;
        }
        int min = Math.min(i, this.f10874b);
        while (this.f10875c < min) {
            mo13715b();
        }
    }

    @Override // org.p210a.p211a.p212a.InterfaceC1858f
    /* renamed from: a */
    public String mo13712a(C1839i c1839i) {
        int i = c1839i.f10905c;
        int i2 = c1839i.f10906d;
        if (i2 >= this.f10874b) {
            i2 = this.f10874b - 1;
        }
        return i >= this.f10874b ? "" : new String(this.f10873a, i, (i2 - i) + 1);
    }

    public String toString() {
        return new String(this.f10873a);
    }
}
