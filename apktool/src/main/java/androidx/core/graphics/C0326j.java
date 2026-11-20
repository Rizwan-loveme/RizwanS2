package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.p028a.C0258c;
import androidx.core.p027c.C0251f;
import java.lang.reflect.Field;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl.java */
/* renamed from: androidx.core.graphics.j */
/* loaded from: classes.dex */
class C0326j {

    /* renamed from: a */
    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, C0258c.b> f2290a = new ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl.java */
    /* renamed from: androidx.core.graphics.j$a */
    private interface a<T> {
        /* renamed from: a */
        boolean mo2412a(T t);

        /* renamed from: b */
        int mo2413b(T t);
    }

    C0326j() {
    }

    /* renamed from: a */
    private static <T> T m2408a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (aVar.mo2412a(t2) == z ? 0 : 1) + (Math.abs(aVar.mo2413b(t2) - i2) * 2);
            if (t == null || i3 > abs) {
                i3 = abs;
                t = t2;
            }
        }
        return t;
    }

    /* renamed from: b */
    private static long m2410b(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e2) {
            Log.m185e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        } catch (NoSuchFieldException e3) {
            Log.m185e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        }
    }

    /* renamed from: a */
    protected C0251f.b mo2406a(C0251f.b[] bVarArr, int i) {
        return (C0251f.b) m2408a(bVarArr, i, new a<C0251f.b>() { // from class: androidx.core.graphics.j.1
            @Override // androidx.core.graphics.C0326j.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo2413b(C0251f.b bVar) {
                return bVar.m1829c();
            }

            @Override // androidx.core.graphics.C0326j.a
            /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo2412a(C0251f.b bVar) {
                return bVar.m1830d();
            }
        });
    }

    /* renamed from: a */
    protected Typeface mo2405a(Context context, InputStream inputStream) {
        Typeface typeface = null;
        File m2414a = C0327k.m2414a(context);
        if (m2414a != null) {
            try {
                if (C0327k.m2421a(m2414a, inputStream)) {
                    typeface = Typeface.createFromFile(m2414a.getPath());
                }
            } catch (RuntimeException e2) {
            } finally {
                m2414a.delete();
            }
        }
        return typeface;
    }

    /* renamed from: a */
    public Typeface mo2384a(Context context, CancellationSignal cancellationSignal, C0251f.b[] bVarArr, int i) {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        Typeface typeface = null;
        if (bVarArr.length >= 1) {
            try {
                inputStream2 = context.getContentResolver().openInputStream(mo2406a(bVarArr, i).m1827a());
            } catch (IOException e2) {
                inputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
            try {
                typeface = mo2405a(context, inputStream2);
                C0327k.m2419a(inputStream2);
            } catch (IOException e3) {
                C0327k.m2419a(inputStream2);
                return typeface;
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStream2;
                C0327k.m2419a(inputStream);
                throw th;
            }
        }
        return typeface;
    }

    /* renamed from: a */
    private C0258c.c m2407a(C0258c.b bVar, int i) {
        return (C0258c.c) m2408a(bVar.m1889a(), i, new a<C0258c.c>() { // from class: androidx.core.graphics.j.2
            @Override // androidx.core.graphics.C0326j.a
            /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo2413b(C0258c.c cVar) {
                return cVar.m1891b();
            }

            @Override // androidx.core.graphics.C0326j.a
            /* renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo2412a(C0258c.c cVar) {
                return cVar.m1892c();
            }
        });
    }

    /* renamed from: a */
    public Typeface mo2385a(Context context, C0258c.b bVar, Resources resources, int i) {
        C0258c.c m2407a = m2407a(bVar, i);
        if (m2407a == null) {
            return null;
        }
        Typeface m2331a = C0314d.m2331a(context, resources, m2407a.m1895f(), m2407a.m1890a(), i);
        m2409a(m2331a, bVar);
        return m2331a;
    }

    /* renamed from: a */
    public Typeface mo2396a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typeface = null;
        File m2414a = C0327k.m2414a(context);
        if (m2414a != null) {
            try {
                if (C0327k.m2420a(m2414a, resources, i)) {
                    typeface = Typeface.createFromFile(m2414a.getPath());
                }
            } catch (RuntimeException e2) {
            } finally {
                m2414a.delete();
            }
        }
        return typeface;
    }

    /* renamed from: a */
    C0258c.b m2411a(Typeface typeface) {
        long m2410b = m2410b(typeface);
        if (m2410b == 0) {
            return null;
        }
        return this.f2290a.get(Long.valueOf(m2410b));
    }

    /* renamed from: a */
    private void m2409a(Typeface typeface, C0258c.b bVar) {
        long m2410b = m2410b(typeface);
        if (m2410b != 0) {
            this.f2290a.put(Long.valueOf(m2410b), bVar);
        }
    }
}
