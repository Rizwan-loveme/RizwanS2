package ru.maximoff.apktool.util.p304b;

import android.graphics.Color;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FilenameFilter;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: ColorsUtils.java */
/* renamed from: ru.maximoff.apktool.util.b.b */
/* loaded from: classes.dex */
public class C3097b {
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<C3096a> m18816a(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream3 = (FileInputStream) null;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream2);
                NodeList elementsByTagName = parse.getElementsByTagName("color");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Element element = (Element) elementsByTagName.item(i);
                    arrayList.add(new C3096a(element.getAttribute("name"), element.getTextContent()));
                }
                NodeList elementsByTagName2 = parse.getElementsByTagName("item");
                for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
                    Element element2 = (Element) elementsByTagName2.item(i2);
                    C3096a c3096a = new C3096a(element2.getAttribute("name"), element2.getTextContent());
                    c3096a.m18808a(true);
                    arrayList.add(c3096a);
                }
            } catch (Exception e2) {
                fileInputStream3 = fileInputStream2;
                fileInputStream2 = fileInputStream3;
                if (fileInputStream2 != null) {
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    throw th;
                }
                try {
                    fileInputStream.close();
                    throw th;
                } catch (IOException e3) {
                    throw th;
                }
            }
        } catch (Exception e4) {
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream3;
        }
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (IOException e5) {
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static String[] m18819b(String str) {
        File file = new File(new StringBuffer().append(str).append("/res").toString());
        if (!file.exists() || !file.isDirectory()) {
            return (String[]) null;
        }
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.b.b.1
            @Override // java.p209io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2.startsWith("values");
            }
        });
        if (listFiles == null) {
            return (String[]) null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            File file3 = new File(file2, "colors.xml");
            if (file3.exists() && file3.isFile()) {
                arrayList.add(file2.getName());
            }
        }
        if (arrayList.isEmpty()) {
            return (String[]) null;
        }
        Collections.sort(arrayList);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public static void m18817a(String str, String str2, List<C3096a> list) {
        File file = new File(new StringBuffer().append(new StringBuffer().append(str).append("/res/").toString()).append(str2).toString());
        if ((!file.exists() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException(new StringBuffer().append(new StringBuffer().append("Failed to create \"").append(str2).toString()).append("\" dir!").toString());
        }
        File file2 = new File(file, "colors.xml");
        Collections.sort(list, new Comparator<C3096a>() { // from class: ru.maximoff.apktool.util.b.b.2
            @Override // java.util.Comparator
            public int compare(C3096a c3096a, C3096a c3096a2) {
                return m18820a(c3096a, c3096a2);
            }

            /* renamed from: a */
            public int m18820a(C3096a c3096a, C3096a c3096a2) {
                return c3096a.m18806a().compareTo(c3096a2.m18806a());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");
        for (C3096a c3096a : list) {
            sb.append("\t");
            sb.append(c3096a.toString());
            sb.append("\n");
        }
        sb.append("</resources>");
        C3061a.m18319b(file2, sb.toString());
    }

    /* renamed from: a */
    public static boolean m18818a(int i) {
        return ((double) 1) - ((((0.299d * ((double) Color.red(i))) + (0.587d * ((double) Color.green(i)))) + (0.114d * ((double) Color.blue(i)))) / ((double) 255)) >= 0.5d;
    }
}
