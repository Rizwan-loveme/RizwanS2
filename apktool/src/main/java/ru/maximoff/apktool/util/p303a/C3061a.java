package ru.maximoff.apktool.util.p303a;

import com.srizwan.apktool.R;
import java.p209io.BufferedInputStream;
import java.p209io.BufferedReader;
import java.p209io.File;
import java.p209io.FileFilter;
import java.p209io.FileInputStream;
import java.p209io.FileNotFoundException;
import java.p209io.FileOutputStream;
import java.p209io.IOException;
import java.p209io.InputStream;
import java.p209io.InputStreamReader;
import java.p209io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import org.p217b.p218a.p219a.C1887e;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import p046b.p047a.p050c.p051a.C0497h;
import ru.maximoff.apktool.p300e.AbstractAsyncTaskC2898a;
import ru.maximoff.apktool.util.C3090av;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.p308f.C3239s;

/* compiled from: ASUtils.java */
/* renamed from: ru.maximoff.apktool.util.a.a */
/* loaded from: classes.dex */
public class C3061a {
    /* renamed from: a */
    public static int m18289a(File file, AbstractAsyncTaskC2898a abstractAsyncTaskC2898a) {
        int i;
        String name;
        String name2;
        int i2 = 0;
        if (!file.isDirectory()) {
            return 0;
        }
        File file2 = new File(file, "/values/public.xml");
        if (!file2.isFile()) {
            return 0;
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: ru.maximoff.apktool.util.a.a.1
            @Override // java.p209io.FileFilter
            public boolean accept(File file3) {
                return file3.isDirectory() && !file3.getName().startsWith("values");
            }
        });
        if (listFiles == null) {
            i = 0;
        } else {
            List<C3090av> m18326d = m18326d(file2);
            int i3 = 0;
            while (true) {
                i = i2;
                if (i3 >= listFiles.length) {
                    break;
                }
                File file3 = listFiles[i3];
                File[] listFiles2 = file3.listFiles();
                if (listFiles2 != null) {
                    int indexOf = file3.getName().indexOf("-");
                    if (indexOf > 0) {
                        name = file3.getName().substring(0, indexOf);
                    } else {
                        name = file3.getName();
                    }
                    int i4 = i;
                    for (File file4 : listFiles2) {
                        int indexOf2 = file4.getName().indexOf(46);
                        if (indexOf2 > 0) {
                            name2 = file4.getName().substring(0, indexOf2);
                        } else {
                            name2 = file4.getName();
                        }
                        if (m18291a(m18326d, name, name2) == -1) {
                            int[] m18311a = m18311a(m18326d, name);
                            if (m18311a[0] > 0 && m18311a[1] > 0) {
                                m18326d.add(new C3090av(file.getParentFile().hashCode(), name, name2, String.format("0x%08x", new Integer(((m18311a[2] + 1) & 65535) + ((m18311a[0] & 255) << 24) + ((m18311a[1] & 255) << 16)))));
                                abstractAsyncTaskC2898a.mo3984d(R.string.res_added, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("@").append(name).toString()).append("/").toString()).append(name2).toString());
                                i4++;
                            }
                        }
                    }
                    i2 = i4;
                } else {
                    i2 = i;
                }
                i3++;
            }
            if (i > 0) {
                Collections.sort(m18326d, new Comparator<C3090av>() { // from class: ru.maximoff.apktool.util.a.a.2
                    @Override // java.util.Comparator
                    public int compare(C3090av c3090av, C3090av c3090av2) {
                        return m18333a(c3090av, c3090av2);
                    }

                    /* renamed from: a */
                    public int m18333a(C3090av c3090av, C3090av c3090av2) {
                        int compareTo = c3090av.m18724a().compareTo(c3090av2.m18724a());
                        return compareTo != 0 ? compareTo : c3090av.m18730d().compareTo(c3090av2.m18730d());
                    }
                });
                m18310a(file2, m18326d, true, (String) null, (String) null);
            }
        }
        return i;
    }

    /* renamed from: a */
    public static int m18291a(List<C3090av> list, String str, String str2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C3090av c3090av = list.get(i2);
                if (str.equals(c3090av.m18724a()) && str2.equals(c3090av.m18727b())) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: a */
    public static int[] m18311a(List<C3090av> list, String str) {
        int[] iArr = {0, 0, -1};
        for (C3090av c3090av : list) {
            if (str.equals(c3090av.m18724a())) {
                long parseLong = Long.parseLong(c3090av.m18730d().substring(6), 16);
                if (iArr[2] < parseLong) {
                    iArr[0] = c3090av.m18732f();
                    iArr[1] = c3090av.m18733g();
                    iArr[2] = (int) parseLong;
                }
            }
        }
        if (iArr[0] == 0) {
            iArr[0] = list.get(0).m18732f();
            iArr[1] = m18290a(list) + 1;
        }
        return iArr;
    }

    /* renamed from: a */
    public static int m18290a(List<C3090av> list) {
        int i = 0;
        for (C3090av c3090av : list) {
            if (i < c3090av.m18733g()) {
                i = c3090av.m18733g();
            }
        }
        return i;
    }

    /* renamed from: a */
    public static String m18293a(File file) {
        return m18298a(m18332i(file));
    }

    /* renamed from: a */
    public static String m18298a(String str) {
        Matcher matcher = Pattern.compile("\\sxmlns:(\\w+)=\"http://schemas.android.com/apk/res/android\"").matcher(str);
        return matcher.find() ? matcher.group(1) : "android";
    }

    /* renamed from: a */
    public static String m18299a(String str, String str2) {
        return (String) null;
    }

    /* renamed from: b */
    public static String m18315b(String str, String str2) {
        return m18316b(m18316b(m18316b(m18316b(m18316b(m18316b(m18316b(str, new StringBuffer().append(new StringBuffer().append("\\s+").append(str2).toString()).append(":isSplitRequired=\"(false|true)\"").toString(), ""), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+<meta-data\\s+").append(str2).toString()).append(":name=\"com\\.android\\.vending\\.splits\\.required\"\\s+").toString()).append(str2).toString()).append(":value=\"(false|true)\"\\s+/>").toString(), ""), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+<meta-data\\s+").append(str2).toString()).append(":name=\"com\\.android\\.vending\\.splits\"\\s+").toString()).append(str2).toString()).append(":(value|resource)=\"[^\"]+\"\\s+/>").toString(), ""), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+<meta-data\\s+").append(str2).toString()).append(":name=\"com\\.android\\.vending\\.derived\\.apk\\.id\"\\s+").toString()).append(str2).toString()).append(":value=\"\\d+\"\\s+/>").toString(), ""), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+<meta-data\\s+").append(str2).toString()).append(":name=\"com\\.android\\.stamp\\.source\"\\s+").toString()).append(str2).toString()).append(":(value|resource)=\"[^\"]+\"\\s+/>").toString(), ""), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+<meta-data\\s+").append(str2).toString()).append(":name=\"com\\.android\\.stamp\\.type\"\\s+").toString()).append(str2).toString()).append(":(value|resource)=\"[^\"]+\"\\s+/>").toString(), ""), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+<meta-data\\s+").append(str2).toString()).append(":name=\"com\\.android\\.dynamic\\.apk\\.fused\\.modules\"\\s+").toString()).append(str2).toString()).append(":(value|resource)=\"[^\"]+\"\\s+/>").toString(), "");
    }

    /* renamed from: c */
    public static String m18323c(String str, String str2) {
        return m18316b(str, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+<property\\s+").append(str2).toString()).append(":name=\"[^\"]+\"\\s+").toString()).append(str2).toString()).append(":(value|resource)=\"[^\"]*\"\\s+/>").toString(), "");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, C3063c> m18318b(File file) {
        FileInputStream fileInputStream;
        HashMap hashMap = new HashMap();
        if (file == null || !file.exists()) {
            return hashMap;
        }
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getElementsByTagName(C0497h.f3457a);
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Element element = (Element) elementsByTagName.item(i);
                    String attribute = element.getAttribute("name");
                    C3063c c3063c = new C3063c(attribute);
                    NodeList elementsByTagName2 = element.getElementsByTagName("enum");
                    for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
                        Element element2 = (Element) elementsByTagName2.item(i2);
                        c3063c.m18348a(element2.getAttribute("value"), element2.getAttribute("name"));
                    }
                    NodeList elementsByTagName3 = element.getElementsByTagName("flag");
                    for (int i3 = 0; i3 < elementsByTagName3.getLength(); i3++) {
                        Element element3 = (Element) elementsByTagName3.item(i3);
                        c3063c.m18348a(element3.getAttribute("value"), element3.getAttribute("name"));
                    }
                    if (!c3063c.m18349b()) {
                        hashMap.put(attribute, c3063c);
                    }
                }
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                return hashMap;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception e5) {
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    public static String m18314b(String str) {
        String stringBuffer;
        String str2;
        Matcher matcher = Pattern.compile("\\sxmlns:(\\w+)=\"http://schemas.android.com/apk/distribution\"").matcher(str);
        boolean find = matcher.find();
        String m18298a = m18298a(str);
        if (find) {
            str2 = matcher.group(1);
            stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("(").append(str2).toString()).append(":|").toString()).append(m18298a).toString()).append(":)?").toString();
        } else {
            stringBuffer = new StringBuffer().append(new StringBuffer().append("(").append(m18298a).toString()).append(":)?").toString();
            str2 = m18298a;
        }
        String m18316b = m18316b(m18316b(str, new StringBuffer().append(new StringBuffer().append("\\s+").append(stringBuffer).toString()).append("splitTypes=\"[^\"]*\"").toString(), ""), new StringBuffer().append(new StringBuffer().append("\\s+").append(stringBuffer).toString()).append("requiredSplitTypes=\"[^\"]*\"").toString(), "");
        if (find && !Pattern.compile(new StringBuffer().append(new StringBuffer().append("\\s").append(str2).toString()).append(":\\w+=\"[^\"]*\"").toString()).matcher(m18316b).find()) {
            return m18316b(m18316b, new StringBuffer().append(new StringBuffer().append("\\s+xmlns:").append(str2).toString()).append("=\"http://schemas.android.com/apk/distribution\"").toString(), "");
        }
        return m18316b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0062, code lost:
    
        if (r0.m18724a().equals(javax.xml.XMLConstants.XML_NS_PREFIX) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
    
        if (r0.m18727b().equals(r10) != false) goto L33;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m18310a(File file, List<C3090av> list, boolean z, String str, String str2) {
        Collections.sort(list, new Comparator<C3090av>() { // from class: ru.maximoff.apktool.util.a.a.3
            @Override // java.util.Comparator
            public int compare(C3090av c3090av, C3090av c3090av2) {
                return m18334a(c3090av, c3090av2);
            }

            /* renamed from: a */
            public int m18334a(C3090av c3090av, C3090av c3090av2) {
                int compareTo = c3090av.m18724a().compareTo(c3090av2.m18724a());
                return compareTo != 0 ? compareTo : c3090av.m18730d().compareTo(c3090av2.m18730d());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append("<resources>\n");
        Iterator<C3090av> it = list.iterator();
        while (it.hasNext()) {
            C3090av next = it.next();
            if (!next.m18731e() || z) {
                if (str == null || !next.m18724a().equals(XMLConstants.XML_NS_PREFIX) || !next.m18727b().equals(str)) {
                    sb.append(new StringBuffer().append(new StringBuffer().append("\t").append(next.toString()).toString()).append("\n").toString());
                }
            }
        }
        sb.append("</resources>");
        m18319b(file, sb.toString());
    }

    /* renamed from: a */
    public static void m18309a(File file, String str, String str2) {
        List<String> m18331h = m18331h(file);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < m18331h.size()) {
                String str3 = m18331h.get(i2);
                if ((str == null || !str3.contains(new StringBuffer().append(new StringBuffer().append("<public type=\"xml\" name=\"").append(str).toString()).append("\" ").toString())) && (str2 == null || !str3.contains(new StringBuffer().append(new StringBuffer().append("<public type=\"xml\" name=\"").append(str2).toString()).append("\" ").toString()))) {
                    if (i2 > 0) {
                        sb.append("\n");
                    }
                    sb.append(str3);
                }
                i = i2 + 1;
            } else {
                m18319b(file, sb.toString());
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> m18324c(File file) {
        FileInputStream fileInputStream;
        ArrayList arrayList = new ArrayList();
        if (file == null || !file.exists()) {
            return arrayList;
        }
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getElementsByTagName("public");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= elementsByTagName.getLength()) {
                        break;
                    }
                    String attribute = ((Element) elementsByTagName.item(i2)).getAttribute("type");
                    if (!arrayList.contains(attribute)) {
                        arrayList.add(attribute);
                    }
                    i = i2 + 1;
                }
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e5) {
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<C3090av> m18326d(File file) {
        FileInputStream fileInputStream;
        ArrayList arrayList = new ArrayList();
        if (file == null || !file.exists()) {
            return arrayList;
        }
        int hashCode = file.getParentFile().getParentFile().getParentFile().hashCode();
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getElementsByTagName("public");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= elementsByTagName.getLength()) {
                        break;
                    }
                    Element element = (Element) elementsByTagName.item(i2);
                    arrayList.add(new C3090av(hashCode, element.getAttribute("type"), element.getAttribute("name"), element.getAttribute("id")));
                    i = i2 + 1;
                }
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream2;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e5) {
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> m18328e(File file) {
        FileInputStream fileInputStream;
        HashMap hashMap = new HashMap();
        if (file == null || !file.exists()) {
            return hashMap;
        }
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e2) {
        } catch (Throwable th) {
            th = th;
            fileInputStream = fileInputStream2;
        }
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getElementsByTagName("color");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= elementsByTagName.getLength()) {
                    break;
                }
                Element element = (Element) elementsByTagName.item(i2);
                hashMap.put(element.getAttribute("name"), element.getTextContent());
                i = i2 + 1;
            }
        } catch (Exception e3) {
            fileInputStream2 = fileInputStream;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e5) {
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map<String, String> m18329f(File file) {
        FileInputStream fileInputStream;
        HashMap hashMap = new HashMap();
        if (file == null || !file.exists()) {
            return hashMap;
        }
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e2) {
        } catch (Throwable th) {
            th = th;
            fileInputStream = fileInputStream2;
        }
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getElementsByTagName("string");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= elementsByTagName.getLength()) {
                    break;
                }
                Element element = (Element) elementsByTagName.item(i2);
                hashMap.put(element.getAttribute("name"), element.getTextContent());
                i = i2 + 1;
            }
        } catch (Exception e3) {
            fileInputStream2 = fileInputStream;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e5) {
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static List<C3090av> m18307a(List<C3090av> list, List<C3090av> list2, Map<Long, Long> map, boolean z) {
        int i = 127;
        ArrayList arrayList = new ArrayList();
        for (C3090av c3090av : list) {
            int m18292a = m18292a(list2, c3090av);
            if (m18292a < 0) {
                arrayList.add(c3090av);
            } else {
                C3090av c3090av2 = list2.get(m18292a);
                if (map != null && map.get(new Long(c3090av2.m18734h())) != null) {
                    arrayList.add(c3090av);
                } else {
                    if (c3090av2.m18731e()) {
                        c3090av2.m18725a(c3090av.hashCode());
                        c3090av2.m18726a(c3090av.m18727b());
                    } else {
                        c3090av2.m18728b(c3090av.m18729c());
                    }
                    arrayList.add(c3090av2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            int m18732f = ((C3090av) arrayList.get(0)).m18732f();
            if (m18732f == 0) {
                m18732f = 127;
            }
            i = m18732f;
        }
        for (C3090av c3090av3 : list2) {
            if (z || c3090av3.m18732f() == i) {
                if (m18292a(arrayList, c3090av3) < 0) {
                    arrayList.add(c3090av3);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static int m18292a(List<C3090av> list, C3090av c3090av) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2).m18730d().equals(c3090av.m18730d())) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: g */
    public static String m18330g(File file) {
        String m18332i = m18332i(file);
        String m18298a = m18298a(m18332i);
        Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<meta-data\\s+").append(m18298a).toString()).append(":name=\"com\\.android\\.vending\\.splits\"\\s+").toString()).append(m18298a).toString()).append(":(value|resource)=\"@xml/(splits\\d+)\"\\s+/>").toString()).matcher(m18332i);
        return matcher.find() ? matcher.group(2) : (String) null;
    }

    /* renamed from: a */
    public static String m18300a(String str, String str2, String str3) {
        if (str == null) {
            return "";
        }
        return (str2 == null || str3 == null) ? str : str.replace(str2, str3);
    }

    /* renamed from: a */
    public static String m18302a(String str, String str2, String str3, String str4) {
        if (str == null) {
            return "";
        }
        String replace = str.replace(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("type=\"").append(str2).toString()).append("\" name=\"").toString()).append(str4).toString()).append('\"').toString(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("type=\"").append(str2).toString()).append("\" name=\"").toString()).append(str3).toString()).append('\"').toString()).replace(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str2).append(" name=\"").toString()).append(str4).toString()).append('\"').toString(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(str2).append(" name=\"").toString()).append(str3).toString()).append('\"').toString()).replace(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\"@").append(str2).toString()).append("/").toString()).append(str4).toString()).append("\"").toString(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\"@").append(str2).toString()).append("/").toString()).append(str3).toString()).append('\"').toString()).replace(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(">@").append(str2).toString()).append('/').toString()).append(str4).toString()).append('<').toString(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(">@").append(str2).toString()).append('/').toString()).append(str3).toString()).append('<').toString()).replace(new StringBuffer().append("@unktype/").append(str4).toString(), new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("@").append(str2).toString()).append('/').toString()).append(str3).toString());
        if (str4.startsWith("APKTOOL_DUMMY_0x")) {
            replace = replace.replaceAll(new StringBuffer().append(new StringBuffer().append("@[^\\s/]+/").append(str4).toString()).append("\"").toString(), new StringBuffer().append(str3).append('\"').toString());
        }
        if (str2.equals(C0497h.f3457a)) {
            replace = replace.replace(new StringBuffer().append(new StringBuffer().append("\"?").append(str4).toString()).append('\"').toString(), new StringBuffer().append(new StringBuffer().append("\"?").append(str3).toString()).append('\"').toString()).replace(new StringBuffer().append(new StringBuffer().append(">?").append(str4).toString()).append('<').toString(), new StringBuffer().append(new StringBuffer().append(">?").append(str3).toString()).append('<').toString());
        }
        if (str2.equals("id")) {
            return replace.replace(new StringBuffer().append(new StringBuffer().append('>').append(str4).toString()).append('<').toString(), new StringBuffer().append(new StringBuffer().append('>').append(str3).toString()).append('<').toString());
        }
        return replace;
    }

    /* renamed from: b */
    public static String m18316b(String str, String str2, String str3) {
        return m18301a(str, str2, str3, 0);
    }

    /* renamed from: a */
    public static String m18301a(String str, String str2, String str3, int i) {
        if (str == null) {
            return "";
        }
        if (str2 != null && str3 != null) {
            Matcher matcher = Pattern.compile(str2, i).matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, str3);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return str;
    }

    /* renamed from: c */
    public static String m18322c(String str) {
        if (str == null) {
            return "";
        }
        Matcher matcher = Pattern.compile("\\s+<item[^>]+name=\"APKTOOL_DUMMY_[^\"]+\">false</item>").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m18303a(String str, List<C3090av> list) {
        if (str == null) {
            return "";
        }
        Matcher matcher = Pattern.compile("@unktype/APKTOOL_DUMMY_([A-Fa-f0-9]+)").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            try {
                long parseLong = Long.parseLong(matcher.group(1), 16);
                Iterator<C3090av> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        C3090av next = it.next();
                        if (next.m18734h() == parseLong) {
                            matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("@").append(next.m18724a()).toString()).append('/').toString()).append(next.m18727b()).toString()));
                            break;
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: d */
    public static String m18325d(String str) {
        if (str == null) {
            return "";
        }
        Matcher matcher = Pattern.compile("@[^\\s/]+/APKTOOL_DUMMY_[\\w\\d]+").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "@null");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString().replace(" parent=\"@null\"", "");
    }

    /* renamed from: a */
    public static String m18304a(String str, Map<String, C3063c> map) {
        String m18347a;
        if (str == null) {
            return "";
        }
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (C3063c c3063c : map.values()) {
                if (i > 0) {
                    sb.append("|");
                }
                sb.append(c3063c.m18346a());
                i++;
            }
            Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("([^\\s]+:)?(").append(sb.toString()).toString()).append(")=\"([^\"]+)\"").toString()).matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                C3063c c3063c2 = map.get(matcher.group(2));
                if (c3063c2 != null && (m18347a = c3063c2.m18347a(matcher.group(3))) != null) {
                    matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(C3112bn.m19017b((CharSequence) matcher.group(1))).append(matcher.group(2)).toString()).append("=\"").toString()).append(m18347a).toString()).append("\"").toString());
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return str;
    }

    /* renamed from: b */
    public static String m18317b(String str, Map<String, C3063c> map) {
        String m18347a;
        if (str == null) {
            return "";
        }
        if (map != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (C3063c c3063c : map.values()) {
                if (i > 0) {
                    sb.append("|");
                }
                sb.append(c3063c.m18346a());
                i++;
            }
            Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<item name=\"([^\"]+:)?(").append(sb.toString()).toString()).append(")\">([^<]+)</item>").toString()).matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                C3063c c3063c2 = map.get(matcher.group(2));
                if (c3063c2 != null && (m18347a = c3063c2.m18347a(matcher.group(3))) != null) {
                    matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<item name=\"").append(C3112bn.m19017b((CharSequence) matcher.group(1))).toString()).append(matcher.group(2)).toString()).append("\">").toString()).append(m18347a).toString()).append("</item>").toString());
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        }
        return str;
    }

    /* renamed from: a */
    public static void m18308a(File file, File file2, boolean z) {
        if (z || (file.getParentFile().getName().startsWith("values") && file.getName().endsWith(".xml") && !file.getName().equals("public.xml"))) {
            if (!z && file.getName().equals("strings.xml")) {
                try {
                    C3239s.m19421a(file.getParentFile().getParentFile().getParentFile().getAbsolutePath(), file.getParentFile().getName(), C3239s.m19427b(file2.getAbsolutePath()), true, true);
                    return;
                } catch (Exception e2) {
                }
            }
            List<String> m18331h = m18331h(file);
            List<String> m18331h2 = m18331h(file2);
            ArrayList<String> arrayList = new ArrayList();
            arrayList.addAll(m18331h);
            StringBuilder sb = new StringBuilder();
            for (String str : arrayList) {
                if (str.trim().equals("</resources>")) {
                    boolean z2 = false;
                    boolean z3 = false;
                    for (String str2 : m18331h2) {
                        String trim = str2.trim();
                        if (trim.equals("<resources>")) {
                            z2 = true;
                        } else if (!trim.equals("</resources>")) {
                            if (z2) {
                                if (z) {
                                    sb.append(str2).append("\n");
                                } else if (z3) {
                                    sb.append(str2).append("\n");
                                    if (trim.matches("^<[^>]+(?<!(/))>$") && trim.startsWith("</")) {
                                        z3 = false;
                                    }
                                    z3 = z3;
                                } else {
                                    z3 = trim.matches("^<[^>]+(?<!(/))>$");
                                    if (z3 || !m18321b(m18331h, trim, "^<[^>]+(?<!(/))>$")) {
                                        sb.append(str2).append("\n");
                                    }
                                }
                            }
                        }
                    }
                }
                sb.append(str).append("\n");
            }
            m18319b(file, sb.toString());
        }
    }

    /* renamed from: b */
    private static boolean m18321b(List<String> list, String str, String str2) {
        if (str.matches("^<[^>]+>[^<]+</[^>]+>$") || str.matches("^<[^>]+/>$")) {
            Iterator<String> it = list.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                String trim = it.next().trim();
                if (!trim.equals("<resources>")) {
                    if (trim.equals("</resources>")) {
                        break;
                    }
                    if (!z2) {
                        continue;
                    } else if (z) {
                        z = (trim.matches(str2) && trim.startsWith("</")) ? false : z;
                    } else {
                        boolean matches = trim.matches(str2);
                        if (matches) {
                            z = matches;
                        } else {
                            if (trim.equals(str) || m18327d(trim, str)) {
                                return true;
                            }
                            z = matches;
                        }
                    }
                } else {
                    z2 = true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    private static boolean m18327d(String str, String str2) {
        Matcher matcher = Pattern.compile("\\sname=\"([^\"]+)\"").matcher(str);
        if (!matcher.find()) {
            return false;
        }
        String stringBuffer = new StringBuffer().append(new StringBuffer().append("^<[^>]+\\sname=\"").append(C3112bn.m19024c((CharSequence) matcher.group(1))).toString()).append("\"[^>]*?>[^<]+</[^>]+>$").toString();
        return str.matches(stringBuffer) && str2.matches(stringBuffer);
    }

    /* renamed from: a */
    public static List<String> m18305a(InputStream inputStream) {
        return m18306a(inputStream, "UTF-8");
    }

    /* renamed from: h */
    public static List<String> m18331h(File file) {
        try {
            return m18306a(new FileInputStream(file), "UTF-8");
        } catch (FileNotFoundException e2) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[Catch: Exception -> 0x0039, TRY_LEAVE, TryCatch #1 {Exception -> 0x0039, blocks: (B:17:0x001a, B:11:0x001f), top: B:16:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> m18306a(InputStream inputStream, String str) {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader3 = (BufferedReader) null;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, str));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Exception e2) {
                    bufferedReader3 = bufferedReader2;
                    bufferedReader2 = bufferedReader3;
                    if (inputStream != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                            throw th;
                        }
                    }
                    if (bufferedReader == null) {
                        throw th;
                    }
                    bufferedReader.close();
                    throw th;
                }
            }
        } catch (Exception e4) {
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader3;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e5) {
            }
        }
        if (bufferedReader2 != null) {
            bufferedReader2.close();
        }
        return arrayList;
    }

    /* renamed from: i */
    public static String m18332i(File file) {
        return m18295a(file, "UTF-8");
    }

    /* renamed from: b */
    public static String m18312b(InputStream inputStream) {
        return m18313b(inputStream, "UTF-8");
    }

    /* renamed from: a */
    public static String m18295a(File file, String str) {
        try {
            return m18313b(new FileInputStream(file), str);
        } catch (FileNotFoundException e2) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x002d A[Catch: Exception -> 0x0033, TRY_LEAVE, TryCatch #7 {Exception -> 0x0033, blocks: (B:27:0x0028, B:22:0x002d), top: B:26:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m18313b(InputStream inputStream, String str) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = (BufferedInputStream) null;
        try {
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(inputStream);
            try {
                try {
                    String m13967a = C1887e.m13967a(bufferedInputStream3, str);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            return m13967a;
                        }
                    }
                    if (bufferedInputStream3 == null) {
                        return m13967a;
                    }
                    bufferedInputStream3.close();
                    return m13967a;
                } catch (Exception e3) {
                    bufferedInputStream2 = bufferedInputStream3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            return "";
                        }
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    return "";
                }
            } catch (Error e5) {
                bufferedInputStream2 = bufferedInputStream3;
                if (inputStream != null) {
                }
                if (bufferedInputStream2 != null) {
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = bufferedInputStream3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        throw th;
                    }
                }
                if (bufferedInputStream == null) {
                    throw th;
                }
                bufferedInputStream.close();
                throw th;
            }
        } catch (Error e7) {
        } catch (Exception e8) {
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    /* renamed from: a */
    public static String m18294a(File file, int i) {
        return m18296a(file, "UTF-8", i);
    }

    /* renamed from: a */
    public static String m18296a(File file, String str, int i) {
        try {
            return m18297a(new FileInputStream(file), str, i);
        } catch (Exception e2) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0041 A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #7 {Exception -> 0x0055, blocks: (B:37:0x003c, B:32:0x0041), top: B:36:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m18297a(InputStream inputStream, String str, int i) {
        Throwable th;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3 = (BufferedReader) null;
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, str));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < i; i2++) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (i2 > 0) {
                            sb.append("\n");
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            return sb2;
                        }
                    }
                    if (bufferedReader2 == null) {
                        return sb2;
                    }
                    bufferedReader2.close();
                    return sb2;
                } catch (Exception e3) {
                    bufferedReader3 = bufferedReader2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            return "";
                        }
                    }
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    return "";
                }
            } catch (Error e5) {
                bufferedReader3 = bufferedReader2;
                if (inputStream != null) {
                }
                if (bufferedReader3 != null) {
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        throw th;
                    }
                }
                if (bufferedReader == null) {
                    throw th;
                }
                bufferedReader.close();
                throw th;
            }
        } catch (Error e7) {
        } catch (Exception e8) {
            bufferedReader2 = bufferedReader3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = bufferedReader3;
        }
    }

    /* renamed from: b */
    public static void m18319b(File file, String str) {
        m18320b(file, str, "UTF-8");
    }

    /* renamed from: b */
    public static void m18320b(File file, String str, String str2) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), str2);
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Exception e2) {
        }
    }
}
