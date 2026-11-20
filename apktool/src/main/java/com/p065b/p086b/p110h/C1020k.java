package com.p065b.p086b.p110h;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: FileUtils.java */
/* renamed from: com.b.b.h.k */
/* loaded from: classes.dex */
public final class C1020k {
    /* renamed from: a */
    public static byte[] m8542a(File file) {
        if (!file.exists()) {
            throw new RuntimeException(file + ": file not found");
        }
        if (!file.isFile()) {
            throw new RuntimeException(file + ": not a file");
        }
        if (!file.canRead()) {
            throw new RuntimeException(file + ": file not readable");
        }
        long length = file.length();
        int i = (int) length;
        if (i != length) {
            throw new RuntimeException(file + ": file too long");
        }
        byte[] bArr = new byte[i];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i2 = 0;
            while (i > 0) {
                int read = fileInputStream.read(bArr, i2, i);
                if (read == -1) {
                    throw new RuntimeException(file + ": unexpected EOF");
                }
                i2 += read;
                i -= read;
            }
            fileInputStream.close();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(file + ": trouble reading", e2);
        }
    }

    /* renamed from: a */
    public static boolean m8541a(String str) {
        return str.endsWith(".zip") || str.endsWith(".jar") || str.endsWith(".apk");
    }
}
