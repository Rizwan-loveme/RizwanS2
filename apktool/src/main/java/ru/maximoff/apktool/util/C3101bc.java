package ru.maximoff.apktool.util;

import java.p209io.ByteArrayInputStream;
import java.p209io.Closeable;
import java.p209io.DataInputStream;
import java.p209io.File;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: SecureContainer.java */
/* renamed from: ru.maximoff.apktool.util.bc */
/* loaded from: classes.dex */
public final class C3101bc implements Closeable {

    /* renamed from: a */
    private final File f18256a;

    /* renamed from: b */
    private final RandomAccessFile f18257b;

    /* renamed from: c */
    private final long f18258c;

    /* renamed from: d */
    private final Map<String, a> f18259d = new LinkedHashMap();

    /* compiled from: SecureContainer.java */
    /* renamed from: ru.maximoff.apktool.util.bc$a */
    private static class a {

        /* renamed from: a */
        long f18260a;

        /* renamed from: b */
        long f18261b;
    }

    public C3101bc(File file) {
        this.f18256a = file;
        this.f18257b = new RandomAccessFile(file, "r");
        this.f18257b.seek(this.f18257b.length() - 32);
        if (this.f18257b.readLong() != 8305568261799555121L) {
            throw new IOException("Invalid container");
        }
        long readLong = this.f18257b.readLong();
        long readLong2 = this.f18257b.readLong();
        this.f18258c = this.f18257b.readLong();
        byte[] bArr = new byte[(int) readLong2];
        this.f18257b.seek(readLong);
        this.f18257b.readFully(bArr);
        m18898a(bArr, readLong ^ this.f18258c);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readInt = dataInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            byte[] bArr2 = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr2);
            String str = new String(bArr2, "UTF-8");
            a aVar = new a();
            aVar.f18260a = dataInputStream.readLong();
            aVar.f18261b = dataInputStream.readLong();
            this.f18259d.put(str, aVar);
        }
        dataInputStream.close();
    }

    /* renamed from: a */
    public InputStream m18903a(String str) {
        a aVar = this.f18259d.get(str);
        if (aVar == null) {
            throw new IOException(new StringBuffer().append("Entry not found: ").append(str).toString());
        }
        return new b(this.f18256a, aVar.f18260a, aVar.f18261b, this.f18258c);
    }

    /* renamed from: a */
    public File m18902a() {
        return this.f18256a;
    }

    @Override // java.p209io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18257b.close();
    }

    /* compiled from: SecureContainer.java */
    /* renamed from: ru.maximoff.apktool.util.bc$b */
    private static class b extends InputStream {

        /* renamed from: a */
        private final RandomAccessFile f18262a;

        /* renamed from: b */
        private final long f18263b;

        /* renamed from: c */
        private long f18264c;

        b(File file, long j, long j2, long j3) {
            this.f18262a = new RandomAccessFile(file, "r");
            this.f18262a.seek(j);
            this.f18263b = j + j2;
            this.f18264c = j3 ^ j;
        }

        @Override // java.p209io.InputStream
        public int read() {
            int read;
            if (this.f18262a.getFilePointer() >= this.f18263b || (read = this.f18262a.read()) < 0) {
                return -1;
            }
            this.f18264c = C3101bc.m18899b(this.f18264c);
            return (((int) this.f18264c) ^ read) & 255;
        }

        @Override // java.p209io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            long filePointer = this.f18263b - this.f18262a.getFilePointer();
            if (filePointer <= 0) {
                return -1;
            }
            int read = this.f18262a.read(bArr, i, (int) Math.min(i2, filePointer));
            if (read > 0) {
                C3101bc.m18901b(bArr, i, read, this.f18264c);
                this.f18264c = C3101bc.m18900b(this.f18264c, read);
                return read;
            }
            return read;
        }

        @Override // java.p209io.InputStream, java.p209io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18262a.close();
        }
    }

    /* renamed from: a */
    private static void m18898a(byte[] bArr, long j) {
        for (int i = 0; i < bArr.length; i++) {
            j = m18899b(j);
            bArr[i] = (byte) (bArr[i] ^ ((byte) j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m18901b(byte[] bArr, int i, int i2, long j) {
        for (int i3 = 0; i3 < i2; i3++) {
            j = m18899b(j);
            int i4 = i + i3;
            bArr[i4] = (byte) (bArr[i4] ^ ((byte) j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m18900b(long j, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            j = m18899b(j);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static long m18899b(long j) {
        long j2 = (j << 13) ^ j;
        long j3 = j2 ^ (j2 >>> 7);
        return j3 ^ (j3 << 17);
    }
}
