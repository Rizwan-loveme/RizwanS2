package ru.maximoff.apktool.util;

import android.content.Context;
import java.p209io.BufferedInputStream;
import java.p209io.BufferedOutputStream;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FileOutputStream;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import ru.maximoff.apktool.util.p310h.C3247a;
import ru.maximoff.apktool.util.p310h.C3248b;
import ru.p294a.C2602u;
import ru.p294a.C2604w;

/* compiled from: Zipper.java */
/* renamed from: ru.maximoff.apktool.util.bs */
/* loaded from: classes.dex */
public class C3117bs {
    /* renamed from: a */
    public static void m19067a(File[] fileArr, String str, int i) {
        m19068a(fileArr, str, i, false, 0);
    }

    /* renamed from: a */
    public static void m19068a(File[] fileArr, String str, int i, boolean z, int i2) {
        m19069a(fileArr, str, i, z, i2, (String) null);
    }

    /* renamed from: a */
    public static void m19069a(File[] fileArr, String str, int i, boolean z, int i2, String str2) {
        File file = new File(new StringBuffer().append(new StringBuffer().append(str).append(".bak_").toString()).append(System.currentTimeMillis()).toString());
        File file2 = new File(str);
        boolean z2 = file2.exists() && file2.isFile() && z;
        try {
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    if (file2.exists() && file2.isFile()) {
                        file2.renameTo(file);
                    }
                    List<File> m19061a = m19061a(fileArr);
                    int length = fileArr[0].getParent().length() + 1;
                    C3248b m19496a = C3248b.m19496a(new FileOutputStream(str));
                    m19496a.m16215a(C3102bd.f18315aw);
                    m19496a.m16212a(i);
                    if (str2 == null) {
                        m19496a.m16213a("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates");
                    } else if (!"".equals(str2)) {
                        m19496a.m16213a(str2);
                    }
                    byte[] bArr = new byte[C3249i.m19500a()];
                    if (z2) {
                        try {
                            C2604w c2604w = new C2604w(file);
                            Enumeration<C2602u> m16163b = c2604w.m16163b();
                            while (m16163b.hasMoreElements()) {
                                C2602u nextElement = m16163b.nextElement();
                                String name = nextElement.getName();
                                if (i2 == 1) {
                                    File file3 = new File(new StringBuffer().append(new StringBuffer().append(fileArr[0].getParent()).append(File.separator).toString()).append(name).toString());
                                    if (m19061a.contains(file3) && file3.isFile()) {
                                    }
                                }
                                arrayList.add(name);
                                BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                                C2602u c2602u = new C2602u(name);
                                c2602u.setTime(nextElement.getTime());
                                long size = nextElement.getSize();
                                c2602u.setCrc(nextElement.getCrc());
                                if (nextElement.getMethod() == 0 && size >= 0) {
                                    c2602u.setMethod(0);
                                    c2602u.setSize(size);
                                    c2602u.setCompressedSize(size);
                                } else {
                                    c2602u.setMethod(8);
                                    c2602u.setCompressedSize(-1L);
                                }
                                m19496a.mo16214a(c2602u);
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        m19496a.write(bArr, 0, read);
                                    }
                                }
                                m19496a.flush();
                                m19496a.m16218b();
                                bufferedInputStream.close();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    for (File file4 : m19061a) {
                        String substring = file4.getAbsolutePath().substring(length);
                        if (file4.isDirectory()) {
                            if (!substring.endsWith(File.separator)) {
                                substring = new StringBuffer().append(substring).append(File.separator).toString();
                            }
                            if (!arrayList.contains(substring)) {
                                C2602u c2602u2 = new C2602u(substring);
                                c2602u2.setTime(file4.lastModified());
                                m19496a.mo16214a(c2602u2);
                                m19496a.flush();
                                m19496a.m16218b();
                            }
                        } else {
                            if (arrayList.contains(substring)) {
                                if (i2 == 0) {
                                    substring = m19058a(substring, arrayList);
                                } else if (i2 == 2) {
                                }
                            }
                            C2602u c2602u3 = new C2602u(substring);
                            c2602u3.setTime(file4.lastModified());
                            m19496a.mo16214a(c2602u3);
                            if (file4.equals(file2)) {
                                file4 = file;
                            }
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file4), bArr.length);
                            while (true) {
                                int read2 = bufferedInputStream2.read(bArr);
                                if (read2 == -1) {
                                    break;
                                } else {
                                    m19496a.write(bArr, 0, read2);
                                }
                            }
                            m19496a.flush();
                            m19496a.m16218b();
                            bufferedInputStream2.close();
                        }
                    }
                    m19496a.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Error e4) {
                e4.printStackTrace();
            }
            if (file.exists()) {
                if (z2) {
                    file.renameTo(new File(new StringBuffer().append(str).append(".bak").toString()));
                } else {
                    file.delete();
                }
            }
        } catch (Throwable th) {
            if (file.exists()) {
                if (z2) {
                    file.renameTo(new File(new StringBuffer().append(str).append(".bak").toString()));
                } else {
                    file.delete();
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static String m19058a(String str, List<String> list) {
        if (!list.isEmpty() && list.contains(str)) {
            int i = 1;
            int lastIndexOf = str.lastIndexOf(46);
            int lastIndexOf2 = str.lastIndexOf(47);
            while (true) {
                if (lastIndexOf > lastIndexOf2) {
                    String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str.substring(0, lastIndexOf)).append(" (").toString()).append(i).toString()).append(")").toString()).append(str.substring(lastIndexOf)).toString();
                    if (!list.contains(stringBuffer)) {
                        return stringBuffer;
                    }
                } else {
                    String stringBuffer2 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str).append(" (").toString()).append(i).toString()).append(")").toString();
                    if (!list.contains(stringBuffer2)) {
                        return stringBuffer2;
                    }
                }
                i++;
            }
        } else {
            return str;
        }
    }

    /* renamed from: a */
    public static List<File> m19061a(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        if (fileArr == null) {
            return arrayList;
        }
        for (File file : fileArr) {
            arrayList.add(file);
            if (file.isDirectory()) {
                arrayList.addAll(m19061a(file.listFiles()));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m19062a(Context context, File file, File file2, List<String> list, boolean z) {
        m19064a(context, file, file2, list, z, false, (Map) null, -1);
    }

    /* renamed from: a */
    public static void m19063a(Context context, File file, File file2, List<String> list, boolean z, Map<String, String> map) {
        m19064a(context, file, file2, list, z, false, map, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m19064a(Context context, File file, File file2, List<String> list, boolean z, boolean z2, Map<String, String> map, int i) {
        String str;
        boolean z3;
        if (file2.exists() && file2.isFile()) {
            throw new Exception(new StringBuffer().append(new StringBuffer().append("File \"").append(file2.getAbsolutePath()).toString()).append("\" is exists, break").toString());
        }
        if (!file2.exists() && !file2.mkdirs()) {
            throw new Exception(new StringBuffer().append(new StringBuffer().append("Failed to create folder \"").append(file2.getAbsolutePath()).toString()).append("\", break").toString());
        }
        HashMap hashMap = new HashMap();
        if (i < 0) {
            i = m19054a(list, z, z2);
        }
        byte[] bArr = new byte[C3249i.m19500a()];
        C2604w c2604w = new C2604w(file);
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (list != null && !list.isEmpty()) {
                boolean contains = list.contains(name);
                if (contains || z) {
                    z3 = contains;
                } else {
                    Iterator<String> it = list.iterator();
                    z3 = contains;
                    while (it.hasNext() && !(z3 = name.endsWith(it.next()))) {
                    }
                }
                if (!z3) {
                    continue;
                }
            }
            String substring = i > 0 ? name.substring(i) : name;
            String m19059a = m19059a(substring, nextElement.isDirectory(), file2);
            if (m19059a != null && ((Long) hashMap.get(m19059a)) == null) {
                hashMap.put(m19059a, new Long(nextElement.getTime()));
            }
            if (nextElement.isDirectory()) {
                continue;
            } else {
                String[] m19641b = C3262u.m19641b(substring);
                if (!m19641b[1].equals("")) {
                    m19641b[1] = new StringBuffer().append(".").append(m19641b[1]).toString();
                }
                if (map != null && (str = map.get(substring)) != null) {
                    m19641b[0] = new StringBuffer().append(str).append(m19641b[0]).toString();
                }
                File file3 = new File(new StringBuffer().append(new StringBuffer().append(file2).append(File.separator).toString()).append(C3262u.m19566a(context, file2.getAbsolutePath(), m19641b[0], m19641b[1], 0)).toString());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3), bArr.length);
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    } finally {
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        C3262u.m19610a(file3, nextElement.getTime());
                    }
                }
            }
        }
        c2604w.close();
        for (Map.Entry entry : hashMap.entrySet()) {
            C3262u.m19610a(new File((String) entry.getKey()), ((Long) entry.getValue()).longValue());
        }
    }

    /* renamed from: a */
    public static void m19065a(String str, String str2, List<String> list) {
        m19066a(str, str2, list, (List<C3247a>) new ArrayList(), false);
    }

    /* renamed from: a */
    public static void m19066a(String str, String str2, List<String> list, List<C3247a> list2, boolean z) {
        BufferedInputStream bufferedInputStream;
        C2604w c2604w = new C2604w(str);
        String m16164c = c2604w.m16164c();
        Enumeration<C2602u> m16163b = c2604w.m16163b();
        C3248b m19496a = C3248b.m19496a(new FileOutputStream(str2));
        m19496a.m16215a(z || C3102bd.f18315aw);
        if (m16164c != null) {
            m19496a.m16213a(m16164c);
        }
        byte[] bArr = new byte[C3249i.m19500a()];
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (name != null && !C3112bn.m19040o(name) && (list.isEmpty() || !list.contains(name))) {
                C2602u c2602u = new C2602u(name);
                c2602u.setTime(nextElement.getTime());
                long size = nextElement.getSize();
                c2602u.setCrc(nextElement.getCrc());
                int m19053a = m19053a(list2, nextElement);
                if (m19053a >= 0) {
                    C3247a c3247a = list2.get(m19053a);
                    C2602u c2602u2 = new C2602u(c3247a.m19491i());
                    c2602u2.setMethod(c3247a.m19487e());
                    c2602u2.setTime(c3247a.m19484c());
                    if (c3247a.m19488f() != null) {
                        File m19488f = c3247a.m19488f();
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(m19488f), bArr.length);
                        c2602u2.setCrc(m19057a(m19488f.getAbsolutePath()));
                        if (c3247a.m19487e() == 0) {
                            c2602u2.setSize(m19488f.length());
                            c2602u2.setCompressedSize(m19488f.length());
                        } else {
                            c2602u2.setCompressedSize(-1L);
                        }
                    } else {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                        c2602u2.setCrc(c3247a.m19486d());
                        if (c3247a.m19487e() == 0) {
                            c2602u2.setSize(c3247a.m19479b());
                            c2602u2.setCompressedSize(c3247a.m19472a());
                            bufferedInputStream = bufferedInputStream2;
                        } else {
                            c2602u2.setCompressedSize(-1L);
                            bufferedInputStream = bufferedInputStream2;
                        }
                    }
                    c2602u = c2602u2;
                } else if (nextElement.getMethod() == 0 && size >= 0) {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                    c2602u.setMethod(0);
                    c2602u.setSize(size);
                    c2602u.setCompressedSize(size);
                    bufferedInputStream = bufferedInputStream3;
                } else {
                    BufferedInputStream bufferedInputStream4 = new BufferedInputStream(c2604w.m16160a(nextElement), bArr.length);
                    c2602u.setMethod(8);
                    c2602u.setCompressedSize(-1L);
                    bufferedInputStream = bufferedInputStream4;
                }
                m19496a.mo16214a(c2602u);
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    } else {
                        m19496a.write(bArr, 0, read);
                    }
                }
                bufferedInputStream.close();
                m19496a.flush();
                m19496a.m16218b();
            }
        }
        m19496a.flush();
        m19496a.close();
        c2604w.close();
    }

    /* renamed from: a */
    private static int m19053a(List<C3247a> list, C2602u c2602u) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (c2602u.getName().equals(list.get(i2).m19492j())) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: a */
    public static List<String> m19060a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Enumeration<C2602u> m16163b = new C2604w(str).m16163b();
        while (m16163b.hasMoreElements()) {
            C2602u nextElement = m16163b.nextElement();
            String name = nextElement.getName();
            if (nextElement.isDirectory() || !name.endsWith(str2)) {
                arrayList.add(name);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static String m19059a(String str, boolean z, File file) {
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf <= 0) {
            if (z) {
                lastIndexOf = str.length();
            } else {
                return (String) null;
            }
        }
        File file2 = new File(file, str.substring(0, lastIndexOf));
        file2.mkdirs();
        return file2.getAbsolutePath();
    }

    /* renamed from: a */
    public static long m19057a(String str) {
        return m19055a(new File(str));
    }

    /* renamed from: a */
    public static long m19055a(File file) {
        try {
            return m19056a(new BufferedInputStream(new FileInputStream(file)));
        } catch (Exception e2) {
            return -1L;
        }
    }

    /* renamed from: a */
    public static long m19056a(InputStream inputStream) {
        try {
            try {
                byte[] bArr = new byte[C3249i.m19500a()];
                CRC32 crc32 = new CRC32();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                if (inputStream == null) {
                    return value;
                }
                try {
                    inputStream.close();
                    return value;
                } catch (Exception e2) {
                    return value;
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Exception e4) {
            return -1L;
        }
    }

    /* renamed from: a */
    private static int m19054a(List<String> list, boolean z, boolean z2) {
        if (!z || !z2 || list == null || list.isEmpty()) {
            return 0;
        }
        Iterator<String> it = list.iterator();
        int i = Integer.MAX_VALUE;
        while (it.hasNext()) {
            int indexOf = it.next().indexOf(47) + 1;
            if (indexOf < i) {
                i = indexOf;
            }
        }
        return i;
    }
}
