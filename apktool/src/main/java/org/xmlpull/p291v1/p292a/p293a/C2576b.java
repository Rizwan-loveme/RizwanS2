package org.xmlpull.p291v1.p292a.p293a;

import org.xmlpull.p291v1.XmlPullParser;
import org.xmlpull.p291v1.XmlSerializer;
import org.xmlpull.p291v1.p292a.C2579b;
import org.xmlpull.p291v1.p292a.InterfaceC2580c;

/* compiled from: StaticXmlSerializerWrapper.java */
/* renamed from: org.xmlpull.v1.a.a.b */
/* loaded from: classes.dex */
public class C2576b extends C2578d implements InterfaceC2580c {

    /* renamed from: c */
    protected C2579b f13404c;

    /* renamed from: d */
    protected int f13405d;

    /* renamed from: e */
    protected String[] f13406e;

    /* renamed from: f */
    protected String[] f13407f;

    /* renamed from: g */
    protected int[] f13408g;

    public C2576b(XmlSerializer xmlSerializer, C2579b c2579b) {
        super(xmlSerializer);
        this.f13405d = 0;
        this.f13406e = new String[8];
        this.f13407f = new String[this.f13406e.length];
        this.f13408g = new int[this.f13406e.length];
        this.f13404c = c2579b;
    }

    /* renamed from: a */
    private void m16040a() {
        int i = this.f13405d > 7 ? this.f13405d * 2 : 8;
        String[] strArr = new String[i];
        String[] strArr2 = new String[i];
        int[] iArr = new int[i];
        if (this.f13406e != null) {
            System.arraycopy(this.f13406e, 0, strArr, 0, this.f13405d);
            System.arraycopy(this.f13407f, 0, strArr2, 0, this.f13405d);
            System.arraycopy(this.f13408g, 0, iArr, 0, this.f13405d);
        }
        this.f13406e = strArr;
        this.f13407f = strArr2;
        this.f13408g = iArr;
    }

    @Override // org.xmlpull.p291v1.p292a.p293a.C2578d, org.xmlpull.p291v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        this.f13410h.setPrefix(str, str2);
        int depth = getDepth();
        for (int i = this.f13405d - 1; i >= 0 && this.f13408g[i] > depth; i--) {
            this.f13405d--;
        }
        if (this.f13405d >= this.f13406e.length) {
            m16040a();
        }
        this.f13406e[this.f13405d] = str;
        this.f13407f[this.f13405d] = str2;
        this.f13405d++;
    }

    /* renamed from: a */
    public void mo3864a(XmlPullParser xmlPullParser) {
        switch (xmlPullParser.getEventType()) {
            case 0:
                startDocument(xmlPullParser.getInputEncoding(), (Boolean) xmlPullParser.getProperty("http://xmlpull.org/v1/doc/features.html#xmldecl-standalone"));
                break;
            case 1:
                endDocument();
                break;
            case 2:
                m16041b(xmlPullParser);
                break;
            case 3:
                endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                break;
            case 4:
                if (xmlPullParser.getDepth() > 0) {
                    text(xmlPullParser.getText());
                    break;
                } else {
                    ignorableWhitespace(xmlPullParser.getText());
                    break;
                }
            case 5:
                cdsect(xmlPullParser.getText());
                break;
            case 6:
                entityRef(xmlPullParser.getName());
                break;
            case 7:
                ignorableWhitespace(xmlPullParser.getText());
                break;
            case 8:
                processingInstruction(xmlPullParser.getText());
                break;
            case 9:
                comment(xmlPullParser.getText());
                break;
            case 10:
                docdecl(xmlPullParser.getText());
                break;
        }
    }

    /* renamed from: b */
    private void m16041b(XmlPullParser xmlPullParser) {
        if (!xmlPullParser.getFeature(XmlPullParser.FEATURE_REPORT_NAMESPACE_ATTRIBUTES)) {
            int namespaceCount = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth());
            for (int namespaceCount2 = xmlPullParser.getNamespaceCount(xmlPullParser.getDepth() - 1); namespaceCount2 < namespaceCount; namespaceCount2++) {
                setPrefix(xmlPullParser.getNamespacePrefix(namespaceCount2), xmlPullParser.getNamespaceUri(namespaceCount2));
            }
        }
        startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
        }
    }
}
