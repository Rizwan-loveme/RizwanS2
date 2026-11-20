package ru.maximoff.apktool.util;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import com.srizwan.apktool.R;

/* compiled from: MiuiUtils.java */
/* renamed from: ru.maximoff.apktool.util.aq */
/* loaded from: classes.dex */
public class C3085aq {
    /* renamed from: a */
    public static boolean m18667a() {
        return !C3112bn.m19040o(m18665a("ro.miui.ui.version.name"));
    }

    /* renamed from: b */
    public static String m18668b() {
        try {
            return String.valueOf(Build.VERSION.INCREMENTAL);
        } catch (Exception e2) {
            return "0.0.0";
        }
    }

    /* renamed from: c */
    public static boolean m18669c() {
        String m18665a = m18665a("persist.sys.miui_optimization");
        if (m18665a != null && m18665a.equals("0")) {
            return true;
        }
        try {
            return ((Boolean) Class.forName("android.miui.AppOpsUtils").getDeclaredMethod("isXOptMode", new Class[0]).invoke((Object) null, new Object[0])).booleanValue();
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    public static String m18665a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Class<?>[] clsArr = new Class[1];
            try {
                clsArr[0] = Class.forName("java.lang.String");
                return (String) cls.getDeclaredMethod("get", clsArr).invoke((Object) null, str);
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        } catch (Exception e3) {
            return (String) null;
        }
    }

    /* renamed from: a */
    public static void m18666a(Context context) {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e2) {
            C3112bn.m18999a(context, R.string.error);
        }
    }
}
