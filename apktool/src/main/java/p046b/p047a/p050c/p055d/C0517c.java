package p046b.p047a.p050c.p055d;

import java.p209io.File;
import java.p209io.FileInputStream;
import java.p209io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import p046b.p059d.InterfaceC0541f;
import ru.maximoff.apktool.MainActivity;
import ru.maximoff.apktool.util.C3080al;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: ResXmlPatcher.java */
/* renamed from: b.a.c.d.c */
/* loaded from: classes.dex */
public final class C0517c {
    /* renamed from: a */
    public static String m3876a(File file) {
        if (file.exists()) {
            try {
                String m18332i = C3061a.m18332i(file);
                Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<application([^>]+?)\\s+").append(C3061a.m18298a(m18332i)).toString()).append(":networkSecurityConfig=\"([^\"]+)\"").toString()).matcher(m18332i);
                if (matcher.find()) {
                    return matcher.group(2).split("/")[1];
                }
            } catch (Exception e2) {
            }
        }
        return (String) null;
    }

    /* renamed from: a */
    public static void m3880a(File file, String str) {
        if (file.exists()) {
            String m18332i = C3061a.m18332i(file);
            String m18298a = C3061a.m18298a(m18332i);
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<application([^>]+?)\\s+").append(m18298a).toString()).append(":networkSecurityConfig=\"([^\"]+)\"").toString()).matcher(m18332i);
            if (matcher.find()) {
                matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<application").append(m3878a(matcher.group(1))).toString()).append("\n\t\t").toString()).append(m18298a).toString()).append(":networkSecurityConfig=\"@xml/").toString()).append(str).toString()).append("\"").toString());
                matcher.appendTail(stringBuffer);
                C3061a.m18319b(file, stringBuffer.toString());
            } else {
                Matcher matcher2 = Pattern.compile("<application(\\s+)").matcher(m18332i);
                if (matcher2.find()) {
                    matcher2.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<application\n\t\t").append(m18298a).toString()).append(":networkSecurityConfig=\"@xml/").toString()).append(str).toString()).append("\"").toString()).append(matcher2.group(1)).toString());
                    matcher2.appendTail(stringBuffer);
                    C3061a.m18319b(file, stringBuffer.toString());
                }
            }
        }
    }

    /* renamed from: b */
    public static void m3883b(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        C3080al.m18561a("tpl/nsc.tpl", file);
    }

    /* renamed from: a */
    public static String m3877a(File file, String str, InterfaceC0541f interfaceC0541f) {
        if (str == null || !str.contains("@")) {
            return (String) null;
        }
        File file2 = new File(file, "/res/values/strings.xml");
        String replace = str.replace("@string/", "");
        if (file2.exists()) {
            try {
                Object evaluate = XPathFactory.newInstance().newXPath().compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("/resources/string[@name=").append('\"').toString()).append(replace).toString()).append("\"]/text()").toString()).evaluate(m3885c(file2, interfaceC0541f), XPathConstants.STRING);
                if (evaluate != null) {
                    return (String) evaluate;
                }
            } catch (IOException e2) {
            } catch (ParserConfigurationException e3) {
            } catch (XPathExpressionException e4) {
            } catch (SAXException e5) {
            }
        }
        return (String) null;
    }

    /* renamed from: c */
    private static Document m3885c(File file, InterfaceC0541f interfaceC0541f) {
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return newDocumentBuilder.parse(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }

    /* renamed from: a */
    public static void m3881a(File file, String str, boolean z) {
        String m18332i = C3061a.m18332i(file);
        String m18298a = C3061a.m18298a(m18332i);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<application([^>]+?)\\s+").append(m18298a).toString()).append(":debuggable=\"([^\"]+)\"").toString()).matcher(m18332i);
        if (matcher.find()) {
            if (z) {
                matcher.appendReplacement(stringBuffer, new StringBuffer().append("<application").append(m3878a(matcher.group(1))).toString());
            } else {
                matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<application").append(m3878a(matcher.group(1))).toString()).append("\n\t\t").toString()).append(m18298a).toString()).append(":debuggable=\"").toString()).append(str).toString()).append("\"").toString());
            }
            matcher.appendTail(stringBuffer);
            C3061a.m18319b(file, stringBuffer.toString());
            return;
        }
        if (!z) {
            Matcher matcher2 = Pattern.compile("<application(\\s+)").matcher(m18332i);
            if (matcher2.find()) {
                matcher2.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<application\n\t\t").append(m18298a).toString()).append(":debuggable=\"").toString()).append(str).toString()).append("\"").toString()).append(matcher2.group(1)).toString());
                matcher2.appendTail(stringBuffer);
                C3061a.m18319b(file, stringBuffer.toString());
            }
        }
    }

    /* renamed from: c */
    public static void m3886c(File file) {
        String m18332i = C3061a.m18332i(file);
        String m18298a = C3061a.m18298a(m18332i);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<manifest([^>]+?)\\s+").append(m18298a).toString()).append(":versionCode=\"([^\"]+)\"").toString()).matcher(m18332i);
        if (matcher.find()) {
            matcher.appendReplacement(stringBuffer, new StringBuffer().append("<manifest").append(m3878a(matcher.group(1))).toString());
        }
        matcher.appendTail(stringBuffer);
        StringBuffer stringBuffer2 = new StringBuffer();
        Matcher matcher2 = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<manifest([^>]+?)\\s+").append(m18298a).toString()).append(":versionName=\"([^\"]+)\"").toString()).matcher(stringBuffer.toString());
        if (matcher2.find()) {
            matcher2.appendReplacement(stringBuffer2, new StringBuffer().append("<manifest").append(m3878a(matcher2.group(1))).toString());
        }
        matcher2.appendTail(stringBuffer2);
        C3061a.m18319b(file, stringBuffer2.toString());
    }

    /* renamed from: b */
    public static void m3884b(File file, String str) {
        String m18332i = C3061a.m18332i(file);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile("<manifest([^>]+?)package=\"([^\"]+)\"").matcher(m18332i);
        if (matcher.find()) {
            matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<manifest").append(matcher.group(1)).toString()).append("package=\"").toString()).append(str).toString()).append("\"").toString());
            matcher.appendTail(stringBuffer);
            C3061a.m18319b(file, stringBuffer.toString());
        }
    }

    /* renamed from: a */
    public static void m3879a(File file, InterfaceC0541f interfaceC0541f) {
        String m3877a;
        boolean z = false;
        String m18332i = C3061a.m18332i(file);
        String m18298a = C3061a.m18298a(m18332i);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<provider([^>]+?)").append(m18298a).toString()).append(":authorities=\"@string/([^\"]+)\"").toString()).matcher(m18332i);
        while (matcher.find()) {
            String m3877a2 = m3877a(file.getParentFile(), new StringBuffer().append("@string/").append(matcher.group(2)).toString(), interfaceC0541f);
            if (m3877a2 != null) {
                if (!z) {
                    z = true;
                }
                matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<provider").append(matcher.group(1)).toString()).append("").toString()).append(m18298a).toString()).append(":authorities=\"").toString()).append(m3877a2).toString()).append("\"").toString());
            }
        }
        matcher.appendTail(stringBuffer);
        StringBuffer stringBuffer2 = new StringBuffer();
        Matcher matcher2 = Pattern.compile(new StringBuffer().append(new StringBuffer().append("<data([^>]+?)").append(m18298a).toString()).append(":scheme=\"@string/([^\"]+)\"").toString()).matcher(stringBuffer.toString());
        if (matcher2.find() && (m3877a = m3877a(file.getParentFile(), new StringBuffer().append("@string/").append(matcher2.group(2)).toString(), interfaceC0541f)) != null) {
            if (!z) {
                z = true;
            }
            matcher2.appendReplacement(stringBuffer2, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("<data").append(matcher2.group(1)).toString()).append("").toString()).append(m18298a).toString()).append(":scheme=\"").toString()).append(m3877a).toString()).append("\"").toString());
        }
        matcher2.appendTail(stringBuffer2);
        if (z) {
            C3061a.m18319b(file, stringBuffer2.toString());
        }
    }

    /* renamed from: a */
    private static String m3878a(String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        return str;
    }

    /* renamed from: d */
    public static void m3887d(File file) {
        String m18332i = C3061a.m18332i(file);
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile("(\\s+)<uses-permission([^>]+?)android:name=\"([^\"]+)\"", 8).matcher(m18332i);
        while (matcher.find()) {
            String m18604i = C3080al.m18604i(MainActivity.m16615o(), matcher.group(3));
            if (m18604i != null) {
                matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(matcher.group(1)).append("<!-- ").toString()).append(m18604i).toString()).append(" -->").toString()).append(matcher.group(0)).toString());
            }
        }
        matcher.appendTail(stringBuffer);
        C3061a.m18319b(file, stringBuffer.toString());
    }

    /* renamed from: b */
    public static List<String> m3882b(File file, InterfaceC0541f interfaceC0541f) {
        if (!file.exists()) {
            return (List) null;
        }
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("/manifest//*").evaluate(m3885c(file, interfaceC0541f), XPathConstants.NODESET);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node namedItem = nodeList.item(i).getAttributes().getNamedItem("android:featureFlag");
                if (namedItem != null) {
                    arrayList.add(namedItem.getNodeValue());
                }
            }
            return arrayList;
        } catch (IOException | ParserConfigurationException | XPathExpressionException | SAXException e2) {
            return (List) null;
        }
    }
}
