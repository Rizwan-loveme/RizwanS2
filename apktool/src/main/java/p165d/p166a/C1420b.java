package p165d.p166a;

import java.p209io.OutputStream;
import java.p209io.PrintStream;

/* compiled from: HexDumpEncoder.java */
/* renamed from: d.a.b */
/* loaded from: classes.dex */
public class C1420b extends AbstractC1419a {

    /* renamed from: b */
    private int f9183b;

    /* renamed from: c */
    private int f9184c;

    /* renamed from: d */
    private byte[] f9185d = new byte[16];

    /* renamed from: e */
    private int f9186e;

    /* renamed from: a */
    static void m11238a(PrintStream printStream, byte b2) {
        char c2;
        char c3;
        char c4 = (char) ((b2 >> 4) & 15);
        if (c4 > '\t') {
            c2 = (char) ((c4 - '\n') + 65);
        } else {
            c2 = (char) (c4 + '0');
        }
        printStream.write(c2);
        char c5 = (char) (b2 & 15);
        if (c5 > '\t') {
            c3 = (char) ((c5 - '\n') + 65);
        } else {
            c3 = (char) (c5 + '0');
        }
        printStream.write(c3);
    }

    @Override // p165d.p166a.AbstractC1419a
    /* renamed from: a */
    protected int mo11226a() {
        return 1;
    }

    @Override // p165d.p166a.AbstractC1419a
    /* renamed from: b */
    protected int mo11233b() {
        return 16;
    }

    @Override // p165d.p166a.AbstractC1419a
    /* renamed from: a */
    protected void mo11230a(OutputStream outputStream) {
        this.f9184c = 0;
        super.mo11230a(outputStream);
    }

    @Override // p165d.p166a.AbstractC1419a
    /* renamed from: a */
    protected void mo11231a(OutputStream outputStream, int i) {
        m11238a(this.f9182a, (byte) ((this.f9184c >>> 8) & 255));
        m11238a(this.f9182a, (byte) (this.f9184c & 255));
        this.f9182a.print(": ");
        this.f9183b = 0;
        this.f9186e = i;
    }

    @Override // p165d.p166a.AbstractC1419a
    /* renamed from: a */
    protected void mo11232a(OutputStream outputStream, byte[] bArr, int i, int i2) {
        this.f9185d[this.f9183b] = bArr[i];
        m11238a(this.f9182a, bArr[i]);
        this.f9182a.print(" ");
        this.f9183b++;
        if (this.f9183b == 8) {
            this.f9182a.print("  ");
        }
    }

    @Override // p165d.p166a.AbstractC1419a
    /* renamed from: c */
    protected void mo11237c(OutputStream outputStream) {
        if (this.f9186e < 16) {
            for (int i = this.f9186e; i < 16; i++) {
                this.f9182a.print("   ");
                if (i == 7) {
                    this.f9182a.print("  ");
                }
            }
        }
        this.f9182a.print(" ");
        for (int i2 = 0; i2 < this.f9186e; i2++) {
            if (this.f9185d[i2] < 32 || this.f9185d[i2] > 122) {
                this.f9182a.print(".");
            } else {
                this.f9182a.write(this.f9185d[i2]);
            }
        }
        this.f9182a.println();
        this.f9184c += this.f9186e;
    }
}
