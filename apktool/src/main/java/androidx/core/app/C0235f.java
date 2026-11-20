package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p006pm.ActivityInfo;
import android.content.p006pm.PackageManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: NavUtils.java */
/* renamed from: androidx.core.app.f */
/* loaded from: classes.dex */
public final class C0235f {
    /* renamed from: a */
    public static boolean m1701a(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            return activity.shouldUpRecreateTask(intent);
        }
        String action = activity.getIntent().getAction();
        return (action == null || action.equals(Intent.ACTION_MAIN)) ? false : true;
    }

    /* renamed from: b */
    public static void m1704b(Activity activity, Intent intent) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.navigateUpTo(intent);
            return;
        }
        intent.addFlags(67108864);
        activity.startActivity(intent);
        activity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.content.Intent] */
    /* renamed from: a */
    public static Intent m1699a(Activity activity) {
        Intent parentActivityIntent;
        if (Build.VERSION.SDK_INT < 16 || (parentActivityIntent = activity.getParentActivityIntent()) == null) {
            String m1702b = m1702b(activity);
            if (m1702b == 0) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, (String) m1702b);
            try {
                if (m1703b(activity, componentName) == null) {
                    m1702b = Intent.makeMainActivity(componentName);
                } else {
                    m1702b = new Intent().setComponent(componentName);
                }
                return m1702b;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.m184e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + m1702b + "' in manifest");
                return null;
            }
        }
        return parentActivityIntent;
    }

    /* renamed from: a */
    public static Intent m1700a(Context context, ComponentName componentName) {
        String m1703b = m1703b(context, componentName);
        if (m1703b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), m1703b);
        if (m1703b(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    /* renamed from: b */
    public static String m1702b(Activity activity) {
        try {
            return m1703b(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    /* renamed from: b */
    public static String m1703b(Context context, ComponentName componentName) {
        String string;
        String str;
        int i = DisplayMetrics.DENSITY_XXXHIGH;
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 24) {
        }
        if (Build.VERSION.SDK_INT >= 29) {
            i = 269222528;
        } else if (Build.VERSION.SDK_INT >= 24) {
            i = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i);
        if (Build.VERSION.SDK_INT < 16 || (str = activityInfo.parentActivityName) == null) {
            if (activityInfo.metaData != null && (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) != null) {
                if (string.charAt(0) == '.') {
                    return context.getPackageName() + string;
                }
                return string;
            }
            return null;
        }
        return str;
    }
}
