package ru.maximoff.apktool.util;

import android.graphics.Bitmap;
import android.util.LruCache;
import java.util.Locale;

/* compiled from: IconCache.java */
/* renamed from: ru.maximoff.apktool.util.z */
/* loaded from: classes.dex */
public class C3267z {

    /* renamed from: a */
    private static C3267z f20750a;

    /* renamed from: b */
    private final LruCache<String, Bitmap> f20751b = new LruCache<String, Bitmap>(this, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8) { // from class: ru.maximoff.apktool.util.z.1

        /* renamed from: a */
        private final C3267z f20752a;

        {
            this.f20752a = this;
        }

        @Override // android.util.LruCache
        protected int sizeOf(String str, Bitmap bitmap) {
            return m19715a(str, bitmap);
        }

        /* renamed from: a */
        protected int m19715a(String str, Bitmap bitmap) {
            return bitmap.getByteCount() / 1024;
        }
    };

    C3267z() {
    }

    /* renamed from: a */
    public static C3267z m19713a() {
        if (f20750a == null) {
            try {
                synchronized (Class.forName("ru.maximoff.apktool.util.z")) {
                    if (f20750a == null) {
                        f20750a = new C3267z();
                    }
                }
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        }
        return f20750a;
    }

    /* renamed from: a */
    public Bitmap m19714a(C3066aa c3066aa, int i, int i2) {
        String m19712a = m19712a(i, i2);
        Bitmap bitmap = this.f20751b.get(m19712a);
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap m18363a = c3066aa.m18363a(i, i2);
            this.f20751b.put(m19712a, m18363a);
            return m18363a;
        }
        return bitmap;
    }

    /* renamed from: a */
    private String m19712a(int i, int i2) {
        return String.format(Locale.f10688US, "%08X_%08X_%08X_%b", new Integer(i2), new Integer(i), new Integer(C3102bd.f18319b), new Boolean(C3102bd.f18270F));
    }
}
