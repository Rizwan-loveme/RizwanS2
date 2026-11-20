package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.p008os.Build;
import android.p008os.Bundle;
import android.p008os.Process;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.p028a.C0261f;
import java.p209io.File;

/* compiled from: ContextCompat.java */
/* renamed from: androidx.core.content.a */
/* loaded from: classes.dex */
public class C0255a {

    /* renamed from: a */
    private static final Object f2014a = new Object();

    /* renamed from: b */
    private static final Object f2015b = new Object();

    /* renamed from: c */
    private static TypedValue f2016c;

    /* renamed from: a */
    public static boolean m1849a(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            a.m1856a(context, intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    /* renamed from: a */
    public static File[] m1851a(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? b.m1866a(context, str) : new File[]{context.getExternalFilesDir(str)};
    }

    /* renamed from: a */
    public static File[] m1850a(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? b.m1865a(context) : new File[]{context.getExternalCacheDir()};
    }

    /* renamed from: a */
    public static Drawable m1847a(Context context, int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            return c.m1879a(context, i);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i);
        }
        synchronized (f2014a) {
            if (f2016c == null) {
                f2016c = new TypedValue();
            }
            context.getResources().getValue(i, f2016c, true);
            i2 = f2016c.resourceId;
        }
        return context.getResources().getDrawable(i2);
    }

    /* renamed from: b */
    public static ColorStateList m1853b(Context context, int i) {
        return C0261f.m1916b(context.getResources(), i, context.getTheme());
    }

    /* renamed from: c */
    public static int m1855c(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? d.m1900a(context, i) : context.getResources().getColor(i);
    }

    /* renamed from: b */
    public static int m1852b(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    /* renamed from: b */
    public static File m1854b(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return c.m1880a(context);
        }
        return m1848a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    /* renamed from: a */
    private static File m1848a(File file) {
        synchronized (f2015b) {
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    Log.m190w("ContextCompat", "Unable to create files subdir " + file.getPath());
                }
            }
        }
        return file;
    }

    /* compiled from: ContextCompat.java */
    /* renamed from: androidx.core.content.a$a */
    static class a {
        /* renamed from: a */
        static void m1856a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }
    }

    /* compiled from: ContextCompat.java */
    /* renamed from: androidx.core.content.a$b */
    static class b {
        /* renamed from: a */
        static File[] m1865a(Context context) {
            return context.getExternalCacheDirs();
        }

        /* renamed from: a */
        static File[] m1866a(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }
    }

    /* compiled from: ContextCompat.java */
    /* renamed from: androidx.core.content.a$c */
    static class c {
        /* renamed from: a */
        static Drawable m1879a(Context context, int i) {
            return context.getDrawable(i);
        }

        /* renamed from: a */
        static File m1880a(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* compiled from: ContextCompat.java */
    /* renamed from: androidx.core.content.a$d */
    static class d {
        /* renamed from: a */
        static int m1900a(Context context, int i) {
            return context.getColor(i);
        }
    }
}
