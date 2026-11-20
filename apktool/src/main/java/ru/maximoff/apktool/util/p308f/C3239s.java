package ru.maximoff.apktool.util.p308f;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.DialogInterfaceC0070b;
import com.srizwan.apktool.R;
import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.FilenameFilter;
import java.p209io.IOException;
import java.p209io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.p217b.p218a.p222b.C1895d;
import org.p270e.C2466a;
import org.p270e.C2467b;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.C3102bd;
import ru.maximoff.apktool.util.C3112bn;
import ru.maximoff.apktool.util.C3249i;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: TranslateUtils.java */
/* renamed from: ru.maximoff.apktool.util.f.s */
/* loaded from: classes.dex */
public class C3239s {
    /* renamed from: a */
    public static List<C3236p> m19415a(String str) {
        if (str.endsWith("arrays.xml")) {
            return m19430c(str);
        }
        if (str.endsWith("plurals.xml")) {
            return m19432d(str);
        }
        return m19427b(str);
    }

    /* renamed from: a */
    public static int m19411a(List<C3236p> list) {
        String m19381e;
        int indexOf;
        int i = 0;
        for (C3236p c3236p : list) {
            if (c3236p.m19390k() && (indexOf = (m19381e = c3236p.m19381e()).indexOf(34)) > 0) {
                String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m19381e.substring(0, indexOf)).append("\"").toString()).append(m19435g(c3236p.m19387h())).toString()).append("\"").toString();
                List<String> m18331h = C3061a.m18331h(c3236p.m19393n());
                m18331h.set(c3236p.m19394o(), stringBuffer);
                C3061a.m18319b(c3236p.m19393n(), C3080al.m18538a(m18331h, "\n"));
                i++;
            }
        }
        return i;
    }

    /* renamed from: b */
    public static int m19425b(List<C3236p> list) {
        int i = 0;
        for (C3236p c3236p : list) {
            if (c3236p.m19390k()) {
                String m19384f = c3236p.m19384f();
                int indexOf = m19384f.indexOf(34);
                int lastIndexOf = m19384f.lastIndexOf(34);
                if (indexOf > 0 && lastIndexOf > indexOf) {
                    String stringBuffer = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m19384f.substring(0, indexOf)).append("\"").toString()).append(m19436h(c3236p.m19387h())).toString()).append(m19384f.substring(lastIndexOf)).toString();
                    List<String> m18331h = C3061a.m18331h(c3236p.m19393n());
                    m18331h.set(c3236p.m19394o(), stringBuffer);
                    C3061a.m18319b(c3236p.m19393n(), C3080al.m18538a(m18331h, "\n"));
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<C3236p> m19427b(String str) {
        FileInputStream fileInputStream;
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream);
                NodeList elementsByTagName = parse.getElementsByTagName("string");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Element element = (Element) elementsByTagName.item(i);
                    String m19414a = m19414a((Node) element, false);
                    boolean m19439k = m19439k(m19414a);
                    String m14012a = C1895d.m14012a(m19414a);
                    if (m14012a.length() > 2 && m14012a.startsWith("\"") && m14012a.endsWith("\"") && !m14012a.matches("^[\\s\\S]+\"(\\s+|(\\s+)?<.+>(\\s+)?)\"[\\s\\S]+$")) {
                        m14012a = m14012a.substring(1, m14012a.length() - 1);
                    }
                    C3236p c3236p = new C3236p(element.getAttribute("name"), m14012a);
                    if (element.hasAttribute("formatted")) {
                        c3236p.m19376c(Boolean.valueOf(element.getAttribute("formatted")).booleanValue());
                    }
                    if (element.hasAttribute("translatable")) {
                        c3236p.m19373b(Boolean.valueOf(element.getAttribute("translatable")).booleanValue());
                    }
                    c3236p.m19383e(m19439k);
                    arrayList.add(c3236p);
                }
                NodeList elementsByTagName2 = parse.getElementsByTagName("item");
                for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
                    Element element2 = (Element) elementsByTagName2.item(i2);
                    String m19414a2 = m19414a((Node) element2, false);
                    boolean m19439k2 = m19439k(m19414a2);
                    String m14012a2 = C1895d.m14012a(m19414a2);
                    if (m14012a2.length() > 2 && m14012a2.startsWith("\"") && m14012a2.endsWith("\"") && !m14012a2.matches("^[\\s\\S]+\"(\\s+|(\\s+)?<.+>(\\s+)?)\"[\\s\\S]+$")) {
                        m14012a2 = m14012a2.substring(1, m14012a2.length() - 1);
                    }
                    C3236p c3236p2 = new C3236p(element2.getAttribute("name"), m14012a2);
                    c3236p2.m19385f(true);
                    if (element2.hasAttribute("formatted")) {
                        c3236p2.m19376c(Boolean.valueOf(element2.getAttribute("formatted")).booleanValue());
                    }
                    if (element2.hasAttribute("translatable")) {
                        c3236p2.m19373b(Boolean.valueOf(element2.getAttribute("translatable")).booleanValue());
                    }
                    c3236p2.m19383e(m19439k2);
                    arrayList.add(c3236p2);
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<C3236p> m19430c(String str) {
        FileInputStream fileInputStream;
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (Exception e2) {
        } catch (Throwable th) {
            th = th;
            fileInputStream = fileInputStream2;
        }
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getElementsByTagName("string-array");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Element element = (Element) elementsByTagName.item(i);
                String attribute = element.getAttribute("name");
                boolean booleanValue = element.hasAttribute("formatted") ? Boolean.valueOf(element.getAttribute("formatted")).booleanValue() : true;
                NodeList elementsByTagName2 = element.getElementsByTagName("item");
                for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
                    String m19414a = m19414a(elementsByTagName2.item(i2), true);
                    arrayList.add(new C3236p(attribute, (m19414a.length() <= 2 || !m19414a.startsWith("\"") || !m19414a.endsWith("\"") || m19414a.matches("^[\\s\\S]+\"(\\s+|(\\s+)?<.+>(\\s+)?)\"[\\s\\S]+$")) ? m19414a : m19414a.substring(1, m19414a.length() - 1), (String) null, booleanValue));
                }
            }
        } catch (Exception e3) {
            fileInputStream2 = fileInputStream;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
            }
            return arrayList;
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
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<C3236p> m19432d(String str) {
        FileInputStream fileInputStream;
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = (FileInputStream) null;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream).getElementsByTagName("plurals");
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Element element = (Element) elementsByTagName.item(i);
                    String attribute = element.getAttribute("name");
                    boolean booleanValue = element.hasAttribute("formatted") ? Boolean.valueOf(element.getAttribute("formatted")).booleanValue() : true;
                    NodeList elementsByTagName2 = element.getElementsByTagName("item");
                    for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
                        Element element2 = (Element) elementsByTagName2.item(i2);
                        String m19414a = m19414a((Node) element2, true);
                        if (m19414a.length() > 2 && m19414a.startsWith("\"") && m19414a.endsWith("\"") && !m19414a.matches("^[\\s\\S]+\"(\\s+|(\\s+)?<.+>(\\s+)?)\"[\\s\\S]+$")) {
                            m19414a = m19414a.substring(1, m19414a.length() - 1);
                        }
                        arrayList.add(new C3236p(attribute, m19414a, (String) null, element2.getAttribute("quantity"), booleanValue));
                    }
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

    /* renamed from: e */
    public static String[] m19433e(String str) {
        File file = new File(new StringBuffer().append(str).append("/res").toString());
        if (!file.exists() || !file.isDirectory()) {
            return (String[]) null;
        }
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: ru.maximoff.apktool.util.f.s.1
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
            File file3 = new File(file2, "strings.xml");
            File file4 = new File(file2, "arrays.xml");
            File file5 = new File(file2, "plurals.xml");
            if ((file3.exists() && file3.isFile()) || ((file4.exists() && file4.isFile()) || (file5.exists() && file5.isFile()))) {
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
    public static String[] m19424a(File file) {
        ArrayList arrayList = new ArrayList();
        if (new File(file, "strings.xml").exists()) {
            arrayList.add("strings");
        }
        if (new File(file, "arrays.xml").exists()) {
            arrayList.add("arrays");
        }
        if (new File(file, "plurals.xml").exists()) {
            arrayList.add("plurals");
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public static void m19421a(String str, String str2, List<C3236p> list, boolean z, boolean z2) {
        File file = new File(new StringBuffer().append(new StringBuffer().append(str).append("/res/").toString()).append(str2).toString());
        if ((!file.exists() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException(new StringBuffer().append(new StringBuffer().append("Failed to create \"").append(str2).toString()).append("\" dir!").toString());
        }
        File file2 = new File(file, "strings.xml");
        if (z2 && file2.exists()) {
            for (C3236p c3236p : m19427b(file2.getAbsolutePath())) {
                int m19412a = m19412a(list, c3236p);
                if (m19412a == -1) {
                    list.add(new C3236p(c3236p.m19381e(), c3236p.m19386g(), c3236p.m19386g(), c3236p.m19374b(), c3236p.m19377c(), c3236p.m19391l()));
                } else if (!list.get(m19412a).m19390k()) {
                    list.set(m19412a, new C3236p(c3236p.m19381e(), c3236p.m19386g(), c3236p.m19386g(), c3236p.m19374b(), c3236p.m19377c(), c3236p.m19391l()));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");
        for (C3236p c3236p2 : list) {
            if (c3236p2.m19387h() != null) {
                String m19387h = c3236p2.m19387h();
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\t<").append(c3236p2.m19392m() ? "item type=\"string\"" : "string").toString()).append(" name=\"").toString()).append(c3236p2.m19381e()).toString()).append("\"").toString()).append(!c3236p2.m19374b() ? " formatted=\"false\"" : "").toString()).append(!c3236p2.m19377c() ? " translatable=\"false\"" : "").toString()).append(">").toString());
                if (c3236p2.m19391l() || (m19387h.length() > 2 && m19387h.startsWith("\"") && m19387h.endsWith("\""))) {
                    sb.append(m19437i(m19387h));
                } else {
                    sb.append(m19434f(m19387h));
                }
                sb.append(new StringBuffer().append(new StringBuffer().append("</").append(c3236p2.m19392m() ? "item" : "string").toString()).append(">\n").toString());
            } else if (!c3236p2.m19390k() && z) {
                String m19386g = c3236p2.m19386g();
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\t<").append(c3236p2.m19392m() ? "item type=\"string\"" : "string").toString()).append(" name=\"").toString()).append(c3236p2.m19381e()).toString()).append("\"").toString()).append(!c3236p2.m19374b() ? " formatted=\"false\"" : "").toString()).append(!c3236p2.m19377c() ? " translatable=\"false\"" : "").toString()).append(">").toString());
                if (c3236p2.m19391l() || (m19386g.length() > 2 && m19386g.startsWith("\"") && m19386g.endsWith("\""))) {
                    sb.append(m19437i(m19386g));
                } else {
                    sb.append(m19434f(m19386g));
                }
                sb.append(new StringBuffer().append(new StringBuffer().append("</").append(c3236p2.m19392m() ? "item" : "string").toString()).append(">\n").toString());
            }
        }
        sb.append("</resources>");
        C3061a.m18319b(file2, sb.toString());
    }

    /* renamed from: a */
    public static void m19420a(String str, String str2, List<C3236p> list, boolean z) {
        File file = new File(new StringBuffer().append(new StringBuffer().append(str).append("/res/").toString()).append(str2).toString());
        if ((!file.exists() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException(new StringBuffer().append(new StringBuffer().append("Failed to create \"").append(str2).toString()).append("\" dir!").toString());
        }
        File file2 = new File(file, "arrays.xml");
        List<String> m19431c = m19431c(list);
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");
        sb.append(m19426b(file2));
        for (String str3 : m19431c) {
            String m19413a = m19413a(str3, list, z);
            boolean m19422a = m19422a(str3, list);
            if (!m19413a.isEmpty()) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\t<string-array name=\"").append(str3).toString()).append("\"").toString()).append(!m19422a ? " formatted=\"false\"" : "").toString()).append(">\n").toString());
                sb.append(m19413a);
                sb.append("\t</string-array>\n");
            }
        }
        sb.append("</resources>");
        C3061a.m18319b(file2, sb.toString());
    }

    /* renamed from: b */
    public static void m19429b(String str, String str2, List<C3236p> list, boolean z) {
        File file = new File(new StringBuffer().append(new StringBuffer().append(str).append("/res/").toString()).append(str2).toString());
        if ((!file.exists() && !file.mkdirs()) || !file.isDirectory()) {
            throw new IOException(new StringBuffer().append(new StringBuffer().append("Failed to create \"").append(str2).toString()).append("\" dir!").toString());
        }
        File file2 = new File(file, "plurals.xml");
        List<String> m19431c = m19431c(list);
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n");
        for (String str3 : m19431c) {
            String m19413a = m19413a(str3, list, z);
            boolean m19422a = m19422a(str3, list);
            if (!m19413a.isEmpty()) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\t<plurals name=\"").append(str3).toString()).append("\"").toString()).append(!m19422a ? " formatted=\"false\"" : "").toString()).append(">\n").toString());
                sb.append(m19413a);
                sb.append("\t</plurals>\n");
            }
        }
        sb.append("</resources>");
        C3061a.m18319b(file2, sb.toString());
    }

    /* renamed from: a */
    public static int m19412a(List<C3236p> list, C3236p c3236p) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (list.get(i2).m19381e().equals(c3236p.m19381e())) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    /* renamed from: f */
    public static String m19434f(String str) {
        return str.replaceAll("(?<!\\\\)\"", "\\\\\"").replaceAll("(?<!\\\\)'", "\\\\'").replaceAll("&(?!(amp;|lt;|#160;))", "&amp;").replaceAll("\n", "\\\\n").replace("<", "&lt;").replace("]]>", "]]&gt;");
    }

    /* renamed from: g */
    public static String m19435g(String str) {
        return str.replaceAll("(?<!\\\\)\\\\(?!(\\\\|n|t|r|u))", "\\\\\\\\").replaceAll("(?<!\\\\)\"", "\\\\\"").replaceAll("(?<!\\\\)'", "\\\\'").replaceAll("\n", "\\\\n");
    }

    /* renamed from: h */
    public static String m19436h(String str) {
        return str.replaceAll("\"", "&quot;").replaceAll("(?<!\\\\)'", "\\\\'").replaceAll("&(?!(amp;|lt;|#160;|quot;))", "&amp;").replaceAll("\n", "\\\\n").replace("<", "&lt;").replace("]]>", "]]&gt;");
    }

    /* renamed from: i */
    public static String m19437i(String str) {
        return str.replaceAll("(?<!\\\\)'", "\\\\'").replaceAll("&(?!(amp;|lt;|#160;))", "&amp;").replaceAll(new StringBuffer().append(new StringBuffer().append("<(?!(/)?(").append(C3080al.m18540a(C3249i.f19543c, "|")).toString()).append(")[\\s>/])").toString(), "&lt;").replace("]]>", "]]&gt;");
    }

    /* renamed from: j */
    public static String m19438j(String str) {
        if (str.equals("zh-Hans")) {
            return "zh-CN";
        }
        if (str.equals("zh-Hant")) {
            return "zh-TW";
        }
        if (str.equals("iw")) {
            return "he";
        }
        return str;
    }

    /* renamed from: c */
    public static List<String> m19431c(List<C3236p> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C3236p c3236p = list.get(i2);
                if (!arrayList.contains(c3236p.m19381e())) {
                    arrayList.add(c3236p.m19381e());
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    /* renamed from: a */
    public static List<C3236p> m19417a(List<C3236p> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C3236p c3236p = list.get(i2);
                if (!list2.contains(c3236p.m19381e())) {
                    arrayList.add(c3236p);
                }
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    /* renamed from: a */
    public static boolean m19422a(String str, List<C3236p> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C3236p c3236p = list.get(i2);
                if (!str.equals(c3236p.m19381e())) {
                    i = i2 + 1;
                } else {
                    return c3236p.m19380d();
                }
            } else {
                return true;
            }
        }
    }

    /* renamed from: a */
    public static String m19413a(String str, List<C3236p> list, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C3236p c3236p = list.get(i2);
                if (str.equals(c3236p.m19381e())) {
                    if (c3236p.m19390k()) {
                        sb.append("\t\t<item");
                        if (c3236p.m19388i() != null) {
                            sb.append(new StringBuffer().append(new StringBuffer().append(" quantity=\"").append(c3236p.m19388i()).toString()).append("\"").toString());
                        }
                        String m19387h = c3236p.m19387h() != null ? c3236p.m19387h() : c3236p.m19386g();
                        if (m19387h.length() > 2 && m19387h.startsWith("\"") && m19387h.endsWith("\"")) {
                            sb.append(new StringBuffer().append(new StringBuffer().append(">").append(m19437i(m19387h)).toString()).append("</item>\n").toString());
                        } else {
                            sb.append(new StringBuffer().append(new StringBuffer().append(">").append(m19434f(m19387h)).toString()).append("</item>\n").toString());
                        }
                    } else if (!c3236p.m19390k() && z) {
                        sb.append("\t\t<item");
                        if (c3236p.m19389j() != null) {
                            sb.append(new StringBuffer().append(new StringBuffer().append(" quantity=\"").append(c3236p.m19389j()).toString()).append("\"").toString());
                        }
                        String m19386g = c3236p.m19386g();
                        if (m19386g.length() > 2 && m19386g.startsWith("\"") && m19386g.endsWith("\"")) {
                            sb.append(new StringBuffer().append(new StringBuffer().append(">").append(m19437i(m19386g)).toString()).append("</item>\n").toString());
                        } else {
                            sb.append(new StringBuffer().append(new StringBuffer().append(">").append(m19434f(m19386g)).toString()).append("</item>\n").toString());
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String m19426b(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream3 = (FileInputStream) null;
        try {
            fileInputStream2 = new FileInputStream(file);
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = fileInputStream3;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileInputStream2);
            NodeList elementsByTagName = parse.getElementsByTagName("array");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                Element element = (Element) elementsByTagName.item(i);
                sb.append(new StringBuffer().append(new StringBuffer().append("\t<array name=\"").append(element.getAttribute("name")).toString()).append("\">\n").toString());
                NodeList elementsByTagName2 = element.getElementsByTagName("item");
                for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
                    sb.append(new StringBuffer().append(new StringBuffer().append("\t\t<item>").append(m19434f(((Element) elementsByTagName2.item(i2)).getTextContent())).toString()).append("</item>\n").toString());
                }
                sb.append("\t</array>\n");
            }
            NodeList elementsByTagName3 = parse.getElementsByTagName("integer-array");
            for (int i3 = 0; i3 < elementsByTagName3.getLength(); i3++) {
                Element element2 = (Element) elementsByTagName3.item(i3);
                sb.append(new StringBuffer().append(new StringBuffer().append("\t<integer-array name=\"").append(element2.getAttribute("name")).toString()).append("\">\n").toString());
                NodeList elementsByTagName4 = element2.getElementsByTagName("item");
                for (int i4 = 0; i4 < elementsByTagName4.getLength(); i4++) {
                    sb.append(new StringBuffer().append(new StringBuffer().append("\t\t<item>").append(m19434f(((Element) elementsByTagName4.item(i4)).getTextContent())).toString()).append("</item>\n").toString());
                }
                sb.append("\t</integer-array>\n");
            }
        } catch (Exception e3) {
            fileInputStream3 = fileInputStream2;
            fileInputStream2 = fileInputStream3;
            if (fileInputStream2 != null) {
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream == null) {
                throw th;
            }
            try {
                fileInputStream.close();
                throw th;
            } catch (IOException e4) {
                throw th;
            }
        }
        if (fileInputStream2 != null) {
            try {
                fileInputStream2.close();
            } catch (IOException e5) {
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m19414a(Node node, boolean z) {
        String textContent;
        try {
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("method", "html");
            newTransformer.setOutputProperty(OutputKeys.INDENT, "no");
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                newTransformer.transform(new DOMSource(node.getChildNodes().item(i)), streamResult);
            }
            textContent = stringWriter.toString();
        } catch (Exception e2) {
            textContent = node.getTextContent();
        }
        String replace = textContent.replace("<br>", "<br/>");
        if (z) {
            return C1895d.m14012a(replace);
        }
        return replace;
    }

    /* renamed from: a */
    public static String[] m19423a(Context context, int i, boolean z) {
        String str;
        int i2;
        int i3;
        C2466a c2466a;
        switch (i) {
            case 1:
                str = "blangs_hide";
                i2 = R.array.bing_translator_codes;
                i3 = R.array.bing_translator_names;
                break;
            case 2:
                str = "glangs_hide";
                i2 = R.array.google_translator_codes;
                i3 = R.array.google_translator_names;
                break;
            case 3:
                str = "gwlangs_hide";
                i2 = R.array.google_translator_codes;
                i3 = R.array.google_translator_names;
                break;
            case 4:
                str = "dlangs_hide";
                i2 = R.array.deepl_translator_codes;
                i3 = R.array.deepl_translator_names;
                break;
            default:
                str = "ylangs_hide";
                i2 = R.array.yandex_translator_codes;
                i3 = R.array.yandex_translator_names;
                break;
        }
        try {
            c2466a = new C2466a(C3102bd.m18910a(context, str, "[]"));
        } catch (C2467b e2) {
            c2466a = new C2466a();
        }
        String[] stringArray = context.getResources().getStringArray(i2);
        String[] stringArray2 = context.getResources().getStringArray(i3);
        if (c2466a.m15569a() == 0) {
            return z ? stringArray2 : stringArray;
        }
        if (stringArray.length != stringArray2.length) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < stringArray.length; i4++) {
            try {
                if (C3080al.m18524a(c2466a, stringArray[i4]) == -1) {
                    if (z) {
                        arrayList.add(stringArray2[i4]);
                    } else {
                        arrayList.add(stringArray[i4]);
                    }
                }
            } catch (C2467b e3) {
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* renamed from: a */
    public static void m19419a(Context context, int i) {
        String str;
        C2466a c2466a;
        int i2 = R.array.google_translator_names;
        int i3 = R.array.google_translator_codes;
        switch (i) {
            case 1:
                i2 = R.array.bing_translator_names;
                i3 = R.array.bing_translator_codes;
                str = "blangs_hide";
                break;
            case 2:
                str = "glangs_hide";
                break;
            case 3:
                str = "gwlangs_hide";
                break;
            case 4:
                i2 = R.array.deepl_translator_names;
                i3 = R.array.deepl_translator_codes;
                str = "dlangs_hide";
                break;
            default:
                i2 = R.array.yandex_translator_names;
                i3 = R.array.yandex_translator_codes;
                str = "ylangs_hide";
                break;
        }
        String[] stringArray = context.getResources().getStringArray(i3);
        String[] stringArray2 = context.getResources().getStringArray(i2);
        if (stringArray.length != stringArray2.length) {
            C3112bn.m18999a(context, R.string.error);
            return;
        }
        try {
            c2466a = new C2466a(C3102bd.m18910a(context, str, "[]"));
        } catch (C2467b e2) {
            c2466a = new C2466a();
        }
        String[] strArr = (String[]) Arrays.copyOfRange(stringArray, 1, stringArray.length);
        String[] strArr2 = (String[]) Arrays.copyOfRange(stringArray2, 1, stringArray2.length);
        boolean[] zArr = new boolean[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            try {
                zArr[i4] = C3080al.m18524a(c2466a, strArr[i4]) == -1;
            } catch (C2467b e3) {
                zArr[i4] = true;
            }
        }
        String[] strArr3 = {context.getString(R.string.mtr_yandex), context.getString(R.string.mtr_bing), context.getString(R.string.mtr_google), context.getString(R.string.mtr_google_web), context.getString(R.string.mtr_deepl)};
        DialogInterfaceC0070b.a aVar = new DialogInterfaceC0070b.a(context);
        aVar.m432a(strArr2, (boolean[]) null, (DialogInterface.OnMultiChoiceClickListener) null);
        aVar.m427a(strArr3[i]);
        aVar.m434b(R.string.cancel, (DialogInterface.OnClickListener) null);
        aVar.m420a(R.string.save, new DialogInterface.OnClickListener(strArr, context, str) { // from class: ru.maximoff.apktool.util.f.s.2

            /* renamed from: a */
            private final String[] f19442a;

            /* renamed from: b */
            private final Context f19443b;

            /* renamed from: c */
            private final String f19444c;

            {
                this.f19442a = strArr;
                this.f19443b = context;
                this.f19444c = str;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                ArrayList arrayList = new ArrayList();
                ListView m415a = ((DialogInterfaceC0070b) dialogInterface).m415a();
                for (int i6 = 0; i6 < m415a.getCount(); i6++) {
                    if (!m415a.isItemChecked(i6)) {
                        arrayList.add(this.f19442a[i6]);
                    }
                }
                C3102bd.m18937b(this.f19443b, this.f19444c, new C2466a((Collection<?>) arrayList).toString());
                dialogInterface.dismiss();
            }
        });
        aVar.m440c(R.string.mselect_inv, (DialogInterface.OnClickListener) null);
        DialogInterfaceC0070b m438b = aVar.m438b();
        m438b.setOnShowListener(new DialogInterface.OnShowListener(m438b, zArr) { // from class: ru.maximoff.apktool.util.f.s.3

            /* renamed from: a */
            private final DialogInterfaceC0070b f19445a;

            /* renamed from: b */
            private final boolean[] f19446b;

            {
                this.f19445a = m438b;
                this.f19446b = zArr;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                Button m414a = this.f19445a.m414a(-1);
                m414a.setEnabled(true);
                ListView m415a = this.f19445a.m415a();
                for (int i5 = 0; i5 < m415a.getCount(); i5++) {
                    m415a.setItemChecked(i5, this.f19446b[i5]);
                }
                m415a.setOnItemClickListener(new AdapterView.OnItemClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.f.s.3.1

                    /* renamed from: a */
                    private final AnonymousClass3 f19447a;

                    /* renamed from: b */
                    private final ListView f19448b;

                    /* renamed from: c */
                    private final Button f19449c;

                    {
                        this.f19447a = this;
                        this.f19448b = m415a;
                        this.f19449c = m414a;
                    }

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j) {
                        for (int i7 = 0; i7 < this.f19448b.getCount(); i7++) {
                            if (this.f19448b.isItemChecked(i7)) {
                                this.f19449c.setEnabled(true);
                                return;
                            }
                        }
                        this.f19449c.setEnabled(false);
                    }
                });
                Button m414a2 = this.f19445a.m414a(-3);
                m414a2.setOnClickListener(new View.OnClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.f.s.3.2

                    /* renamed from: a */
                    private final AnonymousClass3 f19450a;

                    /* renamed from: b */
                    private final ListView f19451b;

                    /* renamed from: c */
                    private final Button f19452c;

                    {
                        this.f19450a = this;
                        this.f19451b = m415a;
                        this.f19452c = m414a;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        boolean z = false;
                        for (int i6 = 0; i6 < this.f19451b.getCount(); i6++) {
                            boolean isItemChecked = this.f19451b.isItemChecked(i6);
                            this.f19451b.setItemChecked(i6, !isItemChecked);
                            if (!isItemChecked) {
                                z = true;
                            }
                        }
                        this.f19452c.setEnabled(z);
                    }
                });
                m414a2.setOnLongClickListener(new View.OnLongClickListener(this, m415a, m414a) { // from class: ru.maximoff.apktool.util.f.s.3.3

                    /* renamed from: a */
                    private final AnonymousClass3 f19453a;

                    /* renamed from: b */
                    private final ListView f19454b;

                    /* renamed from: c */
                    private final Button f19455c;

                    {
                        this.f19453a = this;
                        this.f19454b = m415a;
                        this.f19455c = m414a;
                    }

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view) {
                        for (int i6 = 0; i6 < this.f19454b.getCount(); i6++) {
                            this.f19454b.setItemChecked(i6, true);
                        }
                        this.f19455c.setEnabled(true);
                        return true;
                    }
                });
            }
        });
        m438b.show();
    }

    /* renamed from: a */
    public static void m19418a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mdialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.mdialogTextView1)).setText(R.string.mtr_deepl_key_info);
        EditText editText = (EditText) inflate.findViewById(R.id.mdialogEditText1);
        editText.setHint(R.string.mtr_deepl_key);
        editText.setText(C3102bd.m18910a(context, "deepl_api_key", ""));
        DialogInterfaceC0070b m438b = new DialogInterfaceC0070b.a(context).m418a(R.string.mtr_deepl_key).m435b(inflate).m420a(R.string.f21470ok, new DialogInterface.OnClickListener(context, editText) { // from class: ru.maximoff.apktool.util.f.s.4

            /* renamed from: a */
            private final Context f19456a;

            /* renamed from: b */
            private final EditText f19457b;

            {
                this.f19456a = context;
                this.f19457b = editText;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3102bd.m18937b(this.f19456a, "deepl_api_key", this.f19457b.getText().toString().trim());
                dialogInterface.cancel();
            }
        }).m434b(R.string.cancel, (DialogInterface.OnClickListener) null).m440c(R.string.search_reset, new DialogInterface.OnClickListener(context) { // from class: ru.maximoff.apktool.util.f.s.5

            /* renamed from: a */
            private final Context f19458a;

            {
                this.f19458a = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C3102bd.m18924a(this.f19458a, "deepl_api_key");
                dialogInterface.cancel();
            }
        }).m438b();
        m438b.getWindow().setSoftInputMode(4);
        m438b.setOnShowListener(new DialogInterface.OnShowListener(editText) { // from class: ru.maximoff.apktool.util.f.s.6

            /* renamed from: a */
            private final EditText f19459a;

            {
                this.f19459a = editText;
            }

            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                this.f19459a.requestFocus();
                this.f19459a.selectAll();
            }
        });
        m438b.show();
    }

    /* renamed from: b */
    public static void m19428b(Context context) {
        String[] strArr = {context.getString(R.string.mtr_yandex), context.getString(R.string.mtr_bing), context.getString(R.string.mtr_google), context.getString(R.string.mtr_google_web), context.getString(R.string.mtr_deepl), context.getString(R.string.mtr_deepl_key)};
        new DialogInterfaceC0070b.a(context).m418a(R.string.trlangs_settings).m431a(strArr, new DialogInterface.OnClickListener(strArr, context) { // from class: ru.maximoff.apktool.util.f.s.7

            /* renamed from: a */
            private final String[] f19460a;

            /* renamed from: b */
            private final Context f19461b;

            {
                this.f19460a = strArr;
                this.f19461b = context;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                if (i == this.f19460a.length - 1) {
                    C3239s.m19418a(this.f19461b);
                } else {
                    C3239s.m19419a(this.f19461b, i);
                }
            }
        }).m420a(R.string.cancel, (DialogInterface.OnClickListener) null).m438b().show();
    }

    /* renamed from: k */
    public static boolean m19439k(String str) {
        Matcher matcher = Pattern.compile("\\<(\\w+)[^\\>]*\\>.*\\</(\\w+)\\>|\\<(\\w+)[^\\>]*/\\>", 32).matcher(str);
        boolean z = false;
        while (matcher.find()) {
            if (matcher.group(1) != null && !C3080al.m18585b(C3249i.f19543c, matcher.group(1))) {
                return false;
            }
            if (matcher.group(2) != null && !C3080al.m18585b(C3249i.f19543c, matcher.group(2))) {
                return false;
            }
            if (matcher.group(3) != null && !C3080al.m18585b(C3249i.f19543c, matcher.group(3))) {
                return false;
            }
            if (!z) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static List<String> m19416a(String str, int i) {
        ArrayList arrayList = new ArrayList();
        while (str.length() > i) {
            int lastIndexOf = str.lastIndexOf(".", i - 1);
            if (lastIndexOf == -1) {
                lastIndexOf = str.lastIndexOf("?", i - 1);
            }
            if (lastIndexOf == -1) {
                lastIndexOf = str.lastIndexOf("!", i - 1);
            }
            if (lastIndexOf == -1) {
                lastIndexOf = str.lastIndexOf("？", i - 1);
            }
            if (lastIndexOf == -1) {
                lastIndexOf = str.lastIndexOf("！", i - 1);
            }
            if (lastIndexOf == -1) {
                lastIndexOf = str.lastIndexOf(",", i - 1);
            }
            if (lastIndexOf == -1) {
                lastIndexOf = str.lastIndexOf(" ", i - 1);
            }
            if (lastIndexOf == -1) {
                arrayList.add(str.substring(0, i));
                str = str.substring(i);
            } else {
                arrayList.add(str.substring(0, lastIndexOf + 1));
                str = str.substring(lastIndexOf + 1);
            }
        }
        if (!str.isEmpty()) {
            arrayList.add(str);
        }
        return arrayList;
    }
}
