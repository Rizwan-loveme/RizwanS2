package p174e.p175a;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: XmlFormatter.java */
/* renamed from: e.a.a */
/* loaded from: classes.dex */
public class C1527a {

    /* renamed from: c */
    private a f9741c = a.APKTOOLM_LIKE;

    /* renamed from: d */
    private String f9742d = "    ";

    /* renamed from: a */
    private final StringBuilder f9739a = new StringBuilder().append("");

    /* renamed from: b */
    private boolean f9740b = false;

    /* renamed from: a */
    public void m11709a(int i) {
        switch (i) {
            case 1:
                this.f9741c = a.APKTOOL_LIKE;
                break;
            case 2:
                this.f9741c = a.ANDROID_STUDIO_LIKE;
                break;
            case 3:
                this.f9741c = a.SIMPLE_TRICK;
                break;
            default:
                this.f9741c = a.APKTOOLM_LIKE;
                break;
        }
    }

    /* renamed from: b */
    public void m11710b(int i) {
        this.f9742d = "";
        for (int i2 = 0; i2 < i; i2++) {
            this.f9742d = new StringBuffer().append(this.f9742d).append(" ").toString();
        }
    }

    /* renamed from: a */
    private void m11702a(Node node, String str) {
        NodeList childNodes = node.getChildNodes();
        if (node.getNodeType() == 1) {
            String str2 = ">";
            if (childNodes.getLength() <= 0) {
                str2 = "/>";
            }
            String nodeName = node.getNodeName();
            NamedNodeMap attributes = node.getAttributes();
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("<").toString()).append(nodeName).toString()).append(attributes == null ? "" : m11701a(attributes, str)).toString()).append(str2).toString());
            NodeList childNodes2 = node.getChildNodes();
            int length = childNodes2.getLength();
            int i = 0;
            while (i < length) {
                m11702a(childNodes2.item(i), new StringBuffer().append(str).append(this.f9742d).toString());
                i++;
            }
            if (i != 0) {
                if (this.f9740b) {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append("</").append(nodeName).toString()).append(">").toString());
                } else {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("</").toString()).append(nodeName).toString()).append(">").toString());
                }
            }
            this.f9740b = false;
            return;
        }
        if (node.getNodeType() == 8) {
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("<!--").toString()).append(node.getTextContent()).toString()).append("-->").toString());
            return;
        }
        if (node.getNodeType() == 3) {
            String trim = node.getTextContent().trim();
            if (trim.isEmpty()) {
                this.f9740b = false;
            } else {
                this.f9739a.append(trim);
                this.f9740b = true;
            }
        }
    }

    /* renamed from: a */
    private String m11701a(NamedNodeMap namedNodeMap, String str) {
        StringBuilder append = new StringBuilder().append("");
        int length = namedNodeMap.getLength();
        for (int i = 0; i < length; i++) {
            if (length > 1) {
                append.append("\n").append(str).append(this.f9742d);
            }
            if (length == 1) {
                append.append(" ");
            }
            Node item = namedNodeMap.item(i);
            append.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(item.getNodeName()).append("=\"").toString()).append(item.getNodeValue()).toString()).append("\"").toString());
        }
        return append.toString();
    }

    /* renamed from: b */
    private void m11704b(Node node, String str) {
        NodeList childNodes = node.getChildNodes();
        if (node.getNodeType() == 1) {
            String str2 = ">\n";
            if (childNodes.getLength() <= 0) {
                str2 = "/>\n";
            }
            String nodeName = node.getNodeName();
            NamedNodeMap attributes = node.getAttributes();
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append("<").toString()).append(nodeName).toString()).append(attributes == null ? "" : m11703b(attributes, str)).toString()).append(str2).toString());
            NodeList childNodes2 = node.getChildNodes();
            int length = childNodes2.getLength();
            int i = 0;
            while (i < length) {
                m11704b(childNodes2.item(i), "");
                i++;
            }
            if (i != 0) {
                if (this.f9740b) {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append("</").append(nodeName).toString()).append(">\n").toString());
                } else {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append("</").toString()).append(nodeName).toString()).append(">\n").toString());
                }
            }
            this.f9740b = false;
            return;
        }
        if (node.getNodeType() == 8) {
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append("<!--").toString()).append(node.getTextContent()).toString()).append("-->\n").toString());
            return;
        }
        if (node.getNodeType() == 3) {
            String trim = node.getTextContent().trim();
            if (trim.isEmpty()) {
                this.f9740b = false;
                return;
            }
            if (this.f9739a.length() > 0) {
                int length2 = this.f9739a.length() - 1;
                if (this.f9739a.charAt(length2) == '\n') {
                    this.f9739a.deleteCharAt(length2);
                }
            }
            this.f9739a.append(trim);
            this.f9740b = true;
        }
    }

    /* renamed from: b */
    private String m11703b(NamedNodeMap namedNodeMap, String str) {
        StringBuilder append = new StringBuilder().append("");
        int length = namedNodeMap.getLength();
        if (length == 0) {
            return "";
        }
        for (int i = 0; i < length; i++) {
            append.append("\n").append(this.f9742d);
            Node item = namedNodeMap.item(i);
            append.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(item.getNodeName()).append("=\"").toString()).append(item.getNodeValue()).toString()).append("\"").toString());
        }
        return append.append("\n").toString();
    }

    /* renamed from: c */
    private void m11706c(Node node, String str) {
        NodeList childNodes = node.getChildNodes();
        if (node.getNodeType() == 1) {
            String str2 = ">";
            if (childNodes.getLength() <= 0) {
                str2 = "/>";
            }
            String nodeName = node.getNodeName();
            NamedNodeMap attributes = node.getAttributes();
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("<").toString()).append(nodeName).toString()).append(attributes == null ? "" : m11705c(attributes, str)).toString()).append(str2).toString());
            NodeList childNodes2 = node.getChildNodes();
            int length = childNodes2.getLength();
            int i = 0;
            while (i < length) {
                m11706c(childNodes2.item(i), new StringBuffer().append(str).append(this.f9742d).toString());
                i++;
            }
            if (i != 0) {
                if (this.f9740b) {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append("</").append(nodeName).toString()).append(">").toString());
                } else {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("</").toString()).append(nodeName).toString()).append(">").toString());
                }
            }
            this.f9740b = false;
            return;
        }
        if (node.getNodeType() == 8) {
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("<!--").toString()).append(node.getTextContent()).toString()).append("-->").toString());
            return;
        }
        if (node.getNodeType() == 3) {
            String trim = node.getTextContent().trim();
            if (trim.isEmpty()) {
                this.f9740b = false;
            } else {
                this.f9739a.append(trim);
                this.f9740b = true;
            }
        }
    }

    /* renamed from: c */
    private String m11705c(NamedNodeMap namedNodeMap, String str) {
        StringBuilder append = new StringBuilder().append("");
        int length = namedNodeMap.getLength();
        for (int i = 0; i < length; i++) {
            append.append("\n").append(str).append(this.f9742d);
            Node item = namedNodeMap.item(i);
            append.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(item.getNodeName()).append("=\"").toString()).append(item.getNodeValue()).toString()).append("\"").toString());
        }
        return append.toString();
    }

    /* renamed from: d */
    private void m11707d(Node node, String str) {
        NodeList childNodes = node.getChildNodes();
        if (node.getNodeType() == 1) {
            String str2 = ">";
            if (childNodes.getLength() <= 0) {
                str2 = "/>";
            }
            String nodeName = node.getNodeName();
            NamedNodeMap attributes = node.getAttributes();
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("<").toString()).append(nodeName).toString()).append(attributes == null ? "" : m11700a(attributes)).toString()).append(str2).toString());
            NodeList childNodes2 = node.getChildNodes();
            int length = childNodes2.getLength();
            int i = 0;
            while (i < length) {
                m11707d(childNodes2.item(i), new StringBuffer().append(str).append(this.f9742d).toString());
                i++;
            }
            if (i != 0) {
                if (this.f9740b) {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append("</").append(nodeName).toString()).append(">").toString());
                } else {
                    this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("</").toString()).append(nodeName).toString()).append(">").toString());
                }
            }
            this.f9740b = false;
            return;
        }
        if (node.getNodeType() == 8) {
            this.f9739a.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("\n").append(str).toString()).append("<!--").toString()).append(node.getTextContent()).toString()).append("-->").toString());
            return;
        }
        if (node.getNodeType() == 3) {
            String trim = node.getTextContent().trim();
            if (trim.isEmpty()) {
                this.f9740b = false;
            } else {
                this.f9739a.append(trim);
                this.f9740b = true;
            }
        }
    }

    /* renamed from: a */
    private String m11700a(NamedNodeMap namedNodeMap) {
        StringBuilder append = new StringBuilder().append("");
        int length = namedNodeMap.getLength();
        for (int i = 0; i < length; i++) {
            append.append(" ");
            Node item = namedNodeMap.item(i);
            append.append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(item.getNodeName()).append("=\"").toString()).append(item.getNodeValue()).toString()).append("\"").toString());
        }
        return append.toString();
    }

    /* renamed from: a */
    public String m11708a(String str) {
        NodeList childNodes;
        int i = 0;
        if (!m11711b(str)) {
            return (String) null;
        }
        String str2 = (String) null;
        this.f9740b = false;
        this.f9739a.replace(0, this.f9739a.length(), "");
        try {
            str.trim();
            if (str.startsWith("<?")) {
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    this.f9739a.append(charAt);
                    if (charAt == '>') {
                        break;
                    }
                }
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(byteArrayInputStream);
            if (parse == null) {
                this.f9739a.replace(0, this.f9739a.length(), "");
                return (String) null;
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception e2) {
            }
            parse.normalize();
            a aVar = this.f9741c;
            if (aVar == a.APKTOOL_LIKE) {
                NodeList childNodes2 = parse.getChildNodes();
                if (childNodes2 != null) {
                    int length2 = childNodes2.getLength();
                    while (i < length2) {
                        m11707d(childNodes2.item(i), "");
                        i++;
                    }
                }
            } else if (aVar == a.ANDROID_STUDIO_LIKE) {
                NodeList childNodes3 = parse.getChildNodes();
                if (childNodes3 != null) {
                    int length3 = childNodes3.getLength();
                    while (i < length3) {
                        m11706c(childNodes3.item(i), "");
                        i++;
                    }
                }
            } else if (aVar == a.SIMPLE_TRICK) {
                NodeList childNodes4 = parse.getChildNodes();
                if (childNodes4 != null) {
                    int length4 = childNodes4.getLength();
                    while (i < length4) {
                        m11704b(childNodes4.item(i), "");
                        i++;
                    }
                }
            } else if (aVar == a.APKTOOLM_LIKE && (childNodes = parse.getChildNodes()) != null) {
                int length5 = childNodes.getLength();
                while (i < length5) {
                    m11702a(childNodes.item(i), "");
                    i++;
                }
            }
            String trim = this.f9739a.toString().trim();
            this.f9739a.replace(0, this.f9739a.length(), "");
            return trim;
        } catch (Exception e3) {
            try {
                this.f9739a.replace(0, this.f9739a.length(), "");
                return str2;
            } catch (Exception e4) {
                return str2;
            }
        }
    }

    /* renamed from: b */
    public boolean m11711b(String str) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(byteArrayInputStream);
            if (parse == null) {
                return false;
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception e2) {
            }
            parse.normalize();
            return true;
        } catch (Exception e3) {
            return false;
        }
    }

    protected void finalize() {
        try {
            this.f9740b = false;
            this.f9739a.replace(0, this.f9739a.length(), "");
        } catch (Exception e2) {
        }
        super.finalize();
    }

    /* compiled from: XmlFormatter.java */
    /* renamed from: e.a.a$a */
    public enum a {
        APKTOOL_LIKE,
        ANDROID_STUDIO_LIKE,
        SIMPLE_TRICK,
        APKTOOLM_LIKE;

        public static a valueOf(String str) {
            for (a aVar : values()) {
                if (aVar.name().equals(str)) {
                    return aVar;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
