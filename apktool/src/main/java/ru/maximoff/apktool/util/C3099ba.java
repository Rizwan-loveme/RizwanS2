package ru.maximoff.apktool.util;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Camera;
import android.icu.text.DateFormat;
import android.net.wifi.WifiConfiguration;
import android.p008os.BatteryManager;
import android.provider.CallLog;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.p209io.ByteArrayInputStream;
import java.p209io.File;
import java.p209io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.p217b.p218a.p219a.C1887e;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.maximoff.apktool.util.p303a.C3061a;

/* compiled from: SVGUtils.java */
/* renamed from: ru.maximoff.apktool.util.ba */
/* loaded from: classes.dex */
public class C3099ba {

    /* renamed from: a */
    private final float f18214a;

    /* renamed from: b */
    private String f18215b;

    /* renamed from: c */
    private File f18216c;

    /* renamed from: d */
    private byte[] f18217d;

    /* renamed from: e */
    private Context f18218e;

    /* renamed from: f */
    private DocumentBuilderFactory f18219f;

    /* renamed from: g */
    private DocumentBuilder f18220g;

    /* renamed from: h */
    private Document f18221h;

    /* renamed from: i */
    private int f18222i;

    /* renamed from: j */
    private int f18223j;

    /* renamed from: k */
    private File f18224k;

    /* renamed from: l */
    private Map<String, String> f18225l;

    /* renamed from: m */
    private Map<String, String> f18226m;

    /* renamed from: n */
    private Map<String, Element> f18227n;

    /* renamed from: o */
    private Map<String, Element> f18228o;

    /* renamed from: p */
    private Map<String, Element> f18229p;

    /* renamed from: q */
    private int f18230q;

    /* renamed from: r */
    private List<String> f18231r;

    /* renamed from: s */
    private StringBuilder f18232s;

    public C3099ba(Context context, String str) {
        this(context, new File(str));
    }

    public C3099ba(Context context, File file) {
        this.f18214a = 0.5522848f;
        this.f18224k = (File) null;
        this.f18230q = 0;
        this.f18232s = new StringBuilder();
        this.f18218e = context;
        this.f18216c = file;
        this.f18217d = (byte[]) null;
        this.f18225l = (Map) null;
        this.f18226m = (Map) null;
        this.f18215b = "android:";
        this.f18222i = 0;
        this.f18223j = 0;
        try {
            this.f18215b = new StringBuffer().append(C3061a.m18293a(file)).append(":").toString();
            this.f18219f = DocumentBuilderFactory.newInstance();
            this.f18220g = this.f18219f.newDocumentBuilder();
            this.f18221h = this.f18220g.parse(this.f18216c);
            this.f18221h.normalize();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
    }

    public C3099ba(Context context, InputStream inputStream) {
        this(context, C1887e.m13984b(inputStream));
    }

    public C3099ba(Context context, byte[] bArr) {
        this.f18214a = 0.5522848f;
        this.f18224k = (File) null;
        this.f18230q = 0;
        this.f18232s = new StringBuilder();
        this.f18218e = context;
        this.f18216c = (File) null;
        this.f18222i = 0;
        this.f18223j = 0;
        this.f18225l = (Map) null;
        this.f18226m = (Map) null;
        this.f18215b = "android:";
        this.f18217d = bArr;
        try {
            this.f18219f = DocumentBuilderFactory.newInstance();
            this.f18220g = this.f18219f.newDocumentBuilder();
            this.f18221h = this.f18220g.parse(new ByteArrayInputStream(this.f18217d));
            this.f18221h.normalize();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
    }

    /* renamed from: a */
    public void m18871a(File file) {
        this.f18224k = file;
    }

    /* renamed from: a */
    public void m18870a() {
        if (this.f18224k != null) {
            File file = new File(new StringBuffer().append(this.f18224k.getAbsolutePath()).append("/res/values/colors.xml").toString());
            if (file.isFile()) {
                this.f18225l = C3061a.m18328e(file);
            }
        }
    }

    /* renamed from: b */
    public void m18873b() {
        if (this.f18224k != null) {
            File file = new File(new StringBuffer().append(this.f18224k.getAbsolutePath()).append("/res/values/strings.xml").toString());
            if (file.isFile()) {
                this.f18226m = C3061a.m18329f(file);
            }
        }
    }

    /* renamed from: c */
    public File m18874c() {
        return this.f18216c;
    }

    /* renamed from: d */
    public int m18875d() {
        return this.f18222i;
    }

    /* renamed from: e */
    public int m18876e() {
        return this.f18223j;
    }

    /* renamed from: f */
    public String m18877f() {
        if (this.f18221h == null) {
            return (String) null;
        }
        try {
            return this.f18221h.getDocumentElement().getNodeName();
        } catch (Error | Exception e2) {
            return (String) null;
        }
    }

    /* renamed from: g */
    public boolean m18878g() {
        String m18877f = m18877f();
        if (m18877f == null) {
            return false;
        }
        return m18877f.equalsIgnoreCase("svg");
    }

    /* renamed from: h */
    public boolean m18879h() {
        String m18877f = m18877f();
        if (m18877f == null) {
            return false;
        }
        return m18877f.equalsIgnoreCase("vector");
    }

    /* renamed from: i */
    public boolean m18880i() {
        String m18877f = m18877f();
        return m18877f != null && m18877f.equalsIgnoreCase("drawable") && m18843b(this.f18221h.getDocumentElement());
    }

    /* renamed from: b */
    private boolean m18843b(Element element) {
        NodeList childNodes = element.getChildNodes();
        if (childNodes.getLength() == 0) {
            return false;
        }
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                String nodeName = item.getNodeName();
                if (!nodeName.equals("path") && !nodeName.equals(WifiConfiguration.GroupCipher.varName) && !nodeName.equals("clip-path")) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: j */
    public boolean m18881j() {
        return m18878g() || m18879h() || m18880i();
    }

    /* renamed from: k */
    public String m18882k() {
        String m18332i;
        if (m18878g()) {
            Element documentElement = this.f18221h.getDocumentElement();
            if (this.f18216c == null) {
                m18332i = new String(this.f18217d, StandardCharsets.UTF_8);
            } else {
                m18332i = C3061a.m18332i(this.f18216c);
            }
            if (documentElement.hasAttribute("width") && documentElement.hasAttribute("height")) {
                if (!documentElement.hasAttribute("viewBox")) {
                    String replaceAll = documentElement.getAttribute("width").replaceAll("[^-\\d\\.]", "");
                    String replaceAll2 = documentElement.getAttribute("height").replaceAll("[^-\\d\\.]", "");
                    int indexOf = replaceAll.indexOf(46);
                    int indexOf2 = replaceAll2.indexOf(46);
                    if (indexOf <= 0) {
                        this.f18222i = Integer.parseInt(replaceAll);
                    } else {
                        this.f18222i = Integer.parseInt(replaceAll.substring(0, indexOf));
                    }
                    if (indexOf2 <= 0) {
                        this.f18223j = Integer.parseInt(replaceAll2);
                    } else {
                        this.f18223j = Integer.parseInt(replaceAll2.substring(0, indexOf2));
                    }
                    Matcher matcher = Pattern.compile("<svg\\s+", 2).matcher(m18332i);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (matcher.find()) {
                        matcher.appendReplacement(stringBuffer, new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(matcher.group(0)).append("viewBox=\"0 0 ").toString()).append(replaceAll).toString()).append(" ").toString()).append(replaceAll2).toString()).append("\" ").toString());
                    }
                    matcher.appendTail(stringBuffer);
                    return stringBuffer.toString();
                }
                String[] split = documentElement.getAttribute("viewBox").replace(",", " ").split("\\s+");
                int indexOf3 = split[2].indexOf(46);
                int indexOf4 = split[3].indexOf(46);
                if (indexOf3 <= 0) {
                    this.f18222i = Integer.parseInt(split[2].replaceAll("[^-\\d\\.]", ""));
                } else {
                    this.f18222i = Integer.parseInt(split[2].substring(0, indexOf3));
                }
                if (indexOf4 <= 0) {
                    this.f18223j = Integer.parseInt(split[3].replaceAll("[^-\\d\\.]", ""));
                    return m18332i;
                }
                this.f18223j = Integer.parseInt(split[3].substring(0, indexOf4));
                return m18332i;
            }
            if (documentElement.hasAttribute("viewBox")) {
                String[] split2 = documentElement.getAttribute("viewBox").replace(",", " ").split("\\s+");
                int indexOf5 = split2[2].indexOf(46);
                int indexOf6 = split2[3].indexOf(46);
                if (indexOf5 <= 0) {
                    this.f18222i = Integer.parseInt(split2[2].replaceAll("[^-\\d\\.]", ""));
                } else {
                    this.f18222i = Integer.parseInt(split2[2].substring(0, indexOf5));
                }
                if (indexOf6 <= 0) {
                    this.f18223j = Integer.parseInt(split2[3].replaceAll("[^-\\d\\.]", ""));
                    return m18332i;
                }
                this.f18223j = Integer.parseInt(split2[3].substring(0, indexOf6));
                return m18332i;
            }
            return m18332i;
        }
        if (!m18879h() && !m18880i()) {
            return "";
        }
        this.f18231r = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("<svg\n\txmlns=\"http://www.w3.org/2000/svg\"\n\txmlns:xlink=\"http://www.w3.org/1999/xlink\"\n\tversion=\"1.1\"");
        Element documentElement2 = this.f18221h.getDocumentElement();
        if (documentElement2.hasAttribute(new StringBuffer().append(this.f18215b).append("viewportWidth").toString()) && documentElement2.hasAttribute(new StringBuffer().append(this.f18215b).append("viewportHeight").toString())) {
            String attribute = documentElement2.getAttribute(new StringBuffer().append(this.f18215b).append("viewportWidth").toString());
            String attribute2 = documentElement2.getAttribute(new StringBuffer().append(this.f18215b).append("viewportHeight").toString());
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n\twidth=\"").append(attribute).toString()).append("\"\n\theight=\"").toString()).append(attribute2).toString()).append("\"\n\tviewBox=\"0 0 ").toString()).append(attribute).toString()).append(" ").toString()).append(attribute2).toString()).append("\"").toString());
            int indexOf7 = attribute.indexOf(46);
            int indexOf8 = attribute2.indexOf(46);
            if (indexOf7 <= 0) {
                this.f18222i = Integer.parseInt(attribute);
            } else {
                this.f18222i = Integer.parseInt(attribute.substring(0, indexOf7));
            }
            if (indexOf8 <= 0) {
                this.f18223j = Integer.parseInt(attribute2);
            } else {
                this.f18223j = Integer.parseInt(attribute2.substring(0, indexOf8));
            }
        } else if (documentElement2.hasAttribute(new StringBuffer().append(this.f18215b).append("width").toString()) && documentElement2.hasAttribute(new StringBuffer().append(this.f18215b).append("height").toString())) {
            String replaceAll3 = documentElement2.getAttribute(new StringBuffer().append(this.f18215b).append("width").toString()).replaceAll("[^-\\d\\.]", "");
            String replaceAll4 = documentElement2.getAttribute(new StringBuffer().append(this.f18215b).append("height").toString()).replaceAll("[^-\\d\\.]", "");
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n\twidth=\"").append(replaceAll3).toString()).append("\"\n\theight=\"").toString()).append(replaceAll4).toString()).append("\"\n\tviewBox=\"0 0 ").toString()).append(replaceAll3).toString()).append(" ").toString()).append(replaceAll4).toString()).append("\"").toString());
            int indexOf9 = replaceAll3.indexOf(46);
            int indexOf10 = replaceAll4.indexOf(46);
            if (indexOf9 <= 0) {
                this.f18222i = Integer.parseInt(replaceAll3);
            } else {
                this.f18222i = Integer.parseInt(replaceAll3.substring(0, indexOf9));
            }
            if (indexOf10 <= 0) {
                this.f18223j = Integer.parseInt(replaceAll4);
            } else {
                this.f18223j = Integer.parseInt(replaceAll4.substring(0, indexOf10));
            }
        } else {
            sb.append("\n\twidth=\"100%\"\n\theight=\"100%\"");
        }
        sb.append(">");
        NodeList childNodes = documentElement2.getChildNodes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childNodes.getLength()) {
                break;
            }
            Node item = childNodes.item(i2);
            if (item.getNodeType() == 1) {
                sb.append(m18846c((Element) item, 1));
            }
            i = i2 + 1;
        }
        if (!this.f18231r.isEmpty()) {
            sb.append("\n\t<defs>");
            Iterator<String> it = this.f18231r.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            sb.append("\n\t</defs>");
        }
        sb.append("\n</svg>");
        try {
            this.f18220g.reset();
            if (this.f18216c == null) {
                this.f18221h = this.f18220g.parse(new ByteArrayInputStream(this.f18217d));
            } else {
                this.f18221h = this.f18220g.parse(this.f18216c);
            }
            this.f18221h.normalize();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        return sb.toString();
    }

    /* renamed from: l */
    public String m18883l() {
        if (m18879h() || m18880i()) {
            if (this.f18216c == null) {
                return new String(this.f18217d, StandardCharsets.UTF_8);
            }
            return C3061a.m18332i(this.f18216c);
        }
        if (!m18878g()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuffer().append(new StringBuffer().append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!-- ").append("Created by Apktool M – https://github.com/Maximoff/Apktool-M-updates").toString()).append(" -->\n<vector\n\txmlns:android=\"http://schemas.android.com/apk/res/android\"\n\txmlns:aapt=\"http://schemas.android.com/aapt\"").toString());
        Element documentElement = this.f18221h.getDocumentElement();
        m18867m();
        m18868n();
        m18869o();
        if (documentElement.hasAttribute("width") && documentElement.hasAttribute("height")) {
            String replaceAll = documentElement.getAttribute("width").replaceAll("[^-\\d\\.]", "");
            String replaceAll2 = documentElement.getAttribute("height").replaceAll("[^-\\d\\.]", "");
            if (!documentElement.hasAttribute("viewBox")) {
                int indexOf = replaceAll.indexOf(46);
                int indexOf2 = replaceAll2.indexOf(46);
                if (indexOf <= 0) {
                    this.f18222i = Integer.parseInt(replaceAll);
                } else {
                    this.f18222i = Integer.parseInt(replaceAll.substring(0, indexOf));
                }
                if (indexOf2 <= 0) {
                    this.f18223j = Integer.parseInt(replaceAll2);
                } else {
                    this.f18223j = Integer.parseInt(replaceAll2.substring(0, indexOf2));
                }
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n\tandroid:width=\"").append(replaceAll).toString()).append("dp\"\n\tandroid:height=\"").toString()).append(replaceAll2).toString()).append("dp\"\n\tandroid:viewportWidth=\"").toString()).append(replaceAll).toString()).append("\"\n\tandroid:viewportHeight=\"").toString()).append(replaceAll2).toString()).append("\"").toString());
            } else {
                String[] split = documentElement.getAttribute("viewBox").replace(",", " ").split("\\s+");
                int indexOf3 = split[2].indexOf(46);
                int indexOf4 = split[3].indexOf(46);
                if (indexOf3 <= 0) {
                    this.f18222i = Integer.parseInt(split[2].replaceAll("[^-\\d\\.]", ""));
                } else {
                    this.f18222i = Integer.parseInt(split[2].substring(0, indexOf3));
                }
                if (indexOf4 <= 0) {
                    this.f18223j = Integer.parseInt(split[3].replaceAll("[^-\\d\\.]", ""));
                } else {
                    this.f18223j = Integer.parseInt(split[3].substring(0, indexOf4));
                }
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n\tandroid:width=\"").append(replaceAll).toString()).append("dp\"\n\tandroid:height=\"").toString()).append(replaceAll2).toString()).append("dp\"\n\tandroid:viewportWidth=\"").toString()).append(split[2].replaceAll("[^-\\d\\.]", "")).toString()).append("\"\n\tandroid:viewportHeight=\"").toString()).append(split[3].replaceAll("[^-\\d\\.]", "")).toString()).append("\"").toString());
            }
        } else if (documentElement.hasAttribute("viewBox")) {
            String[] split2 = documentElement.getAttribute("viewBox").replace(",", " ").split("\\s+");
            int indexOf5 = split2[2].indexOf(46);
            int indexOf6 = split2[3].indexOf(46);
            if (indexOf5 <= 0) {
                this.f18222i = Integer.parseInt(split2[2].replaceAll("[^-\\d\\.]", ""));
            } else {
                this.f18222i = Integer.parseInt(split2[2].substring(0, indexOf5));
            }
            if (indexOf6 <= 0) {
                this.f18223j = Integer.parseInt(split2[3].replaceAll("[^-\\d\\.]", ""));
            } else {
                this.f18223j = Integer.parseInt(split2[3].substring(0, indexOf6));
            }
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n\tandroid:width=\"").append(split2[2].replaceAll("[^-\\d\\.]", "")).toString()).append("dp\"\n\tandroid:height=\"").toString()).append(split2[3].replaceAll("[^-\\d\\.]", "")).toString()).append("dp\"\n\tandroid:viewportWidth=\"").toString()).append(split2[2].replaceAll("[^-\\d\\.]", "")).toString()).append("\"\n\tandroid:viewportHeight=\"").toString()).append(split2[3].replaceAll("[^-\\d\\.]", "")).toString()).append("\"").toString());
        }
        sb.append(">");
        NodeList childNodes = documentElement.getChildNodes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childNodes.getLength()) {
                break;
            }
            Node item = childNodes.item(i2);
            if (item.getNodeType() == 1) {
                sb.append(m18829a((Element) item, 1));
            }
            i = i2 + 1;
        }
        sb.append("\n</vector>");
        try {
            this.f18220g.reset();
            if (this.f18216c == null) {
                this.f18221h = this.f18220g.parse(new ByteArrayInputStream(this.f18217d));
            } else {
                this.f18221h = this.f18220g.parse(this.f18216c);
            }
            this.f18221h.normalize();
        } catch (Error e2) {
        } catch (Exception e3) {
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m18829a(Element element, int i) {
        Element element2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Element element3;
        Element element4;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(m18839b(i));
        NodeList childNodes = element.getChildNodes();
        String lowerCase = element.getNodeName().toLowerCase();
        a aVar = (a) null;
        if (element.hasAttribute("transform")) {
            aVar = m18861h(element.getAttribute("transform"));
        }
        if (lowerCase.equals("clippath")) {
            sb.append("<clip-path");
        } else if (lowerCase.equals("g")) {
            if (element.hasAttribute("clip-path")) {
                String attribute = element.getAttribute("clip-path");
                if (attribute.startsWith("url(#")) {
                    String substring = attribute.substring(5, attribute.length() - 1);
                    if (this.f18227n != null && (element4 = this.f18227n.get(substring)) != null) {
                        sb2.append(m18863i(element4, i + 1));
                    }
                }
            } else if (element.hasAttribute("mask")) {
                String attribute2 = element.getAttribute("mask");
                if (attribute2.startsWith("url(#")) {
                    String substring2 = attribute2.substring(5, attribute2.length() - 1);
                    if (this.f18227n != null && (element3 = this.f18227n.get(substring2)) != null) {
                        sb2.append(m18863i(element3, i + 1));
                    }
                }
            }
            if (childNodes.getLength() == 0 && sb2.length() == 0) {
                return "";
            }
            sb.append("<group");
        } else if (lowerCase.equals("line")) {
            sb.append(new StringBuffer().append(new StringBuffer().append("<").append("path").toString()).append(m18839b(i + 1)).toString()).append(new StringBuffer().append(this.f18215b).append("pathData=\"").toString());
            String m18845c = m18845c(element);
            if (aVar != null) {
                str6 = m18828a(m18845c, aVar);
                element.removeAttribute("transform");
            } else {
                str6 = m18845c;
            }
            sb.append(str6);
            sb.append("\"");
            lowerCase = "path";
        } else if (lowerCase.equals("rect")) {
            sb.append(new StringBuffer().append(new StringBuffer().append("<").append("path").toString()).append(m18839b(i + 1)).toString()).append(new StringBuffer().append(this.f18215b).append("pathData=\"").toString());
            String m18848d = m18848d(element);
            if (aVar != null) {
                str5 = m18828a(m18848d, aVar);
                element.removeAttribute("transform");
            } else {
                str5 = m18848d;
            }
            sb.append(str5);
            sb.append("\"");
            lowerCase = "path";
        } else if (lowerCase.equals("circle")) {
            sb.append(new StringBuffer().append(new StringBuffer().append("<").append("path").toString()).append(m18839b(i + 1)).toString()).append(new StringBuffer().append(this.f18215b).append("pathData=\"").toString());
            String m18852e = m18852e(element);
            if (aVar != null) {
                str4 = m18828a(m18852e, aVar);
                element.removeAttribute("transform");
            } else {
                str4 = m18852e;
            }
            sb.append(str4);
            sb.append("\"");
            lowerCase = "path";
        } else if (lowerCase.equals("ellipse")) {
            sb.append(new StringBuffer().append(new StringBuffer().append("<").append("path").toString()).append(m18839b(i + 1)).toString()).append(new StringBuffer().append(this.f18215b).append("pathData=\"").toString());
            String m18854f = m18854f(element);
            if (aVar != null) {
                str3 = m18828a(m18854f, aVar);
                element.removeAttribute("transform");
            } else {
                str3 = m18854f;
            }
            sb.append(str3);
            sb.append("\"");
            lowerCase = "path";
        } else if (lowerCase.equals("polyline")) {
            sb.append(new StringBuffer().append(new StringBuffer().append("<").append("path").toString()).append(m18839b(i + 1)).toString()).append(new StringBuffer().append(this.f18215b).append("pathData=\"").toString());
            String m18830a = m18830a(element, true);
            if (aVar != null) {
                str2 = m18828a(m18830a, aVar);
                element.removeAttribute("transform");
            } else {
                str2 = m18830a;
            }
            sb.append(str2);
            sb.append("\"");
            lowerCase = "path";
        } else if (lowerCase.equals("polygon")) {
            sb.append(new StringBuffer().append(new StringBuffer().append("<").append("path").toString()).append(m18839b(i + 1)).toString()).append(new StringBuffer().append(this.f18215b).append("pathData=\"").toString());
            String m18830a2 = m18830a(element, false);
            if (aVar != null) {
                str = m18828a(m18830a2, aVar);
                element.removeAttribute("transform");
            } else {
                str = m18830a2;
            }
            sb.append(str);
            sb.append("\"");
            lowerCase = "path";
        } else if (lowerCase.equals("path")) {
            if (aVar != null && element.hasAttribute(DateFormat.DAY)) {
                element.setAttribute(DateFormat.DAY, m18828a(element.getAttribute(DateFormat.DAY), aVar));
                element.removeAttribute("transform");
            }
            sb.append(new StringBuffer().append("<").append(lowerCase).toString());
        } else {
            if (lowerCase.equals("use") && element.hasAttribute("xlink:href")) {
                String attribute3 = element.getAttribute("xlink:href");
                if (attribute3.startsWith("#") && (element2 = this.f18229p.get(attribute3.substring(1))) != null) {
                    NamedNodeMap attributes = element.getAttributes();
                    for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                        element2.setAttribute(attributes.item(i2).getNodeName(), attributes.item(i2).getNodeValue());
                    }
                    return m18829a(element2, i);
                }
                return "";
            }
            return "";
        }
        sb.append(m18841b(element, i + 1));
        if (childNodes.getLength() == 0) {
            if (sb2.length() > 0 || this.f18232s.length() > 0) {
                if (sb2.length() > 0) {
                    sb.append(">");
                    sb.append((CharSequence) sb2);
                    sb2.setLength(0);
                    sb2.trimToSize();
                }
                if (this.f18232s.length() > 0) {
                    sb.append(">");
                    sb.append((CharSequence) this.f18232s);
                    this.f18232s.setLength(0);
                    this.f18232s.trimToSize();
                }
                sb.append(m18839b(i));
                sb.append("</");
                sb.append(lowerCase);
                sb.append(">");
            } else {
                sb.append(" />");
            }
        } else {
            sb.append(">");
            if (sb2.length() > 0) {
                sb.append((CharSequence) sb2);
                sb2.setLength(0);
                sb2.trimToSize();
            }
            if (this.f18232s.length() > 0) {
                sb.append((CharSequence) this.f18232s);
                this.f18232s.setLength(0);
                this.f18232s.trimToSize();
            }
            for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
                Node item = childNodes.item(i3);
                if (item.getNodeType() == 1) {
                    sb.append(m18829a((Element) item, i + 1));
                }
            }
            sb.append(m18839b(i));
            if (lowerCase.equals("clippath")) {
                sb.append("</clip-path>");
            } else if (lowerCase.equals("g")) {
                sb.append("</group>");
            } else {
                sb.append(new StringBuffer().append(new StringBuffer().append("</").append(lowerCase).toString()).append(">").toString());
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String m18841b(Element element, int i) {
        StringBuilder sb = new StringBuilder();
        m18842b(element, sb, i);
        m18847c(element, sb, i);
        m18834a(element, sb, i);
        return sb.toString();
    }

    /* renamed from: a */
    private void m18834a(Element element, StringBuilder sb, int i) {
        String[] strArr = {DateFormat.DAY, "fill-rule", "fill-opacity", "stroke-width", "stroke-linejoin", "stroke-linecap", "stroke-miterlimit", "stroke-opacity"};
        String[] strArr2 = {"pathData", "fillType", "fillAlpha", "strokeWidth", "strokeLineJoin", "strokeLineCap", "strokeMiterLimit", "strokeAlpha"};
        String nodeName = element.getNodeName();
        NamedNodeMap attributes = element.getAttributes();
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String nodeName2 = attributes.item(i2).getNodeName();
            String nodeValue = attributes.item(i2).getNodeValue();
            if (nodeName2 != null && nodeValue != null && (!nodeName2.equals(DateFormat.DAY) || (!nodeName.equals("rect") && !nodeName.equals("circle") && !nodeName.equals("ellipse") && !nodeName.equals("line") && !nodeName.equals("polygon") && !nodeName.equals("polyline")))) {
                int i3 = 0;
                while (true) {
                    if (i3 >= strArr.length) {
                        break;
                    }
                    if (!nodeName2.equals(strArr[i3])) {
                        i3++;
                    } else {
                        sb.append(m18839b(i));
                        if (nodeName2.equals("fill-rule")) {
                            if (nodeValue.equals("evenodd")) {
                                nodeValue = "evenOdd";
                            } else {
                                nodeValue = "nonZero";
                            }
                        }
                        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18215b).append(strArr2[i3]).toString()).append("=\"").toString()).append(nodeValue.trim()).toString()).append("\"").toString());
                    }
                }
                if (nodeName2.equals("style")) {
                    for (String str : nodeValue.split(";")) {
                        String[] split = str.split(":");
                        if (split.length == 2) {
                            String trim = split[0].trim();
                            String trim2 = split[1].trim();
                            int i4 = 0;
                            while (true) {
                                if (i4 >= strArr.length) {
                                    break;
                                }
                                if (!trim.equals(strArr[i4])) {
                                    i4++;
                                } else {
                                    m18832a(sb, Pattern.compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+").append(this.f18215b).toString()).append(strArr2[i4]).toString()).append("=\"[^\"]*\"").toString()));
                                    sb.append(m18839b(i));
                                    if (trim.equals("fill-rule")) {
                                        if (trim2.equals("evenodd")) {
                                            trim2 = "evenOdd";
                                        } else {
                                            trim2 = "nonZero";
                                        }
                                    }
                                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18215b).append(strArr2[i4]).toString()).append("=\"").toString()).append(trim2).toString()).append("\"").toString());
                                }
                            }
                            if (trim.equals("fill") || trim.equals("stroke")) {
                                m18831a(trim, trim2, sb, i);
                            } else if (trim.equals("opacity")) {
                                m18832a(sb, Pattern.compile(new StringBuffer().append(new StringBuffer().append("\\s+").append(this.f18215b).toString()).append("(fillAlpha|strokeAlpha)=\"[^\"]*\"").toString()));
                                sb.append(m18839b(i));
                                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18215b).append("fillAlpha=\"").toString()).append(trim2).toString()).append("\"").toString());
                                sb.append(m18839b(i));
                                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(this.f18215b).append("strokeAlpha=\"").toString()).append(trim2).toString()).append("\"").toString());
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m18842b(Element element, StringBuilder sb, int i) {
        if (element.hasAttribute("transform")) {
            String attribute = element.getAttribute("transform");
            Matcher matcher = Pattern.compile("translate\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
            if (matcher.find()) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("translateX=\"").toString()).append(m18851e(matcher.group(1))).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("translateY=\"").toString()).append(m18851e(matcher.group(2))).toString()).append("\"").toString());
            } else {
                Matcher matcher2 = Pattern.compile("translate\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
                if (matcher2.find()) {
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("translateX=\"").toString()).append(m18851e(matcher2.group(1))).toString()).append("\"").toString());
                    sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("translateY=\"0.0\"").toString());
                }
            }
            Matcher matcher3 = Pattern.compile("scale\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
            if (matcher3.find()) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("scaleX=\"").toString()).append(m18851e(matcher3.group(1))).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("scaleY=\"").toString()).append(m18851e(matcher3.group(2))).toString()).append("\"").toString());
            } else {
                Matcher matcher4 = Pattern.compile("scale\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
                if (matcher4.find()) {
                    float m18851e = m18851e(matcher4.group(1));
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("scaleX=\"").toString()).append(m18851e).toString()).append("\"").toString());
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("scaleY=\"").toString()).append(m18851e).toString()).append("\"").toString());
                }
            }
            Matcher matcher5 = Pattern.compile("rotate\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
            if (matcher5.find()) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("rotation=\"").toString()).append(m18851e(matcher5.group(1))).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("pivotX=\"").toString()).append(m18851e(matcher5.group(2))).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("pivotY=\"").toString()).append(m18851e(matcher5.group(3))).toString()).append("\"").toString());
            } else {
                Matcher matcher6 = Pattern.compile("rotate\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
                if (matcher6.find()) {
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("rotation=\"").toString()).append(m18851e(matcher6.group(1))).toString()).append("\"").toString());
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("pivotX=\"").toString()).append(m18851e(matcher6.group(2))).toString()).append("\"").toString());
                    sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("pivotY=\"0.0\"").toString());
                } else {
                    Matcher matcher7 = Pattern.compile("rotate\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
                    if (matcher7.find()) {
                        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("rotation=\"").toString()).append(m18851e(matcher7.group(1))).toString()).append("\"").toString());
                        sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("pivotX=\"0.0\"").toString());
                        sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("pivotY=\"0.0\"").toString());
                    }
                }
            }
            Matcher matcher8 = Pattern.compile("matrix\\(([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?),?\\s*([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)\\)").matcher(attribute);
            if (matcher8.find()) {
                String[] m18837a = m18837a(new String[]{matcher8.group(1), matcher8.group(2), matcher8.group(3), matcher8.group(4), matcher8.group(5), matcher8.group(6)});
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("translateX=\"").toString()).append(m18837a[0]).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("translateY=\"").toString()).append(m18837a[1]).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("scaleX=\"").toString()).append(m18837a[2]).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("scaleY=\"").toString()).append(m18837a[3]).toString()).append("\"").toString());
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append(this.f18215b).toString()).append("rotation=\"").toString()).append(m18837a[4]).toString()).append("\"").toString());
            }
            element.removeAttribute("transform");
        }
    }

    /* renamed from: a */
    private void m18831a(String str, String str2, StringBuilder sb, int i) {
        String str3;
        Element element;
        if (str.equals("fill")) {
            str3 = "fillColor";
        } else {
            str3 = "strokeColor";
        }
        m18832a(sb, Pattern.compile(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\\s+").append(this.f18215b).toString()).append(str3).toString()).append("=\"[^\"]*\"").toString()));
        if (str2.startsWith("url(#")) {
            String substring = str2.substring(5, str2.length() - 1);
            if (this.f18228o != null && (element = this.f18228o.get(substring)) != null) {
                m18833a(element, str.equals("fill") ? "fillColor" : "strokeColor", this.f18232s, i);
                return;
            }
        }
        sb.append(m18839b(i)).append(new StringBuffer().append(new StringBuffer().append(this.f18215b).append(str3).toString()).append("=\"").toString());
        if (str2.equals(Camera.Parameters.EFFECT_NONE)) {
            sb.append("#00000000");
        } else if (str2.startsWith("#")) {
            if (str2.length() == 4 || str2.length() == 5) {
                sb.append("#");
                for (int i2 = 1; i2 < str2.length(); i2++) {
                    sb.append(str2.charAt(i2)).append(str2.charAt(i2));
                }
            } else {
                sb.append(str2);
            }
        } else if (str2.startsWith("rgb")) {
            Matcher matcher = Pattern.compile("rgb\\((\\d+),?\\s*(\\d+),?\\s*(\\d+)\\)").matcher(str2);
            if (matcher.find()) {
                sb.append(String.format("#%08x", new Integer(Color.rgb(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))) & (-1))));
            } else {
                Matcher matcher2 = Pattern.compile("rgba\\((\\d+),?\\s*(\\d+),?\\s*(\\d+),?\\s*([\\.\\d]+)\\)").matcher(str2);
                if (matcher2.find()) {
                    sb.append(String.format("#%08x", new Integer(Color.argb(m18825a(Float.parseFloat(matcher2.group(4))), Integer.parseInt(matcher2.group(1)), Integer.parseInt(matcher2.group(2)), Integer.parseInt(matcher2.group(3))) & (-1))));
                }
            }
        } else {
            sb.append(m18844c(str2));
        }
        sb.append("\"");
    }

    /* renamed from: c */
    private void m18847c(Element element, StringBuilder sb, int i) {
        if (element.hasAttribute("fill")) {
            m18831a("fill", element.getAttribute("fill"), sb, i);
            element.removeAttribute("fill");
        }
        if (element.hasAttribute("stroke")) {
            m18831a("stroke", element.getAttribute("stroke"), sb, i);
            element.removeAttribute("stroke");
        }
    }

    /* renamed from: c */
    private String m18846c(Element element, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(m18839b(i));
        NodeList childNodes = element.getChildNodes();
        m18866j(element);
        String lowerCase = element.getNodeName().toLowerCase();
        if (lowerCase.equals("clip-path")) {
            return m18865j(element, i);
        }
        if (lowerCase.equals(WifiConfiguration.GroupCipher.varName)) {
            sb.append("<g");
        } else {
            if (lowerCase.equals("aapt:attr")) {
                return "";
            }
            sb.append(new StringBuffer().append("<").append(lowerCase).toString());
        }
        sb.append(m18849d(element, i + 1));
        if (childNodes.getLength() == 0) {
            sb.append(" />");
        } else {
            sb.append(">");
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= childNodes.getLength()) {
                    break;
                }
                Node item = childNodes.item(i3);
                if (item.getNodeType() == 1) {
                    sb.append(m18846c((Element) item, i + 1));
                }
                i2 = i3 + 1;
            }
            sb.append(m18839b(i));
            if (lowerCase.equals(WifiConfiguration.GroupCipher.varName)) {
                sb.append("</g>");
            } else {
                sb.append(new StringBuffer().append(new StringBuffer().append("</").append(lowerCase).toString()).append(">").toString());
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    private String m18849d(Element element, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(m18855f(element, i));
        try {
            sb.append(m18857g(element, i));
        } catch (Exception e2) {
        }
        sb.append(m18860h(element, i));
        sb.append(m18853e(element, i));
        return sb.toString();
    }

    /* renamed from: e */
    private String m18853e(Element element, int i) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        String[] strArr = {"pathData", "fillType", "fillAlpha", "strokeWidth", "strokeLineJoin", "strokeLineCap", "strokeMiterLimit", "strokeAlpha", "trimPathStart", "trimPathEnd", "trimPathOffset"};
        String[] strArr2 = {DateFormat.DAY, "fill-rule", "fill-opacity", "stroke-width", "stroke-linejoin", "stroke-linecap", "stroke-miterlimit", "stroke-opacity", (String) null, (String) null, (String) null};
        NamedNodeMap attributes = element.getAttributes();
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String nodeName = attributes.item(i2).getNodeName();
            String nodeValue = attributes.item(i2).getNodeValue();
            if (nodeName != null && nodeValue != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= strArr.length) {
                        z = false;
                        break;
                    }
                    if (!nodeName.equals(new StringBuffer().append(this.f18215b).append(strArr[i3]).toString())) {
                        i3++;
                    } else {
                        if (strArr2[i3] != null) {
                            sb.append(m18839b(i));
                            if (strArr[i3].equals("pathData") && nodeValue.startsWith("@string/")) {
                                nodeValue = m18826a(nodeValue);
                            }
                            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(strArr2[i3]).append("=\"").toString()).append(strArr[i3].equals("fillType") ? nodeValue.toLowerCase() : nodeValue).toString()).append("\"").toString());
                        }
                        z = true;
                    }
                }
                if (!z) {
                    String substring = nodeName.startsWith(this.f18215b) ? nodeName.substring(this.f18215b.length()) : nodeName;
                    sb.append(m18839b(i));
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(substring).append("=\"").toString()).append(nodeValue).toString()).append("\"").toString());
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: f */
    private String m18855f(Element element, int i) {
        StringBuilder sb = new StringBuilder();
        if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("translateX").toString()) || element.hasAttribute(new StringBuffer().append(this.f18215b).append("translateY").toString())) {
            String str = "0";
            String str2 = "0";
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("translateX").toString())) {
                str = element.getAttribute(new StringBuffer().append(this.f18215b).append("translateX").toString());
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("translateX").toString());
            }
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("translateY").toString())) {
                str2 = element.getAttribute(new StringBuffer().append(this.f18215b).append("translateY").toString());
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("translateY").toString());
            }
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(" translate(").append(str.toLowerCase().replaceAll("[a-z]+", "")).toString()).append(" ").toString()).append(str2.toLowerCase().replaceAll("[a-z]+", "")).toString()).append(")").toString());
        }
        if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("scaleX").toString()) || element.hasAttribute(new StringBuffer().append(this.f18215b).append("scaleY").toString())) {
            String str3 = "0";
            String str4 = "0";
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("scaleX").toString())) {
                str3 = element.getAttribute(new StringBuffer().append(this.f18215b).append("scaleX").toString());
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("scaleX").toString());
            }
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("scaleY").toString())) {
                str4 = element.getAttribute(new StringBuffer().append(this.f18215b).append("scaleY").toString());
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("scaleY").toString());
            }
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(" scale(").append(str3.toLowerCase().replaceAll("[a-z]+", "")).toString()).append(" ").toString()).append(str4.toLowerCase().replaceAll("[a-z]+", "")).toString()).append(")").toString());
        }
        if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("rotation").toString()) || element.hasAttribute(new StringBuffer().append(this.f18215b).append("pivotX").toString()) || element.hasAttribute(new StringBuffer().append(this.f18215b).append("pivotY").toString())) {
            String str5 = "0";
            String str6 = "0";
            String str7 = "0";
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("rotation").toString())) {
                str5 = element.getAttribute(new StringBuffer().append(this.f18215b).append("rotation").toString());
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("rotation").toString());
            }
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("pivotX").toString())) {
                str6 = element.getAttribute(new StringBuffer().append(this.f18215b).append("pivotX").toString());
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("pivotX").toString());
            }
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("pivotY").toString())) {
                str7 = element.getAttribute(new StringBuffer().append(this.f18215b).append("pivotY").toString());
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("pivotY").toString());
            }
            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(" rotate(").append(str5.toLowerCase().replaceAll("[a-z]+", "")).toString()).append(" ").toString()).append(str6.toLowerCase().replaceAll("[a-z]+", "")).toString()).append(" ").toString()).append(str7.toLowerCase().replaceAll("[a-z]+", "")).toString()).append(")").toString());
        }
        return sb.length() == 0 ? "" : new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i)).append("transform=\"").toString()).append(sb.toString().substring(1)).toString()).append("\"").toString();
    }

    /* renamed from: g */
    private String m18857g(Element element, int i) {
        float f2;
        StringBuilder sb = new StringBuilder();
        if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("trimPathStart").toString()) || element.hasAttribute(new StringBuffer().append(this.f18215b).append("trimPathEnd").toString())) {
            float f3 = 0.0f;
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("trimPathStart").toString())) {
                f3 = Float.parseFloat(element.getAttribute(new StringBuffer().append(this.f18215b).append("trimPathStart").toString()));
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("trimPathStart").toString());
            }
            if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("trimPathEnd").toString())) {
                f2 = Float.parseFloat(element.getAttribute(new StringBuffer().append(this.f18215b).append("trimPathEnd").toString()));
                element.removeAttribute(new StringBuffer().append(this.f18215b).append("trimPathEnd").toString());
            } else {
                f2 = 1.0f;
            }
            if (f3 <= f2) {
                sb.append(m18839b(i)).append("pathLength=\"1\"");
                sb.append(m18839b(i)).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("stroke-dasharray=\"0.0 ").append(String.valueOf(f3)).toString()).append(" ").toString()).append(String.valueOf(f2 - f3)).toString()).append(" ").toString()).append(String.valueOf(1.0f - f2)).toString()).append("\"").toString());
                if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("trimPathOffset").toString())) {
                    String attribute = element.getAttribute(new StringBuffer().append(this.f18215b).append("trimPathOffset").toString());
                    element.removeAttribute(new StringBuffer().append(this.f18215b).append("trimPathOffset").toString());
                    sb.append(m18839b(i)).append(new StringBuffer().append(new StringBuffer().append("stroke-dashoffset=\"").append(attribute).toString()).append("\"").toString());
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: h */
    private String m18860h(Element element, int i) {
        StringBuilder sb = new StringBuilder();
        if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("fillColor").toString())) {
            String attribute = element.getAttribute(new StringBuffer().append(this.f18215b).append("fillColor").toString());
            sb.append(m18839b(i));
            sb.append("fill=\"");
            if (attribute.equals("#00000000")) {
                sb.append(Camera.Parameters.EFFECT_NONE);
            } else if (attribute.startsWith("#")) {
                int[] m18850d = m18850d(attribute);
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d[1]).toString()).append(",").toString()).append(m18850d[2]).toString()).append(",").toString()).append(m18850d[3]).toString()).append(")").toString());
                if (!element.hasAttribute(new StringBuffer().append(this.f18215b).append("fillAlpha").toString())) {
                    sb.append("\"");
                    sb.append(m18839b(i));
                    sb.append(new StringBuffer().append("fill-opacity=\"").append(m18824a(m18850d[0])).toString());
                }
            } else if (attribute.startsWith("@android:color/")) {
                int identifier = this.f18218e.getResources().getIdentifier(attribute.split("/", 2)[1], "color", "android");
                if (identifier > 0) {
                    int[] m18850d2 = m18850d(String.format("#%08x", new Integer(C3246h.m19470a(this.f18218e, identifier) & (-1))));
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d2[1]).toString()).append(",").toString()).append(m18850d2[2]).toString()).append(",").toString()).append(m18850d2[3]).toString()).append(")").toString());
                    if (!element.hasAttribute(new StringBuffer().append(this.f18215b).append("fillAlpha").toString())) {
                        sb.append("\"");
                        sb.append(m18839b(i));
                        sb.append(new StringBuffer().append("fill-opacity=\"").append(m18824a(m18850d2[0])).toString());
                    }
                } else {
                    sb.append(attribute);
                }
            } else if (attribute.startsWith("@color/") && this.f18224k != null) {
                if (this.f18225l == null) {
                    m18870a();
                }
                String m18840b = m18840b(attribute.split("/", 2)[1]);
                if (m18840b != null) {
                    int[] m18850d3 = m18850d(m18840b);
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d3[1]).toString()).append(",").toString()).append(m18850d3[2]).toString()).append(",").toString()).append(m18850d3[3]).toString()).append(")").toString());
                    if (!element.hasAttribute(new StringBuffer().append(this.f18215b).append("fillAlpha").toString())) {
                        sb.append("\"");
                        sb.append(m18839b(i));
                        sb.append(new StringBuffer().append("fill-opacity=\"").append(m18824a(m18850d3[0])).toString());
                    }
                } else {
                    sb.append(attribute);
                }
            } else {
                sb.append(attribute);
            }
            sb.append("\"");
            element.removeAttribute(new StringBuffer().append(this.f18215b).append("fillColor").toString());
        }
        if (element.hasAttribute(new StringBuffer().append(this.f18215b).append("strokeColor").toString())) {
            String attribute2 = element.getAttribute(new StringBuffer().append(this.f18215b).append("strokeColor").toString());
            sb.append(m18839b(i));
            sb.append("stroke=\"");
            if (attribute2.equals("#00000000")) {
                sb.append(Camera.Parameters.EFFECT_NONE);
            } else if (attribute2.startsWith("#")) {
                int[] m18850d4 = m18850d(attribute2);
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d4[1]).toString()).append(",").toString()).append(m18850d4[2]).toString()).append(",").toString()).append(m18850d4[3]).toString()).append(")").toString());
                if (!element.hasAttribute(new StringBuffer().append(this.f18215b).append("strokeAlpha").toString())) {
                    sb.append("\"");
                    sb.append(m18839b(i));
                    sb.append(new StringBuffer().append("stroke-opacity=\"").append(m18824a(m18850d4[0])).toString());
                }
            } else if (attribute2.startsWith("@android:color/")) {
                int identifier2 = this.f18218e.getResources().getIdentifier(attribute2.split("/", 2)[1], "color", "android");
                if (identifier2 > 0) {
                    int[] m18850d5 = m18850d(String.format("#%08x", new Integer(C3246h.m19470a(this.f18218e, identifier2) & (-1))));
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d5[1]).toString()).append(",").toString()).append(m18850d5[2]).toString()).append(",").toString()).append(m18850d5[3]).toString()).append(")").toString());
                    if (!element.hasAttribute(new StringBuffer().append(this.f18215b).append("fillAlpha").toString())) {
                        sb.append("\"");
                        sb.append(m18839b(i));
                        sb.append(new StringBuffer().append("fill-opacity=\"").append(m18824a(m18850d5[0])).toString());
                    }
                } else {
                    sb.append(attribute2);
                }
            } else if (attribute2.startsWith("@color/") && this.f18224k != null) {
                if (this.f18225l == null) {
                    m18870a();
                }
                String m18840b2 = m18840b(attribute2.split("/", 2)[1]);
                if (m18840b2 != null) {
                    int[] m18850d6 = m18850d(m18840b2);
                    sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d6[1]).toString()).append(",").toString()).append(m18850d6[2]).toString()).append(",").toString()).append(m18850d6[3]).toString()).append(")").toString());
                    if (!element.hasAttribute(new StringBuffer().append(this.f18215b).append("fillAlpha").toString())) {
                        sb.append("\"");
                        sb.append(m18839b(i));
                        sb.append(new StringBuffer().append("fill-opacity=\"").append(m18824a(m18850d6[0])).toString());
                    }
                } else {
                    sb.append(attribute2);
                }
            } else {
                sb.append(attribute2);
            }
            sb.append("\"");
            element.removeAttribute(new StringBuffer().append(this.f18215b).append("strokeColor").toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private String m18826a(String str) {
        if (this.f18224k != null) {
            if (this.f18226m == null) {
                m18873b();
                if (this.f18226m == null) {
                    return str;
                }
            }
            String str2 = this.f18226m.get(str.split("/", 2)[1]);
            return str2 != null ? str2 : str;
        }
        return str;
    }

    /* renamed from: b */
    private String m18840b(String str) {
        if (this.f18225l == null) {
            return (String) null;
        }
        String str2 = this.f18225l.get(str);
        if (str2 != null) {
            if (str2.startsWith("@android:color/")) {
                int identifier = this.f18218e.getResources().getIdentifier(str2.split("/", 2)[1], "color", "android");
                if (identifier > 0) {
                    return String.format("#%08x", new Integer(C3246h.m19470a(this.f18218e, identifier) & (-1)));
                }
                return (String) null;
            }
            if (str2.startsWith("@color/")) {
                String[] split = str2.split("/", 2);
                if (split[1].equals(str)) {
                    return (String) null;
                }
                return m18840b(split[1]);
            }
            if (str2.matches("^#[A-Fa-f0-9]{3,8}$")) {
                return str2;
            }
        }
        return (String) null;
    }

    /* renamed from: c */
    private String m18844c(String str) {
        String m19471a = C3246h.m19471a(str.toLowerCase());
        return m19471a != null ? m19471a.toLowerCase() : "#ff000000";
    }

    /* renamed from: d */
    private int[] m18850d(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            if (str.length() == 4 || str.length() == 5) {
                sb.append("#");
                for (int i = 1; i < str.length(); i++) {
                    sb.append(str.charAt(i)).append(str.charAt(i));
                }
            } else {
                sb.append(str);
            }
            int parseColor = Color.parseColor(sb.toString());
            return new int[]{Color.alpha(parseColor), Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor)};
        } catch (Exception e2) {
            return new int[]{255, 0, 0, 0};
        }
    }

    /* renamed from: a */
    private float m18824a(int i) {
        return i / 255.0f;
    }

    /* renamed from: a */
    private int m18825a(float f2) {
        return (int) (255.0f * f2);
    }

    /* renamed from: b */
    private String m18839b(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        while (i > 0) {
            sb.append("\t");
            i--;
        }
        return sb.toString();
    }

    /* renamed from: e */
    private float m18851e(String str) {
        return m18823a(Float.parseFloat(str), 12);
    }

    /* renamed from: b */
    private float m18838b(float f2) {
        return m18823a(f2, 12);
    }

    /* renamed from: a */
    private float m18823a(float f2, int i) {
        return new BigDecimal(f2, new MathContext(i)).floatValue();
    }

    /* renamed from: a */
    private float[] m18836a(String[] strArr, int[] iArr) {
        return new float[]{(iArr[0] * Float.parseFloat(strArr[0])) + (iArr[1] * Float.parseFloat(strArr[2])) + 0, (iArr[0] * Float.parseFloat(strArr[1])) + (iArr[1] * Float.parseFloat(strArr[3])) + 0};
    }

    /* renamed from: a */
    private String[] m18837a(String[] strArr) {
        float[] m18836a = m18836a(strArr, new int[]{0, 1});
        float[] m18836a2 = m18836a(strArr, new int[]{1, 0});
        return new String[]{strArr[4], strArr[5], String.valueOf(Math.sqrt((Float.parseFloat(strArr[0]) * Float.parseFloat(strArr[0])) + (Float.parseFloat(strArr[1]) * Float.parseFloat(strArr[1])))), String.valueOf(Math.sqrt((Float.parseFloat(strArr[2]) * Float.parseFloat(strArr[2])) + (Float.parseFloat(strArr[3]) * Float.parseFloat(strArr[3])))), String.valueOf((float) ((Math.atan2(m18836a[1], m18836a[0]) * 57.29577951308232d) - 90)), String.valueOf((float) (Math.atan2(m18836a2[1], m18836a2[0]) * 57.29577951308232d))};
    }

    /* renamed from: c */
    private String m18845c(Element element) {
        String str;
        String str2;
        String str3;
        String str4;
        if (element.hasAttribute("x1")) {
            String attribute = element.getAttribute("x1");
            element.removeAttribute("x1");
            str = attribute;
        } else {
            str = (String) null;
        }
        if (element.hasAttribute("x2")) {
            String attribute2 = element.getAttribute("x2");
            element.removeAttribute("x2");
            str2 = attribute2;
        } else {
            str2 = (String) null;
        }
        if (element.hasAttribute("y1")) {
            str3 = element.getAttribute("y1");
            element.removeAttribute("y1");
        } else {
            str3 = (String) null;
        }
        if (element.hasAttribute("y2")) {
            str4 = element.getAttribute("y2");
            element.removeAttribute("y2");
        } else {
            str4 = (String) null;
        }
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return "";
        }
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("M ").append(str).toString()).append(" ").toString()).append(str3).toString()).append(" ").toString()).append("L ").toString()).append(str2).toString()).append(" ").toString()).append(str4).toString();
    }

    /* renamed from: d */
    private String m18848d(Element element) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        if (element.hasAttribute("x")) {
            f2 = Float.parseFloat(element.getAttribute("x"));
            element.removeAttribute("x");
        } else {
            f2 = 0;
        }
        if (element.hasAttribute(DateFormat.YEAR)) {
            f3 = Float.parseFloat(element.getAttribute(DateFormat.YEAR));
            element.removeAttribute(DateFormat.YEAR);
        } else {
            f3 = 0;
        }
        if (element.hasAttribute("width")) {
            f4 = Float.parseFloat(element.getAttribute("width"));
            element.removeAttribute("width");
        } else {
            f4 = 0;
        }
        if (element.hasAttribute("height")) {
            f5 = Float.parseFloat(element.getAttribute("height"));
            element.removeAttribute("height");
        } else {
            f5 = 0;
        }
        if (element.hasAttribute("rx")) {
            f6 = Float.parseFloat(element.getAttribute("rx"));
            element.removeAttribute("rx");
        } else {
            f6 = 0;
        }
        if (element.hasAttribute("ry")) {
            f7 = Float.parseFloat(element.getAttribute("ry"));
            element.removeAttribute("ry");
        } else {
            f7 = 0;
        }
        float m18838b = m18838b(f2 + f4);
        float m18838b2 = m18838b(f3 + f5);
        if (f7 == 0) {
            f8 = f6;
            f9 = f6;
        } else if (f6 == 0) {
            f8 = f7;
            f9 = f7;
        } else {
            f8 = f7;
            f9 = f6;
        }
        float m18838b3 = f9 > f4 / ((float) 2) ? m18838b(f4 / 2) : f9;
        float m18838b4 = f8 > f5 / ((float) 2) ? m18838b(f5 / 2) : f8;
        if (m18838b3 == 0 && m18838b4 == 0) {
            return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("M ").append(f2).toString()).append(" ").toString()).append(f3).toString()).append(" H ").toString()).append(m18838b(f4 + f2)).toString()).append(" V ").toString()).append(m18838b(f5 + f3)).toString()).append(" H ").toString()).append(f2).toString()).append(" V ").toString()).append(f3).toString()).append(" Z").toString();
        }
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("M ").append(m18838b(f2 + m18838b3)).toString()).append(" ").toString()).append(f3).toString()).append(" ").toString()).append("L ").toString()).append(m18838b(m18838b - m18838b3)).toString()).append(" ").toString()).append(f3).toString()).append(" ").toString()).append("A ").toString()).append(m18838b3).toString()).append(" ").toString()).append(m18838b4).toString()).append(" 0 0,1 ").toString()).append(m18838b).toString()).append(" ").toString()).append(m18838b(f3 + m18838b4)).toString()).append(" ").toString()).append("L ").toString()).append(m18838b).toString()).append(" ").toString()).append(m18838b((f5 + f3) - m18838b4)).toString()).append(" ").toString()).append("A ").toString()).append(m18838b3).toString()).append(" ").toString()).append(m18838b4).toString()).append(" 0 0,1 ").toString()).append(m18838b(m18838b - m18838b3)).toString()).append(" ").toString()).append(m18838b2).toString()).append(" ").toString()).append("L ").toString()).append(m18838b(f2 + m18838b3)).toString()).append(" ").toString()).append(m18838b2).toString()).append(" ").toString()).append("A ").toString()).append(m18838b3).toString()).append(" ").toString()).append(m18838b4).toString()).append(" 0 0,1 ").toString()).append(f2).toString()).append(" ").toString()).append(m18838b(m18838b2 - m18838b4)).toString()).append(" ").toString()).append("L ").toString()).append(f2).toString()).append(" ").toString()).append(m18838b(f3 + m18838b4)).toString()).append(" ").toString()).append("A ").toString()).append(m18838b3).toString()).append(" ").toString()).append(m18838b4).toString()).append(" 0 0,1 ").toString()).append(m18838b(f2 + m18838b3)).toString()).append(" ").toString()).append(f3).toString()).append(" ").toString()).append("Z").toString();
    }

    /* renamed from: e */
    private String m18852e(Element element) {
        float f2;
        float f3;
        float f4;
        if (element.hasAttribute("cx")) {
            f2 = Float.parseFloat(element.getAttribute("cx"));
            element.removeAttribute("cx");
        } else {
            f2 = 0;
        }
        if (element.hasAttribute("cy")) {
            f3 = Float.parseFloat(element.getAttribute("cy"));
            element.removeAttribute("cy");
        } else {
            f3 = 0;
        }
        if (element.hasAttribute("r")) {
            f4 = Float.parseFloat(element.getAttribute("r"));
            element.removeAttribute("r");
        } else {
            f4 = 0;
        }
        float m18838b = m18838b(0.5522848f * f4);
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("M ").append(f2).toString()).append(" ").toString()).append(m18838b(f3 - f4)).toString()).append(" ").toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 + m18838b)).toString()).append(" ").toString()).append(m18838b(f3 - f4)).toString()).append(" ").toString()).append(m18838b(f2 + f4)).toString()).append(" ").toString()).append(m18838b(f3 - m18838b)).toString()).append(" ").toString()).append(m18838b(f2 + f4)).toString()).append(" ").toString()).append(f3).toString()).append(" ").toString()).toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 + f4)).toString()).append(" ").toString()).append(m18838b(f3 + m18838b)).toString()).append(" ").toString()).append(m18838b(f2 + m18838b)).toString()).append(" ").toString()).append(m18838b(f3 + f4)).toString()).append(" ").toString()).append(f2).toString()).append(" ").toString()).append(m18838b(f3 + f4)).toString()).append(" ").toString()).toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 - m18838b)).toString()).append(" ").toString()).append(m18838b(f3 + f4)).toString()).append(" ").toString()).append(m18838b(f2 - f4)).toString()).append(" ").toString()).append(m18838b(f3 + m18838b)).toString()).append(" ").toString()).append(m18838b(f2 - f4)).toString()).append(" ").toString()).append(f3).toString()).append(" ").toString()).toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 - f4)).toString()).append(" ").toString()).append(m18838b(f3 - m18838b)).toString()).append(" ").toString()).append(m18838b(f2 - m18838b)).toString()).append(" ").toString()).append(m18838b(f3 - f4)).toString()).append(" ").toString()).append(f2).toString()).append(" ").toString()).append(m18838b(f3 - f4)).toString()).append(" ").toString()).toString()).append("Z").toString();
    }

    /* renamed from: f */
    private String m18854f(Element element) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (element.hasAttribute("cx")) {
            f2 = Float.parseFloat(element.getAttribute("cx"));
            element.removeAttribute("cx");
        } else {
            f2 = 0;
        }
        if (element.hasAttribute("cy")) {
            f3 = Float.parseFloat(element.getAttribute("cy"));
            element.removeAttribute("cy");
        } else {
            f3 = 0;
        }
        if (element.hasAttribute("rx")) {
            f4 = Float.parseFloat(element.getAttribute("rx"));
            element.removeAttribute("rx");
        } else {
            f4 = 0;
        }
        if (element.hasAttribute("ry")) {
            f5 = Float.parseFloat(element.getAttribute("ry"));
            element.removeAttribute("ry");
        } else {
            f5 = 0;
        }
        float m18838b = m18838b(0.5522848f * f4);
        float m18838b2 = m18838b(0.5522848f * f5);
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("M ").append(f2).toString()).append(" ").toString()).append(m18838b(f3 - f5)).toString()).append(" ").toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 + m18838b)).toString()).append(" ").toString()).append(m18838b(f3 - f5)).toString()).append(" ").toString()).append(m18838b(f2 + f4)).toString()).append(" ").toString()).append(m18838b(f3 - m18838b2)).toString()).append(" ").toString()).append(m18838b(f2 + f4)).toString()).append(" ").toString()).append(f3).toString()).append(" ").toString()).toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 + f4)).toString()).append(" ").toString()).append(m18838b(f3 + m18838b2)).toString()).append(" ").toString()).append(m18838b(f2 + m18838b)).toString()).append(" ").toString()).append(m18838b(f3 + f5)).toString()).append(" ").toString()).append(f2).toString()).append(" ").toString()).append(m18838b(f3 + f5)).toString()).append(" ").toString()).toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 - m18838b)).toString()).append(" ").toString()).append(m18838b(f3 + f5)).toString()).append(" ").toString()).append(m18838b(f2 - f4)).toString()).append(" ").toString()).append(m18838b(f3 + m18838b2)).toString()).append(" ").toString()).append(m18838b(f2 - f4)).toString()).append(" ").toString()).append(f3).toString()).append(" ").toString()).toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("C ").append(m18838b(f2 - f4)).toString()).append(" ").toString()).append(m18838b(f3 - m18838b2)).toString()).append(" ").toString()).append(m18838b(f2 - m18838b)).toString()).append(" ").toString()).append(m18838b(f3 - f5)).toString()).append(" ").toString()).append(f2).toString()).append(" ").toString()).append(m18838b(f3 - f5)).toString()).append(" ").toString()).toString()).append("Z").toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private String m18830a(Element element, boolean z) {
        int i = 0;
        if (!element.hasAttribute("points")) {
            return "";
        }
        String attribute = element.getAttribute("points");
        element.removeAttribute("points");
        String[] split = attribute != null ? attribute.split(",") : new String[0];
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            String[] split2 = str.split(" ");
            for (int i2 = 0; i2 < split2.length; i2++) {
                if (split2[i2].length() > 0) {
                    arrayList.add(split2[i2]);
                }
            }
        }
        if (arrayList.size() % 2 == 0) {
            String str2 = "";
            while (i < arrayList.size()) {
                str2 = new StringBuffer().append(new StringBuffer().append(str2).append(i == 0 ? "M " : "L ").toString()).append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append((String) arrayList.get(i)).append(" ").toString()).append((String) arrayList.get(i + 1)).toString()).append(" ").toString()).toString();
                i += 2;
            }
            if (!z) {
                return new StringBuffer().append(str2).append("Z").toString();
            }
            return str2;
        }
        return "";
    }

    /* renamed from: i */
    private String m18863i(Element element, int i) {
        StringBuilder sb = new StringBuilder();
        String attribute = element.getAttribute("id");
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        NodeList childNodes = element.getChildNodes();
        String str = (String) null;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childNodes.getLength()) {
                break;
            }
            Node item = childNodes.item(i3);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getNodeName().toLowerCase().equals("path")) {
                    str = element2.getAttribute(DateFormat.DAY);
                    break;
                }
            }
            i2 = i3 + 1;
        }
        if (str == null || str.isEmpty()) {
            return "";
        }
        sb.append(m18839b(i)).append("<clip-path").append(m18839b(i + 1)).append(new StringBuffer().append(this.f18215b).append("pathData=\"").toString()).append(str).append("\"/>");
        return sb.toString();
    }

    /* renamed from: j */
    private String m18865j(Element element, int i) {
        StringBuilder sb = new StringBuilder();
        String attribute = element.getAttribute(new StringBuffer().append(this.f18215b).append("pathData").toString());
        if (attribute == null || attribute.isEmpty()) {
            return "";
        }
        sb.append(m18839b(i)).append("<clipPath>");
        sb.append(m18839b(i + 1)).append("<path");
        sb.append(m18839b(i + 2)).append("d=\"").append(attribute).append("\">");
        sb.append(m18839b(i + 1)).append("</path>");
        sb.append(m18839b(i)).append("</clipPath>");
        return sb.toString();
    }

    /* renamed from: m */
    private void m18867m() {
        this.f18228o = new HashMap();
        NodeList elementsByTagName = this.f18221h.getElementsByTagName("*");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= elementsByTagName.getLength()) {
                return;
            }
            Node item = elementsByTagName.item(i2);
            if (item.getNodeType() == 1) {
                Element element = (Element) item;
                String nodeName = element.getNodeName();
                if ((nodeName.equals("linearGradient") || nodeName.equals("radialGradient")) && element.hasAttribute("id")) {
                    this.f18228o.put(element.getAttribute("id"), element);
                }
            }
            i = i2 + 1;
        }
    }

    /* renamed from: n */
    private void m18868n() {
        this.f18227n = new HashMap();
        NodeList elementsByTagName = this.f18221h.getElementsByTagName("clipPath");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item.getNodeType() == 1) {
                Element element = (Element) item;
                if (element.hasAttribute("id")) {
                    this.f18227n.put(element.getAttribute("id"), element);
                }
            }
        }
        NodeList elementsByTagName2 = this.f18221h.getElementsByTagName("mask");
        for (int i2 = 0; i2 < elementsByTagName2.getLength(); i2++) {
            Node item2 = elementsByTagName2.item(i2);
            if (item2.getNodeType() == 1) {
                Element element2 = (Element) item2;
                if (element2.hasAttribute("id") && m18872a(element2)) {
                    this.f18227n.put(element2.getAttribute("id"), element2);
                }
            }
        }
    }

    /* renamed from: o */
    private void m18869o() {
        this.f18229p = new HashMap();
        NodeList elementsByTagName = this.f18221h.getElementsByTagName("defs");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            if (item.getNodeType() == 1) {
                NodeList childNodes = item.getChildNodes();
                for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                    Node item2 = childNodes.item(i2);
                    if (item2.getNodeType() == 1) {
                        Element element = (Element) item2;
                        String nodeName = element.getNodeName();
                        if (!nodeName.equals("linearGradient") && !nodeName.equals("radialGradient") && !nodeName.equals("clipPath") && element.hasAttribute("id")) {
                            this.f18229p.put(element.getAttribute("id"), element);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    boolean m18872a(Element element) {
        boolean equalsIgnoreCase = "luminance".equalsIgnoreCase(element.getAttribute("mask-type"));
        if (!equalsIgnoreCase && element.hasAttribute("style")) {
            equalsIgnoreCase = "luminance".equalsIgnoreCase(m18827a(element.getAttribute("style"), "mask-type"));
        }
        return equalsIgnoreCase && m18859g(element) && !m18862h(element);
    }

    /* renamed from: g */
    private boolean m18859g(Element element) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                String lowerCase = element2.getNodeName().toLowerCase();
                if ("g".equals(lowerCase)) {
                    if (!m18859g(element2)) {
                        return false;
                    }
                } else {
                    if (!"path".equals(lowerCase)) {
                        return false;
                    }
                    String str = (String) null;
                    if (element2.hasAttribute("fill")) {
                        str = element2.getAttribute("fill").trim();
                    } else if (element2.hasAttribute("style")) {
                        str = m18827a(element2.getAttribute("style"), "fill");
                    }
                    if (str == null || str.isEmpty()) {
                        str = "black";
                    }
                    if (Camera.Parameters.EFFECT_NONE.equalsIgnoreCase(str)) {
                        continue;
                    } else {
                        if (!m18856f(str)) {
                            return false;
                        }
                        String str2 = (String) null;
                        if (element2.hasAttribute("stroke")) {
                            str2 = element2.getAttribute("stroke").trim();
                        } else if (element2.hasAttribute("style")) {
                            str2 = m18827a(element2.getAttribute("style"), "stroke");
                        }
                        if ((str2 != null && !str2.isEmpty() && !Camera.Parameters.EFFECT_NONE.equalsIgnoreCase(str2)) || m18864i(element2)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: f */
    private boolean m18856f(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase();
        return "#fff".equals(lowerCase) || "#ffff".equals(lowerCase) || "#ffffff".equals(lowerCase) || "#ffffffff".equals(lowerCase) || "white".equals(lowerCase);
    }

    /* renamed from: h */
    private boolean m18862h(Element element) {
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (!m18864i(element2) && !m18862h(element2)) {
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private boolean m18864i(Element element) {
        if (element.hasAttribute("opacity") && m18858g(element.getAttribute("opacity"))) {
            return true;
        }
        if (element.hasAttribute("fill-opacity") && m18858g(element.getAttribute("fill-opacity"))) {
            return true;
        }
        if (element.hasAttribute("stroke-opacity") && m18858g(element.getAttribute("stroke-opacity"))) {
            return true;
        }
        if (element.hasAttribute("style")) {
            String attribute = element.getAttribute("style");
            String m18827a = m18827a(attribute, "opacity");
            if (m18827a != null && m18858g(m18827a)) {
                return true;
            }
            String m18827a2 = m18827a(attribute, "fill-opacity");
            if (m18827a2 != null && m18858g(m18827a2)) {
                return true;
            }
            String m18827a3 = m18827a(attribute, "stroke-opacity");
            if (m18827a3 != null && m18858g(m18827a3)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private boolean m18858g(String str) {
        try {
            return Float.parseFloat(str.trim()) < 1.0f;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a */
    private String m18827a(String str, String str2) {
        if (str == null) {
            return (String) null;
        }
        for (String str3 : str.split(";")) {
            int indexOf = str3.indexOf(58);
            if (indexOf != -1 && str2.equalsIgnoreCase(str3.substring(0, indexOf).trim())) {
                return str3.substring(indexOf + 1).trim();
            }
        }
        return (String) null;
    }

    /* renamed from: a */
    private void m18833a(Element element, String str, StringBuilder sb, int i) {
        float f2;
        String str2;
        float parseFloat;
        Element element2;
        sb.append(m18839b(i));
        sb.append(new StringBuffer().append("<aapt:attr name=\"").append(this.f18215b).toString());
        sb.append(str);
        sb.append("\">");
        String nodeName = element.getNodeName();
        sb.append(m18839b(i + 1));
        sb.append("<gradient");
        if (nodeName.equals("linearGradient")) {
            if (element.hasAttribute("x1")) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("startX=\"").toString()).append(element.getAttribute("x1")).toString()).append("\"").toString());
            }
            if (element.hasAttribute("y1")) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("startY=\"").toString()).append(element.getAttribute("y1")).toString()).append("\"").toString());
            }
            if (element.hasAttribute("x2")) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("endX=\"").toString()).append(element.getAttribute("x2")).toString()).append("\"").toString());
            }
            if (element.hasAttribute("y2")) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("endY=\"").toString()).append(element.getAttribute("y2")).toString()).append("\"").toString());
            }
            sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("type=\"linear\"").toString());
        } else {
            if (element.hasAttribute("cx")) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("centerX=\"").toString()).append(element.getAttribute("cx")).toString()).append("\"").toString());
            }
            if (element.hasAttribute("cy")) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("centerY=\"").toString()).append(element.getAttribute("cy")).toString()).append("\"").toString());
            }
            if (element.hasAttribute("r")) {
                sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("gradientRadius=\"").toString()).append(element.getAttribute("r")).toString()).append("\"").toString());
            }
            sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("type=\"radial\"").toString());
        }
        String attribute = element.getAttribute("spreadMethod");
        if ("repeat".equals(attribute)) {
            sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("tileMode=\"repeat\"").toString());
        } else if ("reflect".equals(attribute)) {
            sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("tileMode=\"mirror\"").toString());
        } else {
            sb.append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 2)).append(this.f18215b).toString()).append("tileMode=\"clamp\"").toString());
        }
        sb.append(">");
        NodeList childNodes = element.getChildNodes();
        if (childNodes.getLength() == 0 && element.hasAttribute("xlink:href")) {
            String attribute2 = element.getAttribute("xlink:href");
            if (attribute2.startsWith("#") && (element2 = this.f18228o.get(attribute2.substring(1))) != null) {
                childNodes = element2.getChildNodes();
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < childNodes.getLength()) {
                Node item = childNodes.item(i3);
                if (item.getNodeType() == 1) {
                    Element element3 = (Element) item;
                    if (element3.getNodeName().equals("stop")) {
                        sb.append(m18839b(i + 2));
                        sb.append("<item");
                        if (element3.hasAttribute(CallLog.Calls.OFFSET_PARAM_KEY)) {
                            String trim = element3.getAttribute(CallLog.Calls.OFFSET_PARAM_KEY).trim();
                            if (trim.endsWith("%")) {
                                parseFloat = Float.parseFloat(trim.substring(0, trim.length() - 1)) / 100.0f;
                            } else {
                                parseFloat = Float.parseFloat(trim);
                            }
                            sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 3)).append(this.f18215b).toString()).append("offset=\"").toString()).append(parseFloat).toString()).append("\"").toString());
                        }
                        String attribute3 = element3.getAttribute("stop-color");
                        if (!element3.hasAttribute("stop-opacity")) {
                            f2 = 1.0f;
                        } else {
                            f2 = Float.parseFloat(element3.getAttribute("stop-opacity"));
                        }
                        if (attribute3.startsWith("rgb")) {
                            Matcher matcher = Pattern.compile("rgb\\((\\d+),?\\s*(\\d+),?\\s*(\\d+)\\)").matcher(attribute3);
                            if (matcher.find()) {
                                str2 = String.format("#%08x", new Integer(Color.argb(m18825a(f2), Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))) & (-1)));
                            } else {
                                Matcher matcher2 = Pattern.compile("rgba\\((\\d+),?\\s*(\\d+),?\\s*(\\d+),?\\s*([\\.\\d]+)\\)").matcher(attribute3);
                                str2 = matcher2.find() ? String.format("#%08x", new Integer(Color.argb(m18825a(Float.parseFloat(matcher2.group(4))), Integer.parseInt(matcher2.group(1)), Integer.parseInt(matcher2.group(2)), Integer.parseInt(matcher2.group(3))) & (-1))) : attribute3;
                            }
                        } else if (attribute3.startsWith("#")) {
                            int[] m18850d = m18850d(attribute3);
                            str2 = String.format("#%08x", new Integer(Color.argb(m18825a(f2), m18850d[1], m18850d[2], m18850d[3]) & (-1)));
                        } else {
                            str2 = attribute3;
                        }
                        sb.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(m18839b(i + 3)).append(this.f18215b).toString()).append("color=\"").toString()).append(str2).toString()).append("\"").toString());
                        sb.append(" />");
                    }
                }
                i2 = i3 + 1;
            } else {
                sb.append(m18839b(i + 1));
                sb.append("</gradient>");
                sb.append(m18839b(i));
                sb.append("</aapt:attr>");
                return;
            }
        }
    }

    /* renamed from: j */
    private void m18866j(Element element) {
        String str;
        NodeList childNodes = element.getChildNodes();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childNodes.getLength()) {
                return;
            }
            Node item = childNodes.item(i2);
            if (item.getNodeType() == 1) {
                Element element2 = (Element) item;
                if (element2.getNodeName().equals("aapt:attr")) {
                    String attribute = element2.getAttribute("name");
                    if (attribute.equals(new StringBuffer().append(this.f18215b).append("fillColor").toString()) || attribute.equals(new StringBuffer().append(this.f18215b).append("strokeColor").toString())) {
                        NodeList childNodes2 = element2.getChildNodes();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < childNodes2.getLength()) {
                                Node item2 = childNodes2.item(i4);
                                if (item2.getNodeType() == 1) {
                                    Element element3 = (Element) item2;
                                    if (element3.getNodeName().equals("gradient")) {
                                        StringBuffer append = new StringBuffer().append("gradient_");
                                        int i5 = this.f18230q + 1;
                                        this.f18230q = i5;
                                        String stringBuffer = append.append(i5).toString();
                                        StringBuilder sb = new StringBuilder();
                                        String attribute2 = element3.getAttribute(new StringBuffer().append(this.f18215b).append("type").toString());
                                        if (attribute2 == null || attribute2.length() == 0 || attribute2.equals("linear")) {
                                            sb.append("\n\t\t<linearGradient id=\"");
                                            sb.append(stringBuffer);
                                            sb.append("\"");
                                            if (element3.hasAttribute(new StringBuffer().append(this.f18215b).append("startX").toString())) {
                                                sb.append(new StringBuffer().append(new StringBuffer().append(" x1=\"").append(element3.getAttribute(new StringBuffer().append(this.f18215b).append("startX").toString())).toString()).append("\"").toString());
                                            }
                                            if (element3.hasAttribute(new StringBuffer().append(this.f18215b).append("startY").toString())) {
                                                sb.append(new StringBuffer().append(new StringBuffer().append(" y1=\"").append(element3.getAttribute(new StringBuffer().append(this.f18215b).append("startY").toString())).toString()).append("\"").toString());
                                            }
                                            if (element3.hasAttribute(new StringBuffer().append(this.f18215b).append("endX").toString())) {
                                                sb.append(new StringBuffer().append(new StringBuffer().append(" x2=\"").append(element3.getAttribute(new StringBuffer().append(this.f18215b).append("endX").toString())).toString()).append("\"").toString());
                                            }
                                            if (element3.hasAttribute(new StringBuffer().append(this.f18215b).append("endY").toString())) {
                                                sb.append(new StringBuffer().append(new StringBuffer().append(" y2=\"").append(element3.getAttribute(new StringBuffer().append(this.f18215b).append("endY").toString())).toString()).append("\"").toString());
                                            }
                                            String attribute3 = element3.getAttribute(new StringBuffer().append(this.f18215b).append("tileMode").toString());
                                            if ("repeat".equals(attribute3)) {
                                                sb.append(" spreadMethod=\"repeat\"");
                                            } else if ("mirror".equals(attribute3)) {
                                                sb.append(" spreadMethod=\"reflect\"");
                                            }
                                            sb.append(">");
                                        } else if (attribute2.equals("radial")) {
                                            sb.append("\n\t\t<radialGradient id=\"");
                                            sb.append(stringBuffer);
                                            sb.append("\"");
                                            if (element3.hasAttribute(new StringBuffer().append(this.f18215b).append("centerX").toString())) {
                                                sb.append(new StringBuffer().append(new StringBuffer().append(" cx=\"").append(element3.getAttribute(new StringBuffer().append(this.f18215b).append("centerX").toString())).toString()).append("\"").toString());
                                            }
                                            if (element3.hasAttribute(new StringBuffer().append(this.f18215b).append("centerY").toString())) {
                                                sb.append(new StringBuffer().append(new StringBuffer().append(" cy=\"").append(element3.getAttribute(new StringBuffer().append(this.f18215b).append("centerY").toString())).toString()).append("\"").toString());
                                            }
                                            if (element3.hasAttribute(new StringBuffer().append(this.f18215b).append("gradientRadius").toString())) {
                                                sb.append(new StringBuffer().append(new StringBuffer().append(" r=\"").append(element3.getAttribute(new StringBuffer().append(this.f18215b).append("gradientRadius").toString())).toString()).append("\"").toString());
                                            }
                                            String attribute4 = element3.getAttribute(new StringBuffer().append(this.f18215b).append("tileMode").toString());
                                            if ("repeat".equals(attribute4)) {
                                                sb.append(" spreadMethod=\"repeat\"");
                                            } else if ("mirror".equals(attribute4)) {
                                                sb.append(" spreadMethod=\"reflect\"");
                                            }
                                            sb.append(">");
                                        }
                                        NodeList childNodes3 = element3.getChildNodes();
                                        int i6 = 0;
                                        while (true) {
                                            int i7 = i6;
                                            if (i7 >= childNodes3.getLength()) {
                                                break;
                                            }
                                            Node item3 = childNodes3.item(i7);
                                            if (item3.getNodeType() == 1) {
                                                Element element4 = (Element) item3;
                                                if (element4.getNodeName().equals("item")) {
                                                    sb.append("\n\t\t\t<stop");
                                                    if (element4.hasAttribute(new StringBuffer().append(this.f18215b).append(CallLog.Calls.OFFSET_PARAM_KEY).toString())) {
                                                        sb.append(new StringBuffer().append(new StringBuffer().append(" offset=\"").append(Float.parseFloat(element4.getAttribute(new StringBuffer().append(this.f18215b).append(CallLog.Calls.OFFSET_PARAM_KEY).toString())) * 100.0f).toString()).append("%\"").toString());
                                                    }
                                                    if (element4.hasAttribute(new StringBuffer().append(this.f18215b).append("color").toString())) {
                                                        String attribute5 = element4.getAttribute(new StringBuffer().append(this.f18215b).append("color").toString());
                                                        if (attribute5.startsWith("#")) {
                                                            int[] m18850d = m18850d(attribute5);
                                                            attribute5 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d[1]).toString()).append(",").toString()).append(m18850d[2]).toString()).append(",").toString()).append(m18850d[3]).toString()).append(")").toString();
                                                            str = String.valueOf(m18824a(m18850d[0]));
                                                        } else if (attribute5.startsWith("@android:color/")) {
                                                            int identifier = this.f18218e.getResources().getIdentifier(attribute5.split("/", 2)[1], "color", "android");
                                                            if (identifier > 0) {
                                                                int[] m18850d2 = m18850d(String.format("#%08x", new Integer(C3246h.m19470a(this.f18218e, identifier) & (-1))));
                                                                attribute5 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d2[1]).toString()).append(",").toString()).append(m18850d2[2]).toString()).append(",").toString()).append(m18850d2[3]).toString()).append(")").toString();
                                                                str = String.valueOf(m18824a(m18850d2[0]));
                                                            } else {
                                                                str = "1.0";
                                                            }
                                                        } else if (attribute5.startsWith("@color/") && this.f18224k != null) {
                                                            if (this.f18225l == null) {
                                                                m18870a();
                                                            }
                                                            String m18840b = m18840b(attribute5.split("/", 2)[1]);
                                                            if (m18840b != null) {
                                                                int[] m18850d3 = m18850d(m18840b);
                                                                attribute5 = new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("rgb(").append(m18850d3[1]).toString()).append(",").toString()).append(m18850d3[2]).toString()).append(",").toString()).append(m18850d3[3]).toString()).append(")").toString();
                                                                str = String.valueOf(m18824a(m18850d3[0]));
                                                            } else {
                                                                str = "1.0";
                                                            }
                                                        } else {
                                                            str = "1.0";
                                                        }
                                                        sb.append(new StringBuffer().append(new StringBuffer().append(" stop-color=\"").append(attribute5).toString()).append("\"").toString());
                                                        sb.append(new StringBuffer().append(new StringBuffer().append(" stop-opacity=\"").append(str).toString()).append("\"").toString());
                                                    }
                                                    sb.append(" />");
                                                }
                                            }
                                            i6 = i7 + 1;
                                        }
                                        if (attribute2 == null || attribute2.length() == 0 || attribute2.equals("linear")) {
                                            sb.append("\n\t\t</linearGradient>");
                                        } else {
                                            sb.append("\n\t\t</radialGradient>");
                                        }
                                        this.f18231r.add(sb.toString());
                                        if (attribute.equals(new StringBuffer().append(this.f18215b).append("fillColor").toString())) {
                                            element.setAttribute("fill", new StringBuffer().append(new StringBuffer().append("url(#").append(stringBuffer).toString()).append(")").toString());
                                            element.removeAttribute(new StringBuffer().append(this.f18215b).append("fillColor").toString());
                                        } else {
                                            element.setAttribute("stroke", new StringBuffer().append(new StringBuffer().append("url(#").append(stringBuffer).toString()).append(")").toString());
                                            element.removeAttribute(new StringBuffer().append(this.f18215b).append("strokeColor").toString());
                                        }
                                    }
                                }
                                i3 = i4 + 1;
                            }
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private void m18832a(StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(sb);
        for (int i = 0; matcher.find(i); i = matcher.start()) {
            sb.delete(matcher.start(), matcher.end());
        }
    }

    /* renamed from: a */
    private String m18828a(String str, a aVar) {
        Matcher matcher = Pattern.compile("([AaCcHhLlMmQqSsTtVvZz])|([-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?)").matcher(str);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        float f2 = 0.0f;
        float f3 = 0.0f;
        String str2 = (String) null;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group != null) {
                if (str2 != null) {
                    float[] m18835a = m18835a(sb, str2, arrayList, aVar, f3, f2);
                    f3 = m18835a[0];
                    f2 = m18835a[1];
                    arrayList.clear();
                }
                str2 = group;
            } else {
                arrayList.add(new Float(Float.parseFloat(matcher.group(2))));
            }
        }
        if (str2 != null) {
            m18835a(sb, str2, arrayList, aVar, f3, f2);
        }
        return sb.toString().trim();
    }

    /* renamed from: h */
    private a m18861h(String str) {
        a aVar = new a();
        Matcher matcher = Pattern.compile("(matrix|translate|scale|rotate)\\s*\\(([^\\)]*)\\)").matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String[] split = matcher.group(2).trim().split("[,\\s]+");
            float[] fArr = new float[split.length];
            for (int i = 0; i < split.length; i++) {
                fArr[i] = Float.parseFloat(split[i]);
            }
            a aVar2 = new a();
            if ("matrix".equals(group)) {
                if (fArr.length >= 6) {
                    aVar2.f18233a = fArr[0];
                    aVar2.f18234b = fArr[1];
                    aVar2.f18235c = fArr[2];
                    aVar2.f18236d = fArr[3];
                    aVar2.f18237e = fArr[4];
                    aVar2.f18238f = fArr[5];
                }
            } else if ("translate".equals(group)) {
                aVar2.f18237e = fArr[0];
                aVar2.f18238f = fArr.length > 1 ? fArr[1] : 0.0f;
            } else if (BatteryManager.EXTRA_SCALE.equals(group)) {
                aVar2.f18233a = fArr[0];
                aVar2.f18236d = fArr.length > 1 ? fArr[1] : fArr[0];
            } else if ("rotate".equals(group)) {
                float radians = (float) Math.toRadians(fArr[0]);
                float cos = (float) Math.cos(radians);
                float sin = (float) Math.sin(radians);
                aVar2.f18233a = cos;
                aVar2.f18234b = sin;
                aVar2.f18235c = -sin;
                aVar2.f18236d = cos;
                if (fArr.length >= 3) {
                    float f2 = fArr[1];
                    float f3 = fArr[2];
                    aVar2.f18237e = (f2 - (cos * f2)) + (sin * f3);
                    aVar2.f18238f = (f3 - (sin * f2)) - (cos * f3);
                }
            }
            aVar = aVar.m18884a(aVar2);
        }
        return aVar;
    }

    /* renamed from: a */
    private float[] m18835a(StringBuilder sb, String str, List<Float> list, a aVar, float f2, float f3) {
        int i;
        sb.append(str.toUpperCase());
        boolean isLowerCase = Character.isLowerCase(str.charAt(0));
        char upperCase = Character.toUpperCase(str.charAt(0));
        if (upperCase == 'Z') {
            sb.append(" ");
            return new float[]{f2, f3};
        }
        if (upperCase == 'A') {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 + 6 < list.size()) {
                    float floatValue = list.get(i3).floatValue();
                    float floatValue2 = list.get(i3 + 1).floatValue();
                    float floatValue3 = list.get(i3 + 2).floatValue();
                    int intValue = list.get(i3 + 3).intValue();
                    int intValue2 = list.get(i3 + 4).intValue();
                    float floatValue4 = list.get(i3 + 5).floatValue();
                    float floatValue5 = list.get(i3 + 6).floatValue();
                    if (isLowerCase) {
                        f2 += floatValue4;
                        f3 += floatValue5;
                    } else {
                        f3 = floatValue5;
                        f2 = floatValue4;
                    }
                    float[] m18885a = aVar.m18885a(f2, f3);
                    sb.append(" ").append(m18838b(((float) Math.sqrt((aVar.f18233a * aVar.f18233a) + (aVar.f18234b * aVar.f18234b))) * floatValue)).append(" ").append(m18838b(floatValue2 * ((float) Math.sqrt((aVar.f18235c * aVar.f18235c) + (aVar.f18236d * aVar.f18236d))))).append(" ").append(floatValue3).append(" ").append(intValue).append(" ").append(intValue2).append(" ").append(m18838b(m18885a[0])).append(" ").append(m18838b(m18885a[1]));
                    i2 = i3 + 7;
                } else {
                    sb.append(" ");
                    return new float[]{f2, f3};
                }
            }
        } else {
            switch (upperCase) {
                case 'C':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                    i = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                    i = 2;
                    break;
                case 'Q':
                case 'S':
                    i = 4;
                    break;
                default:
                    i = 2;
                    break;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < list.size()) {
                    if (upperCase == 'H') {
                        float floatValue6 = list.get(i5).floatValue();
                        if (isLowerCase) {
                            floatValue6 += f2;
                        }
                        sb.append(" ").append(m18838b(aVar.m18885a(floatValue6, f3)[0]));
                        f2 = floatValue6;
                    } else if (upperCase == 'V') {
                        float floatValue7 = list.get(i5).floatValue();
                        if (isLowerCase) {
                            floatValue7 += f3;
                        }
                        sb.append(" ").append(m18838b(aVar.m18885a(f2, floatValue7)[1]));
                        f3 = floatValue7;
                    } else {
                        int i6 = 0;
                        float f4 = f3;
                        float f5 = f2;
                        while (i6 < i) {
                            float floatValue8 = list.get(i5 + i6).floatValue();
                            float floatValue9 = list.get(i5 + i6 + 1).floatValue();
                            if (isLowerCase) {
                                floatValue8 += f5;
                                floatValue9 += f4;
                            }
                            float[] m18885a2 = aVar.m18885a(floatValue8, floatValue9);
                            sb.append(" ").append(m18838b(m18885a2[0])).append(" ").append(m18838b(m18885a2[1]));
                            if (i6 + 2 < i) {
                                floatValue9 = f4;
                                floatValue8 = f5;
                            }
                            i6 += 2;
                            f4 = floatValue9;
                            f5 = floatValue8;
                        }
                        f3 = f4;
                        f2 = f5;
                    }
                    i4 = i5 + i;
                } else {
                    sb.append(" ");
                    return new float[]{f2, f3};
                }
            }
        }
    }

    public String toString() {
        return m18882k();
    }

    /* compiled from: SVGUtils.java */
    /* renamed from: ru.maximoff.apktool.util.ba$a */
    private static class a {

        /* renamed from: a */
        float f18233a = 1.0f;

        /* renamed from: b */
        float f18234b = 0.0f;

        /* renamed from: c */
        float f18235c = 0.0f;

        /* renamed from: d */
        float f18236d = 1.0f;

        /* renamed from: e */
        float f18237e = 0.0f;

        /* renamed from: f */
        float f18238f = 0.0f;

        /* renamed from: a */
        a m18884a(a aVar) {
            a aVar2 = new a();
            aVar2.f18233a = (this.f18233a * aVar.f18233a) + (this.f18235c * aVar.f18234b);
            aVar2.f18234b = (this.f18234b * aVar.f18233a) + (this.f18236d * aVar.f18234b);
            aVar2.f18235c = (this.f18233a * aVar.f18235c) + (this.f18235c * aVar.f18236d);
            aVar2.f18236d = (this.f18234b * aVar.f18235c) + (this.f18236d * aVar.f18236d);
            aVar2.f18237e = (this.f18233a * aVar.f18237e) + (this.f18235c * aVar.f18238f) + this.f18237e;
            aVar2.f18238f = (this.f18234b * aVar.f18237e) + (this.f18236d * aVar.f18238f) + this.f18238f;
            return aVar2;
        }

        /* renamed from: a */
        float[] m18885a(float f2, float f3) {
            return new float[]{(this.f18233a * f2) + (this.f18235c * f3) + this.f18237e, (this.f18234b * f2) + (this.f18236d * f3) + this.f18238f};
        }
    }
}
