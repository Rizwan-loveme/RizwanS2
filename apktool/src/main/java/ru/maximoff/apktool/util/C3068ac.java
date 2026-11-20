package ru.maximoff.apktool.util;

import android.content.Context;
import android.telephony.SmsMessage;
import com.srizwan.apktool.R;

/* compiled from: IconTypes.java */
/* renamed from: ru.maximoff.apktool.util.ac */
/* loaded from: classes.dex */
public class C3068ac {
    /* renamed from: a */
    public static int[] m18400a(Context context, String str) {
        if (str.equalsIgnoreCase("Apktool_M.backup") || str.matches("^apktool_m\\.\\d+\\.backup$")) {
            return new int[]{R.drawable.ic_settings_dark, C3246h.m19470a(context, R.color.colorArchive)};
        }
        if (str.endsWith(".apk")) {
            return new int[]{R.drawable.ic_apk, C3246h.m19470a(context, R.color.colorApk)};
        }
        if (str.endsWith(".jar")) {
            return new int[]{R.drawable.ic_jar, C3246h.m19470a(context, R.color.colorArchive)};
        }
        if (str.endsWith(".apkm")) {
            return new int[]{R.drawable.ic_apk, C3246h.m19470a(context, R.color.colorFile)};
        }
        if (str.endsWith(".dex")) {
            return new int[]{R.drawable.ic_dex, C3246h.m19470a(context, R.color.colorDex)};
        }
        if (str.endsWith(".arsc")) {
            return new int[]{R.drawable.ic_arsc, C3246h.m19470a(context, R.color.colorArsc)};
        }
        if (str.endsWith(".apks") || str.endsWith(".xapk")) {
            return new int[]{R.drawable.ic_apk, C3246h.m19470a(context, R.color.colorArchive)};
        }
        if (str.endsWith(".ttf") || str.endsWith(".otf")) {
            return new int[]{R.drawable.ic_font, C3246h.m19470a(context, R.color.colorFont)};
        }
        if (str.endsWith(".xls") || str.endsWith(".xlsx")) {
            return new int[]{R.drawable.ic_xls, C3246h.m19470a(context, R.color.colorXls)};
        }
        if (str.endsWith(".pdf")) {
            return new int[]{R.drawable.ic_pdf, C3246h.m19470a(context, R.color.colorPdf)};
        }
        if (str.endsWith(".so")) {
            return new int[]{R.drawable.ic_lib, C3246h.m19470a(context, R.color.colorFile)};
        }
        if (str.endsWith(".jks") || str.endsWith(".bks") || str.endsWith(".keystore") || str.endsWith(".key") || str.endsWith(".pk8")) {
            return new int[]{R.drawable.ic_keystore, C3246h.m19470a(context, R.color.colorFile)};
        }
        for (String str2 : new String[]{"3gp", "asf", "avi", "mp4", "mpe", "mpeg", "mpg", "mpg4", "m4u", "m4v", "mov", "rmvb", "webm"}) {
            if (str.endsWith(new StringBuffer().append(".").append(str2).toString())) {
                return new int[]{R.drawable.ic_video, C3246h.m19470a(context, R.color.colorVideo)};
            }
        }
        for (String str3 : C3249i.m19501b()) {
            if (str.endsWith(new StringBuffer().append(".").append(str3).toString())) {
                return new int[]{R.drawable.ic_text, C3246h.m19470a(context, R.color.colorText)};
            }
        }
        for (String str4 : new String[]{"htm", "html"}) {
            if (str.endsWith(new StringBuffer().append(".").append(str4).toString())) {
                return new int[]{R.drawable.ic_html, C3246h.m19470a(context, R.color.colorHtml)};
            }
        }
        for (String str5 : new String[]{"jpeg", "jpg", "bmp", "gif", "png", "webp"}) {
            if (str.endsWith(new StringBuffer().append(".").append(str5).toString())) {
                return new int[]{R.drawable.ic_image, C3246h.m19470a(context, R.color.colorImage)};
            }
        }
        for (String str6 : new String[]{"m3u", "m4a", "m4b", "m4p", "mp2", "mp3", "mpga", "ogg", "oga", "wav", "wma", "wmv", SmsMessage.FORMAT_3GPP, "flac", "amr", "awb"}) {
            if (str.endsWith(new StringBuffer().append(".").append(str6).toString())) {
                return new int[]{R.drawable.ic_audio, C3246h.m19470a(context, R.color.colorAudio)};
            }
        }
        for (String str7 : new String[]{"zip", "rar", "7z", "tar", "tar.gz", "hwt", "aab", "xpi"}) {
            if (str.endsWith(new StringBuffer().append(".").append(str7).toString())) {
                return new int[]{R.drawable.ic_archive, C3246h.m19470a(context, R.color.colorArchive)};
            }
        }
        return new int[]{R.drawable.ic_file, C3246h.m19470a(context, R.color.colorFile)};
    }
}
