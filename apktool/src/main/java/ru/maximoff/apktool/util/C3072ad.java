package ru.maximoff.apktool.util;

/* compiled from: IconsList.java */
/* renamed from: ru.maximoff.apktool.util.ad */
/* loaded from: classes.dex */
public class C3072ad {

    /* renamed from: a */
    private static final String[] f17333a = {".apk", ".apks", ".apkm", ".xapk"};

    /* renamed from: b */
    private static final String[] f17334b = {".svg", ".xml"};

    /* renamed from: c */
    private static final String[] f17335c = {".mp4", ".3gp", ".avi", ".webm", ".mov", ".mkv"};

    /* renamed from: a */
    public static boolean m18430a(String str) {
        for (String str2 : f17333a) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        for (String str3 : f17334b) {
            if (str.toLowerCase().endsWith(str3)) {
                return true;
            }
        }
        for (String str4 : f17335c) {
            if (str.toLowerCase().endsWith(str4)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m18431b(String str) {
        for (String str2 : f17334b) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m18432c(String str) {
        for (String str2 : f17335c) {
            if (str.toLowerCase().endsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
