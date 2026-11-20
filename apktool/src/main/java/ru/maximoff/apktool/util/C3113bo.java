package ru.maximoff.apktool.util;

import android.app.Activity;
import android.p008os.Build;
import com.srizwan.apktool.R;
import java.lang.Thread;
import java.p209io.File;
import java.util.concurrent.TimeoutException;
import ru.maximoff.apktool.service.C3056b;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: TopExceptionHandler.java */
/* renamed from: ru.maximoff.apktool.util.bo */
/* loaded from: classes.dex */
public class C3113bo implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f18387a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b */
    private Activity f18388b;

    /* renamed from: c */
    private boolean f18389c;

    public C3113bo(Activity activity, boolean z) {
        this.f18388b = activity;
        this.f18389c = z;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        int i;
        if (!thread.getName().equals("FinalizerWatchdogDaemon") || !(th instanceof TimeoutException)) {
            if (this.f18389c) {
                try {
                    i = this.f18388b.getPackageManager().getPackageInfo(this.f18388b.getPackageName(), 0).versionCode;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i = 1;
                }
                String m19032g = C3112bn.m19032g("dd/MM/yyyy HH:mm:ss");
                StackTraceElement[] stackTrace = th.getStackTrace();
                StringBuilder sb = new StringBuilder();
                sb.append(new StringBuffer().append(new StringBuffer().append("##### ").append(m19032g).toString()).append(" #####\n\n").toString());
                sb.append(th.toString()).append("\n\n");
                sb.append("--------------------------------\n\n");
                sb.append("---------- Stack trace ---------\n\n");
                sb.append("--------------------------------\n\n");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(new StringBuffer().append(new StringBuffer().append("    ").append(stackTraceElement.toString()).toString()).append("\n").toString());
                }
                Throwable cause = th.getCause();
                if (cause != null) {
                    sb.append("\n--------------------------------\n\n");
                    sb.append("------------- Cause ------------\n\n");
                    sb.append("--------------------------------\n\n");
                    sb.append(new StringBuffer().append(cause.toString()).append("\n\n").toString());
                    for (StackTraceElement stackTraceElement2 : cause.getStackTrace()) {
                        sb.append(new StringBuffer().append(new StringBuffer().append("    ").append(stackTraceElement2.toString()).toString()).append("\n").toString());
                    }
                }
                sb.append("\n--------------------------------\n\n");
                sb.append("------------- System -----------\n\n");
                sb.append("--------------------------------\n\n");
                sb.append(new StringBuffer().append(new StringBuffer().append("BUILD CODE: ").append(i).toString()).append("\n").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("SDK CODE: ").append(Build.VERSION.SDK_INT).toString()).append(" (").toString()).append(C3080al.m18532a(Build.VERSION.SDK_INT, true)).toString()).append(")\n").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("HASH CODE: ").append(C3080al.m18577b(this.f18388b)).toString()).append(C3080al.m18589c(this.f18388b) ? ".1" : new StringBuffer().append(".").append(C3080al.m18520a(2, 9)).toString()).toString()).append(" (").toString()).append(String.valueOf(C3102bd.f18295ac)).toString()).append(")\n").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append("HEAP: ").append(new C3266y().toString()).toString()).append("\n").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append("LANGUAGE: ").append(C3080al.m18600g(this.f18388b).toUpperCase()).toString()).append("\n").toString());
                if (C3085aq.m18667a()) {
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("MIUI OPTIMIZATION: ").append(C3085aq.m18669c() ? "OFF" : "ON").toString()).append(" (").toString()).append(C3085aq.m18668b()).toString()).append(")\n").toString());
                }
                sb.append("\n--------------------------------\n\n");
                sb.append("------------- Build ------------\n\n");
                sb.append("--------------------------------\n\n");
                C3112bn.m19010a(sb);
                sb.append("----------------------------------\n\n\n\n");
                try {
                    File file = new File(this.f18388b.getExternalFilesDir((String) null), "Apktool_M.crashlog.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    C3061a.m18319b(file, sb.toString());
                    C3056b c3056b = new C3056b(this.f18388b);
                    try {
                        c3056b.m18196a(Class.forName("ru.maximoff.apktool.CrashActivity"));
                        c3056b.m18194a(123);
                        c3056b.m18197a("app_crashed");
                        c3056b.m18195a(this.f18388b.getText(R.string.error), this.f18388b.getText(R.string.crash_log));
                        c3056b.m18192a(this.f18388b.getString(R.string.error), this.f18388b.getString(R.string.app_crashed));
                    } catch (ClassNotFoundException e3) {
                        throw new NoClassDefFoundError(e3.getMessage());
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            if (this.f18387a != null) {
                this.f18387a.uncaughtException(thread, th);
            }
        }
    }
}
