package com.p140g.p141a.p149f.p150a;

import android.widget.ExpandableListView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* compiled from: ZipFile.java */
/* renamed from: com.g.a.f.a.c */
/* loaded from: classes.dex */
public class C1291c implements AutoCloseable {

    /* renamed from: a */
    final ByteBuffer f8502a;

    /* renamed from: b */
    RandomAccessFile f8503b;

    /* renamed from: c */
    private List<C1290b> f8504c;

    /* renamed from: d */
    private String f8505d;

    public C1291c(ByteBuffer byteBuffer) {
        this.f8502a = byteBuffer.asReadOnlyBuffer().order(ByteOrder.LITTLE_ENDIAN);
        m10466b();
    }

    public C1291c(byte[] bArr) {
        this(ByteBuffer.wrap(bArr));
    }

    /* renamed from: a */
    public List<? extends C1290b> m10468a() {
        return this.f8504c;
    }

    /* renamed from: a */
    public long m10467a(C1290b c1290b) {
        int i = this.f8502a.getShort((int) (c1290b.f8501k + 26)) & 65535;
        return (this.f8502a.getShort((int) (c1290b.f8501k + 28)) & 65535) + c1290b.f8501k + 30 + i;
    }

    /* renamed from: b */
    public InputStream m10469b(C1290b c1290b) {
        ByteBuffer byteBuffer = (ByteBuffer) this.f8502a.duplicate().position((int) m10467a(c1290b));
        if (c1290b.f8496f == 0) {
            return new a((ByteBuffer) byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN).limit((int) c1290b.f8495e));
        }
        ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.slice().order(ByteOrder.LITTLE_ENDIAN).limit((int) c1290b.f8494d);
        return new b(new a(byteBuffer2), new Inflater(true), Math.max(1024, (int) Math.min(c1290b.m10463b(), 65535L)), c1290b);
    }

    /* renamed from: a */
    static void m10465a(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* renamed from: b */
    private void m10466b() {
        ByteBuffer byteBuffer = this.f8502a;
        long limit = byteBuffer.limit() - 22;
        if (limit < 0) {
            throw new ZipException(new StringBuffer().append("File too short to be a zip file: ").append(byteBuffer.limit()).toString());
        }
        long j = limit - 65536;
        if (j < 0) {
            j = 0;
        }
        do {
            byteBuffer.position((int) limit);
            if (byteBuffer.getInt() == 101010256) {
                int i = byteBuffer.getShort() & 65535;
                int i2 = byteBuffer.getShort() & 65535;
                int i3 = byteBuffer.getShort() & 65535;
                int i4 = byteBuffer.getShort() & 65535;
                m10465a(byteBuffer, 4);
                long j2 = byteBuffer.getInt() & ExpandableListView.PACKED_POSITION_VALUE_NULL;
                int i5 = byteBuffer.getShort() & 65535;
                if (i3 != i4 || i != 0 || i2 != 0) {
                    throw new ZipException("Spanned archives not supported");
                }
                if (i5 > 0) {
                    if (i5 > byteBuffer.remaining()) {
                        System.err.println("WARN: the zip comment exceed the zip content");
                    } else {
                        m10465a(byteBuffer, i5);
                    }
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN).position((int) j2);
                this.f8504c = new ArrayList(i3);
                for (int i6 = 0; i6 < i3; i6++) {
                    C1290b c1290b = new C1290b(byteBuffer2, true);
                    if (c1290b.f8501k < j2) {
                        this.f8504c.add(c1290b);
                    }
                }
                return;
            }
            limit--;
        } while (limit >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    /* renamed from: a */
    static void m10464a(String str, int i) {
        throw new ZipException(new StringBuffer().append(new StringBuffer().append(str).append(" signature not found; was ").toString()).append(String.format("0x%08x", new Integer(i))).toString());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.f8503b != null) {
            this.f8503b.close();
        }
    }

    /* compiled from: ZipFile.java */
    /* renamed from: com.g.a.f.a.c$b */
    static class b extends InflaterInputStream {

        /* renamed from: a */
        private final C1290b f8507a;

        /* renamed from: b */
        private long f8508b;

        public b(InputStream inputStream, Inflater inflater, int i, C1290b c1290b) {
            super(inputStream, inflater, i);
            this.f8508b = 0;
            this.f8507a = c1290b;
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            try {
                int read = super.read(bArr, i, i2);
                if (read != -1) {
                    this.f8508b += read;
                } else if (this.f8507a.f8495e != this.f8508b) {
                    throw new IOException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Size mismatch on inflated file: ").append(this.f8508b).toString()).append(" vs ").toString()).append(this.f8507a.f8495e).toString());
                }
                return read;
            } catch (IOException e2) {
                throw new IOException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("Error reading data for ").append(this.f8507a.m10462a()).toString()).append(" near offset ").toString()).append(this.f8508b).toString(), e2);
            }
        }

        @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
        public int available() {
            if (super.available() == 0) {
                return 0;
            }
            return (int) (this.f8507a.m10463b() - this.f8508b);
        }
    }

    /* compiled from: ZipFile.java */
    /* renamed from: com.g.a.f.a.c$a */
    private static class a extends InputStream {

        /* renamed from: a */
        private final ByteBuffer f8506a;

        public a(ByteBuffer byteBuffer) {
            this.f8506a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f8506a.hasRemaining()) {
                return this.f8506a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!this.f8506a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, this.f8506a.remaining());
            this.f8506a.get(bArr, i, min);
            return min;
        }
    }
}
