package org.p217b.p218a.p219a;

import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.p217b.p218a.p219a.p221b.C1883a;
import org.p217b.p218a.p219a.p221b.C1884b;

/* compiled from: IOUtils.java */
/* renamed from: org.b.a.a.e */
/* loaded from: classes.dex */
public class C1887e {

    /* renamed from: a */
    public static final char f11050a = File.separatorChar;

    /* renamed from: b */
    public static final String f11051b;

    static {
        C1884b c1884b = new C1884b(4);
        PrintWriter printWriter = new PrintWriter(c1884b);
        printWriter.println();
        f11051b = c1884b.toString();
        printWriter.close();
    }

    /* renamed from: a */
    public static void m13970a(InputStream inputStream) {
        m13969a((Closeable) inputStream);
    }

    /* renamed from: a */
    public static void m13972a(OutputStream outputStream) {
        m13969a((Closeable) outputStream);
    }

    /* renamed from: a */
    public static void m13969a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    /* renamed from: a */
    public static BufferedReader m13966a(Reader reader) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    /* renamed from: b */
    public static byte[] m13984b(InputStream inputStream) {
        C1883a c1883a = new C1883a();
        m13962a(inputStream, c1883a);
        return c1883a.m13949a();
    }

    /* renamed from: a */
    public static byte[] m13979a(InputStream inputStream, long j) {
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
        }
        return m13978a(inputStream, (int) j);
    }

    /* renamed from: a */
    public static byte[] m13978a(InputStream inputStream, int i) {
        int i2 = 0;
        if (i < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
        }
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 != i) {
            throw new IOException("Unexpected readed size. current: " + i2 + ", excepted: " + i);
        }
        return bArr;
    }

    /* renamed from: c */
    public static String m13985c(InputStream inputStream) {
        return m13968a(inputStream, Charset.defaultCharset());
    }

    /* renamed from: a */
    public static String m13968a(InputStream inputStream, Charset charset) {
        C1884b c1884b = new C1884b();
        m13971a(inputStream, c1884b, charset);
        return c1884b.toString();
    }

    /* renamed from: a */
    public static String m13967a(InputStream inputStream, String str) {
        return m13968a(inputStream, C1879a.m13935a(str));
    }

    /* renamed from: b */
    public static List<String> m13982b(InputStream inputStream, Charset charset) {
        return m13983b(new InputStreamReader(inputStream, C1879a.m13936a(charset)));
    }

    /* renamed from: b */
    public static List<String> m13983b(Reader reader) {
        BufferedReader m13966a = m13966a(reader);
        ArrayList arrayList = new ArrayList();
        for (String readLine = m13966a.readLine(); readLine != null; readLine = m13966a.readLine()) {
            arrayList.add(readLine);
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m13973a(String str, OutputStream outputStream) {
        m13975a(str, outputStream, Charset.defaultCharset());
    }

    /* renamed from: a */
    public static void m13975a(String str, OutputStream outputStream, Charset charset) {
        if (str != null) {
            outputStream.write(str.getBytes(C1879a.m13936a(charset)));
        }
    }

    /* renamed from: a */
    public static void m13974a(String str, OutputStream outputStream, String str2) {
        m13975a(str, outputStream, C1879a.m13935a(str2));
    }

    /* renamed from: a */
    public static void m13977a(Collection<?> collection, String str, OutputStream outputStream, Charset charset) {
        if (collection != null) {
            if (str == null) {
                str = f11051b;
            }
            Charset m13936a = C1879a.m13936a(charset);
            for (Object obj : collection) {
                if (obj != null) {
                    outputStream.write(obj.toString().getBytes(m13936a));
                }
                outputStream.write(str.getBytes(m13936a));
            }
        }
    }

    /* renamed from: a */
    public static void m13976a(Collection<?> collection, String str, OutputStream outputStream, String str2) {
        m13977a(collection, str, outputStream, C1879a.m13935a(str2));
    }

    /* renamed from: a */
    public static int m13962a(InputStream inputStream, OutputStream outputStream) {
        long m13980b = m13980b(inputStream, outputStream);
        if (m13980b > 2147483647L) {
            return -1;
        }
        return (int) m13980b;
    }

    /* renamed from: b */
    public static long m13980b(InputStream inputStream, OutputStream outputStream) {
        return m13964a(inputStream, outputStream, new byte[4096]);
    }

    /* renamed from: a */
    public static long m13964a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j += read;
            } else {
                return j;
            }
        }
    }

    /* renamed from: a */
    public static void m13971a(InputStream inputStream, Writer writer, Charset charset) {
        m13963a(new InputStreamReader(inputStream, C1879a.m13936a(charset)), writer);
    }

    /* renamed from: a */
    public static int m13963a(Reader reader, Writer writer) {
        long m13981b = m13981b(reader, writer);
        if (m13981b > 2147483647L) {
            return -1;
        }
        return (int) m13981b;
    }

    /* renamed from: b */
    public static long m13981b(Reader reader, Writer writer) {
        return m13965a(reader, writer, new char[4096]);
    }

    /* renamed from: a */
    public static long m13965a(Reader reader, Writer writer, char[] cArr) {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 != read) {
                writer.write(cArr, 0, read);
                j += read;
            } else {
                return j;
            }
        }
    }
}
