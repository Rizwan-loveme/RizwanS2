package p046b.p059d;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import org.p217b.p218a.p219a.C1887e;
import p046b.p057b.C0523b;
import p046b.p057b.C0524c;
import p046b.p057b.C0525d;

/* compiled from: BrutIO.java */
/* renamed from: b.d.a */
/* loaded from: classes.dex */
public class C0536a {
    /* renamed from: a */
    public static void m3968a(InputStream inputStream, OutputStream outputStream) {
        try {
            C1887e.m13962a(inputStream, outputStream);
        } finally {
            C1887e.m13970a(inputStream);
            C1887e.m13972a(outputStream);
        }
    }

    /* renamed from: a */
    public static long m3965a(File[] fileArr) {
        long j = 0;
        for (File file : fileArr) {
            long m3964a = m3964a(file);
            if (m3964a > j) {
                j = m3964a;
            }
        }
        return j;
    }

    /* renamed from: a */
    public static long m3964a(File file) {
        long lastModified = file.lastModified();
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                long m3964a = m3964a(file2);
                if (m3964a > lastModified) {
                    lastModified = m3964a;
                }
            }
        }
        return lastModified;
    }

    /* renamed from: a */
    public static String m3966a(File file, String str) {
        if (str.length() == 0) {
            throw new C0523b(new StringBuffer().append("Invalid Unknown File - ").append(str).toString());
        }
        if (new File(str).isAbsolute()) {
            throw new C0524c(new StringBuffer().append("Absolute Unknown Files is not allowed - ").append(str).toString());
        }
        String stringBuffer = new StringBuffer().append(file.getCanonicalPath()).append(File.separator).toString();
        String canonicalPath = new File(file, str).getCanonicalPath();
        if (!canonicalPath.startsWith(stringBuffer)) {
            throw new C0525d(new StringBuffer().append("Directory Traversal is not allowed - ").append(str).toString());
        }
        return canonicalPath.substring(stringBuffer.length());
    }

    /* renamed from: a */
    public static String m3967a(String str) {
        char c2 = File.separatorChar;
        if (c2 != '/') {
            return str.replace(c2, '/');
        }
        return str;
    }
}
