package com.p129f.p130a.p135e;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.p129f.p130a.p131a.C1120o;
import com.p129f.p130a.p136f.C1216a;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: ByteStreams.java */
/* renamed from: com.f.a.e.a */
/* loaded from: classes.dex */
public final class C1213a {

    /* renamed from: a */
    private static final OutputStream f7977a = new OutputStream() { // from class: com.f.a.e.a.1
        @Override // java.io.OutputStream
        public void write(int i) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            C1120o.m9547a(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            C1120o.m9547a(bArr);
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    };

    /* renamed from: a */
    static byte[] m10160a() {
        return new byte[8192];
    }

    /* renamed from: a */
    private static byte[] m10162a(InputStream inputStream, Deque<byte[]> deque, int i) {
        int i2 = 8192;
        int i3 = i;
        while (i3 < 2147483639) {
            byte[] bArr = new byte[Math.min(i2, 2147483639 - i3)];
            deque.add(bArr);
            int i4 = 0;
            while (i4 < bArr.length) {
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                if (read == -1) {
                    return m10163a(deque, i3);
                }
                i4 += read;
                i3 += read;
            }
            i2 = C1216a.m10169a(i2, 2);
        }
        if (inputStream.read() == -1) {
            return m10163a(deque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* renamed from: a */
    private static byte[] m10163a(Deque<byte[]> deque, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            byte[] removeFirst = deque.removeFirst();
            int min = Math.min(i2, removeFirst.length);
            System.arraycopy(removeFirst, 0, bArr, i - i2, min);
            i2 -= min;
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m10161a(InputStream inputStream) {
        C1120o.m9547a(inputStream);
        return m10162a(inputStream, new ArrayDeque(20), 0);
    }

    /* renamed from: a */
    public static void m10158a(InputStream inputStream, byte[] bArr) {
        m10159a(inputStream, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static void m10159a(InputStream inputStream, byte[] bArr, int i, int i2) {
        int m10164b = m10164b(inputStream, bArr, i, i2);
        if (m10164b != i2) {
            throw new EOFException("reached end of stream after reading " + m10164b + " bytes; " + i2 + " bytes expected");
        }
    }

    /* renamed from: a */
    public static void m10157a(InputStream inputStream, long j) {
        long m10165b = m10165b(inputStream, j);
        if (m10165b < j) {
            throw new EOFException("reached end of stream after skipping " + m10165b + " bytes; " + j + " bytes expected");
        }
    }

    /* renamed from: b */
    static long m10165b(InputStream inputStream, long j) {
        byte[] m10160a = m10160a();
        long j2 = 0;
        while (j2 < j) {
            long j3 = j - j2;
            long m10166c = m10166c(inputStream, j3);
            if (m10166c == 0) {
                m10166c = inputStream.read(m10160a, 0, (int) Math.min(j3, m10160a.length));
                if (m10166c == -1) {
                    break;
                }
            }
            j2 = m10166c + j2;
        }
        return j2;
    }

    /* renamed from: c */
    private static long m10166c(InputStream inputStream, long j) {
        int available = inputStream.available();
        if (available == 0) {
            return 0L;
        }
        return inputStream.skip(Math.min(available, j));
    }

    @CanIgnoreReturnValue
    /* renamed from: b */
    public static int m10164b(InputStream inputStream, byte[] bArr, int i, int i2) {
        C1120o.m9547a(inputStream);
        C1120o.m9547a(bArr);
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}
