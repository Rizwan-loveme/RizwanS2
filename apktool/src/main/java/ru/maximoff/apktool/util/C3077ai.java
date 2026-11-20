package ru.maximoff.apktool.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;

/* compiled from: LocaleHelper.java */
/* renamed from: ru.maximoff.apktool.util.ai */
/* loaded from: classes.dex */
public class C3077ai {
    /* renamed from: a */
    public static Context m18488a(Context context) {
        return m18489a(context, C3080al.m18600g(context));
    }

    /* renamed from: a */
    public static Context m18489a(Context context, String str) {
        return Build.VERSION.SDK_INT >= 24 ? m18490b(context, str) : m18491c(context, str);
    }

    @TargetApi(24)
    /* renamed from: b */
    private static Context m18490b(Context context, String str) {
        Locale locale;
        if (str.equals("en")) {
            locale = Locale.ROOT;
        } else {
            locale = new Locale(str);
        }
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context.createConfigurationContext(configuration);
    }

    @SuppressWarnings("deprecation")
    /* renamed from: c */
    private static Context m18491c(Context context, String str) {
        Locale locale;
        if (str.equals("en")) {
            locale = Locale.ROOT;
        } else {
            locale = new Locale(str);
        }
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLayoutDirection(locale);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
