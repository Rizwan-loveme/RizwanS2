package ru.maximoff.apktool.util;

import java.p209io.FilterInputStream;
import java.p209io.IOException;
import java.p209io.InputStream;

/* compiled from: ReplacingInputStream.java */
/* renamed from: ru.maximoff.apktool.util.az */
/* loaded from: classes.dex */
public class C3094az extends FilterInputStream {

    /* renamed from: a */
    int[] f18188a;

    /* renamed from: b */
    int f18189b;

    /* renamed from: c */
    int f18190c;

    /* renamed from: d */
    int f18191d;

    /* renamed from: e */
    private final byte[] f18192e;

    /* renamed from: f */
    private final byte[] f18193f;

    /* renamed from: g */
    private a f18194g;

    /* compiled from: ReplacingInputStream.java */
    /* renamed from: ru.maximoff.apktool.util.az$a */
    private enum a {
        NOT_MATCHED,
        MATCHING,
        REPLACING,
        UNBUFFER;

        public static a valueOf(String str) {
            for (a aVar : values()) {
                if (aVar.name().equals(str)) {
                    return aVar;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public C3094az(InputStream inputStream, String str, String str2) {
        this(inputStream, str.getBytes("UTF-8"), str2 == null ? (byte[]) null : str2.getBytes("UTF-8"));
    }

    public C3094az(InputStream inputStream, byte[] bArr, byte[] bArr2) {
        super(inputStream);
        this.f18188a = (int[]) null;
        this.f18189b = 0;
        this.f18190c = 0;
        this.f18191d = 0;
        this.f18194g = a.NOT_MATCHED;
        this.f18192e = bArr;
        this.f18193f = bArr2;
        this.f18188a = new int[bArr.length];
    }

    @Override // java.p209io.FilterInputStream, java.p209io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        bArr[i] = (byte) read;
        int i3 = 1;
        while (i3 < i2) {
            try {
                int read2 = read();
                if (read2 == -1) {
                    break;
                }
                bArr[i + i3] = (byte) read2;
                i3++;
            } catch (IOException e2) {
            }
        }
        return i3;
    }

    @Override // java.p209io.FilterInputStream, java.p209io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.p209io.FilterInputStream, java.p209io.InputStream
    public int read() {
        a aVar = this.f18194g;
        if (aVar == a.NOT_MATCHED) {
            int read = super.read();
            if (this.f18192e[0] == read) {
                this.f18188a = new int[this.f18192e.length];
                this.f18189b = 0;
                int[] iArr = this.f18188a;
                int i = this.f18189b;
                this.f18189b = i + 1;
                iArr[i] = read;
                if (this.f18192e.length == 1) {
                    this.f18194g = a.REPLACING;
                    this.f18191d = 0;
                } else {
                    this.f18194g = a.MATCHING;
                }
                return read();
            }
            return read;
        }
        if (aVar == a.MATCHING) {
            int read2 = super.read();
            if (this.f18192e[this.f18189b] == read2) {
                int[] iArr2 = this.f18188a;
                int i2 = this.f18189b;
                this.f18189b = i2 + 1;
                iArr2[i2] = read2;
                if (this.f18189b == this.f18192e.length) {
                    if (this.f18193f == null || this.f18193f.length == 0) {
                        this.f18194g = a.NOT_MATCHED;
                        this.f18189b = 0;
                    } else {
                        this.f18194g = a.REPLACING;
                        this.f18191d = 0;
                    }
                }
            } else {
                int[] iArr3 = this.f18188a;
                int i3 = this.f18189b;
                this.f18189b = i3 + 1;
                iArr3[i3] = read2;
                this.f18194g = a.UNBUFFER;
                this.f18190c = 0;
            }
            return read();
        }
        if (aVar == a.REPLACING) {
            byte[] bArr = this.f18193f;
            int i4 = this.f18191d;
            this.f18191d = i4 + 1;
            byte b2 = bArr[i4];
            if (this.f18191d == this.f18193f.length) {
                this.f18194g = a.NOT_MATCHED;
                this.f18191d = 0;
                return b2;
            }
            return b2;
        }
        if (aVar == a.UNBUFFER) {
            int[] iArr4 = this.f18188a;
            int i5 = this.f18190c;
            this.f18190c = i5 + 1;
            int i6 = iArr4[i5];
            if (this.f18190c == this.f18189b) {
                this.f18194g = a.NOT_MATCHED;
                this.f18189b = 0;
                return i6;
            }
            return i6;
        }
        throw new IllegalStateException(new StringBuffer().append("No such state ").append(this.f18194g).toString());
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18194g.name()).append(" ").toString()).append(this.f18189b).toString()).append(" ").toString()).append(this.f18191d).toString()).append(" ").toString()).append(this.f18190c).toString();
    }
}
