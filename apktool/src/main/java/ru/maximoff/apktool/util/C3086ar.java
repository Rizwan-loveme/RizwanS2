package ru.maximoff.apktool.util;

import android.content.Context;
import android.hardware.Camera;
import android.p008os.Environment;
import java.nio.charset.StandardCharsets;
import java.p209io.BufferedReader;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MountInfo.java */
/* renamed from: ru.maximoff.apktool.util.ar */
/* loaded from: classes.dex */
public class C3086ar {

    /* renamed from: a */
    public String f18030a;

    /* renamed from: b */
    public String f18031b;

    /* renamed from: c */
    public String f18032c;

    /* renamed from: d */
    public String f18033d;

    /* renamed from: a */
    public static List<C3086ar> m18670a() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/mounts"), StandardCharsets.UTF_8));
            ArrayList arrayList = new ArrayList();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            return arrayList;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return arrayList;
                        }
                    }
                    String[] split = readLine.split(" ");
                    if (split.length >= 6) {
                        C3086ar c3086ar = new C3086ar();
                        c3086ar.f18030a = split[0];
                        c3086ar.f18031b = split[1];
                        c3086ar.f18032c = split[2];
                        c3086ar.f18033d = split[3];
                        arrayList.add(c3086ar);
                    }
                } finally {
                }
            }
        } catch (Exception e3) {
            return new ArrayList();
        }
    }

    /* renamed from: b */
    public static List<C3086ar> m18672b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/mountinfo"), StandardCharsets.UTF_8));
            ArrayList arrayList = new ArrayList();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            return arrayList;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return arrayList;
                        }
                    }
                    String[] split = readLine.split(" ");
                    if (split.length >= 9) {
                        C3086ar c3086ar = new C3086ar();
                        c3086ar.f18030a = split[7];
                        c3086ar.f18031b = split[4];
                        c3086ar.f18032c = split[6];
                        c3086ar.f18033d = split[8];
                        arrayList.add(c3086ar);
                    }
                } finally {
                }
            }
        } catch (Exception e3) {
            return new ArrayList();
        }
    }

    /* renamed from: a */
    public static File[] m18671a(Context context, String str, boolean z) {
        List<C3086ar> m18672b = m18672b();
        m18672b.addAll(m18670a());
        if (str == null) {
            str = "";
        }
        if (!str.endsWith("/")) {
            str = new StringBuffer().append(str).append("/").toString();
        }
        ArrayList arrayList = new ArrayList();
        for (C3086ar c3086ar : m18672b) {
            if (!c3086ar.f18032c.equals("tmpfs") && !c3086ar.f18032c.equals(Camera.Parameters.EFFECT_NONE) && c3086ar.f18031b.startsWith(str)) {
                String substring = c3086ar.f18031b.substring(str.length());
                if (substring.length() > 0 && !substring.equals("/")) {
                    String[] split = substring.split("/");
                    if (split.length >= 1) {
                        File file = new File(new StringBuffer().append(str).append(split[0]).toString());
                        if (file.isFile() || file.isDirectory()) {
                            if (z || file.getName().charAt(0) != '.') {
                                if (!arrayList.contains(file)) {
                                    arrayList.add(file);
                                }
                            }
                        }
                    }
                }
            }
        }
        String substring2 = C3249i.f19550j.substring(0, C3249i.f19550j.length() - 1);
        if (str.equals("/")) {
            File rootDirectory = Environment.getRootDirectory();
            if (!arrayList.contains(rootDirectory)) {
                arrayList.add(rootDirectory);
            }
        } else if (str.equals("/data/")) {
            File file2 = new File(C3249i.f19549i);
            if (!arrayList.contains(file2)) {
                arrayList.add(file2);
            }
            File file3 = new File(substring2);
            if (!arrayList.contains(file3)) {
                arrayList.add(file3);
            }
        } else if (str.equals(substring2)) {
            File file4 = new File(C3249i.f19550j);
            if (!arrayList.contains(file4)) {
                arrayList.add(file4);
            }
        }
        if (str.startsWith(C3249i.f19549i)) {
            try {
                String substring3 = str.substring(C3249i.f19549i.length());
                for (String str2 : new C3252l(context).m19511e()) {
                    if (str2.startsWith(substring3)) {
                        String[] split2 = str2.substring(0, str2.lastIndexOf(58)).split("/");
                        String substring4 = C3249i.f19549i.substring(0, C3249i.f19549i.length() - 1);
                        for (int i = 0; i < split2.length && substring4.length() <= str.length(); i++) {
                            substring4 = new StringBuffer().append(substring4).append(new StringBuffer().append("/").append(split2[i]).toString()).toString();
                        }
                        File file5 = new File(substring4);
                        if (z || file5.getName().charAt(0) != '.') {
                            if (!arrayList.contains(file5)) {
                                arrayList.add(file5);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (arrayList.isEmpty()) {
            return (File[]) null;
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }
}
