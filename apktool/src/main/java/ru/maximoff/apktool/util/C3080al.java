package ru.maximoff.apktool.util;

import android.C0012R;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.bluetooth.BluetoothClass;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.p006pm.ActivityInfo;
import android.content.p006pm.ApplicationInfo;
import android.content.p006pm.ComponentInfo;
import android.content.p006pm.PackageInfo;
import android.content.p006pm.PackageManager;
import android.content.p006pm.PermissionInfo;
import android.content.p006pm.ResolveInfo;
import android.content.p006pm.ServiceInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.p008os.AsyncTask;
import android.p008os.Build;
import android.p008os.Handler;
import android.p008os.LocaleList;
import android.p008os.Looper;
import android.p008os.Process;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.security.keystore.KeyProperties;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import androidx.appcompat.widget.C0173ao;
import androidx.core.content.FileProvider;
import com.p065b.p066a.p067a.AbstractC0581c;
import com.p122c.p123a.C1076d;
import com.p122c.p123a.C1078f;
import com.p122c.p123a.InterfaceC1075c;
import com.srizwan.apktool.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.p209io.BufferedInputStream;
import java.p209io.File;
import java.p209io.FileOutputStream;
import java.p209io.FilenameFilter;
import java.p209io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.p217b.p218a.p219a.C1887e;
import org.p270e.C2466a;
import p046b.p047a.C0518d;
import p046b.p059d.C0542g;
import p060c.p061a.p062a.AbstractC0549e;
import p060c.p061a.p062a.C0546b;
import p060c.p061a.p062a.C0547c;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.fragment.p302b.InterfaceC2995n;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;
import ru.maximoff.apktool.p300e.AsyncTaskC2916ar;
import ru.maximoff.apktool.p300e.AsyncTaskC2928bc;
import ru.maximoff.apktool.p300e.AsyncTaskC2933d;
import ru.maximoff.apktool.p300e.AsyncTaskC2940k;
import ru.maximoff.apktool.p300e.AsyncTaskC2944o;
import ru.maximoff.apktool.p300e.AsyncTaskC2949t;
import ru.maximoff.apktool.p300e.AsyncTaskC2950u;
import ru.maximoff.apktool.p300e.AsyncTaskC2953x;
import ru.maximoff.apktool.p300e.C2917as;
import ru.maximoff.apktool.util.activities.C3071a;
import ru.maximoff.apktool.util.activities.MActList;
import ru.maximoff.apktool.util.p303a.C3061a;
import ru.maximoff.apktool.util.p305c.AsyncTaskC3127ah;
import ru.maximoff.apktool.view.C3309k;
import ru.maximoff.apktool.view.C3311m;
import ru.maximoff.apktool.view.CustomListView;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: MUtil.java */
/* renamed from: ru.maximoff.apktool.util.al */
/* loaded from: classes.dex */
public class C3080al {

    /* renamed from: a */
    public static final String[] f17664a = {"dex 035", "dex 037", "dex 038", "dex 039"};

    /* renamed from: b */
    public static final int[] f17665b = {14, 24, 26, 28};

    /* renamed from: a */
    public static String[] m18572a(Context context) {
        String[] strArr = {"0", "0", "0"};
        File file = new File(context.getFilesDir(), ".stats");
        if (file.isFile()) {
            try {
                String[] split = C3257q.m19520b(C3061a.m18332i(file), m18529a()).split(",");
                strArr[2] = String.valueOf(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
                strArr[0] = split[0];
                strArr[1] = split[1];
            } catch (Error e2) {
            } catch (Exception e3) {
            }
        }
        return strArr;
    }

    /* renamed from: a */
    public static boolean m18565a(Context context, boolean z) {
        String stringBuffer;
        String[] m18572a = m18572a(context);
        try {
            File file = new File(context.getFilesDir(), ".stats");
            if (z) {
                stringBuffer = new StringBuffer().append(new StringBuffer().append(String.valueOf(Integer.parseInt(m18572a[0]) + 1)).append(",").toString()).append(m18572a[1]).toString();
            } else {
                stringBuffer = new StringBuffer().append(new StringBuffer().append(m18572a[0]).append(",").toString()).append(String.valueOf(Integer.parseInt(m18572a[1]) + 1)).toString();
            }
            C3061a.m18319b(file, C3257q.m19518a(stringBuffer, m18529a()));
            return true;
        } catch (Error | Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    public static int m18522a(Context context, int i) {
        return Math.round(context.getResources().getDisplayMetrics().scaledDensity * i);
    }

    /* renamed from: a */
    public static int m18521a(Context context, float f2) {
        return Math.round(context.getResources().getDisplayMetrics().density * f2);
    }

    /* renamed from: b */
    public static int m18574b(Context context, int i) {
        return Math.round(context.getResources().getDisplayMetrics().density * i);
    }

    /* renamed from: b */
    public static String m18577b(Context context) {
        return m18579b(context, false);
    }

    /* renamed from: b */
    public static String m18579b(Context context, boolean z) {
        try {
            String packageName = context.getPackageName();
            if (z) {
                packageName = new StringBuffer().append(packageName).append(".unapkm").toString();
            }
            byte[] byteArray = context.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray();
            if (byteArray.length == C3249i.f19541a.length) {
                for (int i = 0; i < byteArray.length; i++) {
                    if (byteArray[i] != C3249i.f19541a[i]) {
                        return new String(byteArray);
                    }
                }
                return m18529a();
            }
            return m18575b();
        } catch (Exception e2) {
            return m18575b();
        }
    }

    /* renamed from: c */
    public static boolean m18589c(Context context) {
        return m18590c(context, false);
    }

    /* renamed from: c */
    public static boolean m18590c(Context context, boolean z) {
        return m18579b(context, z).equals(m18529a());
    }

    /* renamed from: a */
    public static String m18529a() {
        return m18539a(49, 57, 50, 52, 51, 48, 52, 53, 54, 50);
    }

    /* renamed from: b */
    public static String m18575b() {
        return m18539a(1090, 1099, 32, 1087, BluetoothClass.Device.AUDIO_VIDEO_VIDEO_MONITOR, BluetoothClass.Device.AUDIO_VIDEO_CAMCORDER, 1086, BluetoothClass.Device.AUDIO_VIDEO_VIDEO_CONFERENCING);
    }

    /* renamed from: a */
    public static String m18539a(int... iArr) {
        StringBuilder sb = new StringBuilder(iArr.length);
        for (int i : iArr) {
            sb.append(Character.toChars(i));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m18561a(String str, File file) {
        m18554a(MainActivity.m16615o(), str, file);
    }

    /* renamed from: a */
    public static void m18554a(Context context, String str, File file) {
        InputStream open = context.getAssets().open(str);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        C1887e.m13962a(open, fileOutputStream);
        open.close();
        fileOutputStream.close();
    }

    /* renamed from: a */
    public static boolean m18564a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = (InputStream) null;
        try {
            inputStream = context.getAssets().open(str);
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return true;
                } catch (Exception e2) {
                    return true;
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            inputStream = inputStream2;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStream2;
        }
        try {
            inputStream.close();
        } catch (Exception e5) {
        }
        return false;
    }

    /* renamed from: a */
    public static File[] m18571a(File[] fileArr, File[] fileArr2) {
        ArrayList arrayList = new ArrayList(fileArr.length + fileArr2.length);
        Collections.addAll(arrayList, fileArr);
        Collections.addAll(arrayList, fileArr2);
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    /* renamed from: a */
    public static String[] m18573a(String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList(strArr.length + strArr2.length);
        Collections.addAll(arrayList, strArr);
        Collections.addAll(arrayList, strArr2);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: d */
    public static boolean m18594d(Context context) {
        File[] listFiles;
        File file = new File(context.getFilesDir(), "bin");
        return file.isDirectory() && (listFiles = file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.al.1
            @Override // java.p209io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.startsWith("aapt");
            }
        })) != null && listFiles.length >= 2;
    }

    /* renamed from: a */
    public static String m18531a(int i, int i2, int i3) {
        return i > 0 ? new StringBuffer().append(String.format(new StringBuffer().append(new StringBuffer().append("%.").append(i3).toString()).append("f").toString(), new Float(i2 / (i / 100.0f)))).append("%").toString() : "0%";
    }

    /* renamed from: b */
    public static String m18578b(Context context, String str) {
        InputStream inputStream = (InputStream) null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                String m18312b = C3061a.m18312b(inputStream);
                if (inputStream == null) {
                    return m18312b;
                }
                try {
                    inputStream.close();
                    return m18312b;
                } catch (Exception e2) {
                    return m18312b;
                }
            } catch (Exception e3) {
                return (String) null;
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e4) {
                }
            }
        }
    }

    /* renamed from: e */
    public static String[] m18597e(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(context.getCacheDir().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 19) {
            File[] externalCacheDirs = context.getExternalCacheDirs();
            if (externalCacheDirs != null) {
                for (File file : externalCacheDirs) {
                    if (file != null && !arrayList.contains(file.getAbsolutePath())) {
                        arrayList.add(file.getAbsolutePath());
                    }
                }
            }
        } else {
            arrayList.add(context.getExternalCacheDir().getAbsolutePath());
        }
        String[] m19640b = C3262u.m19640b(context);
        if (m19640b != null) {
            String packageName = context.getPackageName();
            for (String str : m19640b) {
                File file2 = new File(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append("/Android/data/").toString()).append(packageName).toString()).append("/cache").toString());
                if (((file2.isDirectory() && file2.canWrite()) || file2.mkdirs()) && !arrayList.contains(file2.getAbsolutePath())) {
                    arrayList.add(file2.getAbsolutePath());
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public static <T> List<T> m18542a(List<T> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        return new ArrayList(new LinkedHashSet(list));
    }

    /* renamed from: a */
    public static void m18551a(Context context, File file, PackageInfo packageInfo, PackageManager packageManager) {
        if (file == null && (packageInfo == null || packageManager == null)) {
            C3112bn.m19023b(context, context.getString(R.string.error));
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.search_progress, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.searchprogressTextView1)).setText(R.string.mplease_wait);
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m435b(inflate).m429a(false).m438b();
        m438b.show();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(packageManager, packageInfo, file, context, m438b) { // from class: ru.maximoff.apktool.util.al.2

            /* renamed from: a */
            private final PackageManager f17797a;

            /* renamed from: b */
            private final PackageInfo f17798b;

            /* renamed from: c */
            private final File f17799c;

            /* renamed from: d */
            private final Context f17800d;

            /* renamed from: e */
            private final DialogInterfaceC0070b f17801e;

            {
                this.f17797a = packageManager;
                this.f17798b = packageInfo;
                this.f17799c = file;
                this.f17800d = context;
                this.f17801e = m438b;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (this.f17797a == null || this.f17798b == null) {
                    try {
                        String absolutePath = this.f17799c.getAbsolutePath();
                        String str2 = (String) null;
                        String lowerCase = this.f17799c.getName().toLowerCase();
                        ArrayList arrayList = new ArrayList();
                        if (lowerCase.endsWith(".apks") || lowerCase.endsWith(".xapk") || (lowerCase.endsWith(".apkm") && C3262u.m19654d(this.f17799c))) {
                            C2604w c2604w = new C2604w(this.f17799c);
                            Enumeration<C2602u> m16163b = c2604w.m16163b();
                            byte[] bArr = new byte[C3249i.m19500a()];
                            String str3 = str2;
                            while (m16163b.hasMoreElements()) {
                                C2602u nextElement = m16163b.nextElement();
                                String lowerCase2 = nextElement.getName().toLowerCase();
                                if (!nextElement.isDirectory() && lowerCase2.endsWith(".apk") && !lowerCase2.contains(File.separator)) {
                                    String[] split = lowerCase2.split("\\.");
                                    if (split.length >= 3) {
                                        int length = split.length - 2;
                                        if (split[length].startsWith("arm") || split[length].startsWith("x86") || split[length].startsWith("mips")) {
                                            if (split[length].startsWith("x86")) {
                                                arrayList.add(split[length]);
                                            } else {
                                                arrayList.add(split[length].replace("_", "-"));
                                            }
                                        }
                                    }
                                    File createTempFile = File.createTempFile("AM_TempApkIT_", ".tmp", C3102bd.m18908a());
                                    BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), C3249i.m19500a());
                                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                                    while (true) {
                                        try {
                                            int read = bufferedInputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                        } catch (Throwable th) {
                                            bufferedInputStream.close();
                                            fileOutputStream.close();
                                            throw th;
                                        }
                                    }
                                    bufferedInputStream.close();
                                    fileOutputStream.close();
                                    C3060a c3060a = new C3060a(this.f17800d, createTempFile.getAbsolutePath());
                                    if (!c3060a.m18255D() || c3060a.m18266d() == null) {
                                        createTempFile.delete();
                                    } else {
                                        str3 = this.f17799c.getAbsolutePath();
                                        absolutePath = createTempFile.getAbsolutePath();
                                    }
                                }
                            }
                            str2 = str3;
                            str = absolutePath;
                        } else if (absolutePath.startsWith(new StringBuffer().append(new StringBuffer().append(C3102bd.m18908a().getAbsolutePath()).append(File.separator).toString()).append("open_apk").toString())) {
                            str2 = absolutePath;
                            str = absolutePath;
                        } else {
                            str = absolutePath;
                        }
                        Collections.sort(arrayList);
                        PackageManager packageManager2 = this.f17800d.getPackageManager();
                        PackageInfo packageArchiveInfo = packageManager2.getPackageArchiveInfo(str, 0);
                        packageArchiveInfo.applicationInfo.sourceDir = str;
                        packageArchiveInfo.applicationInfo.publicSourceDir = str;
                        C3080al.m18583b(this.f17800d, packageArchiveInfo, packageManager2, str2, arrayList);
                    } catch (Exception e2) {
                        C3112bn.m19023b(this.f17800d, this.f17800d.getString(R.string.failed_open, this.f17799c.getName()));
                    }
                } else {
                    C3080al.m18583b(this.f17800d, this.f17798b, this.f17797a, (String) null, (List) null);
                }
                this.f17801e.cancel();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m18583b(Context context, PackageInfo packageInfo, PackageManager packageManager, String str, List<String> list) {
        Bitmap m18372a;
        int i;
        int i2;
        String parent;
        String stringBuffer;
        SpannableString spannableString;
        int applicationEnabledSetting;
        AsyncTaskC3127ah asyncTaskC3127ah;
        LayoutInflater from = LayoutInflater.from(context);
        int m18521a = m18521a(context, 5.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(m18521a, m18521a / 2, m18521a, m18521a / 2);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setPadding(m18521a, m18521a, m18521a, m18521a);
        scrollView.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        scrollView.addView(linearLayout, layoutParams);
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        File[] m18570a = m18570a(packageInfo);
        C3081am c3081am = new C3081am(m18570a[0]);
        c3081am.m18624a(packageManager, packageInfo);
        if (c3081am.m18626b() != null && c3081am.m18644t() != 0 && c3081am.m18644t() != -1) {
            Bitmap m18366a = C3067ab.m18366a(c3081am.m18626b(), context.getResources().getDisplayMetrics().densityDpi, c3081am.m18644t());
            if (m18366a == null) {
                m18366a = C3067ab.m18372a(applicationInfo.loadIcon(packageManager));
            }
            m18372a = m18366a;
        } else {
            m18372a = C3067ab.m18372a(applicationInfo.loadIcon(packageManager));
        }
        if (list == null || list.isEmpty()) {
            list = c3081am.m18646v();
        }
        if (list.isEmpty()) {
            list = m18543a(m18570a);
        }
        List m18542a = m18542a(list);
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        try {
            i3 = c3081am.m18632h();
            i4 = c3081am.m18633i();
            z = c3081am.m18628d();
            i = i4;
            i2 = i3;
        } catch (Exception e2) {
            i = i4;
            i2 = i3;
        }
        boolean[] zArr = {true};
        File[] fileArr = new File[1];
        if (str == null) {
            zArr[0] = false;
            fileArr[0] = m18570a[0];
            parent = m18570a[0].getParent();
        } else {
            fileArr[0] = new File(str);
            parent = fileArr[0].getParent();
        }
        boolean startsWith = fileArr[0].getAbsolutePath().startsWith(new StringBuffer().append(new StringBuffer().append(C3102bd.m18908a().getAbsolutePath()).append(File.separator).toString()).append("open_apk").toString());
        boolean z2 = C3262u.m19670j(context, m18570a[0]) && !zArr[0];
        String[] m19620a = C3262u.m19620a(context, packageInfo, packageManager);
        String str2 = "";
        if (zArr[0]) {
            stringBuffer = new StringBuffer().append("").append(C3106bh.m18975a(fileArr[0].length(), C3102bd.f18305am)).toString();
        } else {
            long j = 0;
            for (int i5 = 0; i5 < m18570a.length; i5++) {
                long m19668i = C3262u.m19668i(context, m18570a[i5]);
                j += m19668i;
                if (i5 > 0) {
                    str2 = new StringBuffer().append(str2).append(" + ").toString();
                }
                str2 = new StringBuffer().append(str2).append(C3106bh.m18975a(m19668i, C3102bd.f18305am)).toString();
            }
            if (m18570a.length > 1) {
                str2 = new StringBuffer().append(str2).append(new StringBuffer().append(" = ").append(C3106bh.m18975a(j, C3102bd.f18305am)).toString()).toString();
            }
            stringBuffer = str2;
        }
        if (packageInfo.versionName != null) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.version_app), packageInfo.versionName), layoutParams2);
        }
        linearLayout.addView(m18526a(context, from, context.getString(R.string.vcode_app), String.valueOf(packageInfo.versionCode)), layoutParams2);
        if (m19620a != null && !z2) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.inst_ver), m19620a[0]), layoutParams2);
            linearLayout.addView(m18526a(context, from, context.getString(R.string.sign_match), m19620a[1]), layoutParams2);
        }
        if (z2) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.inst_date), C3112bn.m18989a(packageInfo.firstInstallTime)), layoutParams2);
            linearLayout.addView(m18526a(context, from, context.getString(R.string.inst_update), C3112bn.m18989a(packageInfo.lastUpdateTime)), layoutParams2);
            String m18580b = m18580b(packageManager, applicationInfo.packageName);
            if (m18580b != null) {
                linearLayout.addView(m18526a(context, from, context.getString(R.string.act_launch), m18580b), layoutParams2);
            }
        } else if (c3081am.m18636l() != null) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.act_launch), c3081am.m18636l()), layoutParams2);
        }
        if (c3081am.m18635k() != null) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.mapp_name), c3081am.m18635k()), layoutParams2);
        }
        linearLayout.addView(m18526a(context, from, context.getString(R.string.pname_app), applicationInfo.packageName), layoutParams2);
        if (z2 || z) {
            if (m18570a.length > 1 || z) {
                String lowerCase = context.getString(R.string.split).toLowerCase();
                spannableString = new SpannableString(new StringBuffer().append(new StringBuffer().append(" ").append(lowerCase).toString()).append(" ").toString());
                spannableString.setSpan(new ForegroundColorSpan(-1), 0, lowerCase.length() + 2, 33);
                spannableString.setSpan(new BackgroundColorSpan(C3246h.m19470a(context, R.color.dark_red)), 0, lowerCase.length() + 2, 33);
            } else {
                spannableString = new SpannableString(context.getString(R.string.f21469no).toLowerCase());
            }
            linearLayout.addView(m18528a(context, from, context.getString(R.string.split), spannableString, new Runnable(context, spannableString) { // from class: ru.maximoff.apktool.util.al.3

                /* renamed from: a */
                private final Context f17845a;

                /* renamed from: b */
                private final SpannableString f17846b;

                {
                    this.f17845a = context;
                    this.f17846b = spannableString;
                }

                @Override // java.lang.Runnable
                public void run() {
                    C3112bn.m19002a(this.f17845a, this.f17846b.toString().trim());
                }
            }, (Runnable) null), layoutParams2);
            if (z2 && ((applicationEnabledSetting = packageManager.getApplicationEnabledSetting(applicationInfo.packageName)) == 2 || applicationEnabledSetting == 3)) {
                linearLayout.addView(m18526a(context, from, context.getString(R.string.app_disabled), context.getString(R.string.yes).toLowerCase()), layoutParams2);
            }
        }
        if (C3102bd.m18925a(context, "detect_protect", true) && ((!zArr[0] || startsWith) && m18570a.length == 1)) {
            View m18528a = m18528a(context, from, context.getString(R.string.protection), "", (Runnable) null, (Runnable) null);
            linearLayout.addView(m18528a, layoutParams2);
            asyncTaskC3127ah = new AsyncTaskC3127ah(context, (TextView) m18528a.findViewById(R.id.linelayoutTextView2), c3081am.m18635k());
            asyncTaskC3127ah.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr[0]);
        } else {
            asyncTaskC3127ah = (AsyncTaskC3127ah) null;
        }
        if (!m18542a.isEmpty()) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.lib_set), m18538a((List<String>) m18542a, ", ")), layoutParams2);
        }
        if (i2 > 0) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.mapp_minsdk), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(i2).append(" (").toString()).append(m18532a(i2, true)).toString()).append(")").toString()), layoutParams2);
        }
        if (i > 0) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.mapp_targetsdk), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(i).append(" (").toString()).append(m18532a(i, true)).toString()).append(")").toString()), layoutParams2);
        }
        if (c3081am.m18637m() >= 0) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.mapp_inLocation), context.getResources().getStringArray(R.array.installLocation)[c3081am.m18637m() + 1].toLowerCase()), layoutParams2);
        }
        if (c3081am.m18639o() != null) {
            linearLayout.addView(m18526a(context, from, "sharedUserId", c3081am.m18639o()), layoutParams2);
        }
        linearLayout.addView(m18527a(context, from, context.getString(R.string.path_app), parent, new Runnable(fileArr, context) { // from class: ru.maximoff.apktool.util.al.4

            /* renamed from: a */
            private final File[] f17900a;

            /* renamed from: b */
            private final Context f17901b;

            {
                this.f17900a = fileArr;
                this.f17901b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity m16615o = MainActivity.m16615o();
                if (m16615o != null) {
                    m16615o.m16622a(this.f17900a[0].getParentFile());
                } else {
                    C3112bn.m19023b(this.f17901b, this.f17901b.getString(R.string.failed_open, this.f17900a[0].getParentFile().getAbsolutePath()));
                }
            }
        }), layoutParams2);
        Runnable runnable = (Runnable) null;
        if (z2) {
            if (m18570a.length > 1) {
                runnable = new Runnable(m18570a, context, applicationInfo, packageManager) { // from class: ru.maximoff.apktool.util.al.5

                    /* renamed from: a */
                    private final File[] f17951a;

                    /* renamed from: b */
                    private final Context f17952b;

                    /* renamed from: c */
                    private final ApplicationInfo f17953c;

                    /* renamed from: d */
                    private final PackageManager f17954d;

                    {
                        this.f17951a = m18570a;
                        this.f17952b = context;
                        this.f17953c = applicationInfo;
                        this.f17954d = packageManager;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList arrayList = new ArrayList();
                        for (int i6 = 0; i6 < this.f17951a.length; i6++) {
                            arrayList.add(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f17951a[i6].getName()).append(" (").toString()).append(C3106bh.m18975a(C3262u.m19668i(this.f17952b, this.f17951a[i6]), C3102bd.f18305am)).toString()).append(")").toString());
                        }
                        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f17952b).m427a(this.f17953c.loadLabel(this.f17954d)).m431a((String[]) arrayList.toArray(new String[arrayList.size()]), (DialogInterface.OnClickListener) null).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
                        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f17952b, arrayList) { // from class: ru.maximoff.apktool.util.al.5.1

                            /* renamed from: a */
                            private final AnonymousClass5 f17955a;

                            /* renamed from: b */
                            private final DialogInterfaceC0070b f17956b;

                            /* renamed from: c */
                            private final Context f17957c;

                            /* renamed from: d */
                            private final List f17958d;

                            {
                                this.f17955a = this;
                                this.f17956b = m438b;
                                this.f17957c = r3;
                                this.f17958d = arrayList;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface) {
                                this.f17956b.m415a().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(this, this.f17957c, this.f17958d) { // from class: ru.maximoff.apktool.util.al.5.1.1

                                    /* renamed from: a */
                                    private final AnonymousClass1 f17959a;

                                    /* renamed from: b */
                                    private final Context f17960b;

                                    /* renamed from: c */
                                    private final List f17961c;

                                    {
                                        this.f17959a = this;
                                        this.f17960b = r2;
                                        this.f17961c = r3;
                                    }

                                    @Override // android.widget.AdapterView.OnItemLongClickListener
                                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i7, long j2) {
                                        C3112bn.m19002a(this.f17960b, (String) this.f17961c.get(i7));
                                        return true;
                                    }
                                });
                            }
                        });
                        m438b.show();
                    }
                };
            }
            if (!C3112bn.m19040o(applicationInfo.dataDir)) {
                linearLayout.addView(m18527a(context, from, context.getString(R.string.data_dir), applicationInfo.dataDir, new Runnable(context, applicationInfo) { // from class: ru.maximoff.apktool.util.al.6

                    /* renamed from: a */
                    private final Context f17973a;

                    /* renamed from: b */
                    private final ApplicationInfo f17974b;

                    {
                        this.f17973a = context;
                        this.f17974b = applicationInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String[] m19640b = C3262u.m19640b(this.f17973a);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f17974b.dataDir);
                        if (m19640b != null) {
                            for (String str3 : m19640b) {
                                String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(str3).append("/Android/data/").toString()).append(this.f17974b.packageName).toString();
                                if (new File(stringBuffer2).isDirectory()) {
                                    arrayList.add(stringBuffer2);
                                }
                            }
                        }
                        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f17973a).m431a((String[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterface.OnClickListener(this, arrayList, this.f17973a) { // from class: ru.maximoff.apktool.util.al.6.1

                            /* renamed from: a */
                            private final AnonymousClass6 f17975a;

                            /* renamed from: b */
                            private final List f17976b;

                            /* renamed from: c */
                            private final Context f17977c;

                            {
                                this.f17975a = this;
                                this.f17976b = arrayList;
                                this.f17977c = r3;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i6) {
                                MainActivity m16615o = MainActivity.m16615o();
                                String str4 = (String) this.f17976b.get(i6);
                                if (m16615o != null) {
                                    m16615o.m16622a(new File(str4));
                                } else {
                                    C3112bn.m19023b(this.f17977c, this.f17977c.getString(R.string.failed_open, str4));
                                }
                                dialogInterface.dismiss();
                            }
                        }).m438b();
                        m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f17973a, arrayList) { // from class: ru.maximoff.apktool.util.al.6.2

                            /* renamed from: a */
                            private final AnonymousClass6 f17978a;

                            /* renamed from: b */
                            private final DialogInterfaceC0070b f17979b;

                            /* renamed from: c */
                            private final Context f17980c;

                            /* renamed from: d */
                            private final List f17981d;

                            {
                                this.f17978a = this;
                                this.f17979b = m438b;
                                this.f17980c = r3;
                                this.f17981d = arrayList;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface) {
                                this.f17979b.m415a().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(this, this.f17980c, this.f17981d) { // from class: ru.maximoff.apktool.util.al.6.2.1

                                    /* renamed from: a */
                                    private final AnonymousClass2 f17982a;

                                    /* renamed from: b */
                                    private final Context f17983b;

                                    /* renamed from: c */
                                    private final List f17984c;

                                    {
                                        this.f17982a = this;
                                        this.f17983b = r2;
                                        this.f17984c = r3;
                                    }

                                    @Override // android.widget.AdapterView.OnItemLongClickListener
                                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i6, long j2) {
                                        C3112bn.m19002a(this.f17983b, (String) this.f17984c.get(i6));
                                        return true;
                                    }
                                });
                            }
                        });
                        m438b.show();
                    }
                }), layoutParams2);
            }
            if (applicationInfo.uid != -1) {
                linearLayout.addView(m18526a(context, from, context.getString(R.string.app_uid), String.valueOf(applicationInfo.uid)), layoutParams2);
            }
            String installerPackageName = packageManager.getInstallerPackageName(applicationInfo.packageName);
            if (!C3112bn.m19040o(installerPackageName)) {
                linearLayout.addView(m18526a(context, from, context.getString(R.string.installer), installerPackageName), layoutParams2);
            }
        }
        linearLayout.addView(m18527a(context, from, context.getString(zArr[0] ? R.string.size_label : R.string.apk_size_label), stringBuffer, runnable), layoutParams2);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m427a(applicationInfo.loadLabel(packageManager)).m423a(new BitmapDrawable(context.getResources(), m18372a)).m435b(scrollView);
        if (z2) {
            aVar.m420a(R.string.extract, (DialogInterface.OnClickListener) null);
        } else {
            aVar.m420a(R.string.install, (DialogInterface.OnClickListener) null);
        }
        aVar.m421a(new DialogInterface.OnCancelListener(zArr, startsWith, m18570a) { // from class: ru.maximoff.apktool.util.al.7

            /* renamed from: a */
            private final boolean[] f17985a;

            /* renamed from: b */
            private final boolean f17986b;

            /* renamed from: c */
            private final File[] f17987c;

            {
                this.f17985a = zArr;
                this.f17986b = startsWith;
                this.f17987c = m18570a;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (!this.f17985a[0] || this.f17986b) {
                    return;
                }
                this.f17987c[0].delete();
            }
        });
        aVar.m434b(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.maximoff.apktool.util.al.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i6) {
                dialogInterface.cancel();
            }
        });
        aVar.m429a(false);
        aVar.m440c(R.string.mshow_more_options, (DialogInterface.OnClickListener) null);
        aVar.m422a(new DialogInterface.OnKeyListener() { // from class: ru.maximoff.apktool.util.al.9
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                if (i6 != 4 || keyEvent.getAction() != 1 || keyEvent.isCanceled()) {
                    return false;
                }
                dialogInterface.cancel();
                return true;
            }
        });
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnCancelListener(new DialogInterface.OnCancelListener(asyncTaskC3127ah) { // from class: ru.maximoff.apktool.util.al.10

            /* renamed from: a */
            private final AsyncTaskC3127ah f17666a;

            {
                this.f17666a = asyncTaskC3127ah;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (this.f17666a != null) {
                    this.f17666a.cancel(true);
                }
            }
        });
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, zArr, startsWith, context, packageManager, packageInfo, m18570a, z2, applicationInfo, fileArr, m19620a, c3081am, m18372a) { // from class: ru.maximoff.apktool.util.al.11

            /* renamed from: a */
            private final DialogInterfaceC0070b f17667a;

            /* renamed from: b */
            private final boolean[] f17668b;

            /* renamed from: c */
            private final boolean f17669c;

            /* renamed from: d */
            private final Context f17670d;

            /* renamed from: e */
            private final PackageManager f17671e;

            /* renamed from: f */
            private final PackageInfo f17672f;

            /* renamed from: g */
            private final File[] f17673g;

            /* renamed from: h */
            private final boolean f17674h;

            /* renamed from: i */
            private final ApplicationInfo f17675i;

            /* renamed from: j */
            private final File[] f17676j;

            /* renamed from: k */
            private final String[] f17677k;

            /* renamed from: l */
            private final C3081am f17678l;

            /* renamed from: m */
            private final Bitmap f17679m;

            {
                this.f17667a = m438b;
                this.f17668b = zArr;
                this.f17669c = startsWith;
                this.f17670d = context;
                this.f17671e = packageManager;
                this.f17672f = packageInfo;
                this.f17673g = m18570a;
                this.f17674h = z2;
                this.f17675i = applicationInfo;
                this.f17676j = fileArr;
                this.f17677k = m19620a;
                this.f17678l = c3081am;
                this.f17679m = m18372a;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f17667a.m414a(-1);
                if (this.f17668b[0] && Build.VERSION.SDK_INT < 21 && !this.f17669c) {
                    m414a.setEnabled(false);
                }
                m414a.setOnClickListener(new View.OnClickListener(this, this.f17674h, this.f17670d, new C3060a(this.f17670d, this.f17671e, this.f17672f, this.f17673g[0]), this.f17675i, this.f17671e, this.f17672f, this.f17673g, this.f17667a, this.f17668b, this.f17669c, this.f17676j) { // from class: ru.maximoff.apktool.util.al.11.1

                    /* renamed from: a */
                    private final AnonymousClass11 f17680a;

                    /* renamed from: b */
                    private final boolean f17681b;

                    /* renamed from: c */
                    private final Context f17682c;

                    /* renamed from: d */
                    private final C3060a f17683d;

                    /* renamed from: e */
                    private final ApplicationInfo f17684e;

                    /* renamed from: f */
                    private final PackageManager f17685f;

                    /* renamed from: g */
                    private final PackageInfo f17686g;

                    /* renamed from: h */
                    private final File[] f17687h;

                    /* renamed from: i */
                    private final DialogInterfaceC0070b f17688i;

                    /* renamed from: j */
                    private final boolean[] f17689j;

                    /* renamed from: k */
                    private final boolean f17690k;

                    /* renamed from: l */
                    private final File[] f17691l;

                    {
                        this.f17680a = this;
                        this.f17681b = r2;
                        this.f17682c = r3;
                        this.f17683d = r4;
                        this.f17684e = r5;
                        this.f17685f = r6;
                        this.f17686g = r7;
                        this.f17687h = r8;
                        this.f17688i = r9;
                        this.f17689j = r10;
                        this.f17690k = r11;
                        this.f17691l = r12;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String stringBuffer2;
                        int i6;
                        int i7;
                        if (this.f17681b) {
                            try {
                                try {
                                    stringBuffer2 = C3112bn.m18992a(this.f17682c, this.f17683d, C3102bd.m18910a(this.f17682c, "apk_name_tpl", "{LABEL}_v{VERSION}({CODE})"));
                                } catch (Exception e3) {
                                    stringBuffer2 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append((Object) this.f17684e.loadLabel(this.f17685f)).append("_v").toString()).append(C3112bn.m19017b((CharSequence) this.f17686g.versionName)).toString()).append("(").toString()).append(this.f17686g.versionCode).toString()).append(")").toString();
                                }
                                if (this.f17687h.length > 1) {
                                    C3080al.m18557a(this.f17682c, this.f17687h, this.f17683d, C3112bn.m19033h(stringBuffer2), stringBuffer2, false);
                                } else {
                                    try {
                                        new AsyncTaskC2950u(this.f17682c, new StringBuffer().append(C3112bn.m19033h(stringBuffer2)).append(".apk").toString(), false, (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f17687h);
                                    } catch (Exception e4) {
                                        C3112bn.m18999a(this.f17682c, R.string.error_try_again);
                                    }
                                }
                            } catch (Exception e5) {
                                C3112bn.m19023b(this.f17682c, this.f17682c.getString(R.string.errorf, e5.getMessage()));
                            }
                            this.f17688i.cancel();
                            return;
                        }
                        if (this.f17689j[0] && !this.f17690k) {
                            C3262u.m19586a(this.f17682c, this.f17691l[0], (InterfaceC2995n) null, 1, false);
                            this.f17688i.cancel();
                            return;
                        }
                        String m18910a = C3102bd.m18910a(this.f17682c, "install_opt", "0");
                        if (Build.VERSION.SDK_INT < 21) {
                            C3262u.m19590a(this.f17682c, this.f17687h[0], false);
                            this.f17688i.cancel();
                            return;
                        }
                        if (!m18910a.equals("0")) {
                            try {
                                i6 = Integer.parseInt(m18910a);
                            } catch (Exception e6) {
                                i6 = 1;
                            }
                            switch (i6) {
                                case 1:
                                    C3262u.m19590a(this.f17682c, this.f17687h[0], false);
                                    break;
                                case 2:
                                    C3262u.m19590a(this.f17682c, this.f17687h[0], true);
                                    break;
                            }
                            this.f17688i.cancel();
                            return;
                        }
                        C0173ao c0173ao = new C0173ao(this.f17682c, view);
                        if (C3102bd.m18910a(this.f17682c, "menu_position", "1").equals("0")) {
                            i7 = 3;
                        } else {
                            i7 = 5;
                        }
                        c0173ao.m1340a(i7);
                        c0173ao.m1339a().add(0, PointerIcon.TYPE_ALIAS, 0, R.string.install).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17682c, this.f17687h, this.f17688i) { // from class: ru.maximoff.apktool.util.al.11.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f17692a;

                            /* renamed from: b */
                            private final Context f17693b;

                            /* renamed from: c */
                            private final File[] f17694c;

                            /* renamed from: d */
                            private final DialogInterfaceC0070b f17695d;

                            {
                                this.f17692a = this;
                                this.f17693b = r2;
                                this.f17694c = r3;
                                this.f17695d = r4;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                C3262u.m19590a(this.f17693b, this.f17694c[0], false);
                                this.f17695d.cancel();
                                return true;
                            }
                        });
                        c0173ao.m1339a().add(0, PointerIcon.TYPE_COPY, 0, R.string.install_session).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this, this.f17682c, this.f17687h, this.f17688i) { // from class: ru.maximoff.apktool.util.al.11.1.2

                            /* renamed from: a */
                            private final AnonymousClass1 f17696a;

                            /* renamed from: b */
                            private final Context f17697b;

                            /* renamed from: c */
                            private final File[] f17698c;

                            /* renamed from: d */
                            private final DialogInterfaceC0070b f17699d;

                            {
                                this.f17696a = this;
                                this.f17697b = r2;
                                this.f17698c = r3;
                                this.f17699d = r4;
                            }

                            @Override // android.view.MenuItem.OnMenuItemClickListener
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                C3262u.m19590a(this.f17697b, this.f17698c[0], true);
                                this.f17699d.cancel();
                                return true;
                            }
                        });
                        c0173ao.m1344c();
                    }
                });
                m414a.setOnLongClickListener(new View.OnLongClickListener(this, this.f17674h, this.f17668b, this.f17669c, this.f17670d, this.f17673g) { // from class: ru.maximoff.apktool.util.al.11.2

                    /* renamed from: a */
                    private final AnonymousClass11 f17700a;

                    /* renamed from: b */
                    private final boolean f17701b;

                    /* renamed from: c */
                    private final boolean[] f17702c;

                    /* renamed from: d */
                    private final boolean f17703d;

                    /* renamed from: e */
                    private final Context f17704e;

                    /* renamed from: f */
                    private final File[] f17705f;

                    {
                        this.f17700a = this;
                        this.f17701b = r2;
                        this.f17702c = r3;
                        this.f17703d = r4;
                        this.f17704e = r5;
                        this.f17705f = r6;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        if (this.f17701b) {
                            return false;
                        }
                        if (this.f17702c[0] && !this.f17703d) {
                            return false;
                        }
                        C3262u.m19650d(this.f17704e, this.f17705f[0]);
                        return true;
                    }
                });
                this.f17667a.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f17668b, this.f17673g, this.f17669c, this.f17670d, this.f17676j, this.f17677k, this.f17671e, this.f17678l, this.f17667a, this.f17674h) { // from class: ru.maximoff.apktool.util.al.11.3

                    /* renamed from: a */
                    private final AnonymousClass11 f17706a;

                    /* renamed from: b */
                    private final boolean[] f17707b;

                    /* renamed from: c */
                    private final File[] f17708c;

                    /* renamed from: d */
                    private final boolean f17709d;

                    /* renamed from: e */
                    private final Context f17710e;

                    /* renamed from: f */
                    private final File[] f17711f;

                    /* renamed from: g */
                    private final String[] f17712g;

                    /* renamed from: h */
                    private final PackageManager f17713h;

                    /* renamed from: i */
                    private final C3081am f17714i;

                    /* renamed from: j */
                    private final DialogInterfaceC0070b f17715j;

                    /* renamed from: k */
                    private final boolean f17716k;

                    {
                        this.f17706a = this;
                        this.f17707b = r2;
                        this.f17708c = r3;
                        this.f17709d = r4;
                        this.f17710e = r5;
                        this.f17711f = r6;
                        this.f17712g = r7;
                        this.f17713h = r8;
                        this.f17714i = r9;
                        this.f17715j = r10;
                        this.f17716k = r11;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        File[] fileArr2;
                        boolean z3;
                        List<C3071a> list2;
                        List<C3071a> list3;
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        if ((!this.f17707b[0] && this.f17708c.length == 1) || this.f17709d) {
                            fileArr2 = this.f17708c;
                            arrayList.add(this.f17710e.getString(R.string.decompile));
                            arrayList2.add(new Integer(R.string.decompile));
                            arrayList.add(this.f17710e.getString(R.string.sign));
                            arrayList2.add(new Integer(R.string.sign));
                            arrayList.add(this.f17710e.getString(R.string.verify));
                            arrayList2.add(new Integer(R.string.verify));
                            z3 = false;
                        } else if (this.f17707b[0]) {
                            fileArr2 = this.f17711f;
                            if (Build.VERSION.SDK_INT >= 21) {
                                arrayList.add(this.f17710e.getString(R.string.install_sign));
                                arrayList2.add(new Integer(R.string.install_sign));
                            }
                            arrayList.add(this.f17710e.getString(R.string.verify));
                            arrayList2.add(new Integer(R.string.verify));
                            arrayList.add(this.f17710e.getString(R.string.mantisplit));
                            arrayList2.add(new Integer(R.string.mantisplit));
                            z3 = true;
                        } else {
                            fileArr2 = this.f17708c;
                            z3 = this.f17708c.length > 1;
                        }
                        if (this.f17712g != null) {
                            try {
                                list2 = C3080al.m18541a(this.f17710e, this.f17713h, this.f17714i.m18634j());
                                if (!list2.isEmpty()) {
                                    arrayList.add(this.f17710e.getString(R.string.act_list));
                                    arrayList2.add(new Integer(R.string.act_list));
                                }
                            } catch (Exception e3) {
                                list2 = (List) null;
                            }
                            arrayList.add(this.f17710e.getString(R.string.about));
                            arrayList2.add(new Integer(R.string.about));
                            arrayList.add(this.f17710e.getString(R.string.launch_app));
                            arrayList2.add(new Integer(R.string.launch_app));
                            arrayList.add(this.f17710e.getString(R.string.delete));
                            arrayList2.add(new Integer(R.string.delete));
                            list3 = list2;
                        } else {
                            list3 = (List) null;
                        }
                        if (!this.f17714i.m18627c().isEmpty()) {
                            arrayList.add(this.f17710e.getString(R.string.permissions));
                            arrayList2.add(new Integer(R.string.permissions));
                        }
                        arrayList.add(this.f17710e.getString(R.string.previewf, AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME));
                        arrayList2.add(new Integer(R.string.previewf));
                        if (fileArr2[0].getName().endsWith(".apk")) {
                            arrayList.add(this.f17710e.getString(R.string.dexs_info));
                            arrayList2.add(new Integer(R.string.dexs_info));
                            arrayList.add(this.f17710e.getString(R.string.packages));
                            arrayList2.add(new Integer(R.string.packages));
                        }
                        arrayList.add(this.f17710e.getString(R.string.gplay));
                        arrayList2.add(new Integer(R.string.gplay));
                        arrayList.add(this.f17710e.getString(R.string.properties));
                        arrayList2.add(new Integer(R.string.properties));
                        DialogInterfaceC0070b m438b2 = new DialogInterfaceC0070b.a(this.f17710e).m431a((String[]) arrayList.toArray(new String[arrayList.size()]), new DialogInterface.OnClickListener(this, this.f17710e, fileArr2, this.f17714i, arrayList2, this.f17715j, list3, this.f17716k, z3) { // from class: ru.maximoff.apktool.util.al.11.3.1

                            /* renamed from: a */
                            private final AnonymousClass3 f17717a;

                            /* renamed from: b */
                            private final Context f17718b;

                            /* renamed from: c */
                            private final File[] f17719c;

                            /* renamed from: d */
                            private final C3081am f17720d;

                            /* renamed from: e */
                            private final List f17721e;

                            /* renamed from: f */
                            private final DialogInterfaceC0070b f17722f;

                            /* renamed from: g */
                            private final List f17723g;

                            /* renamed from: h */
                            private final boolean f17724h;

                            /* renamed from: i */
                            private final boolean f17725i;

                            {
                                this.f17717a = this;
                                this.f17718b = r2;
                                this.f17719c = fileArr2;
                                this.f17720d = r4;
                                this.f17721e = arrayList2;
                                this.f17722f = r6;
                                this.f17723g = list3;
                                this.f17724h = r8;
                                this.f17725i = z3;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface2, int i6) {
                                C3080al.m18584b(this.f17718b, this.f17719c, this.f17720d, ((Integer) this.f17721e.get(i6)).intValue(), this.f17722f, this.f17723g, this.f17724h, this.f17725i);
                                dialogInterface2.dismiss();
                            }
                        }).m429a(true).m438b();
                        m438b2.setOnShowListener(new DialogInterface.OnShowListener(this, m438b2, arrayList2, this.f17714i, this.f17710e) { // from class: ru.maximoff.apktool.util.al.11.3.2

                            /* renamed from: a */
                            private final AnonymousClass3 f17726a;

                            /* renamed from: b */
                            private final DialogInterfaceC0070b f17727b;

                            /* renamed from: c */
                            private final List f17728c;

                            /* renamed from: d */
                            private final C3081am f17729d;

                            /* renamed from: e */
                            private final Context f17730e;

                            {
                                this.f17726a = this;
                                this.f17727b = m438b2;
                                this.f17728c = arrayList2;
                                this.f17729d = r4;
                                this.f17730e = r5;
                            }

                            @Override // android.content.DialogInterface.OnShowListener
                            public void onShow(DialogInterface dialogInterface2) {
                                this.f17727b.m415a().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(this, this.f17728c, this.f17729d, this.f17730e) { // from class: ru.maximoff.apktool.util.al.11.3.2.1

                                    /* renamed from: a */
                                    private final AnonymousClass2 f17731a;

                                    /* renamed from: b */
                                    private final List f17732b;

                                    /* renamed from: c */
                                    private final C3081am f17733c;

                                    /* renamed from: d */
                                    private final Context f17734d;

                                    {
                                        this.f17731a = this;
                                        this.f17732b = r2;
                                        this.f17733c = r3;
                                        this.f17734d = r4;
                                    }

                                    @Override // android.widget.AdapterView.OnItemLongClickListener
                                    public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i6, long j2) {
                                        if (i6 >= this.f17732b.size() || ((Integer) this.f17732b.get(i6)).intValue() != R.string.gplay) {
                                            return false;
                                        }
                                        C3112bn.m19002a(this.f17734d, String.format("https://play.google.com/store/apps/details?id=%s", this.f17733c.m18634j()));
                                        return true;
                                    }
                                });
                            }
                        });
                        m438b2.show();
                    }
                });
                try {
                    TextView textView = (TextView) this.f17667a.findViewById(R.id.alertTitle);
                    if (textView != null) {
                        textView.setBackgroundResource(this.f17670d.obtainStyledAttributes(new int[]{C0012R.attr.selectableItemBackground}).getResourceId(0, 0));
                        textView.setClickable(true);
                        textView.setOnClickListener(new View.OnClickListener(this, this.f17670d, this.f17675i, this.f17671e) { // from class: ru.maximoff.apktool.util.al.11.4

                            /* renamed from: a */
                            private final AnonymousClass11 f17735a;

                            /* renamed from: b */
                            private final Context f17736b;

                            /* renamed from: c */
                            private final ApplicationInfo f17737c;

                            /* renamed from: d */
                            private final PackageManager f17738d;

                            {
                                this.f17735a = this;
                                this.f17736b = r2;
                                this.f17737c = r3;
                                this.f17738d = r4;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                C3112bn.m19002a(this.f17736b, this.f17737c.loadLabel(this.f17738d).toString());
                            }
                        });
                    }
                    ImageView imageView = (ImageView) this.f17667a.findViewById(C0012R.id.icon);
                    if (imageView != null) {
                        imageView.setOnClickListener(new View.OnClickListener(this, this.f17670d, this.f17675i, this.f17671e) { // from class: ru.maximoff.apktool.util.al.11.5

                            /* renamed from: a */
                            private final AnonymousClass11 f17739a;

                            /* renamed from: b */
                            private final Context f17740b;

                            /* renamed from: c */
                            private final ApplicationInfo f17741c;

                            /* renamed from: d */
                            private final PackageManager f17742d;

                            {
                                this.f17739a = this;
                                this.f17740b = r2;
                                this.f17741c = r3;
                                this.f17742d = r4;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                C3112bn.m19002a(this.f17740b, this.f17741c.loadLabel(this.f17742d).toString());
                            }
                        });
                        imageView.setOnLongClickListener(new View.OnLongClickListener(this, this.f17670d, this.f17676j, this.f17675i, this.f17671e, this.f17672f, this.f17679m) { // from class: ru.maximoff.apktool.util.al.11.6

                            /* renamed from: a */
                            private final AnonymousClass11 f17743a;

                            /* renamed from: b */
                            private final Context f17744b;

                            /* renamed from: c */
                            private final File[] f17745c;

                            /* renamed from: d */
                            private final ApplicationInfo f17746d;

                            /* renamed from: e */
                            private final PackageManager f17747e;

                            /* renamed from: f */
                            private final PackageInfo f17748f;

                            /* renamed from: g */
                            private final Bitmap f17749g;

                            {
                                this.f17743a = this;
                                this.f17744b = r2;
                                this.f17745c = r3;
                                this.f17746d = r4;
                                this.f17747e = r5;
                                this.f17748f = r6;
                                this.f17749g = r7;
                            }

                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                String str3;
                                if (!C3262u.m19664g(this.f17744b, this.f17745c[0]) || C3102bd.m18925a(this.f17744b, "all_to_out_dir", false)) {
                                    str3 = C3102bd.f18339v;
                                    if (str3 == null) {
                                        C3112bn.m19023b(this.f17744b, this.f17744b.getString(R.string.output_directory_not_set));
                                    } else {
                                        File file = new File(str3);
                                        if (!file.exists() && !file.mkdirs()) {
                                            C3112bn.m19023b(this.f17744b, this.f17744b.getString(R.string.output_directory_not_extsts, str3));
                                        } else if (!file.isDirectory()) {
                                            C3112bn.m19023b(this.f17744b, this.f17744b.getString(R.string.not_directory, str3));
                                        }
                                    }
                                    return true;
                                }
                                str3 = this.f17745c[0].getParent();
                                C3112bn.m19023b(this.f17744b, this.f17744b.getString(R.string.extraction, C3067ab.m18383a(this.f17749g, new File(str3, C3262u.m19566a(this.f17744b, str3, C3112bn.m19033h(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append((Object) this.f17746d.loadLabel(this.f17747e)).append("_v").toString()).append(C3112bn.m19017b((CharSequence) this.f17748f.versionName)).toString()).append("_icon").toString()).replaceAll("\\s", "_"), ".png", 0))).getAbsolutePath()));
                                MainActivity.m16615o().m16644z();
                                return true;
                            }
                        });
                    }
                } catch (Exception e3) {
                }
            }
        });
        m438b.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m18584b(Context context, File[] fileArr, C3081am c3081am, int i, DialogInterfaceC0070b dialogInterfaceC0070b, List<C3071a> list, boolean z, boolean z2) {
        int[] iArr = {1, 3};
        switch (i) {
            case R.string.packages /* 2131361886 */:
                new AsyncTaskC2933d(context, new C3060a(context, fileArr[0])).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr[0]);
                break;
            case R.string.dexs_info /* 2131361965 */:
                new AsyncTaskC2944o(context, new C3060a(context, fileArr[0])).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr[0]);
                break;
            case R.string.properties /* 2131362025 */:
                m18553a(context, fileArr[0], (InterfaceC2995n) null);
                break;
            case R.string.launch_app /* 2131362128 */:
                m18599f(context, c3081am.m18634j());
                break;
            case R.string.decompile /* 2131362177 */:
                m18556a(context, (InterfaceC2995n) null, fileArr, fileArr[0].getName(), (String) null);
                dialogInterfaceC0070b.cancel();
                break;
            case R.string.install_sign /* 2131362185 */:
                C3262u.m19586a(context, fileArr[0], (InterfaceC2995n) null, 2, false);
                dialogInterfaceC0070b.cancel();
                break;
            case R.string.verify /* 2131362189 */:
                AsyncTaskC2928bc asyncTaskC2928bc = new AsyncTaskC2928bc(context);
                asyncTaskC2928bc.m17445g(z2);
                asyncTaskC2928bc.m17060b(fileArr[0]);
                try {
                    asyncTaskC2928bc.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr[0]);
                    break;
                } catch (Exception e2) {
                    C3112bn.m18999a(context, R.string.error_try_again);
                    return;
                }
            case R.string.sign /* 2131362195 */:
                iArr[1] = 2;
                Runnable runnable = new Runnable(context, iArr, fileArr) { // from class: ru.maximoff.apktool.util.al.12

                    /* renamed from: a */
                    private final Context f17750a;

                    /* renamed from: b */
                    private final int[] f17751b;

                    /* renamed from: c */
                    private final File[] f17752c;

                    {
                        this.f17750a = context;
                        this.f17751b = iArr;
                        this.f17752c = fileArr;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        C2917as.m17314a(this.f17750a, this.f17751b[0], new C2917as.a(this, this.f17750a, this.f17752c) { // from class: ru.maximoff.apktool.util.al.12.1

                            /* renamed from: a */
                            private final AnonymousClass12 f17753a;

                            /* renamed from: b */
                            private final Context f17754b;

                            /* renamed from: c */
                            private final File[] f17755c;

                            {
                                this.f17753a = this;
                                this.f17754b = r2;
                                this.f17755c = r3;
                            }

                            @Override // ru.maximoff.apktool.p300e.C2917as.a
                            /* renamed from: a */
                            public void mo16440a(C2917as c2917as, boolean z3) {
                                try {
                                    new AsyncTaskC2916ar(this.f17754b, (InterfaceC2995n) null, c2917as).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f17755c[0]);
                                } catch (Exception e3) {
                                    C3112bn.m18999a(this.f17754b, R.string.error_try_again);
                                }
                            }
                        });
                    }
                };
                dialogInterfaceC0070b.cancel();
                if (C3102bd.m18925a(context, "custom_signature_file", false)) {
                    C3262u.m19599a(context, iArr, runnable, (Runnable) null);
                    break;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(runnable, 100L);
                    break;
                }
            case R.string.delete /* 2131362197 */:
                m18601g(context, c3081am.m18634j());
                if (z) {
                    dialogInterfaceC0070b.cancel();
                    break;
                }
                break;
            case R.string.act_list /* 2131362248 */:
                if (list == null || list.isEmpty()) {
                    C3112bn.m18999a(context, R.string.empty);
                    break;
                } else {
                    View inflate = LayoutInflater.from(context).inflate(R.layout.act_list, (ViewGroup) null);
                    MActList mActList = (MActList) inflate.findViewById(R.id.actlistListView1);
                    mActList.setPackage(c3081am.m18634j());
                    mActList.m18408a(list);
                    ((EditText) inflate.findViewById(R.id.actlistEditText1)).addTextChangedListener(new TextWatcher(mActList) { // from class: ru.maximoff.apktool.util.al.15

                        /* renamed from: a */
                        private final MActList f17759a;

                        {
                            this.f17759a = mActList;
                        }

                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            this.f17759a.setFilter(editable.toString());
                        }
                    });
                    DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.act_list)).append(" (").toString()).append(list.size()).toString()).append(")").toString()).m435b(inflate).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
                    mActList.setDialog(m438b);
                    m438b.show();
                    break;
                }
                break;
            case R.string.about /* 2131362340 */:
                m18588c(context, c3081am.m18634j());
                break;
            case R.string.mantisplit /* 2131362512 */:
                C3262u.m19586a(context, fileArr[0], (InterfaceC2995n) null, 0, false);
                dialogInterfaceC0070b.cancel();
                break;
            case R.string.permissions /* 2131362671 */:
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.smali_help, (ViewGroup) null);
                C3309k c3309k = new C3309k(context, c3081am.m18627c(), false);
                CustomListView customListView = (CustomListView) inflate2.findViewById(R.id.smalihelpListView1);
                customListView.setDivider((Drawable) null);
                customListView.setDividerHeight(0);
                customListView.setFastScrollEnabled(C3102bd.f18314av);
                customListView.setAdapter((ListAdapter) c3309k);
                EditText editText = (EditText) inflate2.findViewById(R.id.smalihelpEditText1);
                ImageView imageView = (ImageView) inflate2.findViewById(R.id.clearText1);
                if (C3102bd.f18291a) {
                    imageView.setImageResource(R.drawable.ic_close);
                } else {
                    imageView.setImageResource(R.drawable.ic_close_dark);
                }
                imageView.setOnClickListener(new View.OnClickListener(editText) { // from class: ru.maximoff.apktool.util.al.13

                    /* renamed from: a */
                    private final EditText f17756a;

                    {
                        this.f17756a = editText;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f17756a.requestFocus();
                        this.f17756a.setText("");
                    }
                });
                if (editText.getText().length() == 0) {
                    imageView.setVisibility(8);
                }
                editText.addTextChangedListener(new TextWatcher(imageView, c3309k) { // from class: ru.maximoff.apktool.util.al.14

                    /* renamed from: a */
                    private final ImageView f17757a;

                    /* renamed from: b */
                    private final C3309k f17758b;

                    {
                        this.f17757a = imageView;
                        this.f17758b = c3309k;
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (editable.length() == 0) {
                            this.f17757a.setVisibility(8);
                        } else {
                            this.f17757a.setVisibility(0);
                        }
                        this.f17758b.m19937a(editable.toString());
                    }
                });
                new DialogInterfaceC0070b.a(context).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.permissions)).append(" (").toString()).append(c3081am.m18627c().size()).toString()).append(")").toString()).m435b(inflate2).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
                break;
            case R.string.previewf /* 2131362674 */:
                try {
                    File createTempFile = File.createTempFile(new StringBuffer().append(C3112bn.m19033h(fileArr[0].getName().replaceAll("\\s", "_"))).append("_AndroidManifest_").toString(), ".xml", C3102bd.m18908a());
                    C3061a.m18319b(createTempFile, c3081am.toString());
                    MainActivity.m16615o().m16624a(createTempFile, true);
                } catch (Exception e3) {
                    C3112bn.m19023b(context, context.getString(R.string.errorf, e3.getMessage()));
                }
                dialogInterfaceC0070b.cancel();
                break;
            case R.string.gplay /* 2131362727 */:
                m18603h(context, c3081am.m18634j());
                break;
        }
    }

    /* renamed from: a */
    public static void m18553a(Context context, File file, InterfaceC2995n interfaceC2995n) {
        if (file == null) {
            C3112bn.m18999a(context, R.string.error);
            return;
        }
        try {
            new AsyncTaskC2953x(context, interfaceC2995n).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, file);
        } catch (Exception e2) {
            C3112bn.m18999a(context, R.string.error_try_again);
        }
    }

    /* renamed from: a */
    public static void m18555a(Context context, HashMap<String, String> hashMap) {
        int m18521a = m18521a(context, 5.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(m18521a, m18521a / 2, m18521a, m18521a / 2);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setPadding(m18521a, m18521a, m18521a, m18521a);
        scrollView.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        scrollView.addView(linearLayout, layoutParams);
        String m18975a = C3106bh.m18975a(Long.parseLong(hashMap.get("size")), C3102bd.f18305am);
        LayoutInflater from = LayoutInflater.from(context);
        linearLayout.addView(m18526a(context, from, context.getString(R.string.path_app), hashMap.get("path")), layoutParams2);
        linearLayout.addView(m18527a(context, from, context.getString(R.string.size_label), m18975a, new Runnable(context, hashMap) { // from class: ru.maximoff.apktool.util.al.16

            /* renamed from: a */
            private final Context f17760a;

            /* renamed from: b */
            private final HashMap f17761b;

            {
                this.f17760a = context;
                this.f17761b = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f17760a, (String) this.f17761b.get("size"));
            }
        }), layoutParams2);
        linearLayout.addView(m18526a(context, from, context.getString(R.string.total_filesc), hashMap.get("files")), layoutParams2);
        linearLayout.addView(m18526a(context, from, context.getString(R.string.total_foldersc), hashMap.get("folders")), layoutParams2);
        new DialogInterfaceC0070b.a(context).m418a(R.string.properties).m435b(scrollView).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* renamed from: a */
    public static void m18552a(Context context, File file, HashMap<String, String> hashMap, InterfaceC2995n interfaceC2995n) {
        String m19571a;
        C3253m m19624b;
        int m18521a = m18521a(context, 5.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(m18521a, m18521a / 2, m18521a, m18521a / 2);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setPadding(m18521a, m18521a, m18521a, m18521a);
        scrollView.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        scrollView.addView(linearLayout, layoutParams);
        String m18975a = C3106bh.m18975a(Long.parseLong(hashMap.get("size")), C3102bd.f18305am);
        LayoutInflater from = LayoutInflater.from(context);
        linearLayout.addView(m18527a(context, from, context.getString(R.string.name), file.getName(), new Runnable(context, file) { // from class: ru.maximoff.apktool.util.al.17

            /* renamed from: a */
            private final Context f17762a;

            /* renamed from: b */
            private final File f17763b;

            {
                this.f17762a = context;
                this.f17763b = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f17762a, this.f17763b.getAbsolutePath());
            }
        }), layoutParams2);
        linearLayout.addView(m18526a(context, from, context.getString(R.string.path_app), file.getParent()), layoutParams2);
        linearLayout.addView(m18527a(context, from, context.getString(R.string.size_label), m18975a, new Runnable(context, hashMap) { // from class: ru.maximoff.apktool.util.al.18

            /* renamed from: a */
            private final Context f17764a;

            /* renamed from: b */
            private final HashMap f17765b;

            {
                this.f17764a = context;
                this.f17765b = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f17764a, (String) this.f17765b.get("size"));
            }
        }), layoutParams2);
        String[] strArr = {C3112bn.m18989a(file.lastModified())};
        View m18528a = m18528a(context, from, context.getString(R.string.modified), strArr[0], new Runnable(context, strArr, file, r8, interfaceC2995n) { // from class: ru.maximoff.apktool.util.al.19

            /* renamed from: a */
            private final Context f17766a;

            /* renamed from: b */
            private final String[] f17767b;

            /* renamed from: c */
            private final File f17768c;

            /* renamed from: d */
            private final TextView[] f17769d;

            /* renamed from: e */
            private final InterfaceC2995n f17770e;

            {
                this.f17766a = context;
                this.f17767b = strArr;
                this.f17768c = file;
                this.f17769d = r4;
                this.f17770e = interfaceC2995n;
            }

            @Override // java.lang.Runnable
            public void run() {
                View inflate = LayoutInflater.from(this.f17766a).inflate(R.layout.rename_one, (ViewGroup) null);
                EditText editText = (EditText) inflate.findViewById(R.id.renameoneEditText1);
                editText.setSingleLine(true);
                editText.setText(this.f17767b[0]);
                editText.setHint(this.f17767b[0]);
                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.renameoneLinearLayout2);
                if (this.f17768c.isDirectory()) {
                    linearLayout2.setVisibility(0);
                } else {
                    linearLayout2.setVisibility(8);
                }
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.renameoneCheckBox1);
                CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.renameoneCheckBox2);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.renameoneImageView1);
                imageView.setVisibility(0);
                if (C3102bd.f18291a) {
                    imageView.setImageResource(R.drawable.ic_paste_light);
                } else {
                    imageView.setImageResource(R.drawable.ic_paste_dark);
                }
                imageView.setOnClickListener(new View.OnClickListener(this, this.f17766a, editText) { // from class: ru.maximoff.apktool.util.al.19.1

                    /* renamed from: a */
                    private final AnonymousClass19 f17771a;

                    /* renamed from: b */
                    private final Context f17772b;

                    /* renamed from: c */
                    private final EditText f17773c;

                    {
                        this.f17771a = this;
                        this.f17772b = r2;
                        this.f17773c = editText;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String m18991a = C3112bn.m18991a(this.f17772b);
                        if (m18991a != null) {
                            C3112bn.m19007a(this.f17773c, (CharSequence) m18991a);
                        } else {
                            C3112bn.m18999a(this.f17772b, R.string.empty);
                        }
                    }
                });
                imageView.setOnLongClickListener(new View.OnLongClickListener(this, this.f17766a, editText) { // from class: ru.maximoff.apktool.util.al.19.2

                    /* renamed from: a */
                    private final AnonymousClass19 f17774a;

                    /* renamed from: b */
                    private final Context f17775b;

                    /* renamed from: c */
                    private final EditText f17776c;

                    {
                        this.f17774a = this;
                        this.f17775b = r2;
                        this.f17776c = editText;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        String m18991a = C3112bn.m18991a(this.f17775b);
                        if (m18991a == null) {
                            return false;
                        }
                        this.f17776c.setText(m18991a);
                        this.f17776c.requestFocus();
                        this.f17776c.setSelection(m18991a.length());
                        return true;
                    }
                });
                TextView textView = (TextView) inflate.findViewById(R.id.renameoneTextView1);
                C3112bn.m19009a(textView, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f17766a.getString(R.string.modified)).append(" (").toString()).append(C3102bd.f18266B).toString()).append(")").toString());
                textView.setOnClickListener(new View.OnClickListener(this, editText, this.f17767b) { // from class: ru.maximoff.apktool.util.al.19.3

                    /* renamed from: a */
                    private final AnonymousClass19 f17777a;

                    /* renamed from: b */
                    private final EditText f17778b;

                    /* renamed from: c */
                    private final String[] f17779c;

                    {
                        this.f17777a = this;
                        this.f17778b = editText;
                        this.f17779c = r3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        this.f17778b.setText(this.f17779c[0]);
                        this.f17778b.requestFocus();
                        this.f17778b.setSelection(this.f17779c[0].length());
                    }
                });
                textView.setOnLongClickListener(new View.OnLongClickListener(this, editText) { // from class: ru.maximoff.apktool.util.al.19.4

                    /* renamed from: a */
                    private final AnonymousClass19 f17780a;

                    /* renamed from: b */
                    private final EditText f17781b;

                    {
                        this.f17780a = this;
                        this.f17781b = editText;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        String m19032g = C3112bn.m19032g(C3102bd.f18266B);
                        this.f17781b.setText(m19032g);
                        this.f17781b.requestFocus();
                        this.f17781b.setSelection(m19032g.length());
                        return true;
                    }
                });
                DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(this.f17766a).m435b(inflate).m427a(this.f17768c.getName()).m420a(R.string.save, new DialogInterface.OnClickListener(this, editText, this.f17768c, checkBox, checkBox2, this.f17767b, this.f17769d, this.f17770e, this.f17766a) { // from class: ru.maximoff.apktool.util.al.19.5

                    /* renamed from: a */
                    private final AnonymousClass19 f17782a;

                    /* renamed from: b */
                    private final EditText f17783b;

                    /* renamed from: c */
                    private final File f17784c;

                    /* renamed from: d */
                    private final CheckBox f17785d;

                    /* renamed from: e */
                    private final CheckBox f17786e;

                    /* renamed from: f */
                    private final String[] f17787f;

                    /* renamed from: g */
                    private final TextView[] f17788g;

                    /* renamed from: h */
                    private final InterfaceC2995n f17789h;

                    /* renamed from: i */
                    private final Context f17790i;

                    {
                        this.f17782a = this;
                        this.f17783b = editText;
                        this.f17784c = r3;
                        this.f17785d = checkBox;
                        this.f17786e = checkBox2;
                        this.f17787f = r6;
                        this.f17788g = r7;
                        this.f17789h = r8;
                        this.f17790i = r9;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        long time;
                        try {
                            time = new SimpleDateFormat(C3102bd.f18266B).parse(this.f17783b.getText().toString()).getTime();
                        } catch (Exception e2) {
                            C3112bn.m19000a(this.f17790i, R.string.errorf, e2.getMessage());
                        }
                        if (!C3262u.m19611a(this.f17784c, time, true)) {
                            throw new Exception("file modification time change error");
                        }
                        if (this.f17784c.isDirectory()) {
                            C3262u.m19607a(this.f17784c, time, this.f17785d.isChecked(), this.f17786e.isChecked(), true);
                        }
                        this.f17787f[0] = C3112bn.m18989a(time);
                        if (this.f17788g[0] != null) {
                            C3112bn.m19009a(this.f17788g[0], this.f17787f[0]);
                        }
                        if (this.f17789h != null) {
                            this.f17789h.mo17929a();
                        } else {
                            MainActivity.m16615o().m16637s();
                        }
                        C3112bn.m18999a(this.f17790i, R.string.success);
                        dialogInterface.cancel();
                    }
                }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.paste, (DialogInterface.OnClickListener) null).m438b();
                m438b.getWindow().setSoftInputMode(4);
                m438b.setOnShowListener(new DialogInterface.OnShowListener(this, m438b, this.f17766a, editText) { // from class: ru.maximoff.apktool.util.al.19.6

                    /* renamed from: a */
                    private final AnonymousClass19 f17791a;

                    /* renamed from: b */
                    private final DialogInterfaceC0070b f17792b;

                    /* renamed from: c */
                    private final Context f17793c;

                    /* renamed from: d */
                    private final EditText f17794d;

                    {
                        this.f17791a = this;
                        this.f17792b = m438b;
                        this.f17793c = r3;
                        this.f17794d = editText;
                    }

                    @Override // android.content.DialogInterface.OnShowListener
                    public void onShow(DialogInterface dialogInterface) {
                        Button m414a = this.f17792b.m414a(-3);
                        try {
                            m414a.setTypeface(Typeface.createFromAsset(this.f17793c.getAssets(), "icofont.ttf"));
                            m414a.setText(R.string.clock_icon);
                        } catch (Exception e2) {
                            m414a.setTypeface(Typeface.DEFAULT);
                            m414a.setText(R.string.paste);
                        }
                        m414a.setOnClickListener(new View.OnClickListener(this, this.f17794d) { // from class: ru.maximoff.apktool.util.al.19.6.1

                            /* renamed from: a */
                            private final AnonymousClass6 f17795a;

                            /* renamed from: b */
                            private final EditText f17796b;

                            {
                                this.f17795a = this;
                                this.f17796b = r2;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                String m19032g = C3112bn.m19032g(C3102bd.f18266B);
                                this.f17796b.setText(m19032g);
                                this.f17796b.requestFocus();
                                this.f17796b.setSelection(m19032g.length());
                            }
                        });
                        this.f17794d.requestFocus();
                        this.f17794d.selectAll();
                    }
                });
                m438b.show();
            }
        }, new Runnable(context, strArr) { // from class: ru.maximoff.apktool.util.al.20

            /* renamed from: a */
            private final Context f17802a;

            /* renamed from: b */
            private final String[] f17803b;

            {
                this.f17802a = context;
                this.f17803b = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f17802a, this.f17803b[0]);
            }
        });
        TextView[] textViewArr = {(TextView) m18528a.findViewById(R.id.linelayoutTextView2)};
        C3112bn.m19009a(textViewArr[0], strArr[0]);
        linearLayout.addView(m18528a, layoutParams2);
        if (hashMap.get("chmod") != null) {
            linearLayout.addView(m18526a(context, from, context.getString(R.string.permissions), hashMap.get("chmod")), layoutParams2);
            linearLayout.addView(m18526a(context, from, context.getString(R.string.owner), hashMap.get("owner")), layoutParams2);
            linearLayout.addView(m18526a(context, from, context.getString(R.string.group), hashMap.get(WifiConfiguration.GroupCipher.varName)), layoutParams2);
        }
        if (file.isDirectory()) {
            try {
                linearLayout.addView(m18526a(context, from, context.getString(R.string.total_filesc), hashMap.get("files")), layoutParams2);
                linearLayout.addView(m18526a(context, from, context.getString(R.string.total_foldersc), hashMap.get("folders")), layoutParams2);
            } catch (Exception e2) {
            }
        } else {
            if (C3262u.m19647c(file)) {
                try {
                    InterfaceC1075c m8994a = C1076d.m8992a().m8994a(file.getAbsolutePath());
                    ArrayList arrayList = new ArrayList();
                    byte mo8990b = m8994a.mo8990b();
                    if (mo8990b != 0) {
                        arrayList.add(mo8990b == 1 ? "32-bit" : "64-bit");
                    }
                    byte mo8991c = m8994a.mo8991c();
                    if (mo8991c != 0) {
                        arrayList.add(mo8991c == 1 ? "LSB" : "MSB");
                    }
                    short mo9001a = m8994a.mo8989a().mo9001a();
                    if (mo9001a != 0) {
                        arrayList.add(C1078f.m9003a(mo9001a));
                    }
                    short mo9002b = m8994a.mo8989a().mo9002b();
                    if (mo9002b != 0) {
                        arrayList.add(C1078f.m9004b(mo9002b));
                    }
                    if (!arrayList.isEmpty()) {
                        linearLayout.addView(m18526a(context, from, "ELF", m18538a(arrayList, ", ")), layoutParams2);
                    }
                } catch (Error e3) {
                } catch (Exception e4) {
                }
            }
            String m19017b = C3112bn.m19017b((CharSequence) hashMap.get("public_id"));
            String m19017b2 = C3112bn.m19017b((CharSequence) hashMap.get(KeyProperties.DIGEST_MD5));
            String m19017b3 = C3112bn.m19017b((CharSequence) hashMap.get(KeyProperties.DIGEST_SHA1));
            String m19017b4 = C3112bn.m19017b((CharSequence) hashMap.get(KeyProperties.DIGEST_SHA224));
            String m19017b5 = C3112bn.m19017b((CharSequence) hashMap.get(KeyProperties.DIGEST_SHA256));
            String m19017b6 = C3112bn.m19017b((CharSequence) hashMap.get(KeyProperties.DIGEST_SHA384));
            String m19017b7 = C3112bn.m19017b((CharSequence) hashMap.get(KeyProperties.DIGEST_SHA512));
            String m19017b8 = C3112bn.m19017b((CharSequence) hashMap.get("CRC32"));
            String m19017b9 = C3112bn.m19017b((CharSequence) hashMap.get(new StringBuffer().append("Long_").append("CRC32").toString()));
            if (Build.VERSION.SDK_INT >= 24) {
                m19571a = context.getContentResolver().getType(FileProvider.m1838a(context, new StringBuffer().append(context.getPackageName()).append(".outprovider").toString(), file));
            } else {
                m19571a = C3262u.m19571a(Uri.fromFile(file).toString());
            }
            if (C3112bn.m19040o(m19571a)) {
                m19571a = "application/octet-stream";
            }
            linearLayout.addView(m18526a(context, from, context.getString(R.string.mime_type), m19571a), layoutParams2);
            if (file.getName().toLowerCase().endsWith(".dex") && (m19624b = C3262u.m19624b(file)) != null) {
                linearLayout.addView(m18526a(context, from, context.getString(R.string.dex_version), m19624b.f19655a), layoutParams2);
                linearLayout.addView(m18526a(context, from, context.getString(R.string.methods_count), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(String.valueOf(m19624b.f19660f)).append(" (").toString()).append(m18531a(65536, m19624b.f19660f, 2)).toString()).append(")").toString()), layoutParams2);
                linearLayout.addView(m18526a(context, from, context.getString(R.string.fields_count), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(String.valueOf(m19624b.f19659e)).append(" (").toString()).append(m18531a(65536, m19624b.f19659e, 2)).toString()).append(")").toString()), layoutParams2);
                linearLayout.addView(m18526a(context, from, context.getString(R.string.strings_count), String.valueOf(m19624b.f19656b)), layoutParams2);
                linearLayout.addView(m18526a(context, from, context.getString(R.string.class_count), String.valueOf(m19624b.f19661g)), layoutParams2);
                linearLayout.addView(m18526a(context, from, context.getString(R.string.types_count), String.valueOf(m19624b.f19657c)), layoutParams2);
                linearLayout.addView(m18526a(context, from, context.getString(R.string.protos_count), String.valueOf(m19624b.f19658d)), layoutParams2);
            }
            if (!C3112bn.m19040o(m19017b)) {
                linearLayout.addView(m18526a(context, from, "ID", m19017b), layoutParams2);
            }
            if (!m19017b8.isEmpty()) {
                linearLayout.addView(m18527a(context, from, "CRC32", m19017b8, new Runnable(m19017b9, context) { // from class: ru.maximoff.apktool.util.al.21

                    /* renamed from: a */
                    private final String f17804a;

                    /* renamed from: b */
                    private final Context f17805b;

                    {
                        this.f17804a = m19017b9;
                        this.f17805b = context;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (this.f17804a.isEmpty()) {
                            return;
                        }
                        C3112bn.m19002a(this.f17805b, this.f17804a);
                    }
                }), layoutParams2);
            }
            if (!m19017b2.isEmpty()) {
                linearLayout.addView(m18526a(context, from, KeyProperties.DIGEST_MD5, m19017b2), layoutParams2);
            }
            if (!m19017b3.isEmpty()) {
                linearLayout.addView(m18526a(context, from, KeyProperties.DIGEST_SHA1, m19017b3), layoutParams2);
            }
            if (!m19017b4.isEmpty()) {
                linearLayout.addView(m18526a(context, from, KeyProperties.DIGEST_SHA224, m19017b4), layoutParams2);
            }
            if (!m19017b5.isEmpty()) {
                linearLayout.addView(m18526a(context, from, KeyProperties.DIGEST_SHA256, m19017b5), layoutParams2);
            }
            if (!m19017b6.isEmpty()) {
                linearLayout.addView(m18526a(context, from, KeyProperties.DIGEST_SHA384, m19017b6), layoutParams2);
            }
            if (!m19017b7.isEmpty()) {
                linearLayout.addView(m18526a(context, from, KeyProperties.DIGEST_SHA512, m19017b7), layoutParams2);
            }
            View inflate = from.inflate(R.layout.checksum, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.checksumTextView1);
            textView.setTextSize(2, C3102bd.f18332o);
            EditText editText = (EditText) inflate.findViewById(R.id.checksumEditText1);
            ((Button) inflate.findViewById(R.id.checksumButton1)).setOnClickListener(new View.OnClickListener(context, editText) { // from class: ru.maximoff.apktool.util.al.22

                /* renamed from: a */
                private final Context f17806a;

                /* renamed from: b */
                private final EditText f17807b;

                {
                    this.f17806a = context;
                    this.f17807b = editText;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String m18991a = C3112bn.m18991a(this.f17806a);
                    if (m18991a != null) {
                        this.f17807b.setText(m18991a);
                        this.f17807b.setSelection(this.f17807b.getText().length());
                    }
                }
            });
            editText.addTextChangedListener(new TextWatcher(context, textView, m19017b2, m19017b3, m19017b4, m19017b5, m19017b6, m19017b7, m19017b8, m19017b9, m19017b) { // from class: ru.maximoff.apktool.util.al.23

                /* renamed from: a */
                private final Context f17808a;

                /* renamed from: b */
                private final TextView f17809b;

                /* renamed from: c */
                private final String f17810c;

                /* renamed from: d */
                private final String f17811d;

                /* renamed from: e */
                private final String f17812e;

                /* renamed from: f */
                private final String f17813f;

                /* renamed from: g */
                private final String f17814g;

                /* renamed from: h */
                private final String f17815h;

                /* renamed from: i */
                private final String f17816i;

                /* renamed from: j */
                private final String f17817j;

                /* renamed from: k */
                private final String f17818k;

                {
                    this.f17808a = context;
                    this.f17809b = textView;
                    this.f17810c = m19017b2;
                    this.f17811d = m19017b3;
                    this.f17812e = m19017b4;
                    this.f17813f = m19017b5;
                    this.f17814g = m19017b6;
                    this.f17815h = m19017b7;
                    this.f17816i = m19017b8;
                    this.f17817j = m19017b9;
                    this.f17818k = m19017b;
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String trim = editable.toString().toLowerCase().trim();
                    String string = this.f17808a.getString(R.string.check_hash);
                    if (C3112bn.m19040o(trim)) {
                        this.f17809b.setText(string);
                        return;
                    }
                    String lowerCase = trim.replace(":", "").toLowerCase();
                    String lowerCase2 = this.f17810c.replace(":", "").toLowerCase();
                    String lowerCase3 = this.f17811d.replace(":", "").toLowerCase();
                    String lowerCase4 = this.f17812e.replace(":", "").toLowerCase();
                    String lowerCase5 = this.f17813f.replace(":", "").toLowerCase();
                    String lowerCase6 = this.f17814g.replace(":", "").toLowerCase();
                    String lowerCase7 = this.f17815h.replace(":", "").toLowerCase();
                    int m19470a = C3246h.m19470a(this.f17808a, R.color.dark_red);
                    String string2 = this.f17808a.getString(R.string.not_match);
                    String string3 = this.f17808a.getString(R.string.matches);
                    String string4 = this.f17808a.getString(R.string.part_matches);
                    if (lowerCase.equals(lowerCase2)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_MD5).append(" ").toString()).append(string3).toString();
                    } else if (lowerCase.equals(lowerCase3)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA1).append(" ").toString()).append(string3).toString();
                    } else if (lowerCase.equals(lowerCase4)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA224).append(" ").toString()).append(string3).toString();
                    } else if (lowerCase.equals(lowerCase5)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA256).append(" ").toString()).append(string3).toString();
                    } else if (lowerCase.equals(lowerCase6)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA384).append(" ").toString()).append(string3).toString();
                    } else if (lowerCase.equals(lowerCase7)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA512).append(" ").toString()).append(string3).toString();
                    } else if (trim.equalsIgnoreCase(this.f17816i) || trim.equals(this.f17817j)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append("CRC32").append(" ").toString()).append(string3).toString();
                    } else if (!C3112bn.m19040o(this.f17818k) && trim.equalsIgnoreCase(this.f17818k)) {
                        m19470a = C3246h.m19470a(this.f17808a, R.color.dark_green);
                        string2 = new StringBuffer().append(new StringBuffer().append("ID").append(" ").toString()).append(string3).toString();
                    } else if (lowerCase.length() > 8) {
                        if (lowerCase2.length() > lowerCase.length() && lowerCase2.contains(lowerCase)) {
                            m19470a = C3246h.m19470a(this.f17808a, R.color.light_orange);
                            string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_MD5).append(" ").toString()).append(string4).toString();
                        } else if (lowerCase3.length() > lowerCase.length() && lowerCase3.contains(lowerCase)) {
                            m19470a = C3246h.m19470a(this.f17808a, R.color.light_orange);
                            string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA1).append(" ").toString()).append(string4).toString();
                        } else if (lowerCase4.length() > lowerCase.length() && lowerCase4.contains(lowerCase)) {
                            m19470a = C3246h.m19470a(this.f17808a, R.color.light_orange);
                            string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA224).append(" ").toString()).append(string4).toString();
                        } else if (lowerCase5.length() > lowerCase.length() && lowerCase5.contains(lowerCase)) {
                            m19470a = C3246h.m19470a(this.f17808a, R.color.light_orange);
                            string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA256).append(" ").toString()).append(string4).toString();
                        } else if (lowerCase6.length() > lowerCase.length() && lowerCase6.contains(lowerCase)) {
                            m19470a = C3246h.m19470a(this.f17808a, R.color.light_orange);
                            string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA384).append(" ").toString()).append(string4).toString();
                        } else if (lowerCase7.length() > lowerCase.length() && lowerCase7.contains(lowerCase)) {
                            m19470a = C3246h.m19470a(this.f17808a, R.color.light_orange);
                            string2 = new StringBuffer().append(new StringBuffer().append(KeyProperties.DIGEST_SHA512).append(" ").toString()).append(string4).toString();
                        }
                    }
                    SpannableString spannableString = new SpannableString(new StringBuffer().append(new StringBuffer().append(string).append(": ").toString()).append(string2).toString());
                    spannableString.setSpan(new ForegroundColorSpan(m19470a), string.length() + 2, string.length() + string2.length() + 2, 33);
                    spannableString.setSpan(new StyleSpan(1), string.length() + 2, string2.length() + string.length() + 2, 33);
                    this.f17809b.setText(spannableString);
                }
            });
            linearLayout.addView(inflate, layoutParams2);
        }
        DialogInterfaceC0070b.a m420a = new DialogInterfaceC0070b.a(context).m427a(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(context.getString(R.string.properties)).append(" \"").toString()).append(file.getName()).toString()).append("\"").toString()).m435b(scrollView).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null);
        if (file.isFile()) {
            m420a.m440c(R.string.settings, (DialogInterface.OnClickListener) null);
        }
        DialogInterfaceC0070b m438b = m420a.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(file, m438b, context, interfaceC2995n) { // from class: ru.maximoff.apktool.util.al.24

            /* renamed from: a */
            private final File f17819a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f17820b;

            /* renamed from: c */
            private final Context f17821c;

            /* renamed from: d */
            private final InterfaceC2995n f17822d;

            {
                this.f17819a = file;
                this.f17820b = m438b;
                this.f17821c = context;
                this.f17822d = interfaceC2995n;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (!this.f17819a.isFile()) {
                    return;
                }
                this.f17820b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f17821c, this.f17820b, this.f17819a, this.f17822d) { // from class: ru.maximoff.apktool.util.al.24.1

                    /* renamed from: a */
                    private final AnonymousClass24 f17823a;

                    /* renamed from: b */
                    private final Context f17824b;

                    /* renamed from: c */
                    private final DialogInterfaceC0070b f17825c;

                    /* renamed from: d */
                    private final File f17826d;

                    /* renamed from: e */
                    private final InterfaceC2995n f17827e;

                    {
                        this.f17823a = this;
                        this.f17824b = r2;
                        this.f17825c = r3;
                        this.f17826d = r4;
                        this.f17827e = r5;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String[] stringArray = this.f17824b.getResources().getStringArray(R.array.checksum_names);
                        String[] stringArray2 = this.f17824b.getResources().getStringArray(R.array.checksum_keys);
                        boolean[] zArr = new boolean[stringArray2.length];
                        for (int i = 0; i < stringArray2.length; i++) {
                            zArr[i] = C3102bd.m18925a(this.f17824b, stringArray2[i], false);
                        }
                        new DialogInterfaceC0070b.a(this.f17824b).m418a(R.string.checksum_format).m432a(stringArray, zArr, new DialogInterface.OnMultiChoiceClickListener(this, zArr) { // from class: ru.maximoff.apktool.util.al.24.1.1

                            /* renamed from: a */
                            private final AnonymousClass1 f17828a;

                            /* renamed from: b */
                            private final boolean[] f17829b;

                            {
                                this.f17828a = this;
                                this.f17829b = zArr;
                            }

                            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                            public void onClick(DialogInterface dialogInterface2, int i2, boolean z) {
                                this.f17829b[i2] = z;
                            }
                        }).m420a(R.string.save, new DialogInterface.OnClickListener(this, stringArray2, this.f17824b, zArr, this.f17825c, this.f17826d, this.f17827e) { // from class: ru.maximoff.apktool.util.al.24.1.2

                            /* renamed from: a */
                            private final AnonymousClass1 f17830a;

                            /* renamed from: b */
                            private final String[] f17831b;

                            /* renamed from: c */
                            private final Context f17832c;

                            /* renamed from: d */
                            private final boolean[] f17833d;

                            /* renamed from: e */
                            private final DialogInterfaceC0070b f17834e;

                            /* renamed from: f */
                            private final File f17835f;

                            /* renamed from: g */
                            private final InterfaceC2995n f17836g;

                            {
                                this.f17830a = this;
                                this.f17831b = stringArray2;
                                this.f17832c = r3;
                                this.f17833d = zArr;
                                this.f17834e = r5;
                                this.f17835f = r6;
                                this.f17836g = r7;
                            }

                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface2, int i2) {
                                for (int i3 = 0; i3 < this.f17831b.length; i3++) {
                                    C3102bd.m18938b(this.f17832c, this.f17831b[i3], this.f17833d[i3]);
                                }
                                dialogInterface2.cancel();
                                this.f17834e.cancel();
                                C3080al.m18553a(this.f17832c, this.f17835f, this.f17836g);
                            }
                        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static View m18526a(Context context, LayoutInflater layoutInflater, CharSequence charSequence, CharSequence charSequence2) {
        return m18528a(context, layoutInflater, charSequence, charSequence2, new Runnable(context, charSequence2) { // from class: ru.maximoff.apktool.util.al.25

            /* renamed from: a */
            private final Context f17837a;

            /* renamed from: b */
            private final CharSequence f17838b;

            {
                this.f17837a = context;
                this.f17838b = charSequence2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f17837a, this.f17838b.toString());
            }
        }, (Runnable) null);
    }

    /* renamed from: a */
    public static View m18527a(Context context, LayoutInflater layoutInflater, CharSequence charSequence, CharSequence charSequence2, Runnable runnable) {
        return m18528a(context, layoutInflater, charSequence, charSequence2, new Runnable(context, charSequence2) { // from class: ru.maximoff.apktool.util.al.26

            /* renamed from: a */
            private final Context f17839a;

            /* renamed from: b */
            private final CharSequence f17840b;

            {
                this.f17839a = context;
                this.f17840b = charSequence2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C3112bn.m19002a(this.f17839a, this.f17840b.toString());
            }
        }, runnable);
    }

    /* renamed from: a */
    public static View m18528a(Context context, LayoutInflater layoutInflater, CharSequence charSequence, CharSequence charSequence2, Runnable runnable, Runnable runnable2) {
        View inflate = layoutInflater.inflate(R.layout.line_layout, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.linelayoutTextView1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.linelayoutTextView2);
        textView.setText(charSequence);
        textView2.setText(charSequence2);
        textView.setTextSize(2, C3102bd.f18332o);
        textView2.setTextSize(2, C3102bd.f18332o - 2);
        if (runnable != null) {
            textView2.setOnClickListener(new View.OnClickListener(runnable) { // from class: ru.maximoff.apktool.util.al.27

                /* renamed from: a */
                private final Runnable f17841a;

                {
                    this.f17841a = runnable;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f17841a.run();
                }
            });
        }
        if (runnable2 != null) {
            textView2.setOnLongClickListener(new View.OnLongClickListener(runnable2) { // from class: ru.maximoff.apktool.util.al.28

                /* renamed from: a */
                private final Runnable f17842a;

                {
                    this.f17842a = runnable2;
                }

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    this.f17842a.run();
                    return true;
                }
            });
        }
        return inflate;
    }

    /* renamed from: a */
    public static void m18556a(Context context, InterfaceC2995n interfaceC2995n, File[] fileArr, String str, String str2) {
        Button[] buttonArr = new Button[1];
        boolean[] zArr = {false};
        View inflate = LayoutInflater.from(context).inflate(R.layout.decompile, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.decompileCheckBox2);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.decompileCheckBox3);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.decompileCheckBox1);
        CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.decompileCheckBox4);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.decompileSpinner0);
        Spinner spinner2 = (Spinner) inflate.findViewById(R.id.decompileSpinner1);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.decompileImageView1);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.decompileImageView2);
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_help_light);
            imageView2.setImageResource(R.drawable.ic_help_light);
        } else {
            imageView.setImageResource(R.drawable.ic_help_dark);
            imageView2.setImageResource(R.drawable.ic_help_dark);
        }
        boolean m18946d = C3102bd.m18946d();
        spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, context.getResources().getStringArray(R.array.store_type)));
        spinner.setSelection((C3102bd.f18316ax && m18946d) ? 1 : 0);
        spinner.setEnabled(m18946d);
        spinner.setOnLongClickListener(new View.OnLongClickListener(context, spinner) { // from class: ru.maximoff.apktool.util.al.29

            /* renamed from: a */
            private final Context f17843a;

            /* renamed from: b */
            private final Spinner f17844b;

            {
                this.f17843a = context;
                this.f17844b = spinner;
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                C3080al.m18550a(this.f17843a, this.f17844b, 0);
                return true;
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener(context) { // from class: ru.maximoff.apktool.util.al.30

            /* renamed from: a */
            private final Context f17847a;

            {
                this.f17847a = context;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                int i2;
                switch (view.getId()) {
                    case R.id.decompileImageView1 /* 2131689728 */:
                        i = R.string.dex_decompile_info;
                        i2 = R.string.decompile_dex;
                        break;
                    case R.id.decompileCheckBox1 /* 2131689729 */:
                    default:
                        i = R.string.minfo;
                        i2 = R.string.minfo;
                        break;
                    case R.id.decompileImageView2 /* 2131689730 */:
                        i = R.string.dex_decompile_info2;
                        i2 = R.string.decompile_all_dex;
                        break;
                }
                new DialogInterfaceC0070b.a(this.f17847a).m418a(i2).m433b(i).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m438b().show();
            }
        };
        imageView.setOnClickListener(onClickListener);
        imageView2.setOnClickListener(onClickListener);
        spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(context, C0012R.layout.simple_spinner_dropdown_item, context.getResources().getStringArray(R.array.resDecodeMode)));
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(checkBox2, checkBox3, buttonArr, checkBox) { // from class: ru.maximoff.apktool.util.al.31

            /* renamed from: a */
            private final CheckBox f17848a;

            /* renamed from: b */
            private final CheckBox f17849b;

            /* renamed from: c */
            private final Button[] f17850c;

            /* renamed from: d */
            private final CheckBox f17851d;

            {
                this.f17848a = checkBox2;
                this.f17849b = checkBox3;
                this.f17850c = buttonArr;
                this.f17851d = checkBox;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                boolean z = false;
                this.f17848a.setEnabled(i != 3);
                this.f17849b.setEnabled(i != 3 && this.f17848a.isChecked() && this.f17848a.isEnabled());
                if (this.f17850c[0] != null) {
                    Button button = this.f17850c[0];
                    if (this.f17851d.isChecked() || (this.f17848a.isChecked() && this.f17848a.isEnabled())) {
                        z = true;
                    }
                    button.setEnabled(z);
                }
            }
        });
        spinner2.setSelection(C3102bd.m18905a(context, "dcode_mrs", 0));
        checkBox.setChecked(C3102bd.m18925a(context, "dcode_rs", true));
        checkBox2.setChecked(C3102bd.m18925a(context, "dcode_dx", false));
        checkBox4.setChecked(C3102bd.m18925a(context, "add_nomedia", true));
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m427a(str);
        aVar.m435b(inflate);
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m420a(R.string.f21470ok, new DialogInterface.OnClickListener(spinner, m18946d, context, spinner2, interfaceC2995n, str2, checkBox, checkBox2, zArr, checkBox3, checkBox4, fileArr) { // from class: ru.maximoff.apktool.util.al.32

            /* renamed from: a */
            private final Spinner f17852a;

            /* renamed from: b */
            private final boolean f17853b;

            /* renamed from: c */
            private final Context f17854c;

            /* renamed from: d */
            private final Spinner f17855d;

            /* renamed from: e */
            private final InterfaceC2995n f17856e;

            /* renamed from: f */
            private final String f17857f;

            /* renamed from: g */
            private final CheckBox f17858g;

            /* renamed from: h */
            private final CheckBox f17859h;

            /* renamed from: i */
            private final boolean[] f17860i;

            /* renamed from: j */
            private final CheckBox f17861j;

            /* renamed from: k */
            private final CheckBox f17862k;

            /* renamed from: l */
            private final File[] f17863l;

            {
                this.f17852a = spinner;
                this.f17853b = m18946d;
                this.f17854c = context;
                this.f17855d = spinner2;
                this.f17856e = interfaceC2995n;
                this.f17857f = str2;
                this.f17858g = checkBox;
                this.f17859h = checkBox2;
                this.f17860i = zArr;
                this.f17861j = checkBox3;
                this.f17862k = checkBox4;
                this.f17863l = fileArr;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C0518d c0518d = C0518d.f3579w;
                if (this.f17852a.getSelectedItemPosition() == 0 || !this.f17853b) {
                    C3102bd.m18938b(this.f17854c, "user_frameworks", false);
                    C3102bd.f18316ax = false;
                    c0518d.f3598s = C3102bd.f18322e;
                } else {
                    C3102bd.m18938b(this.f17854c, "user_frameworks", true);
                    C3102bd.f18316ax = true;
                    c0518d.f3598s = C3102bd.f18323f;
                }
                int selectedItemPosition = this.f17855d.getSelectedItemPosition();
                AsyncTaskC2940k asyncTaskC2940k = new AsyncTaskC2940k(this.f17854c, this.f17856e, this.f17857f);
                asyncTaskC2940k.m17508g(this.f17858g.isChecked());
                asyncTaskC2940k.m17509h(this.f17859h.isChecked() && selectedItemPosition != 3);
                AbstractAsyncTaskC2898a.m17032d(this.f17860i[0]);
                asyncTaskC2940k.m17510i(this.f17859h.isChecked() && this.f17861j.isChecked() && selectedItemPosition != 3);
                asyncTaskC2940k.m17506a(selectedItemPosition);
                asyncTaskC2940k.m17511j(this.f17862k.isChecked());
                C3102bd.m18938b(this.f17854c, "dcode_rs", this.f17858g.isChecked());
                C3102bd.m18938b(this.f17854c, "dcode_dx", this.f17859h.isChecked());
                C3102bd.m18938b(this.f17854c, "add_nomedia", this.f17862k.isChecked());
                if (this.f17858g.isChecked()) {
                    C3102bd.m18935b(this.f17854c, "dcode_mrs", this.f17855d.getSelectedItemPosition());
                }
                try {
                    asyncTaskC2940k.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f17863l);
                } catch (Exception e2) {
                    C3112bn.m18999a(this.f17854c, R.string.error_try_again);
                }
                dialogInterface.dismiss();
            }
        });
        aVar.m440c(R.string.settings, (DialogInterface.OnClickListener) null);
        View.OnClickListener onClickListener2 = new View.OnClickListener(buttonArr, checkBox, checkBox2, checkBox3, spinner, m18946d, spinner2) { // from class: ru.maximoff.apktool.util.al.33

            /* renamed from: a */
            private final Button[] f17864a;

            /* renamed from: b */
            private final CheckBox f17865b;

            /* renamed from: c */
            private final CheckBox f17866c;

            /* renamed from: d */
            private final CheckBox f17867d;

            /* renamed from: e */
            private final Spinner f17868e;

            /* renamed from: f */
            private final boolean f17869f;

            /* renamed from: g */
            private final Spinner f17870g;

            {
                this.f17864a = buttonArr;
                this.f17865b = checkBox;
                this.f17866c = checkBox2;
                this.f17867d = checkBox3;
                this.f17868e = spinner;
                this.f17869f = m18946d;
                this.f17870g = spinner2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f17864a[0] != null) {
                    this.f17864a[0].setEnabled(this.f17865b.isChecked() || (this.f17866c.isChecked() && this.f17866c.isEnabled()));
                }
                this.f17867d.setEnabled(this.f17866c.isChecked() && this.f17866c.isEnabled());
                this.f17868e.setEnabled(this.f17865b.isChecked() && this.f17869f);
                this.f17870g.setEnabled(this.f17865b.isChecked());
            }
        };
        checkBox.setOnClickListener(onClickListener2);
        checkBox2.setOnClickListener(onClickListener2);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(buttonArr, m438b, zArr, checkBox, checkBox2, checkBox3, spinner, m18946d, spinner2, context) { // from class: ru.maximoff.apktool.util.al.34

            /* renamed from: a */
            private final Button[] f17871a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f17872b;

            /* renamed from: c */
            private final boolean[] f17873c;

            /* renamed from: d */
            private final CheckBox f17874d;

            /* renamed from: e */
            private final CheckBox f17875e;

            /* renamed from: f */
            private final CheckBox f17876f;

            /* renamed from: g */
            private final Spinner f17877g;

            /* renamed from: h */
            private final boolean f17878h;

            /* renamed from: i */
            private final Spinner f17879i;

            /* renamed from: j */
            private final Context f17880j;

            {
                this.f17871a = buttonArr;
                this.f17872b = m438b;
                this.f17873c = zArr;
                this.f17874d = checkBox;
                this.f17875e = checkBox2;
                this.f17876f = checkBox3;
                this.f17877g = spinner;
                this.f17878h = m18946d;
                this.f17879i = spinner2;
                this.f17880j = context;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f17871a[0] = this.f17872b.m414a(-1);
                this.f17871a[0].setOnLongClickListener(new View.OnLongClickListener(this, this.f17873c, this.f17871a) { // from class: ru.maximoff.apktool.util.al.34.1

                    /* renamed from: a */
                    private final AnonymousClass34 f17881a;

                    /* renamed from: b */
                    private final boolean[] f17882b;

                    /* renamed from: c */
                    private final Button[] f17883c;

                    {
                        this.f17881a = this;
                        this.f17882b = r2;
                        this.f17883c = r3;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        this.f17882b[0] = true;
                        this.f17883c[0].performClick();
                        return true;
                    }
                });
                this.f17871a[0].setEnabled(this.f17874d.isChecked() || this.f17875e.isChecked());
                this.f17876f.setEnabled(this.f17875e.isChecked() && this.f17875e.isEnabled());
                this.f17877g.setEnabled(this.f17874d.isChecked() && this.f17878h);
                this.f17879i.setEnabled(this.f17874d.isChecked());
                this.f17872b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f17880j) { // from class: ru.maximoff.apktool.util.al.34.2

                    /* renamed from: a */
                    private final AnonymousClass34 f17884a;

                    /* renamed from: b */
                    private final Context f17885b;

                    {
                        this.f17884a = this;
                        this.f17885b = r2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C3080al.m18587c(this.f17885b, 0);
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: c */
    public static void m18587c(Context context, int i) {
        String[] strArr;
        String[] strArr2;
        boolean[] zArr;
        switch (i) {
            case 0:
                strArr = new String[]{context.getString(R.string.mBakdeb), context.getString(R.string.baksmali_registers), context.getString(R.string.keep_structure), context.getString(R.string.add_dummy), context.getString(R.string.keep_broken), context.getString(R.string.clear_split), context.getString(R.string.remove_property)};
                strArr2 = new String[]{"mBakdeb", "baksmali_registers", "keep_structure", "add_dummy", "keep_broken_res", "clear_split", "remove_property"};
                zArr = new boolean[]{true, false, false, false, false, false, false};
                break;
            case 1:
                strArr = new String[]{context.getString(R.string.debug_mode), context.getString(R.string.add_nsc), context.getString(R.string.delete_build), context.getString(R.string.checksums_original)};
                strArr2 = new String[]{"debug_mode", "add_nsc", "delete_build", "build_checksums"};
                zArr = new boolean[]{false, false, true, false};
                break;
            case 2:
                strArr = new String[]{context.getString(R.string.keep_structure), context.getString(R.string.keep_broken), context.getString(R.string.try_merge_res), context.getString(R.string.debug_mode), context.getString(R.string.add_nsc), context.getString(R.string.remove_property)};
                strArr2 = new String[]{"keep_structure", "keep_broken_res", "try_merge_res", "debug_mode", "add_nsc", "remove_property"};
                zArr = new boolean[]{false, false, false, false, false, false};
                break;
            default:
                return;
        }
        boolean[] zArr2 = new boolean[strArr2.length];
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            zArr2[i2] = C3102bd.m18925a(context, strArr2[i2], zArr[i2]);
        }
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.settings).m432a(strArr, zArr2, new DialogInterface.OnMultiChoiceClickListener(zArr2) { // from class: ru.maximoff.apktool.util.al.35

            /* renamed from: a */
            private final boolean[] f17886a;

            {
                this.f17886a = zArr2;
            }

            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i3, boolean z) {
                this.f17886a[i3] = z;
            }
        }).m420a(R.string.save, new DialogInterface.OnClickListener(strArr2, context, zArr2) { // from class: ru.maximoff.apktool.util.al.36

            /* renamed from: a */
            private final String[] f17887a;

            /* renamed from: b */
            private final Context f17888b;

            /* renamed from: c */
            private final boolean[] f17889c;

            {
                this.f17887a = strArr2;
                this.f17888b = context;
                this.f17889c = zArr2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                for (int i4 = 0; i4 < this.f17887a.length; i4++) {
                    String str = this.f17887a[i4];
                    C3102bd.m18938b(this.f17888b, str, this.f17889c[i4]);
                    if (str.equals("add_nsc")) {
                        C0518d.f3579w.f3594o = this.f17889c[i4];
                    } else if (str.equals("debug_mode")) {
                        C0518d.f3579w.f3583d = this.f17889c[i4];
                    } else if (str.equals("baksmali_registers")) {
                        C3102bd.f18313au = this.f17889c[i4];
                    }
                }
                C3112bn.m18999a(this.f17888b, R.string.success);
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.threads, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, i, context) { // from class: ru.maximoff.apktool.util.al.37

            /* renamed from: a */
            private final DialogInterfaceC0070b f17890a;

            /* renamed from: b */
            private final int f17891b;

            /* renamed from: c */
            private final Context f17892c;

            {
                this.f17890a = m438b;
                this.f17891b = i;
                this.f17892c = context;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f17890a.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f17891b, this.f17892c) { // from class: ru.maximoff.apktool.util.al.37.1

                    /* renamed from: a */
                    private final AnonymousClass37 f17893a;

                    /* renamed from: b */
                    private final int f17894b;

                    /* renamed from: c */
                    private final Context f17895c;

                    {
                        this.f17893a = this;
                        this.f17894b = r2;
                        this.f17895c = r3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int i3;
                        String str;
                        int i4;
                        int availableProcessors = Runtime.getRuntime().availableProcessors();
                        if (availableProcessors <= 0) {
                            availableProcessors = 4;
                        }
                        switch (this.f17894b) {
                            case 1:
                                i3 = R.string.build_smali;
                                str = "threads_smali";
                                i4 = Math.min(4, availableProcessors);
                                break;
                            case 2:
                                i3 = R.string.mantisplit;
                                str = "threads_antisplit";
                                i4 = availableProcessors;
                                break;
                            default:
                                i3 = R.string.decode_smali;
                                str = "threads_baksmali";
                                i4 = Math.min(6, availableProcessors);
                                break;
                        }
                        C3080al.m18546a(this.f17895c, 1, availableProcessors, i4, str, i3);
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static void m18550a(Context context, Spinner spinner, int i) {
        int i2;
        File file = new File(context.getFilesDir(), "framework/user");
        if (!file.exists()) {
            file.mkdirs();
        }
        String[] list = file.list(new FilenameFilter() { // from class: ru.maximoff.apktool.util.al.38
            @Override // java.p209io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(".apk");
            }
        });
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m418a(R.string.man_frame_summary);
        aVar.m420a(R.string.close_cur, (DialogInterface.OnClickListener) null);
        aVar.m440c(R.string.search_reset, new DialogInterface.OnClickListener(file, context, spinner, i) { // from class: ru.maximoff.apktool.util.al.39

            /* renamed from: a */
            private final File f17896a;

            /* renamed from: b */
            private final Context f17897b;

            /* renamed from: c */
            private final Spinner f17898c;

            /* renamed from: d */
            private final int f17899d;

            {
                this.f17896a = file;
                this.f17897b = context;
                this.f17898c = spinner;
                this.f17899d = i;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                C0542g.m3987a(this.f17896a);
                C3102bd.m18949e();
                C0518d.f3579w.f3598s = C3102bd.f18322e;
                C3102bd.m18938b(this.f17897b, "user_frameworks", false);
                if (this.f17898c != null) {
                    this.f17898c.setSelection(this.f17899d);
                    this.f17898c.setEnabled(false);
                }
                C3112bn.m18999a(this.f17897b, R.string.complete);
                dialogInterface.dismiss();
            }
        });
        if (list == null || list.length == 0) {
            aVar.m433b(R.string.not_found);
        } else {
            String[] strArr = new String[list.length];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.length) {
                    break;
                }
                String str = list[i4];
                File file2 = new File(file, str);
                if (str.equals("1.apk")) {
                    try {
                        C2604w c2604w = new C2604w(file2);
                        Enumeration<C2602u> m16163b = c2604w.m16163b();
                        while (true) {
                            if (!m16163b.hasMoreElements()) {
                                i2 = 0;
                                break;
                            }
                            C2602u nextElement = m16163b.nextElement();
                            if (AbstractC0581c.ANDROID_MANIFEST_ZIP_ENTRY_NAME.equals(nextElement.getName())) {
                                i2 = m18523a(c2604w.m16160a(nextElement));
                                break;
                            }
                        }
                        c2604w.close();
                    } catch (Error | Exception e2) {
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                }
                if (i2 > 0 && i2 <= 36) {
                    strArr[i4] = String.format("%s (SDK %d, %s)", str, new Integer(i2), C3106bh.m18975a(file2.length(), C3102bd.f18305am));
                } else {
                    strArr[i4] = String.format("%s (%s)", str, C3106bh.m18975a(file2.length(), C3102bd.f18305am));
                }
                i3 = i4 + 1;
            }
            aVar.m432a(strArr, (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null);
            aVar.m434b(R.string.delete, new DialogInterface.OnClickListener(list, file, spinner, i, context) { // from class: ru.maximoff.apktool.util.al.40

                /* renamed from: a */
                private final String[] f17902a;

                /* renamed from: b */
                private final File f17903b;

                /* renamed from: c */
                private final Spinner f17904c;

                /* renamed from: d */
                private final int f17905d;

                /* renamed from: e */
                private final Context f17906e;

                {
                    this.f17902a = list;
                    this.f17903b = file;
                    this.f17904c = spinner;
                    this.f17905d = i;
                    this.f17906e = context;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i5) {
                    ArrayList arrayList = new ArrayList();
                    ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                    for (int i6 = 0; i6 < m415a.getCount(); i6++) {
                        if (m415a.isItemChecked(i6)) {
                            String[] split = ((String) m415a.getItemAtPosition(i6)).split(" ");
                            int i7 = 0;
                            while (true) {
                                if (i7 < this.f17902a.length) {
                                    if (!this.f17902a[i7].equals(split[0])) {
                                        i7++;
                                    } else {
                                        arrayList.add(new File(this.f17903b, this.f17902a[i7]));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        dialogInterface.dismiss();
                        return;
                    }
                    Iterator<E> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((File) it.next()).delete();
                    }
                    if (this.f17904c != null && !C3102bd.m18946d()) {
                        this.f17904c.setSelection(this.f17905d);
                        this.f17904c.setEnabled(false);
                    }
                    C3112bn.m18999a(this.f17906e, R.string.complete);
                    dialogInterface.dismiss();
                }
            });
        }
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(list, m438b) { // from class: ru.maximoff.apktool.util.al.41

            /* renamed from: a */
            private final String[] f17907a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f17908b;

            {
                this.f17907a = list;
                this.f17908b = m438b;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (this.f17907a != null && this.f17907a.length != 0) {
                    Button m414a = this.f17908b.m414a(-2);
                    m414a.setEnabled(false);
                    ListView m415a = this.f17908b.m415a();
                    m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.al.41.1

                        /* renamed from: a */
                        private final AnonymousClass41 f17909a;

                        /* renamed from: b */
                        private final ListView f17910b;

                        /* renamed from: c */
                        private final Button f17911c;

                        {
                            this.f17909a = this;
                            this.f17910b = m415a;
                            this.f17911c = m414a;
                        }

                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j) {
                            for (int i6 = 0; i6 < this.f17910b.getCount(); i6++) {
                                if (this.f17910b.isItemChecked(i6)) {
                                    this.f17911c.setEnabled(true);
                                    return;
                                }
                            }
                            this.f17911c.setEnabled(false);
                        }
                    });
                }
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static void m18560a(NumberPicker numberPicker, int i) {
        try {
            for (Field field : Class.forName("android.widget.NumberPicker").getDeclaredFields()) {
                if (field.getName().equals("mSelectionDivider")) {
                    field.setAccessible(true);
                    try {
                        field.set(numberPicker, new ColorDrawable(i));
                    } catch (Resources.NotFoundException e2) {
                        e2.printStackTrace();
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                    } catch (IllegalArgumentException e4) {
                        e4.printStackTrace();
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        numberPicker.postInvalidateOnAnimation();
                        return;
                    } else {
                        numberPicker.postInvalidateDelayed(16L);
                        return;
                    }
                }
            }
        } catch (ClassNotFoundException e5) {
            throw new NoClassDefFoundError(e5.getMessage());
        }
    }

    /* renamed from: a */
    public static void m18546a(Context context, int i, int i2, int i3, String str, int i4) {
        m18548a(context, i, i2, i3, str, context.getString(i4), (Runnable) null);
    }

    /* renamed from: a */
    public static void m18547a(Context context, int i, int i2, int i3, String str, int i4, Runnable runnable) {
        m18548a(context, i, i2, i3, str, context.getString(i4), runnable);
    }

    /* renamed from: a */
    public static void m18548a(Context context, int i, int i2, int i3, String str, String str2, Runnable runnable) {
        int m19470a;
        switch (C3102bd.f18319b) {
            case 1:
                m19470a = C3246h.m19470a(context, R.color.accent_material);
                break;
            case 2:
                m19470a = C3246h.m19470a(context, R.color.white);
                break;
            default:
                m19470a = C3246h.m19470a(context, R.color.accent_material_light);
                break;
        }
        NumberPicker numberPicker = new NumberPicker(context);
        m18560a(numberPicker, m19470a);
        int m18905a = C3102bd.m18905a(context, str, i3);
        if (m18905a > i2 || m18905a < i) {
            C3102bd.m18935b(context, str, i3);
            if (str.equals("threads_smali")) {
                C3102bd.f18298af = i3;
            } else if (str.equals("threads_baksmali")) {
                C3102bd.f18299ag = i3;
            } else if (str.equals("threads_antisplit")) {
                C3102bd.f18300ah = i3;
            } else if (str.equals("threads_others")) {
                C3102bd.f18297ae = i3;
            }
            m18905a = i3;
        }
        numberPicker.setMinValue(i);
        numberPicker.setMaxValue(i2);
        numberPicker.setValue(m18905a);
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m435b(numberPicker);
        aVar.m427a(str2);
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m420a(R.string.save, new DialogInterface.OnClickListener(numberPicker, i, i2, i3, context, str, runnable) { // from class: ru.maximoff.apktool.util.al.42

            /* renamed from: a */
            private final NumberPicker f17912a;

            /* renamed from: b */
            private final int f17913b;

            /* renamed from: c */
            private final int f17914c;

            /* renamed from: d */
            private final int f17915d;

            /* renamed from: e */
            private final Context f17916e;

            /* renamed from: f */
            private final String f17917f;

            /* renamed from: g */
            private final Runnable f17918g;

            {
                this.f17912a = numberPicker;
                this.f17913b = i;
                this.f17914c = i2;
                this.f17915d = i3;
                this.f17916e = context;
                this.f17917f = str;
                this.f17918g = runnable;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                int value = this.f17912a.getValue();
                if (value < this.f17913b || value > this.f17914c) {
                    value = this.f17915d;
                }
                C3102bd.m18935b(this.f17916e, this.f17917f, value);
                if (this.f17917f.equals("threads_smali")) {
                    C3102bd.f18298af = value;
                } else if (this.f17917f.equals("threads_baksmali")) {
                    C3102bd.f18299ag = value;
                } else if (this.f17917f.equals("threads_antisplit")) {
                    C3102bd.f18300ah = value;
                } else if (this.f17917f.equals("threads_others")) {
                    C3102bd.f18297ae = value;
                }
                if (this.f17918g != null) {
                    this.f17918g.run();
                }
                dialogInterface.cancel();
            }
        });
        aVar.m440c(R.string.search_reset, new DialogInterface.OnClickListener(context, str, i3, runnable) { // from class: ru.maximoff.apktool.util.al.43

            /* renamed from: a */
            private final Context f17919a;

            /* renamed from: b */
            private final String f17920b;

            /* renamed from: c */
            private final int f17921c;

            /* renamed from: d */
            private final Runnable f17922d;

            {
                this.f17919a = context;
                this.f17920b = str;
                this.f17921c = i3;
                this.f17922d = runnable;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                C3102bd.m18935b(this.f17919a, this.f17920b, this.f17921c);
                if (this.f17920b.equals("threads_smali")) {
                    C3102bd.f18298af = this.f17921c;
                } else if (this.f17920b.equals("threads_baksmali")) {
                    C3102bd.f18299ag = this.f17921c;
                } else if (this.f17920b.equals("threads_antisplit")) {
                    C3102bd.f18300ah = this.f17921c;
                } else if (this.f17920b.equals("threads_others")) {
                    C3102bd.f18297ae = this.f17921c;
                }
                if (this.f17922d != null) {
                    this.f17922d.run();
                }
                dialogInterface.cancel();
            }
        });
        aVar.m438b().show();
    }

    /* renamed from: f */
    public static void m18598f(Context context) {
        String[] strArr;
        String[] strArr2;
        int i;
        Button[] buttonArr = new Button[1];
        if (Build.VERSION.SDK_INT >= 21) {
            strArr = new String[]{context.getString(R.string.use_v1_sign), context.getString(R.string.use_v2_sign), context.getString(R.string.use_v3_sign), context.getString(R.string.use_v4_sign), context.getString(R.string.save)};
            strArr2 = new String[]{"use_v1_sign", "use_v2_sign", "use_v3_sign", "use_v4_sign"};
            i = R.string.sign_ver_info2;
        } else {
            strArr = new String[]{context.getString(R.string.use_v1_sign), context.getString(R.string.use_v2_sign), context.getString(R.string.save)};
            strArr2 = new String[]{"use_v1_sign", "use_v2_sign"};
            i = R.string.sign_ver_info;
        }
        boolean[] zArr = new boolean[strArr2.length + 1];
        if (C3102bd.f18317ay != null && C3102bd.f18317ay.length == strArr2.length) {
            for (int i2 = 0; i2 < C3102bd.f18317ay.length; i2++) {
                zArr[i2] = C3102bd.f18317ay[i2];
            }
        } else {
            int i3 = 0;
            while (i3 < strArr2.length) {
                zArr[i3] = C3102bd.m18925a(context, strArr2[i3], i3 < 2);
                i3++;
            }
        }
        zArr[strArr2.length] = false;
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.signature).m432a(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener(zArr, buttonArr) { // from class: ru.maximoff.apktool.util.al.44

            /* renamed from: a */
            private final boolean[] f17923a;

            /* renamed from: b */
            private final Button[] f17924b;

            {
                this.f17923a = zArr;
                this.f17924b = buttonArr;
            }

            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public void onClick(DialogInterface dialogInterface, int i4, boolean z) {
                boolean z2 = true;
                this.f17923a[i4] = z;
                if (this.f17924b[0] != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        if (!this.f17923a[0] && !this.f17923a[1] && !this.f17923a[2] && !this.f17923a[3]) {
                            z2 = false;
                        } else if (!this.f17923a[0] && !this.f17923a[1] && !this.f17923a[2] && this.f17923a[3]) {
                            z2 = false;
                        } else if (this.f17923a[0] && !this.f17923a[1] && !this.f17923a[2] && this.f17923a[3]) {
                            z2 = false;
                        }
                        this.f17924b[0].setEnabled(z2);
                        return;
                    }
                    this.f17924b[0].setEnabled(this.f17923a[0] || this.f17923a[1]);
                }
            }
        }).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(zArr, strArr2, context) { // from class: ru.maximoff.apktool.util.al.45

            /* renamed from: a */
            private final boolean[] f17925a;

            /* renamed from: b */
            private final String[] f17926b;

            /* renamed from: c */
            private final Context f17927c;

            {
                this.f17925a = zArr;
                this.f17926b = strArr2;
                this.f17927c = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                int i5 = 0;
                if (this.f17925a[this.f17926b.length]) {
                    while (i5 < this.f17926b.length) {
                        C3102bd.m18938b(this.f17927c, this.f17926b[i5], this.f17925a[i5]);
                        i5++;
                    }
                } else {
                    C3102bd.f18317ay = new boolean[this.f17926b.length];
                    while (i5 < this.f17926b.length) {
                        C3102bd.f18317ay[i5] = this.f17925a[i5];
                        i5++;
                    }
                }
                C3112bn.m18999a(this.f17927c, R.string.success);
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.minfo, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(buttonArr, m438b, context, i) { // from class: ru.maximoff.apktool.util.al.46

            /* renamed from: a */
            private final Button[] f17928a;

            /* renamed from: b */
            private final DialogInterfaceC0070b f17929b;

            /* renamed from: c */
            private final Context f17930c;

            /* renamed from: d */
            private final int f17931d;

            {
                this.f17928a = buttonArr;
                this.f17929b = m438b;
                this.f17930c = context;
                this.f17931d = i;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f17928a[0] = this.f17929b.m414a(-1);
                this.f17929b.m414a(-3).setOnClickListener(new View.OnClickListener(this, this.f17930c, this.f17931d) { // from class: ru.maximoff.apktool.util.al.46.1

                    /* renamed from: a */
                    private final AnonymousClass46 f17932a;

                    /* renamed from: b */
                    private final Context f17933b;

                    /* renamed from: c */
                    private final int f17934c;

                    {
                        this.f17932a = this;
                        this.f17933b = r2;
                        this.f17934c = r3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        new C3078aj(this.f17933b).m18494a(R.string.minfo).m18500b(this.f17934c).m18497a(true).m18506d(R.string.f21470ok).m18507d();
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static void m18557a(Context context, File[] fileArr, C3060a c3060a, String str, String str2, boolean z) {
        String[] strArr = new String[fileArr.length];
        for (int i = 0; i < fileArr.length; i++) {
            strArr[i] = fileArr[i].getName();
        }
        Arrays.sort(strArr);
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = context.getString(R.string.extract_icon);
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i2 + 1] = strArr[i2];
        }
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m432a(strArr2, (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null);
        aVar.m427a(str2);
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m420a(R.string.extract, new DialogInterface.OnClickListener(fileArr, context, c3060a, str, z) { // from class: ru.maximoff.apktool.util.al.47

            /* renamed from: a */
            private final File[] f17935a;

            /* renamed from: b */
            private final Context f17936b;

            /* renamed from: c */
            private final C3060a f17937c;

            /* renamed from: d */
            private final String f17938d;

            /* renamed from: e */
            private final boolean f17939e;

            {
                this.f17935a = fileArr;
                this.f17936b = context;
                this.f17937c = c3060a;
                this.f17938d = str;
                this.f17939e = z;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ArrayList arrayList = new ArrayList();
                ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                boolean z2 = true;
                for (int i4 = 0; i4 < m415a.getCount(); i4++) {
                    if (i4 == 0) {
                        z2 = m415a.isItemChecked(i4);
                    } else if (m415a.isItemChecked(i4)) {
                        for (int i5 = 0; i5 < this.f17935a.length; i5++) {
                            if (this.f17935a[i5].getName().equals((String) m415a.getItemAtPosition(i4))) {
                                arrayList.add(this.f17935a[i5]);
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    File[] fileArr2 = (File[]) arrayList.toArray(new File[arrayList.size()]);
                    try {
                        if (fileArr2.length > 1) {
                            new AsyncTaskC2949t(this.f17936b, this.f17937c, this.f17938d, z2, this.f17939e, (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr2);
                        } else {
                            new AsyncTaskC2950u(this.f17936b, new StringBuffer().append(new StringBuffer().append(this.f17938d).append("_").toString()).append(fileArr2[0].getName()).toString(), this.f17939e, (InterfaceC2995n) null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, fileArr2);
                        }
                    } catch (Exception e2) {
                        C3112bn.m18999a(this.f17936b, R.string.error_try_again);
                    }
                }
                dialogInterface.cancel();
            }
        });
        aVar.m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b) { // from class: ru.maximoff.apktool.util.al.48

            /* renamed from: a */
            private final DialogInterfaceC0070b f17940a;

            {
                this.f17940a = m438b;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f17940a.m414a(-1);
                m414a.setEnabled(true);
                ListView m415a = this.f17940a.m415a();
                for (int i3 = 0; i3 < m415a.getCount(); i3++) {
                    m415a.setItemChecked(i3, true);
                }
                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.al.48.1

                    /* renamed from: a */
                    private final AnonymousClass48 f17941a;

                    /* renamed from: b */
                    private final ListView f17942b;

                    /* renamed from: c */
                    private final Button f17943c;

                    {
                        this.f17941a = this;
                        this.f17942b = m415a;
                        this.f17943c = m414a;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                        for (int i5 = 1; i5 < this.f17942b.getCount(); i5++) {
                            if (this.f17942b.isItemChecked(i5)) {
                                this.f17943c.setEnabled(true);
                                return;
                            }
                        }
                        this.f17943c.setEnabled(false);
                    }
                });
                Button m414a2 = this.f17940a.m414a(-3);
                m414a2.setOnClickListener(new View.OnClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.al.48.2

                    /* renamed from: a */
                    private final AnonymousClass48 f17944a;

                    /* renamed from: b */
                    private final ListView f17945b;

                    /* renamed from: c */
                    private final Button f17946c;

                    {
                        this.f17944a = this;
                        this.f17945b = m415a;
                        this.f17946c = m414a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z2 = false;
                        for (int i4 = 1; i4 < this.f17945b.getCount(); i4++) {
                            boolean isItemChecked = this.f17945b.isItemChecked(i4);
                            this.f17945b.setItemChecked(i4, !isItemChecked);
                            if (!isItemChecked) {
                                z2 = true;
                            }
                        }
                        this.f17946c.setEnabled(z2);
                    }
                });
                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.al.48.3

                    /* renamed from: a */
                    private final AnonymousClass48 f17947a;

                    /* renamed from: b */
                    private final ListView f17948b;

                    /* renamed from: c */
                    private final Button f17949c;

                    {
                        this.f17947a = this;
                        this.f17948b = m415a;
                        this.f17949c = m414a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        for (int i4 = 0; i4 < this.f17948b.getCount(); i4++) {
                            this.f17948b.setItemChecked(i4, true);
                        }
                        this.f17949c.setEnabled(true);
                        return true;
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: c */
    public static void m18588c(Context context, String str) {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse(new StringBuffer().append("package:").append(str).toString()));
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e2) {
            C3112bn.m19023b(context, context.getString(R.string.failed_openset));
        }
    }

    /* renamed from: a */
    public static String m18540a(String[] strArr, String str) {
        if (strArr == null || str == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m18538a(List<String> list, String str) {
        if (list == null || str == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (i2 > 0) {
                    sb.append(str);
                }
                sb.append(list.get(i2));
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }

    /* renamed from: b */
    public static boolean m18585b(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static int m18524a(C2466a c2466a, String str) {
        for (int i = 0; i < c2466a.m15569a(); i++) {
            if (c2466a.m15571a(i).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static void m18545a(Activity activity, boolean z) {
        if (z) {
            activity.getWindow().addFlags(128);
        } else {
            activity.getWindow().clearFlags(128);
        }
    }

    /* renamed from: d */
    public static Context m18592d(Context context, String str) {
        try {
            return context.getApplicationContext().createPackageContext(str, 3);
        } catch (PackageManager.NameNotFoundException e2) {
            return (Context) null;
        }
    }

    /* renamed from: a */
    public static long m18525a(Context context, File[] fileArr) {
        long j = 0;
        if (fileArr != null && fileArr.length != 0) {
            for (File file : fileArr) {
                j += C3262u.m19668i(context, file);
            }
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static File[] m18570a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new File(applicationInfo.sourceDir));
        if (Build.VERSION.SDK_INT >= 21 && applicationInfo.splitSourceDirs != null) {
            String[] strArr = applicationInfo.splitSourceDirs;
            for (String str : strArr) {
                arrayList.add(new File(str));
            }
        }
        File[] fileArr = new File[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            fileArr[i] = (File) arrayList.get(i);
        }
        return fileArr;
    }

    /* renamed from: a */
    public static List<String> m18543a(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        if (fileArr.length > 1) {
            for (File file : fileArr) {
                String[] split = file.getName().toLowerCase().split("\\.");
                if (split.length >= 3) {
                    int length = split.length - 2;
                    if (split[length].startsWith("arm") || split[length].startsWith("x86") || split[length].startsWith("mips")) {
                        if (split[length].startsWith("x86")) {
                            arrayList.add(split[length]);
                        } else {
                            arrayList.add(split[length].replace("_", "-"));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: e */
    public static boolean m18595e(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: g */
    public static String m18600g(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("lang", "default");
        if (string.equals("default")) {
            string = m18586c();
            if (C3112bn.m19040o(string)) {
                string = "en";
            }
            if (string.length() > 2) {
                string = string.substring(0, 2);
            }
            defaultSharedPreferences.edit().putString("lang", string.toLowerCase()).commit();
        }
        if (!m18585b(context.getResources().getStringArray(R.array.values_lang), string.toLowerCase())) {
            string = "en";
        }
        return string.toLowerCase();
    }

    /* renamed from: c */
    public static String m18586c() {
        return Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0).getLanguage() : Locale.getDefault().getLanguage();
    }

    /* renamed from: h */
    public static String m18602h(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i <= 120) {
            return "LDPI";
        }
        if (i <= 160) {
            return "MDPI";
        }
        if (i <= 213) {
            return "TVDPI";
        }
        if (i <= 240) {
            return "HDPI";
        }
        if (i <= 320) {
            return "XHDPI";
        }
        if (i <= 480) {
            return "XXHDPI";
        }
        return "XXXHDPI";
    }

    /* renamed from: f */
    public static void m18599f(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                context.startActivity(launchIntentForPackage);
            } else {
                C3112bn.m19023b(context, context.getString(R.string.launch_fail));
            }
        } catch (Exception e2) {
            C3112bn.m19023b(context, context.getString(R.string.error));
        }
    }

    /* renamed from: g */
    public static void m18601g(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            m18588c(context, str);
            return;
        }
        try {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse(new StringBuffer().append("package:").append(str).toString()));
            intent.addFlags(268435456);
            intent.putExtra(Intent.EXTRA_RETURN_RESULT, true);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: h */
    public static void m18603h(Context context, String str) {
        if (m18595e(context, new StringBuffer().append("market://details?id=").append(str).toString())) {
            return;
        }
        m18595e(context, new StringBuffer().append("https://play.google.com/store/apps/details?id=").append(str).toString());
    }

    /* renamed from: i */
    public static boolean m18605i(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: i */
    public static String m18604i(Context context, String str) {
        return m18536a(context.getPackageManager(), str, C3102bd.m18925a(context, "short_perm_description", false));
    }

    /* renamed from: a */
    public static String m18535a(PackageManager packageManager, String str) {
        return m18536a(packageManager, str, C3102bd.m18925a((Context) MainActivity.m16615o(), "short_perm_description", false));
    }

    /* renamed from: a */
    public static String m18536a(PackageManager packageManager, String str, boolean z) {
        CharSequence loadDescription;
        try {
            PermissionInfo permissionInfo = packageManager.getPermissionInfo(str, 128);
            if (permissionInfo != null) {
                if (z) {
                    loadDescription = permissionInfo.loadLabel(packageManager);
                } else {
                    loadDescription = permissionInfo.loadDescription(packageManager);
                }
                if (loadDescription != null) {
                    String charSequence = loadDescription.toString();
                    if (!charSequence.equals(str)) {
                        return charSequence;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return (String) null;
    }

    /* renamed from: a */
    public static int m18520a(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    /* renamed from: a */
    public static String m18533a(long j) {
        return m18534a(j, true);
    }

    /* renamed from: a */
    public static String m18534a(long j, boolean z) {
        long j2 = (j / 1000) % 60;
        long j3 = (j / 60000) % 60;
        long j4 = (j / 3600000) % 24;
        return z ? String.format("%02d:%02d:%02d.%d", new Long(j4), new Long(j3), new Long(j2), new Long(j % 1000)) : String.format("%02d:%02d:%02d", new Long(j4), new Long(j3), new Long(j2));
    }

    /* renamed from: a */
    public static void m18544a(Activity activity) {
        new DialogInterfaceC0070b.a(activity).m418a(R.string.scoped_storage_title).m433b(R.string.scoped_storage_msg).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(activity) { // from class: ru.maximoff.apktool.util.al.49

            /* renamed from: a */
            private final Activity f17950a;

            {
                this.f17950a = activity;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String[] m18596e = C3080al.m18596e();
                try {
                    Intent intent = new Intent(m18596e[0]);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setData(Uri.parse(String.format("package:%s", this.f17950a.getPackageName())));
                    this.f17950a.startActivity(intent);
                } catch (Exception e2) {
                    try {
                        Intent intent2 = new Intent();
                        intent2.setAction(m18596e[1]);
                        this.f17950a.startActivity(intent2);
                    } catch (Exception e3) {
                        C3112bn.m18999a(this.f17950a, R.string.error);
                    }
                }
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m429a(false).m438b().show();
    }

    /* renamed from: d */
    public static boolean m18593d() {
        try {
            if (Build.VERSION.SDK_INT <= 29) {
                return true;
            }
            try {
                Method declaredMethod = Class.forName(Class.forName("android.os.Environment").getName()).getDeclaredMethod("isExternalStorageManager", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke((Object) null, new Object[0])).booleanValue();
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        } catch (Exception e3) {
            return false;
        }
    }

    /* renamed from: e */
    public static String[] m18596e() {
        try {
            try {
                Class<?> cls = Class.forName(Class.forName("android.provider.Settings").getName());
                Field declaredField = cls.getDeclaredField("ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getDeclaredField("ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION");
                declaredField2.setAccessible(true);
                return new String[]{(String) declaredField.get(cls), (String) declaredField2.get(cls)};
            } catch (ClassNotFoundException e2) {
                throw new NoClassDefFoundError(e2.getMessage());
            }
        } catch (Exception e3) {
            return new String[]{"android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", "android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"};
        }
    }

    /* renamed from: j */
    public static boolean m18607j(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return Settings.canDrawOverlays(context);
    }

    /* renamed from: a */
    public static String m18530a(int i) {
        String m18532a = m18532a(i, false);
        String[] split = m18532a.split("\\s", 2);
        if (split.length == 2) {
            int indexOf = split[1].indexOf(47);
            if (indexOf > 0) {
                return split[1].substring(0, indexOf);
            }
            return split[1];
        }
        return m18532a;
    }

    /* renamed from: a */
    public static String m18532a(int i, boolean z) {
        String stringBuffer;
        String m18576b;
        switch (i) {
            case 1:
                stringBuffer = new StringBuffer().append("Android ").append("1.0").toString();
                break;
            case 2:
                stringBuffer = new StringBuffer().append("Android ").append("1.1").toString();
                break;
            case 3:
                stringBuffer = new StringBuffer().append("Android ").append("1.5").toString();
                break;
            case 4:
                stringBuffer = new StringBuffer().append("Android ").append("1.6").toString();
                break;
            case 5:
                stringBuffer = new StringBuffer().append("Android ").append("2.0").toString();
                break;
            case 6:
                stringBuffer = new StringBuffer().append("Android ").append("2.0.1").toString();
                break;
            case 7:
                stringBuffer = new StringBuffer().append("Android ").append("2.1.x").toString();
                break;
            case 8:
                stringBuffer = new StringBuffer().append("Android ").append("2.2.x").toString();
                break;
            case 9:
                stringBuffer = new StringBuffer().append("Android ").append("2.3/2.3.1/2.3.2").toString();
                break;
            case 10:
                stringBuffer = new StringBuffer().append("Android ").append("2.3.3/2.3.4").toString();
                break;
            case 11:
                stringBuffer = new StringBuffer().append("Android ").append("3.0.x").toString();
                break;
            case 12:
                stringBuffer = new StringBuffer().append("Android ").append("3.1.x").toString();
                break;
            case 13:
                stringBuffer = new StringBuffer().append("Android ").append("3.2").toString();
                break;
            case 14:
                stringBuffer = new StringBuffer().append("Android ").append("4.0/4.0.1/4.0.2").toString();
                break;
            case 15:
                stringBuffer = new StringBuffer().append("Android ").append("4.0.3/4.0.4").toString();
                break;
            case 16:
                stringBuffer = new StringBuffer().append("Android ").append("4.1/4.1.1").toString();
                break;
            case 17:
                stringBuffer = new StringBuffer().append("Android ").append("4.2/4.2.2").toString();
                break;
            case 18:
                stringBuffer = new StringBuffer().append("Android ").append("4.3").toString();
                break;
            case 19:
                stringBuffer = new StringBuffer().append("Android ").append("4.4").toString();
                break;
            case 20:
                stringBuffer = new StringBuffer().append("Android ").append("4.4W").toString();
                break;
            case 21:
                stringBuffer = new StringBuffer().append("Android ").append("5.0").toString();
                break;
            case 22:
                stringBuffer = new StringBuffer().append("Android ").append("5.1.1").toString();
                break;
            case 23:
                stringBuffer = new StringBuffer().append("Android ").append("6.0").toString();
                break;
            case 24:
                stringBuffer = new StringBuffer().append("Android ").append("7.0").toString();
                break;
            case 25:
                stringBuffer = new StringBuffer().append("Android ").append("7.1/7.1.1").toString();
                break;
            case 26:
                stringBuffer = new StringBuffer().append("Android ").append("8.0").toString();
                break;
            case 27:
                stringBuffer = new StringBuffer().append("Android ").append("8.1").toString();
                break;
            case 28:
                stringBuffer = new StringBuffer().append("Android ").append("9").toString();
                break;
            case 29:
                stringBuffer = new StringBuffer().append("Android ").append("10").toString();
                break;
            case 30:
                stringBuffer = new StringBuffer().append("Android ").append("11").toString();
                break;
            case 31:
                stringBuffer = new StringBuffer().append("Android ").append("12").toString();
                break;
            case 32:
                stringBuffer = new StringBuffer().append("Android ").append("12.1L").toString();
                break;
            case 33:
                stringBuffer = new StringBuffer().append("Android ").append("13").toString();
                break;
            case 34:
                stringBuffer = new StringBuffer().append("Android ").append("14").toString();
                break;
            case 35:
                stringBuffer = new StringBuffer().append("Android ").append("15").toString();
                break;
            case 36:
                stringBuffer = new StringBuffer().append("Android ").append("16").toString();
                break;
            case 37:
                stringBuffer = new StringBuffer().append("Android ").append("17").toString();
                break;
            default:
                stringBuffer = new StringBuffer().append("Android ").append(new StringBuffer().append("SDK").append(String.valueOf(i)).toString()).toString();
                break;
        }
        if (z && (m18576b = m18576b(i)) != null) {
            return new StringBuffer().append(stringBuffer).append(new StringBuffer().append(" ").append(m18576b).toString()).toString();
        }
        return stringBuffer;
    }

    /* renamed from: b */
    public static String m18576b(int i) {
        switch (i) {
            case 3:
                return "Cupcake";
            case 4:
                return "Donut";
            case 5:
            case 6:
            case 7:
                return "Eclair";
            case 8:
                return "Froyo";
            case 9:
            case 10:
                return "Gingerbread";
            case 11:
            case 12:
            case 13:
                return "Honeycomb";
            case 14:
            case 15:
                return "Ice Cream Sandwich";
            case 16:
            case 17:
            case 18:
                return "Jelly Bean";
            case 19:
            case 20:
                return "KitKat";
            case 21:
            case 22:
                return "Lollipop";
            case 23:
                return "Marshmallow";
            case 24:
            case 25:
                return "Nougat";
            case 26:
            case 27:
                return "Oreo";
            case 28:
                return "Pie";
            case 29:
                return "Queen Cake";
            case 30:
                return "Red Velvet Cake";
            case 31:
            case 32:
                return "Snow Cone";
            case 33:
                return "Tiramisu";
            case 34:
                return "Upside Down Cake";
            case 35:
                return "Vanilla Ice Cream";
            case 36:
                return "Baklava";
            case 37:
                return "Cinnamon Bun";
            default:
                return (String) null;
        }
    }

    /* renamed from: k */
    public static int m18608k(Context context) {
        int i;
        try {
            i = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("app_theme", "0"));
        } catch (Exception e2) {
            i = 0;
        }
        if (i > 2 || i < 0) {
            return 0;
        }
        return i;
    }

    /* renamed from: d */
    public static int m18591d(Context context, boolean z) {
        if (z) {
            return 0;
        }
        int i = PreferenceManager.getDefaultSharedPreferences(context).getInt("dark_theme", 1);
        if (i > 2 || i < 1) {
            return 1;
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m18567a(Configuration configuration) {
        return configuration != null && (configuration.uiMode & 48) == 32;
    }

    /* renamed from: a */
    public static String m18537a(String str) {
        String str2 = "";
        if (str.startsWith("-")) {
            str = str.substring(1);
            str2 = "-";
        }
        if (str.startsWith("0x")) {
            str = str.substring(2);
        }
        return String.format("#%08x", new Integer(Integer.parseInt(new StringBuffer().append(str2).append(str).toString(), 16) & (-1)));
    }

    /* renamed from: b */
    public static String m18581b(String str) {
        if (!str.startsWith("#")) {
            str = new StringBuffer().append("#").append(str).toString();
        }
        int parseColor = Color.parseColor(str);
        if (Color.alpha(parseColor) >= 128) {
            return new StringBuffer().append("-0x").append(Integer.toHexString(parseColor * (-1))).toString();
        }
        return new StringBuffer().append("0x").append(Integer.toHexString(parseColor)).toString();
    }

    /* renamed from: a */
    public static List<C3071a> m18541a(Context context, PackageManager packageManager, String str) {
        ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(str, 1).activities;
        ArrayList arrayList = new ArrayList();
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                arrayList.add(new C3071a(activityInfo.packageName, activityInfo.name, activityInfo.loadLabel(packageManager), activityInfo.loadIcon(packageManager), (activityInfo.enabled && activityInfo.exported) ? false : true));
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public static List<C3071a> m18606j(Context context, String str) {
        return m18582b(context, context.getPackageManager(), str);
    }

    /* renamed from: b */
    public static List<C3071a> m18582b(Context context, PackageManager packageManager, String str) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(packageManager.getLaunchIntentForPackage(str), 0);
        if (queryIntentActivities != null) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                arrayList.add(new C3071a(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name, resolveInfo.loadLabel(packageManager), resolveInfo.loadIcon(packageManager), (resolveInfo.activityInfo.enabled && resolveInfo.activityInfo.exported) ? false : true));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m18563a(Context context, Class<? extends AccessibilityService> cls) {
        Iterator<AccessibilityServiceInfo> it = ((AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE)).getEnabledAccessibilityServiceList(-1).iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().getResolveInfo().serviceInfo;
            if (serviceInfo.packageName.equals(context.getPackageName()) && serviceInfo.name.equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static String m18580b(PackageManager packageManager, String str) {
        String str2 = (String) null;
        try {
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(packageManager.getLaunchIntentForPackage(str), 0);
            if (queryIntentActivities != null) {
                return queryIntentActivities.get(0).activityInfo.name;
            }
            return str2;
        } catch (Exception e2) {
            return str2;
        }
    }

    /* renamed from: a */
    public static void m18559a(ImageView imageView, EditText editText) {
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_pass_visible);
        } else {
            imageView.setImageResource(R.drawable.ic_pass_visible_dark);
        }
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setOnClickListener(new View.OnClickListener(editText, imageView) { // from class: ru.maximoff.apktool.util.al.50

            /* renamed from: a */
            private final EditText f17962a;

            /* renamed from: b */
            private final ImageView f17963b;

            {
                this.f17962a = editText;
                this.f17963b = imageView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f17962a.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    if (C3102bd.f18291a) {
                        this.f17963b.setImageResource(R.drawable.ic_pass_hide);
                    } else {
                        this.f17963b.setImageResource(R.drawable.ic_pass_hide_dark);
                    }
                    this.f17962a.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    if (C3102bd.f18291a) {
                        this.f17963b.setImageResource(R.drawable.ic_pass_visible);
                    } else {
                        this.f17963b.setImageResource(R.drawable.ic_pass_visible_dark);
                    }
                    this.f17962a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                this.f17962a.requestFocus();
                this.f17962a.setSelection(this.f17962a.getText().length());
            }
        });
    }

    /* renamed from: a */
    public static boolean m18568a(File file) {
        try {
            return new ProcessBuilder("logcat", "-d", "-f", file.getAbsolutePath()).start().waitFor() == 0;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m18569a(File file, long j) {
        try {
            return new ProcessBuilder("touch", "-m", "-d", C3112bn.m18990a(j, "yyyy-MM-dd HH:mm:ss.SSSSS"), file.getAbsolutePath()).start().waitFor() == 0;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m18562a(Context context, File file) {
        try {
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent.setData(Uri.fromFile(file));
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: l */
    public static void m18610l(Context context) {
        File[] listFiles;
        try {
            File cacheDir = context.getCacheDir();
            if (cacheDir != null && cacheDir.exists() && !cacheDir.isFile() && (listFiles = cacheDir.listFiles()) != null) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        C0542g.m3987a(file);
                    } else {
                        file.delete();
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: m */
    public static void m18611m(Context context) {
        File[] listFiles;
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null && externalCacheDir.exists() && !externalCacheDir.isFile() && (listFiles = externalCacheDir.listFiles()) != null) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        C0542g.m3987a(file);
                    } else {
                        file.delete();
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: n */
    public static void m18612n(Context context) {
        File[] listFiles;
        try {
            File m18908a = C3102bd.m18908a();
            if (m18908a != null && m18908a.exists() && !m18908a.isFile() && (listFiles = m18908a.listFiles()) != null) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        C0542g.m3987a(file);
                    } else {
                        file.delete();
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* renamed from: o */
    public static void m18613o(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268468224);
            context.startActivity(launchIntentForPackage);
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    /* renamed from: a */
    public static boolean m18566a(PackageManager packageManager, ComponentName componentName) {
        switch (packageManager.getComponentEnabledSetting(componentName)) {
            case 1:
                break;
            case 2:
                break;
            default:
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(componentName.getPackageName(), 527);
                    ArrayList<ComponentInfo> arrayList = new ArrayList();
                    if (packageInfo.activities != null) {
                        Collections.addAll(arrayList, packageInfo.activities);
                    }
                    if (packageInfo.services != null) {
                        Collections.addAll(arrayList, packageInfo.services);
                    }
                    if (packageInfo.providers != null) {
                        Collections.addAll(arrayList, packageInfo.providers);
                    }
                    for (ComponentInfo componentInfo : arrayList) {
                        if (componentInfo.name.equals(componentName.getClassName())) {
                            break;
                        }
                    }
                    break;
                } catch (PackageManager.NameNotFoundException e2) {
                    return false;
                }
        }
        return false;
    }

    /* renamed from: k */
    public static void m18609k(Context context, String str) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.smali_help, (ViewGroup) null);
        CustomListView customListView = (CustomListView) inflate.findViewById(R.id.smalihelpListView1);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.clearText1);
        customListView.setDivider((Drawable) null);
        customListView.setDividerHeight(0);
        customListView.setFastScrollEnabled(C3102bd.f18314av);
        C3311m c3311m = new C3311m(context);
        customListView.setAdapter((ListAdapter) c3311m);
        EditText editText = (EditText) inflate.findViewById(R.id.smalihelpEditText1);
        if (!C3112bn.m19040o(str)) {
            editText.setText(str);
        }
        if (C3102bd.f18291a) {
            imageView.setImageResource(R.drawable.ic_close);
        } else {
            imageView.setImageResource(R.drawable.ic_close_dark);
        }
        imageView.setOnClickListener(new View.OnClickListener(editText) { // from class: ru.maximoff.apktool.util.al.51

            /* renamed from: a */
            private final EditText f17964a;

            {
                this.f17964a = editText;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f17964a.requestFocus();
                this.f17964a.setText("");
            }
        });
        if (editText.getText().length() == 0) {
            imageView.setVisibility(8);
        }
        editText.addTextChangedListener(new TextWatcher(imageView, c3311m) { // from class: ru.maximoff.apktool.util.al.52

            /* renamed from: a */
            private final ImageView f17965a;

            /* renamed from: b */
            private final C3311m f17966b;

            {
                this.f17965a = imageView;
                this.f17966b = c3311m;
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    this.f17965a.setVisibility(8);
                } else {
                    this.f17965a.setVisibility(0);
                }
                this.f17966b.m20008a(editable.toString());
            }
        });
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.smali_help).m435b(inflate).m420a(R.string.close_cur, (DialogInterface.OnClickListener) null).m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(c3311m, str) { // from class: ru.maximoff.apktool.util.al.53

            /* renamed from: a */
            private final C3311m f17967a;

            /* renamed from: b */
            private final String f17968b;

            {
                this.f17967a = c3311m;
                this.f17968b = str;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f17967a.m20008a(this.f17968b);
            }
        });
        m438b.show();
    }

    /* renamed from: p */
    public static void m18614p(Context context) {
        if (!C3102bd.m18925a(context, "installLocation_notice", true)) {
            return;
        }
        new DialogInterfaceC0070b.a(context).m418a(R.string.attention).m433b(R.string.mapp_inLocation_info).m420a(R.string.f21470ok, (DialogInterface.OnClickListener) null).m440c(R.string.not_remind, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.al.54

            /* renamed from: a */
            private final Context f17969a;

            {
                this.f17969a = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3102bd.m18938b(this.f17969a, "installLocation_notice", false);
                dialogInterface.cancel();
            }
        }).m429a(false).m438b().show();
    }

    /* renamed from: a */
    public static int m18523a(InputStream inputStream) {
        int[] iArr = {0};
        new C0546b(C1887e.m13984b(inputStream)).m4018a(new C0547c(iArr) { // from class: ru.maximoff.apktool.util.al.55

            /* renamed from: a */
            private final int[] f17970a;

            {
                this.f17970a = iArr;
            }

            @Override // p060c.p061a.p062a.AbstractC0549e
            /* renamed from: a */
            public AbstractC0549e mo4019a(String str, String str2) {
                return str2.equalsIgnoreCase("manifest") ? new AbstractC0549e(this, super.mo4019a(str, str2), this.f17970a) { // from class: ru.maximoff.apktool.util.al.55.1

                    /* renamed from: a */
                    private final AnonymousClass55 f17971a;

                    /* renamed from: b */
                    private final int[] f17972b;

                    {
                        this.f17971a = this;
                        this.f17972b = r3;
                    }

                    @Override // p060c.p061a.p062a.AbstractC0549e
                    /* renamed from: a */
                    public void mo4032a(String str3, String str4, int i, int i2, Object obj) {
                        if (str4.equalsIgnoreCase("versionCode")) {
                            this.f17972b[0] = ((Integer) obj).intValue();
                        }
                        super.mo4032a(str3, str4, i, i2, obj);
                    }
                } : super.mo4019a(str, str2);
            }
        });
        return iArr[0];
    }

    /* renamed from: q */
    public static boolean m18615q(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
