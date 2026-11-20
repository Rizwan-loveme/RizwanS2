package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: DictionaryUtils.java */
/* renamed from: ru.maximoff.apktool.util.f.e */
/* loaded from: classes.dex */
public class C3225e {
    /* renamed from: a */
    public static File[] m19329a() {
        if (C3102bd.f18339v == null) {
            return (File[]) null;
        }
        File file = new File(C3102bd.f18339v, "dictionary");
        if (!file.exists() || !file.isDirectory()) {
            file.mkdir();
        }
        return file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.f.e.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.toLowerCase().endsWith(".amd") || str.toLowerCase().endsWith(".mtd");
            }
        });
    }

    /* renamed from: b */
    public static String[] m19330b() {
        File[] m19329a = m19329a();
        if (m19329a == null || m19329a.length == 0) {
            return (String[]) null;
        }
        String[] strArr = new String[m19329a.length];
        for (int i = 0; i < m19329a.length; i++) {
            strArr[i] = m19329a[i].getName();
        }
        return strArr;
    }

    /* renamed from: a */
    public static Map<String, String> m19325a(String str) {
        return m19326a(str, true);
    }

    /* renamed from: a */
    public static Map<String, String> m19326a(String str, boolean z) {
        return m19324a(new File(new StringBuffer().append(new StringBuffer().append(C3102bd.f18339v).append("/dictionary/").toString()).append(str).toString()), z);
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0130 A[Catch: IOException -> 0x0136, TRY_LEAVE, TryCatch #1 {IOException -> 0x0136, blocks: (B:93:0x012b, B:88:0x0130), top: B:92:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> m19324a(File file, boolean z) {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        String str;
        if (!file.exists() || file.isDirectory()) {
            return (Map) null;
        }
        FileInputStream fileInputStream3 = (FileInputStream) null;
        BufferedReader bufferedReader2 = (BufferedReader) null;
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str2 = (String) null;
            String str3 = (String) null;
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String trim = readLine.trim();
                        if (!trim.equals("{") && !trim.equals("")) {
                            if (trim.equals("}")) {
                                str3 = (String) null;
                                str2 = (String) null;
                            } else {
                                if (trim.startsWith("{")) {
                                    trim = trim.substring(1).trim();
                                }
                                if (trim.endsWith("}")) {
                                    trim = trim.substring(0, trim.length() - 1).trim();
                                }
                                if (trim.startsWith("\"") && trim.endsWith("\"")) {
                                    if (str2 == null) {
                                        str2 = trim.substring(1, trim.length() - 1);
                                    } else if (str3 == null) {
                                        String substring = trim.substring(1, trim.length() - 1);
                                        if (z) {
                                            str = str2.replaceAll("\\\\n", "\n").replaceAll("\\\\\"", "\"").replaceAll("\\\\'", "'").replace("&amp;", "&").replace("&lt;", "<");
                                            substring = substring.replaceAll("\\\\n", "\n").replaceAll("\\\\\"", "\"").replaceAll("\\\\'", "'").replace("&amp;", "&").replace("&lt;", "<");
                                        } else {
                                            str = str2;
                                        }
                                        linkedHashMap.put(str, substring);
                                        str3 = substring;
                                        str2 = str;
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader2 = bufferedReader;
                        fileInputStream2 = fileInputStream;
                        try {
                            e.printStackTrace();
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e3) {
                                    return (Map) null;
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            return (Map) null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return linkedHashMap;
            } catch (Exception e6) {
                e = e6;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream2 = fileInputStream3;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = bufferedReader2;
            fileInputStream = fileInputStream3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m19327a(Context context, String str, List<C3236p> list) {
        Map map;
        if (str == null || TextUtils.isEmpty(str)) {
            throw new IOException("File name is empty!");
        }
        if (list.isEmpty()) {
            throw new IOException("Strings list is empty!");
        }
        if (!str.toLowerCase().endsWith(".amd") && !str.toLowerCase().endsWith(".mtd")) {
            str = new StringBuffer().append(str).append(".amd").toString();
        }
        File file = new File(C3102bd.f18339v, "dictionary");
        if ((!file.exists() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException(new StringBuffer().append(new StringBuffer().append("Failed to create \"").append(C3112bn.m19033h(str)).toString()).append("\"!").toString());
        }
        File file2 = new File(file, str);
        StringBuilder sb = new StringBuilder();
        Map linkedHashMap = new LinkedHashMap();
        if (file2.exists() && file2.isFile()) {
            map = m19326a(file2.getName(), false);
        } else {
            file2 = new File(file, C3112bn.m19033h(str));
            map = linkedHashMap;
        }
        for (C3236p c3236p : list) {
            if (c3236p.m19387h() != null) {
                map.put(c3236p.m19386g().replaceAll("(?<!\\\\)\"", "\\\\\"").replaceAll("\n", "\\\\n"), c3236p.m19387h().replaceAll("(?<!\\\\)\"", "\\\\\"").replaceAll("\n", "\\\\n"));
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("{\n  \"").append((String) entry.getKey()).toString()).append("\"\n  \"").toString()).append((String) entry.getValue()).toString()).append("\"\n}\n").toString());
        }
        if (sb.length() > 0) {
            C3061a.m18319b(file2, sb.toString());
            return;
        }
        throw new IOException("No strings translated!");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m19328a(Context context, String str, Map<String, String> map) {
        Map map2;
        File file;
        if (str == null || TextUtils.isEmpty(str)) {
            throw new IOException("File name is empty!");
        }
        if (map.isEmpty()) {
            throw new IOException("Strings list is empty!");
        }
        if (!str.toLowerCase().endsWith(".amd") && !str.toLowerCase().endsWith(".mtd")) {
            str = new StringBuffer().append(str).append(".amd").toString();
        }
        File file2 = new File(C3102bd.f18339v, "dictionary");
        if ((!file2.exists() && !file2.mkdirs()) || !file2.isDirectory()) {
            throw new IOException(new StringBuffer().append(new StringBuffer().append("Failed to create \"").append(C3112bn.m19033h(str)).toString()).append("\"!").toString());
        }
        File file3 = new File(file2, str);
        StringBuilder sb = new StringBuilder();
        Map linkedHashMap = new LinkedHashMap();
        if (file3.exists() && file3.isFile()) {
            map2 = m19326a(file3.getName(), false);
            file = file3;
        } else {
            File file4 = new File(file2, C3112bn.m19033h(str));
            map2 = linkedHashMap;
            file = file4;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("{\n  \"").append((String) entry2.getKey()).toString()).append("\"\n  \"").toString()).append((String) entry2.getValue()).toString()).append("\"\n}\n").toString());
        }
        if (sb.length() > 0) {
            C3061a.m18319b(file, sb.toString());
            return;
        }
        throw new IOException("No strings translated!");
    }
}
