package org.xmlpull.p290a;

import java.p209io.OutputStream;
import java.p209io.OutputStreamWriter;
import java.p209io.Writer;
import java.util.HashSet;
import java.util.Set;
import javax.xml.XMLConstants;
import org.xmlpull.p291v1.XmlSerializer;

/* compiled from: MXSerializer.java */
/* renamed from: org.xmlpull.a.a */
/* loaded from: classes.dex */
public class C2573a implements XmlSerializer {

    /* renamed from: E */
    protected static final String[] f13364E;

    /* renamed from: L */
    private static final int f13365L;

    /* renamed from: e */
    protected static final String f13366e = "http://xmlpull.org/v1/doc/properties.html#location";

    /* renamed from: A */
    protected boolean f13367A;

    /* renamed from: B */
    protected boolean f13368B;

    /* renamed from: C */
    protected boolean f13369C;

    /* renamed from: F */
    protected int f13371F;

    /* renamed from: G */
    protected int f13372G;

    /* renamed from: H */
    protected char[] f13373H;

    /* renamed from: I */
    protected int f13374I;

    /* renamed from: J */
    protected boolean f13375J;

    /* renamed from: K */
    protected boolean f13376K;

    /* renamed from: f */
    protected boolean f13383f;

    /* renamed from: g */
    protected boolean f13384g;

    /* renamed from: j */
    protected String f13387j;

    /* renamed from: k */
    protected Writer f13388k;

    /* renamed from: l */
    protected int f13389l;

    /* renamed from: u */
    protected boolean f13398u;

    /* renamed from: v */
    protected boolean f13399v;

    /* renamed from: w */
    protected boolean f13400w;

    /* renamed from: x */
    protected boolean f13401x;

    /* renamed from: y */
    protected boolean f13402y;

    /* renamed from: z */
    public boolean f13403z;

    /* renamed from: a */
    protected final String f13379a = "http://xmlpull.org/v1/doc/features.html#serializer-attvalue-use-apostrophe";

    /* renamed from: b */
    protected final String f13380b = "http://xmlpull.org/v1/doc/features.html#names-interned";

    /* renamed from: c */
    protected final String f13381c = "http://xmlpull.org/v1/doc/properties.html#serializer-indentation";

    /* renamed from: d */
    protected final String f13382d = "http://xmlpull.org/v1/doc/properties.html#serializer-line-separator";

    /* renamed from: h */
    protected String f13385h = (String) null;

    /* renamed from: i */
    protected String f13386i = "\n";

    /* renamed from: m */
    protected int f13390m = 0;

    /* renamed from: n */
    protected String[] f13391n = new String[2];

    /* renamed from: o */
    protected String[] f13392o = new String[this.f13391n.length];

    /* renamed from: p */
    protected String[] f13393p = new String[this.f13391n.length];

    /* renamed from: q */
    protected int[] f13394q = new int[this.f13391n.length];

    /* renamed from: r */
    protected int f13395r = 0;

    /* renamed from: s */
    protected String[] f13396s = new String[8];

    /* renamed from: t */
    protected String[] f13397t = new String[this.f13396s.length];

    /* renamed from: D */
    protected char[] f13370D = new char[f13365L];

    /* renamed from: M */
    private Set<String> f13377M = new HashSet();

    /* renamed from: N */
    private boolean f13378N = false;

    static {
        f13365L = Runtime.getRuntime().freeMemory() > 1000000 ? 8192 : 256;
        f13364E = new String[32];
        for (int i = 0; i < f13364E.length; i++) {
            f13364E[i] = new StringBuffer().append("n").append(i).toString().intern();
        }
    }

    /* renamed from: c */
    private void m16027c(String str) {
        if (this.f13383f && str != str.intern()) {
            throw new IllegalArgumentException(new StringBuffer().append("all names passed as arguments must be interned").append("when NAMES INTERNED feature is enabled").toString());
        }
    }

    /* renamed from: b */
    protected void m16032b() {
        this.f13387j = (String) null;
        this.f13388k = (Writer) null;
        this.f13389l = 0;
        this.f13390m = 0;
        for (int i = 0; i < this.f13394q.length; i++) {
            this.f13392o[i] = (String) null;
            this.f13393p[i] = (String) null;
            this.f13391n[i] = (String) null;
            this.f13394q[i] = 2;
        }
        this.f13395r = 0;
        this.f13396s[this.f13395r] = XMLConstants.XMLNS_ATTRIBUTE;
        this.f13397t[this.f13395r] = XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
        this.f13395r++;
        this.f13396s[this.f13395r] = XMLConstants.XML_NS_PREFIX;
        this.f13397t[this.f13395r] = "http://www.w3.org/XML/1998/namespace";
        this.f13395r++;
        this.f13398u = false;
        this.f13399v = false;
        this.f13400w = false;
        this.f13401x = false;
        this.f13367A = false;
        this.f13368B = false;
        this.f13369C = false;
    }

    /* renamed from: c */
    protected void m16034c() {
        int length = this.f13392o.length;
        int i = (this.f13390m >= 7 ? this.f13390m * 2 : 8) + 2;
        boolean z = length > 0;
        String[] strArr = new String[i];
        if (z) {
            System.arraycopy(this.f13392o, 0, strArr, 0, length);
        }
        this.f13392o = strArr;
        String[] strArr2 = new String[i];
        if (z) {
            System.arraycopy(this.f13393p, 0, strArr2, 0, length);
        }
        this.f13393p = strArr2;
        String[] strArr3 = new String[i];
        if (z) {
            System.arraycopy(this.f13391n, 0, strArr3, 0, length);
        }
        this.f13391n = strArr3;
        int[] iArr = new int[i];
        if (z) {
            System.arraycopy(this.f13394q, 0, iArr, 0, length);
        } else {
            iArr[0] = 0;
        }
        this.f13394q = iArr;
    }

    /* renamed from: d */
    protected void m16035d() {
        int i = this.f13395r > 7 ? this.f13395r * 2 : 8;
        String[] strArr = new String[i];
        String[] strArr2 = new String[i];
        if (this.f13396s != null) {
            System.arraycopy(this.f13396s, 0, strArr, 0, this.f13395r);
            System.arraycopy(this.f13397t, 0, strArr2, 0, this.f13395r);
        }
        this.f13396s = strArr;
        this.f13397t = strArr2;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("feature name can not be null");
        }
        if (this.f13380b.equals(str)) {
            this.f13383f = z;
        } else {
            if (this.f13379a.equals(str)) {
                this.f13384g = z;
                return;
            }
            throw new IllegalStateException(new StringBuffer().append("unsupported feature ").append(str).toString());
        }
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public boolean getFeature(String str) {
        if (str == null) {
            throw new IllegalArgumentException("feature name can not be null");
        }
        if (this.f13380b.equals(str)) {
            return this.f13383f;
        }
        if (this.f13379a.equals(str)) {
            return this.f13384g;
        }
        return false;
    }

    /* renamed from: e */
    protected void m16036e() {
        int i;
        int i2;
        if (this.f13402y) {
            this.f13371F = 0;
            if (this.f13375J) {
                this.f13371F = this.f13386i.length();
                i = this.f13371F + 0;
            } else {
                i = 0;
            }
            this.f13374I = 0;
            if (this.f13376K) {
                this.f13372G = this.f13385h.length();
                this.f13374I = 65 / this.f13372G;
                i += this.f13374I * this.f13372G;
            }
            if (this.f13373H == null || this.f13373H.length < i) {
                this.f13373H = new char[i + 8];
            }
            if (this.f13375J) {
                int i3 = 0;
                i2 = 0;
                while (i3 < this.f13386i.length()) {
                    this.f13373H[i2] = this.f13386i.charAt(i3);
                    i3++;
                    i2++;
                }
            } else {
                i2 = 0;
            }
            if (this.f13376K) {
                for (int i4 = 0; i4 < this.f13374I; i4++) {
                    int i5 = 0;
                    while (i5 < this.f13385h.length()) {
                        this.f13373H[i2] = this.f13385h.charAt(i5);
                        i5++;
                        i2++;
                    }
                }
            }
        }
    }

    /* renamed from: f */
    protected void m16037f() {
        this.f13388k.write(this.f13373H, this.f13375J ? 0 : this.f13371F, (((this.f13390m > this.f13374I ? this.f13374I : this.f13390m) - 1) * this.f13372G) + this.f13371F);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        boolean z = true;
        if (str == null) {
            throw new IllegalArgumentException("property name can not be null");
        }
        if (this.f13381c.equals(str)) {
            this.f13385h = (String) obj;
        } else if (this.f13382d.equals(str)) {
            this.f13386i = (String) obj;
        } else if (f13366e.equals(str)) {
            this.f13387j = (String) obj;
        } else {
            throw new IllegalStateException(new StringBuffer().append("unsupported property ").append(str).toString());
        }
        this.f13375J = this.f13386i != null && this.f13386i.length() > 0;
        this.f13376K = this.f13385h != null && this.f13385h.length() > 0;
        if (this.f13385h == null || (!this.f13375J && !this.f13376K)) {
            z = false;
        }
        this.f13402y = z;
        m16036e();
        this.f13367A = false;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public Object getProperty(String str) {
        if (str == null) {
            throw new IllegalArgumentException("property name can not be null");
        }
        if (this.f13381c.equals(str)) {
            return this.f13385h;
        }
        if (this.f13382d.equals(str)) {
            return this.f13386i;
        }
        if (f13366e.equals(str)) {
            return this.f13387j;
        }
        return (Object) null;
    }

    /* renamed from: a */
    private String m16023a() {
        return this.f13387j != null ? new StringBuffer().append(" @").append(this.f13387j).toString() : "";
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setOutput(Writer writer) {
        m16032b();
        this.f13388k = writer;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) {
        if (outputStream == null) {
            throw new IllegalArgumentException("output stream can not be null");
        }
        m16032b();
        if (str != null) {
            this.f13388k = new OutputStreamWriter(outputStream, str);
        } else {
            this.f13388k = new OutputStreamWriter(outputStream);
        }
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void startDocument(String str, Boolean bool) {
        if (this.f13384g) {
        }
        if (this.f13384g) {
            this.f13388k.write("<?xml version='1.0'");
        } else {
            this.f13388k.write("<?xml version=\"1.0\"");
        }
        if (str != null) {
            this.f13388k.write(" encoding=");
            this.f13388k.write(this.f13384g ? 39 : 34);
            this.f13388k.write(str);
            this.f13388k.write(this.f13384g ? 39 : 34);
        }
        if (bool != null) {
            this.f13388k.write(" standalone=");
            this.f13388k.write(this.f13384g ? 39 : 34);
            if (bool.booleanValue()) {
                this.f13388k.write("yes");
            } else {
                this.f13388k.write("no");
            }
            this.f13388k.write(this.f13384g ? 39 : 34);
        }
        this.f13388k.write("?>");
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void endDocument() {
        while (this.f13390m > 0) {
            endTag(this.f13391n[this.f13390m], this.f13392o[this.f13390m]);
        }
        this.f13401x = true;
        this.f13399v = true;
        this.f13398u = true;
        this.f13388k.flush();
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        if (this.f13401x) {
            m16038g();
        }
        if (str == null) {
            str = "";
        }
        if (!this.f13383f) {
            str = str.intern();
        } else if (this.f13378N) {
            m16027c(str);
        } else if (str == null) {
            throw new IllegalArgumentException(new StringBuffer().append("prefix must be not null").append(m16023a()).toString());
        }
        for (int i = this.f13394q[this.f13390m]; i < this.f13395r; i++) {
            if (str == this.f13396s[i]) {
                return;
            }
        }
        if (!this.f13383f) {
            str2 = str2.intern();
        } else if (this.f13378N) {
            m16027c(str2);
        } else if (str2 == null) {
            throw new IllegalArgumentException(new StringBuffer().append("namespace must be not null").append(m16023a()).toString());
        }
        if (this.f13395r >= this.f13396s.length) {
            m16035d();
        }
        this.f13396s[this.f13395r] = str;
        this.f13397t[this.f13395r] = str2;
        this.f13395r++;
        this.f13400w = true;
    }

    /* renamed from: a */
    protected String m16029a(String str) {
        return getPrefix(str, true);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        return m16030a(str, z, false);
    }

    /* renamed from: a */
    protected String m16030a(String str, boolean z, boolean z2) {
        if (!this.f13383f) {
            str = str.intern();
        } else if (this.f13378N) {
            m16027c(str);
        }
        if (str == null) {
            throw new IllegalArgumentException(new StringBuffer().append("namespace must be not null").append(m16023a()).toString());
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException(new StringBuffer().append("default namespace cannot have prefix").append(m16023a()).toString());
        }
        for (int i = this.f13395r - 1; i >= 0; i--) {
            if (str == this.f13397t[i]) {
                String str2 = this.f13396s[i];
                if (!z2 || str2.length() != 0) {
                    for (int i2 = this.f13395r - 1; i2 > i; i2--) {
                        if (str2 == this.f13396s[i2]) {
                        }
                    }
                    return str2;
                }
            }
        }
        if (!z) {
            return (String) null;
        }
        return m16028d(str);
    }

    /* renamed from: d */
    private String m16028d(String str) {
        this.f13389l++;
        String intern = this.f13389l < f13364E.length ? f13364E[this.f13389l] : new StringBuffer().append("n").append(this.f13389l).toString().intern();
        for (int i = this.f13395r - 1; i >= 0; i--) {
            if (intern == this.f13396s[i]) {
            }
        }
        if (this.f13395r >= this.f13396s.length) {
            m16035d();
        }
        this.f13396s[this.f13395r] = intern;
        this.f13397t[this.f13395r] = str;
        this.f13395r++;
        return intern;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public int getDepth() {
        return this.f13390m;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public String getNamespace() {
        return this.f13391n[this.f13390m];
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public String getName() {
        return this.f13392o[this.f13390m];
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) {
        String str3;
        String str4;
        this.f13377M.clear();
        if (this.f13401x) {
            m16038g();
        }
        this.f13369C = false;
        this.f13368B = false;
        this.f13390m++;
        if (this.f13402y && this.f13390m > 0 && this.f13367A) {
            m16037f();
        }
        this.f13367A = true;
        this.f13400w = false;
        this.f13401x = true;
        if (this.f13390m + 1 >= this.f13392o.length) {
            m16034c();
        }
        if (this.f13378N && this.f13383f) {
            m16027c(str);
        }
        this.f13391n[this.f13390m] = (this.f13383f || str == null) ? str : str.intern();
        if (this.f13378N && this.f13383f) {
            m16027c(str2);
        }
        this.f13392o[this.f13390m] = (this.f13383f || str2 == null) ? str2 : str2.intern();
        if (this.f13388k == null) {
            throw new IllegalStateException("setOutput() must called set before serialization can start");
        }
        this.f13388k.write(60);
        if (str != null) {
            if (str.length() > 0) {
                String str5 = (String) null;
                if (this.f13390m > 0 && this.f13395r - this.f13394q[this.f13390m - 1] == 1 && ((str3 = this.f13397t[this.f13395r - 1]) == str || str3.equals(str))) {
                    Object obj = this.f13396s[this.f13395r - 1];
                    int i = this.f13394q[this.f13390m - 1];
                    do {
                        i--;
                        if (i < 2) {
                            break;
                        }
                        str4 = this.f13396s[i];
                        if (str4 == obj) {
                            break;
                        }
                    } while (!str4.equals(obj));
                    String str6 = this.f13397t[i];
                    if (str6 == str3 || str6.equals(str3)) {
                        this.f13395r--;
                        str5 = obj;
                    }
                }
                if (str5 == null) {
                    str5 = m16029a(str);
                }
                if (str5.length() > 0) {
                    this.f13393p[this.f13390m] = str5;
                    this.f13388k.write(str5);
                    this.f13388k.write(58);
                } else {
                    this.f13393p[this.f13390m] = "";
                }
            } else {
                int i2 = this.f13395r - 1;
                while (true) {
                    if (i2 < 0) {
                        break;
                    }
                    if (this.f13396s[i2] != "") {
                        i2--;
                    } else {
                        String str7 = this.f13397t[i2];
                        if (str7 == null) {
                            setPrefix("", "");
                        } else if (str7.length() > 0) {
                            throw new IllegalStateException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("start tag can not be written in empty default namespace ").append("as default namespace is currently bound to '").toString()).append(str7).toString()).append("'").toString()).append(m16023a()).toString());
                        }
                    }
                }
                this.f13393p[this.f13390m] = "";
            }
        } else {
            this.f13393p[this.f13390m] = "";
        }
        this.f13388k.write(str2);
        return this;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) {
        if (!this.f13401x) {
            throw new IllegalArgumentException(new StringBuffer().append("startTag() must be called before attribute()").append(m16023a()).toString());
        }
        String stringBuffer = (str == null || str.length() <= 0) ? str2 : new StringBuffer().append(new StringBuffer().append(str).append(":").toString()).append(str2).toString();
        if (!this.f13377M.contains(stringBuffer)) {
            this.f13377M.add(stringBuffer);
            if (this.f13403z && this.f13402y) {
                m16037f();
                this.f13388k.write(this.f13385h);
            } else {
                this.f13388k.write(32);
            }
            if (str != null && str.length() > 0) {
                if (!this.f13383f) {
                    str = str.intern();
                } else if (this.f13378N) {
                    m16027c(str);
                }
                String m16030a = m16030a(str, false, true);
                if (m16030a == null) {
                    m16030a = m16028d(str);
                }
                this.f13388k.write(m16030a);
                this.f13388k.write(58);
            }
            this.f13388k.write(str2);
            this.f13388k.write(61);
            this.f13388k.write(this.f13384g ? 39 : 34);
            mo3866a(str3, this.f13388k);
            this.f13388k.write(this.f13384g ? 39 : 34);
        }
        return this;
    }

    /* renamed from: g */
    protected void m16038g() {
        if (this.f13398u) {
            throw new IllegalArgumentException(new StringBuffer().append("trying to write past already finished output").append(m16023a()).toString());
        }
        if (this.f13368B) {
            this.f13369C = false;
            this.f13368B = false;
        }
        if (this.f13401x || this.f13400w) {
            if (this.f13400w) {
                throw new IllegalArgumentException(new StringBuffer().append("startTag() must be called immediately after setPrefix()").append(m16023a()).toString());
            }
            if (!this.f13401x) {
                throw new IllegalArgumentException(new StringBuffer().append("trying to close start tag that is not opened").append(m16023a()).toString());
            }
            m16039h();
            this.f13388k.write(62);
            this.f13394q[this.f13390m] = this.f13395r;
            this.f13401x = false;
        }
    }

    /* renamed from: h */
    protected void m16039h() {
        HashSet hashSet = new HashSet();
        for (int i = this.f13394q[this.f13390m - 1]; i < this.f13395r; i++) {
            String str = this.f13396s[i];
            String str2 = this.f13397t[i];
            if (!hashSet.contains(new StringBuffer().append(str).append(str2).toString())) {
                if (this.f13402y) {
                    m16037f();
                    this.f13388k.write(this.f13385h);
                }
                if (str != "") {
                    this.f13388k.write("xmlns:");
                    this.f13388k.write(str);
                    this.f13388k.write(61);
                } else {
                    this.f13388k.write("xmlns=");
                }
                this.f13388k.write(this.f13384g ? 39 : 34);
                mo3866a(str2, this.f13388k);
                this.f13388k.write(this.f13384g ? 39 : 34);
                hashSet.add(new StringBuffer().append(str).append(str2).toString());
            }
        }
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) {
        this.f13369C = false;
        this.f13368B = false;
        if (str != null) {
            if (!this.f13383f) {
                str = str.intern();
            } else if (this.f13378N) {
                m16027c(str);
            }
        }
        if (str != null && str != this.f13391n[this.f13390m]) {
            throw new IllegalArgumentException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("expected namespace ").append(m16026b(this.f13391n[this.f13390m])).toString()).append(" and not ").toString()).append(m16026b(str)).toString()).append(m16023a()).toString());
        }
        if (str2 == null) {
            throw new IllegalArgumentException(new StringBuffer().append("end tag name can not be null").append(m16023a()).toString());
        }
        if (this.f13378N && this.f13383f) {
            m16027c(str2);
        }
        if (this.f13401x) {
            m16039h();
            this.f13388k.write(" />");
            this.f13390m--;
        } else {
            if (this.f13402y && this.f13367A) {
                m16037f();
            }
            this.f13388k.write("</");
            String str3 = this.f13393p[this.f13390m];
            if (str3.length() > 0) {
                this.f13388k.write(str3);
                this.f13388k.write(58);
            }
            this.f13388k.write(str2);
            this.f13388k.write(62);
            this.f13390m--;
        }
        this.f13395r = this.f13394q[this.f13390m];
        this.f13401x = false;
        this.f13367A = true;
        return this;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer text(String str) {
        if (this.f13401x || this.f13400w) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        m16033b(str, this.f13388k);
        return this;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) {
        if (this.f13401x || this.f13400w) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        m16031a(cArr, i, i2, this.f13388k);
        return this;
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void cdsect(String str) {
        if (this.f13401x || this.f13400w || this.f13368B) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        this.f13388k.write("<![CDATA[");
        this.f13388k.write(str);
        this.f13388k.write("]]>");
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void entityRef(String str) {
        if (this.f13401x || this.f13400w || this.f13368B) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        this.f13388k.write(38);
        this.f13388k.write(str);
        this.f13388k.write(59);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void processingInstruction(String str) {
        if (this.f13401x || this.f13400w || this.f13368B) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        this.f13388k.write("<?");
        this.f13388k.write(str);
        this.f13388k.write("?>");
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void comment(String str) {
        if (this.f13401x || this.f13400w || this.f13368B) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        this.f13388k.write("<!--");
        this.f13388k.write(str);
        this.f13388k.write("-->");
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void docdecl(String str) {
        if (this.f13401x || this.f13400w || this.f13368B) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        this.f13388k.write("<!DOCTYPE");
        this.f13388k.write(str);
        this.f13388k.write(">");
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void ignorableWhitespace(String str) {
        if (this.f13401x || this.f13400w || this.f13368B) {
            m16038g();
        }
        if (this.f13402y && this.f13367A) {
            this.f13367A = false;
        }
        if (str.length() == 0) {
        }
        this.f13388k.write(str);
    }

    @Override // org.xmlpull.p291v1.XmlSerializer
    public void flush() {
        if (!this.f13398u && this.f13401x) {
            m16038g();
        }
        this.f13388k.flush();
    }

    /* renamed from: a */
    protected void mo3866a(String str, Writer writer) {
        int i = 0;
        char c2 = this.f13384g ? '\'' : '\"';
        String str2 = this.f13384g ? "&apos;" : "&quot;";
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < str.length()) {
                char charAt = str.charAt(i2);
                if (charAt == '&') {
                    if (i2 > i3) {
                        writer.write(str.substring(i3, i2));
                    }
                    writer.write("&amp;");
                    i = i2 + 1;
                } else {
                    i = i3;
                }
                if (charAt == '<') {
                    if (i2 > i) {
                        writer.write(str.substring(i, i2));
                    }
                    writer.write("&lt;");
                    i = i2 + 1;
                } else if (charAt == c2) {
                    if (i2 > i) {
                        writer.write(str.substring(i, i2));
                    }
                    writer.write(str2);
                    i = i2 + 1;
                } else if (charAt >= ' ') {
                    continue;
                } else if (charAt == '\r' || charAt == '\n' || charAt == '\t') {
                    if (i2 > i) {
                        writer.write(str.substring(i, i2));
                    }
                    writer.write("&#");
                    writer.write(Integer.toString(charAt));
                    writer.write(59);
                    i = i2 + 1;
                } else {
                    throw new IllegalStateException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("character ").append(m16024a(charAt)).toString()).append(" (").toString()).append(Integer.toString(charAt)).toString()).append(") is not allowed in output").toString()).append(m16023a()).toString()).append(" (attr value=").toString()).append(m16026b(str)).toString()).append(")").toString());
                }
                i2++;
            } else if (i3 > 0) {
                writer.write(str.substring(i3));
                return;
            } else {
                writer.write(str);
                return;
            }
        }
    }

    /* renamed from: b */
    protected void m16033b(String str, Writer writer) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == ']') {
                if (this.f13368B) {
                    this.f13369C = true;
                } else {
                    this.f13368B = true;
                }
            } else {
                if (charAt == '&') {
                    if (i2 >= str.length() - 3 || str.charAt(i2 + 1) != 'l' || str.charAt(i2 + 2) != 't' || str.charAt(i2 + 3) != ';') {
                        if (i2 > i) {
                            writer.write(str.substring(i, i2));
                        }
                        writer.write("&amp;");
                        i = i2 + 1;
                    }
                } else if (charAt == '<') {
                    if (i2 > i) {
                        writer.write(str.substring(i, i2));
                    }
                    writer.write("&lt;");
                    i = i2 + 1;
                } else if (this.f13369C && charAt == '>') {
                    if (i2 > i) {
                        writer.write(str.substring(i, i2));
                    }
                    writer.write("&gt;");
                    i = i2 + 1;
                } else if (charAt < ' ' && charAt != '\t' && charAt != '\n' && charAt != '\r') {
                    throw new IllegalStateException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("character ").append(Integer.toString(charAt)).toString()).append(" is not allowed in output").toString()).append(m16023a()).toString()).append(" (text value=").toString()).append(m16026b(str)).toString()).append(")").toString());
                }
                if (this.f13368B) {
                    this.f13368B = false;
                    this.f13369C = false;
                }
            }
        }
        if (i > 0) {
            writer.write(str.substring(i));
        } else {
            writer.write(str);
        }
    }

    /* renamed from: a */
    protected void m16031a(char[] cArr, int i, int i2, Writer writer) {
        int i3 = i + i2;
        int i4 = i;
        for (int i5 = i; i5 < i3; i5++) {
            char c2 = cArr[i5];
            if (c2 == ']') {
                if (this.f13368B) {
                    this.f13369C = true;
                } else {
                    this.f13368B = true;
                }
            } else {
                if (c2 == '&') {
                    if (i5 > i4) {
                        writer.write(cArr, i4, i5 - i4);
                    }
                    writer.write("&amp;");
                    i4 = i5 + 1;
                } else if (c2 == '<') {
                    if (i5 > i4) {
                        writer.write(cArr, i4, i5 - i4);
                    }
                    writer.write("&lt;");
                    i4 = i5 + 1;
                } else if (this.f13369C && c2 == '>') {
                    if (i5 > i4) {
                        writer.write(cArr, i4, i5 - i4);
                    }
                    writer.write("&gt;");
                    i4 = i5 + 1;
                } else if (c2 < ' ' && c2 != '\t' && c2 != '\n' && c2 != '\r') {
                    throw new IllegalStateException(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("character ").append(m16024a(c2)).toString()).append(" (").toString()).append(Integer.toString(c2)).toString()).append(") is not allowed in output").toString()).append(m16023a()).toString());
                }
                if (this.f13368B) {
                    this.f13368B = false;
                    this.f13369C = false;
                }
            }
        }
        if (i3 > i4) {
            writer.write(cArr, i4, i3 - i4);
        }
    }

    /* renamed from: b */
    protected static final String m16026b(String str) {
        if (str == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 16);
        stringBuffer.append("'");
        for (int i = 0; i < str.length(); i++) {
            m16025a(stringBuffer, str.charAt(i));
        }
        stringBuffer.append("'");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected static final String m16024a(char c2) {
        StringBuffer stringBuffer = new StringBuffer();
        m16025a(stringBuffer, c2);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m16025a(StringBuffer stringBuffer, char c2) {
        switch (c2) {
            case '\b':
                stringBuffer.append("\\b");
                break;
            case '\t':
                stringBuffer.append("\\t");
                break;
            case '\n':
                stringBuffer.append("\\n");
                break;
            case '\f':
                stringBuffer.append("\\f");
                break;
            case '\r':
                stringBuffer.append("\\r");
                break;
            case '\"':
                stringBuffer.append("\\\"");
                break;
            case '\'':
                stringBuffer.append("\\'");
                break;
            case '\\':
                stringBuffer.append("\\\\");
                break;
            default:
                if (c2 < ' ' || c2 > '~') {
                    String stringBuffer2 = new StringBuffer().append("0000").append(Integer.toString(c2, 16)).toString();
                    stringBuffer.append(new StringBuffer().append("\\u").append(stringBuffer2.substring(stringBuffer2.length() - 4, stringBuffer2.length())).toString());
                    break;
                } else {
                    stringBuffer.append(c2);
                    break;
                }
                break;
        }
    }
}
