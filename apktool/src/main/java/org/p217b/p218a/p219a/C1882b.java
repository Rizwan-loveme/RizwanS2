package org.p217b.p218a.p219a;

import android.media.session.PlaybackState;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.p209io.BufferedOutputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileNotFoundException;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.OutputStream;
import java.util.Collection;
import java.util.List;

/* compiled from: FileUtils.java */
/* renamed from: org.b.a.a.b */
/* loaded from: classes.dex */
public class C1882b {

    /* renamed from: a */
    public static final BigInteger f11025a = BigInteger.valueOf(PlaybackState.ACTION_PLAY_FROM_MEDIA_ID);

    /* renamed from: b */
    public static final BigInteger f11026b = f11025a.multiply(f11025a);

    /* renamed from: c */
    public static final BigInteger f11027c = f11025a.multiply(f11026b);

    /* renamed from: d */
    public static final BigInteger f11028d = f11025a.multiply(f11027c);

    /* renamed from: e */
    public static final BigInteger f11029e = f11025a.multiply(f11028d);

    /* renamed from: f */
    public static final BigInteger f11030f = f11025a.multiply(f11029e);

    /* renamed from: g */
    public static final BigInteger f11031g = BigInteger.valueOf(PlaybackState.ACTION_PLAY_FROM_MEDIA_ID).multiply(BigInteger.valueOf(1152921504606846976L));

    /* renamed from: h */
    public static final BigInteger f11032h = f11025a.multiply(f11031g);

    /* renamed from: i */
    public static final File[] f11033i = new File[0];

    /* renamed from: j */
    private static final Charset f11034j = Charset.forName("UTF-8");

    /* renamed from: a */
    public static FileInputStream m13942a(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            }
            return new FileInputStream(file);
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    /* renamed from: a */
    public static FileOutputStream m13943a(File file, boolean z) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        }
        return new FileOutputStream(file, z);
    }

    /* renamed from: a */
    public static List<String> m13945a(File file, Charset charset) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = m13942a(file);
            return C1887e.m13982b(fileInputStream, C1879a.m13936a(charset));
        } finally {
            C1887e.m13970a((InputStream) fileInputStream);
        }
    }

    /* renamed from: a */
    public static List<String> m13944a(File file, String str) {
        return m13945a(file, C1879a.m13935a(str));
    }

    /* renamed from: a */
    public static void m13946a(File file, String str, Collection<?> collection) {
        m13947a(file, str, collection, null, false);
    }

    /* renamed from: a */
    public static void m13947a(File file, String str, Collection<?> collection, String str2, boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = m13943a(file, z);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            C1887e.m13976a(collection, str2, bufferedOutputStream, str);
            bufferedOutputStream.flush();
            fileOutputStream.close();
        } finally {
            C1887e.m13972a((OutputStream) fileOutputStream);
        }
    }
}
