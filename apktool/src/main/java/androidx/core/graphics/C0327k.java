package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.p027c.C0251f;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TypefaceCompatUtil.java */
/* renamed from: androidx.core.graphics.k */
/* loaded from: classes.dex */
public class C0327k {
    /* renamed from: a */
    public static File m2414a(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                return null;
            }
            File file = new File(cacheDir, str + i2);
            if (file.createNewFile()) {
                return file;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private static ByteBuffer m2417a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                return map;
            } finally {
            }
        } catch (IOException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public static ByteBuffer m2416a(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (openFileDescriptor != null) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                        fileInputStream.close();
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                            return map;
                        }
                        return map;
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                }
            }
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
            }
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public static ByteBuffer m2415a(Context context, Resources resources, int i) {
        ByteBuffer byteBuffer = null;
        File m2414a = m2414a(context);
        if (m2414a != null) {
            try {
                if (m2420a(m2414a, resources, i)) {
                    byteBuffer = m2417a(m2414a);
                }
            } finally {
                m2414a.delete();
            }
        }
        return byteBuffer;
    }

    /* renamed from: a */
    public static boolean m2421a(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            m2419a(fileOutputStream);
                            StrictMode.setThreadPolicy(allowThreadDiskWrites);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.m184e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    m2419a(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                m2419a((Closeable) null);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            m2419a((Closeable) null);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m2420a(File file, Resources resources, int i) {
        InputStream inputStream = null;
        try {
            inputStream = resources.openRawResource(i);
            return m2421a(file, inputStream);
        } finally {
            m2419a(inputStream);
        }
    }

    /* renamed from: a */
    public static void m2419a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
            }
        }
    }

    /* renamed from: a */
    public static Map<Uri, ByteBuffer> m2418a(Context context, C0251f.b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0251f.b bVar : bVarArr) {
            if (bVar.m1831e() == 0) {
                Uri m1827a = bVar.m1827a();
                if (!hashMap.containsKey(m1827a)) {
                    hashMap.put(m1827a, m2416a(context, cancellationSignal, m1827a));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
